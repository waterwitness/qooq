package com.tribe.async.utils;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target({java.lang.annotation.ElementType.TYPE, java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.CONSTRUCTOR})
public @interface DoNotStrip {}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tribe\async\utils\DoNotStrip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */