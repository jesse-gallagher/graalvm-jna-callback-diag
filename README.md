# graalvm-jna-callback-diag

Example code when troubleshooting JNA callbacks in GraalVM native. This repo does not contain
actual working code, and definitely isn't an example of how to do this successfully.

This project is intended to show a simplified version of trouble I've been running into using
an existing, large third-party C library with callbacks. Most of the calls using JNA in that
library work, but any with callbacks leading to a hard crash.

### graalvm-native-callback-basic

The `graalvm-native-callback-basic` projects demonstrates a small callback library and has two scripts
to run it. Both of these use the `ghcr.io/graalvm/graalvm-ce:java8-21.0.0` Docker image.

- `run-java.sh` builds and runs the project in a Docker container using the provided Java runtime
- `run-native-image.sh` builds and runs using the GraalVM native image

The expected output, as seen from `run-java.sh` is:

```
Loaded into Main
Calling the non-callback function: 9
Callback called with 3
Finished execution normally
```

Where "callback called with 3" comes from a JNA callback from the C library.

The native image, as seen from `run-native-image.sh`, stops execution early with no exception:

```
Loaded into Main
Calling the non-callback function: 9
```