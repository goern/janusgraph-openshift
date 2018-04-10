// JanusGraph connects to localhost by default, that is what we want.

:remote connect tinkerpop.server conf/remote.yaml session
:remote console
:load /home/fpokorny/git/thoth-common/janusgraph-openshift/images/janusgraph/hack/files/schema_def.groovy

