package com.github.fabiojose.di.core;

import io.vertx.core.AbstractVerticle;

/**
 * 
 * @author fabiojose
 *
 */
public class MyCoreClass extends AbstractVerticle {
	@Override
    public void start() {
		vertx.eventBus()
			.consumer("core", (message) -> {
				vertx.eventBus().send("my", "get", handler -> {
					message.reply("foo" + 
						handler.result().body().toString());
				});
			});	
	}
}
