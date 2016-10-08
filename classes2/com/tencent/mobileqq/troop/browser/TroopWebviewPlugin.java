package com.tencent.mobileqq.troop.browser;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ChatActivityConstants;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity;
import com.tencent.mobileqq.troop.activity.TroopSearchLogicActivity;
import com.tencent.mobileqq.troop.activity.TroopTagViewActivity;
import com.tencent.mobileqq.troop.data.TroopCreateLogic.TroopCreateResult;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.APNUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.dingdong.DingdongPluginHelper;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import vlb;
import vlc;
import vld;
import vle;

public class TroopWebviewPlugin
  extends WebViewPlugin
  implements TroopMemberApiClient.Callback
{
  public static final String a = "6.5.5.2880";
  public static final String b = "Troop";
  public static final int c = 41;
  public static final String c = "searchTroop";
  public static final int d = 42;
  public static final String d = "showTroopProfile";
  public static final int e = 43;
  public static final String e = "getBkn";
  public static final int f = 44;
  public static final String f = "getVersion";
  public static final int g = 45;
  public static final String g = "isNetworkConnected";
  public static final String h = "openUrl";
  public static final String i = "didModifyGroupTags";
  public static final String j = "openTroopProfileEdit";
  public static final String k = "setWebDataCache";
  public static final String l = "getWebDataCache";
  public static final String m = "createDingdong";
  public final byte a;
  protected int a;
  public Dialog a;
  TroopMemberApiClient jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient;
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  public QQProgressDialog a;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  protected boolean a;
  protected int b;
  String n;
  protected String o;
  
  public TroopWebviewPlugin()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = -1;
    this.jdField_a_of_type_Byte = 5;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = null;
    this.mPluginNameSpace = "Troop";
  }
  
  private void c()
  {
    IphoneTitleBarActivity localIphoneTitleBarActivity = (IphoneTitleBarActivity)this.mRuntime.a();
    localIphoneTitleBarActivity.leftView.setEnabled(true);
    localIphoneTitleBarActivity.rightViewText.setEnabled(true);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null)
    {
      if (this.jdField_a_of_type_AndroidAppDialog.isShowing()) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      this.jdField_a_of_type_AndroidAppDialog = null;
    }
  }
  
  private void e()
  {
    this.mRuntime.a().finish();
  }
  
  private void g(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      String str1 = paramString.getString("type");
      String str2 = paramString.optString("wording", "");
      String str3 = paramString.optString("callback", "");
      boolean bool1 = paramString.optBoolean("show", true);
      boolean bool2 = paramString.optBoolean("disabled", false);
      a(str1, str2, bool1, paramString.optBoolean("showImg", true), bool2, str3);
      if (QLog.isColorLevel()) {
        QLog.d("CreateTroop-SetTitleButton", 2, "wording: " + str2 + " show: " + bool1);
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void h(String paramString)
  {
    Object localObject = (BaseActivity)this.mRuntime.a();
    a();
    localObject = new QQProgressDialog((Context)localObject, ((BaseActivity)localObject).getTitleBarHeight());
    ((QQProgressDialog)localObject).a(paramString);
    ((QQProgressDialog)localObject).setCancelable(false);
    ((QQProgressDialog)localObject).setOnDismissListener(new vlc(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = ((QQProgressDialog)localObject);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  private void i(String paramString)
  {
    Object localObject = (BaseActivity)this.mRuntime.a();
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      QQToast.a((Context)localObject, 2131367481, 0).b(((BaseActivity)localObject).getTitleBarHeight());
      return;
    }
    h(((BaseActivity)localObject).getString(2131369764));
    localObject = new Intent((Context)localObject, TroopCreateLogicActivity.class);
    ((Intent)localObject).putExtra("type", 1);
    ((Intent)localObject).putExtra("cfg", paramString);
    startActivityForResult((Intent)localObject, (byte)41);
  }
  
  private void j(String paramString)
  {
    Activity localActivity = this.mRuntime.a();
    Intent localIntent = new Intent(localActivity, TroopCreateLogicActivity.class);
    localIntent.putExtra("type", 3);
    localIntent.putExtra("cfg", paramString);
    localActivity.startActivity(localIntent);
  }
  
  private void k(String paramString)
  {
    Activity localActivity = this.mRuntime.a();
    Intent localIntent = new Intent(localActivity, TroopCreateLogicActivity.class);
    localIntent.putExtra("type", 7);
    localIntent.putExtra("cfg", paramString);
    localActivity.startActivity(localIntent);
  }
  
  private void l(String paramString)
  {
    Activity localActivity = this.mRuntime.a();
    if (localActivity == null) {}
    for (;;)
    {
      return;
      Intent localIntent = null;
      try
      {
        paramString = new JSONObject(paramString).getString("troopUin");
        if (TextUtils.isEmpty(paramString)) {
          continue;
        }
        localIntent = new Intent(localActivity, SelectMemberActivity.class);
        localIntent.putExtra("param_groupcode", paramString);
        localIntent.putExtra("param_type", 1);
        localIntent.putExtra("param_subtype", 0);
        localIntent.putExtra("param_only_friends", true);
        localIntent.putExtra("param_title", this.mRuntime.a().getString(2131367924));
        localIntent.putExtra("param_done_button_wording", this.mRuntime.a().getString(2131367263));
        localIntent.putExtra("param_done_button_highlight_wording", this.mRuntime.a().getString(2131369244));
        localIntent.putExtra("param_only_friends", true);
        localIntent.putExtra("param_exit_animation", 1);
        localIntent.putExtra("param_max", 10);
        localActivity.startActivity(localIntent);
        localActivity.overridePendingTransition(2130968585, 2130968586);
        return;
      }
      catch (JSONException paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
          paramString = localIntent;
        }
      }
    }
  }
  
  private void m(String paramString)
  {
    int i1 = 0;
    Activity localActivity = this.mRuntime.a();
    if (localActivity == null) {
      return;
    }
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject(paramString);
        paramString = localJSONObject.optString("troopUin", "");
      }
      catch (JSONException localJSONException1)
      {
        try
        {
          JSONObject localJSONObject;
          boolean bool = localJSONObject.optBoolean("closeCurPage", false);
          i1 = bool;
          if (!TextUtils.isEmpty(paramString))
          {
            paramString = TroopInfoActivity.a(paramString, 9);
            paramString.putString("troop_info_title", localActivity.getString(2131364287));
            TroopInfoActivity.a(localActivity, paramString, 45);
            localActivity.overridePendingTransition(2130968585, 2130968586);
          }
          if (i1 == 0) {
            break;
          }
          localActivity.finish();
          return;
        }
        catch (JSONException localJSONException2)
        {
          for (;;) {}
        }
        localJSONException1 = localJSONException1;
        paramString = "";
      }
      localJSONException1.printStackTrace();
    }
  }
  
  private void n(String paramString)
  {
    Activity localActivity = this.mRuntime.a();
    Object localObject = paramString.split("\\|");
    String str = "";
    if (localObject.length >= 4) {
      str = localObject[3];
    }
    localObject = new Intent();
    ((Intent)localObject).putExtra("location", str);
    ((Intent)localObject).putExtra("locationOriginal", paramString);
    localActivity.setResult(-1, (Intent)localObject);
    localActivity.finish();
  }
  
  private void o(String paramString)
  {
    Object localObject = this.mRuntime.a();
    h(((Activity)localObject).getString(2131369785));
    localObject = new Intent((Context)localObject, TroopCreateLogicActivity.class);
    ((Intent)localObject).putExtra("type", 5);
    ((Intent)localObject).putExtra("troop_location", paramString);
    ((Intent)localObject).putExtra("troop_uin", this.n);
    startActivityForResult((Intent)localObject, (byte)5);
  }
  
  void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    }
  }
  
  public void a(Bundle paramBundle)
  {
    int i1 = 2;
    if (paramBundle == null) {}
    do
    {
      return;
      if (paramBundle.getInt("type") != 84) {
        break;
      }
      paramBundle.getBoolean("isSuccess");
      paramBundle.getInt("appid");
      paramBundle.getString("openGroupId");
      paramBundle.getString("token");
      paramBundle = paramBundle.getString("uin");
    } while (!QLog.isColorLevel());
    QLog.d(this.TAG + ".troopTAG_GET_UIN_BY_OPEN_ID", 2, "callback,uin:" + paramBundle);
    return;
    if (paramBundle.getInt("type") == 71)
    {
      boolean bool = paramBundle.getBoolean("isSuccess");
      int i3 = paramBundle.getInt("appid");
      String str1 = paramBundle.getString("openGroupId");
      String str2 = paramBundle.getString("token");
      int i4 = paramBundle.getInt("freq");
      int i5 = paramBundle.getInt("expireTime");
      ArrayList localArrayList = paramBundle.getStringArrayList("apilist");
      int i2 = paramBundle.getInt("retCode");
      if (!bool)
      {
        switch (i2)
        {
        default: 
          i1 = -100;
        }
        for (;;)
        {
          callJs4OpenApiIfNeeded("init", i1, " server retCode:" + i2);
          return;
          i1 = 0;
          continue;
          i1 = 4;
        }
      }
      CustomWebView localCustomWebView = this.mRuntime.a();
      if (localCustomWebView != null)
      {
        localCustomWebView.a(i3, str1, str2, i4, i5, localArrayList);
        callJs4OpenApiIfNeeded("init", 0, localArrayList.toString());
        return;
      }
      callJs(paramBundle.getString("callback"), new String[] { "webView == null" });
      return;
    }
    callJs(paramBundle.getString("callback"), new String[] { "" });
  }
  
  /* Error */
  public void a(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: new 137	org/json/JSONObject
    //   5: dup
    //   6: aload_1
    //   7: invokespecial 139	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   10: astore_1
    //   11: aload_1
    //   12: ldc -99
    //   14: invokevirtual 432	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   17: istore_2
    //   18: iload_2
    //   19: ifne +61 -> 80
    //   22: iconst_1
    //   23: istore_2
    //   24: aload_1
    //   25: ldc_w 434
    //   28: invokevirtual 432	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   31: istore 4
    //   33: iload 4
    //   35: istore_3
    //   36: new 257	android/content/Intent
    //   39: dup
    //   40: aload_0
    //   41: getfield 98	com/tencent/mobileqq/troop/browser/TroopWebviewPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   44: invokevirtual 103	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   47: ldc_w 436
    //   50: invokespecial 262	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   53: astore_1
    //   54: aload_1
    //   55: ldc_w 438
    //   58: iload_2
    //   59: invokevirtual 300	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   62: pop
    //   63: aload_1
    //   64: ldc_w 440
    //   67: iload_3
    //   68: invokevirtual 300	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   71: pop
    //   72: aload_0
    //   73: aload_1
    //   74: bipush 43
    //   76: invokevirtual 275	com/tencent/mobileqq/troop/browser/TroopWebviewPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   79: return
    //   80: iconst_0
    //   81: istore_2
    //   82: goto -58 -> 24
    //   85: astore_1
    //   86: iconst_0
    //   87: istore_2
    //   88: aload_1
    //   89: invokevirtual 199	org/json/JSONException:printStackTrace	()V
    //   92: goto -56 -> 36
    //   95: astore_1
    //   96: goto -8 -> 88
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	this	TroopWebviewPlugin
    //   0	99	1	paramString	String
    //   17	71	2	bool1	boolean
    //   1	67	3	bool2	boolean
    //   31	3	4	bool3	boolean
    // Exception table:
    //   from	to	target	type
    //   2	18	85	org/json/JSONException
    //   24	33	95	org/json/JSONException
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    String str = paramString2;
    if (!TextUtils.isEmpty(paramString2)) {
      str = paramString2.replace("\"", "\\\"");
    }
    paramString1 = "javascript:" + paramString1 + "(\"" + str + "\")";
    this.mRuntime.a().loadUrl(paramString1);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString3)
  {
    boolean bool = false;
    IphoneTitleBarActivity localIphoneTitleBarActivity = (IphoneTitleBarActivity)this.mRuntime.a();
    Object localObject = null;
    if (paramString1.equals("left"))
    {
      localObject = localIphoneTitleBarActivity.leftView;
      Resources localResources = localIphoneTitleBarActivity.getResources();
      if (paramBoolean2)
      {
        i1 = 2130843454;
        ((View)localObject).setBackgroundDrawable(localResources.getDrawable(i1));
      }
    }
    for (;;)
    {
      if (localObject != null) {
        break label186;
      }
      return;
      i1 = 2130843457;
      break;
      if (paramString1.equals("right"))
      {
        localObject = localIphoneTitleBarActivity.rightViewText;
        localIphoneTitleBarActivity.rightViewImg.setVisibility(8);
        localIphoneTitleBarActivity.rightViewText.setVisibility(0);
      }
      else if (paramString1.equals("rightImgBtn"))
      {
        localObject = localIphoneTitleBarActivity.rightViewImg;
        localIphoneTitleBarActivity.rightViewImg.setImageResource(2130838290);
        localIphoneTitleBarActivity.rightViewImg.setContentDescription(localIphoneTitleBarActivity.getResources().getString(2131368933));
        localIphoneTitleBarActivity.rightViewImg.setVisibility(0);
        localIphoneTitleBarActivity.rightViewText.setVisibility(8);
      }
    }
    label186:
    if ((localObject instanceof TextView)) {
      ((TextView)localObject).setText(paramString2);
    }
    if (paramBoolean1) {}
    for (int i1 = 0;; i1 = 8)
    {
      ((View)localObject).setVisibility(i1);
      paramBoolean1 = bool;
      if (!paramBoolean3) {
        paramBoolean1 = true;
      }
      ((View)localObject).setEnabled(paramBoolean1);
      if (ChatActivityConstants.I) {
        ((View)localObject).setContentDescription(paramString2);
      }
      if (paramString1.equals("left")) {
        break;
      }
      ((View)localObject).setOnClickListener(new vlb(this, paramString3, localIphoneTitleBarActivity));
      return;
    }
    this.o = paramString3;
  }
  
  public void b()
  {
    d();
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.mRuntime.a(), null);
    localActionSheet.a(2131369783);
    localActionSheet.a(2131369784, 3);
    localActionSheet.d(2131367262);
    localActionSheet.setOnDismissListener(new vld(this));
    localActionSheet.a(new vle(this));
    this.jdField_a_of_type_AndroidAppDialog = localActionSheet;
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  public void b(String paramString)
  {
    BaseActivity localBaseActivity = (BaseActivity)this.mRuntime.a();
    if (!NetworkUtil.e(localBaseActivity)) {
      QQToast.a(localBaseActivity, 2131367481, 0).b(localBaseActivity.getTitleBarHeight());
    }
    while (TextUtils.isEmpty(paramString)) {
      return;
    }
    n(paramString);
  }
  
  public void c(String paramString)
  {
    BaseActivity localBaseActivity = (BaseActivity)this.mRuntime.a();
    try
    {
      paramString = new JSONObject(paramString).optString("location", "");
      if (!this.jdField_a_of_type_Boolean)
      {
        b(paramString);
        return;
      }
      if (!NetworkUtil.e(localBaseActivity))
      {
        QQToast.a(localBaseActivity, 2131367481, 0).b(localBaseActivity.getTitleBarHeight());
        return;
      }
      if (TextUtils.isEmpty(paramString))
      {
        b();
        return;
      }
      o(paramString);
      return;
    }
    catch (Exception paramString) {}
  }
  
  /* Error */
  public void d(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 98	com/tencent/mobileqq/troop/browser/TroopWebviewPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   4: invokevirtual 103	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   7: astore_2
    //   8: new 137	org/json/JSONObject
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 139	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   16: astore_1
    //   17: aload_1
    //   18: ldc_w 566
    //   21: invokevirtual 145	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   24: astore_3
    //   25: aload_1
    //   26: ldc_w 568
    //   29: invokevirtual 432	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   32: istore 4
    //   34: aload_3
    //   35: bipush 13
    //   37: invokestatic 327	com/tencent/mobileqq/activity/TroopInfoActivity:a	(Ljava/lang/String;I)Landroid/os/Bundle;
    //   40: astore_1
    //   41: aload_1
    //   42: ldc_w 568
    //   45: iload 4
    //   47: invokevirtual 572	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   50: aload_2
    //   51: aload_1
    //   52: invokestatic 575	com/tencent/mobileqq/activity/TroopInfoActivity:a	(Landroid/content/Context;Landroid/os/Bundle;)V
    //   55: iload 4
    //   57: ifeq +7 -> 64
    //   60: aload_2
    //   61: invokevirtual 133	android/app/Activity:finish	()V
    //   64: return
    //   65: astore_1
    //   66: return
    //   67: astore_1
    //   68: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	this	TroopWebviewPlugin
    //   0	69	1	paramString	String
    //   7	54	2	localActivity	Activity
    //   24	11	3	str	String
    //   32	24	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   8	17	65	org/json/JSONException
    //   17	55	67	org/json/JSONException
    //   60	64	67	org/json/JSONException
  }
  
  public void e(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      Activity localActivity;
      return;
    }
    catch (JSONException paramString)
    {
      try
      {
        paramString = paramString.getString("url");
        if (paramString != null)
        {
          localActivity = this.mRuntime.a();
          TroopQQBrowserHelper.a(localActivity, localActivity.getIntent().getExtras(), paramString);
        }
        return;
      }
      catch (JSONException paramString) {}
      paramString = paramString;
      return;
    }
  }
  
  public void f(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      try
      {
        paramString = paramString.getString("tags");
        if (!(this.mRuntime.a() instanceof TroopTagViewActivity)) {
          return;
        }
        ((TroopTagViewActivity)this.mRuntime.a()).a(paramString);
        return;
      }
      catch (JSONException paramString) {}
      return;
    }
    catch (JSONException paramString) {}
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map paramMap)
  {
    if (paramLong == 8589934593L)
    {
      this.o = null;
      c();
    }
    for (;;)
    {
      return false;
      if (paramLong == 8589934601L)
      {
        if (!TextUtils.isEmpty(this.o))
        {
          callJs(this.o, new String[] { "" });
          this.o = null;
          return true;
        }
      }
      else if (paramLong == 2L)
      {
        if (this.b != -1)
        {
          paramString = new JSONObject();
          try
          {
            paramString.put("isBack", this.b);
            a("onGetGroupHeadEditViewBack", paramString.toString());
            this.b = -1;
          }
          catch (JSONException paramString)
          {
            for (;;)
            {
              paramString.printStackTrace();
            }
          }
        }
      }
      else if (paramLong == 16L)
      {
        this.o = null;
        c();
      }
    }
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    paramString1 = null;
    int i1 = 0;
    boolean bool = false;
    if (!paramString2.equals("Troop")) {}
    for (;;)
    {
      return false;
      addOpenApiListenerIfNeeded(paramString3, paramJsBridgeListener);
      if ("init".equals(paramString3)) {}
      try
      {
        paramString3 = new JSONObject(paramVarArgs[0]);
        i1 = paramString3.optInt("appid");
        paramString2 = paramString3.optString("openGroupId");
        paramString3 = paramString3.optString("token");
        if ((TextUtils.isEmpty(i1 + "")) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)))
        {
          callJs4OpenApi(paramJsBridgeListener, 4, JsBridgeListener.a(4, null, null));
          return false;
        }
        paramJsBridgeListener = this.mRuntime.a().getUrl();
        int i2 = paramJsBridgeListener.indexOf("?");
        paramVarArgs = this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient;
        if (i2 == -1) {}
        for (paramJsBridgeListener = paramString1;; paramJsBridgeListener = paramJsBridgeListener.substring(0, i2))
        {
          paramVarArgs.a(i1, paramString2, paramString3, paramJsBridgeListener, "init", this);
          break;
        }
        if (paramString3.equals("setTitleButton"))
        {
          g(paramVarArgs[0]);
        }
        else if (paramString3.equals("commitGroupInfo"))
        {
          i(paramVarArgs[0]);
        }
        else if (paramString3.equals("shareGroup"))
        {
          j(paramVarArgs[0]);
        }
        else if (paramString3.equals("inviteMemberToGroup"))
        {
          l(paramVarArgs[0]);
        }
        else if (paramString3.equals("enterGroupInfoCard"))
        {
          m(paramVarArgs[0]);
        }
        else if (paramString3.equals("modifyTroopLocation"))
        {
          c(paramVarArgs[0]);
        }
        else if (paramString3.equals("finishCreateGroup"))
        {
          e();
        }
        else if (paramString3.equals("insertCreateGroupSuccessMsg"))
        {
          try
          {
            paramString2 = new JSONObject(paramVarArgs[0]);
            paramJsBridgeListener = paramString2.getString("troopUin");
            paramString1 = paramString2.getString("groupName");
            i1 = paramString2.optInt("cateId");
            paramString2 = paramString2.optString("callback");
            this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(paramJsBridgeListener, paramString1, i1, paramString2, this);
          }
          catch (JSONException paramJsBridgeListener)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
        else if (paramString3.equals("showGroupHeadEditView"))
        {
          a(paramVarArgs[0]);
        }
        else if (paramString3.equals("searchTroop"))
        {
          paramJsBridgeListener = this.mRuntime.a();
          paramString1 = new Intent(paramJsBridgeListener, TroopSearchLogicActivity.class);
          paramString1.putExtra("type", 2);
          paramString1.putExtra("key_words", paramVarArgs[0]);
          paramJsBridgeListener.startActivity(paramString1);
        }
        else if (paramString3.equals("didModifyGroupTags"))
        {
          f(paramVarArgs[0]);
          paramJsBridgeListener.a(Boolean.valueOf(true));
        }
        else if (paramString3.equals("openTroopProfileEdit"))
        {
          d(paramVarArgs[0]);
        }
        else if (paramString3.equals("showTroopProfile"))
        {
          paramJsBridgeListener = this.mRuntime.a();
          paramString1 = new Intent(paramJsBridgeListener, TroopSearchLogicActivity.class);
          paramString1.putExtra("type", 1);
          paramString1.putExtra("key_words", paramVarArgs[0]);
          paramJsBridgeListener.startActivity(paramString1);
        }
        else if (paramString3.equals("getVersion"))
        {
          paramJsBridgeListener.a("6.5.5.2880");
        }
        else if (paramString3.equals("isNetworkConnected"))
        {
          paramJsBridgeListener.a(Boolean.valueOf(APNUtil.d(CommonDataAdapter.a().a())));
        }
        else if (paramString3.equals("openUrl"))
        {
          e(paramVarArgs[0]);
        }
        else if ((!paramString3.equals("setWebDataCache")) && (!paramString3.equals("getWebDataCache")))
        {
          if ("getUniqueTitleNewFlag".equals(paramString3)) {
            try
            {
              paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
              if ((this.mRuntime.a().getSharedPreferences(this.mRuntime.a().a() + "_troopManager", 0).getInt("uniqueTitleNewFlag", 0) & 0x2) == 0) {
                bool = true;
              }
              callJs(paramJsBridgeListener, new String[] { "{\"showFlag\":" + bool + "}" });
              return true;
            }
            catch (JSONException paramJsBridgeListener)
            {
              paramJsBridgeListener.printStackTrace();
            }
          }
          if ("setUniqueTitleNewFlag".equals(paramString3))
          {
            paramJsBridgeListener = this.mRuntime.a().getSharedPreferences(this.mRuntime.a().a() + "_troopManager", 0);
            i1 = paramJsBridgeListener.getInt("uniqueTitleNewFlag", 0);
            paramJsBridgeListener.edit().putInt("uniqueTitleNewFlag", i1 | 0x2).commit();
            return true;
          }
          if ("createDingdong".equals(paramString3))
          {
            try
            {
              paramJsBridgeListener = new JSONObject(paramVarArgs[0]).getString("troopUin");
              if (paramJsBridgeListener == null) {
                break;
              }
              paramString1 = new Intent();
              paramString1.putExtra("_src_type_", 1);
              paramString1.putExtra("_src_code_", paramJsBridgeListener);
              DingdongPluginHelper.a(this.mRuntime.a(), "com.dingdong.business.base.activity.DingdongDingActivity", paramString1, -1);
              this.mRuntime.a().finish();
              return true;
            }
            catch (JSONException paramJsBridgeListener)
            {
              for (;;)
              {
                paramJsBridgeListener.printStackTrace();
                paramJsBridgeListener = null;
              }
            }
          }
          else
          {
            if (!"updateTroopBindedPubAccount".equals(paramString3)) {
              continue;
            }
            try
            {
              paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
              long l1 = paramJsBridgeListener.getLong("troopPubAccountUin");
              paramJsBridgeListener = paramJsBridgeListener.getJSONArray("groupCodeList");
              i2 = paramJsBridgeListener.length();
              if (i2 > 0)
              {
                paramString1 = new long[i2];
                while (i1 < i2)
                {
                  paramString1[i1] = paramJsBridgeListener.getLong(i1);
                  i1 += 1;
                }
                this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(l1, paramString1);
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("AccountDetailActivity.bindTroop", 2, "updateTroopBindedPubAccount:" + paramVarArgs[0]);
            }
            catch (JSONException paramJsBridgeListener)
            {
              if (!QLog.isColorLevel()) {
                break;
              }
            }
            QLog.e("AccountDetailActivity.bindTroop", 2, paramJsBridgeListener.toString());
          }
        }
      }
      catch (JSONException paramJsBridgeListener) {}
    }
    return true;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    Object localObject2 = (BaseActivity)this.mRuntime.a();
    switch (paramByte)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              a();
            } while ((paramIntent == null) || (paramInt != -1));
            paramByte = paramIntent.getIntExtra("retCode", -1);
            Object localObject1 = paramIntent.getStringExtra("troopUin");
            paramIntent = (Intent)localObject1;
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              paramIntent = "";
            }
            paramInt = TroopCreateLogic.TroopCreateResult.a(paramByte);
            if (paramInt != 0) {
              QQToast.a(this.mRuntime.a(), paramInt, 0).b(((BaseActivity)localObject2).getTitleBarHeight());
            }
            localObject2 = new JSONObject();
            for (;;)
            {
              try
              {
                ((JSONObject)localObject2).put("result", paramByte);
                if (TextUtils.isEmpty(paramIntent)) {
                  continue;
                }
                localObject1 = paramIntent;
                ((JSONObject)localObject2).put("troopUin", localObject1);
              }
              catch (JSONException localJSONException)
              {
                localJSONException.printStackTrace();
                continue;
              }
              a("onCreateGroupResult", ((JSONObject)localObject2).toString());
              if (paramByte != 0) {
                break;
              }
              this.n = paramIntent;
              return;
              localObject1 = "";
            }
          } while ((paramIntent == null) || (paramInt != -1));
          a("onGroupInfoModified", paramIntent.getStringExtra("modifiedInfo"));
          return;
        } while ((paramIntent == null) || (paramInt != -1));
        this.b = paramIntent.getIntExtra("isBack", -1);
        return;
      } while (TextUtils.isEmpty(this.n));
      paramIntent = new Intent(this.mRuntime.a(), TroopCreateLogicActivity.class);
      paramIntent.putExtra("type", 4);
      paramIntent.putExtra("troop_uin", this.n);
      startActivityForResult(paramIntent, (byte)42);
      return;
      paramIntent.getBooleanExtra("has_head", false);
      return;
    } while ((paramIntent == null) || (paramInt != -1));
    paramByte = paramIntent.getIntExtra("errCode", -1);
    boolean bool = paramIntent.getBooleanExtra("isClear", false);
    String str = paramIntent.getStringExtra("location");
    paramInt = paramIntent.getIntExtra("lat", 0);
    int i1 = paramIntent.getIntExtra("lon", 0);
    if (paramByte == 0)
    {
      if (bool) {
        QQToast.a((Context)localObject2, 2131369788, 0).b(((BaseActivity)localObject2).getTitleBarHeight());
      }
      for (;;)
      {
        paramIntent = new Intent();
        paramIntent.putExtra("location", str);
        paramIntent.putExtra("lat", paramInt);
        paramIntent.putExtra("lon", i1);
        ((BaseActivity)localObject2).setResult(-1, paramIntent);
        ((BaseActivity)localObject2).finish();
        return;
        QQToast.a((Context)localObject2, 2131369786, 0).b(((BaseActivity)localObject2).getTitleBarHeight());
      }
    }
    if (paramByte == 1002) {
      paramIntent = ((BaseActivity)localObject2).getString(2131369790);
    }
    for (;;)
    {
      QQToast.a((Context)localObject2, paramIntent, 0).b(((BaseActivity)localObject2).getTitleBarHeight());
      return;
      if (bool) {
        paramIntent = ((BaseActivity)localObject2).getString(2131369789);
      } else {
        paramIntent = ((BaseActivity)localObject2).getString(2131369787);
      }
    }
  }
  
  public void onCreate()
  {
    this.jdField_a_of_type_Int = this.mRuntime.a().getIntent().getIntExtra("troop_create_from", 0);
    if (this.jdField_a_of_type_Int != 0) {
      this.mRuntime.a().setResult(-1);
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
    {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
    }
  }
  
  public void onDestroy()
  {
    if ((this.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_Int != 4)) {}
    for (;;)
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
      }
      return;
      Intent localIntent = new Intent(this.mRuntime.a(), TroopCreateLogicActivity.class);
      localIntent.putExtra("type", 2);
      localIntent.putExtra("troop_uin", this.n);
      this.mRuntime.a().startActivity(localIntent);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\browser\TroopWebviewPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */