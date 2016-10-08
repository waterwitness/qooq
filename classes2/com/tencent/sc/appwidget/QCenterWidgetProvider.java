package com.tencent.sc.appwidget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class QCenterWidgetProvider
  extends BroadcastReceiver
{
  public QCenterWidgetProvider()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent) {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\sc\appwidget\QCenterWidgetProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */