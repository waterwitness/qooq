package com.tencent.mobileqq.search.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class BaseSearchActivity$CancelReceiver
  extends BroadcastReceiver
{
  public BaseSearchActivity$CancelReceiver(BaseSearchActivity paramBaseSearchActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.mobileqq.search.cancel".equals(paramIntent.getAction())) {
      this.a.finish();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\activity\BaseSearchActivity$CancelReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */