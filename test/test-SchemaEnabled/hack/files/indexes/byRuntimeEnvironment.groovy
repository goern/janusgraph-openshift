:remote connect tinkerpop.server conf/remote.yaml session
:remote console

graph.tx().rollback()

mgmt = graph.openManagement()

if (mgmt.getGraphIndex("byRuntimeEnvironment") == null) {

/*
 * Properties.
 */
     lbl = mgmt.getPropertyKey('__label__')
     type = mgmt.getPropertyKey('__type__')

     runtime_environment_name = mgmt.getPropertyKey('runtime_environment_name')

/*
 * Index.
 */
// Exact match for RuntimeEnviroment.
     mgmt.buildIndex('byRuntimeEnvironment', Vertex.class) \
       .addKey(lbl) \
       .addKey(type) \
       .addKey(runtime_environment_name) \
       .buildCompositeIndex()

// Make changes! \o/
     mgmt.commit()
}
