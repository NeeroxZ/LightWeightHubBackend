package de.neeroxz.api.v1.workout;

import de.neeroxz.domain.workout.Workout;
import de.neeroxz.domain.workout.dto.WorkoutDTO;
import de.neeroxz.domain.workout.dto.request.CreateWorkoutRequest;
import de.neeroxz.service.workout.WorkoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by NeeroxZ
 *
 * @author : NeeroxZ
 * @date : 21.07.2025
 */
@RestController
@RequestMapping("/api/v1/workouts")
@RequiredArgsConstructor
public class WorkoutController {
   private final WorkoutService workoutService;

    /*
    Get Workouts
     */
    @GetMapping
    public List<WorkoutDTO> getAllWorkouts() {
       return  workoutService.getAll();
    }

    /*
    Save Workout
     */
    @PostMapping
    public WorkoutDTO createWorkout(@RequestBody CreateWorkoutRequest workout) {
        return workoutService.createWorkout(workout);
    }

    /*
    Update Workout
     */

    /*
    Delete Workout
     */

}
