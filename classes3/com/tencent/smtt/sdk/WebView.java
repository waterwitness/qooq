package com.tencent.smtt.sdk;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.net.http.SslCertificate;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebSettingsExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.extension.proxy.X5ProxyWebViewClientExtension;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.FindListener;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.HitTestResult;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.PictureListener;
import com.tencent.smtt.sdk.stat.HttpUtils;
import com.tencent.smtt.sdk.stat.MttLoader;
import com.tencent.smtt.utils.Apn;
import com.tencent.smtt.utils.DebugTbsPlugin;
import com.tencent.smtt.utils.ReflectionUtils;
import com.tencent.smtt.utils.TbsConfigFile;
import com.tencent.smtt.utils.TbsLog;
import java.io.BufferedWriter;
import java.io.File;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class WebView
  extends FrameLayout
  implements View.OnLongClickListener
{
  public static final int GETPVERROR = -1;
  private static final String LOGTAG = "webview";
  public static int NIGHT_MODE_ALPHA = 153;
  public static final int NIGHT_MODE_COLOR = -16777216;
  public static final int NORMAL_MODE_ALPHA = 255;
  private static final String QQ_PACKAGE_NAME = "com.tencent.mobileqq";
  public static final String SCHEME_GEO = "geo:0,0?q=";
  public static final String SCHEME_MAILTO = "mailto:";
  public static final String SCHEME_TEL = "tel:";
  public static String TBS_DEBUG_INSTALL_ONLINE;
  private static final String WX_PACKAGE_NAME = "com.tencent.mm";
  static boolean current_process_used_x5;
  private static boolean isConnectivityChangeReceiverRegistered;
  private static Context mAppContext;
  private static String mCallerAppPackageName;
  private static boolean mIsDayMode;
  private static Paint mNightModePaint;
  public static boolean mSysWebviewCreated;
  private static TbsConfigFile mTbsConfig;
  private static final Lock mTbsPvLock = new ReentrantLock();
  private static OutputStream outputStream = null;
  private static Method sWebviewsetWebContentsDebuggingEnabled;
  private final int ATTRIBUTE_SCROLLBARS_HORIZONTAL = 2;
  private final int ATTRIBUTE_SCROLLBARS_NONE = 1;
  private final int ATTRIBUTE_SCROLLBARS_VERTICAL = 3;
  private final String LOG_TAG = "WebView";
  private Button assistant_confirm;
  private Button assistant_test_reset;
  private final String deleteNightMode = "javascript:document.getElementsByTagName('HEAD').item(0).removeChild(document.getElementById('QQBrowserSDKNightMode'));";
  private boolean isShowDebugView = false;
  private boolean isX5Core = false;
  private Object longClickListener = null;
  private Context mContext = null;
  private boolean mIsReported = false;
  private View.OnLongClickListener mOnLongClickListener = null;
  int mPv = 0;
  private SystemWebView mSysWebView;
  private WebSettings mWebSettings = null;
  public WebViewCallbackClient mWebViewCallbackClient;
  private WebViewClient mWebViewClient = null;
  private IX5WebViewBase mX5WebView;
  private final String nightMode = "javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);";
  private CheckBox tbs_use_syswebview_query;
  
  static
  {
    mAppContext = null;
    TBS_DEBUG_INSTALL_ONLINE = "tbsdebug_install_online_";
    isConnectivityChangeReceiverRegistered = false;
    current_process_used_x5 = false;
    mTbsConfig = null;
    sWebviewsetWebContentsDebuggingEnabled = null;
    mCallerAppPackageName = null;
    mSysWebviewCreated = false;
    mNightModePaint = null;
    mIsDayMode = true;
  }
  
  public WebView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, false);
  }
  
  @TargetApi(11)
  public WebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, Map<String, Object> paramMap, boolean paramBoolean)
  {
    super(paramContext, paramAttributeSet, paramInt);
    TbsLog.initIfNeed(paramContext);
    if (paramContext == null)
    {
      current_process_used_x5 = this.isX5Core;
      throw new IllegalArgumentException("Invalid context argument");
    }
    if (mTbsConfig == null) {
      mTbsConfig = TbsConfigFile.getInstance(paramContext);
    }
    if (mTbsConfig.mForceUseSystemWebview)
    {
      TbsLog.e("WebView", "sys WebView: debug.conf force syswebview", true);
      QbSdk.forceSysWebViewInner(paramContext, "debug.conf force syswebview!");
    }
    init(paramContext);
    this.mContext = paramContext;
    if (paramContext != null) {
      mAppContext = paramContext.getApplicationContext();
    }
    if (this.isX5Core)
    {
      this.mX5WebView = X5CoreEngine.getInstance().wizard().createSDKWebview(paramContext);
      if ((this.mX5WebView == null) || (this.mX5WebView.getView() == null))
      {
        TbsLog.e("WebView", "sys WebView: failed to createTBSWebview", true);
        this.mX5WebView = null;
        this.isX5Core = false;
        QbSdk.forceSysWebViewInner(paramContext, "failed to createTBSWebview!");
        init(paramContext);
        if (TbsShareManager.isThirdPartyApp(this.mContext)) {
          this.mSysWebView = new SystemWebView(paramContext, paramAttributeSet);
        }
        for (;;)
        {
          TbsLog.i("WebView", "SystemWebView Created Success! #1");
          this.mSysWebView.setFocusableInTouchMode(true);
          addView(this.mSysWebView, new FrameLayout.LayoutParams(-1, -1));
          try
          {
            if (Build.VERSION.SDK_INT >= 11) {
              removeJavascriptInterface("searchBoxJavaBridge_");
            }
            current_process_used_x5 = this.isX5Core;
            registerConnectivityChangedReceiverIfNeeded(paramContext);
            return;
            this.mSysWebView = new SystemWebView(paramContext);
          }
          catch (Throwable paramAttributeSet)
          {
            for (;;)
            {
              paramAttributeSet.printStackTrace();
            }
          }
        }
      }
      TbsLog.i("WebView", "X5 WebView Created Success!!");
      this.mX5WebView.getView().setFocusableInTouchMode(true);
      setAttributeForX5(paramAttributeSet);
      addView(this.mX5WebView.getView(), new FrameLayout.LayoutParams(-1, -1));
      this.mX5WebView.setDownloadListener(new DownLoadListenerAdapter(this, null, this.isX5Core));
      this.mX5WebView.getX5WebViewExtension().setWebViewClientExtension(new X5ProxyWebViewClientExtension(X5CoreEngine.getInstance().wizardForCoreTypeConfirmed(true).createDefaultX5WebChromeClientExtension())
      {
        public void onScrollChanged(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
        {
          super.onScrollChanged(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4);
          WebView.this.onScrollChanged(paramAnonymousInt3, paramAnonymousInt4, paramAnonymousInt1, paramAnonymousInt2);
        }
      });
    }
    try
    {
      if (Build.VERSION.SDK_INT >= 11) {
        removeJavascriptInterface("searchBoxJavaBridge_");
      }
      if ((("com.tencent.mobileqq".equals(this.mContext.getApplicationInfo().packageName)) || ("com.tencent.mm".equals(this.mContext.getApplicationInfo().packageName))) && (SDKEngine.getInstance(true).useSoftWare()) && (Build.VERSION.SDK_INT >= 11)) {
        setLayerType(1, null);
      }
      current_process_used_x5 = this.isX5Core;
      return;
      this.mX5WebView = null;
      if (TbsShareManager.isThirdPartyApp(this.mContext)) {}
      for (this.mSysWebView = new SystemWebView(paramContext, paramAttributeSet);; this.mSysWebView = new SystemWebView(paramContext))
      {
        TbsLog.i("WebView", "SystemWebView Created Success! #2");
        this.mSysWebView.setFocusableInTouchMode(true);
        addView(this.mSysWebView, new FrameLayout.LayoutParams(-1, -1));
        setDownloadListener(null);
        registerConnectivityChangedReceiverIfNeeded(paramContext);
        break;
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  public WebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, boolean paramBoolean)
  {
    this(paramContext, paramAttributeSet, paramInt, null, paramBoolean);
  }
  
  private boolean callX5CoreOnLongClick(View paramView)
  {
    if ((this.mContext != null) && (getTbsCoreVersion(this.mContext) > 36200)) {
      return false;
    }
    paramView = ReflectionUtils.invokeInstance(this.longClickListener, "onLongClick", new Class[] { View.class }, new Object[] { paramView });
    if (paramView != null) {
      return ((Boolean)paramView).booleanValue();
    }
    return false;
  }
  
  private void deletepvfile(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getDir("tbs", 0);
      paramContext = new File(paramContext + File.separator + "core_private", "pv.db");
      if (paramContext != null)
      {
        if (!paramContext.exists()) {
          return;
        }
        paramContext.delete();
        return;
      }
    }
    catch (Exception paramContext)
    {
      TbsLog.i("getTbsCorePV", "TbsInstaller--getTbsCorePV Exception=" + paramContext.toString());
    }
  }
  
  @Deprecated
  public static void disablePlatformNotifications()
  {
    if (!X5CoreEngine.getInstance().isX5Core()) {
      ReflectionUtils.invokeStatic("android.webkit.WebView", "disablePlatformNotifications");
    }
  }
  
  @Deprecated
  public static void enablePlatformNotifications()
  {
    if (!X5CoreEngine.getInstance().isX5Core()) {
      ReflectionUtils.invokeStatic("android.webkit.WebView", "enablePlatformNotifications");
    }
  }
  
  public static String findAddress(String paramString)
  {
    if (!X5CoreEngine.getInstance().isX5Core()) {
      return android.webkit.WebView.findAddress(paramString);
    }
    return null;
  }
  
  public static String getCrashExtraMessage(Context paramContext)
  {
    String str = "tbs_core_version:" + QbSdk.getTbsVersion(paramContext) + ";" + "tbs_sdk_version:" + 36548 + ";";
    if (TbsShareManager.isThirdPartyApp(paramContext)) {
      return "nothing return ^-^." + str;
    }
    paramContext = new StringBuilder();
    paramContext.append(SDKEngine.getInstance(true).getCrashExtraMessage());
    paramContext.append("\n");
    paramContext.append(str);
    if (paramContext.length() > 8192) {
      return paramContext.substring(paramContext.length() - 8192);
    }
    return paramContext.toString();
  }
  
  /* Error */
  @Deprecated
  public static Object getPluginList()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 247	com/tencent/smtt/sdk/X5CoreEngine:getInstance	()Lcom/tencent/smtt/sdk/X5CoreEngine;
    //   6: invokevirtual 482	com/tencent/smtt/sdk/X5CoreEngine:isX5Core	()Z
    //   9: ifne +18 -> 27
    //   12: ldc_w 484
    //   15: ldc_w 528
    //   18: invokestatic 489	com/tencent/smtt/utils/ReflectionUtils:invokeStatic	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   21: astore_0
    //   22: ldc 2
    //   24: monitorexit
    //   25: aload_0
    //   26: areturn
    //   27: aconst_null
    //   28: astore_0
    //   29: goto -7 -> 22
    //   32: astore_0
    //   33: ldc 2
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   21	8	0	localObject1	Object
    //   32	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   3	22	32	finally
  }
  
  /* Error */
  private int getTbsCorePV(Context paramContext)
  {
    // Byte code:
    //   0: aload_1
    //   1: iconst_1
    //   2: ldc_w 532
    //   5: invokestatic 538	com/tencent/smtt/utils/FileUtil:getLockFos	(Landroid/content/Context;ZLjava/lang/String;)Ljava/io/FileOutputStream;
    //   8: astore 5
    //   10: aload 5
    //   12: ifnull +16 -> 28
    //   15: aload_1
    //   16: aload 5
    //   18: invokestatic 542	com/tencent/smtt/utils/FileUtil:tryFileLock	(Landroid/content/Context;Ljava/io/FileOutputStream;)Ljava/nio/channels/FileLock;
    //   21: astore 4
    //   23: aload 4
    //   25: ifnonnull +5 -> 30
    //   28: iconst_m1
    //   29: ireturn
    //   30: getstatic 118	com/tencent/smtt/sdk/WebView:mTbsPvLock	Ljava/util/concurrent/locks/Lock;
    //   33: invokeinterface 547 1 0
    //   38: ifeq +453 -> 491
    //   41: aconst_null
    //   42: astore_3
    //   43: aload_1
    //   44: ldc_w 438
    //   47: iconst_0
    //   48: invokevirtual 442	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   51: astore_1
    //   52: new 444	java/io/File
    //   55: dup
    //   56: new 446	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 447	java/lang/StringBuilder:<init>	()V
    //   63: aload_1
    //   64: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   67: getstatic 454	java/io/File:separator	Ljava/lang/String;
    //   70: invokevirtual 457	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: ldc_w 459
    //   76: invokevirtual 457	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: invokevirtual 463	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: ldc_w 465
    //   85: invokespecial 467	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: astore_1
    //   89: aload_1
    //   90: ifnull +14 -> 104
    //   93: aload_1
    //   94: invokevirtual 470	java/io/File:exists	()Z
    //   97: istore 8
    //   99: iload 8
    //   101: ifne +65 -> 166
    //   104: iconst_0
    //   105: ifeq +11 -> 116
    //   108: new 549	java/lang/NullPointerException
    //   111: dup
    //   112: invokespecial 550	java/lang/NullPointerException:<init>	()V
    //   115: athrow
    //   116: getstatic 118	com/tencent/smtt/sdk/WebView:mTbsPvLock	Ljava/util/concurrent/locks/Lock;
    //   119: invokeinterface 553 1 0
    //   124: aload 4
    //   126: aload 5
    //   128: invokestatic 557	com/tencent/smtt/utils/FileUtil:freeFileLock	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   131: iconst_m1
    //   132: ireturn
    //   133: astore_1
    //   134: ldc_w 475
    //   137: new 446	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 447	java/lang/StringBuilder:<init>	()V
    //   144: ldc_w 559
    //   147: invokevirtual 457	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: aload_1
    //   151: invokevirtual 560	java/io/IOException:toString	()Ljava/lang/String;
    //   154: invokevirtual 457	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: invokevirtual 463	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: invokestatic 562	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   163: goto -47 -> 116
    //   166: new 564	java/util/Properties
    //   169: dup
    //   170: invokespecial 565	java/util/Properties:<init>	()V
    //   173: astore 6
    //   175: new 567	java/io/FileInputStream
    //   178: dup
    //   179: aload_1
    //   180: invokespecial 570	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   183: astore_2
    //   184: aload_2
    //   185: astore_1
    //   186: aload 6
    //   188: aload_2
    //   189: invokevirtual 574	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   192: aload_2
    //   193: astore_1
    //   194: aload_2
    //   195: invokevirtual 577	java/io/FileInputStream:close	()V
    //   198: aload_2
    //   199: astore_1
    //   200: aload 6
    //   202: ldc_w 579
    //   205: invokevirtual 582	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   208: astore_3
    //   209: aload_3
    //   210: ifnonnull +61 -> 271
    //   213: aload_2
    //   214: ifnull +7 -> 221
    //   217: aload_2
    //   218: invokevirtual 577	java/io/FileInputStream:close	()V
    //   221: getstatic 118	com/tencent/smtt/sdk/WebView:mTbsPvLock	Ljava/util/concurrent/locks/Lock;
    //   224: invokeinterface 553 1 0
    //   229: aload 4
    //   231: aload 5
    //   233: invokestatic 557	com/tencent/smtt/utils/FileUtil:freeFileLock	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   236: iconst_m1
    //   237: ireturn
    //   238: astore_1
    //   239: ldc_w 475
    //   242: new 446	java/lang/StringBuilder
    //   245: dup
    //   246: invokespecial 447	java/lang/StringBuilder:<init>	()V
    //   249: ldc_w 559
    //   252: invokevirtual 457	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: aload_1
    //   256: invokevirtual 560	java/io/IOException:toString	()Ljava/lang/String;
    //   259: invokevirtual 457	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: invokevirtual 463	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   265: invokestatic 562	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   268: goto -47 -> 221
    //   271: aload_2
    //   272: astore_1
    //   273: aload_3
    //   274: invokestatic 588	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   277: istore 7
    //   279: aload_2
    //   280: ifnull +7 -> 287
    //   283: aload_2
    //   284: invokevirtual 577	java/io/FileInputStream:close	()V
    //   287: getstatic 118	com/tencent/smtt/sdk/WebView:mTbsPvLock	Ljava/util/concurrent/locks/Lock;
    //   290: invokeinterface 553 1 0
    //   295: aload 4
    //   297: aload 5
    //   299: invokestatic 557	com/tencent/smtt/utils/FileUtil:freeFileLock	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   302: iload 7
    //   304: ireturn
    //   305: astore_1
    //   306: ldc_w 475
    //   309: new 446	java/lang/StringBuilder
    //   312: dup
    //   313: invokespecial 447	java/lang/StringBuilder:<init>	()V
    //   316: ldc_w 559
    //   319: invokevirtual 457	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: aload_1
    //   323: invokevirtual 560	java/io/IOException:toString	()Ljava/lang/String;
    //   326: invokevirtual 457	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: invokevirtual 463	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   332: invokestatic 562	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   335: goto -48 -> 287
    //   338: astore_3
    //   339: aconst_null
    //   340: astore_2
    //   341: aload_2
    //   342: astore_1
    //   343: ldc_w 475
    //   346: new 446	java/lang/StringBuilder
    //   349: dup
    //   350: invokespecial 447	java/lang/StringBuilder:<init>	()V
    //   353: ldc_w 477
    //   356: invokevirtual 457	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: aload_3
    //   360: invokevirtual 478	java/lang/Exception:toString	()Ljava/lang/String;
    //   363: invokevirtual 457	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: invokevirtual 463	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   369: invokestatic 562	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   372: aload_2
    //   373: ifnull +7 -> 380
    //   376: aload_2
    //   377: invokevirtual 577	java/io/FileInputStream:close	()V
    //   380: getstatic 118	com/tencent/smtt/sdk/WebView:mTbsPvLock	Ljava/util/concurrent/locks/Lock;
    //   383: invokeinterface 553 1 0
    //   388: aload 4
    //   390: aload 5
    //   392: invokestatic 557	com/tencent/smtt/utils/FileUtil:freeFileLock	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   395: iconst_m1
    //   396: ireturn
    //   397: astore_1
    //   398: ldc_w 475
    //   401: new 446	java/lang/StringBuilder
    //   404: dup
    //   405: invokespecial 447	java/lang/StringBuilder:<init>	()V
    //   408: ldc_w 559
    //   411: invokevirtual 457	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: aload_1
    //   415: invokevirtual 560	java/io/IOException:toString	()Ljava/lang/String;
    //   418: invokevirtual 457	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: invokevirtual 463	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   424: invokestatic 562	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   427: goto -47 -> 380
    //   430: astore_1
    //   431: aload_3
    //   432: astore_2
    //   433: aload_2
    //   434: ifnull +7 -> 441
    //   437: aload_2
    //   438: invokevirtual 577	java/io/FileInputStream:close	()V
    //   441: getstatic 118	com/tencent/smtt/sdk/WebView:mTbsPvLock	Ljava/util/concurrent/locks/Lock;
    //   444: invokeinterface 553 1 0
    //   449: aload 4
    //   451: aload 5
    //   453: invokestatic 557	com/tencent/smtt/utils/FileUtil:freeFileLock	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   456: aload_1
    //   457: athrow
    //   458: astore_2
    //   459: ldc_w 475
    //   462: new 446	java/lang/StringBuilder
    //   465: dup
    //   466: invokespecial 447	java/lang/StringBuilder:<init>	()V
    //   469: ldc_w 559
    //   472: invokevirtual 457	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: aload_2
    //   476: invokevirtual 560	java/io/IOException:toString	()Ljava/lang/String;
    //   479: invokevirtual 457	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: invokevirtual 463	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   485: invokestatic 562	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   488: goto -47 -> 441
    //   491: aload 4
    //   493: aload 5
    //   495: invokestatic 557	com/tencent/smtt/utils/FileUtil:freeFileLock	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   498: iconst_m1
    //   499: ireturn
    //   500: astore_3
    //   501: aload_1
    //   502: astore_2
    //   503: aload_3
    //   504: astore_1
    //   505: goto -72 -> 433
    //   508: astore_3
    //   509: goto -168 -> 341
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	512	0	this	WebView
    //   0	512	1	paramContext	Context
    //   183	255	2	localObject1	Object
    //   458	18	2	localIOException	java.io.IOException
    //   502	1	2	localContext	Context
    //   42	232	3	str	String
    //   338	94	3	localException1	Exception
    //   500	4	3	localObject2	Object
    //   508	1	3	localException2	Exception
    //   21	471	4	localFileLock	java.nio.channels.FileLock
    //   8	486	5	localFileOutputStream	java.io.FileOutputStream
    //   173	28	6	localProperties	java.util.Properties
    //   277	26	7	i	int
    //   97	3	8	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   108	116	133	java/io/IOException
    //   217	221	238	java/io/IOException
    //   283	287	305	java/io/IOException
    //   43	89	338	java/lang/Exception
    //   93	99	338	java/lang/Exception
    //   166	184	338	java/lang/Exception
    //   376	380	397	java/io/IOException
    //   43	89	430	finally
    //   93	99	430	finally
    //   166	184	430	finally
    //   437	441	458	java/io/IOException
    //   186	192	500	finally
    //   194	198	500	finally
    //   200	209	500	finally
    //   273	279	500	finally
    //   343	372	500	finally
    //   186	192	508	java/lang/Exception
    //   194	198	508	java/lang/Exception
    //   200	209	508	java/lang/Exception
    //   273	279	508	java/lang/Exception
  }
  
  public static int getTbsCoreVersion(Context paramContext)
  {
    return QbSdk.getTbsVersion(paramContext);
  }
  
  public static boolean getTbsNeedReboot()
  {
    updateRebootStatus();
    return SDKEngine.getInstance(true).getTbsNeedReboot();
  }
  
  public static int getTbsSDKVersion(Context paramContext)
  {
    return 36548;
  }
  
  private long getWifiConnectedTime()
  {
    synchronized (QbSdk.sApnLock)
    {
      if (QbSdk.sIsApnWifi)
      {
        QbSdk.sWifiConnectedTime += System.currentTimeMillis() - QbSdk.sApnRecordTime;
        TbsLog.d("sdkreport", "pv report, WebView.getWifiConnectedTime QbSdk.sWifiConnectedTime=" + QbSdk.sWifiConnectedTime);
      }
      long l = QbSdk.sWifiConnectedTime / 1000L;
      QbSdk.sWifiConnectedTime = 0L;
      QbSdk.sApnRecordTime = System.currentTimeMillis();
      return l;
    }
  }
  
  private void init(Context paramContext)
  {
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    localX5CoreEngine.init(paramContext);
    this.isX5Core = localX5CoreEngine.isX5Core();
  }
  
  private boolean isQQ(Context paramContext)
  {
    try
    {
      int i = paramContext.getPackageName().indexOf("com.tencent.mobileqq");
      if (i >= 0) {
        return true;
      }
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  private void registerConnectivityChangedReceiverIfNeeded(final Context paramContext)
  {
    if (isConnectivityChangeReceiverRegistered) {
      return;
    }
    isConnectivityChangeReceiverRegistered = true;
    new Thread()
    {
      public void run()
      {
        try
        {
          if (Apn.getApnType(paramContext) == 3) {}
          for (boolean bool = true;; bool = false)
          {
            QbSdk.sIsApnWifi = bool;
            QbSdk.sApnRecordTime = System.currentTimeMillis();
            IntentFilter localIntentFilter = new IntentFilter();
            localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            paramContext.getApplicationContext().registerReceiver(new BroadcastReceiver()
            {
              public void onReceive(Context arg1, Intent paramAnonymous2Intent)
              {
                if (paramAnonymous2Intent != null) {}
                for (;;)
                {
                  try
                  {
                    int i;
                    long l;
                    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(paramAnonymous2Intent.getAction()))
                    {
                      i = Apn.getApnType(???);
                      l = System.currentTimeMillis();
                    }
                    synchronized (QbSdk.sApnLock)
                    {
                      if (QbSdk.sIsApnWifi) {
                        QbSdk.sWifiConnectedTime += l - QbSdk.sApnRecordTime;
                      }
                      QbSdk.sApnRecordTime = l;
                      TbsLog.d("sdkreport", "pv report, SdkEngine.registerConnectivityChangedReceiver QbSdk.sWifiConnectTime=" + QbSdk.sWifiConnectedTime + " apnType=" + i);
                      if (i == 3)
                      {
                        bool = true;
                        QbSdk.sIsApnWifi = bool;
                        return;
                      }
                    }
                    boolean bool = false;
                  }
                  catch (Throwable ???)
                  {
                    return;
                  }
                }
              }
            }, localIntentFilter);
            return;
          }
          return;
        }
        catch (Throwable localThrowable) {}
      }
    }.start();
  }
  
  private void setAttributeForX5(AttributeSet paramAttributeSet)
  {
    int i = 0;
    if (paramAttributeSet != null) {}
    for (;;)
    {
      int[] arrayOfInt;
      int k;
      try
      {
        int j = paramAttributeSet.getAttributeCount();
        if (i < j)
        {
          if (!paramAttributeSet.getAttributeName(i).equalsIgnoreCase("scrollbars")) {
            break label145;
          }
          arrayOfInt = getResources().getIntArray(16842974);
          k = paramAttributeSet.getAttributeIntValue(i, -1);
          if (k == arrayOfInt[1])
          {
            this.mX5WebView.getView().setVerticalScrollBarEnabled(false);
            this.mX5WebView.getView().setHorizontalScrollBarEnabled(false);
          }
          else if (k == arrayOfInt[2])
          {
            this.mX5WebView.getView().setVerticalScrollBarEnabled(false);
          }
        }
      }
      catch (Exception paramAttributeSet)
      {
        paramAttributeSet.printStackTrace();
      }
      return;
      if (k == arrayOfInt[3]) {
        this.mX5WebView.getView().setHorizontalScrollBarEnabled(false);
      }
      label145:
      i += 1;
    }
  }
  
  public static void setSysDayOrNight(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        boolean bool = mIsDayMode;
        if (paramBoolean == bool) {
          return;
        }
        mIsDayMode = paramBoolean;
        if (mNightModePaint == null)
        {
          mNightModePaint = new Paint();
          mNightModePaint.setColor(-16777216);
        }
        if (!paramBoolean)
        {
          if (mNightModePaint.getAlpha() == NIGHT_MODE_ALPHA) {
            continue;
          }
          mNightModePaint.setAlpha(NIGHT_MODE_ALPHA);
          continue;
        }
        if (mNightModePaint.getAlpha() == 255) {
          continue;
        }
      }
      finally {}
      mNightModePaint.setAlpha(255);
    }
  }
  
  public static void setWebContentsDebuggingEnabled(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 19) {}
    try
    {
      sWebviewsetWebContentsDebuggingEnabled = Class.forName("android.webkit.WebView").getDeclaredMethod("setWebContentsDebuggingEnabled", new Class[] { Boolean.TYPE });
      if (sWebviewsetWebContentsDebuggingEnabled != null)
      {
        sWebviewsetWebContentsDebuggingEnabled.setAccessible(true);
        sWebviewsetWebContentsDebuggingEnabled.invoke(null, new Object[] { Boolean.valueOf(paramBoolean) });
      }
      return;
    }
    catch (Exception localException)
    {
      TbsLog.e("QbSdk", "Exception:" + localException.getStackTrace());
      localException.printStackTrace();
    }
  }
  
  static void updateRebootStatus()
  {
    if (mAppContext == null) {}
    SDKEngine localSDKEngine;
    int i;
    int j;
    do
    {
      do
      {
        return;
        localSDKEngine = SDKEngine.getInstance(true);
      } while (SDKEngine.mTbsNeedReboot);
      TbsCoreVerManager localTbsCoreVerManager = TbsCoreVerManager.getInstance(mAppContext);
      i = localTbsCoreVerManager.getTbsCoreInstallStatus();
      if (i == 2)
      {
        localSDKEngine.setCalledCountKey(String.valueOf(localTbsCoreVerManager.getTbsCoreInstallVer()));
        localSDKEngine.setTbsNeedReboot(true);
        return;
      }
      j = localTbsCoreVerManager.getTbsCoreCopyStatus();
      if (j == 1)
      {
        localSDKEngine.setCalledCountKey(String.valueOf(localTbsCoreVerManager.getTbsCoreCopyVer()));
        localSDKEngine.setTbsNeedReboot(true);
        return;
      }
    } while ((X5CoreEngine.getInstance().isX5Core()) || ((i != 3) && (j != 3)));
    localSDKEngine.setCalledCountKey(String.valueOf(SDKEngine.getTbsCoreVersion()));
    localSDKEngine.setTbsNeedReboot(true);
  }
  
  public void addJavascriptInterface(Object paramObject, String paramString)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.addJavascriptInterface(paramObject, paramString);
      return;
    }
    this.mX5WebView.addJavascriptInterface(paramObject, paramString);
  }
  
  public void addView(View paramView)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.addView(paramView);
      return;
    }
    View localView = this.mX5WebView.getView();
    try
    {
      Method localMethod = ReflectionUtils.getParentDeclaredMethod(localView, "addView", new Class[] { View.class });
      localMethod.setAccessible(true);
      localMethod.invoke(localView, new Object[] { paramView });
      return;
    }
    catch (Throwable paramView) {}
  }
  
  public boolean canGoBack()
  {
    if (!this.isX5Core) {
      return this.mSysWebView.canGoBack();
    }
    return this.mX5WebView.canGoBack();
  }
  
  public boolean canGoBackOrForward(int paramInt)
  {
    if (!this.isX5Core) {
      return this.mSysWebView.canGoBackOrForward(paramInt);
    }
    return this.mX5WebView.canGoBackOrForward(paramInt);
  }
  
  public boolean canGoForward()
  {
    if (!this.isX5Core) {
      return this.mSysWebView.canGoForward();
    }
    return this.mX5WebView.canGoForward();
  }
  
  @Deprecated
  public boolean canZoomIn()
  {
    if (!this.isX5Core)
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        Object localObject = ReflectionUtils.invokeInstance(this.mSysWebView, "canZoomIn");
        if (localObject == null) {
          return false;
        }
        return ((Boolean)localObject).booleanValue();
      }
      return false;
    }
    return this.mX5WebView.canZoomIn();
  }
  
  @Deprecated
  public boolean canZoomOut()
  {
    if (!this.isX5Core)
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        Object localObject = ReflectionUtils.invokeInstance(this.mSysWebView, "canZoomOut");
        if (localObject == null) {
          return false;
        }
        return ((Boolean)localObject).booleanValue();
      }
      return false;
    }
    return this.mX5WebView.canZoomOut();
  }
  
  @Deprecated
  public Picture capturePicture()
  {
    if (!this.isX5Core)
    {
      Object localObject = ReflectionUtils.invokeInstance(this.mSysWebView, "capturePicture");
      if (localObject == null) {
        return null;
      }
      return (Picture)localObject;
    }
    return this.mX5WebView.capturePicture();
  }
  
  public void clearCache(boolean paramBoolean)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.clearCache(paramBoolean);
      return;
    }
    this.mX5WebView.clearCache(paramBoolean);
  }
  
  public void clearFormData()
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.clearFormData();
      return;
    }
    this.mX5WebView.clearFormData();
  }
  
  public void clearHistory()
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.clearHistory();
      return;
    }
    this.mX5WebView.clearHistory();
  }
  
  @TargetApi(3)
  public void clearMatches()
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.clearMatches();
      return;
    }
    this.mX5WebView.clearMatches();
  }
  
  public void clearSslPreferences()
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.clearSslPreferences();
      return;
    }
    this.mX5WebView.clearSslPreferences();
  }
  
  @Deprecated
  public void clearView()
  {
    if (!this.isX5Core)
    {
      ReflectionUtils.invokeInstance(this.mSysWebView, "clearView");
      return;
    }
    this.mX5WebView.clearView();
  }
  
  public void computeScroll()
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.computeScroll();
      return;
    }
    this.mX5WebView.computeScroll();
  }
  
  public WebBackForwardList copyBackForwardList()
  {
    if (this.isX5Core) {
      return WebBackForwardList.wrap(this.mX5WebView.copyBackForwardList());
    }
    return WebBackForwardList.wrap(this.mSysWebView.copyBackForwardList());
  }
  
  public Object createPrintDocumentAdapter(String paramString)
  {
    Object localObject = null;
    if (this.isX5Core) {}
    while (Build.VERSION.SDK_INT < 21) {
      try
      {
        localObject = this.mX5WebView.createPrintDocumentAdapter(paramString);
        return localObject;
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
        return null;
      }
    }
    return ReflectionUtils.invokeInstance(this.mSysWebView, "createPrintDocumentAdapter", new Class[] { String.class }, new Object[] { paramString });
  }
  
  public void destroy()
  {
    Object localObject4;
    Object localObject1;
    int i;
    if ((!this.mIsReported) && (this.mPv != 0))
    {
      this.mIsReported = true;
      String str1 = "";
      String str2 = "";
      String str3 = "";
      localObject4 = str1;
      ??? = str2;
      localObject1 = str3;
      if (this.isX5Core)
      {
        Bundle localBundle = this.mX5WebView.getX5WebViewExtension().getSdkQBStatisticsInfo();
        localObject4 = str1;
        ??? = str2;
        localObject1 = str3;
        if (localBundle != null)
        {
          localObject4 = localBundle.getString("guid");
          ??? = localBundle.getString("qua2");
          localObject1 = localBundle.getString("lc");
        }
      }
      if ("com.qzone".equals(this.mContext.getApplicationInfo().packageName))
      {
        int j = getTbsCorePV(this.mContext);
        i = j;
        if (j == -1) {
          i = this.mPv;
        }
        this.mPv = i;
        deletepvfile(this.mContext);
      }
      HttpUtils.doReport(this.mContext, (String)localObject4, (String)???, (String)localObject1, this.mPv, this.isX5Core, getWifiConnectedTime());
      this.mPv = 0;
      this.mIsReported = false;
    }
    if (!this.isX5Core) {}
    try
    {
      localObject1 = Class.forName("android.webkit.WebViewClassic");
      ??? = ((Class)localObject1).getMethod("fromWebView", new Class[] { android.webkit.WebView.class });
      ((Method)???).setAccessible(true);
      ??? = ((Method)???).invoke(null, new Object[] { this.mSysWebView });
      if (??? != null)
      {
        localObject1 = ((Class)localObject1).getDeclaredField("mListBoxDialog");
        ((Field)localObject1).setAccessible(true);
        localObject1 = ((Field)localObject1).get(???);
        if (localObject1 != null)
        {
          localObject1 = (Dialog)localObject1;
          ((Dialog)localObject1).setOnCancelListener(null);
          ??? = Class.forName("android.app.Dialog");
          localObject4 = ((Class)???).getDeclaredField("CANCEL");
          ((Field)localObject4).setAccessible(true);
          i = ((Integer)((Field)localObject4).get(localObject1)).intValue();
          ??? = ((Class)???).getDeclaredField("mListenersHandler");
          ((Field)???).setAccessible(true);
          ((Handler)((Field)???).get(localObject1)).removeMessages(i);
        }
      }
    }
    catch (Exception localException2)
    {
      for (;;) {}
    }
    this.mSysWebView.destroy();
    try
    {
      ??? = Class.forName("android.webkit.BrowserFrame").getDeclaredField("sConfigCallback");
      ((Field)???).setAccessible(true);
      localObject1 = (ComponentCallbacks)((Field)???).get(null);
      if (localObject1 == null) {
        return;
      }
      ((Field)???).set(null, null);
      ??? = Class.forName("android.view.ViewRoot").getDeclaredField("sConfigCallbacks");
      ((Field)???).setAccessible(true);
      ??? = ((Field)???).get(null);
      if (??? == null) {
        return;
      }
      synchronized ((List)???)
      {
        ((List)???).remove(localObject1);
        return;
      }
      this.mX5WebView.destroy();
    }
    catch (Exception localException1)
    {
      return;
    }
    return;
  }
  
  public void documentHasImages(Message paramMessage)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.documentHasImages(paramMessage);
      return;
    }
    this.mX5WebView.documentHasImages(paramMessage);
  }
  
  public void dumpViewHierarchyWithProperties(BufferedWriter paramBufferedWriter, int paramInt)
  {
    if (!this.isX5Core)
    {
      ReflectionUtils.invokeInstance(this.mSysWebView, "dumpViewHierarchyWithProperties", new Class[] { BufferedWriter.class, Integer.TYPE }, new Object[] { paramBufferedWriter, Integer.valueOf(paramInt) });
      return;
    }
    this.mX5WebView.dumpViewHierarchyWithProperties(paramBufferedWriter, paramInt);
  }
  
  public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    if (this.isX5Core) {}
    Method localMethod;
    while (Build.VERSION.SDK_INT < 19) {
      try
      {
        localMethod = ReflectionUtils.getParentDeclaredMethod(this.mX5WebView.getView(), "evaluateJavascript", new Class[] { String.class, android.webkit.ValueCallback.class });
        localMethod.setAccessible(true);
        localMethod.invoke(this.mX5WebView.getView(), new Object[] { paramString, paramValueCallback });
        return;
      }
      catch (Exception paramValueCallback)
      {
        paramValueCallback.printStackTrace();
        loadUrl(paramString);
        return;
      }
    }
    try
    {
      localMethod = Class.forName("android.webkit.WebView").getDeclaredMethod("evaluateJavascript", new Class[] { String.class, android.webkit.ValueCallback.class });
      localMethod.setAccessible(true);
      localMethod.invoke(this.mSysWebView, new Object[] { paramString, paramValueCallback });
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  @Deprecated
  public int findAll(String paramString)
  {
    if (!this.isX5Core)
    {
      paramString = ReflectionUtils.invokeInstance(this.mSysWebView, "findAll", new Class[] { String.class }, new Object[] { paramString });
      if (paramString == null) {
        return 0;
      }
      return ((Integer)paramString).intValue();
    }
    return this.mX5WebView.findAll(paramString);
  }
  
  @TargetApi(16)
  public void findAllAsync(String paramString)
  {
    if (!this.isX5Core)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        ReflectionUtils.invokeInstance(this.mSysWebView, "findAllAsync", new Class[] { String.class }, new Object[] { paramString });
      }
      return;
    }
    this.mX5WebView.findAllAsync(paramString);
  }
  
  public View findHierarchyView(String paramString, int paramInt)
  {
    if (!this.isX5Core) {
      return (View)ReflectionUtils.invokeInstance(this.mSysWebView, "findHierarchyView", new Class[] { String.class, Integer.TYPE }, new Object[] { paramString, Integer.valueOf(paramInt) });
    }
    return this.mX5WebView.findHierarchyView(paramString, paramInt);
  }
  
  @TargetApi(3)
  public void findNext(boolean paramBoolean)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.findNext(paramBoolean);
      return;
    }
    this.mX5WebView.findNext(paramBoolean);
  }
  
  public void flingScroll(int paramInt1, int paramInt2)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.flingScroll(paramInt1, paramInt2);
      return;
    }
    this.mX5WebView.flingScroll(paramInt1, paramInt2);
  }
  
  @Deprecated
  public void freeMemory()
  {
    if (!this.isX5Core)
    {
      ReflectionUtils.invokeInstance(this.mSysWebView, "freeMemory");
      return;
    }
    this.mX5WebView.freeMemory();
  }
  
  public SslCertificate getCertificate()
  {
    if (!this.isX5Core) {
      return this.mSysWebView.getCertificate();
    }
    return this.mX5WebView.getCertificate();
  }
  
  public int getContentHeight()
  {
    if (!this.isX5Core) {
      return this.mSysWebView.getContentHeight();
    }
    return this.mX5WebView.getContentHeight();
  }
  
  public int getContentWidth()
  {
    if (!this.isX5Core)
    {
      Object localObject = ReflectionUtils.invokeInstance(this.mSysWebView, "getContentWidth");
      if (localObject == null) {
        return 0;
      }
      return ((Integer)localObject).intValue();
    }
    return this.mX5WebView.getContentWidth();
  }
  
  public Bitmap getFavicon()
  {
    if (!this.isX5Core) {
      return this.mSysWebView.getFavicon();
    }
    return this.mX5WebView.getFavicon();
  }
  
  public HitTestResult getHitTestResult()
  {
    if (!this.isX5Core) {
      return new HitTestResult(this.mSysWebView.getHitTestResult());
    }
    return new HitTestResult(this.mX5WebView.getHitTestResult());
  }
  
  public String[] getHttpAuthUsernamePassword(String paramString1, String paramString2)
  {
    if (!this.isX5Core) {
      return this.mSysWebView.getHttpAuthUsernamePassword(paramString1, paramString2);
    }
    return this.mX5WebView.getHttpAuthUsernamePassword(paramString1, paramString2);
  }
  
  @TargetApi(3)
  public String getOriginalUrl()
  {
    if (!this.isX5Core) {
      return this.mSysWebView.getOriginalUrl();
    }
    return this.mX5WebView.getOriginalUrl();
  }
  
  public int getProgress()
  {
    if (!this.isX5Core) {
      return this.mSysWebView.getProgress();
    }
    return this.mX5WebView.getProgress();
  }
  
  @Deprecated
  public float getScale()
  {
    if (!this.isX5Core)
    {
      Object localObject = ReflectionUtils.invokeInstance(this.mSysWebView, "getScale");
      if (localObject == null) {
        return 0.0F;
      }
      return ((Float)localObject).floatValue();
    }
    return this.mX5WebView.getScale();
  }
  
  public int getScrollBarDefaultDelayBeforeFade()
  {
    return getView().getScrollBarDefaultDelayBeforeFade();
  }
  
  public int getScrollBarFadeDuration()
  {
    return getView().getScrollBarFadeDuration();
  }
  
  public int getScrollBarSize()
  {
    return getView().getScrollBarSize();
  }
  
  public int getScrollBarStyle()
  {
    return getView().getScrollBarStyle();
  }
  
  public WebSettings getSettings()
  {
    if (this.mWebSettings != null) {
      return this.mWebSettings;
    }
    if (this.isX5Core)
    {
      localWebSettings = new WebSettings(this.mX5WebView.getSettings());
      this.mWebSettings = localWebSettings;
      return localWebSettings;
    }
    WebSettings localWebSettings = new WebSettings(this.mSysWebView.getSettings());
    this.mWebSettings = localWebSettings;
    return localWebSettings;
  }
  
  public IX5WebSettingsExtension getSettingsExtension()
  {
    if (!this.isX5Core) {
      return null;
    }
    return this.mX5WebView.getX5WebViewExtension().getSettingsExtension();
  }
  
  public int getSysNightModeAlpha()
  {
    return NIGHT_MODE_ALPHA;
  }
  
  android.webkit.WebView getSysWebView()
  {
    if (!this.isX5Core) {
      return this.mSysWebView;
    }
    return null;
  }
  
  public String getTitle()
  {
    if (!this.isX5Core) {
      return this.mSysWebView.getTitle();
    }
    return this.mX5WebView.getTitle();
  }
  
  public String getUrl()
  {
    if (!this.isX5Core) {
      return this.mSysWebView.getUrl();
    }
    return this.mX5WebView.getUrl();
  }
  
  public View getView()
  {
    if (!this.isX5Core) {
      return this.mSysWebView;
    }
    return this.mX5WebView.getView();
  }
  
  public int getVisibleTitleHeight()
  {
    if (!this.isX5Core)
    {
      Object localObject = ReflectionUtils.invokeInstance(this.mSysWebView, "getVisibleTitleHeight");
      if (localObject == null) {
        return 0;
      }
      return ((Integer)localObject).intValue();
    }
    return this.mX5WebView.getVisibleTitleHeight();
  }
  
  public IX5WebChromeClientExtension getWebChromeClientExtension()
  {
    if (!this.isX5Core) {
      return null;
    }
    return this.mX5WebView.getX5WebViewExtension().getWebChromeClientExtension();
  }
  
  public int getWebScrollX()
  {
    if (this.isX5Core) {
      return this.mX5WebView.getView().getScrollX();
    }
    return this.mSysWebView.getScrollX();
  }
  
  public int getWebScrollY()
  {
    if (this.isX5Core) {
      return this.mX5WebView.getView().getScrollY();
    }
    return this.mSysWebView.getScrollY();
  }
  
  public IX5WebViewClientExtension getWebViewClientExtension()
  {
    if (!this.isX5Core) {
      return null;
    }
    return this.mX5WebView.getX5WebViewExtension().getWebViewClientExtension();
  }
  
  IX5WebViewBase getX5WebView()
  {
    return this.mX5WebView;
  }
  
  public IX5WebViewExtension getX5WebViewExtension()
  {
    if (!this.isX5Core) {
      return null;
    }
    return this.mX5WebView.getX5WebViewExtension();
  }
  
  @Deprecated
  public View getZoomControls()
  {
    if (!this.isX5Core) {
      return (View)ReflectionUtils.invokeInstance(this.mSysWebView, "getZoomControls");
    }
    return this.mX5WebView.getZoomControls();
  }
  
  public void goBack()
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.goBack();
      return;
    }
    this.mX5WebView.goBack();
  }
  
  public void goBackOrForward(int paramInt)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.goBackOrForward(paramInt);
      return;
    }
    this.mX5WebView.goBackOrForward(paramInt);
  }
  
  public void goForward()
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.goForward();
      return;
    }
    this.mX5WebView.goForward();
  }
  
  public void invokeZoomPicker()
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.invokeZoomPicker();
      return;
    }
    this.mX5WebView.invokeZoomPicker();
  }
  
  public boolean isDayMode()
  {
    return mIsDayMode;
  }
  
  public boolean isPrivateBrowsingEnabled()
  {
    if (!this.isX5Core)
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        Object localObject = ReflectionUtils.invokeInstance(this.mSysWebView, "isPrivateBrowsingEnabled");
        if (localObject == null) {
          return false;
        }
        return ((Boolean)localObject).booleanValue();
      }
      return false;
    }
    return this.mX5WebView.isPrivateBrowsingEnable();
  }
  
  public void loadData(String paramString1, String paramString2, String paramString3)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.loadData(paramString1, paramString2, paramString3);
      return;
    }
    this.mX5WebView.loadData(paramString1, paramString2, paramString3);
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
      return;
    }
    this.mX5WebView.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
  }
  
  public void loadUrl(String paramString)
  {
    if ((paramString == null) || (showDebugView(paramString))) {
      return;
    }
    if (!this.isX5Core)
    {
      this.mSysWebView.loadUrl(paramString);
      return;
    }
    this.mX5WebView.loadUrl(paramString);
  }
  
  @TargetApi(8)
  public void loadUrl(String paramString, Map<String, String> paramMap)
  {
    if ((paramString == null) || (showDebugView(paramString))) {}
    do
    {
      return;
      if (this.isX5Core) {
        break;
      }
    } while (Build.VERSION.SDK_INT < 8);
    this.mSysWebView.loadUrl(paramString, paramMap);
    return;
    this.mX5WebView.loadUrl(paramString, paramMap);
  }
  
  protected void onDetachedFromWindow()
  {
    if ((!this.mIsReported) && (this.mPv != 0))
    {
      this.mIsReported = true;
      String str4 = "";
      String str5 = "";
      String str6 = "";
      String str3 = str4;
      String str2 = str5;
      String str1 = str6;
      if (this.isX5Core)
      {
        Bundle localBundle = this.mX5WebView.getX5WebViewExtension().getSdkQBStatisticsInfo();
        str3 = str4;
        str2 = str5;
        str1 = str6;
        if (localBundle != null)
        {
          str3 = localBundle.getString("guid");
          str2 = localBundle.getString("qua2");
          str1 = localBundle.getString("lc");
        }
      }
      if ("com.qzone".equals(this.mContext.getApplicationInfo().packageName))
      {
        int j = getTbsCorePV(this.mContext);
        int i = j;
        if (j == -1) {
          i = this.mPv;
        }
        this.mPv = i;
        deletepvfile(this.mContext);
      }
      HttpUtils.doReport(this.mContext, str3, str2, str1, this.mPv, this.isX5Core, getWifiConnectedTime());
      this.mPv = 0;
      this.mIsReported = false;
    }
    super.onDetachedFromWindow();
  }
  
  public boolean onLongClick(View paramView)
  {
    if (this.mOnLongClickListener != null)
    {
      if (!this.mOnLongClickListener.onLongClick(paramView)) {
        return callX5CoreOnLongClick(paramView);
      }
      return true;
    }
    return callX5CoreOnLongClick(paramView);
  }
  
  public void onPause()
  {
    if (!this.isX5Core)
    {
      ReflectionUtils.invokeInstance(this.mSysWebView, "onPause");
      return;
    }
    this.mX5WebView.onPause();
  }
  
  public void onResume()
  {
    if (!this.isX5Core)
    {
      ReflectionUtils.invokeInstance(this.mSysWebView, "onResume");
      return;
    }
    this.mX5WebView.onResume();
  }
  
  @TargetApi(11)
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((Build.VERSION.SDK_INT >= 21) && (isQQ(this.mContext)) && (isHardwareAccelerated()) && (paramInt1 > 0) && (paramInt2 > 0) && (getLayerType() != 2) && (this.mX5WebView != null) && (this.mX5WebView.getView() != null)) {
      this.mX5WebView.getView().setLayerType(2, null);
    }
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    if (this.mContext == null)
    {
      super.onVisibilityChanged(paramView, paramInt);
      return;
    }
    if (mCallerAppPackageName == null) {
      mCallerAppPackageName = this.mContext.getApplicationInfo().packageName;
    }
    if ((mCallerAppPackageName != null) && ((mCallerAppPackageName.equals("com.tencent.mm")) || (mCallerAppPackageName.equals("com.tencent.mobileqq"))))
    {
      super.onVisibilityChanged(paramView, paramInt);
      return;
    }
    if ((paramInt != 0) && (!this.mIsReported) && (this.mPv != 0))
    {
      this.mIsReported = true;
      String str4 = "";
      String str5 = "";
      String str6 = "";
      String str3 = str4;
      String str2 = str5;
      String str1 = str6;
      if (this.isX5Core)
      {
        Bundle localBundle = this.mX5WebView.getX5WebViewExtension().getSdkQBStatisticsInfo();
        str3 = str4;
        str2 = str5;
        str1 = str6;
        if (localBundle != null)
        {
          str3 = localBundle.getString("guid");
          str2 = localBundle.getString("qua2");
          str1 = localBundle.getString("lc");
        }
      }
      if ("com.qzone".equals(this.mContext.getApplicationInfo().packageName))
      {
        int j = getTbsCorePV(this.mContext);
        int i = j;
        if (j == -1) {
          i = this.mPv;
        }
        this.mPv = i;
        deletepvfile(this.mContext);
      }
      HttpUtils.doReport(this.mContext, str3, str2, str1, this.mPv, this.isX5Core, getWifiConnectedTime());
      this.mPv = 0;
      this.mIsReported = false;
    }
    super.onVisibilityChanged(paramView, paramInt);
  }
  
  public boolean overlayHorizontalScrollbar()
  {
    if (!this.isX5Core) {
      return this.mSysWebView.overlayHorizontalScrollbar();
    }
    return this.mX5WebView.overlayHorizontalScrollbar();
  }
  
  public boolean overlayVerticalScrollbar()
  {
    if (this.isX5Core) {
      return this.mX5WebView.overlayVerticalScrollbar();
    }
    return this.mSysWebView.overlayVerticalScrollbar();
  }
  
  public boolean pageDown(boolean paramBoolean)
  {
    if (!this.isX5Core) {
      return this.mSysWebView.pageDown(paramBoolean);
    }
    return this.mX5WebView.pageDown(paramBoolean, -1);
  }
  
  public boolean pageUp(boolean paramBoolean)
  {
    if (!this.isX5Core) {
      return this.mSysWebView.pageUp(paramBoolean);
    }
    return this.mX5WebView.pageUp(paramBoolean, -1);
  }
  
  public void pauseTimers()
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.pauseTimers();
      return;
    }
    this.mX5WebView.pauseTimers();
  }
  
  @TargetApi(5)
  public void postUrl(String paramString, byte[] paramArrayOfByte)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.postUrl(paramString, paramArrayOfByte);
      return;
    }
    this.mX5WebView.postUrl(paramString, paramArrayOfByte);
  }
  
  @Deprecated
  public void refreshPlugins(boolean paramBoolean)
  {
    if (!this.isX5Core)
    {
      ReflectionUtils.invokeInstance(this.mSysWebView, "refreshPlugins", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    this.mX5WebView.refreshPlugins(paramBoolean);
  }
  
  public void reload()
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.reload();
      return;
    }
    this.mX5WebView.reload();
  }
  
  @TargetApi(11)
  public void removeJavascriptInterface(String paramString)
  {
    if (!this.isX5Core)
    {
      if (Build.VERSION.SDK_INT >= 11) {
        ReflectionUtils.invokeInstance(this.mSysWebView, "removeJavascriptInterface", new Class[] { String.class }, new Object[] { paramString });
      }
    }
    else {
      return;
    }
    this.mX5WebView.removeJavascriptInterface(paramString);
  }
  
  public void removeView(View paramView)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.removeView(paramView);
      return;
    }
    View localView = this.mX5WebView.getView();
    try
    {
      Method localMethod = ReflectionUtils.getParentDeclaredMethod(localView, "removeView", new Class[] { View.class });
      localMethod.setAccessible(true);
      localMethod.invoke(localView, new Object[] { paramView });
      return;
    }
    catch (Throwable paramView) {}
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    if (this.isX5Core)
    {
      localObject1 = this.mX5WebView.getView();
      if ((localObject1 instanceof ViewGroup))
      {
        localObject2 = (ViewGroup)localObject1;
        if (paramView == this) {
          paramView = (View)localObject1;
        }
        for (;;)
        {
          return ((ViewGroup)localObject2).requestChildRectangleOnScreen(paramView, paramRect, paramBoolean);
        }
      }
      return false;
    }
    Object localObject2 = this.mSysWebView;
    Object localObject1 = paramView;
    if (paramView == this) {
      localObject1 = this.mSysWebView;
    }
    return ((android.webkit.WebView)localObject2).requestChildRectangleOnScreen((View)localObject1, paramRect, paramBoolean);
  }
  
  public void requestFocusNodeHref(Message paramMessage)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.requestFocusNodeHref(paramMessage);
      return;
    }
    this.mX5WebView.requestFocusNodeHref(paramMessage);
  }
  
  public void requestImageRef(Message paramMessage)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.requestImageRef(paramMessage);
      return;
    }
    this.mX5WebView.requestImageRef(paramMessage);
  }
  
  @Deprecated
  public boolean restorePicture(Bundle paramBundle, File paramFile)
  {
    if (!this.isX5Core)
    {
      paramBundle = ReflectionUtils.invokeInstance(this.mSysWebView, "restorePicture", new Class[] { Bundle.class, File.class }, new Object[] { paramBundle, paramFile });
      if (paramBundle == null) {
        return false;
      }
      return ((Boolean)paramBundle).booleanValue();
    }
    return this.mX5WebView.restorePicture(paramBundle, paramFile);
  }
  
  public WebBackForwardList restoreState(Bundle paramBundle)
  {
    if (!this.isX5Core) {
      return WebBackForwardList.wrap(this.mSysWebView.restoreState(paramBundle));
    }
    return WebBackForwardList.wrap(this.mX5WebView.restoreState(paramBundle));
  }
  
  public void resumeTimers()
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.resumeTimers();
      return;
    }
    this.mX5WebView.resumeTimers();
  }
  
  @Deprecated
  public void savePassword(String paramString1, String paramString2, String paramString3)
  {
    if (!this.isX5Core)
    {
      ReflectionUtils.invokeInstance(this.mSysWebView, "savePassword", new Class[] { String.class, String.class, String.class }, new Object[] { paramString1, paramString2, paramString3 });
      return;
    }
    this.mX5WebView.savePassword(paramString1, paramString2, paramString3);
  }
  
  @Deprecated
  public boolean savePicture(Bundle paramBundle, File paramFile)
  {
    if (!this.isX5Core)
    {
      paramBundle = ReflectionUtils.invokeInstance(this.mSysWebView, "savePicture", new Class[] { Bundle.class, File.class }, new Object[] { paramBundle, paramFile });
      if (paramBundle == null) {
        return false;
      }
      return ((Boolean)paramBundle).booleanValue();
    }
    return this.mX5WebView.savePicture(paramBundle, paramFile);
  }
  
  public WebBackForwardList saveState(Bundle paramBundle)
  {
    if (!this.isX5Core) {
      return WebBackForwardList.wrap(this.mSysWebView.saveState(paramBundle));
    }
    return WebBackForwardList.wrap(this.mX5WebView.saveState(paramBundle));
  }
  
  @TargetApi(11)
  public void saveWebArchive(String paramString)
  {
    if (!this.isX5Core)
    {
      if (Build.VERSION.SDK_INT >= 11) {
        ReflectionUtils.invokeInstance(this.mSysWebView, "saveWebArchive", new Class[] { String.class }, new Object[] { paramString });
      }
      return;
    }
    this.mX5WebView.saveWebArchive(paramString);
  }
  
  @TargetApi(11)
  public void saveWebArchive(String paramString, boolean paramBoolean, ValueCallback<String> paramValueCallback)
  {
    if (!this.isX5Core)
    {
      if (Build.VERSION.SDK_INT >= 11) {
        ReflectionUtils.invokeInstance(this.mSysWebView, "saveWebArchive", new Class[] { String.class, Boolean.TYPE, android.webkit.ValueCallback.class }, new Object[] { paramString, Boolean.valueOf(paramBoolean), paramValueCallback });
      }
      return;
    }
    this.mX5WebView.saveWebArchive(paramString, paramBoolean, paramValueCallback);
  }
  
  public void setBackgroundColor(int paramInt)
  {
    if (!this.isX5Core) {
      this.mSysWebView.setBackgroundColor(paramInt);
    }
    for (;;)
    {
      super.setBackgroundColor(paramInt);
      return;
      this.mX5WebView.setBackgroundColor(paramInt);
    }
  }
  
  @Deprecated
  public void setCertificate(SslCertificate paramSslCertificate)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.setCertificate(paramSslCertificate);
      return;
    }
    this.mX5WebView.setCertificate(paramSslCertificate);
  }
  
  public void setDayOrNight(boolean paramBoolean)
  {
    try
    {
      if (this.isX5Core) {
        getSettingsExtension().setDayOrNight(paramBoolean);
      }
      setSysDayOrNight(paramBoolean);
      getView().postInvalidate();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void setDownloadListener(final DownloadListener paramDownloadListener)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.setDownloadListener(new android.webkit.DownloadListener()
      {
        public void onDownloadStart(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, long paramAnonymousLong)
        {
          if (paramDownloadListener == null)
          {
            MttLoader.loadUrl(WebView.this.mContext, paramAnonymousString1, null, null);
            return;
          }
          paramDownloadListener.onDownloadStart(paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, paramAnonymousString4, paramAnonymousLong);
        }
      });
      return;
    }
    this.mX5WebView.setDownloadListener(new DownLoadListenerAdapter(this, paramDownloadListener, this.isX5Core));
  }
  
  @TargetApi(16)
  public void setFindListener(final IX5WebViewBase.FindListener paramFindListener)
  {
    if (!this.isX5Core)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        this.mSysWebView.setFindListener(new WebView.FindListener()
        {
          public void onFindResultReceived(int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean)
          {
            paramFindListener.onFindResultReceived(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBoolean);
          }
        });
      }
      return;
    }
    this.mX5WebView.setFindListener(paramFindListener);
  }
  
  public void setHorizontalScrollbarOverlay(boolean paramBoolean)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.setHorizontalScrollbarOverlay(paramBoolean);
      return;
    }
    this.mX5WebView.setHorizontalScrollbarOverlay(paramBoolean);
  }
  
  public void setHttpAuthUsernamePassword(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.setHttpAuthUsernamePassword(paramString1, paramString2, paramString3, paramString4);
      return;
    }
    this.mX5WebView.setHttpAuthUsernamePassword(paramString1, paramString2, paramString3, paramString4);
  }
  
  public void setInitialScale(int paramInt)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.setInitialScale(paramInt);
      return;
    }
    this.mX5WebView.setInitialScale(paramInt);
  }
  
  public void setLongPressTextExtensionMenu(int paramInt)
  {
    if (this.isX5Core) {
      ReflectionUtils.invokeInstance(this.mX5WebView, "setLongPressTextExtensionMenu", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(paramInt) });
    }
  }
  
  @Deprecated
  public void setMapTrackballToArrowKeys(boolean paramBoolean)
  {
    if (!this.isX5Core)
    {
      ReflectionUtils.invokeInstance(this.mSysWebView, "setMapTrackballToArrowKeys", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    this.mX5WebView.setMapTrackballToArrowKeys(paramBoolean);
  }
  
  public void setNetworkAvailable(boolean paramBoolean)
  {
    if (!this.isX5Core)
    {
      if (Build.VERSION.SDK_INT >= 3) {
        this.mSysWebView.setNetworkAvailable(paramBoolean);
      }
      return;
    }
    this.mX5WebView.setNetworkAvailable(paramBoolean);
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.setOnLongClickListener(paramOnLongClickListener);
      return;
    }
    Object localObject1 = this.mX5WebView.getView();
    try
    {
      if (this.longClickListener == null)
      {
        Object localObject2 = ReflectionUtils.getParentDeclaredMethod(localObject1, "getListenerInfo", new Class[0]);
        ((Method)localObject2).setAccessible(true);
        localObject1 = ((Method)localObject2).invoke(localObject1, (Object[])null);
        localObject2 = localObject1.getClass().getDeclaredField("mOnLongClickListener");
        ((Field)localObject2).setAccessible(true);
        this.longClickListener = ((Field)localObject2).get(localObject1);
      }
      this.mOnLongClickListener = paramOnLongClickListener;
      getView().setOnLongClickListener(this);
      return;
    }
    catch (Throwable paramOnLongClickListener) {}
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    getView().setOnTouchListener(paramOnTouchListener);
  }
  
  public void setPictureListener(final PictureListener paramPictureListener)
  {
    if (!this.isX5Core)
    {
      if (paramPictureListener == null)
      {
        this.mSysWebView.setPictureListener(null);
        return;
      }
      this.mSysWebView.setPictureListener(new android.webkit.WebView.PictureListener()
      {
        public void onNewPicture(android.webkit.WebView paramAnonymousWebView, Picture paramAnonymousPicture)
        {
          WebView.this.setSysWebView(paramAnonymousWebView);
          paramPictureListener.onNewPicture(WebView.this, paramAnonymousPicture);
        }
      });
      return;
    }
    if (paramPictureListener == null)
    {
      this.mX5WebView.setPictureListener(null);
      return;
    }
    this.mX5WebView.setPictureListener(new IX5WebViewBase.PictureListener()
    {
      public void onNewPicture(IX5WebViewBase paramAnonymousIX5WebViewBase, Picture paramAnonymousPicture, boolean paramAnonymousBoolean)
      {
        WebView.this.setX5WebView(paramAnonymousIX5WebViewBase);
        paramPictureListener.onNewPicture(WebView.this, paramAnonymousPicture);
      }
      
      public void onNewPictureIfHaveContent(IX5WebViewBase paramAnonymousIX5WebViewBase, Picture paramAnonymousPicture) {}
    });
  }
  
  public void setScrollBarStyle(int paramInt)
  {
    if (this.isX5Core)
    {
      this.mX5WebView.getView().setScrollBarStyle(paramInt);
      return;
    }
    this.mSysWebView.setScrollBarStyle(paramInt);
  }
  
  public void setSysNightModeAlpha(int paramInt)
  {
    NIGHT_MODE_ALPHA = paramInt;
  }
  
  void setSysWebView(android.webkit.WebView paramWebView)
  {
    if (!this.isX5Core) {}
  }
  
  public void setVerticalScrollbarOverlay(boolean paramBoolean)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.setVerticalScrollbarOverlay(paramBoolean);
      return;
    }
    this.mX5WebView.setVerticalScrollbarOverlay(paramBoolean);
  }
  
  public boolean setVideoFullScreen(Context paramContext, boolean paramBoolean)
  {
    if ((paramContext.getApplicationInfo().processName.contains("com.tencent.android.qqdownloader")) && (this.mX5WebView != null))
    {
      paramContext = new Bundle();
      if (paramBoolean) {
        paramContext.putInt("DefaultVideoScreen", 2);
      }
      for (;;)
      {
        this.mX5WebView.getX5WebViewExtension().invokeMiscMethod("setVideoParams", paramContext);
        return true;
        paramContext.putInt("DefaultVideoScreen", 1);
      }
    }
    return false;
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    getView().setVisibility(paramInt);
  }
  
  public void setWebChromeClient(WebChromeClient paramWebChromeClient)
  {
    IX5WebViewBase localIX5WebViewBase = null;
    SystemWebView localSystemWebView = null;
    if (this.isX5Core)
    {
      localIX5WebViewBase = this.mX5WebView;
      if (paramWebChromeClient == null) {}
      for (paramWebChromeClient = localSystemWebView;; paramWebChromeClient = new SmttWebChromeClient(X5CoreEngine.getInstance().wizardForCoreTypeConfirmed(true).createDefaultX5WebChromeClient(), this, paramWebChromeClient))
      {
        localIX5WebViewBase.setWebChromeClient(paramWebChromeClient);
        return;
      }
    }
    localSystemWebView = this.mSysWebView;
    if (paramWebChromeClient == null) {}
    for (paramWebChromeClient = localIX5WebViewBase;; paramWebChromeClient = new SystemWebChromeClient(this, paramWebChromeClient))
    {
      localSystemWebView.setWebChromeClient(paramWebChromeClient);
      return;
    }
  }
  
  public void setWebChromeClientExtension(IX5WebChromeClientExtension paramIX5WebChromeClientExtension)
  {
    if (!this.isX5Core) {
      return;
    }
    this.mX5WebView.getX5WebViewExtension().setWebChromeClientExtension(paramIX5WebChromeClientExtension);
  }
  
  public void setWebViewCallbackClient(WebViewCallbackClient paramWebViewCallbackClient)
  {
    this.mWebViewCallbackClient = paramWebViewCallbackClient;
    if ((this.isX5Core) && (getX5WebViewExtension() != null))
    {
      paramWebViewCallbackClient = new Bundle();
      paramWebViewCallbackClient.putBoolean("flag", true);
      getX5WebViewExtension().invokeMiscMethod("setWebViewCallbackClientFlag", paramWebViewCallbackClient);
    }
  }
  
  public void setWebViewClient(WebViewClient paramWebViewClient)
  {
    IX5WebViewBase localIX5WebViewBase = null;
    SystemWebView localSystemWebView = null;
    this.mWebViewClient = paramWebViewClient;
    if (this.isX5Core)
    {
      localIX5WebViewBase = this.mX5WebView;
      if (paramWebViewClient == null) {}
      for (paramWebViewClient = localSystemWebView;; paramWebViewClient = new SmttWebViewClient(X5CoreEngine.getInstance().wizardForCoreTypeConfirmed(true).createDefaultX5WebViewClient(), this, paramWebViewClient))
      {
        localIX5WebViewBase.setWebViewClient(paramWebViewClient);
        return;
      }
    }
    localSystemWebView = this.mSysWebView;
    if (paramWebViewClient == null) {}
    for (paramWebViewClient = localIX5WebViewBase;; paramWebViewClient = new SystemWebViewClient(this, paramWebViewClient))
    {
      localSystemWebView.setWebViewClient(paramWebViewClient);
      return;
    }
  }
  
  public void setWebViewClientExtension(IX5WebViewClientExtension paramIX5WebViewClientExtension)
  {
    if (!this.isX5Core) {
      return;
    }
    this.mX5WebView.getX5WebViewExtension().setWebViewClientExtension(paramIX5WebViewClientExtension);
  }
  
  void setX5WebView(IX5WebViewBase paramIX5WebViewBase)
  {
    this.mX5WebView = paramIX5WebViewBase;
  }
  
  @SuppressLint({"NewApi"})
  public boolean showDebugView(String paramString)
  {
    if (paramString.startsWith("http://debugtbs.qq.com"))
    {
      getView().setVisibility(4);
      DebugTbsPlugin.getInstance(this.mContext).showPluginView(paramString, this, this.mContext, TbsHandlerThread.getInstance().getLooper());
      return true;
    }
    return false;
  }
  
  public boolean showFindDialog(String paramString, boolean paramBoolean)
  {
    return false;
  }
  
  public void stopLoading()
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.stopLoading();
      return;
    }
    this.mX5WebView.stopLoading();
  }
  
  public void super_computeScroll()
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.super_computeScroll();
      return;
    }
    View localView = this.mX5WebView.getView();
    try
    {
      ReflectionUtils.invokeInstance(localView, "super_computeScroll");
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public boolean super_dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.isX5Core) {
      return this.mSysWebView.super_dispatchTouchEvent(paramMotionEvent);
    }
    View localView = this.mX5WebView.getView();
    try
    {
      paramMotionEvent = ReflectionUtils.invokeInstance(localView, "super_dispatchTouchEvent", new Class[] { MotionEvent.class }, new Object[] { paramMotionEvent });
      if (paramMotionEvent == null) {
        return false;
      }
      boolean bool = ((Boolean)paramMotionEvent).booleanValue();
      return bool;
    }
    catch (Throwable paramMotionEvent) {}
    return false;
  }
  
  public boolean super_onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.isX5Core) {
      return this.mSysWebView.super_onInterceptTouchEvent(paramMotionEvent);
    }
    View localView = this.mX5WebView.getView();
    try
    {
      paramMotionEvent = ReflectionUtils.invokeInstance(localView, "super_onInterceptTouchEvent", new Class[] { MotionEvent.class }, new Object[] { paramMotionEvent });
      if (paramMotionEvent == null) {
        return false;
      }
      boolean bool = ((Boolean)paramMotionEvent).booleanValue();
      return bool;
    }
    catch (Throwable paramMotionEvent) {}
    return false;
  }
  
  public void super_onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.super_onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
      return;
    }
    View localView = this.mX5WebView.getView();
    try
    {
      ReflectionUtils.invokeInstance(localView, "super_onOverScrolled", new Class[] { Integer.TYPE, Integer.TYPE, Boolean.TYPE, Boolean.TYPE }, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void super_onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.super_onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    View localView = this.mX5WebView.getView();
    try
    {
      ReflectionUtils.invokeInstance(localView, "super_onScrollChanged", new Class[] { Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE }, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public boolean super_onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.isX5Core) {
      return this.mSysWebView.super_onTouchEvent(paramMotionEvent);
    }
    View localView = this.mX5WebView.getView();
    try
    {
      paramMotionEvent = ReflectionUtils.invokeInstance(localView, "super_onTouchEvent", new Class[] { MotionEvent.class }, new Object[] { paramMotionEvent });
      if (paramMotionEvent == null) {
        return false;
      }
      boolean bool = ((Boolean)paramMotionEvent).booleanValue();
      return bool;
    }
    catch (Throwable paramMotionEvent) {}
    return false;
  }
  
  public boolean super_overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    if (!this.isX5Core) {
      return this.mSysWebView.super_overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
    }
    Object localObject = this.mX5WebView.getView();
    try
    {
      localObject = ReflectionUtils.invokeInstance(localObject, "super_overScrollBy", new Class[] { Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Boolean.TYPE }, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), Integer.valueOf(paramInt8), Boolean.valueOf(paramBoolean) });
      if (localObject == null) {
        return false;
      }
      paramBoolean = ((Boolean)localObject).booleanValue();
      return paramBoolean;
    }
    catch (Throwable localThrowable) {}
    return false;
  }
  
  public void switchNightMode(boolean paramBoolean)
  {
    if (paramBoolean == mIsDayMode) {
      return;
    }
    mIsDayMode = paramBoolean;
    if (mIsDayMode)
    {
      TbsLog.e("QB_SDK", "deleteNightMode");
      loadUrl("javascript:document.getElementsByTagName('HEAD').item(0).removeChild(document.getElementById('QQBrowserSDKNightMode'));");
      return;
    }
    TbsLog.e("QB_SDK", "nightMode");
    loadUrl("javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);");
  }
  
  public void switchToNightMode()
  {
    TbsLog.e("QB_SDK", "switchToNightMode 01");
    if (!mIsDayMode)
    {
      TbsLog.e("QB_SDK", "switchToNightMode");
      loadUrl("javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);");
    }
  }
  
  /* Error */
  void writetbscorepvfile(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 872	com/tencent/smtt/sdk/WebView:getTbsCorePV	(Landroid/content/Context;)I
    //   5: istore_3
    //   6: iload_3
    //   7: iconst_m1
    //   8: if_icmpeq +80 -> 88
    //   11: new 446	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 447	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 1560
    //   21: invokevirtual 457	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: iload_3
    //   25: iconst_1
    //   26: iadd
    //   27: invokestatic 740	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   30: invokevirtual 457	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 463	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: astore_2
    //   37: aload_1
    //   38: ldc_w 438
    //   41: iconst_0
    //   42: invokevirtual 442	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   45: astore_1
    //   46: new 444	java/io/File
    //   49: dup
    //   50: new 446	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 447	java/lang/StringBuilder:<init>	()V
    //   57: aload_1
    //   58: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   61: getstatic 454	java/io/File:separator	Ljava/lang/String;
    //   64: invokevirtual 457	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: ldc_w 459
    //   70: invokevirtual 457	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: invokevirtual 463	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: ldc_w 465
    //   79: invokespecial 467	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   82: astore_1
    //   83: aload_1
    //   84: ifnonnull +11 -> 95
    //   87: return
    //   88: ldc_w 1562
    //   91: astore_2
    //   92: goto -55 -> 37
    //   95: aload_1
    //   96: invokevirtual 1566	java/io/File:getParentFile	()Ljava/io/File;
    //   99: invokevirtual 1569	java/io/File:mkdirs	()Z
    //   102: pop
    //   103: aload_1
    //   104: invokevirtual 1572	java/io/File:isFile	()Z
    //   107: ifeq +10 -> 117
    //   110: aload_1
    //   111: invokevirtual 470	java/io/File:exists	()Z
    //   114: ifne +8 -> 122
    //   117: aload_1
    //   118: invokevirtual 1575	java/io/File:createNewFile	()Z
    //   121: pop
    //   122: new 1577	java/io/FileOutputStream
    //   125: dup
    //   126: aload_1
    //   127: iconst_0
    //   128: invokespecial 1580	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   131: putstatic 120	com/tencent/smtt/sdk/WebView:outputStream	Ljava/io/OutputStream;
    //   134: getstatic 120	com/tencent/smtt/sdk/WebView:outputStream	Ljava/io/OutputStream;
    //   137: aload_2
    //   138: invokevirtual 1584	java/lang/String:getBytes	()[B
    //   141: invokevirtual 1590	java/io/OutputStream:write	([B)V
    //   144: getstatic 120	com/tencent/smtt/sdk/WebView:outputStream	Ljava/io/OutputStream;
    //   147: ifnull -60 -> 87
    //   150: getstatic 120	com/tencent/smtt/sdk/WebView:outputStream	Ljava/io/OutputStream;
    //   153: invokevirtual 1593	java/io/OutputStream:flush	()V
    //   156: return
    //   157: astore_1
    //   158: getstatic 120	com/tencent/smtt/sdk/WebView:outputStream	Ljava/io/OutputStream;
    //   161: ifnull +9 -> 170
    //   164: getstatic 120	com/tencent/smtt/sdk/WebView:outputStream	Ljava/io/OutputStream;
    //   167: invokevirtual 1593	java/io/OutputStream:flush	()V
    //   170: aload_1
    //   171: athrow
    //   172: astore_1
    //   173: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	174	0	this	WebView
    //   0	174	1	paramContext	Context
    //   36	102	2	str	String
    //   5	22	3	i	int
    // Exception table:
    //   from	to	target	type
    //   95	117	157	finally
    //   117	122	157	finally
    //   122	144	157	finally
    //   144	156	172	java/lang/Throwable
    //   158	170	172	java/lang/Throwable
    //   170	172	172	java/lang/Throwable
  }
  
  public boolean zoomIn()
  {
    if (!this.isX5Core) {
      return this.mSysWebView.zoomIn();
    }
    return this.mX5WebView.zoomIn();
  }
  
  public boolean zoomOut()
  {
    if (!this.isX5Core) {
      return this.mSysWebView.zoomOut();
    }
    return this.mX5WebView.zoomOut();
  }
  
  public static class HitTestResult
  {
    @Deprecated
    public static final int ANCHOR_TYPE = 1;
    public static final int EDIT_TEXT_TYPE = 9;
    public static final int EMAIL_TYPE = 4;
    public static final int GEO_TYPE = 3;
    @Deprecated
    public static final int IMAGE_ANCHOR_TYPE = 6;
    public static final int IMAGE_TYPE = 5;
    public static final int PHONE_TYPE = 2;
    public static final int SRC_ANCHOR_TYPE = 7;
    public static final int SRC_IMAGE_ANCHOR_TYPE = 8;
    public static final int UNKNOWN_TYPE = 0;
    private IX5WebViewBase.HitTestResult mHitTestResultImpl;
    private android.webkit.WebView.HitTestResult mSysHitTestResult = null;
    
    public HitTestResult()
    {
      this.mHitTestResultImpl = null;
      this.mSysHitTestResult = null;
    }
    
    public HitTestResult(android.webkit.WebView.HitTestResult paramHitTestResult)
    {
      this.mHitTestResultImpl = null;
      this.mSysHitTestResult = paramHitTestResult;
    }
    
    public HitTestResult(IX5WebViewBase.HitTestResult paramHitTestResult)
    {
      this.mHitTestResultImpl = paramHitTestResult;
      this.mSysHitTestResult = null;
    }
    
    public String getExtra()
    {
      String str = "";
      if (this.mHitTestResultImpl != null) {
        str = this.mHitTestResultImpl.getExtra();
      }
      while (this.mSysHitTestResult == null) {
        return str;
      }
      return this.mSysHitTestResult.getExtra();
    }
    
    public int getType()
    {
      int i = 0;
      if (this.mHitTestResultImpl != null) {
        i = this.mHitTestResultImpl.getType();
      }
      while (this.mSysHitTestResult == null) {
        return i;
      }
      return this.mSysHitTestResult.getType();
    }
    
    public void setExtra(String paramString)
    {
      if (this.mHitTestResultImpl != null) {
        this.mHitTestResultImpl.setExtra(paramString);
      }
    }
    
    public void setType(int paramInt)
    {
      if (this.mHitTestResultImpl != null) {
        this.mHitTestResultImpl.setType(paramInt);
      }
    }
  }
  
  public static abstract interface PictureListener
  {
    public abstract void onNewPicture(WebView paramWebView, Picture paramPicture);
  }
  
  private class SystemWebView
    extends android.webkit.WebView
  {
    public SystemWebView(Context paramContext)
    {
      this(paramContext, null);
    }
    
    public SystemWebView(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      CookieSyncManager.createInstance(WebView.this.mContext).startSync();
      try
      {
        this$1 = Class.forName("android.webkit.WebViewWorker").getDeclaredMethod("getHandler", new Class[0]);
        WebView.this.setAccessible(true);
        ((Handler)WebView.this.invoke(null, new Object[0])).getLooper().getThread().setUncaughtExceptionHandler(new SQLiteUncaughtExceptionHandler());
        WebView.mSysWebviewCreated = true;
        return;
      }
      catch (Exception this$1) {}
    }
    
    public void computeScroll()
    {
      if (WebView.this.mWebViewCallbackClient != null)
      {
        WebView.this.mWebViewCallbackClient.computeScroll(this);
        return;
      }
      super.computeScroll();
    }
    
    protected void dispatchDraw(Canvas paramCanvas)
    {
      try
      {
        super.dispatchDraw(paramCanvas);
        if ((!WebView.mIsDayMode) && (WebView.mNightModePaint != null))
        {
          paramCanvas.save();
          paramCanvas.drawPaint(WebView.mNightModePaint);
          paramCanvas.restore();
        }
        return;
      }
      catch (Throwable paramCanvas)
      {
        paramCanvas.printStackTrace();
      }
    }
    
    public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
    {
      if (WebView.this.mWebViewCallbackClient != null) {
        return WebView.this.mWebViewCallbackClient.dispatchTouchEvent(paramMotionEvent, this);
      }
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    
    public android.webkit.WebSettings getSettings()
    {
      try
      {
        android.webkit.WebSettings localWebSettings = super.getSettings();
        return localWebSettings;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return null;
    }
    
    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
    {
      if (WebView.this.mWebViewCallbackClient != null) {
        return WebView.this.mWebViewCallbackClient.onInterceptTouchEvent(paramMotionEvent, this);
      }
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    
    @TargetApi(9)
    public void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
    {
      if (WebView.this.mWebViewCallbackClient != null) {
        WebView.this.mWebViewCallbackClient.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2, this);
      }
      while (Build.VERSION.SDK_INT < 9) {
        return;
      }
      super.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    }
    
    protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      if (WebView.this.mWebViewCallbackClient != null)
      {
        WebView.this.mWebViewCallbackClient.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, this);
        return;
      }
      super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
      WebView.this.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      if (!hasFocus()) {
        requestFocus();
      }
      if (WebView.this.mWebViewCallbackClient != null) {
        return WebView.this.mWebViewCallbackClient.onTouchEvent(paramMotionEvent, this);
      }
      try
      {
        boolean bool = super.onTouchEvent(paramMotionEvent);
        return bool;
      }
      catch (Exception paramMotionEvent)
      {
        paramMotionEvent.printStackTrace();
      }
      return false;
    }
    
    @TargetApi(9)
    public boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
    {
      if (WebView.this.mWebViewCallbackClient != null) {
        return WebView.this.mWebViewCallbackClient.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean, this);
      }
      if (Build.VERSION.SDK_INT >= 9) {
        return super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
      }
      return false;
    }
    
    public void super_computeScroll()
    {
      super.computeScroll();
    }
    
    public boolean super_dispatchTouchEvent(MotionEvent paramMotionEvent)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    
    public boolean super_onInterceptTouchEvent(MotionEvent paramMotionEvent)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    
    @TargetApi(9)
    public void super_onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
    {
      if (Build.VERSION.SDK_INT >= 9) {
        super.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
      }
    }
    
    public void super_onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    
    public boolean super_onTouchEvent(MotionEvent paramMotionEvent)
    {
      return super.onTouchEvent(paramMotionEvent);
    }
    
    @TargetApi(9)
    public boolean super_overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
    {
      if (Build.VERSION.SDK_INT >= 9) {
        return super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
      }
      return false;
    }
  }
  
  public class WebViewTransport
  {
    private WebView mWebview;
    
    public WebViewTransport() {}
    
    public WebView getWebView()
    {
      try
      {
        WebView localWebView = this.mWebview;
        return localWebView;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public void setWebView(WebView paramWebView)
    {
      try
      {
        this.mWebview = paramWebView;
        return;
      }
      finally
      {
        paramWebView = finally;
        throw paramWebView;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\smtt\sdk\WebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */