package com.tencent.mfsdk.reporter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mfsdk.collector.ResultObject;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ROReceiver
  extends BroadcastReceiver
{
  public ROReceiver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    ReporterMachine.a((ResultObject)paramIntent.getSerializableExtra("resultObj"));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mfsdk\reporter\ROReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */