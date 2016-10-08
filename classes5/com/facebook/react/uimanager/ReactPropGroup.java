package com.facebook.react.uimanager;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.annotation.Nullable;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.METHOD})
public @interface ReactPropGroup
{
  public static final String USE_DEFAULT_TYPE = "__default_type__";
  
  @Nullable
  String customType() default "__default_type__";
  
  double defaultDouble() default 0.0D;
  
  float defaultFloat() default 0.0F;
  
  int defaultInt() default 0;
  
  String[] names();
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\uimanager\ReactPropGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */