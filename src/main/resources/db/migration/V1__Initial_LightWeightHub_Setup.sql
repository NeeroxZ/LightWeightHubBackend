-- =========================
-- User
-- =========================
CREATE TABLE IF NOT EXISTS "user" (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) UNIQUE,
    birthday DATE DEFAULT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    account_non_locked BOOLEAN NOT NULL DEFAULT TRUE,
    account_non_expired BOOLEAN NOT NULL DEFAULT TRUE,
    credentials_non_expired BOOLEAN NOT NULL DEFAULT TRUE,
    enabled BOOLEAN NOT NULL DEFAULT TRUE
    );

-- =========================
-- Muscle Group
-- =========================
CREATE TABLE IF NOT EXISTS "muscle_group" (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) UNIQUE NOT NULL
    );

-- =========================
-- Exercise Category
-- =========================
CREATE TABLE IF NOT EXISTS "exercise_category" (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) UNIQUE NOT NULL
    );

-- =========================
-- Exercise
-- =========================
CREATE TABLE IF NOT EXISTS "exercise" (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) UNIQUE NOT NULL,
    description TEXT,
    category_id INTEGER REFERENCES exercise_category(id) ON DELETE SET NULL,
    muscle_group_id INTEGER REFERENCES muscle_group(id) ON DELETE SET NULL
    );

-- =========================
-- Workout
-- =========================
CREATE TABLE IF NOT EXISTS "workout" (
    id SERIAL PRIMARY KEY,
    user_id INTEGER REFERENCES "user"(id) ON DELETE CASCADE,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );

-- =========================
-- Workout Exercise (Join-Tabelle)
-- =========================
CREATE TABLE IF NOT EXISTS "workout_exercise" (
    id SERIAL PRIMARY KEY,
    workout_id INTEGER NOT NULL REFERENCES workout(id) ON DELETE CASCADE,
    exercise_id INTEGER NOT NULL REFERENCES exercise(id) ON DELETE CASCADE,
    position INTEGER NOT NULL,
    sets INTEGER DEFAULT 3,
    reps INTEGER DEFAULT 10
    );

-- =========================
-- Shared Workout
-- =========================
CREATE TABLE IF NOT EXISTS "shared_workout" (
    id SERIAL PRIMARY KEY,
    workout_id INTEGER REFERENCES workout(id) ON DELETE CASCADE,
    shared_by_user_id INTEGER REFERENCES "user"(id) ON DELETE CASCADE,
    shared_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );

-- =========================
-- Workout Invite
-- =========================
CREATE TABLE IF NOT EXISTS "workout_invite" (
   id SERIAL PRIMARY KEY,
   workout_id INTEGER NOT NULL REFERENCES workout(id) ON DELETE CASCADE,
    invited_user_id INTEGER NOT NULL REFERENCES "user"(id) ON DELETE CASCADE,
    status VARCHAR(20) NOT NULL DEFAULT 'pending' CHECK (status IN ('pending', 'accepted', 'declined')),
    invited_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UNIQUE (workout_id, invited_user_id)
    );
