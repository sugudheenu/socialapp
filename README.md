# Social Command Line App



To Run
--------------------------
Make sure you have JDK8.
You can build it using gradle


Run it as jar
-------------
````
$./gradlew installApp
$./build/install/socialapp/bin/socialapp
````

Run it with Docker
------------------
```
$./gradlew distDocker
$docker run -it sugudheenu/socialapp
```

###### Commands
``` 
posting: <user name> -> <message>
reading: <user name>
following: <user name> follows <another user>
wall: <user name> wall
```
