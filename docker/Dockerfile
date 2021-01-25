FROM ubuntu:latest
ARG LOOM_FILE=openjdk-17-loom+6-225_linux-x64_bin.tar.gz

# Install preconditions
RUN apt-get update
RUN apt-get install -y wget



# Install JDK17
RUN mkdir -p /usr/lib/jvm/
RUN wget -P /usr/lib/jvm/ https://download.java.net/java/early_access/loom/6/${LOOM_FILE} \
    && tar -zxvf /usr/lib/jvm/${LOOM_FILE} -C /usr/lib/jvm/ \
    && rm /usr/lib/jvm/${LOOM_FILE}

# Add Java to classpath
ENV PATH=/usr/lib/jvm/jdk-17/bin:$PATH

# Test installation
RUN java --version
COPY ./docker/HelloWorld.java /tmp/
RUN javac /tmp/HelloWorld.java
RUN java -cp /tmp/. HelloWorld

# Create mount direcotry
RUN mkdir -p /tmp/workshop/
VOLUME /tmp/workshop/
WORKDIR /tmp/workshop/