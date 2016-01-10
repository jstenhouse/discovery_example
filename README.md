## Discovery Example

Going to play with [Spring-Boot](http://projects.spring.io/spring-boot/) some more and various discovery tools: [Consul](https://www.consul.io/) and [etcd](https://github.com/coreos/etcd).

### Running

```
./gradlew run
```

```
http://localhost:8080/ping
```

```
http://localhost:8080/pong
```

### Docker

```
./gradlew clean build && docker build -t jstenhouse/discovery_example:latest .
```

```
docker run --name discovery_example_ping -d -p 8080:8080 -e SERVICE_NAME=ping -e SERVER_PORT=8080 --link etcd jstenhouse/discovery_example:latest
```

```
docker run --name discovery_example_pong -d -p 8081:8081 -e SERVER_PORT=8081 jstenhouse/discovery_example:latest
```

```
docker run --name discovery_example_services -d -p 8082:8082 -e SERVER_PORT=8082 jstenhouse/discovery_example:latest
```
