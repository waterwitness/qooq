package com.tencent.mobileqq.vip;

import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract class IPCDownloadListener
{
  public IPCDownloadListener()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(long paramLong, int paramInt, Bundle paramBundle) {}
  
  public void a(Bundle paramBundle) {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vip\IPCDownloadListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */