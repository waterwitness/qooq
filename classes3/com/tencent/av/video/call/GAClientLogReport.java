package com.tencent.av.video.call;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class GAClientLogReport
{
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cacheMethodIds();
  }
  
  public GAClientLogReport()
  {
    init();
  }
  
  private static native void cacheMethodIds();
  
  private int callbackSendLog(long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    return ClientLogReport.instance().callbackSendLog(paramLong, paramInt, paramArrayOfByte);
  }
  
  private native void init();
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\video\call\GAClientLogReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */