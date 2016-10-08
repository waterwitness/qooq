package com.tencent.mobileqq.theme.diy;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.theme.ThemeReporter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ThemeDiyStyleLogic$1
  extends DownloadListener
{
  ThemeDiyStyleLogic$1(ThemeDiyStyleLogic paramThemeDiyStyleLogic, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    Object localObject = paramDownloadTask.a();
    if (((Bundle)localObject).getInt("nowOperate") == 12) {
      if (this.this$0.saveDealCallBack != null)
      {
        if ((paramDownloadTask.a() != 3) || (paramDownloadTask.z != 0)) {
          break label180;
        }
        if (QLog.isColorLevel()) {
          QLog.i("ThemeDiyStyleLogic", 2, "downLoadStyleZip onDone: OPERATE_KEY_DOWN_STYLE OK:" + (String)paramDownloadTask.a.get(0));
        }
        this.this$0.saveDealCallBack.callback(12, 4, (Bundle)localObject, null);
        localQQAppInterface = this.this$0.app;
        i = NetworkUtil.a(null);
        if (localObject == null) {
          break label168;
        }
        paramDownloadTask = ((Bundle)localObject).getString("id");
        if (localObject == null) {
          break label174;
        }
        str = ((Bundle)localObject).getString("version");
        ThemeReporter.a(localQQAppInterface, "theme_detail", "201", 153, i, 9, paramDownloadTask, str, ThemeReporter.t, "");
      }
    }
    label168:
    label174:
    label180:
    label319:
    while ((((Bundle)localObject).getInt("nowOperate") != 13) || (this.this$0.saveDealCallBack == null))
    {
      String str;
      for (;;)
      {
        return;
        paramDownloadTask = "";
        continue;
        str = "";
      }
      if (QLog.isColorLevel()) {
        QLog.i("ThemeDiyStyleLogic", 2, "downLoadStyleZip onDone: OPERATE_KEY_DOWN_STYLE ERROR:" + (String)paramDownloadTask.a.get(0));
      }
      this.this$0.saveDealCallBack.callback(12, 8, (Bundle)localObject, null);
      QQAppInterface localQQAppInterface = this.this$0.app;
      int i = NetworkUtil.a(null);
      int j = paramDownloadTask.z;
      if (localObject != null)
      {
        str = ((Bundle)localObject).getString("id");
        if (localObject == null) {
          break label319;
        }
      }
      for (localObject = ((Bundle)localObject).getString("version");; localObject = "")
      {
        ThemeReporter.a(localQQAppInterface, "theme_detail", "201", 153, i, j, str, (String)localObject, String.valueOf(paramDownloadTask.a()), "");
        return;
        str = "";
        break;
      }
    }
    if ((paramDownloadTask.a() == 3) && (paramDownloadTask.z == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ThemeDiyStyleLogic", 2, "downLoadBgPic onDone : OPERATE_KEY_DOWN_BG OK:" + (String)paramDownloadTask.a.get(0));
      }
      this.this$0.saveDealCallBack.callback(13, 4, (Bundle)localObject, null);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ThemeDiyStyleLogic", 2, "downLoadBgPic onDone : OPERATE_KEY_DOWN_BG ERROR:" + (String)paramDownloadTask.a.get(0));
    }
    this.this$0.saveDealCallBack.callback(13, 8, (Bundle)localObject, null);
  }
  
  public void onProgress(DownloadTask paramDownloadTask) {}
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    return super.onStart(paramDownloadTask);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\theme\diy\ThemeDiyStyleLogic$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */