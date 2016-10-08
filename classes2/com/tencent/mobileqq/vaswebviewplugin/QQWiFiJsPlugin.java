package com.tencent.mobileqq.vaswebviewplugin;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class QQWiFiJsPlugin
  extends VasWebviewJsPlugin
{
  public static final String OBJECT_NAME = "qw_qqwifi";
  private static final String TAG = "QQWiFiJsPlugin";
  
  public QQWiFiJsPlugin()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.mPluginNameSpace = "qw_qqwifi";
  }
  
  private boolean isAppInstall(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 64);
      if (paramContext == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQWiFiJsPlugin", 2, "isAppInstall:false packageInfo=null");
        }
        return false;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        paramContext = null;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiJsPlugin", 2, "isAppInstall:true");
      }
    }
    return true;
  }
  
  /* Error */
  protected boolean handleJsRequest(com.tencent.mobileqq.webview.swift.JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    // Byte code:
    //   0: ldc 8
    //   2: aload_3
    //   3: invokevirtual 68	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6: ifne +5 -> 11
    //   9: iconst_0
    //   10: ireturn
    //   11: aload 4
    //   13: invokestatic 74	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   16: ifeq +11 -> 27
    //   19: aload_1
    //   20: ldc 76
    //   22: invokevirtual 82	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/String;)V
    //   25: iconst_1
    //   26: ireturn
    //   27: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   30: ifeq +38 -> 68
    //   33: ldc 11
    //   35: iconst_2
    //   36: new 84	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   43: ldc 87
    //   45: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload_3
    //   49: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: ldc 93
    //   54: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: aload 4
    //   59: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokestatic 53	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   68: ldc 99
    //   70: aload 4
    //   72: invokevirtual 68	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   75: ifeq +543 -> 618
    //   78: new 101	org/json/JSONObject
    //   81: dup
    //   82: invokespecial 102	org/json/JSONObject:<init>	()V
    //   85: astore 4
    //   87: new 101	org/json/JSONObject
    //   90: dup
    //   91: aload 5
    //   93: iconst_0
    //   94: aaload
    //   95: invokespecial 104	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   98: ldc 106
    //   100: invokevirtual 110	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   103: istore 8
    //   105: new 101	org/json/JSONObject
    //   108: dup
    //   109: invokespecial 102	org/json/JSONObject:<init>	()V
    //   112: astore 5
    //   114: aload_0
    //   115: getfield 114	com/tencent/mobileqq/vaswebviewplugin/QQWiFiJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   118: invokevirtual 119	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   121: ldc 121
    //   123: invokevirtual 127	android/app/Activity:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   126: checkcast 129	android/telephony/TelephonyManager
    //   129: astore 6
    //   131: iload 8
    //   133: iconst_1
    //   134: iand
    //   135: ifle +13 -> 148
    //   138: aload 5
    //   140: ldc -125
    //   142: ldc -123
    //   144: invokevirtual 137	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   147: pop
    //   148: iload 8
    //   150: iconst_2
    //   151: iand
    //   152: ifle +31 -> 183
    //   155: aload 6
    //   157: ifnull +683 -> 840
    //   160: aload 6
    //   162: invokevirtual 140	android/telephony/TelephonyManager:getDeviceId	()Ljava/lang/String;
    //   165: astore_2
    //   166: ldc -114
    //   168: invokestatic 74	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   171: ifne +669 -> 840
    //   174: aload 5
    //   176: ldc -112
    //   178: aload_2
    //   179: invokevirtual 137	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   182: pop
    //   183: iload 8
    //   185: iconst_4
    //   186: iand
    //   187: ifle +21 -> 208
    //   190: aload 5
    //   192: ldc -110
    //   194: aload_0
    //   195: getfield 114	com/tencent/mobileqq/vaswebviewplugin/QQWiFiJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   198: invokevirtual 119	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   201: invokestatic 151	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/content/Context;)I
    //   204: invokevirtual 154	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   207: pop
    //   208: iload 8
    //   210: bipush 8
    //   212: iand
    //   213: ifle +62 -> 275
    //   216: ldc -100
    //   218: astore_3
    //   219: aload_3
    //   220: astore_2
    //   221: aload 6
    //   223: ifnull +43 -> 266
    //   226: aload 6
    //   228: invokevirtual 159	android/telephony/TelephonyManager:getSubscriberId	()Ljava/lang/String;
    //   231: astore 7
    //   233: aload_3
    //   234: astore_2
    //   235: aload 7
    //   237: invokestatic 74	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   240: ifne +26 -> 266
    //   243: aload 7
    //   245: ldc -95
    //   247: invokevirtual 165	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   250: ifne +596 -> 846
    //   253: aload 7
    //   255: ldc -89
    //   257: invokevirtual 165	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   260: ifeq +273 -> 533
    //   263: goto +583 -> 846
    //   266: aload 5
    //   268: ldc -87
    //   270: aload_2
    //   271: invokevirtual 137	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   274: pop
    //   275: iload 8
    //   277: bipush 16
    //   279: iand
    //   280: ifle +43 -> 323
    //   283: aload_0
    //   284: getfield 114	com/tencent/mobileqq/vaswebviewplugin/QQWiFiJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   287: invokevirtual 119	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   290: ldc -85
    //   292: invokevirtual 127	android/app/Activity:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   295: checkcast 173	android/net/wifi/WifiManager
    //   298: astore_2
    //   299: aload_2
    //   300: ifnonnull +265 -> 565
    //   303: aconst_null
    //   304: astore_2
    //   305: aload_2
    //   306: ifnull +528 -> 834
    //   309: aload_2
    //   310: invokevirtual 178	android/net/wifi/WifiInfo:getMacAddress	()Ljava/lang/String;
    //   313: astore_2
    //   314: aload 5
    //   316: ldc -76
    //   318: aload_2
    //   319: invokevirtual 137	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   322: pop
    //   323: iload 8
    //   325: bipush 32
    //   327: iand
    //   328: ifle +30 -> 358
    //   331: aload 6
    //   333: ifnull +495 -> 828
    //   336: aload 6
    //   338: invokevirtual 159	android/telephony/TelephonyManager:getSubscriberId	()Ljava/lang/String;
    //   341: astore_2
    //   342: aload_2
    //   343: invokestatic 74	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   346: ifne +482 -> 828
    //   349: aload 5
    //   351: ldc -74
    //   353: aload_2
    //   354: invokevirtual 137	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   357: pop
    //   358: iload 8
    //   360: bipush 64
    //   362: iand
    //   363: ifle +13 -> 376
    //   366: aload 5
    //   368: ldc -72
    //   370: ldc -100
    //   372: invokevirtual 137	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   375: pop
    //   376: iload 8
    //   378: sipush 128
    //   381: iand
    //   382: ifle +32 -> 414
    //   385: aload_0
    //   386: getfield 114	com/tencent/mobileqq/vaswebviewplugin/QQWiFiJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   389: invokevirtual 187	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   392: invokevirtual 192	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   395: astore_3
    //   396: aload_3
    //   397: astore_2
    //   398: aload_3
    //   399: ifnonnull +6 -> 405
    //   402: ldc -100
    //   404: astore_2
    //   405: aload 5
    //   407: ldc -62
    //   409: aload_2
    //   410: invokevirtual 137	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   413: pop
    //   414: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   417: ifeq +39 -> 456
    //   420: ldc 11
    //   422: iconst_2
    //   423: new 84	java/lang/StringBuilder
    //   426: dup
    //   427: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   430: ldc -60
    //   432: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: iload 8
    //   437: invokevirtual 199	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   440: ldc -55
    //   442: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: aload 5
    //   447: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   450: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   453: invokestatic 207	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   456: aload 5
    //   458: invokevirtual 208	org/json/JSONObject:toString	()Ljava/lang/String;
    //   461: astore_3
    //   462: iconst_0
    //   463: istore 8
    //   465: ldc -100
    //   467: astore_2
    //   468: aload 4
    //   470: ldc -46
    //   472: iload 8
    //   474: invokevirtual 154	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   477: pop
    //   478: aload 4
    //   480: ldc -44
    //   482: aload_3
    //   483: invokevirtual 137	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   486: pop
    //   487: aload 4
    //   489: ldc -42
    //   491: aload_2
    //   492: invokevirtual 137	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   495: pop
    //   496: aload_1
    //   497: aload 4
    //   499: invokevirtual 217	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   502: iconst_1
    //   503: ireturn
    //   504: astore_2
    //   505: aload_1
    //   506: new 84	java/lang/StringBuilder
    //   509: dup
    //   510: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   513: ldc -37
    //   515: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   518: aload_2
    //   519: invokevirtual 222	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   522: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   525: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   528: invokevirtual 82	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/String;)V
    //   531: iconst_1
    //   532: ireturn
    //   533: aload 7
    //   535: ldc -32
    //   537: invokevirtual 165	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   540: ifeq +9 -> 549
    //   543: ldc -30
    //   545: astore_2
    //   546: goto -280 -> 266
    //   549: aload 7
    //   551: ldc -28
    //   553: invokevirtual 165	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   556: ifeq +297 -> 853
    //   559: ldc -26
    //   561: astore_2
    //   562: goto -296 -> 266
    //   565: aload_2
    //   566: invokevirtual 234	android/net/wifi/WifiManager:getConnectionInfo	()Landroid/net/wifi/WifiInfo;
    //   569: astore_2
    //   570: goto -265 -> 305
    //   573: astore_2
    //   574: aload_2
    //   575: invokevirtual 235	org/json/JSONException:printStackTrace	()V
    //   578: new 84	java/lang/StringBuilder
    //   581: dup
    //   582: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   585: ldc -37
    //   587: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: aload_2
    //   591: invokevirtual 222	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   594: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   597: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   600: astore_2
    //   601: ldc -100
    //   603: astore_3
    //   604: iconst_1
    //   605: istore 8
    //   607: goto -139 -> 468
    //   610: astore_2
    //   611: aload_2
    //   612: invokevirtual 235	org/json/JSONException:printStackTrace	()V
    //   615: goto -119 -> 496
    //   618: ldc -19
    //   620: aload 4
    //   622: invokevirtual 68	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   625: ifeq +201 -> 826
    //   628: new 101	org/json/JSONObject
    //   631: dup
    //   632: invokespecial 102	org/json/JSONObject:<init>	()V
    //   635: astore 6
    //   637: new 101	org/json/JSONObject
    //   640: dup
    //   641: aload 5
    //   643: iconst_0
    //   644: aaload
    //   645: invokespecial 104	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   648: ldc -17
    //   650: invokevirtual 243	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   653: astore_3
    //   654: aload_3
    //   655: invokestatic 74	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   658: ifne +148 -> 806
    //   661: aload_0
    //   662: aload_0
    //   663: getfield 114	com/tencent/mobileqq/vaswebviewplugin/QQWiFiJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   666: invokevirtual 119	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   669: aload_3
    //   670: invokespecial 245	com/tencent/mobileqq/vaswebviewplugin/QQWiFiJsPlugin:isAppInstall	(Landroid/content/Context;Ljava/lang/String;)Z
    //   673: ifeq +127 -> 800
    //   676: ldc -9
    //   678: astore_2
    //   679: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   682: ifeq +37 -> 719
    //   685: ldc 11
    //   687: iconst_2
    //   688: new 84	java/lang/StringBuilder
    //   691: dup
    //   692: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   695: ldc -7
    //   697: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   700: aload_3
    //   701: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   704: ldc -5
    //   706: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   709: aload_2
    //   710: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   713: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   716: invokestatic 53	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   719: iconst_0
    //   720: istore 8
    //   722: ldc -100
    //   724: astore 4
    //   726: aload_2
    //   727: astore_3
    //   728: aload 4
    //   730: astore_2
    //   731: aload 6
    //   733: ldc -46
    //   735: iload 8
    //   737: invokevirtual 154	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   740: pop
    //   741: aload 6
    //   743: ldc -44
    //   745: aload_3
    //   746: invokevirtual 137	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   749: pop
    //   750: aload 6
    //   752: ldc -42
    //   754: aload_2
    //   755: invokevirtual 137	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   758: pop
    //   759: aload_1
    //   760: aload 6
    //   762: invokevirtual 217	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   765: iconst_1
    //   766: ireturn
    //   767: astore_2
    //   768: aload_2
    //   769: invokevirtual 235	org/json/JSONException:printStackTrace	()V
    //   772: aload_1
    //   773: new 84	java/lang/StringBuilder
    //   776: dup
    //   777: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   780: ldc -37
    //   782: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   785: aload_2
    //   786: invokevirtual 222	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   789: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   792: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   795: invokevirtual 82	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/String;)V
    //   798: iconst_1
    //   799: ireturn
    //   800: ldc -3
    //   802: astore_2
    //   803: goto -124 -> 679
    //   806: ldc -1
    //   808: astore_2
    //   809: ldc -100
    //   811: astore_3
    //   812: iconst_1
    //   813: istore 8
    //   815: goto -84 -> 731
    //   818: astore_2
    //   819: aload_2
    //   820: invokevirtual 235	org/json/JSONException:printStackTrace	()V
    //   823: goto -64 -> 759
    //   826: iconst_0
    //   827: ireturn
    //   828: ldc -100
    //   830: astore_2
    //   831: goto -482 -> 349
    //   834: ldc -100
    //   836: astore_2
    //   837: goto -523 -> 314
    //   840: ldc -100
    //   842: astore_2
    //   843: goto -669 -> 174
    //   846: ldc_w 257
    //   849: astore_2
    //   850: goto -584 -> 266
    //   853: ldc_w 259
    //   856: astore_2
    //   857: goto -591 -> 266
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	860	0	this	QQWiFiJsPlugin
    //   0	860	1	paramJsBridgeListener	com.tencent.mobileqq.webview.swift.JsBridgeListener
    //   0	860	2	paramString1	String
    //   0	860	3	paramString2	String
    //   0	860	4	paramString3	String
    //   0	860	5	paramVarArgs	String[]
    //   129	632	6	localObject	Object
    //   231	319	7	str	String
    //   103	711	8	i	int
    // Exception table:
    //   from	to	target	type
    //   87	105	504	org/json/JSONException
    //   114	131	573	org/json/JSONException
    //   138	148	573	org/json/JSONException
    //   160	174	573	org/json/JSONException
    //   174	183	573	org/json/JSONException
    //   190	208	573	org/json/JSONException
    //   226	233	573	org/json/JSONException
    //   235	263	573	org/json/JSONException
    //   266	275	573	org/json/JSONException
    //   283	299	573	org/json/JSONException
    //   309	314	573	org/json/JSONException
    //   314	323	573	org/json/JSONException
    //   336	349	573	org/json/JSONException
    //   349	358	573	org/json/JSONException
    //   366	376	573	org/json/JSONException
    //   385	396	573	org/json/JSONException
    //   405	414	573	org/json/JSONException
    //   414	456	573	org/json/JSONException
    //   456	462	573	org/json/JSONException
    //   533	543	573	org/json/JSONException
    //   549	559	573	org/json/JSONException
    //   565	570	573	org/json/JSONException
    //   468	496	610	org/json/JSONException
    //   637	654	767	org/json/JSONException
    //   731	759	818	org/json/JSONException
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vaswebviewplugin\QQWiFiJsPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */