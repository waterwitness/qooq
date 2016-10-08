package com.tencent.securemodule.service;

import android.content.Context;

public abstract interface ISecureModuleService
{
  public abstract void cloudScan();
  
  public abstract void downLoadTMSeucreApk(ApkDownLoadListener paramApkDownLoadListener);
  
  public abstract int register(ProductInfo paramProductInfo);
  
  public abstract void registerCloudScanListener(Context paramContext, CloudScanListener paramCloudScanListener);
  
  public abstract void setNotificationUIEnable(boolean paramBoolean);
  
  public abstract void unregisterCloudScanListener(Context paramContext, CloudScanListener paramCloudScanListener);
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\securemodule\service\ISecureModuleService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */