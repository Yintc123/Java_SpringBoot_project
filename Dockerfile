 
# --------------------------basic----------------------------
# FROM openjdk:11
# COPY /target/HelloSpringBoot-0.0.1-SNAPSHOT.war HelloSpringBoot-0.0.1-SNAPSHOT.war
# ENTRYPOINT ["java", "-jar", "HelloSpringBoot-0.0.1-SNAPSHOT.war"]

# -----------------------docker-compose----------------------------
# FROM openjdk:11-jre-slim-buster
# RUN mkdir /app
# RUN mkdir /app/ssl

# 加入bash功能
# RUN apt update && apt install bash-completion
# COPY wait-for-it.sh wait-for-it.sh
# RUN chmod +x wait-for-it.sh
# COPY /target/HelloSpringBoot-0.0.1-SNAPSHOT.war /app/HelloSpringBoot-0.0.1-SNAPSHOT.war

# COPY /target/ /app
# WORKDIR /app
# ENTRYPOINT ["java", "-jar", "HelloSpringBoot-0.0.1-SNAPSHOT.war"]
# CMD ["./wait-for-it.sh", "mysqldb:3307", "--", "java", "-jar", "HelloSpringBoot-0.0.1-SNAPSHOT.war"]

# -----------------------RDS----------------------------
FROM openjdk:11
# RUN mkdir /ssl
COPY /target/HelloSpringBoot-0.0.1-SNAPSHOT.war HelloSpringBoot-0.0.1-SNAPSHOT.war
ENTRYPOINT ["java", "-jar", "HelloSpringBoot-0.0.1-SNAPSHOT.war"]