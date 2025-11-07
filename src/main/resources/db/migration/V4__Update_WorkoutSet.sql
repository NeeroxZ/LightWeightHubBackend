CREATE TABLE workout_set (
                             id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                             set_number INT NOT NULL,
                             reps INT NOT NULL,
                             weight DECIMAL(10, 2),
                             is_body_weight BOOLEAN NOT NULL DEFAULT FALSE,
                             workout_exercise_id BIGINT NOT NULL,
                             CONSTRAINT fk_workout_set_exercise
                                 FOREIGN KEY (workout_exercise_id)
                                     REFERENCES workout_exercise(id)
                                     ON DELETE CASCADE
);
