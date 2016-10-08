package com.tencent.mobileqq.widget;

import android.app.Activity;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import wny;

public class QQProgressNotifier
{
  public static final int a = 0;
  public static final String a = "QQProgressNotifier";
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public static final int f = 5;
  public static final int g = 6;
  protected static final int i = 1;
  protected static final int j = 2;
  public Activity a;
  protected Handler a;
  protected QQProgressDialog a;
  int h;
  
  public QQProgressNotifier(Activity paramActivity)
  {
    this(paramActivity, -1);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public QQProgressNotifier(Activity paramActivity, int paramInt)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.h = paramInt;
    this.jdField_a_of_type_AndroidOsHandler = new wny(this, Looper.getMainLooper());
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramInt1, this.jdField_a_of_type_AndroidAppActivity.getString(paramInt2), paramInt3);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    a(paramInt1, paramString, paramInt2, null);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    if ((paramInt1 == 0) && (paramInt2 > 0))
    {
      paramOnCancelListener = Message.obtain();
      paramOnCancelListener.what = 1;
      paramOnCancelListener.arg1 = paramInt1;
      paramOnCancelListener.arg2 = 0;
      paramOnCancelListener.obj = paramString;
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramOnCancelListener, paramInt2);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      if (this.h > 0) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidAppActivity, 0, this.h, 17);
      }
    }
    else
    {
      label102:
      if (paramInt1 != 0) {
        break label270;
      }
      if (paramOnCancelListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setOnCancelListener(paramOnCancelListener);
      }
      if ((paramString != null) && (!"".equals(paramString.trim()))) {
        break label251;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(this.jdField_a_of_type_AndroidAppActivity.getString(2131368647));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(true);
      if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
        break label262;
      }
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.d("QQProgressNotifier", 4, "[" + this.jdField_a_of_type_AndroidAppActivity.isFinishing() + "]");
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131492908));
      break label102;
      label251:
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
    }
    label262:
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    return;
    label270:
    if ((paramInt1 == 2) || (paramInt1 == 4) || (paramInt1 == 6))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2130838442);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(false);
      if (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())
      {
        if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
          break label439;
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("QQProgressNotifier", 4, "[" + this.jdField_a_of_type_AndroidAppActivity.isFinishing() + "]");
        }
      }
      label381:
      paramString = Message.obtain();
      paramString.what = 2;
      paramString.arg1 = paramInt1;
      paramOnCancelListener = this.jdField_a_of_type_AndroidOsHandler;
      if (paramInt2 <= 0) {
        break label449;
      }
    }
    label439:
    label449:
    for (long l = paramInt2;; l = 1000L)
    {
      paramOnCancelListener.sendMessageDelayed(paramString, l);
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2130838452);
      break;
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      break label381;
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing());
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\widget\QQProgressNotifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */