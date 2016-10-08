package com.tencent.upload.uinterface;

import com.tencent.upload.common.UploadConfiguration.NetworkStateObserver;

public abstract interface IUploadEnv
{
  public abstract String getApnName();
  
  public abstract String getBSSID();
  
  public abstract int getCurrentNetworkCategory();
  
  public abstract int getMobileOperatorCategory();
  
  public abstract String getProviderName();
  
  public abstract boolean isAvailable();
  
  public abstract boolean isMobile();
  
  public abstract boolean isWap();
  
  public abstract boolean isWifi();
  
  public abstract boolean loadLibrary(String paramString);
  
  public abstract void registerNetworkStateObserver(UploadConfiguration.NetworkStateObserver paramNetworkStateObserver);
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\uinterface\IUploadEnv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */