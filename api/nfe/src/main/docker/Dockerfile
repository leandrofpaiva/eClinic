FROM java:8
VOLUME /tmp
ADD nfe-api-1.0.jar nfe.jar
RUN bash -c 'touch /nfe.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/nfe.jar"]
