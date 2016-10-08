package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.service.gamecenter.AppLaucherHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebUiBaseInterface;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserMiscHandler;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.QQBrowserBaseActivityInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebFeaturesInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebShareInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebShareReportInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebUiMethodInterface;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneShareManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;
import sxx;
import sxz;
import syb;
import syc;

public class QQApiPlugin
  extends WebViewPlugin
{
  public static final String A = "cover_url";
  public static final String B = "source_name";
  public static final String C = "article_id";
  public static final String D = "QQApi";
  protected static final String F = "shareMsg";
  static final byte jdField_a_of_type_Byte = 1;
  public static final String a = "QQApi";
  static final String b = "title";
  static final String c = "desc";
  static final String d = "share_url";
  static final String e = "shareUrl";
  static final String f = "image_url";
  static final String g = "imageUrl";
  static final String h = "shareElement";
  static final String i = "shareQQType";
  static final String j = "flash_url";
  static final String k = "callback";
  static final String l = "keepShareUrl";
  static final String m = "share_type";
  static final String n = "shareType";
  static final String o = "toUin";
  static final String p = "uinType";
  static final String q = "appid";
  static final String r = "back";
  static final String s = "report";
  static final String t = "sourceName";
  static final String u = "src_iconUrl";
  static final String v = "src_webActionUrl";
  static final String w = "src_action";
  static final String x = "src_actionData";
  static final String y = "src_a_actionData";
  static final String z = "src_i_actionData";
  public String E;
  public String G;
  Context jdField_a_of_type_AndroidContentContext;
  private WebUiUtils.QQBrowserBaseActivityInterface jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$QQBrowserBaseActivityInterface;
  private WebUiUtils.WebFeaturesInterface jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebFeaturesInterface;
  private WebUiUtils.WebShareInterface jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareInterface;
  private WebUiUtils.WebShareReportInterface jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareReportInterface;
  private WebUiUtils.WebUiMethodInterface jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebUiMethodInterface;
  public QQProgressDialog a;
  public WXShareHelper.WXShareListener a;
  
  public QQApiPlugin()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.mPluginNameSpace = "QQApi";
  }
  
  private Context a()
  {
    for (Activity localActivity = this.mRuntime.a(); (localActivity != null) && ((localActivity instanceof BasePluginActivity)); localActivity = ((BasePluginActivity)localActivity).getOutActivity()) {}
    return localActivity;
  }
  
  private void a(Activity paramActivity)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareInterface != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareInterface.getShare().a();
      }
    }
    else {
      return;
    }
    if (paramActivity.getClass().getName().equalsIgnoreCase("com.tencent.qqreadinjoy.detailspage.ReadInJoyArticleDetailActivity"))
    {
      if ((paramActivity instanceof WebUiUtils.WebShareInterface))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = ((WebUiUtils.WebShareInterface)paramActivity).getShare().a();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(paramActivity, paramActivity.getResources().getDimensionPixelSize(2131492908));
      return;
    }
    if ((paramActivity instanceof WebUiUtils.WebShareInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = ((WebUiUtils.WebShareInterface)paramActivity).getShare().a();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(paramActivity, paramActivity.getResources().getDimensionPixelSize(2131492908));
  }
  
  private void a(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    paramJSONObject = this.mRuntime.a();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      a(paramJSONObject);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    paramJSONObject = new Bundle();
    paramJSONObject.putString("title", paramString2);
    paramJSONObject.putString("desc", paramString3);
    paramJSONObject.putString("detail_url", paramString4);
    paramJSONObject.putString("from", "qq");
    paramString1 = new ArrayList(1);
    paramString1.add(paramString5);
    paramJSONObject.putStringArrayList("image_url", paramString1);
    paramJSONObject.putLong("req_share_id", 0L);
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareReportInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebUiMethodInterface != null))
    {
      paramJSONObject.putString("strurt_msgid", this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareReportInterface.e());
      paramJSONObject.putString("struct_uin", this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareReportInterface.f());
      paramJSONObject.putString("struct_url", this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebUiMethodInterface.getCurrentUrl());
      paramJSONObject.putBoolean("from_web", true);
      if ((this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareReportInterface.g() != null) && (!"".equals(this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareReportInterface.g()))) {
        paramJSONObject.putString("source_puin", this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareReportInterface.g());
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$QQBrowserBaseActivityInterface != null) {}
    for (int i1 = this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$QQBrowserBaseActivityInterface.a(this, (byte)1, true); QZoneShareManager.a(this.mRuntime.a(), a(), paramJSONObject, null, i1); i1 = 1) {
      return;
    }
    QRUtils.a(1, 2131369679);
    if (!TextUtils.isEmpty(this.E))
    {
      callJs(this.E, new String[] { "false" });
      return;
    }
    callJs4OpenApiIfNeeded("shareMsg", 0, "false");
  }
  
  private void a(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt)
  {
    Activity localActivity = this.mRuntime.a();
    Intent localIntent = new Intent();
    paramString1 = paramJSONObject.optString("toUin");
    int i1 = paramJSONObject.optInt("uinType", 0);
    if ((paramString1 != null) && (paramString1.length() >= 5))
    {
      localIntent.setClass(this.jdField_a_of_type_AndroidContentContext, DirectForwardActivity.class);
      localIntent.putExtra("toUin", paramString1);
      localIntent.putExtra("uinType", i1);
      localIntent.putExtra("key_flag_from_plugin", true);
      paramString1 = paramString2;
      if (paramString2 != null)
      {
        paramString1 = paramString2;
        if (paramString2.length() > 45) {
          paramString1 = paramString2.substring(0, 45) + "…";
        }
      }
      paramString2 = paramString3;
      if (paramString3 != null)
      {
        paramString2 = paramString3;
        if (paramString3.length() > 60) {
          paramString2 = paramString3.substring(0, 60) + "…";
        }
      }
      i1 = paramInt;
      if (paramInt <= 0) {
        i1 = 13;
      }
      localIntent.putExtra("pluginName", "web_share");
      localIntent.putExtra("title", paramString1);
      localIntent.putExtra("desc", paramString2);
      localIntent.putExtra("detail_url", paramString4);
      localIntent.putExtra("shareQQType", i1);
      localIntent.putExtra("forward_type", 1001);
      localIntent.putExtra("req_share_id", paramJSONObject.optLong("appid", -1L));
      localIntent.putExtra("pkg_name", "com.tencent.mobileqq");
      localIntent.putExtra("image_url_remote", paramString5);
      localIntent.putExtra("brief_key", BaseApplicationImpl.getContext().getString(2131364569, new Object[] { paramString1 }));
      if (paramJSONObject.has("contentAction")) {
        localIntent.putExtra("struct_share_key_content_action", paramJSONObject.getString("contentAction"));
      }
      if (paramJSONObject.has("actionData")) {
        localIntent.putExtra("struct_share_key_content_action_DATA", paramJSONObject.getString("actionData"));
      }
      if (paramJSONObject.has("sourceAction")) {
        localIntent.putExtra("struct_share_key_source_action", paramJSONObject.getString("sourceAction"));
      }
      if (paramJSONObject.has("isShareFlag")) {
        localIntent.putExtra("is_share_flag", Integer.parseInt(paramJSONObject.getString("isShareFlag")));
      }
      if (paramJSONObject.has("srcActionData")) {
        localIntent.putExtra("struct_share_key_source_action_data", paramJSONObject.getString("srcActionData"));
      }
      if (paramJSONObject.has("appName")) {
        localIntent.putExtra("app_name", paramJSONObject.getString("appName"));
      }
      if (!"audio".equals(paramString6)) {
        break label720;
      }
      paramInt = 2;
      localIntent.putExtra("audio_url", paramString7);
    }
    boolean bool;
    for (;;)
    {
      localIntent.putExtra("req_type", paramInt);
      if (paramJSONObject.has("report")) {
        localIntent.putExtra("report", paramJSONObject.getString("report"));
      }
      localIntent.putExtra("openerProc", MobileQQ.getMobileQQ().getProcessName());
      bool = paramJSONObject.optBoolean("back", false);
      if (paramJSONObject.has("k_back")) {
        bool = paramJSONObject.getBoolean("k_back");
      }
      localIntent.putExtra("k_back", bool);
      long l1 = paramJSONObject.optLong("appid", 0L);
      if (l1 <= 0L) {
        break label763;
      }
      paramJSONObject = this.mRuntime.a();
      if (paramJSONObject != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
          a(localActivity);
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131369682);
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
        }
        localIntent.putExtra("struct_share_key_source_name", Long.toString(l1));
        Share.a(paramJSONObject, this.jdField_a_of_type_AndroidContentContext, paramJSONObject.getAccount(), l1, 3000L, new syc(this, localIntent));
      }
      return;
      localIntent.setClass(this.jdField_a_of_type_AndroidContentContext, ForwardRecentActivity.class);
      break;
      label720:
      i1 = paramJSONObject.optInt("req_type", 1);
      paramInt = i1;
      if (i1 == 2)
      {
        localIntent.putExtra("audio_url", paramJSONObject.getString("audio_url"));
        paramInt = i1;
      }
    }
    label763:
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      a(localActivity);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    paramString1 = paramJSONObject.optString("puin", null);
    if (paramString1 == null) {
      paramString1 = paramJSONObject.optString("oaUin");
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramString1))
      {
        paramString2 = this.mRuntime.a().a(this.mRuntime.a().getAccount()).createEntityManager();
        paramString5 = (AccountDetail)paramString2.a(AccountDetail.class, paramString1);
        paramString2.a();
        paramString4 = paramJSONObject.optString("src_action", "");
        paramString2 = null;
        if (TextUtils.isEmpty(paramString4)) {
          if (paramString5 == null) {
            break label1808;
          }
        }
      }
      label986:
      label996:
      label1006:
      label1323:
      label1331:
      label1670:
      label1770:
      label1781:
      label1802:
      label1808:
      for (paramString2 = paramString5.name;; paramString2 = null)
      {
        paramString3 = paramString2;
        if (TextUtils.isEmpty(paramString2))
        {
          paramString3 = paramString2;
          if (paramJSONObject.has("sourceName")) {
            paramString3 = paramJSONObject.optString("sourceName");
          }
        }
        paramString2 = paramString3;
        if (TextUtils.isEmpty(paramString3)) {
          paramString2 = paramString1;
        }
        for (;;)
        {
          if (paramString2.equalsIgnoreCase(this.jdField_a_of_type_AndroidContentContext.getString(2131366416)))
          {
            bool = paramString2.equalsIgnoreCase(this.jdField_a_of_type_AndroidContentContext.getString(2131366416));
            if (bool)
            {
              paramJSONObject = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=cooperation.readinjoy.ReadInJoyProxyActivity";
              if (!bool) {
                break label1323;
              }
              paramString3 = "mqqapi://readinjoy/open?src_type=internal&version=1";
              if (!bool) {
                break label1331;
              }
              paramString4 = "http://sqimg.qq.com/qq_product_operations/ydqpush/message_icon/kandian.png";
              localIntent.putExtra("source_puin", paramString1);
              localIntent.putExtra("struct_share_key_source_action", "plugin");
              localIntent.putExtra("struct_share_key_source_a_action_data", paramJSONObject);
              localIntent.putExtra("struct_share_key_source_i_action_data", paramString3);
              localIntent.putExtra("struct_share_key_content_a_action_DATA", paramJSONObject);
              localIntent.putExtra("struct_share_key_source_icon", paramString4);
              localIntent.putExtra("app_name", paramString2);
            }
          }
          for (;;)
          {
            if ((this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareReportInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebUiMethodInterface != null))
            {
              localIntent.putExtra("strurt_msgid", this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareReportInterface.e());
              localIntent.putExtra("struct_uin", this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareReportInterface.f());
              localIntent.putExtra("struct_url", this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebUiMethodInterface.getCurrentUrl());
              localIntent.putExtra("from_web", true);
              if ((this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareReportInterface.g() != null) && (!"".equals(this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareReportInterface.g()))) {
                localIntent.putExtra("source_puin", this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareReportInterface.g());
              }
            }
            paramJSONObject = StructMsgFactory.a(localIntent.getExtras());
            if (paramJSONObject != null) {
              break label1781;
            }
            if (QLog.isColorLevel()) {
              QLog.d("QQApi", 2, "build struct msg fail");
            }
            if (TextUtils.isEmpty(this.E)) {
              break label1770;
            }
            callJs(this.E, new String[] { "false" });
            return;
            if (paramJSONObject.has("sourceName")) {
              paramString2 = paramJSONObject.optString("sourceName");
            }
            paramString3 = paramString2;
            if (TextUtils.isEmpty(paramString2))
            {
              paramString3 = paramString2;
              if (paramString5 != null) {
                paramString3 = paramString5.name;
              }
            }
            if (!TextUtils.isEmpty(paramString3)) {
              break label1802;
            }
            paramString2 = paramString1;
            break;
            paramJSONObject = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=cooperation.readinjoy.ReadInJoyProxyActivity&from=recent";
            break label986;
            paramString3 = "mqqapi://readinjoy/open?src_type=internal&version=1&from=recent";
            break label996;
            paramString4 = "http://sqimg.qq.com/qq_product_operations/ydqpush/message_icon/dingyuehao.png";
            break label1006;
            paramString3 = paramJSONObject.optString("src_webActionUrl", "");
            paramString5 = paramJSONObject.optString("src_actionData", "");
            paramString6 = paramJSONObject.optString("src_a_actionData", "");
            paramString7 = paramJSONObject.optString("src_i_actionData", "");
            if ((TextUtils.isEmpty(paramString4)) || (("web".equals(paramString4)) && (TextUtils.isEmpty(paramString3))) || ((!"web".equals(paramString4)) && (TextUtils.isEmpty(paramString5)) && ((TextUtils.isEmpty(paramString6)) || (TextUtils.isEmpty(paramString7)))))
            {
              paramString3 = String.format("mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=%s", new Object[] { paramString1 });
              paramString4 = String.format("mqqapi://card/show_pslcard?src_type=internal&card_type=public_account&uin=%s&version=1", new Object[] { paramString1 });
              localIntent.putExtra("struct_share_key_source_action", "plugin");
              localIntent.putExtra("struct_share_key_source_a_action_data", paramString3);
              localIntent.putExtra("struct_share_key_source_i_action_data", paramString4);
            }
            for (;;)
            {
              localIntent.putExtra("source_puin", paramString1);
              localIntent.putExtra("app_name", paramString2);
              paramJSONObject = paramJSONObject.optString("src_iconUrl", "");
              if (!TextUtils.isEmpty(paramJSONObject)) {
                break label1670;
              }
              localIntent.putExtra("struct_share_key_source_icon", "http://url.cn/JS8oE7");
              break;
              localIntent.putExtra("struct_share_key_source_action", paramString4);
              if ("web".equals(paramString4))
              {
                localIntent.putExtra("struct_share_key_source_url", paramString3);
                localIntent.putExtra("source_url", paramString3);
              }
              else
              {
                if (!TextUtils.isEmpty(paramString5)) {
                  localIntent.putExtra("struct_share_key_source_action_data", paramString5);
                }
                if (!TextUtils.isEmpty(paramString6)) {
                  localIntent.putExtra("struct_share_key_source_a_action_data", paramString6);
                }
                if (!TextUtils.isEmpty(paramString7)) {
                  localIntent.putExtra("struct_share_key_source_i_action_data", paramString7);
                }
              }
            }
            localIntent.putExtra("struct_share_key_source_icon", paramJSONObject);
            continue;
            if (paramJSONObject.has("sourceName"))
            {
              paramString1 = paramJSONObject.optString("sourceName");
              localIntent.putExtra("app_name", paramString1);
              if (("手Q阅读".equals(paramString1)) && (paramJSONObject.has("srcIconUrl"))) {
                localIntent.putExtra("struct_share_key_source_icon", paramJSONObject.optString("srcIconUrl"));
              }
            }
            else
            {
              localIntent.putExtra("app_name", this.jdField_a_of_type_AndroidContentContext.getString(2131364568));
            }
          }
          callJs4OpenApiIfNeeded("shareMsg", 0, "false");
          return;
          localIntent.putExtra("stuctmsg_bytes", paramJSONObject.getBytes());
          startActivityForResult(localIntent, (byte)1);
          return;
          paramString2 = paramString3;
        }
      }
    }
  }
  
  private void b(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    paramJSONObject = this.mRuntime.a();
    int i1 = -1;
    if (!WXShareHelper.a().a()) {
      i1 = 2131369529;
    }
    while (i1 != -1)
    {
      QRUtils.a(0, i1);
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
        a(paramJSONObject);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      return;
      if (!WXShareHelper.a().b()) {
        i1 = 2131369530;
      }
    }
    HashMap localHashMap = new HashMap(1);
    paramString1 = new sxz(this, paramString1, paramString4, localHashMap, paramString6, paramString2, paramString3, paramString7);
    if (TextUtils.isEmpty(paramString5))
    {
      paramString1.run();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      a(paramJSONObject);
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131369682);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
    ThreadManager.a(new syb(this, paramString5, localHashMap, paramString1), 8, null, false);
  }
  
  public String a(String paramString)
  {
    String str = "";
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebFeaturesInterface != null)
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebFeaturesInterface.a(paramString);
      str = paramString;
      if (QLog.isColorLevel())
      {
        QLog.d("gamecenter", 2, "<--getOpenidBatch result=" + paramString);
        str = paramString;
      }
    }
    return str;
  }
  
  public void a(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).optString("appID");
      String str1 = ((JSONObject)localObject).optString("paramsStr");
      String str2 = ((JSONObject)localObject).optString("packageName");
      String str3 = ((JSONObject)localObject).optString("flags");
      String str4 = ((JSONObject)localObject).optString("type");
      localObject = ((JSONObject)localObject).optString("subappid");
      a(paramString, str1, str2, str3, str4, (String)localObject);
      return;
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("launchAppWithTokens", 2, "parse params error");
      }
      paramString.printStackTrace();
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    if (QLog.isColorLevel()) {
      QLog.d("gamecenter", 2, "launchAppWithTokens " + paramString3);
    }
    AppLaucherHelper localAppLaucherHelper = new AppLaucherHelper();
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$QQBrowserBaseActivityInterface != null) {
      localObject = this.mRuntime.a();
    }
    for (;;)
    {
      if (localObject == null)
      {
        return;
        if ((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) {
          localObject = ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app;
        }
      }
      else
      {
        int i2 = 268435456;
        try
        {
          i3 = Integer.parseInt(paramString4);
          if ((0x4000000 & i3) == 67108864) {
            i2 = 335544320;
          }
          i1 = i2;
          if ((0x20000000 & i3) == 536870912) {
            i1 = i2 | 0x20000000;
          }
          i2 = i1;
          if ((i3 & 0x400000) == 4194304) {
            i2 = i1 | 0x400000;
          }
          i1 = i2;
        }
        catch (Exception paramString4)
        {
          int i1;
          for (;;)
          {
            int i3;
            String str;
            i1 = 268435456;
            continue;
            paramString2 = paramString4;
            if (QLog.isColorLevel())
            {
              QLog.d(getClass().getSimpleName(), 2, "launchAppWithWlogin webview is null");
              paramString2 = paramString4;
            }
          }
          localAppLaucherHelper.a((AppInterface)localObject, this.jdField_a_of_type_AndroidContentContext, paramString1, paramString2, paramString3, i1);
          return;
        }
        ReportController.b(null, "CliOper", "", "", "Game", "Launch_game", 0, 0, paramString1, "", "", "");
        i3 = 0;
        str = "tencentwtlogin" + paramString1 + "://";
        i2 = i3;
        if ("wtlogin".equals(paramString5))
        {
          paramString4 = this.jdField_a_of_type_AndroidContentContext.getPackageManager();
          paramString5 = new Intent("android.intent.action.VIEW");
          paramString5.setData(Uri.parse(str));
          i2 = i3;
          if (paramString4 != null)
          {
            i2 = i3;
            if (paramString4.queryIntentActivities(paramString5, 0).size() > 0) {
              i2 = 1;
            }
          }
        }
        if (i2 != 0)
        {
          paramString4 = "";
          if ((this.mRuntime != null) && (this.mRuntime.a() != null))
          {
            paramString2 = this.mRuntime.a().getUrl();
            localAppLaucherHelper.a(str, this.jdField_a_of_type_AndroidContentContext, paramString2, (AppInterface)localObject, paramString1, paramString3, i1, paramString6);
            return;
          }
        }
      }
      localObject = null;
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.E = null;
    for (;;)
    {
      JSONObject localJSONObject;
      String str1;
      String str2;
      String str3;
      String str4;
      String str5;
      String str6;
      int i1;
      try
      {
        localJSONObject = new JSONObject(paramString);
        Activity localActivity = this.mRuntime.a();
        if (!paramBoolean) {
          break label364;
        }
        paramString = "shareType";
        str1 = localJSONObject.optString(paramString, "0");
        str2 = localJSONObject.getString("title");
        str3 = localJSONObject.getString("desc");
        if (!paramBoolean) {
          break label462;
        }
        paramString = "shareUrl";
        str4 = localJSONObject.getString(paramString);
        if (!paramBoolean) {
          break label468;
        }
        paramString = "imageUrl";
        paramString = localJSONObject.optString(paramString);
        str5 = localJSONObject.optString("shareElement");
        str6 = localJSONObject.optString("flash_url");
        i1 = localJSONObject.optInt("shareQQType", 13);
        this.E = localJSONObject.optString("callback");
        paramBoolean = localJSONObject.optBoolean("keepShareUrl", false);
        HashMap localHashMap = new HashMap();
        if ((!paramBoolean) && (str4 != null) && (str4.length() > 180)) {
          localHashMap.put("share_url", str4);
        }
        if ((paramString != null) && (paramString.length() > 30) && (!"2".equals(str1)) && (!"3".equals(str1))) {
          localHashMap.put("image_url", paramString);
        }
        if ((str6 != null) && (str6.length() > 30)) {
          localHashMap.put("flash_url", str6);
        }
        if (localHashMap.isEmpty()) {
          break label370;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
          a(localActivity);
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131369682);
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
        }
        ThreadManager.a(new sxx(this, localHashMap, str4, paramString, str6, str1, localJSONObject, str2, str3, str5, i1, localActivity), 8, null, true);
        return;
      }
      catch (JSONException paramString) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("QQApi", 2, "shareMsg error: " + paramString.toString());
      return;
      label364:
      paramString = "share_type";
      continue;
      label370:
      if ("1".equals(str1))
      {
        a(localJSONObject, str1, str2, str3, str4, paramString, str5, str6);
        return;
      }
      if (("2".equals(str1)) || ("3".equals(str1)))
      {
        b(localJSONObject, str1, str2, str3, str4, paramString, str5, str6);
        return;
      }
      a(localJSONObject, str1, str2, str3, str4, paramString, str5, str6, i1);
      return;
      label462:
      paramString = "share_url";
      continue;
      label468:
      paramString = "image_url";
    }
  }
  
  public boolean a(String paramString)
  {
    return (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareInterface.setShareUrl(paramString));
  }
  
  public void b(String paramString)
  {
    try
    {
      int i1 = Integer.parseInt(paramString, 10);
      paramString = (SwiftBrowserMiscHandler)super.getBrowserComponent(32);
      if (paramString != null)
      {
        Message localMessage = paramString.a.obtainMessage(0, i1, 0);
        paramString.a.sendMessage(localMessage);
      }
      return;
    }
    catch (NumberFormatException paramString) {}
  }
  
  public boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQApi", 2, "setShareInfo been called");
    }
    Bundle localBundle = new Bundle();
    try
    {
      Object localObject2 = new JSONObject(paramString);
      paramString = ((JSONObject)localObject2).optString("title");
      String str1 = ((JSONObject)localObject2).optString("desc");
      String str2 = ((JSONObject)localObject2).optString("share_url");
      String str3 = ((JSONObject)localObject2).optString("image_url");
      Object localObject1 = ((JSONObject)localObject2).optString("cover_url");
      String str4 = ((JSONObject)localObject2).optString("source_name");
      localObject2 = ((JSONObject)localObject2).optString("article_id");
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localBundle.putString("cover_url", (String)localObject1);
      }
      if (!TextUtils.isEmpty(str4)) {
        localBundle.putString("source_name", str4);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        localBundle.putString("article_id", (String)localObject2);
      }
      localObject1 = this.mRuntime.a(this.mRuntime.a());
      if ((localObject1 != null) && ((localObject1 instanceof WebUiUtils.WebShareInterface)))
      {
        localBundle.putInt("extra_url_info_from", 1);
        return ((WebUiUtils.WebShareInterface)localObject1).setSummary(paramString, str1, str2, str3, localBundle);
      }
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQApi", 2, "setShareInfo param error");
      }
      return false;
    }
    return false;
  }
  
  public void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      this.E = null;
      try
      {
        paramString = new JSONObject(paramString);
        Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, ForwardRecentActivity.class);
        localIntent.putExtra("isFromShare", true);
        String str = paramString.optString("toUin");
        int i1 = paramString.optInt("uinType", 0);
        if ((str != null) && (str.length() >= 5))
        {
          localIntent.setClass(this.jdField_a_of_type_AndroidContentContext, DirectForwardActivity.class);
          localIntent.putExtra("toUin", str);
          localIntent.putExtra("uinType", i1);
        }
        localIntent.putExtra("forward_type", -1);
        localIntent.putExtra("forward_text", paramString.optString("text"));
        this.E = paramString.optString("callback");
        if (paramString.has("report")) {
          localIntent.putExtra("report", paramString.getString("report"));
        }
        localIntent.putExtra("openerProc", MobileQQ.getMobileQQ().getProcessName());
        startActivityForResult(localIntent, (byte)1);
        return;
      }
      catch (JSONException paramString) {}
    } while (!QLog.isColorLevel());
    QLog.d("QQApi", 2, "shareText error: " + paramString.getMessage());
  }
  
  public void d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = new JSONObject(paramString);
        if (!"0".equals(((JSONObject)localObject).optString("share_type", "0"))) {
          break;
        }
        paramString = new Intent(this.jdField_a_of_type_AndroidContentContext, ForwardRecentActivity.class);
        paramString.putExtra("pluginName", "web_share");
        paramString.putExtra("forward_type", -4);
        paramString.putExtra("openerProc", MobileQQ.getMobileQQ().getProcessName());
        paramString.putExtra("req_type", 3);
        paramString.putExtra("k_back", false);
        paramString.putExtra("key_flag_from_plugin", true);
        paramString.putExtra("forward_text", ((JSONObject)localObject).optString("text"));
        paramString.putExtra("struct_share_key_source_name", ((JSONObject)localObject).optString("srcName"));
        paramString.putExtra("struct_share_key_source_icon", ((JSONObject)localObject).optString("srcIconUrl"));
        paramString.putExtra("struct_share_key_source_url", ((JSONObject)localObject).optString("srcUrl"));
        localObject = StructMsgFactory.a(paramString.getExtras());
        if (localObject != null) {
          break label243;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQApi", 2, "build struct msg fail");
        }
        startActivityForResult(paramString, (byte)1);
        return;
      }
      catch (JSONException paramString) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("QQApi", 2, "shareHyperText error: " + paramString.getMessage());
      return;
      label243:
      paramString.putExtra("stuctmsg_bytes", ((AbsStructMsg)localObject).getBytes());
    }
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    Object localObject = null;
    boolean bool3 = false;
    boolean bool2 = bool3;
    boolean bool1;
    int i1;
    if ("QQApi".equals(paramString2))
    {
      if ((paramJsBridgeListener == null) || (!paramJsBridgeListener.a)) {
        break label96;
      }
      bool1 = true;
      addOpenApiListenerIfNeeded(paramString3, paramJsBridgeListener);
      i1 = paramVarArgs.length;
      if ((!"isAppInstalled".equals(paramString3)) || (i1 != 1)) {
        break label102;
      }
      paramString1 = Boolean.valueOf(PackageUtil.a(this.jdField_a_of_type_AndroidContentContext, paramVarArgs[0]));
      label77:
      if (!bool1) {
        break label613;
      }
      callJs4OpenApiIfNeeded(paramString3, 0, paramString1);
    }
    for (;;)
    {
      bool2 = true;
      label96:
      label102:
      do
      {
        do
        {
          return bool2;
          bool1 = false;
          break;
          if (("checkAppInstalled".equals(paramString3)) && (i1 == 1))
          {
            paramString1 = PackageUtil.a(this.jdField_a_of_type_AndroidContentContext, paramVarArgs[0]);
            break label77;
          }
          if (("checkAppInstalledBatch".equals(paramString3)) && (i1 == 1))
          {
            paramString1 = PackageUtil.b(this.jdField_a_of_type_AndroidContentContext, paramVarArgs[0]);
            break label77;
          }
          if (("isAppInstalledBatch".equals(paramString3)) && (i1 == 1))
          {
            paramString1 = PackageUtil.c(this.jdField_a_of_type_AndroidContentContext, paramVarArgs[0]);
            break label77;
          }
          if (("startAppWithPkgName".equals(paramString3)) && (i1 == 1))
          {
            paramString1 = Boolean.valueOf(PackageUtil.a(this.jdField_a_of_type_AndroidContentContext, paramVarArgs[0], null));
            break label77;
          }
          if (("startAppWithPkgNameAndOpenId".equals(paramString3)) && (i1 == 2))
          {
            paramString1 = Boolean.valueOf(PackageUtil.a(this.jdField_a_of_type_AndroidContentContext, paramVarArgs[0], paramVarArgs[1]));
            break label77;
          }
          if (("getOpenidBatch".equals(paramString3)) && (i1 == 1))
          {
            paramString1 = a(paramVarArgs[0]);
            break label77;
          }
          if (("launchAppWithTokens".equals(paramString3)) && ((i1 == 1) || (i1 == 4)))
          {
            if (i1 == 1)
            {
              a(paramVarArgs[0]);
              paramString1 = (String)localObject;
              break label77;
            }
            paramString1 = (String)localObject;
            if (i1 != 4) {
              break label77;
            }
            a(paramVarArgs[0], paramVarArgs[1], paramVarArgs[2], paramVarArgs[3], null, "");
            paramString1 = (String)localObject;
            break label77;
          }
          if (("getAppsVerionCodeBatch".equals(paramString3)) && (i1 == 1))
          {
            paramString1 = PackageUtil.d(this.jdField_a_of_type_AndroidContentContext, paramVarArgs[0]);
            break label77;
          }
          if (("setShareURL".equals(paramString3)) && (i1 == 1))
          {
            paramString1 = Boolean.valueOf(a(paramVarArgs[0]));
            break label77;
          }
          if (("setShareInfo".equals(paramString3)) && (i1 == 1))
          {
            paramString1 = Boolean.valueOf(b(paramVarArgs[0]));
            break label77;
          }
          if (("setToolHiddenFlags".equals(paramString3)) && (i1 == 1))
          {
            b(paramVarArgs[0]);
            paramString1 = (String)localObject;
            break label77;
          }
          if (("shareMsg".equals(paramString3)) && (i1 == 1))
          {
            a(paramVarArgs[0], bool1);
            paramString1 = (String)localObject;
            break label77;
          }
          if (("shareText".equals(paramString3)) && (i1 == 1))
          {
            c(paramVarArgs[0]);
            paramString1 = (String)localObject;
            break label77;
          }
          bool2 = bool3;
        } while (!"shareHypertext".equals(paramString3));
        bool2 = bool3;
      } while (i1 != 1);
      d(paramVarArgs[0]);
      paramString1 = (String)localObject;
      break label77;
      label613:
      paramJsBridgeListener.a(paramString1);
    }
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    String str;
    if (paramByte == 1)
    {
      if (TextUtils.isEmpty(this.E)) {
        break label59;
      }
      str = this.E;
      if (paramInt != -1) {
        break label52;
      }
    }
    label52:
    for (paramIntent = "true";; paramIntent = "false")
    {
      callJs(str, new String[] { paramIntent });
      return;
    }
    label59:
    if (paramInt == -1) {}
    for (paramIntent = "true";; paramIntent = "false")
    {
      callJs4OpenApiIfNeeded("shareMsg", 0, paramIntent);
      return;
    }
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_AndroidContentContext = a();
    WebUiBaseInterface localWebUiBaseInterface = this.mRuntime.a(this.mRuntime.a());
    if ((localWebUiBaseInterface != null) && ((localWebUiBaseInterface instanceof WebUiUtils.WebUiMethodInterface))) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebUiMethodInterface = ((WebUiUtils.WebUiMethodInterface)localWebUiBaseInterface);
    }
    localWebUiBaseInterface = this.mRuntime.a(this.mRuntime.a());
    if ((localWebUiBaseInterface != null) && ((localWebUiBaseInterface instanceof WebUiUtils.QQBrowserBaseActivityInterface))) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$QQBrowserBaseActivityInterface = ((WebUiUtils.QQBrowserBaseActivityInterface)localWebUiBaseInterface);
    }
    localWebUiBaseInterface = this.mRuntime.a(this.mRuntime.a());
    if ((localWebUiBaseInterface != null) && ((localWebUiBaseInterface instanceof WebUiUtils.WebFeaturesInterface))) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebFeaturesInterface = ((WebUiUtils.WebFeaturesInterface)localWebUiBaseInterface);
    }
    localWebUiBaseInterface = this.mRuntime.a(this.mRuntime.a());
    if ((localWebUiBaseInterface != null) && ((localWebUiBaseInterface instanceof WebUiUtils.WebShareReportInterface))) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareReportInterface = ((WebUiUtils.WebShareReportInterface)localWebUiBaseInterface);
    }
    localWebUiBaseInterface = this.mRuntime.a(this.mRuntime.a());
    if ((localWebUiBaseInterface != null) && ((localWebUiBaseInterface instanceof WebUiUtils.WebShareInterface))) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareInterface = ((WebUiUtils.WebShareInterface)localWebUiBaseInterface);
    }
  }
  
  protected void onDestroy()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener != null) {
      WXShareHelper.a().b(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener);
    }
    super.onDestroy();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\jsp\QQApiPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */