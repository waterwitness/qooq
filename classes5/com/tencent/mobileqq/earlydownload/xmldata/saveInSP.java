package com.tencent.mobileqq.earlydownload.xmldata;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.FIELD})
public @interface saveInSP
{
  boolean a();
  
  boolean b();
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\earlydownload\xmldata\saveInSP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */