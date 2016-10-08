package com.tencent.mobileqq.vashealth;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.jsp.WebSSOAgentServlet;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReq;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReqComm;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
import com.tencent.smtt.sdk.CookieManager;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.json.JSONArray;
import org.json.JSONObject;
import wfd;
import wfe;
import wff;

public class HealthStepCounterPlugin
  extends VasWebviewJsPlugin
{
  public static long a = 0L;
  public static final String a = "healthkit";
  static final String b = "HealthStepCounterPlugin";
  public static final String c = "HealthStepCounterJs";
  static String d;
  static String e;
  private static final String i = "httpagent_sh.http";
  protected Activity a;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private CookieManager jdField_a_of_type_ComTencentSmttSdkCookieManager;
  public HashMap a;
  public AtomicBoolean a;
  private BusinessObserver jdField_a_of_type_MqqObserverBusinessObserver;
  public HashMap b;
  public HashMap c;
  public String f;
  public String g;
  public String h;
  
  public HealthStepCounterPlugin()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.b = new HashMap();
    this.c = new HashMap();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.f = null;
    this.g = null;
    this.h = null;
    this.jdField_a_of_type_MqqObserverBusinessObserver = new wfe(this);
    this.mPluginNameSpace = "healthkit";
  }
  
  private int a(String paramString)
  {
    int m = 0;
    int k = 5381;
    String str = "";
    String[] arrayOfString = paramString.split(";");
    paramString = str;
    int n;
    int j;
    if (arrayOfString.length > 0)
    {
      n = arrayOfString.length;
      j = 0;
    }
    for (;;)
    {
      paramString = str;
      if (j < n)
      {
        paramString = arrayOfString[j];
        if (paramString.indexOf("skey") > 0)
        {
          paramString = paramString.split("=");
          if (paramString.length == 2) {
            paramString = paramString[1];
          }
        }
      }
      else
      {
        n = paramString.length();
        j = m;
        while (j < n)
        {
          k += (k << 5) + paramString.charAt(j);
          j += 1;
        }
      }
      j += 1;
    }
    return 0x7FFFFFFF & k;
  }
  
  /* Error */
  private void a(String paramString)
  {
    // Byte code:
    //   0: invokestatic 121	java/lang/System:currentTimeMillis	()J
    //   3: lstore 8
    //   5: aload_0
    //   6: getfield 125	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   9: ifnull +687 -> 696
    //   12: aload_0
    //   13: getfield 127	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   16: ifnull +680 -> 696
    //   19: aload_0
    //   20: getfield 125	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   23: invokevirtual 132	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   26: astore_2
    //   27: aload_2
    //   28: iconst_1
    //   29: invokevirtual 137	com/tencent/biz/pubaccount/CustomWebView:setDrawingCacheEnabled	(Z)V
    //   32: aload_2
    //   33: invokevirtual 141	com/tencent/biz/pubaccount/CustomWebView:getDrawingCache	()Landroid/graphics/Bitmap;
    //   36: astore_3
    //   37: new 143	org/json/JSONObject
    //   40: dup
    //   41: aload_1
    //   42: invokespecial 145	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   45: astore_1
    //   46: aload_1
    //   47: ldc -109
    //   49: invokevirtual 151	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   52: astore 4
    //   54: aload 4
    //   56: invokestatic 157	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   59: ifeq +4 -> 63
    //   62: return
    //   63: aload_1
    //   64: ldc -97
    //   66: invokevirtual 162	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   69: istore 7
    //   71: getstatic 168	android/os/Build$VERSION:SDK_INT	I
    //   74: bipush 8
    //   76: if_icmplt +297 -> 373
    //   79: aload_0
    //   80: getfield 127	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   83: invokevirtual 174	android/app/Activity:getExternalCacheDir	()Ljava/io/File;
    //   86: astore_1
    //   87: aload_1
    //   88: astore_2
    //   89: aload_1
    //   90: ifnonnull +11 -> 101
    //   93: aload_0
    //   94: getfield 127	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   97: invokevirtual 177	android/app/Activity:getCacheDir	()Ljava/io/File;
    //   100: astore_2
    //   101: new 179	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   108: aload_2
    //   109: invokevirtual 186	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   112: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: getstatic 193	java/io/File:separator	Ljava/lang/String;
    //   118: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: invokestatic 121	java/lang/System:currentTimeMillis	()J
    //   124: invokevirtual 196	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   127: ldc -58
    //   129: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: astore 5
    //   137: new 182	java/io/File
    //   140: dup
    //   141: aload 5
    //   143: invokespecial 202	java/io/File:<init>	(Ljava/lang/String;)V
    //   146: astore_1
    //   147: aload_1
    //   148: ifnull +542 -> 690
    //   151: new 204	java/io/FileOutputStream
    //   154: dup
    //   155: aload_1
    //   156: invokespecial 207	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   159: astore_2
    //   160: aload_2
    //   161: astore_1
    //   162: aload_3
    //   163: getstatic 213	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   166: bipush 80
    //   168: aload_2
    //   169: invokevirtual 219	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   172: istore 11
    //   174: aload_2
    //   175: astore_1
    //   176: aload_0
    //   177: getfield 221	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   180: ifnull +517 -> 697
    //   183: aload_2
    //   184: astore_1
    //   185: aload_0
    //   186: getfield 221	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   189: invokevirtual 227	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   192: ifeq +505 -> 697
    //   195: aload_2
    //   196: astore_1
    //   197: aload_0
    //   198: getfield 221	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   201: invokevirtual 230	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   204: goto +493 -> 697
    //   207: aload_2
    //   208: astore_1
    //   209: invokestatic 235	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   212: ifeq +35 -> 247
    //   215: aload_2
    //   216: astore_1
    //   217: ldc 14
    //   219: iconst_2
    //   220: new 179	java/lang/StringBuilder
    //   223: dup
    //   224: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   227: ldc -19
    //   229: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: invokestatic 121	java/lang/System:currentTimeMillis	()J
    //   235: lload 8
    //   237: lsub
    //   238: invokevirtual 196	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   241: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: invokestatic 240	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   247: iload 11
    //   249: istore 10
    //   251: aload_2
    //   252: ifnull +11 -> 263
    //   255: aload_2
    //   256: invokevirtual 243	java/io/FileOutputStream:close	()V
    //   259: iload 11
    //   261: istore 10
    //   263: new 143	org/json/JSONObject
    //   266: dup
    //   267: invokespecial 244	org/json/JSONObject:<init>	()V
    //   270: astore_1
    //   271: iload 10
    //   273: ifeq +357 -> 630
    //   276: aload_1
    //   277: ldc -10
    //   279: iconst_0
    //   280: invokevirtual 250	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   283: pop
    //   284: aload_1
    //   285: ldc -4
    //   287: ldc -2
    //   289: invokevirtual 257	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   292: pop
    //   293: aload_1
    //   294: ldc_w 259
    //   297: aload 5
    //   299: invokevirtual 257	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   302: pop
    //   303: invokestatic 235	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   306: ifeq +12 -> 318
    //   309: ldc 14
    //   311: iconst_2
    //   312: ldc_w 261
    //   315: invokestatic 240	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   318: aload_0
    //   319: aload 4
    //   321: iconst_1
    //   322: anewarray 81	java/lang/String
    //   325: dup
    //   326: iconst_0
    //   327: aload_1
    //   328: invokevirtual 262	org/json/JSONObject:toString	()Ljava/lang/String;
    //   331: aastore
    //   332: invokevirtual 266	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   335: return
    //   336: astore_1
    //   337: invokestatic 235	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   340: ifeq +356 -> 696
    //   343: ldc 14
    //   345: iconst_2
    //   346: new 179	java/lang/StringBuilder
    //   349: dup
    //   350: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   353: ldc_w 268
    //   356: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: aload_1
    //   360: invokevirtual 269	java/lang/Exception:toString	()Ljava/lang/String;
    //   363: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   369: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   372: return
    //   373: new 182	java/io/File
    //   376: dup
    //   377: invokestatic 276	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   380: new 179	java/lang/StringBuilder
    //   383: dup
    //   384: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   387: ldc_w 278
    //   390: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: aload_0
    //   394: getfield 127	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   397: invokevirtual 281	android/app/Activity:getPackageName	()Ljava/lang/String;
    //   400: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: ldc_w 283
    //   406: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   412: invokespecial 286	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   415: astore_1
    //   416: aload_1
    //   417: invokevirtual 289	java/io/File:mkdirs	()Z
    //   420: pop
    //   421: goto -334 -> 87
    //   424: aload_2
    //   425: astore_1
    //   426: new 291	android/os/Bundle
    //   429: dup
    //   430: invokespecial 292	android/os/Bundle:<init>	()V
    //   433: astore_3
    //   434: aload_2
    //   435: astore_1
    //   436: aload_3
    //   437: ldc_w 294
    //   440: iconst_1
    //   441: invokevirtual 298	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   444: aload_2
    //   445: astore_1
    //   446: aload_3
    //   447: ldc_w 300
    //   450: aload 5
    //   452: invokevirtual 303	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   455: aload_2
    //   456: astore_1
    //   457: aload_3
    //   458: ldc_w 305
    //   461: aload 5
    //   463: invokevirtual 303	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   466: aload_2
    //   467: astore_1
    //   468: aload_3
    //   469: ldc_w 307
    //   472: aload 5
    //   474: invokevirtual 303	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   477: aload_2
    //   478: astore_1
    //   479: aload_3
    //   480: ldc_w 309
    //   483: aload 5
    //   485: invokevirtual 303	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   488: aload_2
    //   489: astore_1
    //   490: new 311	android/content/Intent
    //   493: dup
    //   494: invokespecial 312	android/content/Intent:<init>	()V
    //   497: astore 6
    //   499: aload_2
    //   500: astore_1
    //   501: aload 6
    //   503: aload_3
    //   504: invokevirtual 316	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   507: pop
    //   508: aload_2
    //   509: astore_1
    //   510: aload_0
    //   511: getfield 127	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   514: aload 6
    //   516: bipush 21
    //   518: invokestatic 321	com/tencent/mobileqq/forward/ForwardBaseOption:a	(Landroid/app/Activity;Landroid/content/Intent;I)V
    //   521: goto -314 -> 207
    //   524: astore_3
    //   525: aload_2
    //   526: astore_1
    //   527: invokestatic 235	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   530: ifeq +34 -> 564
    //   533: aload_2
    //   534: astore_1
    //   535: ldc 14
    //   537: iconst_2
    //   538: new 179	java/lang/StringBuilder
    //   541: dup
    //   542: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   545: ldc_w 268
    //   548: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   551: aload_3
    //   552: invokevirtual 322	java/io/FileNotFoundException:toString	()Ljava/lang/String;
    //   555: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   558: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   561: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   564: aload_2
    //   565: ifnull +125 -> 690
    //   568: aload_2
    //   569: invokevirtual 243	java/io/FileOutputStream:close	()V
    //   572: iconst_0
    //   573: istore 10
    //   575: goto -312 -> 263
    //   578: aload_2
    //   579: astore_1
    //   580: invokestatic 327	com/tencent/mobileqq/wxapi/WXShareHelper:a	()Lcom/tencent/mobileqq/wxapi/WXShareHelper;
    //   583: aload 5
    //   585: aload_3
    //   586: iconst_1
    //   587: invokevirtual 330	com/tencent/mobileqq/wxapi/WXShareHelper:a	(Ljava/lang/String;Landroid/graphics/Bitmap;I)V
    //   590: goto -383 -> 207
    //   593: astore_3
    //   594: aload_1
    //   595: astore_2
    //   596: aload_3
    //   597: astore_1
    //   598: aload_2
    //   599: ifnull +7 -> 606
    //   602: aload_2
    //   603: invokevirtual 243	java/io/FileOutputStream:close	()V
    //   606: aload_1
    //   607: athrow
    //   608: aload_2
    //   609: astore_1
    //   610: invokestatic 327	com/tencent/mobileqq/wxapi/WXShareHelper:a	()Lcom/tencent/mobileqq/wxapi/WXShareHelper;
    //   613: aload 5
    //   615: aload_3
    //   616: iconst_0
    //   617: invokevirtual 330	com/tencent/mobileqq/wxapi/WXShareHelper:a	(Ljava/lang/String;Landroid/graphics/Bitmap;I)V
    //   620: goto -413 -> 207
    //   623: astore_1
    //   624: iconst_0
    //   625: istore 10
    //   627: goto -364 -> 263
    //   630: aload_1
    //   631: ldc -10
    //   633: iconst_m1
    //   634: invokevirtual 250	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   637: pop
    //   638: aload_1
    //   639: ldc -4
    //   641: ldc_w 332
    //   644: invokevirtual 257	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   647: pop
    //   648: invokestatic 235	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   651: ifeq -333 -> 318
    //   654: ldc 14
    //   656: iconst_2
    //   657: ldc_w 334
    //   660: invokestatic 240	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   663: goto -345 -> 318
    //   666: astore_1
    //   667: iload 11
    //   669: istore 10
    //   671: goto -408 -> 263
    //   674: astore_2
    //   675: goto -69 -> 606
    //   678: astore_1
    //   679: aconst_null
    //   680: astore_2
    //   681: goto -83 -> 598
    //   684: astore_3
    //   685: aconst_null
    //   686: astore_2
    //   687: goto -162 -> 525
    //   690: iconst_0
    //   691: istore 10
    //   693: goto -430 -> 263
    //   696: return
    //   697: iload 7
    //   699: tableswitch	default:+25->724, 1:+-275->424, 2:+-121->578, 3:+-91->608
    //   724: goto -517 -> 207
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	727	0	this	HealthStepCounterPlugin
    //   0	727	1	paramString	String
    //   26	583	2	localObject1	Object
    //   674	1	2	localIOException	java.io.IOException
    //   680	7	2	localObject2	Object
    //   36	468	3	localObject3	Object
    //   524	62	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   593	23	3	localBitmap	android.graphics.Bitmap
    //   684	1	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   52	268	4	str1	String
    //   135	479	5	str2	String
    //   497	18	6	localIntent	android.content.Intent
    //   69	629	7	j	int
    //   3	233	8	l	long
    //   249	443	10	bool1	boolean
    //   172	496	11	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   37	62	336	java/lang/Exception
    //   63	87	336	java/lang/Exception
    //   93	101	336	java/lang/Exception
    //   101	147	336	java/lang/Exception
    //   255	259	336	java/lang/Exception
    //   263	271	336	java/lang/Exception
    //   276	318	336	java/lang/Exception
    //   318	335	336	java/lang/Exception
    //   373	421	336	java/lang/Exception
    //   568	572	336	java/lang/Exception
    //   602	606	336	java/lang/Exception
    //   606	608	336	java/lang/Exception
    //   630	663	336	java/lang/Exception
    //   162	174	524	java/io/FileNotFoundException
    //   176	183	524	java/io/FileNotFoundException
    //   185	195	524	java/io/FileNotFoundException
    //   197	204	524	java/io/FileNotFoundException
    //   209	215	524	java/io/FileNotFoundException
    //   217	247	524	java/io/FileNotFoundException
    //   426	434	524	java/io/FileNotFoundException
    //   436	444	524	java/io/FileNotFoundException
    //   446	455	524	java/io/FileNotFoundException
    //   457	466	524	java/io/FileNotFoundException
    //   468	477	524	java/io/FileNotFoundException
    //   479	488	524	java/io/FileNotFoundException
    //   490	499	524	java/io/FileNotFoundException
    //   501	508	524	java/io/FileNotFoundException
    //   510	521	524	java/io/FileNotFoundException
    //   580	590	524	java/io/FileNotFoundException
    //   610	620	524	java/io/FileNotFoundException
    //   162	174	593	finally
    //   176	183	593	finally
    //   185	195	593	finally
    //   197	204	593	finally
    //   209	215	593	finally
    //   217	247	593	finally
    //   426	434	593	finally
    //   436	444	593	finally
    //   446	455	593	finally
    //   457	466	593	finally
    //   468	477	593	finally
    //   479	488	593	finally
    //   490	499	593	finally
    //   501	508	593	finally
    //   510	521	593	finally
    //   527	533	593	finally
    //   535	564	593	finally
    //   580	590	593	finally
    //   610	620	593	finally
    //   568	572	623	java/io/IOException
    //   255	259	666	java/io/IOException
    //   602	606	674	java/io/IOException
    //   151	160	678	finally
    //   151	160	684	java/io/FileNotFoundException
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    String str;
    label134:
    do
    {
      JSONObject localJSONObject;
      do
      {
        do
        {
          do
          {
            for (;;)
            {
              return;
              try
              {
                localJSONObject = new JSONObject(paramString1);
                str = localJSONObject.getString("callback");
                if (!TextUtils.isEmpty(str))
                {
                  if (NetworkUtil.h(this.jdField_a_of_type_AndroidAppActivity)) {
                    break label134;
                  }
                  paramString1 = new JSONObject();
                  paramString1.put("ssoRet", 103);
                  paramString1.put("businessRet", 0);
                  paramString1.put("msg", "MSF未连接");
                  super.callJs(str, new String[] { paramString1.toString() });
                  return;
                }
              }
              catch (Exception paramString1) {}
            }
          } while (!QLog.isColorLevel());
          QLog.e("HealthStepCounterPlugin", 2, "Exception:" + paramString1);
          return;
          l1 = 10240L;
          if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("httpagent_sh.http")) {
            l1 = ((Long)this.jdField_a_of_type_JavaUtilHashMap.get("httpagent_sh.http")).longValue();
          }
          if ((l1 > 0L) && (localJSONObject.toString().getBytes().length > l1))
          {
            paramString1 = new JSONObject();
            paramString1.put("ssoRet", 101);
            paramString1.put("businessRet", 0);
            paramString1.put("msg", "请求数据过大");
            super.callJs(str, new String[] { paramString1.toString() });
            return;
          }
          if (this.c.containsKey("httpagent_sh.http"))
          {
            long l2 = ((Long)this.c.get("httpagent_sh.http")).longValue();
            l1 = 1000L;
            if (this.b.containsKey("httpagent_sh.http")) {
              l1 = ((Long)this.b.get("httpagent_sh.http")).longValue();
            }
            if ((l1 > 0L) && (System.currentTimeMillis() - l2 < l1))
            {
              paramString1 = new JSONObject();
              paramString1.put("ssoRet", 102);
              paramString1.put("businessRet", 0);
              paramString1.put("msg", "请求过于频繁");
              super.callJs(str, new String[] { paramString1.toString() });
              this.c.put("httpagent_sh.http", Long.valueOf(System.currentTimeMillis()));
              return;
            }
          }
          this.c.put("httpagent_sh.http", Long.valueOf(System.currentTimeMillis()));
          localObject1 = "";
          paramString1 = (String)localObject1;
          if (this.mRuntime != null)
          {
            localObject2 = this.mRuntime.a();
            paramString1 = (String)localObject1;
            if (localObject2 != null)
            {
              localObject2 = ((CustomWebView)localObject2).getUrl();
              paramString1 = (String)localObject1;
              if (!TextUtils.isEmpty((CharSequence)localObject2))
              {
                if (this.jdField_a_of_type_ComTencentSmttSdkCookieManager == null)
                {
                  this.jdField_a_of_type_ComTencentSmttSdkCookieManager = CookieManager.getInstance();
                  this.jdField_a_of_type_ComTencentSmttSdkCookieManager.setAcceptCookie(true);
                }
                localObject1 = this.jdField_a_of_type_ComTencentSmttSdkCookieManager.getCookie((String)localObject2);
                paramString1 = (String)localObject1;
                if (!TextUtils.isEmpty((CharSequence)localObject1))
                {
                  if (((String)localObject1).indexOf(',') != -1) {
                    ((String)localObject1).replace(',', ';');
                  }
                  localJSONObject.put("Cookie", localObject1);
                  paramString1 = (String)localObject1;
                }
              }
            }
          }
        } while (TextUtils.isEmpty(paramString1));
        paramString2 = new JSONObject(paramString2);
        if (!paramString2.getBoolean("isStepCounterEnable"))
        {
          QLog.i("HealthStepCounterPlugin", 1, "web process report step found step counter off!");
          return;
        }
        localObject1 = String.valueOf(SSOHttpUtils.a());
      } while ((paramString2 == null) || (!paramString2.has((String)localObject1 + "_total")) || (!paramString2.has((String)localObject1 + "_init")) || (!paramString2.has((String)localObject1 + "_offset")));
      int j = paramString2.getInt((String)localObject1 + "_total");
      int k = paramString2.getInt((String)localObject1 + "_init");
      int m = paramString2.getInt((String)localObject1 + "_offset");
      long l1 = NetConnInfoCenter.getServerTime();
      paramString2 = new JSONArray();
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("type", 1);
      ((JSONObject)localObject1).put("time", l1);
      ((JSONObject)localObject1).put("distance", 0);
      ((JSONObject)localObject1).put("steps", m + (j - k));
      ((JSONObject)localObject1).put("duration", 0);
      ((JSONObject)localObject1).put("calories", 0);
      ((JSONObject)localObject1).put("achieve", 0);
      ((JSONObject)localObject1).put("target", 0);
      paramString2.put(localObject1);
      Object localObject2 = paramString2.toString();
      paramString2 = new StringBuilder("oauth_consumer_key=1002&");
      localObject1 = URLEncoder.encode((String)localObject2, "utf-8");
      paramString2.append("data=" + (String)localObject1);
      paramString2.append("&format=json&key=");
      paramString2.append(MD5FileUtil.b((String)localObject2 + "qlDFDfnbma!@23DKEd["));
      paramString2.append("&version=");
      paramString2.append("6.5.5");
      if (TextUtils.isEmpty(d)) {
        d = URLEncoder.encode(Build.MODEL, "utf-8");
      }
      paramString2.append("&model=");
      paramString2.append(d);
      if (TextUtils.isEmpty(e))
      {
        localObject2 = TimeZone.getDefault();
        e = URLEncoder.encode(((TimeZone)localObject2).getDisplayName(false, 0) + " " + ((TimeZone)localObject2).getID(), "utf-8");
      }
      if (!TextUtils.isEmpty(e))
      {
        paramString2.append("&zone=");
        paramString2.append(e);
      }
      localJSONObject.put("cmd", "httpagent_sh.http");
      localJSONObject.put("url", "http://open.jiankang.qq.com/cgi-bin/qqhealth_report_health_data?g_tk=" + a(paramString1));
      localJSONObject.put("Content-Type", "application/x-www-form-urlencoded");
      localJSONObject.put("needCookie", "1");
      localJSONObject.put("method", "POST");
      localJSONObject.put("content", paramString2.toString());
      QLog.i("HealthStepCounterPlugin", 1, "msg:" + (String)localObject1);
      paramString2 = new WebSSOAgent.UniSsoServerReqComm();
      paramString2.platform.set(109L);
      paramString2.osver.set(Build.VERSION.RELEASE);
      paramString2.mqqver.set("6.5.5");
      paramString1 = new WebSSOAgent.UniSsoServerReq();
      paramString1.comm.set(paramString2);
      paramString1.reqdata.set(localJSONObject.toString());
      paramString2 = new wfd(this);
    } while (this.mRuntime == null);
    Object localObject1 = new NewIntent(this.mRuntime.a().getApplicationContext(), WebSSOAgentServlet.class);
    ((NewIntent)localObject1).putExtra("extra_cmd", "httpagent_sh.http");
    ((NewIntent)localObject1).putExtra("extra_data", paramString1.toByteArray());
    ((NewIntent)localObject1).putExtra("extra_callbackid", str);
    ((NewIntent)localObject1).setObserver(paramString2);
    this.mRuntime.a().startServlet((NewIntent)localObject1);
  }
  
  private void b(String paramString)
  {
    try
    {
      this.f = new JSONObject(paramString).getString("callback");
      Object localObject;
      Sensor localSensor;
      if (!TextUtils.isEmpty(this.f))
      {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        localObject = (SensorManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("sensor");
        localSensor = ((SensorManager)localObject).getDefaultSensor(19);
        if ((Build.VERSION.SDK_INT >= 19) && (localSensor != null)) {
          break label114;
        }
        this.g = "Unsupported model found.";
        paramString = new JSONObject();
      }
      try
      {
        paramString.put("msg", this.g);
        callJs(this.f, new String[] { paramString.toString() });
        return;
        label114:
        wff localwff = new wff(this);
        ((SensorManager)localObject).registerListener(localwff, localSensor, 3, 0);
        ((SensorManager)localObject).flush(localwff);
        localObject = new NewIntent(this.mRuntime.a().getApplication(), StepCounterServlert.class);
        ((NewIntent)localObject).putExtra("msf_cmd_type", "cmd_refresh_steps");
        ((NewIntent)localObject).putExtra("json_string", paramString);
        ((NewIntent)localObject).setObserver(this.jdField_a_of_type_MqqObserverBusinessObserver);
        this.mRuntime.a().startServlet((NewIntent)localObject);
        return;
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
  }
  
  /* Error */
  protected boolean handleJsRequest(com.tencent.mobileqq.webview.swift.JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: iconst_1
    //   4: istore 11
    //   6: iconst_0
    //   7: istore 8
    //   9: invokestatic 235	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12: ifeq +12 -> 24
    //   15: ldc 14
    //   17: iconst_2
    //   18: ldc_w 675
    //   21: invokestatic 240	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   24: aload_2
    //   25: ifnull +17 -> 42
    //   28: ldc 11
    //   30: aload_3
    //   31: invokevirtual 678	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   34: ifeq +8 -> 42
    //   37: aload 4
    //   39: ifnonnull +9 -> 48
    //   42: iconst_0
    //   43: istore 10
    //   45: iload 10
    //   47: ireturn
    //   48: aload 4
    //   50: ldc_w 680
    //   53: invokevirtual 678	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   56: ifeq +194 -> 250
    //   59: iload 11
    //   61: istore 10
    //   63: aload 5
    //   65: arraylength
    //   66: ifle -21 -> 45
    //   69: aload_0
    //   70: getfield 127	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   73: ldc_w 636
    //   76: invokevirtual 640	android/app/Activity:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   79: checkcast 642	android/hardware/SensorManager
    //   82: astore_1
    //   83: getstatic 168	android/os/Build$VERSION:SDK_INT	I
    //   86: bipush 19
    //   88: if_icmplt +12 -> 100
    //   91: aload_1
    //   92: bipush 19
    //   94: invokevirtual 646	android/hardware/SensorManager:getDefaultSensor	(I)Landroid/hardware/Sensor;
    //   97: ifnonnull +88 -> 185
    //   100: new 143	org/json/JSONObject
    //   103: dup
    //   104: aload 5
    //   106: iconst_0
    //   107: aaload
    //   108: invokespecial 145	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   111: ldc -109
    //   113: invokevirtual 151	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   116: astore_2
    //   117: aload_2
    //   118: invokestatic 157	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   121: ifeq +5 -> 126
    //   124: iconst_0
    //   125: ireturn
    //   126: new 143	org/json/JSONObject
    //   129: dup
    //   130: invokespecial 244	org/json/JSONObject:<init>	()V
    //   133: astore_1
    //   134: aload_1
    //   135: ldc_w 341
    //   138: sipush 255
    //   141: invokevirtual 250	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   144: pop
    //   145: aload_1
    //   146: ldc_w 343
    //   149: iconst_0
    //   150: invokevirtual 250	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   153: pop
    //   154: aload_1
    //   155: ldc -4
    //   157: ldc_w 682
    //   160: invokevirtual 257	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   163: pop
    //   164: aload_0
    //   165: aload_2
    //   166: iconst_1
    //   167: anewarray 81	java/lang/String
    //   170: dup
    //   171: iconst_0
    //   172: aload_1
    //   173: invokevirtual 262	org/json/JSONObject:toString	()Ljava/lang/String;
    //   176: aastore
    //   177: invokespecial 346	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   180: iconst_1
    //   181: ireturn
    //   182: astore_1
    //   183: iconst_1
    //   184: ireturn
    //   185: new 589	mqq/app/NewIntent
    //   188: dup
    //   189: aload_0
    //   190: getfield 125	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   193: invokevirtual 624	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   196: invokevirtual 663	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   199: ldc_w 665
    //   202: invokespecial 601	mqq/app/NewIntent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   205: astore_1
    //   206: aload_1
    //   207: ldc_w 667
    //   210: ldc_w 669
    //   213: invokevirtual 607	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   216: pop
    //   217: aload_1
    //   218: ldc_w 671
    //   221: aload 5
    //   223: iconst_0
    //   224: aaload
    //   225: invokevirtual 607	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   228: pop
    //   229: aload_1
    //   230: aload_0
    //   231: getfield 70	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:jdField_a_of_type_MqqObserverBusinessObserver	Lmqq/observer/BusinessObserver;
    //   234: invokevirtual 621	mqq/app/NewIntent:setObserver	(Lmqq/observer/BusinessObserver;)V
    //   237: aload_0
    //   238: getfield 125	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   241: invokevirtual 624	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   244: aload_1
    //   245: invokevirtual 630	com/tencent/common/app/AppInterface:startServlet	(Lmqq/app/NewIntent;)V
    //   248: iconst_1
    //   249: ireturn
    //   250: aload 4
    //   252: ldc_w 684
    //   255: invokevirtual 678	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   258: ifeq +415 -> 673
    //   261: invokestatic 235	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   264: ifeq +32 -> 296
    //   267: ldc 14
    //   269: iconst_2
    //   270: new 179	java/lang/StringBuilder
    //   273: dup
    //   274: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   277: ldc_w 686
    //   280: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: aload 5
    //   285: iconst_0
    //   286: aaload
    //   287: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   293: invokestatic 240	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   296: invokestatic 691	com/tencent/mobileqq/app/DeviceProfileManager:a	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   299: getstatic 697	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:health_ban	Lcom/tencent/mobileqq/app/DeviceProfileManager$DpcNames;
    //   302: invokevirtual 700	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:name	()Ljava/lang/String;
    //   305: ldc 77
    //   307: invokevirtual 702	com/tencent/mobileqq/app/DeviceProfileManager:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   310: astore_1
    //   311: aload_1
    //   312: invokestatic 157	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   315: ifne +77 -> 392
    //   318: aload_1
    //   319: invokestatic 707	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   322: ifne +70 -> 392
    //   325: new 143	org/json/JSONObject
    //   328: dup
    //   329: invokespecial 244	org/json/JSONObject:<init>	()V
    //   332: astore_1
    //   333: new 143	org/json/JSONObject
    //   336: dup
    //   337: aload 5
    //   339: iconst_0
    //   340: aaload
    //   341: invokespecial 145	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   344: ldc -109
    //   346: invokevirtual 151	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   349: astore_2
    //   350: aload_1
    //   351: ldc_w 343
    //   354: sipush 202
    //   357: invokevirtual 250	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   360: pop
    //   361: aload_1
    //   362: ldc -4
    //   364: ldc_w 709
    //   367: invokevirtual 257	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   370: pop
    //   371: aload_0
    //   372: aload_2
    //   373: iconst_1
    //   374: anewarray 81	java/lang/String
    //   377: dup
    //   378: iconst_0
    //   379: aload_1
    //   380: invokevirtual 262	org/json/JSONObject:toString	()Ljava/lang/String;
    //   383: aastore
    //   384: invokespecial 346	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   387: iconst_1
    //   388: ireturn
    //   389: astore_1
    //   390: iconst_1
    //   391: ireturn
    //   392: new 143	org/json/JSONObject
    //   395: dup
    //   396: invokespecial 244	org/json/JSONObject:<init>	()V
    //   399: astore_1
    //   400: new 143	org/json/JSONObject
    //   403: dup
    //   404: aload 5
    //   406: iconst_0
    //   407: aaload
    //   408: invokespecial 145	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   411: astore_3
    //   412: aload_3
    //   413: ldc -109
    //   415: invokevirtual 151	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   418: astore_2
    //   419: aload_3
    //   420: ldc_w 711
    //   423: invokevirtual 413	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   426: istore 10
    //   428: aload_0
    //   429: getfield 127	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   432: ifnull +779 -> 1211
    //   435: new 589	mqq/app/NewIntent
    //   438: dup
    //   439: aload_0
    //   440: getfield 127	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   443: ldc_w 665
    //   446: invokespecial 601	mqq/app/NewIntent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   449: astore_3
    //   450: aload_3
    //   451: ldc_w 667
    //   454: ldc_w 713
    //   457: invokevirtual 607	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   460: pop
    //   461: aload_3
    //   462: ldc_w 711
    //   465: iload 10
    //   467: invokevirtual 716	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   470: pop
    //   471: aload_0
    //   472: getfield 125	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   475: invokevirtual 624	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   478: aload_3
    //   479: invokevirtual 630	com/tencent/common/app/AppInterface:startServlet	(Lmqq/app/NewIntent;)V
    //   482: aload_1
    //   483: ldc_w 343
    //   486: iconst_0
    //   487: invokevirtual 250	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   490: pop
    //   491: aload_1
    //   492: ldc -4
    //   494: ldc -2
    //   496: invokevirtual 257	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   499: pop
    //   500: aload_0
    //   501: aload_2
    //   502: iconst_1
    //   503: anewarray 81	java/lang/String
    //   506: dup
    //   507: iconst_0
    //   508: aload_1
    //   509: invokevirtual 262	org/json/JSONObject:toString	()Ljava/lang/String;
    //   512: aastore
    //   513: invokespecial 346	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   516: iconst_1
    //   517: istore 7
    //   519: iload 11
    //   521: istore 10
    //   523: iload 7
    //   525: ifne -480 -> 45
    //   528: new 143	org/json/JSONObject
    //   531: dup
    //   532: aload 5
    //   534: iconst_0
    //   535: aaload
    //   536: invokespecial 145	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   539: ldc -109
    //   541: invokevirtual 151	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   544: astore_2
    //   545: aload_1
    //   546: ldc_w 343
    //   549: sipush 201
    //   552: invokevirtual 250	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   555: pop
    //   556: aload_1
    //   557: ldc -4
    //   559: ldc_w 332
    //   562: invokevirtual 257	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   565: pop
    //   566: aload_0
    //   567: aload_2
    //   568: iconst_1
    //   569: anewarray 81	java/lang/String
    //   572: dup
    //   573: iconst_0
    //   574: aload_1
    //   575: invokevirtual 262	org/json/JSONObject:toString	()Ljava/lang/String;
    //   578: aastore
    //   579: invokespecial 346	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   582: iconst_1
    //   583: ireturn
    //   584: astore_1
    //   585: iload 11
    //   587: istore 10
    //   589: invokestatic 235	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   592: ifeq -547 -> 45
    //   595: ldc 14
    //   597: iconst_2
    //   598: new 179	java/lang/StringBuilder
    //   601: dup
    //   602: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   605: ldc_w 268
    //   608: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   611: aload_1
    //   612: invokevirtual 269	java/lang/Exception:toString	()Ljava/lang/String;
    //   615: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   621: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   624: iconst_1
    //   625: ireturn
    //   626: astore_2
    //   627: iload 8
    //   629: istore 7
    //   631: invokestatic 235	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   634: ifeq -115 -> 519
    //   637: ldc 14
    //   639: iconst_2
    //   640: new 179	java/lang/StringBuilder
    //   643: dup
    //   644: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   647: ldc_w 268
    //   650: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   653: aload_2
    //   654: invokevirtual 269	java/lang/Exception:toString	()Ljava/lang/String;
    //   657: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   660: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   663: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   666: iload 8
    //   668: istore 7
    //   670: goto -151 -> 519
    //   673: aload 4
    //   675: ldc_w 718
    //   678: invokevirtual 678	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   681: ifeq +89 -> 770
    //   684: aload_0
    //   685: getfield 221	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   688: ifnonnull +37 -> 725
    //   691: aload_0
    //   692: getfield 127	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   695: ifnull +30 -> 725
    //   698: aload_0
    //   699: getfield 127	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   702: instanceof 720
    //   705: ifeq +20 -> 725
    //   708: aload_0
    //   709: aload_0
    //   710: getfield 127	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   713: checkcast 720	com/tencent/mobileqq/activity/QQBrowserActivity
    //   716: invokevirtual 724	com/tencent/mobileqq/activity/QQBrowserActivity:getShare	()Lcom/tencent/biz/webviewplugin/Share;
    //   719: invokevirtual 729	com/tencent/biz/webviewplugin/Share:a	()Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   722: putfield 221	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   725: aload_0
    //   726: getfield 221	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   729: ldc_w 730
    //   732: invokevirtual 733	com/tencent/mobileqq/widget/QQProgressDialog:b	(I)V
    //   735: aload_0
    //   736: getfield 221	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   739: iconst_0
    //   740: invokevirtual 736	com/tencent/mobileqq/widget/QQProgressDialog:setCancelable	(Z)V
    //   743: aload_0
    //   744: getfield 221	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   747: invokevirtual 739	com/tencent/mobileqq/widget/QQProgressDialog:show	()V
    //   750: new 741	wfc
    //   753: dup
    //   754: aload_0
    //   755: aload 5
    //   757: iconst_0
    //   758: aaload
    //   759: invokespecial 743	wfc:<init>	(Lcom/tencent/mobileqq/vashealth/HealthStepCounterPlugin;Ljava/lang/String;)V
    //   762: iconst_5
    //   763: aconst_null
    //   764: iconst_1
    //   765: invokestatic 748	com/tencent/mobileqq/app/ThreadManager:a	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   768: iconst_1
    //   769: ireturn
    //   770: aload 4
    //   772: ldc_w 750
    //   775: invokevirtual 678	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   778: ifeq +13 -> 791
    //   781: aload_0
    //   782: aload 5
    //   784: iconst_0
    //   785: aaload
    //   786: invokespecial 752	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:b	(Ljava/lang/String;)V
    //   789: iconst_0
    //   790: ireturn
    //   791: aload 4
    //   793: ldc_w 754
    //   796: invokevirtual 678	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   799: ifeq -10 -> 789
    //   802: new 179	java/lang/StringBuilder
    //   805: dup
    //   806: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   809: invokestatic 759	com/tencent/common/app/BaseApplicationImpl:a	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   812: invokevirtual 762	com/tencent/common/app/BaseApplicationImpl:getFilesDir	()Ljava/io/File;
    //   815: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   818: getstatic 193	java/io/File:separator	Ljava/lang/String;
    //   821: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   824: ldc_w 764
    //   827: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   830: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   833: astore_1
    //   834: new 182	java/io/File
    //   837: dup
    //   838: aload_1
    //   839: invokespecial 202	java/io/File:<init>	(Ljava/lang/String;)V
    //   842: astore_2
    //   843: aload_2
    //   844: invokevirtual 767	java/io/File:exists	()Z
    //   847: ifeq +14 -> 861
    //   850: aload_2
    //   851: invokevirtual 770	java/io/File:isFile	()Z
    //   854: istore 10
    //   856: iload 10
    //   858: ifne +22 -> 880
    //   861: iload 11
    //   863: istore 10
    //   865: iconst_0
    //   866: ifeq -821 -> 45
    //   869: new 772	java/lang/NullPointerException
    //   872: dup
    //   873: invokespecial 773	java/lang/NullPointerException:<init>	()V
    //   876: athrow
    //   877: astore_1
    //   878: iconst_1
    //   879: ireturn
    //   880: new 775	com/tencent/qphone/base/util/Cryptor
    //   883: dup
    //   884: invokespecial 776	com/tencent/qphone/base/util/Cryptor:<init>	()V
    //   887: astore_3
    //   888: new 778	java/io/RandomAccessFile
    //   891: dup
    //   892: aload_1
    //   893: ldc_w 780
    //   896: invokespecial 782	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   899: astore_2
    //   900: aload_2
    //   901: astore_1
    //   902: aload_2
    //   903: invokevirtual 784	java/io/RandomAccessFile:length	()J
    //   906: l2i
    //   907: newarray <illegal type>
    //   909: astore 4
    //   911: aload_2
    //   912: astore_1
    //   913: aload_2
    //   914: aload 4
    //   916: invokevirtual 788	java/io/RandomAccessFile:read	([B)I
    //   919: pop
    //   920: aload_2
    //   921: astore_1
    //   922: new 81	java/lang/String
    //   925: dup
    //   926: aload_3
    //   927: aload 4
    //   929: ldc_w 790
    //   932: invokevirtual 368	java/lang/String:getBytes	()[B
    //   935: invokevirtual 794	com/tencent/qphone/base/util/Cryptor:decrypt	([B[B)[B
    //   938: invokespecial 797	java/lang/String:<init>	([B)V
    //   941: astore_3
    //   942: aload_2
    //   943: astore_1
    //   944: aload_2
    //   945: invokevirtual 798	java/io/RandomAccessFile:close	()V
    //   948: invokestatic 419	com/tencent/mobileqq/vashealth/SSOHttpUtils:a	()J
    //   951: invokestatic 422	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   954: astore_1
    //   955: new 143	org/json/JSONObject
    //   958: dup
    //   959: aload_3
    //   960: invokespecial 145	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   963: astore_2
    //   964: aload_2
    //   965: new 179	java/lang/StringBuilder
    //   968: dup
    //   969: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   972: aload_1
    //   973: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   976: ldc_w 424
    //   979: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   982: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   985: invokevirtual 162	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   988: istore 9
    //   990: aload_2
    //   991: new 179	java/lang/StringBuilder
    //   994: dup
    //   995: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   998: aload_1
    //   999: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1002: ldc_w 429
    //   1005: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1008: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1011: invokevirtual 162	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1014: istore 8
    //   1016: aload_2
    //   1017: new 179	java/lang/StringBuilder
    //   1020: dup
    //   1021: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   1024: aload_1
    //   1025: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1028: ldc_w 431
    //   1031: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1034: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1037: invokevirtual 162	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1040: istore 7
    //   1042: new 143	org/json/JSONObject
    //   1045: dup
    //   1046: aload 5
    //   1048: iconst_0
    //   1049: aaload
    //   1050: invokespecial 145	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1053: astore_2
    //   1054: new 143	org/json/JSONObject
    //   1057: dup
    //   1058: invokespecial 244	org/json/JSONObject:<init>	()V
    //   1061: astore_1
    //   1062: aload_2
    //   1063: ldc -109
    //   1065: invokevirtual 151	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1068: astore_2
    //   1069: aload_2
    //   1070: invokestatic 157	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1073: ifne +35 -> 1108
    //   1076: aload_1
    //   1077: ldc_w 800
    //   1080: iload 7
    //   1082: iload 9
    //   1084: iload 8
    //   1086: isub
    //   1087: iadd
    //   1088: invokevirtual 250	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1091: pop
    //   1092: aload_0
    //   1093: aload_2
    //   1094: iconst_1
    //   1095: anewarray 81	java/lang/String
    //   1098: dup
    //   1099: iconst_0
    //   1100: aload_1
    //   1101: invokevirtual 262	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1104: aastore
    //   1105: invokespecial 346	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1108: iconst_0
    //   1109: ifeq -320 -> 789
    //   1112: new 772	java/lang/NullPointerException
    //   1115: dup
    //   1116: invokespecial 773	java/lang/NullPointerException:<init>	()V
    //   1119: athrow
    //   1120: astore_1
    //   1121: goto -332 -> 789
    //   1124: astore_3
    //   1125: aconst_null
    //   1126: astore_2
    //   1127: aload_2
    //   1128: astore_1
    //   1129: invokestatic 235	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1132: ifeq +34 -> 1166
    //   1135: aload_2
    //   1136: astore_1
    //   1137: ldc 14
    //   1139: iconst_2
    //   1140: new 179	java/lang/StringBuilder
    //   1143: dup
    //   1144: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   1147: ldc_w 802
    //   1150: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1153: aload_3
    //   1154: invokevirtual 269	java/lang/Exception:toString	()Ljava/lang/String;
    //   1157: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1160: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1163: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1166: aload_2
    //   1167: ifnull -378 -> 789
    //   1170: aload_2
    //   1171: invokevirtual 798	java/io/RandomAccessFile:close	()V
    //   1174: goto -385 -> 789
    //   1177: astore_1
    //   1178: goto -389 -> 789
    //   1181: astore_1
    //   1182: aload 6
    //   1184: astore_2
    //   1185: aload_2
    //   1186: ifnull +7 -> 1193
    //   1189: aload_2
    //   1190: invokevirtual 798	java/io/RandomAccessFile:close	()V
    //   1193: aload_1
    //   1194: athrow
    //   1195: astore_2
    //   1196: goto -3 -> 1193
    //   1199: astore_3
    //   1200: aload_1
    //   1201: astore_2
    //   1202: aload_3
    //   1203: astore_1
    //   1204: goto -19 -> 1185
    //   1207: astore_3
    //   1208: goto -81 -> 1127
    //   1211: iconst_0
    //   1212: istore 7
    //   1214: goto -695 -> 519
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1217	0	this	HealthStepCounterPlugin
    //   0	1217	1	paramJsBridgeListener	com.tencent.mobileqq.webview.swift.JsBridgeListener
    //   0	1217	2	paramString1	String
    //   0	1217	3	paramString2	String
    //   0	1217	4	paramString3	String
    //   0	1217	5	paramVarArgs	String[]
    //   1	1182	6	localObject	Object
    //   517	696	7	j	int
    //   7	1080	8	k	int
    //   988	99	9	m	int
    //   43	821	10	bool1	boolean
    //   4	858	11	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   100	124	182	java/lang/Exception
    //   126	180	182	java/lang/Exception
    //   333	387	389	java/lang/Exception
    //   528	582	584	java/lang/Exception
    //   400	516	626	java/lang/Exception
    //   869	877	877	java/io/IOException
    //   1112	1120	1120	java/io/IOException
    //   834	856	1124	java/lang/Exception
    //   880	900	1124	java/lang/Exception
    //   948	1108	1124	java/lang/Exception
    //   1170	1174	1177	java/io/IOException
    //   834	856	1181	finally
    //   880	900	1181	finally
    //   948	1108	1181	finally
    //   1189	1193	1195	java/io/IOException
    //   902	911	1199	finally
    //   913	920	1199	finally
    //   922	942	1199	finally
    //   944	948	1199	finally
    //   1129	1135	1199	finally
    //   1137	1166	1199	finally
    //   902	911	1207	java/lang/Exception
    //   913	920	1207	java/lang/Exception
    //   922	942	1207	java/lang/Exception
    //   944	948	1207	java/lang/Exception
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_AndroidAppActivity = this.mRuntime.a();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vashealth\HealthStepCounterPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */