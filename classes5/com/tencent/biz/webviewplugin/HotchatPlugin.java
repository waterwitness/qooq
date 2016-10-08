package com.tencent.biz.webviewplugin;

import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import jhb;

public class HotchatPlugin
  extends WebViewPlugin
{
  public static final String a = "HotchatPlugin";
  public static final String b = "hotchat";
  public static final String c = "joinHotchat";
  public static final String d = "get8a3Info";
  public static final String e = "refreshList";
  public static final String f = "getHotChatBannerHeight";
  public static final String g = "setRightButton";
  public static final String h = "getHasFavorite";
  public static final String i = "updateFavoriteFlag";
  public static final String j = "updateSchoolName";
  public static final String k = "getBigData";
  public static final String l = "加入热聊失败，请稍后再试。";
  public static final String m = "key_action";
  public static final String n = "key_uin";
  public static final String o = "key_favorite_flag";
  private Client.onRemoteRespObserver a;
  
  public HotchatPlugin()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new jhb(this);
    this.mPluginNameSpace = "hotchat";
  }
  
  /* Error */
  protected boolean handleJsRequest(com.tencent.mobileqq.webview.swift.JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    // Byte code:
    //   0: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +41 -> 44
    //   6: ldc 8
    //   8: iconst_2
    //   9: new 87	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   16: ldc 90
    //   18: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload 4
    //   23: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: ldc 96
    //   28: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: aload 5
    //   33: iconst_0
    //   34: aaload
    //   35: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   44: ldc 11
    //   46: aload_3
    //   47: invokevirtual 109	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   50: ifeq +235 -> 285
    //   53: ldc 26
    //   55: aload 4
    //   57: invokevirtual 113	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   60: ifeq +159 -> 219
    //   63: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   66: ifeq +29 -> 95
    //   69: ldc 8
    //   71: iconst_2
    //   72: new 87	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   79: ldc 26
    //   81: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: aload 5
    //   86: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokestatic 118	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   95: aload 5
    //   97: ifnull +1376 -> 1473
    //   100: aload 5
    //   102: arraylength
    //   103: ifle +1370 -> 1473
    //   106: new 120	org/json/JSONObject
    //   109: dup
    //   110: aload 5
    //   112: iconst_0
    //   113: aaload
    //   114: invokespecial 123	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   117: ldc 125
    //   119: invokevirtual 129	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   122: astore_1
    //   123: aload_0
    //   124: getfield 133	com/tencent/biz/webviewplugin/HotchatPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   127: invokevirtual 138	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   130: astore_2
    //   131: aload_2
    //   132: ifnull +1341 -> 1473
    //   135: aload_2
    //   136: instanceof 140
    //   139: ifeq +1334 -> 1473
    //   142: aload_2
    //   143: checkcast 140	com/tencent/mobileqq/activity/NearbyActivity
    //   146: iconst_2
    //   147: invokevirtual 143	com/tencent/mobileqq/activity/NearbyActivity:a	(I)Lcom/tencent/mobileqq/fragment/NearbyBaseFragment;
    //   150: astore_2
    //   151: aload_2
    //   152: ifnull +1321 -> 1473
    //   155: aload_2
    //   156: instanceof 145
    //   159: ifeq +1314 -> 1473
    //   162: aload_1
    //   163: invokestatic 151	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   166: ifeq +14 -> 180
    //   169: aload_2
    //   170: checkcast 145	com/tencent/mobileqq/fragment/HotChatFragment
    //   173: aconst_null
    //   174: invokevirtual 154	com/tencent/mobileqq/fragment/HotChatFragment:a	(Landroid/view/View$OnClickListener;)V
    //   177: goto +1296 -> 1473
    //   180: aload_2
    //   181: checkcast 145	com/tencent/mobileqq/fragment/HotChatFragment
    //   184: new 156	jgz
    //   187: dup
    //   188: aload_0
    //   189: aload_1
    //   190: invokespecial 159	jgz:<init>	(Lcom/tencent/biz/webviewplugin/HotchatPlugin;Ljava/lang/String;)V
    //   193: invokevirtual 154	com/tencent/mobileqq/fragment/HotChatFragment:a	(Landroid/view/View$OnClickListener;)V
    //   196: goto +1277 -> 1473
    //   199: astore_1
    //   200: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   203: ifeq +1270 -> 1473
    //   206: ldc 8
    //   208: iconst_2
    //   209: aload_1
    //   210: invokevirtual 162	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   213: invokestatic 118	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   216: goto +1257 -> 1473
    //   219: ldc 14
    //   221: aload 4
    //   223: invokevirtual 109	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   226: ifeq +30 -> 256
    //   229: aload 5
    //   231: ifnull +23 -> 254
    //   234: aload 5
    //   236: arraylength
    //   237: ifle +17 -> 254
    //   240: aload_0
    //   241: getfield 133	com/tencent/biz/webviewplugin/HotchatPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   244: invokevirtual 138	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   247: aload 5
    //   249: iconst_0
    //   250: aaload
    //   251: invokestatic 167	com/tencent/mobileqq/dating/NearbyTransitActivity:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   254: iconst_1
    //   255: ireturn
    //   256: ldc 20
    //   258: aload 4
    //   260: invokevirtual 113	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   263: ifeq +24 -> 287
    //   266: aload_0
    //   267: getfield 133	com/tencent/biz/webviewplugin/HotchatPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   270: invokevirtual 138	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   273: new 169	android/content/Intent
    //   276: dup
    //   277: ldc -85
    //   279: invokespecial 172	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   282: invokevirtual 178	android/app/Activity:sendBroadcast	(Landroid/content/Intent;)V
    //   285: iconst_0
    //   286: ireturn
    //   287: ldc 23
    //   289: aload 4
    //   291: invokevirtual 113	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   294: ifeq +48 -> 342
    //   297: aload 5
    //   299: iconst_0
    //   300: aaload
    //   301: invokestatic 151	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   304: ifne -19 -> 285
    //   307: new 169	android/content/Intent
    //   310: dup
    //   311: ldc -76
    //   313: invokespecial 172	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   316: astore_1
    //   317: aload_1
    //   318: ldc -74
    //   320: aload 5
    //   322: iconst_0
    //   323: aaload
    //   324: invokevirtual 186	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   327: pop
    //   328: aload_0
    //   329: getfield 133	com/tencent/biz/webviewplugin/HotchatPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   332: invokevirtual 138	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   335: aload_1
    //   336: invokevirtual 178	android/app/Activity:sendBroadcast	(Landroid/content/Intent;)V
    //   339: goto -54 -> 285
    //   342: ldc 17
    //   344: aload 4
    //   346: invokevirtual 109	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   349: ifeq +23 -> 372
    //   352: invokestatic 191	com/tencent/mobileqq/app/ThreadManager:a	()Lmqq/os/MqqHandler;
    //   355: new 193	jha
    //   358: dup
    //   359: aload_0
    //   360: aload 5
    //   362: invokespecial 196	jha:<init>	(Lcom/tencent/biz/webviewplugin/HotchatPlugin;[Ljava/lang/String;)V
    //   365: invokevirtual 202	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   368: pop
    //   369: goto -84 -> 285
    //   372: ldc 29
    //   374: aload 4
    //   376: invokevirtual 109	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   379: ifeq +142 -> 521
    //   382: aload_0
    //   383: getfield 133	com/tencent/biz/webviewplugin/HotchatPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   386: invokevirtual 205	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   389: invokevirtual 210	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   392: ldc -44
    //   394: iconst_0
    //   395: invokestatic 218	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   398: invokestatic 223	com/tencent/mobileqq/nearby/NearbySPUtil:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   401: checkcast 214	java/lang/Boolean
    //   404: invokevirtual 226	java/lang/Boolean:booleanValue	()Z
    //   407: istore 15
    //   409: aconst_null
    //   410: astore_2
    //   411: aload_2
    //   412: astore_1
    //   413: aload 5
    //   415: ifnull +28 -> 443
    //   418: aload_2
    //   419: astore_1
    //   420: aload 5
    //   422: arraylength
    //   423: ifle +20 -> 443
    //   426: new 120	org/json/JSONObject
    //   429: dup
    //   430: aload 5
    //   432: iconst_0
    //   433: aaload
    //   434: invokespecial 123	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   437: ldc 125
    //   439: invokevirtual 229	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   442: astore_1
    //   443: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   446: ifeq +28 -> 474
    //   449: ldc 8
    //   451: iconst_2
    //   452: new 87	java/lang/StringBuilder
    //   455: dup
    //   456: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   459: ldc -25
    //   461: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: aload_1
    //   465: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   471: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   474: aload_1
    //   475: invokestatic 151	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   478: ifne -193 -> 285
    //   481: iload 15
    //   483: ifeq +32 -> 515
    //   486: ldc -23
    //   488: astore_2
    //   489: aload_0
    //   490: aload_1
    //   491: iconst_1
    //   492: anewarray 105	java/lang/String
    //   495: dup
    //   496: iconst_0
    //   497: aload_2
    //   498: aastore
    //   499: invokevirtual 237	com/tencent/biz/webviewplugin/HotchatPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   502: goto -217 -> 285
    //   505: astore_1
    //   506: aload_1
    //   507: invokevirtual 240	org/json/JSONException:printStackTrace	()V
    //   510: aload_2
    //   511: astore_1
    //   512: goto -69 -> 443
    //   515: ldc -14
    //   517: astore_2
    //   518: goto -29 -> 489
    //   521: ldc 32
    //   523: aload 4
    //   525: invokevirtual 109	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   528: ifeq +275 -> 803
    //   531: aconst_null
    //   532: astore 6
    //   534: aconst_null
    //   535: astore_3
    //   536: aconst_null
    //   537: astore 4
    //   539: aconst_null
    //   540: astore 7
    //   542: iconst_0
    //   543: istore 16
    //   545: iload 16
    //   547: istore 15
    //   549: aload 7
    //   551: astore_2
    //   552: aload_3
    //   553: astore_1
    //   554: aload 5
    //   556: ifnull +99 -> 655
    //   559: iload 16
    //   561: istore 15
    //   563: aload 7
    //   565: astore_2
    //   566: aload_3
    //   567: astore_1
    //   568: aload 5
    //   570: arraylength
    //   571: ifle +84 -> 655
    //   574: aload 4
    //   576: astore_2
    //   577: aload 6
    //   579: astore_3
    //   580: new 120	org/json/JSONObject
    //   583: dup
    //   584: aload 5
    //   586: iconst_0
    //   587: aaload
    //   588: invokespecial 123	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   591: astore 5
    //   593: aload 4
    //   595: astore_2
    //   596: aload 6
    //   598: astore_3
    //   599: aload 5
    //   601: ldc 125
    //   603: invokevirtual 229	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   606: astore_1
    //   607: aload 4
    //   609: astore_2
    //   610: aload_1
    //   611: astore_3
    //   612: aload 5
    //   614: ldc -12
    //   616: invokevirtual 229	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   619: astore 4
    //   621: aload 4
    //   623: invokestatic 249	java/net/URLDecoder:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   626: astore_2
    //   627: aload_2
    //   628: astore 4
    //   630: aload 4
    //   632: astore_2
    //   633: aload_1
    //   634: astore_3
    //   635: aload 5
    //   637: ldc -5
    //   639: invokevirtual 255	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   642: istore 9
    //   644: iload 9
    //   646: ifne +132 -> 778
    //   649: iconst_0
    //   650: istore 15
    //   652: aload 4
    //   654: astore_2
    //   655: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   658: ifeq +49 -> 707
    //   661: ldc 8
    //   663: iconst_2
    //   664: new 87	java/lang/StringBuilder
    //   667: dup
    //   668: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   671: ldc -25
    //   673: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   676: aload_1
    //   677: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   680: ldc_w 257
    //   683: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   686: aload_2
    //   687: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   690: ldc_w 259
    //   693: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   696: iload 15
    //   698: invokevirtual 262	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   701: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   704: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   707: aload_2
    //   708: invokestatic 151	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   711: ifne -426 -> 285
    //   714: aload_1
    //   715: invokestatic 151	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   718: ifne -433 -> 285
    //   721: new 264	android/os/Bundle
    //   724: dup
    //   725: invokespecial 265	android/os/Bundle:<init>	()V
    //   728: astore_3
    //   729: aload_3
    //   730: ldc 47
    //   732: aload_2
    //   733: invokevirtual 269	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   736: aload_3
    //   737: ldc 44
    //   739: ldc 32
    //   741: invokevirtual 269	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   744: aload_3
    //   745: ldc 50
    //   747: iload 15
    //   749: invokevirtual 273	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   752: ldc_w 275
    //   755: aload_1
    //   756: aload_0
    //   757: getfield 68	com/tencent/biz/webviewplugin/HotchatPlugin:a	Lcom/tencent/mobileqq/emosm/Client$onRemoteRespObserver;
    //   760: getfield 281	com/tencent/mobileqq/emosm/Client$onRemoteRespObserver:key	I
    //   763: aload_3
    //   764: invokestatic 286	com/tencent/mobileqq/emosm/DataFactory:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   767: astore_1
    //   768: invokestatic 291	com/tencent/mobileqq/emosm/web/WebIPCOperator:a	()Lcom/tencent/mobileqq/emosm/web/WebIPCOperator;
    //   771: aload_1
    //   772: invokevirtual 294	com/tencent/mobileqq/emosm/web/WebIPCOperator:a	(Landroid/os/Bundle;)V
    //   775: goto -490 -> 285
    //   778: iconst_1
    //   779: istore 15
    //   781: aload 4
    //   783: astore_2
    //   784: goto -129 -> 655
    //   787: astore 4
    //   789: aload_3
    //   790: astore_1
    //   791: aload 4
    //   793: invokevirtual 240	org/json/JSONException:printStackTrace	()V
    //   796: iload 16
    //   798: istore 15
    //   800: goto -145 -> 655
    //   803: ldc 35
    //   805: aload 4
    //   807: invokevirtual 109	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   810: ifeq +280 -> 1090
    //   813: aload_0
    //   814: getfield 133	com/tencent/biz/webviewplugin/HotchatPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   817: invokevirtual 205	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   820: astore 8
    //   822: aconst_null
    //   823: astore 6
    //   825: aconst_null
    //   826: astore_3
    //   827: aconst_null
    //   828: astore 7
    //   830: aconst_null
    //   831: astore 4
    //   833: aload 7
    //   835: astore_1
    //   836: aload 6
    //   838: astore_2
    //   839: aload 5
    //   841: ifnull +210 -> 1051
    //   844: aload 7
    //   846: astore_1
    //   847: aload 6
    //   849: astore_2
    //   850: aload 5
    //   852: arraylength
    //   853: ifle +198 -> 1051
    //   856: aload 4
    //   858: astore_1
    //   859: aload_3
    //   860: astore_2
    //   861: new 120	org/json/JSONObject
    //   864: dup
    //   865: aload 5
    //   867: iconst_0
    //   868: aaload
    //   869: invokespecial 123	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   872: astore 6
    //   874: aload 4
    //   876: astore_1
    //   877: aload_3
    //   878: astore_2
    //   879: aload 6
    //   881: ldc_w 296
    //   884: invokevirtual 229	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   887: astore_3
    //   888: aload 4
    //   890: astore_1
    //   891: aload_3
    //   892: astore_2
    //   893: aload 6
    //   895: ldc_w 298
    //   898: invokevirtual 229	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   901: astore 4
    //   903: aload 4
    //   905: astore_1
    //   906: aload_3
    //   907: astore_2
    //   908: aload 6
    //   910: ldc_w 300
    //   913: invokevirtual 229	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   916: astore 6
    //   918: aload_3
    //   919: astore_2
    //   920: aload 4
    //   922: astore_1
    //   923: aload 6
    //   925: astore_3
    //   926: aload 8
    //   928: ifnull +56 -> 984
    //   931: aload_1
    //   932: ifnull +52 -> 984
    //   935: aload_2
    //   936: ifnull +48 -> 984
    //   939: ldc_w 302
    //   942: aload_2
    //   943: invokevirtual 113	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   946: ifeq +112 -> 1058
    //   949: aload 8
    //   951: invokevirtual 304	com/tencent/common/app/AppInterface:a	()Ljava/lang/String;
    //   954: ldc_w 306
    //   957: aload_1
    //   958: invokestatic 309	com/tencent/mobileqq/nearby/NearbySPUtil:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   961: pop
    //   962: aload 8
    //   964: invokevirtual 304	com/tencent/common/app/AppInterface:a	()Ljava/lang/String;
    //   967: ldc_w 311
    //   970: ldc_w 313
    //   973: aload_3
    //   974: invokevirtual 316	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   977: invokestatic 218	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   980: invokestatic 309	com/tencent/mobileqq/nearby/NearbySPUtil:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   983: pop
    //   984: invokestatic 320	com/tencent/mobileqq/nearby/NearbyUtils:b	()Z
    //   987: ifeq -702 -> 285
    //   990: aload 5
    //   992: ifnull +9 -> 1001
    //   995: aload 5
    //   997: arraylength
    //   998: ifne +83 -> 1081
    //   1001: ldc_w 322
    //   1004: astore 4
    //   1006: ldc 8
    //   1008: bipush 6
    //   1010: anewarray 324	java/lang/Object
    //   1013: dup
    //   1014: iconst_0
    //   1015: ldc 35
    //   1017: aastore
    //   1018: dup
    //   1019: iconst_1
    //   1020: aload 8
    //   1022: aastore
    //   1023: dup
    //   1024: iconst_2
    //   1025: aload_2
    //   1026: aastore
    //   1027: dup
    //   1028: iconst_3
    //   1029: aload_1
    //   1030: aastore
    //   1031: dup
    //   1032: iconst_4
    //   1033: aload_3
    //   1034: aastore
    //   1035: dup
    //   1036: iconst_5
    //   1037: aload 4
    //   1039: aastore
    //   1040: invokestatic 327	com/tencent/mobileqq/nearby/NearbyUtils:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1043: goto -758 -> 285
    //   1046: astore_3
    //   1047: aload_3
    //   1048: invokevirtual 328	java/lang/Exception:printStackTrace	()V
    //   1051: ldc_w 313
    //   1054: astore_3
    //   1055: goto -129 -> 926
    //   1058: aload_1
    //   1059: invokestatic 151	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1062: ifne -78 -> 984
    //   1065: aload 8
    //   1067: invokevirtual 304	com/tencent/common/app/AppInterface:a	()Ljava/lang/String;
    //   1070: ldc_w 330
    //   1073: aload_1
    //   1074: invokestatic 309	com/tencent/mobileqq/nearby/NearbySPUtil:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   1077: pop
    //   1078: goto -94 -> 984
    //   1081: aload 5
    //   1083: iconst_0
    //   1084: aaload
    //   1085: astore 4
    //   1087: goto -81 -> 1006
    //   1090: ldc 38
    //   1092: aload 4
    //   1094: invokevirtual 109	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1097: ifeq +336 -> 1433
    //   1100: aload_0
    //   1101: getfield 133	com/tencent/biz/webviewplugin/HotchatPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1104: invokevirtual 205	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   1107: astore 7
    //   1109: iconst_0
    //   1110: istore 11
    //   1112: iconst_0
    //   1113: istore 13
    //   1115: iconst_0
    //   1116: istore 12
    //   1118: iconst_0
    //   1119: istore 14
    //   1121: aconst_null
    //   1122: astore_3
    //   1123: aconst_null
    //   1124: astore 6
    //   1126: aconst_null
    //   1127: astore 4
    //   1129: iload 13
    //   1131: istore 9
    //   1133: iload 14
    //   1135: istore 10
    //   1137: aload 6
    //   1139: astore_1
    //   1140: aload 4
    //   1142: astore_2
    //   1143: aload 5
    //   1145: ifnull +128 -> 1273
    //   1148: iload 13
    //   1150: istore 9
    //   1152: iload 14
    //   1154: istore 10
    //   1156: aload 6
    //   1158: astore_1
    //   1159: aload 4
    //   1161: astore_2
    //   1162: aload 5
    //   1164: arraylength
    //   1165: ifle +108 -> 1273
    //   1168: iload 11
    //   1170: istore 9
    //   1172: iload 12
    //   1174: istore 10
    //   1176: aload_3
    //   1177: astore_1
    //   1178: new 120	org/json/JSONObject
    //   1181: dup
    //   1182: aload 5
    //   1184: iconst_0
    //   1185: aaload
    //   1186: invokespecial 123	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1189: astore_2
    //   1190: iload 11
    //   1192: istore 9
    //   1194: iload 12
    //   1196: istore 10
    //   1198: aload_3
    //   1199: astore_1
    //   1200: aload_2
    //   1201: ldc_w 332
    //   1204: invokevirtual 229	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1207: astore_3
    //   1208: iload 11
    //   1210: istore 9
    //   1212: iload 12
    //   1214: istore 10
    //   1216: aload_3
    //   1217: astore_1
    //   1218: aload_2
    //   1219: ldc_w 334
    //   1222: invokevirtual 255	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1225: istore 11
    //   1227: iload 11
    //   1229: istore 9
    //   1231: iload 12
    //   1233: istore 10
    //   1235: aload_3
    //   1236: astore_1
    //   1237: aload_2
    //   1238: ldc_w 336
    //   1241: invokevirtual 255	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1244: istore 12
    //   1246: iload 11
    //   1248: istore 9
    //   1250: iload 12
    //   1252: istore 10
    //   1254: aload_3
    //   1255: astore_1
    //   1256: aload_2
    //   1257: ldc 125
    //   1259: invokevirtual 229	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1262: astore_2
    //   1263: aload_3
    //   1264: astore_1
    //   1265: iload 12
    //   1267: istore 10
    //   1269: iload 11
    //   1271: istore 9
    //   1273: aload_1
    //   1274: invokestatic 151	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1277: ifeq +141 -> 1418
    //   1280: ldc_w 338
    //   1283: astore_3
    //   1284: new 120	org/json/JSONObject
    //   1287: dup
    //   1288: invokespecial 339	org/json/JSONObject:<init>	()V
    //   1291: astore 4
    //   1293: aload 4
    //   1295: ldc_w 341
    //   1298: iconst_m1
    //   1299: invokevirtual 345	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1302: pop
    //   1303: aload 4
    //   1305: ldc_w 347
    //   1308: ldc_w 338
    //   1311: invokevirtual 350	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1314: pop
    //   1315: aload 4
    //   1317: ldc_w 352
    //   1320: ldc_w 354
    //   1323: invokevirtual 350	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1326: pop
    //   1327: aload 4
    //   1329: invokevirtual 355	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1332: astore 4
    //   1334: aload 4
    //   1336: astore_3
    //   1337: aload_0
    //   1338: aload_2
    //   1339: iconst_1
    //   1340: anewarray 105	java/lang/String
    //   1343: dup
    //   1344: iconst_0
    //   1345: aload_3
    //   1346: aastore
    //   1347: invokevirtual 237	com/tencent/biz/webviewplugin/HotchatPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1350: invokestatic 320	com/tencent/mobileqq/nearby/NearbyUtils:b	()Z
    //   1353: ifeq -1068 -> 285
    //   1356: ldc 8
    //   1358: iconst_5
    //   1359: anewarray 324	java/lang/Object
    //   1362: dup
    //   1363: iconst_0
    //   1364: ldc 38
    //   1366: aastore
    //   1367: dup
    //   1368: iconst_1
    //   1369: iload 9
    //   1371: invokestatic 360	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1374: aastore
    //   1375: dup
    //   1376: iconst_2
    //   1377: iload 10
    //   1379: invokestatic 360	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1382: aastore
    //   1383: dup
    //   1384: iconst_3
    //   1385: aload_1
    //   1386: aastore
    //   1387: dup
    //   1388: iconst_4
    //   1389: aload_2
    //   1390: aastore
    //   1391: invokestatic 327	com/tencent/mobileqq/nearby/NearbyUtils:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1394: goto -1109 -> 285
    //   1397: astore_2
    //   1398: aload_2
    //   1399: invokevirtual 328	java/lang/Exception:printStackTrace	()V
    //   1402: aload 4
    //   1404: astore_2
    //   1405: goto -132 -> 1273
    //   1408: astore 4
    //   1410: aload 4
    //   1412: invokevirtual 328	java/lang/Exception:printStackTrace	()V
    //   1415: goto -78 -> 1337
    //   1418: aload 7
    //   1420: iload 9
    //   1422: iload 10
    //   1424: aload_1
    //   1425: aload_0
    //   1426: aload_2
    //   1427: invokestatic 365	com/tencent/mobileqq/nearby/NearbyAlumniServlet:a	(Lcom/tencent/common/app/AppInterface;IILjava/lang/String;Ljava/lang/Object;Ljava/lang/String;)V
    //   1430: goto -80 -> 1350
    //   1433: ldc 8
    //   1435: iconst_1
    //   1436: new 87	java/lang/StringBuilder
    //   1439: dup
    //   1440: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   1443: ldc_w 367
    //   1446: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1449: aload 4
    //   1451: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1454: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1457: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1460: goto -1175 -> 285
    //   1463: astore_3
    //   1464: aload 4
    //   1466: astore_2
    //   1467: aload_3
    //   1468: astore 4
    //   1470: goto -679 -> 791
    //   1473: iconst_1
    //   1474: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1475	0	this	HotchatPlugin
    //   0	1475	1	paramJsBridgeListener	com.tencent.mobileqq.webview.swift.JsBridgeListener
    //   0	1475	2	paramString1	String
    //   0	1475	3	paramString2	String
    //   0	1475	4	paramString3	String
    //   0	1475	5	paramVarArgs	String[]
    //   532	625	6	localObject	Object
    //   540	879	7	localAppInterface1	com.tencent.common.app.AppInterface
    //   820	246	8	localAppInterface2	com.tencent.common.app.AppInterface
    //   642	779	9	i1	int
    //   1135	288	10	i2	int
    //   1110	160	11	i3	int
    //   1116	150	12	i4	int
    //   1113	36	13	i5	int
    //   1119	34	14	i6	int
    //   407	392	15	bool1	boolean
    //   543	254	16	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   106	131	199	org/json/JSONException
    //   135	151	199	org/json/JSONException
    //   155	177	199	org/json/JSONException
    //   180	196	199	org/json/JSONException
    //   426	443	505	org/json/JSONException
    //   580	593	787	org/json/JSONException
    //   599	607	787	org/json/JSONException
    //   612	621	787	org/json/JSONException
    //   635	644	787	org/json/JSONException
    //   861	874	1046	java/lang/Exception
    //   879	888	1046	java/lang/Exception
    //   893	903	1046	java/lang/Exception
    //   908	918	1046	java/lang/Exception
    //   1178	1190	1397	java/lang/Exception
    //   1200	1208	1397	java/lang/Exception
    //   1218	1227	1397	java/lang/Exception
    //   1237	1246	1397	java/lang/Exception
    //   1256	1263	1397	java/lang/Exception
    //   1284	1334	1408	java/lang/Exception
    //   621	627	1463	org/json/JSONException
  }
  
  protected void onCreate()
  {
    WebIPCOperator.a().a(this.a);
  }
  
  protected void onDestroy()
  {
    WebIPCOperator.a().b(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\webviewplugin\HotchatPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */