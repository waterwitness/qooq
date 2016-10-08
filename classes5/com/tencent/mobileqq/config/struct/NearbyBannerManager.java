package com.tencent.mobileqq.config.struct;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import mqq.manager.Manager;
import rba;

public class NearbyBannerManager
  implements Manager
{
  private static final int jdField_a_of_type_Int = 10;
  public static final String a = "NearbyBannerManager";
  public static final String b = "NearbyBannerPic";
  private static final String c = "nearby_banner";
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public NearbyBannerManager(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramQQAppInterface;
  }
  
  private void a()
  {
    try
    {
      Object localObject = new File(this.a.a().getFilesDir().getAbsolutePath() + "/" + "NearbyBannerPic");
      int i;
      if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
      {
        localObject = Arrays.asList(((File)localObject).listFiles());
        if (((List)localObject).size() > 10)
        {
          Collections.sort((List)localObject, new rba(this));
          i = 10;
        }
      }
      else
      {
        while (i < ((List)localObject).size())
        {
          a((File)((List)localObject).get(i));
          i += 1;
          continue;
          if (((File)localObject).isFile()) {
            a((File)localObject);
          }
        }
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private void a(int paramInt)
  {
    NearbySPUtil.a(this.a.a(), "key_config_ver", Integer.valueOf(paramInt));
  }
  
  private void a(File paramFile)
  {
    try
    {
      if (paramFile.exists())
      {
        if (paramFile.isFile())
        {
          paramFile.delete();
          return;
        }
        if (paramFile.isDirectory())
        {
          paramFile = paramFile.listFiles();
          if (paramFile != null)
          {
            int i = 0;
            while (i < paramFile.length)
            {
              a(paramFile[i]);
              i += 1;
            }
          }
        }
      }
      return;
    }
    catch (Exception paramFile)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyBannerManager", 2, "", paramFile);
      }
    }
  }
  
  public int a()
  {
    return ((Integer)NearbySPUtil.a(this.a.a(), "key_config_ver", Integer.valueOf(0))).intValue();
  }
  
  public Set a()
  {
    return new HashSet(Arrays.asList(((String)NearbySPUtil.a(this.a.a(), "key_expired_banner", "")).split("\\|")));
  }
  
  /* Error */
  public void a(PicAndAdConf paramPicAndAdConf, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore_3
    //   5: iconst_1
    //   6: istore 8
    //   8: iconst_1
    //   9: istore 9
    //   11: invokestatic 135	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14: ifeq +11 -> 25
    //   17: ldc 12
    //   19: iconst_2
    //   20: ldc -90
    //   22: invokestatic 169	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   25: new 39	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   32: aload_0
    //   33: getfield 32	com/tencent/mobileqq/config/struct/NearbyBannerManager:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   36: invokevirtual 45	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   39: invokevirtual 51	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   42: invokevirtual 55	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   45: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: ldc 61
    //   50: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: aload_0
    //   54: getfield 32	com/tencent/mobileqq/config/struct/NearbyBannerManager:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   57: invokevirtual 114	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   60: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: astore 4
    //   68: new 37	java/io/File
    //   71: dup
    //   72: new 39	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   79: aload 4
    //   81: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: ldc 61
    //   86: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: ldc 18
    //   91: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
    //   100: astore 7
    //   102: aload_0
    //   103: aload 7
    //   105: invokespecial 108	com/tencent/mobileqq/config/struct/NearbyBannerManager:a	(Ljava/io/File;)V
    //   108: aload_0
    //   109: invokespecial 171	com/tencent/mobileqq/config/struct/NearbyBannerManager:a	()V
    //   112: new 37	java/io/File
    //   115: dup
    //   116: aload 4
    //   118: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
    //   121: astore 4
    //   123: aload 4
    //   125: invokevirtual 71	java/io/File:exists	()Z
    //   128: ifne +9 -> 137
    //   131: aload 4
    //   133: invokevirtual 174	java/io/File:mkdirs	()Z
    //   136: pop
    //   137: aload 7
    //   139: invokevirtual 177	java/io/File:createNewFile	()Z
    //   142: pop
    //   143: aload 7
    //   145: ifnull +263 -> 408
    //   148: aload 7
    //   150: invokevirtual 71	java/io/File:exists	()Z
    //   153: ifeq +255 -> 408
    //   156: new 179	java/io/BufferedOutputStream
    //   159: dup
    //   160: new 181	java/io/FileOutputStream
    //   163: dup
    //   164: aload 7
    //   166: invokespecial 183	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   169: invokespecial 186	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   172: astore 4
    //   174: new 188	java/io/DataOutputStream
    //   177: dup
    //   178: aload 4
    //   180: invokespecial 189	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   183: astore_3
    //   184: aload_1
    //   185: aload_3
    //   186: invokevirtual 194	com/tencent/mobileqq/config/struct/PicAndAdConf:a	(Ljava/io/DataOutputStream;)V
    //   189: aload 4
    //   191: ifnull +8 -> 199
    //   194: aload 4
    //   196: invokevirtual 197	java/io/BufferedOutputStream:close	()V
    //   199: aload_3
    //   200: ifnull +7 -> 207
    //   203: aload_3
    //   204: invokevirtual 198	java/io/DataOutputStream:close	()V
    //   207: aload_1
    //   208: invokevirtual 200	com/tencent/mobileqq/config/struct/PicAndAdConf:d	()V
    //   211: aload_0
    //   212: iload_2
    //   213: invokespecial 202	com/tencent/mobileqq/config/struct/NearbyBannerManager:a	(I)V
    //   216: invokestatic 206	com/tencent/mobileqq/nearby/NearbyProxy:c	()V
    //   219: iconst_0
    //   220: istore_2
    //   221: invokestatic 135	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   224: ifeq +35 -> 259
    //   227: new 39	java/lang/StringBuilder
    //   230: dup
    //   231: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   234: ldc -48
    //   236: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: astore_1
    //   240: iload_2
    //   241: ifne +161 -> 402
    //   244: ldc 12
    //   246: iconst_2
    //   247: aload_1
    //   248: iload 9
    //   250: invokevirtual 211	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   253: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: invokestatic 169	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   259: return
    //   260: astore 4
    //   262: invokestatic 135	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   265: ifeq -122 -> 143
    //   268: ldc 12
    //   270: iconst_2
    //   271: ldc -119
    //   273: aload 4
    //   275: invokestatic 141	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   278: goto -135 -> 143
    //   281: astore 5
    //   283: aconst_null
    //   284: astore 6
    //   286: aload_3
    //   287: astore 4
    //   289: aload 6
    //   291: astore_3
    //   292: invokestatic 135	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   295: ifeq +13 -> 308
    //   298: ldc 12
    //   300: iconst_2
    //   301: ldc -43
    //   303: aload 5
    //   305: invokestatic 141	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   308: aload 4
    //   310: ifnull +8 -> 318
    //   313: aload 4
    //   315: invokevirtual 197	java/io/BufferedOutputStream:close	()V
    //   318: aload_3
    //   319: ifnull +7 -> 326
    //   322: aload_3
    //   323: invokevirtual 198	java/io/DataOutputStream:close	()V
    //   326: aload_0
    //   327: aload 7
    //   329: invokespecial 108	com/tencent/mobileqq/config/struct/NearbyBannerManager:a	(Ljava/io/File;)V
    //   332: aload_0
    //   333: iconst_0
    //   334: invokespecial 202	com/tencent/mobileqq/config/struct/NearbyBannerManager:a	(I)V
    //   337: iconst_1
    //   338: istore_2
    //   339: goto -118 -> 221
    //   342: astore_3
    //   343: iconst_0
    //   344: istore 8
    //   346: aconst_null
    //   347: astore 4
    //   349: aload 4
    //   351: ifnull +8 -> 359
    //   354: aload 4
    //   356: invokevirtual 197	java/io/BufferedOutputStream:close	()V
    //   359: aload 5
    //   361: ifnull +8 -> 369
    //   364: aload 5
    //   366: invokevirtual 198	java/io/DataOutputStream:close	()V
    //   369: iload 8
    //   371: ifeq +16 -> 387
    //   374: aload_0
    //   375: aload 7
    //   377: invokespecial 108	com/tencent/mobileqq/config/struct/NearbyBannerManager:a	(Ljava/io/File;)V
    //   380: aload_0
    //   381: iconst_0
    //   382: invokespecial 202	com/tencent/mobileqq/config/struct/NearbyBannerManager:a	(I)V
    //   385: aload_3
    //   386: athrow
    //   387: aload_1
    //   388: invokevirtual 200	com/tencent/mobileqq/config/struct/PicAndAdConf:d	()V
    //   391: aload_0
    //   392: iload_2
    //   393: invokespecial 202	com/tencent/mobileqq/config/struct/NearbyBannerManager:a	(I)V
    //   396: invokestatic 206	com/tencent/mobileqq/nearby/NearbyProxy:c	()V
    //   399: goto -14 -> 385
    //   402: iconst_0
    //   403: istore 9
    //   405: goto -161 -> 244
    //   408: invokestatic 135	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   411: ifeq -152 -> 259
    //   414: ldc 12
    //   416: iconst_2
    //   417: ldc -41
    //   419: invokestatic 169	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   422: return
    //   423: astore 4
    //   425: goto -226 -> 199
    //   428: astore_3
    //   429: goto -222 -> 207
    //   432: astore_1
    //   433: goto -115 -> 318
    //   436: astore_1
    //   437: goto -111 -> 326
    //   440: astore 4
    //   442: goto -83 -> 359
    //   445: astore 4
    //   447: goto -78 -> 369
    //   450: astore_3
    //   451: iconst_0
    //   452: istore 8
    //   454: goto -105 -> 349
    //   457: astore 6
    //   459: iconst_0
    //   460: istore 8
    //   462: aload_3
    //   463: astore 5
    //   465: aload 6
    //   467: astore_3
    //   468: goto -119 -> 349
    //   471: astore 6
    //   473: aload_3
    //   474: astore 5
    //   476: aload 6
    //   478: astore_3
    //   479: goto -130 -> 349
    //   482: astore 5
    //   484: aconst_null
    //   485: astore_3
    //   486: goto -194 -> 292
    //   489: astore 5
    //   491: goto -199 -> 292
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	494	0	this	NearbyBannerManager
    //   0	494	1	paramPicAndAdConf	PicAndAdConf
    //   0	494	2	paramInt	int
    //   4	319	3	localObject1	Object
    //   342	44	3	localObject2	Object
    //   428	1	3	localException1	Exception
    //   450	13	3	localObject3	Object
    //   467	19	3	localObject4	Object
    //   66	129	4	localObject5	Object
    //   260	14	4	localException2	Exception
    //   287	68	4	localObject6	Object
    //   423	1	4	localException3	Exception
    //   440	1	4	localException4	Exception
    //   445	1	4	localException5	Exception
    //   1	1	5	localObject7	Object
    //   281	84	5	localException6	Exception
    //   463	12	5	localObject8	Object
    //   482	1	5	localException7	Exception
    //   489	1	5	localException8	Exception
    //   284	6	6	localObject9	Object
    //   457	9	6	localObject10	Object
    //   471	6	6	localObject11	Object
    //   100	276	7	localFile	File
    //   6	455	8	i	int
    //   9	395	9	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   123	137	260	java/lang/Exception
    //   137	143	260	java/lang/Exception
    //   156	174	281	java/lang/Exception
    //   156	174	342	finally
    //   194	199	423	java/lang/Exception
    //   203	207	428	java/lang/Exception
    //   313	318	432	java/lang/Exception
    //   322	326	436	java/lang/Exception
    //   354	359	440	java/lang/Exception
    //   364	369	445	java/lang/Exception
    //   174	184	450	finally
    //   184	189	457	finally
    //   292	308	471	finally
    //   174	184	482	java/lang/Exception
    //   184	189	489	java/lang/Exception
  }
  
  public void onDestroy() {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\config\struct\NearbyBannerManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */