FROM openjdk:8-jdk-alpine
LABEL maintainer="arifahmetbarbak@gmail.com"
VOLUME /tmp
EXPOSE 8080
ADD target/task1-0.0.1-SNAPSHOT.jar /
CMD java -jar task1-0.0.1-SNAPSHOT.jar