# SETUP Instructions

* In application.properties file, configure the username, password and database as suitable.
* Also, before running the application, create the database manually as specified in your application.properties file.

## Dependencies/Artifacts used
* ***spring-boot-starter-data-r2dbc***: As an alternative to spring data JPA for the reactive stack
* ***spring-boot-starter-webflux***: To write reactive REST endpoints
* ***r2dbc-mysql***: MySQL driver for R2dbcEntityTemplate

## Rest endpoint details
* POST Endpoint: http://localhost:8080/employee
* Request body expected:
```
 {
    "name": "Hello",
    "email": "hello@gmail.com"
 }
```
* GET Endpoints
  * Get all employees: http://localhost/employee/all
  * Get employee by Id: http://localhost/employee/{id} - Returns 404 if resource not found

* DELETE Endpoint
  * Delete employee by Id: http://localhost/employee/{id}

* PATCH Endpoint
  * Update employee name by Id: http://localhost/employee/{id} - Returns 404 if resource not found
  * Expected request body:
  ```
  {
    "name": "Hello"
  }
  ```  
