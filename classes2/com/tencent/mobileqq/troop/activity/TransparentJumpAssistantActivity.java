package com.tencent.mobileqq.troop.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class TransparentJumpAssistantActivity
  extends BaseActivity
{
  public static final int a = 0;
  public static final String a = "pub_acc_uin";
  public static final String b = "pub_acc_name";
  private String c;
  private String d;
  
  public TransparentJumpAssistantActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 0)
    {
      paramIntent = new Intent(this, ChatActivity.class);
      paramIntent.putExtra("uintype", 1008);
      if (this.c != null) {
        paramIntent.putExtra("uin", this.c);
      }
      if (this.d != null) {
        paramIntent.putExtra("uinname", this.d);
      }
      paramIntent.putExtra("uintype", 1008);
      startActivity(paramIntent);
      overridePendingTransition(2130968587, 2130968588);
      finish();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903420);
    getWindow().setBackgroundDrawable(null);
    paramBundle = getIntent();
    this.c = paramBundle.getStringExtra("pub_acc_uin");
    this.d = paramBundle.getStringExtra("pub_acc_name");
    Intent localIntent = new Intent(this, ChatActivity.class);
    localIntent.putExtras(paramBundle);
    startActivityForResult(localIntent, 0);
    overridePendingTransition(2130968590, 2130968591);
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\activity\TransparentJumpAssistantActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */