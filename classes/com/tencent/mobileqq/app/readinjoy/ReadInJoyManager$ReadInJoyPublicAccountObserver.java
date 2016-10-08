package com.tencent.mobileqq.app.readinjoy;

import android.content.Intent;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;

public class ReadInJoyManager$ReadInJoyPublicAccountObserver
  extends PublicAccountObserver
{
  private String a;
  private int i;
  private int j;
  
  public ReadInJoyManager$ReadInJoyPublicAccountObserver(int paramInt1, int paramInt2, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.i = paramInt1;
    this.j = paramInt2;
    this.a = paramString;
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    paramString = new Intent("notify_main_subscribe_follow_state");
    paramString.putExtra("follow_uin", this.a);
    paramString.putExtra("follow_uin_position", this.i);
    paramString.putExtra("follow_uin_smooth_dx", this.j);
    paramString.putExtra("follow_uin_status", paramBoolean);
    BaseApplication.getContext().sendBroadcast(paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\readinjoy\ReadInJoyManager$ReadInJoyPublicAccountObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */