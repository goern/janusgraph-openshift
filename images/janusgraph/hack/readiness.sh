#!/usr/bin/env sh

set -ex

nc -z localhost 8182

# This file is removed once schema and indexes get created.
test ! -f /tmp/janusgraph-openshift-notready
