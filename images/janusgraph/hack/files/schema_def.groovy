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
if (mgmt.getVertexLabel('deb_package_version') == null)
  mgmt.makeVertexLabel('deb_package_version').make()
if (mgmt.getVertexLabel('rpm_package_version') == null)
  mgmt.makeVertexLabel('rpm_package_version').make()
if (mgmt.getVertexLabel('ecosystem_solver') == null)
  mgmt.makeVertexLabel('ecosystem_solver').make()
if (mgmt.getVertexLabel('software_stack_observation') == null)
  mgmt.makeVertexLabel('software_stack_observation').make()
if (mgmt.getVertexLabel('hardware_information') == null)
  mgmt.makeVertexLabel('hardware_information').make()
if (mgmt.getVertexLabel('cve') == null)
  mgmt.makeVertexLabel('cve').make()

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
if (mgmt.getEdgeLabel('solved') == null)
  mgmt.makeEdgeLabel('solved').make()
if (mgmt.getEdgeLabel('runs_in') == null)
  mgmt.makeEdgeLabel('runs_in').make()
if (mgmt.getEdgeLabel('has_vulnerability') == null)
  mgmt.makeEdgeLabel('has_vulnerability').make()
if (mgmt.getEdgeLabel('deb_replaces') == null)
  mgmt.makeEdgeLabel('deb_replaces').make()
if (mgmt.getEdgeLabel('deb_depends') == null)
  mgmt.makeEdgeLabel('deb_depends').make()
if (mgmt.getEdgeLabel('deb_pre_depends') == null)
  mgmt.makeEdgeLabel('deb_pre_depends').make()
if (mgmt.getEdgeLabel('observation_document_id') == null)
  mgmt.makeEdgeLabel('observation_document_id').make()

if (mgmt.getPropertyKey('ecosystem') == null)
  mgmt.makePropertyKey('ecosystem').dataType(String.class).cardinality(Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('rpm_requirement_name') == null)
  mgmt.makePropertyKey('rpm_requirement_name').dataType(String.class).cardinality(Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('version_range') == null)
  mgmt.makePropertyKey('version_range').dataType(String.class).make()

if (mgmt.getPropertyKey('package_name') == null)
  mgmt.makePropertyKey('package_name').dataType(String.class).make()

if (mgmt.getPropertyKey('index') == null)
  mgmt.makePropertyKey('index').dataType(String.class).cardinality(Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('extras') == null)
  mgmt.makePropertyKey('extras').dataType(String.class).make()

if (mgmt.getPropertyKey('analysis_document_id') == null)
  mgmt.makePropertyKey('analysis_document_id').dataType(String.class).cardinality(Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('analysis_datetime') == null)
  mgmt.makePropertyKey('analysis_datetime').dataType(Integer.class).cardinality(Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('analyzer_name') == null)
  mgmt.makePropertyKey('analyzer_name').dataType(String.class).cardinality(Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('analyzer_version') == null)
  mgmt.makePropertyKey('analyzer_version').dataType(String.class).cardinality(Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('package_version') == null)
  mgmt.makePropertyKey('package_version').dataType(String.class).cardinality(Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('solver_document_id') == null)
  mgmt.makePropertyKey('solver_document_id').dataType(String.class).make()

if (mgmt.getPropertyKey('solver_name') == null)
  mgmt.makePropertyKey('solver_name').dataType(String.class).make()

if (mgmt.getPropertyKey('solver_version') == null)
  mgmt.makePropertyKey('solver_version').dataType(String.class).make()

if (mgmt.getPropertyKey('solver_datetime') == null)
  mgmt.makePropertyKey('solver_datetime').dataType(Integer.class).make()

if (mgmt.getPropertyKey('solver_error') == null)
  mgmt.makePropertyKey('solver_error').dataType(Boolean.class).make()

if (mgmt.getPropertyKey('solver_unsolvable') == null)
  mgmt.makePropertyKey('solver_unsolvable').dataType(Boolean.class).make()

if (mgmt.getPropertyKey('runtime_environment_name') == null)
  mgmt.makePropertyKey('runtime_environment_name').dataType(String.class).cardinality(Cardinality.SINGLE).make()

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

if (mgmt.getPropertyKey('advisory') == null)
  mgmt.makePropertyKey('advisory').dataType(String.class).cardinality(Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('cve_name') == null)
  mgmt.makePropertyKey('cve_name').dataType(String.class).cardinality(Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('cve_id') == null)
  mgmt.makePropertyKey('cve_id').dataType(String.class).cardinality(Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('document_id') == null)
  mgmt.makePropertyKey('document_id').dataType(String.class).cardinality(Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('installable') == null)
  mgmt.makePropertyKey('installable').dataType(Boolean.class).cardinality(Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('performance_index') == null)
  mgmt.makePropertyKey('performance_index').dataType(Float.class).cardinality(Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('cpu_vendor') == null)
  mgmt.makePropertyKey('cpu_vendor').dataType(String.class).cardinality(Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('cpu_model_name') == null)
  mgmt.makePropertyKey('cpu_model_name').dataType(String.class).cardinality(Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('cpu_model') == null)
  mgmt.makePropertyKey('cpu_model').dataType(Integer.class).cardinality(Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('cpu_family') == null)
  mgmt.makePropertyKey('cpu_family').dataType(Integer.class).cardinality(Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('cpu_cores') == null)
  mgmt.makePropertyKey('cpu_cores').dataType(Integer.class).cardinality(Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('gpu_vendor') == null)
  mgmt.makePropertyKey('gpu_vendor').dataType(String.class).cardinality(Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('gpu_model_name') == null)
  mgmt.makePropertyKey('gpu_model_name').dataType(String.class).cardinality(Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('gpu_cores') == null)
  mgmt.makePropertyKey('gpu_cores').dataType(Integer.class).cardinality(Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('gpu_memory_size') == null)
  mgmt.makePropertyKey('gpu_memory_size').dataType(Integer.class).cardinality(Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('gpu_ram_size') == null)
  mgmt.makePropertyKey('gpu_ram_size').dataType(Integer.class).cardinality(Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('__label__') == null)
  mgmt.makePropertyKey('__label__').dataType(String.class).cardinality(Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('__type__') == null)
  mgmt.makePropertyKey('__type__').dataType(String.class).cardinality(Cardinality.SINGLE).make()

mgmt.commit()
