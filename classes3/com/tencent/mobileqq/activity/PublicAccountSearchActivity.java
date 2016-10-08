package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.WebViewPluginFactory;
import java.util.HashMap;

public class PublicAccountSearchActivity
{
  public static final String a = "PublicAccountSearchActivity";
  private static final String b = "http://find.mp.qq.com/search/index?_wv=67109947&keyword=";
  private static final String c = "http://dyzx.mp.qq.com/static/v8/page/subscribeindex.html?_wv=67109947&_bid=2278&_wwv=1";
  
  public PublicAccountSearchActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(Activity paramActivity)
  {
    b(paramActivity);
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent(paramActivity, PublicAccountBrowser.class);
    if ((paramActivity instanceof BaseActivity)) {
      localIntent.putExtra("uin", ((QQAppInterface)((BaseActivity)paramActivity).getAppRuntime()).a());
    }
    if (WebViewPluginFactory.a.containsKey("PublicAccountJs")) {
      localIntent.putExtra("insertPluginsArray", new String[] { "PublicAccountJs" });
    }
    localIntent.putExtra("fromLocalUrl", true);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("hideRightButton", true);
    localIntent.putExtra("leftViewText", paramActivity.getString(2131371914));
    localIntent.putExtra("assignBackText", paramActivity.getString(2131371914));
    if (TextUtils.isEmpty(paramString)) {
      localIntent.putExtra("url", PublicAccountConfigUtil.B);
    }
    for (;;)
    {
      paramActivity.startActivity(localIntent);
      return;
      localIntent.putExtra("url", "http://find.mp.qq.com/search/index?_wv=67109947&keyword=" + paramString);
    }
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    Intent localIntent = new Intent(paramActivity, PublicAccountBrowser.class);
    if (TextUtils.isEmpty(paramString2)) {
      if ((paramActivity instanceof BaseActivity)) {
        localIntent.putExtra("uin", ((QQAppInterface)((BaseActivity)paramActivity).getAppRuntime()).a());
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramString1))
      {
        localIntent.putExtra("leftViewText", paramString1);
        localIntent.putExtra("assignBackText", paramString1);
      }
      if (WebViewPluginFactory.a.containsKey("PublicAccountJs")) {
        localIntent.putExtra("insertPluginsArray", new String[] { "PublicAccountJs" });
      }
      paramString1 = paramString3;
      if (TextUtils.isEmpty(paramString3)) {
        paramString1 = "http://dyzx.mp.qq.com/static/v8/page/subscribeindex.html?_wv=67109947&_bid=2278&_wwv=1";
      }
      localIntent.putExtra("fromLocalUrl", true);
      localIntent.putExtra("hide_operation_bar", true);
      localIntent.putExtra("url", paramString1);
      localIntent.putExtra("hideRightButton", true);
      paramActivity.startActivity(localIntent);
      return;
      localIntent.putExtra("uin", paramString2);
    }
  }
  
  private static void b(Activity paramActivity)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("last_key_words", "");
    localIntent.putExtra("from_key", 2);
    localIntent.putExtra(ClassificationSearchActivity.jdField_c_of_type_JavaLangString, ClassificationSearchActivity.jdField_c_of_type_Int);
    localIntent.setClass(paramActivity, ClassificationSearchActivity.class);
    ClassificationSearchActivity.a(paramActivity, localIntent, null);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\PublicAccountSearchActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */