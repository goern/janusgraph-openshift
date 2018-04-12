:remote connect tinkerpop.server conf/remote.yaml session
:remote console

//graph.tx().rollback()

//mgmt = graph.openManagement()

/*
 * Properties.
 */
//lbl = mgmt.getPropertyKey('__label__')
//type = mgmt.getPropertyKey('__type__')


/*
 * Index.
 */
// TODO: adjust based on schema
//mgmt.buildIndex('bySoftwareStack', Vertex.class) \
//  .addKey(lbl) \
//  .addKey(type) \
//  .addKey(analysis_datetime) \
//  .addKey(analysis_document_id) \
//  .addKey(analyzer_name) \
//  .addKey(analyzer_version) \
//  .buildCompositeIndex()

// Make changes! \o/
//mgmt.commit()

