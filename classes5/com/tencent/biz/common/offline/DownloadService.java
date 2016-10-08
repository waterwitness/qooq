package com.tencent.biz.common.offline;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Messenger;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import hgp;

public class DownloadService
  extends BroadcastReceiver
{
  Messenger a;
  
  public DownloadService()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = null;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (NetworkUtil.a(paramContext) == 1) {
      hgp.a();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\common\offline\DownloadService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */