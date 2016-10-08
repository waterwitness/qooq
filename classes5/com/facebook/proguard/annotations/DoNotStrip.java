package com.facebook.proguard.annotations;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target({java.lang.annotation.ElementType.TYPE, java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.CONSTRUCTOR})
public @interface DoNotStrip {}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\proguard\annotations\DoNotStrip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */