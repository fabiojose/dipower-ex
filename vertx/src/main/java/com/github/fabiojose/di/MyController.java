package com.github.fabiojose.di;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.ext.web.Router;

/**
 * 
 * @author fabiojose
 *
 */
public class MyController extends AbstractVerticle {
	@Override
    public void start(Future<Void> f) {
		
		Router router = Router.router(vertx);
		router.route("/foo")
			.handler(context ->{

				vertx.eventBus().send("core", "get", handler -> {
					context.response()
						.end(handler.result().body().toString());
				});
			});
    	
    	vertx.createHttpServer()
    		.requestHandler(router::handle)
    		.listen(8080, result -> {
    			if(result.succeeded()) {
    				f.complete();
    			} else {
    				f.fail(result.cause());
    			}
    		});	
    }
}
