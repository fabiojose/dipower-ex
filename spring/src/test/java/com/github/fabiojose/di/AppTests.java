package com.github.fabiojose.di;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.fabiojose.di.core.MyCoreClass;
import com.github.fabiojose.di.port.Dependency;

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

	@Test
	public void core_ok() {
		
		Assert.assertNotNull(core);
		
	}
	
	@Test
	public void dependency_ok() {
		
		Assert.assertNotNull(my);
	}

}
