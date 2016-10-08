package com.tencent.mobileqq.activity.shortvideo;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.AioShortVideoOperator;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.ShortVideoUploadInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import piy;

public class SendVideoActivity$SendAppShortVideoTask
  extends AsyncTask
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  String jdField_a_of_type_JavaLangString;
  WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  int jdField_b_of_type_Int;
  long jdField_b_of_type_Long;
  String jdField_b_of_type_JavaLangString;
  int jdField_c_of_type_Int;
  String jdField_c_of_type_JavaLangString;
  String d;
  String e;
  String f;
  String g;
  
  public SendVideoActivity$SendAppShortVideoTask(BaseActivity paramBaseActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseActivity);
    paramBaseActivity = paramBaseActivity.getIntent();
    this.jdField_b_of_type_JavaLangString = paramBaseActivity.getExtras().getString("file_send_path");
    this.jdField_b_of_type_Long = paramBaseActivity.getExtras().getLong("file_send_duration");
    this.jdField_a_of_type_Long = paramBaseActivity.getExtras().getLong("file_send_size");
    this.jdField_c_of_type_JavaLangString = paramBaseActivity.getExtras().getString("uin");
    this.jdField_a_of_type_Int = paramBaseActivity.getIntExtra("uintype", -1);
    this.d = paramBaseActivity.getStringExtra("file_source");
    this.e = paramBaseActivity.getExtras().getString("file_shortvideo_md5");
    this.jdField_a_of_type_JavaLangString = paramBaseActivity.getExtras().getString("activity_before_enter_send_video");
    this.g = paramBaseActivity.getExtras().getString("thumbfile_md5");
    if (QLog.isColorLevel()) {
      QLog.d("SendVideoActivity", 2, " SendAppShortVideoTask(),  mVideoPath :" + this.jdField_b_of_type_JavaLangString + ", mDuration:" + this.jdField_b_of_type_Long + ", mFileSize:" + this.jdField_a_of_type_Long + ",mUin" + this.jdField_c_of_type_JavaLangString + ",mUinType:" + this.jdField_a_of_type_Int + ",mFileSource:" + this.d);
    }
  }
  
  public static void b(Context paramContext, int paramInt)
  {
    DialogUtil.a(paramContext, 232, null, paramContext.getString(paramInt), new piy(paramContext), null).show();
  }
  
  /* Error */
  protected int a()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 8
    //   3: iconst_2
    //   4: istore 9
    //   6: aload_0
    //   7: getfield 58	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendAppShortVideoTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   10: iconst_1
    //   11: invokestatic 174	android/media/ThumbnailUtils:createVideoThumbnail	(Ljava/lang/String;I)Landroid/graphics/Bitmap;
    //   14: astore 5
    //   16: new 111	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   23: ldc -80
    //   25: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokestatic 182	java/lang/System:currentTimeMillis	()J
    //   31: invokevirtual 123	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   34: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: ldc -72
    //   39: invokestatic 189	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   42: astore_3
    //   43: new 111	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   50: invokestatic 191	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	()Ljava/lang/String;
    //   53: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: ldc -63
    //   58: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokestatic 198	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)V
    //   67: new 200	java/io/File
    //   70: dup
    //   71: aload_3
    //   72: invokespecial 202	java/io/File:<init>	(Ljava/lang/String;)V
    //   75: astore 6
    //   77: new 200	java/io/File
    //   80: dup
    //   81: aload 6
    //   83: invokevirtual 205	java/io/File:getParent	()Ljava/lang/String;
    //   86: invokespecial 202	java/io/File:<init>	(Ljava/lang/String;)V
    //   89: astore_1
    //   90: aload_1
    //   91: invokevirtual 208	java/io/File:exists	()Z
    //   94: ifeq +10 -> 104
    //   97: aload_1
    //   98: invokevirtual 211	java/io/File:isDirectory	()Z
    //   101: ifne +8 -> 109
    //   104: aload_1
    //   105: invokevirtual 214	java/io/File:mkdirs	()Z
    //   108: pop
    //   109: aload 6
    //   111: invokevirtual 208	java/io/File:exists	()Z
    //   114: ifeq +11 -> 125
    //   117: aload 6
    //   119: invokevirtual 217	java/io/File:isFile	()Z
    //   122: ifne +9 -> 131
    //   125: aload 6
    //   127: invokevirtual 220	java/io/File:createNewFile	()Z
    //   130: pop
    //   131: new 222	java/io/BufferedOutputStream
    //   134: dup
    //   135: new 224	java/io/FileOutputStream
    //   138: dup
    //   139: aload 6
    //   141: invokespecial 227	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   144: invokespecial 230	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   147: astore_2
    //   148: aload 5
    //   150: ifnull +197 -> 347
    //   153: aload_2
    //   154: astore_1
    //   155: aload 5
    //   157: getstatic 236	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   160: bipush 60
    //   162: aload_2
    //   163: invokevirtual 242	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   166: pop
    //   167: aload_2
    //   168: astore_1
    //   169: aload_2
    //   170: invokevirtual 245	java/io/BufferedOutputStream:flush	()V
    //   173: iload 8
    //   175: istore 7
    //   177: aload_2
    //   178: ifnull +11 -> 189
    //   181: aload_2
    //   182: invokevirtual 248	java/io/BufferedOutputStream:close	()V
    //   185: iload 8
    //   187: istore 7
    //   189: aload 6
    //   191: invokevirtual 208	java/io/File:exists	()Z
    //   194: ifeq +723 -> 917
    //   197: new 250	java/io/FileInputStream
    //   200: dup
    //   201: aload_3
    //   202: invokespecial 251	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   205: astore_1
    //   206: aload_1
    //   207: aload 6
    //   209: invokevirtual 254	java/io/File:length	()J
    //   212: invokestatic 260	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   215: invokestatic 266	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   218: astore_2
    //   219: aload_1
    //   220: ifnull +7 -> 227
    //   223: aload_1
    //   224: invokevirtual 267	java/io/FileInputStream:close	()V
    //   227: aload_2
    //   228: invokestatic 273	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   231: ifeq +336 -> 567
    //   234: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   237: ifeq +750 -> 987
    //   240: ldc 109
    //   242: iconst_2
    //   243: new 111	java/lang/StringBuilder
    //   246: dup
    //   247: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   250: ldc_w 275
    //   253: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: aload_2
    //   257: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   263: invokestatic 277	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   266: aload_0
    //   267: aload_2
    //   268: putfield 101	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendAppShortVideoTask:g	Ljava/lang/String;
    //   271: aload_0
    //   272: aload_3
    //   273: putfield 279	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendAppShortVideoTask:f	Ljava/lang/String;
    //   276: aload 5
    //   278: ifnull +21 -> 299
    //   281: aload_0
    //   282: aload 5
    //   284: invokevirtual 282	android/graphics/Bitmap:getWidth	()I
    //   287: putfield 284	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendAppShortVideoTask:jdField_b_of_type_Int	I
    //   290: aload_0
    //   291: aload 5
    //   293: invokevirtual 287	android/graphics/Bitmap:getHeight	()I
    //   296: putfield 289	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendAppShortVideoTask:jdField_c_of_type_Int	I
    //   299: new 250	java/io/FileInputStream
    //   302: dup
    //   303: aload_0
    //   304: getfield 58	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendAppShortVideoTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   307: invokespecial 251	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   310: astore_2
    //   311: aload_0
    //   312: aload_2
    //   313: new 200	java/io/File
    //   316: dup
    //   317: aload_0
    //   318: getfield 58	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendAppShortVideoTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   321: invokespecial 202	java/io/File:<init>	(Ljava/lang/String;)V
    //   324: invokevirtual 254	java/io/File:length	()J
    //   327: invokestatic 260	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   330: invokestatic 266	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   333: putfield 93	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendAppShortVideoTask:e	Ljava/lang/String;
    //   336: iload 7
    //   338: ireturn
    //   339: astore_1
    //   340: aload_1
    //   341: invokevirtual 292	java/io/IOException:printStackTrace	()V
    //   344: goto -213 -> 131
    //   347: iconst_2
    //   348: istore 8
    //   350: goto -177 -> 173
    //   353: astore 4
    //   355: aconst_null
    //   356: astore_2
    //   357: aload_2
    //   358: astore_1
    //   359: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   362: ifeq +45 -> 407
    //   365: aload_2
    //   366: astore_1
    //   367: ldc 109
    //   369: iconst_2
    //   370: new 111	java/lang/StringBuilder
    //   373: dup
    //   374: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   377: ldc_w 294
    //   380: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: aload_3
    //   384: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: ldc_w 296
    //   390: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: aload 4
    //   395: invokevirtual 299	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   398: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   404: invokestatic 277	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   407: aload_2
    //   408: ifnull +7 -> 415
    //   411: aload_2
    //   412: invokevirtual 248	java/io/BufferedOutputStream:close	()V
    //   415: iconst_2
    //   416: istore 7
    //   418: goto -229 -> 189
    //   421: astore_1
    //   422: iconst_2
    //   423: istore 7
    //   425: goto -236 -> 189
    //   428: astore 4
    //   430: aconst_null
    //   431: astore_2
    //   432: aload_2
    //   433: astore_1
    //   434: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   437: ifeq +45 -> 482
    //   440: aload_2
    //   441: astore_1
    //   442: ldc 109
    //   444: iconst_2
    //   445: new 111	java/lang/StringBuilder
    //   448: dup
    //   449: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   452: ldc_w 294
    //   455: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: aload_3
    //   459: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: ldc_w 301
    //   465: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: aload 4
    //   470: invokevirtual 302	java/io/IOException:getMessage	()Ljava/lang/String;
    //   473: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   479: invokestatic 277	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   482: aload_2
    //   483: ifnull +7 -> 490
    //   486: aload_2
    //   487: invokevirtual 248	java/io/BufferedOutputStream:close	()V
    //   490: iconst_2
    //   491: istore 7
    //   493: goto -304 -> 189
    //   496: astore_1
    //   497: iconst_2
    //   498: istore 7
    //   500: goto -311 -> 189
    //   503: astore_2
    //   504: aconst_null
    //   505: astore_1
    //   506: aload_1
    //   507: ifnull +7 -> 514
    //   510: aload_1
    //   511: invokevirtual 248	java/io/BufferedOutputStream:close	()V
    //   514: aload_2
    //   515: athrow
    //   516: astore 4
    //   518: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   521: ifeq -294 -> 227
    //   524: ldc 109
    //   526: iconst_2
    //   527: new 111	java/lang/StringBuilder
    //   530: dup
    //   531: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   534: ldc_w 304
    //   537: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: aload_3
    //   541: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: ldc_w 301
    //   547: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: aload 4
    //   552: invokevirtual 302	java/io/IOException:getMessage	()Ljava/lang/String;
    //   555: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   558: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   561: invokestatic 277	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   564: goto -337 -> 227
    //   567: aload_2
    //   568: ldc -72
    //   570: invokestatic 189	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   573: astore 4
    //   575: aload_3
    //   576: aload 4
    //   578: invokestatic 307	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   581: ifeq +403 -> 984
    //   584: aload 4
    //   586: astore_3
    //   587: goto -321 -> 266
    //   590: astore_2
    //   591: aconst_null
    //   592: astore_1
    //   593: aload_2
    //   594: invokevirtual 308	java/io/FileNotFoundException:printStackTrace	()V
    //   597: aload_1
    //   598: ifnull +7 -> 605
    //   601: aload_1
    //   602: invokevirtual 267	java/io/FileInputStream:close	()V
    //   605: aconst_null
    //   606: invokestatic 273	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   609: ifeq +92 -> 701
    //   612: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   615: ifeq +361 -> 976
    //   618: ldc 109
    //   620: iconst_2
    //   621: new 111	java/lang/StringBuilder
    //   624: dup
    //   625: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   628: ldc_w 275
    //   631: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   634: aconst_null
    //   635: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   638: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   641: invokestatic 277	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   644: iconst_2
    //   645: istore 7
    //   647: aconst_null
    //   648: astore_2
    //   649: goto -383 -> 266
    //   652: astore_2
    //   653: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   656: ifeq -51 -> 605
    //   659: ldc 109
    //   661: iconst_2
    //   662: new 111	java/lang/StringBuilder
    //   665: dup
    //   666: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   669: ldc_w 304
    //   672: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   675: aload_3
    //   676: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   679: ldc_w 301
    //   682: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   685: aload_2
    //   686: invokevirtual 302	java/io/IOException:getMessage	()Ljava/lang/String;
    //   689: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   692: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   695: invokestatic 277	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   698: goto -93 -> 605
    //   701: aconst_null
    //   702: ldc -72
    //   704: invokestatic 189	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   707: astore_2
    //   708: aload_3
    //   709: astore 4
    //   711: aload_3
    //   712: aload_2
    //   713: invokestatic 307	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   716: ifeq +6 -> 722
    //   719: aload_2
    //   720: astore 4
    //   722: iconst_2
    //   723: istore 7
    //   725: aconst_null
    //   726: astore_2
    //   727: aload 4
    //   729: astore_3
    //   730: goto -464 -> 266
    //   733: astore_2
    //   734: aconst_null
    //   735: astore_1
    //   736: aload_1
    //   737: ifnull +7 -> 744
    //   740: aload_1
    //   741: invokevirtual 267	java/io/FileInputStream:close	()V
    //   744: aconst_null
    //   745: invokestatic 273	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   748: ifeq +86 -> 834
    //   751: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   754: ifeq +29 -> 783
    //   757: ldc 109
    //   759: iconst_2
    //   760: new 111	java/lang/StringBuilder
    //   763: dup
    //   764: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   767: ldc_w 275
    //   770: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   773: aconst_null
    //   774: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   777: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   780: invokestatic 277	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   783: aload_2
    //   784: athrow
    //   785: astore_1
    //   786: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   789: ifeq -45 -> 744
    //   792: ldc 109
    //   794: iconst_2
    //   795: new 111	java/lang/StringBuilder
    //   798: dup
    //   799: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   802: ldc_w 304
    //   805: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   808: aload_3
    //   809: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   812: ldc_w 301
    //   815: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   818: aload_1
    //   819: invokevirtual 302	java/io/IOException:getMessage	()Ljava/lang/String;
    //   822: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   825: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   828: invokestatic 277	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   831: goto -87 -> 744
    //   834: aload_3
    //   835: aconst_null
    //   836: ldc -72
    //   838: invokestatic 189	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   841: invokestatic 307	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   844: ifeq -61 -> 783
    //   847: goto -64 -> 783
    //   850: astore_3
    //   851: iconst_5
    //   852: istore 8
    //   854: aload_1
    //   855: astore_2
    //   856: iload 8
    //   858: istore 7
    //   860: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   863: ifeq -552 -> 311
    //   866: ldc 109
    //   868: iconst_2
    //   869: new 111	java/lang/StringBuilder
    //   872: dup
    //   873: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   876: ldc_w 310
    //   879: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   882: aload_0
    //   883: getfield 58	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendAppShortVideoTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   886: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   889: ldc_w 312
    //   892: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   895: aload_3
    //   896: invokevirtual 299	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   899: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   902: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   905: invokestatic 277	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   908: aload_1
    //   909: astore_2
    //   910: iload 8
    //   912: istore 7
    //   914: goto -603 -> 311
    //   917: iload 9
    //   919: istore 7
    //   921: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   924: ifeq -588 -> 336
    //   927: ldc 109
    //   929: iconst_2
    //   930: ldc_w 314
    //   933: invokestatic 277	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   936: iconst_2
    //   937: ireturn
    //   938: astore_1
    //   939: iload 8
    //   941: istore 7
    //   943: goto -754 -> 189
    //   946: astore_1
    //   947: goto -433 -> 514
    //   950: astore_2
    //   951: goto -215 -> 736
    //   954: astore_2
    //   955: goto -219 -> 736
    //   958: astore_2
    //   959: goto -366 -> 593
    //   962: astore_2
    //   963: goto -457 -> 506
    //   966: astore 4
    //   968: goto -536 -> 432
    //   971: astore 4
    //   973: goto -616 -> 357
    //   976: iconst_2
    //   977: istore 7
    //   979: aconst_null
    //   980: astore_2
    //   981: goto -715 -> 266
    //   984: goto -397 -> 587
    //   987: goto -721 -> 266
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	990	0	this	SendAppShortVideoTask
    //   89	135	1	localObject1	Object
    //   339	2	1	localIOException1	java.io.IOException
    //   358	9	1	localObject2	Object
    //   421	1	1	localIOException2	java.io.IOException
    //   433	9	1	localObject3	Object
    //   496	1	1	localIOException3	java.io.IOException
    //   505	236	1	localObject4	Object
    //   785	124	1	localIOException4	java.io.IOException
    //   938	1	1	localIOException5	java.io.IOException
    //   946	1	1	localIOException6	java.io.IOException
    //   147	340	2	localObject5	Object
    //   503	65	2	str1	String
    //   590	4	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   648	1	2	localObject6	Object
    //   652	34	2	localIOException7	java.io.IOException
    //   707	20	2	str2	String
    //   733	51	2	localObject7	Object
    //   855	55	2	localIOException8	java.io.IOException
    //   950	1	2	localObject8	Object
    //   954	1	2	localObject9	Object
    //   958	1	2	localFileNotFoundException2	java.io.FileNotFoundException
    //   962	1	2	localObject10	Object
    //   980	1	2	localObject11	Object
    //   42	793	3	localObject12	Object
    //   850	46	3	localFileNotFoundException3	java.io.FileNotFoundException
    //   353	41	4	localFileNotFoundException4	java.io.FileNotFoundException
    //   428	41	4	localIOException9	java.io.IOException
    //   516	35	4	localIOException10	java.io.IOException
    //   573	155	4	localObject13	Object
    //   966	1	4	localIOException11	java.io.IOException
    //   971	1	4	localFileNotFoundException5	java.io.FileNotFoundException
    //   14	278	5	localBitmap	Bitmap
    //   75	133	6	localFile	java.io.File
    //   175	803	7	i	int
    //   1	939	8	j	int
    //   4	914	9	k	int
    // Exception table:
    //   from	to	target	type
    //   125	131	339	java/io/IOException
    //   131	148	353	java/io/FileNotFoundException
    //   411	415	421	java/io/IOException
    //   131	148	428	java/io/IOException
    //   486	490	496	java/io/IOException
    //   131	148	503	finally
    //   223	227	516	java/io/IOException
    //   197	206	590	java/io/FileNotFoundException
    //   601	605	652	java/io/IOException
    //   197	206	733	finally
    //   740	744	785	java/io/IOException
    //   299	311	850	java/io/FileNotFoundException
    //   181	185	938	java/io/IOException
    //   510	514	946	java/io/IOException
    //   206	219	950	finally
    //   593	597	954	finally
    //   206	219	958	java/io/FileNotFoundException
    //   155	167	962	finally
    //   169	173	962	finally
    //   359	365	962	finally
    //   367	407	962	finally
    //   434	440	962	finally
    //   442	482	962	finally
    //   155	167	966	java/io/IOException
    //   169	173	966	java/io/IOException
    //   155	167	971	java/io/FileNotFoundException
    //   169	173	971	java/io/FileNotFoundException
  }
  
  protected Integer a(Void... paramVarArgs)
  {
    return Integer.valueOf(a());
  }
  
  void a()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidAppProgressDialog != null) {
        this.jdField_a_of_type_AndroidAppProgressDialog.cancel();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  void a(Context paramContext, int paramInt)
  {
    try
    {
      if (this.jdField_a_of_type_AndroidAppProgressDialog != null) {
        a();
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
        if (this.jdField_a_of_type_AndroidAppProgressDialog.isShowing()) {
          break;
        }
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        return;
        this.jdField_a_of_type_AndroidAppProgressDialog = new ProgressDialog(paramContext, 2131558973);
        this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(true);
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        this.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2130903453);
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131298665));
      }
      return;
    }
    catch (Throwable paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SendVideoActivity", 2, "showProgressDialog", paramContext);
      }
    }
  }
  
  protected void a(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {
      return;
    }
    a();
    switch (paramInteger.intValue())
    {
    default: 
      return;
    case 1: 
      paramInteger = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getIntent();
      paramInteger.putExtra("uin", this.jdField_c_of_type_JavaLangString);
      paramInteger.putExtra("uintype", this.jdField_a_of_type_Int);
      paramInteger.putExtra("file_send_path", this.jdField_b_of_type_JavaLangString);
      paramInteger.putExtra("file_send_size", this.jdField_a_of_type_Long);
      paramInteger.putExtra("file_send_duration", (int)(this.jdField_b_of_type_Long / 1000L));
      paramInteger.putExtra("file_source", this.d);
      paramInteger.putExtra("thumbfile_send_path", this.f);
      paramInteger.putExtra("file_shortvideo_md5", this.e);
      paramInteger.putExtra("thumbfile_send_width", this.jdField_b_of_type_Int);
      paramInteger.putExtra("thumbfile_send_height", this.jdField_c_of_type_Int);
      paramInteger.putExtra("thumbfile_md5", this.g);
      paramInteger.putExtra("file_send_business_type", 2);
      Object localObject2 = ShortVideoBusiManager.a(0, 2);
      Object localObject1 = ShortVideoBusiManager.a(2, paramInteger, (ShortVideoReq)localObject2);
      ((ShortVideoReq)localObject2).a((ShortVideoUploadInfo)localObject1);
      localObject2 = new AioShortVideoOperator(((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).app);
      localObject1 = ((AioShortVideoOperator)localObject2).a((ShortVideoUploadInfo)localObject1);
      ((AioShortVideoOperator)localObject2).a((MessageRecord)localObject1);
      localObject2 = (MessageForShortVideo)localObject1;
      localObject2 = ShortVideoUtils.a(((MessageForShortVideo)localObject2).md5, ((MessageForShortVideo)localObject2).frienduin, ((MessageForShortVideo)localObject2).uniseq, "mp4");
      FileUtils.d(this.jdField_b_of_type_JavaLangString, (String)localObject2);
      localObject2 = ShortVideoBusiManager.a(0, 2);
      localObject1 = ShortVideoBusiManager.a(localObject1, (ShortVideoReq)localObject2);
      ((ShortVideoUploadInfo)localObject1).b = false;
      ((ShortVideoReq)localObject2).a((ShortVideoUploadInfo)localObject1);
      ShortVideoBusiManager.a((ShortVideoReq)localObject2, ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).app);
      localObject1 = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getIntent();
      if (((Intent)localObject1).getBooleanExtra("start_init_activity_after_sended", true))
      {
        localObject2 = ((Intent)localObject1).getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
        paramInteger.setClassName(((Intent)localObject1).getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME"), (String)localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("SendVideoActivity", 2, "SendAppShortVideoTask onPostExecute() INIT_ACTIVITY_CLASS_NAME=" + (String)localObject2);
        }
        paramInteger.addFlags(603979776);
        ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).startActivity(paramInteger);
      }
      ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).finish();
      ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).overridePendingTransition(0, 2130968586);
      return;
    case 2: 
    case 6: 
      b((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131371525);
      return;
    case 3: 
      b((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131371532);
      return;
    case 4: 
      b((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131371530);
      return;
    }
    b((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131371533);
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131370344);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\shortvideo\SendVideoActivity$SendAppShortVideoTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */