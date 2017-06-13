/**
 * 
 */
package org.topicquests.support.config;

import java.util.Map;

/**
 * @author jackpark
 *
 */
public class Configurator {

	/**
	 * Return configuration properties
	 * @param configPath
	 * @return
	 */
	public static Map<String,Object> getProperties(String configPath) {
		ConfigPullParser p = new ConfigPullParser(configPath);
		return p.getProperties();
	}

}
