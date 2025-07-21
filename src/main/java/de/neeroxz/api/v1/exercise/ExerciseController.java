package de.neeroxz.api.v1.exercise;

import de.neeroxz.api.v1.exercise.dto.ExerciseAddRequest;
import de.neeroxz.api.v1.exercise.dto.ExerciseDTO;
import de.neeroxz.service.exercise.ExerciseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by NeeroxZ
 *
 * @author : NeeroxZ
 * @date : 21.07.2025
 */
@RestController
@RequestMapping("/api/v1/exercises")
@RequiredArgsConstructor
public class ExerciseController {

    private final ExerciseService service;

    /* Neues Exercise anlegen */
    @PostMapping
    public ResponseEntity<ExerciseDTO> add(@Valid @RequestBody ExerciseAddRequest request) {
        ExerciseDTO saved = service.add(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    /* Alle Übungen */
    @GetMapping
    public List<ExerciseDTO> getAll() {
        return service.getAll();
    }

    /* Einzelne Übung */
    @GetMapping("/{id}")
    public ResponseEntity<ExerciseDTO> get(@PathVariable Long id) {
        return service.get(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /* Löschen */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (service.remove(id)) return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }
}
