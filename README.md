Spring Teaching Project
=======================

This multi-module Maven project contains examples grouped by topic for use in a guest lecture.

Modules:
- spring-basics : Hello World (Spring Boot), Setter DI, Constructor DI, Autowiring
- spring-aop    : Demonstrates Spring AOP advices: before, after, around, after-returning, after-throwing, pointcut
- spring-jdbc   : Demonstrates JdbcTemplate with H2 (insert, update, delete, PreparedStatement, ResultSetExtractor, RowMapper)
- spring-boot-rest : Simple Spring Boot app that prints a message, a REST controller, and in-memory store

How to run:
1. Ensure Java 17 and Maven are installed.
2. From the project root, run: mvn -pl spring-basics spring-boot:run
   or run each module: mvn -pl spring-aop spring-boot:run
   You can run any module using 'mvn -pl <module-name> spring-boot:run'

Notes:
- H2 in-memory DB is used for JDBC and REST examples so you don't need an external DB.
- Port for REST app: 8081
