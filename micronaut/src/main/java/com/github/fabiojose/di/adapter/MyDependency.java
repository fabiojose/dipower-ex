package com.github.fabiojose.di.adapter;

import javax.inject.Singleton;

import com.github.fabiojose.di.port.Dependency;

/**
 * The adapter of {@link Dependency} port
 * <br>
 * <br>
 * 
 * We can apply spring annotation outside of the core
 *  
 * @author fabiojose
 *
 */
@Singleton
public class MyDependency implements Dependency {

	public String foo() {
		
		return "bar";
		
	}
	
}