FROM openjdk:11
COPY /target/HelloSpringBoot-0.0.1-SNAPSHOT.war HelloSpringBoot-0.0.1-SNAPSHOT.war
ENTRYPOINT ["java", "-jar", "/HelloSpringBoot-0.0.1-SNAPSHOT.war"]