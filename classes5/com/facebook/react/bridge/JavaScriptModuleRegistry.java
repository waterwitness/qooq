package com.facebook.react.bridge;

import com.facebook.common.logging.FLog;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

class JavaScriptModuleRegistry
{
  private final HashMap<Class<? extends JavaScriptModule>, JavaScriptModule> mModuleInstances = new HashMap();
  
  public JavaScriptModuleRegistry(CatalystInstanceImpl paramCatalystInstanceImpl, JavaScriptModulesConfig paramJavaScriptModulesConfig)
  {
    paramJavaScriptModulesConfig = paramJavaScriptModulesConfig.getModuleDefinitions().iterator();
    while (paramJavaScriptModulesConfig.hasNext())
    {
      Object localObject2 = (JavaScriptModuleRegistration)paramJavaScriptModulesConfig.next();
      Class localClass = ((JavaScriptModuleRegistration)localObject2).getModuleInterface();
      Object localObject1 = localClass.getClassLoader();
      localObject2 = new JavaScriptModuleInvocationHandler(paramCatalystInstanceImpl, (JavaScriptModuleRegistration)localObject2);
      localObject1 = (JavaScriptModule)Proxy.newProxyInstance((ClassLoader)localObject1, new Class[] { localClass }, (InvocationHandler)localObject2);
      this.mModuleInstances.put(localClass, localObject1);
    }
  }
  
  public <T extends JavaScriptModule> T getJavaScriptModule(Class<T> paramClass)
  {
    JavaScriptModule localJavaScriptModule = (JavaScriptModule)this.mModuleInstances.get(paramClass);
    if ((localJavaScriptModule == null) && (FLog.isLoggable(6))) {
      FLog.e("Exception", "JS module " + paramClass.getSimpleName() + " hasn't been registered!");
    }
    return localJavaScriptModule;
  }
  
  private static class JavaScriptModuleInvocationHandler
    implements InvocationHandler
  {
    private final CatalystInstanceImpl mCatalystInstance;
    private final JavaScriptModuleRegistration mModuleRegistration;
    
    public JavaScriptModuleInvocationHandler(CatalystInstanceImpl paramCatalystInstanceImpl, JavaScriptModuleRegistration paramJavaScriptModuleRegistration)
    {
      this.mCatalystInstance = paramCatalystInstanceImpl;
      this.mModuleRegistration = paramJavaScriptModuleRegistration;
    }
    
    @Nullable
    public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
      throws Throwable
    {
      paramObject = this.mModuleRegistration.getTracingName(paramMethod);
      this.mCatalystInstance.callFunction(this.mModuleRegistration.getModuleId(), this.mModuleRegistration.getMethodId(paramMethod), paramArrayOfObject, (String)paramObject);
      return null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\bridge\JavaScriptModuleRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */