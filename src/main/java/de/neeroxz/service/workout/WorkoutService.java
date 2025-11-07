package de.neeroxz.service.workout;


import de.neeroxz.domain.workout.Workout;
import de.neeroxz.domain.workout.WorkoutExercise;
import de.neeroxz.domain.workout.WorkoutSet;
import de.neeroxz.domain.workout.dto.WorkoutDTO;

import de.neeroxz.domain.workout.dto.request.CreateTrainingSetRequest;
import de.neeroxz.domain.workout.dto.request.CreateWorkoutExerciseRequest;
import de.neeroxz.domain.workout.dto.request.CreateWorkoutRequest;
import de.neeroxz.mapper.workout.WorkoutMapper;
import de.neeroxz.repository.exercise.IExerciseRepository;
import de.neeroxz.repository.user.UserRepository;
import de.neeroxz.repository.workout.WorkoutRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NeeroxZ
 *
 * @author : NeeroxZ
 * @date : 21.07.2025
 */
@Service
@RequiredArgsConstructor
@Transactional
@Log
public class WorkoutService {
    private final WorkoutRepository workoutRepository;
    private final WorkoutMapper workoutMapper;
    private final IExerciseRepository  exerciseRepository;
    private final UserRepository userRepository;

    public List<WorkoutDTO> getAll() {
        return workoutRepository
                .findAll()
                .stream().map(workoutMapper::toDto)
                .toList();
    }
    /**

    //TODO .orElse fehlt
    public Optional<WorkoutDTO> getWorkoutById(int id) {
        return workoutRepository
                .findById(id)
                .map(workoutMapper::workoutToWorkoutDTO);
    }

    public void  deleteWorkoutById(int id) {
        workoutRepository.deleteById(id);
    }
    */

    public WorkoutDTO createWorkout(CreateWorkoutRequest request) {
        //Neues Workout erstellen
        Workout workout = new Workout();
        workout.setName(request.name());
        workout.setDescription(request.description());
        workout.setUser(
                userRepository.findById(request.userID())
                        .orElseThrow(() -> new IllegalArgumentException("User not found: " + request.userID()))
        );

        //Exercises anlegen
        for (CreateWorkoutExerciseRequest exerciseRequest : request.exercises()) {
            WorkoutExercise we = new WorkoutExercise();
            we.setWorkout(workout);
            we.setExercise(
                    exerciseRepository.findById(exerciseRequest.exerciseId())
                            .orElseThrow(() -> new IllegalArgumentException("Exercise not found: " + exerciseRequest.exerciseId()))
            );
            System.out.println(exerciseRequest.position());
            we.setPosition(exerciseRequest.position());

            //Sets hinzufügen
            List<WorkoutSet> sets = new ArrayList<>();
            for (CreateTrainingSetRequest setRequest : exerciseRequest.sets()) {
                WorkoutSet set = new WorkoutSet();
                set.setWorkoutExercise(we);
                set.setSetNumber(setRequest.setNumber());
                set.setReps(setRequest.reps());
                set.setWeight(setRequest.weight());
                set.setIsBodyWeight(setRequest.isBodyWeight());
                sets.add(set);
            }

            we.setSets(sets);
            workout.getExercises().add(we);
        }

        // Workout speichern
        Workout savedWorkout = workoutRepository.save(workout);

        //DTO zurückgeben
        return workoutMapper.toDto(savedWorkout);
    }

}
