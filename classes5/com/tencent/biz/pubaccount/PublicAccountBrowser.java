package com.tencent.biz.pubaccount;

import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.biz.webviewbase.WebAIOController;
import com.tencent.biz.webviewbase.WebAIOController.Builder;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler.SwiftBrowserUIStyle;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import hpe;
import hpf;
import hpg;
import hph;
import java.util.regex.Pattern;

public class PublicAccountBrowser
  extends QQBrowserActivity
  implements View.OnClickListener
{
  public static final String A = "http://url.cn/JS8oE7";
  public static final String B = "source_name";
  public static final long a = 100298324L;
  private static final String jdField_a_of_type_JavaLangString = "正在阅读 %s: %s";
  public static final int b = 1001;
  protected static final int c = 9;
  static final String c = "PublicAccountBrowser";
  protected static final int d = 3;
  public static final String d = "2632129500";
  public static final String e = "hideRightButton";
  public static final String f = "url";
  public static final String g = "title";
  public static final String h = "hide_operation_bar";
  public static final String i = "puin";
  public static final String j = "assignBackText";
  public static final String k = "uin";
  public static final String l = "uin_name";
  public static final String m = "uin_type";
  public static final String n = "openid";
  public static final String o = "token";
  public static final String p = "msg_id";
  public static final String q = "switch_msg_btn";
  public static final String r = "call_from";
  public static final String s = "http://s.p.qq.com/pub/msg";
  public static final String t = "http://s.p.qq.com/pub/show";
  public static final String u = "http://s.p.qq.com/pub/history";
  public static final String v = "http://s.p.qq.com/pub/jump";
  public static final String w = "http://browserApp.p.qq.com/";
  public static final String y = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=%s";
  public static final String z = "mqqapi://card/show_pslcard?src_type=internal&card_type=public_account&uin=%s&version=1";
  private int jdField_a_of_type_Int;
  protected Bundle a;
  WebAIOController jdField_a_of_type_ComTencentBizWebviewbaseWebAIOController;
  public final Pattern a;
  protected boolean b;
  protected boolean c;
  protected boolean d;
  protected boolean e;
  protected boolean f;
  protected boolean g;
  protected String x;
  
  public PublicAccountBrowser()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("<meta.*itemprop=\"name\"\\s.*content=\"(.*)\">");
    this.jdField_a_of_type_Int = -1;
  }
  
  private void a()
  {
    boolean bool2 = false;
    Intent localIntent = super.getIntent();
    this.jdField_a_of_type_AndroidOsBundle = localIntent.getExtras();
    this.J = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
    this.x = this.jdField_a_of_type_AndroidOsBundle.getString("uin_name");
    this.t = this.jdField_a_of_type_AndroidOsBundle.getInt("uin_type");
    String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("openid");
    String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("token");
    Object localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("url");
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("PublicAccountBrowser", 2, "url not found, use \"\" default");
      }
      localObject1 = "";
    }
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountBrowser", 2, "get a url:" + Util.b((String)localObject1, new String[0]));
    }
    localObject2 = localObject1;
    if (((String)localObject1).startsWith("http://browserApp.p.qq.com/"))
    {
      localObject2 = localObject1;
      if (!((String)localObject1).contains("?")) {
        localObject2 = (String)localObject1 + "?";
      }
      localObject2 = (String)localObject2 + "&openid=" + str1 + "&token=" + str2;
      localIntent.putExtra("url", (String)localObject2);
    }
    localObject1 = Uri.parse((String)localObject2);
    if ((localObject1 != null) && (((Uri)localObject1).isHierarchical()))
    {
      localObject1 = ((Uri)localObject1).getQueryParameter("_wv");
      if (localObject1 == null) {}
    }
    try
    {
      this.jdField_c_of_type_Long = Long.parseLong(((String)localObject1).trim());
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a.jdField_a_of_type_Long = this.jdField_c_of_type_Long;
      this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidOsBundle.getInt("call_from");
      localIntent.removeExtra("call_from");
      this.aw = this.jdField_a_of_type_AndroidOsBundle.getString("puin");
      this.ax = this.jdField_a_of_type_AndroidOsBundle.getString("msg_id");
      if (this.ax == null) {
        this.ax = "";
      }
      if (!this.jdField_a_of_type_AndroidOsBundle.getBoolean("hide_operation_bar"))
      {
        bool1 = true;
        this.jdField_c_of_type_Boolean = bool1;
        if ((!((String)localObject2).startsWith("http://s.p.qq.com/pub/msg")) && (!((String)localObject2).startsWith("http://s.p.qq.com/pub/show"))) {
          break label604;
        }
        bool1 = true;
        this.b = bool1;
        if (!this.jdField_a_of_type_AndroidOsBundle.containsKey("hide_operation_bar"))
        {
          if (this.b) {
            break label610;
          }
          bool1 = true;
          this.jdField_c_of_type_Boolean = bool1;
          if (this.jdField_c_of_type_Boolean) {
            break label616;
          }
          bool1 = true;
          localIntent.putExtra("hide_operation_bar", bool1);
        }
        localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("webStyle");
        if ((localObject1 != null) && (((String)localObject1).equals("noBottomBar"))) {
          this.jdField_c_of_type_Boolean = false;
        }
        localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("disableshare");
        if (!this.jdField_a_of_type_AndroidOsBundle.getBoolean("hideRightButton", false))
        {
          bool1 = bool2;
          if (localObject1 != null)
          {
            bool1 = bool2;
            if (!((String)localObject1).equals("true")) {}
          }
        }
        else
        {
          bool1 = true;
        }
        this.g = bool1;
        localObject1 = (SwiftBrowserShareMenuHandler)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider.a(4);
        if ((!this.g) && ((this.jdField_c_of_type_Long & 0x2378) == 9080L) && (!((SwiftBrowserShareMenuHandler)localObject1).a())) {
          this.g = true;
        }
        localIntent.putExtra("url", (String)localObject2);
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        boolean bool1;
        if (QLog.isDevelopLevel())
        {
          QLog.d("QQBrowser", 4, "sorry, i can not get rules from QQBrowser url, maybe have more than one '_wv' in the url");
          continue;
          bool1 = false;
          continue;
          label604:
          bool1 = false;
          continue;
          label610:
          bool1 = false;
          continue;
          label616:
          bool1 = false;
        }
      }
    }
  }
  
  private void a(Bundle paramBundle)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface != null) && (!NetworkUtil.e(this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.getApplication()))) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.getApplication(), 2131367481, 0).b(super.getTitleBarHeight());
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a.jdField_a_of_type_Boolean)
    {
      paramBundle = this.jdField_a_of_type_AndroidOsBundle.getString("assignBackText");
      if (!TextUtils.isEmpty(paramBundle)) {
        this.leftView.setText(paramBundle);
      }
      if (this.g) {
        break label175;
      }
      this.rightViewText.setText("");
      this.rightViewImg.setImageResource(2130838290);
      this.rightViewImg.setContentDescription(super.getText(2131368933));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Int == 1001)
      {
        this.leftView.setVisibility(8);
        this.rightViewImg.setVisibility(8);
        this.rightViewText.setText("跳过");
        this.rightViewText.setOnClickListener(this);
        this.rightViewText.setVisibility(0);
      }
      return;
      label175:
      this.rightViewText.setVisibility(8);
      this.rightViewImg.setVisibility(8);
      int i1 = (int)DisplayUtils.a(this, 8.0F);
      ((RelativeLayout.LayoutParams)this.centerView.getLayoutParams()).setMargins(i1, 0, i1, 0);
    }
  }
  
  private void a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = this.aw;
    }
    if (str != null)
    {
      paramString = new Intent(this, AccountDetailActivity.class);
      paramString.putExtra("uin", str);
      paramString.putExtra("source", 111);
      super.startActivity(paramString);
    }
  }
  
  protected int a(Bundle paramBundle)
  {
    int i1 = super.a(paramBundle);
    if ((getIntent().getIntExtra("reqType", -1) == 5) && (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a.jdField_a_of_type_Boolean))
    {
      hpe localhpe = new hpe(this);
      this.leftView.setOnClickListener(localhpe);
      this.rightViewText.setText(2131367378);
      this.rightViewText.setOnClickListener(localhpe);
    }
    a(paramBundle);
    return i1;
  }
  
  public WebAIOController a()
  {
    if (this.jdField_a_of_type_ComTencentBizWebviewbaseWebAIOController == null)
    {
      WebAIOController.Builder localBuilder = new WebAIOController.Builder(getTitleBarView());
      boolean bool = getIntent().getBooleanExtra("switch_msg_btn", false);
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("enable_switch", bool);
      localBundle.putString("banner_txt", String.format("正在阅读 %s: %s", new Object[] { this.at, "" }));
      localBundle.putInt("banner_icon_res", 2130838760);
      this.jdField_a_of_type_ComTencentBizWebviewbaseWebAIOController = localBuilder.a(localBundle).a();
    }
    return this.jdField_a_of_type_ComTencentBizWebviewbaseWebAIOController;
  }
  
  public SwiftBrowserComponentsProvider a()
  {
    return new SwiftBrowserComponentsProvider(this, 63, new hph(this));
  }
  
  protected String a()
  {
    return "PA";
  }
  
  public void a(int paramInt)
  {
    Object localObject1 = d();
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = this.ab;
    }
    if (TextUtils.isEmpty(this.aw)) {
      return;
    }
    localObject1 = "";
    Object localObject3 = Uri.parse((String)localObject2);
    try
    {
      localObject3 = ((Uri)localObject3).getQueryParameter("article_id");
      localObject1 = localObject3;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
      ReportController.b(this.app, "P_CliOper", "Pb_account_lifeservice", "", "0X800572A", "0X800572A", 1009, 1, 0, this.aw, (String)localObject2, this.ax, localException);
    }
    localObject3 = localObject1;
    if (localObject1 == null) {
      localObject3 = "";
    }
    switch (paramInt)
    {
    default: 
      
    case 7: 
      ReportController.b(this.app, "P_CliOper", "Pb_account_lifeservice", "", "0X800572A", "0X800572A", 1010, 1, 0, this.aw, (String)localObject2, this.ax, (String)localObject3);
      return;
    }
  }
  
  protected void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    if (paramInt == -8) {
      QRUtils.a(1, 2131364489);
    }
    super.a(paramWebView, paramInt, paramString1, paramString2);
  }
  
  protected boolean a(WebView paramWebView, String paramString)
  {
    if ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://")) && (!paramString.startsWith("file://"))) {
      return super.a(paramWebView, paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountBrowser", 2, "shouldOverride: " + Util.b(paramString, new String[0]));
    }
    String str = paramWebView.getUrl();
    if ((TextUtils.isEmpty(str)) || (str.startsWith("http://s.p.qq.com/pub/jump"))) {}
    for (int i1 = 1; (this.jdField_c_of_type_Boolean) || (!this.b) || (i1 != 0); i1 = 0)
    {
      this.f = false;
      return super.a(paramWebView, paramString);
    }
    if (!this.e)
    {
      paramWebView = new Intent(this, PublicAccountBrowser.class);
      if (this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface != null) {
        paramWebView.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.a());
      }
      paramWebView.putExtra("url", paramString);
      super.startActivity(paramWebView);
      return true;
    }
    return super.a(paramWebView, paramString);
  }
  
  public String b()
  {
    return this.aw;
  }
  
  protected void b()
  {
    if ((this.ab != null) && (this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface != null) && (this.jdField_a_of_type_ComTencentBizAuthorizeConfig != null) && (!TextUtils.isEmpty(this.aw)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizAuthorizeConfig.a(this.ab)))) {
      this.ab = Uri.parse(this.ab).buildUpon().appendQueryParameter("puin", this.aw).appendQueryParameter("uin", this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.getAccount()).toString();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    Intent localIntent = getIntent();
    String str = localIntent.getStringExtra("url");
    if ((str != null) && (str.contains("iyouxi.vip.qq.com/vipcenter")))
    {
      super.doOnCreate(paramBundle);
      VasWebviewUtil.openQQBrowserActivity(this, str, 16L, localIntent, false, -1);
      finish();
      return false;
    }
    a();
    super.doOnCreate(paramBundle);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
  }
  
  public void finish()
  {
    super.finish();
    if (this.jdField_a_of_type_Int == 1001) {
      ThreadManager.b(new hpf(this));
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      super.onClick(paramView);
      return;
    }
    if (this.jdField_a_of_type_Int == 1001)
    {
      ThreadManager.b(new hpg(this));
      finish();
      return;
    }
    super.onClick(paramView);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\PublicAccountBrowser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */