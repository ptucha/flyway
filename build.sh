#!/bin/bash

# Update project version - done
# docker run -it --rm -v "$PWD":/usr/src/flyway -w /usr/src/flyway maven:3-jdk-11 mvn versions:set -DnewVersion=7.10.0-wildfly-fix

# Build
docker run -it --rm -v "$PWD":/usr/src/flyway -w /usr/src/flyway maven:3-jdk-11 mvn install -e
