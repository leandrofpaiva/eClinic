FROM java:8
VOLUME /tmp
ADD eclinic-medic-api-1.0.jar medic.jar
RUN bash -c 'touch /medic.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/medic.jar"]
