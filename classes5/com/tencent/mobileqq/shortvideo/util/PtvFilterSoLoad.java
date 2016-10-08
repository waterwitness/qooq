package com.tencent.mobileqq.shortvideo.util;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.EarlyDataFactory;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.earlydownload.handler.EarlyHandler;
import com.tencent.mobileqq.earlydownload.handler.QQShortVideoConstFilterHandler;
import com.tencent.mobileqq.earlydownload.handler.QQShortVideoVarFilterHandler;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlDataV7aVersion;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraCompatibleList;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.util.VideoLibUtil;
import com.tencent.view.FilterDefault;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import usl;
import usm;

public class PtvFilterSoLoad
{
  public static final int a = 1;
  public static Handler a;
  private static PtvFilterSoLoad.SVFilterDownloadSession jdField_a_of_type_ComTencentMobileqqShortvideoUtilPtvFilterSoLoad$SVFilterDownloadSession;
  private static Object jdField_a_of_type_JavaLangObject;
  private static final String jdField_a_of_type_JavaLangString = "PtvFilterSoLoad";
  private static ArrayList jdField_a_of_type_JavaUtilArrayList;
  public static boolean a = false;
  public static final int b = 2;
  private static PtvFilterSoLoad.SVFilterDownloadSession jdField_b_of_type_ComTencentMobileqqShortvideoUtilPtvFilterSoLoad$SVFilterDownloadSession;
  private static final String jdField_b_of_type_JavaLangString = "const_exist";
  private static int jdField_c_of_type_Int = 0;
  private static final String jdField_c_of_type_JavaLangString = "var_exist";
  private static int jdField_d_of_type_Int = 0;
  private static final String jdField_d_of_type_JavaLangString = "bakcup/";
  private static final int jdField_e_of_type_Int = 1;
  private static final String jdField_e_of_type_JavaLangString = "/app_lib/qq_filter/";
  private static final int jdField_f_of_type_Int = 0;
  private static final String jdField_f_of_type_JavaLangString = "com.tencent.mobileqq";
  private static final String g;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaUtilArrayList = new ArrayList(2);
    jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    c = 8114;
    d = 25801;
    jdField_a_of_type_JavaLangObject = new Object();
    g = Environment.getDataDirectory() + "/data/" + "com.tencent.mobileqq" + "/app_lib/qq_filter/";
    jdField_a_of_type_ComTencentMobileqqShortvideoUtilPtvFilterSoLoad$SVFilterDownloadSession = new PtvFilterSoLoad.SVFilterDownloadSession();
    b = new PtvFilterSoLoad.SVFilterDownloadSession();
  }
  
  public static int a(Context paramContext)
  {
    int i;
    if (b()) {
      if (b(paramContext)) {
        i = 1;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PtvFilterSoLoad", 2, "getFilterSoState " + i);
      }
      return i;
      i = 2;
      continue;
      i = 0;
    }
  }
  
  public static int a(String paramString)
  {
    if (paramString == null) {
      return -1;
    }
    if (!new File(paramString).exists()) {
      return -2;
    }
    try
    {
      System.load(paramString);
      return 0;
    }
    catch (UnsatisfiedLinkError paramString) {}
    return -3;
  }
  
  public static String a(Context paramContext)
  {
    if (paramContext == null) {
      return g;
    }
    paramContext = paramContext.getFilesDir();
    if (paramContext != null) {
      return paramContext.getParent() + "/app_lib/qq_filter/";
    }
    return g;
  }
  
  public static void a(int paramInt)
  {
    int i = jdField_a_of_type_ComTencentMobileqqShortvideoUtilPtvFilterSoLoad$SVFilterDownloadSession.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndAdd(0);
    if ((i == 1) || (i == 0)) {
      jdField_a_of_type_ComTencentMobileqqShortvideoUtilPtvFilterSoLoad$SVFilterDownloadSession.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndSet(2);
    }
    jdField_a_of_type_ComTencentMobileqqShortvideoUtilPtvFilterSoLoad$SVFilterDownloadSession.f = paramInt;
    for (;;)
    {
      try
      {
        Object[] arrayOfObject = jdField_a_of_type_JavaUtilArrayList.toArray();
        if ((arrayOfObject == null) || (arrayOfObject.length <= 0)) {
          return;
        }
      }
      finally {}
      paramInt = 0;
      while (paramInt < localObject.length)
      {
        PtvFilterSoLoad.FilterVideoSoCallback localFilterVideoSoCallback = (PtvFilterSoLoad.FilterVideoSoCallback)localObject[paramInt];
        jdField_a_of_type_AndroidOsHandler.post(new usl(localFilterVideoSoCallback));
        paramInt += 1;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (b(paramContext)) {
      return;
    }
    a(paramQQAppInterface, false);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, PtvFilterSoLoad.SVFilterDownloadSession paramSVFilterDownloadSession)
  {
    if ((paramSVFilterDownloadSession.jdField_a_of_type_ComTencentMobileqqEarlydownloadHandlerEarlyHandler != null) && (paramSVFilterDownloadSession.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndAdd(0) == 0))
    {
      paramSVFilterDownloadSession.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndSet(1);
      paramSVFilterDownloadSession.jdField_a_of_type_ComTencentMobileqqEarlydownloadHandlerEarlyHandler.a(true);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.d("PtvFilterSoLoad", 2, "doRealDownLoad so");
    }
    if (paramQQAppInterface == null) {
      if (QLog.isColorLevel()) {
        QLog.d("PtvFilterSoLoad", 2, "start download so[app == null]");
      }
    }
    Object localObject;
    boolean bool1;
    do
    {
      do
      {
        return;
        localObject = (EarlyDownloadManager)paramQQAppInterface.getManager(76);
      } while (localObject == null);
      QQShortVideoConstFilterHandler localQQShortVideoConstFilterHandler = (QQShortVideoConstFilterHandler)((EarlyDownloadManager)localObject).a("qq.android.native.short.video.filter.const.v1");
      if (localQQShortVideoConstFilterHandler != null)
      {
        if (paramBoolean) {
          break;
        }
        bool1 = true;
        localQQShortVideoConstFilterHandler.jdField_a_of_type_Boolean = bool1;
        jdField_a_of_type_ComTencentMobileqqShortvideoUtilPtvFilterSoLoad$SVFilterDownloadSession.jdField_a_of_type_ComTencentMobileqqEarlydownloadHandlerEarlyHandler = localQQShortVideoConstFilterHandler;
        a(paramQQAppInterface, jdField_a_of_type_ComTencentMobileqqShortvideoUtilPtvFilterSoLoad$SVFilterDownloadSession);
      }
      localObject = (QQShortVideoVarFilterHandler)((EarlyDownloadManager)localObject).a("qq.android.native.short.video.filter.var.v1");
    } while (localObject == null);
    if (!paramBoolean) {}
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      ((QQShortVideoVarFilterHandler)localObject).jdField_a_of_type_Boolean = paramBoolean;
      b.jdField_a_of_type_ComTencentMobileqqEarlydownloadHandlerEarlyHandler = ((EarlyHandler)localObject);
      a(paramQQAppInterface, b);
      return;
      bool1 = false;
      break;
    }
  }
  
  public static void a(PtvFilterSoLoad.FilterVideoSoCallback paramFilterVideoSoCallback)
  {
    if (paramFilterVideoSoCallback != null) {}
    try
    {
      if (!jdField_a_of_type_JavaUtilArrayList.contains(paramFilterVideoSoCallback))
      {
        if (QLog.isColorLevel()) {
          QLog.i("PtvFilterSoLoad", 2, "addFilterVideoSoCallback");
        }
        jdField_a_of_type_JavaUtilArrayList.add(paramFilterVideoSoCallback);
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public static void a(boolean paramBoolean, com.tencent.common.app.AppInterface arg1, String paramString)
  {
    // Byte code:
    //   0: invokestatic 113	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +37 -> 40
    //   6: ldc 13
    //   8: iconst_2
    //   9: new 71	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   16: ldc -21
    //   18: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: iload_0
    //   22: invokevirtual 238	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   25: ldc -16
    //   27: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: aload_2
    //   31: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 121	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   40: iload_0
    //   41: ifne +128 -> 169
    //   44: getstatic 98	com/tencent/mobileqq/shortvideo/util/PtvFilterSoLoad:jdField_a_of_type_ComTencentMobileqqShortvideoUtilPtvFilterSoLoad$SVFilterDownloadSession	Lcom/tencent/mobileqq/shortvideo/util/PtvFilterSoLoad$SVFilterDownloadSession;
    //   47: getfield 151	com/tencent/mobileqq/shortvideo/util/PtvFilterSoLoad$SVFilterDownloadSession:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   50: iconst_4
    //   51: invokevirtual 160	java/util/concurrent/atomic/AtomicInteger:getAndSet	(I)I
    //   54: pop
    //   55: invokestatic 113	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   58: ifeq +33 -> 91
    //   61: ldc 13
    //   63: iconst_2
    //   64: new 71	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   71: ldc -14
    //   73: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: getstatic 48	com/tencent/mobileqq/shortvideo/util/PtvFilterSoLoad:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   79: invokevirtual 246	java/util/ArrayList:size	()I
    //   82: invokevirtual 118	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   85: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokestatic 121	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   91: ldc 2
    //   93: monitorenter
    //   94: getstatic 48	com/tencent/mobileqq/shortvideo/util/PtvFilterSoLoad:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   97: invokevirtual 166	java/util/ArrayList:toArray	()[Ljava/lang/Object;
    //   100: astore_1
    //   101: ldc 2
    //   103: monitorexit
    //   104: aload_1
    //   105: ifnull +8 -> 113
    //   108: aload_1
    //   109: arraylength
    //   110: ifgt +242 -> 352
    //   113: invokestatic 113	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   116: ifeq +28 -> 144
    //   119: ldc 13
    //   121: iconst_2
    //   122: new 71	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   129: ldc -8
    //   131: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: aload_1
    //   135: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   138: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: invokestatic 121	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   144: getstatic 98	com/tencent/mobileqq/shortvideo/util/PtvFilterSoLoad:jdField_a_of_type_ComTencentMobileqqShortvideoUtilPtvFilterSoLoad$SVFilterDownloadSession	Lcom/tencent/mobileqq/shortvideo/util/PtvFilterSoLoad$SVFilterDownloadSession;
    //   147: getfield 151	com/tencent/mobileqq/shortvideo/util/PtvFilterSoLoad$SVFilterDownloadSession:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   150: invokevirtual 251	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   153: iconst_4
    //   154: if_icmpne +14 -> 168
    //   157: getstatic 98	com/tencent/mobileqq/shortvideo/util/PtvFilterSoLoad:jdField_a_of_type_ComTencentMobileqqShortvideoUtilPtvFilterSoLoad$SVFilterDownloadSession	Lcom/tencent/mobileqq/shortvideo/util/PtvFilterSoLoad$SVFilterDownloadSession;
    //   160: getfield 151	com/tencent/mobileqq/shortvideo/util/PtvFilterSoLoad$SVFilterDownloadSession:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   163: iconst_0
    //   164: invokevirtual 160	java/util/concurrent/atomic/AtomicInteger:getAndSet	(I)I
    //   167: pop
    //   168: return
    //   169: invokestatic 257	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   172: invokestatic 259	com/tencent/mobileqq/shortvideo/util/PtvFilterSoLoad:a	(Landroid/content/Context;)Ljava/lang/String;
    //   175: astore_1
    //   176: invokestatic 113	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   179: ifeq +29 -> 208
    //   182: ldc 13
    //   184: iconst_2
    //   185: new 71	java/lang/StringBuilder
    //   188: dup
    //   189: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   192: ldc_w 261
    //   195: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: aload_1
    //   199: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: invokestatic 121	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   208: new 71	java/lang/StringBuilder
    //   211: dup
    //   212: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   215: aload_1
    //   216: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: ldc 26
    //   221: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: astore_3
    //   228: getstatic 69	com/tencent/mobileqq/shortvideo/util/PtvFilterSoLoad:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   231: astore_1
    //   232: aload_1
    //   233: monitorenter
    //   234: new 71	java/lang/StringBuilder
    //   237: dup
    //   238: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   241: aload_3
    //   242: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: ldc 20
    //   247: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   253: astore 4
    //   255: aload 4
    //   257: invokestatic 266	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;)Z
    //   260: pop
    //   261: aload_2
    //   262: aload_3
    //   263: iconst_0
    //   264: invokestatic 269	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   267: aload 4
    //   269: invokestatic 272	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Ljava/io/File;
    //   272: pop
    //   273: invokestatic 113	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   276: ifeq +30 -> 306
    //   279: ldc 13
    //   281: iconst_2
    //   282: new 71	java/lang/StringBuilder
    //   285: dup
    //   286: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   289: ldc_w 274
    //   292: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: aload 4
    //   297: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: invokestatic 121	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   306: aload_1
    //   307: monitorexit
    //   308: getstatic 98	com/tencent/mobileqq/shortvideo/util/PtvFilterSoLoad:jdField_a_of_type_ComTencentMobileqqShortvideoUtilPtvFilterSoLoad$SVFilterDownloadSession	Lcom/tencent/mobileqq/shortvideo/util/PtvFilterSoLoad$SVFilterDownloadSession;
    //   311: getfield 151	com/tencent/mobileqq/shortvideo/util/PtvFilterSoLoad$SVFilterDownloadSession:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   314: iconst_3
    //   315: invokevirtual 160	java/util/concurrent/atomic/AtomicInteger:getAndSet	(I)I
    //   318: pop
    //   319: goto -264 -> 55
    //   322: astore_1
    //   323: aload_1
    //   324: invokevirtual 277	java/io/IOException:printStackTrace	()V
    //   327: getstatic 98	com/tencent/mobileqq/shortvideo/util/PtvFilterSoLoad:jdField_a_of_type_ComTencentMobileqqShortvideoUtilPtvFilterSoLoad$SVFilterDownloadSession	Lcom/tencent/mobileqq/shortvideo/util/PtvFilterSoLoad$SVFilterDownloadSession;
    //   330: getfield 151	com/tencent/mobileqq/shortvideo/util/PtvFilterSoLoad$SVFilterDownloadSession:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   333: iconst_4
    //   334: invokevirtual 160	java/util/concurrent/atomic/AtomicInteger:getAndSet	(I)I
    //   337: pop
    //   338: goto -283 -> 55
    //   341: astore_2
    //   342: aload_1
    //   343: monitorexit
    //   344: aload_2
    //   345: athrow
    //   346: astore_1
    //   347: ldc 2
    //   349: monitorexit
    //   350: aload_1
    //   351: athrow
    //   352: iconst_0
    //   353: istore 5
    //   355: iload 5
    //   357: aload_1
    //   358: arraylength
    //   359: if_icmpge -191 -> 168
    //   362: aload_1
    //   363: iload 5
    //   365: aaload
    //   366: checkcast 168	com/tencent/mobileqq/shortvideo/util/PtvFilterSoLoad$FilterVideoSoCallback
    //   369: astore_2
    //   370: iload 5
    //   372: aload_1
    //   373: arraylength
    //   374: iconst_1
    //   375: isub
    //   376: if_icmpne +30 -> 406
    //   379: iconst_1
    //   380: istore_0
    //   381: getstatic 61	com/tencent/mobileqq/shortvideo/util/PtvFilterSoLoad:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   384: new 279	usn
    //   387: dup
    //   388: iload_0
    //   389: aload_2
    //   390: invokespecial 282	usn:<init>	(ZLcom/tencent/mobileqq/shortvideo/util/PtvFilterSoLoad$FilterVideoSoCallback;)V
    //   393: invokevirtual 177	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   396: pop
    //   397: iload 5
    //   399: iconst_1
    //   400: iadd
    //   401: istore 5
    //   403: goto -48 -> 355
    //   406: iconst_0
    //   407: istore_0
    //   408: goto -27 -> 381
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	411	0	paramBoolean	boolean
    //   0	411	2	paramString	String
    //   227	36	3	str1	String
    //   253	43	4	str2	String
    //   353	49	5	i	int
    // Exception table:
    //   from	to	target	type
    //   228	234	322	java/io/IOException
    //   308	319	322	java/io/IOException
    //   344	346	322	java/io/IOException
    //   234	306	341	finally
    //   306	308	341	finally
    //   342	344	341	finally
    //   94	104	346	finally
    //   347	350	346	finally
  }
  
  public static boolean a()
  {
    boolean bool2 = false;
    for (;;)
    {
      try
      {
        int i = VideoLibUtil.getFilterLibVersion();
        boolean bool1;
        localUnsatisfiedLinkError1.printStackTrace();
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
      {
        try
        {
          j = VideoLibUtil.getFaceDetectLibVersion();
          if (QLog.isColorLevel()) {
            QLog.d("PtvFilterSoLoad", 2, "isFilterFaceSoVersionOK:filterversion=" + i + " detectversion=" + j + " FILTER_SO_VERSION=" + c + " FACE_DETECT_SO_VERSION=" + d);
          }
          bool1 = bool2;
          if (i >= c)
          {
            bool1 = bool2;
            if (j >= d) {
              bool1 = true;
            }
          }
          return bool1;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
        {
          int j;
          for (;;) {}
        }
        localUnsatisfiedLinkError1 = localUnsatisfiedLinkError1;
        i = 0;
      }
      j = 0;
    }
  }
  
  public static boolean a(int paramInt1, int paramInt2, Class paramClass)
  {
    long l1 = System.currentTimeMillis();
    paramClass = EarlyDataFactory.a(paramClass);
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("PtvFilterSoLoad", 2, "judgeDownloadSoVersionIsOK[parseBySP]: time cost " + (l2 - l1) + "ms");
    }
    if (paramClass == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PtvFilterSoLoad", 2, "judgeDownloadSoVersionIsOK:data=null");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PtvFilterSoLoad", 2, "judgeDownloadSoVersionIsOK:data=" + paramClass.toString());
    }
    int k = paramClass.loadState;
    int j;
    int i;
    if (k == 1)
    {
      j = paramClass.Version;
      if ((paramClass instanceof XmlDataV7aVersion)) {
        i = ((XmlDataV7aVersion)paramClass).VideoVersion;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("PtvFilterSoLoad", 2, "judgeDownloadSoVersionIsOK:version=" + j + " loadState=" + k + " privateVersion=" + i);
        QLog.d("PtvFilterSoLoad", 2, "judgeDownloadSoVersionIsOK:selfVerBase=" + paramInt1 + " serverVerBase=" + paramInt2);
      }
      if ((i != -1) && (i >= paramInt1) && (paramClass.hasResDownloaded))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PtvFilterSoLoad", 2, "judgeDownloadSoVersionIsOK:success");
        }
        return true;
        if (QLog.isColorLevel()) {
          QLog.d("PtvFilterSoLoad", 2, "judgeDownloadSoVersionIsOK: data is invalid.");
        }
        i = -1;
      }
      else
      {
        return false;
        i = -1;
        j = -1;
      }
    }
  }
  
  public static boolean a(Context paramContext)
  {
    FilterDefault.initResource();
    return a(paramContext, false);
  }
  
  public static boolean a(Context paramContext, boolean paramBoolean)
  {
    if (!jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_Boolean = true;
      FilterDefault.ENABLE_DEBUG = true;
      FilterDefault.initResource();
    }
    if (paramBoolean) {}
    for (paramBoolean = PtvFilterSoLoad.SVFilterSoLoadStatus.a(); paramBoolean; paramBoolean = PtvFilterSoLoad.SVFilterSoLoadStatus.a(paramContext)) {
      return a();
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    boolean bool = false;
    if (b())
    {
      if (b(paramContext)) {
        bool = true;
      }
    }
    else {
      return bool;
    }
    a(paramQQAppInterface, false);
    return false;
  }
  
  public static String[] a(Context paramContext)
  {
    paramContext = a(paramContext);
    if ((FileUtils.a(paramContext + "noeyegray.png")) && (FileUtils.a(paramContext + "nomouthgray.png"))) {}
    for (int i = 1; i != 0; i = 0) {
      return new String[] { paramContext + "noeyegray.png", paramContext + "nomouthgray.png" };
    }
    return null;
  }
  
  public static void b(int paramInt)
  {
    int i = b.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndAdd(0);
    if ((i == 1) || (i == 0)) {
      b.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndSet(2);
    }
    b.f = paramInt;
    for (;;)
    {
      try
      {
        Object[] arrayOfObject = jdField_a_of_type_JavaUtilArrayList.toArray();
        if ((arrayOfObject == null) || (arrayOfObject.length <= 0)) {
          return;
        }
      }
      finally {}
      paramInt = 0;
      while (paramInt < localObject.length)
      {
        PtvFilterSoLoad.FilterVideoSoCallback localFilterVideoSoCallback = (PtvFilterSoLoad.FilterVideoSoCallback)localObject[paramInt];
        jdField_a_of_type_AndroidOsHandler.post(new usm(localFilterVideoSoCallback));
        paramInt += 1;
      }
    }
  }
  
  public static void b(PtvFilterSoLoad.FilterVideoSoCallback paramFilterVideoSoCallback)
  {
    if (paramFilterVideoSoCallback != null) {}
    try
    {
      if (jdField_a_of_type_JavaUtilArrayList.contains(paramFilterVideoSoCallback))
      {
        if (QLog.isColorLevel()) {
          QLog.i("PtvFilterSoLoad", 2, "removeFilterVideoSoCallback");
        }
        jdField_a_of_type_JavaUtilArrayList.remove(paramFilterVideoSoCallback);
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public static void b(boolean paramBoolean, com.tencent.common.app.AppInterface arg1, String paramString)
  {
    // Byte code:
    //   0: invokestatic 113	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +38 -> 41
    //   6: ldc 13
    //   8: iconst_2
    //   9: new 71	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 390
    //   19: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: iload_0
    //   23: invokevirtual 238	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   26: ldc -16
    //   28: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: aload_2
    //   32: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 121	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   41: iload_0
    //   42: ifne +130 -> 172
    //   45: getstatic 100	com/tencent/mobileqq/shortvideo/util/PtvFilterSoLoad:b	Lcom/tencent/mobileqq/shortvideo/util/PtvFilterSoLoad$SVFilterDownloadSession;
    //   48: getfield 151	com/tencent/mobileqq/shortvideo/util/PtvFilterSoLoad$SVFilterDownloadSession:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   51: iconst_4
    //   52: invokevirtual 160	java/util/concurrent/atomic/AtomicInteger:getAndSet	(I)I
    //   55: pop
    //   56: invokestatic 113	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   59: ifeq +34 -> 93
    //   62: ldc 13
    //   64: iconst_2
    //   65: new 71	java/lang/StringBuilder
    //   68: dup
    //   69: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   72: ldc_w 392
    //   75: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: getstatic 48	com/tencent/mobileqq/shortvideo/util/PtvFilterSoLoad:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   81: invokevirtual 246	java/util/ArrayList:size	()I
    //   84: invokevirtual 118	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   87: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: invokestatic 121	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   93: ldc 2
    //   95: monitorenter
    //   96: getstatic 48	com/tencent/mobileqq/shortvideo/util/PtvFilterSoLoad:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   99: invokevirtual 166	java/util/ArrayList:toArray	()[Ljava/lang/Object;
    //   102: astore_1
    //   103: ldc 2
    //   105: monitorexit
    //   106: aload_1
    //   107: ifnull +8 -> 115
    //   110: aload_1
    //   111: arraylength
    //   112: ifgt +178 -> 290
    //   115: invokestatic 113	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   118: ifeq +29 -> 147
    //   121: ldc 13
    //   123: iconst_2
    //   124: new 71	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   131: ldc_w 394
    //   134: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload_1
    //   138: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   141: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: invokestatic 121	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   147: getstatic 100	com/tencent/mobileqq/shortvideo/util/PtvFilterSoLoad:b	Lcom/tencent/mobileqq/shortvideo/util/PtvFilterSoLoad$SVFilterDownloadSession;
    //   150: getfield 151	com/tencent/mobileqq/shortvideo/util/PtvFilterSoLoad$SVFilterDownloadSession:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   153: invokevirtual 251	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   156: iconst_4
    //   157: if_icmpne +14 -> 171
    //   160: getstatic 100	com/tencent/mobileqq/shortvideo/util/PtvFilterSoLoad:b	Lcom/tencent/mobileqq/shortvideo/util/PtvFilterSoLoad$SVFilterDownloadSession;
    //   163: getfield 151	com/tencent/mobileqq/shortvideo/util/PtvFilterSoLoad$SVFilterDownloadSession:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   166: iconst_0
    //   167: invokevirtual 160	java/util/concurrent/atomic/AtomicInteger:getAndSet	(I)I
    //   170: pop
    //   171: return
    //   172: invokestatic 257	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   175: invokestatic 259	com/tencent/mobileqq/shortvideo/util/PtvFilterSoLoad:a	(Landroid/content/Context;)Ljava/lang/String;
    //   178: astore_1
    //   179: new 71	java/lang/StringBuilder
    //   182: dup
    //   183: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   186: aload_1
    //   187: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: ldc 26
    //   192: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   198: astore_3
    //   199: getstatic 69	com/tencent/mobileqq/shortvideo/util/PtvFilterSoLoad:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   202: astore_1
    //   203: aload_1
    //   204: monitorenter
    //   205: new 71	java/lang/StringBuilder
    //   208: dup
    //   209: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   212: aload_3
    //   213: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: ldc 23
    //   218: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: astore 4
    //   226: aload 4
    //   228: invokestatic 266	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;)Z
    //   231: pop
    //   232: aload_2
    //   233: aload_3
    //   234: iconst_0
    //   235: invokestatic 269	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   238: aload 4
    //   240: invokestatic 272	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Ljava/io/File;
    //   243: pop
    //   244: aload_1
    //   245: monitorexit
    //   246: getstatic 100	com/tencent/mobileqq/shortvideo/util/PtvFilterSoLoad:b	Lcom/tencent/mobileqq/shortvideo/util/PtvFilterSoLoad$SVFilterDownloadSession;
    //   249: getfield 151	com/tencent/mobileqq/shortvideo/util/PtvFilterSoLoad$SVFilterDownloadSession:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   252: iconst_3
    //   253: invokevirtual 160	java/util/concurrent/atomic/AtomicInteger:getAndSet	(I)I
    //   256: pop
    //   257: goto -201 -> 56
    //   260: astore_1
    //   261: aload_1
    //   262: invokevirtual 277	java/io/IOException:printStackTrace	()V
    //   265: getstatic 100	com/tencent/mobileqq/shortvideo/util/PtvFilterSoLoad:b	Lcom/tencent/mobileqq/shortvideo/util/PtvFilterSoLoad$SVFilterDownloadSession;
    //   268: getfield 151	com/tencent/mobileqq/shortvideo/util/PtvFilterSoLoad$SVFilterDownloadSession:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   271: iconst_4
    //   272: invokevirtual 160	java/util/concurrent/atomic/AtomicInteger:getAndSet	(I)I
    //   275: pop
    //   276: goto -220 -> 56
    //   279: astore_2
    //   280: aload_1
    //   281: monitorexit
    //   282: aload_2
    //   283: athrow
    //   284: astore_1
    //   285: ldc 2
    //   287: monitorexit
    //   288: aload_1
    //   289: athrow
    //   290: iconst_0
    //   291: istore 5
    //   293: iload 5
    //   295: aload_1
    //   296: arraylength
    //   297: if_icmpge -126 -> 171
    //   300: aload_1
    //   301: iload 5
    //   303: aaload
    //   304: checkcast 168	com/tencent/mobileqq/shortvideo/util/PtvFilterSoLoad$FilterVideoSoCallback
    //   307: astore_2
    //   308: iload 5
    //   310: aload_1
    //   311: arraylength
    //   312: iconst_1
    //   313: isub
    //   314: if_icmpne +30 -> 344
    //   317: iconst_1
    //   318: istore_0
    //   319: getstatic 61	com/tencent/mobileqq/shortvideo/util/PtvFilterSoLoad:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   322: new 396	uso
    //   325: dup
    //   326: iload_0
    //   327: aload_2
    //   328: invokespecial 397	uso:<init>	(ZLcom/tencent/mobileqq/shortvideo/util/PtvFilterSoLoad$FilterVideoSoCallback;)V
    //   331: invokevirtual 177	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   334: pop
    //   335: iload 5
    //   337: iconst_1
    //   338: iadd
    //   339: istore 5
    //   341: goto -48 -> 293
    //   344: iconst_0
    //   345: istore_0
    //   346: goto -27 -> 319
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	349	0	paramBoolean	boolean
    //   0	349	2	paramString	String
    //   198	36	3	str1	String
    //   224	15	4	str2	String
    //   291	49	5	i	int
    // Exception table:
    //   from	to	target	type
    //   199	205	260	java/io/IOException
    //   246	257	260	java/io/IOException
    //   282	284	260	java/io/IOException
    //   205	246	279	finally
    //   280	282	279	finally
    //   96	106	284	finally
    //   285	288	284	finally
  }
  
  public static boolean b()
  {
    if (CameraCompatibleList.e(CameraCompatibleList.w)) {}
    for (;;)
    {
      return false;
      boolean bool = VcSystemInfo.g();
      try
      {
        Class localClass = Class.forName("android.opengl.EGL14");
        if ((!bool) || (localClass == null) || (Build.VERSION.SDK_INT < 17)) {
          continue;
        }
        return true;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        for (;;)
        {
          Object localObject = null;
        }
      }
    }
  }
  
  public static boolean b(Context paramContext)
  {
    return (PtvFilterSoLoad.SVFilterSoLoadStatus.b(paramContext)) && (PtvFilterSoLoad.SVFilterSoLoadStatus.c());
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\util\PtvFilterSoLoad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */