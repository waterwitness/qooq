package com.tencent.mobileqq.qzonealbumreddot;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import uan;
import uao;

public class QzonePhotoGuideNotifyService
{
  private static final String jdField_a_of_type_JavaLangString = "QzonePhotoGuideNotifyServlet";
  private static final String b = "com.qzonex.localalbum.new_photo_notification_feedback_action";
  private static final String c = "com.qzonex.localalbum.new_photo_notification_action";
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  public Handler a;
  protected QQAppInterface a;
  public QzoneAlbumRedTouchManager a;
  public Runnable a;
  
  public QzonePhotoGuideNotifyService(QQAppInterface paramQQAppInterface, QzoneAlbumRedTouchManager paramQzoneAlbumRedTouchManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangRunnable = new uan(this);
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new uao(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqQzonealbumreddotQzoneAlbumRedTouchManager = paramQzoneAlbumRedTouchManager;
    if (paramQQAppInterface != null) {}
    try
    {
      paramQzoneAlbumRedTouchManager = new IntentFilter("com.qzonex.localalbum.new_photo_notification_feedback_action");
      paramQQAppInterface.a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramQzoneAlbumRedTouchManager);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("QzonePhotoGuideNotifyServlet", 1, "registerreceiver fail:" + paramQQAppInterface);
    }
  }
  
  public static boolean a(Context paramContext, int paramInt)
  {
    boolean bool = false;
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo("com.qzone", 128);
      if ((paramContext == null) || (paramContext.metaData == null)) {
        break label50;
      }
      i = paramContext.metaData.getInt("com.qzone.versioncode");
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        int i = 0;
      }
    }
    if (i >= paramInt) {
      bool = true;
    }
    return bool;
  }
  
  public void a()
  {
    try
    {
      Intent localIntent = new Intent("com.qzonex.localalbum.new_photo_notification_action");
      localIntent.setComponent(new ComponentName("com.qzone", "com.qzonex.proxy.localalbum.business.NewPhotoNotificationService"));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().startService(localIntent);
      if (QLog.isColorLevel()) {
        QLog.i("QzonePhotoGuideNotifyServlet", 2, "calling qzone");
      }
      this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.b());
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 10000L);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("QzonePhotoGuideNotifyServlet", 1, "startService fail:" + localException);
      }
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QzonePhotoGuideNotifyServlet", 1, "stopService fail:" + localException);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\qzonealbumreddot\QzonePhotoGuideNotifyService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */