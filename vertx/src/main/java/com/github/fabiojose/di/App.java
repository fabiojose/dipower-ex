package com.github.fabiojose.di;

import com.github.fabiojose.di.adapter.MyDependency;
import com.github.fabiojose.di.core.MyCoreClass;

import io.vertx.core.AbstractVerticle;

/**
 * 
 * @author fabiojose
 *
 */
public class App extends AbstractVerticle {
	@Override
    public void start() {
		vertx.deployVerticle(new MyController());
		vertx.deployVerticle(new MyDependency());
		vertx.deployVerticle(new MyCoreClass());
	}
}
