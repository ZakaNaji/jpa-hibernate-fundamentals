package com.znaji.id.generators;

import org.hibernate.annotations.IdGeneratorType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@IdGeneratorType(CustomUUIDGeneratorStrategy.class)
public @interface CustomUUIDGenerator {
}
