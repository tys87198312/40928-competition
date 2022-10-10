#!/bin/bash
image="dragee/back:v1.0.0"
/root/apache-maven-3.6.3/bin/mvn clean
/root/apache-maven-3.6.3/bin/mvn package
echo "[1] 构建"
docker build -t "${image}" .

