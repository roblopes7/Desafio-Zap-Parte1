FROM appinair/jdk11-maven:latest
VOLUME /tmp
EXPOSE 8080
RUN mkdir -p /app/
RUN mkdir -p /app/logs/
ADD target/Luna.jar Luna.jar
ENTRYPOINT ["java", "-jar", "Luna.jar"]
