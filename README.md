# dockerizing
Several tests using Docker:

1. **cmd**
2. **entrypoint**
3. **entrypoint2**
4. **entrypoint3**
5. **spring-boot/graylog-app:** Integrates a simple Spring Boot App with Graylog.
  1. Create the application image: `mvn package docker:build`
  2. Download and start Graylog: 
     `$ docker pull graylog2/allinone`
     `$ docker run -t -p 9000:9000 -p 12201:12201 -p 12201:12201/udp graylog2/allinone`
  3. Wait until Graylog is up and then start the app: `docker run -p 8080:8080 -t codependent/graylog-app:0.0.1-SNAPSHOT`
