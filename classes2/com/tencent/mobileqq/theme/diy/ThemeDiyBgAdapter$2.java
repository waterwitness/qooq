package com.tencent.mobileqq.theme.diy;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

class ThemeDiyBgAdapter$2
  extends Handler
{
  ThemeDiyBgAdapter$2(ThemeDiyBgAdapter paramThemeDiyBgAdapter, Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      paramMessage = (Bundle)paramMessage.obj;
      if (paramMessage != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e(ThemeDiyBgAdapter.TAG, 2, "-->adapter HANDLER_MSG_SHOW_THUM bundle = null");
    return;
    int i = paramMessage.getInt("index");
    this.this$0.showThumn(i, null, true);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\theme\diy\ThemeDiyBgAdapter$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */