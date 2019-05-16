package com.github.fabiojose.di;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.github.fabiojose.di.adapter.MyDependency;
import com.github.fabiojose.di.core.MyCoreClass;

import io.vertx.core.Vertx;
import io.vertx.ext.web.client.WebClient;
import io.vertx.ext.web.codec.BodyCodec;
import io.vertx.junit5.VertxExtension;
import io.vertx.junit5.VertxTestContext;


/**
 * 
 * @author fabiojose
 *
 */
@ExtendWith(VertxExtension.class)
public class AppTest {
	
	@BeforeEach
	void deploy_verticle(Vertx vertx, VertxTestContext testContext) {
		vertx.deployVerticle(new MyController(), testContext.completing());
		vertx.deployVerticle(new MyDependency());
		vertx.deployVerticle(new MyCoreClass());
	}
	
	@Test
    public void test_app(Vertx vertx, VertxTestContext testContext){
		WebClient client = WebClient.create(vertx);
		
	    client.get(8080, "localhost", "/foo")
	      .as(BodyCodec.string())
	      .send(testContext.succeeding(response -> testContext.verify(() -> {
	        Assertions.assertEquals("foobar", response.body());
	        testContext.completeNow();
	      })));	
    }
}
