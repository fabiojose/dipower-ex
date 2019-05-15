package com.github.fabiojose.di;

import javax.inject.Inject;

import org.jboss.weld.junit5.auto.AddBeanClasses;
import org.jboss.weld.junit5.auto.AddPackages;
import org.jboss.weld.junit5.auto.WeldJunit5AutoExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.github.fabiojose.di.adapter.MyDependency;
import com.github.fabiojose.di.core.MyCoreClass;
import com.github.fabiojose.di.port.Dependency;
import com.github.fabiojose.di.port.Logging;

/**
 * 
 * @author fabiojose
 *
 */
@ExtendWith(WeldJunit5AutoExtension.class)
@AddBeanClasses({
	AppConfiguration.class
})
@AddPackages({
	MyDependency.class,
	MyCoreClass.class
})
public class AppTest {
	
	@Inject
	private MyCoreClass core;
    	
	@Inject
	public Dependency my;
	
	@Inject
	private Logging log;
	
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
	
	@Test
	public void log_ok() {
		Assertions.assertNotNull(
			log
		);
		log.info(() -> "----> works!");
	}
	
	@Test
	public void dummy_ok() {
		Assertions.assertEquals("foobar", core.dummy());
	}
	
	@Test
	public void annotation_ok() {
		Assertions.assertNotNull(
			MyCoreClass.class.getAnnotation(Beancare.class)
		);
	}
}
