package com.tencent.mobileqq.theme.diy;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;

class ThemeDiyBgAdapter$1
  extends DownloadListener
{
  ThemeDiyBgAdapter$1(ThemeDiyBgAdapter paramThemeDiyBgAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    if ((paramDownloadTask.a() == 3) && (paramDownloadTask.z == 0)) {}
    paramDownloadTask = paramDownloadTask.a();
    if (paramDownloadTask.getInt("type") == 1) {}
    do
    {
      do
      {
        return;
        if (paramDownloadTask.getInt("type") != 0) {
          break;
        }
      } while ((paramDownloadTask.getInt("picType") != 4) && (paramDownloadTask.getInt("picType") != 3));
      this.this$0.mHandler.sendMessage(Message.obtain(this.this$0.mHandler, 100, paramDownloadTask));
      return;
    } while (paramDownloadTask.getInt("type") != 2);
  }
  
  public void onProgress(DownloadTask paramDownloadTask) {}
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    return super.onStart(paramDownloadTask);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\theme\diy\ThemeDiyBgAdapter$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */