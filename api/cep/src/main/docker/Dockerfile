FROM java:8
VOLUME /tmp
ADD cep-api-1.0.jar cep.jar
RUN bash -c 'touch /cep.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/cep.jar"]
