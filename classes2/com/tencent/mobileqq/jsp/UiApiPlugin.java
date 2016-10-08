package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.arrange.ui.AVMeetingActivity;
import com.tencent.biz.ProtoServlet;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.biz.troopplugin.PluginJumpManager;
import com.tencent.biz.ui.IPullRefreshHeader;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.EmosmActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.ShortcutGuideActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.apollo.store.ApolloFloatActivity;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopGiftUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.kapalaiadapter.KapalaiAdapterUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.MobileIssueSettings;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebUiBaseInterface;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.QQBrowserBaseActivityInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.QReaderUiInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.ReadInJoyUiInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.VipComicUiInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebProgressInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebShareInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebTitleBarInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebUiMethodInterface;
import com.tencent.protofile.getopenid.GetOpenidProto.GetOpenidEntry;
import com.tencent.protofile.getopenid.GetOpenidProto.GetOpenidReq;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebBackForwardList;
import com.tencent.smtt.sdk.WebView;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import com.tencent.widget.ActionSheet.OnDismissListener;
import com.tencent.widget.PopupMenuDialog;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.dingdong.DingdongPluginHelper;
import cooperation.readinjoy.ReadInJoyShareManager;
import cooperation.troop.TroopProxyActivity;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.NewIntent;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sye;
import syh;
import syi;
import syj;
import syk;
import syl;
import sym;
import syn;
import syo;

public class UiApiPlugin
  extends WebViewPlugin
  implements DialogInterface.OnCancelListener, View.OnClickListener, ActionSheet.OnButtonClickListener, ActionSheet.OnDismissListener
{
  private static final String A = "fromAIO";
  private static final String J = "10";
  private static final String K = "11";
  static final byte jdField_a_of_type_Byte = 3;
  public static final int a = 1001;
  public static final String a;
  static AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  static final byte jdField_b_of_type_Byte = 4;
  public static final int b = 1;
  static final String jdField_b_of_type_JavaLangString = "name";
  static final byte jdField_c_of_type_Byte = 5;
  public static final int c = 0;
  public static final String c = "callback";
  static final byte jdField_d_of_type_Byte = 6;
  public static final int d = 1;
  public static final String d = "key_troop_fee_notify_js_data_changed";
  static final byte jdField_e_of_type_Byte = 7;
  static final String jdField_e_of_type_JavaLangString = "extras";
  static final byte jdField_f_of_type_Byte = 8;
  static final String jdField_f_of_type_JavaLangString = "callback_url";
  static final byte jdField_g_of_type_Byte = 9;
  static final String jdField_g_of_type_JavaLangString = "mode";
  static final byte jdField_h_of_type_Byte = 10;
  static final String jdField_h_of_type_JavaLangString = "number";
  static final byte jdField_i_of_type_Byte = 11;
  static final String jdField_i_of_type_JavaLangString = "exclude";
  static final byte jdField_j_of_type_Byte = 12;
  static final String jdField_j_of_type_JavaLangString = "com.tencent.mobileqq.action.ACTION_WEBVIEW_CLOSE";
  static final String k = "ret";
  static final String l = "uin";
  static final String m = "groupCode";
  static final String n = "isGroup";
  static final String o = "errMsg";
  static final String p = "openids";
  public static final String q = "types";
  public static final String r = "greetingsTitle";
  public static final String s = "greetingsContent";
  public static final String t = "greetingsMembers";
  public static final String u = "greetingsName";
  public static final String v = "action";
  public static final String w = "sign";
  public static final String x = "ui";
  private static final String z = "sourceType";
  private String B;
  private String C;
  private String D;
  private String E;
  private String F;
  private String G;
  private String H;
  private String I;
  private ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new syo(this);
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  public TroopMemberApiClient a;
  private IPullRefreshHeader jdField_a_of_type_ComTencentBizUiIPullRefreshHeader;
  private RefreshView jdField_a_of_type_ComTencentBizUiRefreshView;
  private Client.onRemoteRespObserver jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver = new sye(this);
  protected QQCustomDialog a;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  PopupMenuDialog jdField_a_of_type_ComTencentWidgetPopupMenuDialog = null;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private boolean jdField_b_of_type_Boolean;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private boolean jdField_c_of_type_Boolean;
  private boolean jdField_d_of_type_Boolean;
  public int e;
  private volatile boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int = -1;
  private boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int;
  private boolean jdField_h_of_type_Boolean;
  private int jdField_i_of_type_Int;
  private boolean jdField_i_of_type_Boolean;
  private boolean jdField_j_of_type_Boolean;
  protected String y;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = UiApiPlugin.class.getSimpleName();
  }
  
  public UiApiPlugin()
  {
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = null;
    this.jdField_e_of_type_Int = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
    this.mPluginNameSpace = "ui";
  }
  
  private int a(String paramString)
  {
    int i1 = -1;
    if ("10".equals(paramString)) {
      i1 = 2130843226;
    }
    while (!"11".equals(paramString)) {
      return i1;
    }
    return 2130843223;
  }
  
  static int a(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      i1 = paramJSONObject.getInt(paramString);
      return i1;
    }
    catch (JSONException localJSONException)
    {
      try
      {
        int i1 = Color.parseColor(paramJSONObject.getString(paramString));
        return i1;
      }
      catch (Exception paramJSONObject) {}
    }
    return 0;
  }
  
  private Context a()
  {
    for (Activity localActivity = this.mRuntime.a(); (localActivity != null) && ((localActivity instanceof BasePluginActivity)); localActivity = ((BasePluginActivity)localActivity).getOutActivity()) {}
    return localActivity;
  }
  
  public static Intent a(Context paramContext, Map paramMap, String paramString1, String paramString2)
  {
    paramMap = new Intent("android.intent.action.MAIN");
    paramMap.setClassName(paramContext, ShortcutGuideActivity.class.getName());
    paramMap.addCategory("android.intent.category.LAUNCHER");
    paramMap.putExtra("from", paramString2);
    paramMap.putExtra("url", paramString1);
    return paramMap;
  }
  
  private WebUiUtils.QQBrowserBaseActivityInterface a()
  {
    WebUiBaseInterface localWebUiBaseInterface = this.mRuntime.a(this.mRuntime.a());
    if ((localWebUiBaseInterface != null) && ((localWebUiBaseInterface instanceof WebUiUtils.QQBrowserBaseActivityInterface))) {
      return (WebUiUtils.QQBrowserBaseActivityInterface)localWebUiBaseInterface;
    }
    return null;
  }
  
  private WebUiUtils.WebProgressInterface a()
  {
    WebUiBaseInterface localWebUiBaseInterface = this.mRuntime.a(this.mRuntime.a());
    if ((localWebUiBaseInterface != null) && ((localWebUiBaseInterface instanceof WebUiUtils.WebProgressInterface))) {
      return (WebUiUtils.WebProgressInterface)localWebUiBaseInterface;
    }
    return null;
  }
  
  private WebUiUtils.WebTitleBarInterface a()
  {
    WebUiBaseInterface localWebUiBaseInterface = this.mRuntime.a(this.mRuntime.a());
    if ((localWebUiBaseInterface != null) && ((localWebUiBaseInterface instanceof WebUiUtils.WebTitleBarInterface))) {
      return (WebUiUtils.WebTitleBarInterface)localWebUiBaseInterface;
    }
    return null;
  }
  
  private WebUiUtils.WebUiMethodInterface a()
  {
    WebUiBaseInterface localWebUiBaseInterface = this.mRuntime.a(this.mRuntime.a());
    if ((localWebUiBaseInterface != null) && ((localWebUiBaseInterface instanceof WebUiUtils.WebUiMethodInterface))) {
      return (WebUiUtils.WebUiMethodInterface)localWebUiBaseInterface;
    }
    return null;
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("result", paramString1);
      if (paramString2 != null) {
        localJSONObject.put("resultData", paramString2);
      }
      if (paramString3 != null) {
        localJSONObject.put("message", paramString3);
      }
      if (paramString4 != null) {
        localJSONObject.put("extras", paramString4);
      }
      paramString1 = localJSONObject.toString();
      return paramString1;
    }
    catch (JSONException paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getCallBackResult json error!");
      }
    }
    return "{\"result\":\"-1\",\"message\":\"getCallBackResult json error!\"}";
  }
  
  private static JSONObject a(String paramString)
  {
    int i1 = paramString.indexOf("?p=");
    if (i1 == -1) {}
    label88:
    do
    {
      return null;
      int i4 = i1 + 3;
      int i2 = paramString.indexOf('&', i4);
      int i3 = paramString.indexOf('#', i4);
      if (i2 == -1)
      {
        i1 = i3;
        if (i1 != -1) {
          break label88;
        }
      }
      for (paramString = paramString.substring(i4);; paramString = paramString.substring(i4, i1))
      {
        try
        {
          paramString = new JSONObject(URLDecoder.decode(paramString));
          return paramString;
        }
        catch (JSONException paramString) {}
        if (i3 != -1)
        {
          i1 = i3;
          if (i3 < i2) {
            break;
          }
        }
        i1 = i2;
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "parseOpenApiParamsFromUrl error", paramString);
    return null;
  }
  
  private void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    Object localObject = null;
    syj localsyj = null;
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    Activity localActivity = this.mRuntime.a();
    if ((localActivity == null) || (localActivity.isFinishing())) {}
    RelativeLayout localRelativeLayout;
    label200:
    do
    {
      do
      {
        return;
        localRelativeLayout = (RelativeLayout)localActivity.findViewById(2131297082);
        switch (paramInt)
        {
        }
        for (;;)
        {
          if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
            break label200;
          }
          if (paramBoolean2) {
            break;
          }
          localRelativeLayout.removeView(this.jdField_a_of_type_AndroidWidgetImageView);
          this.jdField_a_of_type_AndroidWidgetImageView = null;
          this.jdField_b_of_type_AndroidWidgetImageView = null;
          return;
          Drawable localDrawable = localActivity.getResources().getDrawable(2130840534);
          localObject = localDrawable;
          if (!TextUtils.isEmpty(paramString))
          {
            localsyj = new syj(this, paramString);
            localObject = localDrawable;
          }
        }
      } while (this.jdField_b_of_type_AndroidWidgetImageView == null);
      if (paramBoolean1) {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(localsyj);
        this.jdField_a_of_type_AndroidWidgetImageView.invalidate();
        return;
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(localActivity);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(localActivity.getResources().getDrawable(2130843321));
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(localActivity);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(localsyj);
      paramString = new RelativeLayout(localActivity);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(13, -1);
      paramString.addView(this.jdField_a_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject);
      localObject = new RelativeLayout.LayoutParams(DisplayUtil.a(localBaseApplication, 8.0F), DisplayUtil.a(localBaseApplication, 8.0F));
      ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
      ((RelativeLayout.LayoutParams)localObject).addRule(11, -1);
      ((RelativeLayout.LayoutParams)localObject).setMargins(0, DisplayUtil.a(localBaseApplication, 4.0F), DisplayUtil.a(localBaseApplication, 4.0F), 0);
      paramString.addView(this.jdField_b_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject);
      localObject = new RelativeLayout.LayoutParams(DisplayUtil.a(localBaseApplication, 36.0F), DisplayUtil.a(localBaseApplication, 36.0F));
      ((RelativeLayout.LayoutParams)localObject).addRule(0, 2131296798);
      ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject).setMargins(0, 0, DisplayUtil.a(localBaseApplication, 4.0F), 0);
    } while (localRelativeLayout == null);
    localRelativeLayout.addView(paramString, (ViewGroup.LayoutParams)localObject);
  }
  
  public static void a(Activity paramActivity, AppInterface paramAppInterface, long paramLong, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int i2 = paramArrayOfString.length;
    if ((i2 == 0) || (i2 != paramArrayOfInt.length) || (paramLong == -1L))
    {
      paramActivity.setResult(-1, new Intent().putExtra("ret", 4));
      paramActivity.finish();
      return;
    }
    GetOpenidProto.GetOpenidReq localGetOpenidReq = new GetOpenidProto.GetOpenidReq();
    localGetOpenidReq.appid.set(paramLong);
    int i1 = 0;
    if (i1 < i2)
    {
      GetOpenidProto.GetOpenidEntry localGetOpenidEntry = new GetOpenidProto.GetOpenidEntry();
      for (;;)
      {
        int i3;
        try
        {
          localGetOpenidEntry.id.set(Long.parseLong(paramArrayOfString[i1], 10));
          i3 = paramArrayOfInt[i1];
          if (i3 == 0)
          {
            localGetOpenidEntry.type.set(0);
            localGetOpenidReq.list.add(localGetOpenidEntry);
            i1 += 1;
          }
        }
        catch (NumberFormatException paramAppInterface)
        {
          paramActivity.setResult(-1, new Intent().putExtra("ret", 4).putExtra("errMsg", "uin error"));
          paramActivity.finish();
          return;
        }
        if (i3 == 1)
        {
          localGetOpenidEntry.type.set(1);
        }
        else
        {
          if (i3 != 3000) {
            break label214;
          }
          localGetOpenidEntry.type.set(2);
        }
      }
      label214:
      paramActivity.setResult(-1, new Intent().putExtra("ret", 4).putExtra("errMsg", "uin type error"));
      paramActivity.finish();
      return;
    }
    paramArrayOfString = new NewIntent(BaseApplicationImpl.getContext(), ProtoServlet.class);
    paramArrayOfString.setWithouLogin(true);
    paramArrayOfString.putExtra("cmd", "CommCompSvr.get_openid");
    paramArrayOfString.putExtra("data", localGetOpenidReq.toByteArray());
    paramArrayOfString.setObserver(new syh(paramActivity));
    paramAppInterface.startServlet(paramArrayOfString);
  }
  
  private void a(AbsBaseWebViewActivity paramAbsBaseWebViewActivity, String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2)) {
      if ("my_emoji_clk".equals(paramString2)) {
        if (("11".equals(paramString1)) && (paramAbsBaseWebViewActivity != null))
        {
          paramString2 = paramAbsBaseWebViewActivity.getIntent();
          Intent localIntent = new Intent(paramAbsBaseWebViewActivity, EmosmActivity.class);
          localIntent.putExtra("key_emojimall_detail_chat_type", paramString2.getIntExtra("key_emojimall_detail_chat_type", -1));
          localIntent.putExtra("key_emojimall_detail_chat_uin", paramString2.getStringExtra("key_emojimall_detail_chat_uin"));
          localIntent.putExtra("emojimall_src", paramString2.getIntExtra("emojimall_src", 1));
          paramAbsBaseWebViewActivity.startActivity(localIntent);
        }
      }
    }
    for (;;)
    {
      if ("10".equals(paramString1)) {
        ReportController.b(null, "CliOper", "", "", "ep_mall", "Clk_ep_search", 0, 0, "", "", "", "");
      }
      return;
      QLog.e(jdField_a_of_type_JavaLangString, 1, "handleDoubleRightBtnClickEvent, my_emoji_clk, activity = null or iconid != my dressup");
      continue;
      callJs(paramString2, new String[] { "" });
      continue;
      QLog.e(jdField_a_of_type_JavaLangString, 1, "handleDoubleRightBtnClickEvent, callback null, iconId=" + paramString1);
    }
  }
  
  private void a(String paramString)
  {
    int i3 = 0;
    if (TextUtils.isEmpty(paramString)) {}
    Object localObject1;
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null)
      {
        if (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()) {
          this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
        }
        if (paramString.equals(this.B))
        {
          this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
          return;
        }
      }
      localObject1 = this.mRuntime.a();
    } while (localObject1 == null);
    for (;;)
    {
      int i5;
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        localObject1 = ActionSheet.a((Context)localObject1);
        Object localObject2 = localJSONObject.optString("title");
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          ((ActionSheet)localObject1).a((CharSequence)localObject2);
        }
        localObject2 = localJSONObject.optJSONArray("items");
        int i4 = localJSONObject.optInt("selected", -1);
        this.jdField_a_of_type_Boolean = false;
        String str = localJSONObject.optString("close");
        if (TextUtils.isEmpty(str)) {
          break label391;
        }
        this.jdField_a_of_type_Boolean = true;
        ((ActionSheet)localObject1).a(str, 3);
        i1 = 1;
        i2 = i1;
        if (localObject2 != null)
        {
          i2 = i1;
          if (((JSONArray)localObject2).length() > 0)
          {
            i5 = ((JSONArray)localObject2).length();
            i2 = i3;
            if (i4 >= 0)
            {
              i2 = i3;
              if (i4 < i5)
              {
                i2 = 0;
                if (i2 >= i5) {
                  break label403;
                }
                str = ((JSONArray)localObject2).getString(i2);
                if (i2 != i4) {
                  break label397;
                }
                bool = true;
                ((ActionSheet)localObject1).a(str, bool);
                i2 += 1;
                continue;
              }
            }
            if (i2 >= i5) {
              break label403;
            }
            ((ActionSheet)localObject1).c(((JSONArray)localObject2).getString(i2));
            i2 += 1;
            continue;
          }
        }
        localObject2 = localJSONObject.optString("cancel");
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          ((ActionSheet)localObject1).d((CharSequence)localObject2);
        }
        ((ActionSheet)localObject1).a(this);
        ((ActionSheet)localObject1).a(this);
        ((ActionSheet)localObject1).setOnCancelListener(this);
        this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)localObject1);
        this.C = localJSONObject.optString("onclick");
        this.jdField_f_of_type_Int = i2;
        this.B = paramString;
        this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
        return;
      }
      catch (JSONException paramString) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(jdField_a_of_type_JavaLangString, 2, "showActionSheet error:" + paramString.getMessage());
      return;
      label391:
      int i1 = 0;
      continue;
      label397:
      boolean bool = false;
      continue;
      label403:
      int i2 = i1 + i5;
    }
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    Activity localActivity = this.mRuntime.a();
    if (localActivity == null) {}
    while (this.mRuntime.a() == null) {
      return;
    }
    label953:
    for (;;)
    {
      try
      {
        Object localObject2 = new JSONObject(paramString);
        String str = ((JSONObject)localObject2).optString("url");
        Object localObject1;
        int i1;
        if (paramBoolean)
        {
          localObject1 = localObject2;
          if ((TextUtils.isEmpty(str)) || (localObject1 == null) || (!((JSONObject)localObject1).has("style"))) {
            break;
          }
          paramString = null;
          if (!localActivity.getClass().getName().equalsIgnoreCase("com.tencent.qqreadinjoy.detailspage.ReadInJoyArticleDetailActivity")) {
            paramString = localActivity.getIntent().getExtras();
          }
          if (paramString != null) {
            continue;
          }
          paramString = new Bundle();
          i1 = ((JSONObject)localObject1).optInt("style");
          if (!Boolean.valueOf(((JSONObject)localObject2).optBoolean("is_native", true)).booleanValue()) {
            continue;
          }
          PluginJumpManager.getInstance().updateConfig(this.mRuntime.a());
          PluginJumpManager.getInstance().loadConfig();
          if (!(localActivity instanceof mqq.app.BaseActivity)) {
            continue;
          }
          if (PluginJumpManager.getInstance().openView((mqq.app.BaseActivity)localActivity, str, String.valueOf(i1))) {
            break;
          }
          continue;
        }
        switch (((JSONObject)localObject1).optInt("navigationBarStyle"))
        {
        case 1: 
          i1 = ((JSONObject)localObject1).optInt("target");
          if (localActivity.getClass().getName().equalsIgnoreCase("com.tencent.qqreadinjoy.detailspage.ReadInJoyArticleDetailActivity"))
          {
            localObject2 = new Intent(((BasePluginActivity)localActivity).getOutActivity(), QQBrowserActivity.class);
            ((Intent)localObject2).putExtras(paramString);
            ((Intent)localObject2).putExtra("url", str);
            ((Intent)localObject2).setFlags(0);
            if (i1 == 1) {
              ((Intent)localObject2).putExtra("articalChannelId", 0);
            }
            localActivity.startActivityForResult((Intent)localObject2, 100);
          }
          switch (((JSONObject)localObject1).optInt("animation"))
          {
          case 0: 
          case 1: 
            localActivity.overridePendingTransition(0, 0);
            return;
            localObject1 = ((JSONObject)localObject2).optJSONObject("options");
            continue;
            paramString.remove("title");
            paramString.remove("leftViewText");
            paramString.remove("post_data");
            paramString.remove("options");
            paramString.remove("isOpeningQunApp");
            paramString.remove("isTransparentTitleAndClickable");
            if (paramString.containsKey("startOpenPageTime"))
            {
              paramString.putLong("startOpenPageTime", System.currentTimeMillis());
              break label953;
              if (PluginJumpManager.getInstance().openView((com.tencent.mobileqq.app.BaseActivity)localActivity, str, String.valueOf(i1)))
              {
                return;
                paramString.putBoolean("hide_more_button", false);
                paramString.putBoolean("hide_operation_bar", true);
                continue;
                paramString.putBoolean("hide_more_button", true);
                paramString.putBoolean("hide_operation_bar", true);
                continue;
                paramString.putBoolean("hide_more_button", false);
                paramString.putBoolean("hide_operation_bar", false);
                paramString.putString("webStyle", "");
                continue;
                paramString.putBoolean("hide_more_button", true);
                paramString.putBoolean("hide_operation_bar", false);
                paramString.putString("webStyle", "");
                continue;
                paramString.putBoolean("isTransparentTitleAndClickable", true);
                continue;
                if (localActivity.getClass().getName().equalsIgnoreCase("com.tencent.mobileqq.activity.QQVasH5PayBrowserActivity"))
                {
                  localObject2 = new Intent(localActivity, QQBrowserActivity.class);
                  ((Intent)localObject2).putExtras(paramString);
                  ((Intent)localObject2).putExtra("url", str);
                  ((Intent)localObject2).setFlags(0);
                  localActivity.startActivityForResult((Intent)localObject2, 100);
                  continue;
                }
                if ((localActivity.getClass().getName().equalsIgnoreCase("com.qqcomic.activity.fragment.VipComicMainFragmentActivity")) || (localActivity.getClass().getName().equalsIgnoreCase("com.qqcomic.activity.VipComicMainTabActivity")))
                {
                  localObject2 = new Intent();
                  ((Intent)localObject2).setClassName("com.qqcomic", "com.qqcomic.activity.fragment.VipComicWebFragmentActivity");
                  ((Intent)localObject2).putExtras(paramString);
                  ((Intent)localObject2).putExtra("url", str);
                  ((Intent)localObject2).setFlags(0);
                  localActivity.startActivityForResult((Intent)localObject2, 100);
                  continue;
                }
                if (((localActivity instanceof ApolloFloatActivity)) || (((JSONObject)localObject1).optBoolean("useQQBrowser", false)))
                {
                  localObject2 = new Intent(localActivity, QQBrowserActivity.class);
                  if (((JSONObject)localObject1).optBoolean("isOpeningQunApp"))
                  {
                    paramString.putBoolean("isOpeningQunApp", ((JSONObject)localObject1).optBoolean("isOpeningQunApp"));
                    paramString.putInt("appid", ((JSONObject)localObject1).optInt("appid"));
                    JSONObject localJSONObject = ((JSONObject)localObject1).optJSONObject("extraParams");
                    if (localJSONObject != null)
                    {
                      paramString.putString("extraParams", localJSONObject.toString());
                      paramString.putInt("troopid", localJSONObject.optInt("gc"));
                    }
                  }
                  ((Intent)localObject2).putExtras(paramString);
                  ((Intent)localObject2).putExtra("url", str);
                  ((Intent)localObject2).setFlags(0);
                  if (i1 == 1) {
                    ((Intent)localObject2).putExtra("articalChannelId", 0);
                  }
                  localActivity.startActivityForResult((Intent)localObject2, 100);
                  continue;
                }
                localObject2 = new Intent(localActivity, localActivity.getClass());
              }
            }
            break;
          case 2: 
            localActivity.overridePendingTransition(2130968793, 0);
            return;
            switch (i1)
            {
            }
            break;
          }
          break;
        default: 
          continue;
          return;
        }
      }
      catch (JSONException paramString)
      {
        return;
      }
    }
  }
  
  private void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      a(paramJSONObject, null, new syk(this, paramJSONObject));
    }
  }
  
  private void a(JSONObject paramJSONObject, JsBridgeListener paramJsBridgeListener)
  {
    if (paramJSONObject != null) {
      a(paramJSONObject, paramJsBridgeListener, null);
    }
  }
  
  private void a(JSONObject paramJSONObject, JsBridgeListener paramJsBridgeListener, View.OnClickListener paramOnClickListener)
  {
    Activity localActivity = this.mRuntime.a();
    if (localActivity == null) {}
    int i1;
    String str1;
    String str2;
    String str3;
    boolean bool;
    int i2;
    do
    {
      return;
      i1 = paramJSONObject.optInt("iconID");
      str1 = paramJSONObject.optString("title");
      str2 = paramJSONObject.optString("callback");
      str3 = paramJSONObject.optString("color");
      bool = paramJSONObject.optBoolean("hidden");
      i2 = paramJSONObject.optInt("cornerID");
      if ((localActivity instanceof AbsBaseWebViewActivity))
      {
        ((AbsBaseWebViewActivity)localActivity).a(str2, str1, str3, bool, i1, i2, paramJsBridgeListener, paramOnClickListener);
        return;
      }
      paramJSONObject = this.mRuntime.a(this.mRuntime.a());
      if ((paramJSONObject != null) && ((paramJSONObject instanceof WebUiUtils.WebTitleBarInterface)))
      {
        ((WebUiUtils.WebTitleBarInterface)paramJSONObject).a(str2, str1, str3, bool, i1, i2, paramOnClickListener);
        return;
      }
      if ((paramJSONObject != null) && ((paramJSONObject instanceof WebUiUtils.QReaderUiInterface)))
      {
        ((WebUiUtils.QReaderUiInterface)paramJSONObject).a(str2, str1, str3, bool, i1, i2, paramOnClickListener);
        return;
      }
      if ((paramJSONObject != null) && ((paramJSONObject instanceof WebUiUtils.ReadInJoyUiInterface)))
      {
        ((WebUiUtils.ReadInJoyUiInterface)paramJSONObject).setRightButton(str2, str1, str3, bool, i1, i2, paramOnClickListener);
        return;
      }
    } while ((paramJSONObject == null) || (!(paramJSONObject instanceof WebUiUtils.VipComicUiInterface)));
    ((WebUiUtils.VipComicUiInterface)paramJSONObject).a(str2, str1, str3, bool, i1, i2, paramOnClickListener);
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean == this.jdField_i_of_type_Boolean) {}
    do
    {
      return;
      if (!paramBoolean) {
        break label214;
      }
      if (this.jdField_a_of_type_AndroidViewView != null) {
        break;
      }
      localObject2 = BaseApplicationImpl.getContext();
      localObject1 = this.mRuntime.a();
    } while ((localObject1 == null) || (((Activity)localObject1).isFinishing()));
    TextView localTextView = new TextView((Context)localObject1);
    localTextView.setText(2131369134);
    localTextView.setBackgroundResource(2130843457);
    localTextView.setGravity(17);
    localTextView.setIncludeFontPadding(false);
    localTextView.setMaxWidth(DisplayUtil.a((Context)localObject2, 100.0F));
    localTextView.setMinWidth(DisplayUtil.a((Context)localObject2, 52.0F));
    localTextView.setSingleLine();
    localTextView.setTextColor(((Context)localObject2).getResources().getColor(2131428258));
    localTextView.setTextSize(1, 17.0F);
    Object localObject2 = new RelativeLayout.LayoutParams(-2, DisplayUtil.a((Context)localObject2, 36.0F));
    ((RelativeLayout.LayoutParams)localObject2).addRule(0, 2131296798);
    ((RelativeLayout.LayoutParams)localObject2).addRule(15, -1);
    localTextView.setOnClickListener(this);
    Object localObject1 = (RelativeLayout)((Activity)localObject1).findViewById(2131297082);
    if (localObject1 != null) {
      ((RelativeLayout)localObject1).addView(localTextView, (ViewGroup.LayoutParams)localObject2);
    }
    this.jdField_a_of_type_AndroidViewView = localTextView;
    for (;;)
    {
      this.jdField_i_of_type_Boolean = true;
      return;
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    label214:
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    this.jdField_i_of_type_Boolean = false;
  }
  
  public static boolean a(Context paramContext, Intent paramIntent, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    for (;;)
    {
      try
      {
        paramString2 = BitmapFactory.decodeResource(paramContext.getResources(), 2130838592);
        if (paramString2 != null) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "createShortcut.failed, icon is null.");
        }
        return false;
      }
      catch (OutOfMemoryError paramString2)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, QLog.getStackTraceString(paramString2));
        }
        paramString2 = null;
        continue;
      }
      try
      {
        paramString2 = HttpUtil.a(paramContext, paramString2, "GET", null, null);
        if (paramString2 == null) {
          return false;
        }
      }
      catch (IOException paramString2)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, QLog.getStackTraceString(paramString2));
          }
          paramString2 = null;
        }
        try
        {
          paramString2 = BitmapFactory.decodeByteArray(paramString2, 0, paramString2.length);
        }
        catch (OutOfMemoryError paramString2)
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, QLog.getStackTraceString(paramString2));
          }
          paramString2 = null;
        }
      }
    }
    Intent localIntent = new Intent();
    KapalaiAdapterUtil.a().a(paramIntent);
    localIntent.putExtra("android.intent.extra.shortcut.INTENT", paramIntent);
    localIntent.putExtra("android.intent.extra.shortcut.NAME", paramString1);
    int i1;
    if (paramString2 != null)
    {
      i1 = DisplayUtils.b(paramContext);
      paramIntent = paramString2;
      if (i1 != paramString2.getWidth()) {
        if (MobileIssueSettings.jdField_c_of_type_Boolean) {
          break label264;
        }
      }
    }
    label264:
    for (paramIntent = KapalaiAdapterUtil.a().a(paramString2, i1);; paramIntent = Bitmap.createScaledBitmap(paramString2, i1, i1, false))
    {
      localIntent.putExtra("android.intent.extra.shortcut.ICON", paramIntent);
      localIntent.putExtra("duplicate", false);
      localIntent.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
      paramContext.sendOrderedBroadcast(localIntent, null);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "createShortcut.finish.");
      }
      return true;
    }
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    do
    {
      do
      {
        return false;
        if (paramString2.equals("g_appstore_myapp"))
        {
          paramString1 = new Intent();
          TroopProxyActivity.d(this.mRuntime.a(), paramString1);
          return true;
        }
      } while ((TextUtils.isEmpty(paramString1)) || (!paramString1.matches("\\d+")));
      if (paramString2.equals("g_flower"))
      {
        startActivityForResult(TroopGiftUtil.a(this.mRuntime.a(), paramString1, "web"), (byte)10);
        a(paramString1, "exp");
        return true;
      }
      if (paramString2.equals("g_proceeding"))
      {
        paramString2 = new Intent();
        paramString2.putExtra("_src_type_", 1);
        paramString2.putExtra("_src_code_", paramString1);
        DingdongPluginHelper.a(this.mRuntime.a(), "com.dingdong.business.base.activity.DingdongDingActivity", paramString2, -1);
        return true;
      }
      if (paramString2.equals("g_homework"))
      {
        if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient == null)
        {
          this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
          this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
        }
        this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(paramString1, paramString2);
        return true;
      }
      if (paramString2.equals("g_org"))
      {
        paramString1 = "mqqapi://group/openOrg?troopUin=" + paramString1;
        paramString2 = new Intent();
        paramString2.setData(Uri.parse(paramString1));
        paramString2.setAction("android.intent.action.VIEW");
        this.mRuntime.a().startActivity(paramString2);
        return true;
      }
      if (paramString2.equals("g_topic"))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "g_topic ---------------");
        }
        return true;
      }
      if (paramString2.equals("g_approval"))
      {
        paramString2 = new Intent();
        paramString2.putExtra("ApprovalOpenParams.opentype", 1);
        paramString2.putExtra("ApprovalOpenParams.fromuin", paramString1);
        DingdongPluginHelper.a(this.mRuntime.a(), "com.dingdong.business.approval.activity.ApprovalSessionsActivity", paramString2, -1);
        return true;
      }
      if (paramString2.equals("g_troop_reward"))
      {
        if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient == null)
        {
          this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
          this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
        }
        this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(paramString1, paramString2);
        return true;
      }
    } while (!paramString2.equals("g_officecall"));
    paramString2 = new Intent(this.mRuntime.a(), AVMeetingActivity.class);
    paramString2.putExtra("param_only_troop_member", true);
    paramString2.putExtra("group_uin", paramString1);
    this.mRuntime.a().startActivity(paramString2);
    ReportController.b(null, "CliOper", "", "", "0X800667A", "0X800667A", 0, 0, "", "", "", "");
    return true;
  }
  
  private void b(String paramString)
  {
    Object localObject = this.mRuntime.a(this.mRuntime.a());
    if ((localObject != null) && ((localObject instanceof WebUiUtils.WebShareInterface)))
    {
      localObject = ((WebUiUtils.WebShareInterface)localObject).getShare();
      Bundle localBundle = new Bundle();
      localBundle.putString("title", ((Share)localObject).b());
      localBundle.putString("desc", ((Share)localObject).c());
      localBundle.putString("detail_url", ((Share)localObject).a());
      localBundle.putString("cover_url", ((Share)localObject).e());
      localBundle.putInt("article_id", ((Share)localObject).a());
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(((Share)localObject).d());
      localBundle.putStringArrayList("image_url", localArrayList);
      localBundle.putString("source_name", ((Share)localObject).f());
      if (a() != null)
      {
        if (!ReadInJoyShareManager.a(this.mRuntime.a(), a(), localBundle, null, 0)) {
          break label189;
        }
        if (!TextUtils.isEmpty(paramString)) {
          callJs(paramString, new String[] { "true" });
        }
      }
    }
    return;
    label189:
    if (!TextUtils.isEmpty(paramString)) {
      callJs(paramString, new String[] { "false" });
    }
    QRUtils.a(1, 2131369679);
  }
  
  private void b(JSONObject paramJSONObject)
  {
    ArrayList localArrayList = new ArrayList();
    Activity localActivity = this.mRuntime.a();
    if (localActivity == null) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "showPopupMenu: context is null");
      }
    }
    Object localObject1;
    float f1;
    JSONArray localJSONArray;
    for (;;)
    {
      return;
      localObject1 = this.mRuntime.a(this.mRuntime.a());
      if ((localObject1 != null) && ((localObject1 instanceof WebUiUtils.WebTitleBarInterface))) {
        localObject1 = ((WebUiUtils.WebTitleBarInterface)localObject1).getTitleBarView();
      }
      for (;;)
      {
        if (localObject1 == null)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d(jdField_a_of_type_JavaLangString, 2, "showPopupMenu: Can not get TitleBar");
          return;
          if ((localObject1 != null) && ((localObject1 instanceof WebUiUtils.QReaderUiInterface)))
          {
            localObject1 = ((WebUiUtils.QReaderUiInterface)localObject1).a();
          }
          else if ((localObject1 != null) && ((localObject1 instanceof WebUiUtils.VipComicUiInterface)))
          {
            localObject1 = ((WebUiUtils.VipComicUiInterface)localObject1).a();
          }
          else
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d(jdField_a_of_type_JavaLangString, 2, "showPopupMenu: activity has not implement WebUiMethodInterface");
            return;
          }
        }
      }
      f1 = localActivity.getResources().getDisplayMetrics().density;
      if (this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog != null)
      {
        if (!this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.isShowing()) {
          this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.showAsDropDown((View)localObject1, ((View)localObject1).getWidth() - localActivity.getResources().getDimensionPixelSize(2131493351) - localActivity.getResources().getDimensionPixelSize(2131493355), localActivity.getResources().getDimensionPixelSize(2131493356));
        }
      }
      else
      {
        Drawable localDrawable = localActivity.getResources().getDrawable(2130838381);
        try
        {
          localJSONArray = paramJSONObject.optJSONArray("list");
          if (localJSONArray == null)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d(jdField_a_of_type_JavaLangString, 2, "showPopupMenu: list is null");
          }
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.e(jdField_a_of_type_JavaLangString, 2, "showPopupMenu Exception: " + localException.getMessage());
          }
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog = PopupMenuDialog.a(localActivity, localArrayList, new syl(this, paramJSONObject, localActivity));
      this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.showAsDropDown((View)localObject1, ((View)localObject1).getWidth() - localActivity.getResources().getDimensionPixelSize(2131493351) - localActivity.getResources().getDimensionPixelSize(2131493355), localActivity.getResources().getDimensionPixelSize(2131493356));
      return;
      int i1 = 0;
      while (i1 < localJSONArray.length())
      {
        Object localObject2 = localJSONArray.optJSONObject(i1);
        PopupMenuDialog.MenuItem localMenuItem = new PopupMenuDialog.MenuItem();
        localMenuItem.jdField_a_of_type_Int = Integer.parseInt(((JSONObject)localObject2).optString("id"));
        localMenuItem.jdField_a_of_type_JavaLangString = ((JSONObject)localObject2).optString("itemContent");
        localMenuItem.jdField_b_of_type_JavaLangString = localMenuItem.jdField_a_of_type_JavaLangString;
        localMenuItem.jdField_b_of_type_Int = 2130843506;
        localObject2 = ((JSONObject)localObject2).optString("itemUrl");
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mRequestWidth = ((int)(71.0F * f1));
          localURLDrawableOptions.mRequestHeight = ((int)(94.0F * f1));
          localURLDrawableOptions.mLoadingDrawable = localException;
          localURLDrawableOptions.mFailedDrawable = localException;
          localMenuItem.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable((String)localObject2, localURLDrawableOptions);
        }
        localArrayList.add(localMenuItem);
        i1 += 1;
      }
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.isShowing()) {
      this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.dismiss();
    }
  }
  
  private void c(JSONObject paramJSONObject)
  {
    Object localObject = this.mRuntime.a();
    if ((localObject == null) || (((Activity)localObject).isFinishing())) {}
    while (paramJSONObject == null) {
      return;
    }
    String str = paramJSONObject.optString("title");
    WebUiBaseInterface localWebUiBaseInterface;
    if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(str)))
    {
      localWebUiBaseInterface = this.mRuntime.a(this.mRuntime.a());
      if ((localWebUiBaseInterface == null) || (!(localWebUiBaseInterface instanceof WebUiUtils.VipComicUiInterface))) {
        break label97;
      }
      ((WebUiUtils.VipComicUiInterface)localWebUiBaseInterface).a(str);
    }
    for (;;)
    {
      this.y = paramJSONObject.optString("callback");
      return;
      label97:
      if ((localWebUiBaseInterface != null) && ((localWebUiBaseInterface instanceof WebUiUtils.QReaderUiInterface)))
      {
        ((WebUiUtils.QReaderUiInterface)localWebUiBaseInterface).b(str);
      }
      else
      {
        localObject = (TextView)((Activity)localObject).findViewById(2131297083);
        if (localObject != null) {
          ((TextView)localObject).setText(str);
        }
      }
    }
  }
  
  private void d(JSONObject paramJSONObject)
  {
    Activity localActivity;
    String str1;
    String str2;
    String str3;
    Object localObject1;
    Object localObject2;
    if (paramJSONObject != null)
    {
      localActivity = this.mRuntime.a();
      if ((localActivity == null) || (!(localActivity instanceof AbsBaseWebViewActivity))) {
        break label371;
      }
      str1 = paramJSONObject.optString("iconID1");
      paramJSONObject.optString("schemeType1");
      str2 = paramJSONObject.optString("_sharedCallbackID1");
      str3 = paramJSONObject.optString("voiceStr1");
      localObject1 = paramJSONObject.optString("iconID2");
      paramJSONObject.optString("schemeType2");
      localObject2 = paramJSONObject.optString("_sharedCallbackID2");
      String str4 = paramJSONObject.optString("voiceStr2");
      paramJSONObject = (AbsBaseWebViewActivity)localActivity;
      paramJSONObject.rightViewImg.setVisibility(0);
      this.jdField_i_of_type_Int = a((String)localObject1);
      SwiftBrowserUIStyleHandler localSwiftBrowserUIStyleHandler = (SwiftBrowserUIStyleHandler)super.getBrowserComponent(2);
      if (localSwiftBrowserUIStyleHandler == null) {
        break label275;
      }
      localSwiftBrowserUIStyleHandler.a(paramJSONObject.rightViewImg, false, this.jdField_i_of_type_Int);
      paramJSONObject.rightViewImg.setContentDescription(str4);
      paramJSONObject.rightViewImg.setOnClickListener(new sym(this, paramJSONObject, (String)localObject1, (String)localObject2));
      localObject1 = (RelativeLayout)localActivity.findViewById(2131297082);
      if (this.jdField_c_of_type_AndroidWidgetImageView == null) {
        break label289;
      }
      ((RelativeLayout)localObject1).removeView(this.jdField_c_of_type_AndroidWidgetImageView);
      label201:
      this.jdField_h_of_type_Int = a(str1);
      if (localSwiftBrowserUIStyleHandler == null) {
        break label357;
      }
      localSwiftBrowserUIStyleHandler.a(this.jdField_c_of_type_AndroidWidgetImageView, false, this.jdField_h_of_type_Int);
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(str3);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new syn(this, paramJSONObject, str1, str2));
      ((RelativeLayout)localObject1).addView(this.jdField_c_of_type_AndroidWidgetImageView);
      return;
      label275:
      paramJSONObject.rightViewImg.setImageResource(this.jdField_i_of_type_Int);
      break;
      label289:
      this.jdField_c_of_type_AndroidWidgetImageView = new ImageView(localActivity);
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(0, 2131296798);
      ((RelativeLayout.LayoutParams)localObject2).addRule(15);
      ((RelativeLayout.LayoutParams)localObject2).rightMargin = DisplayUtil.a(localActivity.getApplicationContext(), 10.0F);
      this.jdField_c_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      break label201;
      label357:
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(this.jdField_h_of_type_Int);
    }
    label371:
    QLog.e(jdField_a_of_type_JavaLangString, 1, "setDoubleRightButton, not support " + localActivity);
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    if (!TextUtils.isEmpty(this.C)) {
      if ((this.jdField_a_of_type_Boolean) && (paramInt == 0)) {
        callJs(this.C, new String[] { "2", Integer.toString(paramInt) });
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      callJs(this.C, new String[] { "0", Integer.toString(paramInt) });
      continue;
      callJs4OpenApiIfNeeded("showActionSheet", 0, Integer.toString(paramInt));
    }
  }
  
  void a()
  {
    Object localObject = this.mRuntime.a();
    Activity localActivity = this.mRuntime.a();
    if ((localObject == null) || (localActivity == null) || (localActivity.isFinishing())) {
      callJs4OpenApiIfNeeded("setPullDown", -100, "recode_failed_native_error");
    }
    do
    {
      return;
      localObject = (View)((WebView)localObject).getParent();
    } while (!(localObject instanceof RefreshView));
    this.jdField_a_of_type_ComTencentBizUiRefreshView = ((RefreshView)localObject);
    this.j = false;
    if (!this.jdField_g_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidViewView = localActivity.findViewById(2131299833);
      if (this.jdField_b_of_type_AndroidViewView != null) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      }
      this.jdField_g_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader = this.jdField_a_of_type_ComTencentBizUiRefreshView.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader;
      this.jdField_a_of_type_ComTencentBizUiRefreshView.setOnRefreshListener(new syi(this));
      callJs4OpenApiIfNeeded("setPullDown", 0, "[]");
      return;
    }
    callJs4OpenApiIfNeeded("setPullDown", 0, "already initPullDown");
  }
  
  protected final void a(String paramString1, String paramString2)
  {
    EntityManager localEntityManager = this.mRuntime.a().a(this.mRuntime.a().getAccount()).createEntityManager();
    TroopInfo localTroopInfo = (TroopInfo)localEntityManager.a(TroopInfo.class, paramString1);
    localEntityManager.a();
    int i1;
    if (localTroopInfo != null)
    {
      if (!localTroopInfo.isTroopOwner(this.mRuntime.a().getAccount())) {
        break label115;
      }
      i1 = 0;
    }
    for (;;)
    {
      ReportController.b(null, "P_CliOper", "Grp_flower", "", "mber", paramString2, 0, 0, paramString1, i1 + "", "", "");
      return;
      label115:
      if (localTroopInfo.isAdmin()) {
        i1 = 1;
      } else {
        i1 = 2;
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    Object localObject = this.mRuntime.a();
    if ((localObject == null) || (((Activity)localObject).isFinishing())) {}
    View localView;
    do
    {
      return;
      localView = ((Activity)localObject).findViewById(2131297082);
    } while (localView == null);
    if (ImmersiveUtils.isSupporImmersive() == 1) {}
    for (int i1 = ImmersiveUtils.a((Context)localObject) + 0;; i1 = 0)
    {
      localView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      i1 += localView.getMeasuredHeight();
      if ((!this.jdField_f_of_type_Boolean) && (paramBoolean))
      {
        localObject = new TranslateAnimation(0.0F, 0.0F, 0.0F, -i1);
        ((TranslateAnimation)localObject).setDuration(paramInt);
        ((TranslateAnimation)localObject).setInterpolator(new LinearInterpolator());
        ((TranslateAnimation)localObject).setFillAfter(true);
        localView.startAnimation((Animation)localObject);
        this.jdField_f_of_type_Boolean = true;
        return;
      }
      if ((!this.jdField_f_of_type_Boolean) || (paramBoolean)) {
        break;
      }
      localObject = new TranslateAnimation(0.0F, 0.0F, -i1, 0.0F);
      ((TranslateAnimation)localObject).setDuration(paramInt);
      ((TranslateAnimation)localObject).setInterpolator(new LinearInterpolator());
      ((TranslateAnimation)localObject).setFillAfter(true);
      localView.startAnimation((Animation)localObject);
      this.jdField_f_of_type_Boolean = false;
      return;
    }
  }
  
  void b()
  {
    if (this.jdField_g_of_type_Boolean)
    {
      if (this.jdField_b_of_type_AndroidViewView != null) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
      this.jdField_a_of_type_ComTencentBizUiRefreshView.setOnRefreshListener(null);
    }
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map paramMap)
  {
    if (paramLong == 8589934593L) {
      this.y = null;
    }
    for (;;)
    {
      return false;
      if (paramLong == 8589934597L)
      {
        this.jdField_b_of_type_Boolean = false;
        callJs("~function(d,e){try{e=d.createEvent('Event');e.initEvent('qbrowserVisibilityChange');e.hidden=true;d.dispatchEvent(e)}catch(err){}}(document);");
      }
      else if (paramLong == 2L)
      {
        this.jdField_b_of_type_Boolean = true;
        callJs("~function(d,e){try{e=d.createEvent('Event');e.initEvent('qbrowserVisibilityChange');e.hidden=false;d.dispatchEvent(e)}catch(err){}}(document);");
      }
      else if (paramLong == 16L)
      {
        this.y = null;
      }
      else if ((paramLong == 8589934601L) || (paramLong == 8589934602L))
      {
        if (!TextUtils.isEmpty(this.y))
        {
          callJs(this.y, new String[] { "" });
          return true;
        }
        if ((this.mOpenApiListeners != null) && (this.mOpenApiListeners.containsKey("setLeftButton")))
        {
          callJs4OpenApiIfNeeded("setLeftButton", 0, "");
          return true;
        }
        if (paramLong == 8589934601L)
        {
          WebUiUtils.WebTitleBarInterface localWebTitleBarInterface;
          if (this.jdField_g_of_type_Int == -1)
          {
            this.jdField_g_of_type_Int = 0;
            paramString = this.mRuntime.a();
            if ((paramString != null) && (a() != null))
            {
              Object localObject = paramString.getIntent();
              localWebTitleBarInterface = a();
              if ((localWebTitleBarInterface != null) && ((localWebTitleBarInterface.b() & 0x200000) == 0L) && (!((Intent)localObject).getBooleanExtra("show_right_close_button", false)))
              {
                localObject = (TextView)paramString.findViewById(2131297183);
                if ((localObject == null) || (((TextView)localObject).getVisibility() != 0) || (!paramString.getString(2131369134).equals(((TextView)localObject).getText()))) {
                  break label293;
                }
              }
            }
          }
          while (this.jdField_g_of_type_Int == 0)
          {
            return false;
            label293:
            if ((localWebTitleBarInterface.b() & 0x4) == 0L) {
              this.jdField_g_of_type_Int = 1;
            }
          }
          paramString = paramMap.get("target");
          if (!(paramString instanceof Integer)) {
            return false;
          }
          int i1 = ((Integer)paramString).intValue();
          if ((i1 != 1) && (i1 != 3)) {
            return false;
          }
          paramString = this.mRuntime.a();
          if (paramString != null)
          {
            i1 = paramString.copyBackForwardList().getCurrentIndex();
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "web history current index:" + i1);
            }
            if (i1 > 1) {
              a(true);
            } else {
              a(false);
            }
          }
        }
      }
    }
  }
  
  /* Error */
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    // Byte code:
    //   0: ldc 108
    //   2: aload_3
    //   3: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6: ifeq +9997 -> 10003
    //   9: aload_0
    //   10: aload 4
    //   12: aload_1
    //   13: invokevirtual 1567	com/tencent/mobileqq/jsp/UiApiPlugin:addOpenApiListenerIfNeeded	(Ljava/lang/String;Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;)V
    //   16: ldc_w 1569
    //   19: aload 4
    //   21: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   24: ifeq +216 -> 240
    //   27: aload 5
    //   29: arraylength
    //   30: ifle +210 -> 240
    //   33: new 199	org/json/JSONObject
    //   36: dup
    //   37: aload 5
    //   39: iconst_0
    //   40: aaload
    //   41: invokespecial 326	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   44: astore 5
    //   46: aload_0
    //   47: getfield 216	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   50: invokevirtual 221	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   53: astore 4
    //   55: aload 5
    //   57: ldc_w 1571
    //   60: invokevirtual 626	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   63: astore_1
    //   64: aload 5
    //   66: ldc_w 1573
    //   69: invokevirtual 626	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   72: astore_2
    //   73: aload 5
    //   75: ldc -2
    //   77: invokevirtual 626	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   80: astore_3
    //   81: aload 5
    //   83: ldc 38
    //   85: invokevirtual 626	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   88: astore 5
    //   90: aload 4
    //   92: ifnull +90 -> 182
    //   95: aload_1
    //   96: invokestatic 1578	com/tencent/mobileqq/data/Friends:isValidUin	(Ljava/lang/String;)Z
    //   99: ifeq +83 -> 182
    //   102: aload_2
    //   103: invokestatic 1578	com/tencent/mobileqq/data/Friends:isValidUin	(Ljava/lang/String;)Z
    //   106: ifeq +76 -> 182
    //   109: new 232	android/content/Intent
    //   112: dup
    //   113: aload 4
    //   115: ldc_w 1580
    //   118: invokespecial 544	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   121: astore 4
    //   123: aload 4
    //   125: ldc_w 1582
    //   128: aload_1
    //   129: invokevirtual 258	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   132: pop
    //   133: aload 4
    //   135: ldc_w 1573
    //   138: aload_2
    //   139: invokevirtual 258	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   142: pop
    //   143: ldc_w 1584
    //   146: aload_3
    //   147: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   150: ifeq +24 -> 174
    //   153: aload 4
    //   155: ldc_w 1586
    //   158: bipush 8
    //   160: invokevirtual 438	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   163: pop
    //   164: aload 4
    //   166: ldc 38
    //   168: aload 5
    //   170: invokevirtual 258	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   173: pop
    //   174: aload_0
    //   175: aload 4
    //   177: bipush 9
    //   179: invokevirtual 1050	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   182: iconst_1
    //   183: ireturn
    //   184: astore_1
    //   185: invokestatic 300	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   188: ifeq -6 -> 182
    //   191: new 584	java/lang/StringBuilder
    //   194: dup
    //   195: invokespecial 585	java/lang/StringBuilder:<init>	()V
    //   198: getstatic 145	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   201: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: ldc_w 1588
    //   207: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: invokevirtual 592	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: iconst_2
    //   214: new 584	java/lang/StringBuilder
    //   217: dup
    //   218: invokespecial 585	java/lang/StringBuilder:<init>	()V
    //   221: ldc_w 1590
    //   224: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: aload_1
    //   228: invokevirtual 1362	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   231: invokevirtual 592	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   234: invokestatic 305	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   237: goto -55 -> 182
    //   240: ldc_w 1592
    //   243: aload 4
    //   245: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   248: ifeq +181 -> 429
    //   251: aload 5
    //   253: arraylength
    //   254: ifle +175 -> 429
    //   257: new 199	org/json/JSONObject
    //   260: dup
    //   261: aload 5
    //   263: iconst_0
    //   264: aaload
    //   265: invokespecial 326	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   268: astore_2
    //   269: aload_2
    //   270: ldc_w 854
    //   273: invokevirtual 1596	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   276: lstore 13
    //   278: aload_2
    //   279: ldc_w 1598
    //   282: invokevirtual 202	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   285: istore 10
    //   287: aload_2
    //   288: ldc_w 1600
    //   291: invokevirtual 206	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   294: astore_1
    //   295: aload_2
    //   296: ldc 38
    //   298: invokevirtual 626	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   301: astore_2
    //   302: aload_0
    //   303: getfield 216	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   306: invokevirtual 221	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   309: new 584	java/lang/StringBuilder
    //   312: dup
    //   313: invokespecial 585	java/lang/StringBuilder:<init>	()V
    //   316: lload 13
    //   318: invokevirtual 1603	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   321: ldc_w 565
    //   324: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: invokevirtual 592	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   330: bipush 9
    //   332: invokestatic 1608	com/tencent/mobileqq/activity/TroopMemberListActivity:a	(Landroid/content/Context;Ljava/lang/String;I)Landroid/content/Intent;
    //   335: astore_3
    //   336: aload_3
    //   337: ldc_w 1610
    //   340: aload_1
    //   341: invokevirtual 258	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   344: pop
    //   345: aload_3
    //   346: ldc_w 1612
    //   349: iload 10
    //   351: invokevirtual 438	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   354: pop
    //   355: aload_3
    //   356: ldc 38
    //   358: aload_2
    //   359: invokevirtual 258	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   362: pop
    //   363: aload_0
    //   364: aload_3
    //   365: bipush 8
    //   367: invokevirtual 1050	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   370: goto -188 -> 182
    //   373: astore_1
    //   374: invokestatic 300	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   377: ifeq -195 -> 182
    //   380: new 584	java/lang/StringBuilder
    //   383: dup
    //   384: invokespecial 585	java/lang/StringBuilder:<init>	()V
    //   387: getstatic 145	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   390: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: ldc_w 1588
    //   396: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: invokevirtual 592	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   402: iconst_2
    //   403: new 584	java/lang/StringBuilder
    //   406: dup
    //   407: invokespecial 585	java/lang/StringBuilder:<init>	()V
    //   410: ldc_w 1614
    //   413: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: aload_1
    //   417: invokevirtual 1362	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   420: invokevirtual 592	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   423: invokestatic 305	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   426: goto -244 -> 182
    //   429: ldc_w 1616
    //   432: aload 4
    //   434: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   437: ifeq +199 -> 636
    //   440: aload 5
    //   442: arraylength
    //   443: ifle +193 -> 636
    //   446: aload_0
    //   447: getfield 216	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   450: invokevirtual 221	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   453: astore_1
    //   454: aload_1
    //   455: ifnonnull +5 -> 460
    //   458: iconst_1
    //   459: ireturn
    //   460: new 199	org/json/JSONObject
    //   463: dup
    //   464: aload 5
    //   466: iconst_0
    //   467: aaload
    //   468: invokespecial 326	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   471: astore_2
    //   472: aload_2
    //   473: ldc_w 1618
    //   476: invokevirtual 626	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   479: astore_3
    //   480: aload_2
    //   481: ldc_w 1619
    //   484: invokevirtual 715	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   487: tableswitch	default:+9587->10074, 0:+21->508, 1:+115->602
    //   508: aload_2
    //   509: ldc_w 1621
    //   512: iconst_1
    //   513: invokevirtual 640	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   516: istore 10
    //   518: aload_3
    //   519: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   522: ifne -340 -> 182
    //   525: iload 10
    //   527: iconst_2
    //   528: if_icmpne +68 -> 596
    //   531: iconst_1
    //   532: istore 10
    //   534: aload_1
    //   535: iload 10
    //   537: aload_3
    //   538: iconst_0
    //   539: invokestatic 1626	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;ILjava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   542: aload_1
    //   543: invokevirtual 923	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   546: ldc_w 1627
    //   549: invokevirtual 1206	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   552: invokevirtual 1630	com/tencent/mobileqq/widget/QQToast:b	(I)Landroid/widget/Toast;
    //   555: pop
    //   556: goto -374 -> 182
    //   559: astore_1
    //   560: invokestatic 300	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   563: ifeq -381 -> 182
    //   566: getstatic 145	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   569: iconst_2
    //   570: new 584	java/lang/StringBuilder
    //   573: dup
    //   574: invokespecial 585	java/lang/StringBuilder:<init>	()V
    //   577: ldc_w 1632
    //   580: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   583: aload_1
    //   584: invokevirtual 1362	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   587: invokevirtual 592	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   590: invokestatic 305	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   593: goto -411 -> 182
    //   596: iconst_2
    //   597: istore 10
    //   599: goto -65 -> 534
    //   602: aload_3
    //   603: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   606: ifne -424 -> 182
    //   609: aload_1
    //   610: iconst_0
    //   611: aload_3
    //   612: iconst_0
    //   613: invokestatic 1626	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;ILjava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   616: iconst_0
    //   617: invokevirtual 1634	com/tencent/mobileqq/widget/QQToast:a	(I)Landroid/widget/Toast;
    //   620: astore_1
    //   621: aload_1
    //   622: bipush 23
    //   624: iconst_0
    //   625: iconst_0
    //   626: invokevirtual 1639	android/widget/Toast:setGravity	(III)V
    //   629: aload_1
    //   630: invokevirtual 1640	android/widget/Toast:show	()V
    //   633: goto -451 -> 182
    //   636: ldc_w 1642
    //   639: aload 4
    //   641: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   644: ifeq +108 -> 752
    //   647: new 199	org/json/JSONObject
    //   650: dup
    //   651: aload 5
    //   653: iconst_0
    //   654: aaload
    //   655: invokespecial 326	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   658: ldc 75
    //   660: invokevirtual 626	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   663: astore_1
    //   664: aload_1
    //   665: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   668: ifeq +5 -> 673
    //   671: iconst_1
    //   672: ireturn
    //   673: aload_0
    //   674: getfield 216	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   677: invokevirtual 221	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   680: astore_2
    //   681: new 232	android/content/Intent
    //   684: dup
    //   685: aload_2
    //   686: ldc_w 1644
    //   689: invokespecial 544	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   692: aconst_null
    //   693: invokestatic 1649	com/tencent/mobileqq/activity/aio/AIOUtils:a	(Landroid/content/Intent;[I)Landroid/content/Intent;
    //   696: astore_3
    //   697: aload_3
    //   698: ldc 72
    //   700: aload_1
    //   701: invokevirtual 258	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   704: pop
    //   705: aload_3
    //   706: ldc_w 1651
    //   709: iconst_1
    //   710: invokevirtual 438	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   713: pop
    //   714: aload_3
    //   715: ldc_w 1653
    //   718: iconst_1
    //   719: invokevirtual 1007	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   722: pop
    //   723: aload_2
    //   724: aload_3
    //   725: invokevirtual 1094	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   728: goto -546 -> 182
    //   731: astore_1
    //   732: invokestatic 300	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   735: ifeq -553 -> 182
    //   738: getstatic 145	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   741: iconst_2
    //   742: ldc_w 1655
    //   745: aload_1
    //   746: invokestatic 334	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   749: goto -567 -> 182
    //   752: ldc_w 1657
    //   755: aload 4
    //   757: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   760: ifeq +218 -> 978
    //   763: new 199	org/json/JSONObject
    //   766: dup
    //   767: aload 5
    //   769: iconst_0
    //   770: aaload
    //   771: invokespecial 326	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   774: astore_3
    //   775: aload_3
    //   776: ldc 75
    //   778: invokevirtual 626	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   781: astore 4
    //   783: aload 4
    //   785: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   788: ifeq +5 -> 793
    //   791: iconst_1
    //   792: ireturn
    //   793: aload_3
    //   794: ldc 90
    //   796: ldc_w 1659
    //   799: invokevirtual 1662	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   802: astore 5
    //   804: aload_3
    //   805: ldc 93
    //   807: ldc_w 1664
    //   810: invokevirtual 1662	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   813: astore 6
    //   815: aload_0
    //   816: getfield 216	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   819: invokevirtual 221	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   822: astore_1
    //   823: new 232	android/content/Intent
    //   826: dup
    //   827: aload_1
    //   828: ldc_w 1644
    //   831: invokespecial 544	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   834: aconst_null
    //   835: invokestatic 1649	com/tencent/mobileqq/activity/aio/AIOUtils:a	(Landroid/content/Intent;[I)Landroid/content/Intent;
    //   838: astore_2
    //   839: aload_2
    //   840: ldc 72
    //   842: aload 4
    //   844: invokevirtual 258	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   847: pop
    //   848: aload_2
    //   849: ldc_w 1651
    //   852: iconst_1
    //   853: invokevirtual 438	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   856: pop
    //   857: aload_2
    //   858: ldc 90
    //   860: aload 5
    //   862: invokevirtual 258	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   865: pop
    //   866: aload_2
    //   867: ldc 93
    //   869: aload 6
    //   871: invokevirtual 258	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   874: pop
    //   875: aload_3
    //   876: ldc_w 1619
    //   879: iconst_0
    //   880: invokevirtual 640	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   883: istore 10
    //   885: iload 10
    //   887: iconst_1
    //   888: if_icmpne +64 -> 952
    //   891: aload_3
    //   892: ldc_w 1666
    //   895: invokevirtual 635	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   898: astore_3
    //   899: aload_3
    //   900: ifnull +14 -> 914
    //   903: aload_2
    //   904: ldc 96
    //   906: aload_3
    //   907: invokevirtual 1667	org/json/JSONArray:toString	()Ljava/lang/String;
    //   910: invokevirtual 258	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   913: pop
    //   914: aload_2
    //   915: ldc 87
    //   917: iload 10
    //   919: invokevirtual 438	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   922: pop
    //   923: aload_1
    //   924: aload_2
    //   925: invokevirtual 1094	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   928: goto -746 -> 182
    //   931: astore_1
    //   932: invokestatic 300	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   935: ifeq -753 -> 182
    //   938: getstatic 145	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   941: iconst_2
    //   942: ldc_w 1669
    //   945: aload_1
    //   946: invokestatic 334	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   949: goto -767 -> 182
    //   952: iload 10
    //   954: iconst_2
    //   955: if_icmpne -41 -> 914
    //   958: aload_2
    //   959: ldc 99
    //   961: aload_3
    //   962: ldc_w 1666
    //   965: ldc_w 1671
    //   968: invokevirtual 1662	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   971: invokevirtual 258	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   974: pop
    //   975: goto -61 -> 914
    //   978: ldc_w 1673
    //   981: aload 4
    //   983: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   986: ifeq +50 -> 1036
    //   989: new 199	org/json/JSONObject
    //   992: dup
    //   993: aload 5
    //   995: iconst_0
    //   996: aaload
    //   997: invokespecial 326	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1000: ldc_w 1618
    //   1003: invokevirtual 626	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1006: astore_1
    //   1007: aload_1
    //   1008: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1011: ifne -829 -> 182
    //   1014: aload_0
    //   1015: aload_0
    //   1016: getfield 216	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1019: invokevirtual 221	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1022: aload_1
    //   1023: invokestatic 1678	com/tencent/mobileqq/maproam/Utils:a	(Landroid/content/Context;Ljava/lang/String;)Landroid/app/ProgressDialog;
    //   1026: putfield 1680	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   1029: goto -847 -> 182
    //   1032: astore_1
    //   1033: goto -851 -> 182
    //   1036: ldc_w 1682
    //   1039: aload 4
    //   1041: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1044: ifeq +52 -> 1096
    //   1047: aload_0
    //   1048: getfield 1680	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   1051: ifnull -869 -> 182
    //   1054: aload_0
    //   1055: getfield 1680	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   1058: invokevirtual 1685	android/app/ProgressDialog:isShowing	()Z
    //   1061: ifeq -879 -> 182
    //   1064: aload_0
    //   1065: getfield 1680	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   1068: invokevirtual 1686	android/app/ProgressDialog:dismiss	()V
    //   1071: aload_0
    //   1072: aconst_null
    //   1073: putfield 1680	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   1076: goto -894 -> 182
    //   1079: astore_1
    //   1080: aload_0
    //   1081: aconst_null
    //   1082: putfield 1680	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   1085: goto -903 -> 182
    //   1088: astore_1
    //   1089: aload_0
    //   1090: aconst_null
    //   1091: putfield 1680	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   1094: aload_1
    //   1095: athrow
    //   1096: ldc_w 1688
    //   1099: aload 4
    //   1101: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1104: ifeq +41 -> 1145
    //   1107: aload 5
    //   1109: arraylength
    //   1110: iconst_1
    //   1111: if_icmpne -929 -> 182
    //   1114: aload_1
    //   1115: getfield 1691	com/tencent/mobileqq/webview/swift/JsBridgeListener:jdField_a_of_type_Boolean	Z
    //   1118: ifeq +15 -> 1133
    //   1121: aload_0
    //   1122: aload 5
    //   1124: iconst_0
    //   1125: aaload
    //   1126: iconst_1
    //   1127: invokespecial 1693	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Ljava/lang/String;Z)V
    //   1130: goto -948 -> 182
    //   1133: aload_0
    //   1134: aload 5
    //   1136: iconst_0
    //   1137: aaload
    //   1138: iconst_0
    //   1139: invokespecial 1693	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Ljava/lang/String;Z)V
    //   1142: goto -960 -> 182
    //   1145: ldc_w 1695
    //   1148: aload 4
    //   1150: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1153: ifeq +17 -> 1170
    //   1156: aload_1
    //   1157: aload_0
    //   1158: getfield 1491	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_b_of_type_Boolean	Z
    //   1161: invokestatic 727	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1164: invokevirtual 1698	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   1167: goto -985 -> 182
    //   1170: ldc_w 1700
    //   1173: aload 4
    //   1175: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1178: ifeq +51 -> 1229
    //   1181: aload 5
    //   1183: arraylength
    //   1184: iconst_1
    //   1185: if_icmpne +44 -> 1229
    //   1188: aload_0
    //   1189: new 199	org/json/JSONObject
    //   1192: dup
    //   1193: aload 5
    //   1195: iconst_0
    //   1196: aaload
    //   1197: invokespecial 326	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1200: aload_1
    //   1201: aconst_null
    //   1202: invokespecial 862	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;Landroid/view/View$OnClickListener;)V
    //   1205: goto -1023 -> 182
    //   1208: astore_1
    //   1209: invokestatic 300	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1212: ifeq -1030 -> 182
    //   1215: getstatic 145	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1218: iconst_2
    //   1219: ldc_w 1702
    //   1222: aload_1
    //   1223: invokestatic 334	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1226: goto -1044 -> 182
    //   1229: ldc_w 1704
    //   1232: aload 4
    //   1234: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1237: ifeq +91 -> 1328
    //   1240: aload 5
    //   1242: arraylength
    //   1243: iconst_1
    //   1244: if_icmpne +84 -> 1328
    //   1247: aload_0
    //   1248: getfield 216	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1251: invokevirtual 221	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1254: astore_2
    //   1255: aload_2
    //   1256: ifnull +8821 -> 10077
    //   1259: aload_2
    //   1260: invokevirtual 346	android/app/Activity:isFinishing	()Z
    //   1263: ifeq +6 -> 1269
    //   1266: goto +8811 -> 10077
    //   1269: new 199	org/json/JSONObject
    //   1272: dup
    //   1273: aload 5
    //   1275: iconst_0
    //   1276: aaload
    //   1277: invokespecial 326	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1280: astore_2
    //   1281: aload_0
    //   1282: aload_2
    //   1283: ldc_w 1706
    //   1286: invokevirtual 784	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1289: invokespecial 1708	com/tencent/mobileqq/jsp/UiApiPlugin:c	(Lorg/json/JSONObject;)V
    //   1292: aload_0
    //   1293: aload_2
    //   1294: ldc_w 1710
    //   1297: invokevirtual 784	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1300: aload_1
    //   1301: invokespecial 1712	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;)V
    //   1304: goto -1122 -> 182
    //   1307: astore_1
    //   1308: invokestatic 300	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1311: ifeq -1129 -> 182
    //   1314: getstatic 145	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1317: iconst_2
    //   1318: ldc_w 1714
    //   1321: aload_1
    //   1322: invokestatic 334	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1325: goto -1143 -> 182
    //   1328: ldc_w 1715
    //   1331: aload 4
    //   1333: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1336: ifeq +72 -> 1408
    //   1339: aload 5
    //   1341: arraylength
    //   1342: iconst_1
    //   1343: if_icmpne +65 -> 1408
    //   1346: aload_0
    //   1347: getfield 216	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1350: invokevirtual 221	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1353: astore_2
    //   1354: aload_2
    //   1355: ifnull +8724 -> 10079
    //   1358: aload_2
    //   1359: invokevirtual 346	android/app/Activity:isFinishing	()Z
    //   1362: ifeq +6 -> 1368
    //   1365: goto +8714 -> 10079
    //   1368: aload_0
    //   1369: new 199	org/json/JSONObject
    //   1372: dup
    //   1373: aload 5
    //   1375: iconst_0
    //   1376: aaload
    //   1377: invokespecial 326	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1380: aload_1
    //   1381: invokespecial 1712	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;)V
    //   1384: goto -1202 -> 182
    //   1387: astore_1
    //   1388: invokestatic 300	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1391: ifeq -1209 -> 182
    //   1394: getstatic 145	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1397: iconst_2
    //   1398: ldc_w 1717
    //   1401: aload_1
    //   1402: invokestatic 334	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1405: goto -1223 -> 182
    //   1408: ldc_w 1719
    //   1411: aload 4
    //   1413: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1416: ifeq +109 -> 1525
    //   1419: aload 5
    //   1421: arraylength
    //   1422: iconst_1
    //   1423: if_icmpne +102 -> 1525
    //   1426: aload_0
    //   1427: getfield 216	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1430: invokevirtual 221	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1433: astore_1
    //   1434: aload_1
    //   1435: ifnull +8646 -> 10081
    //   1438: aload_1
    //   1439: invokevirtual 346	android/app/Activity:isFinishing	()Z
    //   1442: ifeq +6 -> 1448
    //   1445: goto +8636 -> 10081
    //   1448: new 199	org/json/JSONObject
    //   1451: dup
    //   1452: aload 5
    //   1454: iconst_0
    //   1455: aaload
    //   1456: invokespecial 326	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1459: astore_1
    //   1460: aload_1
    //   1461: ldc_w 1721
    //   1464: invokevirtual 715	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1467: istore 10
    //   1469: aload_1
    //   1470: ldc_w 1723
    //   1473: invokevirtual 843	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   1476: istore 15
    //   1478: aload_1
    //   1479: ldc 38
    //   1481: invokevirtual 626	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1484: astore_2
    //   1485: aload_0
    //   1486: iload 10
    //   1488: iload 15
    //   1490: aload_1
    //   1491: ldc_w 1725
    //   1494: invokevirtual 843	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   1497: aload_2
    //   1498: invokespecial 1727	com/tencent/mobileqq/jsp/UiApiPlugin:a	(IZZLjava/lang/String;)V
    //   1501: goto -1319 -> 182
    //   1504: astore_1
    //   1505: invokestatic 300	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1508: ifeq -1326 -> 182
    //   1511: getstatic 145	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1514: iconst_2
    //   1515: ldc_w 1717
    //   1518: aload_1
    //   1519: invokestatic 334	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1522: goto -1340 -> 182
    //   1525: ldc_w 1511
    //   1528: aload 4
    //   1530: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1533: ifeq +71 -> 1604
    //   1536: aload 5
    //   1538: arraylength
    //   1539: iconst_1
    //   1540: if_icmpne +64 -> 1604
    //   1543: aload_0
    //   1544: getfield 216	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1547: invokevirtual 221	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1550: astore_1
    //   1551: aload_1
    //   1552: ifnull +8531 -> 10083
    //   1555: aload_1
    //   1556: invokevirtual 346	android/app/Activity:isFinishing	()Z
    //   1559: ifeq +6 -> 1565
    //   1562: goto +8521 -> 10083
    //   1565: aload_0
    //   1566: new 199	org/json/JSONObject
    //   1569: dup
    //   1570: aload 5
    //   1572: iconst_0
    //   1573: aaload
    //   1574: invokespecial 326	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1577: invokespecial 1708	com/tencent/mobileqq/jsp/UiApiPlugin:c	(Lorg/json/JSONObject;)V
    //   1580: goto -1398 -> 182
    //   1583: astore_1
    //   1584: invokestatic 300	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1587: ifeq -1405 -> 182
    //   1590: getstatic 145	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1593: iconst_2
    //   1594: ldc_w 1729
    //   1597: aload_1
    //   1598: invokestatic 334	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1601: goto -1419 -> 182
    //   1604: ldc_w 1731
    //   1607: aload 4
    //   1609: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1612: ifeq +84 -> 1696
    //   1615: aload 5
    //   1617: arraylength
    //   1618: iconst_1
    //   1619: if_icmpne +77 -> 1696
    //   1622: aload_0
    //   1623: getfield 216	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1626: invokevirtual 221	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1629: astore_1
    //   1630: aload_1
    //   1631: ifnull +8454 -> 10085
    //   1634: aload_1
    //   1635: invokevirtual 346	android/app/Activity:isFinishing	()Z
    //   1638: ifeq +6 -> 1644
    //   1641: goto +8444 -> 10085
    //   1644: aload_0
    //   1645: new 199	org/json/JSONObject
    //   1648: dup
    //   1649: aload 5
    //   1651: iconst_0
    //   1652: aaload
    //   1653: invokespecial 326	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1656: invokespecial 1733	com/tencent/mobileqq/jsp/UiApiPlugin:d	(Lorg/json/JSONObject;)V
    //   1659: goto -1477 -> 182
    //   1662: astore_1
    //   1663: getstatic 145	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1666: iconst_1
    //   1667: new 584	java/lang/StringBuilder
    //   1670: dup
    //   1671: invokespecial 585	java/lang/StringBuilder:<init>	()V
    //   1674: ldc_w 1735
    //   1677: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1680: aload_1
    //   1681: invokestatic 1738	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1684: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1687: invokevirtual 592	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1690: invokestatic 578	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1693: goto -1511 -> 182
    //   1696: ldc_w 1372
    //   1699: aload 4
    //   1701: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1704: ifeq +21 -> 1725
    //   1707: aload 5
    //   1709: arraylength
    //   1710: iconst_1
    //   1711: if_icmpne +14 -> 1725
    //   1714: aload_0
    //   1715: aload 5
    //   1717: iconst_0
    //   1718: aaload
    //   1719: invokespecial 1739	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Ljava/lang/String;)V
    //   1722: goto -1540 -> 182
    //   1725: ldc_w 1741
    //   1728: aload 4
    //   1730: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1733: ifeq +170 -> 1903
    //   1736: aload 5
    //   1738: arraylength
    //   1739: iconst_1
    //   1740: if_icmpne +163 -> 1903
    //   1743: new 199	org/json/JSONObject
    //   1746: dup
    //   1747: aload 5
    //   1749: iconst_0
    //   1750: aaload
    //   1751: invokespecial 326	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1754: astore_2
    //   1755: aload_2
    //   1756: ldc 33
    //   1758: invokevirtual 626	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1761: astore_1
    //   1762: aload_0
    //   1763: aload_2
    //   1764: ldc 38
    //   1766: invokevirtual 626	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1769: putfield 1743	com/tencent/mobileqq/jsp/UiApiPlugin:D	Ljava/lang/String;
    //   1772: aload_0
    //   1773: getfield 216	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1776: invokevirtual 688	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   1779: ifnonnull +5 -> 1784
    //   1782: iconst_1
    //   1783: ireturn
    //   1784: aload_0
    //   1785: getfield 216	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1788: invokevirtual 688	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   1791: invokevirtual 1748	com/tencent/biz/pubaccount/CustomWebView:getUrl	()Ljava/lang/String;
    //   1794: astore_2
    //   1795: new 232	android/content/Intent
    //   1798: dup
    //   1799: aload_0
    //   1800: getfield 216	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1803: invokevirtual 221	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1806: ldc_w 1750
    //   1809: invokespecial 544	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   1812: ldc -2
    //   1814: ldc_w 1042
    //   1817: invokevirtual 258	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1820: astore_3
    //   1821: aload_1
    //   1822: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1825: ifeq +48 -> 1873
    //   1828: aload_0
    //   1829: getfield 1743	com/tencent/mobileqq/jsp/UiApiPlugin:D	Ljava/lang/String;
    //   1832: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1835: ifeq +38 -> 1873
    //   1838: aload_3
    //   1839: ldc_w 1752
    //   1842: iconst_1
    //   1843: invokevirtual 1007	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1846: pop
    //   1847: aload_0
    //   1848: getfield 216	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1851: invokevirtual 221	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1854: ifnonnull +5 -> 1859
    //   1857: iconst_1
    //   1858: ireturn
    //   1859: aload_0
    //   1860: getfield 216	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1863: invokevirtual 221	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1866: aload_3
    //   1867: invokevirtual 1094	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   1870: goto -1688 -> 182
    //   1873: aload_3
    //   1874: ldc 33
    //   1876: aload_1
    //   1877: invokevirtual 258	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1880: ldc 50
    //   1882: aload_2
    //   1883: invokevirtual 258	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1886: ldc_w 1754
    //   1889: iconst_1
    //   1890: invokevirtual 1007	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1893: pop
    //   1894: aload_0
    //   1895: aload_3
    //   1896: iconst_3
    //   1897: invokevirtual 1050	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   1900: goto -1718 -> 182
    //   1903: ldc_w 1756
    //   1906: aload 4
    //   1908: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1911: ifeq +41 -> 1952
    //   1914: aload 5
    //   1916: arraylength
    //   1917: iconst_1
    //   1918: if_icmpne +34 -> 1952
    //   1921: aload_0
    //   1922: new 199	org/json/JSONObject
    //   1925: dup
    //   1926: aload 5
    //   1928: iconst_0
    //   1929: aaload
    //   1930: invokespecial 326	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1933: ldc 38
    //   1935: invokevirtual 626	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1938: putfield 1288	com/tencent/mobileqq/jsp/UiApiPlugin:y	Ljava/lang/String;
    //   1941: goto -1759 -> 182
    //   1944: astore_1
    //   1945: aload_1
    //   1946: invokevirtual 1759	org/json/JSONException:printStackTrace	()V
    //   1949: goto -1767 -> 182
    //   1952: ldc_w 1761
    //   1955: aload 4
    //   1957: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1960: ifeq +77 -> 2037
    //   1963: aload 5
    //   1965: arraylength
    //   1966: iconst_1
    //   1967: if_icmpne +70 -> 2037
    //   1970: new 199	org/json/JSONObject
    //   1973: dup
    //   1974: aload 5
    //   1976: iconst_0
    //   1977: aaload
    //   1978: invokespecial 326	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1981: ldc 38
    //   1983: invokevirtual 626	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1986: astore_1
    //   1987: aload_0
    //   1988: getfield 216	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1991: aload_0
    //   1992: getfield 216	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1995: invokevirtual 221	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1998: invokevirtual 265	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	(Landroid/app/Activity;)Lcom/tencent/mobileqq/webview/swift/WebUiBaseInterface;
    //   2001: astore_2
    //   2002: aload_2
    //   2003: ifnull -1821 -> 182
    //   2006: aload_2
    //   2007: instanceof 1120
    //   2010: ifeq -1828 -> 182
    //   2013: aload_2
    //   2014: checkcast 1120	com/tencent/mobileqq/webviewplugin/WebUiUtils$WebShareInterface
    //   2017: invokeinterface 1124 1 0
    //   2022: aload_1
    //   2023: invokevirtual 1762	com/tencent/biz/webviewplugin/Share:a	(Ljava/lang/String;)V
    //   2026: goto -1844 -> 182
    //   2029: astore_1
    //   2030: aload_1
    //   2031: invokevirtual 1759	org/json/JSONException:printStackTrace	()V
    //   2034: goto -1852 -> 182
    //   2037: ldc_w 1764
    //   2040: aload 4
    //   2042: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2045: ifeq +110 -> 2155
    //   2048: aload 5
    //   2050: arraylength
    //   2051: iconst_1
    //   2052: if_icmpne +103 -> 2155
    //   2055: new 199	org/json/JSONObject
    //   2058: dup
    //   2059: aload 5
    //   2061: iconst_0
    //   2062: aaload
    //   2063: invokespecial 326	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2066: ldc 38
    //   2068: invokevirtual 626	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2071: astore_1
    //   2072: aload_0
    //   2073: getfield 216	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2076: aload_0
    //   2077: getfield 216	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2080: invokevirtual 221	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   2083: invokevirtual 265	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	(Landroid/app/Activity;)Lcom/tencent/mobileqq/webview/swift/WebUiBaseInterface;
    //   2086: astore_2
    //   2087: aload_2
    //   2088: ifnull +23 -> 2111
    //   2091: aload_2
    //   2092: instanceof 1120
    //   2095: ifeq +16 -> 2111
    //   2098: aload_2
    //   2099: checkcast 1120	com/tencent/mobileqq/webviewplugin/WebUiUtils$WebShareInterface
    //   2102: invokeinterface 1124 1 0
    //   2107: aload_1
    //   2108: putfield 1766	com/tencent/biz/webviewplugin/Share:q	Ljava/lang/String;
    //   2111: aconst_null
    //   2112: ldc_w 1430
    //   2115: ldc_w 1768
    //   2118: ldc_w 565
    //   2121: ldc_w 1770
    //   2124: ldc_w 1770
    //   2127: iconst_0
    //   2128: iconst_0
    //   2129: ldc_w 565
    //   2132: ldc_w 565
    //   2135: ldc_w 565
    //   2138: ldc_w 565
    //   2141: invokestatic 574	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2144: goto -1962 -> 182
    //   2147: astore_1
    //   2148: aload_1
    //   2149: invokevirtual 1759	org/json/JSONException:printStackTrace	()V
    //   2152: goto -41 -> 2111
    //   2155: ldc_w 1772
    //   2158: aload 4
    //   2160: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2163: ifeq +110 -> 2273
    //   2166: aload 5
    //   2168: arraylength
    //   2169: iconst_1
    //   2170: if_icmpne +103 -> 2273
    //   2173: new 199	org/json/JSONObject
    //   2176: dup
    //   2177: aload 5
    //   2179: iconst_0
    //   2180: aaload
    //   2181: invokespecial 326	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2184: ldc 38
    //   2186: invokevirtual 626	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2189: astore_1
    //   2190: aload_0
    //   2191: getfield 216	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2194: aload_0
    //   2195: getfield 216	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2198: invokevirtual 221	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   2201: invokevirtual 265	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	(Landroid/app/Activity;)Lcom/tencent/mobileqq/webview/swift/WebUiBaseInterface;
    //   2204: astore_2
    //   2205: aload_2
    //   2206: ifnull +23 -> 2229
    //   2209: aload_2
    //   2210: instanceof 1120
    //   2213: ifeq +16 -> 2229
    //   2216: aload_2
    //   2217: checkcast 1120	com/tencent/mobileqq/webviewplugin/WebUiUtils$WebShareInterface
    //   2220: invokeinterface 1124 1 0
    //   2225: aload_1
    //   2226: putfield 1774	com/tencent/biz/webviewplugin/Share:r	Ljava/lang/String;
    //   2229: aconst_null
    //   2230: ldc_w 1430
    //   2233: ldc_w 1768
    //   2236: ldc_w 565
    //   2239: ldc_w 1776
    //   2242: ldc_w 1776
    //   2245: iconst_0
    //   2246: iconst_0
    //   2247: ldc_w 565
    //   2250: ldc_w 565
    //   2253: ldc_w 565
    //   2256: ldc_w 565
    //   2259: invokestatic 574	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2262: goto -2080 -> 182
    //   2265: astore_1
    //   2266: aload_1
    //   2267: invokevirtual 1759	org/json/JSONException:printStackTrace	()V
    //   2270: goto -41 -> 2229
    //   2273: ldc_w 1778
    //   2276: aload 4
    //   2278: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2281: ifeq +110 -> 2391
    //   2284: aload 5
    //   2286: arraylength
    //   2287: iconst_1
    //   2288: if_icmpne +103 -> 2391
    //   2291: new 199	org/json/JSONObject
    //   2294: dup
    //   2295: aload 5
    //   2297: iconst_0
    //   2298: aaload
    //   2299: invokespecial 326	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2302: ldc 38
    //   2304: invokevirtual 626	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2307: astore_1
    //   2308: aload_0
    //   2309: getfield 216	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2312: aload_0
    //   2313: getfield 216	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2316: invokevirtual 221	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   2319: invokevirtual 265	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	(Landroid/app/Activity;)Lcom/tencent/mobileqq/webview/swift/WebUiBaseInterface;
    //   2322: astore_2
    //   2323: aload_2
    //   2324: ifnull +23 -> 2347
    //   2327: aload_2
    //   2328: instanceof 1120
    //   2331: ifeq +16 -> 2347
    //   2334: aload_2
    //   2335: checkcast 1120	com/tencent/mobileqq/webviewplugin/WebUiUtils$WebShareInterface
    //   2338: invokeinterface 1124 1 0
    //   2343: aload_1
    //   2344: putfield 1780	com/tencent/biz/webviewplugin/Share:s	Ljava/lang/String;
    //   2347: aconst_null
    //   2348: ldc_w 1430
    //   2351: ldc_w 1768
    //   2354: ldc_w 565
    //   2357: ldc_w 1782
    //   2360: ldc_w 1782
    //   2363: iconst_0
    //   2364: iconst_0
    //   2365: ldc_w 565
    //   2368: ldc_w 565
    //   2371: ldc_w 565
    //   2374: ldc_w 565
    //   2377: invokestatic 574	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2380: goto -2198 -> 182
    //   2383: astore_1
    //   2384: aload_1
    //   2385: invokevirtual 1759	org/json/JSONException:printStackTrace	()V
    //   2388: goto -41 -> 2347
    //   2391: ldc_w 1784
    //   2394: aload 4
    //   2396: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2399: ifeq +110 -> 2509
    //   2402: aload 5
    //   2404: arraylength
    //   2405: iconst_1
    //   2406: if_icmpne +103 -> 2509
    //   2409: new 199	org/json/JSONObject
    //   2412: dup
    //   2413: aload 5
    //   2415: iconst_0
    //   2416: aaload
    //   2417: invokespecial 326	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2420: ldc 38
    //   2422: invokevirtual 626	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2425: astore_1
    //   2426: aload_0
    //   2427: getfield 216	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2430: aload_0
    //   2431: getfield 216	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2434: invokevirtual 221	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   2437: invokevirtual 265	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	(Landroid/app/Activity;)Lcom/tencent/mobileqq/webview/swift/WebUiBaseInterface;
    //   2440: astore_2
    //   2441: aload_2
    //   2442: ifnull +23 -> 2465
    //   2445: aload_2
    //   2446: instanceof 1120
    //   2449: ifeq +16 -> 2465
    //   2452: aload_2
    //   2453: checkcast 1120	com/tencent/mobileqq/webviewplugin/WebUiUtils$WebShareInterface
    //   2456: invokeinterface 1124 1 0
    //   2461: aload_1
    //   2462: putfield 1786	com/tencent/biz/webviewplugin/Share:t	Ljava/lang/String;
    //   2465: aconst_null
    //   2466: ldc_w 1430
    //   2469: ldc_w 1768
    //   2472: ldc_w 565
    //   2475: ldc_w 1788
    //   2478: ldc_w 1788
    //   2481: iconst_0
    //   2482: iconst_0
    //   2483: ldc_w 565
    //   2486: ldc_w 565
    //   2489: ldc_w 565
    //   2492: ldc_w 565
    //   2495: invokestatic 574	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2498: goto -2316 -> 182
    //   2501: astore_1
    //   2502: aload_1
    //   2503: invokevirtual 1759	org/json/JSONException:printStackTrace	()V
    //   2506: goto -41 -> 2465
    //   2509: ldc_w 1790
    //   2512: aload 4
    //   2514: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2517: ifeq +258 -> 2775
    //   2520: aload 5
    //   2522: arraylength
    //   2523: iconst_1
    //   2524: if_icmpne +251 -> 2775
    //   2527: new 199	org/json/JSONObject
    //   2530: dup
    //   2531: aload 5
    //   2533: iconst_0
    //   2534: aaload
    //   2535: invokespecial 326	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2538: astore 5
    //   2540: aload_0
    //   2541: getfield 216	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2544: invokevirtual 221	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   2547: astore 4
    //   2549: aload 4
    //   2551: ifnull +7540 -> 10091
    //   2554: aload 4
    //   2556: invokevirtual 346	android/app/Activity:isFinishing	()Z
    //   2559: ifeq +6 -> 2565
    //   2562: goto +7529 -> 10091
    //   2565: aload 5
    //   2567: ldc_w 623
    //   2570: invokevirtual 626	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2573: astore_1
    //   2574: aload 5
    //   2576: ldc_w 1618
    //   2579: invokevirtual 626	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2582: astore 7
    //   2584: aload 5
    //   2586: ldc_w 1792
    //   2589: iconst_1
    //   2590: invokevirtual 721	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   2593: istore 15
    //   2595: aload 5
    //   2597: ldc_w 1794
    //   2600: iconst_1
    //   2601: invokevirtual 721	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   2604: istore 16
    //   2606: aload 5
    //   2608: ldc_w 1796
    //   2611: invokevirtual 626	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2614: astore_2
    //   2615: aload 5
    //   2617: ldc_w 1798
    //   2620: invokevirtual 626	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2623: astore_3
    //   2624: aload 5
    //   2626: ldc 38
    //   2628: invokevirtual 626	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2631: astore 5
    //   2633: aload 4
    //   2635: iconst_0
    //   2636: invokestatic 1803	com/tencent/mobileqq/utils/DialogUtil:a	(Landroid/content/Context;I)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   2639: astore 6
    //   2641: aload 6
    //   2643: aload_1
    //   2644: invokevirtual 1809	com/tencent/mobileqq/utils/QQCustomDialog:setTitle	(Ljava/lang/String;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   2647: pop
    //   2648: aload 6
    //   2650: aload 7
    //   2652: invokevirtual 1813	com/tencent/mobileqq/utils/QQCustomDialog:setMessage	(Ljava/lang/CharSequence;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   2655: pop
    //   2656: new 1815	syp
    //   2659: dup
    //   2660: aload_0
    //   2661: aload 5
    //   2663: invokespecial 1816	syp:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Ljava/lang/String;)V
    //   2666: astore 7
    //   2668: iload 16
    //   2670: ifeq +30 -> 2700
    //   2673: aload_3
    //   2674: astore_1
    //   2675: aload_3
    //   2676: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2679: ifeq +12 -> 2691
    //   2682: aload 4
    //   2684: ldc_w 1817
    //   2687: invokevirtual 1533	android/app/Activity:getString	(I)Ljava/lang/String;
    //   2690: astore_1
    //   2691: aload 6
    //   2693: aload_1
    //   2694: aload 7
    //   2696: invokevirtual 1821	com/tencent/mobileqq/utils/QQCustomDialog:setNegativeButton	(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   2699: pop
    //   2700: iload 15
    //   2702: ifeq +30 -> 2732
    //   2705: aload_2
    //   2706: astore_1
    //   2707: aload_2
    //   2708: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2711: ifeq +12 -> 2723
    //   2714: aload 4
    //   2716: ldc_w 1822
    //   2719: invokevirtual 1533	android/app/Activity:getString	(I)Ljava/lang/String;
    //   2722: astore_1
    //   2723: aload 6
    //   2725: aload_1
    //   2726: aload 7
    //   2728: invokevirtual 1825	com/tencent/mobileqq/utils/QQCustomDialog:setPositiveButton	(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   2731: pop
    //   2732: aload 5
    //   2734: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2737: ifne +18 -> 2755
    //   2740: aload 6
    //   2742: new 1827	syq
    //   2745: dup
    //   2746: aload_0
    //   2747: aload 5
    //   2749: invokespecial 1828	syq:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Ljava/lang/String;)V
    //   2752: invokevirtual 1829	com/tencent/mobileqq/utils/QQCustomDialog:setOnCancelListener	(Landroid/content/DialogInterface$OnCancelListener;)V
    //   2755: aload 6
    //   2757: invokevirtual 1830	com/tencent/mobileqq/utils/QQCustomDialog:show	()V
    //   2760: goto -2578 -> 182
    //   2763: astore_1
    //   2764: goto -2582 -> 182
    //   2767: astore_1
    //   2768: aload_1
    //   2769: invokevirtual 1759	org/json/JSONException:printStackTrace	()V
    //   2772: goto -2590 -> 182
    //   2775: ldc_w 1832
    //   2778: aload 4
    //   2780: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2783: ifeq +389 -> 3172
    //   2786: aload 5
    //   2788: arraylength
    //   2789: iconst_1
    //   2790: if_icmpne +382 -> 3172
    //   2793: new 199	org/json/JSONObject
    //   2796: dup
    //   2797: aload 5
    //   2799: iconst_0
    //   2800: aaload
    //   2801: invokespecial 326	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2804: astore_2
    //   2805: aload_2
    //   2806: ldc_w 1834
    //   2809: invokevirtual 626	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2812: astore_3
    //   2813: aload_2
    //   2814: ldc_w 1836
    //   2817: invokevirtual 784	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   2820: astore_2
    //   2821: ldc_w 1838
    //   2824: aload_3
    //   2825: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2828: ifeq +96 -> 2924
    //   2831: aload_2
    //   2832: ldc_w 1571
    //   2835: invokevirtual 626	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2838: astore_2
    //   2839: aload_2
    //   2840: invokestatic 1578	com/tencent/mobileqq/data/Friends:isValidUin	(Ljava/lang/String;)Z
    //   2843: ifeq +56 -> 2899
    //   2846: new 232	android/content/Intent
    //   2849: dup
    //   2850: invokespecial 435	android/content/Intent:<init>	()V
    //   2853: astore_3
    //   2854: aload_3
    //   2855: getstatic 1839	cooperation/troop/TroopProxyActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2858: aload_2
    //   2859: invokevirtual 258	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2862: pop
    //   2863: aload_0
    //   2864: getfield 216	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2867: invokevirtual 221	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   2870: aload_3
    //   2871: invokestatic 1843	cooperation/troop/TroopFileProxyActivity:a	(Landroid/app/Activity;Landroid/content/Intent;)V
    //   2874: aload_1
    //   2875: ldc_w 1845
    //   2878: invokevirtual 1698	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   2881: goto -2699 -> 182
    //   2884: astore_2
    //   2885: aload_2
    //   2886: invokevirtual 1759	org/json/JSONException:printStackTrace	()V
    //   2889: aload_1
    //   2890: ldc_w 1847
    //   2893: invokevirtual 1698	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   2896: goto -2714 -> 182
    //   2899: aload_1
    //   2900: ldc_w 1847
    //   2903: invokevirtual 1698	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   2906: goto -2724 -> 182
    //   2909: astore_2
    //   2910: aload_2
    //   2911: invokevirtual 1848	java/lang/Exception:printStackTrace	()V
    //   2914: aload_1
    //   2915: ldc_w 1847
    //   2918: invokevirtual 1698	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   2921: goto -2739 -> 182
    //   2924: ldc_w 1850
    //   2927: aload_3
    //   2928: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2931: ifeq +71 -> 3002
    //   2934: aload_2
    //   2935: ldc_w 1571
    //   2938: invokevirtual 626	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2941: astore_2
    //   2942: aload_2
    //   2943: invokestatic 1578	com/tencent/mobileqq/data/Friends:isValidUin	(Ljava/lang/String;)Z
    //   2946: ifeq +46 -> 2992
    //   2949: invokestatic 1855	cooperation/qzone/QZoneHelper$UserInfo:a	()Lcooperation/qzone/QZoneHelper$UserInfo;
    //   2952: astore_3
    //   2953: aload_3
    //   2954: aload_0
    //   2955: getfield 216	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2958: invokevirtual 739	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   2961: invokevirtual 1856	com/tencent/common/app/AppInterface:a	()Ljava/lang/String;
    //   2964: putfield 1857	cooperation/qzone/QZoneHelper$UserInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2967: aload_0
    //   2968: getfield 216	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2971: invokevirtual 221	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   2974: aload_3
    //   2975: aload_2
    //   2976: aconst_null
    //   2977: iconst_0
    //   2978: iconst_0
    //   2979: invokestatic 1862	cooperation/qzone/QZoneHelper:a	(Landroid/app/Activity;Lcooperation/qzone/QZoneHelper$UserInfo;Ljava/lang/String;Ljava/lang/String;ZI)V
    //   2982: aload_1
    //   2983: ldc_w 1845
    //   2986: invokevirtual 1698	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   2989: goto -2807 -> 182
    //   2992: aload_1
    //   2993: ldc_w 1847
    //   2996: invokevirtual 1698	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   2999: goto -2817 -> 182
    //   3002: ldc_w 1864
    //   3005: aload_3
    //   3006: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3009: ifeq +66 -> 3075
    //   3012: aload_0
    //   3013: getfield 216	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   3016: invokevirtual 221	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   3019: astore_3
    //   3020: aload_2
    //   3021: ldc_w 1571
    //   3024: invokevirtual 626	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3027: astore_2
    //   3028: aload_3
    //   3029: ifnull -2847 -> 182
    //   3032: aload_2
    //   3033: invokestatic 1578	com/tencent/mobileqq/data/Friends:isValidUin	(Ljava/lang/String;)Z
    //   3036: ifeq -2854 -> 182
    //   3039: new 232	android/content/Intent
    //   3042: dup
    //   3043: aload_3
    //   3044: ldc_w 1866
    //   3047: invokespecial 544	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   3050: astore 4
    //   3052: aload 4
    //   3054: ldc_w 1582
    //   3057: aload_2
    //   3058: invokevirtual 258	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   3061: pop
    //   3062: aload_3
    //   3063: aload 4
    //   3065: invokevirtual 1094	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   3068: aload_3
    //   3069: invokevirtual 445	android/app/Activity:finish	()V
    //   3072: goto -2890 -> 182
    //   3075: ldc_w 1868
    //   3078: aload_3
    //   3079: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3082: ifeq -2900 -> 182
    //   3085: aload_0
    //   3086: getfield 216	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   3089: invokevirtual 221	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   3092: astore_3
    //   3093: aload_2
    //   3094: ldc_w 1571
    //   3097: invokevirtual 626	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3100: astore 4
    //   3102: aload_2
    //   3103: ldc_w 1573
    //   3106: invokevirtual 626	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3109: astore_2
    //   3110: aload_3
    //   3111: ifnull -2929 -> 182
    //   3114: aload 4
    //   3116: invokestatic 1578	com/tencent/mobileqq/data/Friends:isValidUin	(Ljava/lang/String;)Z
    //   3119: ifeq -2937 -> 182
    //   3122: aload_2
    //   3123: invokestatic 1578	com/tencent/mobileqq/data/Friends:isValidUin	(Ljava/lang/String;)Z
    //   3126: ifeq -2944 -> 182
    //   3129: new 232	android/content/Intent
    //   3132: dup
    //   3133: aload_3
    //   3134: ldc_w 1580
    //   3137: invokespecial 544	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   3140: astore 5
    //   3142: aload 5
    //   3144: ldc_w 1582
    //   3147: aload 4
    //   3149: invokevirtual 258	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   3152: pop
    //   3153: aload 5
    //   3155: ldc_w 1573
    //   3158: aload_2
    //   3159: invokevirtual 258	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   3162: pop
    //   3163: aload_3
    //   3164: aload 5
    //   3166: invokevirtual 1094	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   3169: goto -2987 -> 182
    //   3172: ldc_w 1869
    //   3175: aload 4
    //   3177: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3180: ifeq +525 -> 3705
    //   3183: aload 5
    //   3185: arraylength
    //   3186: iconst_1
    //   3187: if_icmpne +518 -> 3705
    //   3190: aload_0
    //   3191: ldc_w 565
    //   3194: putfield 1871	com/tencent/mobileqq/jsp/UiApiPlugin:E	Ljava/lang/String;
    //   3197: new 199	org/json/JSONObject
    //   3200: dup
    //   3201: aload 5
    //   3203: iconst_0
    //   3204: aaload
    //   3205: invokespecial 326	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3208: astore_1
    //   3209: aload_1
    //   3210: ifnull +476 -> 3686
    //   3213: aload_0
    //   3214: getfield 216	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   3217: invokevirtual 221	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   3220: astore_3
    //   3221: aload_1
    //   3222: ldc_w 1873
    //   3225: ldc_w 1875
    //   3228: invokevirtual 1662	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   3231: astore 6
    //   3233: aload_1
    //   3234: ldc 33
    //   3236: invokevirtual 626	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3239: astore 4
    //   3241: aload_1
    //   3242: ldc_w 781
    //   3245: invokevirtual 626	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3248: astore 7
    //   3250: aload_1
    //   3251: ldc_w 1877
    //   3254: invokevirtual 626	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3257: astore 5
    //   3259: aload_1
    //   3260: ldc 38
    //   3262: invokevirtual 626	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3265: astore_2
    //   3266: aload_1
    //   3267: ldc_w 776
    //   3270: iconst_m1
    //   3271: invokevirtual 640	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   3274: istore 10
    //   3276: new 199	org/json/JSONObject
    //   3279: dup
    //   3280: aload 7
    //   3282: invokespecial 326	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3285: astore_1
    //   3286: aload_0
    //   3287: getfield 216	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   3290: invokevirtual 688	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   3293: astore 7
    //   3295: aload 7
    //   3297: ifnull +16 -> 3313
    //   3300: aload_1
    //   3301: ldc_w 1879
    //   3304: aload 7
    //   3306: invokevirtual 1880	com/tencent/smtt/sdk/WebView:getUrl	()Ljava/lang/String;
    //   3309: invokevirtual 287	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   3312: pop
    //   3313: ldc_w 1882
    //   3316: aload 6
    //   3318: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3321: ifeq +166 -> 3487
    //   3324: new 712	android/os/Bundle
    //   3327: dup
    //   3328: invokespecial 713	android/os/Bundle:<init>	()V
    //   3331: astore_2
    //   3332: aload_2
    //   3333: ldc_w 781
    //   3336: aload_1
    //   3337: invokevirtual 294	org/json/JSONObject:toString	()Ljava/lang/String;
    //   3340: invokevirtual 825	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   3343: aload_2
    //   3344: ldc_w 1877
    //   3347: aload 5
    //   3349: invokevirtual 825	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   3352: ldc_w 1884
    //   3355: aload 4
    //   3357: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3360: ifeq +97 -> 3457
    //   3363: new 1886	com/tencent/mobileqq/troop/activity/PublicCommentWindow
    //   3366: dup
    //   3367: aload_3
    //   3368: checkcast 812	com/tencent/mobileqq/app/BaseActivity
    //   3371: aload_2
    //   3372: invokespecial 1889	com/tencent/mobileqq/troop/activity/PublicCommentWindow:<init>	(Lcom/tencent/mobileqq/app/BaseActivity;Landroid/os/Bundle;)V
    //   3375: aload_3
    //   3376: invokevirtual 1891	com/tencent/mobileqq/troop/activity/PublicCommentWindow:a	(Landroid/app/Activity;)V
    //   3379: goto -3197 -> 182
    //   3382: astore_1
    //   3383: ldc_w 565
    //   3386: astore_2
    //   3387: invokestatic 300	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3390: ifeq +24 -> 3414
    //   3393: getstatic 145	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3396: iconst_2
    //   3397: ldc_w 1893
    //   3400: invokestatic 305	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3403: getstatic 145	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3406: iconst_2
    //   3407: aload_1
    //   3408: invokestatic 958	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3411: invokestatic 305	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3414: aload_2
    //   3415: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3418: ifne -3236 -> 182
    //   3421: aload_0
    //   3422: aload_2
    //   3423: iconst_1
    //   3424: anewarray 186	java/lang/String
    //   3427: dup
    //   3428: iconst_0
    //   3429: ldc_w 1895
    //   3432: aastore
    //   3433: invokevirtual 582	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   3436: goto -3254 -> 182
    //   3439: astore_1
    //   3440: aconst_null
    //   3441: astore_1
    //   3442: goto -233 -> 3209
    //   3445: astore_1
    //   3446: new 199	org/json/JSONObject
    //   3449: dup
    //   3450: invokespecial 281	org/json/JSONObject:<init>	()V
    //   3453: astore_1
    //   3454: goto -168 -> 3286
    //   3457: ldc_w 1897
    //   3460: aload 4
    //   3462: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3465: ifeq -3283 -> 182
    //   3468: new 1899	com/tencent/mobileqq/troop/activity/TroopBarCommentWindow
    //   3471: dup
    //   3472: aload_3
    //   3473: checkcast 812	com/tencent/mobileqq/app/BaseActivity
    //   3476: aload_2
    //   3477: invokespecial 1900	com/tencent/mobileqq/troop/activity/TroopBarCommentWindow:<init>	(Lcom/tencent/mobileqq/app/BaseActivity;Landroid/os/Bundle;)V
    //   3480: aload_3
    //   3481: invokevirtual 1901	com/tencent/mobileqq/troop/activity/TroopBarCommentWindow:a	(Landroid/app/Activity;)V
    //   3484: goto -3302 -> 182
    //   3487: ldc_w 1875
    //   3490: aload 6
    //   3492: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3495: ifeq -3313 -> 182
    //   3498: new 232	android/content/Intent
    //   3501: dup
    //   3502: invokespecial 435	android/content/Intent:<init>	()V
    //   3505: astore 6
    //   3507: ldc_w 1903
    //   3510: aload 4
    //   3512: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3515: ifeq +107 -> 3622
    //   3518: aload 6
    //   3520: new 1905	android/content/ComponentName
    //   3523: dup
    //   3524: aload_0
    //   3525: invokespecial 229	com/tencent/mobileqq/jsp/UiApiPlugin:a	()Landroid/content/Context;
    //   3528: aload 4
    //   3530: invokespecial 1908	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   3533: invokevirtual 1912	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   3536: pop
    //   3537: aload 6
    //   3539: ldc_w 781
    //   3542: aload_1
    //   3543: invokevirtual 294	org/json/JSONObject:toString	()Ljava/lang/String;
    //   3546: invokevirtual 258	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   3549: pop
    //   3550: aload_0
    //   3551: aload 5
    //   3553: putfield 1871	com/tencent/mobileqq/jsp/UiApiPlugin:E	Ljava/lang/String;
    //   3556: aload 5
    //   3558: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3561: ifeq +80 -> 3641
    //   3564: aload_3
    //   3565: aload 6
    //   3567: invokevirtual 1094	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   3570: goto +6523 -> 10093
    //   3573: ldc_w 1914
    //   3576: invokevirtual 242	java/lang/Class:getName	()Ljava/lang/String;
    //   3579: aload 4
    //   3581: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3584: ifeq -3402 -> 182
    //   3587: aload_0
    //   3588: getfield 158	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   3591: ifnonnull +17 -> 3608
    //   3594: aload_0
    //   3595: invokestatic 1074	com/tencent/biz/troop/TroopMemberApiClient:a	()Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   3598: putfield 158	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   3601: aload_0
    //   3602: getfield 158	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   3605: invokevirtual 1076	com/tencent/biz/troop/TroopMemberApiClient:a	()V
    //   3608: aload_0
    //   3609: getfield 158	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   3612: invokevirtual 1916	com/tencent/biz/troop/TroopMemberApiClient:c	()V
    //   3615: goto -3433 -> 182
    //   3618: astore_1
    //   3619: goto -232 -> 3387
    //   3622: aload 6
    //   3624: new 1905	android/content/ComponentName
    //   3627: dup
    //   3628: aload_3
    //   3629: aload 4
    //   3631: invokespecial 1908	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   3634: invokevirtual 1912	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   3637: pop
    //   3638: goto -101 -> 3537
    //   3641: aload_0
    //   3642: aload 6
    //   3644: iconst_4
    //   3645: invokevirtual 1050	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   3648: aload_2
    //   3649: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3652: ifne +6441 -> 10093
    //   3655: aload_0
    //   3656: aload_2
    //   3657: iconst_1
    //   3658: anewarray 186	java/lang/String
    //   3661: dup
    //   3662: iconst_0
    //   3663: ldc_w 1370
    //   3666: aastore
    //   3667: invokevirtual 582	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   3670: goto +6423 -> 10093
    //   3673: aload_3
    //   3674: ldc_w 1917
    //   3677: ldc_w 1918
    //   3680: invokevirtual 779	android/app/Activity:overridePendingTransition	(II)V
    //   3683: goto -110 -> 3573
    //   3686: invokestatic 300	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3689: ifeq -3507 -> 182
    //   3692: getstatic 145	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3695: iconst_2
    //   3696: ldc_w 1920
    //   3699: invokestatic 305	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3702: goto -3520 -> 182
    //   3705: ldc_w 1922
    //   3708: aload 4
    //   3710: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3713: ifeq +1084 -> 4797
    //   3716: aload 5
    //   3718: arraylength
    //   3719: iconst_1
    //   3720: if_icmpne +1077 -> 4797
    //   3723: new 199	org/json/JSONObject
    //   3726: dup
    //   3727: aload 5
    //   3729: iconst_0
    //   3730: aaload
    //   3731: invokespecial 326	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3734: astore_2
    //   3735: aload_0
    //   3736: getfield 216	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   3739: invokevirtual 221	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   3742: astore_3
    //   3743: aload_0
    //   3744: invokespecial 1517	com/tencent/mobileqq/jsp/UiApiPlugin:a	()Lcom/tencent/mobileqq/webviewplugin/WebUiUtils$QQBrowserBaseActivityInterface;
    //   3747: ifnonnull +5 -> 3752
    //   3750: iconst_1
    //   3751: ireturn
    //   3752: aload_2
    //   3753: ldc_w 1924
    //   3756: invokevirtual 694	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   3759: ifeq +70 -> 3829
    //   3762: aload_2
    //   3763: ldc_w 1924
    //   3766: invokevirtual 202	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   3769: istore 10
    //   3771: aload_3
    //   3772: ldc_w 1529
    //   3775: invokevirtual 351	android/app/Activity:findViewById	(I)Landroid/view/View;
    //   3778: checkcast 894	android/widget/TextView
    //   3781: astore_1
    //   3782: aload_3
    //   3783: ldc_w 1925
    //   3786: invokevirtual 351	android/app/Activity:findViewById	(I)Landroid/view/View;
    //   3789: checkcast 385	android/widget/ImageView
    //   3792: astore 4
    //   3794: aload_1
    //   3795: ifnull +34 -> 3829
    //   3798: aload 4
    //   3800: ifnull +29 -> 3829
    //   3803: iload 10
    //   3805: iconst_1
    //   3806: if_icmpne +633 -> 4439
    //   3809: aload 4
    //   3811: invokevirtual 1928	android/widget/ImageView:getDrawable	()Landroid/graphics/drawable/Drawable;
    //   3814: ifnull +573 -> 4387
    //   3817: aload 4
    //   3819: iconst_0
    //   3820: invokevirtual 388	android/widget/ImageView:setVisibility	(I)V
    //   3823: aload_1
    //   3824: bipush 8
    //   3826: invokevirtual 1929	android/widget/TextView:setVisibility	(I)V
    //   3829: aload_2
    //   3830: ldc_w 1931
    //   3833: invokevirtual 694	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   3836: ifeq +43 -> 3879
    //   3839: aload_2
    //   3840: ldc_w 1931
    //   3843: invokevirtual 202	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   3846: istore 10
    //   3848: aload_3
    //   3849: ifnull +30 -> 3879
    //   3852: aload_3
    //   3853: instanceof 760
    //   3856: ifeq +23 -> 3879
    //   3859: aload_3
    //   3860: checkcast 760	com/tencent/mobileqq/activity/QQBrowserActivity
    //   3863: astore_1
    //   3864: iload 10
    //   3866: iconst_1
    //   3867: if_icmpne +6248 -> 10115
    //   3870: iconst_1
    //   3871: istore 15
    //   3873: aload_1
    //   3874: iload 15
    //   3876: invokevirtual 1933	com/tencent/mobileqq/activity/QQBrowserActivity:e	(Z)V
    //   3879: aload_0
    //   3880: invokespecial 1935	com/tencent/mobileqq/jsp/UiApiPlugin:a	()Lcom/tencent/mobileqq/webviewplugin/WebUiUtils$WebUiMethodInterface;
    //   3883: astore_1
    //   3884: aload_1
    //   3885: ifnull +131 -> 4016
    //   3888: aload_1
    //   3889: invokeinterface 1938 1 0
    //   3894: ifne +122 -> 4016
    //   3897: aload_2
    //   3898: ldc_w 1940
    //   3901: invokevirtual 694	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   3904: ifeq +112 -> 4016
    //   3907: aload_2
    //   3908: ldc_w 1940
    //   3911: invokestatic 1942	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   3914: istore 11
    //   3916: aload_3
    //   3917: ldc_w 347
    //   3920: invokevirtual 351	android/app/Activity:findViewById	(I)Landroid/view/View;
    //   3923: astore 4
    //   3925: aload 4
    //   3927: ifnull +89 -> 4016
    //   3930: aconst_null
    //   3931: astore_1
    //   3932: aload_0
    //   3933: invokespecial 1944	com/tencent/mobileqq/jsp/UiApiPlugin:a	()Lcom/tencent/mobileqq/webviewplugin/WebUiUtils$WebProgressInterface;
    //   3936: ifnull +519 -> 4455
    //   3939: aload_0
    //   3940: invokespecial 1944	com/tencent/mobileqq/jsp/UiApiPlugin:a	()Lcom/tencent/mobileqq/webviewplugin/WebUiUtils$WebProgressInterface;
    //   3943: invokeinterface 1947 1 0
    //   3948: astore_1
    //   3949: iload 11
    //   3951: iconst_m1
    //   3952: if_icmpne +564 -> 4516
    //   3955: aload 4
    //   3957: ldc_w 1948
    //   3960: invokevirtual 1949	android/view/View:setBackgroundResource	(I)V
    //   3963: aload_1
    //   3964: ifnull +7 -> 3971
    //   3967: aload_1
    //   3968: invokevirtual 1952	com/tencent/mobileqq/widget/WebViewProgressBar:a	()V
    //   3971: aload_0
    //   3972: invokespecial 1519	com/tencent/mobileqq/jsp/UiApiPlugin:a	()Lcom/tencent/mobileqq/webviewplugin/WebUiUtils$WebTitleBarInterface;
    //   3975: astore_1
    //   3976: aload_1
    //   3977: ifnull +39 -> 4016
    //   3980: aload_1
    //   3981: invokeinterface 1955 1 0
    //   3986: ifnull +30 -> 4016
    //   3989: aload_1
    //   3990: invokeinterface 1957 1 0
    //   3995: ifeq +484 -> 4479
    //   3998: aload_1
    //   3999: invokeinterface 1955 1 0
    //   4004: iconst_0
    //   4005: iconst_0
    //   4006: invokevirtual 1961	com/tencent/widget/immersive/SystemBarCompact:a	(ZI)V
    //   4009: aload_1
    //   4010: iconst_0
    //   4011: invokeinterface 1963 2 0
    //   4016: aload_2
    //   4017: ldc_w 1965
    //   4020: invokevirtual 694	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4023: ifeq +6098 -> 10121
    //   4026: iconst_1
    //   4027: aload_2
    //   4028: ldc_w 1965
    //   4031: invokevirtual 202	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   4034: if_icmpne +6087 -> 10121
    //   4037: iconst_1
    //   4038: istore 15
    //   4040: aload_0
    //   4041: iconst_2
    //   4042: invokespecial 1320	com/tencent/mobileqq/webview/swift/WebViewPlugin:getBrowserComponent	(I)Ljava/lang/Object;
    //   4045: checkcast 1322	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler
    //   4048: astore_1
    //   4049: iload 15
    //   4051: ifeq +86 -> 4137
    //   4054: aload_1
    //   4055: ifnull +82 -> 4137
    //   4058: iload 15
    //   4060: aload_1
    //   4061: getfield 1968	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle;
    //   4064: getfield 1972	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle:x	Z
    //   4067: if_icmpeq +70 -> 4137
    //   4070: aload_1
    //   4071: getfield 1968	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle;
    //   4074: iload 15
    //   4076: putfield 1972	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle:x	Z
    //   4079: aload_0
    //   4080: getfield 1316	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_i_of_type_Int	I
    //   4083: ifeq +19 -> 4102
    //   4086: aload_1
    //   4087: aload_1
    //   4088: getfield 1975	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftIphoneTitleBarUI	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftIphoneTitleBarUI;
    //   4091: getfield 1978	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftIphoneTitleBarUI:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   4094: iconst_0
    //   4095: aload_0
    //   4096: getfield 1316	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_i_of_type_Int	I
    //   4099: invokevirtual 1325	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:a	(Landroid/view/View;ZI)V
    //   4102: aload_0
    //   4103: getfield 1336	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_h_of_type_Int	I
    //   4106: ifeq +16 -> 4122
    //   4109: aload_1
    //   4110: aload_0
    //   4111: getfield 1334	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_c_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   4114: iconst_0
    //   4115: aload_0
    //   4116: getfield 1336	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_h_of_type_Int	I
    //   4119: invokevirtual 1325	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:a	(Landroid/view/View;ZI)V
    //   4122: aload_1
    //   4123: aload_1
    //   4124: getfield 1975	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftIphoneTitleBarUI	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftIphoneTitleBarUI;
    //   4127: getfield 1981	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftIphoneTitleBarUI:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   4130: iconst_1
    //   4131: ldc_w 1982
    //   4134: invokevirtual 1325	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:a	(Landroid/view/View;ZI)V
    //   4137: aload_0
    //   4138: invokespecial 1519	com/tencent/mobileqq/jsp/UiApiPlugin:a	()Lcom/tencent/mobileqq/webviewplugin/WebUiUtils$WebTitleBarInterface;
    //   4141: astore_1
    //   4142: aload_1
    //   4143: ifnull +34 -> 4177
    //   4146: aload_2
    //   4147: ldc_w 1984
    //   4150: invokevirtual 694	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4153: ifeq +24 -> 4177
    //   4156: aload_2
    //   4157: ldc_w 1984
    //   4160: invokestatic 1942	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   4163: istore 10
    //   4165: iload 10
    //   4167: iconst_m1
    //   4168: if_icmpne +595 -> 4763
    //   4171: aload_1
    //   4172: invokeinterface 1986 1 0
    //   4177: aload_0
    //   4178: invokespecial 1935	com/tencent/mobileqq/jsp/UiApiPlugin:a	()Lcom/tencent/mobileqq/webviewplugin/WebUiUtils$WebUiMethodInterface;
    //   4181: ifnull +33 -> 4214
    //   4184: aload_2
    //   4185: ldc_w 1988
    //   4188: invokevirtual 694	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4191: ifeq +23 -> 4214
    //   4194: aload_2
    //   4195: ldc_w 1988
    //   4198: invokevirtual 1991	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   4201: istore 15
    //   4203: aload_0
    //   4204: invokespecial 1935	com/tencent/mobileqq/jsp/UiApiPlugin:a	()Lcom/tencent/mobileqq/webviewplugin/WebUiUtils$WebUiMethodInterface;
    //   4207: iload 15
    //   4209: invokeinterface 1994 2 0
    //   4214: aload_1
    //   4215: ifnull +39 -> 4254
    //   4218: aload_2
    //   4219: ldc_w 1996
    //   4222: invokevirtual 694	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4225: ifeq +29 -> 4254
    //   4228: aload_2
    //   4229: ldc_w 1996
    //   4232: invokevirtual 1991	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   4235: ifeq +543 -> 4778
    //   4238: aload_1
    //   4239: aload_1
    //   4240: invokeinterface 1521 1 0
    //   4245: ldc2_w 1997
    //   4248: land
    //   4249: invokeinterface 2000 3 0
    //   4254: aload_2
    //   4255: ldc_w 2002
    //   4258: invokevirtual 694	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4261: ifeq +30 -> 4291
    //   4264: aload_2
    //   4265: ldc_w 2002
    //   4268: invokevirtual 626	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4271: astore_1
    //   4272: aload_3
    //   4273: ifnull +18 -> 4291
    //   4276: aload_3
    //   4277: instanceof 760
    //   4280: ifeq +11 -> 4291
    //   4283: aload_3
    //   4284: checkcast 760	com/tencent/mobileqq/activity/QQBrowserActivity
    //   4287: aload_1
    //   4288: invokevirtual 2004	com/tencent/mobileqq/activity/QQBrowserActivity:setTitle	(Ljava/lang/CharSequence;)V
    //   4291: aload_2
    //   4292: ldc_w 2006
    //   4295: invokevirtual 694	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4298: ifeq -4116 -> 182
    //   4301: aload_2
    //   4302: ldc_w 2006
    //   4305: invokevirtual 843	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   4308: istore 15
    //   4310: sipush 800
    //   4313: istore 10
    //   4315: aload_2
    //   4316: ldc_w 2008
    //   4319: invokevirtual 694	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4322: ifeq +17 -> 4339
    //   4325: aload_2
    //   4326: ldc_w 2008
    //   4329: invokevirtual 2012	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   4332: ldc2_w 2013
    //   4335: dmul
    //   4336: d2i
    //   4337: istore 10
    //   4339: aload_0
    //   4340: iload 15
    //   4342: iload 10
    //   4344: invokevirtual 2015	com/tencent/mobileqq/jsp/UiApiPlugin:a	(ZI)V
    //   4347: goto -4165 -> 182
    //   4350: astore_1
    //   4351: invokestatic 2018	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   4354: ifeq -4172 -> 182
    //   4357: getstatic 145	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4360: iconst_4
    //   4361: new 584	java/lang/StringBuilder
    //   4364: dup
    //   4365: invokespecial 585	java/lang/StringBuilder:<init>	()V
    //   4368: ldc_w 2020
    //   4371: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4374: aload_1
    //   4375: invokevirtual 1362	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4378: invokevirtual 592	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4381: invokestatic 305	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4384: goto -4202 -> 182
    //   4387: aload 4
    //   4389: bipush 8
    //   4391: invokevirtual 388	android/widget/ImageView:setVisibility	(I)V
    //   4394: aload_1
    //   4395: iconst_0
    //   4396: invokevirtual 1929	android/widget/TextView:setVisibility	(I)V
    //   4399: goto -570 -> 3829
    //   4402: astore_1
    //   4403: invokestatic 2018	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   4406: ifeq -4224 -> 182
    //   4409: getstatic 145	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4412: iconst_4
    //   4413: new 584	java/lang/StringBuilder
    //   4416: dup
    //   4417: invokespecial 585	java/lang/StringBuilder:<init>	()V
    //   4420: ldc_w 2020
    //   4423: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4426: aload_1
    //   4427: invokevirtual 1362	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4430: invokevirtual 592	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4433: invokestatic 305	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4436: goto -4254 -> 182
    //   4439: aload_1
    //   4440: bipush 8
    //   4442: invokevirtual 1929	android/widget/TextView:setVisibility	(I)V
    //   4445: aload 4
    //   4447: bipush 8
    //   4449: invokevirtual 388	android/widget/ImageView:setVisibility	(I)V
    //   4452: goto -623 -> 3829
    //   4455: aload_0
    //   4456: iconst_2
    //   4457: invokespecial 1320	com/tencent/mobileqq/webview/swift/WebViewPlugin:getBrowserComponent	(I)Ljava/lang/Object;
    //   4460: checkcast 1322	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler
    //   4463: astore 5
    //   4465: aload 5
    //   4467: ifnull -518 -> 3949
    //   4470: aload 5
    //   4472: getfield 2023	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar	Lcom/tencent/mobileqq/widget/WebViewProgressBar;
    //   4475: astore_1
    //   4476: goto -527 -> 3949
    //   4479: aload_3
    //   4480: invokevirtual 365	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   4483: ldc_w 2024
    //   4486: invokevirtual 928	android/content/res/Resources:getColor	(I)I
    //   4489: istore 10
    //   4491: aload_1
    //   4492: invokeinterface 1955 1 0
    //   4497: iload 10
    //   4499: invokevirtual 2026	com/tencent/widget/immersive/SystemBarCompact:a	(I)V
    //   4502: aload_1
    //   4503: invokeinterface 1955 1 0
    //   4508: iload 10
    //   4510: invokevirtual 2028	com/tencent/widget/immersive/SystemBarCompact:b	(I)V
    //   4513: goto -504 -> 4009
    //   4516: aload 4
    //   4518: iconst_0
    //   4519: invokevirtual 1949	android/view/View:setBackgroundResource	(I)V
    //   4522: ldc_w 2029
    //   4525: istore 10
    //   4527: aload_2
    //   4528: ldc_w 2031
    //   4531: invokevirtual 694	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4534: ifeq +15 -> 4549
    //   4537: aload_2
    //   4538: ldc_w 2031
    //   4541: invokestatic 1942	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   4544: bipush 24
    //   4546: ishl
    //   4547: istore 10
    //   4549: iload 11
    //   4551: iload 10
    //   4553: ior
    //   4554: istore 12
    //   4556: invokestatic 300	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4559: ifeq +62 -> 4621
    //   4562: getstatic 145	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4565: iconst_2
    //   4566: new 584	java/lang/StringBuilder
    //   4569: dup
    //   4570: invokespecial 585	java/lang/StringBuilder:<init>	()V
    //   4573: ldc_w 2033
    //   4576: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4579: iload 10
    //   4581: invokestatic 2036	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   4584: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4587: ldc_w 2038
    //   4590: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4593: iload 11
    //   4595: invokestatic 2036	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   4598: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4601: ldc_w 2040
    //   4604: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4607: iload 12
    //   4609: invokestatic 2036	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   4612: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4615: invokevirtual 592	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4618: invokestatic 305	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4621: aload 4
    //   4623: iload 12
    //   4625: invokevirtual 2043	android/view/View:setBackgroundColor	(I)V
    //   4628: aload_1
    //   4629: ifnull +13 -> 4642
    //   4632: aload_1
    //   4633: ldc_w 2029
    //   4636: iload 11
    //   4638: ior
    //   4639: invokevirtual 2046	com/tencent/mobileqq/widget/WebViewProgressBar:setCustomColor	(I)V
    //   4642: aload_0
    //   4643: invokespecial 1519	com/tencent/mobileqq/jsp/UiApiPlugin:a	()Lcom/tencent/mobileqq/webviewplugin/WebUiUtils$WebTitleBarInterface;
    //   4646: astore_1
    //   4647: aload_1
    //   4648: ifnull +41 -> 4689
    //   4651: aload_1
    //   4652: invokeinterface 1957 1 0
    //   4657: ifeq +32 -> 4689
    //   4660: aload_1
    //   4661: invokeinterface 1955 1 0
    //   4666: ifnonnull +83 -> 4749
    //   4669: aload_1
    //   4670: iconst_1
    //   4671: invokeinterface 2048 2 0
    //   4676: aload_1
    //   4677: iconst_1
    //   4678: invokeinterface 2050 2 0
    //   4683: aload_1
    //   4684: invokeinterface 2053 1 0
    //   4689: aload_1
    //   4690: invokeinterface 1955 1 0
    //   4695: ifnull -679 -> 4016
    //   4698: aload_1
    //   4699: invokeinterface 1955 1 0
    //   4704: invokevirtual 2056	com/tencent/widget/immersive/SystemBarCompact:init	()V
    //   4707: aload_1
    //   4708: invokeinterface 1955 1 0
    //   4713: iload 12
    //   4715: invokevirtual 2026	com/tencent/widget/immersive/SystemBarCompact:a	(I)V
    //   4718: aload_1
    //   4719: invokeinterface 1955 1 0
    //   4724: iload 12
    //   4726: invokevirtual 2028	com/tencent/widget/immersive/SystemBarCompact:b	(I)V
    //   4729: aload_1
    //   4730: invokeinterface 1955 1 0
    //   4735: iconst_0
    //   4736: invokevirtual 2057	com/tencent/widget/immersive/SystemBarCompact:a	(Z)V
    //   4739: aload_1
    //   4740: iconst_1
    //   4741: invokeinterface 1963 2 0
    //   4746: goto -730 -> 4016
    //   4749: aload_1
    //   4750: invokeinterface 1955 1 0
    //   4755: iconst_1
    //   4756: iconst_0
    //   4757: invokevirtual 1961	com/tencent/widget/immersive/SystemBarCompact:a	(ZI)V
    //   4760: goto -71 -> 4689
    //   4763: aload_1
    //   4764: iload 10
    //   4766: ldc_w 2029
    //   4769: ior
    //   4770: invokeinterface 2058 2 0
    //   4775: goto -598 -> 4177
    //   4778: aload_1
    //   4779: aload_1
    //   4780: invokeinterface 1521 1 0
    //   4785: ldc2_w 1538
    //   4788: lor
    //   4789: invokeinterface 2000 3 0
    //   4794: goto -540 -> 4254
    //   4797: ldc_w 2060
    //   4800: aload 4
    //   4802: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4805: ifeq +111 -> 4916
    //   4808: aload 5
    //   4810: arraylength
    //   4811: iconst_1
    //   4812: if_icmpgt +104 -> 4916
    //   4815: aload 5
    //   4817: arraylength
    //   4818: iconst_1
    //   4819: if_icmpne +22 -> 4841
    //   4822: new 199	org/json/JSONObject
    //   4825: dup
    //   4826: aload 5
    //   4828: iconst_0
    //   4829: aaload
    //   4830: invokespecial 326	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   4833: ldc_w 2062
    //   4836: iconst_0
    //   4837: invokevirtual 640	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   4840: pop
    //   4841: aload_0
    //   4842: getfield 216	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   4845: aload_0
    //   4846: getfield 216	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   4849: invokevirtual 221	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   4852: invokevirtual 265	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	(Landroid/app/Activity;)Lcom/tencent/mobileqq/webview/swift/WebUiBaseInterface;
    //   4855: astore_1
    //   4856: aload_1
    //   4857: ifnull -4675 -> 182
    //   4860: aload_1
    //   4861: instanceof 276
    //   4864: ifeq -4682 -> 182
    //   4867: aload_1
    //   4868: checkcast 276	com/tencent/mobileqq/webviewplugin/WebUiUtils$WebUiMethodInterface
    //   4871: invokeinterface 2064 1 0
    //   4876: goto -4694 -> 182
    //   4879: astore_1
    //   4880: invokestatic 2018	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   4883: ifeq -4701 -> 182
    //   4886: getstatic 145	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4889: iconst_4
    //   4890: new 584	java/lang/StringBuilder
    //   4893: dup
    //   4894: invokespecial 585	java/lang/StringBuilder:<init>	()V
    //   4897: ldc_w 2066
    //   4900: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4903: aload_1
    //   4904: invokevirtual 1362	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4907: invokevirtual 592	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4910: invokestatic 305	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4913: goto -4731 -> 182
    //   4916: ldc_w 2068
    //   4919: aload 4
    //   4921: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4924: ifeq +138 -> 5062
    //   4927: aload 5
    //   4929: arraylength
    //   4930: iconst_1
    //   4931: if_icmpne +131 -> 5062
    //   4934: new 199	org/json/JSONObject
    //   4937: dup
    //   4938: aload 5
    //   4940: iconst_0
    //   4941: aaload
    //   4942: invokespecial 326	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   4945: astore_1
    //   4946: aload_1
    //   4947: ldc 54
    //   4949: iconst_0
    //   4950: invokevirtual 640	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   4953: istore 10
    //   4955: aload_1
    //   4956: ldc 58
    //   4958: iconst_0
    //   4959: invokevirtual 640	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   4962: istore 11
    //   4964: aload_1
    //   4965: ldc 62
    //   4967: iconst_0
    //   4968: invokevirtual 721	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   4971: istore 15
    //   4973: invokestatic 341	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4976: new 232	android/content/Intent
    //   4979: dup
    //   4980: ldc 66
    //   4982: invokespecial 237	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   4985: ldc 54
    //   4987: iload 10
    //   4989: invokevirtual 438	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   4992: ldc 62
    //   4994: iload 15
    //   4996: invokevirtual 1007	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   4999: ldc 58
    //   5001: iload 11
    //   5003: invokevirtual 438	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   5006: ldc_w 2070
    //   5009: aload_0
    //   5010: getfield 166	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_e_of_type_Int	I
    //   5013: invokevirtual 438	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   5016: ldc_w 2072
    //   5019: invokevirtual 2077	com/tencent/qphone/base/util/BaseApplication:sendBroadcast	(Landroid/content/Intent;Ljava/lang/String;)V
    //   5022: goto -4840 -> 182
    //   5025: astore_1
    //   5026: invokestatic 2018	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   5029: ifeq -4847 -> 182
    //   5032: getstatic 145	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   5035: iconst_4
    //   5036: new 584	java/lang/StringBuilder
    //   5039: dup
    //   5040: invokespecial 585	java/lang/StringBuilder:<init>	()V
    //   5043: ldc_w 2079
    //   5046: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5049: aload_1
    //   5050: invokevirtual 1362	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5053: invokevirtual 592	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5056: invokestatic 305	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5059: goto -4877 -> 182
    //   5062: ldc_w 2081
    //   5065: aload 4
    //   5067: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5070: ifeq +257 -> 5327
    //   5073: aload 5
    //   5075: arraylength
    //   5076: iconst_1
    //   5077: if_icmpne +250 -> 5327
    //   5080: aload_0
    //   5081: aconst_null
    //   5082: putfield 2083	com/tencent/mobileqq/jsp/UiApiPlugin:F	Ljava/lang/String;
    //   5085: new 199	org/json/JSONObject
    //   5088: dup
    //   5089: aload 5
    //   5091: iconst_0
    //   5092: aaload
    //   5093: invokespecial 326	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   5096: astore_3
    //   5097: aload_3
    //   5098: ldc_w 844
    //   5101: invokevirtual 1596	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   5104: lstore 13
    //   5106: aload_3
    //   5107: ldc_w 2085
    //   5110: bipush 13
    //   5112: invokevirtual 640	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   5115: istore 10
    //   5117: aload_3
    //   5118: ldc_w 2087
    //   5121: iconst_0
    //   5122: invokevirtual 640	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   5125: istore 11
    //   5127: aload_3
    //   5128: ldc 38
    //   5130: invokevirtual 206	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   5133: astore_1
    //   5134: aload_0
    //   5135: getfield 216	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   5138: invokevirtual 739	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   5141: astore_2
    //   5142: aload_2
    //   5143: ifnull +10 -> 5153
    //   5146: aload_2
    //   5147: invokevirtual 2090	com/tencent/common/app/AppInterface:isLogin	()Z
    //   5150: ifne +20 -> 5170
    //   5153: aload_0
    //   5154: aload_1
    //   5155: iconst_1
    //   5156: anewarray 186	java/lang/String
    //   5159: dup
    //   5160: iconst_0
    //   5161: ldc_w 2092
    //   5164: aastore
    //   5165: invokevirtual 582	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   5168: iconst_1
    //   5169: ireturn
    //   5170: aload_3
    //   5171: ldc 72
    //   5173: invokevirtual 626	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5176: astore_3
    //   5177: aload_3
    //   5178: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5181: ifne +31 -> 5212
    //   5184: aload_3
    //   5185: aload_2
    //   5186: invokevirtual 1408	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   5189: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5192: ifne +20 -> 5212
    //   5195: aload_0
    //   5196: aload_1
    //   5197: iconst_1
    //   5198: anewarray 186	java/lang/String
    //   5201: dup
    //   5202: iconst_0
    //   5203: ldc_w 2094
    //   5206: aastore
    //   5207: invokevirtual 582	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   5210: iconst_1
    //   5211: ireturn
    //   5212: aload_0
    //   5213: getfield 216	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   5216: invokevirtual 221	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   5219: astore_2
    //   5220: aload_2
    //   5221: ifnull -5039 -> 182
    //   5224: aload_0
    //   5225: aload_1
    //   5226: putfield 2083	com/tencent/mobileqq/jsp/UiApiPlugin:F	Ljava/lang/String;
    //   5229: new 232	android/content/Intent
    //   5232: dup
    //   5233: aload_2
    //   5234: ldc_w 2096
    //   5237: invokespecial 544	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   5240: astore_1
    //   5241: aload_1
    //   5242: ldc_w 2098
    //   5245: bipush 16
    //   5247: invokevirtual 438	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   5250: pop
    //   5251: aload_1
    //   5252: ldc_w 2085
    //   5255: iload 10
    //   5257: invokevirtual 438	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   5260: pop
    //   5261: aload_1
    //   5262: ldc_w 844
    //   5265: lload 13
    //   5267: invokevirtual 2101	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   5270: pop
    //   5271: aload_1
    //   5272: ldc_w 2087
    //   5275: iload 11
    //   5277: invokevirtual 438	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   5280: pop
    //   5281: aload_0
    //   5282: aload_1
    //   5283: iconst_5
    //   5284: invokevirtual 1050	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   5287: goto -5105 -> 182
    //   5290: astore_1
    //   5291: invokestatic 2018	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   5294: ifeq -5112 -> 182
    //   5297: getstatic 145	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   5300: iconst_4
    //   5301: new 584	java/lang/StringBuilder
    //   5304: dup
    //   5305: invokespecial 585	java/lang/StringBuilder:<init>	()V
    //   5308: ldc_w 2103
    //   5311: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5314: aload_1
    //   5315: invokevirtual 1362	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5318: invokevirtual 592	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5321: invokestatic 305	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5324: goto -5142 -> 182
    //   5327: ldc_w 2105
    //   5330: aload 4
    //   5332: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5335: ifeq +268 -> 5603
    //   5338: aload 5
    //   5340: arraylength
    //   5341: iconst_1
    //   5342: if_icmpne +261 -> 5603
    //   5345: aload_0
    //   5346: aconst_null
    //   5347: putfield 1871	com/tencent/mobileqq/jsp/UiApiPlugin:E	Ljava/lang/String;
    //   5350: new 199	org/json/JSONObject
    //   5353: dup
    //   5354: aload 5
    //   5356: iconst_0
    //   5357: aaload
    //   5358: invokespecial 326	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   5361: astore_3
    //   5362: aload_0
    //   5363: aload_3
    //   5364: ldc 72
    //   5366: invokevirtual 206	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   5369: putfield 2107	com/tencent/mobileqq/jsp/UiApiPlugin:G	Ljava/lang/String;
    //   5372: aload_3
    //   5373: ldc_w 2109
    //   5376: iconst_0
    //   5377: invokevirtual 640	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   5380: istore 10
    //   5382: aload_0
    //   5383: aload_3
    //   5384: ldc_w 2111
    //   5387: iconst_0
    //   5388: invokevirtual 721	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   5391: putfield 2112	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_c_of_type_Boolean	Z
    //   5394: aload_3
    //   5395: ldc 38
    //   5397: invokevirtual 206	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   5400: astore_1
    //   5401: aload_0
    //   5402: getfield 216	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   5405: invokevirtual 739	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   5408: astore_2
    //   5409: aload_2
    //   5410: ifnull +10 -> 5420
    //   5413: aload_2
    //   5414: invokevirtual 2090	com/tencent/common/app/AppInterface:isLogin	()Z
    //   5417: ifne +20 -> 5437
    //   5420: aload_0
    //   5421: aload_1
    //   5422: iconst_1
    //   5423: anewarray 186	java/lang/String
    //   5426: dup
    //   5427: iconst_0
    //   5428: ldc_w 2114
    //   5431: aastore
    //   5432: invokevirtual 582	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   5435: iconst_1
    //   5436: ireturn
    //   5437: aload_0
    //   5438: getfield 216	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   5441: invokevirtual 221	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   5444: astore_2
    //   5445: aload_2
    //   5446: ifnull -5264 -> 182
    //   5449: iload 10
    //   5451: ifne -5269 -> 182
    //   5454: aload_3
    //   5455: ldc_w 623
    //   5458: aload_2
    //   5459: ldc_w 2115
    //   5462: invokevirtual 1533	android/app/Activity:getString	(I)Ljava/lang/String;
    //   5465: invokevirtual 1662	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   5468: astore_3
    //   5469: aload_0
    //   5470: aload_1
    //   5471: putfield 1871	com/tencent/mobileqq/jsp/UiApiPlugin:E	Ljava/lang/String;
    //   5474: aload_0
    //   5475: getfield 2112	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_c_of_type_Boolean	Z
    //   5478: ifeq +102 -> 5580
    //   5481: new 232	android/content/Intent
    //   5484: dup
    //   5485: aload_2
    //   5486: ldc_w 2117
    //   5489: invokespecial 544	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   5492: astore_1
    //   5493: aload_1
    //   5494: ldc_w 1114
    //   5497: iconst_1
    //   5498: invokevirtual 1007	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   5501: pop
    //   5502: aload_1
    //   5503: ldc_w 1116
    //   5506: aload_0
    //   5507: getfield 2107	com/tencent/mobileqq/jsp/UiApiPlugin:G	Ljava/lang/String;
    //   5510: invokevirtual 258	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   5513: pop
    //   5514: aload_1
    //   5515: ldc_w 2119
    //   5518: aload_3
    //   5519: invokevirtual 258	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   5522: pop
    //   5523: aload_0
    //   5524: aload_1
    //   5525: bipush 7
    //   5527: invokevirtual 1050	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   5530: aload_2
    //   5531: ldc_w 2120
    //   5534: ldc_w 2121
    //   5537: invokevirtual 779	android/app/Activity:overridePendingTransition	(II)V
    //   5540: goto -5358 -> 182
    //   5543: astore_1
    //   5544: invokestatic 2018	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   5547: ifeq -5365 -> 182
    //   5550: getstatic 145	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   5553: iconst_4
    //   5554: new 584	java/lang/StringBuilder
    //   5557: dup
    //   5558: invokespecial 585	java/lang/StringBuilder:<init>	()V
    //   5561: ldc_w 2123
    //   5564: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5567: aload_1
    //   5568: invokevirtual 1362	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5571: invokevirtual 592	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5574: invokestatic 305	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5577: goto -5395 -> 182
    //   5580: aload_2
    //   5581: aload_0
    //   5582: getfield 2107	com/tencent/mobileqq/jsp/UiApiPlugin:G	Ljava/lang/String;
    //   5585: bipush 8
    //   5587: invokestatic 1608	com/tencent/mobileqq/activity/TroopMemberListActivity:a	(Landroid/content/Context;Ljava/lang/String;I)Landroid/content/Intent;
    //   5590: astore_1
    //   5591: aload_1
    //   5592: ldc_w 2125
    //   5595: aload_3
    //   5596: invokevirtual 258	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   5599: pop
    //   5600: goto -77 -> 5523
    //   5603: ldc_w 2127
    //   5606: aload 4
    //   5608: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5611: ifeq +121 -> 5732
    //   5614: aload 5
    //   5616: arraylength
    //   5617: iconst_1
    //   5618: if_icmpne +114 -> 5732
    //   5621: new 199	org/json/JSONObject
    //   5624: dup
    //   5625: aload 5
    //   5627: iconst_0
    //   5628: aaload
    //   5629: invokespecial 326	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   5632: astore_1
    //   5633: aload_1
    //   5634: ldc_w 2129
    //   5637: invokevirtual 694	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5640: ifeq -5458 -> 182
    //   5643: aload_1
    //   5644: ldc_w 2129
    //   5647: invokevirtual 1991	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   5650: istore 15
    //   5652: aload_0
    //   5653: getfield 216	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   5656: invokevirtual 688	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   5659: invokevirtual 2130	com/tencent/biz/pubaccount/CustomWebView:getParent	()Landroid/view/ViewParent;
    //   5662: checkcast 939	android/view/View
    //   5665: astore_1
    //   5666: aload_1
    //   5667: instanceof 1384
    //   5670: ifne +5 -> 5675
    //   5673: iconst_1
    //   5674: ireturn
    //   5675: aload_0
    //   5676: aload_1
    //   5677: checkcast 1384	com/tencent/biz/ui/RefreshView
    //   5680: putfield 1386	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizUiRefreshView	Lcom/tencent/biz/ui/RefreshView;
    //   5683: aload_0
    //   5684: getfield 1386	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizUiRefreshView	Lcom/tencent/biz/ui/RefreshView;
    //   5687: iload 15
    //   5689: invokevirtual 2131	com/tencent/biz/ui/RefreshView:a	(Z)V
    //   5692: goto -5510 -> 182
    //   5695: astore_1
    //   5696: invokestatic 2018	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   5699: ifeq -5517 -> 182
    //   5702: getstatic 145	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   5705: iconst_4
    //   5706: new 584	java/lang/StringBuilder
    //   5709: dup
    //   5710: invokespecial 585	java/lang/StringBuilder:<init>	()V
    //   5713: ldc_w 2133
    //   5716: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5719: aload_1
    //   5720: invokevirtual 1362	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5723: invokevirtual 592	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5726: invokestatic 305	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5729: goto -5547 -> 182
    //   5732: ldc_w 1374
    //   5735: aload 4
    //   5737: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5740: ifeq +216 -> 5956
    //   5743: aload 5
    //   5745: arraylength
    //   5746: iconst_1
    //   5747: if_icmpne +209 -> 5956
    //   5750: new 199	org/json/JSONObject
    //   5753: dup
    //   5754: aload 5
    //   5756: iconst_0
    //   5757: aaload
    //   5758: invokespecial 326	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   5761: astore_1
    //   5762: aload_1
    //   5763: ldc_w 2129
    //   5766: invokevirtual 694	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5769: ifeq +83 -> 5852
    //   5772: aload_1
    //   5773: ldc_w 2129
    //   5776: invokevirtual 1991	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   5779: istore 15
    //   5781: iload 15
    //   5783: aload_0
    //   5784: getfield 2135	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_h_of_type_Boolean	Z
    //   5787: if_icmpeq -5605 -> 182
    //   5790: iload 15
    //   5792: ifeq +53 -> 5845
    //   5795: aload_0
    //   5796: invokevirtual 2136	com/tencent/mobileqq/jsp/UiApiPlugin:a	()V
    //   5799: aload_0
    //   5800: iload 15
    //   5802: putfield 2135	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_h_of_type_Boolean	Z
    //   5805: goto -5623 -> 182
    //   5808: astore_1
    //   5809: invokestatic 2018	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   5812: ifeq -5630 -> 182
    //   5815: getstatic 145	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   5818: iconst_4
    //   5819: new 584	java/lang/StringBuilder
    //   5822: dup
    //   5823: invokespecial 585	java/lang/StringBuilder:<init>	()V
    //   5826: ldc_w 2133
    //   5829: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5832: aload_1
    //   5833: invokevirtual 1362	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5836: invokevirtual 592	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5839: invokestatic 305	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5842: goto -5660 -> 182
    //   5845: aload_0
    //   5846: invokevirtual 2138	com/tencent/mobileqq/jsp/UiApiPlugin:b	()V
    //   5849: goto -50 -> 5799
    //   5852: aload_1
    //   5853: ldc_w 2140
    //   5856: invokevirtual 694	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5859: ifeq -5677 -> 182
    //   5862: aload_0
    //   5863: getfield 1025	com/tencent/mobileqq/jsp/UiApiPlugin:j	Z
    //   5866: ifeq -5684 -> 182
    //   5869: aload_0
    //   5870: iconst_0
    //   5871: putfield 1025	com/tencent/mobileqq/jsp/UiApiPlugin:j	Z
    //   5874: aload_1
    //   5875: ldc_w 2140
    //   5878: invokevirtual 1991	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   5881: istore 15
    //   5883: invokestatic 341	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   5886: invokevirtual 2141	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   5889: astore_2
    //   5890: iload 15
    //   5892: ifeq +37 -> 5929
    //   5895: aload_0
    //   5896: getfield 1394	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizUiIPullRefreshHeader	Lcom/tencent/biz/ui/IPullRefreshHeader;
    //   5899: iconst_0
    //   5900: aload_1
    //   5901: ldc_w 1618
    //   5904: aload_2
    //   5905: ldc_w 2142
    //   5908: invokevirtual 2143	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   5911: invokevirtual 1662	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   5914: invokeinterface 2148 3 0
    //   5919: aload_0
    //   5920: getfield 1386	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizUiRefreshView	Lcom/tencent/biz/ui/RefreshView;
    //   5923: invokevirtual 2149	com/tencent/biz/ui/RefreshView:c	()V
    //   5926: goto -5744 -> 182
    //   5929: aload_0
    //   5930: getfield 1394	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizUiIPullRefreshHeader	Lcom/tencent/biz/ui/IPullRefreshHeader;
    //   5933: iconst_1
    //   5934: aload_1
    //   5935: ldc_w 1618
    //   5938: aload_2
    //   5939: ldc_w 2150
    //   5942: invokevirtual 2143	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   5945: invokevirtual 1662	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   5948: invokeinterface 2148 3 0
    //   5953: goto -34 -> 5919
    //   5956: ldc_w 2152
    //   5959: aload 4
    //   5961: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5964: ifeq +193 -> 6157
    //   5967: aload 5
    //   5969: arraylength
    //   5970: iconst_1
    //   5971: if_icmpne +186 -> 6157
    //   5974: new 199	org/json/JSONObject
    //   5977: dup
    //   5978: aload 5
    //   5980: iconst_0
    //   5981: aaload
    //   5982: invokespecial 326	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   5985: astore_2
    //   5986: aload_2
    //   5987: ldc_w 2154
    //   5990: invokevirtual 715	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   5993: istore 10
    //   5995: aload_2
    //   5996: ldc_w 260
    //   5999: invokevirtual 626	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6002: astore_1
    //   6003: aload_2
    //   6004: ldc_w 283
    //   6007: invokevirtual 715	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   6010: istore 11
    //   6012: aload_0
    //   6013: aload_2
    //   6014: ldc 38
    //   6016: invokevirtual 626	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6019: putfield 1871	com/tencent/mobileqq/jsp/UiApiPlugin:E	Ljava/lang/String;
    //   6022: new 232	android/content/Intent
    //   6025: dup
    //   6026: getstatic 2157	com/tencent/common/app/BaseApplicationImpl:a	Lcom/tencent/common/app/BaseApplicationImpl;
    //   6029: ldc_w 2159
    //   6032: invokespecial 544	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   6035: astore_2
    //   6036: aload_2
    //   6037: ldc_w 2161
    //   6040: iload 10
    //   6042: invokevirtual 438	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   6045: pop
    //   6046: aload_2
    //   6047: ldc_w 2163
    //   6050: aload_1
    //   6051: invokevirtual 258	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   6054: pop
    //   6055: aload_2
    //   6056: ldc_w 2165
    //   6059: iload 11
    //   6061: invokevirtual 438	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   6064: pop
    //   6065: aload_2
    //   6066: ldc_w 2167
    //   6069: bipush 6
    //   6071: invokevirtual 2170	android/content/Intent:putExtra	(Ljava/lang/String;B)Landroid/content/Intent;
    //   6074: pop
    //   6075: aload_0
    //   6076: aload_2
    //   6077: bipush 6
    //   6079: invokevirtual 1050	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   6082: goto -5900 -> 182
    //   6085: astore_1
    //   6086: aload_1
    //   6087: invokevirtual 1759	org/json/JSONException:printStackTrace	()V
    //   6090: aload_0
    //   6091: getfield 1871	com/tencent/mobileqq/jsp/UiApiPlugin:E	Ljava/lang/String;
    //   6094: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6097: ifne -5915 -> 182
    //   6100: aload_0
    //   6101: aload_0
    //   6102: getfield 1871	com/tencent/mobileqq/jsp/UiApiPlugin:E	Ljava/lang/String;
    //   6105: iconst_1
    //   6106: anewarray 186	java/lang/String
    //   6109: dup
    //   6110: iconst_0
    //   6111: ldc_w 2172
    //   6114: aastore
    //   6115: invokevirtual 582	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   6118: goto -5936 -> 182
    //   6121: astore_1
    //   6122: aload_1
    //   6123: invokevirtual 1848	java/lang/Exception:printStackTrace	()V
    //   6126: aload_0
    //   6127: getfield 1871	com/tencent/mobileqq/jsp/UiApiPlugin:E	Ljava/lang/String;
    //   6130: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6133: ifne -5951 -> 182
    //   6136: aload_0
    //   6137: aload_0
    //   6138: getfield 1871	com/tencent/mobileqq/jsp/UiApiPlugin:E	Ljava/lang/String;
    //   6141: iconst_1
    //   6142: anewarray 186	java/lang/String
    //   6145: dup
    //   6146: iconst_0
    //   6147: ldc_w 2172
    //   6150: aastore
    //   6151: invokevirtual 582	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   6154: goto -5972 -> 182
    //   6157: ldc_w 2174
    //   6160: aload 4
    //   6162: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6165: ifeq +243 -> 6408
    //   6168: aload_0
    //   6169: getfield 216	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   6172: invokevirtual 221	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   6175: astore_1
    //   6176: aload_0
    //   6177: getfield 216	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   6180: invokevirtual 739	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   6183: astore_2
    //   6184: aload_1
    //   6185: ifnull -6003 -> 182
    //   6188: aload_2
    //   6189: ifnull -6007 -> 182
    //   6192: aconst_null
    //   6193: astore_2
    //   6194: aload_2
    //   6195: astore_1
    //   6196: new 199	org/json/JSONObject
    //   6199: dup
    //   6200: aload 5
    //   6202: iconst_0
    //   6203: aaload
    //   6204: invokespecial 326	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   6207: astore_3
    //   6208: aload_2
    //   6209: astore_1
    //   6210: aload_3
    //   6211: ldc 38
    //   6213: invokevirtual 626	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6216: astore_2
    //   6217: aload_2
    //   6218: astore_1
    //   6219: aload_3
    //   6220: ldc 72
    //   6222: invokevirtual 206	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   6225: invokestatic 2178	com/tencent/mobileqq/nearby/NearbyURLSafeUtil:b	(Ljava/lang/String;)Ljava/lang/String;
    //   6228: astore 4
    //   6230: aload_2
    //   6231: astore_1
    //   6232: aload_3
    //   6233: ldc 105
    //   6235: invokevirtual 626	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6238: astore 5
    //   6240: aload_2
    //   6241: astore_1
    //   6242: aload_3
    //   6243: ldc 111
    //   6245: invokevirtual 202	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   6248: istore 11
    //   6250: iconst_0
    //   6251: istore 10
    //   6253: aload_2
    //   6254: astore_1
    //   6255: aload_3
    //   6256: ldc_w 2180
    //   6259: invokevirtual 694	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6262: ifeq +14 -> 6276
    //   6265: aload_2
    //   6266: astore_1
    //   6267: aload_3
    //   6268: ldc_w 2180
    //   6271: invokevirtual 202	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   6274: istore 10
    //   6276: aload_2
    //   6277: astore_1
    //   6278: new 712	android/os/Bundle
    //   6281: dup
    //   6282: invokespecial 713	android/os/Bundle:<init>	()V
    //   6285: astore_3
    //   6286: aload_2
    //   6287: astore_1
    //   6288: aload_3
    //   6289: ldc 72
    //   6291: aload 4
    //   6293: invokevirtual 825	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   6296: aload 5
    //   6298: ifnull +13 -> 6311
    //   6301: aload_2
    //   6302: astore_1
    //   6303: aload_3
    //   6304: ldc 105
    //   6306: aload 5
    //   6308: invokevirtual 825	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   6311: aload_2
    //   6312: astore_1
    //   6313: aload_3
    //   6314: ldc_w 2182
    //   6317: iload 11
    //   6319: invokevirtual 848	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   6322: aload_2
    //   6323: astore_1
    //   6324: aload_3
    //   6325: ldc 102
    //   6327: ldc_w 2174
    //   6330: invokevirtual 825	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   6333: aload_2
    //   6334: astore_1
    //   6335: aload_3
    //   6336: ldc_w 2180
    //   6339: iload 10
    //   6341: invokevirtual 848	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   6344: aload_2
    //   6345: astore_1
    //   6346: ldc_w 2184
    //   6349: aload_2
    //   6350: aload_0
    //   6351: getfield 173	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver	Lcom/tencent/mobileqq/emosm/Client$onRemoteRespObserver;
    //   6354: getfield 2189	com/tencent/mobileqq/emosm/Client$onRemoteRespObserver:key	I
    //   6357: aload_3
    //   6358: invokestatic 2194	com/tencent/mobileqq/emosm/DataFactory:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   6361: astore_3
    //   6362: aload_2
    //   6363: astore_1
    //   6364: invokestatic 2199	com/tencent/mobileqq/emosm/web/WebIPCOperator:a	()Lcom/tencent/mobileqq/emosm/web/WebIPCOperator;
    //   6367: aload_3
    //   6368: invokevirtual 2202	com/tencent/mobileqq/emosm/web/WebIPCOperator:a	(Landroid/os/Bundle;)V
    //   6371: goto -6189 -> 182
    //   6374: astore_2
    //   6375: aload_1
    //   6376: ifnull -6194 -> 182
    //   6379: aload_0
    //   6380: aload_1
    //   6381: iconst_1
    //   6382: anewarray 186	java/lang/String
    //   6385: dup
    //   6386: iconst_0
    //   6387: ldc_w 2204
    //   6390: iconst_1
    //   6391: anewarray 696	java/lang/Object
    //   6394: dup
    //   6395: iconst_0
    //   6396: aload_2
    //   6397: aastore
    //   6398: invokestatic 2208	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   6401: aastore
    //   6402: invokevirtual 582	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   6405: goto -6223 -> 182
    //   6408: ldc_w 2210
    //   6411: aload 4
    //   6413: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6416: ifeq +317 -> 6733
    //   6419: aload_0
    //   6420: getfield 216	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   6423: invokevirtual 221	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   6426: astore_1
    //   6427: aload_0
    //   6428: getfield 216	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   6431: invokevirtual 739	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   6434: astore_2
    //   6435: aload_1
    //   6436: ifnull -6254 -> 182
    //   6439: aload_2
    //   6440: ifnull -6258 -> 182
    //   6443: aconst_null
    //   6444: astore_2
    //   6445: aconst_null
    //   6446: astore 4
    //   6448: aload_2
    //   6449: astore_1
    //   6450: new 199	org/json/JSONObject
    //   6453: dup
    //   6454: aload 5
    //   6456: iconst_0
    //   6457: aaload
    //   6458: invokespecial 326	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   6461: astore 6
    //   6463: aload_2
    //   6464: astore_1
    //   6465: aload 6
    //   6467: ldc 38
    //   6469: invokevirtual 626	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6472: astore_3
    //   6473: aload_3
    //   6474: astore_1
    //   6475: aload 6
    //   6477: ldc 72
    //   6479: invokevirtual 626	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6482: invokestatic 2178	com/tencent/mobileqq/nearby/NearbyURLSafeUtil:b	(Ljava/lang/String;)Ljava/lang/String;
    //   6485: astore_2
    //   6486: aload_3
    //   6487: astore_1
    //   6488: aload 6
    //   6490: ldc 75
    //   6492: invokevirtual 626	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6495: astore 5
    //   6497: iconst_0
    //   6498: istore 15
    //   6500: aload_3
    //   6501: astore_1
    //   6502: aload 5
    //   6504: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6507: ifne +3564 -> 10071
    //   6510: iconst_1
    //   6511: istore 15
    //   6513: aload 5
    //   6515: astore_2
    //   6516: aload_3
    //   6517: astore_1
    //   6518: aload 6
    //   6520: ldc 105
    //   6522: invokevirtual 626	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6525: astore 5
    //   6527: aload_3
    //   6528: astore_1
    //   6529: aload 6
    //   6531: ldc 111
    //   6533: invokevirtual 715	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   6536: istore 10
    //   6538: aload_3
    //   6539: astore_1
    //   6540: aload 6
    //   6542: ldc 16
    //   6544: invokevirtual 715	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   6547: istore 11
    //   6549: aload_3
    //   6550: astore_1
    //   6551: aload_2
    //   6552: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6555: ifne +150 -> 6705
    //   6558: aload_3
    //   6559: astore_1
    //   6560: new 712	android/os/Bundle
    //   6563: dup
    //   6564: invokespecial 713	android/os/Bundle:<init>	()V
    //   6567: astore 6
    //   6569: aload_3
    //   6570: astore_1
    //   6571: aload 6
    //   6573: ldc 111
    //   6575: iload 10
    //   6577: invokevirtual 848	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   6580: aload_3
    //   6581: astore_1
    //   6582: aload 6
    //   6584: ldc 72
    //   6586: aload_2
    //   6587: invokevirtual 825	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   6590: aload_3
    //   6591: astore_1
    //   6592: aload 6
    //   6594: ldc 78
    //   6596: iload 15
    //   6598: invokevirtual 817	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   6601: aload_3
    //   6602: astore_1
    //   6603: aload 6
    //   6605: ldc 102
    //   6607: ldc_w 2210
    //   6610: invokevirtual 825	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   6613: aload_3
    //   6614: astore_1
    //   6615: aload 6
    //   6617: ldc 16
    //   6619: iload 11
    //   6621: invokevirtual 848	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   6624: aload_3
    //   6625: astore_1
    //   6626: aload 5
    //   6628: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6631: ifne +14 -> 6645
    //   6634: aload_3
    //   6635: astore_1
    //   6636: aload 6
    //   6638: ldc 105
    //   6640: aload 5
    //   6642: invokevirtual 825	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   6645: aload_3
    //   6646: astore_1
    //   6647: ldc_w 2184
    //   6650: aload_3
    //   6651: aload_0
    //   6652: getfield 173	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver	Lcom/tencent/mobileqq/emosm/Client$onRemoteRespObserver;
    //   6655: getfield 2189	com/tencent/mobileqq/emosm/Client$onRemoteRespObserver:key	I
    //   6658: aload 6
    //   6660: invokestatic 2194	com/tencent/mobileqq/emosm/DataFactory:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   6663: astore_2
    //   6664: aload_3
    //   6665: astore_1
    //   6666: invokestatic 2199	com/tencent/mobileqq/emosm/web/WebIPCOperator:a	()Lcom/tencent/mobileqq/emosm/web/WebIPCOperator;
    //   6669: aload_2
    //   6670: invokevirtual 2202	com/tencent/mobileqq/emosm/web/WebIPCOperator:a	(Landroid/os/Bundle;)V
    //   6673: aload_3
    //   6674: astore_1
    //   6675: aload 4
    //   6677: astore_2
    //   6678: aload_2
    //   6679: ifnull -6497 -> 182
    //   6682: aload_1
    //   6683: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6686: ifne -6504 -> 182
    //   6689: aload_0
    //   6690: aload_1
    //   6691: iconst_1
    //   6692: anewarray 186	java/lang/String
    //   6695: dup
    //   6696: iconst_0
    //   6697: aload_2
    //   6698: aastore
    //   6699: invokevirtual 582	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   6702: goto -6520 -> 182
    //   6705: ldc_w 2212
    //   6708: astore_2
    //   6709: aload_3
    //   6710: astore_1
    //   6711: goto -33 -> 6678
    //   6714: astore_2
    //   6715: ldc_w 2204
    //   6718: iconst_1
    //   6719: anewarray 696	java/lang/Object
    //   6722: dup
    //   6723: iconst_0
    //   6724: aload_2
    //   6725: aastore
    //   6726: invokestatic 2208	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   6729: astore_2
    //   6730: goto -52 -> 6678
    //   6733: ldc_w 2214
    //   6736: aload 4
    //   6738: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6741: ifeq +195 -> 6936
    //   6744: aconst_null
    //   6745: astore_2
    //   6746: aload_2
    //   6747: astore_1
    //   6748: new 199	org/json/JSONObject
    //   6751: dup
    //   6752: aload 5
    //   6754: iconst_0
    //   6755: aaload
    //   6756: invokespecial 326	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   6759: astore_3
    //   6760: aload_2
    //   6761: astore_1
    //   6762: aload_3
    //   6763: ldc 38
    //   6765: invokevirtual 626	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6768: astore_2
    //   6769: aload_2
    //   6770: astore_1
    //   6771: aload_3
    //   6772: ldc_w 2129
    //   6775: invokevirtual 694	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6778: ifeq -6596 -> 182
    //   6781: aload_2
    //   6782: astore_1
    //   6783: aload_3
    //   6784: ldc_w 2129
    //   6787: invokevirtual 843	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   6790: istore 15
    //   6792: aload_2
    //   6793: astore_1
    //   6794: aload_0
    //   6795: getfield 216	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   6798: aload_0
    //   6799: getfield 216	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   6802: invokevirtual 221	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   6805: invokevirtual 265	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	(Landroid/app/Activity;)Lcom/tencent/mobileqq/webview/swift/WebUiBaseInterface;
    //   6808: astore_3
    //   6809: aload_3
    //   6810: ifnull +83 -> 6893
    //   6813: aload_2
    //   6814: astore_1
    //   6815: aload_3
    //   6816: instanceof 2216
    //   6819: ifeq +74 -> 6893
    //   6822: aload_2
    //   6823: astore_1
    //   6824: aload_3
    //   6825: checkcast 2216	com/tencent/mobileqq/webviewplugin/WebUiUtils$WebEventInterface
    //   6828: astore_3
    //   6829: iload 15
    //   6831: ifne +56 -> 6887
    //   6834: iconst_1
    //   6835: istore 15
    //   6837: aload_2
    //   6838: astore_1
    //   6839: aload_3
    //   6840: iload 15
    //   6842: invokeinterface 2217 2 0
    //   6847: goto -6665 -> 182
    //   6850: astore_2
    //   6851: aload_1
    //   6852: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6855: ifne -6673 -> 182
    //   6858: aload_0
    //   6859: aload_1
    //   6860: iconst_1
    //   6861: anewarray 186	java/lang/String
    //   6864: dup
    //   6865: iconst_0
    //   6866: ldc_w 2204
    //   6869: iconst_1
    //   6870: anewarray 696	java/lang/Object
    //   6873: dup
    //   6874: iconst_0
    //   6875: aload_2
    //   6876: aastore
    //   6877: invokestatic 2208	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   6880: aastore
    //   6881: invokevirtual 582	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   6884: goto -6702 -> 182
    //   6887: iconst_0
    //   6888: istore 15
    //   6890: goto -53 -> 6837
    //   6893: aload_2
    //   6894: astore_1
    //   6895: aload_0
    //   6896: iconst_m1
    //   6897: invokespecial 1320	com/tencent/mobileqq/webview/swift/WebViewPlugin:getBrowserComponent	(I)Ljava/lang/Object;
    //   6900: checkcast 2219	com/tencent/mobileqq/webview/swift/component/SwiftBrowserSetting
    //   6903: astore_3
    //   6904: aload_3
    //   6905: ifnull -6723 -> 182
    //   6908: iload 15
    //   6910: ifne +20 -> 6930
    //   6913: iconst_1
    //   6914: istore 15
    //   6916: aload_2
    //   6917: astore_1
    //   6918: aload_3
    //   6919: ldc_w 2221
    //   6922: iload 15
    //   6924: invokevirtual 2222	com/tencent/mobileqq/webview/swift/component/SwiftBrowserSetting:a	(Ljava/lang/String;Z)V
    //   6927: goto -6745 -> 182
    //   6930: iconst_0
    //   6931: istore 15
    //   6933: goto -17 -> 6916
    //   6936: ldc_w 2224
    //   6939: aload 4
    //   6941: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6944: ifeq +195 -> 7139
    //   6947: aconst_null
    //   6948: astore_2
    //   6949: aload_2
    //   6950: astore_1
    //   6951: new 199	org/json/JSONObject
    //   6954: dup
    //   6955: aload 5
    //   6957: iconst_0
    //   6958: aaload
    //   6959: invokespecial 326	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   6962: astore_3
    //   6963: aload_2
    //   6964: astore_1
    //   6965: aload_3
    //   6966: ldc 38
    //   6968: invokevirtual 626	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6971: astore_2
    //   6972: aload_2
    //   6973: astore_1
    //   6974: aload_3
    //   6975: ldc_w 2129
    //   6978: invokevirtual 694	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6981: ifeq -6799 -> 182
    //   6984: aload_2
    //   6985: astore_1
    //   6986: aload_3
    //   6987: ldc_w 2129
    //   6990: invokevirtual 843	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   6993: istore 15
    //   6995: aload_2
    //   6996: astore_1
    //   6997: aload_0
    //   6998: getfield 216	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   7001: aload_0
    //   7002: getfield 216	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   7005: invokevirtual 221	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   7008: invokevirtual 265	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	(Landroid/app/Activity;)Lcom/tencent/mobileqq/webview/swift/WebUiBaseInterface;
    //   7011: astore_3
    //   7012: aload_3
    //   7013: ifnull +83 -> 7096
    //   7016: aload_2
    //   7017: astore_1
    //   7018: aload_3
    //   7019: instanceof 2216
    //   7022: ifeq +74 -> 7096
    //   7025: aload_2
    //   7026: astore_1
    //   7027: aload_3
    //   7028: checkcast 2216	com/tencent/mobileqq/webviewplugin/WebUiUtils$WebEventInterface
    //   7031: astore_3
    //   7032: iload 15
    //   7034: ifne +56 -> 7090
    //   7037: iconst_1
    //   7038: istore 15
    //   7040: aload_2
    //   7041: astore_1
    //   7042: aload_3
    //   7043: iload 15
    //   7045: invokeinterface 2225 2 0
    //   7050: goto -6868 -> 182
    //   7053: astore_2
    //   7054: aload_1
    //   7055: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7058: ifne -6876 -> 182
    //   7061: aload_0
    //   7062: aload_1
    //   7063: iconst_1
    //   7064: anewarray 186	java/lang/String
    //   7067: dup
    //   7068: iconst_0
    //   7069: ldc_w 2204
    //   7072: iconst_1
    //   7073: anewarray 696	java/lang/Object
    //   7076: dup
    //   7077: iconst_0
    //   7078: aload_2
    //   7079: aastore
    //   7080: invokestatic 2208	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   7083: aastore
    //   7084: invokevirtual 582	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   7087: goto -6905 -> 182
    //   7090: iconst_0
    //   7091: istore 15
    //   7093: goto -53 -> 7040
    //   7096: aload_2
    //   7097: astore_1
    //   7098: aload_0
    //   7099: iconst_m1
    //   7100: invokespecial 1320	com/tencent/mobileqq/webview/swift/WebViewPlugin:getBrowserComponent	(I)Ljava/lang/Object;
    //   7103: checkcast 2219	com/tencent/mobileqq/webview/swift/component/SwiftBrowserSetting
    //   7106: astore_3
    //   7107: aload_3
    //   7108: ifnull -6926 -> 182
    //   7111: iload 15
    //   7113: ifne +20 -> 7133
    //   7116: iconst_1
    //   7117: istore 15
    //   7119: aload_2
    //   7120: astore_1
    //   7121: aload_3
    //   7122: ldc_w 2227
    //   7125: iload 15
    //   7127: invokevirtual 2222	com/tencent/mobileqq/webview/swift/component/SwiftBrowserSetting:a	(Ljava/lang/String;Z)V
    //   7130: goto -6948 -> 182
    //   7133: iconst_0
    //   7134: istore 15
    //   7136: goto -17 -> 7119
    //   7139: ldc_w 2229
    //   7142: aload 4
    //   7144: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7147: ifeq +221 -> 7368
    //   7150: aload_0
    //   7151: getfield 216	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   7154: invokevirtual 221	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   7157: astore 6
    //   7159: aload_0
    //   7160: getfield 216	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   7163: invokevirtual 739	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   7166: astore_1
    //   7167: aload 6
    //   7169: ifnull -6987 -> 182
    //   7172: aload_1
    //   7173: ifnull -6991 -> 182
    //   7176: aconst_null
    //   7177: astore_1
    //   7178: aconst_null
    //   7179: astore 4
    //   7181: new 199	org/json/JSONObject
    //   7184: dup
    //   7185: aload 5
    //   7187: iconst_0
    //   7188: aaload
    //   7189: invokespecial 326	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   7192: astore_3
    //   7193: aload_3
    //   7194: ldc 38
    //   7196: invokevirtual 626	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7199: astore_2
    //   7200: aload_2
    //   7201: astore_1
    //   7202: aload_3
    //   7203: ifnull +156 -> 7359
    //   7206: new 712	android/os/Bundle
    //   7209: dup
    //   7210: invokespecial 713	android/os/Bundle:<init>	()V
    //   7213: astore 5
    //   7215: aload 5
    //   7217: ldc_w 2231
    //   7220: aload_3
    //   7221: invokevirtual 294	org/json/JSONObject:toString	()Ljava/lang/String;
    //   7224: invokevirtual 825	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   7227: aload 6
    //   7229: invokevirtual 700	java/lang/Object:getClass	()Ljava/lang/Class;
    //   7232: invokevirtual 242	java/lang/Class:getName	()Ljava/lang/String;
    //   7235: ldc_w 2233
    //   7238: invokevirtual 705	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   7241: istore 15
    //   7243: aload 4
    //   7245: astore_2
    //   7246: aload_1
    //   7247: astore_3
    //   7248: iload 15
    //   7250: ifeq +41 -> 7291
    //   7253: aconst_null
    //   7254: aload 6
    //   7256: new 199	org/json/JSONObject
    //   7259: dup
    //   7260: aload 5
    //   7262: ldc_w 2231
    //   7265: invokevirtual 2234	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   7268: invokespecial 326	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   7271: ldc_w 2236
    //   7274: ldc_w 565
    //   7277: invokevirtual 1662	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   7280: invokestatic 2240	com/tencent/biz/pubaccount/subscript/SubscriptUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   7283: invokestatic 2245	com/tencent/biz/pubaccount/util/PublicAccountUtil:b	(Landroid/content/Intent;Landroid/content/Context;Ljava/lang/String;)V
    //   7286: aload_1
    //   7287: astore_3
    //   7288: aload 4
    //   7290: astore_2
    //   7291: aload_2
    //   7292: ifnull -7110 -> 182
    //   7295: aload_3
    //   7296: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7299: ifne -7117 -> 182
    //   7302: aload_0
    //   7303: aload_3
    //   7304: iconst_1
    //   7305: anewarray 186	java/lang/String
    //   7308: dup
    //   7309: iconst_0
    //   7310: aload_2
    //   7311: aastore
    //   7312: invokevirtual 582	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   7315: goto -7133 -> 182
    //   7318: astore_2
    //   7319: getstatic 145	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   7322: iconst_2
    //   7323: ldc_w 2247
    //   7326: aload_2
    //   7327: invokestatic 334	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   7330: aload 4
    //   7332: astore_2
    //   7333: aload_1
    //   7334: astore_3
    //   7335: goto -44 -> 7291
    //   7338: astore_2
    //   7339: ldc_w 2204
    //   7342: iconst_1
    //   7343: anewarray 696	java/lang/Object
    //   7346: dup
    //   7347: iconst_0
    //   7348: aload_2
    //   7349: aastore
    //   7350: invokestatic 2208	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   7353: astore_2
    //   7354: aload_1
    //   7355: astore_3
    //   7356: goto -65 -> 7291
    //   7359: ldc_w 2212
    //   7362: astore_2
    //   7363: aload_1
    //   7364: astore_3
    //   7365: goto -74 -> 7291
    //   7368: ldc_w 2249
    //   7371: aload 4
    //   7373: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7376: ifeq +498 -> 7874
    //   7379: aconst_null
    //   7380: ldc_w 1430
    //   7383: ldc_w 2251
    //   7386: ldc_w 565
    //   7389: ldc_w 1042
    //   7392: ldc_w 2253
    //   7395: iconst_0
    //   7396: iconst_1
    //   7397: iconst_0
    //   7398: aload 5
    //   7400: iconst_0
    //   7401: aaload
    //   7402: ldc_w 565
    //   7405: ldc_w 565
    //   7408: ldc_w 565
    //   7411: invokestatic 2256	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   7414: aload_0
    //   7415: getfield 216	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   7418: invokevirtual 221	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   7421: astore 6
    //   7423: aload_0
    //   7424: getfield 216	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   7427: invokevirtual 739	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   7430: astore_1
    //   7431: aload 6
    //   7433: ifnull -7251 -> 182
    //   7436: aload_1
    //   7437: ifnull -7255 -> 182
    //   7440: aconst_null
    //   7441: astore_3
    //   7442: aconst_null
    //   7443: astore 4
    //   7445: aload 4
    //   7447: astore_1
    //   7448: aload_3
    //   7449: astore_2
    //   7450: new 199	org/json/JSONObject
    //   7453: dup
    //   7454: aload 5
    //   7456: iconst_0
    //   7457: aaload
    //   7458: invokespecial 326	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   7461: astore 7
    //   7463: aload 4
    //   7465: astore_1
    //   7466: aload_3
    //   7467: astore_2
    //   7468: aload 7
    //   7470: ldc 38
    //   7472: invokevirtual 626	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7475: astore_3
    //   7476: aload 4
    //   7478: astore_1
    //   7479: aload_3
    //   7480: astore_2
    //   7481: aload 7
    //   7483: ldc 46
    //   7485: invokevirtual 626	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7488: astore 4
    //   7490: aload 4
    //   7492: astore_1
    //   7493: aload_3
    //   7494: astore_2
    //   7495: aload 7
    //   7497: ldc 102
    //   7499: invokevirtual 626	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7502: astore 8
    //   7504: aload 4
    //   7506: astore_1
    //   7507: aload_3
    //   7508: astore_2
    //   7509: aload 7
    //   7511: ldc_w 510
    //   7514: invokevirtual 784	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   7517: astore 7
    //   7519: aload 4
    //   7521: astore_1
    //   7522: aload_3
    //   7523: astore_2
    //   7524: ldc_w 1042
    //   7527: aload 8
    //   7529: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7532: ifeq +2532 -> 10064
    //   7535: aload 7
    //   7537: ifnull +2527 -> 10064
    //   7540: aload 4
    //   7542: astore_1
    //   7543: aload_3
    //   7544: astore_2
    //   7545: aload 7
    //   7547: ldc_w 623
    //   7550: invokevirtual 626	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7553: astore 8
    //   7555: aload 4
    //   7557: astore_1
    //   7558: aload_3
    //   7559: astore_2
    //   7560: aload 7
    //   7562: ldc_w 2258
    //   7565: invokevirtual 626	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7568: astore 9
    //   7570: aload 4
    //   7572: astore_1
    //   7573: aload_3
    //   7574: astore_2
    //   7575: aload 7
    //   7577: ldc_w 260
    //   7580: invokevirtual 626	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7583: astore 7
    //   7585: aload 4
    //   7587: astore_1
    //   7588: aload_3
    //   7589: astore_2
    //   7590: aload 8
    //   7592: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7595: ifne +235 -> 7830
    //   7598: aload 4
    //   7600: astore_1
    //   7601: aload_3
    //   7602: astore_2
    //   7603: aload 7
    //   7605: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7608: ifne +222 -> 7830
    //   7611: aload 4
    //   7613: astore_1
    //   7614: aload_3
    //   7615: astore_2
    //   7616: aload_0
    //   7617: getfield 2260	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   7620: ifnonnull +18 -> 7638
    //   7623: aload 4
    //   7625: astore_1
    //   7626: aload_3
    //   7627: astore_2
    //   7628: aload_0
    //   7629: aload 6
    //   7631: iconst_0
    //   7632: invokestatic 1803	com/tencent/mobileqq/utils/DialogUtil:a	(Landroid/content/Context;I)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   7635: putfield 2260	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   7638: aload 4
    //   7640: astore_1
    //   7641: aload_3
    //   7642: astore_2
    //   7643: aload_0
    //   7644: getfield 2260	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   7647: ldc_w 2261
    //   7650: invokevirtual 2263	com/tencent/mobileqq/utils/QQCustomDialog:setTitle	(I)V
    //   7653: aload 4
    //   7655: astore_1
    //   7656: aload_3
    //   7657: astore_2
    //   7658: new 2265	syr
    //   7661: dup
    //   7662: aload_0
    //   7663: aload 6
    //   7665: aload 8
    //   7667: aload 4
    //   7669: aload 7
    //   7671: aload 9
    //   7673: aload_3
    //   7674: invokespecial 2268	syr:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   7677: astore 6
    //   7679: aload 4
    //   7681: astore_1
    //   7682: aload_3
    //   7683: astore_2
    //   7684: new 2270	sys
    //   7687: dup
    //   7688: aload_0
    //   7689: aload 4
    //   7691: aload_3
    //   7692: invokespecial 2273	sys:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Ljava/lang/String;Ljava/lang/String;)V
    //   7695: astore 7
    //   7697: aload 4
    //   7699: astore_1
    //   7700: aload_3
    //   7701: astore_2
    //   7702: aload_0
    //   7703: getfield 2260	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   7706: ldc_w 1822
    //   7709: aload 6
    //   7711: invokevirtual 2276	com/tencent/mobileqq/utils/QQCustomDialog:setPositiveButton	(ILandroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   7714: pop
    //   7715: aload 4
    //   7717: astore_1
    //   7718: aload_3
    //   7719: astore_2
    //   7720: aload_0
    //   7721: getfield 2260	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   7724: ldc_w 1817
    //   7727: aload 6
    //   7729: invokevirtual 2278	com/tencent/mobileqq/utils/QQCustomDialog:setNegativeButton	(ILandroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   7732: pop
    //   7733: aload 4
    //   7735: astore_1
    //   7736: aload_3
    //   7737: astore_2
    //   7738: aload_0
    //   7739: getfield 2260	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   7742: aload 7
    //   7744: invokevirtual 1829	com/tencent/mobileqq/utils/QQCustomDialog:setOnCancelListener	(Landroid/content/DialogInterface$OnCancelListener;)V
    //   7747: aload 4
    //   7749: astore_1
    //   7750: aload_3
    //   7751: astore_2
    //   7752: aload_0
    //   7753: getfield 2260	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   7756: invokevirtual 1830	com/tencent/mobileqq/utils/QQCustomDialog:show	()V
    //   7759: aload 4
    //   7761: astore_1
    //   7762: aload_3
    //   7763: astore_2
    //   7764: aconst_null
    //   7765: ldc_w 1430
    //   7768: ldc_w 2251
    //   7771: ldc_w 565
    //   7774: ldc_w 1042
    //   7777: ldc_w 2280
    //   7780: iconst_0
    //   7781: iconst_1
    //   7782: iconst_0
    //   7783: aload 5
    //   7785: iconst_0
    //   7786: aaload
    //   7787: ldc_w 565
    //   7790: ldc_w 565
    //   7793: ldc_w 565
    //   7796: invokestatic 2256	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   7799: aconst_null
    //   7800: astore_1
    //   7801: aload_3
    //   7802: astore_2
    //   7803: aload_1
    //   7804: ifnull -7622 -> 182
    //   7807: aload_2
    //   7808: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7811: ifne -7629 -> 182
    //   7814: aload_0
    //   7815: aload_2
    //   7816: iconst_1
    //   7817: anewarray 186	java/lang/String
    //   7820: dup
    //   7821: iconst_0
    //   7822: aload_1
    //   7823: aastore
    //   7824: invokevirtual 582	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   7827: goto -7645 -> 182
    //   7830: aload 4
    //   7832: astore_1
    //   7833: aload_3
    //   7834: astore_2
    //   7835: ldc_w 1895
    //   7838: aconst_null
    //   7839: ldc_w 2282
    //   7842: aload 4
    //   7844: invokestatic 2284	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   7847: astore 4
    //   7849: aload 4
    //   7851: astore_1
    //   7852: aload_3
    //   7853: astore_2
    //   7854: goto -51 -> 7803
    //   7857: astore_3
    //   7858: ldc_w 2286
    //   7861: aconst_null
    //   7862: aload_3
    //   7863: invokevirtual 2287	java/lang/Exception:toString	()Ljava/lang/String;
    //   7866: aload_1
    //   7867: invokestatic 2284	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   7870: astore_1
    //   7871: goto -68 -> 7803
    //   7874: ldc_w 2289
    //   7877: aload 4
    //   7879: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7882: ifeq +314 -> 8196
    //   7885: aload 5
    //   7887: arraylength
    //   7888: ifle +308 -> 8196
    //   7891: invokestatic 300	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7894: ifeq +52 -> 7946
    //   7897: new 584	java/lang/StringBuilder
    //   7900: dup
    //   7901: invokespecial 585	java/lang/StringBuilder:<init>	()V
    //   7904: getstatic 145	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   7907: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7910: ldc_w 2291
    //   7913: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7916: invokevirtual 592	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7919: iconst_2
    //   7920: new 584	java/lang/StringBuilder
    //   7923: dup
    //   7924: invokespecial 585	java/lang/StringBuilder:<init>	()V
    //   7927: ldc_w 2293
    //   7930: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7933: aload 5
    //   7935: iconst_0
    //   7936: aaload
    //   7937: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7940: invokevirtual 592	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7943: invokestatic 305	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7946: new 199	org/json/JSONObject
    //   7949: dup
    //   7950: aload 5
    //   7952: iconst_0
    //   7953: aaload
    //   7954: invokespecial 326	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   7957: ldc_w 260
    //   7960: invokevirtual 626	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7963: astore_1
    //   7964: aload_1
    //   7965: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7968: ifne -7786 -> 182
    //   7971: aload_1
    //   7972: ldc_w 2295
    //   7975: invokevirtual 2299	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   7978: astore_2
    //   7979: new 1513	java/util/HashMap
    //   7982: dup
    //   7983: invokespecial 2300	java/util/HashMap:<init>	()V
    //   7986: astore_1
    //   7987: aload_2
    //   7988: arraylength
    //   7989: iconst_1
    //   7990: if_icmple -7808 -> 182
    //   7993: aload_2
    //   7994: iconst_1
    //   7995: aaload
    //   7996: ldc_w 2302
    //   7999: invokevirtual 2299	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   8002: astore_2
    //   8003: iconst_0
    //   8004: istore 10
    //   8006: aload_2
    //   8007: arraylength
    //   8008: istore 11
    //   8010: iload 10
    //   8012: iload 11
    //   8014: if_icmpge +49 -> 8063
    //   8017: aload_2
    //   8018: iload 10
    //   8020: aaload
    //   8021: bipush 61
    //   8023: invokevirtual 2304	java/lang/String:indexOf	(I)I
    //   8026: istore 12
    //   8028: iload 12
    //   8030: iconst_m1
    //   8031: if_icmpeq +2096 -> 10127
    //   8034: aload_1
    //   8035: aload_2
    //   8036: iload 10
    //   8038: aaload
    //   8039: iconst_0
    //   8040: iload 12
    //   8042: invokevirtual 329	java/lang/String:substring	(II)Ljava/lang/String;
    //   8045: aload_2
    //   8046: iload 10
    //   8048: aaload
    //   8049: iload 12
    //   8051: iconst_1
    //   8052: iadd
    //   8053: invokevirtual 320	java/lang/String:substring	(I)Ljava/lang/String;
    //   8056: invokevirtual 2307	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   8059: pop
    //   8060: goto +2067 -> 10127
    //   8063: aload_0
    //   8064: aload_1
    //   8065: ldc_w 1116
    //   8068: invokevirtual 2308	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   8071: checkcast 186	java/lang/String
    //   8074: aload_1
    //   8075: ldc_w 2310
    //   8078: invokevirtual 2308	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   8081: checkcast 186	java/lang/String
    //   8084: invokespecial 2312	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   8087: ifne -7905 -> 182
    //   8090: invokestatic 300	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8093: ifeq +32 -> 8125
    //   8096: new 584	java/lang/StringBuilder
    //   8099: dup
    //   8100: invokespecial 585	java/lang/StringBuilder:<init>	()V
    //   8103: getstatic 145	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   8106: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8109: ldc_w 2291
    //   8112: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8115: invokevirtual 592	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8118: iconst_2
    //   8119: ldc_w 1688
    //   8122: invokestatic 305	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8125: aload_0
    //   8126: aload 5
    //   8128: iconst_0
    //   8129: aaload
    //   8130: iconst_0
    //   8131: invokespecial 1693	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Ljava/lang/String;Z)V
    //   8134: goto -7952 -> 182
    //   8137: astore_1
    //   8138: invokestatic 300	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8141: ifeq -7959 -> 182
    //   8144: new 584	java/lang/StringBuilder
    //   8147: dup
    //   8148: invokespecial 585	java/lang/StringBuilder:<init>	()V
    //   8151: getstatic 145	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   8154: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8157: ldc_w 2291
    //   8160: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8163: invokevirtual 592	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8166: iconst_2
    //   8167: new 584	java/lang/StringBuilder
    //   8170: dup
    //   8171: invokespecial 585	java/lang/StringBuilder:<init>	()V
    //   8174: ldc_w 2314
    //   8177: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8180: aload 5
    //   8182: iconst_0
    //   8183: aaload
    //   8184: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8187: invokevirtual 592	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8190: invokestatic 305	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8193: goto -8011 -> 182
    //   8196: ldc_w 2316
    //   8199: aload 4
    //   8201: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8204: ifeq +67 -> 8271
    //   8207: aload 5
    //   8209: arraylength
    //   8210: ifle +61 -> 8271
    //   8213: aload_0
    //   8214: new 199	org/json/JSONObject
    //   8217: dup
    //   8218: aload 5
    //   8220: iconst_0
    //   8221: aaload
    //   8222: invokespecial 326	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8225: invokespecial 2318	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;)V
    //   8228: goto -8046 -> 182
    //   8231: astore_1
    //   8232: invokestatic 300	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8235: ifeq -8053 -> 182
    //   8238: getstatic 145	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   8241: iconst_2
    //   8242: new 584	java/lang/StringBuilder
    //   8245: dup
    //   8246: invokespecial 585	java/lang/StringBuilder:<init>	()V
    //   8249: ldc_w 2320
    //   8252: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8255: aload 5
    //   8257: iconst_0
    //   8258: aaload
    //   8259: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8262: invokevirtual 592	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8265: invokestatic 305	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8268: goto -8086 -> 182
    //   8271: ldc_w 2322
    //   8274: aload 4
    //   8276: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8279: ifeq +10 -> 8289
    //   8282: aload_0
    //   8283: invokespecial 2323	com/tencent/mobileqq/jsp/UiApiPlugin:c	()V
    //   8286: goto -8104 -> 182
    //   8289: ldc_w 2325
    //   8292: aload 4
    //   8294: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8297: ifeq +72 -> 8369
    //   8300: aload 5
    //   8302: arraylength
    //   8303: ifle +66 -> 8369
    //   8306: aload_0
    //   8307: new 199	org/json/JSONObject
    //   8310: dup
    //   8311: aload 5
    //   8313: iconst_0
    //   8314: aaload
    //   8315: invokespecial 326	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8318: ldc 38
    //   8320: invokevirtual 626	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8323: invokespecial 2326	com/tencent/mobileqq/jsp/UiApiPlugin:b	(Ljava/lang/String;)V
    //   8326: goto -8144 -> 182
    //   8329: astore_1
    //   8330: invokestatic 300	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8333: ifeq -8151 -> 182
    //   8336: getstatic 145	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   8339: iconst_2
    //   8340: new 584	java/lang/StringBuilder
    //   8343: dup
    //   8344: invokespecial 585	java/lang/StringBuilder:<init>	()V
    //   8347: ldc_w 2328
    //   8350: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8353: aload 5
    //   8355: iconst_0
    //   8356: aaload
    //   8357: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8360: invokevirtual 592	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8363: invokestatic 305	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8366: goto -8184 -> 182
    //   8369: ldc_w 2330
    //   8372: aload 4
    //   8374: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8377: ifeq +114 -> 8491
    //   8380: new 199	org/json/JSONObject
    //   8383: dup
    //   8384: aload 5
    //   8386: iconst_0
    //   8387: aaload
    //   8388: invokespecial 326	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8391: astore_1
    //   8392: aload_0
    //   8393: invokespecial 1519	com/tencent/mobileqq/jsp/UiApiPlugin:a	()Lcom/tencent/mobileqq/webviewplugin/WebUiUtils$WebTitleBarInterface;
    //   8396: astore_2
    //   8397: aload_2
    //   8398: ifnull -8216 -> 182
    //   8401: aload_2
    //   8402: aload_1
    //   8403: invokeinterface 2331 2 0
    //   8408: goto -8226 -> 182
    //   8411: astore_1
    //   8412: invokestatic 300	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8415: ifeq -8233 -> 182
    //   8418: getstatic 145	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   8421: iconst_2
    //   8422: new 584	java/lang/StringBuilder
    //   8425: dup
    //   8426: invokespecial 585	java/lang/StringBuilder:<init>	()V
    //   8429: ldc_w 2333
    //   8432: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8435: aload_1
    //   8436: invokevirtual 2334	org/json/JSONException:toString	()Ljava/lang/String;
    //   8439: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8442: invokevirtual 592	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8445: invokestatic 305	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8448: goto -8266 -> 182
    //   8451: astore_1
    //   8452: invokestatic 300	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8455: ifeq -8273 -> 182
    //   8458: getstatic 145	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   8461: iconst_2
    //   8462: new 584	java/lang/StringBuilder
    //   8465: dup
    //   8466: invokespecial 585	java/lang/StringBuilder:<init>	()V
    //   8469: ldc_w 2333
    //   8472: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8475: aload_1
    //   8476: invokevirtual 2287	java/lang/Exception:toString	()Ljava/lang/String;
    //   8479: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8482: invokevirtual 592	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8485: invokestatic 305	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8488: goto -8306 -> 182
    //   8491: ldc_w 2336
    //   8494: aload 4
    //   8496: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8499: ifeq +197 -> 8696
    //   8502: aload 5
    //   8504: arraylength
    //   8505: ifle +191 -> 8696
    //   8508: new 199	org/json/JSONObject
    //   8511: dup
    //   8512: aload 5
    //   8514: iconst_0
    //   8515: aaload
    //   8516: invokespecial 326	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8519: ldc 38
    //   8521: invokevirtual 626	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8524: astore_1
    //   8525: aload_1
    //   8526: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8529: ifeq +15 -> 8544
    //   8532: getstatic 145	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   8535: iconst_1
    //   8536: ldc_w 2338
    //   8539: invokestatic 578	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   8542: iconst_1
    //   8543: ireturn
    //   8544: new 199	org/json/JSONObject
    //   8547: dup
    //   8548: invokespecial 281	org/json/JSONObject:<init>	()V
    //   8551: astore_2
    //   8552: new 199	org/json/JSONObject
    //   8555: dup
    //   8556: invokespecial 281	org/json/JSONObject:<init>	()V
    //   8559: astore_3
    //   8560: aload_0
    //   8561: getfield 216	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   8564: invokevirtual 221	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   8567: invokevirtual 365	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   8570: ldc_w 1627
    //   8573: invokevirtual 1206	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   8576: istore 11
    //   8578: iload 11
    //   8580: istore 10
    //   8582: invokestatic 1446	com/tencent/widget/immersive/ImmersiveUtils:isSupporImmersive	()I
    //   8585: iconst_1
    //   8586: if_icmpne +18 -> 8604
    //   8589: iload 11
    //   8591: aload_0
    //   8592: getfield 216	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   8595: invokevirtual 221	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   8598: invokestatic 1448	com/tencent/widget/immersive/ImmersiveUtils:a	(Landroid/content/Context;)I
    //   8601: iadd
    //   8602: istore 10
    //   8604: aload_3
    //   8605: ldc_w 2340
    //   8608: iload 10
    //   8610: invokevirtual 2343	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   8613: pop
    //   8614: aload_2
    //   8615: ldc_w 2345
    //   8618: iconst_0
    //   8619: invokevirtual 2343	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   8622: pop
    //   8623: aload_2
    //   8624: ldc_w 291
    //   8627: ldc_w 2347
    //   8630: invokevirtual 287	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   8633: pop
    //   8634: aload_2
    //   8635: ldc_w 510
    //   8638: aload_3
    //   8639: invokevirtual 287	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   8642: pop
    //   8643: aload_0
    //   8644: aload_1
    //   8645: iconst_1
    //   8646: anewarray 186	java/lang/String
    //   8649: dup
    //   8650: iconst_0
    //   8651: aload_2
    //   8652: invokevirtual 294	org/json/JSONObject:toString	()Ljava/lang/String;
    //   8655: aastore
    //   8656: invokevirtual 582	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   8659: goto -8477 -> 182
    //   8662: astore_1
    //   8663: getstatic 145	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   8666: iconst_1
    //   8667: new 584	java/lang/StringBuilder
    //   8670: dup
    //   8671: invokespecial 585	java/lang/StringBuilder:<init>	()V
    //   8674: ldc_w 2349
    //   8677: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8680: aload_1
    //   8681: invokestatic 1738	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   8684: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8687: invokevirtual 592	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8690: invokestatic 578	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   8693: goto -8511 -> 182
    //   8696: ldc_w 2351
    //   8699: aload 4
    //   8701: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8704: ifeq +77 -> 8781
    //   8707: new 199	org/json/JSONObject
    //   8710: dup
    //   8711: aload 5
    //   8713: iconst_0
    //   8714: aaload
    //   8715: invokespecial 326	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8718: astore_1
    //   8719: aload_1
    //   8720: ldc_w 854
    //   8723: invokevirtual 626	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8726: astore_2
    //   8727: aload_0
    //   8728: aload_1
    //   8729: ldc 38
    //   8731: invokevirtual 626	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8734: putfield 279	com/tencent/mobileqq/jsp/UiApiPlugin:I	Ljava/lang/String;
    //   8737: aload_0
    //   8738: getfield 158	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   8741: ifnonnull +17 -> 8758
    //   8744: aload_0
    //   8745: invokestatic 1074	com/tencent/biz/troop/TroopMemberApiClient:a	()Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   8748: putfield 158	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   8751: aload_0
    //   8752: getfield 158	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   8755: invokevirtual 1076	com/tencent/biz/troop/TroopMemberApiClient:a	()V
    //   8758: aload_0
    //   8759: getfield 158	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   8762: aload_2
    //   8763: new 2353	syt
    //   8766: dup
    //   8767: aload_0
    //   8768: aload_2
    //   8769: invokespecial 2354	syt:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Ljava/lang/String;)V
    //   8772: invokevirtual 2357	com/tencent/biz/troop/TroopMemberApiClient:b	(Ljava/lang/String;Lcom/tencent/biz/troop/TroopMemberApiClient$Callback;)V
    //   8775: goto -8593 -> 182
    //   8778: astore_1
    //   8779: iconst_1
    //   8780: ireturn
    //   8781: ldc_w 2359
    //   8784: aload 4
    //   8786: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8789: ifeq +482 -> 9271
    //   8792: aload 5
    //   8794: arraylength
    //   8795: iconst_1
    //   8796: if_icmpne +475 -> 9271
    //   8799: new 199	org/json/JSONObject
    //   8802: dup
    //   8803: aload 5
    //   8805: iconst_0
    //   8806: aaload
    //   8807: invokespecial 326	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8810: astore_3
    //   8811: aload_3
    //   8812: ldc_w 2361
    //   8815: invokevirtual 626	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8818: astore 4
    //   8820: aload_3
    //   8821: ldc_w 2363
    //   8824: invokevirtual 626	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8827: astore_1
    //   8828: aload_1
    //   8829: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8832: ifeq +41 -> 8873
    //   8835: invokestatic 300	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8838: ifeq +1298 -> 10136
    //   8841: new 584	java/lang/StringBuilder
    //   8844: dup
    //   8845: invokespecial 585	java/lang/StringBuilder:<init>	()V
    //   8848: getstatic 145	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   8851: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8854: ldc_w 2365
    //   8857: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8860: invokevirtual 592	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8863: iconst_2
    //   8864: ldc_w 2367
    //   8867: invokestatic 305	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8870: goto +1266 -> 10136
    //   8873: aload_0
    //   8874: getfield 216	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   8877: invokevirtual 688	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   8880: astore_2
    //   8881: aload_2
    //   8882: ifnull +10 -> 8892
    //   8885: aload_2
    //   8886: invokevirtual 2370	com/tencent/biz/pubaccount/CustomWebView:a	()Lcom/tencent/biz/pubaccount/CustomWebView$OpenApiTokenInfo;
    //   8889: ifnonnull +41 -> 8930
    //   8892: invokestatic 300	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8895: ifeq +1243 -> 10138
    //   8898: new 584	java/lang/StringBuilder
    //   8901: dup
    //   8902: invokespecial 585	java/lang/StringBuilder:<init>	()V
    //   8905: getstatic 145	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   8908: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8911: ldc_w 2365
    //   8914: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8917: invokevirtual 592	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8920: iconst_2
    //   8921: ldc_w 2372
    //   8924: invokestatic 305	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8927: goto +1211 -> 10138
    //   8930: aload_2
    //   8931: invokevirtual 2370	com/tencent/biz/pubaccount/CustomWebView:a	()Lcom/tencent/biz/pubaccount/CustomWebView$OpenApiTokenInfo;
    //   8934: getfield 2375	com/tencent/biz/pubaccount/CustomWebView$OpenApiTokenInfo:jdField_a_of_type_Int	I
    //   8937: invokestatic 2378	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   8940: astore_2
    //   8941: aload_3
    //   8942: ldc_w 2109
    //   8945: invokevirtual 715	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   8948: istore 10
    //   8950: iload 10
    //   8952: iconst_1
    //   8953: if_icmpne +228 -> 9181
    //   8956: new 2380	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   8959: dup
    //   8960: invokespecial 2381	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   8963: astore_3
    //   8964: aload_3
    //   8965: getfield 2384	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_command	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   8968: sipush 1814
    //   8971: invokevirtual 478	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   8974: aload_3
    //   8975: getfield 2387	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_service_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   8978: bipush 48
    //   8980: invokevirtual 478	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   8983: aload_1
    //   8984: invokevirtual 2390	java/lang/String:getBytes	()[B
    //   8987: arraylength
    //   8988: bipush 6
    //   8990: iadd
    //   8991: invokestatic 2396	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   8994: astore 4
    //   8996: aload 4
    //   8998: aload_2
    //   8999: invokevirtual 1548	java/lang/Integer:intValue	()I
    //   9002: invokevirtual 2398	java/nio/ByteBuffer:putInt	(I)Ljava/nio/ByteBuffer;
    //   9005: pop
    //   9006: aload 4
    //   9008: aload_1
    //   9009: invokevirtual 2390	java/lang/String:getBytes	()[B
    //   9012: arraylength
    //   9013: i2s
    //   9014: invokevirtual 2402	java/nio/ByteBuffer:putShort	(S)Ljava/nio/ByteBuffer;
    //   9017: pop
    //   9018: aload 4
    //   9020: aload_1
    //   9021: invokevirtual 2390	java/lang/String:getBytes	()[B
    //   9024: invokevirtual 2405	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   9027: pop
    //   9028: aload_3
    //   9029: getfield 2409	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   9032: aload 4
    //   9034: invokevirtual 2412	java/nio/ByteBuffer:array	()[B
    //   9037: invokestatic 2418	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   9040: invokevirtual 2423	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   9043: new 494	mqq/app/NewIntent
    //   9046: dup
    //   9047: aload_0
    //   9048: invokespecial 229	com/tencent/mobileqq/jsp/UiApiPlugin:a	()Landroid/content/Context;
    //   9051: ldc_w 496
    //   9054: invokespecial 499	mqq/app/NewIntent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   9057: astore_2
    //   9058: new 712	android/os/Bundle
    //   9061: dup
    //   9062: invokespecial 713	android/os/Bundle:<init>	()V
    //   9065: astore 4
    //   9067: aload 4
    //   9069: ldc_w 2363
    //   9072: aload_1
    //   9073: invokevirtual 825	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   9076: aload_2
    //   9077: aload 4
    //   9079: invokevirtual 2424	mqq/app/NewIntent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   9082: pop
    //   9083: aload_2
    //   9084: ldc_w 505
    //   9087: ldc_w 2426
    //   9090: invokevirtual 508	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   9093: pop
    //   9094: aload_2
    //   9095: ldc_w 510
    //   9098: aload_3
    //   9099: invokevirtual 2427	tencent/im/oidb/oidb_sso$OIDBSSOPkg:toByteArray	()[B
    //   9102: invokevirtual 517	mqq/app/NewIntent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   9105: pop
    //   9106: aload_2
    //   9107: ldc_w 2429
    //   9110: iconst_1
    //   9111: invokevirtual 2430	mqq/app/NewIntent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   9114: pop
    //   9115: aload_2
    //   9116: new 2432	syu
    //   9119: dup
    //   9120: aload_0
    //   9121: invokespecial 2433	syu:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;)V
    //   9124: invokevirtual 526	mqq/app/NewIntent:setObserver	(Lmqq/observer/BusinessObserver;)V
    //   9127: aload_0
    //   9128: getfield 216	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   9131: invokevirtual 739	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   9134: aload_2
    //   9135: invokevirtual 532	com/tencent/common/app/AppInterface:startServlet	(Lmqq/app/NewIntent;)V
    //   9138: goto -8956 -> 182
    //   9141: astore_1
    //   9142: invokestatic 300	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9145: ifeq -8963 -> 182
    //   9148: getstatic 145	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   9151: iconst_2
    //   9152: new 584	java/lang/StringBuilder
    //   9155: dup
    //   9156: invokespecial 585	java/lang/StringBuilder:<init>	()V
    //   9159: ldc_w 2435
    //   9162: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9165: aload 5
    //   9167: iconst_0
    //   9168: aaload
    //   9169: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9172: invokevirtual 592	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9175: invokestatic 305	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   9178: goto -8996 -> 182
    //   9181: iload 10
    //   9183: ifne -9001 -> 182
    //   9186: aload_0
    //   9187: getfield 158	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   9190: ifnonnull +17 -> 9207
    //   9193: aload_0
    //   9194: invokestatic 1074	com/tencent/biz/troop/TroopMemberApiClient:a	()Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   9197: putfield 158	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   9200: aload_0
    //   9201: getfield 158	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   9204: invokevirtual 1076	com/tencent/biz/troop/TroopMemberApiClient:a	()V
    //   9207: aload_0
    //   9208: getfield 158	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   9211: aload_2
    //   9212: aload_1
    //   9213: aload 4
    //   9215: new 2437	syv
    //   9218: dup
    //   9219: aload_0
    //   9220: aload_2
    //   9221: aload_1
    //   9222: invokespecial 2440	syv:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Ljava/lang/Integer;Ljava/lang/String;)V
    //   9225: invokevirtual 2443	com/tencent/biz/troop/TroopMemberApiClient:a	(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/biz/troop/TroopMemberApiClient$Callback;)V
    //   9228: goto -9046 -> 182
    //   9231: astore_1
    //   9232: invokestatic 300	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9235: ifeq -9053 -> 182
    //   9238: getstatic 145	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   9241: iconst_2
    //   9242: new 584	java/lang/StringBuilder
    //   9245: dup
    //   9246: invokespecial 585	java/lang/StringBuilder:<init>	()V
    //   9249: ldc_w 2445
    //   9252: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9255: aload 5
    //   9257: iconst_0
    //   9258: aaload
    //   9259: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9262: invokevirtual 592	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9265: invokestatic 305	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   9268: goto -9086 -> 182
    //   9271: ldc_w 2447
    //   9274: aload 4
    //   9276: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9279: ifeq +515 -> 9794
    //   9282: aload 5
    //   9284: arraylength
    //   9285: iconst_1
    //   9286: if_icmpne +508 -> 9794
    //   9289: invokestatic 300	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9292: ifeq +52 -> 9344
    //   9295: new 584	java/lang/StringBuilder
    //   9298: dup
    //   9299: invokespecial 585	java/lang/StringBuilder:<init>	()V
    //   9302: getstatic 145	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   9305: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9308: ldc_w 2365
    //   9311: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9314: invokevirtual 592	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9317: iconst_2
    //   9318: new 584	java/lang/StringBuilder
    //   9321: dup
    //   9322: invokespecial 585	java/lang/StringBuilder:<init>	()V
    //   9325: ldc_w 2449
    //   9328: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9331: aload 5
    //   9333: iconst_0
    //   9334: aaload
    //   9335: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9338: invokevirtual 592	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9341: invokestatic 305	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   9344: new 199	org/json/JSONObject
    //   9347: dup
    //   9348: aload 5
    //   9350: iconst_0
    //   9351: aaload
    //   9352: invokespecial 326	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   9355: astore_3
    //   9356: aload_3
    //   9357: ldc_w 2361
    //   9360: invokevirtual 626	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9363: astore_1
    //   9364: aload_3
    //   9365: ldc_w 2363
    //   9368: invokevirtual 626	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9371: astore_2
    //   9372: aload_3
    //   9373: ldc_w 2451
    //   9376: invokevirtual 626	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9379: astore_3
    //   9380: aload_2
    //   9381: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9384: ifne +10 -> 9394
    //   9387: aload_3
    //   9388: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9391: ifeq +68 -> 9459
    //   9394: invokestatic 300	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9397: ifeq +743 -> 10140
    //   9400: new 584	java/lang/StringBuilder
    //   9403: dup
    //   9404: invokespecial 585	java/lang/StringBuilder:<init>	()V
    //   9407: getstatic 145	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   9410: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9413: ldc_w 2365
    //   9416: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9419: invokevirtual 592	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9422: iconst_2
    //   9423: new 584	java/lang/StringBuilder
    //   9426: dup
    //   9427: invokespecial 585	java/lang/StringBuilder:<init>	()V
    //   9430: ldc_w 2453
    //   9433: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9436: aload_3
    //   9437: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9440: ldc_w 2455
    //   9443: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9446: aload_2
    //   9447: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9450: invokevirtual 592	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9453: invokestatic 305	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   9456: goto +684 -> 10140
    //   9459: aload_0
    //   9460: getfield 216	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   9463: invokevirtual 688	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   9466: astore 4
    //   9468: aload 4
    //   9470: ifnull +11 -> 9481
    //   9473: aload 4
    //   9475: invokevirtual 2370	com/tencent/biz/pubaccount/CustomWebView:a	()Lcom/tencent/biz/pubaccount/CustomWebView$OpenApiTokenInfo;
    //   9478: ifnonnull +41 -> 9519
    //   9481: invokestatic 300	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9484: ifeq +658 -> 10142
    //   9487: new 584	java/lang/StringBuilder
    //   9490: dup
    //   9491: invokespecial 585	java/lang/StringBuilder:<init>	()V
    //   9494: getstatic 145	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   9497: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9500: ldc_w 2365
    //   9503: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9506: invokevirtual 592	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9509: iconst_2
    //   9510: ldc_w 2457
    //   9513: invokestatic 305	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   9516: goto +626 -> 10142
    //   9519: aload 4
    //   9521: invokevirtual 2370	com/tencent/biz/pubaccount/CustomWebView:a	()Lcom/tencent/biz/pubaccount/CustomWebView$OpenApiTokenInfo;
    //   9524: getfield 2375	com/tencent/biz/pubaccount/CustomWebView$OpenApiTokenInfo:jdField_a_of_type_Int	I
    //   9527: invokestatic 2378	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   9530: astore 4
    //   9532: new 2380	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   9535: dup
    //   9536: invokespecial 2381	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   9539: astore 6
    //   9541: aload 6
    //   9543: getfield 2384	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_command	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9546: sipush 1814
    //   9549: invokevirtual 478	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   9552: aload 6
    //   9554: getfield 2387	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_service_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9557: bipush 48
    //   9559: invokevirtual 478	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   9562: aload_3
    //   9563: invokevirtual 2390	java/lang/String:getBytes	()[B
    //   9566: arraylength
    //   9567: bipush 6
    //   9569: iadd
    //   9570: invokestatic 2396	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   9573: astore 7
    //   9575: aload 7
    //   9577: aload 4
    //   9579: invokevirtual 1548	java/lang/Integer:intValue	()I
    //   9582: invokevirtual 2398	java/nio/ByteBuffer:putInt	(I)Ljava/nio/ByteBuffer;
    //   9585: pop
    //   9586: aload 7
    //   9588: aload_3
    //   9589: invokevirtual 2390	java/lang/String:getBytes	()[B
    //   9592: arraylength
    //   9593: i2s
    //   9594: invokevirtual 2402	java/nio/ByteBuffer:putShort	(S)Ljava/nio/ByteBuffer;
    //   9597: pop
    //   9598: aload 7
    //   9600: aload_3
    //   9601: invokevirtual 2390	java/lang/String:getBytes	()[B
    //   9604: invokevirtual 2405	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   9607: pop
    //   9608: aload 6
    //   9610: getfield 2409	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   9613: aload 7
    //   9615: invokevirtual 2412	java/nio/ByteBuffer:array	()[B
    //   9618: invokestatic 2418	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   9621: invokevirtual 2423	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   9624: new 494	mqq/app/NewIntent
    //   9627: dup
    //   9628: aload_0
    //   9629: invokespecial 229	com/tencent/mobileqq/jsp/UiApiPlugin:a	()Landroid/content/Context;
    //   9632: ldc_w 496
    //   9635: invokespecial 499	mqq/app/NewIntent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   9638: astore_3
    //   9639: aload_3
    //   9640: new 712	android/os/Bundle
    //   9643: dup
    //   9644: invokespecial 713	android/os/Bundle:<init>	()V
    //   9647: invokevirtual 2424	mqq/app/NewIntent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   9650: pop
    //   9651: aload_3
    //   9652: ldc_w 505
    //   9655: ldc_w 2426
    //   9658: invokevirtual 508	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   9661: pop
    //   9662: aload_3
    //   9663: ldc_w 510
    //   9666: aload 6
    //   9668: invokevirtual 2427	tencent/im/oidb/oidb_sso$OIDBSSOPkg:toByteArray	()[B
    //   9671: invokevirtual 517	mqq/app/NewIntent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   9674: pop
    //   9675: aload_3
    //   9676: ldc_w 2429
    //   9679: iconst_1
    //   9680: invokevirtual 2430	mqq/app/NewIntent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   9683: pop
    //   9684: aload_3
    //   9685: new 2459	syf
    //   9688: dup
    //   9689: aload_0
    //   9690: aload 4
    //   9692: aload_2
    //   9693: aload_1
    //   9694: invokespecial 2462	syf:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V
    //   9697: invokevirtual 526	mqq/app/NewIntent:setObserver	(Lmqq/observer/BusinessObserver;)V
    //   9700: aload_0
    //   9701: getfield 216	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   9704: invokevirtual 739	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   9707: aload_3
    //   9708: invokevirtual 532	com/tencent/common/app/AppInterface:startServlet	(Lmqq/app/NewIntent;)V
    //   9711: goto -9529 -> 182
    //   9714: astore_1
    //   9715: invokestatic 300	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9718: ifeq -9536 -> 182
    //   9721: getstatic 145	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   9724: iconst_2
    //   9725: new 584	java/lang/StringBuilder
    //   9728: dup
    //   9729: invokespecial 585	java/lang/StringBuilder:<init>	()V
    //   9732: ldc_w 2435
    //   9735: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9738: aload 5
    //   9740: iconst_0
    //   9741: aaload
    //   9742: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9745: invokevirtual 592	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9748: invokestatic 305	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   9751: goto -9569 -> 182
    //   9754: astore_1
    //   9755: invokestatic 300	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9758: ifeq -9576 -> 182
    //   9761: getstatic 145	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   9764: iconst_2
    //   9765: new 584	java/lang/StringBuilder
    //   9768: dup
    //   9769: invokespecial 585	java/lang/StringBuilder:<init>	()V
    //   9772: ldc_w 2445
    //   9775: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9778: aload 5
    //   9780: iconst_0
    //   9781: aaload
    //   9782: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9785: invokevirtual 592	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9788: invokestatic 305	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   9791: goto -9609 -> 182
    //   9794: ldc_w 2464
    //   9797: aload 4
    //   9799: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9802: ifeq -9620 -> 182
    //   9805: aload_0
    //   9806: new 199	org/json/JSONObject
    //   9809: dup
    //   9810: aload 5
    //   9812: iconst_0
    //   9813: aaload
    //   9814: invokespecial 326	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   9817: ldc 38
    //   9819: invokevirtual 206	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   9822: putfield 1871	com/tencent/mobileqq/jsp/UiApiPlugin:E	Ljava/lang/String;
    //   9825: aload_0
    //   9826: invokespecial 1519	com/tencent/mobileqq/jsp/UiApiPlugin:a	()Lcom/tencent/mobileqq/webviewplugin/WebUiUtils$WebTitleBarInterface;
    //   9829: astore_1
    //   9830: aload_1
    //   9831: ifnull -9649 -> 182
    //   9834: aload_1
    //   9835: invokeinterface 2465 1 0
    //   9840: istore 10
    //   9842: aload_0
    //   9843: aload_0
    //   9844: getfield 1871	com/tencent/mobileqq/jsp/UiApiPlugin:E	Ljava/lang/String;
    //   9847: iconst_1
    //   9848: anewarray 186	java/lang/String
    //   9851: dup
    //   9852: iconst_0
    //   9853: new 584	java/lang/StringBuilder
    //   9856: dup
    //   9857: invokespecial 585	java/lang/StringBuilder:<init>	()V
    //   9860: ldc_w 2467
    //   9863: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9866: iload 10
    //   9868: invokevirtual 1437	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9871: ldc_w 2469
    //   9874: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9877: invokevirtual 592	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9880: aastore
    //   9881: invokevirtual 582	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   9884: goto -9702 -> 182
    //   9887: astore_1
    //   9888: invokestatic 300	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9891: ifeq -9709 -> 182
    //   9894: aload_0
    //   9895: aload_0
    //   9896: getfield 1871	com/tencent/mobileqq/jsp/UiApiPlugin:E	Ljava/lang/String;
    //   9899: iconst_1
    //   9900: anewarray 186	java/lang/String
    //   9903: dup
    //   9904: iconst_0
    //   9905: ldc_w 2471
    //   9908: aastore
    //   9909: invokevirtual 582	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   9912: getstatic 145	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   9915: iconst_2
    //   9916: new 584	java/lang/StringBuilder
    //   9919: dup
    //   9920: invokespecial 585	java/lang/StringBuilder:<init>	()V
    //   9923: ldc_w 2473
    //   9926: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9929: aload_1
    //   9930: invokevirtual 2334	org/json/JSONException:toString	()Ljava/lang/String;
    //   9933: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9936: invokevirtual 592	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9939: invokestatic 305	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   9942: goto -9760 -> 182
    //   9945: astore_1
    //   9946: invokestatic 300	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9949: ifeq -9767 -> 182
    //   9952: aload_0
    //   9953: aload_0
    //   9954: getfield 1871	com/tencent/mobileqq/jsp/UiApiPlugin:E	Ljava/lang/String;
    //   9957: iconst_1
    //   9958: anewarray 186	java/lang/String
    //   9961: dup
    //   9962: iconst_0
    //   9963: ldc_w 2471
    //   9966: aastore
    //   9967: invokevirtual 582	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   9970: getstatic 145	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   9973: iconst_2
    //   9974: new 584	java/lang/StringBuilder
    //   9977: dup
    //   9978: invokespecial 585	java/lang/StringBuilder:<init>	()V
    //   9981: ldc_w 2473
    //   9984: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9987: aload_1
    //   9988: invokevirtual 2287	java/lang/Exception:toString	()Ljava/lang/String;
    //   9991: invokevirtual 591	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9994: invokevirtual 592	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9997: invokestatic 305	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10000: goto -9818 -> 182
    //   10003: ldc_w 2475
    //   10006: aload_3
    //   10007: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10010: ifeq +43 -> 10053
    //   10013: ldc_w 2477
    //   10016: aload 4
    //   10018: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10021: ifeq +32 -> 10053
    //   10024: new 232	android/content/Intent
    //   10027: dup
    //   10028: aload_0
    //   10029: getfield 216	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   10032: invokevirtual 221	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   10035: ldc_w 2479
    //   10038: invokespecial 544	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   10041: astore_1
    //   10042: aload_0
    //   10043: getfield 216	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   10046: invokevirtual 221	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   10049: aload_1
    //   10050: invokevirtual 1094	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   10053: iconst_0
    //   10054: ireturn
    //   10055: astore_2
    //   10056: goto -2717 -> 7339
    //   10059: astore 7
    //   10061: goto -6748 -> 3313
    //   10064: aconst_null
    //   10065: astore_1
    //   10066: aload_3
    //   10067: astore_2
    //   10068: goto -2265 -> 7803
    //   10071: goto -3555 -> 6516
    //   10074: goto -9892 -> 182
    //   10077: iconst_1
    //   10078: ireturn
    //   10079: iconst_1
    //   10080: ireturn
    //   10081: iconst_1
    //   10082: ireturn
    //   10083: iconst_1
    //   10084: ireturn
    //   10085: iconst_1
    //   10086: ireturn
    //   10087: astore_1
    //   10088: goto -9906 -> 182
    //   10091: iconst_1
    //   10092: ireturn
    //   10093: iload 10
    //   10095: tableswitch	default:+17->10112, 1001:+-6422->3673
    //   10112: goto -6539 -> 3573
    //   10115: iconst_0
    //   10116: istore 15
    //   10118: goto -6245 -> 3873
    //   10121: iconst_0
    //   10122: istore 15
    //   10124: goto -6084 -> 4040
    //   10127: iload 10
    //   10129: iconst_1
    //   10130: iadd
    //   10131: istore 10
    //   10133: goto -2123 -> 8010
    //   10136: iconst_1
    //   10137: ireturn
    //   10138: iconst_1
    //   10139: ireturn
    //   10140: iconst_1
    //   10141: ireturn
    //   10142: iconst_1
    //   10143: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	10144	0	this	UiApiPlugin
    //   0	10144	1	paramJsBridgeListener	JsBridgeListener
    //   0	10144	2	paramString1	String
    //   0	10144	3	paramString2	String
    //   0	10144	4	paramString3	String
    //   0	10144	5	paramVarArgs	String[]
    //   813	8854	6	localObject1	Object
    //   2582	7032	7	localObject2	Object
    //   10059	1	7	localJSONException	JSONException
    //   7502	164	8	str1	String
    //   7568	104	9	str2	String
    //   285	9847	10	i1	int
    //   3914	4688	11	i2	int
    //   4554	3499	12	i3	int
    //   276	4990	13	l1	long
    //   1476	8647	15	bool1	boolean
    //   2604	65	16	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   33	90	184	org/json/JSONException
    //   95	174	184	org/json/JSONException
    //   174	182	184	org/json/JSONException
    //   257	370	373	org/json/JSONException
    //   446	454	559	org/json/JSONException
    //   460	508	559	org/json/JSONException
    //   508	525	559	org/json/JSONException
    //   534	556	559	org/json/JSONException
    //   602	633	559	org/json/JSONException
    //   647	671	731	org/json/JSONException
    //   673	728	731	org/json/JSONException
    //   763	791	931	org/json/JSONException
    //   793	885	931	org/json/JSONException
    //   891	899	931	org/json/JSONException
    //   903	914	931	org/json/JSONException
    //   914	928	931	org/json/JSONException
    //   958	975	931	org/json/JSONException
    //   989	1029	1032	org/json/JSONException
    //   1064	1071	1079	java/lang/Exception
    //   1064	1071	1088	finally
    //   1188	1205	1208	org/json/JSONException
    //   1247	1255	1307	org/json/JSONException
    //   1259	1266	1307	org/json/JSONException
    //   1269	1304	1307	org/json/JSONException
    //   1346	1354	1387	org/json/JSONException
    //   1358	1365	1387	org/json/JSONException
    //   1368	1384	1387	org/json/JSONException
    //   1426	1434	1504	org/json/JSONException
    //   1438	1445	1504	org/json/JSONException
    //   1448	1501	1504	org/json/JSONException
    //   1543	1551	1583	org/json/JSONException
    //   1555	1562	1583	org/json/JSONException
    //   1565	1580	1583	org/json/JSONException
    //   1622	1630	1662	java/lang/Exception
    //   1634	1641	1662	java/lang/Exception
    //   1644	1659	1662	java/lang/Exception
    //   1921	1941	1944	org/json/JSONException
    //   1970	2002	2029	org/json/JSONException
    //   2006	2026	2029	org/json/JSONException
    //   2055	2087	2147	org/json/JSONException
    //   2091	2111	2147	org/json/JSONException
    //   2173	2205	2265	org/json/JSONException
    //   2209	2229	2265	org/json/JSONException
    //   2291	2323	2383	org/json/JSONException
    //   2327	2347	2383	org/json/JSONException
    //   2409	2441	2501	org/json/JSONException
    //   2445	2465	2501	org/json/JSONException
    //   2755	2760	2763	java/lang/Exception
    //   2527	2549	2767	org/json/JSONException
    //   2554	2562	2767	org/json/JSONException
    //   2565	2668	2767	org/json/JSONException
    //   2675	2691	2767	org/json/JSONException
    //   2691	2700	2767	org/json/JSONException
    //   2707	2723	2767	org/json/JSONException
    //   2723	2732	2767	org/json/JSONException
    //   2732	2755	2767	org/json/JSONException
    //   2755	2760	2767	org/json/JSONException
    //   2793	2881	2884	org/json/JSONException
    //   2899	2906	2884	org/json/JSONException
    //   2924	2989	2884	org/json/JSONException
    //   2992	2999	2884	org/json/JSONException
    //   3002	3028	2884	org/json/JSONException
    //   3032	3072	2884	org/json/JSONException
    //   3075	3110	2884	org/json/JSONException
    //   3114	3169	2884	org/json/JSONException
    //   2793	2881	2909	java/lang/Exception
    //   2899	2906	2909	java/lang/Exception
    //   2924	2989	2909	java/lang/Exception
    //   2992	2999	2909	java/lang/Exception
    //   3002	3028	2909	java/lang/Exception
    //   3032	3072	2909	java/lang/Exception
    //   3075	3110	2909	java/lang/Exception
    //   3114	3169	2909	java/lang/Exception
    //   3213	3276	3382	java/lang/Exception
    //   3276	3286	3382	java/lang/Exception
    //   3286	3295	3382	java/lang/Exception
    //   3300	3313	3382	java/lang/Exception
    //   3313	3379	3382	java/lang/Exception
    //   3446	3454	3382	java/lang/Exception
    //   3457	3484	3382	java/lang/Exception
    //   3487	3537	3382	java/lang/Exception
    //   3537	3556	3382	java/lang/Exception
    //   3622	3638	3382	java/lang/Exception
    //   3197	3209	3439	org/json/JSONException
    //   3276	3286	3445	org/json/JSONException
    //   3556	3570	3618	java/lang/Exception
    //   3573	3608	3618	java/lang/Exception
    //   3608	3615	3618	java/lang/Exception
    //   3641	3670	3618	java/lang/Exception
    //   3673	3683	3618	java/lang/Exception
    //   3723	3750	4350	org/json/JSONException
    //   3752	3794	4350	org/json/JSONException
    //   3809	3829	4350	org/json/JSONException
    //   3829	3848	4350	org/json/JSONException
    //   3852	3864	4350	org/json/JSONException
    //   3873	3879	4350	org/json/JSONException
    //   3879	3884	4350	org/json/JSONException
    //   3888	3925	4350	org/json/JSONException
    //   3932	3949	4350	org/json/JSONException
    //   3955	3963	4350	org/json/JSONException
    //   3967	3971	4350	org/json/JSONException
    //   3971	3976	4350	org/json/JSONException
    //   3980	4009	4350	org/json/JSONException
    //   4009	4016	4350	org/json/JSONException
    //   4016	4037	4350	org/json/JSONException
    //   4040	4049	4350	org/json/JSONException
    //   4058	4102	4350	org/json/JSONException
    //   4102	4122	4350	org/json/JSONException
    //   4122	4137	4350	org/json/JSONException
    //   4137	4142	4350	org/json/JSONException
    //   4146	4165	4350	org/json/JSONException
    //   4171	4177	4350	org/json/JSONException
    //   4177	4214	4350	org/json/JSONException
    //   4218	4254	4350	org/json/JSONException
    //   4254	4272	4350	org/json/JSONException
    //   4276	4291	4350	org/json/JSONException
    //   4291	4310	4350	org/json/JSONException
    //   4315	4339	4350	org/json/JSONException
    //   4339	4347	4350	org/json/JSONException
    //   4387	4399	4350	org/json/JSONException
    //   4439	4452	4350	org/json/JSONException
    //   4455	4465	4350	org/json/JSONException
    //   4470	4476	4350	org/json/JSONException
    //   4479	4513	4350	org/json/JSONException
    //   4516	4522	4350	org/json/JSONException
    //   4527	4549	4350	org/json/JSONException
    //   4556	4621	4350	org/json/JSONException
    //   4621	4628	4350	org/json/JSONException
    //   4632	4642	4350	org/json/JSONException
    //   4642	4647	4350	org/json/JSONException
    //   4651	4689	4350	org/json/JSONException
    //   4689	4746	4350	org/json/JSONException
    //   4749	4760	4350	org/json/JSONException
    //   4763	4775	4350	org/json/JSONException
    //   4778	4794	4350	org/json/JSONException
    //   3723	3750	4402	java/lang/Exception
    //   3752	3794	4402	java/lang/Exception
    //   3809	3829	4402	java/lang/Exception
    //   3829	3848	4402	java/lang/Exception
    //   3852	3864	4402	java/lang/Exception
    //   3873	3879	4402	java/lang/Exception
    //   3879	3884	4402	java/lang/Exception
    //   3888	3925	4402	java/lang/Exception
    //   3932	3949	4402	java/lang/Exception
    //   3955	3963	4402	java/lang/Exception
    //   3967	3971	4402	java/lang/Exception
    //   3971	3976	4402	java/lang/Exception
    //   3980	4009	4402	java/lang/Exception
    //   4009	4016	4402	java/lang/Exception
    //   4016	4037	4402	java/lang/Exception
    //   4040	4049	4402	java/lang/Exception
    //   4058	4102	4402	java/lang/Exception
    //   4102	4122	4402	java/lang/Exception
    //   4122	4137	4402	java/lang/Exception
    //   4137	4142	4402	java/lang/Exception
    //   4146	4165	4402	java/lang/Exception
    //   4171	4177	4402	java/lang/Exception
    //   4177	4214	4402	java/lang/Exception
    //   4218	4254	4402	java/lang/Exception
    //   4254	4272	4402	java/lang/Exception
    //   4276	4291	4402	java/lang/Exception
    //   4291	4310	4402	java/lang/Exception
    //   4315	4339	4402	java/lang/Exception
    //   4339	4347	4402	java/lang/Exception
    //   4387	4399	4402	java/lang/Exception
    //   4439	4452	4402	java/lang/Exception
    //   4455	4465	4402	java/lang/Exception
    //   4470	4476	4402	java/lang/Exception
    //   4479	4513	4402	java/lang/Exception
    //   4516	4522	4402	java/lang/Exception
    //   4527	4549	4402	java/lang/Exception
    //   4556	4621	4402	java/lang/Exception
    //   4621	4628	4402	java/lang/Exception
    //   4632	4642	4402	java/lang/Exception
    //   4642	4647	4402	java/lang/Exception
    //   4651	4689	4402	java/lang/Exception
    //   4689	4746	4402	java/lang/Exception
    //   4749	4760	4402	java/lang/Exception
    //   4763	4775	4402	java/lang/Exception
    //   4778	4794	4402	java/lang/Exception
    //   4815	4841	4879	org/json/JSONException
    //   4841	4856	4879	org/json/JSONException
    //   4860	4876	4879	org/json/JSONException
    //   4934	5022	5025	org/json/JSONException
    //   5080	5142	5290	org/json/JSONException
    //   5146	5153	5290	org/json/JSONException
    //   5153	5168	5290	org/json/JSONException
    //   5170	5210	5290	org/json/JSONException
    //   5212	5220	5290	org/json/JSONException
    //   5224	5287	5290	org/json/JSONException
    //   5345	5409	5543	org/json/JSONException
    //   5413	5420	5543	org/json/JSONException
    //   5420	5435	5543	org/json/JSONException
    //   5437	5445	5543	org/json/JSONException
    //   5454	5523	5543	org/json/JSONException
    //   5523	5540	5543	org/json/JSONException
    //   5580	5600	5543	org/json/JSONException
    //   5621	5673	5695	org/json/JSONException
    //   5675	5692	5695	org/json/JSONException
    //   5750	5790	5808	org/json/JSONException
    //   5795	5799	5808	org/json/JSONException
    //   5799	5805	5808	org/json/JSONException
    //   5845	5849	5808	org/json/JSONException
    //   5852	5890	5808	org/json/JSONException
    //   5895	5919	5808	org/json/JSONException
    //   5919	5926	5808	org/json/JSONException
    //   5929	5953	5808	org/json/JSONException
    //   5974	6082	6085	org/json/JSONException
    //   5974	6082	6121	java/lang/Exception
    //   6196	6208	6374	java/lang/Exception
    //   6210	6217	6374	java/lang/Exception
    //   6219	6230	6374	java/lang/Exception
    //   6232	6240	6374	java/lang/Exception
    //   6242	6250	6374	java/lang/Exception
    //   6255	6265	6374	java/lang/Exception
    //   6267	6276	6374	java/lang/Exception
    //   6278	6286	6374	java/lang/Exception
    //   6288	6296	6374	java/lang/Exception
    //   6303	6311	6374	java/lang/Exception
    //   6313	6322	6374	java/lang/Exception
    //   6324	6333	6374	java/lang/Exception
    //   6335	6344	6374	java/lang/Exception
    //   6346	6362	6374	java/lang/Exception
    //   6364	6371	6374	java/lang/Exception
    //   6450	6463	6714	java/lang/Exception
    //   6465	6473	6714	java/lang/Exception
    //   6475	6486	6714	java/lang/Exception
    //   6488	6497	6714	java/lang/Exception
    //   6502	6510	6714	java/lang/Exception
    //   6518	6527	6714	java/lang/Exception
    //   6529	6538	6714	java/lang/Exception
    //   6540	6549	6714	java/lang/Exception
    //   6551	6558	6714	java/lang/Exception
    //   6560	6569	6714	java/lang/Exception
    //   6571	6580	6714	java/lang/Exception
    //   6582	6590	6714	java/lang/Exception
    //   6592	6601	6714	java/lang/Exception
    //   6603	6613	6714	java/lang/Exception
    //   6615	6624	6714	java/lang/Exception
    //   6626	6634	6714	java/lang/Exception
    //   6636	6645	6714	java/lang/Exception
    //   6647	6664	6714	java/lang/Exception
    //   6666	6673	6714	java/lang/Exception
    //   6748	6760	6850	java/lang/Exception
    //   6762	6769	6850	java/lang/Exception
    //   6771	6781	6850	java/lang/Exception
    //   6783	6792	6850	java/lang/Exception
    //   6794	6809	6850	java/lang/Exception
    //   6815	6822	6850	java/lang/Exception
    //   6824	6829	6850	java/lang/Exception
    //   6839	6847	6850	java/lang/Exception
    //   6895	6904	6850	java/lang/Exception
    //   6918	6927	6850	java/lang/Exception
    //   6951	6963	7053	java/lang/Exception
    //   6965	6972	7053	java/lang/Exception
    //   6974	6984	7053	java/lang/Exception
    //   6986	6995	7053	java/lang/Exception
    //   6997	7012	7053	java/lang/Exception
    //   7018	7025	7053	java/lang/Exception
    //   7027	7032	7053	java/lang/Exception
    //   7042	7050	7053	java/lang/Exception
    //   7098	7107	7053	java/lang/Exception
    //   7121	7130	7053	java/lang/Exception
    //   7253	7286	7318	java/lang/Exception
    //   7206	7243	7338	java/lang/Exception
    //   7319	7330	7338	java/lang/Exception
    //   7450	7463	7857	java/lang/Exception
    //   7468	7476	7857	java/lang/Exception
    //   7481	7490	7857	java/lang/Exception
    //   7495	7504	7857	java/lang/Exception
    //   7509	7519	7857	java/lang/Exception
    //   7524	7535	7857	java/lang/Exception
    //   7545	7555	7857	java/lang/Exception
    //   7560	7570	7857	java/lang/Exception
    //   7575	7585	7857	java/lang/Exception
    //   7590	7598	7857	java/lang/Exception
    //   7603	7611	7857	java/lang/Exception
    //   7616	7623	7857	java/lang/Exception
    //   7628	7638	7857	java/lang/Exception
    //   7643	7653	7857	java/lang/Exception
    //   7658	7679	7857	java/lang/Exception
    //   7684	7697	7857	java/lang/Exception
    //   7702	7715	7857	java/lang/Exception
    //   7720	7733	7857	java/lang/Exception
    //   7738	7747	7857	java/lang/Exception
    //   7752	7759	7857	java/lang/Exception
    //   7764	7799	7857	java/lang/Exception
    //   7835	7849	7857	java/lang/Exception
    //   7946	8003	8137	org/json/JSONException
    //   8006	8010	8137	org/json/JSONException
    //   8017	8028	8137	org/json/JSONException
    //   8034	8060	8137	org/json/JSONException
    //   8063	8125	8137	org/json/JSONException
    //   8125	8134	8137	org/json/JSONException
    //   8213	8228	8231	org/json/JSONException
    //   8306	8326	8329	org/json/JSONException
    //   8380	8397	8411	org/json/JSONException
    //   8401	8408	8411	org/json/JSONException
    //   8380	8397	8451	java/lang/Exception
    //   8401	8408	8451	java/lang/Exception
    //   8508	8542	8662	java/lang/Exception
    //   8544	8578	8662	java/lang/Exception
    //   8582	8604	8662	java/lang/Exception
    //   8604	8659	8662	java/lang/Exception
    //   8707	8758	8778	java/lang/Exception
    //   8758	8775	8778	java/lang/Exception
    //   8799	8870	9141	org/json/JSONException
    //   8873	8881	9141	org/json/JSONException
    //   8885	8892	9141	org/json/JSONException
    //   8892	8927	9141	org/json/JSONException
    //   8930	8950	9141	org/json/JSONException
    //   8956	9138	9141	org/json/JSONException
    //   9186	9207	9141	org/json/JSONException
    //   9207	9228	9141	org/json/JSONException
    //   8799	8870	9231	java/lang/Exception
    //   8873	8881	9231	java/lang/Exception
    //   8885	8892	9231	java/lang/Exception
    //   8892	8927	9231	java/lang/Exception
    //   8930	8950	9231	java/lang/Exception
    //   8956	9138	9231	java/lang/Exception
    //   9186	9207	9231	java/lang/Exception
    //   9207	9228	9231	java/lang/Exception
    //   9344	9394	9714	org/json/JSONException
    //   9394	9456	9714	org/json/JSONException
    //   9459	9468	9714	org/json/JSONException
    //   9473	9481	9714	org/json/JSONException
    //   9481	9516	9714	org/json/JSONException
    //   9519	9711	9714	org/json/JSONException
    //   9344	9394	9754	java/lang/Exception
    //   9394	9456	9754	java/lang/Exception
    //   9459	9468	9754	java/lang/Exception
    //   9473	9481	9754	java/lang/Exception
    //   9481	9516	9754	java/lang/Exception
    //   9519	9711	9754	java/lang/Exception
    //   9805	9830	9887	org/json/JSONException
    //   9834	9884	9887	org/json/JSONException
    //   9805	9830	9945	java/lang/Exception
    //   9834	9884	9945	java/lang/Exception
    //   7181	7200	10055	java/lang/Exception
    //   3286	3295	10059	org/json/JSONException
    //   3300	3313	10059	org/json/JSONException
    //   1743	1782	10087	org/json/JSONException
    //   1784	1857	10087	org/json/JSONException
    //   1859	1870	10087	org/json/JSONException
    //   1873	1900	10087	org/json/JSONException
  }
  
  public void onActivityReady()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_CLOSE");
    Activity localActivity = this.mRuntime.a();
    if ((localActivity != null) && (!this.jdField_e_of_type_Boolean)) {}
    try
    {
      localActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter, "com.tencent.msg.permission.pushnotify", null);
      this.jdField_e_of_type_Boolean = true;
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(jdField_a_of_type_JavaLangString, 2, "regist receiver error:" + localException.toString());
    }
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    if (paramByte == 3) {
      if (paramIntent != null) {}
    }
    Object localObject1;
    Object localObject3;
    Object localObject2;
    int i1;
    boolean bool1;
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
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      return;
                      localObject1 = paramIntent.getStringExtra("scanResult");
                      if (!TextUtils.isEmpty(this.D)) {
                        break;
                      }
                      localObject3 = paramIntent.getStringExtra("callback_url");
                      localObject2 = paramIntent.getStringExtra("name");
                    } while ((TextUtils.isEmpty((CharSequence)localObject3)) || (TextUtils.isEmpty((CharSequence)localObject2)));
                    localObject3 = ((String)localObject3).split("#");
                    StringBuilder localStringBuilder = new StringBuilder(localObject3[0]);
                    if (localObject3[0].contains("?")) {}
                    for (paramIntent = "&";; paramIntent = "?")
                    {
                      paramIntent = localStringBuilder.append(paramIntent).append((String)localObject2).append("=").append(URLEncoder.encode((String)localObject1));
                      if (localObject3.length > 1) {
                        paramIntent.append("#").append(localObject3[1]);
                      }
                      if (this.mRuntime.a() == null) {
                        break;
                      }
                      this.mRuntime.a().loadUrl(paramIntent.toString());
                      return;
                    }
                    localObject2 = this.D;
                    if (localObject1 == null) {}
                    for (paramIntent = "''";; paramIntent = Util.b((String)localObject1))
                    {
                      callJs((String)localObject2, new String[] { paramIntent });
                      return;
                    }
                    if (paramByte != 4) {
                      break;
                    }
                  } while (TextUtils.isEmpty(this.E));
                  if (paramInt == -1)
                  {
                    if (paramIntent == null) {}
                    for (paramIntent = "";; paramIntent = paramIntent.getStringExtra("result"))
                    {
                      paramIntent = "{\"code\":0,\"data\":{\"retcode\":0,\"result\":" + paramIntent + "}}";
                      callJs(this.E, new String[] { paramIntent });
                      return;
                    }
                  }
                  callJs(this.E, new String[] { "{\"code\":-1}" });
                  return;
                  if (paramByte != 5) {
                    break;
                  }
                } while (TextUtils.isEmpty(this.F));
                if (paramInt == -1)
                {
                  paramInt = paramIntent.getIntExtra("ret", 4);
                  if (QLog.isColorLevel()) {
                    QLog.d(jdField_a_of_type_JavaLangString, 2, "select contact ret:" + paramInt);
                  }
                  localObject1 = new JSONObject();
                  for (;;)
                  {
                    try
                    {
                      ((JSONObject)localObject1).put("ret", paramInt);
                      if (paramInt == 0)
                      {
                        localObject2 = paramIntent.getStringArrayExtra("openids");
                        paramIntent = paramIntent.getIntArrayExtra("types");
                        if ((localObject2 != null) && (paramIntent != null) && (localObject2.length == paramIntent.length))
                        {
                          i1 = localObject2.length;
                          localObject3 = new JSONArray();
                          paramInt = 0;
                          if (paramInt < i1)
                          {
                            ((JSONArray)localObject3).put(new JSONObject().put("type", paramIntent[paramInt]).put("openID", localObject2[paramInt]));
                            paramInt += 1;
                            continue;
                          }
                          ((JSONObject)localObject1).put("contacts", localObject3);
                        }
                        callJs(this.F, new String[] { ((JSONObject)localObject1).toString() });
                        return;
                      }
                    }
                    catch (JSONException paramIntent)
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d(jdField_a_of_type_JavaLangString, 2, "select contact result json exception", paramIntent);
                      }
                      callJs(this.F, new String[] { "{\"ret\":4}" });
                      return;
                    }
                    ((JSONObject)localObject1).put("errMsg", paramIntent.getStringExtra("errMsg"));
                  }
                }
                callJs(this.F, new String[] { "{\"ret\":3}" });
                return;
                if (paramByte != 7) {
                  break;
                }
              } while (TextUtils.isEmpty(this.E));
              if (paramInt == -1)
              {
                paramInt = paramIntent.getIntExtra("ret", 0);
                if (QLog.isColorLevel()) {
                  QLog.d(jdField_a_of_type_JavaLangString, 2, "select Member ret:" + paramInt);
                }
                localObject1 = new JSONObject();
                for (;;)
                {
                  try
                  {
                    ((JSONObject)localObject1).put("ret", paramInt);
                    if (paramInt == 0)
                    {
                      ((JSONObject)localObject1).put("selectMore", this.jdField_c_of_type_Boolean);
                      ((JSONObject)localObject1).put("uin", this.G);
                      ((JSONObject)localObject1).put("uinType", "0");
                      localObject2 = new JSONArray();
                      if (this.jdField_c_of_type_Boolean)
                      {
                        paramIntent = paramIntent.getParcelableArrayListExtra("result_set");
                        paramInt = 0;
                        if (paramInt < paramIntent.size())
                        {
                          localObject3 = (ResultRecord)paramIntent.get(paramInt);
                          ((JSONArray)localObject2).put(new JSONObject().put("memUin", ((ResultRecord)localObject3).jdField_a_of_type_JavaLangString).put("nick", ((ResultRecord)localObject3).jdField_b_of_type_JavaLangString));
                          paramInt += 1;
                          continue;
                        }
                      }
                      else
                      {
                        localObject3 = paramIntent.getStringExtra("member_uin");
                        paramIntent = paramIntent.getStringExtra("member_display_name");
                        ((JSONArray)localObject2).put(new JSONObject().put("memUin", localObject3).put("nick", paramIntent));
                      }
                      ((JSONObject)localObject1).put("selectUins", localObject2);
                      callJs(this.E, new String[] { ((JSONObject)localObject1).toString() });
                      return;
                    }
                  }
                  catch (JSONException paramIntent)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d(jdField_a_of_type_JavaLangString, 2, "select contact result json exception", paramIntent);
                    }
                    callJs(this.E, new String[] { "{\"ret\":3,\"errMsg\":\"Json Parse Error\"}" });
                    return;
                  }
                  ((JSONObject)localObject1).put("errMsg", paramIntent.getStringExtra("errMsg"));
                }
              }
              callJs(this.E, new String[] { "{\"ret\":1,\"errMsg\":\"User cancle\"}" });
              return;
              if (paramByte != 6) {
                break;
              }
            } while (TextUtils.isEmpty(this.E));
            if (paramInt == -1)
            {
              callJs(this.E, new String[] { "{'retcode' : 0}" });
              return;
            }
            paramInt = paramIntent.getIntExtra("retCode", -1);
            callJs(this.E, new String[] { "{'retcode' : " + paramInt + "}" });
            return;
            if ((paramByte != 8) && (paramByte != 9)) {
              break;
            }
          } while ((paramInt != -1) || (paramIntent == null));
          bool1 = paramIntent.getBooleanExtra("key_troop_fee_notify_js_data_changed", false);
          paramIntent = paramIntent.getStringExtra("callback");
        } while (!bool1);
        callJs(paramIntent, new String[] { "{}" });
        return;
        if (paramByte != 10) {
          break;
        }
      } while ((paramInt != -1) && (paramIntent == null));
      TroopGiftUtil.a(this.mRuntime.a(), paramIntent, null);
      a(paramIntent.getStringExtra("troop_uin"), "send_page");
      return;
      if (paramByte != 11) {
        break label1537;
      }
      localObject1 = null;
      bool1 = false;
      if (paramIntent != null)
      {
        localObject1 = paramIntent.getStringExtra("callback");
        bool1 = paramIntent.getBooleanExtra("isOpenApi", false);
      }
      localObject2 = localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break;
      }
      localObject1 = this.H;
      boolean bool2 = this.d;
      bool1 = bool2;
      localObject2 = localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break;
      }
      bool1 = bool2;
      localObject2 = localObject1;
      if (bool2) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w(jdField_a_of_type_JavaLangString, 2, "groupOrganizationView no callback");
    return;
    this.H = null;
    this.d = false;
    if (paramIntent == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w(jdField_a_of_type_JavaLangString, 2, "groupOrganization result intent=null");
      }
      if (bool1)
      {
        callJs4OpenApiIfNeeded("groupOrganizationView", -100, "{ret:4}");
        return;
      }
      callJs((String)localObject2, new String[] { "{ret:4}" });
      return;
    }
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject();
        i1 = paramIntent.getIntExtra("ret", 5);
        ((JSONObject)localObject1).put("ret", i1);
        localObject3 = paramIntent.getStringExtra("errMsg");
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          ((JSONObject)localObject1).put("errMsg", localObject3);
        }
        if (i1 != 0) {
          break label1704;
        }
        paramIntent = paramIntent.getStringArrayExtra("result");
        localObject3 = new JSONArray();
        int i2 = paramIntent.length;
        paramInt = 0;
        if (paramInt < i2)
        {
          ((JSONArray)localObject3).put(paramIntent[paramInt]);
          paramInt += 1;
          continue;
        }
        ((JSONObject)localObject1).put("openIDArr", localObject3);
      }
      catch (JSONException paramIntent)
      {
        label1445:
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w(jdField_a_of_type_JavaLangString, 2, "groupOrganization error", paramIntent);
        if (!bool1) {
          break label1520;
        }
      }
      callJs4OpenApiIfNeeded("groupOrganizationView", paramInt, ((JSONObject)localObject1).toString());
      return;
      callJs4OpenApiIfNeeded("groupOrganizationView", -100, "{ret:4}");
      return;
      label1520:
      label1537:
      label1704:
      do
      {
        paramInt = -100;
        break label1445;
        do
        {
          callJs((String)localObject2, new String[] { ((JSONObject)localObject1).toString() });
          return;
          callJs((String)localObject2, new String[] { "{ret:4}" });
          return;
          if (paramByte != 12) {
            break;
          }
          paramInt = paramIntent.getIntExtra("cGroupOption", -1);
          localObject1 = paramIntent.getStringExtra("troop_uin");
          if (paramIntent.getBooleanExtra("isSetFee", false)) {
            paramInt = 4;
          }
          for (;;)
          {
            paramIntent = new JSONObject();
            try
            {
              paramIntent.put("gc", localObject1);
              paramIntent.put("ret", 0);
              paramIntent.put("joinType", paramInt);
              callJs(this.I, new String[] { paramIntent.toString() });
              return;
              switch (paramInt)
              {
              default: 
                paramInt = -1;
                break;
              case 1: 
                paramInt = 0;
                break;
              case 2: 
                paramInt = 1;
                break;
              case 3: 
                paramInt = 5;
                break;
              case 4: 
                paramInt = 3;
                break;
              case 5: 
                paramInt = 2;
              }
            }
            catch (JSONException localJSONException)
            {
              for (;;)
              {
                localJSONException.printStackTrace();
              }
            }
          }
        } while (!bool1);
      } while (i1 != 0);
      paramInt = 0;
    }
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (!TextUtils.isEmpty(this.C))
    {
      callJs(this.C, new String[] { "1", Integer.toString(this.jdField_f_of_type_Int) });
      return;
    }
    callJs4OpenApiIfNeeded("showActionSheet", 0, Integer.toString(this.jdField_f_of_type_Int));
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidViewView)
    {
      paramView = this.mRuntime.a();
      if (paramView != null) {
        paramView.finish();
      }
    }
  }
  
  protected void onCreate()
  {
    WebIPCOperator.a().a(this.jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver);
  }
  
  protected void onDestroy()
  {
    Activity localActivity = this.mRuntime.a();
    if ((localActivity != null) && (this.jdField_e_of_type_Boolean))
    {
      localActivity.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_e_of_type_Boolean = false;
    }
    if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
    if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient != null) {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b();
    }
    WebIPCOperator.a().b(this.jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver);
    super.onDestroy();
  }
  
  public void onDismiss()
  {
    if (!TextUtils.isEmpty(this.C))
    {
      callJs(this.C, new String[] { "1", Integer.toString(this.jdField_f_of_type_Int) });
      return;
    }
    callJs4OpenApiIfNeeded("showActionSheet", 0, Integer.toString(this.jdField_f_of_type_Int));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\jsp\UiApiPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */