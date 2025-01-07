# product-service

It is a product Service which is a part of Lost_and_found Application
which is based on microservice's architecture.Here manage all product related

## step-by-step guide to work with this service
start from cloning, clone the service from Git and setup on local machine 

### *Configure the application.properties File*
spring.application.name=ProductService
server.port=8083


# Hikari Connection Pool Properties
spring.datasource.hikari.data-source-properties.ssl=true
spring.datasource.hikari.data-source-properties.sslmode=require
spring.datasource.hikari.data-source-properties.sslrootcert=file:///C:/Users/hp/Downloads/root.crt

# JPA and Hibernate Settings
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.properties.hibernate.jdbc.url=jdbc:postgresql://ap-south-1.000a698e-9531-4f05-81c7-2b0e60704508.aws.yugabyte.cloud:5433/product_db

set the server.port=8083 used hikari for connection pooling and hibernate(jpa) for database connectivity

#### *Create Database tables* 

For Database connectivity we required database.The database server should be protected by a username and password.
1.Visit the PostgreSQL Website and https://www.postgresql.org/download/ download
and pgAdmin: GUI for managing PostgreSQL databases.

1. Create a new database (`database_name`).//product_db
2. Mention the credentials in `application.properties` as shown below. 

# Other settings

spring.datasource.url=jdbc:postgresql://ap-south-1.000a698e-9531-4f05-81c7-2b0e60704508.aws.yugabyte.cloud:5433/database_name
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.datasource.driver-class-name=org.postgresql.Driver

## Setup YugaByte and Config with pgAdmin

### Create the YugaByteDB Cluster on the Server:

    Create a cluster named 'LostAndFoundApplication,' connect to it, and provide the root.crt file and credentials 
    for its creation.
    Download the root.crt and credentials file in local repo.

### Download pgAdmin and Configure with YugaByte:

    Now to Connect YugabyteDB to pgAdmin:-
    1.Open pgAdmin and right-click on Servers, then select Create > Server
    2.In the Create - Server window, fill in the following details:
     -> General Tab: Name: Enter a name for your server (e.g., YugabyteDB).
     -> Connection Tab:-
                       * Host: Enter the IP address of the server where YugabyteDB is running.
                       * Port: Use the default YugabyteDB PostgreSQL port 5433.
                       * Username: Use the PostgreSQL username
                       * Password: Enter the password (u will get from credentials file)
    3.Click Save to create and connect.

#### *IDE Support*

using <b>IntelliJ Idea</b> for better performence additionally we managed git related work from IDE
1.simply create a branch from main(branch) that is https://github.com/lost-n-found-app/product-service/tree/new_test_branch_for_controller
in this branch setup all required 
                                 *Entities
                                 *controllers
                                 *services 
2.Create a new Branch from main(branch) that is https://github.com/lost-n-found-app/product-service/tree/create_Dao_Entity/ProductService
in this branch performed CRUD for lost/found
                                 *report lost/found item
                                 *getAll lost/found itemList
                                 *get lost/found item by id
                                 *delete lost/found item
                                 *update lost/found item by id

3 take a pull request from main(Branch) and create new branch that is code_update
in this branch 