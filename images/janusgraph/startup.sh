#!/bin/bash

BIN=/opt/janusgraph-0.2.0-hadoop2/bin
$BIN/janusgraph.sh start -v

while :; do
  sleep 300
done
