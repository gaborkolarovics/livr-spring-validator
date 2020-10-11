package io.github.livr.springframework.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import io.github.livr.springframework.validation.LivrValidator;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * LIVR Schema
 * <p>
 * Usage:<br>
 * <code>
 * &#64;LivrSchema(schema = "{\"name\": \"required\", \"email\": \"required\"}")<br>
 * public class LivrObj {<br>
 *     private String name;<br>
 *     private String email;<br>
 *     // Getter.. Setter..<br>
 * }<br>
 * </code>
 *
 * @author Gábor KOLÁROVICS
 * @since 2020/10/09
 */
@Constraint(validatedBy = LivrValidator.class)
@Target({ TYPE })
@Retention(RUNTIME)
public @interface LivrSchema {

	String message() default "Validation failed!";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	String schema();

	@Target({ ElementType.TYPE })
	@Retention(RetentionPolicy.RUNTIME)
	@interface List {
		LivrSchema[] value();
	}

}
