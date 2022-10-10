#!/bin/bash
version=$1
imageName=$2
echo "版本号为：${version}, 镜像名称为：${imageName}"
image="docker.agro-robot.net:5000/${imageName}"
if [ "$version" != "" ]; then
  image="$image:$version"
fi
  mvn clean
  mvn package
  echo "[1] 构建"
  docker build -t "${image}" .
  echo "[2] 推送"
  docker push "${image}"false