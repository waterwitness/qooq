package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.offline.HtmlOffline.MyWebResourceResponse;
import com.tencent.biz.common.util.LoadedBack2;
import com.tencent.biz.common.util.OfflineSecurity;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.util.OfflineUpdateStatus;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.OfflineWebRes;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebUiBaseInterface;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserOfflineHandler;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.OfflinePluginInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.QQBrowserBaseActivityInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebUiMethodInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import jhi;
import jhj;
import jhk;
import jhl;
import jhm;
import jhn;
import jho;
import jhp;
import jhq;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class OfflinePlugin
  extends WebViewPlugin
{
  private static Context jdField_a_of_type_AndroidContentContext;
  public static final String a = "OfflinePlugin_handleOfflinePackage";
  public static HashMap a;
  public static ConcurrentHashMap a;
  static final int jdField_b_of_type_Int;
  public static final String b = "OfflinePlugin_verifySign_";
  public static HashMap b;
  public static final String c = "OfflinePlugin_verifySingleFile_";
  public static final String d = "OfflinePlugin_offlineGetResponse_";
  public static final int e = 1;
  public static final String e = "offline";
  public static final int f = 2;
  public static final int g = 3;
  private static boolean g = false;
  public static final int h = 0;
  private static final String jdField_h_of_type_JavaLangString = "OfflinePluginQQ";
  public static final int i = 1;
  public static final int j = 2;
  private static final int k = 121;
  protected int a;
  public volatile long a;
  public Handler a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new jhn(this);
  public LinearLayout a;
  public ProgressBar a;
  public RelativeLayout a;
  public TextView a;
  private AuthorizeConfig jdField_a_of_type_ComTencentBizAuthorizeConfig;
  private LoadedBack2 jdField_a_of_type_ComTencentBizCommonUtilLoadedBack2 = new jho(this);
  public OfflineWebResManager a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new jhp(this);
  public CopyOnWriteArrayList a;
  protected CopyOnWriteArraySet a;
  public AtomicBoolean a;
  public AtomicInteger a;
  public boolean a;
  public volatile long b;
  boolean jdField_b_of_type_Boolean = false;
  public volatile int c;
  boolean c;
  public volatile int d;
  public volatile boolean d;
  public volatile boolean e;
  public String f;
  public boolean f;
  public String g;
  private boolean jdField_h_of_type_Boolean;
  private String i;
  private String j;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_b_of_type_Int = Build.VERSION.SDK_INT;
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public OfflinePlugin()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_b_of_type_Long = -1L;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_g_of_type_JavaLangString = "";
    this.mPluginNameSpace = "offline";
  }
  
  private void a(String paramString, int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    if (!TextUtils.isEmpty(this.i))
    {
      if (QLog.isColorLevel()) {
        QLog.i("OfflinePluginQQ", 2, "OfflinePlugin handleSchemaRequest loadMode: " + this.jdField_c_of_type_Int + ", bid: " + this.i + ", cost: " + this.d);
      }
      a(paramString);
      a(this.i, "Offline_Check", this.d, 2, paramString, String.valueOf(this.jdField_c_of_type_Int), "");
    }
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5)
  {
    if (jdField_a_of_type_AndroidContentContext == null) {
      jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getContext();
    }
    if (jdField_a_of_type_AndroidContentContext != null) {}
    for (int m = com.tencent.biz.common.util.NetworkUtil.a(jdField_a_of_type_AndroidContentContext);; m = -1)
    {
      String str2 = "";
      String str1 = str2;
      int n;
      if (!TextUtils.isEmpty(paramString3)) {
        if (!paramString3.startsWith("http"))
        {
          str1 = str2;
          if (!paramString3.startsWith("https")) {}
        }
        else
        {
          n = paramString3.indexOf("?");
          if (n == -1) {
            break label118;
          }
        }
      }
      label118:
      for (str1 = paramString3.substring(0, n);; str1 = paramString3)
      {
        ReportController.b(null, "P_CliOper", "OfflineStatusReport", "", paramString2, paramString1, paramInt1, 1, paramInt2, str1, paramString4, paramString5, String.valueOf(m));
        return;
      }
    }
  }
  
  private void a(JSONObject paramJSONObject)
  {
    if (TextUtils.isEmpty(this.j)) {}
    do
    {
      OfflineUpdateStatus localOfflineUpdateStatus;
      Object localObject2;
      int m;
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              localObject1 = this.mRuntime.a();
            } while (localObject1 == null);
            if (jdField_a_of_type_JavaUtilHashMap == null) {
              jdField_a_of_type_JavaUtilHashMap = new HashMap();
            }
          } while ((OfflineUpdateStatus)jdField_a_of_type_JavaUtilHashMap.get(this.j) != null);
          localOfflineUpdateStatus = new OfflineUpdateStatus(this.j);
          localOfflineUpdateStatus.a(this.jdField_a_of_type_ComTencentBizCommonUtilLoadedBack2);
          localObject2 = paramJSONObject.optJSONObject("wording");
          if (localObject2 != null)
          {
            localOfflineUpdateStatus.c = ((JSONObject)localObject2).optString("nonWifiUpdatingText");
            localOfflineUpdateStatus.b = ((JSONObject)localObject2).optString("wifiUpdatingText");
            localOfflineUpdateStatus.d = ((JSONObject)localObject2).optString("updateCompletedText");
          }
          localOfflineUpdateStatus.e = ((Activity)localObject1).getResources().getString(2131364642);
          jdField_a_of_type_JavaUtilHashMap.put(this.j, localOfflineUpdateStatus);
          localObject2 = paramJSONObject.optString("url");
          localOfflineUpdateStatus.jdField_f_of_type_JavaLangString = ((String)localObject2);
          m = paramJSONObject.optInt("filesize");
          localOfflineUpdateStatus.jdField_f_of_type_Int = m;
          if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          }
          if (!com.tencent.mobileqq.utils.NetworkUtil.i(((Activity)localObject1).getApplicationContext())) {
            break;
          }
          localOfflineUpdateStatus.e = localOfflineUpdateStatus.b;
          paramJSONObject = localOfflineUpdateStatus.e;
        } while ((TextUtils.isEmpty((CharSequence)localObject2)) || (m <= 0));
        d();
        localOfflineUpdateStatus.b(1);
        if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(paramJSONObject + "0%");
        }
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        }
        if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
          this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
        }
        if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
          this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        }
        if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        }
        HtmlOffline.a(((Activity)localObject1).getApplicationContext(), this.j, (String)localObject2, m, localOfflineUpdateStatus);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 2000L);
        return;
        paramJSONObject = localOfflineUpdateStatus.c;
      } while ((TextUtils.isEmpty((CharSequence)localObject2)) || (m <= 0));
      d();
      localOfflineUpdateStatus.b(0);
      Object localObject1 = ((Activity)localObject1).getResources().getDrawable(2130840616);
      ((Drawable)localObject1).setBounds(0, 0, 40, 40);
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables((Drawable)localObject1, null, null, null);
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramJSONObject);
      }
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
    } while (this.jdField_a_of_type_AndroidWidgetProgressBar == null);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
  }
  
  private WebResourceResponse b(String paramString1, String paramString2)
  {
    String str = HtmlOffline.g(paramString1);
    if ((TextUtils.isEmpty(this.i)) || (!paramString2.equals(this.i)))
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet == null) {
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
      }
      if (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.contains(paramString2))
      {
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(paramString2);
        if (QLog.isColorLevel()) {
          QLog.i("OfflinePluginQQ", 2, "now begin check ex bid : " + paramString2);
        }
        Util.a("OfflinePlugin_verifySign_" + paramString2);
        if (!HtmlOffline.f(paramString2)) {}
        for (m = 1;; m = 0)
        {
          Util.b("OfflinePlugin_verifySign_" + paramString2);
          if (m == 0) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("OfflinePluginQQ", 2, "verfySign fail to reload");
          }
          return null;
        }
      }
    }
    for (int m = 1;; m = 0)
    {
      if ((this.jdField_c_of_type_Int == 3) || (m != 0))
      {
        Util.a("OfflinePlugin_verifySingleFile_" + str);
        if (!HtmlOffline.a(paramString2, paramString1)) {}
        for (int n = 1;; n = 0)
        {
          Util.b("OfflinePlugin_verifySingleFile_" + str);
          if (n == 0) {
            break label305;
          }
          if (m == 0)
          {
            this.e = true;
            b();
          }
          a(paramString2, "Offline_InterceptRequest", 0, 3, paramString1, "", "");
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("OfflinePluginQQ", 2, "shouldInterceptRequest verfy single fail to reload");
          return null;
        }
      }
      label305:
      Util.a("OfflinePlugin_offlineGetResponse_" + str);
      paramString1 = HtmlOffline.a(paramString2, paramString1);
      if (paramString1 == null) {}
      for (paramString1 = null;; paramString1 = new WebResourceResponse(paramString1.jdField_a_of_type_JavaLangString, "utf-8", paramString1.jdField_a_of_type_JavaIoInputStream))
      {
        Util.b("OfflinePlugin_offlineGetResponse_" + str);
        if (paramString1 != null)
        {
          this.h = true;
          if (m == 0) {
            this.jdField_f_of_type_Boolean = true;
          }
        }
        return paramString1;
      }
    }
  }
  
  private boolean b(String paramString)
  {
    paramString = SwiftBrowserOfflineHandler.a(paramString);
    if (paramString != null)
    {
      paramString.a();
      if (SwiftBrowserOfflineHandler.b.get() == 4)
      {
        this.i = null;
        this.jdField_c_of_type_Boolean = true;
        return true;
      }
    }
    return false;
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidOsHandler = new jhj(this, Looper.getMainLooper());
  }
  
  public static void c(String paramString)
  {
    if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ThreadManager.a().post(new jhq(paramString));
  }
  
  private void d()
  {
    if (this.mRuntime.a() == null) {}
    do
    {
      ViewStub localViewStub;
      do
      {
        return;
        localViewStub = (ViewStub)this.mRuntime.a().findViewById(2131297377);
      } while (localViewStub == null);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localViewStub.inflate());
    } while (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131297384));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131297383));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131297382));
  }
  
  public static void d(String paramString)
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    paramString = SwiftBrowserOfflineHandler.b(paramString);
    if (paramString != null) {
      paramString.b();
    }
  }
  
  private void e(String paramString)
  {
    Object localObject;
    if (this.jdField_b_of_type_Long == -1L)
    {
      localObject = this.mRuntime.a();
      if (!(localObject instanceof QQBrowserActivity)) {
        break label108;
      }
      localObject = (QQBrowserActivity)localObject;
      if (!TextUtils.isEmpty(((QQBrowserActivity)localObject).G)) {
        this.jdField_g_of_type_JavaLangString = ((QQBrowserActivity)localObject).G;
      }
      localObject = HtmlOffline.g(this.jdField_g_of_type_JavaLangString);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        if (!((String)localObject).equalsIgnoreCase(paramString)) {
          break label140;
        }
      }
    }
    label108:
    label140:
    for (long l = System.currentTimeMillis();; l = -1L)
    {
      this.jdField_b_of_type_Long = l;
      if ((QLog.isColorLevel()) && (this.jdField_b_of_type_Long != -1L)) {
        QLog.d("OfflinePluginQQ", 2, "read index offline res!");
      }
      return;
      if (!(localObject instanceof WebUiUtils.OfflinePluginInterface)) {
        break;
      }
      localObject = ((WebUiUtils.OfflinePluginInterface)localObject).a();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break;
      }
      this.jdField_g_of_type_JavaLangString = ((String)localObject);
      break;
    }
  }
  
  public WebResourceResponse a(String paramString)
  {
    if ((this.jdField_c_of_type_Boolean) || (TextUtils.isEmpty(paramString)) || (!paramString.startsWith("http"))) {
      return null;
    }
    label412:
    for (;;)
    {
      Object localObject1;
      try
      {
        localObject1 = Uri.parse(paramString).getQueryParameter("_bid");
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label412;
        }
        localObject1 = this.i;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          return null;
        }
        if (!((String)localObject1).equals(this.i))
        {
          if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
            continue;
          }
          if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) {
            this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
          }
          if (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramString)) {
            this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramString);
          }
        }
        localObject2 = HtmlOffline.a((String)localObject1);
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          return null;
          b(paramString);
          continue;
        }
        localObject2 = (String)localObject2 + (String)localObject1 + File.separator;
      }
      catch (Exception paramString)
      {
        QLog.e("OfflinePluginQQ", 1, "OfflinePlugin shouldInterceptRequest got Exception", paramString);
        return null;
      }
      String str = HtmlOffline.g(paramString);
      if (((String)localObject1).equals(this.i))
      {
        localObject3 = (ArrayList)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject1);
        if ((localObject3 == null) || (((ArrayList)localObject3).size() <= 0)) {
          break;
        }
        if (!((ArrayList)localObject3).contains((String)localObject2 + str)) {
          return null;
        }
      }
      Object localObject3 = a(paramString, (String)localObject1);
      Object localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = b(paramString, (String)localObject1);
      }
      if (localObject2 != null)
      {
        if (((String)localObject1).equals(this.i)) {
          this.jdField_f_of_type_Boolean = true;
        }
        localObject3 = ((WebResourceResponse)localObject2).getResponseHeaders();
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = new HashMap();
        }
        ((Map)localObject1).put("Access-Control-Allow-Origin", "*");
        ((WebResourceResponse)localObject2).setResponseHeaders((Map)localObject1);
        OfflineWebResManager.a(paramString);
        e(str);
      }
      if (localObject2 != null)
      {
        QLog.d("OfflinePluginQQ", 2, "Url(" + paramString + ") uses the offline res");
        return (WebResourceResponse)localObject2;
      }
      QLog.d("OfflinePluginQQ", 2, "Url(" + paramString + ") does not  use the offline res");
      return (WebResourceResponse)localObject2;
    }
    return null;
  }
  
  public WebResourceResponse a(String paramString1, String paramString2)
  {
    long l1;
    long l2;
    try
    {
      l1 = System.currentTimeMillis();
      if ((HtmlOffline.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (HtmlOffline.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString2))) {}
      for (paramString2 = (String)HtmlOffline.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString2);; paramString2 = (String)localObject1)
      {
        l2 = System.currentTimeMillis();
        if (!TextUtils.isEmpty(paramString2)) {
          break;
        }
        return null;
        localObject1 = HtmlOffline.a(paramString2) + paramString2 + "/verify.json";
        if (!new File((String)localObject1).exists()) {
          return null;
        }
        localObject2 = new BufferedInputStream(new FileInputStream((String)localObject1));
        localObject1 = OfflineSecurity.a((BufferedInputStream)localObject2);
        ((BufferedInputStream)localObject2).close();
        HtmlOffline.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString2, localObject1);
      }
      localObject1 = new JSONObject(paramString2);
    }
    catch (Exception paramString1)
    {
      QLog.e("OfflinePluginQQ", 1, "getOfflineResFromDatabase got exception!", paramString1);
      return null;
    }
    paramString2 = HtmlOffline.g(paramString1);
    Object localObject1 = ((JSONObject)localObject1).optString(paramString2);
    long l3 = System.currentTimeMillis();
    Object localObject2 = BaseApplicationImpl.a().a();
    if ((this.jdField_a_of_type_ComTencentBizWebviewpluginOfflineWebResManager == null) && ((localObject2 instanceof AppInterface))) {
      this.jdField_a_of_type_ComTencentBizWebviewpluginOfflineWebResManager = new OfflineWebResManager((AppInterface)localObject2);
    }
    if (this.jdField_a_of_type_ComTencentBizWebviewpluginOfflineWebResManager == null) {
      return null;
    }
    localObject1 = this.jdField_a_of_type_ComTencentBizWebviewpluginOfflineWebResManager.a((String)localObject1);
    long l4 = System.currentTimeMillis();
    if (localObject1 == null) {
      return null;
    }
    localObject2 = new File(BaseApplicationImpl.getContext().getFilesDir(), "WebOfflineRes");
    if ((!((File)localObject2).exists()) && (!((File)localObject2).mkdirs())) {
      return null;
    }
    if (paramString2.contains(".css")) {
      paramString2 = "text/css";
    }
    for (;;)
    {
      localObject1 = new File((File)localObject2, ((OfflineWebRes)localObject1).hashName);
      if (!((File)localObject1).exists()) {
        break;
      }
      paramString2 = new WebResourceResponse(paramString2, "utf-8", new BufferedInputStream(new FileInputStream((File)localObject1)));
      if ((paramString2 == null) || (!QLog.isColorLevel())) {
        return paramString2;
      }
      QLog.d("OfflinePluginQQ", 2, "shouldInterceptRequest from database return local res, readMd5File: " + (l2 - l1) + ", getMd5: " + (l3 - l2) + ", query: " + (l4 - l3) + ", totalCost: " + (System.currentTimeMillis() - l1) + ", filePath: " + HtmlOffline.g(paramString1));
      return paramString2;
      if (paramString2.contains(".js")) {
        paramString2 = "application/x-javascript";
      } else if ((paramString2.contains(".jpg")) || (paramString2.contains(".gif")) || (paramString2.contains(".png")) || (paramString2.contains(".jpeg"))) {
        paramString2 = "image/*";
      } else {
        paramString2 = "text/html";
      }
    }
    return paramString2;
  }
  
  public String a()
  {
    return this.i;
  }
  
  protected String a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("OfflinePluginQQ", 2, "-->offlien:checkOfflineUrl");
    }
    if ((TextUtils.isEmpty(paramString)) || (!Uri.parse(paramString).isHierarchical())) {}
    for (;;)
    {
      return paramString;
      try
      {
        this.i = Uri.parse(paramString).getQueryParameter("_bid");
        if (this.j == null) {
          this.j = this.i;
        }
        if ((TextUtils.isEmpty(this.i)) && (this.jdField_a_of_type_ComTencentBizAuthorizeConfig != null))
        {
          this.i = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.b(paramString);
          if (this.j == null) {
            this.j = this.i;
          }
          if (!TextUtils.isEmpty(this.i))
          {
            String str1 = HtmlOffline.a(paramString, "_bid=" + this.i);
            if (b(str1)) {
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.i("OfflinePluginQQ", 2, "-->offline:checkOfflineUrl:" + Util.b(str1, new String[0]));
            }
            return str1;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          continue;
          String str2 = paramString;
        }
      }
    }
  }
  
  public void a()
  {
    if ((jdField_a_of_type_JavaUtilHashMap != null) && (!TextUtils.isEmpty(this.j)))
    {
      OfflineUpdateStatus localOfflineUpdateStatus = (OfflineUpdateStatus)jdField_a_of_type_JavaUtilHashMap.get(this.j);
      if (localOfflineUpdateStatus != null) {
        localOfflineUpdateStatus.a();
      }
    }
    b();
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("OfflinePluginQQ", 2, "-->offline:checkOfflineUp,url=" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {}
    while (!a(paramString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("OfflinePluginQQ", 2, "-->offline:checkOfflineUp.");
    }
    HtmlOffline.a(paramString, this.mRuntime.a(), new jhi(this));
  }
  
  public boolean a()
  {
    return this.h;
  }
  
  protected boolean a(String paramString)
  {
    Object localObject2 = "0";
    try
    {
      String str = Uri.parse(paramString).getQueryParameter("_duck");
      localObject2 = str;
      if (TextUtils.isEmpty(str)) {
        localObject2 = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.c(paramString);
      }
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).equals("1")))
      {
        if (QLog.isDevelopLevel()) {
          QLog.e("webviewLoadUrl", 4, "1 checkOfflineUp _duck=1");
        }
        return false;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.e("QQBrowserActivity", 2, "checkOfflineUpr:url parse exception:" + Util.b(paramString, new String[0]));
          localObject1 = localObject2;
        }
      }
    }
    return true;
  }
  
  public String b(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!Uri.parse(paramString).isHierarchical())) {}
    String str1;
    String str2;
    String str3;
    do
    {
      return paramString;
      paramString = Uri.parse(paramString);
      str1 = paramString.getPath();
      str2 = paramString.getHost();
      str3 = paramString.getQueryParameter("_bid");
      if (!TextUtils.isEmpty(str2)) {
        break;
      }
      paramString = str1;
    } while (TextUtils.isEmpty(str3));
    return str2 + str1 + "?_bid=" + str3;
  }
  
  public void b()
  {
    if (this.mRuntime.a() == null) {}
    do
    {
      WebUiBaseInterface localWebUiBaseInterface;
      CustomWebView localCustomWebView;
      do
      {
        do
        {
          return;
          localWebUiBaseInterface = this.mRuntime.a(this.mRuntime.a());
        } while ((localWebUiBaseInterface == null) || (!(localWebUiBaseInterface instanceof WebUiUtils.WebUiMethodInterface)));
        localCustomWebView = this.mRuntime.a();
      } while (localCustomWebView == null);
      localCustomWebView.loadUrl(((WebUiUtils.WebUiMethodInterface)localWebUiBaseInterface).getCurrentUrl());
    } while (!QLog.isColorLevel());
    QLog.i("OfflinePluginQQ", 2, "reloadCurrentUrl");
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!a(paramString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("OfflinePluginQQ", 2, "checkOfflineUpNotCallback.");
    }
    HtmlOffline.a(paramString, this.mRuntime.a());
  }
  
  protected Object handleEvent(String paramString, long paramLong)
  {
    if (paramLong == 8L)
    {
      Util.a("OfflinePlugin_handleOfflinePackage");
      paramString = a(paramString);
      Util.b("OfflinePlugin_handleOfflinePackage");
      return paramString;
    }
    return null;
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map paramMap)
  {
    if (paramLong == 2L)
    {
      paramString = this.mRuntime.a();
      paramMap = this.mRuntime.a(this.mRuntime.a());
      if ((paramMap != null) && ((paramMap instanceof WebUiUtils.QQBrowserBaseActivityInterface))) {}
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
                          return false;
                          if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
                            this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
                          }
                        } while ((jdField_a_of_type_JavaUtilHashMap == null) || (TextUtils.isEmpty(this.j)));
                        paramMap = (OfflineUpdateStatus)jdField_a_of_type_JavaUtilHashMap.get(this.j);
                      } while (paramMap == null);
                      d();
                      paramMap.a(this.jdField_a_of_type_ComTencentBizCommonUtilLoadedBack2);
                      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
                        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
                      }
                      if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
                        this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
                      }
                      switch (paramMap.b())
                      {
                      default: 
                        return false;
                      case 0: 
                        if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
                          this.jdField_a_of_type_AndroidWidgetTextView.setText(paramMap.c);
                        }
                        break;
                      }
                    } while (paramString == null);
                    paramString = paramString.getResources().getDrawable(2130840616);
                    paramString.setBounds(0, 0, 40, 40);
                    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
                      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(paramString, null, null, null);
                    }
                    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
                      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
                    }
                  } while (this.jdField_a_of_type_AndroidWidgetLinearLayout == null);
                  this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
                  return false;
                  if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
                    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramMap.e + paramMap.c() + "%");
                  }
                  if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
                    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
                  }
                } while (this.jdField_a_of_type_AndroidWidgetLinearLayout == null);
                this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
                return false;
                if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
                  this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramMap.c());
                }
                if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
                  this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
                }
              } while (this.jdField_a_of_type_AndroidWidgetLinearLayout == null);
              this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
              return false;
              if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
                this.jdField_a_of_type_AndroidWidgetTextView.setText(paramMap.d);
              }
            } while (paramString == null);
            paramString = paramString.getResources().getDrawable(2130838301);
            paramString.setBounds(0, 0, paramString.getMinimumWidth(), paramString.getMinimumHeight());
            if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
              this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(paramString, null, null, null);
            }
            if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
              this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
            }
          } while (this.jdField_a_of_type_AndroidWidgetLinearLayout == null);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          return false;
        } while (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        return false;
        if (paramLong != 8589934594L) {
          break;
        }
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        ThreadManager.a(new jhm(this), 5, null, false);
      } while (this.jdField_a_of_type_ComTencentBizWebviewpluginOfflineWebResManager == null);
      this.jdField_a_of_type_ComTencentBizWebviewpluginOfflineWebResManager.a(5);
      return false;
    } while ((paramLong != 8589934601L) || (this.jdField_a_of_type_ComTencentBizWebviewpluginOfflineWebResManager == null));
    this.jdField_a_of_type_ComTencentBizWebviewpluginOfflineWebResManager.a(0);
    return false;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    Object localObject = null;
    paramString1 = null;
    int m = 0;
    if ("offline".equals(paramString2))
    {
      if (("clearCache".equals(paramString3)) && (paramVarArgs.length > 0)) {
        paramJsBridgeListener = paramString1;
      }
      do
      {
        do
        {
          do
          {
            try
            {
              paramString3 = new JSONObject(paramVarArgs[0]);
              paramJsBridgeListener = paramString1;
              paramString2 = paramString3.optString("bid");
              paramJsBridgeListener = paramString1;
              paramString1 = paramString3.optString("callback");
              paramJsBridgeListener = paramString1;
              HtmlOffline.a(this.mRuntime.a(), paramString2, 1);
              paramJsBridgeListener = paramString1;
              paramString2 = new JSONObject();
              paramJsBridgeListener = paramString1;
              paramString2.put("retcode", 0);
              paramJsBridgeListener = paramString1;
              paramString2.put("msg", "ok");
              paramJsBridgeListener = paramString1;
              callJs(paramString1, new String[] { paramString2.toString() });
            }
            catch (JSONException paramString1)
            {
              do
              {
                if (QLog.isColorLevel()) {
                  QLog.d("OfflinePluginQQ", 2, "OfflinePlugin, clearCache, JSONException :" + paramString1);
                }
                try
                {
                  paramString1 = new JSONObject();
                  paramString1.put("retcode", -1);
                  paramString1.put("msg", "error");
                  callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
                  return true;
                }
                catch (JSONException paramJsBridgeListener) {}
              } while (!QLog.isColorLevel());
              QLog.d("OfflinePluginQQ", 2, "OfflinePlugin, clearCache, JSONException :" + paramJsBridgeListener);
              return true;
            }
            return true;
            if (!"disableCache".equals(paramString3)) {
              break;
            }
            paramJsBridgeListener = (JsBridgeListener)localObject;
            try
            {
              paramString1 = new JSONObject(paramVarArgs[0]).optString("callback");
              paramJsBridgeListener = paramString1;
              jdField_g_of_type_Boolean = true;
              paramJsBridgeListener = paramString1;
              paramString2 = new JSONObject();
              paramJsBridgeListener = paramString1;
              paramString2.put("retcode", 0);
              paramJsBridgeListener = paramString1;
              paramString2.put("msg", "ok");
              paramJsBridgeListener = paramString1;
              callJs(paramString1, new String[] { paramString2.toString() });
              return true;
            }
            catch (JSONException paramString1)
            {
              if (QLog.isColorLevel()) {
                QLog.d("OfflinePluginQQ", 2, "OfflinePlugin, disableCache, JSONException :" + paramString1);
              }
              try
              {
                paramString1 = new JSONObject();
                paramString1.put("retcode", -1);
                paramString1.put("msg", "error");
                callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
                return true;
              }
              catch (JSONException paramJsBridgeListener) {}
            }
          } while (!QLog.isColorLevel());
          QLog.d("OfflinePluginQQ", 2, "OfflinePlugin, disableCache, JSONException :" + paramJsBridgeListener);
          return true;
        } while ((!"batchCheckUpdate".equals(paramString3)) || (paramVarArgs.length <= 0));
        try
        {
          paramString2 = new JSONObject(paramVarArgs[0]);
          paramString1 = paramString2.optJSONArray("bids");
          this.jdField_f_of_type_JavaLangString = paramString2.optString("callback");
          int n = paramString1.length();
          paramString2 = new ArrayList(n);
          while (m < n)
          {
            paramString2.add(paramString1.optString(m));
            m += 1;
          }
          HtmlOffline.a(paramString2, this.mRuntime.a(), new jhk(this, paramJsBridgeListener), true, false);
          return true;
        }
        catch (JSONException paramJsBridgeListener)
        {
          if (QLog.isColorLevel()) {
            QLog.d("OfflinePluginQQ", 2, "OfflinePlugin, batchCheckUpdate, JSONException :" + paramJsBridgeListener);
          }
          try
          {
            paramJsBridgeListener = new JSONObject();
            paramJsBridgeListener.put("retcode", -1);
            paramJsBridgeListener.put("msg", "error");
            callJs(this.jdField_f_of_type_JavaLangString, new String[] { paramJsBridgeListener.toString() });
            return true;
          }
          catch (JSONException paramJsBridgeListener) {}
        }
      } while (!QLog.isColorLevel());
      QLog.d("OfflinePluginQQ", 2, "OfflinePlugin, batchCheckUpdate, JSONException :" + paramJsBridgeListener);
      return true;
    }
    return false;
  }
  
  protected boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    if ((!paramString2.equals("http")) && (!paramString2.equals("https"))) {
      return false;
    }
    paramString1 = a(paramString1);
    long l = System.currentTimeMillis();
    paramString2 = SwiftBrowserOfflineHandler.a(paramString1);
    if ((paramString2 != null) && (!paramString2.a()))
    {
      paramString2.a(new jhl(this, l, paramString1), paramString1);
      return true;
    }
    if (paramString2 != null) {}
    for (int m = paramString2.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();; m = 0)
    {
      a(paramString1, m);
      return false;
    }
  }
  
  public void onAppRuntimeReady(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentBizAuthorizeConfig = AuthorizeConfig.a();
    c();
  }
  
  protected void onCreate()
  {
    super.onCreate();
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Boolean = true;
    if ((jdField_a_of_type_JavaUtilHashMap != null) && (!TextUtils.isEmpty(this.j)))
    {
      OfflineUpdateStatus localOfflineUpdateStatus = (OfflineUpdateStatus)jdField_a_of_type_JavaUtilHashMap.get(this.j);
      if (localOfflineUpdateStatus != null)
      {
        localOfflineUpdateStatus.b(this.jdField_a_of_type_ComTencentBizCommonUtilLoadedBack2);
        if (localOfflineUpdateStatus.a() == 0) {
          jdField_a_of_type_JavaUtilHashMap.remove(this.j);
        }
      }
      if (jdField_a_of_type_JavaUtilHashMap.size() == 0) {
        jdField_a_of_type_JavaUtilHashMap = null;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\webviewplugin\OfflinePlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */