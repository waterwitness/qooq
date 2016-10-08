package com.tencent.biz.game;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.media.SoundPool;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Vibrator;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import com.tencent.beacon.event.UserAction;
import com.tencent.biz.apiproxy.QQMusicClient;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.biz.troopplugin.PluginJumpManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.webview.swift.JsWebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.VipComicUiInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebUiMethodInterface;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import com.tencent.util.URLUtil;
import hhz;
import hia;
import hib;
import hic;
import hid;
import hie;
import hif;
import hig;
import hij;
import hik;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class SensorAPIJavaScript
  extends JsWebViewPlugin
{
  static final byte jdField_a_of_type_Byte = 1;
  public static final int a = 1;
  public static MSFToWebViewConnector a;
  public static final String a = "qbizApi";
  public static final int b = 0;
  public static final int e = 600000;
  public Activity a;
  protected SensorManager a;
  protected AudioRecord a;
  protected MediaRecorder a;
  public SoundPool a;
  public Handler a;
  protected SensorAPIJavaScript.QQSensorEventListener a;
  TroopMemberApiClient jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient;
  protected Object a;
  public WeakReference a;
  protected HashMap a;
  protected boolean a;
  protected final byte b;
  protected SensorAPIJavaScript.QQSensorEventListener b;
  protected String b;
  protected boolean b;
  protected final byte c;
  protected final int c;
  protected SensorAPIJavaScript.QQSensorEventListener c;
  protected String c;
  public boolean c;
  protected final byte d;
  protected final int d;
  protected final int f;
  protected final int g;
  protected final int h;
  protected final int i;
  protected final int j;
  protected final int k;
  protected final int l;
  protected final int m;
  protected final int n;
  protected int o;
  
  public SensorAPIJavaScript()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_Byte = 0;
    this.jdField_c_of_type_Byte = 1;
    this.jdField_d_of_type_Byte = 2;
    this.jdField_c_of_type_Int = 8000;
    this.jdField_d_of_type_Int = 0;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.f = 5;
    this.g = 291;
    this.h = 0;
    this.i = 1;
    this.j = 2;
    this.k = 3;
    this.l = 4;
    this.m = 0;
    this.n = 1;
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = null;
    this.o = 100;
  }
  
  private void a()
  {
    if (Looper.myLooper() == null) {
      Looper.prepare();
    }
    this.jdField_a_of_type_AndroidOsHandler = new hhz(this);
  }
  
  private void b(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("SensorApi", 4, "start checkWifiStatus");
    }
    new hij(this, this.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), paramString).start();
  }
  
  public static MSFToWebViewConnector getMsfToWebViewConnector()
  {
    return jdField_a_of_type_ComTencentBizGameMSFToWebViewConnector;
  }
  
  /* Error */
  public final int a()
  {
    // Byte code:
    //   0: invokestatic 157	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   3: new 159	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   10: ldc -94
    //   12: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: ldc -88
    //   17: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   23: invokevirtual 176	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   26: astore_3
    //   27: aload_3
    //   28: invokevirtual 182	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   31: astore_1
    //   32: new 184	java/io/BufferedReader
    //   35: dup
    //   36: new 186	java/io/InputStreamReader
    //   39: dup
    //   40: aload_1
    //   41: invokespecial 189	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   44: invokespecial 192	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   47: astore_2
    //   48: new 194	java/lang/StringBuffer
    //   51: dup
    //   52: invokespecial 195	java/lang/StringBuffer:<init>	()V
    //   55: astore 4
    //   57: aload_2
    //   58: invokevirtual 198	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   61: astore 5
    //   63: aload 5
    //   65: ifnull +75 -> 140
    //   68: aload 4
    //   70: aload 5
    //   72: invokevirtual 201	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   75: pop
    //   76: goto -19 -> 57
    //   79: astore_3
    //   80: aload_2
    //   81: astore_3
    //   82: aload_1
    //   83: astore_2
    //   84: aload_3
    //   85: astore_1
    //   86: invokestatic 117	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   89: ifeq +29 -> 118
    //   92: ldc 119
    //   94: iconst_4
    //   95: new 159	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   102: ldc -53
    //   104: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: ldc -51
    //   109: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokestatic 207	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   118: aload_1
    //   119: ifnull +7 -> 126
    //   122: aload_1
    //   123: invokevirtual 210	java/io/BufferedReader:close	()V
    //   126: aload_2
    //   127: ifnull +7 -> 134
    //   130: aload_2
    //   131: invokevirtual 213	java/io/InputStream:close	()V
    //   134: iconst_1
    //   135: istore 6
    //   137: iload 6
    //   139: ireturn
    //   140: invokestatic 117	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   143: ifeq +32 -> 175
    //   146: ldc 119
    //   148: iconst_4
    //   149: new 159	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   156: ldc -41
    //   158: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: aload 4
    //   163: invokevirtual 216	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   166: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: invokestatic 207	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   175: aload_3
    //   176: invokevirtual 219	java/lang/Process:waitFor	()I
    //   179: ifne +71 -> 250
    //   182: iconst_0
    //   183: istore 6
    //   185: invokestatic 117	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   188: ifeq +29 -> 217
    //   191: ldc 119
    //   193: iconst_4
    //   194: new 159	java/lang/StringBuilder
    //   197: dup
    //   198: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   201: ldc -53
    //   203: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: ldc -35
    //   208: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: invokestatic 207	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   217: aload_2
    //   218: ifnull +7 -> 225
    //   221: aload_2
    //   222: invokevirtual 210	java/io/BufferedReader:close	()V
    //   225: aload_1
    //   226: ifnull -89 -> 137
    //   229: aload_1
    //   230: invokevirtual 213	java/io/InputStream:close	()V
    //   233: iconst_0
    //   234: ireturn
    //   235: astore_1
    //   236: aload_1
    //   237: invokevirtual 224	java/io/IOException:printStackTrace	()V
    //   240: iconst_0
    //   241: ireturn
    //   242: astore_2
    //   243: aload_2
    //   244: invokevirtual 224	java/io/IOException:printStackTrace	()V
    //   247: goto -22 -> 225
    //   250: invokestatic 117	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   253: ifeq +29 -> 282
    //   256: ldc 119
    //   258: iconst_4
    //   259: new 159	java/lang/StringBuilder
    //   262: dup
    //   263: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   266: ldc -53
    //   268: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: ldc -30
    //   273: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   279: invokestatic 207	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   282: aload_2
    //   283: ifnull +7 -> 290
    //   286: aload_2
    //   287: invokevirtual 210	java/io/BufferedReader:close	()V
    //   290: aload_1
    //   291: ifnull -157 -> 134
    //   294: aload_1
    //   295: invokevirtual 213	java/io/InputStream:close	()V
    //   298: goto -164 -> 134
    //   301: astore_1
    //   302: aload_1
    //   303: invokevirtual 224	java/io/IOException:printStackTrace	()V
    //   306: goto -172 -> 134
    //   309: astore_2
    //   310: aload_2
    //   311: invokevirtual 224	java/io/IOException:printStackTrace	()V
    //   314: goto -24 -> 290
    //   317: astore_1
    //   318: aload_1
    //   319: invokevirtual 224	java/io/IOException:printStackTrace	()V
    //   322: goto -196 -> 126
    //   325: astore_1
    //   326: aload_1
    //   327: invokevirtual 224	java/io/IOException:printStackTrace	()V
    //   330: goto -196 -> 134
    //   333: astore_1
    //   334: aconst_null
    //   335: astore_2
    //   336: aconst_null
    //   337: astore_1
    //   338: invokestatic 117	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   341: ifeq +29 -> 370
    //   344: ldc 119
    //   346: iconst_4
    //   347: new 159	java/lang/StringBuilder
    //   350: dup
    //   351: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   354: ldc -53
    //   356: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: ldc -28
    //   361: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   367: invokestatic 207	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   370: aload_2
    //   371: ifnull +7 -> 378
    //   374: aload_2
    //   375: invokevirtual 210	java/io/BufferedReader:close	()V
    //   378: aload_1
    //   379: ifnull -245 -> 134
    //   382: aload_1
    //   383: invokevirtual 213	java/io/InputStream:close	()V
    //   386: goto -252 -> 134
    //   389: astore_1
    //   390: aload_1
    //   391: invokevirtual 224	java/io/IOException:printStackTrace	()V
    //   394: goto -260 -> 134
    //   397: astore_2
    //   398: aload_2
    //   399: invokevirtual 224	java/io/IOException:printStackTrace	()V
    //   402: goto -24 -> 378
    //   405: astore_3
    //   406: aconst_null
    //   407: astore_2
    //   408: aconst_null
    //   409: astore_1
    //   410: invokestatic 117	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   413: ifeq +28 -> 441
    //   416: ldc 119
    //   418: iconst_4
    //   419: new 159	java/lang/StringBuilder
    //   422: dup
    //   423: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   426: ldc -53
    //   428: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: aconst_null
    //   432: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   438: invokestatic 207	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   441: aload_2
    //   442: ifnull +7 -> 449
    //   445: aload_2
    //   446: invokevirtual 210	java/io/BufferedReader:close	()V
    //   449: aload_1
    //   450: ifnull +7 -> 457
    //   453: aload_1
    //   454: invokevirtual 213	java/io/InputStream:close	()V
    //   457: aload_3
    //   458: athrow
    //   459: astore_2
    //   460: aload_2
    //   461: invokevirtual 224	java/io/IOException:printStackTrace	()V
    //   464: goto -15 -> 449
    //   467: astore_1
    //   468: aload_1
    //   469: invokevirtual 224	java/io/IOException:printStackTrace	()V
    //   472: goto -15 -> 457
    //   475: astore_3
    //   476: aconst_null
    //   477: astore_2
    //   478: goto -68 -> 410
    //   481: astore_3
    //   482: goto -72 -> 410
    //   485: astore_2
    //   486: aconst_null
    //   487: astore_2
    //   488: goto -150 -> 338
    //   491: astore_3
    //   492: goto -154 -> 338
    //   495: astore_1
    //   496: aconst_null
    //   497: astore_1
    //   498: aconst_null
    //   499: astore_2
    //   500: goto -414 -> 86
    //   503: astore_2
    //   504: aconst_null
    //   505: astore_3
    //   506: aload_1
    //   507: astore_2
    //   508: aload_3
    //   509: astore_1
    //   510: goto -424 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	513	0	this	SensorAPIJavaScript
    //   31	199	1	localObject1	Object
    //   235	60	1	localIOException1	java.io.IOException
    //   301	2	1	localIOException2	java.io.IOException
    //   317	2	1	localIOException3	java.io.IOException
    //   325	2	1	localIOException4	java.io.IOException
    //   333	1	1	localInterruptedException1	InterruptedException
    //   337	46	1	localObject2	Object
    //   389	2	1	localIOException5	java.io.IOException
    //   409	45	1	localObject3	Object
    //   467	2	1	localIOException6	java.io.IOException
    //   495	1	1	localIOException7	java.io.IOException
    //   497	13	1	localObject4	Object
    //   47	175	2	localObject5	Object
    //   242	45	2	localIOException8	java.io.IOException
    //   309	2	2	localIOException9	java.io.IOException
    //   335	40	2	localObject6	Object
    //   397	2	2	localIOException10	java.io.IOException
    //   407	39	2	localObject7	Object
    //   459	2	2	localIOException11	java.io.IOException
    //   477	1	2	localObject8	Object
    //   485	1	2	localInterruptedException2	InterruptedException
    //   487	13	2	localObject9	Object
    //   503	1	2	localIOException12	java.io.IOException
    //   507	1	2	localObject10	Object
    //   26	2	3	localProcess	Process
    //   79	1	3	localIOException13	java.io.IOException
    //   81	95	3	localObject11	Object
    //   405	53	3	localObject12	Object
    //   475	1	3	localObject13	Object
    //   481	1	3	localObject14	Object
    //   491	1	3	localInterruptedException3	InterruptedException
    //   505	4	3	localObject15	Object
    //   55	107	4	localStringBuffer	StringBuffer
    //   61	10	5	str	String
    //   135	49	6	i1	int
    // Exception table:
    //   from	to	target	type
    //   48	57	79	java/io/IOException
    //   57	63	79	java/io/IOException
    //   68	76	79	java/io/IOException
    //   140	175	79	java/io/IOException
    //   175	182	79	java/io/IOException
    //   229	233	235	java/io/IOException
    //   221	225	242	java/io/IOException
    //   294	298	301	java/io/IOException
    //   286	290	309	java/io/IOException
    //   122	126	317	java/io/IOException
    //   130	134	325	java/io/IOException
    //   0	32	333	java/lang/InterruptedException
    //   382	386	389	java/io/IOException
    //   374	378	397	java/io/IOException
    //   0	32	405	finally
    //   445	449	459	java/io/IOException
    //   453	457	467	java/io/IOException
    //   32	48	475	finally
    //   48	57	481	finally
    //   57	63	481	finally
    //   68	76	481	finally
    //   140	175	481	finally
    //   175	182	481	finally
    //   32	48	485	java/lang/InterruptedException
    //   48	57	491	java/lang/InterruptedException
    //   57	63	491	java/lang/InterruptedException
    //   68	76	491	java/lang/InterruptedException
    //   140	175	491	java/lang/InterruptedException
    //   175	182	491	java/lang/InterruptedException
    //   0	32	495	java/io/IOException
    //   32	48	503	java/io/IOException
  }
  
  protected String a()
  {
    return "qbizApi";
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidMediaMediaRecorder != null)
    {
      int i1 = (int)(20.0D * Math.log10(this.jdField_a_of_type_AndroidMediaMediaRecorder.getMaxAmplitude()));
      if (!TextUtils.isEmpty(paramString))
      {
        callJs(paramString, new String[] { "true", Integer.toString(i1) });
        Message localMessage = new Message();
        localMessage.what = 291;
        localMessage.obj = paramString;
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, this.o);
      }
    }
  }
  
  public void checkUpdate(String paramString1, String paramString2)
  {
    HtmlOffline.a(paramString1, this.mRuntime.a(), new hif(this, paramString2), false);
  }
  
  /* Error */
  public void connectToWiFi(String paramString)
  {
    // Byte code:
    //   0: ldc 61
    //   2: astore_2
    //   3: new 302	org/json/JSONObject
    //   6: dup
    //   7: aload_1
    //   8: invokespecial 304	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11: astore 6
    //   13: aload 6
    //   15: ldc_w 306
    //   18: invokevirtual 310	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   21: astore_3
    //   22: aload 6
    //   24: ldc_w 312
    //   27: invokevirtual 310	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   30: astore 4
    //   32: aload 6
    //   34: ldc_w 314
    //   37: invokevirtual 310	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   40: astore 5
    //   42: aload 6
    //   44: ldc_w 316
    //   47: invokevirtual 310	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   50: astore_1
    //   51: aload 6
    //   53: ldc_w 318
    //   56: invokevirtual 322	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   59: istore 7
    //   61: aload_0
    //   62: getfield 324	com/tencent/biz/game/SensorAPIJavaScript:jdField_c_of_type_Boolean	Z
    //   65: ifeq +53 -> 118
    //   68: aload_0
    //   69: aload 5
    //   71: iconst_1
    //   72: anewarray 251	java/lang/String
    //   75: dup
    //   76: iconst_0
    //   77: ldc_w 326
    //   80: aastore
    //   81: invokevirtual 262	com/tencent/biz/game/SensorAPIJavaScript:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   84: return
    //   85: astore_1
    //   86: aload_1
    //   87: invokevirtual 327	org/json/JSONException:printStackTrace	()V
    //   90: return
    //   91: astore_1
    //   92: aload_1
    //   93: invokevirtual 327	org/json/JSONException:printStackTrace	()V
    //   96: return
    //   97: astore_1
    //   98: aload_1
    //   99: invokevirtual 327	org/json/JSONException:printStackTrace	()V
    //   102: aload_2
    //   103: astore_1
    //   104: goto -53 -> 51
    //   107: astore_2
    //   108: aload_2
    //   109: invokevirtual 327	org/json/JSONException:printStackTrace	()V
    //   112: iconst_0
    //   113: istore 7
    //   115: goto -54 -> 61
    //   118: aload 5
    //   120: invokestatic 249	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   123: ifne -39 -> 84
    //   126: aload_0
    //   127: getfield 128	com/tencent/biz/game/SensorAPIJavaScript:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   130: ifnull -46 -> 84
    //   133: aload_3
    //   134: invokestatic 249	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   137: ifne +11 -> 148
    //   140: aload 4
    //   142: invokestatic 249	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   145: ifeq +20 -> 165
    //   148: aload_0
    //   149: aload 5
    //   151: iconst_1
    //   152: anewarray 251	java/lang/String
    //   155: dup
    //   156: iconst_0
    //   157: ldc_w 329
    //   160: aastore
    //   161: invokevirtual 262	com/tencent/biz/game/SensorAPIJavaScript:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   164: return
    //   165: aload_0
    //   166: getfield 128	com/tencent/biz/game/SensorAPIJavaScript:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   169: invokevirtual 134	android/app/Activity:getApplicationContext	()Landroid/content/Context;
    //   172: ldc_w 331
    //   175: invokevirtual 337	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   178: checkcast 339	android/net/wifi/WifiManager
    //   181: astore_2
    //   182: aload_2
    //   183: ifnonnull +35 -> 218
    //   186: invokestatic 117	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   189: ifeq +12 -> 201
    //   192: ldc 119
    //   194: iconst_4
    //   195: ldc_w 341
    //   198: invokestatic 124	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   201: aload_0
    //   202: aload 5
    //   204: iconst_1
    //   205: anewarray 251	java/lang/String
    //   208: dup
    //   209: iconst_0
    //   210: ldc_w 343
    //   213: aastore
    //   214: invokevirtual 262	com/tencent/biz/game/SensorAPIJavaScript:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   217: return
    //   218: aload_0
    //   219: iconst_1
    //   220: putfield 324	com/tencent/biz/game/SensorAPIJavaScript:jdField_c_of_type_Boolean	Z
    //   223: new 345	hii
    //   226: dup
    //   227: aload_0
    //   228: aload 4
    //   230: aload_3
    //   231: aload_1
    //   232: iload 7
    //   234: aload_2
    //   235: aload 5
    //   237: invokespecial 348	hii:<init>	(Lcom/tencent/biz/game/SensorAPIJavaScript;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLandroid/net/wifi/WifiManager;Ljava/lang/String;)V
    //   240: invokevirtual 142	java/lang/Thread:start	()V
    //   243: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	244	0	this	SensorAPIJavaScript
    //   0	244	1	paramString	String
    //   2	101	2	str1	String
    //   107	2	2	localJSONException	JSONException
    //   181	54	2	localWifiManager	android.net.wifi.WifiManager
    //   21	210	3	str2	String
    //   30	199	4	str3	String
    //   40	196	5	str4	String
    //   11	41	6	localJSONObject	JSONObject
    //   59	174	7	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	13	85	org/json/JSONException
    //   13	42	91	org/json/JSONException
    //   42	51	97	org/json/JSONException
    //   51	61	107	org/json/JSONException
  }
  
  public final String getClientInfo()
  {
    return "{\"qqVersion\":\"" + qqVersion() + "\",\"qqBuild\":\"" + "2880" + "\"}";
  }
  
  public boolean getCurrentSong(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      for (;;)
      {
        return true;
        try
        {
          paramString = new JSONObject(paramString);
          paramString = paramString.optString("callback");
          if (!TextUtils.isEmpty(paramString))
          {
            this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a().c(new hib(this, paramString));
            return true;
          }
        }
        catch (JSONException paramString)
        {
          paramString.printStackTrace();
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.TAG, 2, "getCurrentSong json err");
    return true;
  }
  
  public final String getDeviceInfo()
  {
    String str4 = Build.MODEL;
    String str5 = Build.VERSION.RELEASE;
    String str6 = Build.FINGERPRINT;
    String str7 = Build.VERSION.INCREMENTAL;
    String str3 = "";
    try
    {
      String str1 = UserAction.getQIMEI();
      return "{\"model\":\"" + str4 + "\",\"systemName\":\"android\",\"systemVersion\":\"" + str5 + "\",\"isMobileQQ\":\"true\",\"identifier\":" + Util.b(MobileInfoUtil.c()) + ",\"fingerprint\":" + Util.b(str6) + ",\"incremental\":" + Util.b(str7) + ",\"macAddress\":" + Util.b(MobileInfoUtil.a()) + ",\"androidID\":" + Util.b(Settings.Secure.getString(CommonDataAdapter.a().a().getContentResolver(), "android_id")) + ",\"imsi\":" + Util.b(MobileInfoUtil.d()) + ",\"qimei\":" + Util.b(str1) + "}";
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str2 = str3;
        if (QLog.isColorLevel())
        {
          QLog.e(this.TAG, 2, "get QIMEI fail");
          str2 = str3;
        }
      }
    }
  }
  
  public JSONObject getNetworkInfo()
  {
    int i3 = 0;
    Object localObject1 = (ConnectivityManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("connectivity");
    int i1;
    if (localObject1 != null)
    {
      localObject1 = ((ConnectivityManager)localObject1).getActiveNetworkInfo();
      if ((localObject1 != null) && (((NetworkInfo)localObject1).isConnected())) {
        switch (((NetworkInfo)localObject1).getType())
        {
        default: 
          localObject1 = "NETWORK_TYPE_UNKNOWN";
          i1 = -1;
        }
      }
    }
    for (;;)
    {
      Object localObject2 = DeviceInfoUtil.b();
      int i2 = i3;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        i2 = i3;
        if (((String)localObject2).length() > 5)
        {
          i2 = i3;
          if (((String)localObject2).startsWith("460"))
          {
            localObject2 = ((String)localObject2).substring(3, 5);
            if ((!((String)localObject2).equals("00")) && (!((String)localObject2).equals("02")) && (!((String)localObject2).equals("04")) && (!((String)localObject2).equals("07"))) {
              break label432;
            }
            i2 = 1;
          }
        }
      }
      for (;;)
      {
        localObject2 = new JSONObject();
        try
        {
          ((JSONObject)localObject2).put("type", i1);
          ((JSONObject)localObject2).put("radio", localObject1);
          ((JSONObject)localObject2).put("carriertype", i2);
          return (JSONObject)localObject2;
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
          return (JSONObject)localObject2;
        }
        localObject1 = "NETWORK_TYPE_WIFI";
        i1 = 1;
        break;
        switch (((NetworkInfo)localObject1).getSubtype())
        {
        default: 
          localObject1 = "NETWORK_TYPE_UNKNOWN";
          i1 = -1;
          break;
        case 1: 
          localObject1 = "NETWORK_TYPE_GPRS";
          i1 = 2;
          break;
        case 2: 
          localObject1 = "NETWORK_TYPE_EDGE";
          i1 = 2;
          break;
        case 4: 
          localObject1 = "NETWORK_TYPE_CDMA";
          i1 = 2;
          break;
        case 7: 
          localObject1 = "NETWORK_TYPE_1xRTT";
          i1 = 2;
          break;
        case 11: 
          localObject1 = "NETWORK_TYPE_IDEN";
          i1 = 2;
          break;
        case 3: 
          localObject1 = "NETWORK_TYPE_UMTS";
          i1 = 3;
          break;
        case 5: 
          localObject1 = "NETWORK_TYPE_EVDO_0";
          i1 = 3;
          break;
        case 6: 
          localObject1 = "NETWORK_TYPE_EVDO_A";
          i1 = 3;
          break;
        case 8: 
          localObject1 = "NETWORK_TYPE_HSDPA";
          i1 = 3;
          break;
        case 9: 
          localObject1 = "NETWORK_TYPE_HSUPA";
          i1 = 3;
          break;
        case 10: 
          localObject1 = "NETWORK_TYPE_HSPA";
          i1 = 3;
          break;
        case 12: 
          localObject1 = "NETWORK_TYPE_EVDO_B";
          i1 = 3;
          break;
        case 14: 
          localObject1 = "NETWORK_TYPE_EHRPD";
          i1 = 3;
          break;
        case 15: 
          localObject1 = "NETWORK_TYPE_HSPAP";
          i1 = 3;
          break;
        case 13: 
          i1 = 4;
          localObject1 = "NETWORK_TYPE_LTE";
          break;
          label432:
          if ((((String)localObject2).equals("01")) || (((String)localObject2).equals("06")) || (((String)localObject2).equals("09")))
          {
            i2 = 2;
          }
          else if ((((String)localObject2).equals("03")) || (((String)localObject2).equals("05")))
          {
            i2 = 3;
          }
          else
          {
            i2 = i3;
            if (((String)localObject2).equals("20")) {
              i2 = 4;
            }
          }
          break;
        }
      }
      String str = "NETWORK_TYPE_NO";
      i1 = 0;
    }
  }
  
  public int getNetworkType()
  {
    return HttpUtil.a();
  }
  
  public boolean getPlayMode(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      for (;;)
      {
        return true;
        try
        {
          paramString = new JSONObject(paramString);
          paramString = paramString.optString("callback");
          if (!TextUtils.isEmpty(paramString))
          {
            this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a().b(new hia(this, paramString));
            return true;
          }
        }
        catch (JSONException paramString)
        {
          paramString.printStackTrace();
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.TAG, 2, "getPlayMode json err");
    return true;
  }
  
  public boolean getPlayState(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      for (;;)
      {
        return true;
        try
        {
          paramString = new JSONObject(paramString);
          paramString = paramString.optString("callback");
          if (!TextUtils.isEmpty(paramString))
          {
            this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a().a(new hik(this, paramString));
            return true;
          }
        }
        catch (JSONException paramString)
        {
          paramString.printStackTrace();
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.TAG, 2, "getPlayState json err");
    return true;
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map paramMap)
  {
    if (paramLong == 4L)
    {
      if (paramMap != null) {
        notifyCacheReady(((Integer)paramMap.get("code")).intValue());
      }
      return true;
    }
    return false;
  }
  
  public void isCached(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    paramString1 = HtmlOffline.d(paramString1);
    if (TextUtils.isEmpty(paramString1))
    {
      callJs(paramString2, new String[] { "-1" });
      return;
    }
    callJs(paramString2, new String[] { paramString1 });
  }
  
  public final String modelVersion()
  {
    return Build.MODEL;
  }
  
  public boolean notifyCacheReady(int paramInt)
  {
    String str;
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      str = "";
      if (paramInt == 0) {
        str = "success";
      }
    }
    for (;;)
    {
      callJs(this.jdField_b_of_type_JavaLangString, new String[] { Integer.toString(paramInt), Util.b(str) });
      return true;
      if (paramInt == 1)
      {
        str = "param error";
        continue;
        if (paramInt == 5)
        {
          str = "had update ";
          continue;
          return false;
        }
      }
      else if (paramInt == 2)
      {
        str = "download error";
      }
      else if (paramInt == 3)
      {
        str = "no sdcard";
      }
      else
      {
        if (paramInt != 4) {
          break;
        }
        str = "other ";
      }
    }
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    if (paramInt != -1) {}
    Activity localActivity;
    do
    {
      do
      {
        return;
      } while ((paramByte != 1) || (paramIntent == null) || (!paramIntent.getBooleanExtra("closeSpecialLogic", false)) || (!this.jdField_a_of_type_Boolean));
      localActivity = this.mRuntime.a();
    } while (localActivity == null);
    localActivity.setResult(-1, paramIntent);
    localActivity.finish();
  }
  
  protected void onCreate()
  {
    super.onCreate();
    a();
    this.jdField_a_of_type_AndroidAppActivity = this.mRuntime.a();
    if (this.mRuntime.a() != null) {
      this.jdField_c_of_type_JavaLangString = this.mRuntime.a().a();
    }
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
  }
  
  public void onDestroy()
  {
    release();
  }
  
  protected void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this.mRuntime.a());
  }
  
  public final void openLinkInNewWebView(String paramString1, String paramString2)
  {
    PluginJumpManager.getInstance().updateConfig(((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).getAppRuntime());
    PluginJumpManager.getInstance().loadConfig();
    if (PluginJumpManager.getInstance().openView((BaseActivity)this.jdField_a_of_type_AndroidAppActivity, paramString1, paramString2)) {}
    while ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    Bundle localBundle2 = this.jdField_a_of_type_AndroidAppActivity.getIntent().getExtras();
    Bundle localBundle1;
    if (localBundle2 == null) {
      localBundle1 = new Bundle();
    }
    try
    {
      for (;;)
      {
        i1 = Integer.valueOf(paramString2).intValue();
        switch (i1)
        {
        default: 
          paramString2 = new Intent(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getClass());
          paramString2.putExtras(localBundle1);
          paramString2.putExtra("url", paramString1);
          paramString2.setFlags(0);
          paramString1 = this.mRuntime.a(this.mRuntime.a());
          if ((paramString1 != null) && ((paramString1 instanceof WebUiUtils.WebUiMethodInterface)))
          {
            paramString1 = ((WebUiUtils.WebUiMethodInterface)paramString1).getCurrentUrl();
            if ((!TextUtils.isEmpty(paramString1)) && (paramString1.contains("closeSpecialLogic")) && (URLUtil.a(URLUtil.a(paramString1), "closeSpecialLogic", 0) != 0)) {
              this.jdField_a_of_type_Boolean = true;
            }
          }
          if (!this.jdField_a_of_type_Boolean) {
            break label410;
          }
          startActivityForResult(paramString2, (byte)1);
          return;
          localBundle2.remove("title");
          localBundle2.remove("leftViewText");
          localBundle2.remove("post_data");
          localBundle2.remove("options");
          localBundle1 = localBundle2;
          if (localBundle2.containsKey("startOpenPageTime"))
          {
            localBundle2.putLong("startOpenPageTime", System.currentTimeMillis());
            localBundle1 = localBundle2;
          }
          break;
        }
      }
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        int i1 = 0;
        continue;
        localBundle1.putBoolean("hide_more_button", false);
        localBundle1.putBoolean("hide_operation_bar", true);
        continue;
        localBundle1.putBoolean("hide_more_button", true);
        localBundle1.putBoolean("hide_operation_bar", true);
        continue;
        localBundle1.putBoolean("hide_more_button", false);
        localBundle1.putBoolean("hide_operation_bar", false);
        localBundle1.putString("webStyle", "");
        continue;
        localBundle1.putBoolean("hide_more_button", true);
        localBundle1.putBoolean("hide_operation_bar", false);
        localBundle1.putString("webStyle", "");
      }
      label410:
      this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(paramString2, 100);
    }
  }
  
  public boolean pausePlayMusic()
  {
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a().a();
    return true;
  }
  
  public final void phoneVibrate(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      try
      {
        l1 = Long.valueOf(paramString).longValue();
        paramString = (Vibrator)this.jdField_a_of_type_AndroidAppActivity.getSystemService("vibrator");
        if (paramString == null) {
          continue;
        }
        paramString.vibrate(l1);
        return;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          long l1 = 0L;
        }
      }
    }
  }
  
  public boolean playVoice(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    do
    {
      do
      {
        return false;
        if (this.jdField_a_of_type_AndroidMediaSoundPool == null) {
          this.jdField_a_of_type_AndroidMediaSoundPool = new SoundPool(10, 3, 0);
        }
        if (this.jdField_a_of_type_JavaUtilHashMap == null) {
          this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
        }
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString2)) {
          break;
        }
      } while (!preloadVoice(paramString1, paramString2, null));
      if (Build.VERSION.SDK_INT >= 8) {
        this.jdField_a_of_type_AndroidMediaSoundPool.setOnLoadCompleteListener(new hic(this, paramString2));
      }
      int i1;
      do
      {
        for (;;)
        {
          return true;
          i1 = ((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramString2)).intValue();
          if (this.jdField_a_of_type_AndroidOsHandler != null) {
            this.jdField_a_of_type_AndroidOsHandler.postDelayed(new hid(this, i1, paramString2), 200L);
          }
        }
        i1 = ((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramString2)).intValue();
      } while (this.jdField_a_of_type_AndroidMediaSoundPool.play(i1, 1.0F, 1.0F, 0, 0, 1.0F) != 0);
    } while (!QLog.isColorLevel());
    QLog.d("SensorApi", 2, "play failure url=" + paramString2);
    return false;
  }
  
  public boolean preloadVoice(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString2)) || ((this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString2)))) {
      return false;
    }
    String str = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator;
    paramString3 = new StringBuilder();
    paramString3.append(str);
    paramString3.append("tencent/MobileQQ/qbiz/html5/");
    paramString3.append(paramString1);
    paramString3.append('/');
    str = Uri.parse(paramString2).getScheme();
    paramString1 = "";
    if (str != null) {
      paramString1 = str + "://";
    }
    if (paramString2.length() >= paramString1.length()) {
      paramString3.append(paramString2.substring(paramString1.length()));
    }
    paramString1 = new File(paramString3.toString());
    if (!paramString1.exists()) {
      return false;
    }
    if (this.jdField_a_of_type_AndroidMediaSoundPool == null) {
      this.jdField_a_of_type_AndroidMediaSoundPool = new SoundPool(10, 3, 0);
    }
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    if (Build.VERSION.SDK_INT >= 8) {
      this.jdField_a_of_type_AndroidMediaSoundPool.setOnLoadCompleteListener(null);
    }
    int i1 = this.jdField_a_of_type_AndroidMediaSoundPool.load(paramString1.getAbsolutePath(), 1);
    if (i1 == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SensorApi", 2, "load failure url=" + paramString2);
      }
      return false;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString2, Integer.valueOf(i1));
    return true;
  }
  
  public final String qqVersion()
  {
    try
    {
      Object localObject = this.mRuntime.a(this.mRuntime.a());
      if ((localObject != null) && ((localObject instanceof WebUiUtils.VipComicUiInterface))) {
        return this.jdField_a_of_type_AndroidAppActivity.getPackageManager().getPackageInfo("com.tencent.mobileqq", 0).versionName;
      }
      localObject = this.jdField_a_of_type_AndroidAppActivity.getPackageManager().getPackageInfo(this.jdField_a_of_type_AndroidAppActivity.getPackageName(), 0).versionName;
      return (String)localObject;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      localNameNotFoundException.printStackTrace();
    }
    return "";
  }
  
  public void refreshOfflineCache()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      WebView localWebView = (WebView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localWebView != null) {
        localWebView.loadUrl(localWebView.getUrl());
      }
    }
  }
  
  public void release()
  {
    if (this.jdField_a_of_type_AndroidMediaSoundPool != null)
    {
      this.jdField_a_of_type_AndroidMediaSoundPool.release();
      this.jdField_a_of_type_AndroidMediaSoundPool = null;
    }
    if (jdField_a_of_type_ComTencentBizGameMSFToWebViewConnector != null)
    {
      jdField_a_of_type_ComTencentBizGameMSFToWebViewConnector.a();
      jdField_a_of_type_ComTencentBizGameMSFToWebViewConnector = null;
    }
    stopAccelerometer();
    stopCompass();
    stopListen();
    stopLight();
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      this.jdField_a_of_type_JavaLangRefWeakReference.clear();
    }
    if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient != null) {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b();
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
  }
  
  public boolean resumePlayMusic()
  {
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a().b();
    return true;
  }
  
  public void returnToAIO()
  {
    if ("Meizu_M040".equals(Build.MANUFACTURER + "_" + Build.MODEL))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Sensor", 2, "meizu mx2 returnToAIO");
      }
      new Handler().postDelayed(new hie(this), 400L);
      return;
    }
    this.jdField_a_of_type_AndroidAppActivity.setResult(4660);
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
  
  public void sendFunnyFace(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    try
    {
      int i1 = Integer.parseInt(paramString5);
      paramString1 = AIOUtils.a(new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class), null);
      paramString1.putExtra("indexOfFunnyFaceClickedInWebview", i1);
      paramString2 = this.jdField_a_of_type_AndroidAppActivity.getIntent();
      if (paramString2 != null)
      {
        paramString2 = (SessionInfo)paramString2.getParcelableExtra("sessionInfo");
        if (paramString2 != null)
        {
          ChatActivityUtils.a(paramString2, paramString1);
          paramString1.putExtra("sessionInfo", paramString2);
          this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString1);
        }
      }
      return;
    }
    catch (Exception paramString1) {}
  }
  
  public boolean setPlayMode(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      for (;;)
      {
        return true;
        try
        {
          paramString = new JSONObject(paramString);
          int i1 = paramString.optInt("mode", -1);
          if (i1 != -1)
          {
            this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a().a(i1);
            return true;
          }
        }
        catch (JSONException paramString)
        {
          paramString.printStackTrace();
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.TAG, 2, "setPlayMode json err");
    return true;
  }
  
  public final void startAccelerometer(String paramString)
  {
    if (this.jdField_a_of_type_AndroidHardwareSensorManager == null) {
      this.jdField_a_of_type_AndroidHardwareSensorManager = ((SensorManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("sensor"));
    }
    Object localObject = this.jdField_a_of_type_AndroidHardwareSensorManager.getSensorList(1);
    if (((List)localObject).size() > 0)
    {
      localObject = (Sensor)((List)localObject).get(0);
      if (this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript$QQSensorEventListener != null) {
        stopAccelerometer();
      }
      this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript$QQSensorEventListener = new SensorAPIJavaScript.QQSensorEventListener(this, (byte)0, paramString);
      this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript$QQSensorEventListener, (Sensor)localObject, 0);
      return;
    }
    callJs(paramString, new String[] { "false" });
  }
  
  public final void startCompass(String paramString)
  {
    if (this.jdField_a_of_type_AndroidHardwareSensorManager == null) {
      this.jdField_a_of_type_AndroidHardwareSensorManager = ((SensorManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("sensor"));
    }
    Object localObject = this.jdField_a_of_type_AndroidHardwareSensorManager.getSensorList(3);
    if (((List)localObject).size() > 0)
    {
      localObject = (Sensor)((List)localObject).get(0);
      if (this.jdField_c_of_type_ComTencentBizGameSensorAPIJavaScript$QQSensorEventListener != null) {
        stopCompass();
      }
      this.jdField_c_of_type_ComTencentBizGameSensorAPIJavaScript$QQSensorEventListener = new SensorAPIJavaScript.QQSensorEventListener(this, (byte)2, paramString);
      this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this.jdField_c_of_type_ComTencentBizGameSensorAPIJavaScript$QQSensorEventListener, (Sensor)localObject, 0);
      return;
    }
    callJs(paramString, new String[] { "false" });
  }
  
  public final void startLight(String paramString)
  {
    if (this.jdField_a_of_type_AndroidHardwareSensorManager == null) {
      this.jdField_a_of_type_AndroidHardwareSensorManager = ((SensorManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("sensor"));
    }
    Object localObject = this.jdField_a_of_type_AndroidHardwareSensorManager.getSensorList(5);
    if (((List)localObject).size() > 0)
    {
      localObject = (Sensor)((List)localObject).get(0);
      if (this.jdField_b_of_type_ComTencentBizGameSensorAPIJavaScript$QQSensorEventListener != null) {
        stopLight();
      }
      this.jdField_b_of_type_ComTencentBizGameSensorAPIJavaScript$QQSensorEventListener = new SensorAPIJavaScript.QQSensorEventListener(this, (byte)1, paramString);
      this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this.jdField_b_of_type_ComTencentBizGameSensorAPIJavaScript$QQSensorEventListener, (Sensor)localObject, 0);
      return;
    }
    callJs(paramString, new String[] { "false" });
  }
  
  public final void startListen(String paramString)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      callJs(paramString, new String[] { "false" });
      return;
    }
    if (this.jdField_a_of_type_AndroidMediaMediaRecorder == null) {
      this.jdField_a_of_type_AndroidMediaMediaRecorder = new MediaRecorder();
    }
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaRecorder.setAudioSource(1);
      this.jdField_a_of_type_AndroidMediaMediaRecorder.setOutputFormat(3);
      this.jdField_a_of_type_AndroidMediaMediaRecorder.setAudioEncoder(0);
      this.jdField_a_of_type_AndroidMediaMediaRecorder.setOutputFile("/dev/null");
      this.jdField_a_of_type_AndroidMediaMediaRecorder.setMaxDuration(600000);
      this.jdField_a_of_type_AndroidMediaMediaRecorder.prepare();
      this.jdField_a_of_type_AndroidMediaMediaRecorder.start();
      a(paramString);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      callJs(paramString, new String[] { "false" });
      this.jdField_a_of_type_AndroidMediaMediaRecorder.release();
      this.jdField_a_of_type_AndroidMediaMediaRecorder = null;
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  public boolean startPlayMusic(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return true;
    }
    try
    {
      new JSONObject(paramString);
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a().a(paramString);
      return true;
    }
    catch (JSONException localJSONException)
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.TAG, 2, "playQQMusic err:" + paramString);
      }
      localJSONException.printStackTrace();
    }
    return true;
  }
  
  public void startSyncData(String paramString1, String paramString2)
  {
    if (jdField_a_of_type_ComTencentBizGameMSFToWebViewConnector == null) {
      jdField_a_of_type_ComTencentBizGameMSFToWebViewConnector = new MSFToWebViewConnector();
    }
    AppInterface localAppInterface = this.mRuntime.a();
    if (localAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SensorApi", 2, "appRuntime is null");
      }
      return;
    }
    jdField_a_of_type_ComTencentBizGameMSFToWebViewConnector.a(paramString1, paramString2, localAppInterface, this.jdField_a_of_type_AndroidAppActivity, new hig(this));
  }
  
  public final void stopAccelerometer()
  {
    if ((this.jdField_a_of_type_AndroidHardwareSensorManager != null) && (this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript$QQSensorEventListener != null))
    {
      this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript$QQSensorEventListener);
      this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript$QQSensorEventListener = null;
    }
  }
  
  public void stopCompass()
  {
    if ((this.jdField_a_of_type_AndroidHardwareSensorManager != null) && (this.jdField_c_of_type_ComTencentBizGameSensorAPIJavaScript$QQSensorEventListener != null))
    {
      this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this.jdField_c_of_type_ComTencentBizGameSensorAPIJavaScript$QQSensorEventListener);
      this.jdField_c_of_type_ComTencentBizGameSensorAPIJavaScript$QQSensorEventListener = null;
    }
  }
  
  public final void stopLight()
  {
    if ((this.jdField_a_of_type_AndroidHardwareSensorManager != null) && (this.jdField_b_of_type_ComTencentBizGameSensorAPIJavaScript$QQSensorEventListener != null))
    {
      this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this.jdField_b_of_type_ComTencentBizGameSensorAPIJavaScript$QQSensorEventListener);
      this.jdField_b_of_type_ComTencentBizGameSensorAPIJavaScript$QQSensorEventListener = null;
    }
  }
  
  public final void stopListen()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaRecorder != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaRecorder.release();
      this.jdField_a_of_type_AndroidMediaMediaRecorder = null;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(291);
    this.jdField_b_of_type_Boolean = false;
  }
  
  public boolean stopPlayMusic()
  {
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a().c();
    return true;
  }
  
  public void stopSyncData()
  {
    if (jdField_a_of_type_ComTencentBizGameMSFToWebViewConnector != null) {
      jdField_a_of_type_ComTencentBizGameMSFToWebViewConnector.a();
    }
    jdField_a_of_type_ComTencentBizGameMSFToWebViewConnector = null;
  }
  
  public final String systemName()
  {
    return "android";
  }
  
  public final String systemVersion()
  {
    return Build.VERSION.RELEASE;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\game\SensorAPIJavaScript.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */