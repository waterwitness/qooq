package com.tencent.biz.webviewbase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.subscript.SubscriptFeedsNewActivity;
import com.tencent.gamecenter.activities.GameCenterActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class WebViewJumpAction
  extends Activity
{
  public static final int a = 0;
  public static final String a = "targetID";
  private static HashMap a;
  public static final int b = 1;
  public static final String b = "from_conversation";
  public static final int c = 2;
  public static final String c = "web_died";
  private static final String d = "AIOProxyActivity";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    a = new HashMap();
    a.put(Integer.valueOf(0), GameCenterActivity.class);
    a.put(Integer.valueOf(1), SubscriptFeedsNewActivity.class);
    a.put(Integer.valueOf(2), PublicAccountBrowser.class);
  }
  
  private void a()
  {
    Intent localIntent = getIntent();
    if ((localIntent == null) || (localIntent.getBooleanExtra("from_conversation", false)) || (localIntent.getBooleanExtra("web_died", false))) {}
    for (;;)
    {
      finish();
      return;
      Class localClass = (Class)a.get(Integer.valueOf(localIntent.getIntExtra("targetID", -1)));
      if (localClass != null)
      {
        localIntent.setFlags(localIntent.getFlags() ^ 0x10000000 | 0x20000);
        localIntent.removeCategory("android.intent.category.LAUNCHER");
        localIntent.setAction(null);
        localIntent.setClass(this, localClass);
        startActivity(localIntent);
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("AIOProxyActivity", 2, "-->onCreate");
    }
    a();
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("AIOProxyActivity", 2, "-->onNewIntent");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\webviewbase\WebViewJumpAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */