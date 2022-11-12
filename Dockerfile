FROM openjdk:11
COPY target/demo-docker-0.0.1-SNAPSHOT.war demo-docker-0.0.1-SNAPSHOT.war
ENTRYPOINT ["java", "-jar", "/demo-docker-0.0.1-SNAPSHOT.war"]