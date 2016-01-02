FROM java:8

ADD build/libs/discovery_example-0.0.1.jar /data/
ADD application.yaml /data/

CMD ["java","-jar","/data/discovery_example-0.0.1.jar"]
