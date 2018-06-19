// JanusGraph connects to localhost by default, that is what we want.

:remote connect tinkerpop.server conf/remote.yaml session
:remote console

graph.tx().rollback() //Never create new indexes while a transaction is active

mgmt = graph.openManagement()

if (mgmt.getGraphIndex("byIsPartOf") == null) {
  /*
  * Properties.
  */
  lbl = mgmt.getPropertyKey('__label__')
  type = mgmt.getPropertyKey('__type__')

  analysis_datetime = mgmt.getPropertyKey('analysis_datetime')
  analysis_document_id = mgmt.getPropertyKey('analysis_document_id')
  analyzer_name = mgmt.getPropertyKey('analyzer_name')
  analyzer_version = mgmt.getPropertyKey('analyzer_version')

  /*
  * Indexes.
  */
  mgmt.buildIndex('byIsPartOf', Edge.class) \
   .addKey(lbl) \
   .addKey(type) \
   .addKey(analysis_datetime) \
   .addKey(analysis_document_id) \
   .addKey(analyzer_name) \
   .addKey(analyzer_version) \
   .buildCompositeIndex()

  // Make changes! \o/
  mgmt.commit()
}
