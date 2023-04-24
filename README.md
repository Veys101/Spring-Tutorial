# Spring-Tutorial
This repository involves Spring Example Project

## Commands
- To clean and build project
```
mvn clean package
```

- To run project
```
java -jar .\target\{artifactId}{version}-SNAPSHOT.jar
java -jar .\target\{artifactId}{version}-SNAPSHOT-jar-with-dependencies.jar
```

- To create maven project
```
mvn archetype:generate -DgroupId="com.app.tutorial" -DartifactId={artifactId} -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```
