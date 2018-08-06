// JanusGraph connects to localhost by default, that is what we want.

:remote connect tinkerpop.server conf/remote.yaml session
:remote console

graph.tx().rollback() //Never create new indexes while a transaction is active

mgmt = graph.openManagement()

if (mgmt.getGraphIndex("byCVE") == null) {
  /*
  * Properties.
  */
  lbl = mgmt.getPropertyKey('__label__')
  type = mgmt.getPropertyKey('__type__')
  version_range = mgmt.getPropertyKey('version_range')
  advisory = mgmt.getPropertyKey('advisory')
  cve_name = mgmt.getPropertyKey('cve_name')
  cve_id = mgmt.getPropertyKey('cve_id')

  // No property edges match.
  mgmt.buildIndex('byCVE', Edge.class) \
   .addKey(lbl) \
   .addKey(type) \
   .addKey(version_range) \
   .addKey(advisory) \
   .addKey(cve_name) \
   .addKey(cve_id) \
   .buildCompositeIndex()

  // Make changes! \o/
  mgmt.commit()
}

