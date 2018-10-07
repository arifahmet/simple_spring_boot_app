# Spring Boot App


# Requirements

- Java 1.8
- Maven
- Docker


# How to build

Run below command to generate .jar file
```
mvn package
```


# How to run

Run below command and visit http://localhost:8080/swagger-ui.html with your favourite browser. You can access rest api document and see information about end points.
```
java -jar task1-0.0.1-SNAPSHOT.jar
```

# How to run with Docker

Open your docker shell and locate to project directory. Run below command and build docker image.
```
./build.sh 
```

After that run below command to start docker containers. 
``` 
docker-compose up
```

That's all. You can now visit http://localhost:8080/swagger-ui.html with your favourite browser!

Note: If you are using docker on windows. You should write your docker-machine's ip instead of localhost. Because exposing ports on windows hosts is directed to virtual machine which is between windows hosts and docker daemon.