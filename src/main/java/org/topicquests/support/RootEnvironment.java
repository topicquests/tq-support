/*
 * Copyright 2020 TopicQuests
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions
 * and limitations under the License.
 */
package org.topicquests.support;

import java.util.Map;

import org.topicquests.support.api.IEnvironment;
import org.topicquests.support.config.ConfigPullParser;
import org.topicquests.support.config.Configurator;
import org.topicquests.support.util.LoggingPlatform;
import org.topicquests.support.util.Tracer;

/**
 * @author jackpark
 *
 */
public abstract class RootEnvironment implements IEnvironment {
	private LoggingPlatform logger;
	private Map<String,Object>properties;

	/**
	 * 
	 */
	public RootEnvironment(String configPath) {
		 logger = LoggingPlatform.getInstance(); 
			 
			 
			 ConfigPullParser p = new ConfigPullParser(configPath);
			 properties = p.getProperties();
	}

	public Map<String, Object> getProperties() {
		return properties;
	}
	
	public String getStringProperty(String key) {
		return (String)properties.get(key);
	}
	
	public Object getProperty(String key) {
		return properties.get(key);
	}


	public void logDebug(String msg) {
		logger.logDebug(msg);
	}
	
	public void logError(String msg, Exception e) {
		logger.logError(msg,e);
	}

	public Tracer getTracer(String agentName) {
		return new Tracer(agentName, logger);
	}

	public void record(String msg) {
		logger.record(msg);
	}

	@Override
	public abstract void shutDown();
}
