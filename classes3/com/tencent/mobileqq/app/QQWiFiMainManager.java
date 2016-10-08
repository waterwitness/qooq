package com.tencent.mobileqq.app;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.manager.Manager;

public class QQWiFiMainManager
  implements Manager
{
  public static final int a = 1;
  public static final String a = "QQWiFiMainManager";
  public static final int b = 2;
  public QQWiFiMainManager.RemoteResultReceiver a;
  
  QQWiFiMainManager(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new QQWiFiMainManager.RemoteResultReceiver(paramQQAppInterface, new Handler(Looper.getMainLooper()));
  }
  
  public void onDestroy() {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\QQWiFiMainManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */