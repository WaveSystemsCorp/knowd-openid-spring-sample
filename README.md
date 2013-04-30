knowd-openid-spring-sample
==========================

Purpose of this project is to demonstrate spring security authentication integration with [OpenID](http://openid.net) and DeviceID.

Authorized User entity is persisted to HSQLDB (memory) by default, but can be changed to any other JDBC driver / database.

Following libraries are used in the project: spring, hibernate, c3p0, jetty, hsqldb

Persistence (database) settings are located in /src/main/resources/jdbc.properties

Running the sample web application
----------------------------------
This project is using maven to compile, package and run using jetty server.

    cd knowd-openid-spring-sample
    mvn package
    mvn jetty:run

Once the jetty server is running on port 8080, access the sample web application using [http://localhost:8080](http://localhost:8080)

