rm -fr ./target
mvn clean package
mv ./target/*.jar ./target/app.jar

docker-compose up -d
