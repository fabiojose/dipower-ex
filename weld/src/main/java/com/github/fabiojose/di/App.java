package com.github.fabiojose.di;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

import com.github.fabiojose.di.adapter.MyDependency;
import com.github.fabiojose.di.core.MyCoreClass;

/**
 * Application entry point
 * 
 * <br>
 * 
 * Weld does not have a feature annotation to scan for classes
 * 
 * @author fabiojose
 *
 */
public class App {
    public static void main(String[] args) {
    	
        final SeContainerInitializer initializer = 
        	SeContainerInitializer.newInstance();

        try (SeContainer container = initializer
        		.disableDiscovery()//Disable
        		
        		/*
        		 * Every class in the some package as following
        		 * classes, do not need to be added
        		 */
        		.addPackages(App.class)
        		.addPackages(MyDependency.class)
        		.addPackages(MyCoreClass.class)
        		
        		.initialize()) {
        	
            container.select(NettyStuff.class);
        }
    }
}
