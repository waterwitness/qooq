package com.facebook.react.bridge;

import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.common.MapBuilder;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import javax.annotation.concurrent.Immutable;

@Immutable
class JavaScriptModuleRegistration
{
  private final Map<Method, Integer> mMethodsToIds;
  private final Map<Method, String> mMethodsToTracingNames;
  private final int mModuleId;
  private final Class<? extends JavaScriptModule> mModuleInterface;
  
  JavaScriptModuleRegistration(int paramInt, Class<? extends JavaScriptModule> paramClass)
  {
    this.mModuleId = paramInt;
    this.mModuleInterface = paramClass;
    this.mMethodsToIds = MapBuilder.newHashMap();
    this.mMethodsToTracingNames = MapBuilder.newHashMap();
    Method[] arrayOfMethod = this.mModuleInterface.getDeclaredMethods();
    Arrays.sort(arrayOfMethod, new Comparator()
    {
      public int compare(Method paramAnonymousMethod1, Method paramAnonymousMethod2)
      {
        return paramAnonymousMethod1.getName().compareTo(paramAnonymousMethod2.getName());
      }
    });
    paramClass = null;
    paramInt = 0;
    if (paramInt < arrayOfMethod.length)
    {
      Method localMethod = arrayOfMethod[paramInt];
      String str = localMethod.getName();
      Object localObject;
      if (str.equals(paramClass))
      {
        localObject = paramClass;
        if (FLog.isLoggable(6))
        {
          FLog.e("Exception", "Method overloading is unsupported: " + this.mModuleInterface.getName() + "#" + str);
          localObject = paramClass;
        }
      }
      for (;;)
      {
        paramInt += 1;
        paramClass = (Class<? extends JavaScriptModule>)localObject;
        break;
        localObject = str;
        this.mMethodsToIds.put(localMethod, Integer.valueOf(paramInt));
        this.mMethodsToTracingNames.put(localMethod, "JSCall__" + getName() + "_" + localMethod.getName());
      }
    }
  }
  
  public int getMethodId(Method paramMethod)
  {
    Integer localInteger = (Integer)this.mMethodsToIds.get(paramMethod);
    if (localInteger == null) {
      Assertions.assertUnreachable("Unknown method: " + paramMethod.getName());
    }
    return localInteger.intValue();
  }
  
  public Set<Method> getMethods()
  {
    return this.mMethodsToIds.keySet();
  }
  
  public int getModuleId()
  {
    return this.mModuleId;
  }
  
  public Class<? extends JavaScriptModule> getModuleInterface()
  {
    return this.mModuleInterface;
  }
  
  public String getName()
  {
    String str2 = this.mModuleInterface.getSimpleName();
    int i = str2.lastIndexOf('$');
    String str1 = str2;
    if (i != -1) {
      str1 = str2.substring(i + 1);
    }
    return str1;
  }
  
  public String getTracingName(Method paramMethod)
  {
    return (String)Assertions.assertNotNull(this.mMethodsToTracingNames.get(paramMethod));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\bridge\JavaScriptModuleRegistration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */