package com.tencent.device.file;

import android.content.Intent;
import com.tencent.device.msg.data.MessageForDevShortVideo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForRichText;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator;
import com.tencent.mobileqq.shortvideo.ShortVideoDownloadInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoForwardInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.ShortVideoUploadInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUploadInfo.RetryInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import jxd;
import mqq.os.MqqHandler;
import tencent.im.msg.im_msg_body.RichText;

public class DevShortVideoOperator
  extends BaseShortVideoOprerator
{
  private static final String h = "DeviceShortVideoOperator";
  public int a;
  public long a;
  public String a;
  public int b;
  public long b;
  public String b;
  public int c;
  public String c;
  public String d;
  public String e;
  
  public DevShortVideoOperator() {}
  
  public DevShortVideoOperator(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void b(ShortVideoUploadInfo paramShortVideoUploadInfo)
  {
    ThreadManager.b().post(new jxd(this, paramShortVideoUploadInfo));
  }
  
  /* Error */
  public int a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore_3
    //   5: aconst_null
    //   6: astore 6
    //   8: aconst_null
    //   9: astore 4
    //   11: aconst_null
    //   12: aload_0
    //   13: getfield 55	com/tencent/device/file/DevShortVideoOperator:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   16: invokestatic 60	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Landroid/content/Context;Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   19: astore_1
    //   20: aload_1
    //   21: ifnonnull +55 -> 76
    //   24: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   27: ifeq +11 -> 38
    //   30: ldc 8
    //   32: iconst_2
    //   33: ldc 68
    //   35: invokestatic 71	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   38: iconst_0
    //   39: ifeq +11 -> 50
    //   42: new 73	java/lang/NullPointerException
    //   45: dup
    //   46: invokespecial 74	java/lang/NullPointerException:<init>	()V
    //   49: athrow
    //   50: iconst_0
    //   51: ifeq +11 -> 62
    //   54: new 73	java/lang/NullPointerException
    //   57: dup
    //   58: invokespecial 74	java/lang/NullPointerException:<init>	()V
    //   61: athrow
    //   62: iconst_0
    //   63: ifeq +11 -> 74
    //   66: new 73	java/lang/NullPointerException
    //   69: dup
    //   70: invokespecial 74	java/lang/NullPointerException:<init>	()V
    //   73: athrow
    //   74: iconst_m1
    //   75: ireturn
    //   76: aload_1
    //   77: invokestatic 77	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   80: astore 7
    //   82: aload 7
    //   84: ifnonnull +56 -> 140
    //   87: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   90: ifeq +11 -> 101
    //   93: ldc 8
    //   95: iconst_2
    //   96: ldc 79
    //   98: invokestatic 71	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   101: iconst_0
    //   102: ifeq +11 -> 113
    //   105: new 73	java/lang/NullPointerException
    //   108: dup
    //   109: invokespecial 74	java/lang/NullPointerException:<init>	()V
    //   112: athrow
    //   113: iconst_0
    //   114: ifeq +11 -> 125
    //   117: new 73	java/lang/NullPointerException
    //   120: dup
    //   121: invokespecial 74	java/lang/NullPointerException:<init>	()V
    //   124: athrow
    //   125: iconst_0
    //   126: ifeq -52 -> 74
    //   129: new 73	java/lang/NullPointerException
    //   132: dup
    //   133: invokespecial 74	java/lang/NullPointerException:<init>	()V
    //   136: athrow
    //   137: astore_1
    //   138: iconst_m1
    //   139: ireturn
    //   140: aload_0
    //   141: aload 7
    //   143: invokevirtual 84	android/graphics/Bitmap:getWidth	()I
    //   146: putfield 86	com/tencent/device/file/DevShortVideoOperator:jdField_b_of_type_Int	I
    //   149: aload_0
    //   150: aload 7
    //   152: invokevirtual 89	android/graphics/Bitmap:getHeight	()I
    //   155: putfield 91	com/tencent/device/file/DevShortVideoOperator:jdField_c_of_type_Int	I
    //   158: new 93	java/io/File
    //   161: dup
    //   162: aload_0
    //   163: getfield 55	com/tencent/device/file/DevShortVideoOperator:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   166: invokespecial 96	java/io/File:<init>	(Ljava/lang/String;)V
    //   169: astore_1
    //   170: aload_0
    //   171: aload_1
    //   172: invokevirtual 100	java/io/File:length	()J
    //   175: putfield 102	com/tencent/device/file/DevShortVideoOperator:jdField_a_of_type_Long	J
    //   178: new 104	java/io/FileInputStream
    //   181: dup
    //   182: aload_1
    //   183: invokespecial 107	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   186: astore_2
    //   187: aload_0
    //   188: aload_2
    //   189: aload_0
    //   190: getfield 102	com/tencent/device/file/DevShortVideoOperator:jdField_a_of_type_Long	J
    //   193: invokestatic 113	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   196: invokestatic 119	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   199: putfield 121	com/tencent/device/file/DevShortVideoOperator:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   202: aload_0
    //   203: getfield 121	com/tencent/device/file/DevShortVideoOperator:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   206: invokestatic 127	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   209: ifeq +72 -> 281
    //   212: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   215: ifeq +31 -> 246
    //   218: ldc 8
    //   220: iconst_2
    //   221: new 129	java/lang/StringBuilder
    //   224: dup
    //   225: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   228: ldc -124
    //   230: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: aload_0
    //   234: getfield 121	com/tencent/device/file/DevShortVideoOperator:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   237: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   243: invokestatic 71	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   246: aload_2
    //   247: ifnull +7 -> 254
    //   250: aload_2
    //   251: invokevirtual 143	java/io/FileInputStream:close	()V
    //   254: iconst_0
    //   255: ifeq +11 -> 266
    //   258: new 73	java/lang/NullPointerException
    //   261: dup
    //   262: invokespecial 74	java/lang/NullPointerException:<init>	()V
    //   265: athrow
    //   266: iconst_0
    //   267: ifeq -193 -> 74
    //   270: new 73	java/lang/NullPointerException
    //   273: dup
    //   274: invokespecial 74	java/lang/NullPointerException:<init>	()V
    //   277: athrow
    //   278: astore_1
    //   279: iconst_m1
    //   280: ireturn
    //   281: aload_0
    //   282: getfield 121	com/tencent/device/file/DevShortVideoOperator:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   285: ldc -111
    //   287: invokestatic 148	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   290: astore 8
    //   292: new 129	java/lang/StringBuilder
    //   295: dup
    //   296: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   299: invokestatic 150	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	()Ljava/lang/String;
    //   302: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: ldc -104
    //   307: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   313: invokestatic 156	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)V
    //   316: new 93	java/io/File
    //   319: dup
    //   320: aload 8
    //   322: invokespecial 96	java/io/File:<init>	(Ljava/lang/String;)V
    //   325: astore 9
    //   327: new 93	java/io/File
    //   330: dup
    //   331: aload 9
    //   333: invokevirtual 159	java/io/File:getParent	()Ljava/lang/String;
    //   336: invokespecial 96	java/io/File:<init>	(Ljava/lang/String;)V
    //   339: astore_1
    //   340: aload_1
    //   341: invokevirtual 162	java/io/File:exists	()Z
    //   344: ifeq +10 -> 354
    //   347: aload_1
    //   348: invokevirtual 165	java/io/File:isDirectory	()Z
    //   351: ifne +8 -> 359
    //   354: aload_1
    //   355: invokevirtual 168	java/io/File:mkdirs	()Z
    //   358: pop
    //   359: aload 9
    //   361: invokevirtual 162	java/io/File:exists	()Z
    //   364: ifeq +11 -> 375
    //   367: aload 9
    //   369: invokevirtual 171	java/io/File:isFile	()Z
    //   372: ifne +9 -> 381
    //   375: aload 9
    //   377: invokevirtual 174	java/io/File:createNewFile	()Z
    //   380: pop
    //   381: new 176	java/io/FileOutputStream
    //   384: dup
    //   385: aload 9
    //   387: invokespecial 177	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   390: astore_1
    //   391: aload 7
    //   393: getstatic 183	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   396: bipush 50
    //   398: aload_1
    //   399: invokevirtual 187	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   402: pop
    //   403: aload_1
    //   404: invokevirtual 190	java/io/FileOutputStream:flush	()V
    //   407: new 104	java/io/FileInputStream
    //   410: dup
    //   411: aload 9
    //   413: invokespecial 107	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   416: astore_3
    //   417: aload_0
    //   418: aload_3
    //   419: aload 9
    //   421: invokevirtual 100	java/io/File:length	()J
    //   424: invokestatic 113	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   427: invokestatic 119	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   430: putfield 192	com/tencent/device/file/DevShortVideoOperator:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   433: aload_0
    //   434: getfield 192	com/tencent/device/file/DevShortVideoOperator:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   437: invokestatic 127	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   440: ifeq +66 -> 506
    //   443: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   446: ifeq +31 -> 477
    //   449: ldc 8
    //   451: iconst_2
    //   452: new 129	java/lang/StringBuilder
    //   455: dup
    //   456: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   459: ldc -62
    //   461: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: aload_0
    //   465: getfield 192	com/tencent/device/file/DevShortVideoOperator:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   468: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   474: invokestatic 71	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   477: aload_2
    //   478: ifnull +7 -> 485
    //   481: aload_2
    //   482: invokevirtual 143	java/io/FileInputStream:close	()V
    //   485: aload_1
    //   486: ifnull +7 -> 493
    //   489: aload_1
    //   490: invokevirtual 195	java/io/FileOutputStream:close	()V
    //   493: aload_3
    //   494: ifnull -420 -> 74
    //   497: aload_3
    //   498: invokevirtual 143	java/io/FileInputStream:close	()V
    //   501: iconst_m1
    //   502: ireturn
    //   503: astore_1
    //   504: iconst_m1
    //   505: ireturn
    //   506: aload_0
    //   507: aload_0
    //   508: getfield 192	com/tencent/device/file/DevShortVideoOperator:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   511: ldc -111
    //   513: invokestatic 148	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   516: putfield 197	com/tencent/device/file/DevShortVideoOperator:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   519: aload 8
    //   521: aload_0
    //   522: getfield 197	com/tencent/device/file/DevShortVideoOperator:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   525: invokestatic 200	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   528: istore 10
    //   530: iload 10
    //   532: ifne +32 -> 564
    //   535: aload_2
    //   536: ifnull +7 -> 543
    //   539: aload_2
    //   540: invokevirtual 143	java/io/FileInputStream:close	()V
    //   543: aload_1
    //   544: ifnull +7 -> 551
    //   547: aload_1
    //   548: invokevirtual 195	java/io/FileOutputStream:close	()V
    //   551: aload_3
    //   552: ifnull -478 -> 74
    //   555: aload_3
    //   556: invokevirtual 143	java/io/FileInputStream:close	()V
    //   559: iconst_m1
    //   560: ireturn
    //   561: astore_1
    //   562: iconst_m1
    //   563: ireturn
    //   564: aload_0
    //   565: getfield 202	com/tencent/device/file/DevShortVideoOperator:jdField_b_of_type_Long	J
    //   568: lconst_0
    //   569: lcmp
    //   570: ifne +14 -> 584
    //   573: aload_0
    //   574: aload_0
    //   575: getfield 55	com/tencent/device/file/DevShortVideoOperator:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   578: invokestatic 205	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Ljava/lang/String;)J
    //   581: putfield 202	com/tencent/device/file/DevShortVideoOperator:jdField_b_of_type_Long	J
    //   584: aload_2
    //   585: ifnull +7 -> 592
    //   588: aload_2
    //   589: invokevirtual 143	java/io/FileInputStream:close	()V
    //   592: aload_1
    //   593: ifnull +7 -> 600
    //   596: aload_1
    //   597: invokevirtual 195	java/io/FileOutputStream:close	()V
    //   600: aload_3
    //   601: ifnull +7 -> 608
    //   604: aload_3
    //   605: invokevirtual 143	java/io/FileInputStream:close	()V
    //   608: iconst_0
    //   609: ireturn
    //   610: astore_3
    //   611: aconst_null
    //   612: astore_1
    //   613: aconst_null
    //   614: astore_2
    //   615: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   618: ifeq +12 -> 630
    //   621: ldc 8
    //   623: iconst_2
    //   624: ldc -49
    //   626: aload_3
    //   627: invokestatic 210	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   630: aload_2
    //   631: ifnull +7 -> 638
    //   634: aload_2
    //   635: invokevirtual 143	java/io/FileInputStream:close	()V
    //   638: aload 4
    //   640: ifnull +8 -> 648
    //   643: aload 4
    //   645: invokevirtual 195	java/io/FileOutputStream:close	()V
    //   648: aload_1
    //   649: ifnull -575 -> 74
    //   652: aload_1
    //   653: invokevirtual 143	java/io/FileInputStream:close	()V
    //   656: iconst_m1
    //   657: ireturn
    //   658: astore_1
    //   659: iconst_m1
    //   660: ireturn
    //   661: astore 4
    //   663: aconst_null
    //   664: astore_1
    //   665: aconst_null
    //   666: astore 7
    //   668: aload 5
    //   670: astore 6
    //   672: aload_1
    //   673: astore_3
    //   674: aload 7
    //   676: astore_2
    //   677: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   680: ifeq +22 -> 702
    //   683: aload 5
    //   685: astore 6
    //   687: aload_1
    //   688: astore_3
    //   689: aload 7
    //   691: astore_2
    //   692: ldc 8
    //   694: iconst_2
    //   695: ldc -49
    //   697: aload 4
    //   699: invokestatic 210	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   702: aload 7
    //   704: ifnull +8 -> 712
    //   707: aload 7
    //   709: invokevirtual 143	java/io/FileInputStream:close	()V
    //   712: aload 5
    //   714: ifnull +8 -> 722
    //   717: aload 5
    //   719: invokevirtual 195	java/io/FileOutputStream:close	()V
    //   722: aload_1
    //   723: ifnull -649 -> 74
    //   726: aload_1
    //   727: invokevirtual 143	java/io/FileInputStream:close	()V
    //   730: iconst_m1
    //   731: ireturn
    //   732: astore_1
    //   733: iconst_m1
    //   734: ireturn
    //   735: astore 4
    //   737: aconst_null
    //   738: astore_1
    //   739: aconst_null
    //   740: astore 7
    //   742: aload_3
    //   743: astore 5
    //   745: aload 5
    //   747: astore 6
    //   749: aload_1
    //   750: astore_3
    //   751: aload 7
    //   753: astore_2
    //   754: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   757: ifeq +22 -> 779
    //   760: aload 5
    //   762: astore 6
    //   764: aload_1
    //   765: astore_3
    //   766: aload 7
    //   768: astore_2
    //   769: ldc 8
    //   771: iconst_2
    //   772: ldc -44
    //   774: aload 4
    //   776: invokestatic 210	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   779: aload 7
    //   781: ifnull +8 -> 789
    //   784: aload 7
    //   786: invokevirtual 143	java/io/FileInputStream:close	()V
    //   789: aload 5
    //   791: ifnull +8 -> 799
    //   794: aload 5
    //   796: invokevirtual 195	java/io/FileOutputStream:close	()V
    //   799: aload_1
    //   800: ifnull -726 -> 74
    //   803: aload_1
    //   804: invokevirtual 143	java/io/FileInputStream:close	()V
    //   807: iconst_m1
    //   808: ireturn
    //   809: astore_1
    //   810: iconst_m1
    //   811: ireturn
    //   812: astore_1
    //   813: aconst_null
    //   814: astore_3
    //   815: aconst_null
    //   816: astore_2
    //   817: aload 6
    //   819: astore 4
    //   821: aload_2
    //   822: ifnull +7 -> 829
    //   825: aload_2
    //   826: invokevirtual 143	java/io/FileInputStream:close	()V
    //   829: aload 4
    //   831: ifnull +8 -> 839
    //   834: aload 4
    //   836: invokevirtual 195	java/io/FileOutputStream:close	()V
    //   839: aload_3
    //   840: ifnull +7 -> 847
    //   843: aload_3
    //   844: invokevirtual 143	java/io/FileInputStream:close	()V
    //   847: aload_1
    //   848: athrow
    //   849: astore_1
    //   850: goto -800 -> 50
    //   853: astore_1
    //   854: goto -792 -> 62
    //   857: astore_1
    //   858: iconst_m1
    //   859: ireturn
    //   860: astore_1
    //   861: goto -748 -> 113
    //   864: astore_1
    //   865: goto -740 -> 125
    //   868: astore_1
    //   869: goto -615 -> 254
    //   872: astore_1
    //   873: goto -607 -> 266
    //   876: astore_2
    //   877: goto -392 -> 485
    //   880: astore_1
    //   881: goto -388 -> 493
    //   884: astore_2
    //   885: goto -342 -> 543
    //   888: astore_1
    //   889: goto -338 -> 551
    //   892: astore_2
    //   893: goto -301 -> 592
    //   896: astore_1
    //   897: goto -297 -> 600
    //   900: astore_1
    //   901: goto -293 -> 608
    //   904: astore_2
    //   905: goto -267 -> 638
    //   908: astore_2
    //   909: goto -261 -> 648
    //   912: astore_2
    //   913: goto -201 -> 712
    //   916: astore_2
    //   917: goto -195 -> 722
    //   920: astore_2
    //   921: goto -132 -> 789
    //   924: astore_2
    //   925: goto -126 -> 799
    //   928: astore_2
    //   929: goto -100 -> 829
    //   932: astore_2
    //   933: goto -94 -> 839
    //   936: astore_2
    //   937: goto -90 -> 847
    //   940: astore_1
    //   941: aconst_null
    //   942: astore_3
    //   943: aload 6
    //   945: astore 4
    //   947: goto -126 -> 821
    //   950: astore 5
    //   952: aconst_null
    //   953: astore_3
    //   954: aload_1
    //   955: astore 4
    //   957: aload 5
    //   959: astore_1
    //   960: goto -139 -> 821
    //   963: astore 5
    //   965: aload_1
    //   966: astore 4
    //   968: aload 5
    //   970: astore_1
    //   971: goto -150 -> 821
    //   974: astore 5
    //   976: aload_1
    //   977: astore_3
    //   978: aload 5
    //   980: astore_1
    //   981: goto -160 -> 821
    //   984: astore_1
    //   985: aload 6
    //   987: astore 4
    //   989: goto -168 -> 821
    //   992: astore 4
    //   994: aconst_null
    //   995: astore_1
    //   996: aload_3
    //   997: astore 5
    //   999: aload_2
    //   1000: astore 7
    //   1002: goto -257 -> 745
    //   1005: astore 4
    //   1007: aconst_null
    //   1008: astore_3
    //   1009: aload_1
    //   1010: astore 5
    //   1012: aload_3
    //   1013: astore_1
    //   1014: aload_2
    //   1015: astore 7
    //   1017: goto -272 -> 745
    //   1020: astore 4
    //   1022: aload_1
    //   1023: astore 5
    //   1025: aload_3
    //   1026: astore_1
    //   1027: aload_2
    //   1028: astore 7
    //   1030: goto -285 -> 745
    //   1033: astore 4
    //   1035: aconst_null
    //   1036: astore_1
    //   1037: aload_2
    //   1038: astore 7
    //   1040: goto -372 -> 668
    //   1043: astore 4
    //   1045: aconst_null
    //   1046: astore_3
    //   1047: aload_1
    //   1048: astore 5
    //   1050: aload_3
    //   1051: astore_1
    //   1052: aload_2
    //   1053: astore 7
    //   1055: goto -387 -> 668
    //   1058: astore 4
    //   1060: aload_1
    //   1061: astore 5
    //   1063: aload_3
    //   1064: astore_1
    //   1065: aload_2
    //   1066: astore 7
    //   1068: goto -400 -> 668
    //   1071: astore_3
    //   1072: aconst_null
    //   1073: astore_1
    //   1074: goto -459 -> 615
    //   1077: astore_3
    //   1078: aconst_null
    //   1079: astore 5
    //   1081: aload_1
    //   1082: astore 4
    //   1084: aload 5
    //   1086: astore_1
    //   1087: goto -472 -> 615
    //   1090: astore 4
    //   1092: aload_3
    //   1093: astore 5
    //   1095: aload 4
    //   1097: astore_3
    //   1098: aload_1
    //   1099: astore 4
    //   1101: aload 5
    //   1103: astore_1
    //   1104: goto -489 -> 615
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1107	0	this	DevShortVideoOperator
    //   19	58	1	localBitmap	android.graphics.Bitmap
    //   137	1	1	localIOException1	java.io.IOException
    //   169	14	1	localFile1	java.io.File
    //   278	1	1	localIOException2	java.io.IOException
    //   339	151	1	localObject1	Object
    //   503	45	1	localIOException3	java.io.IOException
    //   561	36	1	localIOException4	java.io.IOException
    //   612	41	1	localObject2	Object
    //   658	1	1	localIOException5	java.io.IOException
    //   664	63	1	localObject3	Object
    //   732	1	1	localIOException6	java.io.IOException
    //   738	66	1	localObject4	Object
    //   809	1	1	localIOException7	java.io.IOException
    //   812	36	1	localObject5	Object
    //   849	1	1	localIOException8	java.io.IOException
    //   853	1	1	localIOException9	java.io.IOException
    //   857	1	1	localIOException10	java.io.IOException
    //   860	1	1	localIOException11	java.io.IOException
    //   864	1	1	localIOException12	java.io.IOException
    //   868	1	1	localIOException13	java.io.IOException
    //   872	1	1	localIOException14	java.io.IOException
    //   880	1	1	localIOException15	java.io.IOException
    //   888	1	1	localIOException16	java.io.IOException
    //   896	1	1	localIOException17	java.io.IOException
    //   900	1	1	localIOException18	java.io.IOException
    //   940	15	1	localObject6	Object
    //   959	22	1	localObject7	Object
    //   984	1	1	localObject8	Object
    //   995	109	1	localObject9	Object
    //   186	640	2	localObject10	Object
    //   876	1	2	localIOException19	java.io.IOException
    //   884	1	2	localIOException20	java.io.IOException
    //   892	1	2	localIOException21	java.io.IOException
    //   904	1	2	localIOException22	java.io.IOException
    //   908	1	2	localIOException23	java.io.IOException
    //   912	1	2	localIOException24	java.io.IOException
    //   916	1	2	localIOException25	java.io.IOException
    //   920	1	2	localIOException26	java.io.IOException
    //   924	1	2	localIOException27	java.io.IOException
    //   928	1	2	localIOException28	java.io.IOException
    //   932	1	2	localIOException29	java.io.IOException
    //   936	130	2	localIOException30	java.io.IOException
    //   4	601	3	localFileInputStream	java.io.FileInputStream
    //   610	17	3	localIOException31	java.io.IOException
    //   673	391	3	localObject11	Object
    //   1071	1	3	localIOException32	java.io.IOException
    //   1077	16	3	localIOException33	java.io.IOException
    //   1097	1	3	localObject12	Object
    //   9	635	4	localObject13	Object
    //   661	37	4	localException1	Exception
    //   735	40	4	localOutOfMemoryError1	OutOfMemoryError
    //   819	169	4	localObject14	Object
    //   992	1	4	localOutOfMemoryError2	OutOfMemoryError
    //   1005	1	4	localOutOfMemoryError3	OutOfMemoryError
    //   1020	1	4	localOutOfMemoryError4	OutOfMemoryError
    //   1033	1	4	localException2	Exception
    //   1043	1	4	localException3	Exception
    //   1058	1	4	localException4	Exception
    //   1082	1	4	localObject15	Object
    //   1090	6	4	localIOException34	java.io.IOException
    //   1099	1	4	localObject16	Object
    //   1	794	5	localObject17	Object
    //   950	8	5	localObject18	Object
    //   963	6	5	localObject19	Object
    //   974	5	5	localObject20	Object
    //   997	105	5	localObject21	Object
    //   6	980	6	localObject22	Object
    //   80	987	7	localObject23	Object
    //   290	230	8	str	String
    //   325	95	9	localFile2	java.io.File
    //   528	3	10	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   129	137	137	java/io/IOException
    //   270	278	278	java/io/IOException
    //   497	501	503	java/io/IOException
    //   555	559	561	java/io/IOException
    //   11	20	610	java/io/IOException
    //   24	38	610	java/io/IOException
    //   76	82	610	java/io/IOException
    //   87	101	610	java/io/IOException
    //   140	187	610	java/io/IOException
    //   652	656	658	java/io/IOException
    //   11	20	661	java/lang/Exception
    //   24	38	661	java/lang/Exception
    //   76	82	661	java/lang/Exception
    //   87	101	661	java/lang/Exception
    //   140	187	661	java/lang/Exception
    //   726	730	732	java/io/IOException
    //   11	20	735	java/lang/OutOfMemoryError
    //   24	38	735	java/lang/OutOfMemoryError
    //   76	82	735	java/lang/OutOfMemoryError
    //   87	101	735	java/lang/OutOfMemoryError
    //   140	187	735	java/lang/OutOfMemoryError
    //   803	807	809	java/io/IOException
    //   11	20	812	finally
    //   24	38	812	finally
    //   76	82	812	finally
    //   87	101	812	finally
    //   140	187	812	finally
    //   42	50	849	java/io/IOException
    //   54	62	853	java/io/IOException
    //   66	74	857	java/io/IOException
    //   105	113	860	java/io/IOException
    //   117	125	864	java/io/IOException
    //   250	254	868	java/io/IOException
    //   258	266	872	java/io/IOException
    //   481	485	876	java/io/IOException
    //   489	493	880	java/io/IOException
    //   539	543	884	java/io/IOException
    //   547	551	888	java/io/IOException
    //   588	592	892	java/io/IOException
    //   596	600	896	java/io/IOException
    //   604	608	900	java/io/IOException
    //   634	638	904	java/io/IOException
    //   643	648	908	java/io/IOException
    //   707	712	912	java/io/IOException
    //   717	722	916	java/io/IOException
    //   784	789	920	java/io/IOException
    //   794	799	924	java/io/IOException
    //   825	829	928	java/io/IOException
    //   834	839	932	java/io/IOException
    //   843	847	936	java/io/IOException
    //   187	246	940	finally
    //   281	354	940	finally
    //   354	359	940	finally
    //   359	375	940	finally
    //   375	381	940	finally
    //   381	391	940	finally
    //   391	417	950	finally
    //   417	477	963	finally
    //   506	530	963	finally
    //   564	584	963	finally
    //   615	630	974	finally
    //   677	683	984	finally
    //   692	702	984	finally
    //   754	760	984	finally
    //   769	779	984	finally
    //   187	246	992	java/lang/OutOfMemoryError
    //   281	354	992	java/lang/OutOfMemoryError
    //   354	359	992	java/lang/OutOfMemoryError
    //   359	375	992	java/lang/OutOfMemoryError
    //   375	381	992	java/lang/OutOfMemoryError
    //   381	391	992	java/lang/OutOfMemoryError
    //   391	417	1005	java/lang/OutOfMemoryError
    //   417	477	1020	java/lang/OutOfMemoryError
    //   506	530	1020	java/lang/OutOfMemoryError
    //   564	584	1020	java/lang/OutOfMemoryError
    //   187	246	1033	java/lang/Exception
    //   281	354	1033	java/lang/Exception
    //   354	359	1033	java/lang/Exception
    //   359	375	1033	java/lang/Exception
    //   375	381	1033	java/lang/Exception
    //   381	391	1033	java/lang/Exception
    //   391	417	1043	java/lang/Exception
    //   417	477	1058	java/lang/Exception
    //   506	530	1058	java/lang/Exception
    //   564	584	1058	java/lang/Exception
    //   187	246	1071	java/io/IOException
    //   281	354	1071	java/io/IOException
    //   354	359	1071	java/io/IOException
    //   359	375	1071	java/io/IOException
    //   375	381	1071	java/io/IOException
    //   381	391	1071	java/io/IOException
    //   391	417	1077	java/io/IOException
    //   417	477	1090	java/io/IOException
    //   506	530	1090	java/io/IOException
    //   564	584	1090	java/io/IOException
  }
  
  public MessageRecord a(ShortVideoForwardInfo paramShortVideoForwardInfo)
  {
    return null;
  }
  
  public MessageRecord a(ShortVideoUploadInfo paramShortVideoUploadInfo)
  {
    int i = 0;
    long l = System.currentTimeMillis();
    MessageForDevShortVideo localMessageForDevShortVideo = (MessageForDevShortVideo)MessageRecordFactory.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramShortVideoUploadInfo.jdField_c_of_type_JavaLangString, paramShortVideoUploadInfo.jdField_d_of_type_JavaLangString, paramShortVideoUploadInfo.jdField_b_of_type_Int);
    localMessageForDevShortVideo.videoFileName = paramShortVideoUploadInfo.h;
    if (paramShortVideoUploadInfo.jdField_a_of_type_JavaLangString == null) {
      paramShortVideoUploadInfo.jdField_a_of_type_JavaLangString = "";
    }
    localMessageForDevShortVideo.uuid = paramShortVideoUploadInfo.jdField_a_of_type_JavaLangString;
    if (paramShortVideoUploadInfo.jdField_e_of_type_JavaLangString == null) {
      paramShortVideoUploadInfo.jdField_e_of_type_JavaLangString = "";
    }
    localMessageForDevShortVideo.md5 = paramShortVideoUploadInfo.jdField_e_of_type_JavaLangString;
    localMessageForDevShortVideo.videoFileFormat = 2;
    localMessageForDevShortVideo.videoFileSize = paramShortVideoUploadInfo.jdField_e_of_type_Int;
    localMessageForDevShortVideo.videoFileTime = paramShortVideoUploadInfo.f;
    localMessageForDevShortVideo.thumbWidth = paramShortVideoUploadInfo.jdField_c_of_type_Int;
    localMessageForDevShortVideo.thumbHeight = paramShortVideoUploadInfo.jdField_d_of_type_Int;
    localMessageForDevShortVideo.videoFileStatus = 1002;
    localMessageForDevShortVideo.videoFileProgress = 0;
    localMessageForDevShortVideo.fileType = 19;
    localMessageForDevShortVideo.thumbMD5 = paramShortVideoUploadInfo.jdField_g_of_type_JavaLangString;
    localMessageForDevShortVideo.extraflag = 32772;
    if (paramShortVideoUploadInfo.l == null) {
      paramShortVideoUploadInfo.l = "";
    }
    localMessageForDevShortVideo.fileSource = paramShortVideoUploadInfo.l;
    localMessageForDevShortVideo.lastModified = 0L;
    if (paramShortVideoUploadInfo.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo$RetryInfo != null) {
      i = 1;
    }
    if (i != 0)
    {
      localMessageForDevShortVideo.msgseq = paramShortVideoUploadInfo.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo$RetryInfo.jdField_a_of_type_Long;
      localMessageForDevShortVideo.shmsgseq = paramShortVideoUploadInfo.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo$RetryInfo.jdField_b_of_type_Long;
      localMessageForDevShortVideo.msgUid = paramShortVideoUploadInfo.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo$RetryInfo.c;
    }
    localMessageForDevShortVideo.msg = localMessageForDevShortVideo.getSummary();
    localMessageForDevShortVideo.serial();
    paramShortVideoUploadInfo.jdField_a_of_type_Long = localMessageForDevShortVideo.uniseq;
    Logger.a(this.jdField_g_of_type_JavaLangString, this.f, "packmsg", "cost:" + (System.currentTimeMillis() - l));
    Logger.a(this.jdField_g_of_type_JavaLangString, this.f, "packMsg", "mr: " + localMessageForDevShortVideo.toLogString() + "-" + localMessageForDevShortVideo.toString());
    return localMessageForDevShortVideo;
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    Logger.a(this.jdField_g_of_type_JavaLangString, this.f, "attachRichText2Msg", "");
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForRichText)) {
      ((MessageForRichText)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).richText = paramRichText;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  }
  
  public ShortVideoDownloadInfo a(Object paramObject)
  {
    return null;
  }
  
  public ShortVideoForwardInfo a(Object paramObject, ShortVideoReq paramShortVideoReq)
  {
    return null;
  }
  
  public ShortVideoUploadInfo a(Object paramObject, ShortVideoReq paramShortVideoReq)
  {
    if (paramObject == null)
    {
      Logger.a(this.jdField_g_of_type_JavaLangString, this.f, "createShortVideoUploadInfo", "unknow obj");
      return null;
    }
    Object localObject;
    if ((paramObject instanceof Intent))
    {
      localObject = (Intent)paramObject;
      this.jdField_b_of_type_JavaLangString = ((Intent)localObject).getStringExtra("uin");
      this.jdField_a_of_type_Int = ((Intent)localObject).getIntExtra("uintype", 1003);
      this.jdField_a_of_type_JavaLangString = ((Intent)localObject).getStringExtra("file_send_path");
    }
    for (;;)
    {
      a();
      localObject = new ShortVideoUploadInfo();
      ((ShortVideoUploadInfo)localObject).jdField_c_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      ((ShortVideoUploadInfo)localObject).h = this.jdField_a_of_type_JavaLangString;
      ((ShortVideoUploadInfo)localObject).j = this.jdField_d_of_type_JavaLangString;
      ((ShortVideoUploadInfo)localObject).jdField_b_of_type_Int = this.jdField_a_of_type_Int;
      ((ShortVideoUploadInfo)localObject).jdField_d_of_type_JavaLangString = "";
      ((ShortVideoUploadInfo)localObject).jdField_e_of_type_Int = ((int)this.jdField_a_of_type_Long);
      ((ShortVideoUploadInfo)localObject).f = ((int)this.jdField_b_of_type_Long / 1000);
      ((ShortVideoUploadInfo)localObject).jdField_e_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      ((ShortVideoUploadInfo)localObject).jdField_c_of_type_Int = this.jdField_b_of_type_Int;
      ((ShortVideoUploadInfo)localObject).jdField_d_of_type_Int = this.jdField_c_of_type_Int;
      ((ShortVideoUploadInfo)localObject).jdField_g_of_type_Int = paramShortVideoReq.f;
      ((ShortVideoUploadInfo)localObject).jdField_a_of_type_JavaLangObject = paramObject;
      ((ShortVideoUploadInfo)localObject).jdField_g_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
      ((ShortVideoUploadInfo)localObject).l = "";
      Logger.a(this.jdField_g_of_type_JavaLangString, this.f, "createShortVideoUploadInfo", "");
      return (ShortVideoUploadInfo)localObject;
      if ((paramObject instanceof MessageForShortVideo))
      {
        localObject = (MessageForShortVideo)paramObject;
        this.jdField_b_of_type_JavaLangString = ((MessageForShortVideo)localObject).frienduin;
        this.jdField_a_of_type_Int = ((MessageForShortVideo)localObject).istroop;
        this.jdField_a_of_type_Long = ((MessageForShortVideo)localObject).videoFileSize;
        this.jdField_b_of_type_Long = (((MessageForShortVideo)localObject).videoFileTime * 1000);
        this.jdField_a_of_type_JavaLangString = ((MessageForShortVideo)localObject).videoFileName;
        this.jdField_d_of_type_JavaLangString = ShortVideoUtils.a(((MessageForShortVideo)localObject).thumbMD5, "jpg");
        this.jdField_c_of_type_JavaLangString = ((MessageForShortVideo)localObject).md5;
        this.jdField_b_of_type_Int = ((MessageForShortVideo)localObject).thumbWidth;
        this.jdField_c_of_type_Int = ((MessageForShortVideo)localObject).thumbHeight;
        this.jdField_e_of_type_JavaLangString = ((MessageForShortVideo)localObject).thumbMD5;
      }
    }
  }
  
  public void a(UpCallBack.SendResult paramSendResult)
  {
    Logger.a(this.jdField_g_of_type_JavaLangString, this.f, "updateMsg", "resut:" + paramSendResult);
    if (paramSendResult != null)
    {
      MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      localMessageForShortVideo.videoFileSize = ((int)paramSendResult.jdField_a_of_type_Long);
      localMessageForShortVideo.uuid = paramSendResult.jdField_c_of_type_JavaLangString;
      localMessageForShortVideo.md5 = paramSendResult.jdField_d_of_type_JavaLangString;
      localMessageForShortVideo.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq, localMessageForShortVideo.msgData);
    }
  }
  
  public void a(ShortVideoUploadInfo paramShortVideoUploadInfo)
  {
    Logger.a(this.jdField_g_of_type_JavaLangString, this.f, "sendPic.start", "");
    b(paramShortVideoUploadInfo);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\device\file\DevShortVideoOperator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */