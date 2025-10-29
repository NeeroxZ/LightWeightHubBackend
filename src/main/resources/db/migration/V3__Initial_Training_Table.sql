CREATE TABLE IF NOT EXISTS "training_session"(
    id SERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL REFERENCES "user"(id) on DELETE CASCADE,
    workout_id INTEGER NOT NULL REFERENCES "Workout"(id) on DELTE CASCADE,
    startet_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    ended_at
    )
CREATE TABLE IF NOT EXISTS "training_exercise"(
	id SERIAL PRIMARY KEY,
	training_session_id INTEGER NOT NULL REFERENCES "training_session"(id) ON DELTE CASCADE,
	exercise_id INTEGER NOT NULL REFERENCES "exercise"(id) on DELTE CASCADE,
	Position INTEGER NOT NULL
)
CREATE TABLE IF NOT EXISTS "training_set"(
	id SERIAL PRIMARY KEY,
	training_exercise_id INTEGER NOT NULL REFERENCES "training_exercise"(id) ON DELTE CASCADE,
    set_number INTEGER NOT NULL,
    reps INTEGER NOT NULL,
    weight DECIMAL(2,5) NOT NULL
    is_body_weight BOLEAN DEFAULT FALSE,
    perfomed_at TIMESTAMP NOT NULL

    )