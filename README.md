# Project - Crud Operations client

## Stack 
- Java 17, Maven, War
- Jakarta EE 10 (Faces 4.0, CDI 4.0)
- Widfly 27+
- Prime Faces 14
- PostgreSQL

 ## Build
  mvn clean package -DskipTests
  Obs: If you don't want to skip test, remove '-DskipTests'

## Deploy
  cp target/simple-webapp.war $WILDFLY_HOME/standalone/deployments/
  JAVA_HOME=/path/to/jdk-17 $WILDFLY_HOME/bin/standalone.sh

## Link
  http://localhost:8080/simple-webapp/

## Possible Problems
- Widfly don't work with java 21+, I had to used Java 17
- You should add to Eclipse, "Maven Dependencies" -> "Deployment Assembly"
- PrimeFaces 14 without "Jakarta", you shouldn't use "javax" because it's about old Java EE version
- You should add Facets (JavaServer Faces 2.3, Dynamic Web Module 5.0, Java 11) 
