#!/usr/bin/env bash
docker build -t dragee/front:v1.0.0 ./competition-web

cd competition
chmod +x build-docker.sh
bash build-docker.sh