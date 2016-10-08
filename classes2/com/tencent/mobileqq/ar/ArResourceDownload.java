package com.tencent.mobileqq.ar;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.model.ArResourceInfo;
import com.tencent.mobileqq.ar.model.ModelResource;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.olympic.utils.OlympicUtil;
import com.tencent.mobileqq.portal.PortalUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.INetEngine.IBreakDownFix;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import qpi;

public class ArResourceDownload
  implements INetEngine.INetEngineListener
{
  public static final int a = 1;
  protected static INetEngine.IBreakDownFix a;
  public static final String a = "ArConfig_ArResourceDownload";
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 3;
  private long jdField_a_of_type_Long;
  public AppInterface a;
  public ArResourceManager a;
  private INetEngine jdField_a_of_type_ComTencentMobileqqTransfileINetEngine;
  ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  Set jdField_a_of_type_JavaUtilSet = Collections.synchronizedSet(new HashSet());
  private boolean jdField_a_of_type_Boolean;
  private final byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix = new qpi();
  }
  
  public ArResourceDownload(AppInterface paramAppInterface, ArResourceManager paramArResourceManager)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqArArResourceManager = paramArResourceManager;
  }
  
  private void a(ArResourceDownload.DownloadInfo paramDownloadInfo)
  {
    if ((TextUtils.isEmpty(paramDownloadInfo.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(paramDownloadInfo.jdField_b_of_type_JavaLangString))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ArConfig_ArResourceDownload", 2, "downLoad:url=" + paramDownloadInfo.jdField_a_of_type_JavaLangString + ",md5= " + paramDownloadInfo.jdField_b_of_type_JavaLangString);
    }
    paramDownloadInfo.jdField_b_of_type_Int += 1;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine == null) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine = this.jdField_a_of_type_ComTencentCommonAppAppInterface.a(0);
    }
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this;
    localHttpNetReq.jdField_a_of_type_JavaLangString = paramDownloadInfo.jdField_a_of_type_JavaLangString;
    localHttpNetReq.c = 0;
    localHttpNetReq.jdField_b_of_type_JavaLangString = paramDownloadInfo.c;
    localHttpNetReq.m = 1;
    localHttpNetReq.a(paramDownloadInfo);
    localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix = jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix;
    this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.a(localHttpNetReq);
    paramDownloadInfo.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = localHttpNetReq;
  }
  
  /* Error */
  private void a(ModelResource paramModelResource, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 6
    //   9: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12: ifeq +28 -> 40
    //   15: ldc 13
    //   17: iconst_2
    //   18: new 86	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   25: ldc -112
    //   27: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: aload_2
    //   31: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 146	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   40: aload 8
    //   42: astore 5
    //   44: aload 7
    //   46: astore 4
    //   48: new 148	java/util/zip/ZipFile
    //   51: dup
    //   52: aload_2
    //   53: invokespecial 151	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   56: astore 11
    //   58: aload 8
    //   60: astore 5
    //   62: aload 7
    //   64: astore 4
    //   66: aload 11
    //   68: invokevirtual 155	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   71: astore 12
    //   73: aload_1
    //   74: ifnull +18 -> 92
    //   77: aload 8
    //   79: astore 5
    //   81: aload 7
    //   83: astore 4
    //   85: aload_1
    //   86: getfield 160	com/tencent/mobileqq/ar/model/ModelResource:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   89: invokevirtual 165	java/util/HashMap:clear	()V
    //   92: aload 8
    //   94: astore 5
    //   96: aload 7
    //   98: astore 4
    //   100: sipush 8192
    //   103: newarray <illegal type>
    //   105: astore 13
    //   107: aconst_null
    //   108: astore_2
    //   109: aload 6
    //   111: astore 5
    //   113: aload 12
    //   115: invokeinterface 170 1 0
    //   120: ifeq +461 -> 581
    //   123: aload 12
    //   125: invokeinterface 174 1 0
    //   130: checkcast 176	java/util/zip/ZipEntry
    //   133: astore 7
    //   135: aload 7
    //   137: invokevirtual 179	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   140: astore 6
    //   142: aload 6
    //   144: ifnull -31 -> 113
    //   147: aload 6
    //   149: ldc -75
    //   151: invokevirtual 186	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   154: ifne -41 -> 113
    //   157: new 86	java/lang/StringBuilder
    //   160: dup
    //   161: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   164: aload_3
    //   165: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: getstatic 191	java/io/File:separator	Ljava/lang/String;
    //   171: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: aload 6
    //   176: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: astore 4
    //   184: aload 7
    //   186: invokevirtual 194	java/util/zip/ZipEntry:isDirectory	()Z
    //   189: ifeq +78 -> 267
    //   192: new 188	java/io/File
    //   195: dup
    //   196: aload 4
    //   198: invokespecial 195	java/io/File:<init>	(Ljava/lang/String;)V
    //   201: astore 4
    //   203: aload 4
    //   205: invokevirtual 198	java/io/File:exists	()Z
    //   208: ifne +9 -> 217
    //   211: aload 4
    //   213: invokevirtual 201	java/io/File:mkdir	()Z
    //   216: pop
    //   217: aload 5
    //   219: astore 6
    //   221: aload_1
    //   222: ifnull +38 -> 260
    //   225: aload 6
    //   227: astore 5
    //   229: aload_2
    //   230: astore 4
    //   232: new 86	java/lang/StringBuilder
    //   235: dup
    //   236: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   239: aload_3
    //   240: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: getstatic 191	java/io/File:separator	Ljava/lang/String;
    //   246: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: ldc -53
    //   251: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   257: invokestatic 207	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)V
    //   260: aload 6
    //   262: astore 5
    //   264: goto -151 -> 113
    //   267: aload 4
    //   269: getstatic 191	java/io/File:separator	Ljava/lang/String;
    //   272: invokevirtual 211	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   275: istore 16
    //   277: aload 4
    //   279: iconst_0
    //   280: iload 16
    //   282: invokevirtual 215	java/lang/String:substring	(II)Ljava/lang/String;
    //   285: astore 8
    //   287: aload 4
    //   289: iload 16
    //   291: iconst_1
    //   292: iadd
    //   293: invokevirtual 218	java/lang/String:substring	(I)Ljava/lang/String;
    //   296: ldc -36
    //   298: invokevirtual 224	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   301: ifne -188 -> 113
    //   304: new 188	java/io/File
    //   307: dup
    //   308: aload 8
    //   310: invokespecial 195	java/io/File:<init>	(Ljava/lang/String;)V
    //   313: astore 8
    //   315: aload 8
    //   317: invokevirtual 198	java/io/File:exists	()Z
    //   320: ifne +9 -> 329
    //   323: aload 8
    //   325: invokevirtual 201	java/io/File:mkdir	()Z
    //   328: pop
    //   329: new 188	java/io/File
    //   332: dup
    //   333: new 86	java/lang/StringBuilder
    //   336: dup
    //   337: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   340: aload 4
    //   342: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: ldc -30
    //   347: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   353: invokespecial 195	java/io/File:<init>	(Ljava/lang/String;)V
    //   356: astore 14
    //   358: new 188	java/io/File
    //   361: dup
    //   362: aload 4
    //   364: invokespecial 195	java/io/File:<init>	(Ljava/lang/String;)V
    //   367: astore 15
    //   369: aload 14
    //   371: invokevirtual 198	java/io/File:exists	()Z
    //   374: ifeq +9 -> 383
    //   377: aload 14
    //   379: invokevirtual 229	java/io/File:delete	()Z
    //   382: pop
    //   383: new 231	java/io/FileOutputStream
    //   386: dup
    //   387: aload 14
    //   389: invokespecial 234	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   392: astore 4
    //   394: aload 11
    //   396: aload 7
    //   398: invokevirtual 238	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   401: astore 5
    //   403: lconst_0
    //   404: lstore 17
    //   406: aload 5
    //   408: aload 13
    //   410: iconst_0
    //   411: aload 13
    //   413: arraylength
    //   414: invokevirtual 244	java/io/InputStream:read	([BII)I
    //   417: istore 16
    //   419: iload 16
    //   421: iconst_m1
    //   422: if_icmpeq +59 -> 481
    //   425: lload 17
    //   427: iload 16
    //   429: i2l
    //   430: ladd
    //   431: lstore 17
    //   433: aload 4
    //   435: aload 13
    //   437: iconst_0
    //   438: iload 16
    //   440: invokevirtual 248	java/io/FileOutputStream:write	([BII)V
    //   443: goto -37 -> 406
    //   446: astore_2
    //   447: aload 5
    //   449: astore_1
    //   450: aload 4
    //   452: astore 5
    //   454: aload_1
    //   455: astore 4
    //   457: aload_2
    //   458: astore_1
    //   459: aload 5
    //   461: ifnull +8 -> 469
    //   464: aload 5
    //   466: invokevirtual 251	java/io/FileOutputStream:close	()V
    //   469: aload 4
    //   471: ifnull +8 -> 479
    //   474: aload 4
    //   476: invokevirtual 252	java/io/InputStream:close	()V
    //   479: aload_1
    //   480: athrow
    //   481: aload 4
    //   483: invokevirtual 255	java/io/FileOutputStream:flush	()V
    //   486: aload_1
    //   487: ifnull +18 -> 505
    //   490: aload_1
    //   491: getfield 160	com/tencent/mobileqq/ar/model/ModelResource:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   494: aload 6
    //   496: lload 17
    //   498: invokestatic 261	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   501: invokevirtual 265	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   504: pop
    //   505: aload 4
    //   507: invokevirtual 251	java/io/FileOutputStream:close	()V
    //   510: aload 5
    //   512: invokevirtual 252	java/io/InputStream:close	()V
    //   515: aconst_null
    //   516: astore 9
    //   518: aconst_null
    //   519: astore 7
    //   521: aconst_null
    //   522: astore 10
    //   524: aconst_null
    //   525: astore 8
    //   527: aload 7
    //   529: astore 6
    //   531: aload 8
    //   533: astore_2
    //   534: aload 9
    //   536: astore 5
    //   538: aload 10
    //   540: astore 4
    //   542: aload 14
    //   544: aload 15
    //   546: invokestatic 268	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/io/File;Ljava/io/File;)Z
    //   549: ifne -328 -> 221
    //   552: aload 9
    //   554: astore 5
    //   556: aload 10
    //   558: astore 4
    //   560: aload 14
    //   562: aload 15
    //   564: invokestatic 271	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/io/File;Ljava/io/File;)V
    //   567: aload 7
    //   569: astore 6
    //   571: aload 8
    //   573: astore_2
    //   574: goto -353 -> 221
    //   577: astore_1
    //   578: goto -119 -> 459
    //   581: aload 5
    //   583: ifnull +8 -> 591
    //   586: aload 5
    //   588: invokevirtual 251	java/io/FileOutputStream:close	()V
    //   591: aload_2
    //   592: ifnull +7 -> 599
    //   595: aload_2
    //   596: invokevirtual 252	java/io/InputStream:close	()V
    //   599: return
    //   600: astore_1
    //   601: aload_1
    //   602: invokevirtual 274	java/io/IOException:printStackTrace	()V
    //   605: goto -14 -> 591
    //   608: astore_1
    //   609: aload_1
    //   610: invokevirtual 274	java/io/IOException:printStackTrace	()V
    //   613: return
    //   614: astore_2
    //   615: aload_2
    //   616: invokevirtual 274	java/io/IOException:printStackTrace	()V
    //   619: goto -150 -> 469
    //   622: astore_2
    //   623: aload_2
    //   624: invokevirtual 274	java/io/IOException:printStackTrace	()V
    //   627: goto -148 -> 479
    //   630: astore_1
    //   631: aload_2
    //   632: astore 4
    //   634: goto -175 -> 459
    //   637: astore_1
    //   638: aload 4
    //   640: astore 5
    //   642: aload_2
    //   643: astore 4
    //   645: goto -186 -> 459
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	648	0	this	ArResourceDownload
    //   0	648	1	paramModelResource	ModelResource
    //   0	648	2	paramString1	String
    //   0	648	3	paramString2	String
    //   46	598	4	localObject1	Object
    //   42	599	5	localObject2	Object
    //   7	563	6	localObject3	Object
    //   1	567	7	localZipEntry	java.util.zip.ZipEntry
    //   4	568	8	localObject4	Object
    //   516	37	9	localObject5	Object
    //   522	35	10	localObject6	Object
    //   56	339	11	localZipFile	java.util.zip.ZipFile
    //   71	53	12	localEnumeration	java.util.Enumeration
    //   105	331	13	arrayOfByte	byte[]
    //   356	205	14	localFile1	File
    //   367	196	15	localFile2	File
    //   275	164	16	i	int
    //   404	93	17	l	long
    // Exception table:
    //   from	to	target	type
    //   406	419	446	finally
    //   433	443	446	finally
    //   481	486	446	finally
    //   490	505	446	finally
    //   505	515	446	finally
    //   48	58	577	finally
    //   66	73	577	finally
    //   85	92	577	finally
    //   100	107	577	finally
    //   232	260	577	finally
    //   542	552	577	finally
    //   560	567	577	finally
    //   586	591	600	java/io/IOException
    //   595	599	608	java/io/IOException
    //   464	469	614	java/io/IOException
    //   474	479	622	java/io/IOException
    //   113	142	630	finally
    //   147	217	630	finally
    //   267	329	630	finally
    //   329	383	630	finally
    //   383	394	630	finally
    //   394	403	637	finally
  }
  
  private boolean a(ArConfigInfo paramArConfigInfo)
  {
    if (paramArConfigInfo == null) {
      return true;
    }
    Object localObject;
    if (!paramArConfigInfo.featureResources.isEmpty())
    {
      localObject = paramArConfigInfo.featureResources.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (!FileUtils.a(((ArResourceInfo)((Iterator)localObject).next()).n)) {
          return false;
        }
      }
    }
    if (!paramArConfigInfo.modelResources.isEmpty())
    {
      paramArConfigInfo = paramArConfigInfo.modelResources.iterator();
      while (paramArConfigInfo.hasNext())
      {
        localObject = (ModelResource)paramArConfigInfo.next();
        if ((!new File(((ModelResource)localObject).c).exists()) && (((ModelResource)localObject).jdField_a_of_type_Boolean)) {
          return false;
        }
      }
    }
    return true;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      synchronized (this.jdField_a_of_type_ArrayOfByte)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          ArResourceDownload.DownloadInfo localDownloadInfo = (ArResourceDownload.DownloadInfo)localIterator.next();
          if (localDownloadInfo.jdField_b_of_type_Long < localDownloadInfo.jdField_a_of_type_Long) {
            this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.b(localDownloadInfo.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq);
          }
        }
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_JavaUtilSet.clear();
    }
  }
  
  public void a(ArConfigInfo paramArConfigInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool;
    Object localObject1;
    Object localObject2;
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("ArConfig_ArResourceDownload", 2, "downloadArResource|isDownloading=" + this.jdField_a_of_type_Boolean);
      }
      bool = this.jdField_a_of_type_Boolean;
      if (bool) {
        return;
      }
      synchronized (this.jdField_a_of_type_ArrayOfByte)
      {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        if (!paramArConfigInfo.featureResources.isEmpty())
        {
          localIterator = paramArConfigInfo.featureResources.iterator();
          while (localIterator.hasNext())
          {
            localObject1 = (ArResourceInfo)localIterator.next();
            if ((localObject1 != null) && (!FileUtils.a(((ArResourceInfo)localObject1).n)))
            {
              localObject2 = new ArResourceDownload.DownloadInfo();
              ((ArResourceDownload.DownloadInfo)localObject2).jdField_a_of_type_Int = 2;
              ((ArResourceDownload.DownloadInfo)localObject2).jdField_a_of_type_JavaLangString = ((ArResourceInfo)localObject1).d;
              ((ArResourceDownload.DownloadInfo)localObject2).jdField_b_of_type_JavaLangString = ((ArResourceInfo)localObject1).e;
              ((ArResourceDownload.DownloadInfo)localObject2).c = ((ArResourceInfo)localObject1).n;
              ((ArResourceDownload.DownloadInfo)localObject2).jdField_a_of_type_Long = ((ArResourceInfo)localObject1).jdField_a_of_type_Long;
              ((ArResourceDownload.DownloadInfo)localObject2).jdField_a_of_type_Boolean = true;
              if (!this.jdField_a_of_type_JavaUtilSet.contains(((ArResourceDownload.DownloadInfo)localObject2).jdField_b_of_type_JavaLangString))
              {
                this.jdField_a_of_type_JavaUtilSet.add(((ArResourceDownload.DownloadInfo)localObject2).jdField_b_of_type_JavaLangString);
                this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
              }
            }
          }
        }
      }
      if (paramArConfigInfo.modelResources.isEmpty()) {
        break label768;
      }
    }
    finally {}
    int i = 0;
    Iterator localIterator = paramArConfigInfo.modelResources.iterator();
    label263:
    String str1;
    Object localObject3;
    int j;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localObject1 = (ModelResource)localIterator.next();
        if (localObject1 != null)
        {
          localObject2 = new File(((ModelResource)localObject1).c);
          if (((File)localObject2).exists())
          {
            str1 = ((File)localObject2).getParentFile().getAbsolutePath();
            localObject3 = ((ModelResource)localObject1).jdField_a_of_type_JavaUtilHashMap;
            if (!paramBoolean2)
            {
              bool = ((HashMap)localObject3).isEmpty();
              if (!bool) {
                break;
              }
            }
            else
            {
              j = 1;
              label348:
              if (j == 0) {
                break label1015;
              }
            }
          }
        }
      }
    }
    label768:
    label1009:
    label1015:
    for (;;)
    {
      try
      {
        a((ModelResource)localObject1, ((ModelResource)localObject1).c, str1);
        i = 1;
      }
      catch (Exception localException)
      {
        Object localObject4;
        String str2;
        long l;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ArConfig_ArResourceDownload", 2, "e= " + localException.getMessage());
        ((File)localObject2).delete();
        localObject2 = new ArResourceDownload.DownloadInfo();
        ((ArResourceDownload.DownloadInfo)localObject2).jdField_a_of_type_Int = 3;
        ((ArResourceDownload.DownloadInfo)localObject2).jdField_a_of_type_JavaLangString = ((ModelResource)localObject1).jdField_a_of_type_JavaLangString;
        ((ArResourceDownload.DownloadInfo)localObject2).jdField_b_of_type_JavaLangString = ((ModelResource)localObject1).jdField_b_of_type_JavaLangString;
        ((ArResourceDownload.DownloadInfo)localObject2).c = ((ModelResource)localObject1).c;
        ((ArResourceDownload.DownloadInfo)localObject2).jdField_a_of_type_Long = ((ModelResource)localObject1).jdField_a_of_type_Long;
        ((ArResourceDownload.DownloadInfo)localObject2).jdField_a_of_type_Boolean = ((ModelResource)localObject1).jdField_a_of_type_Boolean;
        if (this.jdField_a_of_type_JavaUtilSet.contains(((ArResourceDownload.DownloadInfo)localObject2).jdField_b_of_type_JavaLangString)) {
          break label1015;
        }
      }
      localObject3 = ((HashMap)localObject3).entrySet().iterator();
      if (((Iterator)localObject3).hasNext())
      {
        localObject4 = (Map.Entry)((Iterator)localObject3).next();
        str2 = str1 + File.separator + (String)((Map.Entry)localObject4).getKey();
        l = ((Long)((Map.Entry)localObject4).getValue()).longValue();
        localObject4 = new File(str2);
        if (!((File)localObject4).exists()) {
          break label1009;
        }
        if (((File)localObject4).length() == l) {
          continue;
        }
        break label1009;
        this.jdField_a_of_type_JavaUtilSet.add(((ArResourceDownload.DownloadInfo)localObject2).jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
        break label1015;
        localObject2 = new ArResourceDownload.DownloadInfo();
        ((ArResourceDownload.DownloadInfo)localObject2).jdField_a_of_type_Int = 3;
        ((ArResourceDownload.DownloadInfo)localObject2).jdField_a_of_type_JavaLangString = ((ModelResource)localObject1).jdField_a_of_type_JavaLangString;
        ((ArResourceDownload.DownloadInfo)localObject2).jdField_b_of_type_JavaLangString = ((ModelResource)localObject1).jdField_b_of_type_JavaLangString;
        ((ArResourceDownload.DownloadInfo)localObject2).c = ((ModelResource)localObject1).c;
        ((ArResourceDownload.DownloadInfo)localObject2).jdField_a_of_type_Long = ((ModelResource)localObject1).jdField_a_of_type_Long;
        ((ArResourceDownload.DownloadInfo)localObject2).jdField_a_of_type_Boolean = ((ModelResource)localObject1).jdField_a_of_type_Boolean;
        if (this.jdField_a_of_type_JavaUtilSet.contains(((ArResourceDownload.DownloadInfo)localObject2).jdField_b_of_type_JavaLangString)) {
          break label263;
        }
        this.jdField_a_of_type_JavaUtilSet.add(((ArResourceDownload.DownloadInfo)localObject2).jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
        break label263;
        if (i != 0) {
          this.jdField_a_of_type_ComTencentMobileqqArArResourceManager.a(paramArConfigInfo);
        }
        if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ArConfig_ArResourceDownload", 2, "downloadArResource|download num= " + this.jdField_a_of_type_JavaUtilArrayList.size());
          }
          this.jdField_a_of_type_Long = 0L;
          this.jdField_b_of_type_Long = 0L;
          this.jdField_a_of_type_Boolean = true;
          this.jdField_b_of_type_Boolean = false;
        }
        for (;;)
        {
          try
          {
            i = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
            if (i >= 0)
            {
              paramArConfigInfo = (ArResourceDownload.DownloadInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i);
              if (!paramBoolean1) {
                continue;
              }
              paramArConfigInfo.jdField_b_of_type_Boolean = true;
              if (this.jdField_a_of_type_ComTencentMobileqqArArResourceManager.a(paramArConfigInfo.jdField_b_of_type_JavaLangString)) {
                continue;
              }
              this.jdField_a_of_type_JavaUtilArrayList.remove(i);
              this.jdField_a_of_type_JavaUtilSet.remove(paramArConfigInfo.jdField_b_of_type_JavaLangString);
            }
          }
          catch (Exception paramArConfigInfo)
          {
            this.jdField_a_of_type_JavaUtilSet.clear();
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("ArConfig_ArResourceDownload", 2, "e= " + paramArConfigInfo.getMessage());
            continue;
          }
          break;
          this.jdField_a_of_type_Long += paramArConfigInfo.jdField_a_of_type_Long;
          a(paramArConfigInfo);
          i -= 1;
          continue;
          this.jdField_a_of_type_ComTencentMobileqqArArResourceManager.d();
        }
      }
      j = 0;
      break label348;
      j = 1;
      break label348;
    }
  }
  
  public void a(NetReq arg1, long paramLong1, long paramLong2)
  {
    ??? = ???.a();
    if ((??? != null) && ((??? instanceof ArResourceDownload.DownloadInfo)))
    {
      ??? = (ArResourceDownload.DownloadInfo)???;
      if (???.jdField_a_of_type_Int != 1) {}
    }
    else
    {
      return;
    }
    String str = ???.jdField_b_of_type_JavaLangString;
    synchronized (this.jdField_a_of_type_ArrayOfByte)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        ArResourceDownload.DownloadInfo localDownloadInfo = (ArResourceDownload.DownloadInfo)localIterator.next();
        if (str.equals(localDownloadInfo.jdField_b_of_type_JavaLangString))
        {
          paramLong2 = localDownloadInfo.jdField_b_of_type_Long;
          localDownloadInfo.jdField_b_of_type_Long = paramLong1;
          this.jdField_b_of_type_Long += paramLong1 - paramLong2;
        }
      }
      if (!this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqArArResourceManager.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_Long);
      }
      return;
    }
  }
  
  public void a(NetResp paramNetResp)
  {
    if (paramNetResp.e == 3)
    {
      QLog.d("ArConfig_ArResourceDownload", 1, "doOnResp is downloading...");
      return;
    }
    boolean bool1;
    label28:
    int j;
    HttpNetReq localHttpNetReq;
    Object localObject3;
    Object localObject2;
    boolean bool2;
    int i;
    if (paramNetResp.e == 0)
    {
      bool1 = true;
      j = paramNetResp.f;
      localHttpNetReq = (HttpNetReq)paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq;
      ??? = new File(localHttpNetReq.jdField_b_of_type_JavaLangString);
      localObject3 = localHttpNetReq.a();
      if ((localObject3 != null) && ((localObject3 instanceof ArResourceDownload.DownloadInfo)))
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqArArResourceManager.a();
        localObject3 = (ArResourceDownload.DownloadInfo)localObject3;
        if (!bool1) {
          break label674;
        }
        ??? = PortalUtils.a(((File)???).getAbsolutePath());
        if ((TextUtils.isEmpty((CharSequence)???)) || (((String)???).equalsIgnoreCase(((ArResourceDownload.DownloadInfo)localObject3).jdField_b_of_type_JavaLangString))) {
          break label525;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ArConfig_ArResourceDownload", 2, "Md5 error|fileMD5= " + (String)???);
        }
        ((File)???).delete();
        bool2 = false;
        i = -100001;
        label170:
        if (((ArResourceDownload.DownloadInfo)localObject3).jdField_b_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentMobileqqArArResourceManager.a(((ArResourceDownload.DownloadInfo)localObject3).jdField_b_of_type_JavaLangString, true);
        }
        label191:
        if (this.jdField_a_of_type_JavaUtilSet.contains(((ArResourceDownload.DownloadInfo)localObject3).jdField_b_of_type_JavaLangString)) {
          this.jdField_a_of_type_JavaUtilSet.remove(((ArResourceDownload.DownloadInfo)localObject3).jdField_b_of_type_JavaLangString);
        }
        if (this.jdField_a_of_type_JavaUtilSet.isEmpty()) {
          this.jdField_a_of_type_Boolean = false;
        }
        if ((((ArResourceDownload.DownloadInfo)localObject3).jdField_a_of_type_Int != 2) && (((ArResourceDownload.DownloadInfo)localObject3).jdField_a_of_type_Int != 3)) {
          break label780;
        }
        j = 1;
        ??? = "0";
        if (!TextUtils.isEmpty(paramNetResp.jdField_a_of_type_JavaLangString)) {
          ??? = paramNetResp.jdField_a_of_type_JavaLangString;
        }
        ??? = new HashMap();
        ((HashMap)???).put("url", OlympicUtil.a(localHttpNetReq.jdField_a_of_type_JavaLangString));
        ((HashMap)???).put("resultCode", String.valueOf(paramNetResp.e));
        ((HashMap)???).put("fileSize", String.valueOf(((ArResourceDownload.DownloadInfo)localObject3).jdField_a_of_type_Long));
        ((HashMap)???).put("param_errorDesc", ???);
        if (!bool2) {
          break label791;
        }
        ((HashMap)???).put("param_FailCode", "0");
        if ((j == 0) || (this.jdField_a_of_type_Boolean) || (!a((ArConfigInfo)localObject2))) {}
      }
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_ArrayOfByte)
      {
        if (!this.jdField_b_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentMobileqqArArResourceManager.d();
          this.jdField_b_of_type_Boolean = true;
        }
        if (QLog.isColorLevel()) {
          QLog.i("ArConfig_ArResourceDownload", 2, "onResp:downloadSuccess!");
        }
        ??? = this.jdField_a_of_type_ComTencentCommonAppAppInterface.a();
        StatisticCollector.a(BaseApplicationImpl.getContext()).a((String)???, "olympic_ar_download", bool2, 0L, 0L, (HashMap)???, null);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("ArConfig_ArResourceDownload", 2, "onResp:" + localHttpNetReq.jdField_a_of_type_JavaLangString + ", " + paramNetResp.e + ", " + paramNetResp.f);
        return;
        bool1 = false;
        break label28;
        label525:
        bool2 = bool1;
        i = j;
        if (((ArResourceDownload.DownloadInfo)localObject3).jdField_a_of_type_Int != 3) {
          break label170;
        }
        try
        {
          synchronized (this.jdField_a_of_type_ArrayOfByte)
          {
            a(((ArConfigInfo)localObject2).getModelResByMd5(((ArResourceDownload.DownloadInfo)localObject3).jdField_b_of_type_JavaLangString), ((File)???).getAbsolutePath(), ((File)???).getParentFile().getAbsolutePath());
            this.jdField_a_of_type_ComTencentMobileqqArArResourceManager.a((ArConfigInfo)localObject2);
            bool2 = bool1;
            i = j;
          }
          bool1 = false;
        }
        catch (Exception localException)
        {
          ((File)???).delete();
          if (!((ArResourceDownload.DownloadInfo)localObject3).jdField_a_of_type_Boolean) {
            break label928;
          }
        }
        i = -100002;
        if (QLog.isColorLevel()) {
          QLog.d("ArConfig_ArResourceDownload", 2, "e= " + localException.getMessage());
        }
        bool2 = bool1;
        break label170;
        label674:
        if ((((ArResourceDownload.DownloadInfo)localObject3).jdField_b_of_type_Int <= 3) && (!((ArResourceDownload.DownloadInfo)localObject3).jdField_b_of_type_Boolean))
        {
          a((ArResourceDownload.DownloadInfo)localObject3);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("ArConfig_ArResourceDownload", 2, "retry downLoad:retryUrl=" + ((ArResourceDownload.DownloadInfo)localObject3).jdField_a_of_type_JavaLangString + ",retryMd5= " + ((ArResourceDownload.DownloadInfo)localObject3).jdField_b_of_type_JavaLangString);
          return;
        }
        if (((ArResourceDownload.DownloadInfo)localObject3).jdField_b_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentMobileqqArArResourceManager.a(((ArResourceDownload.DownloadInfo)localObject3).jdField_b_of_type_JavaLangString, false);
        }
        i = j;
        bool2 = bool1;
        break label191;
        label780:
        j = 0;
      }
      label791:
      localException.put("param_FailCode", String.valueOf(i));
      this.jdField_a_of_type_JavaUtilSet.clear();
      synchronized (this.jdField_a_of_type_ArrayOfByte)
      {
        this.jdField_a_of_type_Boolean = false;
        localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ArResourceDownload.DownloadInfo)((Iterator)localObject2).next();
          if (((ArResourceDownload.DownloadInfo)localObject3).jdField_b_of_type_Long < ((ArResourceDownload.DownloadInfo)localObject3).jdField_a_of_type_Long) {
            this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.b(((ArResourceDownload.DownloadInfo)localObject3).jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq);
          }
        }
      }
      if ((j != 0) && (!this.jdField_b_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentMobileqqArArResourceManager.a(i, paramNetResp.e);
        this.jdField_b_of_type_Boolean = true;
      }
      continue;
      label928:
      i = j;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\ar\ArResourceDownload.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */