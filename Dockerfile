FROM tomcat:latest
LABEL maintainer="Naman Badkul"
COPY target/our-web-app.war /usr/local/tomcat/webapps/
EXPOSE 8080
CMD ["catalina.sh", "run"]