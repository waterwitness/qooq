package com.tencent.mobileqq.vas;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class ChatBackgroundMarketActivity
  extends QQBrowserActivity
{
  public static final String a = "isFromPhoto";
  
  public ChatBackgroundMarketActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    return true;
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.setIntent(paramIntent);
    boolean bool = paramIntent.getBooleanExtra("isFromPhoto", false);
    String str = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    paramIntent = paramIntent.getStringExtra("chatbg_intent_frinedUin");
    if ((bool) && (str != null) && (this.a != null))
    {
      Intent localIntent = new Intent();
      localIntent.setAction("chatbgBroadcast");
      localIntent.setPackage(this.a.a().getPackageName());
      localIntent.putExtra("friendUin", paramIntent);
      localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", str);
      this.a.a().sendBroadcast(localIntent);
      QQToast.a(this, 2131369191, 0).a();
      ReportController.b(null, "CliOper", "", "", "chatbackground", "BjIDShezhi", 0, 0, "1", "", "", "");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vas\ChatBackgroundMarketActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */