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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * 
 * @author jackpark
 *
 */
public class ISO8601DateParser {
	public ISO8601DateParser() {
	}

	public static Date parse(String input) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd\'T\'HH:mm:ssz");
		if (input.endsWith("Z")) {
			input = input.substring(0, input.length() - 1) + "GMT-00:00";
		} else {
			int inset = 6;
			String s0 = input.substring(0, input.length() - inset);
			String s1 = input.substring(input.length() - inset, input.length());
			input = s0 + "GMT" + s1;
		}

		return df.parse(input);
	}

	public static String toString(Date date) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd\'T\'HH:mm:ssz");
		TimeZone tz = TimeZone.getTimeZone("UTC");
		df.setTimeZone(tz);
		String output = df.format(date);
		int inset0 = 9;
		int inset1 = 6;
		String s0 = output.substring(0, output.length() - inset0);
		String s1 = output.substring(output.length() - inset1, output.length());
		String result = s0 + s1;
		result = result.replaceAll("UTC", "+00:00");
		return result;
	}
}
