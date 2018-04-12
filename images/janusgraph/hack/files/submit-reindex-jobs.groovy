:remote connect tinkerpop.server conf/remote.yaml session
:remote console

graph.tx().rollback()

mgmt = graph.openManagement()

indexes = [
  'byEdge',
  'bySolved',
  'bySolver',
  'byPackage',
  'byPythonPackageVersion',
  'byRequires',
  'byRPMPackageVersion',
  'byRPMRequirement',
  'byRuntimeEnvironment',
  'bySoftwareStack'
]

//Wait for the index to become available
indexes.each { i ->
  mgmt.awaitGraphIndexStatus(graph, i).status(SchemaStatus.REGISTERED).call();
}

//Reindex the existing data by submitting reindex jobs.
// TODO: once we have more data, we should use MapReduce here.
indexes.each { i ->
  mgmt = graph.openManagement()
  mgmt.updateIndex(mgmt.getGraphIndex(i), SchemaAction.REINDEX)
  mgmt.commit();
}
