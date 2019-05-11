package com.github.fabiojose.di;

import javax.inject.Inject;

import org.jboss.weld.junit5.auto.AddPackages;
import org.jboss.weld.junit5.auto.WeldJunit5AutoExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.github.fabiojose.di.adapter.MyDependency;
import com.github.fabiojose.di.core.MyCoreClass;
import com.github.fabiojose.di.port.Dependency;

/**
 * 
 * @author fabiojose
 *
 */
@ExtendWith(WeldJunit5AutoExtension.class)
@AddPackages({
	MyDependency.class,
	MyCoreClass.class
})
public class AppTest {
	
	@Inject
	private MyCoreClass core;
    	
	@Inject
	public Dependency my;
	
	@Test
	public void core_ok() {
	
		Assertions.assertNotNull(
			core
		);
	}
	
	@Test
	public void my_ok() {
		
		Assertions.assertNotNull(
			my
		);
	}
}
