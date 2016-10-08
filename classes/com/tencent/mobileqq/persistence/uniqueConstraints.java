package com.tencent.mobileqq.persistence;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.TYPE})
public @interface uniqueConstraints
{
  ConflictClause clause();
  
  String columnNames();
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\persistence\uniqueConstraints.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */