:remote connect tinkerpop.server conf/remote.yaml session
:remote console

graph.tx().rollback()

mgmt = graph.openManagement()

if (mgmt.getGraphIndex("byDebPackageVersion") == null) {
  /*
  * Properties.
  */
  lbl = mgmt.getPropertyKey('__label__')
  type = mgmt.getPropertyKey('__type__')

  ecosystem = mgmt.getPropertyKey('ecosystem')
  package_name = mgmt.getPropertyKey('package_name')
  package_version = mgmt.getPropertyKey('package_version')

  epoch = mgmt.getPropertyKey('epoch')
  arch = mgmt.getPropertyKey('arch')

  /*
  * Index.
  */
  // Exact match for DebPackageVersion.
  mgmt.buildIndex('byDebPackageVersion', Vertex.class) \
   .addKey(lbl) \
   .addKey(type) \
   .addKey(ecosystem) \
   .addKey(package_name) \
   .addKey(package_version) \
   .addKey(epoch) \
   .addKey(arch) \
   .buildCompositeIndex() \

  // Make changes! \o/
  mgmt.commit()
}
