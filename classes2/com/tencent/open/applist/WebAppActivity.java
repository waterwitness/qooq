package com.tencent.open.applist;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.WidgetUtil;
import com.tencent.open.adapter.AppBaseActivity;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.appcommon.Common;
import com.tencent.open.appcommon.js.InterfaceRegisterUtils;
import com.tencent.open.appcommon.js.OpenJsBridge;
import com.tencent.open.base.FileUtils;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.http.HttpBaseUtil;
import com.tencent.open.base.http.HttpBaseUtil.HttpResponseBean;
import com.tencent.open.base.http.HttpBaseUtil.NetworkUnavailableException;
import com.tencent.open.base.http.HttpCgiAsyncTask;
import com.tencent.open.base.img.ImageCache;
import com.tencent.open.business.base.OpenConfig;
import com.tencent.open.business.cgireport.ReportManager;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.smtt.sdk.DownloadListener;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebSettings.PluginState;
import com.tencent.smtt.sdk.WebSettings.RenderPriority;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.CookieStore;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.json.JSONException;
import org.json.JSONObject;
import wtp;
import wtq;
import wtr;
import wts;
import wtt;
import wtu;
import wtv;
import wtw;

public class WebAppActivity
  extends AppBaseActivity
{
  public static Map a;
  protected static final int b = 2;
  protected static final int c = 3;
  protected static final String c = "WebAppActivity";
  protected static final int d = 4;
  protected static final String d = "http://mapp.qzone.qq.com/cgi-bin/mapp/mapp_info";
  protected static final int e = 5;
  protected static final int f = 6;
  protected static final int g = 7;
  protected static final int h = 8;
  protected static final int i = 0;
  protected static final int j = -100;
  protected static final int k = -70000002;
  protected static final int l = -70000003;
  protected static final int m = -70000004;
  public ProgressDialog a;
  protected final View.OnClickListener a;
  public ImageView a;
  public RelativeLayout a;
  public OpenJsBridge a;
  public WebAppActivity.HttpGetAppInfoAsyncTask a;
  protected final DownloadListener a;
  protected final WebChromeClient a;
  public WebView a;
  protected final WebViewClient a;
  protected List a;
  protected boolean a;
  protected Handler b;
  public ImageView b;
  public ProgressBar b;
  protected boolean b;
  public View c;
  public ImageView c;
  public ImageView d;
  protected final String e = "qq.com";
  public String f;
  protected String g;
  protected String h;
  public String i;
  protected String j;
  protected String k;
  protected int n;
  public int o;
  protected int p;
  protected int q;
  protected int r;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaUtilMap = new HashMap();
    jdField_a_of_type_JavaUtilMap.put("Q-UA", CommonDataAdapter.a().e());
  }
  
  public WebAppActivity()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentSmttSdkWebViewClient = new wtp(this);
    this.jdField_a_of_type_ComTencentSmttSdkWebChromeClient = new wtq(this);
    this.jdField_a_of_type_ComTencentSmttSdkDownloadListener = new wtr(this);
    this.jdField_b_of_type_AndroidOsHandler = new wts(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new wtv(this);
  }
  
  /* Error */
  public android.graphics.Bitmap a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore 4
    //   5: iconst_0
    //   6: istore 7
    //   8: aload_0
    //   9: getfield 133	com/tencent/open/applist/WebAppActivity:i	Ljava/lang/String;
    //   12: invokestatic 139	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   15: ifeq +5 -> 20
    //   18: aconst_null
    //   19: areturn
    //   20: ldc 14
    //   22: new 141	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   29: ldc -112
    //   31: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: aload_0
    //   35: getfield 133	com/tencent/open/applist/WebAppActivity:i	Ljava/lang/String;
    //   38: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokestatic 156	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   47: new 158	org/apache/http/impl/client/DefaultHttpClient
    //   50: dup
    //   51: invokespecial 159	org/apache/http/impl/client/DefaultHttpClient:<init>	()V
    //   54: astore_2
    //   55: aload_2
    //   56: new 161	org/apache/http/client/methods/HttpGet
    //   59: dup
    //   60: aload_0
    //   61: getfield 133	com/tencent/open/applist/WebAppActivity:i	Ljava/lang/String;
    //   64: invokespecial 164	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   67: invokeinterface 170 2 0
    //   72: invokeinterface 176 1 0
    //   77: astore_2
    //   78: aload_2
    //   79: ifnull +229 -> 308
    //   82: aload_2
    //   83: invokeinterface 182 1 0
    //   88: astore_1
    //   89: aload_1
    //   90: astore_2
    //   91: new 184	java/io/ByteArrayOutputStream
    //   94: dup
    //   95: invokespecial 185	java/io/ByteArrayOutputStream:<init>	()V
    //   98: astore_3
    //   99: aload_1
    //   100: astore_2
    //   101: sipush 2048
    //   104: newarray <illegal type>
    //   106: astore 5
    //   108: aload_1
    //   109: astore_2
    //   110: aload_1
    //   111: aload 5
    //   113: invokevirtual 191	java/io/InputStream:read	([B)I
    //   116: istore 6
    //   118: iload 6
    //   120: iconst_m1
    //   121: if_icmpeq +74 -> 195
    //   124: aload_1
    //   125: astore_2
    //   126: aload_3
    //   127: aload 5
    //   129: iconst_0
    //   130: iload 6
    //   132: invokevirtual 195	java/io/ByteArrayOutputStream:write	([BII)V
    //   135: goto -27 -> 108
    //   138: astore_3
    //   139: aload_1
    //   140: astore_2
    //   141: aload_3
    //   142: invokevirtual 198	java/lang/Exception:printStackTrace	()V
    //   145: aload 4
    //   147: astore_2
    //   148: aload_1
    //   149: ifnull +10 -> 159
    //   152: aload_1
    //   153: invokevirtual 201	java/io/InputStream:close	()V
    //   156: aload 4
    //   158: astore_2
    //   159: new 141	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   166: ldc -53
    //   168: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: astore_1
    //   172: aload_2
    //   173: ifnull +6 -> 179
    //   176: iconst_1
    //   177: istore 7
    //   179: ldc 14
    //   181: aload_1
    //   182: iload 7
    //   184: invokevirtual 206	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   187: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokestatic 156	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   193: aload_2
    //   194: areturn
    //   195: aload_1
    //   196: astore_2
    //   197: aload_3
    //   198: invokevirtual 210	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   201: iconst_0
    //   202: aload_3
    //   203: invokevirtual 214	java/io/ByteArrayOutputStream:size	()I
    //   206: invokestatic 220	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   209: astore_3
    //   210: aload_3
    //   211: astore_2
    //   212: aload_1
    //   213: astore_3
    //   214: aload_2
    //   215: astore_1
    //   216: aload_1
    //   217: astore_2
    //   218: aload_3
    //   219: ifnull -60 -> 159
    //   222: aload_3
    //   223: invokevirtual 201	java/io/InputStream:close	()V
    //   226: aload_1
    //   227: astore_2
    //   228: goto -69 -> 159
    //   231: astore_2
    //   232: aload_1
    //   233: astore_2
    //   234: goto -75 -> 159
    //   237: astore_3
    //   238: aconst_null
    //   239: astore_1
    //   240: aload_1
    //   241: astore_2
    //   242: aload_3
    //   243: invokevirtual 221	java/lang/OutOfMemoryError:printStackTrace	()V
    //   246: aload 4
    //   248: astore_2
    //   249: aload_1
    //   250: ifnull -91 -> 159
    //   253: aload_1
    //   254: invokevirtual 201	java/io/InputStream:close	()V
    //   257: aload 4
    //   259: astore_2
    //   260: goto -101 -> 159
    //   263: astore_1
    //   264: aload 4
    //   266: astore_2
    //   267: goto -108 -> 159
    //   270: astore_1
    //   271: aconst_null
    //   272: astore_2
    //   273: aload_2
    //   274: ifnull +7 -> 281
    //   277: aload_2
    //   278: invokevirtual 201	java/io/InputStream:close	()V
    //   281: aload_1
    //   282: athrow
    //   283: astore_1
    //   284: aload 4
    //   286: astore_2
    //   287: goto -128 -> 159
    //   290: astore_2
    //   291: goto -10 -> 281
    //   294: astore_1
    //   295: goto -22 -> 273
    //   298: astore_3
    //   299: goto -59 -> 240
    //   302: astore_3
    //   303: aconst_null
    //   304: astore_1
    //   305: goto -166 -> 139
    //   308: aconst_null
    //   309: astore_3
    //   310: goto -94 -> 216
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	313	0	this	WebAppActivity
    //   1	253	1	localObject1	Object
    //   263	1	1	localIOException1	IOException
    //   270	12	1	localObject2	Object
    //   283	1	1	localIOException2	IOException
    //   294	1	1	localObject3	Object
    //   304	1	1	localObject4	Object
    //   54	174	2	localObject5	Object
    //   231	1	2	localIOException3	IOException
    //   233	54	2	localObject6	Object
    //   290	1	2	localIOException4	IOException
    //   98	29	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   138	65	3	localException1	Exception
    //   209	14	3	localObject7	Object
    //   237	6	3	localOutOfMemoryError1	OutOfMemoryError
    //   298	1	3	localOutOfMemoryError2	OutOfMemoryError
    //   302	1	3	localException2	Exception
    //   309	1	3	localObject8	Object
    //   3	282	4	localObject9	Object
    //   106	22	5	arrayOfByte	byte[]
    //   116	15	6	i1	int
    //   6	177	7	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   91	99	138	java/lang/Exception
    //   101	108	138	java/lang/Exception
    //   110	118	138	java/lang/Exception
    //   126	135	138	java/lang/Exception
    //   197	210	138	java/lang/Exception
    //   222	226	231	java/io/IOException
    //   55	78	237	java/lang/OutOfMemoryError
    //   82	89	237	java/lang/OutOfMemoryError
    //   253	257	263	java/io/IOException
    //   55	78	270	finally
    //   82	89	270	finally
    //   152	156	283	java/io/IOException
    //   277	281	290	java/io/IOException
    //   91	99	294	finally
    //   101	108	294	finally
    //   110	118	294	finally
    //   126	135	294	finally
    //   141	145	294	finally
    //   197	210	294	finally
    //   242	246	294	finally
    //   91	99	298	java/lang/OutOfMemoryError
    //   101	108	298	java/lang/OutOfMemoryError
    //   110	118	298	java/lang/OutOfMemoryError
    //   126	135	298	java/lang/OutOfMemoryError
    //   197	210	298	java/lang/OutOfMemoryError
    //   55	78	302	java/lang/Exception
    //   82	89	302	java/lang/Exception
  }
  
  public Bundle a()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", this.n);
    localBundle.putInt("showQuickBar", this.o);
    localBundle.putInt("showDialog", this.p);
    localBundle.putInt("screenOrientation", this.q);
    localBundle.putInt("fullScreen", this.r);
    localBundle.putString("url", this.f);
    localBundle.putString("appName", this.h);
    localBundle.putString("appIconUrl", this.i);
    localBundle.putString("appId", this.g);
    localBundle.putString("args", this.j);
    localBundle.putBoolean("fromShortcut", true);
    return localBundle;
  }
  
  public String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = Common.f() + ImageCache.b + "app" + File.separator + FileUtils.a(paramString);
    if (new File(paramString).exists())
    {
      LogUtility.c("WebAppActivity", "imageIsExist = " + paramString);
      return paramString;
    }
    LogUtility.c("WebAppActivity", "imageIsExist != " + paramString);
    return null;
  }
  
  protected HashMap a(String paramString, Bundle paramBundle)
  {
    LogUtility.c("WebAppActivity", "enter getCookie ");
    HashMap localHashMap = new HashMap();
    int i1 = 0;
    int i2 = 0;
    long l1 = SystemClock.elapsedRealtime();
    int i4 = OpenConfig.a(CommonDataAdapter.a().a(), null).a("Common_HttpRetryCount");
    if (i4 == 0) {
      i4 = 3;
    }
    for (;;)
    {
      int i3 = 0;
      int i5 = i3 + 1;
      Object localObject1 = new BasicHttpContext();
      Object localObject2 = new BasicCookieStore();
      ((HttpContext)localObject1).setAttribute("http.cookie-store", localObject2);
      try
      {
        localObject1 = HttpBaseUtil.a(paramString, "GET", paramBundle, (HttpContext)localObject1);
        localObject3 = ((HttpBaseUtil.HttpResponseBean)localObject1).jdField_a_of_type_OrgApacheHttpHttpResponse;
        if (((HttpResponse)localObject3).getStatusLine().getStatusCode() != 200) {
          break label382;
        }
        localObject2 = ((CookieStore)localObject2).getCookies();
        if (((List)localObject2).isEmpty()) {
          break label319;
        }
        i3 = ((List)localObject2).size();
        while (i3 > 0)
        {
          LogUtility.c("WebAppActivity", ((Cookie)((List)localObject2).get(i3 - 1)).toString());
          i3 -= 1;
        }
        a((List)localObject2);
      }
      catch (ConnectTimeoutException localConnectTimeoutException)
      {
        try
        {
          Object localObject3;
          i3 = ((JSONObject)localObject3).getInt("ret");
          i2 = ((HttpBaseUtil.HttpResponseBean)localObject1).jdField_a_of_type_Int;
          LogUtility.c("WebAppActivity", "resutl >>> " + (String)localObject2);
          for (;;)
          {
            ReportManager.a().a(paramString, l1, i2, i1, i3, CommonDataAdapter.a().a(), "1000002", null);
            return localHashMap;
            LogUtility.c("WebAppActivity", "cookies.isEmpty() ");
            break;
            localConnectTimeoutException = localConnectTimeoutException;
            localConnectTimeoutException.printStackTrace();
            localHashMap.put("ResultType", Integer.valueOf(0));
            i1 = -7;
            if (i5 < i4) {
              break label628;
            }
            i3 = i1;
            i1 = 0;
            i2 = 0;
          }
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            i3 = -4;
          }
        }
        LogUtility.c("WebAppActivity", "response code >>> " + localJSONException.getStatusLine().getStatusCode());
        localHashMap.put("ResultType", Integer.valueOf(0));
        localJSONException.getStatusLine().getStatusCode();
        return localHashMap;
      }
      catch (SocketTimeoutException localSocketTimeoutException)
      {
        for (;;)
        {
          localSocketTimeoutException.printStackTrace();
          localHashMap.put("ResultType", Integer.valueOf(0));
          localHashMap.put("ResultValue", localSocketTimeoutException);
          i1 = -8;
        }
      }
      catch (HttpBaseUtil.NetworkUnavailableException paramString)
      {
        paramString.printStackTrace();
        localHashMap.put("ResultType", Integer.valueOf(0));
        localHashMap.put("ResultValue", paramString);
        return localHashMap;
      }
      catch (JSONException paramBundle)
      {
        for (;;)
        {
          paramBundle.printStackTrace();
          localHashMap.put("ResultType", Integer.valueOf(0));
          localHashMap.put("ResultValue", paramBundle);
          i3 = -4;
          i1 = 0;
          i2 = 0;
        }
      }
      catch (IOException paramBundle)
      {
        for (;;)
        {
          paramBundle.printStackTrace();
          localHashMap.put("ResultType", Integer.valueOf(0));
          localHashMap.put("ResultValue", paramBundle);
          i3 = HttpCgiAsyncTask.a(paramBundle);
          i1 = 0;
          i2 = 0;
        }
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          paramBundle.printStackTrace();
          localHashMap.put("ResultType", Integer.valueOf(0));
          localHashMap.put("ResultValue", paramBundle);
          i3 = -6;
          i1 = 0;
          i2 = 0;
        }
        i6 = 0;
        i3 = i5;
        i2 = i1;
        i1 = i6;
      }
      localObject2 = HttpBaseUtil.a((HttpResponse)localObject3);
      if (localObject2 != null)
      {
        i1 = ((String)localObject2).length();
        localObject3 = HttpBaseUtil.a((String)localObject2);
        localHashMap.put("ResultType", Integer.valueOf(1));
        localHashMap.put("ResultValue", localObject3);
      }
      for (;;)
      {
        label319:
        label382:
        label628:
        int i6;
        break;
        i3 = i2;
      }
    }
  }
  
  protected void a(Intent paramIntent)
  {
    paramIntent = paramIntent.getExtras();
    if (paramIntent == null)
    {
      LogUtility.e("WebAppActivity", "getParams extras is null");
      finish();
      return;
    }
    paramIntent.putBoolean("IsBack", true);
    this.f = paramIntent.getString("url");
    this.n = paramIntent.getInt("type", 1);
    this.o = paramIntent.getInt("showQuickBar", 1);
    this.p = paramIntent.getInt("showDialog", 0);
    this.q = paramIntent.getInt("screenOrientation", 0);
    this.r = paramIntent.getInt("fullScreen", 0);
    if (this.n == 1)
    {
      this.h = paramIntent.getString("appName");
      this.i = paramIntent.getString("appIconUrl");
      this.g = paramIntent.getString("appId");
      this.j = paramIntent.getString("args");
      this.jdField_a_of_type_Boolean = paramIntent.getBoolean("fromShortcut", false);
      return;
    }
    this.h = paramIntent.getString("appName");
    this.i = paramIntent.getString("appIconUrl");
  }
  
  public void a(String paramString)
  {
    Intent localIntent = new Intent("com.android.launcher.action.UNINSTALL_SHORTCUT");
    localIntent.putExtra("android.intent.extra.shortcut.NAME", paramString);
    localIntent.putExtra("android.intent.extra.shortcut.INTENT", new Intent("com.tencent.open.startwebapp"));
    sendBroadcast(localIntent);
  }
  
  protected void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    new Handler().post(new wtw(this, paramString1, paramString2, paramBoolean));
  }
  
  protected void a(List paramList)
  {
    try
    {
      CookieSyncManager.createInstance(this);
      CookieManager localCookieManager = CookieManager.getInstance();
      localCookieManager.setAcceptCookie(true);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (Cookie)paramList.next();
        localObject = ((Cookie)localObject).getName() + "=" + ((Cookie)localObject).getValue() + "; domain=" + ((Cookie)localObject).getDomain();
        localCookieManager.setCookie("qq.com", (String)localObject);
        LogUtility.c("WebAppActivity", "setCookie >>> " + (String)localObject);
      }
      CookieSyncManager.getInstance().sync();
    }
    finally {}
    LogUtility.c("WebAppActivity", "synCookies >>> end");
  }
  
  public boolean a()
  {
    if (Build.VERSION.SDK_INT < 8) {}
    for (Object localObject = "content://com.android.launcher.settings/favorites?notify=true";; localObject = "content://com.android.launcher2.settings/favorites?notify=true")
    {
      localObject = Uri.parse((String)localObject);
      localObject = getContentResolver().query((Uri)localObject, null, "title=?", new String[] { this.h }, null);
      if (localObject == null) {
        break;
      }
      ((Cursor)localObject).close();
      return true;
    }
    return false;
  }
  
  protected boolean a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    do
    {
      do
      {
        return false;
      } while (!this.jdField_a_of_type_Boolean);
      if (this.o != paramJSONObject.optInt("quickbar"))
      {
        LogUtility.c("WebAppActivity", "replaceShortcut >>> " + this.o + " | " + paramJSONObject.optInt("quickbar"));
        return true;
      }
      if (this.p != paramJSONObject.optInt("isGenIcon"))
      {
        LogUtility.c("WebAppActivity", "replaceShortcut >>> " + this.p + " | " + paramJSONObject.optInt("isGenIcon"));
        return true;
      }
      if (this.q != paramJSONObject.optInt("orientation"))
      {
        LogUtility.c("WebAppActivity", "replaceShortcut >>> " + this.q + " | " + paramJSONObject.optInt("orientation"));
        return true;
      }
    } while (this.h.equals(paramJSONObject.optString("name")));
    LogUtility.c("WebAppActivity", "replaceShortcut >>> " + this.h + " | " + paramJSONObject.optString("name"));
    return true;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_ComTencentSmttSdkWebView != null) && (!this.jdField_a_of_type_ComTencentSmttSdkWebView.hasFocus()))
    {
      this.jdField_a_of_type_ComTencentSmttSdkWebView.requestFocus();
      this.jdField_a_of_type_ComTencentSmttSdkWebView.requestFocusFromTouch();
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    LogUtility.c("WebAppActivity", "onCreate");
    a();
    paramBundle = getIntent();
    if (paramBundle != null)
    {
      a(paramBundle);
      g();
      h();
      i();
      if (this.n != 0) {
        break label286;
      }
      if (this.f.indexOf("?") != -1) {
        break label214;
      }
      this.f += "?";
    }
    for (;;)
    {
      LogUtility.b("Jie", "webApp sid=" + CommonDataAdapter.a().a());
      try
      {
        this.f = (this.f + "sid=" + URLEncoder.encode(CommonDataAdapter.a().a(), "UTF-8") + "&uin=" + CommonDataAdapter.a().a());
        if (Build.VERSION.SDK_INT > 7)
        {
          this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl(this.f, jdField_a_of_type_JavaUtilMap);
          return true;
          LogUtility.c("WebAppActivity", "onCreate 0");
          return true;
          label214:
          if (this.f.endsWith("&")) {
            continue;
          }
          this.f += "&";
        }
      }
      catch (UnsupportedEncodingException paramBundle)
      {
        for (;;)
        {
          paramBundle.printStackTrace();
        }
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          paramBundle.printStackTrace();
        }
        this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl(this.f);
        return true;
      }
    }
    label286:
    this.jdField_a_of_type_AndroidAppProgressDialog.setMessage(getResources().getString(2131363007));
    this.jdField_a_of_type_AndroidAppProgressDialog.show();
    paramBundle = this.jdField_b_of_type_AndroidOsHandler.obtainMessage();
    if (TextUtils.isEmpty(CommonDataAdapter.a().a())) {}
    for (paramBundle.what = 3;; paramBundle.what = 2)
    {
      this.jdField_b_of_type_AndroidOsHandler.sendMessage(paramBundle);
      return true;
    }
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_AndroidAppProgressDialog.isShowing()) {
      this.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
    }
    if (this.jdField_b_of_type_AndroidOsHandler != null) {
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    if (this.jdField_a_of_type_ComTencentOpenAppcommonJsOpenJsBridge != null)
    {
      this.jdField_a_of_type_ComTencentOpenAppcommonJsOpenJsBridge.a(null);
      this.jdField_a_of_type_ComTencentOpenAppcommonJsOpenJsBridge = null;
    }
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    if (this.jdField_a_of_type_ComTencentSmttSdkWebView != null)
    {
      this.jdField_a_of_type_ComTencentSmttSdkWebView.setDownloadListener(null);
      this.jdField_a_of_type_ComTencentSmttSdkWebView.destroy();
      this.jdField_a_of_type_ComTencentSmttSdkWebView = null;
    }
    super.doOnDestroy();
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {}
    try
    {
      if (this.jdField_a_of_type_ComTencentSmttSdkWebView != null)
      {
        if (this.jdField_a_of_type_ComTencentSmttSdkWebView.canGoBack())
        {
          this.jdField_a_of_type_ComTencentSmttSdkWebView.goBack();
          return false;
        }
        if (this.p == 1) {
          break label63;
        }
        finish();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        LogUtility.c("WebAppActivity", "onKeyDown", localException);
      }
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
    label63:
    return false;
  }
  
  protected void doOnStop()
  {
    if (Build.VERSION.SDK_INT < 16) {
      WebView.disablePlatformNotifications();
    }
    super.doOnStop();
  }
  
  public void f()
  {
    a(new wtt(this), 2000L);
  }
  
  public void g()
  {
    if (this.q == 1) {
      setRequestedOrientation(0);
    }
    for (;;)
    {
      if (this.r == 1) {
        getWindow().setFlags(1024, 1024);
      }
      return;
      if (this.q == 2) {
        setRequestedOrientation(1);
      }
    }
  }
  
  protected void h()
  {
    setContentView(2130903502);
    removeWebViewLayerType();
    this.jdField_a_of_type_AndroidAppProgressDialog = new ProgressDialog(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131298839));
    if (this.o == 0)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_c_of_type_AndroidViewView = findViewById(2131298841);
      if (this.o != 0) {
        break label181;
      }
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
    for (;;)
    {
      Object localObject = ((ConnectivityManager)getSystemService("connectivity")).getActiveNetworkInfo();
      if ((localObject == null) || (((NetworkInfo)localObject).getState() == NetworkInfo.State.DISCONNECTED) || (((NetworkInfo)localObject).getState() == NetworkInfo.State.DISCONNECTING))
      {
        localObject = this.jdField_b_of_type_AndroidOsHandler.obtainMessage();
        ((Message)localObject).what = 8;
        this.jdField_b_of_type_AndroidOsHandler.sendMessage((Message)localObject);
      }
      return;
      this.jdField_b_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131298840));
      this.jdField_b_of_type_AndroidWidgetProgressBar.setProgressDrawable(WidgetUtil.a(getResources().getDrawable(2130838953), false, null));
      break;
      label181:
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131298843));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297425));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_b_of_type_AndroidWidgetImageView.setEnabled(false);
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297448));
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.d = ((ImageView)findViewById(2131298842));
      this.d.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
  }
  
  protected void i()
  {
    this.jdField_a_of_type_ComTencentSmttSdkWebView = ((WebView)findViewById(2131296688));
    this.jdField_a_of_type_ComTencentSmttSdkWebView.setWebViewClient(this.jdField_a_of_type_ComTencentSmttSdkWebViewClient);
    this.jdField_a_of_type_ComTencentSmttSdkWebView.setWebChromeClient(this.jdField_a_of_type_ComTencentSmttSdkWebChromeClient);
    this.jdField_a_of_type_ComTencentSmttSdkWebView.setDownloadListener(this.jdField_a_of_type_ComTencentSmttSdkDownloadListener);
    this.jdField_a_of_type_ComTencentSmttSdkWebView.setScrollBarStyle(0);
    this.jdField_a_of_type_ComTencentSmttSdkWebView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
    this.jdField_a_of_type_ComTencentSmttSdkWebView.setOnLongClickListener(new wtu(this));
    WebSettings localWebSettings = this.jdField_a_of_type_ComTencentSmttSdkWebView.getSettings();
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setNeedInitialFocus(true);
    localWebSettings.setUseWideViewPort(true);
    localWebSettings.setAllowFileAccess(true);
    localWebSettings.setBuiltInZoomControls(false);
    localWebSettings.setPluginsEnabled(true);
    if (Build.VERSION.SDK_INT > 7)
    {
      localWebSettings.setPluginState(WebSettings.PluginState.ON);
      localWebSettings.setDatabaseEnabled(true);
      localWebSettings.setDatabasePath(getApplicationContext().getDir("storage", 2).getPath());
      localWebSettings.setDomStorageEnabled(true);
      localWebSettings.setAppCacheEnabled(true);
      localWebSettings.setAppCachePath(getApplicationContext().getDir("cache", 2).getPath());
    }
    if (Build.VERSION.SDK_INT < 16) {
      WebView.enablePlatformNotifications();
    }
    if (Build.VERSION.SDK_INT >= 11) {
      this.jdField_a_of_type_ComTencentSmttSdkWebView.removeJavascriptInterface("searchBoxJavaBridge_");
    }
    this.jdField_a_of_type_ComTencentSmttSdkWebView.requestFocus();
    this.jdField_a_of_type_ComTencentSmttSdkWebView.setFocusableInTouchMode(true);
    this.jdField_a_of_type_ComTencentOpenAppcommonJsOpenJsBridge = new OpenJsBridge();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    InterfaceRegisterUtils.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentSmttSdkWebView, "file://", this.jdField_a_of_type_ComTencentOpenAppcommonJsOpenJsBridge);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\applist\WebAppActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */