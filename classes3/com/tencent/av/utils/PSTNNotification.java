package com.tencent.av.utils;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Process;
import android.widget.RemoteViews;
import com.tencent.av.app.PstnSessionInfo;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.ui.CallbackWaitingActivityExt;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.Stack;

public class PSTNNotification
{
  public static final int a = 0;
  static PSTNNotification jdField_a_of_type_ComTencentAvUtilsPSTNNotification;
  static final String jdField_a_of_type_JavaLangString = "PSTNNotification";
  public static final int b = 1;
  Notification jdField_a_of_type_AndroidAppNotification;
  NotificationManager jdField_a_of_type_AndroidAppNotificationManager;
  Context jdField_a_of_type_AndroidContentContext;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  Bundle jdField_a_of_type_AndroidOsBundle;
  RemoteViews jdField_a_of_type_AndroidWidgetRemoteViews;
  NotificationStyleDiscover jdField_a_of_type_ComTencentAvUtilsNotificationStyleDiscover;
  Stack jdField_a_of_type_JavaUtilStack;
  boolean jdField_a_of_type_Boolean;
  String b;
  final int jdField_c_of_type_Int;
  String jdField_c_of_type_JavaLangString;
  int d;
  
  PSTNNotification(Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_c_of_type_Int = 2130839140;
    this.jdField_a_of_type_AndroidAppNotification = null;
    this.jdField_a_of_type_AndroidAppNotificationManager = null;
    this.jdField_a_of_type_AndroidWidgetRemoteViews = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_c_of_type_JavaLangString = null;
    this.d = 0;
    this.jdField_a_of_type_AndroidOsBundle = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilStack = new Stack();
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    }
    this.jdField_a_of_type_AndroidAppNotification = new Notification();
    this.jdField_a_of_type_AndroidAppNotificationManager = ((NotificationManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("notification"));
    this.jdField_a_of_type_ComTencentAvUtilsNotificationStyleDiscover = new NotificationStyleDiscover(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetRemoteViews = new RemoteViews(this.jdField_a_of_type_AndroidContentContext.getPackageName(), 2130903624);
  }
  
  public static PSTNNotification a(Context paramContext)
  {
    if ((jdField_a_of_type_ComTencentAvUtilsPSTNNotification == null) && (paramContext != null)) {
      jdField_a_of_type_ComTencentAvUtilsPSTNNotification = new PSTNNotification(paramContext);
    }
    return jdField_a_of_type_ComTencentAvUtilsPSTNNotification;
  }
  
  public static void a(Context paramContext)
  {
    ((NotificationManager)paramContext.getSystemService("notification")).cancel(2130839140);
  }
  
  void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PSTNNotification", 2, "addNotification");
    }
    this.jdField_a_of_type_AndroidAppNotification = new Notification();
    this.jdField_a_of_type_AndroidAppNotificationManager = ((NotificationManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("notification"));
    this.jdField_a_of_type_AndroidWidgetRemoteViews = new RemoteViews(this.jdField_a_of_type_AndroidContentContext.getPackageName(), 2130903624);
    if (this.jdField_b_of_type_JavaLangString == null)
    {
      this.jdField_b_of_type_JavaLangString = "";
      if (QLog.isColorLevel()) {
        QLog.e("PSTNNotification", 2, "addNotification mName ==null");
      }
    }
    int i = Process.myPid();
    String str;
    switch (this.d)
    {
    default: 
      str = "";
    }
    for (;;)
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, CallbackWaitingActivityExt.class);
      localIntent.addFlags(268435456);
      localIntent.addFlags(4194304);
      localIntent.addFlags(262144);
      Object localObject1 = new PstnSessionInfo();
      Object localObject2 = (QQAppInterface)BaseApplicationImpl.a().a();
      ((PstnSessionInfo)localObject1).jdField_a_of_type_JavaLangString = ((QQAppInterface)localObject2).a().a().jdField_a_of_type_JavaLangString;
      ((PstnSessionInfo)localObject1).d = ((QQAppInterface)localObject2).a().a().d;
      ((PstnSessionInfo)localObject1).jdField_b_of_type_JavaLangString = ((QQAppInterface)localObject2).a().a().jdField_b_of_type_JavaLangString;
      ((PstnSessionInfo)localObject1).jdField_c_of_type_JavaLangString = ((QQAppInterface)localObject2).a().a().jdField_c_of_type_JavaLangString;
      ((PstnSessionInfo)localObject1).jdField_a_of_type_Int = ((QQAppInterface)localObject2).a().a().jdField_a_of_type_Int;
      ((PstnSessionInfo)localObject1).jdField_b_of_type_Int = ((QQAppInterface)localObject2).a().a().jdField_b_of_type_Int;
      localIntent.putExtra("pstn_session_info", (Parcelable)localObject1);
      localIntent.putExtra("needStopService", true);
      localObject2 = this.jdField_b_of_type_JavaLangString;
      this.jdField_a_of_type_AndroidAppNotification.tickerText = str;
      localIntent.putExtra("PID", i);
      this.jdField_a_of_type_AndroidWidgetRemoteViews.setImageViewResource(2131299485, 2130839140);
      this.jdField_a_of_type_AndroidAppNotification.icon = 2130839140;
      localObject1 = null;
      if (localIntent != null) {
        localObject1 = PendingIntent.getActivity(this.jdField_a_of_type_AndroidContentContext, 0, localIntent, 268435456);
      }
      if (this.jdField_a_of_type_ComTencentAvUtilsNotificationStyleDiscover.b() > 0.0F) {
        this.jdField_a_of_type_AndroidWidgetRemoteViews.setFloat(2131299483, "setTextSize", this.jdField_a_of_type_ComTencentAvUtilsNotificationStyleDiscover.b());
      }
      if (this.jdField_a_of_type_ComTencentAvUtilsNotificationStyleDiscover.a() > 0.0F) {
        this.jdField_a_of_type_AndroidWidgetRemoteViews.setFloat(2131299484, "setTextSize", this.jdField_a_of_type_ComTencentAvUtilsNotificationStyleDiscover.a());
      }
      this.jdField_a_of_type_AndroidWidgetRemoteViews.setTextViewText(2131299483, (CharSequence)localObject2);
      this.jdField_a_of_type_AndroidWidgetRemoteViews.setTextViewText(2131299484, str);
      try
      {
        if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
          this.jdField_a_of_type_AndroidWidgetRemoteViews.setImageViewBitmap(2131299482, this.jdField_a_of_type_AndroidGraphicsBitmap);
        }
        this.jdField_a_of_type_AndroidAppNotification.flags = 2;
        this.jdField_a_of_type_AndroidAppNotification.contentView = this.jdField_a_of_type_AndroidWidgetRemoteViews;
        this.jdField_a_of_type_AndroidAppNotification.contentIntent = ((PendingIntent)localObject1);
        this.jdField_a_of_type_AndroidAppNotificationManager.notify(2130839140, this.jdField_a_of_type_AndroidAppNotification);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
      this.jdField_a_of_type_Boolean = true;
      return;
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131364002);
      continue;
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131364009);
    }
  }
  
  public void a(int paramInt)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("PSTNNotification", 2, "updateNotification mIsActive: " + this.jdField_a_of_type_Boolean);
        }
        if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidAppNotification != null)) {
          str = "";
        }
        switch (paramInt)
        {
        case 0: 
          this.jdField_a_of_type_AndroidAppNotification.tickerText = str;
          this.jdField_a_of_type_AndroidAppNotificationManager.notify(2130839140, this.jdField_a_of_type_AndroidAppNotification);
          return;
        }
      }
      finally {}
      String str = this.jdField_a_of_type_AndroidContentContext.getString(2131364002);
      continue;
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131364009);
    }
  }
  
  public void a(String paramString1, Bitmap paramBitmap, String paramString2, int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PSTNNotification", 2, "addNotification name: " + paramString1 + ", id: " + paramString2 + ", type: " + paramInt + ", mName: " + this.jdField_b_of_type_JavaLangString + ", mId: " + this.jdField_c_of_type_JavaLangString + ", mType: " + this.d);
    }
    if ((paramString1 != null) && (paramString1.equals(this.jdField_b_of_type_JavaLangString)) && (paramBitmap == this.jdField_a_of_type_AndroidGraphicsBitmap) && (paramInt == this.d))
    {
      b();
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PSTNNotification", 2, "addNotification store");
      }
      c();
    }
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.d = paramInt;
    this.jdField_c_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    a();
    this.jdField_a_of_type_AndroidAppNotificationManager.notify(2130839140, this.jdField_a_of_type_AndroidAppNotification);
  }
  
  void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PSTNNotification", 2, "notifyNotification mIsActive: " + this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidAppNotificationManager.notify(2130839140, this.jdField_a_of_type_AndroidAppNotification);
      return;
    }
    a();
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +32 -> 37
    //   8: ldc 11
    //   10: iconst_2
    //   11: new 256	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 303
    //   21: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_0
    //   25: getfield 57	com/tencent/av/utils/PSTNNotification:jdField_a_of_type_Boolean	Z
    //   28: invokevirtual 266	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   31: invokevirtual 269	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   37: aload_0
    //   38: getfield 57	com/tencent/av/utils/PSTNNotification:jdField_a_of_type_Boolean	Z
    //   41: ifeq +84 -> 125
    //   44: aload_0
    //   45: getfield 41	com/tencent/av/utils/PSTNNotification:jdField_a_of_type_AndroidAppNotificationManager	Landroid/app/NotificationManager;
    //   48: ldc 35
    //   50: invokevirtual 104	android/app/NotificationManager:cancel	(I)V
    //   53: aload_0
    //   54: getfield 62	com/tencent/av/utils/PSTNNotification:jdField_a_of_type_JavaUtilStack	Ljava/util/Stack;
    //   57: invokevirtual 306	java/util/Stack:size	()I
    //   60: ifle +68 -> 128
    //   63: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   66: ifeq +12 -> 78
    //   69: ldc 11
    //   71: iconst_2
    //   72: ldc_w 308
    //   75: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   78: aload_0
    //   79: getfield 62	com/tencent/av/utils/PSTNNotification:jdField_a_of_type_JavaUtilStack	Ljava/util/Stack;
    //   82: invokevirtual 312	java/util/Stack:pop	()Ljava/lang/Object;
    //   85: checkcast 314	hbd
    //   88: astore_1
    //   89: aload_0
    //   90: aload_1
    //   91: getfield 315	hbd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   94: putfield 47	com/tencent/av/utils/PSTNNotification:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   97: aload_0
    //   98: aload_1
    //   99: getfield 316	hbd:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   102: putfield 49	com/tencent/av/utils/PSTNNotification:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   105: aload_0
    //   106: aload_1
    //   107: getfield 317	hbd:jdField_a_of_type_Int	I
    //   110: putfield 53	com/tencent/av/utils/PSTNNotification:d	I
    //   113: aload_0
    //   114: aload_1
    //   115: getfield 318	hbd:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   118: putfield 51	com/tencent/av/utils/PSTNNotification:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   121: aload_0
    //   122: invokevirtual 299	com/tencent/av/utils/PSTNNotification:a	()V
    //   125: aload_0
    //   126: monitorexit
    //   127: return
    //   128: aload_0
    //   129: iconst_0
    //   130: putfield 57	com/tencent/av/utils/PSTNNotification:jdField_a_of_type_Boolean	Z
    //   133: aload_0
    //   134: aconst_null
    //   135: putfield 39	com/tencent/av/utils/PSTNNotification:jdField_a_of_type_AndroidAppNotification	Landroid/app/Notification;
    //   138: goto -13 -> 125
    //   141: astore_1
    //   142: aload_0
    //   143: monitorexit
    //   144: aload_1
    //   145: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	PSTNNotification
    //   88	27	1	localhbd	hbd
    //   141	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	37	141	finally
    //   37	78	141	finally
    //   78	125	141	finally
    //   128	138	141	finally
  }
  
  public void d()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("PSTNNotification", 2, "cancelNotificationEx mIsActive: " + this.jdField_a_of_type_Boolean);
      }
      if (this.jdField_a_of_type_Boolean)
      {
        this.d = 0;
        this.jdField_c_of_type_JavaLangString = null;
        this.jdField_b_of_type_JavaLangString = null;
        this.jdField_a_of_type_AndroidGraphicsBitmap = null;
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_JavaUtilStack.clear();
        this.jdField_a_of_type_AndroidAppNotificationManager.cancel(2130839140);
        this.jdField_a_of_type_AndroidAppNotificationManager = null;
        this.jdField_a_of_type_AndroidWidgetRemoteViews = null;
        this.jdField_a_of_type_AndroidAppNotification = null;
      }
      return;
    }
    finally {}
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\utils\PSTNNotification.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */