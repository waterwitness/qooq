package com.tencent.mobileqq.app.readinjoy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.concurrent.ExecutorService;
import qnx;

public class ReadInJoyManager$NotifyReceiver
  extends BroadcastReceiver
{
  public ReadInJoyManager$NotifyReceiver(ReadInJoyManager paramReadInJoyManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    ReadInJoyManager.a(this.a).execute(new qnx(this, paramIntent));
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\readinjoy\ReadInJoyManager$NotifyReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */