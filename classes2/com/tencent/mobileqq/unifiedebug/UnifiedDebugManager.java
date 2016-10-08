package com.tencent.mobileqq.unifiedebug;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.biz.common.util.Util;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil.NetInfo;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.QbSdk;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import mqq.os.MqqHandler;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import vws;
import vwt;
import vwu;
import vwv;
import vww;
import vwx;
import vwy;

public class UnifiedDebugManager
{
  public static final int a = 5;
  public static final String a = "UnifiedDebugManager";
  private static final int jdField_b_of_type_Int = 30000;
  private static final String jdField_b_of_type_JavaLangString = ".localstorage";
  private static final int jdField_c_of_type_Int = 120000;
  private static final String jdField_c_of_type_JavaLangString = "cache";
  private static final String d = "cookies";
  private static final String e = "ItemTable";
  public Handler a;
  private ResultReceiver jdField_a_of_type_AndroidOsResultReceiver;
  public Map a;
  private final Queue jdField_a_of_type_JavaUtilQueue;
  
  public UnifiedDebugManager(SnapshotResultReceiver paramSnapshotResultReceiver)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilQueue = new LinkedList();
    this.jdField_a_of_type_AndroidOsResultReceiver = paramSnapshotResultReceiver;
    paramSnapshotResultReceiver = ThreadManager.a("UnifiedDebugMonitor", 0);
    paramSnapshotResultReceiver.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(paramSnapshotResultReceiver.getLooper());
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaUtilMap.put("offline_pkg", "sdcard/tencent/MobileQQ/qbiz/html5");
  }
  
  private String a(Context paramContext)
  {
    if (QbSdk.getTbsVersion(paramContext) < 30000)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UnifiedDebugManager", 2, "Local StoragePath = " + paramContext.getApplicationContext().getDir("database_web", 0).getPath());
      }
      return paramContext.getApplicationContext().getDir("database_web", 0).getPath();
    }
    if (QLog.isColorLevel()) {
      QLog.d("UnifiedDebugManager", 2, "Local StoragePath = " + paramContext.getApplicationContext().getDir("webview", 0).getPath() + "/Local Storage/");
    }
    return paramContext.getApplicationContext().getDir("webview", 0).getPath() + "/Local Storage/";
  }
  
  private String a(Context paramContext, int paramInt)
  {
    if (paramInt < 30000) {
      return paramContext.getDatabasePath("webview_x5.db").getPath();
    }
    return paramContext.getApplicationContext().getDir("webview", 0).getPath() + "/Cookies";
  }
  
  private Map a(String paramString)
  {
    Object localObject = new BasicHttpParams();
    HttpConnectionParams.setConnectionTimeout((HttpParams)localObject, 10000);
    HttpConnectionParams.setSoTimeout((HttpParams)localObject, 10000);
    localObject = new DefaultHttpClient((HttpParams)localObject);
    paramString = new HttpGet(paramString);
    long l1 = System.currentTimeMillis();
    paramString = ((HttpClient)localObject).execute(paramString);
    long l2 = System.currentTimeMillis();
    int i = paramString.getStatusLine().getStatusCode();
    localObject = new HashMap();
    ((Map)localObject).put("status", Integer.valueOf(i));
    ((Map)localObject).put("downloadTime", Long.valueOf(l2 - l1));
    if (i / 100 == 2) {
      ((Map)localObject).put("size", Integer.valueOf(EntityUtils.toByteArray(paramString.getEntity()).length));
    }
    return (Map)localObject;
  }
  
  public static void a(Application paramApplication)
  {
    SharedPreferences localSharedPreferences = paramApplication.getSharedPreferences("x5_proxy_setting", 4);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    localEditor.remove("http_proxy_address");
    localEditor.putBoolean("post_encription", true);
    localEditor.remove("qproxy_address");
    localEditor.putInt("connect_status", 0);
    localEditor.remove("qproxy_address_lists");
    localEditor.commit();
    a(paramApplication);
    ThreadManager.a().postDelayed(new vwx(paramApplication), 2000L);
    if (QLog.isColorLevel())
    {
      QLog.d("UnifiedDebugManager", 2, "unset x5 proxy");
      QLog.d("UnifiedDebugManager", 2, "http_proxy_address: " + localSharedPreferences.getString("http_proxy_address", "no proxy"));
      QLog.d("UnifiedDebugManager", 2, "qproxy_address_lists: " + localSharedPreferences.getString("qproxy_address_lists", "no proxy"));
    }
  }
  
  public static void a(Application paramApplication, String paramString, int paramInt)
  {
    SharedPreferences localSharedPreferences = paramApplication.getSharedPreferences("x5_proxy_setting", 4);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    localEditor.putString("http_proxy_address", paramString + ":" + paramInt);
    localEditor.putBoolean("post_encription", false);
    localEditor.putString("qproxy_address", "http://" + paramString + ":" + paramInt);
    localEditor.putInt("connect_status", 1);
    localEditor.putString("qproxy_address_lists", paramString + ":" + paramInt);
    localEditor.commit();
    Utils.a(paramApplication, "com.tencent.mobileqq:web");
    if (QLog.isColorLevel())
    {
      QLog.d("UnifiedDebugManager", 2, "set x5 proxy: " + paramString + ":" + paramInt);
      QLog.d("UnifiedDebugManager", 2, "http_proxy_address: " + localSharedPreferences.getString("http_proxy_address", "no proxy"));
      QLog.d("UnifiedDebugManager", 2, "qproxy_address_lists: " + localSharedPreferences.getString("qproxy_address_lists", "no proxy"));
      QLog.d("UnifiedDebugManager", 2, "sQQBrowserActivityCounter =  " + QQBrowserActivity.K);
    }
  }
  
  public static void a(Context paramContext)
  {
    Intent localIntent = new Intent("android.intent.action.ultimatesnapshot");
    localIntent.putExtra("action", 1);
    localIntent.putExtra("id", 0L);
    paramContext.sendBroadcast(localIntent);
    if (QLog.isColorLevel()) {
      QLog.d("UnifiedDebugManager", 2, "send broadcast to finish all alive webview");
    }
  }
  
  public static boolean a(Application paramApplication)
  {
    Object localObject = ((ActivityManager)paramApplication.getSystemService("activity")).getRunningAppProcesses();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
        String str = localRunningAppProcessInfo.processName;
        if ((str.startsWith("com.tencent.mobileqq")) && (str.indexOf(':') != -1) && (str.endsWith(":web"))) {
          if ((localRunningAppProcessInfo.importance != 100) && ((localRunningAppProcessInfo.importance != 200) || ((localRunningAppProcessInfo.importance == 200) && (localRunningAppProcessInfo.importanceReasonCode != 0))))
          {
            Utils.a(paramApplication, "com.tencent.mobileqq:web");
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public static boolean a(Context paramContext)
  {
    return paramContext.getSharedPreferences("x5_proxy_setting", 4).contains("http_proxy_address");
  }
  
  private String c(String paramString)
  {
    Object localObject = MessageDigest.getInstance("SHA-1");
    ((MessageDigest)localObject).update(paramString.getBytes());
    paramString = ((MessageDigest)localObject).digest();
    localObject = new StringBuffer();
    int i = 0;
    while (i < paramString.length)
    {
      String str = Integer.toHexString(paramString[i] & 0xFF);
      if (str.length() < 2) {
        ((StringBuffer)localObject).append(0);
      }
      ((StringBuffer)localObject).append(str);
      i += 1;
    }
    return ((StringBuffer)localObject).toString();
  }
  
  private void c(Context paramContext, String paramString1, int paramInt, long paramLong1, long paramLong2, String paramString2)
  {
    Intent localIntent = new Intent(paramContext, SnapshotService.class);
    localIntent.setFlags(268435456);
    localIntent.putExtra("debugUrl", paramString1);
    localIntent.putExtra("seq", paramLong2);
    localIntent.putExtra("seqKey", paramString2);
    localIntent.putExtra("delay", paramLong1);
    localIntent.putExtra("maxSnapshotCount", paramInt);
    localIntent.putExtra("callback", this.jdField_a_of_type_AndroidOsResultReceiver);
    paramContext.startActivity(localIntent);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new vww(this, paramLong2, paramContext, paramString1, paramInt, paramLong1, paramString2), 120000L + paramLong1);
  }
  
  private String d(String paramString)
  {
    return new URL(paramString).getHost();
  }
  
  public Handler a()
  {
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  public UnifiedDebugManager.TerminalInfo a(Context paramContext)
  {
    UnifiedDebugManager.TerminalInfo localTerminalInfo = new UnifiedDebugManager.TerminalInfo(this);
    localTerminalInfo.jdField_a_of_type_JavaLangString = (DeviceInfoUtil.h() + " " + DeviceInfoUtil.d());
    localTerminalInfo.jdField_b_of_type_JavaLangString = Build.VERSION.RELEASE;
    localTerminalInfo.c = "6.5.5.2880";
    DeviceInfoUtil.NetInfo localNetInfo = DeviceInfoUtil.a(paramContext);
    localTerminalInfo.d = localNetInfo.jdField_a_of_type_JavaLangString;
    localTerminalInfo.e = localNetInfo.c;
    localTerminalInfo.jdField_a_of_type_Int = DeviceInfoUtil.b();
    localTerminalInfo.jdField_a_of_type_Long = DeviceInfoUtil.a();
    localTerminalInfo.jdField_b_of_type_Long = DeviceInfoUtil.c();
    localTerminalInfo.f = DeviceInfoUtil.g();
    localTerminalInfo.jdField_a_of_type_Boolean = a(paramContext);
    localTerminalInfo.jdField_b_of_type_Int = QbSdk.getTbsVersion(paramContext);
    if (localTerminalInfo.jdField_b_of_type_Int == 0) {}
    for (boolean bool = false;; bool = true)
    {
      localTerminalInfo.jdField_b_of_type_Boolean = bool;
      return localTerminalInfo;
    }
  }
  
  public String a()
  {
    UnifiedCommandUtil.ExecResult localExecResult = UnifiedCommandUtil.a("getprop net.dns1");
    if (localExecResult.jdField_a_of_type_Boolean)
    {
      if (!localExecResult.jdField_a_of_type_JavaUtilList.isEmpty()) {
        return (String)localExecResult.jdField_a_of_type_JavaUtilList.get(0);
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.d("UnifiedDebugManager", 2, localExecResult.jdField_a_of_type_JavaLangString);
    }
    return "";
  }
  
  /* Error */
  public String a(long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: invokestatic 586	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   3: astore 5
    //   5: aload 5
    //   7: lload_1
    //   8: invokevirtual 590	java/util/Calendar:setTimeInMillis	(J)V
    //   11: invokestatic 586	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   14: astore 6
    //   16: aload 6
    //   18: lload_3
    //   19: invokevirtual 590	java/util/Calendar:setTimeInMillis	(J)V
    //   22: invokestatic 173	java/lang/System:currentTimeMillis	()J
    //   25: lstore 23
    //   27: lload_3
    //   28: lload 23
    //   30: lcmp
    //   31: iflt +10 -> 41
    //   34: aload 6
    //   36: lload 23
    //   38: invokevirtual 590	java/util/Calendar:setTimeInMillis	(J)V
    //   41: aload 5
    //   43: iconst_1
    //   44: invokevirtual 592	java/util/Calendar:get	(I)I
    //   47: istore 14
    //   49: aload 5
    //   51: iconst_2
    //   52: invokevirtual 592	java/util/Calendar:get	(I)I
    //   55: istore 15
    //   57: aload 5
    //   59: iconst_5
    //   60: invokevirtual 592	java/util/Calendar:get	(I)I
    //   63: istore 16
    //   65: aload 5
    //   67: bipush 10
    //   69: invokevirtual 592	java/util/Calendar:get	(I)I
    //   72: istore 17
    //   74: aload 6
    //   76: iconst_1
    //   77: invokevirtual 592	java/util/Calendar:get	(I)I
    //   80: istore 18
    //   82: aload 6
    //   84: iconst_2
    //   85: invokevirtual 592	java/util/Calendar:get	(I)I
    //   88: istore 19
    //   90: aload 6
    //   92: iconst_5
    //   93: invokevirtual 592	java/util/Calendar:get	(I)I
    //   96: istore 20
    //   98: aload 6
    //   100: bipush 10
    //   102: invokevirtual 592	java/util/Calendar:get	(I)I
    //   105: istore 21
    //   107: new 594	java/util/HashSet
    //   110: dup
    //   111: invokespecial 595	java/util/HashSet:<init>	()V
    //   114: astore 9
    //   116: iconst_0
    //   117: istore 13
    //   119: invokestatic 599	com/tencent/qphone/base/util/QLog:getLogFileFormatter	()Ljava/text/SimpleDateFormat;
    //   122: lload_1
    //   123: invokestatic 206	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   126: invokevirtual 605	java/text/SimpleDateFormat:format	(Ljava/lang/Object;)Ljava/lang/String;
    //   129: astore 5
    //   131: aload 9
    //   133: aload 5
    //   135: invokevirtual 609	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   138: pop
    //   139: iload 13
    //   141: istore 12
    //   143: iload 13
    //   145: ifne +10 -> 155
    //   148: aload 5
    //   150: invokevirtual 436	java/lang/String:length	()I
    //   153: istore 12
    //   155: lload_1
    //   156: ldc2_w 610
    //   159: ladd
    //   160: lstore 23
    //   162: iload 12
    //   164: istore 13
    //   166: lload 23
    //   168: lstore_1
    //   169: lload 23
    //   171: lload_3
    //   172: lcmp
    //   173: ifle -54 -> 119
    //   176: new 613	java/util/ArrayList
    //   179: dup
    //   180: invokespecial 614	java/util/ArrayList:<init>	()V
    //   183: astore 8
    //   185: new 121	java/io/File
    //   188: dup
    //   189: invokestatic 617	com/tencent/qphone/base/util/QLog:getLogPath	()Ljava/lang/String;
    //   192: invokespecial 618	java/io/File:<init>	(Ljava/lang/String;)V
    //   195: astore 7
    //   197: aload 7
    //   199: invokevirtual 621	java/io/File:exists	()Z
    //   202: ifeq +183 -> 385
    //   205: aload 7
    //   207: invokevirtual 625	java/io/File:listFiles	()[Ljava/io/File;
    //   210: astore 10
    //   212: aload 10
    //   214: ifnull +177 -> 391
    //   217: aload 10
    //   219: arraylength
    //   220: istore 22
    //   222: iconst_0
    //   223: istore 13
    //   225: iload 13
    //   227: iload 22
    //   229: if_icmpge +162 -> 391
    //   232: aload 10
    //   234: iload 13
    //   236: aaload
    //   237: astore 11
    //   239: aload 11
    //   241: invokevirtual 628	java/io/File:getName	()Ljava/lang/String;
    //   244: astore 6
    //   246: aload 6
    //   248: ldc_w 630
    //   251: invokevirtual 395	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   254: ifeq +12 -> 266
    //   257: iload 13
    //   259: iconst_1
    //   260: iadd
    //   261: istore 13
    //   263: goto -38 -> 225
    //   266: aload 6
    //   268: ldc_w 632
    //   271: invokevirtual 395	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   274: ifeq +78 -> 352
    //   277: aload 6
    //   279: iconst_0
    //   280: aload 6
    //   282: invokevirtual 436	java/lang/String:length	()I
    //   285: iconst_4
    //   286: isub
    //   287: invokevirtual 636	java/lang/String:substring	(II)Ljava/lang/String;
    //   290: astore 5
    //   292: aload 5
    //   294: getstatic 639	com/tencent/qphone/base/util/QLog:packageName	Ljava/lang/String;
    //   297: invokevirtual 386	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   300: ifeq -43 -> 257
    //   303: aload 5
    //   305: aload 5
    //   307: invokevirtual 436	java/lang/String:length	()I
    //   310: iload 12
    //   312: isub
    //   313: invokevirtual 641	java/lang/String:substring	(I)Ljava/lang/String;
    //   316: astore 5
    //   318: aload 5
    //   320: invokestatic 646	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   323: ifne -66 -> 257
    //   326: aload 9
    //   328: aload 5
    //   330: invokevirtual 648	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   333: ifeq -76 -> 257
    //   336: aload 8
    //   338: aload 11
    //   340: invokevirtual 125	java/io/File:getPath	()Ljava/lang/String;
    //   343: invokeinterface 649 2 0
    //   348: pop
    //   349: goto -92 -> 257
    //   352: aload 6
    //   354: astore 5
    //   356: aload 6
    //   358: ldc_w 651
    //   361: invokevirtual 395	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   364: ifeq -72 -> 292
    //   367: aload 6
    //   369: iconst_0
    //   370: aload 6
    //   372: invokevirtual 436	java/lang/String:length	()I
    //   375: iconst_5
    //   376: isub
    //   377: invokevirtual 636	java/lang/String:substring	(II)Ljava/lang/String;
    //   380: astore 5
    //   382: goto -90 -> 292
    //   385: aload 7
    //   387: invokevirtual 654	java/io/File:mkdirs	()Z
    //   390: pop
    //   391: aconst_null
    //   392: astore 6
    //   394: aload 7
    //   396: invokevirtual 621	java/io/File:exists	()Z
    //   399: ifeq +347 -> 746
    //   402: new 121	java/io/File
    //   405: dup
    //   406: aload 7
    //   408: ldc_w 656
    //   411: invokespecial 659	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   414: astore 5
    //   416: new 661	java/io/BufferedWriter
    //   419: dup
    //   420: new 663	java/io/OutputStreamWriter
    //   423: dup
    //   424: new 665	java/io/FileOutputStream
    //   427: dup
    //   428: aload 5
    //   430: invokespecial 668	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   433: invokespecial 671	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   436: invokespecial 674	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   439: astore 6
    //   441: aload 6
    //   443: ifnull +75 -> 518
    //   446: aload 7
    //   448: invokevirtual 625	java/io/File:listFiles	()[Ljava/io/File;
    //   451: astore 7
    //   453: aload 7
    //   455: ifnull +63 -> 518
    //   458: aload 7
    //   460: arraylength
    //   461: istore 13
    //   463: iconst_0
    //   464: istore 12
    //   466: iload 12
    //   468: iload 13
    //   470: if_icmpge +48 -> 518
    //   473: aload 7
    //   475: iload 12
    //   477: aaload
    //   478: astore 9
    //   480: aload 6
    //   482: new 100	java/lang/StringBuilder
    //   485: dup
    //   486: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   489: aload 9
    //   491: invokevirtual 628	java/io/File:getName	()Ljava/lang/String;
    //   494: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: ldc_w 676
    //   500: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   506: invokevirtual 679	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   509: iload 12
    //   511: iconst_1
    //   512: iadd
    //   513: istore 12
    //   515: goto -49 -> 466
    //   518: aload 6
    //   520: invokevirtual 682	java/io/BufferedWriter:flush	()V
    //   523: aload 6
    //   525: invokevirtual 685	java/io/BufferedWriter:close	()V
    //   528: aload 5
    //   530: ifnull +16 -> 546
    //   533: aload 8
    //   535: aload 5
    //   537: invokevirtual 125	java/io/File:getPath	()Ljava/lang/String;
    //   540: invokeinterface 649 2 0
    //   545: pop
    //   546: new 121	java/io/File
    //   549: dup
    //   550: ldc_w 687
    //   553: invokespecial 618	java/io/File:<init>	(Ljava/lang/String;)V
    //   556: astore 5
    //   558: aload 5
    //   560: invokevirtual 621	java/io/File:exists	()Z
    //   563: ifeq +16 -> 579
    //   566: aload 8
    //   568: aload 5
    //   570: invokevirtual 125	java/io/File:getPath	()Ljava/lang/String;
    //   573: invokeinterface 649 2 0
    //   578: pop
    //   579: new 100	java/lang/StringBuilder
    //   582: dup
    //   583: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   586: invokestatic 617	com/tencent/qphone/base/util/QLog:getLogPath	()Ljava/lang/String;
    //   589: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: iload 14
    //   594: invokevirtual 297	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   597: ldc_w 689
    //   600: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   603: iload 15
    //   605: iconst_1
    //   606: iadd
    //   607: invokevirtual 297	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   610: ldc_w 689
    //   613: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   616: iload 16
    //   618: invokevirtual 297	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   621: ldc_w 689
    //   624: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   627: iload 17
    //   629: invokevirtual 297	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   632: ldc_w 691
    //   635: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   638: iload 18
    //   640: invokevirtual 297	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   643: ldc_w 689
    //   646: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   649: iload 19
    //   651: iconst_1
    //   652: iadd
    //   653: invokevirtual 297	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   656: ldc_w 689
    //   659: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   662: iload 20
    //   664: invokevirtual 297	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   667: ldc_w 689
    //   670: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   673: iload 21
    //   675: invokevirtual 297	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   678: ldc_w 630
    //   681: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   684: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   687: astore 5
    //   689: aload 8
    //   691: aload 5
    //   693: invokestatic 696	com/tencent/mobileqq/unifiedebug/UnifiedFileUtil:a	(Ljava/util/List;Ljava/lang/String;)V
    //   696: aload 5
    //   698: areturn
    //   699: astore 7
    //   701: aload 6
    //   703: astore 5
    //   705: aload 7
    //   707: astore 6
    //   709: ldc 10
    //   711: iconst_1
    //   712: new 100	java/lang/StringBuilder
    //   715: dup
    //   716: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   719: ldc_w 698
    //   722: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   725: aload 6
    //   727: invokevirtual 701	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   730: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   733: aload 6
    //   735: invokestatic 704	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   738: goto -210 -> 528
    //   741: astore 6
    //   743: goto -34 -> 709
    //   746: aconst_null
    //   747: astore 5
    //   749: goto -221 -> 528
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	752	0	this	UnifiedDebugManager
    //   0	752	1	paramLong1	long
    //   0	752	3	paramLong2	long
    //   3	745	5	localObject1	Object
    //   14	720	6	localObject2	Object
    //   741	1	6	localException1	Exception
    //   195	279	7	localObject3	Object
    //   699	7	7	localException2	Exception
    //   183	507	8	localArrayList	ArrayList
    //   114	376	9	localHashSet	HashSet
    //   210	23	10	arrayOfFile	File[]
    //   237	102	11	localFile	File
    //   141	373	12	i	int
    //   117	354	13	j	int
    //   47	546	14	k	int
    //   55	552	15	m	int
    //   63	554	16	n	int
    //   72	556	17	i1	int
    //   80	559	18	i2	int
    //   88	565	19	i3	int
    //   96	567	20	i4	int
    //   105	569	21	i5	int
    //   220	10	22	i6	int
    //   25	145	23	l	long
    // Exception table:
    //   from	to	target	type
    //   394	416	699	java/lang/Exception
    //   416	441	741	java/lang/Exception
    //   446	453	741	java/lang/Exception
    //   458	463	741	java/lang/Exception
    //   480	509	741	java/lang/Exception
    //   518	528	741	java/lang/Exception
  }
  
  public String a(Context paramContext, String paramString)
  {
    paramString = new URL(paramString);
    Object localObject1 = paramString.getProtocol();
    paramString = paramString.getHost();
    localObject1 = (String)localObject1 + "_" + paramString + "_";
    paramContext = new File(a(paramContext));
    if ((paramContext.exists()) && (paramContext.isDirectory()))
    {
      String[] arrayOfString = paramContext.list(new vwu(this, (String)localObject1));
      localObject1 = new ArrayList();
      File localFile = new File(paramContext, "json.txt");
      BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(new FileOutputStream(localFile));
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("host", paramString);
      JSONArray localJSONArray = new JSONArray();
      if ((arrayOfString != null) && (arrayOfString.length > 0))
      {
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          Object localObject2 = arrayOfString[i];
          localObject2 = SQLiteDatabase.openDatabase(paramContext.getPath() + "/" + (String)localObject2, null, 1);
          Cursor localCursor = ((SQLiteDatabase)localObject2).query("ItemTable", new String[] { "key", "value" }, null, null, null, null, null);
          while (localCursor.moveToNext())
          {
            String str1 = localCursor.getString(0);
            String str2 = new String(localCursor.getBlob(1), "UTF-16LE");
            JSONObject localJSONObject2 = new JSONObject();
            localJSONObject2.put("key", str1);
            localJSONObject2.put("value", str2);
            localJSONArray.put(localJSONObject2);
          }
          if (QLog.isColorLevel()) {
            QLog.d("UnifiedDebugManager", 2, "zipLocalStorage value = " + localJSONArray.toString());
          }
          localCursor.close();
          ((SQLiteDatabase)localObject2).close();
          i += 1;
        }
      }
      localJSONObject1.put("data", localJSONArray);
      localBufferedOutputStream.write(localJSONObject1.toString().getBytes());
      localBufferedOutputStream.flush();
      localBufferedOutputStream.close();
      ((List)localObject1).add(localFile.getPath());
      if (!((List)localObject1).isEmpty())
      {
        paramContext = paramContext.getPath() + "/localstorage_" + paramString + ".zip";
        UnifiedFileUtil.a((List)localObject1, paramContext);
        UnifiedFileUtil.a((List)localObject1);
        return paramContext;
      }
    }
    return null;
  }
  
  public String a(Context paramContext, List paramList)
  {
    int i = QbSdk.getTbsVersion(paramContext);
    ArrayList localArrayList = new ArrayList();
    Object localObject2;
    if (i < 30000)
    {
      localObject1 = paramContext.getDatabasePath("webviewCache_x5.db").getPath();
      paramContext = new File(paramContext.getCacheDir(), "webviewCache");
      localObject1 = SQLiteDatabase.openDatabase((String)localObject1, null, 0);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject2 = (String)paramList.next();
        localObject2 = ((SQLiteDatabase)localObject1).query("cache", new String[] { "url", "filepath" }, "url=?", new String[] { localObject2 }, null, null, null);
        while (((Cursor)localObject2).moveToNext()) {
          localArrayList.add(new File(paramContext, ((Cursor)localObject2).getString(1)).getPath());
        }
        ((Cursor)localObject2).close();
      }
      ((SQLiteDatabase)localObject1).close();
      paramContext = paramContext.getPath() + "/html_cache.zip";
      UnifiedFileUtil.a(localArrayList, paramContext);
      return paramContext;
    }
    paramContext = paramContext.getApplicationContext().getDir("webview", 0).getPath() + "/Cache/";
    Object localObject1 = new File(paramContext);
    if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject2 = ((File)localObject1).list(new vws(this, c((String)paramList.next()).substring(0, 16)));
        if (localObject2 != null)
        {
          int j = localObject2.length;
          i = 0;
          while (i < j)
          {
            String str = localObject2[i];
            localArrayList.add(paramContext + str);
            i += 1;
          }
        }
      }
      if (localArrayList.isEmpty()) {
        throw new FileNotFoundException("no cache file was found");
      }
      paramContext = paramContext + "html_cache.zip";
      UnifiedFileUtil.a(localArrayList, paramContext);
      return paramContext;
    }
    throw new FileNotFoundException("no cache directory found");
  }
  
  public String a(QQAppInterface paramQQAppInterface, long paramLong, String paramString)
  {
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putString("User-Agent", SwiftWebViewUtils.b(""));
    paramQQAppInterface = CookieManager.getInstance();
    paramQQAppInterface.setAcceptCookie(true);
    paramQQAppInterface = paramQQAppInterface.getCookie(paramString);
    if (paramQQAppInterface != null)
    {
      ((Bundle)localObject1).putString("Cookie", paramQQAppInterface);
      if (QLog.isColorLevel()) {
        QLog.d("UnifiedDebugManager", 2, "Get cookie: " + Util.c(paramQQAppInterface, new String[0]) + " from " + Util.b(paramString, new String[0]));
      }
    }
    paramQQAppInterface = Environment.getExternalStorageDirectory() + "/tencent/MobileQQ/unifiedebug";
    Object localObject2 = new File(paramQQAppInterface);
    if (!((File)localObject2).exists()) {
      ((File)localObject2).mkdirs();
    }
    localObject2 = String.valueOf(paramLong);
    String str1 = paramQQAppInterface + "/" + (String)localObject2 + ".html";
    FileOutputStream localFileOutputStream = new FileOutputStream(new File(str1));
    paramString = (HttpURLConnection)new URL(paramString).openConnection();
    paramString.setRequestMethod("GET");
    paramString.setConnectTimeout(6000);
    paramString.setReadTimeout(6000);
    Object localObject3 = ((Bundle)localObject1).keySet().iterator();
    while (((Iterator)localObject3).hasNext())
    {
      String str2 = (String)((Iterator)localObject3).next();
      Object localObject4 = ((Bundle)localObject1).get(str2);
      if ((localObject4 instanceof String)) {
        paramString.setRequestProperty(str2, (String)localObject4);
      }
    }
    try
    {
      paramString.connect();
      if (200 == paramString.getResponseCode())
      {
        localObject1 = new byte['Ѐ'];
        localObject3 = new BufferedInputStream(paramString.getInputStream());
        for (;;)
        {
          int i = ((InputStream)localObject3).read((byte[])localObject1);
          if (-1 == i) {
            break;
          }
          localFileOutputStream.write((byte[])localObject1, 0, i);
        }
        localFileOutputStream.flush();
      }
    }
    finally
    {
      localFileOutputStream.close();
      paramString.disconnect();
    }
    localFileOutputStream.close();
    paramString.disconnect();
    paramString = new ArrayList();
    paramString.add(str1);
    paramQQAppInterface = paramQQAppInterface + "/" + (String)localObject2 + ".zip";
    UnifiedFileUtil.a(paramString, paramQQAppInterface);
    return paramQQAppInterface;
  }
  
  public String a(File paramFile, List paramList)
  {
    String str = new File(paramFile, "files-" + System.currentTimeMillis() + ".zip").getAbsolutePath();
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i < paramList.size())
    {
      localLinkedList.add(paramFile + "/" + (String)paramList.get(i));
      i += 1;
    }
    UnifiedFileUtil.a(paramFile, paramList, str);
    return str;
  }
  
  public String a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
      return (String)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    }
    return paramString;
  }
  
  public String a(List paramList)
  {
    String str = Environment.getExternalStorageDirectory().getPath() + "/tencent/MobileQQ/unifiedebug/snapshots.zip";
    UnifiedFileUtil.a(paramList, str);
    return str;
  }
  
  @Deprecated
  public List a(Context paramContext)
  {
    if (QbSdk.getTbsVersion(paramContext) < 30000)
    {
      paramContext = SQLiteDatabase.openDatabase(paramContext.getDatabasePath("webviewCache_x5.db").getPath(), null, 1);
      Cursor localCursor = paramContext.query("cache", new String[] { "url" }, null, null, null, null, null);
      ArrayList localArrayList = new ArrayList();
      while (localCursor.moveToNext()) {
        localArrayList.add(localCursor.getString(0));
      }
      localCursor.close();
      paramContext.close();
      return localArrayList;
    }
    return new ArrayList();
  }
  
  public List a(Context paramContext, String paramString)
  {
    int i = QbSdk.getTbsVersion(paramContext);
    String str = paramString;
    if (!paramString.startsWith(".")) {
      str = "." + paramString;
    }
    SQLiteDatabase localSQLiteDatabase;
    Cursor localCursor;
    ArrayList localArrayList;
    if (i < 30000)
    {
      paramString = new String[6];
      paramString[0] = "domain";
      paramString[1] = "name";
      paramString[2] = "value";
      paramString[3] = "path";
      paramString[4] = "expires";
      paramString[5] = "secure";
      localSQLiteDatabase = SQLiteDatabase.openDatabase(a(paramContext, i), null, 1);
      localCursor = localSQLiteDatabase.query("cookies", paramString, null, null, null, null, null);
      localArrayList = new ArrayList();
    }
    for (;;)
    {
      if (!localCursor.moveToNext()) {
        break label325;
      }
      paramContext = localCursor.getString(0);
      if ((str.endsWith(paramContext)) || (str.equals(paramContext)))
      {
        HashMap localHashMap = new HashMap();
        i = 0;
        label174:
        if (i < paramString.length)
        {
          Object localObject = paramString[i];
          if (i <= 3) {}
          for (paramContext = localCursor.getString(i);; paramContext = Integer.valueOf(localCursor.getInt(i)))
          {
            localHashMap.put(localObject, paramContext);
            i += 1;
            break label174;
            paramString = new String[10];
            paramString[0] = "host_key";
            paramString[1] = "name";
            paramString[2] = "value";
            paramString[3] = "path";
            paramString[4] = "expires_utc";
            paramString[5] = "secure";
            paramString[6] = "httponly";
            paramString[7] = "has_expires";
            paramString[8] = "persistent";
            paramString[9] = "priority";
            break;
          }
        }
        localArrayList.add(localHashMap);
      }
    }
    label325:
    localCursor.close();
    localSQLiteDatabase.close();
    return localArrayList;
  }
  
  public Set a(Context paramContext)
  {
    int i = QbSdk.getTbsVersion(paramContext);
    Object localObject;
    if (i < 30000)
    {
      localObject = new String[1];
      localObject[0] = "domain";
    }
    HashSet localHashSet;
    for (;;)
    {
      paramContext = SQLiteDatabase.openDatabase(a(paramContext, i), null, 1);
      localObject = paramContext.query("cookies", (String[])localObject, null, null, null, null, null);
      localHashSet = new HashSet();
      while (((Cursor)localObject).moveToNext()) {
        localHashSet.add(((Cursor)localObject).getString(0));
      }
      localObject = new String[1];
      localObject[0] = "host_key";
    }
    ((Cursor)localObject).close();
    paramContext.close();
    return localHashSet;
  }
  
  public JSONObject a(File paramFile, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramFile == null) {
      return localJSONObject;
    }
    label33:
    JSONArray localJSONArray1;
    int i;
    label70:
    Object localObject;
    JSONArray localJSONArray2;
    if ((paramFile.exists()) && (paramFile.isDirectory()))
    {
      paramFile = paramFile.listFiles();
      if (paramFile == null) {
        break label163;
      }
      localJSONObject.put("module_dir", paramString);
      paramString = new JSONArray();
      localJSONArray1 = new JSONArray();
      int j = paramFile.length;
      i = 0;
      if (i >= j) {
        break label201;
      }
      localObject = paramFile[i];
      localJSONArray2 = new JSONArray();
      localJSONArray2.put(((File)localObject).getName());
      if (!((File)localObject).isFile()) {
        break label165;
      }
      localJSONArray2.put(((File)localObject).length() / 1000L);
      localJSONArray2.put(0);
      localJSONArray2.put(((File)localObject).lastModified());
      paramString.put(localJSONArray2);
    }
    for (;;)
    {
      i += 1;
      break label70;
      paramFile = null;
      break label33;
      label163:
      break;
      label165:
      localJSONArray2.put(0);
      localJSONArray2.put(0);
      localJSONArray2.put(((File)localObject).lastModified());
      localJSONArray1.put(localJSONArray2);
    }
    label201:
    localJSONObject.put("sub_dir", localJSONArray1);
    localJSONObject.put("files", paramString);
    return localJSONObject;
  }
  
  public void a(Context paramContext, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    Intent localIntent = new Intent(paramContext, SnapshotService.class);
    localIntent.setFlags(268435456);
    localIntent.putExtra("id", paramLong1);
    localIntent.putExtra("action", 0);
    localIntent.putExtra("seq", paramLong2);
    localIntent.putExtra("seqKey", paramString);
    localIntent.putExtra("maxSnapshotCount", paramInt);
    localIntent.putExtra("callback", this.jdField_a_of_type_AndroidOsResultReceiver);
    paramContext.startActivity(localIntent);
    if (QLog.isColorLevel()) {
      QLog.d("UnifiedDebugManager", 2, "start alive snapshot to webview(" + paramLong1 + ")");
    }
  }
  
  public void a(Context paramContext, String paramString1, int paramInt, long paramLong1, long paramLong2, String paramString2)
  {
    synchronized (this.jdField_a_of_type_JavaUtilQueue)
    {
      if (this.jdField_a_of_type_JavaUtilQueue.isEmpty())
      {
        c(paramContext, paramString1, paramInt, paramLong1, paramLong2, paramString2);
        if (QLog.isColorLevel()) {
          QLog.d("UnifiedDebugManager", 2, "start debug(queue is empty): seq=" + paramLong2);
        }
      }
      while (!QLog.isColorLevel())
      {
        this.jdField_a_of_type_JavaUtilQueue.offer(new vwy(this, paramString1, paramInt, paramLong1, paramLong2, paramString2));
        return;
      }
      QLog.d("UnifiedDebugManager", 2, "start debug(only enqueue one cmd): seq=" + paramLong2);
    }
  }
  
  public void a(Context paramContext, String paramString, List paramList)
  {
    int i = QbSdk.getTbsVersion(paramContext);
    Object localObject = a(paramContext, i);
    if (i < 30000) {}
    for (paramContext = "domain=? and name=?";; paramContext = "host_key=? and name=?")
    {
      localObject = SQLiteDatabase.openDatabase((String)localObject, null, 0);
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((SQLiteDatabase)localObject).delete("cookies", paramContext, new String[] { paramString, (String)paramList.next() });
      }
    }
    ((SQLiteDatabase)localObject).close();
  }
  
  public void a(Context paramContext, List paramList)
  {
    Object localObject1;
    if (QbSdk.getTbsVersion(paramContext) < 30000)
    {
      localObject1 = paramContext.getDatabasePath("webviewCache_x5.db").getPath();
      paramContext = new File(paramContext.getCacheDir(), "webviewCache");
      localObject1 = SQLiteDatabase.openDatabase((String)localObject1, null, 0);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject2 = (String)paramList.next();
        localObject2 = ((SQLiteDatabase)localObject1).query("cache", new String[] { "url", "filepath" }, "url=?", new String[] { localObject2 }, null, null, null);
        while (((Cursor)localObject2).moveToNext())
        {
          String str1 = ((Cursor)localObject2).getString(0);
          String str2 = ((Cursor)localObject2).getString(1);
          File localFile = new File(paramContext, str2);
          if ((localFile.exists()) && (localFile.delete())) {
            ((SQLiteDatabase)localObject1).delete("cache", "url=? and filepath=?", new String[] { str1, str2 });
          }
        }
        ((Cursor)localObject2).close();
      }
      ((SQLiteDatabase)localObject1).close();
      label208:
      return;
    }
    else
    {
      paramContext = new File(paramContext.getApplicationContext().getDir("webview", 0).getPath() + "/Cache");
      paramList = paramList.iterator();
    }
    for (;;)
    {
      if (!paramList.hasNext()) {
        break label208;
      }
      localObject1 = paramContext.listFiles(new vwt(this, c((String)paramList.next()).substring(0, 16)));
      if (localObject1 == null) {
        break;
      }
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        localObject1[i].delete();
        i += 1;
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong, String paramString, Handler paramHandler)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IOException("url is empty");
    }
    String str1 = d(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("UnifiedDebugManager", 2, "traceRoute getHost = " + str1);
    }
    String str2 = b(str1);
    if (QLog.isColorLevel()) {
      QLog.d("UnifiedDebugManager", 2, "traceRoute getIp = " + str2);
    }
    paramString = a(paramString);
    new UnifiedTraceRouter(paramQQAppInterface, paramHandler).a(paramLong, str1, paramString);
  }
  
  public boolean a(Context paramContext, long paramLong)
  {
    synchronized (this.jdField_a_of_type_JavaUtilQueue)
    {
      vwy localvwy = (vwy)this.jdField_a_of_type_JavaUtilQueue.poll();
      if ((localvwy != null) && (vwy.a(localvwy) == paramLong))
      {
        localvwy = (vwy)this.jdField_a_of_type_JavaUtilQueue.peek();
        if (localvwy != null)
        {
          c(paramContext, vwy.a(localvwy), vwy.a(localvwy), vwy.b(localvwy), vwy.a(localvwy), vwy.b(localvwy));
          if (QLog.isColorLevel()) {
            QLog.d("UnifiedDebugManager", 2, "finish once webview debug, start new debug(dequeue one cmd): seq=" + vwy.a(localvwy));
          }
        }
        while (!QLog.isColorLevel()) {
          return true;
        }
        QLog.d("UnifiedDebugManager", 2, "finish once webview debug: seq=" + paramLong);
      }
    }
    return false;
  }
  
  public boolean a(File paramFile, List paramList)
  {
    if ((paramFile == null) || (paramList == null) || (paramList.isEmpty())) {
      return false;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      File localFile = new File(paramFile, (String)paramList.next());
      if (localFile.exists())
      {
        if (localFile.isDirectory()) {
          return UnifiedFileUtil.a(localFile);
        }
        return localFile.delete();
      }
    }
    return false;
  }
  
  public String b(String paramString)
  {
    return InetAddress.getByName(paramString).getHostAddress();
  }
  
  public Set b(Context paramContext)
  {
    paramContext = UnifiedFileUtil.a(a(paramContext));
    HashSet localHashSet = new HashSet();
    if ((paramContext != null) && (paramContext.length > 0))
    {
      int j = paramContext.length;
      int i = 0;
      while (i < j)
      {
        String[] arrayOfString = paramContext[i].split("_");
        if (arrayOfString.length == 3) {
          localHashSet.add(arrayOfString[1]);
        }
        i += 1;
      }
    }
    return localHashSet;
  }
  
  public void b(Context paramContext, String paramString1, int paramInt, long paramLong1, long paramLong2, String paramString2)
  {
    Intent localIntent = new Intent(paramContext, SnapshotService.class);
    localIntent.setFlags(268435456);
    localIntent.putExtra("id", paramLong2);
    localIntent.putExtra("action", 2);
    localIntent.putExtra("debugUrl", paramString1);
    localIntent.putExtra("seq", paramLong2);
    localIntent.putExtra("seqKey", paramString2);
    localIntent.putExtra("delay", paramLong1);
    localIntent.putExtra("maxSnapshotCount", paramInt);
    localIntent.putExtra("callback", this.jdField_a_of_type_AndroidOsResultReceiver);
    paramContext.startActivity(localIntent);
    if (QLog.isColorLevel()) {
      QLog.d("UnifiedDebugManager", 2, "start alive snapshot, seq=" + paramLong2);
    }
  }
  
  public void b(Context paramContext, String paramString, List paramList)
  {
    Object localObject = new URL(paramString);
    paramString = ((URL)localObject).getProtocol();
    localObject = ((URL)localObject).getHost();
    paramString = paramString + "_" + (String)localObject + "_";
    paramContext = new File(a(paramContext));
    if ((paramContext.exists()) && (paramContext.isDirectory()))
    {
      paramString = paramContext.list(new vwv(this, paramString));
      if ((paramString != null) && (paramString.length > 0))
      {
        int j = paramString.length;
        int i = 0;
        while (i < j)
        {
          localObject = paramString[i];
          localObject = SQLiteDatabase.openDatabase(paramContext.getPath() + "/" + (String)localObject, null, 0);
          Iterator localIterator = paramList.iterator();
          while (localIterator.hasNext()) {
            ((SQLiteDatabase)localObject).delete("ItemTable", "key=?", new String[] { (String)localIterator.next() });
          }
          ((SQLiteDatabase)localObject).close();
          i += 1;
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\unifiedebug\UnifiedDebugManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */