package com.tencent.mobileqq.activity.phone;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class MyBusinessActivity
  extends PublicAccountBrowser
{
  public static final int a = 2;
  public static final String a = "MyBusinessActivity_NeedRefreshPage";
  
  public MyBusinessActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent(paramActivity, MyBusinessActivity.class);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("title", paramActivity.getString(2131371273));
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("hideRightButton", true);
    paramActivity.startActivity(localIntent);
  }
  
  public static void f(boolean paramBoolean)
  {
    PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.a()).edit().putBoolean("MyBusinessActivity_NeedRefreshPage", paramBoolean).commit();
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  protected void onRestart()
  {
    super.onRestart();
    if (PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.a()).getBoolean("MyBusinessActivity_NeedRefreshPage", false))
    {
      if (this.a != null) {
        this.a.reload();
      }
      f(false);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\mobileqq\activity\phone\MyBusinessActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */