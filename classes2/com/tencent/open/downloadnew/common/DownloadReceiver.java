package com.tencent.open.downloadnew.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.appcommon.Common;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.AppUtil;
import wxq;

public class DownloadReceiver
  extends BroadcastReceiver
{
  public DownloadReceiver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str2;
    if (paramIntent != null)
    {
      str2 = paramIntent.getStringExtra("processName");
      if ((!TextUtils.isEmpty(str2)) && (str2.equalsIgnoreCase(Common.u()))) {
        break label32;
      }
    }
    label32:
    String str1;
    String str3;
    do
    {
      do
      {
        return;
        str1 = paramIntent.getAction();
        paramIntent = (NoticeParam)paramIntent.getParcelableExtra("noticeParam");
      } while (paramIntent == null);
      str3 = str2.replace(":", ".");
      if ((IntentFactory.f + "." + str3).equals(str1))
      {
        AppUtil.a(paramContext, paramIntent.d);
        return;
      }
      LogUtility.b("vivi", "processName :" + str2 + " | formatStr:" + str3);
      str2 = paramIntent.a;
    } while (TextUtils.isEmpty(str2));
    ThreadManager.b(new wxq(this, str2, paramIntent, str3, str1, paramContext));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\downloadnew\common\DownloadReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */