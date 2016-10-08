package com.tencent.mobileqq.webview.swift.component;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.widgets.XChooserActivity;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.app.UniformDownload;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.downloadnew.DownloadApi;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsDownloader;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.stat.DesUtils;
import com.tencent.smtt.sdk.stat.MttLoader;
import com.tencent.util.MqqWeakReferenceHandler;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import wiy;
import wiz;
import wja;
import wjb;
import wjc;
import wjd;
import wje;
import wjf;
import wjg;

public class SwiftBrowserTBSHandler
  extends SwiftBrowserComponentsProvider.SwiftBrowserComponent
  implements Handler.Callback
{
  public static final int a = 4;
  private static final long jdField_a_of_type_Long = 86400000L;
  private static final String jdField_a_of_type_JavaLangString = "utf-8";
  private static final int jdField_b_of_type_Int = 100;
  private static final String jdField_b_of_type_JavaLangString = "http://p.mb.qq.com/sdk";
  private static final int jdField_c_of_type_Int = 101;
  private static final String jdField_c_of_type_JavaLangString = "http://mqqad.html5.qq.com/adjs?p=";
  private static final int jdField_d_of_type_Int = 102;
  private static final String jdField_d_of_type_JavaLangString = "version_code_key";
  private static final int jdField_e_of_type_Int = 103;
  private static final String jdField_e_of_type_JavaLangString = "801097412";
  private static final int jdField_f_of_type_Int = 104;
  private static final String jdField_f_of_type_JavaLangString = "QQ浏览器";
  private static final int jdField_g_of_type_Int = 0;
  private static final String jdField_g_of_type_JavaLangString = "SwiftBrowserTBSHandler";
  private static final int jdField_h_of_type_Int = 1;
  private static final String jdField_h_of_type_JavaLangString = "qb_param_url";
  private static final int jdField_i_of_type_Int = 2;
  private static final String jdField_i_of_type_JavaLangString = "click_icon";
  private static final int jdField_j_of_type_Int = 3;
  private static final String jdField_j_of_type_JavaLangString = "update_time";
  private static final int jdField_k_of_type_Int = 5;
  private static final String jdField_k_of_type_JavaLangString = "icon_time";
  private static final int jdField_l_of_type_Int = 20000;
  private static final String jdField_l_of_type_JavaLangString = "icon_url";
  private static final int jdField_m_of_type_Int = 12;
  private static final String jdField_m_of_type_JavaLangString = "content_time";
  private static final String n = "content_memo";
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private final QQBrowserActivity jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity;
  private Boolean jdField_a_of_type_JavaLangBoolean;
  private final Object jdField_a_of_type_JavaLangObject;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private long jdField_b_of_type_Long;
  private String o;
  
  public SwiftBrowserTBSHandler(Activity paramActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
    if ((paramActivity instanceof QQBrowserActivity))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity = ((QQBrowserActivity)paramActivity);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity = null;
  }
  
  /* Error */
  private HttpURLConnection a(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 127	java/net/URL
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 130	java/net/URL:<init>	(Ljava/lang/String;)V
    //   8: invokevirtual 134	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   11: checkcast 136	java/net/HttpURLConnection
    //   14: astore_1
    //   15: aload_1
    //   16: ldc -118
    //   18: invokevirtual 141	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   21: aload_1
    //   22: iconst_1
    //   23: invokevirtual 145	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   26: aload_1
    //   27: iconst_1
    //   28: invokevirtual 148	java/net/HttpURLConnection:setDoInput	(Z)V
    //   31: aload_1
    //   32: iconst_0
    //   33: invokevirtual 151	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   36: aload_1
    //   37: sipush 20000
    //   40: invokevirtual 155	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   43: getstatic 160	android/os/Build$VERSION:SDK_INT	I
    //   46: bipush 13
    //   48: if_icmple +11 -> 59
    //   51: aload_1
    //   52: ldc -94
    //   54: ldc -92
    //   56: invokevirtual 168	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   59: aload_1
    //   60: ldc -86
    //   62: ldc -84
    //   64: invokevirtual 168	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   67: aload_2
    //   68: ifnull +28 -> 96
    //   71: aload_1
    //   72: ldc -82
    //   74: aload_2
    //   75: arraylength
    //   76: invokestatic 179	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   79: invokevirtual 168	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   82: aload_1
    //   83: invokevirtual 183	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   86: astore_3
    //   87: aload_3
    //   88: aload_2
    //   89: invokevirtual 189	java/io/OutputStream:write	([B)V
    //   92: aload_3
    //   93: invokevirtual 192	java/io/OutputStream:flush	()V
    //   96: aload_1
    //   97: invokevirtual 196	java/net/HttpURLConnection:getResponseCode	()I
    //   100: istore 4
    //   102: iload 4
    //   104: sipush 200
    //   107: if_icmpne +8 -> 115
    //   110: aload_1
    //   111: areturn
    //   112: astore_1
    //   113: aconst_null
    //   114: areturn
    //   115: aconst_null
    //   116: areturn
    //   117: astore_1
    //   118: aconst_null
    //   119: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	this	SwiftBrowserTBSHandler
    //   0	120	1	paramString	String
    //   0	120	2	paramArrayOfByte	byte[]
    //   86	7	3	localOutputStream	java.io.OutputStream
    //   100	8	4	i1	int
    // Exception table:
    //   from	to	target	type
    //   0	21	112	java/lang/Exception
    //   71	96	117	java/lang/Throwable
    //   96	102	117	java/lang/Throwable
  }
  
  private void a(String paramString, int paramInt)
  {
    if (paramInt < 12)
    {
      try
      {
        localHttpURLConnection = (HttpURLConnection)new URL(paramString).openConnection();
        localHttpURLConnection.setDoInput(true);
        localHttpURLConnection.setConnectTimeout(20000);
        localHttpURLConnection.setRequestMethod("GET");
        localHttpURLConnection.connect();
        i1 = localHttpURLConnection.getResponseCode();
        if ((i1 != 301) && (i1 != 302)) {
          break label135;
        }
        paramString = localHttpURLConnection.getHeaderFields().keySet().iterator();
        String str;
        do
        {
          if (!paramString.hasNext()) {
            break;
          }
          str = (String)paramString.next();
        } while (!"location".equalsIgnoreCase(str));
        paramString = localHttpURLConnection.getHeaderField(str);
      }
      catch (Throwable paramString)
      {
        HttpURLConnection localHttpURLConnection;
        int i1;
        label135:
        while (QLog.isColorLevel())
        {
          QLog.e("SwiftBrowserTBSHandler", 2, paramString.getMessage());
          return;
          paramString = null;
        }
      }
      if (paramString != null)
      {
        a(MsfSdkUtils.insertMtype("Web", paramString), paramInt + 1);
        return;
        if (i1 == 200)
        {
          this.b = localHttpURLConnection.getContentLength();
          this.o = localHttpURLConnection.getURL().toString();
        }
      }
      localHttpURLConnection.disconnect();
      return;
    }
  }
  
  public Object a(String paramString, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity == null)
    {
      paramString = null;
      return paramString;
    }
    Object localObject;
    if ("openBrowserList".equals(paramString))
    {
      paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramBundle.getString("url")));
      paramBundle = new Bundle();
      paramBundle.putString("EXTRA_PACKAGE_NAME", "com.tencent.mtt");
      paramBundle.putString("EXTRA_TITLE", "QQ浏览器");
      paramBundle.putString("EXTRA_DESC", "安全推荐");
      paramBundle.putInt("EXTRA_ICON_ID", 2130839507);
      paramBundle.putString("EXTRA_URL", "http://mdc.html5.qq.com/d/directdown.jsp?channel_id=10612");
      if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
      {
        this.jdField_a_of_type_AndroidContentBroadcastReceiver = new wjc(this);
        localObject = new IntentFilter("com.tencent.mobileqq.action.ACTION_QB_REPORT");
        this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject, "com.tencent.msg.permission.pushnotify", null);
      }
      XChooserActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, paramString, -1, "android.intent.action.VIEW", this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getString(2131365062), new Bundle[] { paramBundle });
    }
    for (;;)
    {
      return null;
      if ("addDownloadTask".equals(paramString))
      {
        if (paramBundle == null) {
          return null;
        }
        localObject = paramBundle.getString("task_name");
        paramString = paramBundle.getString("task_url");
        paramBundle = paramBundle.getString("appid");
        this.o = paramString;
        paramString = paramBundle;
        if (paramBundle == null) {
          break;
        }
        paramString = paramBundle;
        if (localObject == null) {
          break;
        }
        paramString = DownloadManager.a().a(paramBundle);
        if (paramString != null)
        {
          paramString = paramString.c;
          Bundle localBundle = new Bundle();
          localBundle.putString(DownloadConstants.a, paramBundle);
          localBundle.putString(DownloadConstants.i, paramString);
          localBundle.putInt(DownloadConstants.j, 2);
          localBundle.putString(DownloadConstants.k, (String)localObject);
          localBundle.putBoolean(DownloadConstants.q, false);
          localBundle.putBoolean(DownloadConstants.w, false);
          localBundle.putString(DownloadConstants.l, "_" + paramBundle);
          DownloadApi.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, localBundle, 0, null, 0);
          return paramBundle;
        }
        ThreadManager.a(new wjd(this, paramBundle, (String)localObject), 8, null, true);
        return paramBundle;
      }
      if ("cancelDownloadTask".equals(paramString))
      {
        paramString = paramBundle.getString("download_id");
        if (!DownloadApi.a(paramString)) {
          return Boolean.valueOf(false);
        }
        DownloadApi.a(paramString, "_" + paramString, true);
        return Boolean.valueOf(true);
      }
      if ("queryDownloadTask".equals(paramString))
      {
        paramString = paramBundle.getString("download_id");
        paramString = DownloadManager.a().a(paramString);
        if (paramString == null) {
          return Integer.valueOf(0);
        }
        switch (paramString.a())
        {
        case 5: 
        case 6: 
        case 7: 
        case 8: 
        case 9: 
        default: 
          return Integer.valueOf(0);
        case 10: 
          return Integer.valueOf(5);
        case 4: 
          return Integer.valueOf(3);
        case 2: 
          return Integer.valueOf(1);
        }
        return Integer.valueOf(2);
      }
      if ("installDownloadTask".equals(paramString))
      {
        paramString = paramBundle.getString("download_id");
        paramBundle = DownloadManager.a().a(paramString);
        if ((paramBundle == null) || (paramBundle.a() != 4)) {
          return Boolean.valueOf(false);
        }
        paramBundle = new Bundle();
        paramBundle.putString(DownloadConstants.a, paramString);
        paramBundle.putInt(DownloadConstants.j, 5);
        paramBundle.putBoolean(DownloadConstants.q, false);
        paramBundle.putBoolean(DownloadConstants.w, false);
        DownloadApi.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, paramBundle, 0, null, 0);
        return Boolean.valueOf(true);
      }
      if ("notifyQBiconShine".equals(paramString))
      {
        paramString = (SwiftBrowserUIStyleHandler)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a().a(2);
        if (paramString != null)
        {
          paramString.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.v = true;
          paramString.d();
          if (QLog.isColorLevel()) {
            QLog.d("SwiftBrowserTBSHandler", 2, "QQBrowser has related content.");
          }
        }
      }
    }
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
    } while (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity == null) {
      return;
    }
    if (this.jdField_a_of_type_MqqOsMqqHandler == null) {}
    Object localObject;
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_MqqOsMqqHandler == null) {
          this.jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this);
        }
        localObject = DownloadManager.a().a("801097412");
        if ((localObject == null) || (!NetworkUtil.i(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity))) {
          break;
        }
        this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
        this.o = ((DownloadInfo)localObject).c;
        if (paramBoolean)
        {
          paramString = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131369675);
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getApplicationContext(), 2, paramString, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getTitleBarHeight());
          this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(102));
          return;
        }
      }
      finally {}
      paramString = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131369671);
    }
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
    this.o = paramString;
    this.b = 0L;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.isFinishing())
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      ThreadManager.a(new wje(this), 8, null, true);
      paramString = new wjf(this);
      localObject = new wjg(this);
      if (!NetworkUtil.i(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity)) {
        break label357;
      }
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(102));
      if (!paramBoolean) {
        break label340;
      }
    }
    label340:
    for (paramString = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131369675);; paramString = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131369671))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getApplicationContext(), 2, paramString, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getTitleBarHeight());
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      break;
    }
    label357:
    if (paramBoolean)
    {
      Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130840395);
      this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, localDrawable, this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131369676), " ", this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131367976), this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131369668), paramString, (View.OnClickListener)localObject);
      this.jdField_a_of_type_AndroidAppDialog.show();
      paramString = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getSharedPreferences("qb_info", 0);
      if (paramString == null) {
        break label578;
      }
    }
    label578:
    for (paramString = paramString.getString("icon_url", null);; paramString = null)
    {
      localObject = new wiy(this);
      if (paramString != null)
      {
        paramString = URLDrawable.getDrawable(paramString);
        paramString.setURLDrawableListener((URLDrawable.URLDrawableListener)localObject);
        this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(103, paramString));
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      return;
      this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131369670), 2131367976, 2131369668, paramString, (View.OnClickListener)localObject);
      this.jdField_a_of_type_AndroidAppDialog.show();
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      return;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity == null) {
      return;
    }
    Object localObject1 = WebAccelerateHelper.getInstance().getTBSDpcParam();
    if ((localObject1 != null) && (((String)localObject1).charAt(0) == '1')) {}
    for (int i1 = 1;; i1 = 0)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface != null) && (i1 != 0))
      {
        localObject1 = TimeZone.getDefault().getID();
        if (("CN".equals(Locale.getDefault().getCountry())) && (("Asia/Shanghai".equals(localObject1)) || ("Asia/Chongqing".equals(localObject1)) || ("Asia/Beijing".equals(localObject1)) || ("Asia/Hong_Kong".equals(localObject1)))) {
          if (TbsDownloader.needDownload(BaseApplication.getContext(), false))
          {
            if (QLog.isColorLevel()) {
              QLog.d("TBS_update", 2, "tbs need download");
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.a();
            i1 = 1;
            label148:
            if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext == null) {
              break label428;
            }
          }
        }
      }
      label231:
      label414:
      label421:
      label428:
      for (localObject1 = (SwiftBrowserStatistics)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a().a(-2);; localObject1 = null)
      {
        if (((localObject1 == null) || (!((SwiftBrowserStatistics)localObject1).d)) && (!QLog.isColorLevel())) {
          break label431;
        }
        int i2 = QbSdk.getTbsVersion(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getApplicationContext());
        Object localObject2;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder().append("tbs current webview:");
          if (i2 == 0)
          {
            localObject2 = "sys";
            QLog.d("TBS_update", 2, (String)localObject2);
          }
        }
        else
        {
          if ((localObject1 == null) || (!((SwiftBrowserStatistics)localObject1).d)) {
            break;
          }
          localObject2 = new StringBuilder().append("tbs_cover_");
          if (i1 == 0) {
            break label421;
          }
          if (i2 <= 0) {
            break label414;
          }
          localObject1 = "tbs";
        }
        for (;;)
        {
          ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", (String)localObject1, 0, 1, i2, "", "", "", "");
          return;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("TBS_update", 2, "tbs no need download");
          break;
          if (QLog.isColorLevel()) {
            QLog.d("TBS_update", 2, "tbs loc/tz not match");
          }
          i1 = 0;
          break label148;
          if (QLog.isColorLevel()) {
            QLog.d("TBS_update", 2, "tbs update disabled");
          }
          i1 = 0;
          break label148;
          localObject2 = "x5_" + i2;
          break label231;
          localObject1 = "sys";
          continue;
          localObject1 = "dis";
        }
      }
      label431:
      break;
    }
  }
  
  public void c()
  {
    long l1 = 0L;
    boolean bool1 = true;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.findViewById(2131299840));
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getSharedPreferences("qb_info", 0);
    boolean bool2 = MttLoader.isBrowserInstalled(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity);
    for (;;)
    {
      long l2;
      try
      {
        i1 = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getPackageManager().getPackageInfo(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getPackageName(), 0).versionCode;
        if (localObject1 == null) {
          break label372;
        }
        bool1 = ((SharedPreferences)localObject1).getBoolean("click_icon", false);
        l1 = ((SharedPreferences)localObject1).getLong("update_time", 0L);
        int i2 = ((SharedPreferences)localObject1).getInt("version_code_key", 0);
        SharedPreferences.Editor localEditor = ((SharedPreferences)localObject1).edit();
        localEditor.putInt("version_code_key", i1);
        localEditor.commit();
        if (i2 >= i1) {
          break label367;
        }
        i1 = 1;
        if ((i1 == 0) && ((bool2) || (bool1)))
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          return;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        i1 = 0;
        continue;
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        l2 = System.currentTimeMillis();
      }
      if (l2 - l1 <= 86400000L) {
        break;
      }
      Object localObject3 = ((SharedPreferences)localObject1).edit();
      ((SharedPreferences.Editor)localObject3).putLong("update_time", l2);
      ((SharedPreferences.Editor)localObject3).commit();
      localObject3 = ((SharedPreferences)localObject1).getString("icon_time", null);
      localObject1 = ((SharedPreferences)localObject1).getString("content_time", null);
      localObject3 = "paK=" + this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getApplicationContext().getPackageName() + "&itime=" + (String)localObject3 + "&ctime=" + (String)localObject1;
      try
      {
        localObject1 = "24Xdf8j6".getBytes("utf-8");
        if (localObject1 == null) {
          break;
        }
        try
        {
          localObject1 = DesUtils.DesEncrypt((byte[])localObject1, ((String)localObject3).getBytes("utf-8"), 1);
          ThreadManager.a(new wiz(this, "http://mqqad.html5.qq.com/adjs?p=" + URLEncoder.encode(Base64Util.encodeToString((byte[])localObject1, 2))), 1, null, true);
          return;
        }
        catch (Throwable localThrowable)
        {
          return;
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          Object localObject2 = null;
        }
      }
      label367:
      int i1 = 0;
      continue;
      label372:
      i1 = 0;
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity == null) {}
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      } while (MttLoader.isBrowserInstalled(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity));
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getSharedPreferences("qb_info", 0);
    } while ((localObject == null) || (((SharedPreferences)localObject).getBoolean("click_icon", false)));
    Object localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putBoolean("click_icon", true);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity == null) {
      return;
    }
    ThreadManager.a(new wja(this), 5, null, true);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        for (;;)
        {
          return true;
          paramMessage = (String)paramMessage.obj;
          try
          {
            paramMessage = new JSONObject(paramMessage);
            localObject1 = paramMessage.getJSONObject("icon");
            Object localObject2 = paramMessage.getJSONObject("content");
            paramMessage = ((JSONObject)localObject1).getString("timestamp");
            localObject1 = ((JSONObject)localObject1).getString("url");
            String str = ((JSONObject)localObject2).getString("timestamp");
            localObject2 = ((JSONObject)localObject2).getString("memo");
            Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getSharedPreferences("qb_info", 0);
            if (localObject3 != null)
            {
              localObject3 = ((SharedPreferences)localObject3).edit();
              ((SharedPreferences.Editor)localObject3).putString("icon_time", paramMessage);
              ((SharedPreferences.Editor)localObject3).putString("icon_url", (String)localObject1);
              ((SharedPreferences.Editor)localObject3).putString("content_time", str);
              ((SharedPreferences.Editor)localObject3).putString("content_memo", (String)localObject2);
              ((SharedPreferences.Editor)localObject3).commit();
              return true;
            }
          }
          catch (Exception paramMessage)
          {
            return true;
          }
        }
        if ((!this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.isFinishing()) && (!this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.i))
        {
          paramMessage = (Bundle)paramMessage.obj;
          if (paramMessage != null)
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getSharedPreferences("qb_info", 0);
            if (localObject1 != null)
            {
              paramMessage.putString("param_content_memo", ((SharedPreferences)localObject1).getString("content_memo", null));
              paramMessage.putString("param_icon_path", ((SharedPreferences)localObject1).getString("icon_url", null));
            }
            paramMessage.putString("param_user_agent", this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.jdField_a_of_type_ComTencentBizUiTouchWebView.getSettings().getUserAgentString());
            paramMessage.putString("param_refer_url", this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl());
            localObject1 = paramMessage.getString("qb_param_url");
            if ((localObject1 != null) && (((String)localObject1).length() != 0))
            {
              paramMessage.remove("qb_param_url");
              paramMessage.putBoolean("param_isqbdownload", true);
              UniformDownload.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, (String)localObject1, paramMessage);
            }
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        return true;
        ThreadManager.a(new wjb(this), 8, null, true);
        return true;
        paramMessage = (Drawable)paramMessage.obj;
      } while ((this.jdField_a_of_type_AndroidAppDialog == null) || (!this.jdField_a_of_type_AndroidAppDialog.isShowing()) || (paramMessage == null));
      Object localObject1 = (ImageView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131300995);
      ((ImageView)localObject1).setImageDrawable(null);
      ((ImageView)localObject1).setImageDrawable(paramMessage);
      return true;
      paramMessage = (String)paramMessage.obj;
    } while ((this.jdField_a_of_type_AndroidAppDialog == null) || (!this.jdField_a_of_type_AndroidAppDialog.isShowing()) || (paramMessage == null));
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131300998)).setText(paramMessage);
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\webview\swift\component\SwiftBrowserTBSHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */