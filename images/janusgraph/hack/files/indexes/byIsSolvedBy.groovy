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

solver_datetime = mgmt.getPropertyKey('solver_datetime')
solver_document_id = mgmt.getPropertyKey('solver_document_id')
solver = mgmt.getPropertyKey('solver')
solver_version = mgmt.getPropertyKey('solver_version')

installable = mgmt.getPropertyKey('installable')

/*
 * Indexes.
 */
mgmt.buildIndex('byIsSolvedBy', Edge.class) \
  .addKey(lbl) \
  .addKey(type) \
  .addKey(solver_datetime) \
  .addKey(solver_document_id) \
  .addKey(solver) \
  .addKey(solver_version) \
  .addKey(installable) \
  .buildCompositeIndex()

// Make changes! \o/
mgmt.commit()
