package com.tencent.bitapp.bundle;

public abstract interface IBundleListener
{
  public abstract void onCombinBundle(String paramString);
  
  public abstract void onLoadFail(String paramString, int paramInt);
  
  public abstract void onLoadSuccess(String paramString, Bundle paramBundle);
  
  public abstract void onLoadingCache(String paramString);
  
  public abstract void onLoadingFile(String paramString);
  
  public abstract void onLoadingModules(String paramString);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\bundle\IBundleListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */