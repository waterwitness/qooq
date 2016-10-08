package com.tencent.assistant.sdk.remote;

import android.os.IInterface;

public abstract interface SDKActionCallback
  extends IInterface
{
  public abstract void onActionResult(byte[] paramArrayOfByte);
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\assistant\sdk\remote\SDKActionCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */