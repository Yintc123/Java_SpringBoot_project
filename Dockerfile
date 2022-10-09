# FROM openjdk:11
# COPY /target/HelloSpringBoot-0.0.1-SNAPSHOT.war HelloSpringBoot-0.0.1-SNAPSHOT.war
# ENTRYPOINT ["java", "-jar", "HelloSpringBoot-0.0.1-SNAPSHOT.war"]
# FROM openjdk:11

FROM openjdk:11-jre-slim-buster
RUN mkdir /app
RUN mkdir /app/ssl

# 加入bash功能
RUN apt-get add --no-cache bash
COPY wait-for-it.sh /app/wait-for-it.sh
RUN chmod +x /app/wait-for-it.sh
COPY /target/HelloSpringBoot-0.0.1-SNAPSHOT.war /app/HelloSpringBoot-0.0.1-SNAPSHOT.war

# COPY /target/ /app
WORKDIR /app
# ENTRYPOINT ["java", "-jar", "HelloSpringBoot-0.0.1-SNAPSHOT.war"]
CMD ["wait-for-it.sh", "mysqldb:3307", "--", "java", "-jar", "HelloSpringBoot-0.0.1-SNAPSHOT.war"]