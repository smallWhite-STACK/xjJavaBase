package com.atxujian.java;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.*;

/**
 * @author xujian
 * @create 2020-02-22 10:30
 */

@Repeatable(MyAnnotations.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE,TYPE_USE,TYPE_PARAMETER})
public @interface MyAnnotation {
    String value() default "hello";
}
