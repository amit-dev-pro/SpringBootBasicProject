package com.example.amitlal.mvcProj.entity.validations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = RatingAnnotationLogic.class)
@Target(ElementType.FIELD )
@Retention(RetentionPolicy.RUNTIME)
public @interface Rating {
     String message() default "Please enter rating b/w 5 to 10";
     
     
     Class<?>[] groups() default {};
	 Class<? extends Payload>[] payload() default {};
}
