// JanusGraph connects to localhost by default, that is what we want.

:remote connect tinkerpop.server conf/remote.yaml session
:remote console

graph.tx().rollback() //Never create new indexes while a transaction is active

mgmt = graph.openManagement()

if (mgmt.getGraphIndex("byEcosystemSolver") == null) {
   /*
   * Properties.
   */
  lbl = mgmt.getPropertyKey('__label__')
  type = mgmt.getPropertyKey('__type__')

  solver_name = mgmt.getPropertyKey('solver_name')
  solver_version = mgmt.getPropertyKey('solver_version')

  // No property edges match.
  mgmt.buildIndex('byEcosystemSolver', Vertex.class) \
    .addKey(lbl) \
    .addKey(type) \
    .addKey(solver_name) \
    .addKey(solver_version) \
    .buildCompositeIndex()

// Make changes! \o/
  mgmt.commit()
}
