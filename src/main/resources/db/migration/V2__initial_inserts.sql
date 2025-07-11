-- =========================
-- Muskelgruppen (nur wenn nicht vorhanden)
-- =========================
INSERT INTO muscle_group (name)
VALUES ('Brust'),
       ('Rücken'),
       ('Beine'),
       ('Schultern'),
       ('Bizeps'),
       ('Trizeps'),
       ('Bauch'),
       ('Waden'),
       ('Ganzkörper') ON CONFLICT (name) DO NOTHING;

-- =========================
-- Übungskategorien (nur wenn nicht vorhanden)
-- =========================
INSERT INTO exercise_category (name)
VALUES ('Kraft'),
       ('Calisthenics'),
       ('Ausdauer'),
       ('Beweglichkeit'),
       ('Koordination'),
       ('Mobilität'),
       ('Rehabilitation') ON CONFLICT (name) DO NOTHING;

-- =========================
-- Beispielübungen inkl. Calisthenics
-- =========================
INSERT INTO exercise (name, description, category_id, muscle_group_id)
VALUES
    -- Klassische Kraftübungen
    ('Bankdrücken', 'Klassische Brustübung mit Langhantel oder Kurzhanteln.',
     (SELECT id FROM exercise_category WHERE name = 'Kraft'),
     (SELECT id FROM muscle_group WHERE name = 'Brust')),
    ('Kreuzheben', 'Ganzkörperübung mit Fokus auf Rücken und Beine.',
     (SELECT id FROM exercise_category WHERE name = 'Kraft'),
     (SELECT id FROM muscle_group WHERE name = 'Rücken')),
    ('Kniebeugen', 'Grundübung für die Beinmuskulatur.',
     (SELECT id FROM exercise_category WHERE name = 'Kraft'),
     (SELECT id FROM muscle_group WHERE name = 'Beine')),
    ('Schulterdrücken', 'Langhantel oder Kurzhantel Schulterdrücken.',
     (SELECT id FROM exercise_category WHERE name = 'Kraft'),
     (SELECT id FROM muscle_group WHERE name = 'Schultern')),
    ('Bizepscurls', 'Bizepsübung mit Kurzhantel oder Langhantel.',
     (SELECT id FROM exercise_category WHERE name = 'Kraft'),
     (SELECT id FROM muscle_group WHERE name = 'Bizeps')),
    ('Trizepsdrücken', 'Trizeps-Isolationsübung mit Seilzug.',
     (SELECT id FROM exercise_category WHERE name = 'Kraft'),
     (SELECT id FROM muscle_group WHERE name = 'Trizeps')),

    -- Calisthenics
    ('Liegestütze', 'Klassische Eigengewichtsübung für Brust, Schultern und Trizeps.',
     (SELECT id FROM exercise_category WHERE name = 'Calisthenics'),
     (SELECT id FROM muscle_group WHERE name = 'Brust')),

    ('Klimmzüge', 'Eigengewichtsrückenübung an der Stange.',
     (SELECT id FROM exercise_category WHERE name = 'Calisthenics'),
     (SELECT id FROM muscle_group WHERE name = 'Rücken')),

    ('Dips', 'Übung für Brust, Schultern und Trizeps.',
     (SELECT id FROM exercise_category WHERE name = 'Calisthenics'),
     (SELECT id FROM muscle_group WHERE name = 'Trizeps')),

    ('Muscle-Up', 'Fortgeschrittene Übung für Rücken, Arme und Schultern.',
     (SELECT id FROM exercise_category WHERE name = 'Calisthenics'),
     (SELECT id FROM muscle_group WHERE name = 'Ganzkörper')),

    ('Handstand Push-Up', 'Schulter- und Trizeps-Übung im Handstand.',
     (SELECT id FROM exercise_category WHERE name = 'Calisthenics'),
     (SELECT id FROM muscle_group WHERE name = 'Schultern')),

    ('L-Sit', 'Statische Bauchübung für Rumpf und Hüfte.',
     (SELECT id FROM exercise_category WHERE name = 'Calisthenics'),
     (SELECT id FROM muscle_group WHERE name = 'Bauch')),

    ('Dragon Flag', 'Fortgeschrittene Core-Übung nach Bruce Lee.',
     (SELECT id FROM exercise_category WHERE name = 'Calisthenics'),
     (SELECT id FROM muscle_group WHERE name = 'Bauch')),

    ('Plank', 'Isometrische Übung zur Rumpfstabilisierung.',
     (SELECT id FROM exercise_category WHERE name = 'Koordination'),
     (SELECT id FROM muscle_group WHERE name = 'Bauch')),

    ('Burpees', 'Ganzkörperübung zur Kondition und Explosivität.',
     (SELECT id FROM exercise_category WHERE name = 'Calisthenics'),
     (SELECT id FROM muscle_group WHERE name = 'Ganzkörper')),

    ('Hanging Leg Raises', 'Bauchübung im Hang an der Stange.',
     (SELECT id FROM exercise_category WHERE name = 'Calisthenics'),
     (SELECT id FROM muscle_group WHERE name = 'Bauch')),

    ('Jump Squats', 'Plyometrische Beinübung mit Sprung.',
     (SELECT id FROM exercise_category WHERE name = 'Calisthenics'),
     (SELECT id FROM muscle_group WHERE name = 'Beine')) ON CONFLICT (name) DO NOTHING;
