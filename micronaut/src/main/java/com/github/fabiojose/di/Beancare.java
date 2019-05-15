package com.github.fabiojose.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Singleton;

/**
 * Inheriting the behavior of {@link Singleton}
 * 
 * @author fabiojose
 *
 */
@Singleton
@Retention(RetentionPolicy.RUNTIME)
public @interface Beancare {

}
