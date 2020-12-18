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
package org.topicquests.support.util;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * 
 * @author jackpark
 *
 */
public class LoggingPlatform {
	private static LoggingPlatform instance = null;
	private List<Tracer> tracers;
	private Logger log;

	protected LoggingPlatform(String loggerPropertiesFilePath) {
	/**
		LoggerContext context = (org.apache.logging.log4j.core.LoggerContext) LogManager.getContext(false);
		File file = new File(ConfigurationHelper.findPath(loggerPropertiesFilePath));
		// this will force a reconfiguration
		context.setConfigLocation(file.toURI());
		this.log = LogManager.getLogger(LoggingPlatform.class.getName());

	 */
		PropertyConfigurator.configure(ConfigurationHelper.findPath(loggerPropertiesFilePath));
		this.log = Logger.getLogger(LoggingPlatform.class);
		this.tracers = new ArrayList();
	}

	public static LoggingPlatform getLiveInstance() {
		if (instance == null) {
			throw new RuntimeException("LoggingPlatform not initialized");
		} else {
			return instance;
		}
	}

	public static LoggingPlatform getInstance(String loggerPropertiesFilePath) {
		if (instance == null) {
			instance = new LoggingPlatform(loggerPropertiesFilePath);
		}

		return instance;
	}

	public void logDebug(String msg) {
		this.log.debug(msg);
	}

	public void logError(String msg, Exception e) {
		if (e == null) {
			this.log.error(msg);
		} else {
			this.log.error(msg, e);
		}

	}

	public void record(String msg) {
		this.log.info(msg);
	}

	public Tracer getTracer(String agentName) {
		Tracer t = new Tracer(agentName, this);
		this.tracers.add(t);
		return t;
	}

	public void shutDown() {
		Iterator itr = this.tracers.iterator();

		while (itr.hasNext()) {
			((Tracer) itr.next()).shutDown();
		}

	}
}
