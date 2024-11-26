package com.example.amitlal.mvcProj.entity.validations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.Payload;

@Constraint(validatedBy = PriorityAnnotationLogic.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface priority {
	
	String message() default "Enter only L , M , H";
	
	  Class<?>[] groups() default {};
	   Class<? extends Payload>[] payload() default {};

}
