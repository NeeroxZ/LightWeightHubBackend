📖 [User Stories](./docs/user-story.md)

# 💪 LightWeightHub – Backend (Spring Boot)

Das **LightWeightHub Backend** ist eine RESTful API auf Basis von **Spring Boot 3**,  
die alle Serverfunktionen für das LightWeightHub-System bereitstellt.

Das Backend verwaltet Benutzer, Workouts, Übungen und Trainingssessions  
und kommuniziert über eine REST-API mit dem Angular-Frontend.

---

##  Projektübersicht

- **Backend:** Java 17 / Spring Boot 3
- **Frontend:** [LightWeightHub Frontend (Angular)](https://github.com/<dein-username>/LightWeightHub_frontend)
- **Datenbank:** PostgreSQL
- **Build Tool:** Maven
- **Migration:** Flyway
- **ORM:** Spring Data JPA
- **Mapping:** MapStruct
- **Testing:** JUnit 5, Testcontainers, Spring REST Docs

---
## Datenbankstruktur

Das Datenmodell basiert auf PostgreSQL

➡️ Die SQL-Struktur wird über Flyway-Migrationen automatisch erstellt (`/src/main/resources/db/migration`).

---

## Setup & Installation

### Voraussetzungen
- Java **17+**
- Maven **3.9+**
- PostgreSQL **14+**
- (optional) Docker für lokale DB

---
## Anwendung starten
Repository klonen:
```bash
  git clone 
  cd LightWeightHub_backend
```



Konfiguration in  application.yml anpassen (Datenbank-Zugangsdaten, Ports etc.).

Anwendung starten:
