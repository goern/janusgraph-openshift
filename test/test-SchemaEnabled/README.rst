Testing-in-ENABLED-MODE
--------------------------

There are three modes in Schema Status in order of precedence.
INSTALLED  -- LEVEL 0
REGISTERED -- LEVEL 1
ENABLED    -- LEVEL 2 

In this section we are testing on the failure scenarios that may occur in  Enabled Mode.
There are various possibilities where DB could get aborted or shutdown during Enabling process.
In these cases, we may encounter half number of indexes being in Enabled mode and half in some other state , these test files helps to recreate the scenario and  check if only few indexes in other state does the following
Encounters current state of index , identifies the level and gets enabled if the current state is less than enabled state as this is the last state in a schema.
Commands to Recreate Issue:
1. sudo docker build . (Build the test-SchemaEnabled without any changes)
2. sudo docker tag "build ID" janusgraph-wrong
3. sudo docker run -e JANUSGRAPH_USE_INDEXES=1 -p 8182:8182 -v $(pwd)/data:/opt/janusgraph-0.2.0-hadoop2/db:rw,z janusgraph-wrong
4. Program would exit automatically
5. Remove exit 1 statement from startup.sh 
6. Copy the Data folder generated to get some backup to debug if needed
7. sudo docker build .
8. sudo docker tag "build ID" janusgraph-right
9. sudo docker run -e JANUSGRAPH_USE_INDEXES=1 -p 8182:8182 -v $(pwd)/data:/opt/janusgraph-0.2.0-hadoop2/db:rw,z janusgraph-right

