package com.tencent.mobileqq.vashealth;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.richmedia.MX3FlowCameraActivity;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraCompatibleList;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

public class HealthBusinessPlugin
  extends WebViewPlugin
{
  static final byte jdField_a_of_type_Byte = 1;
  public static final int a = 1;
  static final String jdField_a_of_type_JavaLangString = "HealthBusinessPlugin";
  public static HashMap a;
  public static List a;
  static boolean jdField_a_of_type_Boolean = false;
  static final byte b = 2;
  public static final int b = 2;
  public static final String b = "healthSport";
  static final byte jdField_c_of_type_Byte = 3;
  static final int jdField_c_of_type_Int = 0;
  public static final String c = "video_dir";
  static final int d = 1;
  public static final String d = "thumb_dir";
  public static final String e = "min_width";
  public static final String f = "min_height";
  public static final String g = "max_gif_size";
  public static final String h = "size_before_compress";
  public static final String i = "duration_max";
  public static final String j = "size_after_compress";
  public static final String k = "From_HealthBusiness";
  public static final String l = "http://c.yundong.qq.com/cgi-bin/qqsports_upload_pic_terminal?g_tk=";
  public static final String m = "http://c.yundong.qq.com/cgi-bin/qqsports_feeds_publish?cmd=10&g_tk=";
  public static final String p = "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==";
  public static final String q = "qq_sport";
  Uri jdField_a_of_type_AndroidNetUri = null;
  public QQProgressDialog a;
  public boolean b = false;
  String n;
  String o;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public HealthBusinessPlugin()
  {
    this.mPluginNameSpace = "healthSport";
  }
  
  SharedPreferences a()
  {
    String str2 = this.mRuntime.a().getAccount();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "nologin";
    }
    return this.mRuntime.a().getApplication().getSharedPreferences(str1 + "_health", 0);
  }
  
  void a()
  {
    if (QavCameraUsage.b(BaseApplicationImpl.getContext())) {}
    for (;;)
    {
      return;
      Object localObject = new File(AppConstants.bo);
      boolean bool;
      if (((File)localObject).exists()) {
        bool = true;
      }
      while ((bool) && (((File)localObject).canWrite()))
      {
        this.jdField_a_of_type_AndroidNetUri = Uri.fromFile(new File(AppConstants.bo + System.currentTimeMillis() + ".jpg"));
        if ((TextUtils.isEmpty(this.n)) || (TextUtils.isEmpty(this.o)))
        {
          QLog.e("HealthBusinessPlugin", 1, "temp ids lost!");
          return;
          bool = ((File)localObject).mkdirs();
        }
        else
        {
          localObject = new Intent("android.media.action.IMAGE_CAPTURE");
          ((Intent)localObject).putExtra("output", this.jdField_a_of_type_AndroidNetUri);
          ((Intent)localObject).putExtra("android.intent.extra.videoQuality", 100);
          startActivityForResult((Intent)localObject, (byte)2);
          return;
        }
      }
      if (this.mRuntime == null) {}
      for (localObject = null; (localObject != null) && (!((Activity)localObject).isFinishing()); localObject = this.mRuntime.a())
      {
        QQToast.a((Context)localObject, 2131364811, 1).b(((BaseActivity)localObject).getTitleBarHeight());
        return;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HealthBusinessPlugin", 2, paramInt1 + "|" + paramInt2 + "|" + paramInt3);
    }
    Object localObject = NewFlowCameraActivity.class;
    if (CameraCompatibleList.d(CameraCompatibleList.c)) {
      localObject = MX3FlowCameraActivity.class;
    }
    localObject = new Intent(this.mRuntime.a(), (Class)localObject);
    ((Intent)localObject).putExtra("from_type", 1);
    ((Intent)localObject).putExtra("enable_front", true);
    ((Intent)localObject).putExtra("enable_local_video", true);
    ((Intent)localObject).putExtra("set_user_callback", "com.tencent.mobileqq.vashealth.VideoCallBack");
    ((Intent)localObject).putExtra("flow_camera_video_mode", true);
    ((Intent)localObject).putExtra("flow_camera_capture_mode", false);
    ((Intent)localObject).putExtra("ignore_dpc_duration", true);
    ((Intent)localObject).putExtra("video_duration", paramInt4);
    ((Intent)localObject).putExtra("short_video_refer", "From_HealthBusiness");
    ((Intent)localObject).putExtra("sv_config", DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.NewShortVideoConfig.name(), null));
    ((Intent)localObject).putExtra("size_before_compress", paramInt1);
    ((Intent)localObject).putExtra("size_after_compress", paramInt3);
    ((Intent)localObject).putExtra("duration_max", paramInt2);
    startActivityForResult((Intent)localObject, (byte)3);
  }
  
  /* Error */
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, java.util.Map paramMap, android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: aload 6
    //   2: aload_3
    //   3: aload 4
    //   5: ldc 59
    //   7: aload_0
    //   8: getfield 88	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:b	Z
    //   11: invokestatic 324	com/tencent/mobileqq/activity/bless/BlessResultActivity:a	(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp;
    //   14: astore 6
    //   16: aload 6
    //   18: ifnull +1116 -> 1134
    //   21: aload_2
    //   22: invokestatic 329	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)J
    //   25: lstore 14
    //   27: lload 14
    //   29: ldc2_w 330
    //   32: lcmp
    //   33: ifle +449 -> 482
    //   36: ldc2_w 330
    //   39: lstore 12
    //   41: invokestatic 248	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   44: ifeq +47 -> 91
    //   47: ldc 11
    //   49: iconst_2
    //   50: new 126	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   57: ldc_w 333
    //   60: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: aload 6
    //   65: getfield 337	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:h	Ljava/lang/String;
    //   68: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: ldc_w 339
    //   74: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: aload 6
    //   79: getfield 341	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:d	Ljava/lang/String;
    //   82: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokestatic 343	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   91: ldc_w 345
    //   94: aload 6
    //   96: getfield 337	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:h	Ljava/lang/String;
    //   99: invokevirtual 351	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   102: ifeq +387 -> 489
    //   105: aload 6
    //   107: getfield 353	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:f	Ljava/lang/String;
    //   110: astore_2
    //   111: iconst_1
    //   112: istore 11
    //   114: iload 11
    //   116: ifeq +948 -> 1064
    //   119: aconst_null
    //   120: astore 6
    //   122: aconst_null
    //   123: astore 7
    //   125: new 355	java/net/URL
    //   128: dup
    //   129: aload_1
    //   130: invokespecial 356	java/net/URL:<init>	(Ljava/lang/String;)V
    //   133: invokevirtual 360	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   136: checkcast 362	java/net/HttpURLConnection
    //   139: astore_1
    //   140: aload_1
    //   141: sipush 5000
    //   144: invokevirtual 366	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   147: aload_1
    //   148: sipush 30000
    //   151: invokevirtual 369	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   154: aload_1
    //   155: iconst_1
    //   156: invokevirtual 373	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   159: aload_1
    //   160: iconst_1
    //   161: invokevirtual 376	java/net/HttpURLConnection:setDoInput	(Z)V
    //   164: aload_1
    //   165: iconst_0
    //   166: invokevirtual 379	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   169: aload_1
    //   170: ldc_w 381
    //   173: invokevirtual 384	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   176: aload_1
    //   177: ldc_w 386
    //   180: ldc_w 388
    //   183: invokevirtual 392	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   186: aload_1
    //   187: ldc_w 394
    //   190: new 126	java/lang/StringBuilder
    //   193: dup
    //   194: ldc_w 396
    //   197: invokespecial 397	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   200: ldc_w 399
    //   203: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: getstatic 404	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   209: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: ldc_w 399
    //   215: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: getstatic 409	android/os/Build:DEVICE	Ljava/lang/String;
    //   221: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: ldc_w 399
    //   227: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: getstatic 412	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   233: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: ldc_w 399
    //   239: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: ldc_w 414
    //   245: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   251: invokevirtual 392	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   254: aload_1
    //   255: ldc_w 416
    //   258: ldc_w 418
    //   261: invokevirtual 392	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   264: aload_1
    //   265: ldc_w 420
    //   268: new 126	java/lang/StringBuilder
    //   271: dup
    //   272: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   275: ldc_w 422
    //   278: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: aload_3
    //   282: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: ldc_w 424
    //   288: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: aload 4
    //   293: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   299: invokevirtual 392	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   302: new 426	java/io/DataOutputStream
    //   305: dup
    //   306: aload_1
    //   307: invokevirtual 430	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   310: invokespecial 433	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   313: astore_3
    //   314: new 435	java/lang/StringBuffer
    //   317: dup
    //   318: invokespecial 436	java/lang/StringBuffer:<init>	()V
    //   321: astore 4
    //   323: aload 4
    //   325: ldc_w 438
    //   328: invokevirtual 441	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   331: pop
    //   332: aload 4
    //   334: aload_2
    //   335: invokevirtual 441	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   338: pop
    //   339: aload 4
    //   341: ldc_w 443
    //   344: invokevirtual 441	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   347: pop
    //   348: aload 4
    //   350: aload 5
    //   352: ldc_w 445
    //   355: invokeinterface 451 2 0
    //   360: checkcast 347	java/lang/String
    //   363: invokevirtual 441	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   366: pop
    //   367: aload_3
    //   368: aload 4
    //   370: invokevirtual 452	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   373: invokevirtual 456	java/lang/String:getBytes	()[B
    //   376: invokevirtual 462	java/io/OutputStream:write	([B)V
    //   379: aload_3
    //   380: invokevirtual 465	java/io/OutputStream:flush	()V
    //   383: aload_3
    //   384: invokevirtual 468	java/io/OutputStream:close	()V
    //   387: new 435	java/lang/StringBuffer
    //   390: dup
    //   391: invokespecial 436	java/lang/StringBuffer:<init>	()V
    //   394: astore 4
    //   396: new 470	java/io/BufferedReader
    //   399: dup
    //   400: new 472	java/io/InputStreamReader
    //   403: dup
    //   404: aload_1
    //   405: invokevirtual 476	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   408: invokespecial 479	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   411: invokespecial 482	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   414: astore_3
    //   415: aload_3
    //   416: invokevirtual 485	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   419: astore 6
    //   421: aload 6
    //   423: ifnull +548 -> 971
    //   426: aload 4
    //   428: aload 6
    //   430: invokevirtual 441	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   433: ldc_w 487
    //   436: invokevirtual 441	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   439: pop
    //   440: goto -25 -> 415
    //   443: astore_2
    //   444: aload_1
    //   445: astore 6
    //   447: ldc 11
    //   449: iconst_2
    //   450: new 126	java/lang/StringBuilder
    //   453: dup
    //   454: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   457: ldc_w 489
    //   460: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: aload_2
    //   464: invokevirtual 492	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   467: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   470: invokestatic 343	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   473: aload_1
    //   474: ifnull +7 -> 481
    //   477: aload_1
    //   478: invokevirtual 495	java/net/HttpURLConnection:disconnect	()V
    //   481: return
    //   482: lload 14
    //   484: lstore 12
    //   486: goto -445 -> 41
    //   489: aload 6
    //   491: getfield 353	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:f	Ljava/lang/String;
    //   494: ifnull +640 -> 1134
    //   497: aload 6
    //   499: getfield 496	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:c	Ljava/lang/String;
    //   502: invokestatic 501	com/tencent/mobileqq/utils/HexUtil:a	(Ljava/lang/String;)[B
    //   505: astore 8
    //   507: aload_2
    //   508: invokestatic 504	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Ljava/lang/String;)[B
    //   511: astore 9
    //   513: new 126	java/lang/StringBuilder
    //   516: dup
    //   517: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   520: ldc_w 506
    //   523: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   526: aload 6
    //   528: getfield 508	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:a	Ljava/lang/String;
    //   531: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: ldc_w 510
    //   537: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: aload 6
    //   542: getfield 512	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:b	Ljava/lang/String;
    //   545: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   548: ldc_w 514
    //   551: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   554: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   557: astore 10
    //   559: aload_0
    //   560: getfield 88	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:b	Z
    //   563: ifeq +15 -> 578
    //   566: aload 10
    //   568: ldc_w 516
    //   571: ldc_w 518
    //   574: invokevirtual 522	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   577: pop
    //   578: invokestatic 248	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   581: ifeq +44 -> 625
    //   584: ldc 11
    //   586: iconst_2
    //   587: new 126	java/lang/StringBuilder
    //   590: dup
    //   591: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   594: ldc_w 524
    //   597: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: aload 10
    //   602: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   605: ldc_w 526
    //   608: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   611: aload 6
    //   613: getfield 353	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:f	Ljava/lang/String;
    //   616: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   622: invokestatic 343	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   625: new 528	java/io/RandomAccessFile
    //   628: dup
    //   629: aload_2
    //   630: ldc_w 530
    //   633: invokespecial 532	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   636: astore 7
    //   638: lconst_0
    //   639: lstore 16
    //   641: lload 12
    //   643: lload 16
    //   645: lsub
    //   646: l2i
    //   647: istore 11
    //   649: aload 7
    //   651: astore_2
    //   652: invokestatic 148	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   655: invokestatic 536	com/tencent/biz/common/util/HttpUtil:a	(Landroid/content/Context;)Z
    //   658: ifeq +107 -> 765
    //   661: aload 7
    //   663: astore_2
    //   664: aload 8
    //   666: aload 9
    //   668: aload 10
    //   670: lload 14
    //   672: aload 7
    //   674: lload 16
    //   676: iload 11
    //   678: invokestatic 541	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil:a	([B[BLjava/lang/String;JLjava/io/RandomAccessFile;JI)J
    //   681: lstore 16
    //   683: lload 16
    //   685: ldc2_w 542
    //   688: lcmp
    //   689: ifne +35 -> 724
    //   692: iconst_1
    //   693: istore 11
    //   695: goto +449 -> 1144
    //   698: aload 7
    //   700: astore_2
    //   701: aload 6
    //   703: getfield 353	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:f	Ljava/lang/String;
    //   706: astore 6
    //   708: aload 7
    //   710: ifnull +415 -> 1125
    //   713: aload 7
    //   715: invokevirtual 544	java/io/RandomAccessFile:close	()V
    //   718: aload 6
    //   720: astore_2
    //   721: goto -607 -> 114
    //   724: ldc2_w 330
    //   727: lload 16
    //   729: ladd
    //   730: lload 14
    //   732: lcmp
    //   733: ifle +21 -> 754
    //   736: lload 14
    //   738: lstore 12
    //   740: lload 16
    //   742: lload 14
    //   744: lcmp
    //   745: iflt +386 -> 1131
    //   748: iconst_0
    //   749: istore 11
    //   751: goto +393 -> 1144
    //   754: ldc2_w 330
    //   757: lload 16
    //   759: ladd
    //   760: lstore 12
    //   762: goto -22 -> 740
    //   765: iconst_1
    //   766: istore 11
    //   768: goto +376 -> 1144
    //   771: aload 7
    //   773: astore_2
    //   774: ldc 11
    //   776: iconst_1
    //   777: new 126	java/lang/StringBuilder
    //   780: dup
    //   781: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   784: ldc_w 546
    //   787: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   790: aload 10
    //   792: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   795: ldc_w 548
    //   798: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   801: aload 6
    //   803: getfield 353	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:f	Ljava/lang/String;
    //   806: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   809: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   812: invokestatic 198	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   815: iconst_0
    //   816: istore 11
    //   818: goto -120 -> 698
    //   821: astore_2
    //   822: invokestatic 248	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   825: ifeq +13 -> 838
    //   828: ldc 11
    //   830: iconst_2
    //   831: aload_2
    //   832: invokestatic 552	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   835: invokestatic 343	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   838: aload 6
    //   840: astore_2
    //   841: goto -727 -> 114
    //   844: astore 8
    //   846: aconst_null
    //   847: astore 6
    //   849: aload 6
    //   851: astore_2
    //   852: invokestatic 248	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   855: ifeq +36 -> 891
    //   858: aload 6
    //   860: astore_2
    //   861: ldc 11
    //   863: iconst_2
    //   864: new 126	java/lang/StringBuilder
    //   867: dup
    //   868: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   871: ldc_w 554
    //   874: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   877: aload 8
    //   879: invokestatic 552	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   882: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   885: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   888: invokestatic 343	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   891: aload 6
    //   893: ifnull +222 -> 1115
    //   896: aload 6
    //   898: invokevirtual 544	java/io/RandomAccessFile:close	()V
    //   901: ldc_w 556
    //   904: astore_2
    //   905: iconst_0
    //   906: istore 11
    //   908: goto -794 -> 114
    //   911: astore_2
    //   912: invokestatic 248	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   915: ifeq +13 -> 928
    //   918: ldc 11
    //   920: iconst_2
    //   921: aload_2
    //   922: invokestatic 552	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   925: invokestatic 343	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   928: ldc_w 556
    //   931: astore_2
    //   932: iconst_0
    //   933: istore 11
    //   935: goto -821 -> 114
    //   938: astore_1
    //   939: aconst_null
    //   940: astore_2
    //   941: aload_2
    //   942: ifnull +7 -> 949
    //   945: aload_2
    //   946: invokevirtual 544	java/io/RandomAccessFile:close	()V
    //   949: aload_1
    //   950: athrow
    //   951: astore_2
    //   952: invokestatic 248	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   955: ifeq -6 -> 949
    //   958: ldc 11
    //   960: iconst_2
    //   961: aload_2
    //   962: invokestatic 552	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   965: invokestatic 343	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   968: goto -19 -> 949
    //   971: aload 4
    //   973: invokevirtual 452	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   976: astore 4
    //   978: ldc 11
    //   980: iconst_1
    //   981: new 126	java/lang/StringBuilder
    //   984: dup
    //   985: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   988: ldc_w 558
    //   991: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   994: aload_2
    //   995: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   998: ldc_w 560
    //   1001: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1004: aload 5
    //   1006: ldc_w 445
    //   1009: invokeinterface 451 2 0
    //   1014: checkcast 347	java/lang/String
    //   1017: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1020: ldc_w 562
    //   1023: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1026: aload 4
    //   1028: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1031: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1034: invokestatic 255	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1037: aload_3
    //   1038: invokevirtual 563	java/io/BufferedReader:close	()V
    //   1041: aload_1
    //   1042: ifnull -561 -> 481
    //   1045: aload_1
    //   1046: invokevirtual 495	java/net/HttpURLConnection:disconnect	()V
    //   1049: return
    //   1050: astore_2
    //   1051: aload 6
    //   1053: astore_1
    //   1054: aload_1
    //   1055: ifnull +7 -> 1062
    //   1058: aload_1
    //   1059: invokevirtual 495	java/net/HttpURLConnection:disconnect	()V
    //   1062: aload_2
    //   1063: athrow
    //   1064: ldc 11
    //   1066: iconst_1
    //   1067: new 126	java/lang/StringBuilder
    //   1070: dup
    //   1071: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   1074: ldc_w 565
    //   1077: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1080: aload_2
    //   1081: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1084: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1087: invokestatic 198	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1090: return
    //   1091: astore_2
    //   1092: goto -38 -> 1054
    //   1095: astore_2
    //   1096: aload 7
    //   1098: astore_1
    //   1099: goto -655 -> 444
    //   1102: astore_1
    //   1103: goto -162 -> 941
    //   1106: astore 8
    //   1108: aload 7
    //   1110: astore 6
    //   1112: goto -263 -> 849
    //   1115: ldc_w 556
    //   1118: astore_2
    //   1119: iconst_0
    //   1120: istore 11
    //   1122: goto -1008 -> 114
    //   1125: aload 6
    //   1127: astore_2
    //   1128: goto -1014 -> 114
    //   1131: goto -490 -> 641
    //   1134: ldc_w 556
    //   1137: astore_2
    //   1138: iconst_0
    //   1139: istore 11
    //   1141: goto -1027 -> 114
    //   1144: iload 11
    //   1146: ifne -375 -> 771
    //   1149: iconst_1
    //   1150: istore 11
    //   1152: goto -454 -> 698
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1155	0	this	HealthBusinessPlugin
    //   0	1155	1	paramString1	String
    //   0	1155	2	paramString2	String
    //   0	1155	3	paramString3	String
    //   0	1155	4	paramString4	String
    //   0	1155	5	paramMap	java.util.Map
    //   0	1155	6	paramBundle	android.os.Bundle
    //   123	986	7	localRandomAccessFile	java.io.RandomAccessFile
    //   505	160	8	arrayOfByte1	byte[]
    //   844	34	8	localException1	Exception
    //   1106	1	8	localException2	Exception
    //   511	156	9	arrayOfByte2	byte[]
    //   557	234	10	str	String
    //   112	1039	11	i1	int
    //   39	722	12	l1	long
    //   25	718	14	l2	long
    //   639	119	16	l3	long
    // Exception table:
    //   from	to	target	type
    //   140	415	443	java/lang/Exception
    //   415	421	443	java/lang/Exception
    //   426	440	443	java/lang/Exception
    //   971	1041	443	java/lang/Exception
    //   713	718	821	java/io/IOException
    //   625	638	844	java/lang/Exception
    //   896	901	911	java/io/IOException
    //   625	638	938	finally
    //   945	949	951	java/io/IOException
    //   125	140	1050	finally
    //   447	473	1050	finally
    //   140	415	1091	finally
    //   415	421	1091	finally
    //   426	440	1091	finally
    //   971	1041	1091	finally
    //   125	140	1095	java/lang/Exception
    //   652	661	1102	finally
    //   664	683	1102	finally
    //   701	708	1102	finally
    //   774	815	1102	finally
    //   852	858	1102	finally
    //   861	891	1102	finally
    //   652	661	1106	java/lang/Exception
    //   664	683	1106	java/lang/Exception
    //   701	708	1106	java/lang/Exception
    //   774	815	1106	java/lang/Exception
  }
  
  void a(List paramList)
  {
    SharedPreferences localSharedPreferences = a();
    Object localObject = localSharedPreferences.getString(this.n, null);
    if (localObject == null) {}
    JSONArray localJSONArray;
    for (;;)
    {
      try
      {
        localObject = new JSONObject();
        localJSONArray = new JSONArray();
        paramList = paramList.iterator();
        if (!paramList.hasNext()) {
          break;
        }
        String str = (String)paramList.next();
        if (!TextUtils.isEmpty(str))
        {
          localJSONArray.put(str);
          continue;
          localObject = new JSONObject((String)localObject);
        }
      }
      catch (Exception paramList)
      {
        if (QLog.isColorLevel()) {
          QLog.e("HealthBusinessPlugin", 2, paramList, new Object[0]);
        }
        return;
      }
    }
    ((JSONObject)localObject).put("imgList", localJSONArray);
    localSharedPreferences.edit().putString(this.n, ((JSONObject)localObject).toString()).commit();
  }
  
  protected Object handleEvent(String paramString, long paramLong)
  {
    if ((!this.mRuntime.a().getUrl().contains("qq.com")) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return null;
      if ((paramLong == 8L) && (paramString.startsWith("http://qqsport/")) && (paramString.length() > 16))
      {
        paramString = paramString.substring(15);
        try
        {
          paramString = new File(URLDecoder.decode(paramString, "utf-8"));
          if ((paramString.exists()) || (paramString.isFile()))
          {
            paramString = new WebResourceResponse("image/*", "utf-8", new FileInputStream(paramString));
            return paramString;
          }
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
        }
      }
    }
    return null;
  }
  
  /* Error */
  protected boolean handleJsRequest(com.tencent.mobileqq.webview.swift.JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    // Byte code:
    //   0: ldc_w 681
    //   3: aload 4
    //   5: invokevirtual 351	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8: ifeq +755 -> 763
    //   11: aconst_null
    //   12: astore_3
    //   13: aconst_null
    //   14: astore 4
    //   16: iconst_0
    //   17: istore 12
    //   19: iconst_0
    //   20: istore 18
    //   22: sipush 200
    //   25: istore 13
    //   27: sipush 200
    //   30: istore 15
    //   32: iload 15
    //   34: istore 14
    //   36: iload 13
    //   38: istore 16
    //   40: iload 12
    //   42: istore 17
    //   44: aload 4
    //   46: astore_1
    //   47: aload_3
    //   48: astore_2
    //   49: new 575	org/json/JSONObject
    //   52: dup
    //   53: aload 5
    //   55: iconst_0
    //   56: aaload
    //   57: invokespecial 604	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   60: astore 5
    //   62: iload 15
    //   64: istore 14
    //   66: iload 13
    //   68: istore 16
    //   70: iload 12
    //   72: istore 17
    //   74: aload 4
    //   76: astore_1
    //   77: aload_3
    //   78: astore_2
    //   79: aload 5
    //   81: ldc_w 683
    //   84: invokevirtual 687	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   87: astore_3
    //   88: iload 15
    //   90: istore 14
    //   92: iload 13
    //   94: istore 16
    //   96: iload 12
    //   98: istore 17
    //   100: aload 4
    //   102: astore_1
    //   103: aload_3
    //   104: astore_2
    //   105: aload_3
    //   106: invokestatic 118	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   109: ifeq +5 -> 114
    //   112: iconst_1
    //   113: ireturn
    //   114: iload 15
    //   116: istore 14
    //   118: iload 13
    //   120: istore 16
    //   122: iload 12
    //   124: istore 17
    //   126: aload 4
    //   128: astore_1
    //   129: aload_3
    //   130: astore_2
    //   131: aload 5
    //   133: ldc_w 689
    //   136: invokevirtual 687	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   139: astore 4
    //   141: iload 15
    //   143: istore 14
    //   145: iload 13
    //   147: istore 16
    //   149: iload 12
    //   151: istore 17
    //   153: aload 4
    //   155: astore_1
    //   156: aload_3
    //   157: astore_2
    //   158: aload 5
    //   160: ldc_w 691
    //   163: invokevirtual 695	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   166: istore 12
    //   168: iload 15
    //   170: istore 14
    //   172: iload 13
    //   174: istore 16
    //   176: iload 12
    //   178: istore 17
    //   180: aload 4
    //   182: astore_1
    //   183: aload_3
    //   184: astore_2
    //   185: aload 5
    //   187: ldc 29
    //   189: sipush 200
    //   192: invokevirtual 698	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   195: istore 13
    //   197: iload 15
    //   199: istore 14
    //   201: iload 13
    //   203: istore 16
    //   205: iload 12
    //   207: istore 17
    //   209: aload 4
    //   211: astore_1
    //   212: aload_3
    //   213: astore_2
    //   214: aload 5
    //   216: ldc 32
    //   218: sipush 200
    //   221: invokevirtual 698	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   224: istore 15
    //   226: iload 15
    //   228: istore 14
    //   230: iload 13
    //   232: istore 16
    //   234: iload 12
    //   236: istore 17
    //   238: aload 4
    //   240: astore_1
    //   241: aload_3
    //   242: astore_2
    //   243: aload 5
    //   245: ldc 35
    //   247: ldc_w 699
    //   250: invokevirtual 698	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   253: istore 19
    //   255: iload 19
    //   257: istore 14
    //   259: iload 18
    //   261: istore 16
    //   263: aload 5
    //   265: ldc_w 701
    //   268: invokevirtual 704	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   271: ifeq +13 -> 284
    //   274: aload 5
    //   276: ldc_w 701
    //   279: invokevirtual 707	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   282: istore 16
    //   284: iload 15
    //   286: istore 17
    //   288: iload 14
    //   290: istore 18
    //   292: aload_3
    //   293: astore_2
    //   294: aload 4
    //   296: astore_1
    //   297: iload 13
    //   299: istore 15
    //   301: iload 17
    //   303: istore 14
    //   305: iload 18
    //   307: istore 13
    //   309: new 79	java/util/ArrayList
    //   312: dup
    //   313: invokespecial 80	java/util/ArrayList:<init>	()V
    //   316: astore_3
    //   317: aload_1
    //   318: invokestatic 118	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   321: ifeq +116 -> 437
    //   324: aload_0
    //   325: invokestatic 176	java/lang/System:currentTimeMillis	()J
    //   328: ldc2_w 708
    //   331: ldiv
    //   332: invokestatic 713	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   335: putfield 189	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:n	Ljava/lang/String;
    //   338: aload_0
    //   339: aload_2
    //   340: putfield 191	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:o	Ljava/lang/String;
    //   343: iload 12
    //   345: istore 17
    //   347: iload 12
    //   349: ifne +7 -> 356
    //   352: bipush 6
    //   354: istore 17
    //   356: aload_0
    //   357: getfield 101	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   360: invokevirtual 244	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   363: astore 4
    //   365: aload 4
    //   367: ifnonnull +166 -> 533
    //   370: iconst_1
    //   371: ireturn
    //   372: astore_3
    //   373: ldc_w 699
    //   376: istore 18
    //   378: iload 17
    //   380: istore 12
    //   382: iload 16
    //   384: istore 13
    //   386: iload 14
    //   388: istore 15
    //   390: iload 18
    //   392: istore 14
    //   394: invokestatic 248	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   397: ifeq +14 -> 411
    //   400: ldc 11
    //   402: iconst_2
    //   403: aload_3
    //   404: iconst_0
    //   405: anewarray 600	java/lang/Object
    //   408: invokestatic 603	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   411: iload 13
    //   413: istore 16
    //   415: iconst_0
    //   416: istore 17
    //   418: iload 14
    //   420: istore 13
    //   422: iload 15
    //   424: istore 14
    //   426: iload 16
    //   428: istore 15
    //   430: iload 17
    //   432: istore 16
    //   434: goto -125 -> 309
    //   437: aload_0
    //   438: aload_1
    //   439: putfield 189	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:n	Ljava/lang/String;
    //   442: aload_0
    //   443: invokevirtual 568	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:a	()Landroid/content/SharedPreferences;
    //   446: aload_1
    //   447: aconst_null
    //   448: invokeinterface 573 3 0
    //   453: astore_1
    //   454: aload_1
    //   455: invokestatic 118	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   458: ifne -120 -> 338
    //   461: new 575	org/json/JSONObject
    //   464: dup
    //   465: aload_1
    //   466: invokespecial 604	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   469: ldc_w 606
    //   472: invokevirtual 717	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   475: astore_1
    //   476: aload_3
    //   477: invokevirtual 720	java/util/ArrayList:clear	()V
    //   480: iconst_0
    //   481: istore 17
    //   483: iload 17
    //   485: aload_1
    //   486: invokevirtual 721	org/json/JSONArray:length	()I
    //   489: if_icmpge -151 -> 338
    //   492: aload_3
    //   493: aload_1
    //   494: iload 17
    //   496: invokevirtual 723	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   499: invokevirtual 726	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   502: pop
    //   503: iload 17
    //   505: iconst_1
    //   506: iadd
    //   507: istore 17
    //   509: goto -26 -> 483
    //   512: astore_1
    //   513: invokestatic 248	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   516: ifeq -178 -> 338
    //   519: ldc 11
    //   521: iconst_2
    //   522: aload_1
    //   523: iconst_0
    //   524: anewarray 600	java/lang/Object
    //   527: invokestatic 603	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   530: goto -192 -> 338
    //   533: iload 16
    //   535: ifne +215 -> 750
    //   538: new 203	android/content/Intent
    //   541: dup
    //   542: invokespecial 727	android/content/Intent:<init>	()V
    //   545: astore 5
    //   547: aload 5
    //   549: aload 4
    //   551: ldc_w 729
    //   554: invokevirtual 733	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   557: pop
    //   558: aload 5
    //   560: ldc_w 735
    //   563: aload_3
    //   564: invokevirtual 739	android/content/Intent:putStringArrayListExtra	(Ljava/lang/String;Ljava/util/ArrayList;)Landroid/content/Intent;
    //   567: pop
    //   568: aload 5
    //   570: ldc_w 741
    //   573: aload 4
    //   575: invokevirtual 745	java/lang/Object:getClass	()Ljava/lang/Class;
    //   578: invokevirtual 750	java/lang/Class:getName	()Ljava/lang/String;
    //   581: invokevirtual 285	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   584: pop
    //   585: aload 5
    //   587: ldc_w 752
    //   590: ldc_w 754
    //   593: invokevirtual 285	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   596: pop
    //   597: aload 5
    //   599: ldc_w 756
    //   602: iconst_1
    //   603: invokevirtual 276	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   606: pop
    //   607: aload 5
    //   609: ldc_w 758
    //   612: iload 17
    //   614: invokevirtual 217	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   617: pop
    //   618: aload 5
    //   620: invokevirtual 762	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   623: ldc_w 764
    //   626: invokevirtual 769	android/os/Bundle:remove	(Ljava/lang/String;)V
    //   629: aload 5
    //   631: ldc_w 771
    //   634: iconst_1
    //   635: invokevirtual 276	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   638: pop
    //   639: aload 5
    //   641: ldc_w 773
    //   644: getstatic 776	com/tencent/mobileqq/utils/AlbumUtil:b	Ljava/lang/String;
    //   647: invokevirtual 285	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   650: pop
    //   651: aload 5
    //   653: ldc_w 778
    //   656: getstatic 779	com/tencent/mobileqq/utils/AlbumUtil:c	Ljava/lang/String;
    //   659: invokevirtual 285	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   662: pop
    //   663: aload_0
    //   664: getfield 101	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   667: invokevirtual 106	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   670: invokevirtual 112	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   673: astore_2
    //   674: aload_2
    //   675: astore_1
    //   676: aload_2
    //   677: ifnonnull +7 -> 684
    //   680: ldc_w 556
    //   683: astore_1
    //   684: aload 5
    //   686: ldc_w 781
    //   689: aload_1
    //   690: invokevirtual 285	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   693: pop
    //   694: aload 5
    //   696: ldc_w 783
    //   699: iconst_1
    //   700: invokevirtual 276	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   703: pop
    //   704: aload 5
    //   706: ldc 32
    //   708: iload 14
    //   710: invokevirtual 217	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   713: pop
    //   714: aload 5
    //   716: ldc 29
    //   718: iload 15
    //   720: invokevirtual 217	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   723: pop
    //   724: aload 5
    //   726: ldc 35
    //   728: iload 13
    //   730: invokevirtual 217	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   733: pop
    //   734: aload_0
    //   735: aload 5
    //   737: iconst_1
    //   738: invokevirtual 221	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   741: aload 4
    //   743: iconst_0
    //   744: iconst_1
    //   745: invokestatic 786	com/tencent/mobileqq/utils/AlbumUtil:a	(Landroid/app/Activity;ZZ)V
    //   748: iconst_1
    //   749: ireturn
    //   750: iload 16
    //   752: iconst_1
    //   753: if_icmpne -5 -> 748
    //   756: aload_0
    //   757: invokevirtual 788	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:a	()V
    //   760: goto -12 -> 748
    //   763: ldc_w 790
    //   766: aload 4
    //   768: invokevirtual 351	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   771: ifeq +275 -> 1046
    //   774: aconst_null
    //   775: astore 6
    //   777: new 575	org/json/JSONObject
    //   780: dup
    //   781: aload 5
    //   783: iconst_0
    //   784: aaload
    //   785: invokespecial 604	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   788: astore_2
    //   789: aload_2
    //   790: ldc_w 683
    //   793: invokevirtual 687	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   796: astore_1
    //   797: aload_1
    //   798: invokestatic 118	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   801: ifeq +5 -> 806
    //   804: iconst_1
    //   805: ireturn
    //   806: aload_2
    //   807: ldc_w 689
    //   810: invokevirtual 687	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   813: astore_3
    //   814: aload_1
    //   815: astore_2
    //   816: aload_0
    //   817: getfield 101	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   820: invokevirtual 106	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   823: invokevirtual 112	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   826: astore 4
    //   828: aload 4
    //   830: astore_1
    //   831: aload 4
    //   833: invokestatic 118	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   836: ifeq +6 -> 842
    //   839: ldc 120
    //   841: astore_1
    //   842: aload_0
    //   843: getfield 101	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   846: invokevirtual 106	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   849: invokevirtual 124	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   852: new 126	java/lang/StringBuilder
    //   855: dup
    //   856: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   859: aload_1
    //   860: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   863: ldc -123
    //   865: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   868: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   871: iconst_0
    //   872: invokevirtual 142	mqq/app/MobileQQ:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   875: aload_3
    //   876: aconst_null
    //   877: invokeinterface 573 3 0
    //   882: astore_1
    //   883: aload_1
    //   884: invokestatic 118	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   887: ifeq +76 -> 963
    //   890: new 575	org/json/JSONObject
    //   893: dup
    //   894: invokespecial 576	org/json/JSONObject:<init>	()V
    //   897: astore_1
    //   898: aload_1
    //   899: ldc_w 792
    //   902: ldc_w 794
    //   905: invokevirtual 609	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   908: pop
    //   909: aload_0
    //   910: aload_2
    //   911: iconst_1
    //   912: anewarray 347	java/lang/String
    //   915: dup
    //   916: iconst_0
    //   917: aload_1
    //   918: invokevirtual 614	org/json/JSONObject:toString	()Ljava/lang/String;
    //   921: aastore
    //   922: invokespecial 96	com/tencent/mobileqq/webview/swift/WebViewPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   925: goto -177 -> 748
    //   928: astore 4
    //   930: aconst_null
    //   931: astore_1
    //   932: aload 6
    //   934: astore_3
    //   935: aload_1
    //   936: astore_2
    //   937: invokestatic 248	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   940: ifeq -124 -> 816
    //   943: ldc 11
    //   945: iconst_2
    //   946: aload 4
    //   948: iconst_0
    //   949: anewarray 600	java/lang/Object
    //   952: invokestatic 603	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   955: aload 6
    //   957: astore_3
    //   958: aload_1
    //   959: astore_2
    //   960: goto -144 -> 816
    //   963: aload_0
    //   964: getfield 796	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   967: ifnonnull +43 -> 1010
    //   970: aload_0
    //   971: getfield 101	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   974: invokevirtual 244	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   977: astore_3
    //   978: aload_0
    //   979: new 798	com/tencent/mobileqq/widget/QQProgressDialog
    //   982: dup
    //   983: aload_3
    //   984: aload_3
    //   985: invokevirtual 802	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   988: ldc_w 803
    //   991: invokevirtual 809	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   994: invokespecial 812	com/tencent/mobileqq/widget/QQProgressDialog:<init>	(Landroid/content/Context;I)V
    //   997: putfield 796	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   1000: aload_0
    //   1001: getfield 796	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   1004: ldc_w 813
    //   1007: invokevirtual 815	com/tencent/mobileqq/widget/QQProgressDialog:b	(I)V
    //   1010: aload_0
    //   1011: getfield 796	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   1014: invokevirtual 818	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   1017: ifne +10 -> 1027
    //   1020: aload_0
    //   1021: getfield 796	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   1024: invokevirtual 821	com/tencent/mobileqq/widget/QQProgressDialog:show	()V
    //   1027: new 823	wey
    //   1030: dup
    //   1031: aload_0
    //   1032: aload_1
    //   1033: aload_2
    //   1034: invokespecial 826	wey:<init>	(Lcom/tencent/mobileqq/vashealth/HealthBusinessPlugin;Ljava/lang/String;Ljava/lang/String;)V
    //   1037: iconst_5
    //   1038: aconst_null
    //   1039: iconst_1
    //   1040: invokestatic 831	com/tencent/mobileqq/app/ThreadManager:a	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1043: goto -295 -> 748
    //   1046: ldc_w 833
    //   1049: aload 4
    //   1051: invokevirtual 351	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1054: ifeq +265 -> 1319
    //   1057: aload_0
    //   1058: invokevirtual 568	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:a	()Landroid/content/SharedPreferences;
    //   1061: astore_1
    //   1062: new 575	org/json/JSONObject
    //   1065: dup
    //   1066: aload 5
    //   1068: iconst_0
    //   1069: aaload
    //   1070: invokespecial 604	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1073: astore 4
    //   1075: aload 4
    //   1077: ldc_w 683
    //   1080: invokevirtual 687	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1083: astore_2
    //   1084: aload_2
    //   1085: invokestatic 118	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1088: ifeq +5 -> 1093
    //   1091: iconst_1
    //   1092: ireturn
    //   1093: aload 4
    //   1095: ldc_w 835
    //   1098: invokevirtual 687	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1101: astore_3
    //   1102: aload 4
    //   1104: ldc_w 689
    //   1107: invokevirtual 687	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1110: astore 4
    //   1112: aload_3
    //   1113: invokestatic 118	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1116: ifne +1594 -> 2710
    //   1119: aload 4
    //   1121: invokestatic 118	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1124: ifeq +6 -> 1130
    //   1127: goto +1583 -> 2710
    //   1130: aload_1
    //   1131: aload 4
    //   1133: aconst_null
    //   1134: invokeinterface 573 3 0
    //   1139: astore 6
    //   1141: new 578	org/json/JSONArray
    //   1144: dup
    //   1145: invokespecial 579	org/json/JSONArray:<init>	()V
    //   1148: astore 5
    //   1150: aload 6
    //   1152: invokestatic 118	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1155: ifne -407 -> 748
    //   1158: new 575	org/json/JSONObject
    //   1161: dup
    //   1162: aload 6
    //   1164: invokespecial 604	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1167: astore 6
    //   1169: aload 6
    //   1171: ldc_w 606
    //   1174: invokevirtual 717	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1177: astore 7
    //   1179: iconst_0
    //   1180: istore 12
    //   1182: iload 12
    //   1184: aload 7
    //   1186: invokevirtual 721	org/json/JSONArray:length	()I
    //   1189: if_icmpge +57 -> 1246
    //   1192: aload_3
    //   1193: aload 7
    //   1195: iload 12
    //   1197: invokevirtual 723	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   1200: invokevirtual 351	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1203: ifeq +6 -> 1209
    //   1206: goto +1506 -> 2712
    //   1209: aload 5
    //   1211: aload 7
    //   1213: iload 12
    //   1215: invokevirtual 723	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   1218: invokevirtual 598	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   1221: pop
    //   1222: goto +1490 -> 2712
    //   1225: astore_1
    //   1226: invokestatic 248	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1229: ifeq -481 -> 748
    //   1232: ldc 11
    //   1234: iconst_2
    //   1235: aload_1
    //   1236: iconst_0
    //   1237: anewarray 600	java/lang/Object
    //   1240: invokestatic 603	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   1243: goto -495 -> 748
    //   1246: aload 6
    //   1248: ldc_w 606
    //   1251: aload 5
    //   1253: invokevirtual 609	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1256: pop
    //   1257: aload_1
    //   1258: invokeinterface 613 1 0
    //   1263: aload 4
    //   1265: aload 6
    //   1267: invokevirtual 614	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1270: invokeinterface 620 3 0
    //   1275: invokeinterface 623 1 0
    //   1280: pop
    //   1281: new 575	org/json/JSONObject
    //   1284: dup
    //   1285: invokespecial 576	org/json/JSONObject:<init>	()V
    //   1288: astore_1
    //   1289: aload_1
    //   1290: ldc_w 792
    //   1293: ldc_w 837
    //   1296: invokevirtual 609	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1299: pop
    //   1300: aload_0
    //   1301: aload_2
    //   1302: iconst_1
    //   1303: anewarray 347	java/lang/String
    //   1306: dup
    //   1307: iconst_0
    //   1308: aload_1
    //   1309: invokevirtual 614	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1312: aastore
    //   1313: invokespecial 96	com/tencent/mobileqq/webview/swift/WebViewPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1316: goto -568 -> 748
    //   1319: ldc_w 839
    //   1322: aload 4
    //   1324: invokevirtual 351	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1327: ifeq +738 -> 2065
    //   1330: aconst_null
    //   1331: astore 8
    //   1333: aconst_null
    //   1334: astore 4
    //   1336: aconst_null
    //   1337: astore 9
    //   1339: aconst_null
    //   1340: astore_2
    //   1341: aconst_null
    //   1342: astore 7
    //   1344: aconst_null
    //   1345: astore_3
    //   1346: aconst_null
    //   1347: astore 6
    //   1349: aconst_null
    //   1350: astore_1
    //   1351: new 575	org/json/JSONObject
    //   1354: dup
    //   1355: aload 5
    //   1357: iconst_0
    //   1358: aaload
    //   1359: invokespecial 604	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1362: astore 10
    //   1364: aload 10
    //   1366: ldc_w 683
    //   1369: invokevirtual 687	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1372: astore 5
    //   1374: aload 5
    //   1376: astore_2
    //   1377: aload 9
    //   1379: astore 5
    //   1381: aload 8
    //   1383: astore 4
    //   1385: aload 7
    //   1387: astore_3
    //   1388: aload 6
    //   1390: astore_1
    //   1391: aload_2
    //   1392: invokestatic 118	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1395: ifeq +5 -> 1400
    //   1398: iconst_1
    //   1399: ireturn
    //   1400: aload 9
    //   1402: astore 5
    //   1404: aload 8
    //   1406: astore 4
    //   1408: aload 7
    //   1410: astore_3
    //   1411: aload 6
    //   1413: astore_1
    //   1414: aload 10
    //   1416: ldc_w 689
    //   1419: invokevirtual 687	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1422: astore 8
    //   1424: aload 9
    //   1426: astore 5
    //   1428: aload 8
    //   1430: astore 4
    //   1432: aload 7
    //   1434: astore_3
    //   1435: aload 6
    //   1437: astore_1
    //   1438: aload 10
    //   1440: ldc_w 841
    //   1443: invokevirtual 687	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1446: astore 9
    //   1448: aload 9
    //   1450: astore 5
    //   1452: aload 8
    //   1454: astore 4
    //   1456: aload 7
    //   1458: astore_3
    //   1459: aload 6
    //   1461: astore_1
    //   1462: aload 10
    //   1464: ldc_w 843
    //   1467: ldc_w 845
    //   1470: invokevirtual 847	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1473: astore 7
    //   1475: aload 9
    //   1477: astore 5
    //   1479: aload 8
    //   1481: astore 4
    //   1483: aload 7
    //   1485: astore_3
    //   1486: aload 6
    //   1488: astore_1
    //   1489: aload 10
    //   1491: ldc_w 849
    //   1494: ldc_w 851
    //   1497: invokevirtual 847	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1500: astore 6
    //   1502: aload 9
    //   1504: astore 5
    //   1506: aload 8
    //   1508: astore 4
    //   1510: aload 7
    //   1512: astore_3
    //   1513: aload 6
    //   1515: astore_1
    //   1516: aload_0
    //   1517: aload 10
    //   1519: ldc_w 853
    //   1522: iconst_0
    //   1523: invokevirtual 857	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   1526: putfield 88	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:b	Z
    //   1529: aload 9
    //   1531: astore 5
    //   1533: aload 8
    //   1535: astore 4
    //   1537: aload 7
    //   1539: astore_3
    //   1540: aload 6
    //   1542: astore_1
    //   1543: aload 8
    //   1545: invokestatic 118	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1548: ifne +1173 -> 2721
    //   1551: aload 9
    //   1553: astore 5
    //   1555: aload 8
    //   1557: astore 4
    //   1559: aload 7
    //   1561: astore_3
    //   1562: aload 6
    //   1564: astore_1
    //   1565: aload 9
    //   1567: invokestatic 118	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1570: ifeq +6 -> 1576
    //   1573: goto +1148 -> 2721
    //   1576: aload 9
    //   1578: astore 5
    //   1580: aload 8
    //   1582: astore 4
    //   1584: aload 7
    //   1586: astore_3
    //   1587: aload 6
    //   1589: astore_1
    //   1590: getstatic 82	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1593: aload 8
    //   1595: invokeinterface 859 2 0
    //   1600: ifeq +49 -> 1649
    //   1603: aload 9
    //   1605: astore 5
    //   1607: aload 8
    //   1609: astore 4
    //   1611: aload 7
    //   1613: astore_3
    //   1614: aload 6
    //   1616: astore_1
    //   1617: invokestatic 248	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1620: ifeq +1103 -> 2723
    //   1623: aload 9
    //   1625: astore 5
    //   1627: aload 8
    //   1629: astore 4
    //   1631: aload 7
    //   1633: astore_3
    //   1634: aload 6
    //   1636: astore_1
    //   1637: ldc 11
    //   1639: iconst_2
    //   1640: ldc_w 861
    //   1643: invokestatic 255	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1646: goto +1077 -> 2723
    //   1649: aload 9
    //   1651: astore 5
    //   1653: aload 8
    //   1655: astore 4
    //   1657: aload 7
    //   1659: astore_3
    //   1660: aload 6
    //   1662: astore_1
    //   1663: getstatic 82	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1666: aload 8
    //   1668: invokeinterface 862 2 0
    //   1673: pop
    //   1674: aload_2
    //   1675: astore 11
    //   1677: aload_0
    //   1678: invokevirtual 568	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:a	()Landroid/content/SharedPreferences;
    //   1681: aload 8
    //   1683: aconst_null
    //   1684: invokeinterface 573 3 0
    //   1689: astore_2
    //   1690: new 79	java/util/ArrayList
    //   1693: dup
    //   1694: invokespecial 80	java/util/ArrayList:<init>	()V
    //   1697: astore_1
    //   1698: iconst_1
    //   1699: istore 21
    //   1701: iload 21
    //   1703: istore 20
    //   1705: aload_2
    //   1706: invokestatic 118	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1709: ifeq +119 -> 1828
    //   1712: iload 21
    //   1714: istore 20
    //   1716: new 575	org/json/JSONObject
    //   1719: dup
    //   1720: invokespecial 576	org/json/JSONObject:<init>	()V
    //   1723: astore_2
    //   1724: iload 21
    //   1726: istore 20
    //   1728: aload_2
    //   1729: ldc_w 792
    //   1732: ldc_w 864
    //   1735: invokevirtual 609	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1738: pop
    //   1739: iload 21
    //   1741: istore 20
    //   1743: aload_0
    //   1744: aload 11
    //   1746: iconst_1
    //   1747: anewarray 347	java/lang/String
    //   1750: dup
    //   1751: iconst_0
    //   1752: aload_2
    //   1753: invokevirtual 614	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1756: aastore
    //   1757: invokespecial 96	com/tencent/mobileqq/webview/swift/WebViewPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1760: iconst_1
    //   1761: ireturn
    //   1762: astore 10
    //   1764: aconst_null
    //   1765: astore 6
    //   1767: aload_2
    //   1768: astore 5
    //   1770: aload 6
    //   1772: astore_2
    //   1773: aload_2
    //   1774: astore 11
    //   1776: aload 5
    //   1778: astore 9
    //   1780: aload 4
    //   1782: astore 8
    //   1784: aload_3
    //   1785: astore 7
    //   1787: aload_1
    //   1788: astore 6
    //   1790: invokestatic 248	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1793: ifeq -116 -> 1677
    //   1796: ldc 11
    //   1798: iconst_2
    //   1799: aload 10
    //   1801: iconst_0
    //   1802: anewarray 600	java/lang/Object
    //   1805: invokestatic 603	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   1808: aload_2
    //   1809: astore 11
    //   1811: aload 5
    //   1813: astore 9
    //   1815: aload 4
    //   1817: astore 8
    //   1819: aload_3
    //   1820: astore 7
    //   1822: aload_1
    //   1823: astore 6
    //   1825: goto -148 -> 1677
    //   1828: iload 21
    //   1830: istore 20
    //   1832: new 575	org/json/JSONObject
    //   1835: dup
    //   1836: aload_2
    //   1837: invokespecial 604	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1840: astore_2
    //   1841: iload 21
    //   1843: istore 20
    //   1845: aload_2
    //   1846: ldc_w 606
    //   1849: invokevirtual 704	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1852: istore 21
    //   1854: iload 21
    //   1856: ifeq +185 -> 2041
    //   1859: iload 21
    //   1861: istore 20
    //   1863: aload_2
    //   1864: ldc_w 606
    //   1867: invokevirtual 717	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1870: astore_2
    //   1871: iconst_0
    //   1872: istore 12
    //   1874: iload 21
    //   1876: istore 20
    //   1878: iload 21
    //   1880: istore 22
    //   1882: iload 12
    //   1884: aload_2
    //   1885: invokevirtual 721	org/json/JSONArray:length	()I
    //   1888: if_icmpge +102 -> 1990
    //   1891: iload 21
    //   1893: istore 20
    //   1895: aload_2
    //   1896: iload 12
    //   1898: invokevirtual 723	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   1901: astore_3
    //   1902: iload 21
    //   1904: istore 20
    //   1906: aload_3
    //   1907: invokestatic 118	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1910: ifne +815 -> 2725
    //   1913: iload 21
    //   1915: istore 20
    //   1917: aload_3
    //   1918: ldc_w 516
    //   1921: invokevirtual 645	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1924: ifne +801 -> 2725
    //   1927: iload 21
    //   1929: istore 20
    //   1931: aload_3
    //   1932: ldc_w 866
    //   1935: invokevirtual 351	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1938: ifeq +6 -> 1944
    //   1941: goto +784 -> 2725
    //   1944: iload 21
    //   1946: istore 20
    //   1948: aload_1
    //   1949: aload_2
    //   1950: iload 12
    //   1952: invokevirtual 723	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   1955: invokeinterface 862 2 0
    //   1960: pop
    //   1961: goto +764 -> 2725
    //   1964: astore_2
    //   1965: iload 20
    //   1967: istore 22
    //   1969: invokestatic 248	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1972: ifeq +18 -> 1990
    //   1975: ldc 11
    //   1977: iconst_2
    //   1978: aload_2
    //   1979: iconst_0
    //   1980: anewarray 600	java/lang/Object
    //   1983: invokestatic 603	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   1986: iload 20
    //   1988: istore 22
    //   1990: aload_0
    //   1991: getfield 101	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1994: invokevirtual 244	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1997: instanceof 234
    //   2000: ifeq -1252 -> 748
    //   2003: new 868	wfb
    //   2006: dup
    //   2007: aload_0
    //   2008: aload_0
    //   2009: getfield 101	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2012: invokevirtual 244	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   2015: checkcast 234	com/tencent/mobileqq/app/BaseActivity
    //   2018: aload_1
    //   2019: aload 9
    //   2021: aload 8
    //   2023: iload 22
    //   2025: aload 7
    //   2027: aload 6
    //   2029: invokespecial 871	wfb:<init>	(Lcom/tencent/mobileqq/vashealth/HealthBusinessPlugin;Lcom/tencent/mobileqq/app/BaseActivity;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V
    //   2032: iconst_5
    //   2033: aconst_null
    //   2034: iconst_0
    //   2035: invokestatic 831	com/tencent/mobileqq/app/ThreadManager:a	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   2038: goto -1290 -> 748
    //   2041: iload 21
    //   2043: istore 20
    //   2045: aload_1
    //   2046: aload_2
    //   2047: ldc 23
    //   2049: invokevirtual 873	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2052: invokeinterface 862 2 0
    //   2057: pop
    //   2058: iload 21
    //   2060: istore 22
    //   2062: goto -72 -> 1990
    //   2065: ldc_w 875
    //   2068: aload 4
    //   2070: invokevirtual 351	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2073: ifeq +236 -> 2309
    //   2076: aconst_null
    //   2077: astore 6
    //   2079: new 575	org/json/JSONObject
    //   2082: dup
    //   2083: aload 5
    //   2085: iconst_0
    //   2086: aaload
    //   2087: invokespecial 604	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2090: astore_2
    //   2091: aload_2
    //   2092: ldc_w 683
    //   2095: invokevirtual 687	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2098: astore_1
    //   2099: aload_1
    //   2100: invokestatic 118	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2103: ifeq +5 -> 2108
    //   2106: iconst_1
    //   2107: ireturn
    //   2108: aload_2
    //   2109: ldc_w 689
    //   2112: invokevirtual 687	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2115: astore_3
    //   2116: aload_1
    //   2117: astore_2
    //   2118: aload_0
    //   2119: invokevirtual 568	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:a	()Landroid/content/SharedPreferences;
    //   2122: astore_1
    //   2123: aload_1
    //   2124: aload_3
    //   2125: aconst_null
    //   2126: invokeinterface 573 3 0
    //   2131: astore 4
    //   2133: aload 4
    //   2135: invokestatic 118	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2138: ifne +58 -> 2196
    //   2141: aload 4
    //   2143: ldc 23
    //   2145: invokevirtual 638	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2148: ifeq +48 -> 2196
    //   2151: new 155	java/io/File
    //   2154: dup
    //   2155: new 575	org/json/JSONObject
    //   2158: dup
    //   2159: aload 4
    //   2161: invokespecial 604	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2164: ldc 26
    //   2166: invokevirtual 873	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2169: invokespecial 163	java/io/File:<init>	(Ljava/lang/String;)V
    //   2172: astore 4
    //   2174: aload 4
    //   2176: invokevirtual 167	java/io/File:exists	()Z
    //   2179: ifeq +17 -> 2196
    //   2182: aload 4
    //   2184: invokevirtual 662	java/io/File:isFile	()Z
    //   2187: ifeq +9 -> 2196
    //   2190: aload 4
    //   2192: invokevirtual 878	java/io/File:delete	()Z
    //   2195: pop
    //   2196: new 575	org/json/JSONObject
    //   2199: dup
    //   2200: invokespecial 576	org/json/JSONObject:<init>	()V
    //   2203: astore 4
    //   2205: aload_1
    //   2206: invokeinterface 613 1 0
    //   2211: aload_3
    //   2212: invokeinterface 881 2 0
    //   2217: invokeinterface 623 1 0
    //   2222: istore 20
    //   2224: iload 20
    //   2226: ifeq +76 -> 2302
    //   2229: ldc_w 837
    //   2232: astore_1
    //   2233: aload 4
    //   2235: ldc_w 792
    //   2238: aload_1
    //   2239: invokevirtual 609	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2242: pop
    //   2243: aload_0
    //   2244: aload_2
    //   2245: iconst_1
    //   2246: anewarray 347	java/lang/String
    //   2249: dup
    //   2250: iconst_0
    //   2251: aload 4
    //   2253: invokevirtual 614	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2256: aastore
    //   2257: invokespecial 96	com/tencent/mobileqq/webview/swift/WebViewPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2260: goto -1512 -> 748
    //   2263: astore_1
    //   2264: goto -1516 -> 748
    //   2267: astore 4
    //   2269: aconst_null
    //   2270: astore_1
    //   2271: aload 6
    //   2273: astore_3
    //   2274: aload_1
    //   2275: astore_2
    //   2276: invokestatic 248	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2279: ifeq -161 -> 2118
    //   2282: ldc 11
    //   2284: iconst_2
    //   2285: aload 4
    //   2287: iconst_0
    //   2288: anewarray 600	java/lang/Object
    //   2291: invokestatic 603	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   2294: aload 6
    //   2296: astore_3
    //   2297: aload_1
    //   2298: astore_2
    //   2299: goto -181 -> 2118
    //   2302: ldc_w 883
    //   2305: astore_1
    //   2306: goto -73 -> 2233
    //   2309: ldc_w 885
    //   2312: aload 4
    //   2314: invokevirtual 351	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2317: ifeq +229 -> 2546
    //   2320: iconst_0
    //   2321: istore 15
    //   2323: iconst_0
    //   2324: istore 16
    //   2326: iconst_0
    //   2327: istore 17
    //   2329: iconst_0
    //   2330: istore 18
    //   2332: iload 17
    //   2334: istore 14
    //   2336: iload 16
    //   2338: istore 13
    //   2340: iload 15
    //   2342: istore 12
    //   2344: new 575	org/json/JSONObject
    //   2347: dup
    //   2348: aload 5
    //   2350: iconst_0
    //   2351: aaload
    //   2352: invokespecial 604	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2355: astore_1
    //   2356: iload 17
    //   2358: istore 14
    //   2360: iload 16
    //   2362: istore 13
    //   2364: iload 15
    //   2366: istore 12
    //   2368: aload_1
    //   2369: ldc_w 683
    //   2372: invokevirtual 687	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2375: astore_2
    //   2376: iload 17
    //   2378: istore 14
    //   2380: iload 16
    //   2382: istore 13
    //   2384: iload 15
    //   2386: istore 12
    //   2388: aload_2
    //   2389: invokestatic 118	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2392: ifne +20 -> 2412
    //   2395: iload 17
    //   2397: istore 14
    //   2399: iload 16
    //   2401: istore 13
    //   2403: iload 15
    //   2405: istore 12
    //   2407: aload_0
    //   2408: aload_2
    //   2409: putfield 191	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:o	Ljava/lang/String;
    //   2412: iload 17
    //   2414: istore 14
    //   2416: iload 16
    //   2418: istore 13
    //   2420: iload 15
    //   2422: istore 12
    //   2424: aload_1
    //   2425: ldc_w 887
    //   2428: ldc_w 888
    //   2431: invokevirtual 698	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2434: istore 15
    //   2436: iload 17
    //   2438: istore 14
    //   2440: iload 16
    //   2442: istore 13
    //   2444: iload 15
    //   2446: istore 12
    //   2448: aload_1
    //   2449: ldc_w 890
    //   2452: sipush 180
    //   2455: invokevirtual 698	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2458: istore 16
    //   2460: iload 17
    //   2462: istore 14
    //   2464: iload 16
    //   2466: istore 13
    //   2468: iload 15
    //   2470: istore 12
    //   2472: aload_1
    //   2473: ldc_w 892
    //   2476: ldc_w 893
    //   2479: invokevirtual 698	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2482: istore 17
    //   2484: iload 17
    //   2486: istore 14
    //   2488: iload 16
    //   2490: istore 13
    //   2492: iload 15
    //   2494: istore 12
    //   2496: aload_1
    //   2497: ldc_w 895
    //   2500: bipush 20
    //   2502: invokevirtual 698	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2505: istore 19
    //   2507: iload 19
    //   2509: istore 12
    //   2511: iload 15
    //   2513: istore 18
    //   2515: iload 16
    //   2517: istore 13
    //   2519: iload 17
    //   2521: istore 14
    //   2523: iload 12
    //   2525: istore 15
    //   2527: aload_0
    //   2528: iload 18
    //   2530: iload 13
    //   2532: sipush 1000
    //   2535: imul
    //   2536: iload 14
    //   2538: iload 15
    //   2540: invokevirtual 897	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:a	(IIII)V
    //   2543: goto -1795 -> 748
    //   2546: ldc_w 899
    //   2549: aload 4
    //   2551: invokevirtual 351	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2554: ifeq -1806 -> 748
    //   2557: aconst_null
    //   2558: astore_2
    //   2559: aconst_null
    //   2560: astore_3
    //   2561: aload_2
    //   2562: astore_1
    //   2563: new 575	org/json/JSONObject
    //   2566: dup
    //   2567: aload 5
    //   2569: iconst_0
    //   2570: aaload
    //   2571: invokespecial 604	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2574: astore 4
    //   2576: aload_2
    //   2577: astore_1
    //   2578: aload 4
    //   2580: ldc_w 683
    //   2583: invokevirtual 687	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2586: astore_2
    //   2587: aload_2
    //   2588: astore_1
    //   2589: aload 4
    //   2591: ldc_w 689
    //   2594: invokevirtual 873	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2597: astore 4
    //   2599: aload 4
    //   2601: astore_3
    //   2602: aload_2
    //   2603: astore_1
    //   2604: aload_1
    //   2605: invokestatic 118	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2608: ifne +10 -> 2618
    //   2611: aload_3
    //   2612: invokestatic 118	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2615: ifeq +5 -> 2620
    //   2618: iconst_1
    //   2619: ireturn
    //   2620: aload_0
    //   2621: invokevirtual 568	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:a	()Landroid/content/SharedPreferences;
    //   2624: aload_3
    //   2625: aconst_null
    //   2626: invokeinterface 573 3 0
    //   2631: astore_2
    //   2632: aload_2
    //   2633: ifnonnull +5 -> 2638
    //   2636: iconst_1
    //   2637: ireturn
    //   2638: new 901	wez
    //   2641: dup
    //   2642: aload_0
    //   2643: aload_2
    //   2644: aload_1
    //   2645: invokespecial 902	wez:<init>	(Lcom/tencent/mobileqq/vashealth/HealthBusinessPlugin;Ljava/lang/String;Ljava/lang/String;)V
    //   2648: iconst_5
    //   2649: aconst_null
    //   2650: iconst_1
    //   2651: invokestatic 831	com/tencent/mobileqq/app/ThreadManager:a	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   2654: goto -1906 -> 748
    //   2657: astore_2
    //   2658: goto -54 -> 2604
    //   2661: astore_1
    //   2662: iload 18
    //   2664: istore 15
    //   2666: iload 12
    //   2668: istore 18
    //   2670: goto -143 -> 2527
    //   2673: astore 4
    //   2675: goto -479 -> 2196
    //   2678: astore 4
    //   2680: goto -409 -> 2271
    //   2683: astore 10
    //   2685: goto -912 -> 1773
    //   2688: astore_3
    //   2689: goto -1780 -> 909
    //   2692: astore 4
    //   2694: goto -1762 -> 932
    //   2697: astore 5
    //   2699: aload 4
    //   2701: astore_1
    //   2702: aload_3
    //   2703: astore_2
    //   2704: aload 5
    //   2706: astore_3
    //   2707: goto -2313 -> 394
    //   2710: iconst_1
    //   2711: ireturn
    //   2712: iload 12
    //   2714: iconst_1
    //   2715: iadd
    //   2716: istore 12
    //   2718: goto -1536 -> 1182
    //   2721: iconst_1
    //   2722: ireturn
    //   2723: iconst_1
    //   2724: ireturn
    //   2725: iload 12
    //   2727: iconst_1
    //   2728: iadd
    //   2729: istore 12
    //   2731: goto -857 -> 1874
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2734	0	this	HealthBusinessPlugin
    //   0	2734	1	paramJsBridgeListener	com.tencent.mobileqq.webview.swift.JsBridgeListener
    //   0	2734	2	paramString1	String
    //   0	2734	3	paramString2	String
    //   0	2734	4	paramString3	String
    //   0	2734	5	paramVarArgs	String[]
    //   775	1520	6	localObject1	Object
    //   1177	849	7	localObject2	Object
    //   1331	691	8	str1	String
    //   1337	683	9	localObject3	Object
    //   1362	156	10	localJSONObject	JSONObject
    //   1762	38	10	localException1	Exception
    //   2683	1	10	localException2	Exception
    //   1675	135	11	str2	String
    //   17	2713	12	i1	int
    //   25	2511	13	i2	int
    //   34	2503	14	i3	int
    //   30	2635	15	i4	int
    //   38	2478	16	i5	int
    //   42	2478	17	i6	int
    //   20	2649	18	i7	int
    //   253	2255	19	i8	int
    //   1703	522	20	bool1	boolean
    //   1699	360	21	bool2	boolean
    //   1880	181	22	bool3	boolean
    // Exception table:
    //   from	to	target	type
    //   49	62	372	java/lang/Exception
    //   79	88	372	java/lang/Exception
    //   105	112	372	java/lang/Exception
    //   131	141	372	java/lang/Exception
    //   158	168	372	java/lang/Exception
    //   185	197	372	java/lang/Exception
    //   214	226	372	java/lang/Exception
    //   243	255	372	java/lang/Exception
    //   461	480	512	java/lang/Exception
    //   483	503	512	java/lang/Exception
    //   777	797	928	java/lang/Exception
    //   1062	1091	1225	java/lang/Exception
    //   1093	1127	1225	java/lang/Exception
    //   1130	1179	1225	java/lang/Exception
    //   1182	1206	1225	java/lang/Exception
    //   1209	1222	1225	java/lang/Exception
    //   1246	1316	1225	java/lang/Exception
    //   1351	1374	1762	java/lang/Exception
    //   1705	1712	1964	java/lang/Exception
    //   1716	1724	1964	java/lang/Exception
    //   1728	1739	1964	java/lang/Exception
    //   1743	1760	1964	java/lang/Exception
    //   1832	1841	1964	java/lang/Exception
    //   1845	1854	1964	java/lang/Exception
    //   1863	1871	1964	java/lang/Exception
    //   1882	1891	1964	java/lang/Exception
    //   1895	1902	1964	java/lang/Exception
    //   1906	1913	1964	java/lang/Exception
    //   1917	1927	1964	java/lang/Exception
    //   1931	1941	1964	java/lang/Exception
    //   1948	1961	1964	java/lang/Exception
    //   2045	2058	1964	java/lang/Exception
    //   2233	2260	2263	java/lang/Exception
    //   2079	2099	2267	java/lang/Exception
    //   2563	2576	2657	java/lang/Exception
    //   2578	2587	2657	java/lang/Exception
    //   2589	2599	2657	java/lang/Exception
    //   2344	2356	2661	java/lang/Exception
    //   2368	2376	2661	java/lang/Exception
    //   2388	2395	2661	java/lang/Exception
    //   2407	2412	2661	java/lang/Exception
    //   2424	2436	2661	java/lang/Exception
    //   2448	2460	2661	java/lang/Exception
    //   2472	2484	2661	java/lang/Exception
    //   2496	2507	2661	java/lang/Exception
    //   2151	2196	2673	java/lang/Exception
    //   2099	2106	2678	java/lang/Exception
    //   2108	2116	2678	java/lang/Exception
    //   1391	1398	2683	java/lang/Exception
    //   1414	1424	2683	java/lang/Exception
    //   1438	1448	2683	java/lang/Exception
    //   1462	1475	2683	java/lang/Exception
    //   1489	1502	2683	java/lang/Exception
    //   1516	1529	2683	java/lang/Exception
    //   1543	1551	2683	java/lang/Exception
    //   1565	1573	2683	java/lang/Exception
    //   1590	1603	2683	java/lang/Exception
    //   1617	1623	2683	java/lang/Exception
    //   1637	1646	2683	java/lang/Exception
    //   1663	1674	2683	java/lang/Exception
    //   898	909	2688	java/lang/Exception
    //   797	804	2692	java/lang/Exception
    //   806	814	2692	java/lang/Exception
    //   263	284	2697	java/lang/Exception
  }
  
  /* Error */
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: iload_2
    //   3: iload_3
    //   4: invokespecial 906	com/tencent/mobileqq/webview/swift/WebViewPlugin:onActivityResult	(Landroid/content/Intent;BI)V
    //   7: iload_2
    //   8: iconst_1
    //   9: if_icmpne +165 -> 174
    //   12: iload_3
    //   13: iconst_m1
    //   14: if_icmpne +123 -> 137
    //   17: aload_1
    //   18: ldc_w 908
    //   21: invokevirtual 912	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   24: astore_1
    //   25: aload_1
    //   26: ifnonnull +4 -> 30
    //   29: return
    //   30: aload_0
    //   31: getfield 189	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:n	Ljava/lang/String;
    //   34: invokestatic 118	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   37: ifne +13 -> 50
    //   40: aload_0
    //   41: getfield 191	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:o	Ljava/lang/String;
    //   44: invokestatic 118	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   47: ifeq +13 -> 60
    //   50: ldc 11
    //   52: iconst_1
    //   53: ldc_w 914
    //   56: invokestatic 198	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   59: return
    //   60: aload_0
    //   61: getfield 101	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   64: ifnull +8 -> 72
    //   67: aload_0
    //   68: aload_1
    //   69: invokevirtual 916	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:a	(Ljava/util/List;)V
    //   72: new 575	org/json/JSONObject
    //   75: dup
    //   76: invokespecial 576	org/json/JSONObject:<init>	()V
    //   79: astore 4
    //   81: aload 4
    //   83: ldc_w 918
    //   86: aload_0
    //   87: getfield 189	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:n	Ljava/lang/String;
    //   90: invokevirtual 609	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   93: pop
    //   94: aload_0
    //   95: aload_0
    //   96: getfield 191	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:o	Ljava/lang/String;
    //   99: iconst_1
    //   100: anewarray 347	java/lang/String
    //   103: dup
    //   104: iconst_0
    //   105: aload 4
    //   107: invokevirtual 614	org/json/JSONObject:toString	()Ljava/lang/String;
    //   110: aastore
    //   111: invokespecial 96	com/tencent/mobileqq/webview/swift/WebViewPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   114: aload_0
    //   115: getfield 101	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   118: ifnull -89 -> 29
    //   121: new 920	wfa
    //   124: dup
    //   125: aload_0
    //   126: aload_1
    //   127: invokespecial 923	wfa:<init>	(Lcom/tencent/mobileqq/vashealth/HealthBusinessPlugin;Ljava/util/List;)V
    //   130: iconst_5
    //   131: aconst_null
    //   132: iconst_1
    //   133: invokestatic 831	com/tencent/mobileqq/app/ThreadManager:a	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   136: return
    //   137: iload_3
    //   138: bipush 16
    //   140: if_icmpne -111 -> 29
    //   143: aload_1
    //   144: ldc_w 908
    //   147: invokevirtual 912	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   150: astore_1
    //   151: aload_1
    //   152: ifnull +17 -> 169
    //   155: aload_1
    //   156: invokeinterface 925 1 0
    //   161: ifne +8 -> 169
    //   164: aload_0
    //   165: aload_1
    //   166: invokevirtual 916	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:a	(Ljava/util/List;)V
    //   169: aload_0
    //   170: invokevirtual 788	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:a	()V
    //   173: return
    //   174: iload_2
    //   175: iconst_2
    //   176: if_icmpne +295 -> 471
    //   179: aload_0
    //   180: getfield 191	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:o	Ljava/lang/String;
    //   183: invokestatic 118	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   186: ifne +13 -> 199
    //   189: aload_0
    //   190: getfield 189	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:n	Ljava/lang/String;
    //   193: invokestatic 118	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   196: ifeq +13 -> 209
    //   199: ldc 11
    //   201: iconst_1
    //   202: ldc_w 927
    //   205: invokestatic 198	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   208: return
    //   209: new 575	org/json/JSONObject
    //   212: dup
    //   213: invokespecial 576	org/json/JSONObject:<init>	()V
    //   216: astore 5
    //   218: iload_3
    //   219: iconst_m1
    //   220: if_icmpne +232 -> 452
    //   223: aload_0
    //   224: getfield 101	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   227: ifnull +162 -> 389
    //   230: aload_0
    //   231: getfield 101	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   234: invokevirtual 244	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   237: ifnull +152 -> 389
    //   240: aload_0
    //   241: getfield 101	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   244: invokevirtual 244	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   247: invokevirtual 931	android/app/Activity:getApplicationContext	()Landroid/content/Context;
    //   250: astore_1
    //   251: aload_1
    //   252: aload_0
    //   253: getfield 86	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_AndroidNetUri	Landroid/net/Uri;
    //   256: invokestatic 936	com/tencent/mobileqq/utils/ImageUtil:c	(Landroid/content/Context;Landroid/net/Uri;)Ljava/lang/String;
    //   259: astore 6
    //   261: aload_1
    //   262: aload 6
    //   264: invokestatic 939	com/tencent/mobileqq/utils/ImageUtil:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   267: aload_0
    //   268: invokevirtual 568	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:a	()Landroid/content/SharedPreferences;
    //   271: astore 7
    //   273: aload 7
    //   275: aload_0
    //   276: getfield 189	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:n	Ljava/lang/String;
    //   279: aconst_null
    //   280: invokeinterface 573 3 0
    //   285: astore 4
    //   287: aload 4
    //   289: invokestatic 118	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   292: ifeq +135 -> 427
    //   295: new 575	org/json/JSONObject
    //   298: dup
    //   299: invokespecial 576	org/json/JSONObject:<init>	()V
    //   302: astore_1
    //   303: aload 4
    //   305: invokestatic 118	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   308: ifeq +132 -> 440
    //   311: new 578	org/json/JSONArray
    //   314: dup
    //   315: invokespecial 579	org/json/JSONArray:<init>	()V
    //   318: astore 4
    //   320: aload 4
    //   322: aload 6
    //   324: invokevirtual 598	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   327: pop
    //   328: aload_1
    //   329: ldc_w 606
    //   332: aload 4
    //   334: invokevirtual 609	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   337: pop
    //   338: aload 7
    //   340: invokeinterface 613 1 0
    //   345: aload_0
    //   346: getfield 189	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:n	Ljava/lang/String;
    //   349: aload_1
    //   350: invokevirtual 614	org/json/JSONObject:toString	()Ljava/lang/String;
    //   353: invokeinterface 620 3 0
    //   358: invokeinterface 623 1 0
    //   363: pop
    //   364: aload 5
    //   366: ldc_w 918
    //   369: aload_0
    //   370: getfield 189	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:n	Ljava/lang/String;
    //   373: invokevirtual 609	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   376: pop
    //   377: aload 5
    //   379: ldc_w 792
    //   382: ldc_w 941
    //   385: invokevirtual 609	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   388: pop
    //   389: aload_0
    //   390: getfield 101	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   393: ifnull -364 -> 29
    //   396: aload_0
    //   397: getfield 101	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   400: invokevirtual 244	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   403: ifnull -374 -> 29
    //   406: aload_0
    //   407: aload_0
    //   408: getfield 191	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:o	Ljava/lang/String;
    //   411: iconst_1
    //   412: anewarray 347	java/lang/String
    //   415: dup
    //   416: iconst_0
    //   417: aload 5
    //   419: invokevirtual 614	org/json/JSONObject:toString	()Ljava/lang/String;
    //   422: aastore
    //   423: invokespecial 96	com/tencent/mobileqq/webview/swift/WebViewPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   426: return
    //   427: new 575	org/json/JSONObject
    //   430: dup
    //   431: aload 4
    //   433: invokespecial 604	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   436: astore_1
    //   437: goto -134 -> 303
    //   440: aload_1
    //   441: ldc_w 606
    //   444: invokevirtual 717	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   447: astore 4
    //   449: goto -129 -> 320
    //   452: aload 5
    //   454: ldc_w 792
    //   457: ldc_w 943
    //   460: invokevirtual 609	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   463: pop
    //   464: goto -75 -> 389
    //   467: astore_1
    //   468: goto -79 -> 389
    //   471: iload_2
    //   472: iconst_3
    //   473: if_icmpne -444 -> 29
    //   476: iload_3
    //   477: iconst_1
    //   478: if_icmpne -449 -> 29
    //   481: aload_1
    //   482: ldc 23
    //   484: invokevirtual 946	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   487: astore 4
    //   489: aload_1
    //   490: ldc 26
    //   492: invokevirtual 946	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   495: astore_1
    //   496: invokestatic 176	java/lang/System:currentTimeMillis	()J
    //   499: ldc2_w 708
    //   502: ldiv
    //   503: invokestatic 713	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   506: astore 5
    //   508: aload_0
    //   509: getfield 191	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:o	Ljava/lang/String;
    //   512: invokestatic 118	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   515: ifne -486 -> 29
    //   518: new 575	org/json/JSONObject
    //   521: dup
    //   522: invokespecial 576	org/json/JSONObject:<init>	()V
    //   525: astore 6
    //   527: aload 6
    //   529: ldc_w 918
    //   532: aload 5
    //   534: invokevirtual 609	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   537: pop
    //   538: aload_0
    //   539: aload_0
    //   540: getfield 191	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:o	Ljava/lang/String;
    //   543: iconst_1
    //   544: anewarray 347	java/lang/String
    //   547: dup
    //   548: iconst_0
    //   549: aload 6
    //   551: invokevirtual 614	org/json/JSONObject:toString	()Ljava/lang/String;
    //   554: aastore
    //   555: invokespecial 96	com/tencent/mobileqq/webview/swift/WebViewPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   558: new 575	org/json/JSONObject
    //   561: dup
    //   562: invokespecial 576	org/json/JSONObject:<init>	()V
    //   565: astore 6
    //   567: aload 6
    //   569: ldc 23
    //   571: aload 4
    //   573: invokevirtual 609	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   576: pop
    //   577: aload_1
    //   578: invokestatic 118	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   581: ifne +40 -> 621
    //   584: aload 6
    //   586: ldc 26
    //   588: aload_1
    //   589: invokevirtual 609	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   592: pop
    //   593: aload_0
    //   594: invokevirtual 568	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:a	()Landroid/content/SharedPreferences;
    //   597: invokeinterface 613 1 0
    //   602: aload 5
    //   604: aload 6
    //   606: invokevirtual 614	org/json/JSONObject:toString	()Ljava/lang/String;
    //   609: invokeinterface 620 3 0
    //   614: invokeinterface 623 1 0
    //   619: pop
    //   620: return
    //   621: ldc 11
    //   623: iconst_1
    //   624: ldc_w 948
    //   627: invokestatic 198	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   630: goto -37 -> 593
    //   633: astore_1
    //   634: goto -245 -> 389
    //   637: astore 5
    //   639: goto -545 -> 94
    //   642: astore_1
    //   643: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	644	0	this	HealthBusinessPlugin
    //   0	644	1	paramIntent	Intent
    //   0	644	2	paramByte	byte
    //   0	644	3	paramInt	int
    //   79	493	4	localObject1	Object
    //   216	387	5	localObject2	Object
    //   637	1	5	localException	Exception
    //   259	346	6	localObject3	Object
    //   271	68	7	localSharedPreferences	SharedPreferences
    // Exception table:
    //   from	to	target	type
    //   452	464	467	java/lang/Exception
    //   287	303	633	java/lang/Exception
    //   303	320	633	java/lang/Exception
    //   320	389	633	java/lang/Exception
    //   427	437	633	java/lang/Exception
    //   440	449	633	java/lang/Exception
    //   81	94	637	java/lang/Exception
    //   518	593	642	java/lang/Exception
    //   593	620	642	java/lang/Exception
    //   621	630	642	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vashealth\HealthBusinessPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */