package com.tencent.tmassistantsdk.internal.openSDK.param.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SyncSDKDownloadTaskRequest
  extends JceStruct
{
  static IPCSDKDownloadInfo a = new IPCSDKDownloadInfo();
  public IPCSDKDownloadInfo data = null;
  
  public SyncSDKDownloadTaskRequest() {}
  
  public SyncSDKDownloadTaskRequest(IPCSDKDownloadInfo paramIPCSDKDownloadInfo)
  {
    this.data = paramIPCSDKDownloadInfo;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.data = ((IPCSDKDownloadInfo)paramJceInputStream.read(a, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.data, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tmassistantsdk\internal\openSDK\param\jce\SyncSDKDownloadTaskRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */