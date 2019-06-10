/**
 * 
 */
package org.topicquests.support.api;

import java.util.Map;

/**
 * @author jackpark
 *
 */
public interface IEnvironment {

	Map<String, Object> getProperties();
	
	String getStringProperty(String key);
	
	void logDebug(String msg);
	
	/**
	 * 
	 * @param msg
	 * @param e can be <code>null</code>
	 */
	void logError(String msg, Exception e);
	
	void shutDown();
}
