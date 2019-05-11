package com.github.fabiojose.di.core;

import javax.inject.Inject;

import com.github.fabiojose.di.Beancare;
import com.github.fabiojose.di.port.Dependency;

/**
 * We *can't* apply spring annotation at core classes
 * 
 * @author fabiojose
 *
 */
@Beancare
public class MyCoreClass {

	/**
	 * Always depends on interfaces (Ports), never on concrete classes
	 */
	@Inject
	private Dependency my;
	
	public String dummy() {
		
		return "foo" +  my.foo();
	}
	
}
