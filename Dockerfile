FROM openjdk:22-jdk
COPY target/quizapp.jar /quizapp.jar
ENTRYPOINT [ "java","-jar","/quizapp.jar" ]