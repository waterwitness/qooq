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
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.AioShortVideoOperator;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.ShortVideoUploadInfo;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import pjf;

public class SendVideoActivity$SendVideoTask
  extends AsyncTask
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  String jdField_a_of_type_JavaLangString;
  WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  long jdField_b_of_type_Long;
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean;
  int jdField_c_of_type_Int;
  String jdField_c_of_type_JavaLangString;
  int jdField_d_of_type_Int;
  String jdField_d_of_type_JavaLangString;
  int jdField_e_of_type_Int;
  String jdField_e_of_type_JavaLangString;
  String f;
  String g;
  
  public SendVideoActivity$SendVideoTask(BaseActivity paramBaseActivity, Intent paramIntent)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseActivity);
    paramBaseActivity = paramBaseActivity.getIntent();
    if (paramIntent != null) {}
    for (;;)
    {
      this.jdField_b_of_type_JavaLangString = paramIntent.getExtras().getString("file_send_path");
      this.jdField_b_of_type_Long = paramIntent.getExtras().getLong("file_send_duration");
      this.jdField_a_of_type_Long = paramIntent.getExtras().getLong("file_send_size");
      this.jdField_c_of_type_JavaLangString = paramIntent.getExtras().getString("uin");
      this.jdField_a_of_type_Int = paramIntent.getIntExtra("uintype", -1);
      this.jdField_d_of_type_JavaLangString = paramIntent.getStringExtra("file_source");
      this.jdField_e_of_type_JavaLangString = paramIntent.getExtras().getString("file_shortvideo_md5");
      this.jdField_a_of_type_JavaLangString = paramIntent.getExtras().getString("activity_before_enter_send_video");
      this.jdField_b_of_type_Boolean = paramIntent.getExtras().getBoolean("send_in_background");
      if (QLog.isColorLevel()) {
        QLog.d("SendVideoActivity", 2, " SendVideoTask(),  mVideoPath :" + this.jdField_b_of_type_JavaLangString + ", mDuration:" + this.jdField_b_of_type_Long + ", mFileSize:" + this.jdField_a_of_type_Long + ",mUin" + this.jdField_c_of_type_JavaLangString + ",mUinType:" + this.jdField_a_of_type_Int + ",mFileSource:" + this.jdField_d_of_type_JavaLangString + ",mSendBackground = " + this.jdField_b_of_type_Boolean);
      }
      return;
      paramIntent = paramBaseActivity;
    }
  }
  
  public static void a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    DialogUtil.a(paramContext, 232, null, paramContext.getString(paramInt), new pjf(paramBoolean, paramContext), null).show();
  }
  
  /* Error */
  int a(Context paramContext)
  {
    // Byte code:
    //   0: iconst_5
    //   1: istore 8
    //   3: aload_1
    //   4: ifnonnull +6 -> 10
    //   7: iload 8
    //   9: ireturn
    //   10: aload_1
    //   11: aload_0
    //   12: getfield 58	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   15: invokestatic 184	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Landroid/content/Context;Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   18: astore_2
    //   19: aload_2
    //   20: astore_3
    //   21: aload_2
    //   22: ifnonnull +29 -> 51
    //   25: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   28: ifeq +11 -> 39
    //   31: ldc 113
    //   33: iconst_2
    //   34: ldc -70
    //   36: invokestatic 188	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   39: aload_0
    //   40: getfield 190	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTask:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   43: ifnull +90 -> 133
    //   46: aload_0
    //   47: getfield 190	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTask:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   50: astore_3
    //   51: aload_0
    //   52: aload_3
    //   53: invokevirtual 196	android/graphics/Bitmap:getWidth	()I
    //   56: putfield 198	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTask:jdField_b_of_type_Int	I
    //   59: aload_0
    //   60: aload_3
    //   61: invokevirtual 201	android/graphics/Bitmap:getHeight	()I
    //   64: putfield 203	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTask:jdField_c_of_type_Int	I
    //   67: aload_0
    //   68: getfield 198	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTask:jdField_b_of_type_Int	I
    //   71: ifeq +10 -> 81
    //   74: aload_0
    //   75: getfield 203	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTask:jdField_c_of_type_Int	I
    //   78: ifne +93 -> 171
    //   81: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   84: ifeq +11 -> 95
    //   87: ldc 113
    //   89: iconst_2
    //   90: ldc -51
    //   92: invokestatic 188	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   95: iconst_0
    //   96: ifeq +11 -> 107
    //   99: new 207	java/lang/NullPointerException
    //   102: dup
    //   103: invokespecial 208	java/lang/NullPointerException:<init>	()V
    //   106: athrow
    //   107: iconst_0
    //   108: ifeq +11 -> 119
    //   111: new 207	java/lang/NullPointerException
    //   114: dup
    //   115: invokespecial 208	java/lang/NullPointerException:<init>	()V
    //   118: athrow
    //   119: iconst_0
    //   120: ifeq +11 -> 131
    //   123: new 207	java/lang/NullPointerException
    //   126: dup
    //   127: invokespecial 208	java/lang/NullPointerException:<init>	()V
    //   130: athrow
    //   131: iconst_2
    //   132: ireturn
    //   133: iconst_0
    //   134: ifeq +11 -> 145
    //   137: new 207	java/lang/NullPointerException
    //   140: dup
    //   141: invokespecial 208	java/lang/NullPointerException:<init>	()V
    //   144: athrow
    //   145: iconst_0
    //   146: ifeq +11 -> 157
    //   149: new 207	java/lang/NullPointerException
    //   152: dup
    //   153: invokespecial 208	java/lang/NullPointerException:<init>	()V
    //   156: athrow
    //   157: iconst_0
    //   158: ifeq +11 -> 169
    //   161: new 207	java/lang/NullPointerException
    //   164: dup
    //   165: invokespecial 208	java/lang/NullPointerException:<init>	()V
    //   168: athrow
    //   169: iconst_2
    //   170: ireturn
    //   171: new 115	java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   178: ldc -46
    //   180: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: invokestatic 216	java/lang/System:currentTimeMillis	()J
    //   186: invokevirtual 127	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   189: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: ldc -38
    //   194: invokestatic 221	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   197: astore 7
    //   199: new 115	java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   206: invokestatic 223	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	()Ljava/lang/String;
    //   209: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: ldc -31
    //   214: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: invokestatic 230	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)V
    //   223: new 232	java/io/File
    //   226: dup
    //   227: aload 7
    //   229: invokespecial 234	java/io/File:<init>	(Ljava/lang/String;)V
    //   232: astore 6
    //   234: new 232	java/io/File
    //   237: dup
    //   238: aload 6
    //   240: invokevirtual 237	java/io/File:getParent	()Ljava/lang/String;
    //   243: invokespecial 234	java/io/File:<init>	(Ljava/lang/String;)V
    //   246: astore_2
    //   247: aload_2
    //   248: invokevirtual 240	java/io/File:exists	()Z
    //   251: ifeq +10 -> 261
    //   254: aload_2
    //   255: invokevirtual 243	java/io/File:isDirectory	()Z
    //   258: ifne +8 -> 266
    //   261: aload_2
    //   262: invokevirtual 246	java/io/File:mkdirs	()Z
    //   265: pop
    //   266: aload 6
    //   268: invokevirtual 240	java/io/File:exists	()Z
    //   271: ifeq +11 -> 282
    //   274: aload 6
    //   276: invokevirtual 249	java/io/File:isFile	()Z
    //   279: ifne +9 -> 288
    //   282: aload 6
    //   284: invokevirtual 252	java/io/File:createNewFile	()Z
    //   287: pop
    //   288: new 254	java/io/FileOutputStream
    //   291: dup
    //   292: aload 6
    //   294: invokespecial 257	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   297: astore_2
    //   298: aload_3
    //   299: getstatic 263	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   302: bipush 60
    //   304: aload_2
    //   305: invokevirtual 267	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   308: pop
    //   309: aload_2
    //   310: invokevirtual 270	java/io/FileOutputStream:flush	()V
    //   313: new 272	java/io/FileInputStream
    //   316: dup
    //   317: aload 6
    //   319: invokespecial 273	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   322: astore_3
    //   323: aload_2
    //   324: astore 5
    //   326: aload_3
    //   327: astore 4
    //   329: aload 6
    //   331: invokevirtual 276	java/io/File:length	()J
    //   334: lstore 9
    //   336: aload_2
    //   337: astore 5
    //   339: aload_3
    //   340: astore 4
    //   342: aload_0
    //   343: aload_3
    //   344: lload 9
    //   346: invokestatic 282	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   349: invokestatic 288	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   352: putfield 290	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTask:g	Ljava/lang/String;
    //   355: aload_2
    //   356: astore 5
    //   358: aload_3
    //   359: astore 4
    //   361: aload_0
    //   362: getfield 290	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTask:g	Ljava/lang/String;
    //   365: invokestatic 296	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   368: ifeq +83 -> 451
    //   371: aload_2
    //   372: astore 5
    //   374: aload_3
    //   375: astore 4
    //   377: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   380: ifeq +38 -> 418
    //   383: aload_2
    //   384: astore 5
    //   386: aload_3
    //   387: astore 4
    //   389: ldc 113
    //   391: iconst_2
    //   392: new 115	java/lang/StringBuilder
    //   395: dup
    //   396: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   399: ldc_w 298
    //   402: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: aload_0
    //   406: getfield 290	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTask:g	Ljava/lang/String;
    //   409: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   415: invokestatic 188	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   418: iconst_0
    //   419: ifeq +11 -> 430
    //   422: new 207	java/lang/NullPointerException
    //   425: dup
    //   426: invokespecial 208	java/lang/NullPointerException:<init>	()V
    //   429: athrow
    //   430: aload_2
    //   431: ifnull +7 -> 438
    //   434: aload_2
    //   435: invokevirtual 301	java/io/FileOutputStream:close	()V
    //   438: aload_3
    //   439: ifnull -432 -> 7
    //   442: aload_3
    //   443: invokevirtual 302	java/io/FileInputStream:close	()V
    //   446: iconst_5
    //   447: ireturn
    //   448: astore_1
    //   449: iconst_5
    //   450: ireturn
    //   451: aload_2
    //   452: astore 5
    //   454: aload_3
    //   455: astore 4
    //   457: aload_0
    //   458: aload_0
    //   459: getfield 290	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTask:g	Ljava/lang/String;
    //   462: ldc -38
    //   464: invokestatic 221	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   467: putfield 304	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTask:f	Ljava/lang/String;
    //   470: aload_2
    //   471: astore 5
    //   473: aload_3
    //   474: astore 4
    //   476: aload 7
    //   478: aload_0
    //   479: getfield 304	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTask:f	Ljava/lang/String;
    //   482: invokestatic 307	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   485: istore 11
    //   487: iload 11
    //   489: ifne +36 -> 525
    //   492: iconst_0
    //   493: ifeq +11 -> 504
    //   496: new 207	java/lang/NullPointerException
    //   499: dup
    //   500: invokespecial 208	java/lang/NullPointerException:<init>	()V
    //   503: athrow
    //   504: aload_2
    //   505: ifnull +7 -> 512
    //   508: aload_2
    //   509: invokevirtual 301	java/io/FileOutputStream:close	()V
    //   512: aload_3
    //   513: ifnull -506 -> 7
    //   516: aload_3
    //   517: invokevirtual 302	java/io/FileInputStream:close	()V
    //   520: iconst_5
    //   521: ireturn
    //   522: astore_1
    //   523: iconst_5
    //   524: ireturn
    //   525: aload_2
    //   526: astore 5
    //   528: aload_3
    //   529: astore 4
    //   531: aload_1
    //   532: lload 9
    //   534: invokestatic 313	android/text/format/Formatter:formatFileSize	(Landroid/content/Context;J)Ljava/lang/String;
    //   537: astore_1
    //   538: aload_2
    //   539: astore 5
    //   541: aload_3
    //   542: astore 4
    //   544: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   547: ifeq +35 -> 582
    //   550: aload_2
    //   551: astore 5
    //   553: aload_3
    //   554: astore 4
    //   556: ldc 113
    //   558: iconst_2
    //   559: new 115	java/lang/StringBuilder
    //   562: dup
    //   563: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   566: ldc_w 315
    //   569: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   572: aload_1
    //   573: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   579: invokestatic 188	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   582: aload_2
    //   583: astore 5
    //   585: aload_3
    //   586: astore 4
    //   588: aload_0
    //   589: getfield 66	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTask:jdField_b_of_type_Long	J
    //   592: lconst_0
    //   593: lcmp
    //   594: ifne +20 -> 614
    //   597: aload_2
    //   598: astore 5
    //   600: aload_3
    //   601: astore 4
    //   603: aload_0
    //   604: aload_0
    //   605: getfield 58	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   608: invokestatic 317	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Ljava/lang/String;)J
    //   611: putfield 66	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$SendVideoTask:jdField_b_of_type_Long	J
    //   614: iconst_0
    //   615: ifeq +11 -> 626
    //   618: new 207	java/lang/NullPointerException
    //   621: dup
    //   622: invokespecial 208	java/lang/NullPointerException:<init>	()V
    //   625: athrow
    //   626: aload_2
    //   627: ifnull +7 -> 634
    //   630: aload_2
    //   631: invokevirtual 301	java/io/FileOutputStream:close	()V
    //   634: aload_3
    //   635: ifnull +7 -> 642
    //   638: aload_3
    //   639: invokevirtual 302	java/io/FileInputStream:close	()V
    //   642: iconst_1
    //   643: ireturn
    //   644: astore_1
    //   645: aconst_null
    //   646: astore_2
    //   647: aconst_null
    //   648: astore_3
    //   649: aload_2
    //   650: astore 5
    //   652: aload_3
    //   653: astore 4
    //   655: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   658: ifeq +19 -> 677
    //   661: aload_2
    //   662: astore 5
    //   664: aload_3
    //   665: astore 4
    //   667: ldc 113
    //   669: iconst_2
    //   670: ldc_w 319
    //   673: aload_1
    //   674: invokestatic 322	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   677: iconst_3
    //   678: istore 8
    //   680: iconst_0
    //   681: ifeq +11 -> 692
    //   684: new 207	java/lang/NullPointerException
    //   687: dup
    //   688: invokespecial 208	java/lang/NullPointerException:<init>	()V
    //   691: athrow
    //   692: aload_2
    //   693: ifnull +7 -> 700
    //   696: aload_2
    //   697: invokevirtual 301	java/io/FileOutputStream:close	()V
    //   700: aload_3
    //   701: ifnull -694 -> 7
    //   704: aload_3
    //   705: invokevirtual 302	java/io/FileInputStream:close	()V
    //   708: iconst_3
    //   709: ireturn
    //   710: astore_1
    //   711: iconst_3
    //   712: ireturn
    //   713: astore_3
    //   714: aconst_null
    //   715: astore_2
    //   716: aconst_null
    //   717: astore_1
    //   718: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   721: ifeq +13 -> 734
    //   724: ldc 113
    //   726: iconst_2
    //   727: ldc_w 319
    //   730: aload_3
    //   731: invokestatic 322	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   734: iconst_0
    //   735: ifeq +11 -> 746
    //   738: new 207	java/lang/NullPointerException
    //   741: dup
    //   742: invokespecial 208	java/lang/NullPointerException:<init>	()V
    //   745: athrow
    //   746: aload_2
    //   747: ifnull +7 -> 754
    //   750: aload_2
    //   751: invokevirtual 301	java/io/FileOutputStream:close	()V
    //   754: aload_1
    //   755: ifnull -748 -> 7
    //   758: aload_1
    //   759: invokevirtual 302	java/io/FileInputStream:close	()V
    //   762: iconst_5
    //   763: ireturn
    //   764: astore_1
    //   765: iconst_5
    //   766: ireturn
    //   767: astore_1
    //   768: aconst_null
    //   769: astore_2
    //   770: aconst_null
    //   771: astore_3
    //   772: aload_2
    //   773: astore 5
    //   775: aload_3
    //   776: astore 4
    //   778: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   781: ifeq +19 -> 800
    //   784: aload_2
    //   785: astore 5
    //   787: aload_3
    //   788: astore 4
    //   790: ldc 113
    //   792: iconst_2
    //   793: ldc_w 324
    //   796: aload_1
    //   797: invokestatic 322	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   800: iconst_4
    //   801: istore 8
    //   803: iconst_0
    //   804: ifeq +11 -> 815
    //   807: new 207	java/lang/NullPointerException
    //   810: dup
    //   811: invokespecial 208	java/lang/NullPointerException:<init>	()V
    //   814: athrow
    //   815: aload_2
    //   816: ifnull +7 -> 823
    //   819: aload_2
    //   820: invokevirtual 301	java/io/FileOutputStream:close	()V
    //   823: aload_3
    //   824: ifnull -817 -> 7
    //   827: aload_3
    //   828: invokevirtual 302	java/io/FileInputStream:close	()V
    //   831: iconst_4
    //   832: ireturn
    //   833: astore_1
    //   834: iconst_4
    //   835: ireturn
    //   836: astore_1
    //   837: aconst_null
    //   838: astore_2
    //   839: aconst_null
    //   840: astore 4
    //   842: iconst_0
    //   843: ifeq +11 -> 854
    //   846: new 207	java/lang/NullPointerException
    //   849: dup
    //   850: invokespecial 208	java/lang/NullPointerException:<init>	()V
    //   853: athrow
    //   854: aload_2
    //   855: ifnull +7 -> 862
    //   858: aload_2
    //   859: invokevirtual 301	java/io/FileOutputStream:close	()V
    //   862: aload 4
    //   864: ifnull +8 -> 872
    //   867: aload 4
    //   869: invokevirtual 302	java/io/FileInputStream:close	()V
    //   872: aload_1
    //   873: athrow
    //   874: astore_1
    //   875: goto -730 -> 145
    //   878: astore_1
    //   879: goto -722 -> 157
    //   882: astore_1
    //   883: goto -714 -> 169
    //   886: astore_1
    //   887: goto -780 -> 107
    //   890: astore_1
    //   891: goto -772 -> 119
    //   894: astore_1
    //   895: goto -764 -> 131
    //   898: astore_1
    //   899: goto -469 -> 430
    //   902: astore_1
    //   903: goto -465 -> 438
    //   906: astore_1
    //   907: goto -403 -> 504
    //   910: astore_1
    //   911: goto -399 -> 512
    //   914: astore_1
    //   915: goto -289 -> 626
    //   918: astore_1
    //   919: goto -285 -> 634
    //   922: astore_1
    //   923: goto -281 -> 642
    //   926: astore_1
    //   927: goto -235 -> 692
    //   930: astore_1
    //   931: goto -231 -> 700
    //   934: astore_3
    //   935: goto -189 -> 746
    //   938: astore_2
    //   939: goto -185 -> 754
    //   942: astore_1
    //   943: goto -128 -> 815
    //   946: astore_1
    //   947: goto -124 -> 823
    //   950: astore_3
    //   951: goto -97 -> 854
    //   954: astore_2
    //   955: goto -93 -> 862
    //   958: astore_2
    //   959: goto -87 -> 872
    //   962: astore_1
    //   963: aconst_null
    //   964: astore 4
    //   966: goto -124 -> 842
    //   969: astore_1
    //   970: aload 5
    //   972: astore_2
    //   973: goto -131 -> 842
    //   976: astore_3
    //   977: aload_1
    //   978: astore 4
    //   980: aload_3
    //   981: astore_1
    //   982: goto -140 -> 842
    //   985: astore_1
    //   986: aconst_null
    //   987: astore_3
    //   988: goto -216 -> 772
    //   991: astore_1
    //   992: goto -220 -> 772
    //   995: astore_3
    //   996: aconst_null
    //   997: astore_1
    //   998: goto -280 -> 718
    //   1001: astore 4
    //   1003: aload_3
    //   1004: astore_1
    //   1005: aload 4
    //   1007: astore_3
    //   1008: goto -290 -> 718
    //   1011: astore_1
    //   1012: aconst_null
    //   1013: astore_3
    //   1014: goto -365 -> 649
    //   1017: astore_1
    //   1018: goto -369 -> 649
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1021	0	this	SendVideoTask
    //   0	1021	1	paramContext	Context
    //   18	841	2	localObject1	Object
    //   938	1	2	localIOException1	java.io.IOException
    //   954	1	2	localIOException2	java.io.IOException
    //   958	1	2	localIOException3	java.io.IOException
    //   972	1	2	localObject2	Object
    //   20	685	3	localObject3	Object
    //   713	18	3	localException1	Exception
    //   771	57	3	localObject4	Object
    //   934	1	3	localIOException4	java.io.IOException
    //   950	1	3	localIOException5	java.io.IOException
    //   976	5	3	localObject5	Object
    //   987	1	3	localObject6	Object
    //   995	9	3	localException2	Exception
    //   1007	7	3	localObject7	Object
    //   327	652	4	localObject8	Object
    //   1001	5	4	localException3	Exception
    //   324	647	5	localObject9	Object
    //   232	98	6	localFile	java.io.File
    //   197	280	7	str	String
    //   1	801	8	i	int
    //   334	199	9	l	long
    //   485	3	11	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   442	446	448	java/io/IOException
    //   516	520	522	java/io/IOException
    //   10	19	644	java/io/IOException
    //   25	39	644	java/io/IOException
    //   39	51	644	java/io/IOException
    //   51	81	644	java/io/IOException
    //   81	95	644	java/io/IOException
    //   171	261	644	java/io/IOException
    //   261	266	644	java/io/IOException
    //   266	282	644	java/io/IOException
    //   282	288	644	java/io/IOException
    //   288	298	644	java/io/IOException
    //   704	708	710	java/io/IOException
    //   10	19	713	java/lang/Exception
    //   25	39	713	java/lang/Exception
    //   39	51	713	java/lang/Exception
    //   51	81	713	java/lang/Exception
    //   81	95	713	java/lang/Exception
    //   171	261	713	java/lang/Exception
    //   261	266	713	java/lang/Exception
    //   266	282	713	java/lang/Exception
    //   282	288	713	java/lang/Exception
    //   288	298	713	java/lang/Exception
    //   758	762	764	java/io/IOException
    //   10	19	767	java/lang/OutOfMemoryError
    //   25	39	767	java/lang/OutOfMemoryError
    //   39	51	767	java/lang/OutOfMemoryError
    //   51	81	767	java/lang/OutOfMemoryError
    //   81	95	767	java/lang/OutOfMemoryError
    //   171	261	767	java/lang/OutOfMemoryError
    //   261	266	767	java/lang/OutOfMemoryError
    //   266	282	767	java/lang/OutOfMemoryError
    //   282	288	767	java/lang/OutOfMemoryError
    //   288	298	767	java/lang/OutOfMemoryError
    //   827	831	833	java/io/IOException
    //   10	19	836	finally
    //   25	39	836	finally
    //   39	51	836	finally
    //   51	81	836	finally
    //   81	95	836	finally
    //   171	261	836	finally
    //   261	266	836	finally
    //   266	282	836	finally
    //   282	288	836	finally
    //   288	298	836	finally
    //   137	145	874	java/io/IOException
    //   149	157	878	java/io/IOException
    //   161	169	882	java/io/IOException
    //   99	107	886	java/io/IOException
    //   111	119	890	java/io/IOException
    //   123	131	894	java/io/IOException
    //   422	430	898	java/io/IOException
    //   434	438	902	java/io/IOException
    //   496	504	906	java/io/IOException
    //   508	512	910	java/io/IOException
    //   618	626	914	java/io/IOException
    //   630	634	918	java/io/IOException
    //   638	642	922	java/io/IOException
    //   684	692	926	java/io/IOException
    //   696	700	930	java/io/IOException
    //   738	746	934	java/io/IOException
    //   750	754	938	java/io/IOException
    //   807	815	942	java/io/IOException
    //   819	823	946	java/io/IOException
    //   846	854	950	java/io/IOException
    //   858	862	954	java/io/IOException
    //   867	872	958	java/io/IOException
    //   298	323	962	finally
    //   329	336	969	finally
    //   342	355	969	finally
    //   361	371	969	finally
    //   377	383	969	finally
    //   389	418	969	finally
    //   457	470	969	finally
    //   476	487	969	finally
    //   531	538	969	finally
    //   544	550	969	finally
    //   556	582	969	finally
    //   588	597	969	finally
    //   603	614	969	finally
    //   655	661	969	finally
    //   667	677	969	finally
    //   778	784	969	finally
    //   790	800	969	finally
    //   718	734	976	finally
    //   298	323	985	java/lang/OutOfMemoryError
    //   329	336	991	java/lang/OutOfMemoryError
    //   342	355	991	java/lang/OutOfMemoryError
    //   361	371	991	java/lang/OutOfMemoryError
    //   377	383	991	java/lang/OutOfMemoryError
    //   389	418	991	java/lang/OutOfMemoryError
    //   457	470	991	java/lang/OutOfMemoryError
    //   476	487	991	java/lang/OutOfMemoryError
    //   531	538	991	java/lang/OutOfMemoryError
    //   544	550	991	java/lang/OutOfMemoryError
    //   556	582	991	java/lang/OutOfMemoryError
    //   588	597	991	java/lang/OutOfMemoryError
    //   603	614	991	java/lang/OutOfMemoryError
    //   298	323	995	java/lang/Exception
    //   329	336	1001	java/lang/Exception
    //   342	355	1001	java/lang/Exception
    //   361	371	1001	java/lang/Exception
    //   377	383	1001	java/lang/Exception
    //   389	418	1001	java/lang/Exception
    //   457	470	1001	java/lang/Exception
    //   476	487	1001	java/lang/Exception
    //   531	538	1001	java/lang/Exception
    //   544	550	1001	java/lang/Exception
    //   556	582	1001	java/lang/Exception
    //   588	597	1001	java/lang/Exception
    //   603	614	1001	java/lang/Exception
    //   298	323	1011	java/io/IOException
    //   329	336	1017	java/io/IOException
    //   342	355	1017	java/io/IOException
    //   361	371	1017	java/io/IOException
    //   377	383	1017	java/io/IOException
    //   389	418	1017	java/io/IOException
    //   457	470	1017	java/io/IOException
    //   476	487	1017	java/io/IOException
    //   531	538	1017	java/io/IOException
    //   544	550	1017	java/io/IOException
    //   556	582	1017	java/io/IOException
    //   588	597	1017	java/io/IOException
    //   603	614	1017	java/io/IOException
  }
  
  protected Integer a(Void... paramVarArgs)
  {
    return Integer.valueOf(a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()));
  }
  
  void a()
  {
    if (this.jdField_b_of_type_Boolean) {}
    for (;;)
    {
      return;
      try
      {
        if (this.jdField_a_of_type_AndroidAppProgressDialog != null)
        {
          this.jdField_a_of_type_AndroidAppProgressDialog.cancel();
          return;
        }
      }
      catch (Exception localException) {}
    }
  }
  
  void a(Context paramContext, int paramInt)
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_AndroidAppProgressDialog == null) {
          break label63;
        }
        a();
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
        if (this.jdField_a_of_type_AndroidAppProgressDialog.isShowing()) {
          break;
        }
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        return;
      }
      catch (Throwable paramContext) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("SendVideoActivity", 2, "showProgressDialog", paramContext);
      return;
      label63:
      this.jdField_a_of_type_AndroidAppProgressDialog = new ProgressDialog(paramContext, 2131558973);
      this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(true);
      this.jdField_a_of_type_AndroidAppProgressDialog.show();
      this.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2130903453);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131298665));
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
      paramInteger.putExtra("file_source", this.jdField_d_of_type_JavaLangString);
      paramInteger.putExtra("thumbfile_send_path", this.f);
      paramInteger.putExtra("file_shortvideo_md5", this.jdField_e_of_type_JavaLangString);
      paramInteger.putExtra("thumbfile_send_width", this.jdField_b_of_type_Int);
      paramInteger.putExtra("thumbfile_send_height", this.jdField_c_of_type_Int);
      paramInteger.putExtra("thumbfile_md5", this.g);
      paramInteger.putExtra("file_width", this.jdField_d_of_type_Int);
      paramInteger.putExtra("file_height", this.jdField_e_of_type_Int);
      Object localObject1;
      if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.equals(ShortVideoPreviewActivity.class.getName())))
      {
        paramInteger.putExtra("file_send_business_type", 2);
        localObject1 = ShortVideoBusiManager.a(0, 2);
        ((ShortVideoReq)localObject1).a(ShortVideoBusiManager.a(2, paramInteger, (ShortVideoReq)localObject1));
        ShortVideoBusiManager.a((ShortVideoReq)localObject1, ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).app);
      }
      while (!this.jdField_b_of_type_Boolean)
      {
        localObject1 = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getIntent();
        if (((Intent)localObject1).getBooleanExtra("start_init_activity_after_sended", true))
        {
          localObject2 = ((Intent)localObject1).getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
          paramInteger.setClassName(((Intent)localObject1).getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME"), (String)localObject2);
          if (QLog.isColorLevel()) {
            QLog.d("SendVideoActivity", 2, "SendVideoTask onPostExecute() INIT_ACTIVITY_CLASS_NAME=" + (String)localObject2);
          }
          paramInteger.addFlags(603979776);
          ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).startActivity(paramInteger);
        }
        ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).finish();
        ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).overridePendingTransition(0, 2130968586);
        return;
        paramInteger.putExtra("file_send_business_type", 0);
        Object localObject2 = ShortVideoBusiManager.a(0, 0);
        localObject1 = ShortVideoBusiManager.a(0, paramInteger, (ShortVideoReq)localObject2);
        ((ShortVideoReq)localObject2).a((ShortVideoUploadInfo)localObject1);
        localObject2 = new AioShortVideoOperator(((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).app);
        ((AioShortVideoOperator)localObject2).a(((AioShortVideoOperator)localObject2).a((ShortVideoUploadInfo)localObject1));
      }
    case 2: 
    case 6: 
      a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131371525, this.jdField_b_of_type_Boolean);
      return;
    case 3: 
      a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131371532, this.jdField_b_of_type_Boolean);
      return;
    case 4: 
      a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131371530, this.jdField_b_of_type_Boolean);
      return;
    }
    a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131371533, this.jdField_b_of_type_Boolean);
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131370344);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\shortvideo\SendVideoActivity$SendVideoTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */