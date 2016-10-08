package com.tencent.mobileqq.activity.bless;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopBarShortVideoUploadUtil;
import com.tencent.mobileqq.troop.data.TroopBarShortVideoUploadUtil.ApplyUploadRsp;
import com.tencent.mobileqq.troop.data.TroopBarShortVideoUploadUtil.OnUploadVideoListener;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import cooperation.qzone.QZoneShareManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import mqq.manager.TicketManager;
import ofx;
import ofy;
import ofz;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class BlessResultActivity
  extends BaseActivity
  implements Handler.Callback, View.OnClickListener, WXShareHelper.WXShareListener
{
  private static final float jdField_a_of_type_Float = 0.48F;
  public static final int a = 1;
  static final long jdField_a_of_type_Long = 120000L;
  public static final String a = "param_method";
  public static final int b = 2;
  public static final String b = "param_count";
  static final int c = 1000;
  public static final String c = "param_snap_path";
  static final int d = 1001;
  public static final String d = "param_ptv_path";
  static final int e = 1002;
  public static final String e = "param_ptv_id";
  static final int f = 1003;
  public static final String f = "param_share_title";
  public static final String g = "mqq_activity";
  private static final String p = "BlessResultActivity";
  private static final String q = "bless_ptv_upload";
  private static final String r = "bless_ptv_path";
  private static final String s = "bless_vid";
  ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
  View jdField_a_of_type_AndroidViewView;
  private BlessManager jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager;
  public BlessResultActivity.VideoInfo a;
  TroopBarShortVideoUploadUtil.OnUploadVideoListener jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarShortVideoUploadUtil$OnUploadVideoListener;
  public MqqWeakReferenceHandler a;
  ofz jdField_a_of_type_Ofz;
  public boolean a;
  int g;
  int h;
  public String h;
  private int i;
  public String i;
  private int jdField_j_of_type_Int;
  String jdField_j_of_type_JavaLangString;
  public String k;
  public String l;
  String m;
  String n;
  String o;
  
  public BlessResultActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_h_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarShortVideoUploadUtil$OnUploadVideoListener = new ofy(this);
  }
  
  public static TroopBarShortVideoUploadUtil.ApplyUploadRsp a(Bundle paramBundle, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    String str1 = paramBundle.getString("title");
    String str2 = paramBundle.getString("tags");
    String str3 = paramBundle.getString("cat");
    String str4 = paramBundle.getString("file_path");
    String str5 = paramBundle.getString("vid");
    if (QLog.isColorLevel()) {
      QLog.d("BlessResultActivity", 2, "applyUpload title = " + str1 + ", tags = " + str2 + ", cat = " + str3 + ", filePath = " + str4 + ", size = " + FileUtils.a(str4));
    }
    if ((TextUtils.isEmpty(str4)) || (!FileUtils.a(str4)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("BlessResultActivity", 2, "!!!!!!!applyUpload filePath = " + str4);
      }
      paramString1 = null;
    }
    do
    {
      return paramString1;
      if (paramBoolean) {
        "http://c.v.qq.com/openfvupready?g_tk=".replaceFirst("http", "https");
      }
      paramBundle = new HttpPost("http://c.v.qq.com/openfvupready?g_tk=" + String.valueOf(TroopBarShortVideoUploadUtil.a(paramString2)));
      paramBundle.setHeader("Accept", "Accept text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
      paramBundle.setHeader("Accept-Charset", "utf-8;q=0.7,*;q=0.7");
      paramBundle.setHeader("Accept-Encoding", "gzip, deflate");
      paramBundle.setHeader("Accept-Language", "zh-cn,zh;q=0.5");
      paramBundle.setHeader("Connection", "close");
      paramBundle.setHeader("Cookie", "skey=" + paramString2 + ";uin=" + paramString1);
      paramBundle.setHeader("Referer", "http://c.v.qq.com");
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new BasicNameValuePair("bid", paramString3));
      localArrayList.add(new BasicNameValuePair("title", str1));
      localArrayList.add(new BasicNameValuePair("tags", str2));
      localArrayList.add(new BasicNameValuePair("cat", str3));
      localArrayList.add(new BasicNameValuePair("size", String.valueOf(FileUtils.a(str4))));
      localArrayList.add(new BasicNameValuePair("sha", HexUtil.a(FileManagerUtil.a(str4))));
      localArrayList.add(new BasicNameValuePair("md5", HexUtil.a(FileManagerUtil.c(str4))));
      if (QLog.isColorLevel()) {
        QLog.d("BlessResultActivity", 2, "applyUpload() getMessageDigest time = " + (System.currentTimeMillis() - l1));
      }
      localArrayList.add(new BasicNameValuePair("platform", "android"));
      localArrayList.add(new BasicNameValuePair("g_tk", String.valueOf(TroopBarShortVideoUploadUtil.a(paramString2))));
      localArrayList.add(new BasicNameValuePair("otype", "json"));
      if (!TextUtils.isEmpty(str5))
      {
        localArrayList.add(new BasicNameValuePair("vid", str5));
        localArrayList.add(new BasicNameValuePair("continue", "1"));
      }
      paramString1 = null;
      try
      {
        paramBundle.setEntity(new UrlEncodedFormEntity(localArrayList, "UTF-8"));
        paramBundle = new DefaultHttpClient().execute(paramBundle);
        if (paramBundle.getStatusLine().getStatusCode() != 200) {
          break;
        }
        paramBundle = EntityUtils.toString(paramBundle.getEntity());
        paramBundle = paramBundle.substring(paramBundle.indexOf("{"), paramBundle.lastIndexOf("}") + 1);
        if (QLog.isColorLevel()) {
          QLog.d("BlessResultActivity", 2, "applyUpload result = " + paramBundle);
        }
        paramBundle = new JSONObject(paramBundle);
        if (!paramBundle.optString("s", "f").equals("o")) {
          break;
        }
        paramBundle = new TroopBarShortVideoUploadUtil.ApplyUploadRsp(paramBundle);
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          paramBundle = paramString1;
          if (QLog.isColorLevel())
          {
            QLog.d("BlessResultActivity", 2, QLog.getStackTraceString(paramString2));
            paramBundle = paramString1;
            continue;
            paramBundle = null;
          }
        }
      }
      paramString1 = paramBundle;
    } while (!QLog.isColorLevel());
    QLog.d("BlessResultActivity", 2, "applyUpload time: " + (System.currentTimeMillis() - l1));
    return paramBundle;
  }
  
  /* Error */
  public static boolean a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    // Byte code:
    //   0: invokestatic 102	java/lang/System:currentTimeMillis	()J
    //   3: lstore 12
    //   5: aload_0
    //   6: invokestatic 162	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifne +10 -> 19
    //   12: aload_0
    //   13: invokestatic 165	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Z
    //   16: ifne +37 -> 53
    //   19: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   22: ifeq +29 -> 51
    //   25: ldc 47
    //   27: iconst_2
    //   28: new 126	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   35: ldc_w 364
    //   38: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: aload_0
    //   42: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 169	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   51: iconst_0
    //   52: ireturn
    //   53: aload_1
    //   54: invokestatic 162	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   57: ifne +10 -> 67
    //   60: aload_1
    //   61: invokestatic 165	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Z
    //   64: ifne +37 -> 101
    //   67: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   70: ifeq -19 -> 51
    //   73: ldc 47
    //   75: iconst_2
    //   76: new 126	java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   83: ldc_w 366
    //   86: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload_1
    //   90: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokestatic 169	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   99: iconst_0
    //   100: ireturn
    //   101: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   104: ifeq +94 -> 198
    //   107: ldc 47
    //   109: iconst_2
    //   110: new 126	java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   117: ldc_w 368
    //   120: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: aload_0
    //   124: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: ldc_w 370
    //   130: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: aload_1
    //   134: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: ldc_w 372
    //   140: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: aload_1
    //   144: invokestatic 146	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)J
    //   147: invokevirtual 149	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   150: ldc_w 374
    //   153: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: aload_2
    //   157: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: ldc_w 376
    //   163: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: aload_3
    //   167: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: ldc_w 378
    //   173: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: aload 4
    //   178: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: ldc_w 380
    //   184: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: aload 5
    //   189: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   198: invokestatic 386	java/util/UUID:randomUUID	()Ljava/util/UUID;
    //   201: invokevirtual 387	java/util/UUID:toString	()Ljava/lang/String;
    //   204: astore 8
    //   206: new 183	org/apache/http/client/methods/HttpPost
    //   209: dup
    //   210: new 126	java/lang/StringBuilder
    //   213: dup
    //   214: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   217: ldc_w 389
    //   220: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: aload_3
    //   224: invokestatic 188	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil:a	(Ljava/lang/String;)I
    //   227: invokestatic 192	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   230: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: invokespecial 195	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
    //   239: astore 7
    //   241: aload 7
    //   243: ldc -59
    //   245: ldc -57
    //   247: invokevirtual 203	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   250: aload 7
    //   252: ldc -51
    //   254: ldc -49
    //   256: invokevirtual 203	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   259: aload 7
    //   261: ldc -47
    //   263: ldc -45
    //   265: invokevirtual 203	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   268: aload 7
    //   270: ldc -43
    //   272: ldc -41
    //   274: invokevirtual 203	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   277: aload 7
    //   279: ldc -39
    //   281: ldc -37
    //   283: invokevirtual 203	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   286: aload 7
    //   288: ldc -35
    //   290: new 126	java/lang/StringBuilder
    //   293: dup
    //   294: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   297: ldc -33
    //   299: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: aload_3
    //   303: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: ldc -31
    //   308: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: aload_2
    //   312: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   318: invokevirtual 203	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   321: aload 7
    //   323: ldc -29
    //   325: ldc -27
    //   327: invokevirtual 203	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   330: aload 7
    //   332: ldc_w 391
    //   335: new 126	java/lang/StringBuilder
    //   338: dup
    //   339: ldc_w 393
    //   342: invokespecial 394	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   345: aload 8
    //   347: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   353: invokevirtual 203	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   356: new 106	android/os/Bundle
    //   359: dup
    //   360: invokespecial 395	android/os/Bundle:<init>	()V
    //   363: astore 9
    //   365: aload 9
    //   367: ldc -20
    //   369: aload 6
    //   371: invokevirtual 398	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   374: aload 9
    //   376: ldc 118
    //   378: aload 4
    //   380: invokevirtual 398	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   383: aload 9
    //   385: ldc_w 400
    //   388: aload 5
    //   390: invokevirtual 398	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   393: aload 9
    //   395: ldc -10
    //   397: aload_0
    //   398: invokestatic 146	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)J
    //   401: invokestatic 249	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   404: invokevirtual 398	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   407: aload 9
    //   409: ldc -5
    //   411: aload_0
    //   412: invokestatic 256	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Ljava/lang/String;)[B
    //   415: invokestatic 261	com/tencent/mobileqq/utils/HexUtil:a	([B)Ljava/lang/String;
    //   418: invokevirtual 398	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   421: aload 9
    //   423: ldc_w 263
    //   426: aload_0
    //   427: invokestatic 265	com/tencent/mobileqq/filemanager/util/FileManagerUtil:c	(Ljava/lang/String;)[B
    //   430: invokestatic 261	com/tencent/mobileqq/utils/HexUtil:a	([B)Ljava/lang/String;
    //   433: invokevirtual 398	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   436: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   439: ifeq +34 -> 473
    //   442: ldc 47
    //   444: iconst_2
    //   445: new 126	java/lang/StringBuilder
    //   448: dup
    //   449: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   452: ldc_w 402
    //   455: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: invokestatic 102	java/lang/System:currentTimeMillis	()J
    //   461: lload 12
    //   463: lsub
    //   464: invokevirtual 149	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   467: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   470: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   473: aload 9
    //   475: ldc_w 269
    //   478: ldc_w 271
    //   481: invokevirtual 398	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   484: aload 9
    //   486: ldc_w 273
    //   489: aload_3
    //   490: invokestatic 188	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil:a	(Ljava/lang/String;)I
    //   493: invokestatic 192	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   496: invokevirtual 398	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   499: aload 9
    //   501: ldc_w 275
    //   504: ldc_w 277
    //   507: invokevirtual 398	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   510: aload 9
    //   512: ldc_w 404
    //   515: ldc_w 406
    //   518: invokevirtual 398	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   521: aload 9
    //   523: ldc_w 408
    //   526: ldc_w 410
    //   529: invokevirtual 398	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   532: aload 9
    //   534: ldc_w 412
    //   537: ldc_w 414
    //   540: invokevirtual 398	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   543: aload 9
    //   545: ldc_w 416
    //   548: ldc_w 418
    //   551: invokevirtual 398	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   554: aload 9
    //   556: ldc_w 420
    //   559: ldc_w 422
    //   562: invokevirtual 398	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   565: aload 9
    //   567: ldc_w 424
    //   570: ldc_w 426
    //   573: invokevirtual 398	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   576: aload 9
    //   578: ldc_w 428
    //   581: ldc_w 430
    //   584: invokevirtual 398	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   587: aload 9
    //   589: ldc_w 432
    //   592: ldc_w 434
    //   595: invokevirtual 398	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   598: aload 9
    //   600: ldc_w 436
    //   603: ldc_w 438
    //   606: invokevirtual 398	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   609: aload 9
    //   611: ldc_w 440
    //   614: ldc_w 442
    //   617: invokevirtual 398	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   620: aload 9
    //   622: ldc_w 444
    //   625: ldc_w 442
    //   628: invokevirtual 398	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   631: aload 9
    //   633: ldc_w 446
    //   636: ldc_w 448
    //   639: invokevirtual 398	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   642: aload 9
    //   644: ldc_w 450
    //   647: ldc_w 452
    //   650: invokevirtual 398	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   653: aload 9
    //   655: ldc_w 454
    //   658: ldc_w 281
    //   661: invokevirtual 398	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   664: aload 9
    //   666: ldc_w 456
    //   669: ldc_w 458
    //   672: invokevirtual 398	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   675: aload 9
    //   677: ldc_w 460
    //   680: ldc_w 462
    //   683: invokevirtual 398	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   686: new 464	java/io/ByteArrayOutputStream
    //   689: dup
    //   690: invokespecial 465	java/io/ByteArrayOutputStream:<init>	()V
    //   693: astore 4
    //   695: aconst_null
    //   696: astore_3
    //   697: aconst_null
    //   698: astore_2
    //   699: new 467	java/io/File
    //   702: dup
    //   703: aload_1
    //   704: invokespecial 468	java/io/File:<init>	(Ljava/lang/String;)V
    //   707: astore 5
    //   709: aload_3
    //   710: astore_0
    //   711: aload 9
    //   713: invokevirtual 472	android/os/Bundle:keySet	()Ljava/util/Set;
    //   716: invokeinterface 478 1 0
    //   721: astore 6
    //   723: aload_3
    //   724: astore_0
    //   725: aload 6
    //   727: invokeinterface 483 1 0
    //   732: ifeq +460 -> 1192
    //   735: aload_3
    //   736: astore_0
    //   737: aload 6
    //   739: invokeinterface 487 1 0
    //   744: checkcast 177	java/lang/String
    //   747: astore 10
    //   749: aload_3
    //   750: astore_0
    //   751: aload 9
    //   753: aload 10
    //   755: invokevirtual 110	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   758: astore 11
    //   760: aload 11
    //   762: ifnull -39 -> 723
    //   765: aload_3
    //   766: astore_0
    //   767: aload 4
    //   769: new 126	java/lang/StringBuilder
    //   772: dup
    //   773: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   776: ldc_w 489
    //   779: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   782: ldc_w 491
    //   785: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   788: aload 8
    //   790: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   793: ldc_w 489
    //   796: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   799: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   802: invokevirtual 495	java/lang/String:getBytes	()[B
    //   805: invokevirtual 499	java/io/ByteArrayOutputStream:write	([B)V
    //   808: aload_3
    //   809: astore_0
    //   810: aload 4
    //   812: new 126	java/lang/StringBuilder
    //   815: dup
    //   816: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   819: ldc_w 501
    //   822: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   825: aload 10
    //   827: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   830: ldc_w 503
    //   833: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   836: ldc_w 489
    //   839: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   842: ldc_w 489
    //   845: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   848: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   851: invokevirtual 495	java/lang/String:getBytes	()[B
    //   854: invokevirtual 499	java/io/ByteArrayOutputStream:write	([B)V
    //   857: aload_3
    //   858: astore_0
    //   859: aload 4
    //   861: aload 11
    //   863: invokevirtual 495	java/lang/String:getBytes	()[B
    //   866: invokevirtual 499	java/io/ByteArrayOutputStream:write	([B)V
    //   869: goto -146 -> 723
    //   872: astore_0
    //   873: aload_2
    //   874: astore_1
    //   875: aload_0
    //   876: astore_2
    //   877: aload_1
    //   878: astore_0
    //   879: aload_2
    //   880: invokevirtual 506	java/io/IOException:printStackTrace	()V
    //   883: aload 4
    //   885: ifnull +8 -> 893
    //   888: aload 4
    //   890: invokevirtual 508	java/io/ByteArrayOutputStream:close	()V
    //   893: aload_1
    //   894: ifnull +654 -> 1548
    //   897: aload_1
    //   898: invokevirtual 511	java/io/FileInputStream:close	()V
    //   901: aconst_null
    //   902: astore_0
    //   903: new 513	org/apache/http/entity/ByteArrayEntity
    //   906: dup
    //   907: aload_0
    //   908: invokespecial 515	org/apache/http/entity/ByteArrayEntity:<init>	([B)V
    //   911: astore_0
    //   912: aload 7
    //   914: aload_0
    //   915: invokevirtual 292	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   918: new 517	org/apache/http/params/BasicHttpParams
    //   921: dup
    //   922: invokespecial 518	org/apache/http/params/BasicHttpParams:<init>	()V
    //   925: astore_0
    //   926: aload_0
    //   927: sipush 10000
    //   930: invokestatic 524	org/apache/http/params/HttpConnectionParams:setConnectionTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   933: aload_0
    //   934: sipush 10000
    //   937: invokestatic 527	org/apache/http/params/HttpConnectionParams:setSoTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   940: new 294	org/apache/http/impl/client/DefaultHttpClient
    //   943: dup
    //   944: aload_0
    //   945: invokespecial 530	org/apache/http/impl/client/DefaultHttpClient:<init>	(Lorg/apache/http/params/HttpParams;)V
    //   948: aload 7
    //   950: invokevirtual 299	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   953: astore_0
    //   954: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   957: ifeq +39 -> 996
    //   960: ldc 47
    //   962: iconst_2
    //   963: new 126	java/lang/StringBuilder
    //   966: dup
    //   967: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   970: ldc_w 532
    //   973: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   976: aload_0
    //   977: invokeinterface 305 1 0
    //   982: invokeinterface 311 1 0
    //   987: invokevirtual 535	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   990: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   993: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   996: aload_0
    //   997: invokeinterface 305 1 0
    //   1002: invokeinterface 311 1 0
    //   1007: sipush 200
    //   1010: if_icmpne +532 -> 1542
    //   1013: aload_0
    //   1014: invokeinterface 315 1 0
    //   1019: invokestatic 320	org/apache/http/util/EntityUtils:toString	(Lorg/apache/http/HttpEntity;)Ljava/lang/String;
    //   1022: astore_0
    //   1023: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1026: ifeq +29 -> 1055
    //   1029: ldc 47
    //   1031: iconst_2
    //   1032: new 126	java/lang/StringBuilder
    //   1035: dup
    //   1036: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   1039: ldc_w 537
    //   1042: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1045: aload_0
    //   1046: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1049: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1052: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1055: aload_0
    //   1056: aload_0
    //   1057: ldc_w 322
    //   1060: invokevirtual 325	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1063: aload_0
    //   1064: ldc_w 327
    //   1067: invokevirtual 330	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   1070: iconst_1
    //   1071: iadd
    //   1072: invokevirtual 334	java/lang/String:substring	(II)Ljava/lang/String;
    //   1075: astore_0
    //   1076: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1079: ifeq +29 -> 1108
    //   1082: ldc 47
    //   1084: iconst_2
    //   1085: new 126	java/lang/StringBuilder
    //   1088: dup
    //   1089: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   1092: ldc_w 539
    //   1095: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1098: aload_0
    //   1099: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1102: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1105: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1108: new 338	org/json/JSONObject
    //   1111: dup
    //   1112: aload_0
    //   1113: invokespecial 339	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1116: ldc_w 340
    //   1119: ldc_w 341
    //   1122: invokevirtual 344	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1125: ldc_w 345
    //   1128: invokevirtual 348	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1131: istore 14
    //   1133: iload 14
    //   1135: ifeq +407 -> 1542
    //   1138: iconst_1
    //   1139: istore 14
    //   1141: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1144: ifeq +45 -> 1189
    //   1147: ldc 47
    //   1149: iconst_2
    //   1150: new 126	java/lang/StringBuilder
    //   1153: dup
    //   1154: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   1157: ldc_w 541
    //   1160: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1163: invokestatic 102	java/lang/System:currentTimeMillis	()J
    //   1166: lload 12
    //   1168: lsub
    //   1169: invokevirtual 149	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1172: ldc_w 543
    //   1175: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1178: iload 14
    //   1180: invokevirtual 546	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1183: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1186: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1189: iload 14
    //   1191: ireturn
    //   1192: aload_3
    //   1193: astore_0
    //   1194: aload 4
    //   1196: new 126	java/lang/StringBuilder
    //   1199: dup
    //   1200: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   1203: ldc_w 489
    //   1206: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1209: ldc_w 491
    //   1212: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1215: aload 8
    //   1217: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1220: ldc_w 489
    //   1223: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1226: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1229: invokevirtual 495	java/lang/String:getBytes	()[B
    //   1232: invokevirtual 499	java/io/ByteArrayOutputStream:write	([B)V
    //   1235: aload_3
    //   1236: astore_0
    //   1237: aload 4
    //   1239: new 126	java/lang/StringBuilder
    //   1242: dup
    //   1243: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   1246: ldc_w 548
    //   1249: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1252: aload 5
    //   1254: invokevirtual 551	java/io/File:getName	()Ljava/lang/String;
    //   1257: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1260: ldc_w 503
    //   1263: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1266: ldc_w 489
    //   1269: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1272: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1275: invokevirtual 495	java/lang/String:getBytes	()[B
    //   1278: invokevirtual 499	java/io/ByteArrayOutputStream:write	([B)V
    //   1281: aload_3
    //   1282: astore_0
    //   1283: aload 4
    //   1285: new 126	java/lang/StringBuilder
    //   1288: dup
    //   1289: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   1292: ldc_w 553
    //   1295: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1298: ldc_w 489
    //   1301: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1304: ldc_w 489
    //   1307: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1310: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1313: invokevirtual 495	java/lang/String:getBytes	()[B
    //   1316: invokevirtual 499	java/io/ByteArrayOutputStream:write	([B)V
    //   1319: aload_3
    //   1320: astore_0
    //   1321: new 510	java/io/FileInputStream
    //   1324: dup
    //   1325: aload_1
    //   1326: invokespecial 554	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   1329: astore_1
    //   1330: aload_1
    //   1331: invokevirtual 558	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   1334: invokevirtual 562	java/nio/channels/FileChannel:size	()J
    //   1337: l2i
    //   1338: newarray <illegal type>
    //   1340: astore_0
    //   1341: aload_1
    //   1342: aload_0
    //   1343: invokevirtual 566	java/io/FileInputStream:read	([B)I
    //   1346: pop
    //   1347: aload 4
    //   1349: aload_0
    //   1350: invokevirtual 499	java/io/ByteArrayOutputStream:write	([B)V
    //   1353: aload 4
    //   1355: new 126	java/lang/StringBuilder
    //   1358: dup
    //   1359: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   1362: ldc_w 489
    //   1365: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1368: ldc_w 491
    //   1371: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1374: aload 8
    //   1376: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1379: ldc_w 491
    //   1382: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1385: ldc_w 489
    //   1388: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1391: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1394: invokevirtual 495	java/lang/String:getBytes	()[B
    //   1397: invokevirtual 499	java/io/ByteArrayOutputStream:write	([B)V
    //   1400: aload 4
    //   1402: invokevirtual 569	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   1405: astore_2
    //   1406: aload 4
    //   1408: ifnull +8 -> 1416
    //   1411: aload 4
    //   1413: invokevirtual 508	java/io/ByteArrayOutputStream:close	()V
    //   1416: aload_2
    //   1417: astore_0
    //   1418: aload_1
    //   1419: ifnull -516 -> 903
    //   1422: aload_1
    //   1423: invokevirtual 511	java/io/FileInputStream:close	()V
    //   1426: aload_2
    //   1427: astore_0
    //   1428: goto -525 -> 903
    //   1431: astore_0
    //   1432: aload_2
    //   1433: astore_0
    //   1434: goto -531 -> 903
    //   1437: astore_0
    //   1438: aconst_null
    //   1439: astore_0
    //   1440: goto -537 -> 903
    //   1443: astore_2
    //   1444: aload_0
    //   1445: astore_1
    //   1446: aload_2
    //   1447: astore_0
    //   1448: aload 4
    //   1450: ifnull +8 -> 1458
    //   1453: aload 4
    //   1455: invokevirtual 508	java/io/ByteArrayOutputStream:close	()V
    //   1458: aload_1
    //   1459: ifnull +7 -> 1466
    //   1462: aload_1
    //   1463: invokevirtual 511	java/io/FileInputStream:close	()V
    //   1466: aload_0
    //   1467: athrow
    //   1468: astore_0
    //   1469: iconst_0
    //   1470: istore 15
    //   1472: iload 15
    //   1474: istore 14
    //   1476: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1479: ifeq -338 -> 1141
    //   1482: ldc 47
    //   1484: iconst_2
    //   1485: new 126	java/lang/StringBuilder
    //   1488: dup
    //   1489: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   1492: ldc_w 571
    //   1495: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1498: aload_0
    //   1499: invokestatic 359	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1502: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1505: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1508: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1511: iload 15
    //   1513: istore 14
    //   1515: goto -374 -> 1141
    //   1518: astore_0
    //   1519: goto -103 -> 1416
    //   1522: astore_0
    //   1523: goto -630 -> 893
    //   1526: astore_2
    //   1527: goto -69 -> 1458
    //   1530: astore_1
    //   1531: goto -65 -> 1466
    //   1534: astore_0
    //   1535: goto -87 -> 1448
    //   1538: astore_2
    //   1539: goto -662 -> 877
    //   1542: iconst_0
    //   1543: istore 14
    //   1545: goto -404 -> 1141
    //   1548: aconst_null
    //   1549: astore_0
    //   1550: goto -647 -> 903
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1553	0	paramString1	String
    //   0	1553	1	paramString2	String
    //   0	1553	2	paramString3	String
    //   0	1553	3	paramString4	String
    //   0	1553	4	paramString5	String
    //   0	1553	5	paramString6	String
    //   0	1553	6	paramString7	String
    //   239	710	7	localHttpPost	HttpPost
    //   204	1171	8	str1	String
    //   363	389	9	localBundle	Bundle
    //   747	79	10	str2	String
    //   758	104	11	str3	String
    //   3	1164	12	l1	long
    //   1131	413	14	bool1	boolean
    //   1470	42	15	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   711	723	872	java/io/IOException
    //   725	735	872	java/io/IOException
    //   737	749	872	java/io/IOException
    //   751	760	872	java/io/IOException
    //   767	808	872	java/io/IOException
    //   810	857	872	java/io/IOException
    //   859	869	872	java/io/IOException
    //   1194	1235	872	java/io/IOException
    //   1237	1281	872	java/io/IOException
    //   1283	1319	872	java/io/IOException
    //   1321	1330	872	java/io/IOException
    //   1422	1426	1431	java/io/IOException
    //   897	901	1437	java/io/IOException
    //   711	723	1443	finally
    //   725	735	1443	finally
    //   737	749	1443	finally
    //   751	760	1443	finally
    //   767	808	1443	finally
    //   810	857	1443	finally
    //   859	869	1443	finally
    //   879	883	1443	finally
    //   1194	1235	1443	finally
    //   1237	1281	1443	finally
    //   1283	1319	1443	finally
    //   1321	1330	1443	finally
    //   912	996	1468	java/lang/Exception
    //   996	1055	1468	java/lang/Exception
    //   1055	1108	1468	java/lang/Exception
    //   1108	1133	1468	java/lang/Exception
    //   1411	1416	1518	java/io/IOException
    //   888	893	1522	java/io/IOException
    //   1453	1458	1526	java/io/IOException
    //   1462	1466	1530	java/io/IOException
    //   1330	1406	1534	finally
    //   1330	1406	1538	java/io/IOException
  }
  
  private void g()
  {
    ((ImmersiveTitleBar2)findViewById(2131297137)).setVisibility(4);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131297123);
    findViewById(2131297083).setOnClickListener(this);
    findViewById(2131297183).setOnClickListener(this);
    findViewById(2131297185).setOnClickListener(this);
    Object localObject1 = (ImageView)findViewById(2131297134);
    int i1 = BlessManager.g();
    int i2 = (int)(i1 * 0.48F);
    ((ImageView)localObject1).getLayoutParams().height = i2;
    ((ImageView)localObject1).requestLayout();
    if (QLog.isColorLevel()) {
      QLog.d("BlessResultActivity", 2, "target banner size: " + i1 + " * " + i2);
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.d();
    if (localObject2 != null) {}
    try
    {
      FileInputStream localFileInputStream = new FileInputStream((String)localObject2);
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inSampleSize = ((int)ImageUtil.a(localFileInputStream, i1, i2));
      localObject2 = BitmapManager.a((String)localObject2, localOptions);
      if (localObject2 != null) {
        ((ImageView)localObject1).setImageBitmap((Bitmap)localObject2);
      }
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.e("BlessResultActivity", 2, "banner not exist");
          continue;
          String str = getString(2131372367);
          continue;
          str = getString(2131372368);
        }
      }
    }
    localObject2 = (TextView)findViewById(2131297184);
    localObject1 = "";
    switch (this.jdField_i_of_type_Int)
    {
    default: 
      ((TextView)localObject2).setText(String.format(getString(2131372369), new Object[] { localObject1, Integer.valueOf(this.jdField_j_of_type_Int) }));
      if (this.jdField_i_of_type_Int == 2)
      {
        findViewById(2131297186).setVisibility(0);
        ((TextView)findViewById(2131297187)).setText(String.format(getString(2131372371), new Object[] { localObject1 }));
        findViewById(2131297188).setOnClickListener(this);
        findViewById(2131297189).setOnClickListener(this);
      }
      return;
    }
  }
  
  public String a(String paramString)
  {
    paramString = "http://mma.qq.com/blessing/indexp.html?_wv=1057&vid=" + paramString + "&nickname=";
    String str = paramString + Base64Util.encodeToString(this.app.b().getBytes(), 2);
    paramString = str;
    if (this.g > 0) {
      paramString = str + "&template=" + this.g;
    }
    return paramString;
  }
  
  void a()
  {
    if ((this.jdField_a_of_type_Ofz == null) || ((!this.jdField_a_of_type_Ofz.b()) && (!this.jdField_a_of_type_Boolean)))
    {
      String str = this.app.f();
      this.jdField_a_of_type_Ofz = new ofz(this, str, ((TicketManager)this.app.getManager(2)).getSkey(str), this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessResultActivity$VideoInfo, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarShortVideoUploadUtil$OnUploadVideoListener);
      this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessageDelayed(1003, 120000L);
      ThreadManager.a(this.jdField_a_of_type_Ofz, 8, null, false);
      return;
    }
    b();
  }
  
  void a(int paramInt)
  {
    c();
    this.jdField_h_of_type_Int = paramInt;
    if ((this.jdField_i_of_type_JavaLangString == null) || (this.jdField_h_of_type_JavaLangString == null))
    {
      QQToast.a(this, 2131369851, 0).a();
      d();
      return;
    }
    Object localObject1 = new File(this.jdField_i_of_type_JavaLangString);
    Object localObject2 = new File(this.jdField_h_of_type_JavaLangString);
    if ((!((File)localObject1).exists()) || (!((File)localObject2).exists()))
    {
      QQToast.a(this, 2131369851, 0).a();
      d();
      return;
    }
    if ((!((File)localObject1).isFile()) || (!((File)localObject2).isFile()))
    {
      QQToast.a(this, 2131369852, 0).a();
      d();
      return;
    }
    if ((this.n == null) || (this.o == null))
    {
      localObject1 = getSharedPreferences("bless_ptv_upload", 0);
      localObject2 = getCurrentAccountUin();
      this.n = ((SharedPreferences)localObject1).getString("bless_ptv_path" + (String)localObject2, "");
      this.o = ((SharedPreferences)localObject1).getString("bless_vid" + (String)localObject2, "");
    }
    if ((this.jdField_h_of_type_JavaLangString.equals(this.n)) && (!TextUtils.isEmpty(this.o)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BlessResultActivity", 2, "share last uploaded ptv.");
      }
      this.k = this.o;
      this.l = a(this.k);
      b();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessResultActivity$VideoInfo == null)
    {
      ThreadManager.c(new ofx(this));
      return;
    }
    a();
  }
  
  public void a(BaseResp paramBaseResp)
  {
    if ((this.m == null) || (!this.m.equals(paramBaseResp.transaction))) {
      return;
    }
    switch (paramBaseResp.errCode)
    {
    case -2: 
    case -1: 
    default: 
      QQToast.a(this, 1, getString(2131369518), 0).a();
      return;
    }
    QQToast.a(this, 2, getString(2131369517), 0).a();
  }
  
  void b()
  {
    d();
    if (this.jdField_h_of_type_Int == 1)
    {
      e();
      return;
    }
    f();
  }
  
  void c()
  {
    if (QLog.isColorLevel()) {
      QLog.e("BlessResultActivity", 2, "showProgressDialog");
    }
    try
    {
      if (this.jdField_a_of_type_AndroidAppProgressDialog != null) {
        d();
      }
      while (!this.jdField_a_of_type_AndroidAppProgressDialog.isShowing())
      {
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        return;
        this.jdField_a_of_type_AndroidAppProgressDialog = new ProgressDialog(this, 2131558973);
        this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(false);
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        this.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2130903453);
        ((TextView)this.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131298665)).setText(2131368571);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.e("BlessResultActivity", 2, "showProgressDialog", localThrowable);
      }
    }
  }
  
  void d()
  {
    if (QLog.isColorLevel()) {
      QLog.e("BlessResultActivity", 2, "cancelProgressDialog");
    }
    try
    {
      if (this.jdField_a_of_type_AndroidAppProgressDialog != null) {
        this.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void doOnBackPressed()
  {
    onBackEvent();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2130903113);
    this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager = ((BlessManager)this.app.getManager(137));
    this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a(false);
    paramBundle = getIntent();
    this.jdField_i_of_type_Int = paramBundle.getIntExtra("param_method", 1);
    this.jdField_j_of_type_Int = paramBundle.getIntExtra("param_count", 0);
    if (this.jdField_i_of_type_Int == 2)
    {
      this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler = new MqqWeakReferenceHandler(this);
      this.jdField_h_of_type_JavaLangString = paramBundle.getStringExtra("param_ptv_path");
      this.jdField_i_of_type_JavaLangString = paramBundle.getStringExtra("param_snap_path");
      this.g = paramBundle.getIntExtra("param_ptv_id", -1);
      this.jdField_j_of_type_JavaLangString = paramBundle.getStringExtra("param_share_title");
      if (TextUtils.isEmpty(this.jdField_j_of_type_JavaLangString)) {
        this.jdField_j_of_type_JavaLangString = getString(2131372391);
      }
      if (QLog.isColorLevel()) {
        QLog.d("BlessResultActivity", 2, "mp4: " + this.jdField_h_of_type_JavaLangString + ", image:" + this.jdField_i_of_type_JavaLangString);
      }
      WXShareHelper.a().a(this);
    }
    g();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_i_of_type_Int == 2)
    {
      WXShareHelper.a().b(this);
      if ((this.jdField_a_of_type_Ofz != null) && (this.jdField_a_of_type_Ofz.b())) {
        this.jdField_a_of_type_Ofz.a();
      }
    }
  }
  
  void e()
  {
    String str1 = this.jdField_i_of_type_JavaLangString;
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(str1)) {
      localArrayList.add(str1);
    }
    str1 = this.jdField_j_of_type_JavaLangString;
    String str2 = String.format(getString(2131372392), new Object[] { this.app.b() });
    Bundle localBundle = new Bundle();
    localBundle.putString("title", str1);
    localBundle.putString("desc", str2);
    localBundle.putLong("req_share_id", 0L);
    localBundle.putString("detail_url", this.l);
    localBundle.putString("url", this.l);
    localBundle.putStringArrayList("image_url", localArrayList);
    localBundle.putString("troop_wording", str1);
    localBundle.putString("bizname", "StarBlessLink");
    QZoneShareManager.a(this.app, this, localBundle, null);
    if (QLog.isColorLevel()) {
      QLog.i("BlessResultActivity", 2, "shareToQzone: shareLink:" + this.l);
    }
  }
  
  void f()
  {
    int i1;
    if (!WXShareHelper.a().a()) {
      i1 = 2131369529;
    }
    for (;;)
    {
      if (i1 != -1) {
        QQToast.a(this, getString(i1), 0).a();
      }
      for (;;)
      {
        return;
        if (!WXShareHelper.a().b())
        {
          i1 = 2131369530;
          break;
          this.m = String.valueOf(System.currentTimeMillis());
          String str1 = null;
          try
          {
            localObject = BitmapFactory.decodeFile(this.jdField_i_of_type_JavaLangString);
            str1 = this.jdField_j_of_type_JavaLangString;
            String str2 = String.format(getString(2131372392), new Object[] { this.app.b() });
            WXShareHelper.a().c(this.m, str1, (Bitmap)localObject, str2, this.l);
            if (QLog.isColorLevel())
            {
              QLog.i("BlessResultActivity", 2, "shareToFriendCircle.transaction: " + this.m + ", shareLink:" + this.l);
              return;
            }
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            for (;;)
            {
              Object localObject = str1;
              if (QLog.isColorLevel())
              {
                QLog.e("BlessResultActivity", 2, "getBitmapByPath OOM, fileName: " + this.jdField_i_of_type_JavaLangString, localOutOfMemoryError);
                localObject = str1;
              }
            }
          }
        }
      }
      i1 = -1;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("BlessResultActivity", 2, "handleMessage,msg.what = " + paramMessage.what);
    }
    switch (paramMessage.what)
    {
    default: 
      bool = false;
    case 1002: 
      return bool;
    case 1000: 
      a();
      return true;
    case 1003: 
      if ((this.jdField_a_of_type_Ofz != null) && (this.jdField_a_of_type_Ofz.b())) {
        this.jdField_a_of_type_Ofz.a();
      }
      d();
      QQToast.a(this, 1, 2131369518, 0).a();
      return true;
    }
    this.n = this.jdField_h_of_type_JavaLangString;
    this.o = this.k;
    paramMessage = getSharedPreferences("bless_ptv_upload", 0).edit();
    String str = getCurrentAccountUin();
    paramMessage.putString("bless_ptv_path" + str, this.n);
    paramMessage.putString("bless_vid" + str, this.o);
    paramMessage.commit();
    b();
    return true;
  }
  
  protected boolean onBackEvent()
  {
    Intent localIntent = new Intent(this, BlessActivity.class);
    localIntent.setFlags(67108864);
    startActivity(localIntent);
    finish();
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131297185: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.f() <= 0) {
        QQToast.a(this, String.format(getString(2131372357), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.e()) }), 0).a();
      }
      for (;;)
      {
        ReportController.b(this.app, "CliOper", "", "", "0X8006194", "0X8006194", 0, 0, String.valueOf(this.jdField_i_of_type_Int), "", "", "");
        return;
        paramView = new Intent(this, SelectMemberActivity.class);
        paramView.setFlags(67108864);
        startActivity(paramView);
        overridePendingTransition(2130968587, 2130968588);
      }
    case 2131297083: 
      onBackEvent();
      return;
    case 2131297183: 
      paramView = new Intent(this, SplashActivity.class);
      paramView.setFlags(67108864);
      startActivity(paramView);
      return;
    case 2131297188: 
      a(1);
      return;
    }
    a(2);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\bless\BlessResultActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */