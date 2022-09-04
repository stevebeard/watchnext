# watchnext

Manage your personal list of tv shows and movies to watch.

## Build

```
./mvnw package
```

## Run

```
./mvnw spring-boot:run
```

OR

```
java -jar target/watchnext-webapp-0.0.1-SNAPSHOT.jar
```

## Docker

### Build

```
docker build -t watchnext:0.0.1 .
```

#### Raspberry Pi

Specify `linux/arm/v7` platform to build an image for Raspberry Pi
```
docker build --platform=linux/arm/v7 -t watchnext:0.0.1 .
```

### Run

```
docker run -d --name watchnext \
    -p 8080:8080 \
    -v ~/.watchnext/data:/data \
    watchnext:0.0.1
```

## Debug

### h2-console

The H2 database web console can be enabled by adding `debug` to the active spring profiles

```
SPRING_PROFILES_ACTIVE=debug
```
