package com.ua.faculty.validation;

import javax.validation.Payload;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = MobilePhoneValidator.class)
@Documented
public @interface ValidMobilePhone {
    String message() default "mobile.phone.invalid";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
