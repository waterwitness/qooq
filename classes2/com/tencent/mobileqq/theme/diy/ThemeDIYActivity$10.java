package com.tencent.mobileqq.theme.diy;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class ThemeDIYActivity$10
  extends Handler
{
  ThemeDIYActivity$10(ThemeDIYActivity paramThemeDIYActivity, Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      QLog.e("ThemeDIYActivity", 1, "Handler = default");
    }
    do
    {
      do
      {
        do
        {
          return;
          if (paramMessage.obj == null)
          {
            QLog.e("ThemeDIYActivity", 1, "-->handleMessage HANDLER_MSG_RES_PIC_DOWNLOADED msg.obj = null");
            return;
          }
          paramMessage = (Bundle)paramMessage.obj;
          if (paramMessage == null)
          {
            QLog.e("ThemeDIYActivity", 1, "-->handleMessage HANDLER_MSG_RES_PIC_DOWNLOADED bundle = null");
            return;
          }
          if (paramMessage.getInt("picType") == 3) {
            this.this$0.showDefaultImage(null, paramMessage.getInt("index"), true);
          }
          for (;;)
          {
            this.this$0.setProgressBar(null, paramMessage.getInt("index"), false);
            return;
            if (paramMessage.getInt("picType") == 1) {
              this.this$0.showDiyImage(null, paramMessage.getInt("index"), true);
            } else if (paramMessage.getInt("picType") == 2) {
              this.this$0.showScreenShot(null, paramMessage.getInt("index"), true);
            } else if (paramMessage.getInt("picType") == 0) {
              this.this$0.showScreenShot(null, paramMessage.getInt("index"), true);
            }
          }
          this.this$0.bgAdapter.notifyDataSetChanged();
          this.this$0.themeAdapter.notifyDataSetChanged();
          return;
          int i = Integer.parseInt(paramMessage.obj.toString());
          this.this$0.showScreenShot(null, i, false);
          return;
          this.this$0.mHandler.removeMessages(24);
          this.this$0.setProgessDialog(false, 0);
          QQToast.a(this.this$0.mContext, 2131368383, 3000).b(this.this$0.mContext.getResources().getDimensionPixelSize(2131492908));
          return;
          if (paramMessage.obj == null)
          {
            this.this$0.saveOperate(false);
            return;
          }
          this.this$0.saveOperate(true);
          return;
        } while (paramMessage.obj == null);
        this.this$0.setProgressText(paramMessage.obj.toString());
        return;
        this.this$0.setProgessDialog(false, 0);
      } while (paramMessage.obj == null);
      QQToast.a(this.this$0.mContext, paramMessage.obj.toString(), 3600).b(this.this$0.mContext.getResources().getDimensionPixelSize(2131492908));
      return;
    } while (paramMessage.obj == null);
    QQToast.a(this.this$0.mContext, paramMessage.obj.toString(), 3600).b(this.this$0.mContext.getResources().getDimensionPixelSize(2131492908));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\theme\diy\ThemeDIYActivity$10.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */