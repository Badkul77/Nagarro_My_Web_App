FROM tomcat:latest
LABEL maintainer="Naman Badkul"
COPY target/our-web-app.war /usr/local/tomcat/webapps/
EXPOSE 8090
CMD ["catalina.sh", "run"]