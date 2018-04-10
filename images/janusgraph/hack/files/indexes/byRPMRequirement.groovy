:remote connect tinkerpop.server conf/remote.yaml session
:remote console

graph.tx().rollback()

mgmt = graph.openManagement()

/*
 * Properties.
 */
lbl = mgmt.getPropertyKey('__label__')
type = mgmt.getPropertyKey('__type__')

name = mgmt.getPropertyKey('name')

/*
 * Index.
 */
// Exact match for RPMRequirement.
mgmt.buildIndex('byRPMRequirement', Vertex.class) \
  .addKey(lbl) \
  .addKey(type) \
  .addKey(name) \
  .buildCompositeIndex()

// Make changes! \o/
mgmt.commit()
