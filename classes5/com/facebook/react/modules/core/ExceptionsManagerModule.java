package com.facebook.react.modules.core;

import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.devsupport.DevSupportManager;
import java.io.File;

public class ExceptionsManagerModule
  extends BaseJavaModule
{
  private final DevSupportManager mDevSupportManager;
  
  public ExceptionsManagerModule(DevSupportManager paramDevSupportManager)
  {
    this.mDevSupportManager = paramDevSupportManager;
  }
  
  private void showOrThrowError(String paramString, ReadableArray paramReadableArray, int paramInt)
  {
    if ((this.mDevSupportManager != null) && (this.mDevSupportManager.getDevSupportEnabled())) {
      this.mDevSupportManager.showNewJSError(paramString, paramReadableArray, paramInt);
    }
  }
  
  private String stackTraceToString(ReadableArray paramReadableArray)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramReadableArray.size())
    {
      ReadableMap localReadableMap = paramReadableArray.getMap(i);
      localStringBuilder.append(localReadableMap.getString("methodName"));
      localStringBuilder.append("\n    ");
      localStringBuilder.append(new File(localReadableMap.getString("file")).getName());
      localStringBuilder.append(":");
      localStringBuilder.append(localReadableMap.getInt("lineNumber"));
      if ((localReadableMap.hasKey("column")) && (!localReadableMap.isNull("column"))) {
        localStringBuilder.append(":").append(localReadableMap.getInt("column"));
      }
      localStringBuilder.append("\n");
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public String getName()
  {
    return "RKExceptionsManager";
  }
  
  @ReactMethod
  public void reportFatalException(String paramString, ReadableArray paramReadableArray, int paramInt)
  {
    showOrThrowError(paramString, paramReadableArray, paramInt);
  }
  
  @ReactMethod
  public void reportSoftException(String paramString, ReadableArray paramReadableArray, int paramInt)
  {
    if (FLog.isLoggable(6)) {
      FLog.e("React", paramString + "\n" + stackTraceToString(paramReadableArray));
    }
  }
  
  @ReactMethod
  public void updateExceptionMessage(String paramString, ReadableArray paramReadableArray, int paramInt)
  {
    if ((this.mDevSupportManager != null) && (this.mDevSupportManager.getDevSupportEnabled())) {
      this.mDevSupportManager.updateJSError(paramString, paramReadableArray, paramInt);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\modules\core\ExceptionsManagerModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */