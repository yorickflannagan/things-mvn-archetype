rm -rf mvnthings
mvn archetype:generate -DgroupId=com.teste -DartifactId=mvnthings -DarchetypeArtifactId=things-app-archetype -DarchetypeGroupId=org.crypthing -DarchetypeCatalog=local -DinteractiveMode=false
cd mvnthings
git init
git add .
git commit -a -m "First commit"
mvn package
cd ..

