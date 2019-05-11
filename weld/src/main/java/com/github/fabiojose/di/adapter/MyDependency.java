package com.github.fabiojose.di.adapter;

import javax.enterprise.context.ApplicationScoped;

import com.github.fabiojose.di.port.Dependency;

/**
 * The adapter of {@link Dependency} port
 * <br>
 * <br>
 * We can apply weld annotation outside of the core
 * 
 * @author fabiojose
 *
 */
@ApplicationScoped
public class MyDependency implements Dependency {

	@Override
	public String foo() {

		return "bar";
	}

}
