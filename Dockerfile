FROM openjdk:8-nanoserver
EXPOSE 8084
ADD target/our-web-app.war our-web-app.war
ENTRYPOINT ["java","-jar","/our-web-app.war"]