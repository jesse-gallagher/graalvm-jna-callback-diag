#!/usr/bin/env bash

set -e

cd "$(dirname "${BASH_SOURCE[0]}")"

docker build -t jna-callback .

docker run \
	-it \
	--rm \
	jna-callback