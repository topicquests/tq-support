/**
 * 
 */
package org.topicquests.support;

import java.util.Map;

import org.topicquests.support.api.IEnvironment;
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
	public RootEnvironment(String configPath, String logConfigPath) {
		 logger = LoggingPlatform.getInstance(logConfigPath); 
		 properties = Configurator.getProperties(configPath);
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
