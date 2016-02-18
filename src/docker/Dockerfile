FROM podbox/java8

WORKDIR /libs/
EXPOSE 8080 9875

CMD java                        \
  -Xmx64m                       \
  -Xss256k                      \
  -server                       \
  -XX:+UseCompressedOops        \
  -Dfile.encoding=UTF-8         \
  -Dspring.profiles.active=$ENV \
  -jar podbox-template.jar
