FROM sha256:2be7fb198f03acc4767e529f7633c78fca16ed8b69ef138936a962a1d78ea961
EXPOSE 8084
ADD target/our-web-app.war our-web-app.war
ENTRYPOINT ["java","-war","/our-web-app.war"]