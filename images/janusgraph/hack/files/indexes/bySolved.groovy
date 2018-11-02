// JanusGraph connects to localhost by default, that is what we want.

:remote connect tinkerpop.server conf/remote.yaml session
:remote console

graph.tx().rollback() //Never create new indexes while a transaction is active

mgmt = graph.openManagement()

if (mgmt.getGraphIndex("bySolved") == null) {
  /*
  * Properties.
  */
  lbl = mgmt.getPropertyKey('__label__')
  type = mgmt.getPropertyKey('__type__')

  solver_datetime = mgmt.getPropertyKey('solver_datetime')
  solver_document_id = mgmt.getPropertyKey('solver_document_id')
  solver_error = mgmt.getPropertyKey('solver_error')
  solver_error = mgmt.getPropertyKey('solver_unsolvable')
  solver_error = mgmt.getPropertyKey('solver_unparsed')

  /*
  * Indexes.
  */
  mgmt.buildIndex('bySolved', Edge.class) \
   .addKey(lbl) \
   .addKey(type) \
   .addKey(solver_datetime) \
   .addKey(solver_document_id) \
   .addKey(solver_error) \
   .addKey(solver_unsolvable) \
   .addKey(solver_unparsed) \
   .buildCompositeIndex()

  // Make changes! \o/
  mgmt.commit()
}
