package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.compress.CompressOperator;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQProgressDialog.Callback;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import org.json.JSONException;
import org.json.JSONObject;

public class MediaApiPlugin
  extends WebViewPlugin
  implements TroopMemberApiClient.Callback, QQProgressDialog.Callback
{
  public static final String A = "videoSizeLimit";
  public static final String B = "videoDurationLimit";
  public static final String C = "media";
  static final byte jdField_a_of_type_Byte = 1;
  static final String jdField_a_of_type_JavaLangString = UiApiPlugin.class.getSimpleName();
  static final byte jdField_b_of_type_Byte = 2;
  static final String jdField_b_of_type_JavaLangString = "getMediaParam";
  static final byte jdField_c_of_type_Byte = 3;
  static final String jdField_c_of_type_JavaLangString = "callback";
  static final byte jdField_d_of_type_Byte = 4;
  static final String jdField_d_of_type_JavaLangString = "calledFromOpenApi";
  static final byte jdField_e_of_type_Byte = 5;
  static final String jdField_e_of_type_JavaLangString = "match";
  static final String f = "data";
  public static final String g = "thumbData";
  static final String h = "mediaType";
  static final String i = "imageID";
  public static final String j = "videoID";
  public static final String k = "videoSize";
  public static final String l = "videoDuration";
  static final String m = "retCode";
  static final String n = "msg";
  static final String o = "statusCode";
  static final String p = "scaleMode";
  static final String q = "getPicture";
  static final String r = "getPictureV2";
  static final String s = "getLocalImageV2";
  static final String t = "takeRewardVideo";
  static final String u = "previewLocalVideo";
  static final String v = "getIsLTUser";
  protected static final String w = "saveImage";
  public static final String x = "maxProportion";
  public static final String y = "minProportion";
  public static final String z = "imageSizeLimit";
  TroopMemberApiClient jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient;
  public QQProgressDialog a;
  private Thread jdField_a_of_type_JavaLangThread;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public MediaApiPlugin()
  {
    this.mPluginNameSpace = "media";
  }
  
  private Context a()
  {
    for (Activity localActivity = this.mRuntime.a(); (localActivity != null) && ((localActivity instanceof BasePluginActivity)); localActivity = ((BasePluginActivity)localActivity).getOutActivity()) {}
    return localActivity;
  }
  
  public static String a(String paramString, int paramInt)
  {
    paramString = new CompressInfo(paramString, paramInt, 1035);
    CompressOperator.a(paramString);
    return paramString.e;
  }
  
  /* Error */
  public static final String a(String paramString1, String paramString2, String paramString3, com.tencent.mobileqq.troop.utils.TroopRewardUtil.OnUploadImageListener paramOnUploadImageListener)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 170	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +10 -> 14
    //   7: aload_1
    //   8: invokestatic 170	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifeq +7 -> 18
    //   14: aconst_null
    //   15: astore_1
    //   16: aload_1
    //   17: areturn
    //   18: aload_2
    //   19: iconst_0
    //   20: invokestatic 172	com/tencent/mobileqq/jsp/MediaApiPlugin:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   23: astore 5
    //   25: aload 5
    //   27: invokestatic 170	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   30: ifeq +44 -> 74
    //   33: invokestatic 178	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   36: ifeq +29 -> 65
    //   39: getstatic 120	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   42: iconst_2
    //   43: new 180	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   50: ldc -73
    //   52: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload_2
    //   56: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: invokestatic 193	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   65: aload_3
    //   66: aconst_null
    //   67: invokeinterface 198 2 0
    //   72: aconst_null
    //   73: areturn
    //   74: aconst_null
    //   75: astore_2
    //   76: invokestatic 204	java/util/UUID:randomUUID	()Ljava/util/UUID;
    //   79: invokevirtual 205	java/util/UUID:toString	()Ljava/lang/String;
    //   82: astore 6
    //   84: new 207	java/net/URL
    //   87: dup
    //   88: ldc -47
    //   90: invokespecial 211	java/net/URL:<init>	(Ljava/lang/String;)V
    //   93: invokevirtual 215	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   96: checkcast 217	java/net/HttpURLConnection
    //   99: astore 4
    //   101: aload 4
    //   103: astore_2
    //   104: aload 4
    //   106: sipush 5000
    //   109: invokevirtual 221	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   112: aload 4
    //   114: astore_2
    //   115: aload 4
    //   117: sipush 30000
    //   120: invokevirtual 224	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   123: aload 4
    //   125: astore_2
    //   126: aload 4
    //   128: iconst_1
    //   129: invokevirtual 228	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   132: aload 4
    //   134: astore_2
    //   135: aload 4
    //   137: iconst_1
    //   138: invokevirtual 231	java/net/HttpURLConnection:setDoInput	(Z)V
    //   141: aload 4
    //   143: astore_2
    //   144: aload 4
    //   146: iconst_0
    //   147: invokevirtual 234	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   150: aload 4
    //   152: astore_2
    //   153: aload 4
    //   155: ldc -20
    //   157: invokevirtual 239	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   160: aload 4
    //   162: astore_2
    //   163: aload 4
    //   165: ldc -15
    //   167: ldc -13
    //   169: invokevirtual 247	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   172: aload 4
    //   174: astore_2
    //   175: aload 4
    //   177: ldc -7
    //   179: new 180	java/lang/StringBuilder
    //   182: dup
    //   183: ldc -5
    //   185: invokespecial 252	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   188: ldc -2
    //   190: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: getstatic 259	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   196: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: ldc -2
    //   201: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: getstatic 264	android/os/Build:DEVICE	Ljava/lang/String;
    //   207: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: ldc -2
    //   212: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: getstatic 267	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   218: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: ldc -2
    //   223: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: ldc_w 269
    //   229: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   235: invokevirtual 247	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   238: aload 4
    //   240: astore_2
    //   241: aload 4
    //   243: ldc_w 271
    //   246: new 180	java/lang/StringBuilder
    //   249: dup
    //   250: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   253: ldc_w 273
    //   256: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: aload 6
    //   261: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   267: invokevirtual 247	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   270: aload 4
    //   272: astore_2
    //   273: aload 4
    //   275: ldc_w 275
    //   278: new 180	java/lang/StringBuilder
    //   281: dup
    //   282: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   285: ldc_w 277
    //   288: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: aload_0
    //   292: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: ldc_w 279
    //   298: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: aload_1
    //   302: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   308: invokevirtual 247	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   311: aload 4
    //   313: astore_2
    //   314: new 281	java/io/DataOutputStream
    //   317: dup
    //   318: aload 4
    //   320: invokevirtual 285	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   323: invokespecial 288	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   326: astore 7
    //   328: aload 4
    //   330: astore_2
    //   331: new 290	java/io/File
    //   334: dup
    //   335: aload 5
    //   337: invokespecial 291	java/io/File:<init>	(Ljava/lang/String;)V
    //   340: astore 8
    //   342: aload 4
    //   344: astore_2
    //   345: aload 8
    //   347: invokevirtual 294	java/io/File:getName	()Ljava/lang/String;
    //   350: astore 9
    //   352: aconst_null
    //   353: astore_0
    //   354: aload 4
    //   356: astore_2
    //   357: aload 9
    //   359: ldc_w 296
    //   362: invokevirtual 302	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   365: ifeq +280 -> 645
    //   368: ldc_w 304
    //   371: astore_0
    //   372: aload_0
    //   373: ifnull +792 -> 1165
    //   376: aload_0
    //   377: astore 5
    //   379: aload 4
    //   381: astore_2
    //   382: aload_0
    //   383: ldc_w 306
    //   386: invokevirtual 310	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   389: ifeq +6 -> 395
    //   392: goto +773 -> 1165
    //   395: aload 4
    //   397: astore_2
    //   398: new 312	java/lang/StringBuffer
    //   401: dup
    //   402: invokespecial 313	java/lang/StringBuffer:<init>	()V
    //   405: astore_0
    //   406: aload 4
    //   408: astore_2
    //   409: aload_0
    //   410: ldc_w 315
    //   413: invokevirtual 318	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   416: ldc_w 320
    //   419: invokevirtual 318	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   422: aload 6
    //   424: invokevirtual 318	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   427: ldc_w 315
    //   430: invokevirtual 318	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   433: pop
    //   434: aload 4
    //   436: astore_2
    //   437: aload_0
    //   438: new 180	java/lang/StringBuilder
    //   441: dup
    //   442: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   445: ldc_w 322
    //   448: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: aload 9
    //   453: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: ldc_w 324
    //   459: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   465: invokevirtual 318	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   468: pop
    //   469: aload 4
    //   471: astore_2
    //   472: aload_0
    //   473: new 180	java/lang/StringBuilder
    //   476: dup
    //   477: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   480: ldc_w 326
    //   483: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: aload 5
    //   488: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: ldc_w 328
    //   494: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   500: invokevirtual 318	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   503: pop
    //   504: aload 4
    //   506: astore_2
    //   507: aload 7
    //   509: aload_0
    //   510: invokevirtual 329	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   513: invokevirtual 333	java/lang/String:getBytes	()[B
    //   516: invokevirtual 339	java/io/OutputStream:write	([B)V
    //   519: aload 4
    //   521: astore_2
    //   522: new 341	java/io/FileInputStream
    //   525: dup
    //   526: aload 8
    //   528: invokespecial 344	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   531: astore 5
    //   533: aload 4
    //   535: astore_2
    //   536: aload 8
    //   538: invokevirtual 348	java/io/File:length	()J
    //   541: lstore 13
    //   543: aload 4
    //   545: astore_2
    //   546: aload 5
    //   548: invokevirtual 352	java/io/FileInputStream:available	()I
    //   551: ldc_w 353
    //   554: invokestatic 359	java/lang/Math:min	(II)I
    //   557: istore 10
    //   559: iconst_0
    //   560: istore 12
    //   562: aload 4
    //   564: astore_2
    //   565: iload 10
    //   567: newarray <illegal type>
    //   569: astore_0
    //   570: aload 5
    //   572: aload_0
    //   573: iconst_0
    //   574: iload 10
    //   576: invokevirtual 363	java/io/FileInputStream:read	([BII)I
    //   579: istore 11
    //   581: iload 11
    //   583: ifle +135 -> 718
    //   586: aload 7
    //   588: aload_0
    //   589: iconst_0
    //   590: iload 10
    //   592: invokevirtual 366	java/io/OutputStream:write	([BII)V
    //   595: iload 12
    //   597: iload 10
    //   599: iadd
    //   600: istore 12
    //   602: aload_3
    //   603: iload 12
    //   605: bipush 100
    //   607: imul
    //   608: i2l
    //   609: lload 13
    //   611: ldiv
    //   612: l2i
    //   613: invokeinterface 368 2 0
    //   618: aload 5
    //   620: invokevirtual 352	java/io/FileInputStream:available	()I
    //   623: ldc_w 353
    //   626: invokestatic 359	java/lang/Math:min	(II)I
    //   629: istore 10
    //   631: aload 5
    //   633: aload_0
    //   634: iconst_0
    //   635: iload 10
    //   637: invokevirtual 363	java/io/FileInputStream:read	([BII)I
    //   640: istore 11
    //   642: goto -61 -> 581
    //   645: aload 4
    //   647: astore_2
    //   648: aload 9
    //   650: ldc_w 370
    //   653: invokevirtual 302	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   656: ifne +517 -> 1173
    //   659: aload 4
    //   661: astore_2
    //   662: aload 9
    //   664: ldc_w 372
    //   667: invokevirtual 302	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   670: ifeq +6 -> 676
    //   673: goto +500 -> 1173
    //   676: aload 4
    //   678: astore_2
    //   679: aload 9
    //   681: ldc_w 374
    //   684: invokevirtual 302	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   687: ifeq +10 -> 697
    //   690: ldc_w 376
    //   693: astore_0
    //   694: goto -322 -> 372
    //   697: aload 4
    //   699: astore_2
    //   700: aload 9
    //   702: ldc_w 378
    //   705: invokevirtual 302	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   708: ifeq -336 -> 372
    //   711: ldc_w 380
    //   714: astore_0
    //   715: goto -343 -> 372
    //   718: aload 4
    //   720: astore_2
    //   721: aload 5
    //   723: invokevirtual 383	java/io/FileInputStream:close	()V
    //   726: aload 4
    //   728: astore_2
    //   729: aload 7
    //   731: new 180	java/lang/StringBuilder
    //   734: dup
    //   735: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   738: ldc_w 385
    //   741: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   744: aload 6
    //   746: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   749: ldc_w 315
    //   752: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   755: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   758: invokevirtual 333	java/lang/String:getBytes	()[B
    //   761: invokevirtual 339	java/io/OutputStream:write	([B)V
    //   764: aload 4
    //   766: astore_2
    //   767: aload 7
    //   769: new 180	java/lang/StringBuilder
    //   772: dup
    //   773: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   776: ldc_w 387
    //   779: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   782: aload_1
    //   783: invokestatic 392	com/tencent/mobileqq/troop/utils/TroopUtils:b	(Ljava/lang/String;)I
    //   786: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   789: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   792: invokevirtual 333	java/lang/String:getBytes	()[B
    //   795: invokevirtual 339	java/io/OutputStream:write	([B)V
    //   798: aload 4
    //   800: astore_2
    //   801: aload 7
    //   803: new 180	java/lang/StringBuilder
    //   806: dup
    //   807: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   810: ldc_w 385
    //   813: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   816: aload 6
    //   818: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   821: ldc_w 397
    //   824: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   827: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   830: invokevirtual 333	java/lang/String:getBytes	()[B
    //   833: invokevirtual 339	java/io/OutputStream:write	([B)V
    //   836: aload 4
    //   838: astore_2
    //   839: aload 7
    //   841: invokevirtual 400	java/io/OutputStream:flush	()V
    //   844: aload 4
    //   846: astore_2
    //   847: aload 7
    //   849: invokevirtual 401	java/io/OutputStream:close	()V
    //   852: aload 4
    //   854: astore_2
    //   855: new 312	java/lang/StringBuffer
    //   858: dup
    //   859: invokespecial 313	java/lang/StringBuffer:<init>	()V
    //   862: astore 5
    //   864: aload 4
    //   866: astore_2
    //   867: new 403	java/io/BufferedReader
    //   870: dup
    //   871: new 405	java/io/InputStreamReader
    //   874: dup
    //   875: aload 4
    //   877: invokevirtual 409	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   880: invokespecial 412	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   883: invokespecial 415	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   886: astore_1
    //   887: aload 4
    //   889: astore_2
    //   890: aload_1
    //   891: invokevirtual 418	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   894: astore_0
    //   895: aload_0
    //   896: ifnull +199 -> 1095
    //   899: aload 4
    //   901: astore_2
    //   902: aload 5
    //   904: aload_0
    //   905: invokevirtual 318	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   908: ldc_w 420
    //   911: invokevirtual 318	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   914: pop
    //   915: goto -28 -> 887
    //   918: astore_0
    //   919: aconst_null
    //   920: astore_0
    //   921: aload 4
    //   923: astore_1
    //   924: aload_1
    //   925: astore_2
    //   926: ldc_w 422
    //   929: iconst_2
    //   930: new 180	java/lang/StringBuilder
    //   933: dup
    //   934: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   937: ldc_w 424
    //   940: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   943: ldc -47
    //   945: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   948: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   951: invokestatic 193	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   954: aload_0
    //   955: astore_2
    //   956: aload_1
    //   957: ifnull +203 -> 1160
    //   960: aload_1
    //   961: invokevirtual 427	java/net/HttpURLConnection:disconnect	()V
    //   964: aload_0
    //   965: astore_1
    //   966: aload_3
    //   967: ifnull -951 -> 16
    //   970: aload_3
    //   971: aload_0
    //   972: invokeinterface 198 2 0
    //   977: aload_0
    //   978: areturn
    //   979: astore_0
    //   980: ldc_w 429
    //   983: iconst_2
    //   984: new 180	java/lang/StringBuilder
    //   987: dup
    //   988: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   991: ldc_w 431
    //   994: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   997: aload 8
    //   999: invokevirtual 348	java/io/File:length	()J
    //   1002: invokevirtual 434	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1005: ldc_w 436
    //   1008: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1011: aload 8
    //   1013: invokevirtual 439	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1016: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1019: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1022: invokestatic 441	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1025: aload 7
    //   1027: invokevirtual 400	java/io/OutputStream:flush	()V
    //   1030: aload 7
    //   1032: invokevirtual 401	java/io/OutputStream:close	()V
    //   1035: aload 4
    //   1037: invokevirtual 427	java/net/HttpURLConnection:disconnect	()V
    //   1040: aconst_null
    //   1041: astore_2
    //   1042: aconst_null
    //   1043: astore_0
    //   1044: aload_3
    //   1045: aconst_null
    //   1046: invokeinterface 198 2 0
    //   1051: aconst_null
    //   1052: astore_1
    //   1053: aload 5
    //   1055: invokevirtual 383	java/io/FileInputStream:close	()V
    //   1058: iconst_0
    //   1059: ifeq -1043 -> 16
    //   1062: new 443	java/lang/NullPointerException
    //   1065: dup
    //   1066: invokespecial 444	java/lang/NullPointerException:<init>	()V
    //   1069: athrow
    //   1070: astore_1
    //   1071: aload 4
    //   1073: astore_0
    //   1074: aload_0
    //   1075: astore_2
    //   1076: aload 5
    //   1078: invokevirtual 383	java/io/FileInputStream:close	()V
    //   1081: aload_0
    //   1082: astore_2
    //   1083: aload_1
    //   1084: athrow
    //   1085: astore_1
    //   1086: aconst_null
    //   1087: astore_2
    //   1088: aload_0
    //   1089: astore_1
    //   1090: aload_2
    //   1091: astore_0
    //   1092: goto -168 -> 924
    //   1095: aload 4
    //   1097: astore_2
    //   1098: aload 5
    //   1100: invokevirtual 329	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1103: astore_0
    //   1104: aload 4
    //   1106: astore_2
    //   1107: aload_1
    //   1108: invokevirtual 445	java/io/BufferedReader:close	()V
    //   1111: aload_0
    //   1112: astore_2
    //   1113: aload 4
    //   1115: ifnull +45 -> 1160
    //   1118: aload 4
    //   1120: invokevirtual 427	java/net/HttpURLConnection:disconnect	()V
    //   1123: goto -159 -> 964
    //   1126: astore_0
    //   1127: aload_2
    //   1128: ifnull +7 -> 1135
    //   1131: aload_2
    //   1132: invokevirtual 427	java/net/HttpURLConnection:disconnect	()V
    //   1135: aload_0
    //   1136: athrow
    //   1137: astore_0
    //   1138: goto -11 -> 1127
    //   1141: astore_0
    //   1142: aconst_null
    //   1143: astore_1
    //   1144: aconst_null
    //   1145: astore_0
    //   1146: goto -222 -> 924
    //   1149: astore_1
    //   1150: aload 4
    //   1152: astore_1
    //   1153: goto -229 -> 924
    //   1156: astore_1
    //   1157: goto -83 -> 1074
    //   1160: aload_2
    //   1161: astore_0
    //   1162: goto -198 -> 964
    //   1165: ldc_w 447
    //   1168: astore 5
    //   1170: goto -775 -> 395
    //   1173: ldc_w 449
    //   1176: astore_0
    //   1177: goto -805 -> 372
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1180	0	paramString1	String
    //   0	1180	1	paramString2	String
    //   0	1180	2	paramString3	String
    //   0	1180	3	paramOnUploadImageListener	com.tencent.mobileqq.troop.utils.TroopRewardUtil.OnUploadImageListener
    //   99	1052	4	localHttpURLConnection	java.net.HttpURLConnection
    //   23	1146	5	localObject	Object
    //   82	735	6	str1	String
    //   326	705	7	localDataOutputStream	java.io.DataOutputStream
    //   340	672	8	localFile	File
    //   350	351	9	str2	String
    //   557	79	10	i1	int
    //   579	62	11	i2	int
    //   560	48	12	i3	int
    //   541	69	13	l1	long
    // Exception table:
    //   from	to	target	type
    //   104	112	918	java/lang/Exception
    //   115	123	918	java/lang/Exception
    //   126	132	918	java/lang/Exception
    //   135	141	918	java/lang/Exception
    //   144	150	918	java/lang/Exception
    //   153	160	918	java/lang/Exception
    //   163	172	918	java/lang/Exception
    //   175	238	918	java/lang/Exception
    //   241	270	918	java/lang/Exception
    //   273	311	918	java/lang/Exception
    //   314	328	918	java/lang/Exception
    //   331	342	918	java/lang/Exception
    //   345	352	918	java/lang/Exception
    //   357	368	918	java/lang/Exception
    //   382	392	918	java/lang/Exception
    //   398	406	918	java/lang/Exception
    //   409	434	918	java/lang/Exception
    //   437	469	918	java/lang/Exception
    //   472	504	918	java/lang/Exception
    //   507	519	918	java/lang/Exception
    //   522	533	918	java/lang/Exception
    //   536	543	918	java/lang/Exception
    //   546	559	918	java/lang/Exception
    //   565	570	918	java/lang/Exception
    //   648	659	918	java/lang/Exception
    //   662	673	918	java/lang/Exception
    //   679	690	918	java/lang/Exception
    //   700	711	918	java/lang/Exception
    //   721	726	918	java/lang/Exception
    //   729	764	918	java/lang/Exception
    //   767	798	918	java/lang/Exception
    //   801	836	918	java/lang/Exception
    //   839	844	918	java/lang/Exception
    //   847	852	918	java/lang/Exception
    //   855	864	918	java/lang/Exception
    //   867	887	918	java/lang/Exception
    //   890	895	918	java/lang/Exception
    //   902	915	918	java/lang/Exception
    //   1098	1104	918	java/lang/Exception
    //   570	581	979	java/lang/OutOfMemoryError
    //   586	595	979	java/lang/OutOfMemoryError
    //   602	642	979	java/lang/OutOfMemoryError
    //   570	581	1070	finally
    //   586	595	1070	finally
    //   602	642	1070	finally
    //   980	1040	1070	finally
    //   1076	1081	1085	java/lang/Exception
    //   1083	1085	1085	java/lang/Exception
    //   84	101	1126	finally
    //   1053	1058	1126	finally
    //   1076	1081	1126	finally
    //   1083	1085	1126	finally
    //   104	112	1137	finally
    //   115	123	1137	finally
    //   126	132	1137	finally
    //   135	141	1137	finally
    //   144	150	1137	finally
    //   153	160	1137	finally
    //   163	172	1137	finally
    //   175	238	1137	finally
    //   241	270	1137	finally
    //   273	311	1137	finally
    //   314	328	1137	finally
    //   331	342	1137	finally
    //   345	352	1137	finally
    //   357	368	1137	finally
    //   382	392	1137	finally
    //   398	406	1137	finally
    //   409	434	1137	finally
    //   437	469	1137	finally
    //   472	504	1137	finally
    //   507	519	1137	finally
    //   522	533	1137	finally
    //   536	543	1137	finally
    //   546	559	1137	finally
    //   565	570	1137	finally
    //   648	659	1137	finally
    //   662	673	1137	finally
    //   679	690	1137	finally
    //   700	711	1137	finally
    //   721	726	1137	finally
    //   729	764	1137	finally
    //   767	798	1137	finally
    //   801	836	1137	finally
    //   839	844	1137	finally
    //   847	852	1137	finally
    //   855	864	1137	finally
    //   867	887	1137	finally
    //   890	895	1137	finally
    //   902	915	1137	finally
    //   926	954	1137	finally
    //   1098	1104	1137	finally
    //   1107	1111	1137	finally
    //   84	101	1141	java/lang/Exception
    //   1053	1058	1141	java/lang/Exception
    //   1107	1111	1149	java/lang/Exception
    //   1044	1051	1156	finally
  }
  
  /* Error */
  private String a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 290	java/io/File
    //   5: dup
    //   6: getstatic 456	com/tencent/mobileqq/app/AppConstants:bo	Ljava/lang/String;
    //   9: invokespecial 291	java/io/File:<init>	(Ljava/lang/String;)V
    //   12: astore_2
    //   13: aload_2
    //   14: invokevirtual 459	java/io/File:mkdirs	()Z
    //   17: pop
    //   18: aload_2
    //   19: invokevirtual 462	java/io/File:canWrite	()Z
    //   22: ifne +14 -> 36
    //   25: new 451	java/io/IOException
    //   28: dup
    //   29: ldc_w 464
    //   32: invokespecial 465	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   35: athrow
    //   36: new 467	android/graphics/BitmapFactory$Options
    //   39: dup
    //   40: invokespecial 468	android/graphics/BitmapFactory$Options:<init>	()V
    //   43: astore_2
    //   44: aload_2
    //   45: iconst_1
    //   46: putfield 471	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   49: aload_1
    //   50: iconst_0
    //   51: aload_1
    //   52: arraylength
    //   53: aload_2
    //   54: invokestatic 477	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   57: pop
    //   58: aload_2
    //   59: getfield 481	android/graphics/BitmapFactory$Options:outWidth	I
    //   62: ifle +10 -> 72
    //   65: aload_2
    //   66: getfield 484	android/graphics/BitmapFactory$Options:outHeight	I
    //   69: ifgt +14 -> 83
    //   72: new 486	java/lang/IllegalArgumentException
    //   75: dup
    //   76: ldc_w 488
    //   79: invokespecial 489	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   82: athrow
    //   83: ldc_w 491
    //   86: aload_2
    //   87: getfield 494	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   90: invokevirtual 310	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   93: ifeq +135 -> 228
    //   96: ldc_w 372
    //   99: astore_2
    //   100: aload_2
    //   101: ifnull +230 -> 331
    //   104: new 180	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   111: getstatic 456	com/tencent/mobileqq/app/AppConstants:bo	Ljava/lang/String;
    //   114: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: ldc_w 496
    //   120: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: invokestatic 501	java/lang/System:currentTimeMillis	()J
    //   126: invokevirtual 434	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   129: aload_2
    //   130: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: astore_3
    //   137: new 290	java/io/File
    //   140: dup
    //   141: aload_3
    //   142: invokespecial 291	java/io/File:<init>	(Ljava/lang/String;)V
    //   145: astore 4
    //   147: new 503	java/io/FileOutputStream
    //   150: dup
    //   151: aload 4
    //   153: invokespecial 504	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   156: astore_2
    //   157: aload_2
    //   158: aload_1
    //   159: invokevirtual 505	java/io/FileOutputStream:write	([B)V
    //   162: aload_2
    //   163: ifnull +7 -> 170
    //   166: aload_2
    //   167: invokevirtual 506	java/io/FileOutputStream:close	()V
    //   170: iconst_1
    //   171: istore 6
    //   173: aload_3
    //   174: astore_1
    //   175: iload 6
    //   177: ifeq +322 -> 499
    //   180: new 508	android/content/Intent
    //   183: dup
    //   184: ldc_w 510
    //   187: invokespecial 511	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   190: astore_2
    //   191: aload_2
    //   192: new 180	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   199: ldc_w 513
    //   202: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: aload_1
    //   206: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: invokestatic 519	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   215: invokevirtual 523	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
    //   218: pop
    //   219: invokestatic 529	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   222: aload_2
    //   223: invokevirtual 535	com/tencent/qphone/base/util/BaseApplication:sendBroadcast	(Landroid/content/Intent;)V
    //   226: aload_1
    //   227: areturn
    //   228: ldc_w 376
    //   231: aload_2
    //   232: getfield 494	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   235: invokevirtual 310	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   238: ifeq +10 -> 248
    //   241: ldc_w 374
    //   244: astore_2
    //   245: goto -145 -> 100
    //   248: ldc_w 304
    //   251: aload_2
    //   252: getfield 494	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   255: invokevirtual 310	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   258: ifeq +10 -> 268
    //   261: ldc_w 296
    //   264: astore_2
    //   265: goto -165 -> 100
    //   268: ldc_w 380
    //   271: aload_2
    //   272: getfield 494	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   275: invokevirtual 310	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   278: ifeq +261 -> 539
    //   281: ldc_w 378
    //   284: astore_2
    //   285: goto -185 -> 100
    //   288: astore_1
    //   289: aconst_null
    //   290: astore_2
    //   291: aload_2
    //   292: ifnull +7 -> 299
    //   295: aload_2
    //   296: invokevirtual 506	java/io/FileOutputStream:close	()V
    //   299: aload 4
    //   301: invokevirtual 538	java/io/File:exists	()Z
    //   304: ifeq +9 -> 313
    //   307: aload 4
    //   309: invokevirtual 541	java/io/File:delete	()Z
    //   312: pop
    //   313: invokestatic 178	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   316: ifeq +13 -> 329
    //   319: getstatic 120	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   322: iconst_2
    //   323: ldc_w 543
    //   326: invokestatic 193	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   329: aload_1
    //   330: athrow
    //   331: new 180	java/lang/StringBuilder
    //   334: dup
    //   335: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   338: getstatic 456	com/tencent/mobileqq/app/AppConstants:bo	Ljava/lang/String;
    //   341: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: ldc_w 496
    //   347: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: invokestatic 501	java/lang/System:currentTimeMillis	()J
    //   353: invokevirtual 434	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   356: ldc_w 372
    //   359: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   365: astore_2
    //   366: new 290	java/io/File
    //   369: dup
    //   370: aload_2
    //   371: invokespecial 291	java/io/File:<init>	(Ljava/lang/String;)V
    //   374: astore 5
    //   376: new 503	java/io/FileOutputStream
    //   379: dup
    //   380: aload 5
    //   382: invokespecial 504	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   385: astore 4
    //   387: aload_1
    //   388: iconst_0
    //   389: aload_1
    //   390: arraylength
    //   391: invokestatic 546	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   394: getstatic 552	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   397: bipush 75
    //   399: aload 4
    //   401: invokevirtual 558	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   404: istore 6
    //   406: aload 4
    //   408: ifnull +8 -> 416
    //   411: aload 4
    //   413: invokevirtual 506	java/io/FileOutputStream:close	()V
    //   416: iload 6
    //   418: ifne +116 -> 534
    //   421: aload 5
    //   423: invokevirtual 538	java/io/File:exists	()Z
    //   426: ifeq +9 -> 435
    //   429: aload 5
    //   431: invokevirtual 541	java/io/File:delete	()Z
    //   434: pop
    //   435: invokestatic 178	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   438: ifeq +96 -> 534
    //   441: getstatic 120	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   444: iconst_2
    //   445: ldc_w 560
    //   448: invokestatic 193	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   451: aload_2
    //   452: astore_1
    //   453: goto -278 -> 175
    //   456: astore_1
    //   457: aload_3
    //   458: astore_2
    //   459: aload_2
    //   460: ifnull +7 -> 467
    //   463: aload_2
    //   464: invokevirtual 506	java/io/FileOutputStream:close	()V
    //   467: aload 5
    //   469: invokevirtual 538	java/io/File:exists	()Z
    //   472: ifeq +9 -> 481
    //   475: aload 5
    //   477: invokevirtual 541	java/io/File:delete	()Z
    //   480: pop
    //   481: invokestatic 178	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   484: ifeq +13 -> 497
    //   487: getstatic 120	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   490: iconst_2
    //   491: ldc_w 560
    //   494: invokestatic 193	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   497: aload_1
    //   498: athrow
    //   499: new 451	java/io/IOException
    //   502: dup
    //   503: invokespecial 561	java/io/IOException:<init>	()V
    //   506: athrow
    //   507: astore_1
    //   508: goto -338 -> 170
    //   511: astore_2
    //   512: goto -213 -> 299
    //   515: astore_1
    //   516: goto -100 -> 416
    //   519: astore_2
    //   520: goto -53 -> 467
    //   523: astore_1
    //   524: aload 4
    //   526: astore_2
    //   527: goto -68 -> 459
    //   530: astore_1
    //   531: goto -240 -> 291
    //   534: aload_2
    //   535: astore_1
    //   536: goto -361 -> 175
    //   539: aconst_null
    //   540: astore_2
    //   541: goto -441 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	544	0	this	MediaApiPlugin
    //   0	544	1	paramArrayOfByte	byte[]
    //   12	452	2	localObject1	Object
    //   511	1	2	localIOException1	IOException
    //   519	1	2	localIOException2	IOException
    //   526	15	2	localObject2	Object
    //   1	457	3	str	String
    //   145	380	4	localObject3	Object
    //   374	102	5	localFile	File
    //   171	246	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   147	157	288	finally
    //   376	387	456	finally
    //   166	170	507	java/io/IOException
    //   295	299	511	java/io/IOException
    //   411	416	515	java/io/IOException
    //   463	467	519	java/io/IOException
    //   387	406	523	finally
    //   157	162	530	finally
  }
  
  private JSONObject a(String paramString)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(1024);
    Object localObject = ShortVideoUtils.a(null, paramString);
    StringBuilder localStringBuilder = new StringBuilder("data:image/jpeg;base64,");
    if (localObject != null)
    {
      ((Bitmap)localObject).compress(Bitmap.CompressFormat.JPEG, 80, localByteArrayOutputStream);
      ((Bitmap)localObject).recycle();
    }
    localStringBuilder.append(Base64Util.encodeToString(localByteArrayOutputStream.toByteArray(), 2));
    localObject = new JSONObject();
    for (;;)
    {
      try
      {
        ((JSONObject)localObject).put("thumbData", localStringBuilder);
        ((JSONObject)localObject).put("videoID", paramString);
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        if (localByteArrayOutputStream == null) {
          continue;
        }
        try
        {
          localByteArrayOutputStream.flush();
          localByteArrayOutputStream.close();
          return (JSONObject)localObject;
        }
        catch (IOException paramString)
        {
          paramString.printStackTrace();
          return (JSONObject)localObject;
        }
      }
      finally
      {
        if (localByteArrayOutputStream == null) {
          break label147;
        }
      }
      try
      {
        localByteArrayOutputStream.flush();
        localByteArrayOutputStream.close();
        return (JSONObject)localObject;
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
        return (JSONObject)localObject;
      }
    }
    try
    {
      localByteArrayOutputStream.flush();
      localByteArrayOutputStream.close();
      label147:
      throw paramString;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
  }
  
  public static JSONObject a(String paramString, int paramInt)
  {
    long l1 = System.currentTimeMillis();
    JSONObject localJSONObject = new JSONObject();
    Object localObject1 = new File(paramString);
    if (((File)localObject1).length() < 3L) {
      throw new IOException();
    }
    Object localObject2 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject2);
    int i1 = ((BitmapFactory.Options)localObject2).outWidth;
    int i2 = ((BitmapFactory.Options)localObject2).outHeight;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "packImageObjectV2 realWidth: " + i1 + ", realHeight: " + i2 + ", realSize: " + ((File)localObject1).length());
    }
    if ((i1 < 0) || (i2 < 0)) {
      throw new IOException();
    }
    Object localObject3 = a(paramString, paramInt);
    localObject1 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject1).inJustDecodeBounds = false;
    localObject2 = BitmapFactory.decodeFile((String)localObject3, (BitmapFactory.Options)localObject1);
    if (QLog.isColorLevel())
    {
      localObject3 = new File((String)localObject3);
      QLog.d(jdField_a_of_type_JavaLangString, 2, "packImageObjectV2 curWidth: " + ((BitmapFactory.Options)localObject1).outWidth + ", curHeight: " + ((BitmapFactory.Options)localObject1).outHeight + ", realSize: " + ((File)localObject3).length());
    }
    localObject3 = new ByteArrayOutputStream(1024);
    localObject1 = ((BitmapFactory.Options)localObject1).outMimeType;
    if (("image/png".equalsIgnoreCase((String)localObject1)) || ("image/gif".equals(localObject1)) || ("image/bmp".equals(localObject1)))
    {
      localObject1 = new StringBuilder("data:image/png;base64,");
      ((Bitmap)localObject2).compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject3);
    }
    for (;;)
    {
      ((Bitmap)localObject2).recycle();
      ((StringBuilder)localObject1).append(Base64Util.encodeToString(((ByteArrayOutputStream)localObject3).toByteArray(), 2));
      localJSONObject.put("match", 0);
      localJSONObject.put("data", localObject1);
      localJSONObject.put("imageID", paramString);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "packImageObjectV2 time: " + (System.currentTimeMillis() - l1));
      }
      return localJSONObject;
      localObject1 = new StringBuilder("data:image/jpeg;base64,");
      ((Bitmap)localObject2).compress(Bitmap.CompressFormat.JPEG, 80, (OutputStream)localObject3);
    }
  }
  
  /* Error */
  public static JSONObject a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    // Byte code:
    //   0: new 589	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 590	org/json/JSONObject:<init>	()V
    //   7: astore 8
    //   9: new 290	java/io/File
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 291	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore 7
    //   19: aload 7
    //   21: invokevirtual 348	java/io/File:length	()J
    //   24: ldc2_w 602
    //   27: lcmp
    //   28: ifge +11 -> 39
    //   31: new 451	java/io/IOException
    //   34: dup
    //   35: invokespecial 561	java/io/IOException:<init>	()V
    //   38: athrow
    //   39: new 467	android/graphics/BitmapFactory$Options
    //   42: dup
    //   43: invokespecial 468	android/graphics/BitmapFactory$Options:<init>	()V
    //   46: astore 6
    //   48: aload 6
    //   50: iconst_1
    //   51: putfield 471	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   54: aload_0
    //   55: aload 6
    //   57: invokestatic 607	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   60: pop
    //   61: aload 6
    //   63: getfield 481	android/graphics/BitmapFactory$Options:outWidth	I
    //   66: istore 11
    //   68: aload 6
    //   70: getfield 484	android/graphics/BitmapFactory$Options:outHeight	I
    //   73: istore 12
    //   75: iload 11
    //   77: iflt +8 -> 85
    //   80: iload 12
    //   82: ifge +11 -> 93
    //   85: new 451	java/io/IOException
    //   88: dup
    //   89: invokespecial 561	java/io/IOException:<init>	()V
    //   92: athrow
    //   93: iload 11
    //   95: iload_1
    //   96: if_icmplt +9 -> 105
    //   99: iload 12
    //   101: iload_2
    //   102: if_icmpge +15 -> 117
    //   105: aload 8
    //   107: ldc 36
    //   109: iconst_1
    //   110: invokevirtual 627	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   113: pop
    //   114: aload 8
    //   116: areturn
    //   117: iload 11
    //   119: iload_3
    //   120: if_icmpgt +337 -> 457
    //   123: iload 12
    //   125: iload 4
    //   127: if_icmpgt +330 -> 457
    //   130: new 341	java/io/FileInputStream
    //   133: dup
    //   134: aload 7
    //   136: invokespecial 344	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   139: astore 7
    //   141: aload 7
    //   143: invokevirtual 634	java/io/InputStream:read	()I
    //   146: istore_1
    //   147: aload 7
    //   149: invokevirtual 634	java/io/InputStream:read	()I
    //   152: istore_2
    //   153: aload 7
    //   155: invokevirtual 634	java/io/InputStream:read	()I
    //   158: istore_3
    //   159: iload_1
    //   160: sipush 255
    //   163: if_icmpne +104 -> 267
    //   166: iload_2
    //   167: sipush 216
    //   170: if_icmpne +97 -> 267
    //   173: new 180	java/lang/StringBuilder
    //   176: dup
    //   177: ldc_w 575
    //   180: invokespecial 252	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   183: astore 6
    //   185: aload 6
    //   187: iconst_3
    //   188: newarray <illegal type>
    //   190: dup
    //   191: iconst_0
    //   192: iload_1
    //   193: i2b
    //   194: bastore
    //   195: dup
    //   196: iconst_1
    //   197: iload_2
    //   198: i2b
    //   199: bastore
    //   200: dup
    //   201: iconst_2
    //   202: iload_3
    //   203: i2b
    //   204: bastore
    //   205: iconst_2
    //   206: invokestatic 587	com/tencent/mobileqq/utils/Base64Util:encodeToString	([BI)Ljava/lang/String;
    //   209: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: pop
    //   213: sipush 30720
    //   216: newarray <illegal type>
    //   218: astore 9
    //   220: aload 7
    //   222: aload 9
    //   224: invokevirtual 637	java/io/InputStream:read	([B)I
    //   227: istore_1
    //   228: iload_1
    //   229: iconst_m1
    //   230: if_icmpeq +186 -> 416
    //   233: invokestatic 643	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   236: invokevirtual 646	java/lang/Thread:isInterrupted	()Z
    //   239: ifeq +125 -> 364
    //   242: new 648	java/lang/InterruptedException
    //   245: dup
    //   246: invokespecial 649	java/lang/InterruptedException:<init>	()V
    //   249: athrow
    //   250: astore_0
    //   251: aload 7
    //   253: astore 6
    //   255: aload 6
    //   257: ifnull +8 -> 265
    //   260: aload 6
    //   262: invokevirtual 650	java/io/InputStream:close	()V
    //   265: aload_0
    //   266: athrow
    //   267: iload_1
    //   268: bipush 66
    //   270: if_icmpne +24 -> 294
    //   273: iload_2
    //   274: bipush 77
    //   276: if_icmpne +18 -> 294
    //   279: new 180	java/lang/StringBuilder
    //   282: dup
    //   283: ldc_w 652
    //   286: invokespecial 252	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   289: astore 6
    //   291: goto -106 -> 185
    //   294: iload_1
    //   295: sipush 137
    //   298: if_icmpne +24 -> 322
    //   301: iload_2
    //   302: bipush 80
    //   304: if_icmpne +18 -> 322
    //   307: new 180	java/lang/StringBuilder
    //   310: dup
    //   311: ldc_w 622
    //   314: invokespecial 252	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   317: astore 6
    //   319: goto -134 -> 185
    //   322: iload_1
    //   323: bipush 71
    //   325: if_icmpne +24 -> 349
    //   328: iload_2
    //   329: bipush 73
    //   331: if_icmpne +18 -> 349
    //   334: new 180	java/lang/StringBuilder
    //   337: dup
    //   338: ldc_w 654
    //   341: invokespecial 252	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   344: astore 6
    //   346: goto -161 -> 185
    //   349: new 180	java/lang/StringBuilder
    //   352: dup
    //   353: ldc_w 656
    //   356: invokespecial 252	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   359: astore 6
    //   361: goto -176 -> 185
    //   364: iload_1
    //   365: sipush 30720
    //   368: if_icmpge +33 -> 401
    //   371: iload_1
    //   372: newarray <illegal type>
    //   374: astore 10
    //   376: aload 9
    //   378: iconst_0
    //   379: aload 10
    //   381: iconst_0
    //   382: iload_1
    //   383: invokestatic 660	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   386: aload 6
    //   388: aload 10
    //   390: iconst_2
    //   391: invokestatic 587	com/tencent/mobileqq/utils/Base64Util:encodeToString	([BI)Ljava/lang/String;
    //   394: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: pop
    //   398: goto -178 -> 220
    //   401: aload 6
    //   403: aload 9
    //   405: iconst_2
    //   406: invokestatic 587	com/tencent/mobileqq/utils/Base64Util:encodeToString	([BI)Ljava/lang/String;
    //   409: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: pop
    //   413: goto -193 -> 220
    //   416: aload 8
    //   418: ldc 36
    //   420: iconst_0
    //   421: invokevirtual 627	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   424: pop
    //   425: aload 8
    //   427: ldc 39
    //   429: aload 6
    //   431: invokevirtual 594	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   434: pop
    //   435: aload 8
    //   437: ldc 48
    //   439: aload_0
    //   440: invokevirtual 594	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   443: pop
    //   444: aload 7
    //   446: ifnull -332 -> 114
    //   449: aload 7
    //   451: invokevirtual 650	java/io/InputStream:close	()V
    //   454: aload 8
    //   456: areturn
    //   457: iload 11
    //   459: iload_3
    //   460: idiv
    //   461: iload 12
    //   463: iload 4
    //   465: idiv
    //   466: invokestatic 663	java/lang/Math:max	(II)I
    //   469: istore_1
    //   470: aload 6
    //   472: iconst_0
    //   473: putfield 471	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   476: iload_1
    //   477: iload_1
    //   478: iconst_1
    //   479: iushr
    //   480: ior
    //   481: istore_1
    //   482: iload_1
    //   483: iload_1
    //   484: iconst_2
    //   485: iushr
    //   486: ior
    //   487: istore_1
    //   488: iload_1
    //   489: iload_1
    //   490: iconst_4
    //   491: iushr
    //   492: ior
    //   493: istore_1
    //   494: iload_1
    //   495: iload_1
    //   496: bipush 8
    //   498: iushr
    //   499: ior
    //   500: istore_1
    //   501: aload 6
    //   503: iload_1
    //   504: iload_1
    //   505: bipush 16
    //   507: iushr
    //   508: ior
    //   509: iconst_1
    //   510: iadd
    //   511: iconst_1
    //   512: iushr
    //   513: putfield 666	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   516: aload_0
    //   517: aload 6
    //   519: invokestatic 607	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   522: astore 9
    //   524: iload 11
    //   526: iload 4
    //   528: imul
    //   529: iload 12
    //   531: iload_3
    //   532: imul
    //   533: if_icmple +242 -> 775
    //   536: iload_3
    //   537: i2f
    //   538: aload 9
    //   540: invokevirtual 669	android/graphics/Bitmap:getWidth	()I
    //   543: i2f
    //   544: fdiv
    //   545: fstore 5
    //   547: new 671	android/graphics/Matrix
    //   550: dup
    //   551: invokespecial 672	android/graphics/Matrix:<init>	()V
    //   554: astore 7
    //   556: aload_0
    //   557: invokestatic 677	com/tencent/image/JpegExifReader:readOrientation	(Ljava/lang/String;)I
    //   560: tableswitch	default:+44->604, 2:+230->790, 3:+243->803, 4:+264->824, 5:+277->837, 6:+299->859, 7:+320->880, 8:+342->902
    //   604: aload 7
    //   606: fload 5
    //   608: fload 5
    //   610: invokevirtual 681	android/graphics/Matrix:setScale	(FF)V
    //   613: aload 9
    //   615: iconst_0
    //   616: iconst_0
    //   617: aload 9
    //   619: invokevirtual 669	android/graphics/Bitmap:getWidth	()I
    //   622: aload 9
    //   624: invokevirtual 684	android/graphics/Bitmap:getHeight	()I
    //   627: aload 7
    //   629: iconst_1
    //   630: invokestatic 688	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   633: astore 7
    //   635: aload 9
    //   637: aload 7
    //   639: if_acmpeq +8 -> 647
    //   642: aload 9
    //   644: invokevirtual 578	android/graphics/Bitmap:recycle	()V
    //   647: new 566	java/io/ByteArrayOutputStream
    //   650: dup
    //   651: sipush 1024
    //   654: invokespecial 568	java/io/ByteArrayOutputStream:<init>	(I)V
    //   657: astore 9
    //   659: aload 6
    //   661: getfield 494	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   664: astore 6
    //   666: ldc_w 304
    //   669: aload 6
    //   671: invokevirtual 620	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   674: ifne +25 -> 699
    //   677: ldc_w 380
    //   680: aload 6
    //   682: invokevirtual 310	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   685: ifne +14 -> 699
    //   688: ldc_w 376
    //   691: aload 6
    //   693: invokevirtual 310	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   696: ifeq +227 -> 923
    //   699: new 180	java/lang/StringBuilder
    //   702: dup
    //   703: ldc_w 622
    //   706: invokespecial 252	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   709: astore 6
    //   711: aload 7
    //   713: getstatic 625	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   716: bipush 100
    //   718: aload 9
    //   720: invokevirtual 558	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   723: pop
    //   724: aload 7
    //   726: invokevirtual 578	android/graphics/Bitmap:recycle	()V
    //   729: aload 6
    //   731: aload 9
    //   733: invokevirtual 581	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   736: iconst_2
    //   737: invokestatic 587	com/tencent/mobileqq/utils/Base64Util:encodeToString	([BI)Ljava/lang/String;
    //   740: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   743: pop
    //   744: aload 8
    //   746: ldc 36
    //   748: iconst_0
    //   749: invokevirtual 627	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   752: pop
    //   753: aload 8
    //   755: ldc 39
    //   757: aload 6
    //   759: invokevirtual 594	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   762: pop
    //   763: aload 8
    //   765: ldc 48
    //   767: aload_0
    //   768: invokevirtual 594	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   771: pop
    //   772: aload 8
    //   774: areturn
    //   775: iload 4
    //   777: i2f
    //   778: aload 9
    //   780: invokevirtual 684	android/graphics/Bitmap:getHeight	()I
    //   783: i2f
    //   784: fdiv
    //   785: fstore 5
    //   787: goto -240 -> 547
    //   790: aload 7
    //   792: fload 5
    //   794: fneg
    //   795: fload 5
    //   797: invokevirtual 681	android/graphics/Matrix:setScale	(FF)V
    //   800: goto -187 -> 613
    //   803: aload 7
    //   805: fload 5
    //   807: fload 5
    //   809: invokevirtual 681	android/graphics/Matrix:setScale	(FF)V
    //   812: aload 7
    //   814: ldc_w 689
    //   817: invokevirtual 693	android/graphics/Matrix:postRotate	(F)Z
    //   820: pop
    //   821: goto -208 -> 613
    //   824: aload 7
    //   826: fload 5
    //   828: fload 5
    //   830: fneg
    //   831: invokevirtual 681	android/graphics/Matrix:setScale	(FF)V
    //   834: goto -221 -> 613
    //   837: aload 7
    //   839: fload 5
    //   841: fload 5
    //   843: fneg
    //   844: invokevirtual 681	android/graphics/Matrix:setScale	(FF)V
    //   847: aload 7
    //   849: ldc_w 694
    //   852: invokevirtual 693	android/graphics/Matrix:postRotate	(F)Z
    //   855: pop
    //   856: goto -243 -> 613
    //   859: aload 7
    //   861: fload 5
    //   863: fload 5
    //   865: invokevirtual 681	android/graphics/Matrix:setScale	(FF)V
    //   868: aload 7
    //   870: ldc_w 694
    //   873: invokevirtual 693	android/graphics/Matrix:postRotate	(F)Z
    //   876: pop
    //   877: goto -264 -> 613
    //   880: aload 7
    //   882: fload 5
    //   884: fneg
    //   885: fload 5
    //   887: invokevirtual 681	android/graphics/Matrix:setScale	(FF)V
    //   890: aload 7
    //   892: ldc_w 694
    //   895: invokevirtual 693	android/graphics/Matrix:postRotate	(F)Z
    //   898: pop
    //   899: goto -286 -> 613
    //   902: aload 7
    //   904: fload 5
    //   906: fload 5
    //   908: invokevirtual 681	android/graphics/Matrix:setScale	(FF)V
    //   911: aload 7
    //   913: ldc_w 695
    //   916: invokevirtual 693	android/graphics/Matrix:postRotate	(F)Z
    //   919: pop
    //   920: goto -307 -> 613
    //   923: new 180	java/lang/StringBuilder
    //   926: dup
    //   927: ldc_w 575
    //   930: invokespecial 252	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   933: astore 6
    //   935: aload 7
    //   937: getstatic 552	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   940: bipush 80
    //   942: aload 9
    //   944: invokevirtual 558	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   947: pop
    //   948: goto -224 -> 724
    //   951: astore_0
    //   952: aconst_null
    //   953: astore 6
    //   955: goto -700 -> 255
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	958	0	paramString	String
    //   0	958	1	paramInt1	int
    //   0	958	2	paramInt2	int
    //   0	958	3	paramInt3	int
    //   0	958	4	paramInt4	int
    //   545	362	5	f1	float
    //   46	908	6	localObject1	Object
    //   17	919	7	localObject2	Object
    //   7	766	8	localJSONObject	JSONObject
    //   218	725	9	localObject3	Object
    //   374	15	10	arrayOfByte	byte[]
    //   66	463	11	i1	int
    //   73	460	12	i2	int
    // Exception table:
    //   from	to	target	type
    //   141	159	250	finally
    //   173	185	250	finally
    //   185	220	250	finally
    //   220	228	250	finally
    //   233	250	250	finally
    //   279	291	250	finally
    //   307	319	250	finally
    //   334	346	250	finally
    //   349	361	250	finally
    //   371	398	250	finally
    //   401	413	250	finally
    //   416	444	250	finally
    //   130	141	951	finally
  }
  
  public static void a(Context paramContext, String paramString, long paramLong1, long paramLong2)
  {
    Intent localIntent = new Intent(paramContext, ShortVideoPreviewActivity.class);
    localIntent.putExtra("file_send_path", paramString);
    localIntent.putExtra("file_send_size", paramLong1);
    localIntent.putExtra("file_send_duration", paramLong2);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramContext.getClass().getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("preview_only", true);
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    paramContext.startActivity(localIntent);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaLangThread != null) {
      this.jdField_a_of_type_JavaLangThread.interrupt();
    }
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle == null) {}
  }
  
  /* Error */
  protected boolean handleJsRequest(com.tencent.mobileqq.webview.swift.JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    // Byte code:
    //   0: ldc 18
    //   2: aload_3
    //   3: invokevirtual 310	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6: ifeq +2483 -> 2489
    //   9: aload_1
    //   10: ifnull +2485 -> 2495
    //   13: aload_1
    //   14: getfield 760	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	Z
    //   17: ifeq +2478 -> 2495
    //   20: iconst_1
    //   21: istore 17
    //   23: aload_0
    //   24: aload 4
    //   26: aload_1
    //   27: invokevirtual 764	com/tencent/mobileqq/jsp/MediaApiPlugin:addOpenApiListenerIfNeeded	(Ljava/lang/String;Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;)V
    //   30: ldc 72
    //   32: aload 4
    //   34: invokevirtual 310	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   37: ifne +13 -> 50
    //   40: ldc 75
    //   42: aload 4
    //   44: invokevirtual 310	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   47: ifeq +982 -> 1029
    //   50: aload 5
    //   52: arraylength
    //   53: iconst_1
    //   54: if_icmpne +975 -> 1029
    //   57: new 589	org/json/JSONObject
    //   60: dup
    //   61: aload 5
    //   63: iconst_0
    //   64: aaload
    //   65: invokespecial 765	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   68: astore_2
    //   69: aload_2
    //   70: ldc_w 767
    //   73: aload 4
    //   75: invokevirtual 594	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   78: pop
    //   79: aload_2
    //   80: ldc 28
    //   82: invokevirtual 771	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   85: astore_3
    //   86: aload_3
    //   87: invokestatic 170	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   90: ifeq +10 -> 100
    //   93: iload 17
    //   95: ifne +5 -> 100
    //   98: iconst_1
    //   99: ireturn
    //   100: aload_2
    //   101: ldc_w 773
    //   104: iconst_0
    //   105: invokevirtual 777	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   108: istore 11
    //   110: invokestatic 529	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   113: astore_1
    //   114: iload 11
    //   116: ifne +618 -> 734
    //   119: aload_2
    //   120: ldc 45
    //   122: iconst_0
    //   123: invokevirtual 777	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   126: istore 11
    //   128: aload_2
    //   129: ldc 93
    //   131: ldc2_w 778
    //   134: invokevirtual 783	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   137: dstore 6
    //   139: aload_2
    //   140: ldc 96
    //   142: ldc2_w 784
    //   145: invokevirtual 783	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   148: dstore 8
    //   150: aload_2
    //   151: ldc 99
    //   153: sipush 8192
    //   156: invokevirtual 777	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   159: istore 12
    //   161: aload_2
    //   162: ldc 12
    //   164: ldc2_w 786
    //   167: invokevirtual 791	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   170: lstore 13
    //   172: aload_2
    //   173: ldc 15
    //   175: ldc2_w 792
    //   178: invokevirtual 791	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   181: lstore 15
    //   183: aload_0
    //   184: getfield 132	com/tencent/mobileqq/jsp/MediaApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   187: invokevirtual 137	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   190: astore 5
    //   192: aload_0
    //   193: getfield 132	com/tencent/mobileqq/jsp/MediaApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   196: invokevirtual 796	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   199: invokevirtual 801	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   202: astore 10
    //   204: aload 5
    //   206: instanceof 803
    //   209: istore 18
    //   211: aload 5
    //   213: instanceof 805
    //   216: istore 19
    //   218: iload 18
    //   220: ifne +8 -> 228
    //   223: iload 19
    //   225: ifeq +467 -> 692
    //   228: new 508	android/content/Intent
    //   231: dup
    //   232: invokespecial 806	android/content/Intent:<init>	()V
    //   235: astore_3
    //   236: iload 19
    //   238: ifeq +212 -> 450
    //   241: aload 5
    //   243: checkcast 805	com/tencent/mobileqq/webviewplugin/WebUiUtils$MediaApiPluginInterface
    //   246: invokeinterface 808 1 0
    //   251: ifeq +199 -> 450
    //   254: aload_3
    //   255: aload_0
    //   256: invokespecial 810	com/tencent/mobileqq/jsp/MediaApiPlugin:a	()Landroid/content/Context;
    //   259: ldc_w 812
    //   262: invokevirtual 816	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   265: pop
    //   266: aload_3
    //   267: ldc_w 818
    //   270: iconst_1
    //   271: invokevirtual 732	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   274: pop
    //   275: aload_3
    //   276: ldc_w 820
    //   279: aload 5
    //   281: checkcast 805	com/tencent/mobileqq/webviewplugin/WebUiUtils$MediaApiPluginInterface
    //   284: invokeinterface 822 1 0
    //   289: invokevirtual 707	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   292: pop
    //   293: aload_3
    //   294: ldc_w 824
    //   297: aload 5
    //   299: checkcast 805	com/tencent/mobileqq/webviewplugin/WebUiUtils$MediaApiPluginInterface
    //   302: invokeinterface 826 1 0
    //   307: invokevirtual 707	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   310: pop
    //   311: aload_3
    //   312: ldc_w 828
    //   315: aload_0
    //   316: getfield 132	com/tencent/mobileqq/jsp/MediaApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   319: invokevirtual 796	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   322: invokevirtual 832	com/tencent/common/app/AppInterface:a	()Ljava/lang/String;
    //   325: invokevirtual 707	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   328: pop
    //   329: aload_3
    //   330: ldc_w 716
    //   333: aload 5
    //   335: invokevirtual 722	java/lang/Object:getClass	()Ljava/lang/Class;
    //   338: invokevirtual 723	java/lang/Class:getName	()Ljava/lang/String;
    //   341: invokevirtual 707	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   344: pop
    //   345: aload_3
    //   346: ldc_w 725
    //   349: ldc_w 727
    //   352: invokevirtual 707	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   355: pop
    //   356: iload 11
    //   358: ifne +129 -> 487
    //   361: aload_2
    //   362: ldc_w 833
    //   365: iconst_1
    //   366: invokevirtual 777	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   369: istore 11
    //   371: aload_3
    //   372: ldc_w 835
    //   375: iload 11
    //   377: invokevirtual 838	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   380: pop
    //   381: iload 11
    //   383: iconst_1
    //   384: if_icmpne +12 -> 396
    //   387: aload_3
    //   388: ldc_w 840
    //   391: iconst_1
    //   392: invokevirtual 732	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   395: pop
    //   396: iload 18
    //   398: ifeq +73 -> 471
    //   401: aload 5
    //   403: checkcast 803	com/tencent/biz/webviewbase/AbsBaseWebViewActivity
    //   406: aload_0
    //   407: aload_3
    //   408: iconst_2
    //   409: invokevirtual 843	com/tencent/biz/webviewbase/AbsBaseWebViewActivity:a	(Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;Landroid/content/Intent;B)V
    //   412: aload_1
    //   413: invokestatic 849	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   416: invokeinterface 855 1 0
    //   421: ldc 24
    //   423: aload_2
    //   424: invokevirtual 856	org/json/JSONObject:toString	()Ljava/lang/String;
    //   427: invokeinterface 862 3 0
    //   432: ldc 32
    //   434: iload 17
    //   436: invokeinterface 866 3 0
    //   441: invokeinterface 869 1 0
    //   446: pop
    //   447: goto +2054 -> 2501
    //   450: aload_3
    //   451: aload 5
    //   453: ldc_w 812
    //   456: invokevirtual 816	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   459: pop
    //   460: goto -131 -> 329
    //   463: astore_1
    //   464: aload_1
    //   465: invokevirtual 600	org/json/JSONException:printStackTrace	()V
    //   468: goto +2033 -> 2501
    //   471: aload 5
    //   473: checkcast 805	com/tencent/mobileqq/webviewplugin/WebUiUtils$MediaApiPluginInterface
    //   476: aload_0
    //   477: aload_3
    //   478: iconst_2
    //   479: invokeinterface 870 4 0
    //   484: goto -72 -> 412
    //   487: iload 11
    //   489: iconst_1
    //   490: if_icmpne +65 -> 555
    //   493: aload_3
    //   494: ldc_w 840
    //   497: iconst_1
    //   498: invokevirtual 732	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   501: pop
    //   502: aload_3
    //   503: ldc_w 872
    //   506: iconst_2
    //   507: invokevirtual 838	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   510: pop
    //   511: aload_3
    //   512: ldc_w 874
    //   515: iconst_2
    //   516: invokevirtual 838	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   519: pop
    //   520: iload 18
    //   522: ifeq +17 -> 539
    //   525: aload 5
    //   527: checkcast 803	com/tencent/biz/webviewbase/AbsBaseWebViewActivity
    //   530: aload_0
    //   531: aload_3
    //   532: iconst_3
    //   533: invokevirtual 843	com/tencent/biz/webviewbase/AbsBaseWebViewActivity:a	(Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;Landroid/content/Intent;B)V
    //   536: goto -124 -> 412
    //   539: aload 5
    //   541: checkcast 805	com/tencent/mobileqq/webviewplugin/WebUiUtils$MediaApiPluginInterface
    //   544: aload_0
    //   545: aload_3
    //   546: iconst_3
    //   547: invokeinterface 870 4 0
    //   552: goto -140 -> 412
    //   555: iload 11
    //   557: iconst_2
    //   558: if_icmpne -146 -> 412
    //   561: aload_3
    //   562: ldc_w 876
    //   565: aload 10
    //   567: invokevirtual 707	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   570: pop
    //   571: aload_3
    //   572: ldc_w 840
    //   575: iconst_1
    //   576: invokevirtual 732	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   579: pop
    //   580: aload_3
    //   581: ldc_w 878
    //   584: iconst_1
    //   585: invokevirtual 732	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   588: pop
    //   589: aload_3
    //   590: ldc 93
    //   592: dload 6
    //   594: invokevirtual 881	android/content/Intent:putExtra	(Ljava/lang/String;D)Landroid/content/Intent;
    //   597: pop
    //   598: aload_3
    //   599: ldc 96
    //   601: dload 8
    //   603: invokevirtual 881	android/content/Intent:putExtra	(Ljava/lang/String;D)Landroid/content/Intent;
    //   606: pop
    //   607: aload_3
    //   608: ldc 99
    //   610: iload 12
    //   612: sipush 1024
    //   615: imul
    //   616: invokevirtual 838	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   619: pop
    //   620: aload_3
    //   621: ldc_w 874
    //   624: ldc2_w 882
    //   627: lload 15
    //   629: lmul
    //   630: invokevirtual 712	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   633: pop
    //   634: aload_3
    //   635: ldc_w 872
    //   638: iconst_0
    //   639: invokevirtual 838	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   642: pop
    //   643: aload_3
    //   644: ldc_w 885
    //   647: lload 13
    //   649: ldc2_w 886
    //   652: lmul
    //   653: invokevirtual 712	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   656: pop
    //   657: iload 18
    //   659: ifeq +17 -> 676
    //   662: aload 5
    //   664: checkcast 803	com/tencent/biz/webviewbase/AbsBaseWebViewActivity
    //   667: aload_0
    //   668: aload_3
    //   669: iconst_3
    //   670: invokevirtual 843	com/tencent/biz/webviewbase/AbsBaseWebViewActivity:a	(Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;Landroid/content/Intent;B)V
    //   673: goto -261 -> 412
    //   676: aload 5
    //   678: checkcast 805	com/tencent/mobileqq/webviewplugin/WebUiUtils$MediaApiPluginInterface
    //   681: aload_0
    //   682: aload_3
    //   683: iconst_3
    //   684: invokeinterface 870 4 0
    //   689: goto -277 -> 412
    //   692: iload 17
    //   694: ifeq +16 -> 710
    //   697: aload_0
    //   698: aload 4
    //   700: iconst_0
    //   701: ldc_w 889
    //   704: invokevirtual 748	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs4OpenApiIfNeeded	(Ljava/lang/String;ILjava/lang/String;)V
    //   707: goto +1796 -> 2503
    //   710: aload_0
    //   711: aload_3
    //   712: iconst_2
    //   713: anewarray 298	java/lang/String
    //   716: dup
    //   717: iconst_0
    //   718: ldc_w 891
    //   721: aastore
    //   722: dup
    //   723: iconst_1
    //   724: ldc_w 889
    //   727: aastore
    //   728: invokevirtual 895	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   731: goto +1772 -> 2503
    //   734: iload 11
    //   736: iconst_1
    //   737: if_icmpne +1764 -> 2501
    //   740: invokestatic 529	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   743: invokestatic 900	com/tencent/av/camera/QavCameraUsage:b	(Landroid/content/Context;)Z
    //   746: ifeq +5 -> 751
    //   749: iconst_1
    //   750: ireturn
    //   751: new 290	java/io/File
    //   754: dup
    //   755: new 180	java/lang/StringBuilder
    //   758: dup
    //   759: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   762: getstatic 903	com/tencent/mobileqq/app/AppConstants:bj	Ljava/lang/String;
    //   765: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   768: ldc_w 905
    //   771: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   774: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   777: invokespecial 291	java/io/File:<init>	(Ljava/lang/String;)V
    //   780: astore 5
    //   782: aload 5
    //   784: invokevirtual 538	java/io/File:exists	()Z
    //   787: ifne +65 -> 852
    //   790: aload 5
    //   792: invokevirtual 459	java/io/File:mkdirs	()Z
    //   795: ifne +57 -> 852
    //   798: aload_1
    //   799: ldc_w 906
    //   802: iconst_0
    //   803: invokestatic 911	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;II)Lcom/tencent/mobileqq/widget/QQToast;
    //   806: invokevirtual 914	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   809: pop
    //   810: iload 17
    //   812: ifeq +16 -> 828
    //   815: aload_0
    //   816: aload 4
    //   818: iconst_0
    //   819: ldc_w 889
    //   822: invokevirtual 748	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs4OpenApiIfNeeded	(Ljava/lang/String;ILjava/lang/String;)V
    //   825: goto +1680 -> 2505
    //   828: aload_0
    //   829: aload_3
    //   830: iconst_2
    //   831: anewarray 298	java/lang/String
    //   834: dup
    //   835: iconst_0
    //   836: ldc_w 891
    //   839: aastore
    //   840: dup
    //   841: iconst_1
    //   842: ldc_w 889
    //   845: aastore
    //   846: invokevirtual 895	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   849: goto +1656 -> 2505
    //   852: new 180	java/lang/StringBuilder
    //   855: dup
    //   856: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   859: getstatic 903	com/tencent/mobileqq/app/AppConstants:bj	Ljava/lang/String;
    //   862: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   865: ldc_w 905
    //   868: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   871: invokestatic 501	java/lang/System:currentTimeMillis	()J
    //   874: invokevirtual 434	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   877: ldc_w 372
    //   880: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   883: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   886: astore_3
    //   887: new 290	java/io/File
    //   890: dup
    //   891: aload_3
    //   892: invokespecial 291	java/io/File:<init>	(Ljava/lang/String;)V
    //   895: invokestatic 918	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
    //   898: astore 4
    //   900: new 508	android/content/Intent
    //   903: dup
    //   904: ldc_w 920
    //   907: invokespecial 511	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   910: astore 5
    //   912: aload 5
    //   914: ldc_w 922
    //   917: aload 4
    //   919: invokevirtual 925	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   922: pop
    //   923: aload 5
    //   925: ldc_w 927
    //   928: bipush 100
    //   930: invokevirtual 838	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   933: pop
    //   934: aload_2
    //   935: ldc_w 929
    //   938: iconst_0
    //   939: invokevirtual 933	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   942: ifeq +13 -> 955
    //   945: aload 5
    //   947: ldc_w 935
    //   950: iconst_1
    //   951: invokevirtual 838	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   954: pop
    //   955: aload_0
    //   956: aload 5
    //   958: iconst_1
    //   959: invokevirtual 939	com/tencent/mobileqq/jsp/MediaApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   962: aload_1
    //   963: invokestatic 849	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   966: invokeinterface 855 1 0
    //   971: ldc_w 941
    //   974: aload_3
    //   975: invokeinterface 862 3 0
    //   980: ldc 24
    //   982: aload_2
    //   983: invokevirtual 856	org/json/JSONObject:toString	()Ljava/lang/String;
    //   986: invokeinterface 862 3 0
    //   991: ldc 32
    //   993: iload 17
    //   995: invokeinterface 866 3 0
    //   1000: invokeinterface 869 1 0
    //   1005: pop
    //   1006: goto +1495 -> 2501
    //   1009: astore_2
    //   1010: aload_2
    //   1011: invokevirtual 942	java/lang/Exception:printStackTrace	()V
    //   1014: aload_1
    //   1015: ldc_w 943
    //   1018: iconst_0
    //   1019: invokestatic 911	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;II)Lcom/tencent/mobileqq/widget/QQToast;
    //   1022: invokevirtual 914	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   1025: pop
    //   1026: goto +1475 -> 2501
    //   1029: ldc_w 945
    //   1032: aload 4
    //   1034: invokevirtual 310	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1037: ifne +13 -> 1050
    //   1040: ldc 78
    //   1042: aload 4
    //   1044: invokevirtual 310	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1047: ifeq +227 -> 1274
    //   1050: aload 5
    //   1052: arraylength
    //   1053: iconst_1
    //   1054: if_icmpne +220 -> 1274
    //   1057: new 589	org/json/JSONObject
    //   1060: dup
    //   1061: aload 5
    //   1063: iconst_0
    //   1064: aaload
    //   1065: invokespecial 765	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1068: astore_1
    //   1069: aload_1
    //   1070: ldc 28
    //   1072: invokevirtual 771	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1075: astore_2
    //   1076: aload_1
    //   1077: ldc 48
    //   1079: invokevirtual 771	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1082: astore_3
    //   1083: aload_2
    //   1084: invokestatic 170	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1087: ifne +1420 -> 2507
    //   1090: aload_3
    //   1091: invokestatic 170	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1094: ifeq +6 -> 1100
    //   1097: goto +1410 -> 2507
    //   1100: aload_0
    //   1101: getfield 947	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   1104: ifnonnull +54 -> 1158
    //   1107: aload_0
    //   1108: getfield 132	com/tencent/mobileqq/jsp/MediaApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1111: invokevirtual 137	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1114: astore 5
    //   1116: aload_0
    //   1117: new 949	com/tencent/mobileqq/widget/QQProgressDialog
    //   1120: dup
    //   1121: aload 5
    //   1123: aload 5
    //   1125: invokevirtual 953	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1128: ldc_w 954
    //   1131: invokevirtual 960	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   1134: invokespecial 963	com/tencent/mobileqq/widget/QQProgressDialog:<init>	(Landroid/content/Context;I)V
    //   1137: putfield 947	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   1140: aload_0
    //   1141: getfield 947	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   1144: ldc_w 964
    //   1147: invokevirtual 966	com/tencent/mobileqq/widget/QQProgressDialog:b	(I)V
    //   1150: aload_0
    //   1151: getfield 947	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   1154: aload_0
    //   1155: invokevirtual 969	com/tencent/mobileqq/widget/QQProgressDialog:a	(Lcom/tencent/mobileqq/widget/QQProgressDialog$Callback;)V
    //   1158: aload_0
    //   1159: getfield 947	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   1162: invokevirtual 972	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   1165: ifne +10 -> 1175
    //   1168: aload_0
    //   1169: getfield 947	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   1172: invokevirtual 975	com/tencent/mobileqq/widget/QQProgressDialog:show	()V
    //   1175: ldc 78
    //   1177: aload 4
    //   1179: invokevirtual 310	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1182: ifeq +37 -> 1219
    //   1185: new 977	sxw
    //   1188: dup
    //   1189: aload_0
    //   1190: aload_2
    //   1191: aload_1
    //   1192: ldc 69
    //   1194: iconst_0
    //   1195: invokevirtual 777	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1198: aload_3
    //   1199: invokespecial 979	sxw:<init>	(Lcom/tencent/mobileqq/jsp/MediaApiPlugin;Ljava/lang/String;ILjava/lang/String;)V
    //   1202: iconst_5
    //   1203: aconst_null
    //   1204: iconst_1
    //   1205: invokestatic 984	com/tencent/mobileqq/app/ThreadManager:a	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1208: goto +1293 -> 2501
    //   1211: astore_1
    //   1212: aload_1
    //   1213: invokevirtual 600	org/json/JSONException:printStackTrace	()V
    //   1216: goto +1285 -> 2501
    //   1219: new 986	sxv
    //   1222: dup
    //   1223: aload_0
    //   1224: aload_2
    //   1225: aload_1
    //   1226: ldc_w 988
    //   1229: sipush 1280
    //   1232: invokevirtual 777	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1235: aload_1
    //   1236: ldc_w 990
    //   1239: sipush 1280
    //   1242: invokevirtual 777	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1245: aload_1
    //   1246: ldc_w 992
    //   1249: iconst_1
    //   1250: invokevirtual 777	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1253: aload_1
    //   1254: ldc_w 994
    //   1257: iconst_1
    //   1258: invokevirtual 777	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1261: aload_3
    //   1262: invokespecial 997	sxv:<init>	(Lcom/tencent/mobileqq/jsp/MediaApiPlugin;Ljava/lang/String;IIIILjava/lang/String;)V
    //   1265: iconst_5
    //   1266: aconst_null
    //   1267: iconst_1
    //   1268: invokestatic 984	com/tencent/mobileqq/app/ThreadManager:a	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1271: goto +1230 -> 2501
    //   1274: ldc 90
    //   1276: aload 4
    //   1278: invokevirtual 310	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1281: ifeq +377 -> 1658
    //   1284: aload 5
    //   1286: arraylength
    //   1287: iconst_1
    //   1288: if_icmpne +370 -> 1658
    //   1291: aconst_null
    //   1292: astore_2
    //   1293: new 999	java/util/concurrent/atomic/AtomicBoolean
    //   1296: dup
    //   1297: iconst_0
    //   1298: invokespecial 1001	java/util/concurrent/atomic/AtomicBoolean:<init>	(Z)V
    //   1301: astore_3
    //   1302: aload_2
    //   1303: astore_1
    //   1304: new 589	org/json/JSONObject
    //   1307: dup
    //   1308: aload 5
    //   1310: iconst_0
    //   1311: aaload
    //   1312: invokespecial 765	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1315: astore 4
    //   1317: aload_2
    //   1318: astore_1
    //   1319: aload 4
    //   1321: ldc 28
    //   1323: invokevirtual 771	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1326: astore_2
    //   1327: aload_2
    //   1328: astore_1
    //   1329: aload 4
    //   1331: ldc_w 1003
    //   1334: invokevirtual 1006	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1337: astore 4
    //   1339: aload_2
    //   1340: astore_1
    //   1341: aload 4
    //   1343: ldc_w 1008
    //   1346: invokevirtual 1011	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1349: ifne +16 -> 1365
    //   1352: aload_2
    //   1353: astore_1
    //   1354: aload 4
    //   1356: ldc_w 1013
    //   1359: invokevirtual 1011	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1362: ifeq +221 -> 1583
    //   1365: aload_2
    //   1366: astore_1
    //   1367: aload_0
    //   1368: getfield 947	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   1371: ifnonnull +62 -> 1433
    //   1374: aload_2
    //   1375: astore_1
    //   1376: aload_0
    //   1377: getfield 132	com/tencent/mobileqq/jsp/MediaApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1380: invokevirtual 137	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1383: astore 5
    //   1385: aload_2
    //   1386: astore_1
    //   1387: aload_0
    //   1388: new 949	com/tencent/mobileqq/widget/QQProgressDialog
    //   1391: dup
    //   1392: aload 5
    //   1394: aload 5
    //   1396: invokevirtual 953	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1399: ldc_w 954
    //   1402: invokevirtual 960	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   1405: invokespecial 963	com/tencent/mobileqq/widget/QQProgressDialog:<init>	(Landroid/content/Context;I)V
    //   1408: putfield 947	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   1411: aload_2
    //   1412: astore_1
    //   1413: aload_0
    //   1414: getfield 947	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   1417: ldc_w 964
    //   1420: invokevirtual 966	com/tencent/mobileqq/widget/QQProgressDialog:b	(I)V
    //   1423: aload_2
    //   1424: astore_1
    //   1425: aload_0
    //   1426: getfield 947	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   1429: aload_0
    //   1430: invokevirtual 969	com/tencent/mobileqq/widget/QQProgressDialog:a	(Lcom/tencent/mobileqq/widget/QQProgressDialog$Callback;)V
    //   1433: aload_2
    //   1434: astore_1
    //   1435: aload_0
    //   1436: getfield 947	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   1439: invokevirtual 972	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   1442: ifne +12 -> 1454
    //   1445: aload_2
    //   1446: astore_1
    //   1447: aload_0
    //   1448: getfield 947	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   1451: invokevirtual 975	com/tencent/mobileqq/widget/QQProgressDialog:show	()V
    //   1454: aload_2
    //   1455: astore_1
    //   1456: new 1015	sxr
    //   1459: dup
    //   1460: aload_0
    //   1461: aload 4
    //   1463: aload_2
    //   1464: aload_3
    //   1465: invokespecial 1018	sxr:<init>	(Lcom/tencent/mobileqq/jsp/MediaApiPlugin;Ljava/lang/String;Ljava/lang/String;Ljava/util/concurrent/atomic/AtomicBoolean;)V
    //   1468: iconst_5
    //   1469: aconst_null
    //   1470: iconst_1
    //   1471: invokestatic 984	com/tencent/mobileqq/app/ThreadManager:a	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1474: goto +1027 -> 2501
    //   1477: astore_2
    //   1478: invokestatic 1021	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1481: ifeq +30 -> 1511
    //   1484: getstatic 120	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1487: iconst_4
    //   1488: new 180	java/lang/StringBuilder
    //   1491: dup
    //   1492: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   1495: ldc_w 1023
    //   1498: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1501: aload_2
    //   1502: invokevirtual 1026	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1505: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1508: invokestatic 193	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1511: aload_1
    //   1512: invokestatic 170	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1515: ifne +986 -> 2501
    //   1518: aload_3
    //   1519: iconst_0
    //   1520: iconst_1
    //   1521: invokevirtual 1030	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   1524: ifeq +977 -> 2501
    //   1527: new 589	org/json/JSONObject
    //   1530: dup
    //   1531: invokespecial 590	org/json/JSONObject:<init>	()V
    //   1534: astore_2
    //   1535: aload_2
    //   1536: ldc 60
    //   1538: iconst_m1
    //   1539: invokevirtual 627	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1542: pop
    //   1543: aload_2
    //   1544: ldc 63
    //   1546: invokestatic 529	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1549: ldc_w 1031
    //   1552: invokevirtual 1034	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   1555: invokevirtual 594	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1558: pop
    //   1559: iload 17
    //   1561: ifeq +83 -> 1644
    //   1564: aload_0
    //   1565: aload_1
    //   1566: iconst_1
    //   1567: anewarray 298	java/lang/String
    //   1570: dup
    //   1571: iconst_0
    //   1572: aload_2
    //   1573: invokevirtual 856	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1576: aastore
    //   1577: invokevirtual 895	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1580: goto +921 -> 2501
    //   1583: aload_2
    //   1584: astore_1
    //   1585: invokestatic 1037	com/tencent/mobileqq/app/ThreadManager:b	()Lmqq/os/MqqHandler;
    //   1588: new 1039	sxs
    //   1591: dup
    //   1592: aload_0
    //   1593: aload 4
    //   1595: aload_2
    //   1596: aload_3
    //   1597: invokespecial 1040	sxs:<init>	(Lcom/tencent/mobileqq/jsp/MediaApiPlugin;Ljava/lang/String;Ljava/lang/String;Ljava/util/concurrent/atomic/AtomicBoolean;)V
    //   1600: invokevirtual 1046	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   1603: pop
    //   1604: goto +897 -> 2501
    //   1607: astore_1
    //   1608: invokestatic 1021	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1611: ifeq +890 -> 2501
    //   1614: getstatic 120	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1617: iconst_4
    //   1618: new 180	java/lang/StringBuilder
    //   1621: dup
    //   1622: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   1625: ldc_w 1023
    //   1628: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1631: aload_1
    //   1632: invokevirtual 1026	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1635: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1638: invokestatic 193	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1641: goto +860 -> 2501
    //   1644: aload_0
    //   1645: ldc 90
    //   1647: iconst_0
    //   1648: aload_2
    //   1649: invokevirtual 856	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1652: invokevirtual 748	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs4OpenApiIfNeeded	(Ljava/lang/String;ILjava/lang/String;)V
    //   1655: goto +846 -> 2501
    //   1658: ldc 81
    //   1660: aload 4
    //   1662: invokevirtual 310	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1665: ifeq +522 -> 2187
    //   1668: aload 5
    //   1670: arraylength
    //   1671: iconst_1
    //   1672: if_icmpne +515 -> 2187
    //   1675: new 589	org/json/JSONObject
    //   1678: dup
    //   1679: aload 5
    //   1681: iconst_0
    //   1682: aaload
    //   1683: invokespecial 765	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1686: astore_1
    //   1687: invokestatic 178	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1690: ifeq +33 -> 1723
    //   1693: ldc_w 1048
    //   1696: iconst_2
    //   1697: new 180	java/lang/StringBuilder
    //   1700: dup
    //   1701: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   1704: ldc_w 1050
    //   1707: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1710: aload 5
    //   1712: iconst_0
    //   1713: aaload
    //   1714: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1717: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1720: invokestatic 193	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1723: aload_1
    //   1724: ldc 15
    //   1726: bipush 120
    //   1728: invokevirtual 777	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1731: istore 11
    //   1733: aload_0
    //   1734: getfield 132	com/tencent/mobileqq/jsp/MediaApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1737: invokevirtual 796	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   1740: astore_3
    //   1741: invokestatic 529	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1744: astore_2
    //   1745: invokestatic 1052	com/tencent/mobileqq/shortvideo/ShortVideoUtils:b	()Z
    //   1748: putstatic 1053	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	Z
    //   1751: getstatic 1053	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	Z
    //   1754: ifeq +402 -> 2156
    //   1757: aload_3
    //   1758: invokestatic 1058	com/tencent/mobileqq/shortvideo/VideoEnvironment:c	(Lcom/tencent/common/app/AppInterface;)Z
    //   1761: ifeq +395 -> 2156
    //   1764: aload_3
    //   1765: invokestatic 1061	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Lcom/tencent/common/app/AppInterface;)V
    //   1768: invokestatic 1063	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	()Z
    //   1771: ifne +170 -> 1941
    //   1774: aload_2
    //   1775: invokestatic 1067	com/tencent/mobileqq/utils/NetworkUtil:h	(Landroid/content/Context;)Z
    //   1778: ifne +17 -> 1795
    //   1781: aload_2
    //   1782: ldc_w 1068
    //   1785: iconst_0
    //   1786: invokestatic 911	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;II)Lcom/tencent/mobileqq/widget/QQToast;
    //   1789: invokevirtual 914	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   1792: pop
    //   1793: iconst_1
    //   1794: ireturn
    //   1795: aload_3
    //   1796: bipush 76
    //   1798: invokevirtual 1072	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1801: checkcast 1074	com/tencent/mobileqq/earlydownload/EarlyDownloadManager
    //   1804: ldc_w 1076
    //   1807: invokevirtual 1079	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/earlydownload/handler/EarlyHandler;
    //   1810: checkcast 1081	com/tencent/mobileqq/earlydownload/handler/QQShortVideoHandler
    //   1813: astore_1
    //   1814: aload_1
    //   1815: ifnull +107 -> 1922
    //   1818: aload_1
    //   1819: iconst_1
    //   1820: invokevirtual 1083	com/tencent/mobileqq/earlydownload/handler/QQShortVideoHandler:a	(Z)V
    //   1823: invokestatic 178	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1826: ifeq +33 -> 1859
    //   1829: ldc_w 1048
    //   1832: iconst_2
    //   1833: new 180	java/lang/StringBuilder
    //   1836: dup
    //   1837: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   1840: ldc_w 1085
    //   1843: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1846: aload_1
    //   1847: getfield 1087	com/tencent/mobileqq/earlydownload/handler/QQShortVideoHandler:b	I
    //   1850: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1853: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1856: invokestatic 193	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1859: aload_1
    //   1860: getfield 1087	com/tencent/mobileqq/earlydownload/handler/QQShortVideoHandler:b	I
    //   1863: ifle +36 -> 1899
    //   1866: aload_2
    //   1867: aload_2
    //   1868: ldc_w 1088
    //   1871: iconst_1
    //   1872: anewarray 718	java/lang/Object
    //   1875: dup
    //   1876: iconst_0
    //   1877: aload_1
    //   1878: getfield 1087	com/tencent/mobileqq/earlydownload/handler/QQShortVideoHandler:b	I
    //   1881: invokestatic 1094	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1884: aastore
    //   1885: invokevirtual 1097	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   1888: iconst_0
    //   1889: invokestatic 1100	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   1892: invokevirtual 914	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   1895: pop
    //   1896: goto +613 -> 2509
    //   1899: aload_2
    //   1900: ldc_w 1101
    //   1903: iconst_0
    //   1904: invokestatic 911	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;II)Lcom/tencent/mobileqq/widget/QQToast;
    //   1907: invokevirtual 914	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   1910: pop
    //   1911: goto +598 -> 2509
    //   1914: astore_1
    //   1915: aload_1
    //   1916: invokevirtual 600	org/json/JSONException:printStackTrace	()V
    //   1919: goto +582 -> 2501
    //   1922: invokestatic 178	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1925: ifeq +584 -> 2509
    //   1928: ldc_w 1048
    //   1931: iconst_2
    //   1932: ldc_w 1103
    //   1935: invokestatic 193	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1938: goto +571 -> 2509
    //   1941: invokestatic 529	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1944: invokestatic 900	com/tencent/av/camera/QavCameraUsage:b	(Landroid/content/Context;)Z
    //   1947: ifeq +34 -> 1981
    //   1950: aload_2
    //   1951: ldc_w 1104
    //   1954: iconst_0
    //   1955: invokestatic 911	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;II)Lcom/tencent/mobileqq/widget/QQToast;
    //   1958: invokevirtual 914	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   1961: pop
    //   1962: invokestatic 178	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1965: ifeq +546 -> 2511
    //   1968: ldc_w 1048
    //   1971: iconst_2
    //   1972: ldc_w 1106
    //   1975: invokestatic 193	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1978: goto +533 -> 2511
    //   1981: new 508	android/content/Intent
    //   1984: dup
    //   1985: aload_2
    //   1986: ldc_w 1108
    //   1989: invokespecial 701	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   1992: astore_3
    //   1993: aload_3
    //   1994: ldc_w 1110
    //   1997: getstatic 1114	com/tencent/widget/XPanelContainer:c	I
    //   2000: invokevirtual 838	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2003: pop
    //   2004: aload_3
    //   2005: ldc_w 1116
    //   2008: invokestatic 1121	com/tencent/mobileqq/app/DeviceProfileManager:a	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   2011: getstatic 1127	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:NewShortVideoConfig	Lcom/tencent/mobileqq/app/DeviceProfileManager$DpcNames;
    //   2014: invokevirtual 1130	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:name	()Ljava/lang/String;
    //   2017: aconst_null
    //   2018: invokevirtual 1133	com/tencent/mobileqq/app/DeviceProfileManager:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2021: invokevirtual 707	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2024: pop
    //   2025: aload_3
    //   2026: ldc_w 1135
    //   2029: invokestatic 1121	com/tencent/mobileqq/app/DeviceProfileManager:a	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   2032: getstatic 1141	com/tencent/mobileqq/app/DeviceProfileManager$AccountDpcManager$DpcAccountNames:picpredownload_whitelist	Lcom/tencent/mobileqq/app/DeviceProfileManager$AccountDpcManager$DpcAccountNames;
    //   2035: invokevirtual 1142	com/tencent/mobileqq/app/DeviceProfileManager$AccountDpcManager$DpcAccountNames:name	()Ljava/lang/String;
    //   2038: invokevirtual 1144	com/tencent/mobileqq/app/DeviceProfileManager:a	(Ljava/lang/String;)Z
    //   2041: invokevirtual 732	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   2044: pop
    //   2045: aload_3
    //   2046: ldc_w 1146
    //   2049: iconst_1
    //   2050: invokevirtual 732	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   2053: pop
    //   2054: aload_3
    //   2055: ldc_w 725
    //   2058: ldc_w 727
    //   2061: invokevirtual 707	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2064: pop
    //   2065: aload_3
    //   2066: ldc_w 1148
    //   2069: iload 11
    //   2071: sipush 1000
    //   2074: imul
    //   2075: invokevirtual 838	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2078: pop
    //   2079: aload_3
    //   2080: ldc_w 1150
    //   2083: iconst_1
    //   2084: invokevirtual 838	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2087: pop
    //   2088: aload_3
    //   2089: ldc_w 1152
    //   2092: iconst_1
    //   2093: invokevirtual 732	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   2096: pop
    //   2097: aload_3
    //   2098: ldc_w 1154
    //   2101: new 1156	com/tencent/mobileqq/activity/aio/SessionInfo
    //   2104: dup
    //   2105: invokespecial 1157	com/tencent/mobileqq/activity/aio/SessionInfo:<init>	()V
    //   2108: invokevirtual 925	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   2111: pop
    //   2112: aload_0
    //   2113: aload_3
    //   2114: iconst_4
    //   2115: invokevirtual 939	com/tencent/mobileqq/jsp/MediaApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   2118: aload_2
    //   2119: invokestatic 849	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   2122: invokeinterface 855 1 0
    //   2127: ldc 24
    //   2129: aload_1
    //   2130: invokevirtual 856	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2133: invokeinterface 862 3 0
    //   2138: ldc 32
    //   2140: iload 17
    //   2142: invokeinterface 866 3 0
    //   2147: invokeinterface 869 1 0
    //   2152: pop
    //   2153: goto +348 -> 2501
    //   2156: aload_2
    //   2157: ldc_w 1158
    //   2160: iconst_0
    //   2161: invokestatic 911	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;II)Lcom/tencent/mobileqq/widget/QQToast;
    //   2164: invokevirtual 914	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   2167: pop
    //   2168: invokestatic 178	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2171: ifeq -53 -> 2118
    //   2174: ldc_w 1048
    //   2177: iconst_2
    //   2178: ldc_w 1160
    //   2181: invokestatic 1162	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   2184: goto -66 -> 2118
    //   2187: ldc 84
    //   2189: aload 4
    //   2191: invokevirtual 310	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2194: ifeq +118 -> 2312
    //   2197: aload 5
    //   2199: arraylength
    //   2200: iconst_1
    //   2201: if_icmpne +111 -> 2312
    //   2204: new 589	org/json/JSONObject
    //   2207: dup
    //   2208: aload 5
    //   2210: iconst_0
    //   2211: aaload
    //   2212: invokespecial 765	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2215: astore_1
    //   2216: invokestatic 178	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2219: ifeq +30 -> 2249
    //   2222: ldc_w 1164
    //   2225: iconst_2
    //   2226: new 180	java/lang/StringBuilder
    //   2229: dup
    //   2230: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   2233: ldc_w 1166
    //   2236: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2239: aload_1
    //   2240: invokevirtual 1026	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2243: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2246: invokestatic 193	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2249: aload_1
    //   2250: ldc_w 1168
    //   2253: invokevirtual 771	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2256: astore_2
    //   2257: aload_1
    //   2258: ldc 54
    //   2260: invokevirtual 1171	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   2263: lstore 13
    //   2265: aload_1
    //   2266: ldc 57
    //   2268: invokevirtual 1171	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   2271: lstore 15
    //   2273: aload_0
    //   2274: getfield 132	com/tencent/mobileqq/jsp/MediaApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2277: invokevirtual 137	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   2280: aload_2
    //   2281: lload 13
    //   2283: lload 15
    //   2285: invokestatic 1173	com/tencent/mobileqq/jsp/MediaApiPlugin:a	(Landroid/content/Context;Ljava/lang/String;JJ)V
    //   2288: goto +213 -> 2501
    //   2291: astore_1
    //   2292: invokestatic 178	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2295: ifeq +206 -> 2501
    //   2298: ldc_w 1164
    //   2301: iconst_2
    //   2302: ldc_w 1175
    //   2305: aload_1
    //   2306: invokestatic 1178	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2309: goto +192 -> 2501
    //   2312: ldc 87
    //   2314: aload 4
    //   2316: invokevirtual 310	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2319: ifeq +182 -> 2501
    //   2322: aload 5
    //   2324: arraylength
    //   2325: iconst_1
    //   2326: if_icmplt +175 -> 2501
    //   2329: new 589	org/json/JSONObject
    //   2332: dup
    //   2333: aload 5
    //   2335: iconst_0
    //   2336: aaload
    //   2337: invokespecial 765	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2340: astore_1
    //   2341: aload_1
    //   2342: ldc 28
    //   2344: invokevirtual 771	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2347: astore_2
    //   2348: invokestatic 529	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2351: astore_3
    //   2352: aload_0
    //   2353: new 508	android/content/Intent
    //   2356: dup
    //   2357: aload_3
    //   2358: ldc_w 1180
    //   2361: invokespecial 701	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   2364: iconst_5
    //   2365: invokevirtual 939	com/tencent/mobileqq/jsp/MediaApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   2368: aload_3
    //   2369: invokestatic 849	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   2372: invokeinterface 855 1 0
    //   2377: ldc 24
    //   2379: aload_1
    //   2380: invokevirtual 856	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2383: invokeinterface 862 3 0
    //   2388: ldc 32
    //   2390: iload 17
    //   2392: invokeinterface 866 3 0
    //   2397: invokeinterface 869 1 0
    //   2402: pop
    //   2403: invokestatic 178	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2406: ifeq +95 -> 2501
    //   2409: ldc_w 1164
    //   2412: iconst_2
    //   2413: new 180	java/lang/StringBuilder
    //   2416: dup
    //   2417: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   2420: ldc_w 1182
    //   2423: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2426: aload 5
    //   2428: iconst_0
    //   2429: aaload
    //   2430: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2433: ldc_w 1184
    //   2436: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2439: aload_2
    //   2440: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2443: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2446: invokestatic 1162	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   2449: goto +52 -> 2501
    //   2452: astore_1
    //   2453: invokestatic 178	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2456: ifeq +45 -> 2501
    //   2459: ldc_w 1164
    //   2462: iconst_2
    //   2463: new 180	java/lang/StringBuilder
    //   2466: dup
    //   2467: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   2470: ldc_w 1186
    //   2473: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2476: aload_1
    //   2477: invokevirtual 1026	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2480: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2483: invokestatic 1162	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   2486: goto +15 -> 2501
    //   2489: iconst_0
    //   2490: ireturn
    //   2491: astore_3
    //   2492: goto -933 -> 1559
    //   2495: iconst_0
    //   2496: istore 17
    //   2498: goto -2475 -> 23
    //   2501: iconst_1
    //   2502: ireturn
    //   2503: iconst_1
    //   2504: ireturn
    //   2505: iconst_1
    //   2506: ireturn
    //   2507: iconst_1
    //   2508: ireturn
    //   2509: iconst_1
    //   2510: ireturn
    //   2511: iconst_1
    //   2512: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2513	0	this	MediaApiPlugin
    //   0	2513	1	paramJsBridgeListener	com.tencent.mobileqq.webview.swift.JsBridgeListener
    //   0	2513	2	paramString1	String
    //   0	2513	3	paramString2	String
    //   0	2513	4	paramString3	String
    //   0	2513	5	paramVarArgs	String[]
    //   137	456	6	d1	double
    //   148	454	8	d2	double
    //   202	364	10	str	String
    //   108	1967	11	i1	int
    //   159	457	12	i2	int
    //   170	2112	13	l1	long
    //   181	2103	15	l2	long
    //   21	2476	17	bool1	boolean
    //   209	449	18	bool2	boolean
    //   216	21	19	bool3	boolean
    // Exception table:
    //   from	to	target	type
    //   57	93	463	org/json/JSONException
    //   100	114	463	org/json/JSONException
    //   119	218	463	org/json/JSONException
    //   228	236	463	org/json/JSONException
    //   241	329	463	org/json/JSONException
    //   329	356	463	org/json/JSONException
    //   361	381	463	org/json/JSONException
    //   387	396	463	org/json/JSONException
    //   401	412	463	org/json/JSONException
    //   412	447	463	org/json/JSONException
    //   450	460	463	org/json/JSONException
    //   471	484	463	org/json/JSONException
    //   493	520	463	org/json/JSONException
    //   525	536	463	org/json/JSONException
    //   539	552	463	org/json/JSONException
    //   561	657	463	org/json/JSONException
    //   662	673	463	org/json/JSONException
    //   676	689	463	org/json/JSONException
    //   697	707	463	org/json/JSONException
    //   710	731	463	org/json/JSONException
    //   740	749	463	org/json/JSONException
    //   751	810	463	org/json/JSONException
    //   815	825	463	org/json/JSONException
    //   828	849	463	org/json/JSONException
    //   852	955	463	org/json/JSONException
    //   955	1006	463	org/json/JSONException
    //   1010	1026	463	org/json/JSONException
    //   955	1006	1009	java/lang/Exception
    //   1057	1097	1211	org/json/JSONException
    //   1100	1158	1211	org/json/JSONException
    //   1158	1175	1211	org/json/JSONException
    //   1175	1208	1211	org/json/JSONException
    //   1219	1271	1211	org/json/JSONException
    //   1304	1317	1477	java/lang/OutOfMemoryError
    //   1319	1327	1477	java/lang/OutOfMemoryError
    //   1329	1339	1477	java/lang/OutOfMemoryError
    //   1341	1352	1477	java/lang/OutOfMemoryError
    //   1354	1365	1477	java/lang/OutOfMemoryError
    //   1367	1374	1477	java/lang/OutOfMemoryError
    //   1376	1385	1477	java/lang/OutOfMemoryError
    //   1387	1411	1477	java/lang/OutOfMemoryError
    //   1413	1423	1477	java/lang/OutOfMemoryError
    //   1425	1433	1477	java/lang/OutOfMemoryError
    //   1435	1445	1477	java/lang/OutOfMemoryError
    //   1447	1454	1477	java/lang/OutOfMemoryError
    //   1456	1474	1477	java/lang/OutOfMemoryError
    //   1585	1604	1477	java/lang/OutOfMemoryError
    //   1304	1317	1607	org/json/JSONException
    //   1319	1327	1607	org/json/JSONException
    //   1329	1339	1607	org/json/JSONException
    //   1341	1352	1607	org/json/JSONException
    //   1354	1365	1607	org/json/JSONException
    //   1367	1374	1607	org/json/JSONException
    //   1376	1385	1607	org/json/JSONException
    //   1387	1411	1607	org/json/JSONException
    //   1413	1423	1607	org/json/JSONException
    //   1425	1433	1607	org/json/JSONException
    //   1435	1445	1607	org/json/JSONException
    //   1447	1454	1607	org/json/JSONException
    //   1456	1474	1607	org/json/JSONException
    //   1585	1604	1607	org/json/JSONException
    //   1675	1723	1914	org/json/JSONException
    //   1723	1793	1914	org/json/JSONException
    //   1795	1814	1914	org/json/JSONException
    //   1818	1859	1914	org/json/JSONException
    //   1859	1896	1914	org/json/JSONException
    //   1899	1911	1914	org/json/JSONException
    //   1922	1938	1914	org/json/JSONException
    //   1941	1978	1914	org/json/JSONException
    //   1981	2118	1914	org/json/JSONException
    //   2118	2153	1914	org/json/JSONException
    //   2156	2184	1914	org/json/JSONException
    //   2204	2249	2291	java/lang/Exception
    //   2249	2288	2291	java/lang/Exception
    //   2329	2449	2452	java/lang/Exception
    //   1535	1559	2491	org/json/JSONException
  }
  
  /* Error */
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: iload_2
    //   3: iload_3
    //   4: invokespecial 1190	com/tencent/mobileqq/webview/swift/WebViewPlugin:onActivityResult	(Landroid/content/Intent;BI)V
    //   7: invokestatic 529	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   10: astore 5
    //   12: aload 5
    //   14: invokestatic 849	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   17: astore 6
    //   19: aload 6
    //   21: ldc_w 941
    //   24: ldc_w 306
    //   27: invokeinterface 1192 3 0
    //   32: astore 4
    //   34: aload 6
    //   36: ldc 24
    //   38: ldc_w 306
    //   41: invokeinterface 1192 3 0
    //   46: astore 7
    //   48: aload 6
    //   50: ldc 32
    //   52: iconst_0
    //   53: invokeinterface 1195 3 0
    //   58: istore 14
    //   60: aload 5
    //   62: invokestatic 849	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   65: invokeinterface 855 1 0
    //   70: ldc_w 941
    //   73: invokeinterface 1199 2 0
    //   78: ldc 24
    //   80: invokeinterface 1199 2 0
    //   85: ldc 32
    //   87: invokeinterface 1199 2 0
    //   92: invokeinterface 869 1 0
    //   97: pop
    //   98: aload 7
    //   100: invokestatic 170	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   103: ifeq +9 -> 112
    //   106: iload 14
    //   108: ifne +4 -> 112
    //   111: return
    //   112: new 589	org/json/JSONObject
    //   115: dup
    //   116: aload 7
    //   118: invokespecial 765	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   121: astore 7
    //   123: aload 7
    //   125: ldc_w 767
    //   128: invokevirtual 771	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   131: astore 6
    //   133: aload 7
    //   135: ldc 28
    //   137: invokevirtual 771	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   140: astore 5
    //   142: aload 5
    //   144: invokestatic 170	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   147: istore 15
    //   149: iload 15
    //   151: ifeq +8 -> 159
    //   154: iload 14
    //   156: ifeq -45 -> 111
    //   159: iload_2
    //   160: iconst_1
    //   161: if_icmpeq +8 -> 169
    //   164: iload_2
    //   165: iconst_2
    //   166: if_icmpne +523 -> 689
    //   169: iload_3
    //   170: iconst_m1
    //   171: if_icmpne +479 -> 650
    //   174: iload_2
    //   175: iconst_1
    //   176: if_icmpne +111 -> 287
    //   179: iconst_1
    //   180: anewarray 298	java/lang/String
    //   183: astore_1
    //   184: aload_1
    //   185: iconst_0
    //   186: aload 4
    //   188: aastore
    //   189: aload 7
    //   191: ldc_w 1201
    //   194: iconst_0
    //   195: invokevirtual 933	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   198: ifeq +257 -> 455
    //   201: new 1203	org/json/JSONArray
    //   204: dup
    //   205: invokespecial 1204	org/json/JSONArray:<init>	()V
    //   208: astore 4
    //   210: aload_1
    //   211: arraylength
    //   212: istore 9
    //   214: iconst_0
    //   215: istore_3
    //   216: iload_3
    //   217: iload 9
    //   219: if_icmpge +153 -> 372
    //   222: aload_1
    //   223: iload_3
    //   224: aaload
    //   225: astore 7
    //   227: new 589	org/json/JSONObject
    //   230: dup
    //   231: invokespecial 590	org/json/JSONObject:<init>	()V
    //   234: astore 8
    //   236: aload 8
    //   238: ldc 39
    //   240: ldc_w 306
    //   243: invokevirtual 594	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   246: pop
    //   247: aload 8
    //   249: ldc 48
    //   251: aload 7
    //   253: invokevirtual 594	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   256: pop
    //   257: aload 8
    //   259: ldc 36
    //   261: iconst_0
    //   262: invokevirtual 627	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   265: pop
    //   266: aload 4
    //   268: aload 8
    //   270: invokevirtual 1207	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   273: pop
    //   274: iload_3
    //   275: iconst_1
    //   276: iadd
    //   277: istore_3
    //   278: goto -62 -> 216
    //   281: astore_1
    //   282: aload_1
    //   283: invokevirtual 600	org/json/JSONException:printStackTrace	()V
    //   286: return
    //   287: aload_1
    //   288: ifnull +38 -> 326
    //   291: aload_1
    //   292: ldc_w 1209
    //   295: invokevirtual 1213	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   298: astore_1
    //   299: aload_1
    //   300: ifnull +10 -> 310
    //   303: aload_1
    //   304: invokevirtual 1218	java/util/ArrayList:size	()I
    //   307: ifne +47 -> 354
    //   310: iload 14
    //   312: ifeq +19 -> 331
    //   315: aload_0
    //   316: aload 6
    //   318: iconst_0
    //   319: ldc_w 889
    //   322: invokevirtual 748	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs4OpenApiIfNeeded	(Ljava/lang/String;ILjava/lang/String;)V
    //   325: return
    //   326: aconst_null
    //   327: astore_1
    //   328: goto -29 -> 299
    //   331: aload_0
    //   332: aload 5
    //   334: iconst_2
    //   335: anewarray 298	java/lang/String
    //   338: dup
    //   339: iconst_0
    //   340: ldc_w 891
    //   343: aastore
    //   344: dup
    //   345: iconst_1
    //   346: ldc_w 889
    //   349: aastore
    //   350: invokevirtual 895	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   353: return
    //   354: aload_1
    //   355: aload_1
    //   356: invokevirtual 1218	java/util/ArrayList:size	()I
    //   359: anewarray 298	java/lang/String
    //   362: invokevirtual 1222	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   365: checkcast 1224	[Ljava/lang/String;
    //   368: astore_1
    //   369: goto -180 -> 189
    //   372: iload 14
    //   374: ifeq +33 -> 407
    //   377: aload_0
    //   378: aload 6
    //   380: iconst_0
    //   381: aload 4
    //   383: invokevirtual 1225	org/json/JSONArray:toString	()Ljava/lang/String;
    //   386: invokevirtual 748	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs4OpenApiIfNeeded	(Ljava/lang/String;ILjava/lang/String;)V
    //   389: return
    //   390: astore_1
    //   391: iload 14
    //   393: ifeq +39 -> 432
    //   396: aload_0
    //   397: aload 6
    //   399: iconst_0
    //   400: ldc_w 889
    //   403: invokevirtual 748	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs4OpenApiIfNeeded	(Ljava/lang/String;ILjava/lang/String;)V
    //   406: return
    //   407: aload_0
    //   408: aload 5
    //   410: iconst_2
    //   411: anewarray 298	java/lang/String
    //   414: dup
    //   415: iconst_0
    //   416: ldc_w 1227
    //   419: aastore
    //   420: dup
    //   421: iconst_1
    //   422: aload 4
    //   424: invokevirtual 1225	org/json/JSONArray:toString	()Ljava/lang/String;
    //   427: aastore
    //   428: invokevirtual 895	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   431: return
    //   432: aload_0
    //   433: aload 5
    //   435: iconst_2
    //   436: anewarray 298	java/lang/String
    //   439: dup
    //   440: iconst_0
    //   441: ldc_w 891
    //   444: aastore
    //   445: dup
    //   446: iconst_1
    //   447: ldc_w 889
    //   450: aastore
    //   451: invokevirtual 895	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   454: return
    //   455: aload_0
    //   456: getfield 947	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   459: ifnonnull +54 -> 513
    //   462: aload_0
    //   463: getfield 132	com/tencent/mobileqq/jsp/MediaApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   466: invokevirtual 137	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   469: astore 4
    //   471: aload_0
    //   472: new 949	com/tencent/mobileqq/widget/QQProgressDialog
    //   475: dup
    //   476: aload 4
    //   478: aload 4
    //   480: invokevirtual 953	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   483: ldc_w 954
    //   486: invokevirtual 960	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   489: invokespecial 963	com/tencent/mobileqq/widget/QQProgressDialog:<init>	(Landroid/content/Context;I)V
    //   492: putfield 947	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   495: aload_0
    //   496: getfield 947	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   499: ldc_w 964
    //   502: invokevirtual 966	com/tencent/mobileqq/widget/QQProgressDialog:b	(I)V
    //   505: aload_0
    //   506: getfield 947	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   509: aload_0
    //   510: invokevirtual 969	com/tencent/mobileqq/widget/QQProgressDialog:a	(Lcom/tencent/mobileqq/widget/QQProgressDialog$Callback;)V
    //   513: aload_0
    //   514: getfield 750	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_JavaLangThread	Ljava/lang/Thread;
    //   517: ifnull +10 -> 527
    //   520: aload_0
    //   521: getfield 750	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_JavaLangThread	Ljava/lang/Thread;
    //   524: invokevirtual 753	java/lang/Thread:interrupt	()V
    //   527: aload_0
    //   528: getfield 947	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   531: invokevirtual 972	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   534: ifne +10 -> 544
    //   537: aload_0
    //   538: getfield 947	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   541: invokevirtual 975	com/tencent/mobileqq/widget/QQProgressDialog:show	()V
    //   544: ldc 75
    //   546: aload 6
    //   548: invokevirtual 310	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   551: ifeq +37 -> 588
    //   554: aload_0
    //   555: new 1229	sxu
    //   558: dup
    //   559: aload_0
    //   560: aload 5
    //   562: aload 7
    //   564: ldc 69
    //   566: iconst_0
    //   567: invokevirtual 777	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   570: aload_1
    //   571: invokespecial 1232	sxu:<init>	(Lcom/tencent/mobileqq/jsp/MediaApiPlugin;Ljava/lang/String;I[Ljava/lang/String;)V
    //   574: putfield 750	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_JavaLangThread	Ljava/lang/Thread;
    //   577: aload_0
    //   578: getfield 750	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_JavaLangThread	Ljava/lang/Thread;
    //   581: iconst_5
    //   582: aconst_null
    //   583: iconst_1
    //   584: invokestatic 984	com/tencent/mobileqq/app/ThreadManager:a	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   587: return
    //   588: aload_0
    //   589: new 1234	sxt
    //   592: dup
    //   593: aload_0
    //   594: aload 5
    //   596: iload 14
    //   598: aload 6
    //   600: aload 7
    //   602: ldc_w 988
    //   605: sipush 1280
    //   608: invokevirtual 777	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   611: aload 7
    //   613: ldc_w 990
    //   616: sipush 1280
    //   619: invokevirtual 777	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   622: aload 7
    //   624: ldc_w 992
    //   627: iconst_1
    //   628: invokevirtual 777	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   631: aload 7
    //   633: ldc_w 994
    //   636: iconst_1
    //   637: invokevirtual 777	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   640: aload_1
    //   641: invokespecial 1237	sxt:<init>	(Lcom/tencent/mobileqq/jsp/MediaApiPlugin;Ljava/lang/String;ZLjava/lang/String;IIII[Ljava/lang/String;)V
    //   644: putfield 750	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_JavaLangThread	Ljava/lang/Thread;
    //   647: goto -70 -> 577
    //   650: iload 14
    //   652: ifeq +14 -> 666
    //   655: aload_0
    //   656: aload 6
    //   658: iconst_0
    //   659: ldc_w 889
    //   662: invokevirtual 748	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs4OpenApiIfNeeded	(Ljava/lang/String;ILjava/lang/String;)V
    //   665: return
    //   666: aload_0
    //   667: aload 5
    //   669: iconst_2
    //   670: anewarray 298	java/lang/String
    //   673: dup
    //   674: iconst_0
    //   675: ldc_w 1239
    //   678: aastore
    //   679: dup
    //   680: iconst_1
    //   681: ldc_w 889
    //   684: aastore
    //   685: invokevirtual 895	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   688: return
    //   689: iload_2
    //   690: iconst_3
    //   691: if_icmpne +270 -> 961
    //   694: iload_3
    //   695: iconst_m1
    //   696: if_icmpne -585 -> 111
    //   699: aload_1
    //   700: ifnull +150 -> 850
    //   703: aload_1
    //   704: ldc_w 1241
    //   707: invokevirtual 1244	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   710: astore 4
    //   712: aload_1
    //   713: ifnull +143 -> 856
    //   716: aload_1
    //   717: ldc_w 1246
    //   720: iconst_0
    //   721: invokevirtual 1249	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   724: ifeq +132 -> 856
    //   727: iconst_1
    //   728: istore_3
    //   729: aload_1
    //   730: ifnull +131 -> 861
    //   733: aload_1
    //   734: ldc_w 1251
    //   737: lconst_0
    //   738: invokevirtual 1254	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   741: lstore 10
    //   743: aload_1
    //   744: ifnull +123 -> 867
    //   747: aload_1
    //   748: ldc_w 714
    //   751: lconst_0
    //   752: invokevirtual 1254	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   755: lstore 12
    //   757: aload 4
    //   759: ifnonnull +3 -> 762
    //   762: iload_3
    //   763: ifeq +120 -> 883
    //   766: new 1203	org/json/JSONArray
    //   769: dup
    //   770: invokespecial 1204	org/json/JSONArray:<init>	()V
    //   773: astore_1
    //   774: aload_0
    //   775: aload 4
    //   777: invokespecial 1256	com/tencent/mobileqq/jsp/MediaApiPlugin:a	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   780: astore 4
    //   782: aload 4
    //   784: ldc 57
    //   786: lload 12
    //   788: ldc2_w 882
    //   791: ldiv
    //   792: invokevirtual 1259	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   795: pop
    //   796: aload 4
    //   798: ldc 54
    //   800: lload 10
    //   802: ldc2_w 886
    //   805: ldiv
    //   806: invokevirtual 1259	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   809: pop
    //   810: aload 4
    //   812: ldc 45
    //   814: iconst_1
    //   815: invokevirtual 627	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   818: pop
    //   819: aload_1
    //   820: aload 4
    //   822: invokevirtual 1207	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   825: pop
    //   826: aload_0
    //   827: aload 5
    //   829: iconst_2
    //   830: anewarray 298	java/lang/String
    //   833: dup
    //   834: iconst_0
    //   835: ldc_w 1227
    //   838: aastore
    //   839: dup
    //   840: iconst_1
    //   841: aload_1
    //   842: invokevirtual 1225	org/json/JSONArray:toString	()Ljava/lang/String;
    //   845: aastore
    //   846: invokevirtual 895	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   849: return
    //   850: aconst_null
    //   851: astore 4
    //   853: goto -141 -> 712
    //   856: iconst_0
    //   857: istore_3
    //   858: goto -129 -> 729
    //   861: lconst_0
    //   862: lstore 10
    //   864: goto -121 -> 743
    //   867: lconst_0
    //   868: lstore 12
    //   870: goto -113 -> 757
    //   873: astore 6
    //   875: aload 6
    //   877: invokevirtual 600	org/json/JSONException:printStackTrace	()V
    //   880: goto -61 -> 819
    //   883: aload_0
    //   884: new 1234	sxt
    //   887: dup
    //   888: aload_0
    //   889: aload 5
    //   891: iload 14
    //   893: aload 6
    //   895: aload 7
    //   897: ldc_w 988
    //   900: sipush 2000
    //   903: invokevirtual 777	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   906: aload 7
    //   908: ldc_w 990
    //   911: sipush 3000
    //   914: invokevirtual 777	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   917: aload 7
    //   919: ldc_w 992
    //   922: iconst_0
    //   923: invokevirtual 777	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   926: aload 7
    //   928: ldc_w 994
    //   931: iconst_0
    //   932: invokevirtual 777	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   935: iconst_1
    //   936: anewarray 298	java/lang/String
    //   939: dup
    //   940: iconst_0
    //   941: aload 4
    //   943: aastore
    //   944: invokespecial 1237	sxt:<init>	(Lcom/tencent/mobileqq/jsp/MediaApiPlugin;Ljava/lang/String;ZLjava/lang/String;IIII[Ljava/lang/String;)V
    //   947: putfield 750	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_JavaLangThread	Ljava/lang/Thread;
    //   950: aload_0
    //   951: getfield 750	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_JavaLangThread	Ljava/lang/Thread;
    //   954: iconst_5
    //   955: aconst_null
    //   956: iconst_1
    //   957: invokestatic 984	com/tencent/mobileqq/app/ThreadManager:a	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   960: return
    //   961: iload_2
    //   962: iconst_4
    //   963: if_icmpne +141 -> 1104
    //   966: aload_1
    //   967: ifnull +122 -> 1089
    //   970: aload_1
    //   971: ldc_w 1261
    //   974: invokevirtual 1244	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   977: astore_1
    //   978: aload_1
    //   979: ifnull -868 -> 111
    //   982: lconst_0
    //   983: lstore 10
    //   985: getstatic 1264	android/os/Build$VERSION:SDK_INT	I
    //   988: bipush 10
    //   990: if_icmplt +30 -> 1020
    //   993: new 1266	android/media/MediaMetadataRetriever
    //   996: dup
    //   997: invokespecial 1267	android/media/MediaMetadataRetriever:<init>	()V
    //   1000: astore 4
    //   1002: aload 4
    //   1004: aload_1
    //   1005: invokevirtual 1270	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   1008: aload 4
    //   1010: bipush 9
    //   1012: invokevirtual 1273	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   1015: invokestatic 1278	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   1018: lstore 10
    //   1020: new 290	java/io/File
    //   1023: dup
    //   1024: aload_1
    //   1025: invokespecial 291	java/io/File:<init>	(Ljava/lang/String;)V
    //   1028: invokevirtual 348	java/io/File:length	()J
    //   1031: lstore 12
    //   1033: aload_0
    //   1034: aload_1
    //   1035: invokespecial 1256	com/tencent/mobileqq/jsp/MediaApiPlugin:a	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1038: astore_1
    //   1039: aload_1
    //   1040: ldc 57
    //   1042: lload 10
    //   1044: ldc2_w 882
    //   1047: ldiv
    //   1048: invokevirtual 1259	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   1051: pop
    //   1052: aload_1
    //   1053: ldc 54
    //   1055: lload 12
    //   1057: ldc2_w 886
    //   1060: ldiv
    //   1061: invokevirtual 1259	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   1064: pop
    //   1065: aload_0
    //   1066: aload 5
    //   1068: iconst_2
    //   1069: anewarray 298	java/lang/String
    //   1072: dup
    //   1073: iconst_0
    //   1074: ldc_w 1227
    //   1077: aastore
    //   1078: dup
    //   1079: iconst_1
    //   1080: aload_1
    //   1081: invokevirtual 856	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1084: aastore
    //   1085: invokevirtual 895	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1088: return
    //   1089: aconst_null
    //   1090: astore_1
    //   1091: goto -113 -> 978
    //   1094: astore 4
    //   1096: aload 4
    //   1098: invokevirtual 600	org/json/JSONException:printStackTrace	()V
    //   1101: goto -36 -> 1065
    //   1104: iload_2
    //   1105: iconst_5
    //   1106: if_icmpne -995 -> 111
    //   1109: aload_1
    //   1110: ldc_w 1280
    //   1113: iconst_0
    //   1114: invokevirtual 1283	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1117: istore_3
    //   1118: aload_0
    //   1119: aload 5
    //   1121: iconst_1
    //   1122: anewarray 298	java/lang/String
    //   1125: dup
    //   1126: iconst_0
    //   1127: iload_3
    //   1128: invokestatic 1285	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1131: aastore
    //   1132: invokevirtual 895	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1135: invokestatic 178	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1138: ifeq -1027 -> 111
    //   1141: ldc_w 1164
    //   1144: iconst_2
    //   1145: new 180	java/lang/StringBuilder
    //   1148: dup
    //   1149: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   1152: ldc_w 1287
    //   1155: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1158: iload_3
    //   1159: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1162: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1165: invokestatic 1162	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1168: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1169	0	this	MediaApiPlugin
    //   0	1169	1	paramIntent	Intent
    //   0	1169	2	paramByte	byte
    //   0	1169	3	paramInt	int
    //   32	977	4	localObject1	Object
    //   1094	3	4	localJSONException1	JSONException
    //   10	1110	5	localObject2	Object
    //   17	640	6	localObject3	Object
    //   873	21	6	localJSONException2	JSONException
    //   46	881	7	localObject4	Object
    //   234	35	8	localJSONObject	JSONObject
    //   212	8	9	i1	int
    //   741	302	10	l1	long
    //   755	301	12	l2	long
    //   58	834	14	bool1	boolean
    //   147	3	15	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   112	149	281	org/json/JSONException
    //   201	214	390	org/json/JSONException
    //   227	274	390	org/json/JSONException
    //   377	389	390	org/json/JSONException
    //   407	431	390	org/json/JSONException
    //   782	819	873	org/json/JSONException
    //   1039	1065	1094	org/json/JSONException
  }
  
  protected void onDestroy()
  {
    if (this.jdField_a_of_type_JavaLangThread != null) {
      this.jdField_a_of_type_JavaLangThread.interrupt();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient != null) {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b();
    }
    super.onDestroy();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\jsp\MediaApiPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */