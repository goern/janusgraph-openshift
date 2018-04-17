#!/usr/bin/env sh

set -ex

# This file is removed once schema and indexes get created.
test ! -f /tmp/janusgraph-openshift-notready
