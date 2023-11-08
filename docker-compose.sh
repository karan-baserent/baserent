#!/bin/bash
#./gradlew clean build dockerBuildNative
./gradlew --rerun-tasks clean build dockerBuild
docker-compose build --no-cache
docker-compose up --force-recreate