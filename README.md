# quarkus-sample project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```
./gradlew quarkusDev
```

Once started, you can request the provided endpoint:
```
$ curl -w "\n" http://localhost:8080/hello
hello
```

## Packaging and running the application

The application can be packaged using `./gradlew quarkusBuild`.
It produces the `quarkus-sample-1.0-runner.jar` file in the `build` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `build/lib` directory.

The application is now runnable using `java -jar build/quarkus-sample-1.0-runner.jar`.

If you want to build an _über-jar_, just add the `--uber-jar` option to the command line:
```
./gradlew quarkusBuild --uber-jar
```

## Creating a native executable

To create and run native executable, try the [native-image](https://github.com/domaframework/quarkus-sample/tree/native-image) branch in this repository.

See also [this paragraph in the branch](https://github.com/domaframework/quarkus-sample/tree/native-image#creating-a-native-executable).
