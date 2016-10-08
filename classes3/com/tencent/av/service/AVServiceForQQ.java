package com.tencent.av.service;

import android.app.Notification;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.IBinder;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import gmx;
import mqq.app.AppService;

public class AVServiceForQQ
  extends AppService
{
  public Notification a;
  public VideoAppInterface a;
  private gmx a;
  public String a;
  
  public AVServiceForQQ()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "AVServiceForQQ";
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_AndroidAppNotification = null;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    if ((this.app instanceof VideoAppInterface)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)this.app);
    }
    return this.jdField_a_of_type_Gmx;
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (this.jdField_a_of_type_Gmx == null) {
      this.jdField_a_of_type_Gmx = new gmx(this, null);
    }
    try
    {
      if (Build.VERSION.SDK_INT < 18) {
        startForeground(3886, new Notification());
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void onDestroy()
  {
    try
    {
      if ((Build.VERSION.SDK_INT < 18) || (this.jdField_a_of_type_AndroidAppNotification != null))
      {
        stopForeground(true);
        this.jdField_a_of_type_AndroidAppNotification = null;
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    super.onDestroy();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onStartCommand");
    }
    if ((this.app instanceof VideoAppInterface)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)this.app);
    }
    return 2;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\service\AVServiceForQQ.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */