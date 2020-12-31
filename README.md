TopicQuests Support [<img src="https://circleci.com/gh/topicquests/tq-support/tree/develop.png?style=shield"/>](https://circleci.com/gh/topicquests/workflows/tq-support)
===================

Core supporting code for TopicQuests projects

Status: [Production Release](https://search.maven.org/#search%7Cgav%7C1%7Cg%3A%22org.topicquests%22%20AND%20a%3A%22tq-support%22)

## Background ##
These are simply utility routines used throughout TopicQuests projects. The project is relatively stable and has been for a long time, so it is now labeled version 1.0.0

Support is provided for:
- Loading the XML config files with ConfigPullParser
- Various Date utilities
- An LRU cache
- The LoggingPlatform and its Tracer tool
- A TextFileHandler with a variety of useful methods
- A static utility for finding where configuration files are stored; this allows you to put your config files, including logger.properties, into one of: the root directory, or a directory named "config", "conf", or "cfg".

## Build ##
mvn clean install -DskipTests

## License ##
Apache 2
