FROM java:8

ADD build/libs/discovery_example-0.0.1.jar /data/

CMD ["java","-jar","/data/discovery_example-0.0.1.jar"]
