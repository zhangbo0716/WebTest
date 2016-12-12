FROM index.alauda.cn/jk360/deploy-jdk-tomcat
MAINTAINER      zhangbo zhangbo@360jk.com

ADD target/WebTest.war /usr/local/tomcat7/webapps
CMD sh /usr/local/tomcat7/bin/startup.sh

EXPOSE 8080
