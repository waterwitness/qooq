package com.tencent.tmassistantsdk.internal.b;

import com.tencent.assistant.sdk.remote.SDKActionCallback.Stub;
import com.tencent.tmassistantbase.a.m;
import java.util.ArrayList;

class c
  extends SDKActionCallback.Stub
{
  c(b paramb) {}
  
  public void onActionResult(byte[] paramArrayOfByte)
  {
    m.c("TMAssistantDownloadOpenSDKClient", "onActionResult  callBack data:" + paramArrayOfByte + "  mListeners.size:" + this.a.c.size());
    com.tencent.tmassistant.common.c.a().a(paramArrayOfByte, this.a.c);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tmassistantsdk\internal\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */