# 🏋️‍♂️ User Stories – Workout & Training App

Dieses Dokument beschreibt die wichtigsten **User Stories** basierend auf der aktuellen Datenbankstruktur.  
Ziel ist es, die Anforderungen und Nutzungsszenarien der Anwendung aus Sicht der Benutzer zu formulieren.

---

## 👤 Benutzerverwaltung (`user`)

### Story 1 – Registrierung
**Als** neuer Benutzer  
**möchte ich** mich mit einem Benutzernamen, Passwort, Bday und E-Mail registrieren,  
**damit** ich mein persönliches Konto in der App erstellen kann.

**Akzeptanzkriterien**
- Benutzername und E-Mail müssen eindeutig sein.
- Passwort wird verschlüsselt gespeichert.
- Standardstatus: `enabled = true`, `account_non_locked = true`.

---

### Story 2 – Anmeldung
**Als** registrierter Benutzer  
**möchte ich** mich mit meinen Zugangsdaten anmelden,  
**damit** ich Zugriff auf meine gespeicherten Workouts und Trainings habe.

**Akzeptanzkriterien**
- Login schlägt fehl, wenn `enabled = false` oder `account_non_locked = false`.
- Erfolgreicher Login aktualisiert `updated_at`.

---

### Story 3 – Benutzerprofil verwalten
**Als** Benutzer  
**möchte ich** meine E-Mail und meinen Geburtstag ändern können,  
**damit** meine Profildaten aktuell bleiben.

---

## 🏋️‍♀️ Übungen & Kategorien (`exercise`, `exercise_category`, `muscle_group`)

### Story 4 – Übungen nach Muskelgruppen anzeigen
**Als** Benutzer  
**möchte ich** Übungen nach Muskelgruppen filtern,  
**damit** ich gezielt Workouts für bestimmte Körperregionen planen kann.

**Akzeptanzkriterien**
- Übungen werden nach `muscle_group` gruppiert.
- Jede Übung gehört optional zu einer `exercise_category` (z. B. Kraft, Ausdauer).

---

### Story 5 – Neue Übung erstellen (Admin/Trainer)
**Als** Trainer  
**möchte ich** neue Übungen mit Beschreibung, Kategorie und Zielmuskelgruppe hinzufügen,  
**damit** Benutzer sie in ihren Workouts verwenden können.

---

## 💪 Workouts (`workout`, `workout_exercise`)

### Story 6 – Eigenes Workout erstellen
**Als** Benutzer  
**möchte ich** ein neues Workout anlegen, dem ich verschiedene Übungen hinzufüge,  
**damit** ich meine Trainingspläne individuell gestalten kann.

**Akzeptanzkriterien**
- Ein Workout gehört immer zu einem Benutzer (`user_id`).
- Übungen können über `workout_exercise` mit Reihenfolge (`position`), `sets` und `reps` definiert werden.

---

### Story 7 – Workout bearbeiten
**Als** Benutzer  
**möchte ich** Name, Beschreibung oder Übungen meines Workouts anpassen,  
**damit** ich Trainingspläne aktuell halten kann.

---

### Story 8 – Workout löschen
**Als** Benutzer  
**möchte ich** ein Workout löschen,  
**damit** alte oder ungenutzte Pläne entfernt werden.

**Akzeptanzkriterien**
- Löscht auch alle zugehörigen `workout_exercise` Einträge (Cascade).
- Oder Sie werden `inaktiv` damit man den Verlauf noch sehen kann
---

## 🤝 Workouts teilen & Einladungen (`shared_workout`, `workout_invite`)

### Story 9 – Workout teilen
**Als** Benutzer  
**möchte ich** ein Workout mit einem anderen Benutzer teilen,  
**damit** dieser meine Trainingsidee sehen und verwenden kann.

**Akzeptanzkriterien**
- Es wird ein Eintrag in `shared_workout` erstellt (`shared_by_user_id`, `workout_id`, `shared_at`).

---

### Story 10 – Benutzer zu Workout einladen
**Als** Benutzer  
**möchte ich** einen anderen Benutzer zu meinem Workout einladen,  
**damit** wir gemeinsam trainieren können.

**Akzeptanzkriterien**
- Einladung hat Status `pending`, `accepted` oder `declined`.
- Kombination `(workout_id, invited_user_id)` ist eindeutig.
- Akzeptierte Einladung gewährt Zugriff auf das Workout.

---

## 🕒 Trainingsdurchführung (`training_session`, `training_exercise`, `training_set`)

### Story 11 – Training starten
**Als** Benutzer  
**möchte ich** ein Workout starten, um meine Trainingssession zu protokollieren,  
**damit** ich Fortschritte nachvollziehen kann.

**Akzeptanzkriterien**
- Ein neuer Eintrag in `training_session` wird erstellt mit `started_at = NOW()`.
- Bezieht sich auf einen konkreten Benutzer und ein Workout.

---

### Story 12 – Übungen innerhalb einer Session erfassen
**Als** Benutzer  
**möchte ich** für jede Übung in meiner Session festhalten, welche Sets und Wiederholungen ich durchgeführt habe,  
**damit** mein tatsächliches Training dokumentiert wird.

**Akzeptanzkriterien**
- Für jede Übung gibt es einen `training_exercise`.
- Zu jedem `training_exercise` gehören mehrere `training_set` Einträge mit `reps`, `weight`, `performed_at`.

---

### Story 13 – Training beenden
**Als** Benutzer  
**möchte ich** meine Trainingseinheit beenden,  
**damit** sie als abgeschlossen markiert wird und in meiner Trainingshistorie erscheint.

**Akzeptanzkriterien**
- `ended_at` wird gesetzt.
- Session kann danach nicht mehr bearbeitet werden.

---

## 📊 Fortschritt & Auswertung (optional)

### Story 14 – Trainingshistorie ansehen
**Als** Benutzer  
**möchte ich** meine vergangenen Trainingssessions und Leistungen sehen,  
**damit** ich meine Fortschritte über die Zeit verfolgen kann.

---

### Story 15 – Statistiken abrufen
**Als** Benutzer  
**möchte ich** sehen, wie sich meine Wiederholungen und Gewichte im Zeitverlauf verändern,  
**damit** ich meine Trainingsziele optimieren kann.

---

## ⚙️ Systemanforderungen

- Änderungen an Tabellen mit `ON DELETE CASCADE` löschen abhängige Daten automatisch.
- Zeitstempel (`created_at`, `updated_at`) werden vom System gesetzt.
- Validierung erfolgt über Constraints (z. B. `UNIQUE`, `CHECK`).

---

## 📁 Mögliche nächste Schritte
- Implementierung von Entities, Repositories und Services in Spring Boot.
- REST-Endpoints für CRUD-Operationen.
- Integration von Authentifizierung (Spring Security / JWT).
- Erstellung von Tests (Unit + Integration).
- Erstellen von User Rollen
- Erstellen von Statistiken
- SWAGGER UI
- CI/CD
---
