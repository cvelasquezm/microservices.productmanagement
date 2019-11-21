FROM openjdk:8
COPY ./build/libs/productmanagement-0.0.1-SNAPSHOT.jar /usr/src/
WORKDIR /usr/src
EXPOSE 8085
CMD ["java", "-jar", "productmanagement-0.0.1-SNAPSHOT.jar"]