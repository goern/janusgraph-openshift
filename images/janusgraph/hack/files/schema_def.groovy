mgmt = graph.openManagement()

if (mgmt.getVertexLabel('package') == null)
  mgmt.makeVertexLabel('package').make()
if (mgmt.getVertexLabel('software_stack') == null)
  mgmt.makeVertexLabel('software_stack').make()
if (mgmt.getVertexLabel('python_package_version') == null)
  mgmt.makeVertexLabel('python_package_version').make()
if (mgmt.getVertexLabel('rpm_requirement') == null)
  mgmt.makeVertexLabel('rpm_requirement').make()
if (mgmt.getVertexLabel('runtime_environment') == null)
  mgmt.makeVertexLabel('runtime_environment').make()
if (mgmt.getVertexLabel('rpm_package_version') == null)
  mgmt.makeVertexLabel('rpm_package_version').make()

if (mgmt.getEdgeLabel('has_version') == null)
  mgmt.makeEdgeLabel('has_version').make()
if (mgmt.getEdgeLabel('is_part_of') == null)
  mgmt.makeEdgeLabel('is_part_of').make()
if (mgmt.getEdgeLabel('depends_on') == null)
  mgmt.makeEdgeLabel('depends_on').make()
if (mgmt.getEdgeLabel('creates_stack') == null)
  mgmt.makeEdgeLabel('creates_stack').make()
if (mgmt.getEdgeLabel('requires') == null)
  mgmt.makeEdgeLabel('requires').make()
if (mgmt.getEdgeLabel('is_solved_by') == null)
  mgmt.makeEdgeLabel('is_solved_by').make()

if (mgmt.getPropertyKey('ecosystem') == null)
  mgmt.makePropertyKey('ecosystem').dataType(String.class).cardinality(Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('name') == null)
  mgmt.makePropertyKey('name').dataType(String.class).cardinality(Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('version_range') == null)
  mgmt.makePropertyKey('version_range').dataType(String.class).make()

if (mgmt.getPropertyKey('package_name') == null)
  mgmt.makePropertyKey('package_name').dataType(String.class).make()

if (mgmt.getPropertyKey('extras') == null)
  mgmt.makePropertyKey('extras').dataType(String.class).make()

if (mgmt.getPropertyKey('analysis_document_id') == null)
  mgmt.makePropertyKey('analysis_document_id').dataType(String.class).cardinality(Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('analysis_datetime') == null)
  mgmt.makePropertyKey('analysis_datetime').dataType(Integer.class).cardinality(Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('analyzer') == null)
  mgmt.makePropertyKey('analyzer').dataType(String.class).cardinality(Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('analyzer_version') == null)
  mgmt.makePropertyKey('analyzer_version').dataType(String.class).cardinality(Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('version') == null)
  mgmt.makePropertyKey('version').dataType(String.class).cardinality(Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('solver_document_id') == null)
  mgmt.makePropertyKey('solver_document_id').dataType(String.class).make()

if (mgmt.getPropertyKey('solver') == null)
  mgmt.makePropertyKey('solver').dataType(String.class).make()

if (mgmt.getPropertyKey('solver_version') == null)
  mgmt.makePropertyKey('solver_version').dataType(String.class).make()

if (mgmt.getPropertyKey('solver_datetime') == null)
  mgmt.makePropertyKey('solver_datetime').dataType(Integer.class).make()

if (mgmt.getPropertyKey('installable') == null)
  mgmt.makePropertyKey('installable').dataType(Boolean.class).make()

if (mgmt.getPropertyKey('image') == null)
  mgmt.makePropertyKey('image').dataType(String.class).cardinality(Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('release') == null)
  mgmt.makePropertyKey('release').dataType(String.class).cardinality(Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('epoch') == null)
  mgmt.makePropertyKey('epoch').dataType(String.class).cardinality(Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('arch') == null)
  mgmt.makePropertyKey('arch').dataType(String.class).cardinality(Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('src') == null)
  mgmt.makePropertyKey('src').dataType(Boolean.class).cardinality(Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('package_identifier') == null)
  mgmt.makePropertyKey('package_identifier').dataType(String.class).cardinality(Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('__label__') == null)
  mgmt.makePropertyKey('__label__').dataType(String.class).cardinality(Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('__type__') == null)
  mgmt.makePropertyKey('__type__').dataType(String.class).cardinality(Cardinality.SINGLE).make()


mgmt.commit()
