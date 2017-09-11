# Spring Boot "Microservice" Multi Module Example Project
REST APIs implemented using Spring Boot Multi Module Maven Project

## How to Run

* Build the project by running `mvn clean package` inside todo-app-parent module
* Once successfully built, run the service by using the following command:
```
java -jar  todo-app-rest/target/todo-app-rest-0.0.1-SNAPSHOT.jar
```

## REST APIs Endpoints
### Create a Todo Note resource
```
POST /todo
Accept: application/json
Content-Type: application/json

{
"title" : "Spring Boot",
"description" : "Setup spring boot application",
}

```

### Update a Todo Note resource
```
PUT /todo/{Note Id}
Accept: application/json
Content-Type: application/json

{
"id" : "id"
"title" : "Spring Boot",
"description" : "Setup spring boot application",
}

```

### Retrieve a list of Todo Notes
```
Get /todo
Accept: application/json
Content-Type: application/json

```

### Find a Todo Note Resource
```
Get /todo/{Note Id}
Accept: application/json
Content-Type: application/json
```

### Delete a Todo Note Resource
```
DELETE /todo/{Note Id}
Accept: application/json
Content-Type: application/json
```






