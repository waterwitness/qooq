package com.tencent.mobileqq.troop.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.mobileqq.activity.ChatActivityConstants;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.net.URLEncoder;
import vjb;
import vjc;

public abstract class TroopCreateBaseActivity
  extends AbsBaseWebViewActivity
{
  private static final int jdField_a_of_type_Int = 1;
  static final String jdField_a_of_type_JavaLangString = TroopCreateBaseActivity.class.getSimpleName();
  static final String b = "&ver=%d&clientversion=%s";
  public Dialog a;
  CustomWebView jdField_a_of_type_ComTencentBizPubaccountCustomWebView;
  protected TroopCreateBaseActivity.TopBarBtnClickListener a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    String str = URLEncoder.encode(b());
    return paramString + String.format("&ver=%d&clientversion=%s", new Object[] { Integer.valueOf(1), str });
  }
  
  protected static String b()
  {
    try
    {
      Object localObject = BaseApplication.getContext();
      localObject = ((Context)localObject).getPackageManager().getPackageInfo(((Context)localObject).getPackageName(), 0);
      localObject = ((PackageInfo)localObject).versionName + "." + ((PackageInfo)localObject).versionCode;
      return (String)localObject;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      localNameNotFoundException.printStackTrace();
    }
    return "";
  }
  
  void a()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null)
    {
      if (this.jdField_a_of_type_AndroidAppDialog.isShowing()) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      this.jdField_a_of_type_AndroidAppDialog = null;
    }
  }
  
  protected void a(int paramInt)
  {
    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getWindowToken(), 2);
  }
  
  protected void a(WebView paramWebView, String paramString)
  {
    setTitle(paramString);
  }
  
  protected void a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView == null)) {
      return;
    }
    paramString = "javascript:" + paramString + "()";
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadUrl(paramString);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    paramString3 = new vjc(this, paramString3);
    DialogUtil.a(this, 230, paramString1, paramString2, 2131367262, 2131367263, paramString3, paramString3).show();
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString3)
  {
    boolean bool = false;
    Object localObject = null;
    int i;
    if (paramString1.equals("left"))
    {
      localObject = this.leftView;
      Resources localResources = getResources();
      if (paramBoolean2)
      {
        i = 2130843454;
        ((View)localObject).setBackgroundDrawable(localResources.getDrawable(i));
        i = 0;
      }
    }
    for (;;)
    {
      if (localObject == null)
      {
        return;
        i = 2130843457;
        break;
        if (paramString1.equals("right"))
        {
          localObject = this.rightViewText;
          i = 1;
          continue;
        }
        if (!paramString1.equals("rightImgBtn")) {
          break label231;
        }
        localObject = this.rightViewImg;
        this.rightViewImg.setImageResource(2130838290);
        this.rightViewImg.setContentDescription(getResources().getString(2131368933));
        i = 2;
        continue;
      }
      if ((localObject instanceof TextView)) {
        ((TextView)localObject).setText(paramString2);
      }
      if (paramBoolean1) {}
      for (int j = 0;; j = 8)
      {
        ((View)localObject).setVisibility(j);
        paramBoolean1 = bool;
        if (!paramBoolean3) {
          paramBoolean1 = true;
        }
        ((View)localObject).setEnabled(paramBoolean1);
        if (ChatActivityConstants.I) {
          ((View)localObject).setContentDescription(paramString2);
        }
        paramString2 = new TroopCreateBaseActivity.TopBarBtnClickListener(this, i, paramString3);
        ((View)localObject).setOnClickListener(paramString2);
        if (!paramString1.equals("left")) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopCreateBaseActivity$TopBarBtnClickListener = paramString2;
        return;
      }
      label231:
      i = 0;
    }
  }
  
  public void b()
  {
    CustomWebView localCustomWebView = this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView;
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getChildCount();
    localCustomWebView.setFocusableInTouchMode(true);
    localCustomWebView.setFocusable(true);
    localCustomWebView.requestFocus();
    ((InputMethodManager)getSystemService("input_method")).showSoftInput(localCustomWebView, 1);
  }
  
  protected void b(String paramString)
  {
    a();
    QQProgressDialog localQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    localQQProgressDialog.a(paramString);
    localQQProgressDialog.setCancelable(false);
    localQQProgressDialog.setOnDismissListener(new vjb(this));
    this.jdField_a_of_type_AndroidAppDialog = localQQProgressDialog;
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  public void b(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView == null)) {
      return;
    }
    String str = paramString2;
    if (!TextUtils.isEmpty(paramString2)) {
      str = paramString2.replace("\"", "\\\"");
    }
    paramString1 = "javascript:" + paramString1 + "(\"" + str + "\")";
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadUrl(paramString1);
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.canGoBack())
    {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.goBack();
      return;
    }
    finish();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = b((ViewGroup)null);
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.setId(2131296688);
    setContentView(this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView);
    paramBundle = getIntent().getStringExtra("url");
    if (TextUtils.isEmpty(paramBundle)) {
      return false;
    }
    Object localObject = Uri.parse(paramBundle);
    if (((Uri)localObject).isHierarchical())
    {
      localObject = ((Uri)localObject).getQueryParameter("_wv");
      if (localObject == null) {}
    }
    try
    {
      this.c = Long.parseLong((String)localObject, 10);
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadUrl(paramBundle);
      this.leftView.setOnClickListener(new TroopCreateBaseActivity.TopBarBtnClickListener(this, 0, null));
      return true;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 4, "_wv param not found");
        }
      }
    }
  }
  
  protected void f() {}
  
  protected void g() {}
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  protected boolean onBackEvent()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopCreateBaseActivity$TopBarBtnClickListener != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopCreateBaseActivity$TopBarBtnClickListener.onClick(this.leftView);
      return true;
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\activity\TroopCreateBaseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */