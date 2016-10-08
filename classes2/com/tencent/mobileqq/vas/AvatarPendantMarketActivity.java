package com.tencent.mobileqq.vas;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import java.util.HashMap;
import java.util.Map;

public class AvatarPendantMarketActivity
  extends QQBrowserActivity
{
  public static final String a = "key_update_flag";
  public static final String b = "key_page_open_time";
  
  public AvatarPendantMarketActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    ReportController.b(this.app, "CliOper", "", "", "PendantMarket", "WebviewCreate", 0, 0, "", "", "", "");
    return super.doOnCreate(paramBundle);
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    WebViewPluginEngine localWebViewPluginEngine = this.a.a();
    if (localWebViewPluginEngine != null)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("intent", paramIntent);
      localWebViewPluginEngine.a(this.ab, 8589934605L, localHashMap);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vas\AvatarPendantMarketActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */