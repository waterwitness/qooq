package com.sixgod.pluginsdk.a;

import com.sixgod.pluginsdk.log.SixGodReporter;
import com.sixgod.pluginsdk.log.a;
import java.lang.reflect.Field;

public final class f
  extends c
{
  public Field b;
  public String c;
  public String d;
  
  public f(Class paramClass, String paramString)
  {
    this.c = paramString;
    this.d = paramClass.getName();
    Class localClass;
    if (paramClass != null) {
      localClass = paramClass;
    }
    for (;;)
    {
      if (localClass != Object.class) {}
      try
      {
        this.b = localClass.getDeclaredField(paramString);
        this.b.setAccessible(true);
        this.a = true;
        if (this.b == null)
        {
          paramClass = "field not found fieldName = " + paramString + " ; className = " + paramClass.getName();
          SixGodReporter.reportException("ReflectExp", new Exception(paramClass));
          a.c(paramClass);
        }
        return;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        localClass = localClass.getSuperclass();
      }
    }
  }
  
  public final Object a(Object paramObject)
  {
    if (this.b == null)
    {
      a.b("getValue field null:" + this.d + ", " + this.c);
      return null;
    }
    try
    {
      paramObject = this.b.get(paramObject);
      return paramObject;
    }
    catch (Exception paramObject)
    {
      ((Exception)paramObject).printStackTrace();
      SixGodReporter.reportException("ReflectExp", (Exception)paramObject);
    }
    return null;
  }
  
  public final void a(Object paramObject1, Object paramObject2)
  {
    if (this.b == null)
    {
      a.b("setValue field null:" + this.d + ", " + this.c);
      return;
    }
    try
    {
      this.b.set(paramObject1, paramObject2);
      return;
    }
    catch (Exception paramObject1)
    {
      ((Exception)paramObject1).printStackTrace();
      SixGodReporter.reportException("ReflectExp", (Exception)paramObject1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\sixgod\pluginsdk\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */