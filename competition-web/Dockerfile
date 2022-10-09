# build stage
FROM node:14 as build-stage
WORKDIR /app
# Install Quasar
RUN npm install -g @quasar/cli --registry=https://registry.npm.taobao.org
# 添加 key
RUN mkdir -p -m 0600 /root/.ssh
RUN ssh-keyscan -t rsa -p 2222 gitlab.agro-robot.net >> /root/.ssh/known_hosts
# RUN /usr/bin/git ls-remote -h -t ssh://git@gitlab.agro-robot.net:2222/webull/webull-web-api.git
COPY docker/id_rsa /root/.ssh/id_rsa
COPY docker/id_rsa.pub /root/.ssh/id_rsa.pub
RUN chmod 600 /root/.ssh/id_rsa
# RUN cat /root/.ssh/known_hosts
# Install package
COPY .npmrc ./
COPY package*.json ./
RUN npm install
# Build app
COPY . .
RUN quasar build

# production stage
FROM nginx:stable-alpine as production-stage
COPY nginx.conf /etc/nginx/nginx.conf
COPY --from=build-stage /app/dist/spa /app
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
