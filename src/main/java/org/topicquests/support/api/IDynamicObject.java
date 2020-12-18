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
package org.topicquests.support.api;

/**
 * @author jackpark
 * <p>A <em>Dynamic Object</em> is one which has
 * an <em>interestingness</em> value. That value can
 * change over time</p>
 */
public interface IDynamicObject {
	/** A common JSONObject field or property key*/
	public static final String
		INTERESTINGNESS_FIELD	= "interng";
	
	/**
	 * Set an initial {@code value}
	 * @param value
	 */
	void setInterestingess(int value);
	
	/**
	 * Return the current value
	 * @return
	 */
	int getInterestingness();
	
	/**
	 * Submit a delta for the current value;
	 * {@code value} can be positive or negative
	 * @param value
	 */
	void changeInterestingness(int value);

}
