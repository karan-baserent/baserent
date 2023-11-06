#!/bin/bash
#./gradlew clean build dockerBuildNative
./gradlew clean build dockerBuild
docker-compose build --no-cache
docker-compose --env-file '.env-docker-compose' up --force-recreate