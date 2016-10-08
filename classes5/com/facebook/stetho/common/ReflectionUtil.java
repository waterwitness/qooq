package com.facebook.stetho.common;

import java.lang.reflect.Field;
import javax.annotation.Nullable;

public final class ReflectionUtil
{
  @Nullable
  public static Object getFieldValue(Field paramField, Object paramObject)
  {
    try
    {
      paramField = paramField.get(paramObject);
      return paramField;
    }
    catch (IllegalAccessException paramField)
    {
      throw new RuntimeException(paramField);
    }
  }
  
  @Nullable
  public static Class<?> tryGetClassForName(String paramString)
  {
    try
    {
      paramString = Class.forName(paramString);
      return paramString;
    }
    catch (ClassNotFoundException paramString) {}
    return null;
  }
  
  @Nullable
  public static Field tryGetDeclaredField(Class<?> paramClass, String paramString)
  {
    try
    {
      Field localField = paramClass.getDeclaredField(paramString);
      return localField;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      LogUtil.d(localNoSuchFieldException, "Could not retrieve %s field from %s", new Object[] { paramString, paramClass });
    }
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\common\ReflectionUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */