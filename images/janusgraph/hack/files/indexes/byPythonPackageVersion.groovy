// JanusGraph connects to localhost by default, that is what we want.

:remote connect tinkerpop.server conf/remote.yaml session
:remote console

graph.tx().rollback() //Never create new indexes while a transaction is active

mgmt = graph.openManagement()


/*
 * Properties.
 */
lbl = mgmt.getPropertyKey('__label__')
type = mgmt.getPropertyKey('__type__')

ecosystem = mgmt.getPropertyKey('ecosystem')
name = mgmt.getPropertyKey('name')
version = mgmt.getPropertyKey('version')

/*
 * Indexes.
 */
//Exact match for PythonPackageVersion.
mgmt.buildIndex('byPythonPackageVersion', Vertex.class) \
  .addKey(lbl) \
  .addKey(type) \
  .addKey(ecosystem) \
  .addKey(name) \
  .addKey(version) \
  .buildCompositeIndex()


// Make changes! \o/
mgmt.commit()
