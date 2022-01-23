serenity screenplay with docker example:
build it project:
```bash
docker build . -t dogapiv1 
```

Then run built image in terminal:(clean with filter)

```docker
docker run dogapiv1 mvn verify test | awk '/Tests/ {print}'
```

or (all output)

```docker
docker run dogapiv1 mvn verify test
```
