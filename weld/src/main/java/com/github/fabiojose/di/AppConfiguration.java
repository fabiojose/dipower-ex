package com.github.fabiojose.di;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import com.github.fabiojose.di.adapter.MyLogging;
import com.github.fabiojose.di.port.Logging;

/**
 * The Application global configuration
 * 
 * @author fabiojose
 *
 */
public class AppConfiguration {

	/**
	 * Gets the injection point and return an adapter 
	 * instance for the port
	 */
	@Produces
	public Logging logging(InjectionPoint point) {
		
		return new MyLogging(point.getMember().getDeclaringClass());
		
	}
	
}
