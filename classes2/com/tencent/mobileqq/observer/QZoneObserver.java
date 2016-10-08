package com.tencent.mobileqq.observer;

import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZoneLogTags;
import mqq.observer.BusinessObserver;

public class QZoneObserver
  implements BusinessObserver
{
  public static final int a = 1000;
  public static final String a = QZoneLogTags.b + "QZoneObserver";
  public static final int b = 1001;
  public static final int c = 1002;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, Bundle paramBundle) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt) {}
  
  protected void b(boolean paramBoolean, Bundle paramBundle) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt == 1000)
    {
      boolean bool = paramBundle.getBoolean("new");
      paramInt = paramBundle.getInt("notify_type", -1);
      if (QLog.isColorLevel())
      {
        if (17 == paramInt) {
          QLog.d(QZoneLogTags.e + a, 2, "onReceive QZONE_GET_UNREAD hasNew: " + bool + "type:" + paramInt + "and then call onGetQZoneFeedCountFin");
        }
        QLog.d(QZoneLogTags.b + a, 2, "onReceive QZONE_GET_UNREAD hasNew: " + bool + "type:" + paramInt + "and then call onGetQZoneFeedCountFin");
      }
      a(paramBoolean, bool, paramInt);
    }
    do
    {
      return;
      if (paramInt == 1001)
      {
        a(paramBoolean, paramBundle);
        return;
      }
    } while (paramInt != 1002);
    b(paramBoolean, paramBundle);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\observer\QZoneObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */