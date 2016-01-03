## Discovery Example

Going to play with [Spring-Boot](http://projects.spring.io/spring-boot/) some more and various discovery tools: [Consul](https://www.consul.io/) and [etcd](https://github.com/coreos/etcd).

### Running

```
./gradlew run
```

```
http://localhost:8080/word
```

```
http://localhost:8080/number
```

### Docker

```
./gradlew clean build && docker build -t jstenhouse/discovery_example:latest .
```

```
docker run --name discovery_example_0 --rm -p 8080:8080 -e SERVER_PORT=8080 jstenhouse/discovery_example:latest
```

```
docker run --name discovery_example_1 --rm -p 8081:8081 -e SERVER_PORT=8081 jstenhouse/discovery_example:latest
```

```
docker run --name discovery_example_2 --rm -p 8082:8082 -e SERVER_PORT=8082 jstenhouse/discovery_example:latest
```
