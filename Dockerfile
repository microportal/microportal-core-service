FROM microportal/openjdk-kong:11-jre-slim

ENV APP_JAR=portal-service.jar

ADD target/${APP_JAR} /opt/

