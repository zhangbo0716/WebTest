FROM index.alauda.cn/jk360/deploy-jdk-tomcat
MAINTAINER      zhangbo zhangbo@360jk.com

ADD target/webtest-1.0.war /usr/local/tomcat7/webapps
CMD sh /usr/local/tomcat7/bin/catalina.sh

EXPOSE 8080
