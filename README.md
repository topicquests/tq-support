TopicQuestsSupport
==================

Core supporting code for TopicQuests projects

Status: Production<br/>
Latest edit: 201709
## Background ##
These are simply utility routines used throughout TopicQuests projects. The project is relatively stable and has been for a long time, so it is now labeled version 1.0.0

Support is provided for:
- Loading the XML config files with ConfigPullParser
- Various Date utilities
- An LRU cache
- The LoggingPlatform and its Tracer tool
- A TextFileHandler with a variety of useful methods
- A static utility for finding where configuration files are stored; this allows you to put your config files, including logger.properties, into one of: the root directory, or a directory named "config", "conf", or "cfg".


## License ##
Apache 2
