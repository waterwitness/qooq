package com.tencent.open.downloadnew.common;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class DownloadReceiverWebProcess
  extends DownloadReceiver
{
  public DownloadReceiverWebProcess()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    super.onReceive(paramContext, paramIntent);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\downloadnew\common\DownloadReceiverWebProcess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */