package com.github.fabiojose.di;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.fabiojose.di.core.MyCoreClass;
import com.github.fabiojose.di.port.Dependency;
import com.github.fabiojose.di.port.Logging;

/**
 * 
 * @author fabiojose
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTests {
	
	@Inject
	private MyCoreClass core;
	
	@Inject
	private Dependency my;
	
	@Inject
	private Logging log;

	@Test
	public void core_ok() {
		
		Assert.assertNotNull(core);
		
	}
	
	@Test
	public void dependency_ok() {
		
		Assert.assertNotNull(my);
	}
	
	@Test
	public void log_ok() {
		Assert.assertNotNull(log);
		log.info(() -> "----> works!");
	}

	@Test
	public void annotation_ok() {
		Assert.assertNotNull(
			MyCoreClass.class.getAnnotations()
		);
	}
}
