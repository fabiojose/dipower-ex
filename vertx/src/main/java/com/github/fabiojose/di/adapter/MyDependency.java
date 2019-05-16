package com.github.fabiojose.di.adapter;

import io.vertx.core.AbstractVerticle;

/**
 * 
 * @author fabiojose
 *
 */
public class MyDependency extends AbstractVerticle {
	@Override
    public void start() {
		vertx.eventBus()
			.consumer("my", (message) -> {
				message.reply("bar");
			});
	}
}
