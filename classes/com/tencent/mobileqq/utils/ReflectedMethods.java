package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.reflect.Field;

public class ReflectedMethods
{
  public ReflectedMethods()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static SharedPreferences a(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramString == null) || (paramString.length() <= 0)) {
      return null;
    }
    try
    {
      Class localClass = Class.forName("android.content.Context");
      i = ((Integer)localClass.getField("MODE_MULTI_PROCESS").get(localClass)).intValue();
      int j = i;
      if (i == -1) {
        j = 0;
      }
      return paramContext.getSharedPreferences(paramString, j);
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        i = -1;
      }
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;)
      {
        i = -1;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        i = -1;
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        i = -1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = -1;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\utils\ReflectedMethods.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */