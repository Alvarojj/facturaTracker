FROM openjdk:17.0.2

COPY build/libs/facturaTracker-0.0.1-SNAPSHOT.jar facturatracker.jar

ENTRYPOINT ["java", "-jar", "facturatracker.jar"]