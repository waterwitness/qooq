package com.tencent.mobileqq.servlet;

import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.observer.BusinessObserver;

public class ReduFriendObserver
  implements BusinessObserver
{
  public ReduFriendObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle) {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\servlet\ReduFriendObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */