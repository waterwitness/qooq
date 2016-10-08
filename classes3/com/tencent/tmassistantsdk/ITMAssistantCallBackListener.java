package com.tencent.tmassistantsdk;

public abstract interface ITMAssistantCallBackListener
{
  public abstract void OnDownloadTaskProgressChanged(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, long paramLong1, long paramLong2);
  
  public abstract void OnDownloadTaskStateChanged(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, int paramInt1, int paramInt2, String paramString);
  
  public abstract void OnQQDownloaderInvalid();
  
  public abstract void OnServiceFree();
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tmassistantsdk\ITMAssistantCallBackListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */