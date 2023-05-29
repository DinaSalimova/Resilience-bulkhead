# Resilience bulkhead pattern 
### Why to use:
1. avoids cascading failures (second controller is called from 
first controller,second controller doesn't response, first controller 
also can't give response, everything is stuck)
2. allows to preserve some functionality when some part of service 
can't give a response

Usage of this pattern is possible only when application can
provide some functionality even when external service is off (for 
example send dummy data or send empty data).

### Idea of implementation: 
To avoid situation when 
a client's connection pool is exhausted, for every 
necessary controller consumer will have its own connection pool.
