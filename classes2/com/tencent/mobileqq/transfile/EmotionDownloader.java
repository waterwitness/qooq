package com.tencent.mobileqq.transfile;

import android.graphics.BitmapFactory;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.GifDrawable;
import com.tencent.image.NativeGifFactory;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.apache.http.Header;

public class EmotionDownloader
  extends AbsDownloader
  implements EmotionConstants
{
  private static final String S = "EmotionDownloader";
  static File jdField_a_of_type_JavaIoFile;
  static File b;
  public static final String k = "system_face_decode_copyfile";
  public final int a;
  BaseApplicationImpl jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
  public final int b;
  
  public EmotionDownloader(BaseApplicationImpl paramBaseApplicationImpl)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 89500;
    this.jdField_b_of_type_Int = 89501;
    this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl = paramBaseApplicationImpl;
    jdField_b_of_type_JavaIoFile = paramBaseApplicationImpl.getDir("", 0);
  }
  
  /* Error */
  public File a(java.io.OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    // Byte code:
    //   0: getstatic 53	com/tencent/mobileqq/transfile/EmotionDownloader:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   3: ifnull +12 -> 15
    //   6: getstatic 53	com/tencent/mobileqq/transfile/EmotionDownloader:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   9: invokevirtual 59	java/io/File:exists	()Z
    //   12: ifne +55 -> 67
    //   15: aload_0
    //   16: getfield 37	com/tencent/mobileqq/transfile/EmotionDownloader:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   19: ldc 61
    //   21: iconst_0
    //   22: invokevirtual 45	com/tencent/common/app/BaseApplicationImpl:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   25: putstatic 53	com/tencent/mobileqq/transfile/EmotionDownloader:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   28: aload_0
    //   29: getfield 37	com/tencent/mobileqq/transfile/EmotionDownloader:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   32: ldc 63
    //   34: iconst_0
    //   35: invokevirtual 45	com/tencent/common/app/BaseApplicationImpl:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   38: astore_1
    //   39: aload_1
    //   40: invokevirtual 59	java/io/File:exists	()Z
    //   43: ifeq +8 -> 51
    //   46: aload_1
    //   47: invokevirtual 66	java/io/File:delete	()Z
    //   50: pop
    //   51: getstatic 53	com/tencent/mobileqq/transfile/EmotionDownloader:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   54: invokevirtual 59	java/io/File:exists	()Z
    //   57: ifne +10 -> 67
    //   60: getstatic 53	com/tencent/mobileqq/transfile/EmotionDownloader:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   63: invokevirtual 69	java/io/File:mkdirs	()Z
    //   66: pop
    //   67: invokestatic 74	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:a	()Ljava/lang/String;
    //   70: astore_1
    //   71: aload_0
    //   72: getfield 37	com/tencent/mobileqq/transfile/EmotionDownloader:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   75: aload_1
    //   76: invokevirtual 78	com/tencent/common/app/BaseApplicationImpl:getAppRuntime	(Ljava/lang/String;)Lmqq/app/AppRuntime;
    //   79: checkcast 80	com/tencent/mobileqq/app/QQAppInterface
    //   82: astore_1
    //   83: aload_1
    //   84: ifnull +562 -> 646
    //   87: aload_1
    //   88: bipush 76
    //   90: invokevirtual 84	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   93: checkcast 71	com/tencent/mobileqq/earlydownload/EarlyDownloadManager
    //   96: astore_1
    //   97: aload_1
    //   98: ifnull +548 -> 646
    //   101: aload_1
    //   102: ldc 86
    //   104: invokevirtual 89	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/earlydownload/handler/EarlyHandler;
    //   107: checkcast 91	com/tencent/mobileqq/earlydownload/handler/SystemFaceHandler
    //   110: astore_1
    //   111: aload_2
    //   112: getfield 97	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   115: invokevirtual 102	java/net/URL:getHost	()Ljava/lang/String;
    //   118: astore 4
    //   120: new 55	java/io/File
    //   123: dup
    //   124: new 104	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   131: getstatic 53	com/tencent/mobileqq/transfile/EmotionDownloader:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   134: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   137: ldc 111
    //   139: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: aload 4
    //   144: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: invokespecial 120	java/io/File:<init>	(Ljava/lang/String;)V
    //   153: astore_3
    //   154: iconst_0
    //   155: istore 8
    //   157: aload_3
    //   158: invokevirtual 59	java/io/File:exists	()Z
    //   161: ifeq +12 -> 173
    //   164: aload_3
    //   165: invokevirtual 124	java/io/File:length	()J
    //   168: lconst_0
    //   169: lcmp
    //   170: ifne +420 -> 590
    //   173: invokestatic 129	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   176: ifeq +53 -> 229
    //   179: ldc 10
    //   181: iconst_2
    //   182: new 104	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   189: ldc -125
    //   191: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: aload_2
    //   195: getfield 134	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   198: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: ldc -120
    //   203: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: aload 4
    //   208: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: ldc -118
    //   213: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: aload_3
    //   217: invokevirtual 141	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   220: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: invokestatic 145	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   229: getstatic 151	com/tencent/mobileqq/text/EmotcationConstants:c	[Ljava/lang/String;
    //   232: astore 5
    //   234: aload 5
    //   236: arraylength
    //   237: istore 9
    //   239: iconst_0
    //   240: istore 6
    //   242: iload 8
    //   244: istore 7
    //   246: iload 6
    //   248: iload 9
    //   250: if_icmpge +19 -> 269
    //   253: aload 5
    //   255: iload 6
    //   257: aaload
    //   258: aload 4
    //   260: invokevirtual 157	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   263: ifeq +393 -> 656
    //   266: iconst_1
    //   267: istore 7
    //   269: iload 7
    //   271: ifeq +281 -> 552
    //   274: new 55	java/io/File
    //   277: dup
    //   278: new 104	java/lang/StringBuilder
    //   281: dup
    //   282: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   285: getstatic 53	com/tencent/mobileqq/transfile/EmotionDownloader:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   288: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   291: ldc 111
    //   293: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: aload 4
    //   298: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: ldc -97
    //   303: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   309: invokespecial 120	java/io/File:<init>	(Ljava/lang/String;)V
    //   312: astore_1
    //   313: aload_1
    //   314: invokevirtual 59	java/io/File:exists	()Z
    //   317: ifeq +8 -> 325
    //   320: aload_1
    //   321: invokevirtual 66	java/io/File:delete	()Z
    //   324: pop
    //   325: aload_0
    //   326: getfield 37	com/tencent/mobileqq/transfile/EmotionDownloader:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   329: invokevirtual 163	com/tencent/common/app/BaseApplicationImpl:getAssets	()Landroid/content/res/AssetManager;
    //   332: new 104	java/lang/StringBuilder
    //   335: dup
    //   336: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   339: ldc -91
    //   341: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: aload 4
    //   346: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: ldc -89
    //   351: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   357: invokevirtual 173	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   360: astore_2
    //   361: sipush 4096
    //   364: newarray <illegal type>
    //   366: astore 4
    //   368: new 175	java/io/FileOutputStream
    //   371: dup
    //   372: aload_1
    //   373: invokespecial 178	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   376: astore 5
    //   378: aload_2
    //   379: aload 4
    //   381: invokevirtual 184	java/io/InputStream:read	([B)I
    //   384: iconst_m1
    //   385: if_icmpeq +125 -> 510
    //   388: aload 5
    //   390: aload 4
    //   392: invokevirtual 188	java/io/FileOutputStream:write	([B)V
    //   395: aload 5
    //   397: invokevirtual 191	java/io/FileOutputStream:flush	()V
    //   400: goto -22 -> 378
    //   403: astore_1
    //   404: new 193	java/util/HashMap
    //   407: dup
    //   408: invokespecial 194	java/util/HashMap:<init>	()V
    //   411: astore_2
    //   412: aload_2
    //   413: ldc -60
    //   415: ldc 30
    //   417: invokestatic 201	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   420: invokevirtual 205	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   423: pop
    //   424: aload_2
    //   425: ldc -49
    //   427: aload_1
    //   428: invokestatic 212	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Ljava/lang/Exception;)Ljava/lang/String;
    //   431: invokevirtual 205	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   434: pop
    //   435: invokestatic 218	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   438: invokestatic 223	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   441: aconst_null
    //   442: ldc 16
    //   444: iconst_0
    //   445: lconst_0
    //   446: lconst_0
    //   447: aload_2
    //   448: ldc 39
    //   450: invokevirtual 226	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   453: invokestatic 129	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   456: ifeq +12 -> 468
    //   459: ldc 10
    //   461: iconst_2
    //   462: ldc -28
    //   464: aload_1
    //   465: invokestatic 232	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   468: getstatic 47	com/tencent/mobileqq/transfile/EmotionDownloader:jdField_b_of_type_JavaIoFile	Ljava/io/File;
    //   471: areturn
    //   472: astore_1
    //   473: invokestatic 129	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   476: ifeq +175 -> 651
    //   479: ldc 10
    //   481: iconst_2
    //   482: new 104	java/lang/StringBuilder
    //   485: dup
    //   486: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   489: ldc -22
    //   491: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: aload_1
    //   495: invokevirtual 237	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   498: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   504: invokestatic 240	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   507: goto +144 -> 651
    //   510: aload 5
    //   512: invokevirtual 243	java/io/FileOutputStream:close	()V
    //   515: aload_2
    //   516: invokevirtual 244	java/io/InputStream:close	()V
    //   519: aload_1
    //   520: aload_3
    //   521: invokevirtual 248	java/io/File:renameTo	(Ljava/io/File;)Z
    //   524: pop
    //   525: invokestatic 218	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   528: invokestatic 223	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   531: aconst_null
    //   532: ldc 16
    //   534: iconst_1
    //   535: lconst_0
    //   536: lconst_0
    //   537: aconst_null
    //   538: ldc 39
    //   540: invokevirtual 226	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   543: aload_3
    //   544: invokevirtual 59	java/io/File:exists	()Z
    //   547: ifeq +55 -> 602
    //   550: aload_3
    //   551: areturn
    //   552: aload_1
    //   553: ifnull -10 -> 543
    //   556: aload_2
    //   557: ldc -6
    //   559: invokevirtual 254	com/tencent/image/DownloadParams:getHeader	(Ljava/lang/String;)Lorg/apache/http/Header;
    //   562: astore_2
    //   563: aload_2
    //   564: ifnull +13 -> 577
    //   567: aload_1
    //   568: aload_2
    //   569: invokeinterface 259 1 0
    //   574: invokevirtual 261	com/tencent/mobileqq/earlydownload/handler/SystemFaceHandler:b	(Ljava/lang/String;)V
    //   577: aload_1
    //   578: iconst_0
    //   579: invokevirtual 264	com/tencent/mobileqq/earlydownload/handler/SystemFaceHandler:c	(Z)V
    //   582: aload_1
    //   583: iconst_0
    //   584: invokevirtual 266	com/tencent/mobileqq/earlydownload/handler/SystemFaceHandler:d	(Z)V
    //   587: goto -44 -> 543
    //   590: aload_1
    //   591: ifnull -48 -> 543
    //   594: aload_1
    //   595: iconst_1
    //   596: invokevirtual 266	com/tencent/mobileqq/earlydownload/handler/SystemFaceHandler:d	(Z)V
    //   599: goto -56 -> 543
    //   602: new 193	java/util/HashMap
    //   605: dup
    //   606: invokespecial 194	java/util/HashMap:<init>	()V
    //   609: astore_1
    //   610: aload_1
    //   611: ldc -60
    //   613: ldc 33
    //   615: invokestatic 201	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   618: invokevirtual 205	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   621: pop
    //   622: invokestatic 218	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   625: invokestatic 223	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   628: aconst_null
    //   629: ldc 16
    //   631: iconst_0
    //   632: lconst_0
    //   633: lconst_0
    //   634: aload_1
    //   635: ldc 39
    //   637: invokevirtual 226	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   640: getstatic 47	com/tencent/mobileqq/transfile/EmotionDownloader:jdField_b_of_type_JavaIoFile	Ljava/io/File;
    //   643: astore_1
    //   644: aload_1
    //   645: areturn
    //   646: aconst_null
    //   647: astore_1
    //   648: goto -537 -> 111
    //   651: aconst_null
    //   652: astore_1
    //   653: goto -570 -> 83
    //   656: iload 6
    //   658: iconst_1
    //   659: iadd
    //   660: istore 6
    //   662: goto -420 -> 242
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	665	0	this	EmotionDownloader
    //   0	665	1	paramOutputStream	java.io.OutputStream
    //   0	665	2	paramDownloadParams	DownloadParams
    //   0	665	3	paramURLDrawableHandler	URLDrawableHandler
    //   118	273	4	localObject1	Object
    //   232	279	5	localObject2	Object
    //   240	421	6	i	int
    //   244	26	7	j	int
    //   155	88	8	m	int
    //   237	14	9	n	int
    // Exception table:
    //   from	to	target	type
    //   0	15	403	java/lang/Exception
    //   15	51	403	java/lang/Exception
    //   51	67	403	java/lang/Exception
    //   87	97	403	java/lang/Exception
    //   101	111	403	java/lang/Exception
    //   111	154	403	java/lang/Exception
    //   157	173	403	java/lang/Exception
    //   173	229	403	java/lang/Exception
    //   229	239	403	java/lang/Exception
    //   253	266	403	java/lang/Exception
    //   274	325	403	java/lang/Exception
    //   325	378	403	java/lang/Exception
    //   378	400	403	java/lang/Exception
    //   473	507	403	java/lang/Exception
    //   510	543	403	java/lang/Exception
    //   543	550	403	java/lang/Exception
    //   556	563	403	java/lang/Exception
    //   567	577	403	java/lang/Exception
    //   577	587	403	java/lang/Exception
    //   594	599	403	java/lang/Exception
    //   602	644	403	java/lang/Exception
    //   67	83	472	java/lang/Exception
  }
  
  public boolean a()
  {
    return false;
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    try
    {
      if (paramFile.equals(jdField_b_of_type_JavaIoFile))
      {
        paramFile = paramDownloadParams.getHeader("KEY_STATIC_DRAWABLE_ID");
        if (paramFile != null)
        {
          paramFile = paramFile.getValue();
          if (paramFile != null)
          {
            int i = Integer.valueOf(paramFile).intValue();
            return BitmapFactory.decodeResource(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getResources(), i);
          }
        }
      }
      else
      {
        if (GifDrawable.isGifFile(paramFile)) {
          return NativeGifFactory.getNativeGifObject(paramFile, false);
        }
        paramFile = BitmapFactory.decodeFile(paramFile.getAbsolutePath());
        return paramFile;
      }
    }
    catch (Exception paramFile)
    {
      if (QLog.isColorLevel()) {
        QLog.e("EmotionDownloader", 2, "decode file", paramFile);
      }
      return null;
    }
    catch (OutOfMemoryError paramFile)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("EmotionDownloader", 2, "decode file", paramFile);
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\transfile\EmotionDownloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */