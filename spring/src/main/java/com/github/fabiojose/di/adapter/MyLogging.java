package com.github.fabiojose.di.adapter;

import java.util.Objects;
import java.util.function.Supplier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.fabiojose.di.port.Logging;

/**
 * Adapter for {@link Logging} Port, using Logback,
 * the Delegation Pattern and Lazy Evaluation
 * 
 * @author fabiojose
 *
 */
public class MyLogging implements Logging {
	
	private final Logger logger;
	
	public MyLogging(final Class<?> clazz) {
		Objects.requireNonNull(clazz);
		
		logger = LoggerFactory.getLogger(clazz);
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
