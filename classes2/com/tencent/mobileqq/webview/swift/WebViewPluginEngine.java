package com.tencent.mobileqq.webview.swift;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.webviewplugin.QzonePlugin;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.musicgene.MusicGeneWebViewPlugin;
import com.tencent.mobileqq.vaswebviewplugin.MessageRoamJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QWalletPayJsPlugin;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper.CommonJsPluginFactory;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public final class WebViewPluginEngine
{
  public static WebViewPluginEngine a;
  public static final String a = "auth.init";
  protected static final HashMap a;
  private static final String jdField_b_of_type_JavaLangString = "WebViewPluginEngine";
  private static final String jdField_c_of_type_JavaLangString = "appid";
  private static final String d = "openGroupId";
  private static final String e = "token";
  private static final String f = "apiList";
  public Activity a;
  private AuthorizeConfig jdField_a_of_type_ComTencentBizAuthorizeConfig;
  private volatile CustomWebView jdField_a_of_type_ComTencentBizPubaccountCustomWebView;
  public AppInterface a;
  private final ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private final HashMap jdField_b_of_type_JavaUtilHashMap;
  private final HashMap jdField_c_of_type_JavaUtilHashMap;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilHashMap.put("auth.init", "Troop.init");
    jdField_a_of_type_JavaUtilHashMap.put("device.getNetworkInfo", "qbizApi.getNetworkInfo");
    jdField_a_of_type_JavaUtilHashMap.put("data.setShareInfo", "QQApi.setShareInfo");
    jdField_a_of_type_JavaUtilHashMap.put("event.dispatchEvent", "event.dispatchEvent");
    jdField_a_of_type_JavaUtilHashMap.put("media.showPicture", "troopNotice.showPicture");
    jdField_a_of_type_JavaUtilHashMap.put("ui.popBack", "publicAccount.close");
    jdField_a_of_type_JavaUtilHashMap.put("ui.shareMessage", "QQApi.shareMsg");
  }
  
  public WebViewPluginEngine(CustomWebView paramCustomWebView, Activity paramActivity, AppInterface paramAppInterface)
  {
    this(paramCustomWebView, paramActivity, paramAppInterface, new WebAccelerateHelper.CommonJsPluginFactory());
  }
  
  public WebViewPluginEngine(CustomWebView paramCustomWebView, Activity paramActivity, AppInterface paramAppInterface, WebAccelerateHelper.CommonJsPluginFactory paramCommonJsPluginFactory)
  {
    this.b = new HashMap();
    this.c = new HashMap();
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = paramCustomWebView;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    a(false, paramAppInterface, paramCommonJsPluginFactory, null);
    b();
    a(paramAppInterface, paramActivity);
  }
  
  public WebViewPluginEngine(CustomWebView paramCustomWebView, Activity paramActivity, AppInterface paramAppInterface, WebAccelerateHelper.CommonJsPluginFactory paramCommonJsPluginFactory, List paramList)
  {
    this.b = new HashMap();
    this.c = new HashMap();
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = paramCustomWebView;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    a(false, paramAppInterface, paramCommonJsPluginFactory, null);
    paramCustomWebView = paramList.iterator();
    while (paramCustomWebView.hasNext())
    {
      paramCommonJsPluginFactory = (WebViewPlugin)paramCustomWebView.next();
      b(paramCommonJsPluginFactory);
      a(paramCommonJsPluginFactory);
    }
    a(paramAppInterface, paramActivity);
  }
  
  public WebViewPluginEngine(CustomWebView paramCustomWebView, Activity paramActivity, AppInterface paramAppInterface, List paramList)
  {
    this(paramCustomWebView, paramActivity, paramAppInterface, new WebAccelerateHelper.CommonJsPluginFactory(), paramList);
  }
  
  public WebViewPluginEngine(AppInterface paramAppInterface, WebAccelerateHelper.CommonJsPluginFactory paramCommonJsPluginFactory, List paramList)
  {
    this.b = new HashMap();
    this.c = new HashMap();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    a(true, paramAppInterface, paramCommonJsPluginFactory, paramList);
  }
  
  public static int a(WebViewPlugin paramWebViewPlugin)
  {
    if (paramWebViewPlugin == null) {}
    label37:
    label60:
    do
    {
      do
      {
        return -1;
        if (!(paramWebViewPlugin instanceof MultiNameSpacePluginCompact)) {
          break;
        }
        paramWebViewPlugin = ((MultiNameSpacePluginCompact)paramWebViewPlugin).getMultiNameSpace();
      } while ((paramWebViewPlugin == null) || (paramWebViewPlugin.length <= 0));
      int j = paramWebViewPlugin.length;
      int i = 0;
      CharSequence localCharSequence;
      if (i < j)
      {
        localCharSequence = paramWebViewPlugin[i];
        if (!TextUtils.isEmpty(localCharSequence)) {
          break label60;
        }
      }
      while (!WebViewPluginFactory.jdField_a_of_type_JavaUtilHashMap.containsKey(localCharSequence))
      {
        i += 1;
        break label37;
        break;
      }
      return ((Integer)WebViewPluginFactory.jdField_a_of_type_JavaUtilHashMap.get(localCharSequence)).intValue();
      if (TextUtils.isEmpty(paramWebViewPlugin.mPluginNameSpace)) {
        break;
      }
    } while (!WebViewPluginFactory.jdField_a_of_type_JavaUtilHashMap.containsKey(paramWebViewPlugin.mPluginNameSpace));
    return ((Integer)WebViewPluginFactory.jdField_a_of_type_JavaUtilHashMap.get(paramWebViewPlugin.mPluginNameSpace)).intValue();
    a(paramWebViewPlugin.toString() + " have no namespace!!!!");
    return -1;
  }
  
  private void a(WebViewPlugin paramWebViewPlugin)
  {
    if (paramWebViewPlugin != null)
    {
      paramWebViewPlugin.initRuntime(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      paramWebViewPlugin.onCreate();
      if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView != null) {
        paramWebViewPlugin.onWebViewCreated(this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView);
      }
    }
  }
  
  private static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("WebViewPluginEngine", 2, paramString);
    }
  }
  
  private void a(String paramString, WebViewPlugin paramWebViewPlugin)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramWebViewPlugin == null)) {
      break label11;
    }
    for (;;)
    {
      label11:
      return;
      if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
      {
        if (QLog.isColorLevel()) {
          QLog.i("WebViewPluginEngine", 2, String.format("now insert plugin [%s] into pluginHashMap, namespace is [%s]", new Object[] { paramWebViewPlugin.getClass().getSimpleName(), paramString }));
        }
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramWebViewPlugin);
        Object localObject2;
        Object localObject1;
        if (WebviewPluginEventConfig.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
        {
          l2 = ((Long)WebviewPluginEventConfig.jdField_a_of_type_JavaUtilHashMap.get(paramString)).longValue();
          if (l2 > 0L)
          {
            l1 = 1L;
            i = 1;
            while (l2 >= l1)
            {
              if ((l2 & l1) != 0L)
              {
                localObject2 = (CopyOnWriteArrayList)this.b.get(Long.valueOf(l1));
                localObject1 = localObject2;
                if (localObject2 == null)
                {
                  localObject1 = new CopyOnWriteArrayList();
                  this.b.put(Long.valueOf(l1), localObject1);
                }
                ((CopyOnWriteArrayList)localObject1).add(paramWebViewPlugin);
              }
              l1 = 1L << i;
              i += 1;
            }
          }
        }
        if (!WebViewPluginSchemeConfig.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)) {
          break;
        }
        long l2 = ((Long)WebViewPluginSchemeConfig.jdField_a_of_type_JavaUtilHashMap.get(paramString)).longValue();
        int i = 1;
        long l1 = 1L;
        while ((l2 > 0L) && (l2 >= l1))
        {
          if ((l2 & l1) != 0L)
          {
            localObject2 = WebViewPluginSchemeConfig.a(l1);
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              localObject1 = (CopyOnWriteArrayList)this.c.get(localObject2);
              paramString = (String)localObject1;
              if (localObject1 == null)
              {
                paramString = new CopyOnWriteArrayList();
                this.c.put(localObject2, paramString);
              }
              paramString.add(paramWebViewPlugin);
            }
          }
          l1 = 1L << i;
          i += 1;
        }
      }
    }
  }
  
  private void a(boolean paramBoolean, AppInterface paramAppInterface, WebAccelerateHelper.CommonJsPluginFactory paramCommonJsPluginFactory, List paramList)
  {
    paramCommonJsPluginFactory = paramCommonJsPluginFactory.a().iterator();
    while (paramCommonJsPluginFactory.hasNext()) {
      b((WebViewPlugin)paramCommonJsPluginFactory.next());
    }
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramCommonJsPluginFactory = paramList.iterator();
      while (paramCommonJsPluginFactory.hasNext()) {
        b((WebViewPlugin)paramCommonJsPluginFactory.next());
      }
    }
    paramCommonJsPluginFactory = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    while (paramCommonJsPluginFactory.hasNext())
    {
      paramList = (WebViewPlugin)paramCommonJsPluginFactory.next();
      paramList.onAppRuntimeReady(paramAppInterface);
      paramList.onCreate();
      if (!paramBoolean)
      {
        paramList.initRuntime(this.jdField_a_of_type_AndroidAppActivity, paramAppInterface);
        if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView != null) {
          paramList.onWebViewCreated(this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView);
        }
      }
    }
  }
  
  static boolean a(WebViewPlugin paramWebViewPlugin, JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String[] paramArrayOfString)
  {
    if (paramWebViewPlugin == null) {
      return false;
    }
    try
    {
      long l1 = System.currentTimeMillis();
      long l2;
      if (paramWebViewPlugin.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, paramArrayOfString))
      {
        l2 = System.currentTimeMillis();
        if (!QLog.isColorLevel()) {
          break label240;
        }
        QLog.d("WebViewPluginEngine", 2, String.format("now plugin [%s] handleJs [%s] return true, cost: %dms", new Object[] { paramWebViewPlugin.getClass().getSimpleName(), paramString2 + "." + paramString3, Long.valueOf(l2 - l1) }));
        break label240;
      }
      if (QLog.isColorLevel())
      {
        l2 = System.currentTimeMillis();
        QLog.d("WebViewPluginEngine", 2, String.format("At the end, plugin [%s] ignore handleJs [%s], cost: %dms", new Object[] { paramWebViewPlugin.getClass().getSimpleName(), paramString2 + "." + paramString3, Long.valueOf(l2 - l1) }));
      }
    }
    catch (Exception paramJsBridgeListener)
    {
      for (;;)
      {
        paramJsBridgeListener = paramJsBridgeListener;
        if (QLog.isColorLevel()) {
          QLog.w("WebViewPluginEngine", 2, "Exception in " + paramWebViewPlugin.getClass().getSimpleName() + " : " + paramJsBridgeListener.getMessage());
        }
      }
    }
    finally {}
    return false;
    label240:
    return true;
  }
  
  static boolean a(WebViewPluginEngine paramWebViewPluginEngine, CustomWebView paramCustomWebView, String paramString)
  {
    Object localObject2 = (paramString + "/#").split("/");
    if (localObject2.length < 5)
    {
      QLog.e("WebViewPluginEngine", 1, "illegal jsbridge:" + paramString);
      return true;
    }
    String str = localObject2[2];
    int j = 1;
    long l = -1L;
    Object localObject1;
    String[] arrayOfString;
    int k;
    if (localObject2.length == 5)
    {
      localObject1 = localObject2[3].split("#");
      if (localObject1.length > 1) {}
      for (;;)
      {
        try
        {
          i = Integer.parseInt(localObject1[1]);
          l = i;
          localObject2 = localObject1[0].split("\\?");
          if (localObject2.length <= 1) {
            break;
          }
          arrayOfString = localObject2[1].split("&");
          i = 0;
          j = arrayOfString.length;
          localObject1 = arrayOfString;
          if (i >= j) {
            break label267;
          }
          k = arrayOfString[i].indexOf('=');
          if (k != -1)
          {
            arrayOfString[i] = URLDecoder.decode(arrayOfString[i].substring(k + 1));
            i += 1;
          }
          else
          {
            arrayOfString[i] = "";
          }
        }
        catch (NumberFormatException paramWebViewPluginEngine)
        {
          QLog.e("WebViewPluginEngine", 1, "illegal jsbridge:" + paramString + ", error:" + paramWebViewPluginEngine.toString());
          return true;
        }
      }
      localObject1 = new String[0];
      label267:
      arrayOfString = localObject2[0];
    }
    for (int i = 0;; i = j)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("WebViewPluginEngine", 4, "calling " + str + "." + arrayOfString);
      }
      JsBridgeListener localJsBridgeListener = new JsBridgeListener(paramCustomWebView, l, paramString);
      paramCustomWebView = paramCustomWebView.getUrl();
      if (paramWebViewPluginEngine.a().a(paramCustomWebView, str + "." + arrayOfString))
      {
        localObject2 = paramWebViewPluginEngine.a(str);
        paramCustomWebView = (CustomWebView)localObject2;
        if (localObject2 == null) {
          paramCustomWebView = paramWebViewPluginEngine.b(str);
        }
        if (paramCustomWebView != null)
        {
          a(paramCustomWebView, localJsBridgeListener, paramString, str, arrayOfString, (String[])localObject1);
          return true;
          arrayOfString = localObject2[3];
          try
          {
            l = Long.parseLong(localObject2[4]);
            i = localObject2.length - 6;
            localObject1 = new String[i];
            System.arraycopy(localObject2, 5, localObject1, 0, i);
            i = 0;
            k = localObject1.length;
            while (i < k)
            {
              localObject1[i] = URLDecoder.decode(localObject1[i]);
              i += 1;
            }
            if (!QLog.isDevelopLevel()) {
              break label573;
            }
          }
          catch (Exception paramWebViewPluginEngine)
          {
            QLog.e("WebViewPluginEngine", 1, "illegal jsbridge:" + paramString + ", error:" + paramWebViewPluginEngine.toString());
            return true;
          }
        }
        a("no plugin handle " + str + "." + arrayOfString);
        label573:
        if (i != 0) {
          if (l == -1L) {}
        }
      }
      for (;;)
      {
        return true;
        paramCustomWebView = null;
        paramWebViewPluginEngine = paramCustomWebView;
        if (localObject1.length > 0)
        {
          paramWebViewPluginEngine = paramCustomWebView;
          if (!localObject1[0].startsWith("{")) {}
        }
        try
        {
          paramWebViewPluginEngine = new JSONObject(localObject1[0]).optString("callback");
          paramCustomWebView = paramWebViewPluginEngine;
          if (TextUtils.isEmpty(paramWebViewPluginEngine))
          {
            paramCustomWebView = paramWebViewPluginEngine;
            if (l != -1L) {
              paramCustomWebView = Long.toString(l);
            }
          }
          if (!TextUtils.isEmpty(paramCustomWebView))
          {
            continue;
            if (QLog.isDevelopLevel()) {
              a("no plugin have right handle  " + str + "." + arrayOfString);
            }
            localJsBridgeListener.a();
          }
        }
        catch (JSONException paramWebViewPluginEngine)
        {
          for (;;)
          {
            paramWebViewPluginEngine = paramCustomWebView;
          }
        }
      }
    }
  }
  
  private WebViewPlugin b(String paramString)
  {
    paramString = WebViewPluginFactory.a(paramString);
    b(paramString);
    a(paramString);
    return paramString;
  }
  
  private void b()
  {
    Object localObject2;
    Object localObject1;
    if (this.jdField_a_of_type_AndroidAppActivity != null)
    {
      localObject2 = this.jdField_a_of_type_AndroidAppActivity.getIntent();
      str = ((Intent)localObject2).getStringExtra("url");
      localObject1 = str;
      if (str == null)
      {
        str = ((Intent)localObject2).getStringExtra("key_params_qq");
        localObject1 = str;
        if (str == null) {
          localObject1 = "";
        }
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    }
    else
    {
      return;
    }
    int i = ((String)localObject1).indexOf(":");
    if (i > 0) {}
    for (String str = ((String)localObject1).substring(0, i);; str = "")
    {
      if ((((Intent)localObject2).getBooleanExtra("fromQZone", false)) && ((str.equals("http")) || (str.equals("https"))))
      {
        localObject2 = new QzonePlugin();
        a((WebViewPlugin)localObject2);
        b((WebViewPlugin)localObject2);
      }
      if (MusicGeneWebViewPlugin.a((String)localObject1))
      {
        localObject2 = new MusicGeneWebViewPlugin();
        a((WebViewPlugin)localObject2);
        b((WebViewPlugin)localObject2);
      }
      if ((((String)localObject1).startsWith("http://clientui.3g.qq.com/mqqapi/im/roam")) || (((String)localObject1).startsWith("http://mapp.3g.qq.com/touch/psw/verify.jsp")) || (((String)localObject1).startsWith("http://mapp.3g.qq.com/touch/psw/create.jsp")))
      {
        localObject1 = new MessageRoamJsPlugin();
        a((WebViewPlugin)localObject1);
        b((WebViewPlugin)localObject1);
      }
      if (!str.equals("qqjsbridge")) {
        break;
      }
      localObject1 = new QWalletPayJsPlugin();
      a((WebViewPlugin)localObject1);
      b((WebViewPlugin)localObject1);
      return;
    }
  }
  
  private void b(AppInterface paramAppInterface, Activity paramActivity, List paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        WebViewPlugin localWebViewPlugin = (WebViewPlugin)paramList.next();
        localWebViewPlugin.initRuntime(paramActivity, paramAppInterface);
        localWebViewPlugin.onCreate();
        localWebViewPlugin.onAppRuntimeReady(paramAppInterface);
        b(localWebViewPlugin);
      }
    }
  }
  
  private void b(WebViewPlugin paramWebViewPlugin)
  {
    if ((paramWebViewPlugin instanceof MultiNameSpacePluginCompact))
    {
      String[] arrayOfString = ((MultiNameSpacePluginCompact)paramWebViewPlugin).getMultiNameSpace();
      if ((arrayOfString != null) && (arrayOfString.length > 0))
      {
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str = arrayOfString[i];
          if (!TextUtils.isEmpty(str)) {
            a(str, paramWebViewPlugin);
          }
          i += 1;
        }
      }
    }
    else if ((paramWebViewPlugin != null) && (!TextUtils.isEmpty(paramWebViewPlugin.mPluginNameSpace)))
    {
      a(paramWebViewPlugin.mPluginNameSpace, paramWebViewPlugin);
    }
  }
  
  /* Error */
  static boolean b(WebViewPluginEngine paramWebViewPluginEngine, CustomWebView paramCustomWebView, String paramString)
  {
    // Byte code:
    //   0: new 168	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   7: aload_2
    //   8: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11: ldc_w 304
    //   14: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   20: ldc_w 306
    //   23: invokevirtual 310	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   26: astore_3
    //   27: aload_3
    //   28: arraylength
    //   29: iconst_5
    //   30: if_icmpge +31 -> 61
    //   33: ldc 13
    //   35: iconst_1
    //   36: new 168	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   43: ldc_w 312
    //   46: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload_2
    //   50: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokestatic 202	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   59: iconst_1
    //   60: ireturn
    //   61: aload_3
    //   62: iconst_2
    //   63: aaload
    //   64: astore 8
    //   66: ldc2_w 313
    //   69: lstore 15
    //   71: aload_3
    //   72: arraylength
    //   73: iconst_5
    //   74: if_icmpne +390 -> 464
    //   77: aload_3
    //   78: iconst_3
    //   79: aaload
    //   80: ldc_w 316
    //   83: invokevirtual 310	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   86: astore_3
    //   87: aload_3
    //   88: arraylength
    //   89: iconst_1
    //   90: if_icmple +16 -> 106
    //   93: aload_3
    //   94: iconst_1
    //   95: aaload
    //   96: invokestatic 320	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   99: istore 14
    //   101: iload 14
    //   103: i2l
    //   104: lstore 15
    //   106: aload_3
    //   107: iconst_0
    //   108: aaload
    //   109: ldc_w 322
    //   112: invokevirtual 310	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   115: astore 4
    //   117: aload 4
    //   119: arraylength
    //   120: iconst_1
    //   121: if_icmple +335 -> 456
    //   124: aload 4
    //   126: iconst_1
    //   127: aaload
    //   128: bipush 61
    //   130: invokevirtual 328	java/lang/String:indexOf	(I)I
    //   133: istore 14
    //   135: iload 14
    //   137: iconst_m1
    //   138: if_icmpeq +310 -> 448
    //   141: aload 4
    //   143: iconst_1
    //   144: aaload
    //   145: iload 14
    //   147: iconst_1
    //   148: iadd
    //   149: invokevirtual 332	java/lang/String:substring	(I)Ljava/lang/String;
    //   152: invokestatic 338	java/net/URLDecoder:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   155: astore 5
    //   157: ldc_w 468
    //   160: aload 5
    //   162: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   165: ifeq +270 -> 435
    //   168: iconst_0
    //   169: anewarray 217	java/lang/String
    //   172: astore_3
    //   173: aload 4
    //   175: iconst_0
    //   176: aaload
    //   177: astore 9
    //   179: new 168	java/lang/StringBuilder
    //   182: dup
    //   183: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   186: aload 8
    //   188: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: ldc_w 283
    //   194: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: aload 9
    //   199: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: astore 13
    //   207: invokestatic 346	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   210: ifeq +30 -> 240
    //   213: ldc 13
    //   215: iconst_4
    //   216: new 168	java/lang/StringBuilder
    //   219: dup
    //   220: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   223: ldc_w 470
    //   226: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: aload 13
    //   231: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   237: invokestatic 285	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   240: new 350	com/tencent/mobileqq/webview/swift/JsBridgeListener
    //   243: dup
    //   244: aload_1
    //   245: lload 15
    //   247: iconst_1
    //   248: invokespecial 473	com/tencent/mobileqq/webview/swift/JsBridgeListener:<init>	(Lcom/tencent/smtt/sdk/WebView;JZ)V
    //   251: astore 12
    //   253: aconst_null
    //   254: astore 5
    //   256: aconst_null
    //   257: astore 10
    //   259: aconst_null
    //   260: astore 4
    //   262: aconst_null
    //   263: astore 6
    //   265: aconst_null
    //   266: astore 7
    //   268: aconst_null
    //   269: astore 11
    //   271: aload_3
    //   272: arraylength
    //   273: iconst_1
    //   274: if_icmpne +568 -> 842
    //   277: ldc 9
    //   279: aload 13
    //   281: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   284: ifne +558 -> 842
    //   287: new 392	org/json/JSONObject
    //   290: dup
    //   291: aload_3
    //   292: iconst_0
    //   293: aaload
    //   294: invokespecial 394	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   297: astore 11
    //   299: aload 11
    //   301: ldc 16
    //   303: invokevirtual 477	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   306: checkcast 217	java/lang/String
    //   309: invokestatic 320	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   312: istore 14
    //   314: aload 11
    //   316: ldc 19
    //   318: invokevirtual 477	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   321: checkcast 217	java/lang/String
    //   324: astore 4
    //   326: aload 11
    //   328: ldc 22
    //   330: invokevirtual 477	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   333: checkcast 217	java/lang/String
    //   336: astore 5
    //   338: aload 11
    //   340: ldc 25
    //   342: invokevirtual 477	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   345: pop
    //   346: aload 11
    //   348: invokevirtual 478	org/json/JSONObject:toString	()Ljava/lang/String;
    //   351: astore 6
    //   353: ldc_w 468
    //   356: aload 6
    //   358: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   361: ifeq +121 -> 482
    //   364: iconst_0
    //   365: anewarray 217	java/lang/String
    //   368: astore 6
    //   370: aload 6
    //   372: astore_3
    //   373: aload_1
    //   374: aload_1
    //   375: iload 14
    //   377: aload 4
    //   379: aload 5
    //   381: aload 13
    //   383: aload 12
    //   385: invokevirtual 481	com/tencent/biz/pubaccount/CustomWebView:a	(Lcom/tencent/biz/pubaccount/CustomWebView;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;)Z
    //   388: ifne +219 -> 607
    //   391: iconst_1
    //   392: ireturn
    //   393: astore_0
    //   394: ldc 13
    //   396: iconst_1
    //   397: new 168	java/lang/StringBuilder
    //   400: dup
    //   401: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   404: ldc_w 312
    //   407: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: aload_2
    //   411: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: ldc_w 340
    //   417: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: aload_0
    //   421: invokevirtual 341	java/lang/NumberFormatException:toString	()Ljava/lang/String;
    //   424: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   430: invokestatic 202	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   433: iconst_1
    //   434: ireturn
    //   435: iconst_1
    //   436: anewarray 217	java/lang/String
    //   439: astore_3
    //   440: aload_3
    //   441: iconst_0
    //   442: aload 5
    //   444: aastore
    //   445: goto -272 -> 173
    //   448: iconst_0
    //   449: anewarray 217	java/lang/String
    //   452: astore_3
    //   453: goto -280 -> 173
    //   456: iconst_0
    //   457: anewarray 217	java/lang/String
    //   460: astore_3
    //   461: goto -288 -> 173
    //   464: invokestatic 199	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   467: ifeq +13 -> 480
    //   470: ldc_w 483
    //   473: iconst_2
    //   474: ldc_w 485
    //   477: invokestatic 202	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   480: iconst_0
    //   481: ireturn
    //   482: iconst_1
    //   483: anewarray 217	java/lang/String
    //   486: dup
    //   487: iconst_0
    //   488: aload 6
    //   490: aastore
    //   491: astore_3
    //   492: goto -119 -> 373
    //   495: astore 4
    //   497: iconst_0
    //   498: istore 14
    //   500: invokestatic 199	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   503: ifeq +33 -> 536
    //   506: ldc 13
    //   508: iconst_2
    //   509: new 168	java/lang/StringBuilder
    //   512: dup
    //   513: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   516: ldc_w 487
    //   519: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: aload 4
    //   524: invokevirtual 341	java/lang/NumberFormatException:toString	()Ljava/lang/String;
    //   527: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   533: invokestatic 285	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   536: aload 5
    //   538: astore 4
    //   540: aload 6
    //   542: astore 5
    //   544: goto -171 -> 373
    //   547: astore 4
    //   549: iconst_0
    //   550: istore 14
    //   552: aload 7
    //   554: astore 6
    //   556: aload 10
    //   558: astore 5
    //   560: invokestatic 199	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   563: ifeq +33 -> 596
    //   566: ldc 13
    //   568: iconst_2
    //   569: new 168	java/lang/StringBuilder
    //   572: dup
    //   573: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   576: ldc_w 489
    //   579: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   582: aload 4
    //   584: invokevirtual 490	org/json/JSONException:toString	()Ljava/lang/String;
    //   587: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   593: invokestatic 285	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   596: aload 5
    //   598: astore 4
    //   600: aload 6
    //   602: astore 5
    //   604: goto -231 -> 373
    //   607: aload 8
    //   609: astore 5
    //   611: aload 9
    //   613: astore 4
    //   615: getstatic 45	com/tencent/mobileqq/webview/swift/WebViewPluginEngine:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   618: aload 13
    //   620: invokevirtual 153	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   623: ifeq +49 -> 672
    //   626: getstatic 45	com/tencent/mobileqq/webview/swift/WebViewPluginEngine:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   629: aload 13
    //   631: invokevirtual 157	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   634: checkcast 217	java/lang/String
    //   637: ldc_w 492
    //   640: invokevirtual 310	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   643: astore 6
    //   645: aload 8
    //   647: astore 5
    //   649: aload 9
    //   651: astore 4
    //   653: aload 6
    //   655: arraylength
    //   656: iconst_2
    //   657: if_icmpne +15 -> 672
    //   660: aload 6
    //   662: iconst_0
    //   663: aaload
    //   664: astore 5
    //   666: aload 6
    //   668: iconst_1
    //   669: aaload
    //   670: astore 4
    //   672: aload_0
    //   673: aload 5
    //   675: invokevirtual 369	com/tencent/mobileqq/webview/swift/WebViewPluginEngine:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;
    //   678: astore 7
    //   680: aload 7
    //   682: astore 6
    //   684: aload 7
    //   686: ifnonnull +11 -> 697
    //   689: aload_0
    //   690: aload 5
    //   692: invokespecial 371	com/tencent/mobileqq/webview/swift/WebViewPluginEngine:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;
    //   695: astore 6
    //   697: aload 6
    //   699: ifnull +21 -> 720
    //   702: aload 6
    //   704: aload 12
    //   706: aload_2
    //   707: aload 5
    //   709: aload 4
    //   711: aload_3
    //   712: invokestatic 373	com/tencent/mobileqq/webview/swift/WebViewPluginEngine:a	(Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z
    //   715: ifeq +5 -> 720
    //   718: iconst_1
    //   719: ireturn
    //   720: aload_1
    //   721: aload 12
    //   723: iconst_3
    //   724: iconst_1
    //   725: anewarray 217	java/lang/String
    //   728: dup
    //   729: iconst_0
    //   730: iconst_3
    //   731: aconst_null
    //   732: ldc_w 494
    //   735: invokestatic 497	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(ILjava/lang/Object;Ljava/lang/String;)Ljava/lang/String;
    //   738: aastore
    //   739: invokevirtual 500	com/tencent/biz/pubaccount/CustomWebView:a	(Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;I[Ljava/lang/String;)V
    //   742: iconst_1
    //   743: ireturn
    //   744: astore 4
    //   746: aload 10
    //   748: astore 5
    //   750: aload 7
    //   752: astore 6
    //   754: goto -194 -> 560
    //   757: astore 6
    //   759: aload 4
    //   761: astore 5
    //   763: aload 6
    //   765: astore 4
    //   767: aload 7
    //   769: astore 6
    //   771: goto -211 -> 560
    //   774: astore 7
    //   776: aload 5
    //   778: astore 6
    //   780: aload 7
    //   782: astore 5
    //   784: aload 4
    //   786: astore 7
    //   788: aload 5
    //   790: astore 4
    //   792: aload 7
    //   794: astore 5
    //   796: goto -236 -> 560
    //   799: astore 4
    //   801: goto -301 -> 500
    //   804: astore 7
    //   806: aload 4
    //   808: astore 5
    //   810: aload 7
    //   812: astore 4
    //   814: goto -314 -> 500
    //   817: astore 7
    //   819: aload 5
    //   821: astore 6
    //   823: aload 7
    //   825: astore 5
    //   827: aload 4
    //   829: astore 7
    //   831: aload 5
    //   833: astore 4
    //   835: aload 7
    //   837: astore 5
    //   839: goto -339 -> 500
    //   842: iconst_0
    //   843: istore 14
    //   845: aload 11
    //   847: astore 5
    //   849: goto -476 -> 373
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	852	0	paramWebViewPluginEngine	WebViewPluginEngine
    //   0	852	1	paramCustomWebView	CustomWebView
    //   0	852	2	paramString	String
    //   26	686	3	localObject1	Object
    //   115	263	4	localObject2	Object
    //   495	28	4	localNumberFormatException1	NumberFormatException
    //   538	1	4	localObject3	Object
    //   547	36	4	localJSONException1	JSONException
    //   598	112	4	localObject4	Object
    //   744	16	4	localJSONException2	JSONException
    //   765	26	4	localObject5	Object
    //   799	8	4	localNumberFormatException2	NumberFormatException
    //   812	22	4	localObject6	Object
    //   155	693	5	localObject7	Object
    //   263	490	6	localObject8	Object
    //   757	7	6	localJSONException3	JSONException
    //   769	53	6	localObject9	Object
    //   266	502	7	localWebViewPlugin	WebViewPlugin
    //   774	7	7	localJSONException4	JSONException
    //   786	7	7	localObject10	Object
    //   804	7	7	localNumberFormatException3	NumberFormatException
    //   817	7	7	localNumberFormatException4	NumberFormatException
    //   829	7	7	localObject11	Object
    //   64	582	8	str1	String
    //   177	473	9	str2	String
    //   257	490	10	localObject12	Object
    //   269	577	11	localJSONObject	JSONObject
    //   251	471	12	localJsBridgeListener	JsBridgeListener
    //   205	425	13	str3	String
    //   99	745	14	i	int
    //   69	177	15	l	long
    // Exception table:
    //   from	to	target	type
    //   93	101	393	java/lang/NumberFormatException
    //   287	314	495	java/lang/NumberFormatException
    //   287	314	547	org/json/JSONException
    //   314	326	744	org/json/JSONException
    //   326	338	757	org/json/JSONException
    //   338	370	774	org/json/JSONException
    //   314	326	799	java/lang/NumberFormatException
    //   326	338	804	java/lang/NumberFormatException
    //   338	370	817	java/lang/NumberFormatException
  }
  
  private boolean b(String paramString)
  {
    String str = SwiftWebViewUtils.a(paramString);
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    if ("javascript".equals(str)) {
      return false;
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView;
    if (localObject2 == null) {
      return false;
    }
    Object localObject1 = ((CustomWebView)localObject2).getUrl();
    if ("jsbridge".equals(str)) {
      return a(this, (CustomWebView)localObject2, paramString);
    }
    if ("openapi".equals(str)) {
      return b(this, (CustomWebView)localObject2, paramString);
    }
    if ((this.c.containsKey(str)) && (a().c((String)localObject1, str)))
    {
      localObject2 = (CopyOnWriteArrayList)this.c.get(str);
      if ((localObject2 != null) && (!((CopyOnWriteArrayList)localObject2).isEmpty()))
      {
        if (QLog.isColorLevel()) {
          QLog.i("WebViewPluginEngine", 2, String.format("now start handleSchemaRequest [%s], url is [%s]", new Object[] { str, localObject1 }));
        }
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder(((CopyOnWriteArrayList)localObject2).size() * 64);
          localObject2 = ((CopyOnWriteArrayList)localObject2).iterator();
        }
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label353;
          }
          WebViewPlugin localWebViewPlugin = (WebViewPlugin)((Iterator)localObject2).next();
          long l1 = System.currentTimeMillis();
          if (localWebViewPlugin != null)
          {
            long l2;
            if (localWebViewPlugin.handleSchemaRequest(paramString, str))
            {
              if (QLog.isColorLevel())
              {
                l2 = System.currentTimeMillis();
                ((StringBuilder)localObject1).append(String.format("finally plugin [%s] handleSchemaRequest return true,  cost %dms!", new Object[] { localWebViewPlugin.getClass().getSimpleName(), Long.valueOf(l2 - l1) }));
                QLog.i("WebViewPluginEngine", 2, ((StringBuilder)localObject1).toString());
              }
              return true;
              localObject1 = new StringBuilder();
              break;
            }
            if (QLog.isColorLevel())
            {
              l2 = System.currentTimeMillis();
              ((StringBuilder)localObject1).append(String.format("plugin [%s] handleSchemaRequest cost %dms! \n", new Object[] { localWebViewPlugin.getClass().getSimpleName(), Long.valueOf(l2 - l1) }));
            }
          }
        }
        label353:
        if (QLog.isColorLevel())
        {
          ((StringBuilder)localObject1).append("no plugin can handle this scheme ! ").append(str);
          QLog.i("WebViewPluginEngine", 2, ((StringBuilder)localObject1).toString());
        }
      }
    }
    for (;;)
    {
      return false;
      QLog.e("WebViewPluginEngine", 1, "no plugin can handle this scheme ! " + str);
    }
  }
  
  AuthorizeConfig a()
  {
    if (this.jdField_a_of_type_ComTencentBizAuthorizeConfig == null) {
      this.jdField_a_of_type_ComTencentBizAuthorizeConfig = AuthorizeConfig.a();
    }
    return this.jdField_a_of_type_ComTencentBizAuthorizeConfig;
  }
  
  public WebViewPlugin a(int paramInt, boolean paramBoolean)
  {
    WebViewPlugin localWebViewPlugin1;
    if (paramBoolean)
    {
      localWebViewPlugin1 = WebViewPluginFactory.a(paramInt);
      if (localWebViewPlugin1 != null)
      {
        b(localWebViewPlugin1);
        a(localWebViewPlugin1);
      }
    }
    for (;;)
    {
      Iterator localIterator = WebViewPluginFactory.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      Map.Entry localEntry;
      do
      {
        localWebViewPlugin2 = localWebViewPlugin1;
        if (!localIterator.hasNext()) {
          break;
        }
        localEntry = (Map.Entry)localIterator.next();
      } while (((Integer)localEntry.getValue()).intValue() != paramInt);
      WebViewPlugin localWebViewPlugin2 = localWebViewPlugin1;
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(localEntry.getKey())) {
        localWebViewPlugin2 = (WebViewPlugin)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localEntry.getKey());
      }
      return localWebViewPlugin2;
      localWebViewPlugin1 = null;
    }
  }
  
  public WebViewPlugin a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) {
      return (WebViewPlugin)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    }
    return null;
  }
  
  public Object a(String paramString, long paramLong)
  {
    Object localObject1 = (List)this.b.get(Long.valueOf(paramLong));
    if (localObject1 != null)
    {
      if (!QLog.isColorLevel()) {
        break label162;
      }
      QLog.i("WebViewPluginEngine", 2, "now start handle system key event: " + Long.toBinaryString(paramLong));
    }
    for (;;)
    {
      if ((localObject1 == null) || (((List)localObject1).size() == 0))
      {
        return null;
        if (paramLong > 8589934592L)
        {
          localObject1 = new CopyOnWriteArrayList(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values());
          if (QLog.isColorLevel()) {
            QLog.i("WebViewPluginEngine", 2, "now start handle business event: " + (paramLong - 8589934592L));
          }
        }
        else
        {
          QLog.e("WebViewPluginEngine", 1, "now no plugin can handle this event: " + paramLong);
        }
      }
      else
      {
        label162:
        HashMap localHashMap = new HashMap();
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder(((List)localObject1).size() * 64);
          localObject1 = ((List)localObject1).iterator();
        }
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label401;
          }
          WebViewPlugin localWebViewPlugin = (WebViewPlugin)((Iterator)localObject1).next();
          if ((localWebViewPlugin != null) && (!localHashMap.containsKey(localWebViewPlugin)))
          {
            long l1 = System.currentTimeMillis();
            Object localObject2 = localWebViewPlugin.handleEvent(paramString, paramLong);
            if (localObject2 != null)
            {
              if (QLog.isColorLevel())
              {
                paramLong = System.currentTimeMillis();
                localStringBuilder.append(String.format("finally plugin [%s]  handleEvent return true cost: %dms", new Object[] { localWebViewPlugin.getClass().getSimpleName(), Long.valueOf(paramLong - l1) }));
                QLog.i("WebViewPluginEngine", 2, localStringBuilder.toString());
              }
              return localObject2;
              localStringBuilder = new StringBuilder();
              break;
            }
            localHashMap.put(localWebViewPlugin, Boolean.valueOf(true));
            if (QLog.isColorLevel())
            {
              long l2 = System.currentTimeMillis();
              localStringBuilder.append(String.format("plugin [%s] handleEvent cost: %dms. \n", new Object[] { localWebViewPlugin.getClass().getSimpleName(), Long.valueOf(l2 - l1) }));
            }
          }
        }
        label401:
        if (QLog.isColorLevel())
        {
          localStringBuilder.append("At the end,  no plugin can handleEvent !");
          QLog.i("WebViewPluginEngine", 2, localStringBuilder.toString());
        }
        return null;
      }
    }
  }
  
  public String a()
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) || (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebViewPluginEngine", 2, "-->plugin list is empty.");
      }
      return "no plugins";
    }
    StringBuilder localStringBuilder = new StringBuilder(1024);
    localStringBuilder.append("plugin list:\n");
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append(((WebViewPlugin)localIterator.next()).getClass().getSimpleName()).append("\n");
    }
    return localStringBuilder.toString();
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      WebViewPlugin localWebViewPlugin = (WebViewPlugin)localIterator.next();
      System.currentTimeMillis();
      try
      {
        localWebViewPlugin.onDestroy();
      }
      catch (Exception localException) {}
      if (QLog.isColorLevel()) {
        QLog.d("WebViewPluginEngine", 2, QLog.getStackTraceString(localException));
      }
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.b.clear();
    this.c.clear();
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = null;
  }
  
  public void a(CustomWebView paramCustomWebView)
  {
    if ((paramCustomWebView != null) && (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView != paramCustomWebView))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = paramCustomWebView;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
      while (localIterator.hasNext()) {
        ((WebViewPlugin)localIterator.next()).onWebViewCreated(paramCustomWebView);
      }
    }
  }
  
  public void a(AppInterface paramAppInterface, Activity paramActivity)
  {
    a(paramAppInterface, paramActivity, null);
  }
  
  public void a(AppInterface paramAppInterface, Activity paramActivity, List paramList)
  {
    if (this.jdField_a_of_type_AndroidAppActivity == null) {
      this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    }
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    }
    if ((paramList != null) && (paramList.size() > 0)) {
      b(paramAppInterface, paramActivity, paramList);
    }
    boolean bool = paramActivity.getIntent().getBooleanExtra("fromQZone", false);
    paramList = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      WebViewPlugin localWebViewPlugin = (WebViewPlugin)paramList.next();
      if (localWebViewPlugin != null)
      {
        if (localWebViewPlugin.mRuntime == null) {
          localWebViewPlugin.initRuntime(paramActivity, paramAppInterface);
        }
        localWebViewPlugin.onActivityReady();
        if (!(localWebViewPlugin instanceof QzonePlugin)) {
          break label171;
        }
        i = 1;
      }
    }
    label171:
    for (;;)
    {
      break;
      if ((bool) && (i == 0))
      {
        paramList = new QzonePlugin();
        paramList.initRuntime(paramActivity, paramAppInterface);
        paramList.onCreate();
        paramList.onAppRuntimeReady(paramAppInterface);
        b(paramList);
      }
      return;
    }
  }
  
  public void a(String[] paramArrayOfString)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        b(paramArrayOfString[i]);
        i += 1;
      }
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool = b(paramString);
    if (bool) {}
    return bool;
  }
  
  public boolean a(String paramString, long paramLong, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("errorCode", Integer.valueOf(paramInt));
    return a(paramString, paramLong, localHashMap);
  }
  
  public boolean a(String paramString, long paramLong, Map paramMap)
  {
    Object localObject;
    if (this.b.containsKey(Long.valueOf(paramLong)))
    {
      localObject = (List)this.b.get(Long.valueOf(paramLong));
      if (!QLog.isColorLevel()) {
        break label441;
      }
      QLog.i("WebViewPluginEngine", 2, "now start handle system key event: " + Long.toBinaryString(paramLong));
    }
    label410:
    label441:
    for (;;)
    {
      if ((localObject == null) || (((List)localObject).size() == 0))
      {
        return false;
        if (paramLong > 8589934592L)
        {
          localObject = new CopyOnWriteArrayList(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values());
          if (QLog.isColorLevel()) {
            QLog.i("WebViewPluginEngine", 2, "now start handle business event: " + (paramLong - 8589934592L));
          }
        }
        else
        {
          QLog.e("WebViewPluginEngine", 1, "now no plugin can handle this event: " + paramLong);
          localObject = null;
        }
      }
      else
      {
        HashMap localHashMap = new HashMap();
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder(((List)localObject).size() * 64);
          localObject = ((List)localObject).iterator();
        }
        for (;;)
        {
          if (!((Iterator)localObject).hasNext()) {
            break label410;
          }
          WebViewPlugin localWebViewPlugin = (WebViewPlugin)((Iterator)localObject).next();
          if ((localWebViewPlugin != null) && (!localHashMap.containsKey(localWebViewPlugin)))
          {
            long l1 = System.currentTimeMillis();
            if (localWebViewPlugin.handleEvent(paramString, paramLong, paramMap))
            {
              if (QLog.isColorLevel())
              {
                paramLong = System.currentTimeMillis();
                localStringBuilder.append(String.format("finally plugin [%s] handleEvent return true,  cost: %dms", new Object[] { localWebViewPlugin.getClass().getSimpleName(), Long.valueOf(paramLong - l1) }));
                QLog.i("WebViewPluginEngine", 2, localStringBuilder.toString());
              }
              return true;
              localStringBuilder = new StringBuilder();
              break;
            }
            localHashMap.put(localWebViewPlugin, Boolean.valueOf(true));
            if (QLog.isColorLevel())
            {
              long l2 = System.currentTimeMillis();
              localStringBuilder.append(String.format("plugin [%s] handleEvent cost: %dms. \n", new Object[] { localWebViewPlugin.getClass().getSimpleName(), Long.valueOf(l2 - l1) }));
            }
          }
        }
        if (QLog.isColorLevel())
        {
          localStringBuilder.append("At the end no plugin can handleEvent!");
          QLog.i("WebViewPluginEngine", 2, localStringBuilder.toString());
        }
        return false;
      }
    }
  }
  
  public boolean a(Map paramMap)
  {
    Object localObject1 = (CopyOnWriteArrayList)this.b.get(Long.valueOf(32L));
    if ((localObject1 == null) || (((CopyOnWriteArrayList)localObject1).size() == 0)) {
      return false;
    }
    StringBuilder localStringBuilder;
    HashMap localHashMap;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder(((CopyOnWriteArrayList)localObject1).size() * 64);
      if (QLog.isColorLevel()) {
        QLog.i("WebViewPluginEngine", 2, "now start handle key system event " + Long.toBinaryString(32L));
      }
      localHashMap = new HashMap();
      localObject1 = ((CopyOnWriteArrayList)localObject1).iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext()) {
        break label323;
      }
      WebViewPlugin localWebViewPlugin = (WebViewPlugin)((Iterator)localObject1).next();
      if ((localWebViewPlugin != null) && (!localHashMap.containsKey(localWebViewPlugin)))
      {
        Object localObject2 = paramMap.get("url");
        if ((localObject2 instanceof String))
        {
          long l1 = System.currentTimeMillis();
          long l2;
          if (localWebViewPlugin.handleEvent((String)localObject2, 32L, paramMap))
          {
            if (QLog.isColorLevel())
            {
              l2 = System.currentTimeMillis();
              localStringBuilder.append(String.format("finally plugin [%s] handleBeforeLoad return true, cost: %dms", new Object[] { localWebViewPlugin.getClass().getSimpleName(), Long.valueOf(l2 - l1) }));
            }
            if (QLog.isColorLevel()) {
              QLog.i("WebViewPluginEngine", 2, localStringBuilder.toString());
            }
            return true;
            localStringBuilder = new StringBuilder();
            break;
          }
          localHashMap.put(localWebViewPlugin, Boolean.valueOf(true));
          if (QLog.isColorLevel())
          {
            l2 = System.currentTimeMillis();
            localStringBuilder.append(String.format("plugin [%s]  handleBeforeLoad, cost  : %dms \n", new Object[] { localWebViewPlugin.getClass().getSimpleName(), Long.valueOf(l2 - l1) }));
          }
        }
      }
    }
    label323:
    if (QLog.isColorLevel())
    {
      localStringBuilder.append("At the end, no plugin can handleBeforeLoad! ");
      QLog.i("WebViewPluginEngine", 2, localStringBuilder.toString());
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\webview\swift\WebViewPluginEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */