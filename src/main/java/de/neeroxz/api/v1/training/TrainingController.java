package de.neeroxz.api.v1.training;

import de.neeroxz.service.training.TrainingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/training")
@RequiredArgsConstructor
public class TrainingController {
    private final TrainingService trainingService;

    /*
    Start Training
     */
    @GetMapping
    public void startTraining(@PathVariable Long userId, @PathVariable Long workoutId) {

    }

    /*
    Save full Training
     */
}
