package com.tencent.bitapp.module;

public abstract interface IModuleListener
{
  public abstract void onLoadFail(String paramString, int paramInt);
  
  public abstract void onLoadSuccess(String paramString, Module paramModule);
  
  public abstract void onLoadingCache(String paramString);
  
  public abstract void onLoadingDependencies(String paramString);
  
  public abstract void onLoadingFile(String paramString);
  
  public abstract void onLoadingNet(String paramString);
  
  public abstract void onLoadingUnZip(String paramString);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\module\IModuleListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */