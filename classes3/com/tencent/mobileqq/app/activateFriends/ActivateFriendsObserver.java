package com.tencent.mobileqq.app.activateFriends;

import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.observer.BusinessObserver;

public class ActivateFriendsObserver
  implements BusinessObserver
{
  public static final int a = 0;
  public static final String a = "key_rt_type";
  public static final int b = 1;
  public static final int c = 2;
  
  public ActivateFriendsObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a() {}
  
  public void a(int paramInt) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    switch (paramInt)
    {
    case 114: 
    default: 
      return;
    case 113: 
      a(paramBundle.getInt("key_rt_type"));
      return;
    }
    a();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\activateFriends\ActivateFriendsObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */