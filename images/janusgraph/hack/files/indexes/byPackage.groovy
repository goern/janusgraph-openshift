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

/*
 * Indexes.
 */

// Exact match for a Package search.
mgmt.buildIndex('byPackage', Vertex.class) \
  .addKey(lbl) \
  .addKey(type) \
  .addKey(ecosystem) \
  .addKey(name) \
  .buildCompositeIndex()


// Make changes! \o/
mgmt.commit()
