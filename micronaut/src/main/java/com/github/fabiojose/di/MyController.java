package com.github.fabiojose.di;

import javax.inject.Inject;

import com.github.fabiojose.di.core.MyCoreClass;
import com.github.fabiojose.di.port.Logging;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

/**
 * 
 * @author fabiojose
 *
 */
@Controller("/foo")
public class MyController {
	
	@Inject
	private MyCoreClass core;
	
    @Inject
    private Logging log;

	@Get("/")
	@Produces(MediaType.TEXT_PLAIN)
	public String get() {
		
		log.info(() -> "Controller get . . .");
		
		return core.dummy();
	}
	
}
