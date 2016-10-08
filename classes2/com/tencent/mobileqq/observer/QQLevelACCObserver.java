package com.tencent.mobileqq.observer;

import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class QQLevelACCObserver
  implements BusinessObserver
{
  public static final int a = 1;
  public static final String a = "key_qqlevelacc";
  private static String b = "QQLevelACCObserver";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, int paramInt) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (1 == paramInt)
    {
      paramInt = 0;
      if (paramBundle.containsKey("key_qqlevelacc")) {
        paramInt = paramBundle.getInt("key_qqlevelacc");
      }
      if (QLog.isColorLevel()) {
        QLog.d(b, 2, "onReceive:--speed=" + paramInt);
      }
      a(paramBoolean, paramInt);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\observer\QQLevelACCObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */