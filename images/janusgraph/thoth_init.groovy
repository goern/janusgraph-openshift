//:remote connect tinkerpop.server conf/remote.yaml session
//:remote console

graph = JanusGraphFactory.open('conf/gremlin-server/thoth.properties')

mgmt = graph.openManagement()

indexes = [
  'byDependsOn',
  'byEcosystemSolver',
  'byEdge',
  'byIsPartOf',
  'byPackage',
  'byPythonPackageVersion',
  'byRequires',
  'byRPMPackageVersion',
  'byRPMRequirement',
  'byRuntimeEnvironment',
  'bySolved'
]

mgmt.makeVertexLabel('package').make()
mgmt.makeVertexLabel('software_stack').make()
mgmt.makeVertexLabel('python_package_version').make()
mgmt.makeVertexLabel('rpm_requirement').make()
mgmt.makeVertexLabel('runtime_environment').make()
mgmt.makeVertexLabel('rpm_package_version').make()
mgmt.makeVertexLabel('ecosystem_solver').make()

mgmt.makeEdgeLabel('has_version').make()
mgmt.makeEdgeLabel('is_part_of').make()
mgmt.makeEdgeLabel('depends_on').make()
mgmt.makeEdgeLabel('creates_stack').make()
mgmt.makeEdgeLabel('requires').make()
mgmt.makeEdgeLabel('solved').make()
mgmt.makeEdgeLabel('runs_in').make()

mgmt.makePropertyKey('ecosystem').dataType(String.class).cardinality(Cardinality.SINGLE).make()
mgmt.makePropertyKey('rpm_requirement_name').dataType(String.class).cardinality(Cardinality.SINGLE).make()
mgmt.makePropertyKey('version_range').dataType(String.class).make()
mgmt.makePropertyKey('package_name').dataType(String.class).make()
mgmt.makePropertyKey('extras').dataType(String.class).make()
mgmt.makePropertyKey('analysis_document_id').dataType(String.class).cardinality(Cardinality.SINGLE).make()
mgmt.makePropertyKey('analysis_datetime').dataType(Integer.class).cardinality(Cardinality.SINGLE).make()
mgmt.makePropertyKey('analyzer_name').dataType(String.class).cardinality(Cardinality.SINGLE).make()
mgmt.makePropertyKey('analyzer_version').dataType(String.class).cardinality(Cardinality.SINGLE).make()
mgmt.makePropertyKey('package_version').dataType(String.class).cardinality(Cardinality.SINGLE).make()
mgmt.makePropertyKey('solver_document_id').dataType(String.class).make()
mgmt.makePropertyKey('solver_name').dataType(String.class).make()
mgmt.makePropertyKey('solver_version').dataType(String.class).make()
mgmt.makePropertyKey('solver_datetime').dataType(Integer.class).make()
mgmt.makePropertyKey('solver_error').dataType(Boolean.class).make()
mgmt.makePropertyKey('runtime_environment_name').dataType(String.class).cardinality(Cardinality.SINGLE).make()
mgmt.makePropertyKey('release').dataType(String.class).cardinality(Cardinality.SINGLE).make()
mgmt.makePropertyKey('epoch').dataType(String.class).cardinality(Cardinality.SINGLE).make()
mgmt.makePropertyKey('arch').dataType(String.class).cardinality(Cardinality.SINGLE).make()
mgmt.makePropertyKey('src').dataType(Boolean.class).cardinality(Cardinality.SINGLE).make()
mgmt.makePropertyKey('package_identifier').dataType(String.class).cardinality(Cardinality.SINGLE).make()
mgmt.makePropertyKey('__label__').dataType(String.class).cardinality(Cardinality.SINGLE).make()
mgmt.makePropertyKey('__type__').dataType(String.class).cardinality(Cardinality.SINGLE).make()

graph.tx().rollback()

lbl = mgmt.getPropertyKey('__label__')
type = mgmt.getPropertyKey('__type__')
version_range = mgmt.getPropertyKey('version_range')
package_name = mgmt.getPropertyKey('package_name')
extras = mgmt.getPropertyKey('extras')
solver_name = mgmt.getPropertyKey('solver_name')
solver_version = mgmt.getPropertyKey('solver_version')
solver_datetime = mgmt.getPropertyKey('solver_datetime')
solver_document_id = mgmt.getPropertyKey('solver_document_id')
solver_error = mgmt.getPropertyKey('solver_error')
analysis_datetime = mgmt.getPropertyKey('analysis_datetime')
analysis_document_id = mgmt.getPropertyKey('analysis_document_id')
analyzer_name = mgmt.getPropertyKey('analyzer_name')
analyzer_version = mgmt.getPropertyKey('analyzer_version')
ecosystem = mgmt.getPropertyKey('ecosystem')
package_name = mgmt.getPropertyKey('package_name')
package_version = mgmt.getPropertyKey('package_version')
release = mgmt.getPropertyKey('release')
epoch = mgmt.getPropertyKey('epoch')
arch = mgmt.getPropertyKey('arch')
src = mgmt.getPropertyKey('src')
package_identifier = mgmt.getPropertyKey('package_identifier')
rpm_requirement_name = mgmt.getPropertyKey('rpm_requirement_name')
analysis_datetime = mgmt.getPropertyKey('analysis_datetime')
analysis_document_id = mgmt.getPropertyKey('analysis_document_id')
analyzer_name = mgmt.getPropertyKey('analyzer_name')
analyzer_version = mgmt.getPropertyKey('analyzer_version')
runtime_environment_name = mgmt.getPropertyKey('runtime_environment_name')


mgmt.buildIndex('byDependsOn', Edge.class) \
  .addKey(lbl) \
  .addKey(type) \
  .addKey(version_range) \
  .addKey(package_name) \
  .addKey(extras) \
  .buildCompositeIndex()

mgmt.buildIndex('byEcosystemSolver', Vertex.class) \
  .addKey(lbl) \
  .addKey(type) \
  .addKey(solver_name) \
  .addKey(solver_version) \
  .buildCompositeIndex()

mgmt.buildIndex('byEdge', Edge.class) \
  .addKey(lbl) \
  .addKey(type) \
  .buildCompositeIndex()

mgmt.buildIndex('byIsPartOf', Edge.class) \
  .addKey(lbl) \
  .addKey(type) \
  .addKey(analysis_datetime) \
  .addKey(analysis_document_id) \
  .addKey(analyzer_name) \
  .addKey(analyzer_version) \
  .buildCompositeIndex()

mgmt.buildIndex('byPackage', Vertex.class) \
  .addKey(lbl) \
  .addKey(type) \
  .addKey(ecosystem) \
  .addKey(package_name) \
  .buildCompositeIndex()

mgmt.buildIndex('byPythonPackageVersion', Vertex.class) \
  .addKey(lbl) \
  .addKey(type) \
  .addKey(ecosystem) \
  .addKey(package_name) \
  .addKey(package_version) \
  .buildCompositeIndex()

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
  .buildCompositeIndex()

mgmt.buildIndex('byRPMRequirement', Vertex.class) \
  .addKey(lbl) \
  .addKey(type) \
  .addKey(rpm_requirement_name) \
  .buildCompositeIndex()

mgmt.buildIndex('byRequires', Edge.class) \
  .addKey(lbl) \
  .addKey(type) \
  .addKey(analysis_datetime) \
  .addKey(analysis_document_id) \
  .addKey(analyzer_name) \
  .addKey(analyzer_version) \
  .buildCompositeIndex()

mgmt.buildIndex('byRuntimeEnvironment', Vertex.class) \
  .addKey(lbl) \
  .addKey(type) \
  .addKey(runtime_environment_name) \
  .buildCompositeIndex()

mgmt.buildIndex('bySolved', Edge.class) \
  .addKey(lbl) \
  .addKey(type) \
  .addKey(solver_datetime) \
  .addKey(solver_document_id) \
  .addKey(solver_error) \
  .buildCompositeIndex()

mgmt.commit()

indexes.each { i ->
  mgmt.awaitGraphIndexStatus(graph, i).status(SchemaStatus.ENABLED).call()
}