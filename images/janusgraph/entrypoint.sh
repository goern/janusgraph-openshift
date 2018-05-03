#!/bin/bash

# Adopted from openshift-spark by radanalytics team:
#  https://github.com/radanalyticsio/openshift-spark

# Check whether there is a passwd entry for the container UID
myuid=$(id -u)
mygid=$(id -g)
uidentry=$(getent passwd $myuid)

# If there is no passwd entry for the container UID, attempt to create one
if [ -z "$uidentry" ] ; then
    if [ -w /etc/passwd ] ; then
        echo "$myuid:x:$myuid:$mygid:anonymous uid:$SPARK_HOME:/bin/false" >> /etc/passwd
    else
        echo "Container ENTRYPOINT failed to add passwd entry for anonymous UID"
	exit 1
    fi
fi

export PATH="$PATH:/opt/janusgraph-0.2.0-hadoop2/bin"

gremlin.sh --quiet --execute=/opt/janusgraph-0.2.0-hadoop2/thoth_init.groovy 
gremlin-server.sh 
