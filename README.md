# Hibernate PostgreSQL CRUD

A minimal Java project that uses **Hibernate ORM** to save `Student` objects into a **PostgreSQL** database. Built as a first step in learning ORM and database access from Java.

## Tech Stack

- Java 17
- Hibernate ORM 6.4.4.Final
- PostgreSQL (JDBC driver 42.7.3)
- Maven

## Project Structure

```
hibernate-basic
├── pom.xml
└── src
    └── main
        ├── java
        │   ├── Main.java        # Opens a session and saves students
        │   └── Student.java     # Entity mapped to the "students" table
        └── resources
            ├── hibernate.cfg.xml.example   # Config template (copy and fill in)
            └── hibernate.cfg.xml           # Your local config (not committed)
```

## Prerequisites

- JDK 17 or higher
- Maven (or IntelliJ IDEA with its bundled Maven)
- PostgreSQL installed and running

## Setup

1. **Clone the repository**

   ```bash
   git clone https://github.com/chandelaanant/hibernate-postgres-crud.git
   cd hibernate-postgres-crud
   ```

2. **Create the database**

   ```bash
   psql -U postgres
   ```

   ```sql
   CREATE DATABASE hibernate_demo;
   ```

3. **Create your config file**

   Copy the template and add your PostgreSQL password:

   ```bash
   cp src/main/resources/hibernate.cfg.xml.example src/main/resources/hibernate.cfg.xml
   ```

   Then open `hibernate.cfg.xml` and replace `YOUR_PASSWORD` with your own.

   > `hibernate.cfg.xml` is listed in `.gitignore` so your password is never pushed to GitHub.

4. **Load dependencies**

   Reload Maven in your IDE, or run:

   ```bash
   mvn compile
   ```

## Run

Run the `Main` class from your IDE, or from the terminal:

```bash
mvn compile exec:java -Dexec.mainClass=Main
```

Hibernate will create the `students` table automatically (`hbm2ddl.auto=update`) and insert two rows.

## Verify

```bash
psql -U postgres -d hibernate_demo
```

```sql
SELECT * FROM students;
```

Each run of `Main` inserts two more rows, since the table is kept between runs.

## How It Works

1. `Configuration().configure()` reads `hibernate.cfg.xml`.
2. `buildSessionFactory()` connects to PostgreSQL and prepares the mapping for `Student`.
3. A `Session` and `Transaction` are opened.
4. `session.persist(...)` queues the inserts, and `tx.commit()` writes them to the database.

## Roadmap

- [x] Create (persist)
- [ ] Read (get by id, HQL queries)
- [ ] Update
- [ ] Delete
- [ ] Entity relationships (one-to-many, many-to-many)

## Author

Anant Chandela ([@chandelaanant](https://github.com/chandelaanant))
