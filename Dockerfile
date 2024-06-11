FROM amazoncorretto:17.0.7-alpine
ARG JAR_FILE=target/*.jar
COPY bank-account-service/${JAR_FILE} bank-account-service.jar
COPY client-service/${JAR_FILE} client-service.jar
ADD load.sh .
EXPOSE 8080
EXPOSE 8081

CMD ["bash", "load.sh"]
