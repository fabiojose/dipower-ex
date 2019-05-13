package com.github.fabiojose.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.springframework.stereotype.Component;

/**
 * Inheriting the behavior of {@link Component}
 * 
 * @author fabiojose
 *
 */
@Component
@Retention(RetentionPolicy.RUNTIME)
public @interface Beancare {

}
