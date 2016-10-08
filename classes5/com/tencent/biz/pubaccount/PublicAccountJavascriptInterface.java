package com.tencent.biz.pubaccount;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.ProgressBar;
import com.tencent.biz.ProtoServlet;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyFeedsActivity;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.data.CouponH5Data;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webview.swift.JsWebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebUiBaseInterface;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebFeaturesInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebProgressInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebUiMethodInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebviewReportSpeedInterface;
import com.tencent.protofile.coupon.CouponProto.ReportReq;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import com.tencent.util.ThreeDes;
import cooperation.plugin.PluginBaseActivity;
import hpj;
import hpk;
import hpl;
import hpm;
import hpn;
import hpo;
import hpp;
import hpq;
import hpr;
import hps;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.NewIntent;
import org.json.JSONException;
import org.json.JSONObject;

public class PublicAccountJavascriptInterface
  extends JsWebViewPlugin
{
  public static final int a = -2;
  public static final long a = 52428800L;
  protected static final String a = "PAjs";
  protected static HashMap a;
  public static final int b = -3;
  private static long b = 0L;
  protected static final String b = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCrkUA+dDEQT52svdheRw04+xrExuTvNj3g7pjcyUkH3+86FiYNhHtyWJc11BywUZ2Ey3RomCyTb/szl5qQEJqR7UC5z4mhLrhgXlbRI0BgmI/LhaMRsfskGM7ziyQ2ZpS0qbHX2xoum6ou/541/VePIwmcnIk6eWUx6GYnA4euZQIDAQAB";
  public static final int c = -4;
  public static final String c = "pubUin";
  public static final int d = -5;
  public static final String d;
  public static final int e = -6;
  protected static final String e = "nbyvie";
  public static final int f = -7;
  protected static final String f = "webview";
  public static final int g = -8;
  public static final String g = "publicAccount";
  public static final int h = -9;
  private static final String h = "setNavigationBarStyle";
  public static final int i = -10;
  public static final int j = -11;
  public static final int k = -12;
  public static final int l = 1001;
  public Activity a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new hpl(this);
  private WebUiUtils.WebUiMethodInterface jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebUiMethodInterface;
  private WebUiUtils.WebviewReportSpeedInterface jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebviewReportSpeedInterface;
  protected List a;
  boolean jdField_a_of_type_Boolean = false;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    d = AppConstants.bj + "pubaccount/";
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  private String a(String paramString1, String paramString2, String paramString3)
  {
    Object localObject = this.mRuntime.a();
    if (localObject == null) {
      return null;
    }
    localObject = ((AppInterface)localObject).a(((AppInterface)localObject).getAccount()).createEntityManager();
    paramString1 = (CouponH5Data)((EntityManager)localObject).a(CouponH5Data.class, "mHost = ? AND mPath = ? AND mKey = ?", new String[] { paramString1, paramString2, paramString3 });
    ((EntityManager)localObject).a();
    if (paramString1 != null) {}
    for (paramString1 = paramString1.mData;; paramString1 = null) {
      return paramString1;
    }
  }
  
  /* Error */
  private String a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 160	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 161	org/json/JSONObject:<init>	()V
    //   7: astore 5
    //   9: new 144	java/lang/String
    //   12: dup
    //   13: aload_1
    //   14: ldc -93
    //   16: invokespecial 166	java/lang/String:<init>	([BLjava/lang/String;)V
    //   19: astore_2
    //   20: aload_2
    //   21: astore_1
    //   22: new 160	org/json/JSONObject
    //   25: dup
    //   26: aload_1
    //   27: invokespecial 169	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   30: astore_1
    //   31: aload_1
    //   32: astore 5
    //   34: new 160	org/json/JSONObject
    //   37: dup
    //   38: invokespecial 161	org/json/JSONObject:<init>	()V
    //   41: astore 7
    //   43: new 171	org/json/JSONArray
    //   46: dup
    //   47: invokespecial 172	org/json/JSONArray:<init>	()V
    //   50: astore 8
    //   52: new 171	org/json/JSONArray
    //   55: dup
    //   56: invokespecial 172	org/json/JSONArray:<init>	()V
    //   59: astore 9
    //   61: new 160	org/json/JSONObject
    //   64: dup
    //   65: invokespecial 161	org/json/JSONObject:<init>	()V
    //   68: astore 10
    //   70: new 160	org/json/JSONObject
    //   73: dup
    //   74: invokespecial 161	org/json/JSONObject:<init>	()V
    //   77: astore 11
    //   79: new 171	org/json/JSONArray
    //   82: dup
    //   83: invokespecial 172	org/json/JSONArray:<init>	()V
    //   86: astore_2
    //   87: new 171	org/json/JSONArray
    //   90: dup
    //   91: invokespecial 172	org/json/JSONArray:<init>	()V
    //   94: astore 4
    //   96: new 160	org/json/JSONObject
    //   99: dup
    //   100: invokespecial 161	org/json/JSONObject:<init>	()V
    //   103: astore 6
    //   105: new 160	org/json/JSONObject
    //   108: dup
    //   109: invokespecial 161	org/json/JSONObject:<init>	()V
    //   112: astore_1
    //   113: aload 5
    //   115: ldc -82
    //   117: invokevirtual 178	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   120: astore_3
    //   121: aload_3
    //   122: astore_1
    //   123: aload 5
    //   125: ldc -76
    //   127: invokevirtual 184	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   130: astore_3
    //   131: aload 5
    //   133: ldc -70
    //   135: invokevirtual 184	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   138: astore 4
    //   140: aload 5
    //   142: ldc -68
    //   144: invokevirtual 178	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   147: astore 5
    //   149: aload_3
    //   150: astore_2
    //   151: aload 4
    //   153: astore_3
    //   154: aload_2
    //   155: astore 4
    //   157: aload 5
    //   159: astore_2
    //   160: aload 11
    //   162: ldc -66
    //   164: aload_1
    //   165: ldc -64
    //   167: invokevirtual 195	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   170: invokevirtual 199	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   173: pop
    //   174: aload 11
    //   176: ldc -55
    //   178: aload_1
    //   179: ldc -53
    //   181: invokevirtual 195	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   184: invokevirtual 199	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   187: pop
    //   188: aload 11
    //   190: ldc -51
    //   192: aload_1
    //   193: ldc -49
    //   195: invokevirtual 195	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   198: invokevirtual 199	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   201: pop
    //   202: iconst_0
    //   203: istore 12
    //   205: iload 12
    //   207: aload 4
    //   209: invokevirtual 211	org/json/JSONArray:length	()I
    //   212: if_icmpge +157 -> 369
    //   215: new 160	org/json/JSONObject
    //   218: dup
    //   219: invokespecial 161	org/json/JSONObject:<init>	()V
    //   222: astore_1
    //   223: aload 4
    //   225: iload 12
    //   227: invokevirtual 215	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   230: checkcast 160	org/json/JSONObject
    //   233: astore 5
    //   235: aload_1
    //   236: ldc -39
    //   238: aload 5
    //   240: ldc -37
    //   242: invokevirtual 223	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   245: invokestatic 227	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   248: invokevirtual 199	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   251: pop
    //   252: aload_1
    //   253: ldc -27
    //   255: aload 5
    //   257: ldc -25
    //   259: invokevirtual 223	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   262: invokestatic 227	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   265: invokevirtual 199	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   268: pop
    //   269: aload_1
    //   270: ldc -23
    //   272: aload 5
    //   274: ldc -21
    //   276: invokevirtual 223	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   279: invokestatic 227	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   282: invokevirtual 199	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   285: pop
    //   286: aload_1
    //   287: ldc -19
    //   289: aload 5
    //   291: ldc -17
    //   293: invokevirtual 223	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   296: invokestatic 227	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   299: invokevirtual 199	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   302: pop
    //   303: aload_1
    //   304: ldc -15
    //   306: aload 5
    //   308: ldc -13
    //   310: invokevirtual 223	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   313: invokestatic 227	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   316: invokevirtual 199	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   319: pop
    //   320: aload 9
    //   322: aload_1
    //   323: invokevirtual 246	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   326: pop
    //   327: iload 12
    //   329: iconst_1
    //   330: iadd
    //   331: istore 12
    //   333: goto -128 -> 205
    //   336: astore_2
    //   337: new 144	java/lang/String
    //   340: dup
    //   341: aload_1
    //   342: invokespecial 249	java/lang/String:<init>	([B)V
    //   345: astore_1
    //   346: goto -324 -> 22
    //   349: astore_1
    //   350: goto -316 -> 34
    //   353: astore_3
    //   354: aload_2
    //   355: astore_3
    //   356: aload 4
    //   358: astore_2
    //   359: aload_2
    //   360: astore 4
    //   362: aload 6
    //   364: astore_2
    //   365: goto -205 -> 160
    //   368: astore_1
    //   369: iconst_0
    //   370: istore 12
    //   372: iload 12
    //   374: aload_3
    //   375: invokevirtual 211	org/json/JSONArray:length	()I
    //   378: if_icmpge +70 -> 448
    //   381: new 160	org/json/JSONObject
    //   384: dup
    //   385: invokespecial 161	org/json/JSONObject:<init>	()V
    //   388: astore_1
    //   389: aload_3
    //   390: iload 12
    //   392: invokevirtual 215	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   395: checkcast 160	org/json/JSONObject
    //   398: astore 4
    //   400: aload_1
    //   401: ldc -5
    //   403: aload 4
    //   405: ldc -3
    //   407: invokevirtual 195	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   410: invokevirtual 199	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   413: pop
    //   414: aload_1
    //   415: ldc -15
    //   417: aload 4
    //   419: ldc -1
    //   421: invokevirtual 223	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   424: invokestatic 227	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   427: invokevirtual 199	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   430: pop
    //   431: aload 8
    //   433: aload_1
    //   434: invokevirtual 246	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   437: pop
    //   438: iload 12
    //   440: iconst_1
    //   441: iadd
    //   442: istore 12
    //   444: goto -72 -> 372
    //   447: astore_1
    //   448: aload 10
    //   450: ldc_w 257
    //   453: aload_2
    //   454: ldc_w 259
    //   457: invokevirtual 223	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   460: invokestatic 227	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   463: invokevirtual 199	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   466: pop
    //   467: aload 10
    //   469: ldc_w 261
    //   472: aload_2
    //   473: ldc_w 263
    //   476: invokevirtual 223	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   479: invokestatic 227	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   482: invokevirtual 199	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   485: pop
    //   486: aload 10
    //   488: ldc_w 265
    //   491: aload_2
    //   492: ldc_w 267
    //   495: invokevirtual 223	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   498: invokestatic 227	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   501: invokevirtual 199	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   504: pop
    //   505: aload 10
    //   507: ldc_w 269
    //   510: aload_2
    //   511: ldc_w 271
    //   514: invokevirtual 223	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   517: invokestatic 227	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   520: invokevirtual 199	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   523: pop
    //   524: aload 7
    //   526: ldc_w 273
    //   529: aload 11
    //   531: invokevirtual 199	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   534: pop
    //   535: aload 7
    //   537: ldc_w 275
    //   540: aload 10
    //   542: invokevirtual 199	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   545: pop
    //   546: aload 7
    //   548: ldc_w 277
    //   551: aload 9
    //   553: invokevirtual 199	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   556: pop
    //   557: aload 7
    //   559: ldc_w 279
    //   562: aload 8
    //   564: invokevirtual 199	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   567: pop
    //   568: aload 7
    //   570: invokevirtual 280	org/json/JSONObject:toString	()Ljava/lang/String;
    //   573: areturn
    //   574: astore_1
    //   575: goto -7 -> 568
    //   578: astore_1
    //   579: goto -22 -> 557
    //   582: astore_1
    //   583: goto -37 -> 546
    //   586: astore_1
    //   587: goto -52 -> 535
    //   590: astore_1
    //   591: goto -67 -> 524
    //   594: astore_1
    //   595: goto -393 -> 202
    //   598: astore_3
    //   599: aload_2
    //   600: astore_3
    //   601: aload 4
    //   603: astore_2
    //   604: goto -245 -> 359
    //   607: astore 4
    //   609: aload_2
    //   610: astore 4
    //   612: aload_3
    //   613: astore_2
    //   614: aload 4
    //   616: astore_3
    //   617: goto -258 -> 359
    //   620: astore_2
    //   621: aload_3
    //   622: astore_2
    //   623: aload 4
    //   625: astore_3
    //   626: goto -267 -> 359
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	629	0	this	PublicAccountJavascriptInterface
    //   0	629	1	paramArrayOfByte	byte[]
    //   19	141	2	localObject1	Object
    //   336	19	2	localUnsupportedEncodingException1	UnsupportedEncodingException
    //   358	256	2	localObject2	Object
    //   620	1	2	localJSONException1	JSONException
    //   622	1	2	localObject3	Object
    //   120	34	3	localObject4	Object
    //   353	1	3	localJSONException2	JSONException
    //   355	35	3	localUnsupportedEncodingException2	UnsupportedEncodingException
    //   598	1	3	localJSONException3	JSONException
    //   600	26	3	localObject5	Object
    //   94	508	4	localObject6	Object
    //   607	1	4	localJSONException4	JSONException
    //   610	14	4	localObject7	Object
    //   7	300	5	localObject8	Object
    //   103	260	6	localJSONObject1	JSONObject
    //   41	528	7	localJSONObject2	JSONObject
    //   50	513	8	localJSONArray1	org.json.JSONArray
    //   59	493	9	localJSONArray2	org.json.JSONArray
    //   68	473	10	localJSONObject3	JSONObject
    //   77	453	11	localJSONObject4	JSONObject
    //   203	240	12	m	int
    // Exception table:
    //   from	to	target	type
    //   9	20	336	java/io/UnsupportedEncodingException
    //   22	31	349	org/json/JSONException
    //   113	121	353	org/json/JSONException
    //   205	327	368	org/json/JSONException
    //   372	438	447	org/json/JSONException
    //   557	568	574	org/json/JSONException
    //   546	557	578	org/json/JSONException
    //   535	546	582	org/json/JSONException
    //   524	535	586	org/json/JSONException
    //   448	524	590	org/json/JSONException
    //   160	202	594	org/json/JSONException
    //   123	131	598	org/json/JSONException
    //   131	140	607	org/json/JSONException
    //   140	149	620	org/json/JSONException
  }
  
  private void a(String paramString)
  {
    Object localObject = this.mRuntime.a();
    if (localObject == null) {
      return;
    }
    localObject = ((AppInterface)localObject).a(((AppInterface)localObject).getAccount()).createEntityManager();
    paramString = ((EntityManager)localObject).a(CouponH5Data.class, false, "mHost = ?", new String[] { paramString }, null, null, null, null);
    if (paramString != null)
    {
      paramString = paramString.iterator();
      while (paramString.hasNext()) {
        ((EntityManager)localObject).b((CouponH5Data)paramString.next());
      }
    }
    ((EntityManager)localObject).a();
  }
  
  private void a(String paramString1, String paramString2)
  {
    Object localObject = this.mRuntime.a();
    if (localObject == null) {
      return;
    }
    localObject = ((AppInterface)localObject).a(((AppInterface)localObject).getAccount()).createEntityManager();
    paramString1 = ((EntityManager)localObject).a(CouponH5Data.class, false, "mHost = ? AND mPath = ?", new String[] { paramString1, paramString2 }, null, null, null, null);
    if (paramString1 != null)
    {
      paramString1 = paramString1.iterator();
      while (paramString1.hasNext()) {
        ((EntityManager)localObject).b((CouponH5Data)paramString1.next());
      }
    }
    ((EntityManager)localObject).a();
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    Object localObject = this.mRuntime.a();
    if (localObject == null) {
      return;
    }
    localObject = ((AppInterface)localObject).a(((AppInterface)localObject).getAccount()).createEntityManager();
    paramString1 = (CouponH5Data)((EntityManager)localObject).a(CouponH5Data.class, "mHost = ? AND mPath = ? AND mKey = ?", new String[] { paramString1, paramString2, paramString3 });
    if (paramString1 != null) {
      ((EntityManager)localObject).b(paramString1);
    }
    ((EntityManager)localObject).a();
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Object localObject = this.mRuntime.a();
    if (localObject == null) {
      return;
    }
    localObject = ((AppInterface)localObject).a(((AppInterface)localObject).getAccount()).createEntityManager();
    CouponH5Data localCouponH5Data = (CouponH5Data)((EntityManager)localObject).a(CouponH5Data.class, "mHost = ? AND mPath = ? AND mKey = ?", new String[] { paramString1, paramString2, paramString3 });
    if (localCouponH5Data == null) {
      ((EntityManager)localObject).a(new CouponH5Data(paramString1, paramString2, paramString3, paramString4));
    }
    for (;;)
    {
      ((EntityManager)localObject).a();
      return;
      localCouponH5Data.mData = paramString4;
      ((EntityManager)localObject).a(localCouponH5Data);
    }
  }
  
  private void a(URL paramURL, String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    Object localObject2;
    JSONObject localJSONObject;
    try
    {
      if (this.mRuntime.a() == null) {
        return;
      }
      localObject2 = this.mRuntime.a();
      if ((localObject2 == null) || (((AppInterface)localObject2).getAccount() == null)) {
        return;
      }
      localJSONObject = new JSONObject(paramString1);
      str1 = localJSONObject.optString("callid");
      localObject1 = str1;
      if (!TextUtils.isEmpty(str1)) {
        localObject1 = str1.replace("\\", "\\\\").replace("'", "\\'");
      }
      paramJSONObject.put("callid", localObject1);
      if (b > 52428800L)
      {
        ThreadManager.d(new hpr(this, paramString2, paramJSONObject, paramString1));
        return;
      }
    }
    catch (JSONException paramURL)
    {
      callJs(paramString2, new String[] { "{ret:-2, response:" + paramJSONObject.toString() + "}" });
      return;
    }
    String str1 = localJSONObject.optString("path");
    if (TextUtils.isEmpty(str1))
    {
      callJs(paramString2, new String[] { "{ret:-6, response:" + paramJSONObject.toString() + "}" });
      return;
    }
    Object localObject1 = localJSONObject.optString("key");
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      callJs(paramString2, new String[] { "{ret:-7, response:" + paramJSONObject.toString() + "}" });
      return;
    }
    String str2 = localJSONObject.optString("data");
    if (TextUtils.isEmpty(str2))
    {
      callJs(paramString2, new String[] { "{ret:-8, response:" + paramJSONObject.toString() + "}" });
      return;
    }
    paramURL = paramURL.getHost();
    paramString1 = localJSONObject.optString("host");
    if (!TextUtils.isEmpty(paramString1)) {
      if (a(paramString1, paramURL)) {
        paramURL = paramString1;
      }
    }
    for (;;)
    {
      paramString1 = paramURL;
      if (TextUtils.isEmpty(paramURL)) {
        paramString1 = "defaulthost";
      }
      paramURL = b(str2);
      a(paramString1, str1, (String)localObject1, paramURL);
      paramURL = b(str2, paramURL);
      localObject2 = new File(d + "/" + HexUtil.b(((AppInterface)localObject2).getAccount()));
      if (!((File)localObject2).exists())
      {
        ((File)localObject2).mkdirs();
        paramString1 = new File((File)localObject2, paramString1);
        if (paramString1.exists()) {
          break label740;
        }
        paramString1.mkdirs();
        label499:
        paramString1 = new File(paramString1, HexUtil.b(str1));
        if (paramString1.exists()) {
          break label760;
        }
        paramString1.mkdirs();
      }
      for (;;)
      {
        try {}catch (IOException paramURL)
        {
          try
          {
            paramString1 = new File(paramString1, HexUtil.b((String)localObject1));
            if (paramString1.exists()) {
              paramString1.delete();
            }
            localObject1 = new FileWriter(paramString1);
            ((FileWriter)localObject1).write(paramURL);
            ((FileWriter)localObject1).close();
            b += paramString1.length();
            callJs(paramString2, new String[] { "{ret:0, response:" + paramJSONObject.toString() + "}" });
            return;
          }
          finally {}
          paramURL = paramURL;
          callJs(paramString2, new String[] { "{ret:-9, response:" + paramJSONObject.toString() + "}" });
          return;
        }
        tmp680_677[0] = ("{ret:-5, response:" + paramJSONObject.toString() + "}");
        callJs(paramString2, tmp680_677);
        return;
        if (!((File)localObject2).isFile()) {
          break;
        }
        ((File)localObject2).delete();
        ((File)localObject2).mkdirs();
        break;
        label740:
        if (!paramString1.isFile()) {
          break label499;
        }
        paramString1.delete();
        paramString1.mkdirs();
        break label499;
        label760:
        if (paramString1.isFile())
        {
          paramString1.delete();
          paramString1.mkdirs();
        }
      }
    }
  }
  
  private void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    long l1 = 0L;
    if (this.mRuntime.a() == null) {}
    while ((this.jdField_a_of_type_AndroidAppActivity == null) || (this.jdField_a_of_type_AndroidAppActivity.isFinishing())) {
      return;
    }
    try
    {
      paramString1 = new JSONObject(paramString1);
      bool = paramString1.optBoolean("fallback", false);
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        long l2;
        label78:
        boolean bool = false;
        m = 0;
      }
    }
    try
    {
      m = paramString1.optInt("decrypt_padding", 0);
    }
    catch (JSONException paramString1)
    {
      m = 0;
      break label78;
    }
    try
    {
      l2 = paramString1.optLong("allowCacheTime", 0L);
      l1 = l2 * 1000L;
    }
    catch (JSONException paramString1)
    {
      break label78;
    }
    SosoInterface.a(new PublicAccountJavascriptInterface.TimedOnLocationListener(this, 0, paramBoolean, m, bool, paramString2, l1));
  }
  
  private static boolean a(String paramString1, String paramString2)
  {
    if (paramString2 == null) {}
    while ((!paramString2.equals(paramString1)) && ((paramString1.indexOf(".") <= 0) || (!paramString2.endsWith("." + paramString1)))) {
      return false;
    }
    return true;
  }
  
  private String b(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramString.getBytes("UTF-8"));
      paramString = HexUtil.a(localMessageDigest.digest());
      localMessageDigest.reset();
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      return "wronghash";
    }
    catch (NoSuchAlgorithmException paramString)
    {
      for (;;) {}
    }
  }
  
  private String b(String paramString1, String paramString2)
  {
    return ThreeDes.a(paramString1, paramString2);
  }
  
  private void b(String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    CustomWebView localCustomWebView = this.mRuntime.a();
    if (localCustomWebView == null) {
      return;
    }
    try
    {
      ThreadManager.a(new hpq(this, new URL(localCustomWebView.getUrl()), paramString1, paramString2, paramJSONObject), 5, null, false);
      return;
    }
    catch (MalformedURLException paramString1) {}
  }
  
  private static long c()
  {
    Object localObject = new File(d);
    if (!((File)localObject).exists()) {
      return 0L;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject);
    long l1 = 0L;
    while (!localArrayList.isEmpty())
    {
      localObject = (File)localArrayList.remove(0);
      if (((File)localObject).isFile())
      {
        l1 += ((File)localObject).length();
      }
      else
      {
        localObject = ((File)localObject).listFiles();
        if (localObject != null)
        {
          int n = localObject.length;
          int m = 0;
          while (m < n)
          {
            localArrayList.add(localObject[m]);
            m += 1;
          }
        }
      }
    }
    return l1;
  }
  
  private static String c(String paramString)
  {
    Object localObject = new ByteArrayOutputStream(1024);
    for (;;)
    {
      byte[] arrayOfByte;
      try
      {
        paramString = (HttpURLConnection)new URL(paramString).openConnection();
        paramString.setDoInput(true);
        paramString.connect();
        paramString = paramString.getInputStream();
        arrayOfByte = new byte['Ѐ'];
        int m = paramString.read(arrayOfByte);
        if (m == -1)
        {
          paramString.close();
          arrayOfByte = ((ByteArrayOutputStream)localObject).toByteArray();
          if (BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length) == null) {
            return null;
          }
        }
        else
        {
          ((ByteArrayOutputStream)localObject).write(arrayOfByte, 0, m);
          continue;
        }
        if ((arrayOfByte[0] & 0xFF) != 66) {
          break label225;
        }
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
        return null;
        localObject = "data:image;base64,";
        if (((arrayOfByte[0] & 0xFF) == 255) && ((arrayOfByte[1] & 0xFF) == 216))
        {
          paramString = "data:image/jpeg;base64,";
          return paramString + Base64Util.encodeToString(arrayOfByte, 2);
          paramString = (String)localObject;
          if ((arrayOfByte[0] & 0xFF) != 71) {
            continue;
          }
          paramString = (String)localObject;
          if ((arrayOfByte[1] & 0xFF) != 73) {
            continue;
          }
          paramString = "data:image/gif;base64,";
          continue;
        }
      }
      catch (OutOfMemoryError paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      if ((arrayOfByte[1] & 0xFF) == 77) {
        paramString = "data:image/bmp;base64,";
      } else {
        label225:
        if (((arrayOfByte[0] & 0xFF) == 137) && ((arrayOfByte[1] & 0xFF) == 80)) {
          paramString = "data:image/png;base64,";
        }
      }
    }
  }
  
  private String c(String paramString1, String paramString2)
  {
    return ThreeDes.b(paramString1, paramString2);
  }
  
  public static void deleteAllH5Data(AppInterface paramAppInterface)
  {
    EntityManager localEntityManager = paramAppInterface.a(paramAppInterface.getAccount()).createEntityManager();
    Object localObject1 = localEntityManager.a(CouponH5Data.class);
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (CouponH5Data)((Iterator)localObject1).next();
        localObject2 = new File(d + "/" + HexUtil.b(paramAppInterface.getAccount()) + "/" + ((CouponH5Data)localObject2).mHost);
        if (((File)localObject2).exists()) {
          FileUtil.a((File)localObject2);
        }
      }
    }
    localEntityManager.a(CouponH5Data.class);
    localEntityManager.a();
  }
  
  protected String a()
  {
    return "publicAccount";
  }
  
  /* Error */
  protected String a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 119	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   4: invokevirtual 124	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   7: astore 6
    //   9: aload 6
    //   11: ifnonnull +7 -> 18
    //   14: ldc_w 639
    //   17: areturn
    //   18: ldc_w 641
    //   21: astore 4
    //   23: new 160	org/json/JSONObject
    //   26: dup
    //   27: aload_2
    //   28: invokespecial 169	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   31: astore 5
    //   33: aload 5
    //   35: astore_3
    //   36: invokestatic 646	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   39: ifeq +32 -> 71
    //   42: ldc 13
    //   44: iconst_2
    //   45: new 65	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   52: ldc_w 648
    //   55: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload_2
    //   59: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokestatic 651	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   68: aload 5
    //   70: astore_3
    //   71: new 653	android/os/Bundle
    //   74: dup
    //   75: invokespecial 654	android/os/Bundle:<init>	()V
    //   78: astore 5
    //   80: aload 5
    //   82: ldc_w 656
    //   85: ldc_w 658
    //   88: invokevirtual 661	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   91: aload 4
    //   93: astore_2
    //   94: aload_3
    //   95: ifnull +33 -> 128
    //   98: aload 4
    //   100: astore_2
    //   101: aload_3
    //   102: ldc_w 663
    //   105: invokevirtual 666	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   108: ifeq +20 -> 128
    //   111: aload_3
    //   112: ldc_w 663
    //   115: invokevirtual 195	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   118: astore_2
    //   119: aload_2
    //   120: invokevirtual 669	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   123: astore 4
    //   125: aload 4
    //   127: astore_2
    //   128: aload_3
    //   129: ifnull +70 -> 199
    //   132: aload_3
    //   133: ldc_w 671
    //   136: invokevirtual 666	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   139: ifeq +60 -> 199
    //   142: aload_3
    //   143: ldc_w 671
    //   146: invokevirtual 178	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   149: astore_3
    //   150: aload_3
    //   151: invokevirtual 674	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   154: astore 4
    //   156: aload 4
    //   158: invokeinterface 305 1 0
    //   163: ifeq +36 -> 199
    //   166: aload 4
    //   168: invokeinterface 309 1 0
    //   173: invokevirtual 677	java/lang/Object:toString	()Ljava/lang/String;
    //   176: astore 7
    //   178: aload 5
    //   180: aload 7
    //   182: aload_3
    //   183: aload 7
    //   185: invokevirtual 195	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   188: invokevirtual 661	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   191: goto -35 -> 156
    //   194: astore_3
    //   195: aload_3
    //   196: invokevirtual 678	org/json/JSONException:printStackTrace	()V
    //   199: aload 6
    //   201: invokevirtual 129	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   204: astore_3
    //   205: new 65	java/lang/StringBuilder
    //   208: dup
    //   209: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   212: ldc_w 680
    //   215: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: aload_3
    //   219: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: astore_3
    //   226: new 653	android/os/Bundle
    //   229: dup
    //   230: invokespecial 654	android/os/Bundle:<init>	()V
    //   233: astore 4
    //   235: aload 4
    //   237: ldc_w 682
    //   240: aload_3
    //   241: invokevirtual 661	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   244: aload_0
    //   245: getfield 446	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   248: invokevirtual 686	android/app/Activity:getApplicationContext	()Landroid/content/Context;
    //   251: aload_1
    //   252: aload_2
    //   253: aload 5
    //   255: aload 4
    //   257: invokestatic 691	com/tencent/biz/common/util/HttpUtil:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Landroid/os/Bundle;)Ljava/lang/String;
    //   260: astore_1
    //   261: aload_1
    //   262: areturn
    //   263: astore 4
    //   265: ldc_w 641
    //   268: astore_2
    //   269: aload 4
    //   271: invokevirtual 678	org/json/JSONException:printStackTrace	()V
    //   274: goto -146 -> 128
    //   277: astore_1
    //   278: aload_1
    //   279: invokevirtual 692	org/apache/http/client/ClientProtocolException:printStackTrace	()V
    //   282: ldc_w 694
    //   285: areturn
    //   286: astore_1
    //   287: aload_1
    //   288: invokevirtual 601	java/io/IOException:printStackTrace	()V
    //   291: ldc_w 696
    //   294: areturn
    //   295: astore 4
    //   297: goto -28 -> 269
    //   300: astore_2
    //   301: aconst_null
    //   302: astore_3
    //   303: goto -232 -> 71
    //   306: astore_2
    //   307: aload 5
    //   309: astore_3
    //   310: goto -239 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	313	0	this	PublicAccountJavascriptInterface
    //   0	313	1	paramString1	String
    //   0	313	2	paramString2	String
    //   35	148	3	localObject1	Object
    //   194	2	3	localJSONException1	JSONException
    //   204	106	3	localObject2	Object
    //   21	235	4	localObject3	Object
    //   263	7	4	localJSONException2	JSONException
    //   295	1	4	localJSONException3	JSONException
    //   31	277	5	localObject4	Object
    //   7	193	6	localAppInterface	AppInterface
    //   176	8	7	str	String
    // Exception table:
    //   from	to	target	type
    //   132	156	194	org/json/JSONException
    //   156	191	194	org/json/JSONException
    //   101	119	263	org/json/JSONException
    //   244	261	277	org/apache/http/client/ClientProtocolException
    //   244	261	286	java/io/IOException
    //   119	125	295	org/json/JSONException
    //   23	33	300	org/json/JSONException
    //   36	68	306	org/json/JSONException
  }
  
  public void a(String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new hpp(this, paramString1, paramString2, paramJSONObject));
      return;
    }
    b(paramString1, paramString2, paramJSONObject);
  }
  
  public void a(String paramString1, String paramString2, JSONObject paramJSONObject, String paramString3)
  {
    AppInterface localAppInterface;
    Object localObject2;
    Object localObject1;
    try
    {
      localAppInterface = this.mRuntime.a();
      if (localAppInterface == null) {
        return;
      }
      localObject2 = new JSONObject(paramString1);
      localObject1 = ((JSONObject)localObject2).optString("callid");
      paramString1 = (String)localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        paramString1 = ((String)localObject1).replace("\\", "\\\\").replace("'", "\\'");
      }
      paramJSONObject.put("callid", paramString1);
      localObject1 = ((JSONObject)localObject2).optString("path");
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        callJs(paramString2, new String[] { "{ret:-6, response:" + paramJSONObject.toString() + "}" });
        return;
      }
    }
    catch (JSONException paramString1)
    {
      callJs(paramString2, new String[] { "{ret:-2, response:" + paramJSONObject.toString() + "}" });
      return;
    }
    paramString1 = null;
    try
    {
      paramString3 = new URL(paramString3).getHost();
      paramString1 = paramString3;
    }
    catch (MalformedURLException paramString3)
    {
      for (;;) {}
    }
    paramString3 = ((JSONObject)localObject2).optString("host");
    if (!TextUtils.isEmpty(paramString3))
    {
      if (a(paramString3, paramString1))
      {
        paramString1 = paramString3;
        paramString3 = paramString1;
        if (TextUtils.isEmpty(paramString1)) {
          paramString3 = "defaulthost";
        }
        localObject2 = ((JSONObject)localObject2).optString("key");
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          callJs(paramString2, new String[] { "{ret:-7, response:" + paramJSONObject.toString() + "}" });
        }
      }
      else
      {
        callJs(paramString2, new String[] { "{ret:-5, response:" + paramJSONObject.toString() + "}" });
        return;
      }
      paramString1 = a(paramString3, (String)localObject1, (String)localObject2);
      if (TextUtils.isEmpty(paramString1))
      {
        callJs(paramString2, new String[] { "{ret:-11, response:" + paramJSONObject.toString() + "}" });
        return;
      }
      localObject1 = new File(d + "/" + HexUtil.b(localAppInterface.getAccount()) + "/" + paramString3 + "/" + HexUtil.b((String)localObject1) + "/" + HexUtil.b((String)localObject2));
      if (!((File)localObject1).exists())
      {
        callJs(paramString2, new String[] { "{ret:-11, response:" + paramJSONObject.toString() + "}" });
        return;
      }
      try
      {
        try
        {
          paramString3 = new FileInputStream((File)localObject1);
          localObject1 = new byte[(int)((File)localObject1).length()];
          paramString3.read((byte[])localObject1);
          localObject1 = new String((byte[])localObject1);
          paramString3.close();
          paramString1 = c((String)localObject1, paramString1);
          if (paramString1 == null)
          {
            callJs(paramString2, new String[] { "{ret:-11, response:" + paramJSONObject.toString() + "}" });
            return;
          }
        }
        finally {}
        paramJSONObject.put("data", paramString1.replace("\\", "\\\\").replace("'", "\\'"));
      }
      catch (IOException paramString1)
      {
        callJs(paramString2, new String[] { "{ret:-9, response:" + paramJSONObject.toString() + "}" });
        return;
      }
      callJs(paramString2, new String[] { "{ret:0, response:" + paramJSONObject.toString() + "}" });
      return;
    }
  }
  
  public void close()
  {
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
  
  public void deleteH5Data(String paramString1, String paramString2)
  {
    CustomWebView localCustomWebView = this.mRuntime.a();
    if (localCustomWebView == null) {}
    AppInterface localAppInterface;
    do
    {
      return;
      localAppInterface = this.mRuntime.a();
    } while (localAppInterface == null);
    JSONObject localJSONObject1 = new JSONObject();
    if (TextUtils.isEmpty(paramString1))
    {
      callJs(paramString2, new String[] { "{ret:-3, response:" + localJSONObject1.toString() + "}" });
      return;
    }
    JSONObject localJSONObject2;
    String str2;
    try
    {
      localJSONObject2 = new JSONObject(paramString1);
      str1 = localJSONObject2.optString("callid");
      paramString1 = str1;
      if (!TextUtils.isEmpty(str1)) {
        paramString1 = str1.replace("\\", "\\\\").replace("'", "\\'");
      }
      localJSONObject1.put("callid", paramString1);
      str2 = localJSONObject2.optString("path");
      if (TextUtils.isEmpty(str2))
      {
        callJs(paramString2, new String[] { "{ret:-6, response:" + localJSONObject1.toString() + "}" });
        return;
      }
    }
    catch (JSONException paramString1)
    {
      callJs(paramString2, new String[] { "{ret:-2, response:" + localJSONObject1.toString() + "}" });
      return;
    }
    String str3 = localJSONObject2.optString("key");
    paramString1 = null;
    try
    {
      str1 = new URL(localCustomWebView.getUrl()).getHost();
      paramString1 = str1;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;) {}
    }
    String str1 = localJSONObject2.optString("host");
    if (!TextUtils.isEmpty(str1))
    {
      if (a(str1, paramString1))
      {
        paramString1 = str1;
        str1 = paramString1;
        if (TextUtils.isEmpty(paramString1)) {
          str1 = "defaulthost";
        }
        if (!TextUtils.isEmpty(str3)) {
          break label489;
        }
        a(str1, str2);
        FileUtil.a(new File(d + "/" + HexUtil.b(localAppInterface.getAccount()) + "/" + str1 + "/" + HexUtil.b(str2)));
      }
      for (;;)
      {
        callJs(paramString2, new String[] { "{ret:0, response:" + localJSONObject1.toString() + "}" });
        return;
        callJs(paramString2, new String[] { "{ret:-5, response:" + localJSONObject1.toString() + "}" });
        return;
        label489:
        a(str1, str2, str3);
        FileUtil.a(new File(d + "/" + HexUtil.b(localAppInterface.getAccount()) + "/" + str1 + "/" + HexUtil.b(str2) + "/" + HexUtil.b(str3)));
      }
    }
  }
  
  public void deleteH5DataByHost(String paramString1, String paramString2)
  {
    CustomWebView localCustomWebView = this.mRuntime.a();
    if (localCustomWebView == null) {}
    AppInterface localAppInterface;
    do
    {
      return;
      localAppInterface = this.mRuntime.a();
    } while (localAppInterface == null);
    JSONObject localJSONObject1 = new JSONObject();
    if (TextUtils.isEmpty(paramString1))
    {
      callJs(paramString2, new String[] { "{ret:-3, response:" + localJSONObject1.toString() + "}" });
      return;
    }
    try
    {
      localJSONObject2 = new JSONObject(paramString1);
      str = localJSONObject2.optString("callid");
      paramString1 = str;
      if (!TextUtils.isEmpty(str)) {
        paramString1 = str.replace("\\", "\\\\").replace("'", "\\'");
      }
      localJSONObject1.put("callid", paramString1);
      paramString1 = null;
    }
    catch (JSONException paramString1)
    {
      JSONObject localJSONObject2;
      String str;
      label166:
      label192:
      callJs(paramString2, new String[] { "{ret:-2, response:" + localJSONObject1.toString() + "}" });
      return;
    }
    try
    {
      str = new URL(localCustomWebView.getUrl()).getHost();
      paramString1 = str;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      break label166;
      break label192;
    }
    str = localJSONObject2.optString("host");
    if (!TextUtils.isEmpty(str))
    {
      if (a(str, paramString1))
      {
        paramString1 = str;
        str = paramString1;
        if (TextUtils.isEmpty(paramString1)) {
          str = "defaulthost";
        }
        a(str);
        FileUtil.a(new File(d + "/" + HexUtil.b(localAppInterface.getAccount()) + "/" + str));
        callJs(paramString2, new String[] { "{ret:0, response:" + localJSONObject1.toString() + "}" });
        return;
      }
      callJs(paramString2, new String[] { "{ret:-5, response:" + localJSONObject1.toString() + "}" });
      return;
    }
  }
  
  public void enableScreenshot(String paramString)
  {
    SwiftBrowserShareMenuHandler localSwiftBrowserShareMenuHandler = (SwiftBrowserShareMenuHandler)super.getBrowserComponent(4);
    if (localSwiftBrowserShareMenuHandler != null)
    {
      if ("1".equals(paramString)) {
        localSwiftBrowserShareMenuHandler.f();
      }
    }
    else {
      return;
    }
    localSwiftBrowserShareMenuHandler.g();
  }
  
  public void getJson(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((paramString1 == null) || (paramString1.equals(""))) {
      callJs("clientCallback", new String[] { Util.b("{'r': -102, 'msg': 'url empty'}"), Util.b(paramString4) });
    }
    while ((this.mRuntime.a() == null) || (this.jdField_a_of_type_AndroidAppActivity == null) || (this.jdField_a_of_type_AndroidAppActivity.isFinishing())) {
      return;
    }
    paramString3 = new PublicAccountJavascriptInterface.HttpTask(this, paramString4);
    paramString3.execute(new String[] { paramString1, paramString2 });
    this.jdField_a_of_type_JavaUtilList.add(paramString3);
  }
  
  public void getLocation(String paramString)
  {
    long l1 = 0L;
    if (this.mRuntime.a() == null) {}
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_AndroidAppActivity == null) || (this.jdField_a_of_type_AndroidAppActivity.isFinishing()));
      if (paramString.charAt(0) == '{') {}
      for (;;)
      {
        try
        {
          Object localObject = new JSONObject(paramString);
          paramString = ((JSONObject)localObject).getString("callback");
          l1 = ((JSONObject)localObject).optLong("allowCacheTime", 0L) * 1000L;
          bool = ((JSONObject)localObject).optBoolean("is_for_ecshop_map");
          if (!bool) {
            break;
          }
          localObject = this.mRuntime.a();
          if (localObject == null) {
            break;
          }
          String str = ((AppInterface)localObject).getAccount();
          if (TextUtils.isEmpty(str)) {
            break;
          }
          localObject = ((AppInterface)localObject).a().getSharedPreferences(str, 0);
          double d1 = ((SharedPreferences)localObject).getFloat("search_lbs_logitude", 0.0F);
          double d2 = ((SharedPreferences)localObject).getFloat("search_lbs_latitude", 0.0F);
          if (QLog.isColorLevel()) {
            QLog.i("EcShopAssistantActivity", 2, String.format("'longitude:%1$1.15f,latitude:%2$1.15f'", new Object[] { Double.valueOf(d1), Double.valueOf(d2) }));
          }
          callJs(paramString, new String[] { String.format("'%1$1.15f,%2$1.15f'", new Object[] { Double.valueOf(d1), Double.valueOf(d2) }) });
          return;
        }
        catch (JSONException paramString)
        {
          paramString.printStackTrace();
          return;
        }
        boolean bool = false;
      }
    } while (TextUtils.isEmpty(paramString));
    SosoInterface.a(new PublicAccountJavascriptInterface.TimedOnLocationListener(this, 0, paramString, l1));
  }
  
  public int getNetworkState()
  {
    return NetworkUtil.b(BaseApplication.getContext());
  }
  
  public String getNetworkType()
  {
    NetworkInfo localNetworkInfo = AppNetConnInfo.getRecentNetworkInfo();
    if (localNetworkInfo != null)
    {
      switch (localNetworkInfo.getType())
      {
      default: 
        return "other";
      case 1: 
        return "WiFi";
      }
      String str;
      switch (localNetworkInfo.getSubtype())
      {
      case 7: 
      case 10: 
      case 11: 
      default: 
        str = "other_";
      }
      for (;;)
      {
        return str + localNetworkInfo.getExtraInfo();
        str = "CDMA_";
        continue;
        str = "EDGE_";
        continue;
        str = "GPRS";
        continue;
        str = "EVDO_0_";
        continue;
        str = "EVDO_A_";
        continue;
        str = "EVDO_B_";
        continue;
        str = "UMTS_";
        continue;
        str = "HSUPA_";
        continue;
        str = "HSDPA_";
      }
    }
    return "empty";
  }
  
  public void getPageLoadStamp(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebUiMethodInterface != null)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebUiMethodInterface.getCurrentUrl())) {}
      for (String str = this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebUiMethodInterface.getCurrentUrl();; str = "")
      {
        if (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebviewReportSpeedInterface != null) {
          callJs(paramString, new String[] { "{ret:0, onCreateTime:" + this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebviewReportSpeedInterface.b() + ", startLoadUrlTime:" + this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebviewReportSpeedInterface.a() + ", url:'" + str + "'}" });
        }
        return;
      }
    }
    callJs(paramString, new String[] { "{ret: -1}" });
  }
  
  public void getRealLocation(String paramString1, String paramString2)
  {
    a(false, paramString1, paramString2);
  }
  
  public void getRealLocationDes(String paramString1, String paramString2)
  {
    a(true, paramString1, paramString2);
  }
  
  public void getUrlImage(String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    if (!TextUtils.isEmpty(paramString1))
    {
      new hpn(this, paramString1, localJSONObject, paramString2).start();
      return;
    }
    callJs(paramString2, new String[] { "{ret:-3, response:" + localJSONObject.toString() + "}" });
  }
  
  public void gotoKandian()
  {
    gotoKandian(null, null);
  }
  
  public void gotoKandian(String paramString)
  {
    gotoKandian(paramString, null);
  }
  
  public void gotoKandian(String paramString1, String paramString2)
  {
    paramString1 = new Intent(this.jdField_a_of_type_AndroidAppActivity, ReadInJoyFeedsActivity.class);
    paramString1.setFlags(67108864);
    paramString1.putExtra("from_javascript", true);
    this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString1);
  }
  
  public void hideLoading()
  {
    Object localObject = this.mRuntime.a(this.mRuntime.a());
    if ((localObject != null) && ((localObject instanceof WebUiUtils.WebProgressInterface))) {
      ((WebUiUtils.WebProgressInterface)localObject).a();
    }
    do
    {
      return;
      localObject = (SwiftBrowserUIStyleHandler)super.getBrowserComponent(2);
    } while ((localObject == null) || (((SwiftBrowserUIStyleHandler)localObject).a == null));
    ((SwiftBrowserUIStyleHandler)localObject).a.setVisibility(8);
  }
  
  public void isFollowUin(String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    if (TextUtils.isEmpty(paramString1)) {
      callJs(paramString2, new String[] { "{ret:-3, response:" + localJSONObject.toString() + "}" });
    }
    for (;;)
    {
      return;
      localObject = this.mRuntime.a();
      if (localObject != null) {
        try
        {
          paramString1 = new JSONObject(paramString1).optString("uin");
          if (!TextUtils.isEmpty(paramString1)) {
            if (((localObject instanceof BrowserAppInterface)) || (localObject.getClass().getSimpleName().equalsIgnoreCase("ReadInJoyInterfaceProxy")))
            {
              ThreadManager.b(new hpk(this, (AppInterface)localObject, paramString1, localJSONObject, paramString2));
              return;
            }
          }
        }
        catch (JSONException paramString1)
        {
          callJs(paramString2, new String[] { "{ret:-2, response:" + localJSONObject.toString() + "}" });
          return;
        }
      }
    }
    Object localObject = (PublicAccountDataManager)((AppInterface)localObject).getManager(55);
    if (localObject != null) {}
    for (boolean bool = ((PublicAccountDataManager)localObject).a(Long.valueOf(paramString1));; bool = false)
    {
      localJSONObject.put("follow", bool);
      callJs(paramString2, new String[] { "{ret:0, response:" + localJSONObject.toString() + "}" });
      return;
    }
  }
  
  public void officalAccountShareRichMsg2QQ(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      String str4 = ((JSONObject)localObject).getString("oaUin");
      String str5 = ((JSONObject)localObject).getString("title");
      String str6 = ((JSONObject)localObject).getString("summary");
      String str7 = ((JSONObject)localObject).getString("targetUrl");
      paramString = "";
      if (((JSONObject)localObject).has("imageUrl")) {
        paramString = ((JSONObject)localObject).getString("imageUrl");
      }
      String str1 = "";
      if (((JSONObject)localObject).has("sourceName")) {
        str1 = ((JSONObject)localObject).getString("sourceName");
      }
      String str2 = "false";
      if (((JSONObject)localObject).has("needback")) {
        str2 = ((JSONObject)localObject).getString("needback");
      }
      String str3 = "";
      if (((JSONObject)localObject).has("callback")) {
        str3 = ((JSONObject)localObject).getString("callback");
      }
      localObject = this.mRuntime.a(this.mRuntime.a());
      if ((localObject != null) && ((localObject instanceof WebUiUtils.WebFeaturesInterface))) {
        ((WebUiUtils.WebFeaturesInterface)localObject).a(str4, str5, str6, str7, paramString, str1, str2, str3);
      }
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_sys_30", "share_click", 0, 0, str4, "", "", "");
      return;
    }
    catch (JSONException paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(getClass().getSimpleName(), 2, paramString.getMessage());
    }
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_AndroidAppActivity = this.mRuntime.a();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    if (b == 0L) {
      ThreadManager.d(new hpj(this));
    }
    WebUiBaseInterface localWebUiBaseInterface = this.mRuntime.a(this.mRuntime.a());
    if ((localWebUiBaseInterface != null) && ((localWebUiBaseInterface instanceof WebUiUtils.WebUiMethodInterface))) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebUiMethodInterface = ((WebUiUtils.WebUiMethodInterface)localWebUiBaseInterface);
    }
    localWebUiBaseInterface = this.mRuntime.a(this.mRuntime.a());
    if ((localWebUiBaseInterface != null) && ((localWebUiBaseInterface instanceof WebUiUtils.WebviewReportSpeedInterface))) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebviewReportSpeedInterface = ((WebUiUtils.WebviewReportSpeedInterface)localWebUiBaseInterface);
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      PublicAccountJavascriptInterface.HttpTask localHttpTask = (PublicAccountJavascriptInterface.HttpTask)localIterator.next();
      if (!localHttpTask.isCancelled()) {
        localHttpTask.cancel(true);
      }
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList = null;
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidAppActivity.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    }
    super.onDestroy();
  }
  
  public void open(String paramString)
  {
    if ("com.tencent.mobileqq.activity.ChatBubbleSettingActivity".equals(paramString))
    {
      VasWebviewUtil.openQQBrowserWithoutAD(this.jdField_a_of_type_AndroidAppActivity, IndividuationUrlHelper.a(this.jdField_a_of_type_AndroidAppActivity, "bubble", ""), 64L, null, false, -1);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setComponent(new ComponentName(this.jdField_a_of_type_AndroidAppActivity, paramString));
    this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
  }
  
  public void openEmoji()
  {
    AppInterface localAppInterface = this.mRuntime.a();
    if (localAppInterface == null) {
      return;
    }
    EmojiHomeUiPlugin.openEmojiHomePage(this.jdField_a_of_type_AndroidAppActivity, localAppInterface.getAccount(), 2);
  }
  
  public void openInExternalBrowser(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PAjs", 2, "openInExternalBrowser:" + paramString);
    }
    if (paramString != null) {
      paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    }
    try
    {
      Thread.sleep(200L);
      this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString);
      return;
    }
    catch (Exception paramString) {}catch (ActivityNotFoundException paramString) {}
  }
  
  public void openUrl(String paramString)
  {
    Object localObject;
    Intent localIntent;
    if (paramString != null)
    {
      localObject = this.jdField_a_of_type_AndroidAppActivity.getIntent();
      localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getClass());
      localObject = ((Intent)localObject).getExtras();
      if (localObject != null) {
        break label80;
      }
      localObject = new Bundle();
    }
    for (;;)
    {
      localIntent.putExtras((Bundle)localObject);
      localIntent.putExtra("url", paramString);
      localIntent.setFlags(0);
      this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(localIntent, 100);
      return;
      label80:
      ((Bundle)localObject).remove("title");
      ((Bundle)localObject).remove("leftViewText");
      ((Bundle)localObject).remove("post_data");
      ((Bundle)localObject).remove("options");
    }
  }
  
  public void pbReport(String paramString1, String paramString2)
  {
    AppInterface localAppInterface = this.mRuntime.a();
    if (localAppInterface == null) {
      return;
    }
    CouponProto.ReportReq localReportReq = new CouponProto.ReportReq();
    try
    {
      int m = Integer.parseInt(paramString1);
      localReportReq.type.set(m);
      localReportReq.data.set(paramString2);
      paramString1 = new NewIntent(this.jdField_a_of_type_AndroidAppActivity, ProtoServlet.class);
      paramString1.putExtra("cmd", "CouponSvr.report");
      paramString1.putExtra("data", localReportReq.toByteArray());
      localAppInterface.startServlet(paramString1);
      return;
    }
    catch (NumberFormatException paramString1)
    {
      for (;;)
      {
        localReportReq.type.set(0);
      }
    }
  }
  
  public void readH5Data(String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    if (TextUtils.isEmpty(paramString1)) {
      callJs(paramString2, new String[] { "{ret:-3, response:" + localJSONObject.toString() + "}" });
    }
    CustomWebView localCustomWebView;
    do
    {
      return;
      localCustomWebView = this.mRuntime.a();
    } while (localCustomWebView == null);
    new Thread(new hps(this, paramString1, paramString2, localJSONObject, localCustomWebView.getUrl())).start();
  }
  
  public void setNavigationBarStyle(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Activity localActivity;
    do
    {
      return;
      localActivity = this.mRuntime.a();
    } while (!(localActivity instanceof QQBrowserActivity));
    try
    {
      switch (new JSONObject(paramString).optInt("style"))
      {
      case 0: 
        ((QQBrowserActivity)localActivity).a.a(false);
        return;
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      return;
    }
    ((QQBrowserActivity)localActivity).a.a(true);
    return;
  }
  
  public void setReadTime(String paramString)
  {
    TroopMemberApiClient localTroopMemberApiClient = TroopMemberApiClient.a();
    localTroopMemberApiClient.a();
    localTroopMemberApiClient.f(paramString);
  }
  
  public void setRightButton(String paramString1, String paramString2, String paramString3)
  {
    ((AbsBaseWebViewActivity)this.jdField_a_of_type_AndroidAppActivity).a(paramString3, paramString1, paramString2, false, 0, 0, null, null);
  }
  
  @Deprecated
  public void showDialog(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    boolean bool1 = "true".equals(paramString3);
    boolean bool2 = "true".equals(paramString4);
    paramString3 = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 0);
    paramString3.setTitle(paramString1);
    paramString3.setMessage(paramString2);
    paramString1 = new hpm(this, paramString6, paramString5);
    if (bool2) {
      paramString3.setNegativeButton("取消", paramString1);
    }
    if (bool1) {
      paramString3.setPositiveButton("确定", paramString1);
    }
    try
    {
      paramString3.show();
      return;
    }
    catch (Exception paramString1) {}
  }
  
  public void showLoading()
  {
    Object localObject = this.mRuntime.a(this.mRuntime.a());
    if ((localObject != null) && ((localObject instanceof WebUiUtils.WebProgressInterface))) {
      ((WebUiUtils.WebProgressInterface)localObject).b();
    }
    do
    {
      return;
      localObject = (SwiftBrowserUIStyleHandler)super.getBrowserComponent(2);
    } while ((localObject == null) || (((SwiftBrowserUIStyleHandler)localObject).a == null));
    ((SwiftBrowserUIStyleHandler)localObject).a.setVisibility(0);
  }
  
  public void showProfile(String paramString)
  {
    int m = 0;
    if (paramString == null) {
      return;
    }
    String str = paramString.trim();
    paramString = "";
    if (str.startsWith("{")) {}
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(str);
        str = ((JSONObject)localObject).getString("uin");
        int i1 = ((JSONObject)localObject).optInt("uinType", 0);
        n = ((JSONObject)localObject).optInt("isFinish", 0);
        if ("groupSearchOther".equals(((JSONObject)localObject).optString("jump_from")))
        {
          paramString = "group";
          m = ((JSONObject)localObject).optInt("subSourceID");
          if ((str == null) || (str.length() < 5)) {
            break;
          }
          localObject = this.mRuntime.a();
          paramString = "mqq://card/show_pslcard/?uin=" + str + "&card_type=" + paramString + "&wSourceSubID=" + m;
          if (!(localObject instanceof QQAppInterface)) {
            break label270;
          }
          JumpParser.a((QQAppInterface)localObject, this.jdField_a_of_type_AndroidAppActivity, paramString).b();
          if (n != 1) {
            break;
          }
          paramString = new IntentFilter();
          paramString.addAction("start_recomend_page");
          this.jdField_a_of_type_AndroidAppActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramString);
          this.jdField_a_of_type_Boolean = true;
          return;
        }
        if (i1 != 1) {
          continue;
        }
        paramString = "group";
        m = ((JSONObject)localObject).optInt("wSourceSubID");
        continue;
        if (!QLog.isDevelopLevel()) {
          break;
        }
      }
      catch (JSONException paramString) {}
      QLog.d("PAjs", 4, "showProfile param error");
      return;
      paramString = "";
      m = 0;
      int n = 0;
      continue;
      label270:
      this.jdField_a_of_type_AndroidAppActivity.startActivity(new Intent(this.jdField_a_of_type_AndroidAppActivity, JumpActivity.class).setData(Uri.parse(paramString)));
    }
  }
  
  public void viewAccount(String paramString)
  {
    viewAccount(paramString, "false");
  }
  
  public void viewAccount(String paramString1, String paramString2)
  {
    Object localObject1 = null;
    if (TextUtils.isEmpty(paramString1)) {}
    AppInterface localAppInterface;
    do
    {
      return;
      localAppInterface = this.mRuntime.a();
    } while (localAppInterface == null);
    if ((localAppInterface instanceof BrowserAppInterface))
    {
      localObject1 = ((BrowserAppInterface)localAppInterface).a(null).createEntityManager();
      if (localObject1 == null) {
        break label277;
      }
      localObject1 = (PublicAccountInfo)((EntityManager)localObject1).a(PublicAccountInfo.class, "uin = ?", new String[] { paramString1 });
    }
    for (;;)
    {
      Object localObject2 = this.jdField_a_of_type_AndroidAppActivity;
      if ((this.jdField_a_of_type_AndroidAppActivity instanceof BasePluginActivity)) {
        localObject2 = ((BasePluginActivity)this.jdField_a_of_type_AndroidAppActivity).getOutActivity();
      }
      if ((localObject1 != null) && ("true".equals(paramString2)))
      {
        paramString2 = new Intent((Context)localObject2, ChatActivity.class);
        paramString2.putExtra("uin", paramString1);
        paramString2.putExtra("uintype", 1008);
        paramString2.putExtra("uinname", ((PublicAccountInfo)localObject1).name);
        ((Activity)localObject2).startActivity(paramString2);
      }
      for (;;)
      {
        PublicAccountHandler.a(localAppInterface, paramString1, "Pb_account_lifeservice", "mp_msg_sys_5", "addpage_hot");
        return;
        localObject2 = (PublicAccountDataManager)localAppInterface.getManager(55);
        if (localObject2 == null) {
          break;
        }
        localObject1 = ((PublicAccountDataManager)localObject2).b(paramString1);
        break;
        paramString2 = new Intent((Context)localObject2, AccountDetailActivity.class);
        paramString2.putExtra("uin", paramString1);
        paramString2.putExtra("report_src_param_type", "");
        paramString2.putExtra("report_src_param_name", "");
        paramString2.putExtra("fromBrowser", true);
        paramString2.setFlags(67108864);
        ((Activity)localObject2).startActivity(paramString2);
      }
      label277:
      localObject1 = null;
    }
  }
  
  public void viewAccount(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Object localObject1 = null;
    if (QLog.isColorLevel()) {
      QLog.d("PAjs", 2, "func viewAccount(****), sopType:" + paramString3 + ",sopName:" + paramString4);
    }
    if (TextUtils.isEmpty(paramString1)) {}
    AppInterface localAppInterface;
    do
    {
      return;
      localAppInterface = this.mRuntime.a();
    } while (localAppInterface == null);
    if ((localAppInterface instanceof BrowserAppInterface))
    {
      localObject1 = ((BrowserAppInterface)localAppInterface).a(null).createEntityManager();
      if (localObject1 == null) {
        break label317;
      }
      localObject1 = (PublicAccountInfo)((EntityManager)localObject1).a(PublicAccountInfo.class, "uin = ?", new String[] { paramString1 });
    }
    for (;;)
    {
      Object localObject2 = this.jdField_a_of_type_AndroidAppActivity;
      if (this.jdField_a_of_type_AndroidAppActivity.getClass().getName().equalsIgnoreCase("com.tencent.qqreadinjoy.detailspage.ReadInJoyArticleDetailActivity")) {
        localObject2 = ((PluginBaseActivity)this.jdField_a_of_type_AndroidAppActivity).getOutActivity();
      }
      if ((localObject1 != null) && ("true".equals(paramString2)))
      {
        paramString2 = new Intent((Context)localObject2, ChatActivity.class);
        paramString2.putExtra("uin", paramString1);
        paramString2.putExtra("uintype", 1008);
        paramString2.putExtra("uinname", ((PublicAccountInfo)localObject1).name);
        ((Activity)localObject2).startActivity(paramString2);
      }
      for (;;)
      {
        PublicAccountHandler.a(localAppInterface, paramString1, "Pb_account_lifeservice", "mp_msg_sys_5", "addpage_hot");
        return;
        localObject2 = (PublicAccountDataManager)localAppInterface.getManager(55);
        if (localObject2 == null) {
          break;
        }
        localObject1 = ((PublicAccountDataManager)localObject2).b(paramString1);
        break;
        paramString2 = new Intent((Context)localObject2, AccountDetailActivity.class);
        paramString2.putExtra("uin", paramString1);
        paramString2.putExtra("report_src_param_type", paramString3);
        paramString2.putExtra("report_src_param_name", paramString4);
        ((Activity)localObject2).startActivity(paramString2);
      }
      label317:
      localObject1 = null;
    }
  }
  
  public void writeH5Data(String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    if (TextUtils.isEmpty(paramString1))
    {
      callJs(paramString2, new String[] { "{ret:-3, response:" + localJSONObject.toString() + "}" });
      return;
    }
    ThreadManager.a(new hpo(this, paramString1, paramString2, localJSONObject), 5, null, false);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\PublicAccountJavascriptInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */