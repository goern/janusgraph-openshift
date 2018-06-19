:remote connect tinkerpop.server conf/remote.yaml session
:remote console

graph.tx().rollback()

mgmt = graph.openManagement()

if (mgmt.getGraphIndex("byRPMPackageVersion") == null) {
  /*
  * Properties.
  */
  lbl = mgmt.getPropertyKey('__label__')
  type = mgmt.getPropertyKey('__type__')

  ecosystem = mgmt.getPropertyKey('ecosystem')
  package_name = mgmt.getPropertyKey('package_name')
  package_version = mgmt.getPropertyKey('package_version')

  release = mgmt.getPropertyKey('release')
  epoch = mgmt.getPropertyKey('epoch')
  arch = mgmt.getPropertyKey('arch')
  src = mgmt.getPropertyKey('src')
  package_identifier = mgmt.getPropertyKey('package_identifier')

  /*
  * Index.
  */
  // Exact match for RPMPackageVersion.
  mgmt.buildIndex('byRPMPackageVersion', Vertex.class) \
   .addKey(lbl) \
   .addKey(type) \
   .addKey(ecosystem) \
   .addKey(package_name) \
   .addKey(package_version) \
   .addKey(release) \
   .addKey(epoch) \
   .addKey(arch) \
   .addKey(src) \
   .addKey(package_identifier) \
   .buildCompositeIndex() \

  // Make changes! \o/
  mgmt.commit()
}
