FROM bellsoft/liberica-openjdk-alpine-musl:21-jre
WORKDIR /opt
COPY ./target/app.jar /opt/
ENTRYPOINT ["java", "-server", "-jar", "/opt/app.jar"]