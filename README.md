## Discovery Example

Going to play with [Spring-Boot](http://projects.spring.io/spring-boot/) some more and various discovery tools: [Consul](https://www.consul.io/) and [etcd](https://github.com/coreos/etcd).

### Running

```
./gradlew run
```

```
http://localhost:8080/hello-world
```

```
http://localhost:8080/goodbye-world
```

### Docker

```
./gradlew clean build && docker build -t jstenhouse/discovery_example:latest .
```

```
docker run --name discovery_example -d -p 8080:8080 jstenhouse/discovery_example:latest
```
