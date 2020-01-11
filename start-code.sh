#!/bin/bash
cd `dirname $0`

img_mvn="maven:3.3.3-jdk-8"                 # docker image of maven
m2_cache=~/.m2                              # the local maven cache dir
proj_home=$PWD                              # the project root dir
img_output="epxing/epxing-demo"      # output image tag

git pull  # should use git clone https://name:pwd@xxx.git

echo "use docker maven"
docker run --rm \
   -v $m2_cache:/root/.m2 \
   -v $proj_home:/usr/src/mymaven \
   -w /usr/src/mymaven $img_mvn mvn clean package -U

sudo mv $proj_home/epxing-demo-web/target/epxing-demo-web-1.0-SNAPSHOT.jar $proj_home/epxing-demo-web/target/demo.jar # 兼容所有sh脚本
docker build -t $img_output .

mkdir -p $PWD/logs
chmod 777 $PWD/logs

# 删除容器
docker rm -f epxing-demo &> /dev/null

version=`date "+%Y%m%d%H"`

spring_datasource_url=jdbc:mysql://XX.XX.XX.XX:3306/epxing.demo?useUnicode=yes\&characterEncoding=UTF-8\&useSSL=false&allowPublicKeyRetrieval=true\&nullCatalogMeansCurrent=true

# 启动镜像
docker run -d --restart=on-failure:5 --privileged=true \
    --net=host \
    --dns 114.114.114.114 \
    --env 'TZ=Asia/Shanghai' \
    -v $PWD/logs:/home/logs \
    -w /home \
    -v /usr/share/zoneinfo/Asia/Shanghai:/etc/localtime:ro \
    --name epxing-demo epxing/epxing-demo