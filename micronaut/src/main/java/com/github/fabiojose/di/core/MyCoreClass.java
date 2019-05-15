package com.github.fabiojose.di.core;

import javax.inject.Inject;

import com.github.fabiojose.di.Beancare;
import com.github.fabiojose.di.port.Dependency;
import com.github.fabiojose.di.port.Logging;

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
	
	/**
	 * If you like an absolute clean business class (like me).
	 * You can abstract the logger driver too
	 */
	@Inject
	private Logging log;
	
	public String dummy() {
		
		Object bar = my.foo();
		
		log.info(() -> "Running the dummy logic inside the core");
		
		return "foo" + bar.toString();		
	}
	
}