:remote connect tinkerpop.server conf/remote.yaml session
:remote console

graph.tx().rollback()

mgmt = graph.openManagement()

if (mgmt.getGraphIndex("byRPMRequirement") == null) {

/*
 * Properties.
 */
     lbl = mgmt.getPropertyKey('__label__')
     type = mgmt.getPropertyKey('__type__')

     rpm_requirement_name = mgmt.getPropertyKey('rpm_requirement_name')

/*
 * Index.
 */
// Exact match for RPMRequirement.
     mgmt.buildIndex('byRPMRequirement', Vertex.class) \
       .addKey(lbl) \
       .addKey(type) \
       .addKey(rpm_requirement_name) \
       .buildCompositeIndex()

// Make changes! \o/
     mgmt.commit()

}
