// JanusGraph connects to localhost by default, that is what we want.

:remote connect tinkerpop.server conf/remote.yaml session
:remote console
:load /opt/janusgraph-0.2.0-hadoop2/files/schema_def.groovy

