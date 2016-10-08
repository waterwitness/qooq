package com.tencent.mobileqq.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import wob;
import woc;

public class QQToastNotifier
{
  private static final int jdField_a_of_type_Int = 1;
  public Context a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  public Toast a;
  
  public QQToastNotifier(Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidWidgetToast = null;
    this.jdField_a_of_type_AndroidOsHandler = new wob(this, Looper.getMainLooper());
    this.jdField_a_of_type_AndroidContentContext = BaseApplication.getContext();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidWidgetToast != null) {
      this.jdField_a_of_type_AndroidWidgetToast.cancel();
    }
  }
  
  public void a(int paramInt)
  {
    a(paramInt, 0, 0, 0);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2, 0, 0);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    woc localwoc = new woc(null);
    localwoc.jdField_a_of_type_Int = paramInt4;
    localwoc.b = paramInt1;
    localwoc.c = paramInt3;
    localwoc.d = paramInt2;
    localMessage.obj = localwoc;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    woc localwoc = new woc(null);
    localwoc.jdField_a_of_type_Int = paramInt3;
    localwoc.jdField_a_of_type_JavaLangString = paramString;
    localwoc.c = paramInt2;
    localwoc.d = paramInt1;
    localMessage.obj = localwoc;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\widget\QQToastNotifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */