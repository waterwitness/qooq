package com.tencent.mobileqq.qipc;

import android.os.Bundle;
import eipc.EIPCModule;

public abstract class QIPCModule
  extends EIPCModule
{
  public static final int[] LISTEN_MSGS = { 1 };
  
  public QIPCModule(String paramString)
  {
    super(paramString, LISTEN_MSGS);
  }
  
  public void onAccountChange() {}
  
  public void onReceiveMsg(int paramInt, Bundle paramBundle)
  {
    super.onReceiveMsg(paramInt, paramBundle);
    if (paramInt == 1) {
      onAccountChange();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\qipc\QIPCModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */