package com.tencent.device.file;

import com.tencent.litetransfersdk.Session;

public abstract interface DeviceAVFileMsgObserver$DevMsgProcessor
{
  public abstract long a(String paramString, long paramLong);
  
  public abstract void a(Session paramSession);
  
  public abstract void a(Session paramSession, String paramString, long paramLong, int paramInt, float paramFloat);
  
  public abstract void a(Session paramSession, String paramString, long paramLong, int paramInt, boolean paramBoolean);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\device\file\DeviceAVFileMsgObserver$DevMsgProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */