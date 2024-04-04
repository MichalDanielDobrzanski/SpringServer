# Tools used:
- Spring Boot: https://www.youtube.com/watch?v=9SGDpanrc8U
- Spring Data JPA: https://www.youtube.com/watch?v=8SGI_XS5OPw

# Environment:
1. installing postgres: `brew install postgresql@15`
2. installing psql: `brew install libpq` and `brew link --force libpq` and `brew search postgres`
3. running: `psql postgres`
4. installing pgAdmin: https://www.pgadmin.org/

# API endpoint:
```
http://localhost:9090/api/v1/student
```

# Postgres
## psql
  - list roles: `/du`
  - ```sql
    CREATE ROLE root superuser createdb login;
    ```
  - add privileges:
    ```sql
    GRANT ALL PRIVILEGES ON DATABASE "maindb" to root;
    ```
  - connect to a database: `\c maindb`
## info:
- `BIGSERIAL` generates a new unique value for column
- _sql sequence_ - it is needed to create unique values. Only primary key is not enough. This has no transaction isolation, so several transactions cannot get the same values. The increments are also not rolled back. Without it is very hard to generate unique incrementing numbers (ref: https://stackoverflow.com/a/1649126/4150337)
- schemas:
A database contains one or more named _schemas_, which in turn contain tables.
- 

# Hibernate:
- you need to create a Persistent class:
  - no-arg constructor
  - an identifier property
  - must create getters and setters for POJO classes so Hibernate can read properties (default method names)
  - prefer non-final-class
- `@Transient` is used for Persistent classes to skip adding them to the database

# Misc:
- Using script to launch locally: `./psql.sh`