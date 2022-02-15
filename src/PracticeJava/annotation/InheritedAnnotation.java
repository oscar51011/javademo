package PracticeJava.annotation;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@Inherited 
@Retention(RetentionPolicy.RUNTIME)
public @interface InheritedAnnotation {

	String value();

	String message() default "none";
		
}
