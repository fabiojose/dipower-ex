package com.github.fabiojose.di.adapter;

import org.springframework.stereotype.Component;

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
@Component
public class MyDependency implements Dependency {

	public String foo() {
		
		return "bar";
		
	}
}
