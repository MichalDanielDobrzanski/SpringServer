# Tools used:

- Spring Boot: https://www.youtube.com/watch?v=9SGDpanrc8U
- Spring Data JPA: https://www.youtube.com/watch?v=8SGI_XS5OPw

# Environment:

1. installing postgres: `brew install postgresql@15`
2. installing psql: `brew install libpq` and `brew link --force libpq` and `brew search postgres`
3. running: `psql postgres`
4. installing pgAdmin: https://www.pgadmin.org/

# Installing
-> maven -> install 
or CMD:
```bash
./mvnw install

```

```
cd target
java -jar demo-0.0.1-SNAPSHOT.jar
 java -jar demo-0.0.1-SNAPSHOT.jar --server.port=8081 
```

# API endpoint:

GET:

```
http://localhost:9090/api/v1/student
```

POST:

```
curl -X POST http://localhost:9090/api/v1/student -H "Content-Type: application/json" -d '{"name": "john", "email": "john@gmail.com", "localDate": "2001-02-02"}'
```

DELETE:

```
curl -X DELETE http://localhost:9090/api/v1/student/1
```

PUT:
```
curl -X PUT http://localhost:9090/api/v1/student/1\?name\=Korwin\&email=korwin@gmail.com -H "Content-Type: application/json" -v
# without escape chars:
curl -X PUT "http://localhost:9090/api/v1/student/1?name=Korwin&email=korwin@gmail.com" -H "Content-Type: application/json" -v
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
- _sql sequence_ - it is needed to create unique values. Only primary key is not enough. This has no transaction
  isolation, so several transactions cannot get the same values. The increments are also not rolled back. Without it is
  very hard to generate unique incrementing numbers (ref: https://stackoverflow.com/a/1649126/4150337)
- schemas:
  A database contains one or more named _schemas_, which in turn contain tables.

# Hibernate:

- you need to create a Persistent class:
    - no-arg constructor
    - an identifier property
    - must create getters and setters for POJO classes so Hibernate can read properties (default method names)
    - prefer non-final-class
- `@Transient` is used for Persistent classes to skip adding them to the database

# Misc:

- Using script to launch locally: `./psql.sh`

## Docker setup:
- tutorial: https://www.youtube.com/watch?v=pg19Z8LL06w
- spring: https://spring.io/guides/topicals/spring-boot-docker
- https://medium.com/@saygiligozde/using-docker-compose-with-spring-boot-and-postgresql-235031106f9f

1. From dockerfile;
```sh
docker pull nginx:1.25
docker images
docker run nginx:1.25
# to run in background
docker run -d nginx:1.25
# to list running containers
docker ps
# to stop the container <> - is the container id
docker stop <>
# run with port binding to expose it to localhost
docker run -d -p 9000:80 nginx:1.25
# to list all containers (not running ones too)
docker ps -a
# to run with a name
docker run --name web-spring -d -p 9000:80 nginx:1.25
# 1. to build from Dockerfile
docker build --tag 'demo_server' .
# 2. to run
docker run --name demo_server -d -p 9090:9090 demo_server
# to open a shell for this container
docker run -ti --entrypoint /bin/sh demo_server
```

2. From docker compose:
```sh
docker-compose down
# or when to remove orphans too:
docker compose down --remove-orphans
docker rmi demo_server
docker-compose up
# or in background
docker-compose up -d
```