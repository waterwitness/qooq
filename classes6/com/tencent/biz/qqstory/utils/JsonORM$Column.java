package com.tencent.biz.qqstory.utils;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.FIELD})
public @interface JsonORM$Column
{
  String a();
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\utils\JsonORM$Column.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */