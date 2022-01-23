FROM maven:3.8.4-jdk-11
#FROM maven:3.8.4
COPY . /usr/src/myapp
WORKDIR /usr/src/myapp
CMD ["echo", "!TEST KOŞUMLARI BAŞLAMASI ICIN LÜTFEN mvn verify test KOMUTLARINI YAZINIZ!"]
RUN mvn clean test -DskipTests=true | awk '/Tests/{print}'
