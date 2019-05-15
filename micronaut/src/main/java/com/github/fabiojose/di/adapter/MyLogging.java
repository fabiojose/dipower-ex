package com.github.fabiojose.di.adapter;

import java.util.function.Supplier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.fabiojose.di.port.Logging;

import io.micronaut.context.annotation.Prototype;

/**
 * Adapter for {@link Logging} Port, using Logback,
 * the Delegation Pattern and Lazy Evaluation
 * 
 * @author fabiojose
 *
 */
@Prototype
public class MyLogging implements Logging {
	
	private Logger logger;
	
	public MyLogging() {
		logger = LoggerFactory.getLogger(MyLogging.class);
	}

	@Override
	public void debug(Supplier<String> message) {
		if(logger.isDebugEnabled()) {
			logger.debug(message.get());
		}
	}

	@Override
	public void error(Supplier<String> message) {
		if(logger.isErrorEnabled()) {
			logger.error(message.get());
		}
	}

	@Override
	public void info(Supplier<String> message) {
		if(logger.isInfoEnabled()) {
			logger.info(message.get());
		}
	}

	@Override
	public void trace(Supplier<String> message) {
		if(logger.isTraceEnabled()) {
			logger.trace(message.get());
		}
	}

	@Override
	public void warn(Supplier<String> message) {
		if(logger.isWarnEnabled()) {
			logger.warn(message.get());
		}
	}

}
