#!/bin/bash

# Make sure we mark this container as ready once we have schema and indexes in place.
touch /tmp/janusgraph-openshift-notready

BIN=/opt/janusgraph-0.2.0-hadoop2/bin
FILES=/opt/janusgraph-0.2.0-hadoop2/files
$BIN/janusgraph.sh start -v

# Prepare schema and indexes.
echo "Preparing schema..." 2>&1
$BIN/gremlin.sh -e $FILES/schema.groovy

echo "Preparing indexes..." 2>&1
$BIN/gremlin.sh -e $FILES/indexes.groovy

echo "Container is ready now" 2>&1
rm /tmp/janusgraph-openshift-notready

while :; do
  sleep 300
done
