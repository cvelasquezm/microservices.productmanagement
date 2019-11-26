FROM openjdk:8
COPY target/productManagement.jar /usr/src/
WORKDIR /usr/src
EXPOSE 8085
CMD ["java", "-jar", "productManagement.jar"]