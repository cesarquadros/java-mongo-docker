FROM openjdk:8-alpine
MAINTAINER Cesar Quadros
RUN apk update && apk add bash
RUN mkdir -p /opt/app
ENV PROJECT_HOME /opt/app
COPY ./projetodocker/target/projetodocker-0.0.1-SNAPSHOT.jar $PROJECT_HOME
WORKDIR  $PROJECT_HOME
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod","projetodocker-0.0.1-SNAPSHOT.jar"] 