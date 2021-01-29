#!/usr/bin/env bash

set -e

cd "$(dirname "${BASH_SOURCE[0]}")"

docker build -t jna-callback .

docker run \
	-it \
	--rm \
	--entrypoint "java" \
	jna-callback \
	-cp /usr/src/app/target/graalvm-native-callback-basic-0.0.1-SNAPSHOT.jar com.example.graalvm.callback.Main