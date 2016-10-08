package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class ThemeJsPlugin$1
  implements Runnable
{
  ThemeJsPlugin$1(ThemeJsPlugin paramThemeJsPlugin, String paramString1, int paramInt1, String paramString2, long paramLong, String paramString3, String paramString4, String paramString5, int paramInt2, int paramInt3, String paramString6, String paramString7, String paramString8)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("themeId", this.val$themeId);
    localBundle.putInt("actionResult", this.val$actionResult);
    if (!TextUtils.isEmpty(this.val$actionName))
    {
      localBundle.putString("actionName", this.val$actionName);
      localBundle.putLong("downloadTime", this.val$downloadTime);
    }
    if (!TextUtils.isEmpty(this.val$statisticKey))
    {
      localBundle.putString("statistic_key", this.val$statisticKey);
      localBundle.putString("param_FailCode", this.val$failCode);
    }
    if (!TextUtils.isEmpty(this.val$from))
    {
      localBundle.putString("from", this.val$from);
      localBundle.putInt("step", this.val$step);
      localBundle.putInt("code", this.val$code);
      localBundle.putString("version", this.val$version);
      localBundle.putString("r5", this.val$r5);
      localBundle.putString("path", this.val$path);
    }
    localBundle = DataFactory.a("reportTheme", "", this.this$0.mOnRemoteResp.key, localBundle);
    this.this$0.sendRemoteReq(localBundle, false, true);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vaswebviewplugin\ThemeJsPlugin$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */