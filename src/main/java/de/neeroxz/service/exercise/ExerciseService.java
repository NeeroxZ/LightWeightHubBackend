package de.neeroxz.service.exercise;

import de.neeroxz.api.v1.exercise.dto.ExerciseAddRequest;
import de.neeroxz.api.v1.exercise.dto.ExerciseDTO;
import de.neeroxz.domain.exercise.Exercise;
import de.neeroxz.mapper.exercise.ExerciseMapper;
import de.neeroxz.repository.ExerciseCategoryRepo;
import de.neeroxz.repository.IExerciseRepository;
import de.neeroxz.repository.MuscleGroupRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by NeeroxZ
 *
 * @author : NeeroxZ
 * @date : 21.07.2025
 */
@Service
@RequiredArgsConstructor
@Transactional
public class ExerciseService {

    private final IExerciseRepository repo;
    private final ExerciseCategoryRepo categoryRepo;
    private final MuscleGroupRepo muscleRepo;
    private final ExerciseMapper mapper;

    public ExerciseDTO add(ExerciseAddRequest req) {

        Exercise entity = mapper.toEntity(req);
        entity.setExerciseCategory(categoryRepo.getReferenceById(req.categoryId()));
        entity.setMuscleGroup(muscleRepo.getReferenceById(req.muscleGroupId()));

        return mapper.toDto(repo.save(entity));
    }

    public Optional<ExerciseDTO> get(Long id) {
        return repo.findById(id).map(mapper::toDto);
    }

    public List<ExerciseDTO> getAll() {
        return repo.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }

    public boolean remove(Long id) {
        if (!repo.existsById(id)) return false;
        repo.deleteById(id);
        return true;
    }
}