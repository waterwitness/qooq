package com.tencent.securemodule.service;

public abstract interface ApkDownLoadListener
{
  public abstract void onDownLoadError();
  
  public abstract void onDownloadStart();
  
  public abstract void onDownloadSuccess();
  
  public abstract void onRefreshProgress(int paramInt, long paramLong1, long paramLong2);
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\securemodule\service\ApkDownLoadListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */