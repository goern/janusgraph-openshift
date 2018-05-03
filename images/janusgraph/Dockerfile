FROM fabric8/java-centos-openjdk8-jdk

ARG JANUSGRAPH_VERSION=0.2.0-hadoop2

ENV JG_VER=${JANUSGRAPH_VERSION}

LABEL io.k8s.description="JanusGraph Server, backed by Cassandra and ElasticSearch" \
    io.k8s.display-name="JanusGraph ${JG_VER}" \
    io.openshift.expose-services="8182:http" \
    io.openshift.tags="graph,gremlin,janusgraph" \
    architecture=x86_64 \
    name="aicoe/janusgraph" \
    version="2.0.0" \
    release="1" \
    vendor="Red Hat Office of the CTO - AI CoE" \
    license="GPLv3" 

WORKDIR /opt/janusgraph-${JG_VER}

RUN yum install -y unzip && \
    yum clean all -y && \
    curl -L -o /opt/janusgraph.zip https://github.com/JanusGraph/janusgraph/releases/download/v0.2.0/janusgraph-0.2.0-hadoop2.zip && \
    unzip /opt/janusgraph.zip -d /opt/ && \
    rm /opt/janusgraph.zip && \
    mkdir -p /opt/janusgraph-0.2.0-hadoop2/db && \
    chmod 777 -R /opt/janusgraph-0.2.0-hadoop2/db/ && \
    chown 1011:0 -R /opt/janusgraph-0.2.0-hadoop2/ && \
    chmod a+rw /etc/passwd  # needed for entrypoint

USER 1011

ADD entrypoint.sh /opt/janusgraph-0.2.0-hadoop2/
ADD thoth_init.groovy /opt/janusgraph-0.2.0-hadoop2/
ADD thoth.properties /opt/janusgraph-0.2.0-hadoop2/conf/gremlin-server/
ADD gremlin-server.yaml /opt/janusgraph-0.2.0-hadoop2/conf/gremlin-server/
ADD thoth-globals.groovy /opt/janusgraph-0.2.0-hadoop2/

EXPOSE 8182

VOLUME [ "/opt/janusgraph-${JG_VER}/data", "/opt/janusgraph-${JG_VER}/log" ]

ENTRYPOINT ["/opt/janusgraph-0.2.0-hadoop2/entrypoint.sh"]
