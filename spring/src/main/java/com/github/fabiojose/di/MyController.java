package com.github.fabiojose.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.fabiojose.di.core.MyCoreClass;

/**
 * 
 * @author fabiojose
 *
 */
@RestController
public class MyController {

	/*
	 * We can use @Autowired too, outside of core off course!
	 */
	@Autowired
	private MyCoreClass core;
	
	@GetMapping(path = "/foo")
	public ResponseEntity<String> get() {
		
		return ResponseEntity
				.ok()
				.body(core.dummy());
	}
 }
