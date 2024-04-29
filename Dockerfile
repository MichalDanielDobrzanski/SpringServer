FROM bellsoft/liberica-openjdk-alpine-musl:17
VOLUME /tmp
# copy the executable to the isolated system
COPY target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]