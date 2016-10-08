package com.tencent.tmdownloader.internal.downloadclient;

import com.qq.taf.jce.JceStruct;
import com.tencent.tmassistantbase.a.m;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.BatchSDKDownloadActionResponse;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCHead;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCResponse;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.SubScribeSDKDownloadTaskByViaResponse;

class c
  implements com.tencent.tmassistantsdk.internal.b.a
{
  c(b paramb) {}
  
  public void a()
  {
    m.c(b.b(), "onDownloadSDKServiceInvalid yybOpenClient......");
    b.a(this.a, null);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramArrayOfByte = com.tencent.tmassistantsdk.internal.openSDK.param.a.a(paramArrayOfByte);
      JceStruct localJceStruct = com.tencent.tmassistantsdk.internal.openSDK.param.a.a(paramArrayOfByte);
      m.c(b.b(), "response.head.cmdId = " + paramArrayOfByte.head.cmdId);
      switch (paramArrayOfByte.head.cmdId)
      {
      }
      do
      {
        do
        {
          return;
          m.c("jimluo", "_SubScribeSDKDownloadTask......");
        } while (localJceStruct == null);
        this.a.a((SubScribeSDKDownloadTaskByViaResponse)localJceStruct);
        return;
        m.c("jimluo", "_BatchDownloadAction......");
      } while (localJceStruct == null);
      this.a.a((BatchSDKDownloadActionResponse)localJceStruct);
      return;
    }
    m.c(b.b(), "onActionResult reponseData = null");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tmdownloader\internal\downloadclient\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */