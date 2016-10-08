package com.tencent.tmdownloader;

public abstract interface ITMAssistantDownloadClientListener
{
  public abstract void OnDownloadSDKTaskProgressChanged(TMAssistantDownloadClient paramTMAssistantDownloadClient, String paramString, long paramLong1, long paramLong2);
  
  public abstract void OnDownloadSDKTaskStateChanged(TMAssistantDownloadClient paramTMAssistantDownloadClient, String paramString1, int paramInt1, int paramInt2, String paramString2);
  
  public abstract void OnDwonloadSDKServiceInvalid(TMAssistantDownloadClient paramTMAssistantDownloadClient);
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tmdownloader\ITMAssistantDownloadClientListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */