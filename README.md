# JanusGraph on OpenShift

OpenShift enablement glue for JanusGraph Server

[JanusGraph](http://janusgraph.org/) is a highly scalable graph database optimized for storing and querying large graphs with billions of vertices and edges distributed across a multi-machine cluster. JanusGraph is a transactional database that can support thousands of concurrent users, complex traversals, and analytic graph queries.

[OpenShift](https://openshift.org) is a distribution of Kubernetes optimized for continuous application development and multi-tenant deployment. OpenShift adds developer and operations-centric tools on top of Kubernetes to enable rapid application development, easy deployment and scaling, and long-term lifecycle maintenance for small and large teams.

This project is about deploying [JanusGraph Server](http://docs.janusgraph.org/latest/server.html) on top of the OpenShift platform.

## Deploying

Simply process the template: `oc process -f template.yaml | oc create -f -` (you need to be logged in, right?!)

## Copyright

Please see the file LICENSE, it covers all the files in this repository, not the software running in the container or stored in the container image.
