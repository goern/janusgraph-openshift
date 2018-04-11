#!/bin/bash

# Make sure we mark this container as ready once we have schema and indexes in place.
set -ex

touch /tmp/janusgraph-openshift-notready

BIN=/opt/janusgraph-0.2.0-hadoop2/bin
FILES=/opt/janusgraph-0.2.0-hadoop2/files
$BIN/janusgraph.sh start -v
#$BIN/janusgraph.sh start

echo "Preparing schema..." 2>&1
$BIN/gremlin.sh -e $FILES/schema.groovy

if [ -n "$JANUSGRAPH_USE_INDEXES" ]; then
	echo "Preparing indexes..." 2>&1

	for file in $FILES/indexes/*.groovy; do
		$BIN/gremlin.sh -e $file
	done

	$BIN/gremlin.sh -e $FILES/submit-reindex-jobs.groovy

	echo "Waiting for indexes to be propagated to cluster..." 2>&1
	sleep 120
	$BIN/gremlin.sh -e $FILES/wait-for-indexes.yaml
fi


echo "Container is ready now" 2>&1
rm /tmp/janusgraph-openshift-notready

while :; do
  sleep 300
done
