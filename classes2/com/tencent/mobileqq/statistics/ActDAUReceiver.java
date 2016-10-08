package com.tencent.mobileqq.statistics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ActDAUReceiver
  extends BroadcastReceiver
{
  public static final String a = "com.tencent.mobileqq.statistics.ActDAUReceiver";
  public static final String b = "act_name";
  
  public ActDAUReceiver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (!"Success".equals(BaseApplicationImpl.sInjectResult)) {}
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\statistics\ActDAUReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */