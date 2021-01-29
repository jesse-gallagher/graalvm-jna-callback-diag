FROM ghcr.io/graalvm/graalvm-ce:java8-21.0.0
# Same behavior with ol8-java8-21.0.0 and java11-21.0.0

RUN \
    curl -L https://mirrors.gigenet.com/apache/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.tar.gz > /tmp/maven.tar.gz && \
	tar xf /tmp/maven.tar.gz -C /opt && \
    gu install native-image

COPY pom.xml /usr/src/app/
RUN /opt/apache-maven-3.6.3/bin/mvn -f /usr/src/app/pom.xml -B de.qaware.maven:go-offline-maven-plugin:1.2.5:resolve-dependencies
COPY src /usr/src/app/src

RUN cd /usr/src/app/src/main/c && \
	cc -o libexamplecallback.so -shared examplecallback.c && \
	mkdir -p ../resources/linux-x86-64 && \
	cp libexamplecallback.so ../resources/linux-x86-64

RUN /opt/apache-maven-3.6.3/bin/mvn -f /usr/src/app/pom.xml clean package

ENTRYPOINT ["/usr/src/app/target/graalvm-test"]