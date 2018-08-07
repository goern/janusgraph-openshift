:remote connect tinkerpop.server conf/remote.yaml session
:remote console

graph.tx().rollback()

mgmt = graph.openManagement()

indexes = [
  'byCVE',
  'byDependsOn',
  'byEcosystemSolver',
  'byEdge',
  'byIsPartOf',
  'byPackage',
  'byPythonPackageVersion',
  'byRequires',
  'byRPMPackageVersion',
  'byRPMRequirement',
  'byRuntimeEnvironment',
  'bySolved',
]

//Wait for the index to become available
indexes.each { i ->
  index = mgmt.getGraphIndex(i)
  propertykeys = index.getFieldKeys()
  propertykeys.each { j ->
  indexof = propertykeys.findIndexOf{it ==~ j}
  indexcurrentstatus = index.getIndexStatus(propertykeys[indexof])
  if (indexcurrentstatus == SchemaStatus.ENABLED)
   {
    System.err.println "Schema Status in ENABLED"
   }
   else if (indexcurrentstatus == SchemaStatus.INSTALLED)  
   { 
   System.err.println "Schema Status in INSTALLED"
   mgmt.awaitGraphIndexStatus(graph, i).status(SchemaStatus.REGISTERED).call()   
   }
  }
 }

//Reindex the existing data by submitting reindex jobs.
// TODO: once we have more data, we should use MapReduce here.
indexes.each { i ->
  mgmt = graph.openManagement()
  mgmt.updateIndex(mgmt.getGraphIndex(i), SchemaAction.REINDEX)
  mgmt.commit();
}
