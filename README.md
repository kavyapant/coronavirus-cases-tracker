# coronavirus-cases-tracker
This application tracks number of covid cases reported across the globe. It gives total coronavirus cases reported country,state/province wise. 
It also displays changes in the cases since pervious day.
The application is updated daily to show latest count.
## Technology Stack
* The project uses Java Spring Boot
* Thymeleaf java template engine is used to create the UI
* Data is fetched from repository created by by the Center for Systems Science and Engineering (CSSE) at Johns Hopkins University:https://github.com/CSSEGISandData/COVID-19
Note: Display of State wise data of certain countries in the application depends on its availabilty in the source repository
## Requirements

For building and running the application you need:

- Java-15
- apache-maven-3.8.1
## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```
## Deployed Application
URL:https://cornavirus-tracker.herokuapp.com/
## Image of Application





