:remote connect tinkerpop.server conf/remote.yaml session
:remote console

graph.tx().rollback()

mgmt = graph.openManagement()

/*
 * Properties.
 */
lbl = mgmt.getPropertyKey('__label__')
type = mgmt.getPropertyKey('__type__')

analysis_datetime = mgmt.getPropertyKey('analysis_datetime')
analysis_document_id = mgmt.getPropertyKey('analysis_document_id')
analyzer = mgmt.getPropertyKey('analyzer')
analyzer_version = mgmt.getPropertyKey('analyzer_version')

/*
 * Index.
 */
// Exact match for Requires.
mgmt.buildIndex('byRequires', Edge.class) \
  .addKey(lbl) \
  .addKey(type) \
  .addKey(analysis_datetime) \
  .addKey(analysis_document_id) \
  .addKey(analyzer) \
  .addKey(analyzer_version) \
  .buildCompositeIndex()

// Make changes! \o/
mgmt.commit()
