# Spring Boot CRUD Application

## Overview

This project is a **Spring Boot application** that provides CRUD operations for managing application resources.

The application uses **Gradle** as its build and dependency management tool.

## Requirements

Before running the application, make sure you have installed:

* Java 17 or later
* Gradle, or use the included Gradle Wrapper
* Git (optional)

## Running the Application

To start the Spring Boot application, execute:

```bash
./gradlew bootRun
```

On Windows:

```bash
gradlew.bat bootRun
```

Once the application starts, it will be available at:

```text
http://localhost:8080
```

## CRUD Resources

The application exposes REST resources that follow the standard **CRUD** pattern.

CRUD stands for:

* **Create** – Create a new resource of product.
* **Read** – Retrieve existing resources related to products.
* **Update** – Modify an existing resource of product.
* **Delete** – Remove an existing resource.

For example, assuming the application manages a `Product` resource:

| Operation | HTTP Method | Example Endpoint | Description                 |
| --------- | ----------- | ---------------- | --------------------------- |
| Create    | `POST`      | `/products`      | Creates a new product       |
| Read all  | `GET`       | `/products`      | Returns all products        |
| Read one  | `GET`       | `/products/{id}` | Returns a product by ID     |
| Update    | `PUT`       | `/products/{id}` | Updates an existing product |
| Delete    | `DELETE`    | `/products/{id}` | Deletes a product           |

### Create

Use `POST` to create a new resource.

```shell
curl --location 'localhost:8080/products' \
--header 'Content-Type: application/json' \
--data '{
    "name": "mandarina"
}'
```

Example response:

```json
{
  "name": "mandarina mandarina"
}
```


### Read

Use `GET` to retrieve resources.

Retrieve all products:

```shell
curl --location 'localhost:8080/products'
```
Example response:

```json
[
  {
    "name": "MANZANA"
  }
]
```

Retrieve a specific product:

```shell
curl --location 'localhost:8080/products/granadilla'
```

Example response:

```json
{
  "name": "granadilla"
}
```
### Update

Use `PUT` to update an existing resource.

```shell
curl --location --request PUT 'localhost:8080/products/anana' \
--header 'Content-Type: application/json' \
--data '{
    "name": "aleluya"
}'
```

Example response:

```json
{
  "name": "4n4n44leluy4"
}
```

The resource identified by `anana` is updated with the new information.

### Delete

Use `DELETE` to remove a resource.

```shell
curl --location --request DELETE 'localhost:8080/products/anana' \
--header 'Content-Type: application/json' \
```

The server deletes the product identified by `1`.

## REST API Structure

A typical Spring Boot CRUD application can be organized into the following layers:

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
Database
```

### Controller

The **Controller** exposes the REST endpoints and receives HTTP requests.

Example:
