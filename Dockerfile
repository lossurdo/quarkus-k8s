FROM openjdk:11
RUN mkdir /quarkus
COPY target/*-runner.jar /quarkus
WORKDIR /quarkus
RUN mv *runner.jar quarkus.jar
CMD ["java", "-jar", "quarkus.jar"]