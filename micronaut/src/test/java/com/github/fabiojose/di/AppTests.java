package com.github.fabiojose.di;

import javax.inject.Inject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.github.fabiojose.di.core.MyCoreClass;
import com.github.fabiojose.di.port.Dependency;
import com.github.fabiojose.di.port.Logging;

import io.micronaut.test.annotation.MicronautTest;

/**
 * 
 * @author fabiojose
 *
 */
@MicronautTest
public class AppTests {

	@Inject
	private MyCoreClass core;
	
	@Inject
	private Dependency my;
	
	@Inject
	private Logging log;

	@Test
	public void core_ok() {
		
		Assertions.assertNotNull(core);
		
	}
	
	@Test
	public void dependency_ok() {
		
		Assertions.assertNotNull(my);
	}
	
	@Test
	public void log_ok() {
		Assertions.assertNotNull(log);
		log.info(() -> "----> works!");
	}

	@Test
	public void annotation_ok() {
		Assertions.assertNotNull(
			MyCoreClass.class.getAnnotations()
		);
	}
}
