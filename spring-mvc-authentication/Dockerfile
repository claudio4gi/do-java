FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY target/${JAR_FILE} application.jar
ENTRYPOINT ["java","-jar","/application.jar"]