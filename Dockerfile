FROM openjdk:17-ea-14-jdk-nanoserver
EXPOSE 8084
ADD target/our-web-app.war our-web-app.war
ENTRYPOINT ["java","-war","/our-web-app.war"]