#!/bin/bash
image="dragee/back:v1.0.0"
mvn clean
mvn package
echo "[1] 构建"
docker build -t "${image}" .