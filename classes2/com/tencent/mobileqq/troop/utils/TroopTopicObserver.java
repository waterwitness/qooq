package com.tencent.mobileqq.troop.utils;

import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.observer.BusinessObserver;

public class TroopTopicObserver
  implements BusinessObserver
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 3;
  
  public TroopTopicObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle) {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\utils\TroopTopicObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */