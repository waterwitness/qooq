package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.debug.EnvSwitchActivity;
import com.tencent.mobileqq.emosm.Client;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.statistics.DcReportUtil;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil.NetInfo;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialogThreeBtns;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.MultiNameSpacePluginCompact;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderSupporter;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebviewReportSpeedInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.io.FileReader;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VasCommonJsPlugin
  extends VasWebviewJsPlugin
  implements MultiNameSpacePluginCompact
{
  private static final String LOG_TAG_WEB = "WebQlog";
  public static final String PLUGIN_NAMESPACE_FRIEND_DATA = "friendData";
  public static final String PLUGIN_NAMESPACE_QW_DATA = "qw_data";
  public static final String PLUGIN_NAMESPACE_QW_DEBUG = "qw_debug";
  private static final String TAG = "VasCommonJsPlugin";
  private final byte REQUEST_CODE_FRIENDS;
  private VasCommonJsPlugin.JsDebugDialog deBugDialog;
  private List logInfo;
  private boolean logShowTag;
  private boolean logStop;
  protected String mCallback;
  protected VasCommonJsPlugin.ChooseFriendReceiver mChoFriReceiver;
  protected VasCommonJsPlugin.ChooseH5PTVReceiver mH5PTVReceiver;
  private Bundle mReqBundle;
  
  public VasCommonJsPlugin()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.logInfo = Collections.synchronizedList(new ArrayList());
    this.logShowTag = true;
    this.REQUEST_CODE_FRIENDS = 17;
    this.mReqBundle = new Bundle();
  }
  
  private void H5chooseFriends(String paramString)
  {
    Object localObject1 = getCurrentContext();
    if ((localObject1 == null) || (TextUtils.isEmpty(paramString)))
    {
      doChooseFriendResultForH5(null, null, null, null);
      return;
    }
    int i;
    int j;
    boolean bool1;
    boolean bool2;
    try
    {
      localObject2 = new JSONObject(paramString);
      paramString = ((JSONObject)localObject2).optString("title", "选择我的好友");
      i = ((JSONObject)localObject2).optInt("type", 0);
      if (QLog.isColorLevel()) {
        QLog.d("h5ptv", 2, "type=" + i);
      }
      this.mCallback = ((JSONObject)localObject2).optString("callback");
      j = Integer.valueOf(((JSONObject)localObject2).optString("limitNum", "0")).intValue();
      boolean bool3 = Boolean.valueOf(((JSONObject)localObject2).optString("isMulti", "false")).booleanValue();
      if ((i & 0x1) == 0)
      {
        bool1 = false;
        if ((i & 0x2) != 0) {
          break label197;
        }
      }
      label197:
      for (bool2 = false;; bool2 = true)
      {
        if (this.mH5PTVReceiver == null) {
          this.mH5PTVReceiver = new VasCommonJsPlugin.ChooseH5PTVReceiver(this, new Handler());
        }
        if (!bool3) {
          break label276;
        }
        if (j >= 1) {
          break label217;
        }
        doChooseFriendResult(null, null, null);
        return;
        bool1 = true;
        break;
      }
      paramString = new Intent((Context)localObject1, SelectMemberActivity.class);
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      doChooseFriendResultForH5(null, null, null, null);
      return;
    }
    label217:
    paramString.putExtra("param_donot_need_contacts", true);
    paramString.putExtra("param_min", 1);
    paramString.putExtra("param_max", j);
    paramString.putExtra("param_only_friends", true);
    paramString.addFlags(67108864);
    super.startActivityForResult(paramString, (byte)17);
    return;
    label276:
    Parcel localParcel = Parcel.obtain();
    this.mH5PTVReceiver.writeToParcel(localParcel, 0);
    localParcel.setDataPosition(0);
    Object localObject2 = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(localParcel);
    localParcel.recycle();
    localObject1 = new Intent((Context)localObject1, ForwardRecentActivity.class);
    ((Intent)localObject1).putExtra("forward_type", 25);
    ((Intent)localObject1).putExtra("choose_friend_title", paramString);
    ((Intent)localObject1).putExtra("choose_friend_is_qqfriends", bool1);
    ((Intent)localObject1).putExtra("choose_friend_is_contacts", bool2);
    ((Intent)localObject1).putExtra("choose_friend_callback", (Parcelable)localObject2);
    ((Intent)localObject1).putExtra("choose_friend_h5_type", i);
    super.startActivityForResult((Intent)localObject1, (byte)0);
  }
  
  private void chooseFriends(String paramString)
  {
    Object localObject1 = getCurrentContext();
    if ((localObject1 == null) || (TextUtils.isEmpty(paramString)))
    {
      doChooseFriendResult(null, null, null);
      return;
    }
    int j;
    boolean bool1;
    boolean bool2;
    try
    {
      localObject2 = new JSONObject(paramString);
      paramString = ((JSONObject)localObject2).optString("title", "选择我的好友");
      int i = ((JSONObject)localObject2).optInt("type", 0);
      this.mCallback = ((JSONObject)localObject2).optString("callback");
      boolean bool3 = Boolean.valueOf(((JSONObject)localObject2).optString("isMulti", "false")).booleanValue();
      j = Integer.valueOf(((JSONObject)localObject2).optString("limitNum", "0")).intValue();
      if ((i & 0x1) == 0)
      {
        bool1 = false;
        if ((i & 0x2) != 0) {
          break label138;
        }
      }
      label138:
      for (bool2 = false;; bool2 = true)
      {
        if (!bool3) {
          break label216;
        }
        if (j >= 1) {
          break label157;
        }
        doChooseFriendResult(null, null, null);
        return;
        bool1 = true;
        break;
      }
      paramString = new Intent((Context)localObject1, SelectMemberActivity.class);
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      doChooseFriendResult(null, null, null);
      return;
    }
    label157:
    paramString.putExtra("param_donot_need_contacts", true);
    paramString.putExtra("param_min", 1);
    paramString.putExtra("param_max", j);
    paramString.putExtra("param_only_friends", true);
    paramString.addFlags(67108864);
    super.startActivityForResult(paramString, (byte)17);
    return;
    label216:
    if (this.mChoFriReceiver == null) {
      this.mChoFriReceiver = new VasCommonJsPlugin.ChooseFriendReceiver(this, new Handler());
    }
    Parcel localParcel = Parcel.obtain();
    this.mChoFriReceiver.writeToParcel(localParcel, 0);
    localParcel.setDataPosition(0);
    Object localObject2 = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(localParcel);
    localParcel.recycle();
    localObject1 = new Intent((Context)localObject1, ForwardRecentActivity.class);
    ((Intent)localObject1).putExtra("forward_type", 15);
    ((Intent)localObject1).putExtra("choose_friend_title", paramString);
    ((Intent)localObject1).putExtra("choose_friend_is_qqfriends", bool1);
    ((Intent)localObject1).putExtra("choose_friend_is_contacts", bool2);
    ((Intent)localObject1).putExtra("choose_friend_callback", (Parcelable)localObject2);
    super.startActivityForResult((Intent)localObject1, (byte)0);
  }
  
  private void clearCache()
  {
    boolean bool = true;
    Object localObject = this.mRuntime.a();
    if (localObject == null) {}
    do
    {
      return;
      if ((((WebView)localObject).getX5WebViewExtension() != null) && (Looper.getMainLooper() != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VasCommonJsPlugin", 2, "clear all webview cache!");
        }
        QbSdk.clearAllWebViewCache(this.mRuntime.a(), true);
        return;
      }
    } while (!QLog.isColorLevel());
    localObject = new StringBuilder().append("clear webview cache got exception, isX5:").append(((WebView)localObject).getX5WebViewExtension()).append(", isMainThread: ");
    if (Looper.getMainLooper() != null) {}
    for (;;)
    {
      QLog.d("VasCommonJsPlugin", 2, bool);
      return;
      bool = false;
    }
  }
  
  public static void debug(String paramString, WebView paramWebView)
  {
    try
    {
      paramString = URLEncoder.encode("{\"msg\":\"nativeinfo==" + paramString + "\"}", "utf-8");
      paramString = "location.href=\"jsbridge://qw_debug/log?p=" + paramString + "\"";
      Looper localLooper1 = Looper.myLooper();
      Looper localLooper2 = Looper.getMainLooper();
      if (localLooper1 == localLooper2) {
        try
        {
          paramWebView.loadUrl("javascript:" + paramString);
          return;
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
          return;
        }
      }
      paramWebView.post(new VasCommonJsPlugin.6(paramWebView, paramString));
      return;
    }
    catch (Exception paramString) {}
  }
  
  private void doCallback(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      super.callJs(paramString1, new String[] { paramString2 });
    }
  }
  
  private File getConfDir()
  {
    Object localObject = null;
    if (0 == 0)
    {
      File localFile = new File(this.mRuntime.a().getApplication().getFilesDir(), "envconf");
      localObject = localFile;
      if (!localFile.exists())
      {
        localFile.mkdirs();
        localObject = localFile;
      }
    }
    return (File)localObject;
  }
  
  private Context getCurrentContext()
  {
    for (Activity localActivity = this.mRuntime.a(); (localActivity != null) && ((localActivity instanceof BasePluginActivity)); localActivity = ((BasePluginActivity)localActivity).getOutActivity()) {}
    return localActivity;
  }
  
  private void getPerformance(JSONObject paramJSONObject, WebView paramWebView)
  {
    bool1 = false;
    bool5 = true;
    bool6 = false;
    l3 = -1L;
    l23 = -1L;
    l25 = -1L;
    l27 = -1L;
    l26 = -1L;
    l24 = -1L;
    l22 = -1L;
    l21 = -1L;
    l20 = -1L;
    l19 = -1L;
    l18 = -1L;
    l17 = -1L;
    l16 = -1L;
    bool7 = false;
    localObject1 = this.mRuntime.a(this.mRuntime.a());
    if (localObject1 != null)
    {
      l2 = l16;
      l4 = l17;
      l5 = l18;
      l6 = l19;
      l7 = l20;
      l8 = l21;
      l9 = l22;
      l10 = l24;
      l11 = l26;
      l12 = l27;
      l13 = l25;
      l14 = l23;
      l1 = l3;
      bool4 = bool6;
      bool2 = bool5;
      bool3 = bool1;
    }
    try
    {
      if (!(localObject1 instanceof WebUiUtils.WebviewReportSpeedInterface)) {
        break label1894;
      }
      l2 = l16;
      l4 = l17;
      l5 = l18;
      l6 = l19;
      l7 = l20;
      l8 = l21;
      l9 = l22;
      l10 = l24;
      l11 = l26;
      l12 = l27;
      l13 = l25;
      l14 = l23;
      l1 = l3;
      bool4 = bool6;
      bool2 = bool5;
      bool3 = bool1;
      l3 = ((WebUiUtils.WebviewReportSpeedInterface)localObject1).b();
      l2 = l16;
      l4 = l17;
      l5 = l18;
      l6 = l19;
      l7 = l20;
      l8 = l21;
      l9 = l22;
      l10 = l24;
      l11 = l26;
      l12 = l27;
      l13 = l25;
      l14 = l23;
      l1 = l3;
      bool4 = bool6;
      bool2 = bool5;
      bool3 = bool1;
      bool1 = ((WebUiUtils.WebviewReportSpeedInterface)localObject1).d();
      l2 = l16;
      l4 = l17;
      l5 = l18;
      l6 = l19;
      l7 = l20;
      l8 = l21;
      l9 = l22;
      l10 = l24;
      l11 = l26;
      l12 = l27;
      l13 = l25;
      l14 = l23;
      l1 = l3;
      bool4 = bool6;
      bool2 = bool5;
      bool3 = bool1;
      bool5 = ((WebUiUtils.WebviewReportSpeedInterface)localObject1).e();
      l2 = l16;
      l4 = l17;
      l5 = l18;
      l6 = l19;
      l7 = l20;
      l8 = l21;
      l9 = l22;
      l10 = l24;
      l11 = l26;
      l12 = l27;
      l13 = l25;
      l14 = l23;
      l1 = l3;
      bool4 = bool6;
      bool2 = bool5;
      bool3 = bool1;
      bool6 = ((WebUiUtils.WebviewReportSpeedInterface)localObject1).f();
      l2 = l16;
      l4 = l17;
      l5 = l18;
      l6 = l19;
      l7 = l20;
      l8 = l21;
      l9 = l22;
      l10 = l24;
      l11 = l26;
      l12 = l27;
      l13 = l25;
      l14 = l23;
      l1 = l3;
      bool4 = bool6;
      bool2 = bool5;
      bool3 = bool1;
      l15 = ((WebUiUtils.WebviewReportSpeedInterface)localObject1).c();
      l2 = l16;
      l4 = l17;
      l5 = l18;
      l6 = l19;
      l7 = l20;
      l8 = l21;
      l9 = l22;
      l10 = l24;
      l11 = l26;
      l12 = l27;
      l13 = l25;
      l14 = l15;
      l1 = l3;
      bool4 = bool6;
      bool2 = bool5;
      bool3 = bool1;
      l23 = ((WebUiUtils.WebviewReportSpeedInterface)localObject1).d();
      l2 = l16;
      l4 = l17;
      l5 = l18;
      l6 = l19;
      l7 = l20;
      l8 = l21;
      l9 = l22;
      l10 = l24;
      l11 = l26;
      l12 = l27;
      l13 = l23;
      l14 = l15;
      l1 = l3;
      bool4 = bool6;
      bool2 = bool5;
      bool3 = bool1;
      l25 = ((WebUiUtils.WebviewReportSpeedInterface)localObject1).e();
      l2 = l16;
      l4 = l17;
      l5 = l18;
      l6 = l19;
      l7 = l20;
      l8 = l21;
      l9 = l22;
      l10 = l24;
      l11 = l26;
      l12 = l25;
      l13 = l23;
      l14 = l15;
      l1 = l3;
      bool4 = bool6;
      bool2 = bool5;
      bool3 = bool1;
      l26 = ((WebUiUtils.WebviewReportSpeedInterface)localObject1).f();
      l2 = l16;
      l4 = l17;
      l5 = l18;
      l6 = l19;
      l7 = l20;
      l8 = l21;
      l9 = l22;
      l10 = l24;
      l11 = l26;
      l12 = l25;
      l13 = l23;
      l14 = l15;
      l1 = l3;
      bool4 = bool6;
      bool2 = bool5;
      bool3 = bool1;
      l24 = ((WebUiUtils.WebviewReportSpeedInterface)localObject1).g();
      l2 = l16;
      l4 = l17;
      l5 = l18;
      l6 = l19;
      l7 = l20;
      l8 = l21;
      l9 = l22;
      l10 = l24;
      l11 = l26;
      l12 = l25;
      l13 = l23;
      l14 = l15;
      l1 = l3;
      bool4 = bool6;
      bool2 = bool5;
      bool3 = bool1;
      l22 = ((WebUiUtils.WebviewReportSpeedInterface)localObject1).h();
      l2 = l16;
      l4 = l17;
      l5 = l18;
      l6 = l19;
      l7 = l20;
      l8 = l21;
      l9 = l22;
      l10 = l24;
      l11 = l26;
      l12 = l25;
      l13 = l23;
      l14 = l15;
      l1 = l3;
      bool4 = bool6;
      bool2 = bool5;
      bool3 = bool1;
      l21 = ((WebUiUtils.WebviewReportSpeedInterface)localObject1).i();
      l2 = l16;
      l4 = l17;
      l5 = l18;
      l6 = l19;
      l7 = l20;
      l8 = l21;
      l9 = l22;
      l10 = l24;
      l11 = l26;
      l12 = l25;
      l13 = l23;
      l14 = l15;
      l1 = l3;
      bool4 = bool6;
      bool2 = bool5;
      bool3 = bool1;
      l20 = ((WebUiUtils.WebviewReportSpeedInterface)localObject1).j();
      l2 = l16;
      l4 = l17;
      l5 = l18;
      l6 = l19;
      l7 = l20;
      l8 = l21;
      l9 = l22;
      l10 = l24;
      l11 = l26;
      l12 = l25;
      l13 = l23;
      l14 = l15;
      l1 = l3;
      bool4 = bool6;
      bool2 = bool5;
      bool3 = bool1;
      l19 = ((WebUiUtils.WebviewReportSpeedInterface)localObject1).k();
      l2 = l16;
      l4 = l17;
      l5 = l18;
      l6 = l19;
      l7 = l20;
      l8 = l21;
      l9 = l22;
      l10 = l24;
      l11 = l26;
      l12 = l25;
      l13 = l23;
      l14 = l15;
      l1 = l3;
      bool4 = bool6;
      bool2 = bool5;
      bool3 = bool1;
      l18 = ((WebUiUtils.WebviewReportSpeedInterface)localObject1).l();
      l2 = l16;
      l4 = l17;
      l5 = l18;
      l6 = l19;
      l7 = l20;
      l8 = l21;
      l9 = l22;
      l10 = l24;
      l11 = l26;
      l12 = l25;
      l13 = l23;
      l14 = l15;
      l1 = l3;
      bool4 = bool6;
      bool2 = bool5;
      bool3 = bool1;
      l17 = ((WebUiUtils.WebviewReportSpeedInterface)localObject1).m();
      l2 = l16;
      l4 = l17;
      l5 = l18;
      l6 = l19;
      l7 = l20;
      l8 = l21;
      l9 = l22;
      l10 = l24;
      l11 = l26;
      l12 = l25;
      l13 = l23;
      l14 = l15;
      l1 = l3;
      bool4 = bool6;
      bool2 = bool5;
      bool3 = bool1;
      l16 = ((WebUiUtils.WebviewReportSpeedInterface)localObject1).n();
      l2 = l16;
      l4 = l17;
      l5 = l18;
      l6 = l19;
      l7 = l20;
      l8 = l21;
      l9 = l22;
      l10 = l24;
      l11 = l26;
      l12 = l25;
      l13 = l23;
      l14 = l15;
      l1 = l3;
      bool4 = bool6;
      bool2 = bool5;
      bool3 = bool1;
      boolean bool8 = ((WebUiUtils.WebviewReportSpeedInterface)localObject1).g();
      bool2 = bool8;
      l1 = l16;
      l2 = l17;
      l14 = l18;
      l4 = l19;
      l5 = l20;
      l7 = l21;
      l9 = l22;
      l10 = l24;
      l11 = l26;
      l12 = l25;
      l13 = l23;
      l6 = l15;
      bool3 = bool5;
      bool4 = bool1;
      bool1 = bool6;
      l8 = l3;
      l3 = l14;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          SwiftBrowserStatistics localSwiftBrowserStatistics;
          Object localObject2;
          WebViewPlugin localWebViewPlugin;
          l23 = localSwiftBrowserStatistics.b;
          l15 = l16;
          l14 = l17;
          l13 = l18;
          l12 = l19;
          l11 = l20;
          l10 = l21;
          l9 = l22;
          l8 = l24;
          l7 = l26;
          l6 = l27;
          l4 = l25;
          l5 = l23;
          l25 = localSwiftBrowserStatistics.n;
          l15 = l16;
          l14 = l17;
          l13 = l18;
          l12 = l19;
          l11 = l20;
          l10 = l21;
          l9 = l22;
          l8 = l24;
          l7 = l26;
          l6 = l27;
          l4 = l25;
          l5 = l23;
          l27 = localSwiftBrowserStatistics.o;
          l15 = l16;
          l14 = l17;
          l13 = l18;
          l12 = l19;
          l11 = l20;
          l10 = l21;
          l9 = l22;
          l8 = l24;
          l7 = l26;
          l6 = l27;
          l4 = l25;
          l5 = l23;
          l26 = localSwiftBrowserStatistics.p;
          l15 = l16;
          l14 = l17;
          l13 = l18;
          l12 = l19;
          l11 = l20;
          l10 = l21;
          l9 = l22;
          l8 = l24;
          l7 = l26;
          l6 = l27;
          l4 = l25;
          l5 = l23;
          l24 = localSwiftBrowserStatistics.i;
          l15 = l16;
          l14 = l17;
          l13 = l18;
          l12 = l19;
          l11 = l20;
          l10 = l21;
          l9 = l22;
          l8 = l24;
          l7 = l26;
          l6 = l27;
          l4 = l25;
          l5 = l23;
          l22 = localSwiftBrowserStatistics.j;
          l15 = l16;
          l14 = l17;
          l13 = l18;
          l12 = l19;
          l11 = l20;
          l10 = l21;
          l9 = l22;
          l8 = l24;
          l7 = l26;
          l6 = l27;
          l4 = l25;
          l5 = l23;
          l21 = localSwiftBrowserStatistics.k;
          l15 = l16;
          l14 = l17;
          l13 = l18;
          l12 = l19;
          l11 = l20;
          l10 = l21;
          l9 = l22;
          l8 = l24;
          l7 = l26;
          l6 = l27;
          l4 = l25;
          l5 = l23;
          l19 = localSwiftBrowserStatistics.jdField_m_of_type_Long;
          l20 = 0L;
          if (localObject1 != null)
          {
            l15 = l16;
            l14 = l17;
            l13 = l18;
            l12 = l20;
            l11 = l19;
            l10 = l21;
            l9 = l22;
            l8 = l24;
            l7 = l26;
            l6 = l27;
            l4 = l25;
            l5 = l23;
            l2 = ((OfflinePlugin)localObject1).a;
            if (localObject1 != null)
            {
              l15 = l16;
              l14 = l17;
              l13 = l2;
              l12 = l20;
              l11 = l19;
              l10 = l21;
              l9 = l22;
              l8 = l24;
              l7 = l26;
              l6 = l27;
              l4 = l25;
              l5 = l23;
              l1 = ((OfflinePlugin)localObject1).b;
              l15 = l16;
              l14 = l1;
              l13 = l2;
              l12 = l20;
              l11 = l19;
              l10 = l21;
              l9 = l22;
              l8 = l24;
              l7 = l26;
              l6 = l27;
              l4 = l25;
              l5 = l23;
              l16 = localSwiftBrowserStatistics.q;
              if (localObject1 == null) {
                continue;
              }
              l15 = l16;
              l14 = l1;
              l13 = l2;
              l12 = l20;
              l11 = l19;
              l10 = l21;
              l9 = l22;
              l8 = l24;
              l7 = l26;
              l6 = l27;
              l4 = l25;
              l5 = l23;
              bool2 = ((OfflinePlugin)localObject1).e;
              if (!bool2) {
                continue;
              }
              bool2 = true;
              bool4 = bool1;
              l4 = l2;
              l14 = 0L;
              l5 = l19;
              l7 = l21;
              l9 = l22;
              l10 = l24;
              l11 = l26;
              l12 = l27;
              l13 = l25;
              l6 = l23;
              l8 = l3;
              bool1 = bool6;
              bool3 = bool5;
              l2 = l1;
              l1 = l16;
              l3 = l4;
              l4 = l14;
              continue;
              bool1 = false;
              continue;
            }
          }
          else
          {
            l2 = 0L;
            continue;
          }
          l1 = 0L;
          continue;
          bool2 = false;
          continue;
          localException1 = localException1;
          bool1 = bool3;
          l3 = l1;
          l17 = l14;
          l18 = l13;
          l1 = l8;
          l13 = l7;
          l14 = l6;
          l15 = l5;
          l16 = l4;
        }
        catch (Exception localException2)
        {
          bool4 = bool6;
          l2 = l15;
          l16 = l14;
          long l15 = l13;
          l14 = l12;
          l13 = l11;
          l1 = l10;
          l10 = l8;
          l11 = l7;
          l12 = l6;
          l18 = l4;
          l17 = l5;
          bool2 = bool5;
          continue;
        }
        localException1.printStackTrace();
        l6 = l17;
        l8 = l3;
        bool3 = bool2;
        bool5 = bool1;
        l3 = l18;
        bool2 = bool7;
        l4 = l13;
        bool1 = bool4;
        bool4 = bool5;
        continue;
        paramWebView = "1";
        continue;
        paramJSONObject = ", redirect 302 cost: " + (l2 - l5);
        continue;
        paramJSONObject = ", check offline res cost: " + (l15 - l5);
        continue;
        paramJSONObject = ", read index cost: " + (l16 - l5);
        continue;
        bool2 = false;
        l1 = -1L;
        l2 = -1L;
        l3 = -1L;
        l4 = -1L;
        l5 = -1L;
        l7 = -1L;
        l9 = -1L;
        l10 = -1L;
        l11 = -1L;
        l12 = -1L;
        l13 = -1L;
        l6 = -1L;
        l8 = -1L;
        bool1 = false;
        bool3 = true;
        bool4 = false;
      }
    }
    l14 = l4;
    l17 = l1;
    l1 = l7;
    l4 = l5;
    l15 = l3;
    l16 = l2;
    l2 = l17;
    l3 = l13;
    l5 = l3;
    if (l3 == -1L) {
      l5 = this.onPageStartedTime;
    }
    paramJSONObject.put("clickStart", l6);
    paramJSONObject.put("pageStart", l5);
    paramJSONObject.put("pageFinish", this.onPageFinishedTime);
    paramJSONObject.put("webviewStart", l8);
    paramJSONObject.put("isUseLocalSrc", bool4);
    paramJSONObject.put("noLocalSrcType", HtmlOffline.K);
    paramJSONObject.put("isFirstRequest", bool3);
    paramJSONObject.put("isPreloadWebProcess", WebProcessManager.b());
    paramJSONObject.put("isWebViewCache", bool1);
    paramJSONObject.put("onCreate", l12);
    paramJSONObject.put("viewInflate", l11);
    paramJSONObject.put("getWebView", l10);
    paramJSONObject.put("initBrowser", l9);
    paramJSONObject.put("init", l1);
    paramJSONObject.put("initTBS", l4);
    paramJSONObject.put("pluginFinished", l14);
    if (l15 > 0L) {
      paramJSONObject.put("packageCheckFinish", l15);
    }
    if (l16 > 0L) {
      paramJSONObject.put("readIndexTime", l16);
    }
    if (l2 > 0L) {
      paramJSONObject.put("redirect302Time", l2);
    }
    paramJSONObject.put("isReloadUrl", bool2);
    if (paramWebView != null)
    {
      if (paramWebView.getX5WebViewExtension() == null)
      {
        paramWebView = "0";
        paramJSONObject.put("isX5", paramWebView);
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        paramWebView = new StringBuilder().append("");
        if (l2 > 0L) {
          break label3516;
        }
        paramJSONObject = "";
        paramWebView = paramWebView.append(paramJSONObject);
        if (l15 > 0L) {
          break label3544;
        }
        paramJSONObject = "";
        paramWebView = paramWebView.append(paramJSONObject);
        if (l16 > 0L) {
          break label3572;
        }
        paramJSONObject = "";
        QLog.i("QQBrowser_report", 2, paramJSONObject);
      }
      return;
      label1894:
      l2 = l16;
      l4 = l17;
      l5 = l18;
      l6 = l19;
      l7 = l20;
      l8 = l21;
      l9 = l22;
      l10 = l24;
      l11 = l26;
      l12 = l27;
      l13 = l25;
      l14 = l23;
      l1 = l3;
      bool4 = bool6;
      bool2 = bool5;
      bool3 = bool1;
      if (!(this.mRuntime.a() instanceof SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderSupporter)) {
        break label3656;
      }
      l2 = l16;
      l4 = l17;
      l5 = l18;
      l6 = l19;
      l7 = l20;
      l8 = l21;
      l9 = l22;
      l10 = l24;
      l11 = l26;
      l12 = l27;
      l13 = l25;
      l14 = l23;
      l1 = l3;
      bool4 = bool6;
      bool2 = bool5;
      bool3 = bool1;
      localSwiftBrowserStatistics = (SwiftBrowserStatistics)super.getBrowserComponent(-2);
      localObject2 = null;
      localObject1 = localObject2;
      l2 = l16;
      l4 = l17;
      l5 = l18;
      l6 = l19;
      l7 = l20;
      l8 = l21;
      l9 = l22;
      l10 = l24;
      l11 = l26;
      l12 = l27;
      l13 = l25;
      l14 = l23;
      l1 = l3;
      bool4 = bool6;
      bool2 = bool5;
      bool3 = bool1;
      if (this.mRuntime.a() != null)
      {
        l2 = l16;
        l4 = l17;
        l5 = l18;
        l6 = l19;
        l7 = l20;
        l8 = l21;
        l9 = l22;
        l10 = l24;
        l11 = l26;
        l12 = l27;
        l13 = l25;
        l14 = l23;
        l1 = l3;
        bool4 = bool6;
        bool2 = bool5;
        bool3 = bool1;
        localWebViewPlugin = this.mRuntime.a().a().a("offline");
        localObject1 = localObject2;
        if (localWebViewPlugin != null)
        {
          localObject1 = localObject2;
          l2 = l16;
          l4 = l17;
          l5 = l18;
          l6 = l19;
          l7 = l20;
          l8 = l21;
          l9 = l22;
          l10 = l24;
          l11 = l26;
          l12 = l27;
          l13 = l25;
          l14 = l23;
          l1 = l3;
          bool4 = bool6;
          bool2 = bool5;
          bool3 = bool1;
          if ((localWebViewPlugin instanceof OfflinePlugin))
          {
            l2 = l16;
            l4 = l17;
            l5 = l18;
            l6 = l19;
            l7 = l20;
            l8 = l21;
            l9 = l22;
            l10 = l24;
            l11 = l26;
            l12 = l27;
            l13 = l25;
            l14 = l23;
            l1 = l3;
            bool4 = bool6;
            bool2 = bool5;
            bool3 = bool1;
            localObject1 = (OfflinePlugin)localWebViewPlugin;
          }
        }
      }
      if (localSwiftBrowserStatistics == null) {
        break label3656;
      }
      l2 = l16;
      l4 = l17;
      l5 = l18;
      l6 = l19;
      l7 = l20;
      l8 = l21;
      l9 = l22;
      l10 = l24;
      l11 = l26;
      l12 = l27;
      l13 = l25;
      l14 = l23;
      l1 = l3;
      bool4 = bool6;
      bool2 = bool5;
      bool3 = bool1;
      l3 = localSwiftBrowserStatistics.jdField_c_of_type_Long;
      if (localObject1 != null)
      {
        l2 = l16;
        l4 = l17;
        l5 = l18;
        l6 = l19;
        l7 = l20;
        l8 = l21;
        l9 = l22;
        l10 = l24;
        l11 = l26;
        l12 = l27;
        l13 = l25;
        l14 = l23;
        l1 = l3;
        bool4 = bool6;
        bool2 = bool5;
        bool3 = bool1;
        bool1 = ((OfflinePlugin)localObject1).f;
        l2 = l16;
        l4 = l17;
        l5 = l18;
        l6 = l19;
        l7 = l20;
        l8 = l21;
        l9 = l22;
        l10 = l24;
        l11 = l26;
        l12 = l27;
        l13 = l25;
        l14 = l23;
        l1 = l3;
        bool4 = bool6;
        bool2 = bool5;
        bool3 = bool1;
        bool5 = localSwiftBrowserStatistics.jdField_c_of_type_Boolean;
        l2 = l16;
        l4 = l17;
        l5 = l18;
        l6 = l19;
        l7 = l20;
        l8 = l21;
        l9 = l22;
        l10 = l24;
        l11 = l26;
        l12 = l27;
        l13 = l25;
        l14 = l23;
        l1 = l3;
        bool4 = bool6;
        bool2 = bool5;
        bool3 = bool1;
        bool6 = SwiftBrowserStatistics.jdField_m_of_type_Boolean;
        l15 = l16;
        l14 = l17;
        l13 = l18;
        l12 = l19;
        l11 = l20;
        l10 = l21;
        l9 = l22;
        l8 = l24;
        l7 = l26;
        l6 = l27;
        l4 = l25;
        l5 = l23;
      }
    }
  }
  
  private void getPerformanceFromX5(JSONObject paramJSONObject)
  {
    Object localObject = this.mRuntime.a(this.mRuntime.a());
    if (localObject != null) {}
    for (;;)
    {
      long l1;
      long l6;
      try
      {
        if ((localObject instanceof WebUiUtils.WebviewReportSpeedInterface))
        {
          localObject = ((WebUiUtils.WebviewReportSpeedInterface)localObject).a();
          if (localObject == null) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.i("VasCommonJsPlugin", 2, "report X5 performance: " + localObject);
          }
          l5 = ((JSONObject)localObject).optLong("first_screen");
          l1 = ((JSONObject)localObject).optLong("dns_start");
          l2 = ((JSONObject)localObject).optLong("dns_end") - l1;
          if (l2 >= 0L)
          {
            l1 = ((JSONObject)localObject).optLong("send_start");
            l3 = ((JSONObject)localObject).optLong("connect_start");
            l3 = ((JSONObject)localObject).optLong("connect_end") - l3;
            if (l3 < 0L) {
              continue;
            }
            l6 = ((JSONObject)localObject).optLong("recv_start");
            l4 = ((JSONObject)localObject).optLong("recv_end");
            if (l1 != 0L) {
              continue;
            }
            l1 = l4 - l6;
            break label403;
            l4 = ((JSONObject)localObject).optLong("ssl_handshake_end") - ((JSONObject)localObject).optLong("ssl_handshake_start");
            if (l4 < 0L) {
              continue;
            }
            break label412;
            QLog.i("Web_X5_Performance", 1, "Web_X5_Load_Index, DNS cost: " + l2 + ", ssl_handshake cost: " + l4 + ", Connect cost: " + l3 + ", receive Cost: " + l1 + ", website Render Cost: " + l5);
            paramJSONObject.put("X5_dns", l2);
            paramJSONObject.put("X5_sslHandeShake", l4);
            paramJSONObject.put("X5_connect", l3);
            paramJSONObject.put("X5_receive", l1);
            paramJSONObject.put("X5_websiteRender", l5);
          }
        }
        else
        {
          if (!(this.mRuntime.a() instanceof SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderSupporter)) {
            break label398;
          }
          localObject = (SwiftBrowserStatistics)super.getBrowserComponent(-2);
          if (localObject == null) {
            break label398;
          }
          localObject = ((SwiftBrowserStatistics)localObject).a;
          continue;
        }
        long l2 = 0L;
        continue;
        long l3 = 0L;
        continue;
        l1 = l4 - l1;
        break label403;
        l1 = 0L;
        continue;
        long l4 = 0L;
      }
      catch (Exception paramJSONObject)
      {
        return;
      }
      long l5 = 0L;
      continue;
      label398:
      localObject = null;
      continue;
      label403:
      if (l1 >= 0L)
      {
        continue;
        label412:
        l5 -= l6;
        if (l5 < 0L) {}
      }
    }
  }
  
  private void processWebLog(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramString2 = localStringBuilder.append(paramString1).append("|").append(paramString2).append("|").append(paramString3).append("|").append("ANDROID").append("|").append("6.5.5.2880").append("|").append(DeviceInfoUtil.e()).append("|").append(this.mRuntime.a().a()).append("|").append(Build.MODEL).append("|");
    if (TextUtils.isEmpty(DeviceInfoUtil.a(this.mRuntime.a()).c))
    {
      paramString1 = "未知";
      paramString2 = paramString2.append(paramString1).append("|");
      if (!TextUtils.isEmpty(DeviceInfoUtil.a(this.mRuntime.a()).a)) {
        break label208;
      }
      paramString1 = "未知";
      label167:
      paramString2.append(paramString1);
      if (!paramBoolean) {
        break label225;
      }
      QLog.w("WebLog", 1, localStringBuilder.toString());
    }
    label208:
    label225:
    while (!QLog.isColorLevel())
    {
      return;
      paramString1 = DeviceInfoUtil.a(this.mRuntime.a()).c;
      break;
      paramString1 = DeviceInfoUtil.a(this.mRuntime.a()).a;
      break label167;
    }
    QLog.w("WebLog", 2, localStringBuilder.toString());
  }
  
  private String readConfig()
  {
    Object localObject = new File(getConfDir(), "proxy.conf");
    StringBuilder localStringBuilder;
    if (((File)localObject).exists()) {
      try
      {
        localObject = new FileReader(((File)localObject).getAbsolutePath());
        char[] arrayOfChar = new char['Ѐ'];
        localStringBuilder = new StringBuilder();
        for (;;)
        {
          int i = ((FileReader)localObject).read(arrayOfChar);
          if (i <= 0) {
            break;
          }
          localStringBuilder.append(arrayOfChar, 0, i);
        }
        return null;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
    localThrowable.close();
    String str = localStringBuilder.toString();
    return str;
  }
  
  private void reportMobilePerformance(JSONObject paramJSONObject, WebView paramWebView)
  {
    SwiftBrowserStatistics localSwiftBrowserStatistics = (SwiftBrowserStatistics)super.getBrowserComponent(-2);
    long l1;
    long l2;
    long l3;
    long l4;
    long l5;
    long l6;
    long l7;
    label119:
    int j;
    Object localObject;
    label163:
    int k;
    if (localSwiftBrowserStatistics != null)
    {
      l1 = localSwiftBrowserStatistics.r - localSwiftBrowserStatistics.b;
      l2 = localSwiftBrowserStatistics.s - localSwiftBrowserStatistics.r;
      l3 = localSwiftBrowserStatistics.t - localSwiftBrowserStatistics.s;
      l4 = localSwiftBrowserStatistics.u - localSwiftBrowserStatistics.t;
      l5 = localSwiftBrowserStatistics.v - localSwiftBrowserStatistics.u;
      l6 = localSwiftBrowserStatistics.j;
      l7 = localSwiftBrowserStatistics.n - localSwiftBrowserStatistics.w;
      if (!SwiftBrowserStatistics.jdField_m_of_type_Boolean) {
        break label743;
      }
      i = 3;
      if (paramWebView == null) {
        break label761;
      }
      paramWebView = paramWebView.getUrl();
      j = paramWebView.indexOf("?");
      localObject = paramWebView;
      if (j != -1) {
        localObject = paramWebView.substring(0, j);
      }
      if (!paramJSONObject.getString("isX5").equals("1")) {
        break label768;
      }
      j = 1;
      paramWebView = getCurrentNetwork();
      boolean bool = paramJSONObject.optBoolean("isUseLocalSrc", false);
      if (QLog.isColorLevel())
      {
        paramJSONObject = new StringBuilder().append("url: ").append((String)localObject).append("\n").append(" web process status: ").append(i).append(", is use offline: ");
        if (!bool) {
          break label774;
        }
        k = 1;
        label233:
        QLog.i("QQBrowser_report", 2, k + ", isX5: " + j + ", netType: " + paramWebView + ", create activity cost: " + l1 + ", before Do On Create cost: " + l2 + ", super Do On Create cost: " + l3 + ", before webview Create cost: " + l4 + ", webview create cost: " + l5 + ", init variable cost: " + 0L + ", init browser cost: " + l6 + ", before loadUrl cost: " + l7 + ", before loadUrl total cost: " + (localSwiftBrowserStatistics.n - localSwiftBrowserStatistics.b) + ", loadUrl cost: " + localSwiftBrowserStatistics.k + ", init UI cost: " + localSwiftBrowserStatistics.jdField_l_of_type_Long + ", page start cost: " + (localSwiftBrowserStatistics.d - localSwiftBrowserStatistics.x));
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append((String)localObject).append("|");
        localObject = paramJSONObject.append(i).append("|");
        if (!bool) {
          break label780;
        }
      }
    }
    label743:
    label761:
    label768:
    label774:
    label780:
    for (int i = 1;; i = 0)
    {
      ((StringBuilder)localObject).append(i).append("|");
      paramJSONObject.append(j).append("|").append(paramWebView).append("|");
      paramJSONObject.append(l1).append("|");
      paramJSONObject.append(l2).append("|");
      paramJSONObject.append(l3).append("|");
      paramJSONObject.append(l4).append("|");
      paramJSONObject.append(l5).append("|");
      paramJSONObject.append(0L).append("|");
      paramJSONObject.append(l6).append("|");
      paramJSONObject.append(l7).append("|");
      paramJSONObject.append(localSwiftBrowserStatistics.n - localSwiftBrowserStatistics.b).append("|");
      paramJSONObject.append(localSwiftBrowserStatistics.k).append("|");
      paramJSONObject.append(localSwiftBrowserStatistics.jdField_l_of_type_Long).append("|");
      paramJSONObject.append(localSwiftBrowserStatistics.d - localSwiftBrowserStatistics.x).append("|");
      paramJSONObject.append(0).append("|").append(0).append("|");
      paramJSONObject.append("d3_backup").append("|").append("d4_backup");
      DcReportUtil.a(null, "sendtdbank|b_sng_qqvip_vas_status_report|vas_network_speed_report", paramJSONObject.toString(), true);
      return;
      if (SwiftBrowserStatistics.jdField_l_of_type_Boolean) {}
      for (i = 1;; i = 2) {
        break;
      }
      paramWebView = "";
      break label119;
      j = 0;
      break label163;
      k = 0;
      break label233;
    }
  }
  
  /* Error */
  private boolean saveConfig(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 7
    //   3: new 359	java/io/File
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 686	com/tencent/mobileqq/vaswebviewplugin/VasCommonJsPlugin:getConfDir	()Ljava/io/File;
    //   11: ldc_w 688
    //   14: invokespecial 378	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   17: astore 5
    //   19: aload 5
    //   21: invokevirtual 381	java/io/File:exists	()Z
    //   24: ifeq +9 -> 33
    //   27: aload 5
    //   29: invokevirtual 813	java/io/File:delete	()Z
    //   32: pop
    //   33: new 815	java/io/RandomAccessFile
    //   36: dup
    //   37: aload 5
    //   39: ldc_w 817
    //   42: invokespecial 818	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   45: astore_3
    //   46: aload_3
    //   47: astore_2
    //   48: aload_3
    //   49: aload_1
    //   50: invokevirtual 822	java/lang/String:getBytes	()[B
    //   53: invokevirtual 826	java/io/RandomAccessFile:write	([B)V
    //   56: aload_3
    //   57: astore_2
    //   58: aload_3
    //   59: invokevirtual 827	java/io/RandomAccessFile:close	()V
    //   62: iconst_1
    //   63: istore 7
    //   65: iconst_0
    //   66: ifeq +11 -> 77
    //   69: new 829	java/lang/NullPointerException
    //   72: dup
    //   73: invokespecial 830	java/lang/NullPointerException:<init>	()V
    //   76: athrow
    //   77: iload 7
    //   79: istore 6
    //   81: ldc_w 832
    //   84: invokestatic 837	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   87: invokevirtual 743	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   90: ifeq +63 -> 153
    //   93: iload 7
    //   95: istore 6
    //   97: invokestatic 840	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   100: invokevirtual 843	java/io/File:canWrite	()Z
    //   103: ifeq +50 -> 153
    //   106: aload 5
    //   108: new 359	java/io/File
    //   111: dup
    //   112: new 114	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   119: invokestatic 840	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   122: invokevirtual 846	java/io/File:getPath	()Ljava/lang/String;
    //   125: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: ldc_w 848
    //   131: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: ldc_w 688
    //   137: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: invokespecial 849	java/io/File:<init>	(Ljava/lang/String;)V
    //   146: invokestatic 854	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/io/File;Ljava/io/File;)V
    //   149: iload 7
    //   151: istore 6
    //   153: iload 6
    //   155: ireturn
    //   156: astore_1
    //   157: aload_1
    //   158: invokevirtual 855	java/io/IOException:printStackTrace	()V
    //   161: goto -84 -> 77
    //   164: astore 4
    //   166: aconst_null
    //   167: astore_1
    //   168: aload_1
    //   169: astore_2
    //   170: aload 4
    //   172: invokevirtual 182	java/lang/Exception:printStackTrace	()V
    //   175: aload_1
    //   176: ifnull +7 -> 183
    //   179: aload_1
    //   180: invokevirtual 827	java/io/RandomAccessFile:close	()V
    //   183: iload 7
    //   185: istore 6
    //   187: ldc_w 832
    //   190: invokestatic 837	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   193: invokevirtual 743	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   196: ifeq -43 -> 153
    //   199: iload 7
    //   201: istore 6
    //   203: invokestatic 840	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   206: invokevirtual 843	java/io/File:canWrite	()Z
    //   209: ifeq -56 -> 153
    //   212: aload 5
    //   214: new 359	java/io/File
    //   217: dup
    //   218: new 114	java/lang/StringBuilder
    //   221: dup
    //   222: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   225: invokestatic 840	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   228: invokevirtual 846	java/io/File:getPath	()Ljava/lang/String;
    //   231: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: ldc_w 848
    //   237: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: ldc_w 688
    //   243: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   249: invokespecial 849	java/io/File:<init>	(Ljava/lang/String;)V
    //   252: invokestatic 854	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/io/File;Ljava/io/File;)V
    //   255: iconst_0
    //   256: ireturn
    //   257: astore_1
    //   258: aload_1
    //   259: invokevirtual 855	java/io/IOException:printStackTrace	()V
    //   262: goto -79 -> 183
    //   265: astore_1
    //   266: aconst_null
    //   267: astore_2
    //   268: aload_2
    //   269: ifnull +7 -> 276
    //   272: aload_2
    //   273: invokevirtual 827	java/io/RandomAccessFile:close	()V
    //   276: ldc_w 832
    //   279: invokestatic 837	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   282: invokevirtual 743	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   285: ifeq +55 -> 340
    //   288: invokestatic 840	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   291: invokevirtual 843	java/io/File:canWrite	()Z
    //   294: ifeq +46 -> 340
    //   297: aload 5
    //   299: new 359	java/io/File
    //   302: dup
    //   303: new 114	java/lang/StringBuilder
    //   306: dup
    //   307: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   310: invokestatic 840	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   313: invokevirtual 846	java/io/File:getPath	()Ljava/lang/String;
    //   316: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: ldc_w 848
    //   322: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: ldc_w 688
    //   328: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   334: invokespecial 849	java/io/File:<init>	(Ljava/lang/String;)V
    //   337: invokestatic 854	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/io/File;Ljava/io/File;)V
    //   340: aload_1
    //   341: athrow
    //   342: astore_2
    //   343: aload_2
    //   344: invokevirtual 855	java/io/IOException:printStackTrace	()V
    //   347: goto -71 -> 276
    //   350: astore_1
    //   351: goto -83 -> 268
    //   354: astore 4
    //   356: aload_3
    //   357: astore_1
    //   358: goto -190 -> 168
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	361	0	this	VasCommonJsPlugin
    //   0	361	1	paramString	String
    //   47	226	2	localObject	Object
    //   342	2	2	localIOException	java.io.IOException
    //   45	312	3	localRandomAccessFile	java.io.RandomAccessFile
    //   164	7	4	localException1	Exception
    //   354	1	4	localException2	Exception
    //   17	281	5	localFile	File
    //   79	123	6	bool1	boolean
    //   1	199	7	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   69	77	156	java/io/IOException
    //   33	46	164	java/lang/Exception
    //   179	183	257	java/io/IOException
    //   33	46	265	finally
    //   272	276	342	java/io/IOException
    //   48	56	350	finally
    //   58	62	350	finally
    //   170	175	350	finally
    //   48	56	354	java/lang/Exception
    //   58	62	354	java/lang/Exception
  }
  
  private void webLog(JSONObject paramJSONObject)
  {
    try
    {
      processWebLog(paramJSONObject.getString("id"), paramJSONObject.getString("subid"), paramJSONObject.getString("content"), paramJSONObject.getBoolean("isall"));
      return;
    }
    catch (Exception paramJSONObject) {}catch (JSONException paramJSONObject) {}
  }
  
  public void commitPerformanceToWebsite(JsBridgeListener paramJsBridgeListener)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      CustomWebView localCustomWebView = this.mRuntime.a();
      getPerformance(localJSONObject, localCustomWebView);
      getPerformanceFromX5(localJSONObject);
      reportMobilePerformance(localJSONObject, localCustomWebView);
      paramJsBridgeListener.a(localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      paramJsBridgeListener.a("JSONException:" + localJSONException.getMessage());
      localJSONException.printStackTrace();
      return;
    }
    catch (Exception localException)
    {
      paramJsBridgeListener.a("Exception:" + localException.getMessage());
      localException.printStackTrace();
    }
  }
  
  protected void doChooseFriendResult(List paramList1, List paramList2, List paramList3)
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject1 = new JSONObject();
        JSONArray localJSONArray = new JSONArray();
        if ((paramList1 != null) && (paramList2 != null) && (paramList3 != null))
        {
          int i = 0;
          if ((i < paramList1.size()) && (i < paramList2.size()) && (i < paramList3.size()))
          {
            String str1 = "";
            String str2 = "";
            if (!TextUtils.isEmpty((CharSequence)paramList1.get(i))) {
              str1 = (String)paramList1.get(i);
            }
            if (!TextUtils.isEmpty((CharSequence)paramList2.get(i))) {
              str2 = (String)paramList2.get(i);
            }
            if (TextUtils.isEmpty((CharSequence)paramList3.get(i))) {
              break label256;
            }
            str3 = (String)paramList3.get(i);
            JSONObject localJSONObject2 = new JSONObject();
            localJSONObject2.put("uin", str1);
            localJSONObject2.put("phone", str2);
            localJSONObject2.put("name", str3);
            localJSONArray.put(localJSONObject2);
            i += 1;
            continue;
          }
        }
        localJSONObject1.put("friends", localJSONArray);
        doCallback(this.mCallback, localJSONObject1.toString());
        return;
      }
      catch (JSONException paramList1)
      {
        paramList1.printStackTrace();
        return;
      }
      label256:
      String str3 = "";
    }
  }
  
  public void doChooseFriendResultForH5(List paramList1, List paramList2, List paramList3, List paramList4)
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject1 = new JSONObject();
        JSONArray localJSONArray = new JSONArray();
        if ((paramList1 != null) && (paramList2 != null) && (paramList3 != null) && (paramList4 != null))
        {
          int i = 0;
          if ((i < paramList1.size()) && (i < paramList2.size()) && (i < paramList3.size()) && (i < paramList4.size()))
          {
            String str1 = "";
            String str2 = "";
            String str3 = "";
            if (!TextUtils.isEmpty((CharSequence)paramList1.get(i))) {
              str1 = (String)paramList1.get(i);
            }
            if (!TextUtils.isEmpty((CharSequence)paramList2.get(i))) {
              str2 = (String)paramList2.get(i);
            }
            if (!TextUtils.isEmpty((CharSequence)paramList3.get(i))) {
              str3 = (String)paramList3.get(i);
            }
            if (TextUtils.isEmpty((CharSequence)paramList4.get(i))) {
              break label320;
            }
            str4 = (String)paramList4.get(i);
            JSONObject localJSONObject2 = new JSONObject();
            localJSONObject2.put("uin", str1);
            localJSONObject2.put("phone", str2);
            localJSONObject2.put("name", str3);
            localJSONObject2.put("type", str4);
            localJSONArray.put(localJSONObject2);
            i += 1;
            continue;
          }
        }
        localJSONObject1.put("friends", localJSONArray);
        doCallback(this.mCallback, localJSONObject1.toString());
        return;
      }
      catch (JSONException paramList1)
      {
        paramList1.printStackTrace();
        return;
      }
      label320:
      String str4 = "";
    }
  }
  
  public String getCurrentNetwork()
  {
    try
    {
      i = NetworkUtil.a(BaseApplicationImpl.a().getApplicationContext());
      switch (i)
      {
      default: 
        return "";
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = 0;
      }
      return "2G";
    }
    return "3G";
    return "4G";
    return "wifi";
  }
  
  public void getDensity(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      AppInterface localAppInterface = this.mRuntime.a();
      if (localAppInterface != null)
      {
        localJSONObject.put("density", ThemeUtil.getThemeDensity(localAppInterface.getApplication()));
        localJSONObject.put("result", 0);
      }
      for (;;)
      {
        super.callJs(paramString, new String[] { localJSONObject.toString() });
        return;
        localJSONObject.put("result", -1);
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      super.callJs(paramString, new String[] { localJSONException.getMessage() });
      localJSONException.printStackTrace();
    }
  }
  
  public String[] getMultiNameSpace()
  {
    return new String[] { "qw_debug", "qw_data", "friendData" };
  }
  
  public void getNickName(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VasCommonJsPlugin", 2, "getNickName " + paramJSONObject.toString());
    }
    try
    {
      ArrayList localArrayList = new ArrayList();
      paramJSONObject = paramJSONObject.getJSONArray("uins");
      int j = paramJSONObject.length();
      int i = 0;
      while (i < j)
      {
        localArrayList.add(paramJSONObject.getString(i));
        i += 1;
      }
      this.mReqBundle.clear();
      this.mReqBundle.putStringArrayList("uins", localArrayList);
      paramJSONObject = DataFactory.a("getNickName", paramString, this.mOnRemoteResp.key, this.mReqBundle);
      WebIPCOperator.a().a(paramJSONObject);
      return;
    }
    catch (Exception paramJSONObject)
    {
      if (QLog.isColorLevel()) {
        QLog.e("VasCommonJsPlugin", 2, "createShortcut failed: " + paramJSONObject.getMessage());
      }
      super.callJsOnError(paramString, paramJSONObject.getMessage());
    }
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool = false;
    if ((TextUtils.isEmpty(paramString2)) || ((!paramString2.startsWith("qw_debug")) && (!paramString2.startsWith("qw_data")) && (!paramString2.startsWith("friendData")))) {
      return false;
    }
    if (TextUtils.isEmpty(paramString3))
    {
      paramJsBridgeListener.a("method empty");
      return true;
    }
    try
    {
      if ("log".equals(paramString3))
      {
        if ((!this.logStop) && (this.logShowTag))
        {
          paramString1 = new JSONObject(paramVarArgs[0]);
          this.logInfo.add(paramString1.getString("msg"));
          if ((this.deBugDialog != null) && (this.deBugDialog.isShowing())) {
            this.deBugDialog.log(this.logInfo);
          }
        }
      }
      else if ("show".equals(paramString3)) {
        if (this.logStop) {
          paramJsBridgeListener.a("erro:please start log first");
        }
      }
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      paramJsBridgeListener.a("Exception:" + paramString1.getMessage());
    }
    if (this.deBugDialog == null) {
      this.deBugDialog = new VasCommonJsPlugin.JsDebugDialog(this, this.mRuntime.a());
    }
    if (new JSONObject(paramVarArgs[0]).getBoolean("flag")) {}
    for (this.logShowTag = true;; this.logShowTag = false)
    {
      this.deBugDialog.show();
      this.deBugDialog.log(this.logInfo);
      break;
    }
    if ("hide".equals(paramString3))
    {
      if (this.deBugDialog != null) {
        this.deBugDialog.dismiss();
      }
      if (new JSONObject(paramVarArgs[0]).getBoolean("flag")) {
        this.logShowTag = true;
      } else {
        this.logShowTag = false;
      }
    }
    else if ("start".equals(paramString3))
    {
      this.logStop = false;
    }
    else if ("stop".equals(paramString3))
    {
      this.logStop = true;
      this.logInfo.clear();
      if (this.deBugDialog != null) {
        this.deBugDialog.log(this.logInfo);
      }
    }
    else if ("qlog".equals(paramString3))
    {
      if (QLog.isColorLevel())
      {
        paramString1 = new JSONObject(paramVarArgs[0]);
        if (paramString1.has("msg")) {
          QLog.d("WebQlog", 2, paramString1.getString("msg"));
        }
      }
    }
    else if ("getPerformance".equals(paramString3))
    {
      commitPerformanceToWebsite(paramJsBridgeListener);
    }
    else
    {
      int i;
      if ("getVipType".equals(paramString3))
      {
        i = paramString1.indexOf("=");
        if ((i == -1) || (i + 1 > paramString1.length() - 1)) {
          throw new Exception("url illegal");
        }
        paramString1 = paramString1.substring(i + 1);
        if (paramString1 == null) {
          throw new Exception("json para illegal");
        }
        paramString1 = new JSONObject(URLDecoder.decode(paramString1, "UTF-8"));
        getVipType(paramString1, paramString1.getString("callback"));
      }
      else if ("startIpcService".equals(paramString3))
      {
        if (!WebIPCOperator.a().a()) {
          WebIPCOperator.a().a().doBindService(this.mRuntime.a().getApplicationContext());
        }
      }
      else if ("stopIpcService".equals(paramString3))
      {
        WebIPCOperator.a().a().doUnbindService(this.mRuntime.a().getApplicationContext());
      }
      else if ("isIpcStarted".equals(paramString3))
      {
        paramString1 = new JSONObject();
        paramString1.put("isIpcStarted", WebIPCOperator.a().a());
        paramJsBridgeListener.a(paramString1);
      }
      else if ("getFriendInfo".equals(paramString3))
      {
        if (paramVarArgs.length <= 0) {
          chooseFriends(null);
        } else {
          chooseFriends(paramVarArgs[0]);
        }
      }
      else if ("getFriendRemark".equals(paramString3))
      {
        paramString1 = new JSONObject(paramVarArgs[0]);
        getNickName(paramString1, paramString1.getString("callback"));
      }
      else if ("getDomainIpList".equals(paramString3))
      {
        i = paramString1.indexOf("=");
        if ((i == -1) || (i + 1 > paramString1.length() - 1)) {
          throw new Exception("url illegal");
        }
        paramString1 = paramString1.substring(i + 1);
        if (paramString1 == null) {
          throw new Exception("json para illegal");
        }
        paramString1 = new JSONObject(URLDecoder.decode(paramString1, "UTF-8"));
        super.getDomainIpList(paramString1, paramString1.getString("callback"));
      }
      else if ("getDensity".equals(paramString3))
      {
        i = paramString1.indexOf("=");
        if ((i == -1) || (i + 1 > paramString1.length() - 1)) {
          throw new Exception("url illegal");
        }
        paramString1 = paramString1.substring(i + 1);
        if (paramString1 == null) {
          throw new Exception("json para illegal");
        }
        getDensity(new JSONObject(URLDecoder.decode(paramString1, "UTF-8")).getString("callback"));
      }
      else
      {
        if ("detailLog".equals(paramString3))
        {
          webLog(new JSONObject(paramVarArgs[0]));
          return true;
        }
        if ("writeConfig".equals(paramString3)) {
          return true;
        }
        if ("readConfig".equals(paramString3)) {
          return true;
        }
        if ("selectedFriendInfo".equals(paramString3))
        {
          if (paramVarArgs.length <= 0) {
            H5chooseFriends(null);
          } else {
            H5chooseFriends(paramVarArgs[0]);
          }
        }
        else if ("setCurrentActivityShakeFlag".equals(paramString3))
        {
          if ((!TextUtils.isEmpty(paramVarArgs[0])) && (paramVarArgs[0].contains("flag")))
          {
            paramString1 = this.mRuntime.a();
            if ((paramString1 != null) && (!this.isDestroy) && (!paramString1.isFinishing()))
            {
              i = new JSONObject(paramVarArgs[0]).optInt("flag");
              if ((paramString1 instanceof BaseActivity))
              {
                paramString1 = (BaseActivity)paramString1;
                if (i > 0) {
                  bool = true;
                }
                paramString1.mCurrentActivityShakeFlag = bool;
                callJs(this.mCallback, new String[] { "{ result:0, msg: \"设置成功\" }" });
              }
              if (QLog.isColorLevel()) {
                QLog.d("VasCommonJsPlugin", 2, "setCurrentActivityShakeFlag:" + i);
              }
            }
          }
        }
        else
        {
          paramJsBridgeListener.a("no such method");
          return false;
        }
      }
    }
    return true;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    if (paramInt == -1) {
      if ((paramByte == 17) && (paramIntent != null)) {}
    }
    while (paramByte != 17)
    {
      return;
      try
      {
        localObject = paramIntent.getParcelableArrayListExtra("result_set");
        if ((localObject == null) || (((ArrayList)localObject).size() == 0))
        {
          doChooseFriendResult(null, null, null);
          return;
        }
      }
      catch (Exception paramIntent)
      {
        doChooseFriendResult(null, null, null);
        return;
      }
      paramIntent = new ArrayList();
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      Object localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ResultRecord localResultRecord = (ResultRecord)((Iterator)localObject).next();
        paramIntent.add(localResultRecord.a);
        localArrayList1.add("");
        localArrayList2.add(localResultRecord.b);
      }
      doChooseFriendResult(paramIntent, localArrayList1, localArrayList2);
      return;
    }
    doChooseFriendResult(null, null, null);
  }
  
  protected void onCreate()
  {
    super.onCreate();
  }
  
  protected void onResponse(Bundle paramBundle)
  {
    String str;
    if ((paramBundle != null) && (paramBundle.getInt("respkey", 0) == this.mOnRemoteResp.key))
    {
      Object localObject1 = paramBundle.getString("cmd");
      str = paramBundle.getString("callbackid");
      Object localObject2 = paramBundle.getBundle("response");
      if (QLog.isColorLevel()) {
        QLog.i("VasCommonJsPlugin", 2, "response:" + (String)localObject1);
      }
      if ((localObject1 != null) && ("getNickName".equals(localObject1)))
      {
        paramBundle = new JSONObject();
        localObject1 = new JSONObject();
        try
        {
          localObject2 = ((HashMap)((Bundle)localObject2).getSerializable("friendsMap")).entrySet().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
            ((JSONObject)localObject1).put((String)localEntry.getKey(), localEntry.getValue());
            continue;
            doCallback(str, paramBundle.toString());
          }
        }
        catch (JSONException localJSONException)
        {
          super.callJsOnError(str, localJSONException.getMessage());
        }
      }
    }
    for (;;)
    {
      return;
      paramBundle.put("remarks", localJSONException);
    }
  }
  
  public void openX5Proxy(boolean paramBoolean)
  {
    int i = 0;
    Object localObject = this.mRuntime.a();
    boolean bool2 = EnvSwitchActivity.checkUseX5AutoTestMode();
    SharedPreferences.Editor localEditor;
    if ((localObject != null) && (((Activity)localObject).getApplication() != null))
    {
      localObject = ((Activity)localObject).getApplication().getSharedPreferences("x5_proxy_setting", 4);
      localEditor = ((SharedPreferences)localObject).edit();
      ((SharedPreferences)localObject).getBoolean("post_encription", true);
      if ((paramBoolean) || (bool2)) {
        break label152;
      }
    }
    label152:
    for (boolean bool1 = true;; bool1 = false)
    {
      localEditor.putBoolean("post_encription", bool1);
      localEditor.putString("qproxy_address", "http://127.0.0.1:8080");
      if ((paramBoolean) || (bool2)) {
        i = 1;
      }
      localEditor.putInt("connect_status", i);
      localEditor.putString("qproxy_address_lists", "127.0.0.1:8080");
      localEditor.putString("http_proxy_address", "127.0.0.1:8080");
      localEditor.commit();
      return;
    }
  }
  
  public void showMsgBox(JSONObject paramJSONObject, JsBridgeListener paramJsBridgeListener)
  {
    try
    {
      String str1 = paramJSONObject.getString("prompt");
      String str2 = paramJSONObject.getString("title");
      Object localObject = paramJSONObject.getString("button");
      paramJSONObject = ((String)localObject).split("\t");
      if (QLog.isColorLevel()) {
        QLog.i("VasCommonJsPlugin", 2, "CommonJsHandler showMsgBox prompt=" + str1 + ",title=" + str2 + ",button=" + (String)localObject);
      }
      if (paramJSONObject.length >= 1)
      {
        localObject = DialogUtil.a(this.mRuntime.a(), 230);
        ((QQCustomDialogThreeBtns)localObject).a(str2);
        ((QQCustomDialogThreeBtns)localObject).b(str1);
        ((QQCustomDialogThreeBtns)localObject).a(paramJSONObject[0], new VasCommonJsPlugin.2(this, paramJsBridgeListener));
        if (paramJSONObject.length >= 2) {
          ((QQCustomDialogThreeBtns)localObject).b(paramJSONObject[1], new VasCommonJsPlugin.3(this, paramJsBridgeListener));
        }
        if (paramJSONObject.length >= 3) {
          ((QQCustomDialogThreeBtns)localObject).c(paramJSONObject[2], new VasCommonJsPlugin.4(this, paramJsBridgeListener));
        }
        ((QQCustomDialogThreeBtns)localObject).setCanceledOnTouchOutside(false);
        ((QQCustomDialogThreeBtns)localObject).setOnKeyListener(new VasCommonJsPlugin.5(this, (QQCustomDialogThreeBtns)localObject, paramJsBridgeListener));
        ((QQCustomDialogThreeBtns)localObject).show();
        return;
      }
      paramJsBridgeListener.a("not find buttons" + (String)localObject);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJsBridgeListener.a("JSONException params error:" + paramJSONObject.getMessage());
      paramJSONObject.printStackTrace();
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJsBridgeListener.a("Exception:" + paramJSONObject.getMessage());
      paramJSONObject.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vaswebviewplugin\VasCommonJsPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */