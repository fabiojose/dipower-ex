package com.github.fabiojose.di;

import java.net.URL;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 
 * @author fabiojose
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(
	webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
	classes = {App.class}
)
public class MyControllerTests {

	@LocalServerPort
	private int port;

	private URL get;

	@Autowired
	private TestRestTemplate template;
	
	@Before
	public void before() throws Exception {
		this.get = new URL("http://localhost:" + port + "/foo");
	}
	
	@Test
	public void get_ok() throws Exception {
		
		ResponseEntity<String> response = 
				template.getForEntity(get.toString(), String.class);
		
		Assert.assertEquals("foobar", response.getBody());
	}
	
}
