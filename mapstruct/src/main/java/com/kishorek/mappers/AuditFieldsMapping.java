package com.kishorek.mappers;

import org.mapstruct.Mapping;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Meta annotation creates custom grouped/set of mappings that can be applied across the objects.
 */
@Retention(RetentionPolicy.CLASS)
@Mapping(target = "updatedDate", expression = "java(new java.util.Date())")
public @interface AuditFieldsMapping {

}
