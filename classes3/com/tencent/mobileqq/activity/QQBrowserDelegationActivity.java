package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class QQBrowserDelegationActivity
  extends BaseActivity
{
  public static final int a = 10012120;
  public static final String a = "param_force_internal_browser";
  public static final int b = 10012121;
  public static final String b = "动态";
  public static final int c = 10012122;
  private Intent a;
  
  public QQBrowserDelegationActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.a = getIntent();
    if (this.a.getExtras() == null)
    {
      finish();
      return false;
    }
    paramBundle = new Intent(getIntent());
    paramBundle.putExtra("needSkey", "true");
    paramBundle.setClass(this, QQBrowserActivity.class);
    paramBundle.putExtra("startOpenPageTime", System.currentTimeMillis());
    paramBundle.putExtra("uin", this.app.a());
    startActivity(paramBundle);
    finish();
    return false;
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    mAppForground = GesturePWDUtils.getAppForground(getActivity());
    if ((!mAppForground) && (this.mCanLock) && (this.app != null) && (GesturePWDUtils.getJumpLock(getActivity(), this.app.a()))) {
      startUnlockActivity();
    }
    if (!mAppForground)
    {
      mAppForground = true;
      GesturePWDUtils.setAppForground(getActivity(), mAppForground);
    }
    this.mStopFlag = 0;
    this.mCanLock = true;
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\QQBrowserDelegationActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */