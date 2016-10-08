package com.tencent.mobileqq.theme.diy;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;

class ThemeDIYActivity$9
  extends DownloadListener
{
  ThemeDIYActivity$9(ThemeDIYActivity paramThemeDIYActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    Bundle localBundle = paramDownloadTask.a();
    if (localBundle.getInt("type") == 1) {}
    do
    {
      for (;;)
      {
        return;
        if (localBundle.getInt("type") != 0) {
          break;
        }
        if ((paramDownloadTask.a() == 3) && (paramDownloadTask.z == 0)) {}
        while (localBundle.getInt("picType") != 0)
        {
          this.this$0.mHandler.sendMessage(Message.obtain(this.this$0.mHandler, 20, localBundle));
          return;
          QLog.e("ThemeDIYActivity", 1, "DownloadListener fail,status:" + paramDownloadTask.a() + ",errCode:" + paramDownloadTask.z + ",url:" + paramDownloadTask.a);
          this.this$0.mHandler.sendMessage(Message.obtain(this.this$0.mHandler, 27, "下载资源失败"));
        }
      }
    } while (localBundle.getInt("type") != 2);
    this.this$0.loadResJson(false);
  }
  
  public void onNetMobile2None()
  {
    QLog.e("ThemeDIYActivity", 2, "DownloadListener onNetMobile2None...");
    this.this$0.mHandler.sendMessage(Message.obtain(this.this$0.mHandler, 27, "网络异常"));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\theme\diy\ThemeDIYActivity$9.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */