package com.tencent.assistant.sdk.remote;

import android.os.IInterface;

public abstract interface BaseService
  extends IInterface
{
  public abstract int registerActionCallback(String paramString1, String paramString2, SDKActionCallback paramSDKActionCallback);
  
  public abstract void sendAsyncData(String paramString, byte[] paramArrayOfByte);
  
  public abstract byte[] sendSyncData(String paramString, byte[] paramArrayOfByte);
  
  public abstract int unregisterActionCallback(SDKActionCallback paramSDKActionCallback);
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\assistant\sdk\remote\BaseService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */