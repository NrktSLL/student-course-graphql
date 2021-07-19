# Student Course Graphql

Graphql and Liquibase example with Kotlin and Java in Spring Boot



<p align="center">
<img src="https://github.com/NrktSLL/student-course-graphql/blob/main/images/student-course-graphql.png" alt="SSpring Webflux JWT Example" width="100%" height="100%"/> 
</p>


## Installation
Prerequisites:
*  Docker
*  Docker Compose

>Container creation with [Buildpacks](https://buildpacks.io/) 
```
mvn clean install && docker-compose up -d
```

## Build/Package
```
mvn clean package
```

## Used Dependencies
* Kotlin Stdlib JDK8
* Spring Boot Actuator
* Spring Boot Validation
* Spring Boot Web
* H2 Database
* Mysql
* Liquibase
* Netflix Graphql [DGS](https://netflix.github.io/dgs/)
* Jackson Module Kotlin
* Lombok

## Abilities
* Kotlin data class
* Netflix DGS Graphql

## TODO
- [ ] Validation will be added
- [ ] Instructor service and relation services will be added

## Graphiql
> **Access : http://localhost:8080/api/graphiql**

<img src="https://github.com/NrktSLL/student-course-graphql/blob/main/images/student-course-graphql-graphiql.png" alt="Spring Webflux JWT Swagger" width="100%" height="100%"/> 

## Resource
* https://netflix.github.io/dgs/
* https://www.baeldung.com/kotlin/maven-java-project
