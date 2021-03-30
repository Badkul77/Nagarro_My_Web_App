FROM openjdk:8-nanoserver
EXPOSE 8084
ADD target/our-web-app.jar our-web-app.jar
ENTRYPOINT ["java","-jar","/our-web-app.jar"]