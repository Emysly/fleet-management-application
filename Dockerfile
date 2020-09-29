FROM openjdk:latest
COPY ./target/fleet-management.jar fleet-management.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "fleet-management.jar"]
