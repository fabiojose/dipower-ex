package com.github.fabiojose.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.enterprise.context.ApplicationScoped;

/**
 * Inheriting the behavior of {@link ApplicationScoped}
 * 
 * @author fabiojose
 *
 */
@ApplicationScoped
@Retention(RetentionPolicy.RUNTIME)
public @interface Beancare {

}
