// JanusGraph connects to localhost by default, that is what we want.

:remote connect tinkerpop.server conf/remote.yaml session
:remote console

graph.tx().rollback() //Never create new indexes while a transaction is active

mgmt = graph.openManagement()

if (mgmt.getGraphIndex("byPythonPackageIndex") == null) {
  /*
  * Properties.
  */
  lbl = mgmt.getPropertyKey('__label__')
  type = mgmt.getPropertyKey('__type__')

  url = mgmt.getPropertyKey('url')
  warehouse_api_url = mgmt.getPropertyKey('warehouse_api_url')
  verify_ssl = mgmt.getPropertyKey('verify_ssl')
  warehouse = mgmt.getPropertyKey('warehouse')

  /*
  * Indexes.
  */
  //Exact match for PythonPackageIndex.
  mgmt.buildIndex('byPythonPackageIndex', Vertex.class) \
   .addKey(lbl) \
   .addKey(type) \
   .addKey(url) \
   .addKey(warehouse_api_url) \
   .addKey(verify_ssl) \
   .addKey(warehouse) \
   .buildCompositeIndex()

  // Make changes! \o/
  mgmt.commit()
}
