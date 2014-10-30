# Custom model for tooling API

This project demonstrates the use of a custom model for querying project details with the tooling API.

## Project layout

This project consists of three components:

1. A multi-project build that provides the custom model via a plugin. The project defines two subprojects: `model` and `plugin`. `model` represents the custom model representation. `plugin` implements a Gradle plugin that registers the custom model with the tooling API model registry and populates it.
2. The subdirectory `invocation` provides a build script that uses the tooling API to query information from a project.
3. A sample `build.gradle` file in the subdirectory `invocation/sample` that is used to query the information.

## Building and publishing the plugin

From the root project you can build and publish the plugin by running the command `./gradlew build publish`. The command will build all subprojects, assemble their artifacts and publish them to a Maven-based repository in the directory `repo`.

## Invoking the tooling API

As the next step we can execute the build that uses the custom model registered by the plugin with the tooling API. Navigate to the subdirectory `invocation` and execute the command `../gradlew run`. Executing the command will run a build for the `build.gradle` file in the directory named `sample` on the root level of the repository.


