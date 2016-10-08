package com.sixgod.pluginsdk.a;

import android.util.Log;
import com.sixgod.pluginsdk.log.SixGodReporter;
import com.sixgod.pluginsdk.log.a;
import java.lang.reflect.Method;

public final class g
  extends c
{
  public Method b;
  
  public g(Class paramClass, String paramString, Class[] paramArrayOfClass)
  {
    Object localObject;
    if (paramClass != null)
    {
      localObject = paramClass;
      if (localObject == Object.class) {}
    }
    for (;;)
    {
      try
      {
        this.b = ((Class)localObject).getDeclaredMethod(paramString, paramArrayOfClass);
        this.b.setAccessible(true);
        this.a = true;
        if (this.b != null) {
          return;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("method not found: methodName=");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(";className=");
        if (paramClass != null)
        {
          paramClass = paramClass.getName();
          ((StringBuilder)localObject).append(paramClass);
          ((StringBuilder)localObject).append(";args=[");
          if (paramArrayOfClass == null) {
            break label167;
          }
          int i = 0;
          if (i >= paramArrayOfClass.length) {
            break label167;
          }
          ((StringBuilder)localObject).append(paramArrayOfClass[i].getName());
          ((StringBuilder)localObject).append(",");
          i += 1;
          continue;
        }
      }
      catch (Exception localException)
      {
        localObject = ((Class)localObject).getSuperclass();
      }
      paramClass = "null";
    }
    label167:
    ((StringBuilder)localObject).append("]");
    SixGodReporter.reportException("ReflectExp", new Exception(((StringBuilder)localObject).toString()));
    Log.w("ReflectUtils", ((StringBuilder)localObject).toString());
  }
  
  public final Object a(Object paramObject, Object[] paramArrayOfObject)
  {
    if (this.b == null)
    {
      a.b("method null");
      paramObject = Boolean.valueOf(false);
    }
    for (;;)
    {
      return paramObject;
      try
      {
        paramArrayOfObject = this.b.invoke(paramObject, paramArrayOfObject);
        paramObject = paramArrayOfObject;
        if (paramArrayOfObject == null) {
          return Boolean.valueOf(true);
        }
      }
      catch (Exception paramObject)
      {
        ((Exception)paramObject).printStackTrace();
        SixGodReporter.reportException("ReflectExp", (Exception)paramObject);
      }
    }
    return Boolean.valueOf(false);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\sixgod\pluginsdk\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */