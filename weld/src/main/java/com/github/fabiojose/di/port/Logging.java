package com.github.fabiojose.di.port;

import java.util.function.Supplier;

/**
 * Port to abstract the logger driver
 * 
 * @author fabiojose
 * @see Supplier
 */
public interface Logging {

	void debug(Supplier<String> message);
	void error(Supplier<String> message);
	void info(Supplier<String> message);
	void trace(Supplier<String> message);
	void warn(Supplier<String> message);
	
}