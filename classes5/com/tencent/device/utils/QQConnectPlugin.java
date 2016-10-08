package com.tencent.device.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import java.net.URLDecoder;
import java.util.HashMap;

public class QQConnectPlugin
  extends WebViewPlugin
{
  public static final String a = "QQConnect";
  private static final String b = "goShare";
  private static final String c = "doReport";
  private static final String d = "goBind";
  private static final String e = "jumpPublicDevice";
  
  public QQConnectPlugin()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.mPluginNameSpace = "QQConnect";
  }
  
  private HashMap a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return localHashMap;
      paramString = URLDecoder.decode(paramString).split("&");
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        String[] arrayOfString = paramString[i].split("=");
        if (arrayOfString.length > 1) {
          localHashMap.put(arrayOfString[0], arrayOfString[1]);
        }
        i += 1;
      }
    }
  }
  
  /* Error */
  protected boolean handleJsRequest(com.tencent.mobileqq.webview.swift.JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    // Byte code:
    //   0: ldc 8
    //   2: aload_3
    //   3: invokevirtual 74	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6: ifne +5 -> 11
    //   9: iconst_0
    //   10: ireturn
    //   11: ldc 11
    //   13: aload 4
    //   15: invokevirtual 74	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   18: ifeq +270 -> 288
    //   21: aload_0
    //   22: getfield 77	com/tencent/device/utils/QQConnectPlugin:TAG	Ljava/lang/String;
    //   25: ldc 79
    //   27: invokestatic 84	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: new 86	org/json/JSONObject
    //   33: dup
    //   34: aload 5
    //   36: iconst_0
    //   37: aaload
    //   38: invokespecial 89	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   41: astore 5
    //   43: aload 5
    //   45: ldc 91
    //   47: invokevirtual 94	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   50: astore_1
    //   51: aload_0
    //   52: aload 5
    //   54: ldc 96
    //   56: invokevirtual 94	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   59: invokespecial 98	com/tencent/device/utils/QQConnectPlugin:a	(Ljava/lang/String;)Ljava/util/HashMap;
    //   62: astore 6
    //   64: aload 6
    //   66: ldc 100
    //   68: invokevirtual 104	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   71: checkcast 54	java/lang/String
    //   74: astore_3
    //   75: aload 6
    //   77: ldc 106
    //   79: invokevirtual 104	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   82: checkcast 54	java/lang/String
    //   85: astore 4
    //   87: aload 6
    //   89: ldc 108
    //   91: invokevirtual 104	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   94: checkcast 54	java/lang/String
    //   97: astore 6
    //   99: aload 5
    //   101: ldc 110
    //   103: iconst_0
    //   104: invokevirtual 114	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   107: istore 7
    //   109: iload 7
    //   111: ifeq +60 -> 171
    //   114: aload 4
    //   116: invokestatic 44	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   119: ifne +11 -> 130
    //   122: aload 6
    //   124: invokestatic 44	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   127: ifeq +44 -> 171
    //   130: invokestatic 119	com/tencent/open/base/ToastUtil:a	()Lcom/tencent/open/base/ToastUtil;
    //   133: aload_0
    //   134: getfield 123	com/tencent/device/utils/QQConnectPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   137: invokevirtual 128	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   140: ldc -127
    //   142: invokevirtual 134	android/app/Activity:getString	(I)Ljava/lang/String;
    //   145: invokevirtual 136	com/tencent/open/base/ToastUtil:a	(Ljava/lang/String;)V
    //   148: iconst_1
    //   149: ireturn
    //   150: astore_1
    //   151: invokestatic 119	com/tencent/open/base/ToastUtil:a	()Lcom/tencent/open/base/ToastUtil;
    //   154: aload_0
    //   155: getfield 123	com/tencent/device/utils/QQConnectPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   158: invokevirtual 128	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   161: ldc -119
    //   163: invokevirtual 134	android/app/Activity:getString	(I)Ljava/lang/String;
    //   166: invokevirtual 136	com/tencent/open/base/ToastUtil:a	(Ljava/lang/String;)V
    //   169: iconst_1
    //   170: ireturn
    //   171: new 139	android/content/Intent
    //   174: dup
    //   175: aload_0
    //   176: getfield 123	com/tencent/device/utils/QQConnectPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   179: invokevirtual 128	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   182: ldc -115
    //   184: invokespecial 144	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   187: astore 5
    //   189: iload 7
    //   191: ifeq +67 -> 258
    //   194: aload 5
    //   196: ldc -110
    //   198: aload 6
    //   200: invokevirtual 150	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   203: pop
    //   204: aload 5
    //   206: ldc -104
    //   208: aload 4
    //   210: invokevirtual 150	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   213: pop
    //   214: aload 5
    //   216: ldc -102
    //   218: ldc -100
    //   220: invokevirtual 150	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   223: pop
    //   224: aload 5
    //   226: ldc 110
    //   228: iload 7
    //   230: invokevirtual 159	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   233: pop
    //   234: aload_0
    //   235: getfield 123	com/tencent/device/utils/QQConnectPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   238: invokevirtual 128	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   241: aload 5
    //   243: invokevirtual 163	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   246: aload_0
    //   247: getfield 123	com/tencent/device/utils/QQConnectPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   250: invokevirtual 128	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   253: invokevirtual 166	android/app/Activity:finish	()V
    //   256: iconst_1
    //   257: ireturn
    //   258: aload 5
    //   260: ldc -88
    //   262: aload_1
    //   263: invokevirtual 150	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   266: pop
    //   267: aload 5
    //   269: ldc 100
    //   271: aload_3
    //   272: invokevirtual 150	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   275: pop
    //   276: aload 5
    //   278: ldc -86
    //   280: aload_2
    //   281: invokevirtual 150	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   284: pop
    //   285: goto -51 -> 234
    //   288: ldc 14
    //   290: aload 4
    //   292: invokevirtual 74	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   295: ifeq +54 -> 349
    //   298: aload_0
    //   299: getfield 77	com/tencent/device/utils/QQConnectPlugin:TAG	Ljava/lang/String;
    //   302: ldc 14
    //   304: invokestatic 84	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   307: new 86	org/json/JSONObject
    //   310: dup
    //   311: aload 5
    //   313: iconst_0
    //   314: aaload
    //   315: invokespecial 89	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   318: astore_1
    //   319: aconst_null
    //   320: aload_1
    //   321: ldc -84
    //   323: invokevirtual 175	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   326: aload_1
    //   327: ldc -79
    //   329: invokevirtual 180	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   332: aload_1
    //   333: ldc -74
    //   335: invokevirtual 180	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   338: aload_1
    //   339: ldc -72
    //   341: invokevirtual 180	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   344: invokestatic 189	com/tencent/device/utils/SmartDeviceReport:a	(Lmqq/app/AppRuntime;Ljava/lang/String;III)V
    //   347: iconst_1
    //   348: ireturn
    //   349: ldc 17
    //   351: aload 4
    //   353: invokevirtual 74	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   356: ifeq +122 -> 478
    //   359: aload_0
    //   360: getfield 77	com/tencent/device/utils/QQConnectPlugin:TAG	Ljava/lang/String;
    //   363: ldc -65
    //   365: invokestatic 84	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   368: new 86	org/json/JSONObject
    //   371: dup
    //   372: aload 5
    //   374: iconst_0
    //   375: aaload
    //   376: invokespecial 89	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   379: ldc -86
    //   381: invokevirtual 175	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   384: astore_1
    //   385: aload_1
    //   386: invokestatic 44	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   389: istore 8
    //   391: iload 8
    //   393: ifne +67 -> 460
    //   396: new 54	java/lang/String
    //   399: dup
    //   400: aload_1
    //   401: iconst_0
    //   402: invokestatic 196	com/tencent/mobileqq/utils/Base64Util:decode	(Ljava/lang/String;I)[B
    //   405: invokespecial 199	java/lang/String:<init>	([B)V
    //   408: astore_1
    //   409: aload_1
    //   410: invokestatic 44	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   413: ifne +47 -> 460
    //   416: new 139	android/content/Intent
    //   419: dup
    //   420: aload_0
    //   421: getfield 123	com/tencent/device/utils/QQConnectPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   424: invokevirtual 128	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   427: ldc -55
    //   429: invokespecial 144	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   432: astore_2
    //   433: aload_2
    //   434: ldc -53
    //   436: aload_1
    //   437: invokevirtual 150	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   440: pop
    //   441: aload_2
    //   442: ldc -51
    //   444: iconst_1
    //   445: invokevirtual 159	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   448: pop
    //   449: aload_0
    //   450: getfield 123	com/tencent/device/utils/QQConnectPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   453: invokevirtual 128	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   456: aload_2
    //   457: invokevirtual 163	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   460: aload_0
    //   461: getfield 123	com/tencent/device/utils/QQConnectPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   464: invokevirtual 128	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   467: invokevirtual 166	android/app/Activity:finish	()V
    //   470: iconst_1
    //   471: ireturn
    //   472: astore_1
    //   473: aconst_null
    //   474: astore_1
    //   475: goto -66 -> 409
    //   478: ldc 20
    //   480: aload 4
    //   482: invokevirtual 74	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   485: ifeq -476 -> 9
    //   488: aload_0
    //   489: getfield 77	com/tencent/device/utils/QQConnectPlugin:TAG	Ljava/lang/String;
    //   492: ldc -49
    //   494: invokestatic 84	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   497: new 86	org/json/JSONObject
    //   500: dup
    //   501: aload 5
    //   503: iconst_0
    //   504: aaload
    //   505: invokespecial 89	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   508: ldc -47
    //   510: invokevirtual 175	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   513: astore_1
    //   514: aload_1
    //   515: invokestatic 44	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   518: ifeq +5 -> 523
    //   521: iconst_1
    //   522: ireturn
    //   523: new 139	android/content/Intent
    //   526: dup
    //   527: aload_0
    //   528: getfield 123	com/tencent/device/utils/QQConnectPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   531: invokevirtual 128	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   534: ldc -115
    //   536: invokespecial 144	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   539: astore_2
    //   540: aload_2
    //   541: ldc -86
    //   543: aload_1
    //   544: invokevirtual 150	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   547: pop
    //   548: aload_2
    //   549: ldc 20
    //   551: iconst_1
    //   552: invokevirtual 212	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   555: pop
    //   556: aload_0
    //   557: getfield 123	com/tencent/device/utils/QQConnectPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   560: invokevirtual 128	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   563: aload_2
    //   564: invokevirtual 163	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   567: aload_0
    //   568: getfield 123	com/tencent/device/utils/QQConnectPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   571: invokevirtual 128	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   574: invokevirtual 166	android/app/Activity:finish	()V
    //   577: iconst_1
    //   578: ireturn
    //   579: astore_1
    //   580: iconst_0
    //   581: ireturn
    //   582: astore_1
    //   583: iconst_0
    //   584: ireturn
    //   585: astore_1
    //   586: iconst_0
    //   587: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	588	0	this	QQConnectPlugin
    //   0	588	1	paramJsBridgeListener	com.tencent.mobileqq.webview.swift.JsBridgeListener
    //   0	588	2	paramString1	String
    //   0	588	3	paramString2	String
    //   0	588	4	paramString3	String
    //   0	588	5	paramVarArgs	String[]
    //   62	137	6	localObject	Object
    //   107	122	7	i	int
    //   389	3	8	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   30	109	150	org/json/JSONException
    //   396	409	472	java/lang/Exception
    //   488	521	579	org/json/JSONException
    //   523	577	579	org/json/JSONException
    //   359	391	582	org/json/JSONException
    //   396	409	582	org/json/JSONException
    //   409	460	582	org/json/JSONException
    //   460	470	582	org/json/JSONException
    //   298	347	585	org/json/JSONException
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\device\utils\QQConnectPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */