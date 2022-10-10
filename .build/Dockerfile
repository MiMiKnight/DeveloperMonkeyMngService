# 基础镜像
FROM docker.io/library/alpine:3.16.2

# 变量

# 容器运行用户及用户组
USER service:service

# 环境变量
ENV

# 添加内容
ADD

# 更新Alpine的软件源为阿里云
RUN echo http://mirrors.aliyun.com/alpine/v3.10/main/ > /etc/apk/repositories && \
    echo http://mirrors.aliyun.com/alpine/v3.10/community/ >> /etc/apk/repositories
RUN apk update && apk upgrade

# 添加用户
RUN useradd -U -m "运行业务用户" -s /sbin/nologin/ service

# 工作目录
WORKDIR /opt/cloud

# 容器卷
VOLUME /

# 默认暴露的端口
EXPOSE 8443

# 容器运行执行的命令
CMD

