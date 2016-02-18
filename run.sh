#!/bin/sh

docker rm -f podbox-template
set -e

./gradlew clean build
docker build -t podbox/spring-boot-template src/docker/

BUILD_LIBS=`pwd`/build/libs/
docker run -v $BUILD_LIBS:/libs/ -e ENV=prod --name podbox-template -t podbox/spring-boot-template
