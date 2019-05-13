package com.github.fabiojose.di;

import org.springframework.beans.factory.InjectionPoint;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.github.fabiojose.di.adapter.MyLogging;
import com.github.fabiojose.di.port.Logging;

/**
 * The Application global configuration
 * 
 * @author fabiojose
 *
 */
@Configuration
public class AppConfiguration {

	/**
	 * Gets the injection point and return an adapter 
	 * instance for the port
	 */
	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Logging logging(InjectionPoint point) {
		
		return new MyLogging(point.getMember().getDeclaringClass());
		
	}
}
