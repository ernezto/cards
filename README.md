#**Basic Application for a Cards Game**

In order to facilitate the understanding of the assignment I added Swagger to the API, so you can run the server and jump to the swagger URL (see below). Hopefully that documentation should be self-explanatory.

### This API REST implementation tech stack:

- spring boot framework
- gradle 
- hibernate validation 
- H2 database: http://localhost:8080/h2-console (after running the service)
- JPA  
- lombok
- mapstruct  
- swagger: http://localhost:8080/swagger-ui/index.html
- JUnit 5

### Useful commands:

```bash
#compile
./gradlew compile
```

```bash
#run tests
./gradlew test
```

```bash
#run api server
./gradlew bootRun
```
### Tradeoffs
- TDD got halfway through given the time constraint. First commits follow pretty closely the process but later on I went into a more run & test approach.
- Some validations are not completed like when dealing a card to a player isn't covered that the player is assigned to that game.
- Even though this is a pretty simple exercise I went ahead and added an architecture layout that follows the MVC pattern with my own interpretation of a DDD pattern. So in theory all the code is centered on the domain layer that drives the core features.
- Despite the use of an in-memory database some calculations are done mainly in the domain layer. I realize however that for performance reasons multiple of this data gathering processes can be implemented at the DATA layer.
- I would have loved to add more unit tests and also some integration tests too.
- Shuffling could have been done simpler by probably modeling the problem including a Shoe class and making it the holder of the undealt cards. Then probably Game class would have interacted merely with the Shoe and nothing else.