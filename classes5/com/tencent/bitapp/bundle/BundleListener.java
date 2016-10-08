package com.tencent.bitapp.bundle;

import com.facebook.common.logging.FLog;

public class BundleListener
  implements IBundleListener
{
  private static final String TAG = BundleListener.class.getSimpleName();
  
  public void onCombinBundle(String paramString)
  {
    if (FLog.isLoggable(3)) {
      FLog.i(TAG, "onCombinBundle key: " + paramString);
    }
  }
  
  public void onLoadFail(String paramString, int paramInt)
  {
    if (FLog.isLoggable(3)) {
      FLog.i(TAG, "onLoadFail key: " + paramString + " | errorCode: " + paramInt);
    }
  }
  
  public void onLoadSuccess(String paramString, Bundle paramBundle)
  {
    if (FLog.isLoggable(3)) {
      FLog.i(TAG, "onLoadSuccess key: " + paramString + " | bundle: " + paramBundle);
    }
  }
  
  public void onLoadingCache(String paramString)
  {
    if (FLog.isLoggable(3)) {
      FLog.i(TAG, "onLoadingCache key: " + paramString);
    }
  }
  
  public void onLoadingFile(String paramString)
  {
    if (FLog.isLoggable(3)) {
      FLog.i(TAG, "onLoadingFile key: " + paramString);
    }
  }
  
  public void onLoadingModules(String paramString)
  {
    if (FLog.isLoggable(3)) {
      FLog.i(TAG, "onLoadingModules key: " + paramString);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\bundle\BundleListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */