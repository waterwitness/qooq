package com.facebook.react.modules.common;

import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.NativeModule;
import java.util.Collection;
import java.util.Iterator;

public class ModuleDataCleaner
{
  public static void cleanDataFromModules(CatalystInstance paramCatalystInstance)
  {
    paramCatalystInstance = paramCatalystInstance.getNativeModules().iterator();
    while (paramCatalystInstance.hasNext())
    {
      NativeModule localNativeModule = (NativeModule)paramCatalystInstance.next();
      if ((localNativeModule instanceof Cleanable))
      {
        if (FLog.isLoggable(3)) {
          FLog.d("React", "Cleaning data from " + localNativeModule.getName());
        }
        ((Cleanable)localNativeModule).clearSensitiveData();
      }
    }
  }
  
  public static abstract interface Cleanable
  {
    public abstract void clearSensitiveData();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\modules\common\ModuleDataCleaner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */