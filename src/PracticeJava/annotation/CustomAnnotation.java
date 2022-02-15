package PracticeJava.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 客製化 annotation
 * 1. 定義修飾類型: Method
 * 2. 定義生命週期:
 * 
 * @author oscar51011
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomAnnotation {

	String[] value();

	String message() default "none";
}
