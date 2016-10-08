package com.tencent.bitapp.module;

import com.facebook.common.logging.FLog;

public class ModuleListener
  implements IModuleListener
{
  private static final String TAG = ModuleListener.class.getSimpleName();
  
  public void onLoadFail(String paramString, int paramInt)
  {
    if (FLog.isLoggable(3)) {
      FLog.i(TAG, "onLoadFail key: " + paramString + " | errorCode: " + paramInt);
    }
  }
  
  public void onLoadSuccess(String paramString, Module paramModule)
  {
    if (FLog.isLoggable(3)) {
      FLog.i(TAG, "onLoadSuccess key: " + paramString + " | module: " + paramModule);
    }
  }
  
  public void onLoadingCache(String paramString)
  {
    if (FLog.isLoggable(3)) {
      FLog.i(TAG, "onLoadingCache key: " + paramString);
    }
  }
  
  public void onLoadingDependencies(String paramString)
  {
    if (FLog.isLoggable(3)) {
      FLog.i(TAG, "onLoadingDependencies key: " + paramString);
    }
  }
  
  public void onLoadingFile(String paramString)
  {
    if (FLog.isLoggable(3)) {
      FLog.i(TAG, "onLoadingFile key: " + paramString);
    }
  }
  
  public void onLoadingNet(String paramString)
  {
    if (FLog.isLoggable(3)) {
      FLog.i(TAG, "onLoadingNet key: " + paramString);
    }
  }
  
  public void onLoadingUnZip(String paramString)
  {
    if (FLog.isLoggable(3)) {
      FLog.i(TAG, "onLoadingUnZip key: " + paramString);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\module\ModuleListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */