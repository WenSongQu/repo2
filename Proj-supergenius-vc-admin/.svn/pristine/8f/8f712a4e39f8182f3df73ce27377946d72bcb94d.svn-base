package com.supergenius.admin.utils;

import org.slf4j.Logger;

import java.io.PrintWriter;
import java.io.StringWriter;

public abstract class BaseLog {
	
	protected static void logException(Logger log, Exception e) {
		e.printStackTrace();
		StringWriter sw = new StringWriter();
		e.printStackTrace(new PrintWriter(sw));
		log.error(sw.toString());
	}
	
	protected static void logDebug(Logger log, String str) {
		log.debug(str);
	}
}
