#!/bin/sh
docker rm -f podbox-template
set -e

./gradlew clean build
docker build -t podbox/spring-boot-template src/docker/

docker run --cap-drop ALL --rm -v `pwd`/build/libs/:/libs/ -e ENV=prod --name podbox-template -t podbox/spring-boot-template
