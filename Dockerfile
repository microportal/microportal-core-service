FROM openjdk:11-jre-slim

ENV JAVA_OPTS="-Xms96m -Xmx128m -XX:MetaspaceSize=96m -XX:MaxMetaspaceSize=128m"

ADD target/core-service.jar /app/
RUN groupadd -r microportal \
    && useradd --no-log-init -g microportal microportal \
    && chown -R microportal:microportal  /app
USER microportal
WORKDIR /app

ENTRYPOINT java -Djava.security.egd=file:/dev/./urandom -server -XX:+UseContainerSupport \
    ${JAVA_OPTS} -jar core-service.jar
