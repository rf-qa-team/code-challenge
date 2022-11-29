FROM adoptopenjdk/openjdk16

WORKDIR /app
COPY . /app
RUN chmod +x gradlew
RUN  ./gradlew --refresh-dependencies --no-daemon
RUN  ./gradlew build --exclude-task test --no-daemon
CMD while true; do sleep 1000; done