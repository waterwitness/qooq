package com.tencent.bitapp.module;

import com.tencent.bitapp.bundle.BundleStruct;

public abstract interface IDownloadListener
{
  public abstract void downloadFailure();
  
  public abstract void downloadSuccessful(BundleStruct paramBundleStruct);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\module\IDownloadListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */