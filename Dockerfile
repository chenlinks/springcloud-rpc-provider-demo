# 建议生产使用，ref: http://blog.tenxcloud.com/?p=1894
FROM openjdk:8-jre-alpine

USER root

ENV LANG zh_CN.UTF-8
ENV LANG_ALL zh_CN.UTF-8

COPY epxing-demo-web/target/demo.jar /home/
