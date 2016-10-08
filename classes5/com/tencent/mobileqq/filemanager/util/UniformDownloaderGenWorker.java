package com.tencent.mobileqq.filemanager.util;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.HttpUrlProcessor;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticAssist;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import mqq.app.MobileQQ;

public class UniformDownloaderGenWorker
  implements IHttpCommunicatorListener
{
  public static int a = 0;
  public static String a;
  public static int b = 0;
  public static final String b = "EXT_TRANS_SIZE ";
  public static int c = 0;
  public static final String c = "EXT_TTRANS_SIZE ";
  public static final int d = 3;
  public static final String d = "EXT_AUTOTRY_COUNT";
  long jdField_a_of_type_Long = 0L;
  private UniformDownloaderGen.IUniformDownloaderGenListener jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloaderGen$IUniformDownloaderGenListener;
  private HttpMsg jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg;
  private OutputStream jdField_a_of_type_JavaIoOutputStream;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  long jdField_b_of_type_Long = 0L;
  private Object jdField_b_of_type_JavaLangObject = new Object();
  private final long jdField_c_of_type_Long;
  private Object jdField_c_of_type_JavaLangObject = new Object();
  private long jdField_d_of_type_Long;
  private Object jdField_d_of_type_JavaLangObject = new Object();
  private int jdField_e_of_type_Int = jdField_b_of_type_Int;
  private long jdField_e_of_type_Long;
  private Object jdField_e_of_type_JavaLangObject = new Object();
  private final String jdField_e_of_type_JavaLangString;
  private int jdField_f_of_type_Int;
  private String jdField_f_of_type_JavaLangString;
  private int jdField_g_of_type_Int;
  private String jdField_g_of_type_JavaLangString;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = "UniformDownloaderGenWorker<FileAssistant>";
    jdField_a_of_type_Int = 1;
    jdField_b_of_type_Int = 2;
    jdField_c_of_type_Int = 3;
  }
  
  public UniformDownloaderGenWorker(long paramLong1, QQAppInterface paramQQAppInterface, String paramString1, long paramLong2, String paramString2, UniformDownloaderGen.IUniformDownloaderGenListener paramIUniformDownloaderGenListener)
  {
    this.jdField_c_of_type_Long = paramLong1;
    this.jdField_e_of_type_JavaLangString = new HttpUrlProcessor(paramQQAppInterface, paramString1).a();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloaderGen$IUniformDownloaderGenListener = paramIUniformDownloaderGenListener;
    this.jdField_d_of_type_Long = paramLong2;
    this.jdField_g_of_type_JavaLangString = paramString2;
  }
  
  private int a()
  {
    int i = jdField_b_of_type_Int;
    synchronized (this.jdField_e_of_type_JavaLangObject)
    {
      i = this.jdField_e_of_type_Int;
      return i;
    }
  }
  
  private long a()
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      long l = this.jdField_e_of_type_Long;
      return l;
    }
  }
  
  private UniformDownloaderGen.IUniformDownloaderGenListener a()
  {
    synchronized (this.jdField_d_of_type_JavaLangObject)
    {
      UniformDownloaderGen.IUniformDownloaderGenListener localIUniformDownloaderGenListener = this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloaderGen$IUniformDownloaderGenListener;
      return localIUniformDownloaderGenListener;
    }
  }
  
  private HttpMsg a()
  {
    synchronized (this.jdField_c_of_type_JavaLangObject)
    {
      HttpMsg localHttpMsg = this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg;
      return localHttpMsg;
    }
  }
  
  private void a(int paramInt)
  {
    synchronized (this.jdField_e_of_type_JavaLangObject)
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. setStatus: " + this.jdField_e_of_type_Int + " -> " + paramInt);
      this.jdField_e_of_type_Int = paramInt;
      return;
    }
  }
  
  private void a(int paramInt, String paramString1, String paramString2)
  {
    c();
    QQAppInterface localQQAppInterface = UniformDownloadMgr.a().a();
    if (localQQAppInterface != null)
    {
      FileManagerUtil.a(localQQAppInterface, this.jdField_c_of_type_Long, "actFileUfGenDownload", this.jdField_a_of_type_Long, "", "", "", "", paramInt, paramString1, this.jdField_b_of_type_Long, this.jdField_e_of_type_Long, this.jdField_d_of_type_Long, this.jdField_e_of_type_JavaLangString, "", this.jdField_f_of_type_Int, paramString2, null);
      FileManagerUtil.a(localQQAppInterface, this.jdField_c_of_type_Long, "actFileUfGenDownloadDetail", this.jdField_a_of_type_Long, "", "", "", "", paramInt, paramString1, this.jdField_b_of_type_Long, this.jdField_e_of_type_Long, this.jdField_d_of_type_Long, this.jdField_e_of_type_JavaLangString, "", this.jdField_f_of_type_Int, paramString2, null);
      StatisticAssist.a(localQQAppInterface.getApplication().getApplicationContext(), localQQAppInterface.a(), "Stop_download_2-0_3-1");
    }
    for (;;)
    {
      paramString2 = a();
      if (paramString2 != null) {
        paramString2.a(paramInt, paramString1, null);
      }
      return;
      QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "].report failed - 3");
    }
  }
  
  private void a(long paramLong)
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      this.jdField_e_of_type_Long = paramLong;
      return;
    }
  }
  
  private void a(UniformDownloaderGen.IUniformDownloaderGenListener paramIUniformDownloaderGenListener)
  {
    synchronized (this.jdField_d_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloaderGen$IUniformDownloaderGenListener = paramIUniformDownloaderGenListener;
      return;
    }
  }
  
  private boolean a()
  {
    return jdField_b_of_type_Int == a();
  }
  
  /* Error */
  private boolean a(long paramLong)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: lload_1
    //   7: invokespecial 186	com/tencent/mobileqq/filemanager/util/UniformDownloaderGenWorker:a	(J)V
    //   10: new 96	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   17: ldc -68
    //   19: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: lload_1
    //   23: invokevirtual 106	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   26: ldc -66
    //   28: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: astore 4
    //   36: aload_0
    //   37: getfield 79	com/tencent/mobileqq/filemanager/util/UniformDownloaderGenWorker:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   40: ifnull +235 -> 275
    //   43: aload_0
    //   44: getfield 79	com/tencent/mobileqq/filemanager/util/UniformDownloaderGenWorker:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   47: ldc -64
    //   49: invokevirtual 198	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   52: ifne +223 -> 275
    //   55: new 96	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   62: aload_0
    //   63: getfield 79	com/tencent/mobileqq/filemanager/util/UniformDownloaderGenWorker:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   66: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: ldc -56
    //   71: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: lload_1
    //   75: invokestatic 204	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   78: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: astore_3
    //   85: new 206	com/tencent/mobileqq/utils/httputils/HttpMsg
    //   88: dup
    //   89: aload_3
    //   90: aconst_null
    //   91: aload_0
    //   92: iconst_1
    //   93: invokespecial 209	com/tencent/mobileqq/utils/httputils/HttpMsg:<init>	(Ljava/lang/String;[BLcom/tencent/mobileqq/utils/httputils/IHttpCommunicatorListener;Z)V
    //   96: astore 5
    //   98: ldc -45
    //   100: astore_3
    //   101: invokestatic 217	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   104: invokestatic 222	com/tencent/mobileqq/utils/NetworkUtil:b	(Landroid/content/Context;)I
    //   107: iconst_1
    //   108: if_icmpne +6 -> 114
    //   111: ldc -32
    //   113: astore_3
    //   114: aload 5
    //   116: ldc -30
    //   118: aload_3
    //   119: invokevirtual 229	com/tencent/mobileqq/utils/httputils/HttpMsg:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   122: aload 5
    //   124: ldc -25
    //   126: aload 4
    //   128: invokevirtual 229	com/tencent/mobileqq/utils/httputils/HttpMsg:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   131: aload 5
    //   133: iconst_1
    //   134: invokevirtual 233	com/tencent/mobileqq/utils/httputils/HttpMsg:b	(I)V
    //   137: aload_0
    //   138: getfield 85	com/tencent/mobileqq/filemanager/util/UniformDownloaderGenWorker:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   141: invokestatic 238	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   144: ifne +14 -> 158
    //   147: aload 5
    //   149: ldc -16
    //   151: aload_0
    //   152: getfield 85	com/tencent/mobileqq/filemanager/util/UniformDownloaderGenWorker:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   155: invokevirtual 229	com/tencent/mobileqq/utils/httputils/HttpMsg:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   158: aload 5
    //   160: iconst_1
    //   161: invokevirtual 243	com/tencent/mobileqq/utils/httputils/HttpMsg:a	(Z)V
    //   164: aload 5
    //   166: iconst_5
    //   167: putfield 245	com/tencent/mobileqq/utils/httputils/HttpMsg:d	I
    //   170: aload 5
    //   172: iconst_0
    //   173: putfield 246	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_e_of_type_Int	I
    //   176: aload 5
    //   178: invokestatic 251	java/lang/System:currentTimeMillis	()J
    //   181: invokestatic 204	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   184: putfield 254	com/tencent/mobileqq/utils/httputils/HttpMsg:ai	Ljava/lang/String;
    //   187: aload 5
    //   189: ldc_w 256
    //   192: ldc_w 258
    //   195: invokevirtual 229	com/tencent/mobileqq/utils/httputils/HttpMsg:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   198: aload_0
    //   199: aload 5
    //   201: invokespecial 261	com/tencent/mobileqq/filemanager/util/UniformDownloaderGenWorker:b	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   204: invokestatic 130	com/tencent/mobileqq/filemanager/core/UniformDownloadMgr:a	()Lcom/tencent/mobileqq/filemanager/core/UniformDownloadMgr;
    //   207: invokevirtual 133	com/tencent/mobileqq/filemanager/core/UniformDownloadMgr:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   210: astore_3
    //   211: aload_3
    //   212: ifnonnull +97 -> 309
    //   215: getstatic 40	com/tencent/mobileqq/filemanager/util/UniformDownloaderGenWorker:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   218: iconst_1
    //   219: new 96	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   226: ldc 99
    //   228: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: aload_0
    //   232: getfield 69	com/tencent/mobileqq/filemanager/util/UniformDownloaderGenWorker:jdField_c_of_type_Long	J
    //   235: invokevirtual 106	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   238: ldc_w 263
    //   241: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: lload_1
    //   245: invokevirtual 106	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   248: ldc_w 265
    //   251: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: lload_1
    //   255: aload_0
    //   256: getfield 83	com/tencent/mobileqq/filemanager/util/UniformDownloaderGenWorker:jdField_d_of_type_Long	J
    //   259: ldiv
    //   260: l2i
    //   261: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   264: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   267: invokestatic 122	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   270: aload_0
    //   271: monitorexit
    //   272: iload 6
    //   274: ireturn
    //   275: new 96	java/lang/StringBuilder
    //   278: dup
    //   279: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   282: aload_0
    //   283: getfield 79	com/tencent/mobileqq/filemanager/util/UniformDownloaderGenWorker:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   286: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: ldc_w 267
    //   292: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: lload_1
    //   296: invokestatic 204	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   299: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   305: astore_3
    //   306: goto -221 -> 85
    //   309: aload_3
    //   310: invokevirtual 270	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/utils/httputils/HttpCommunicator;
    //   313: aload 5
    //   315: invokevirtual 275	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)I
    //   318: pop
    //   319: getstatic 40	com/tencent/mobileqq/filemanager/util/UniformDownloaderGenWorker:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   322: iconst_1
    //   323: new 96	java/lang/StringBuilder
    //   326: dup
    //   327: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   330: ldc 99
    //   332: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: aload_0
    //   336: getfield 69	com/tencent/mobileqq/filemanager/util/UniformDownloaderGenWorker:jdField_c_of_type_Long	J
    //   339: invokevirtual 106	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   342: ldc_w 277
    //   345: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: lload_1
    //   349: invokevirtual 106	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   352: ldc_w 265
    //   355: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: lload_1
    //   359: aload_0
    //   360: getfield 83	com/tencent/mobileqq/filemanager/util/UniformDownloaderGenWorker:jdField_d_of_type_Long	J
    //   363: ldiv
    //   364: l2i
    //   365: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   368: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   371: invokestatic 122	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   374: iconst_1
    //   375: istore 6
    //   377: goto -107 -> 270
    //   380: astore_3
    //   381: aload_0
    //   382: monitorexit
    //   383: aload_3
    //   384: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	385	0	this	UniformDownloaderGenWorker
    //   0	385	1	paramLong	long
    //   84	226	3	localObject1	Object
    //   380	4	3	localObject2	Object
    //   34	93	4	str	String
    //   96	218	5	localHttpMsg	HttpMsg
    //   1	375	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   5	85	380	finally
    //   85	98	380	finally
    //   101	111	380	finally
    //   114	158	380	finally
    //   158	211	380	finally
    //   215	270	380	finally
    //   275	306	380	finally
    //   309	374	380	finally
  }
  
  private boolean a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    if (paramHttpMsg1 == null) {
      return false;
    }
    if (paramHttpMsg2 == null) {
      return true;
    }
    return paramHttpMsg2.d();
  }
  
  private boolean a(byte[] paramArrayOfByte)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      try
      {
        if (this.jdField_a_of_type_JavaIoOutputStream == null)
        {
          QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. writeFileStream: stream = null:");
          return false;
        }
        this.jdField_a_of_type_JavaIoOutputStream.write(paramArrayOfByte);
        return true;
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return false;
      }
    }
  }
  
  private void b(HttpMsg paramHttpMsg)
  {
    synchronized (this.jdField_c_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = paramHttpMsg;
      return;
    }
  }
  
  private boolean b()
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        OutputStream localOutputStream = this.jdField_a_of_type_JavaIoOutputStream;
        if (localOutputStream == null) {
          try
          {
            this.jdField_a_of_type_JavaIoOutputStream = new FileOutputStream(this.jdField_f_of_type_JavaLangString, true);
            QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. openFileStream: filepath:" + this.jdField_f_of_type_JavaLangString);
            return true;
          }
          catch (FileNotFoundException localFileNotFoundException)
          {
            QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. openFileStream: exception");
            localFileNotFoundException.printStackTrace();
            return false;
          }
        }
      }
      QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. openFileStream: had be opened");
    }
  }
  
  private void c()
  {
    try
    {
      a(jdField_b_of_type_Int);
      d();
      c();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private boolean c()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      try
      {
        if (this.jdField_a_of_type_JavaIoOutputStream != null)
        {
          this.jdField_a_of_type_JavaIoOutputStream.close();
          this.jdField_a_of_type_JavaIoOutputStream = null;
          QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. closeFileStream: filepath:" + this.jdField_f_of_type_JavaLangString);
        }
        for (;;)
        {
          return true;
          QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. closeFileStream.had closed: stream = null:");
        }
        localObject2 = finally;
      }
      catch (IOException localIOException)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. closeFileStream: exception");
        localIOException.printStackTrace();
        return false;
      }
    }
  }
  
  private void d()
  {
    HttpMsg localHttpMsg = a();
    if (localHttpMsg != null)
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. stopHttpRequest");
      b(null);
      QQAppInterface localQQAppInterface = UniformDownloadMgr.a().a();
      if (localQQAppInterface == null)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. stopHttpRequest failed.APP=null");
        return;
      }
      localQQAppInterface.a().a(localHttpMsg);
      return;
    }
    QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. stopHttpRequest: no request");
  }
  
  public void a()
  {
    c();
    a(null);
  }
  
  public void a(HttpMsg paramHttpMsg)
  {
    int i;
    int j;
    int k;
    if (paramHttpMsg != null)
    {
      i = paramHttpMsg.d;
      j = paramHttpMsg.jdField_e_of_type_Int;
      k = paramHttpMsg.jdField_f_of_type_Int;
      if (((i == -1) || (j == -1)) && (QLog.isColorLevel())) {
        QLog.e("flowstat", 2, "fileType:" + i + ",busiType:" + j);
      }
      if (!"POST".equals(paramHttpMsg.e())) {
        break label139;
      }
    }
    QQAppInterface localQQAppInterface;
    label139:
    for (boolean bool = true;; bool = false)
    {
      localQQAppInterface = UniformDownloadMgr.a().a();
      if (localQQAppInterface != null) {
        break;
      }
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. onFlowEvent failed.APP=null");
      return;
    }
    localQQAppInterface.a(localQQAppInterface.getAccount(), bool, k, i, j, paramHttpMsg.i);
  }
  
  public void a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    if (a()) {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. decode. but had stoped");
    }
    int i;
    do
    {
      long l1;
      do
      {
        for (;;)
        {
          return;
          try
          {
            if ((paramHttpMsg2.c() == 206) || (paramHttpMsg2.c() == 200)) {
              if (!a(paramHttpMsg2.a()))
              {
                i = 3;
                paramHttpMsg1 = UniformDownloader.a(3);
                l1 = 0L;
                if (SystemUtil.a()) {
                  l1 = SystemUtil.a() * 1024L;
                }
                if (l1 < this.jdField_d_of_type_Long - a())
                {
                  QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] write file failed. sd card space is no enough:[" + this.jdField_d_of_type_Long + " " + a() + " " + l1 + "]");
                  i = 9;
                  paramHttpMsg1 = UniformDownloader.a(9);
                }
                a(i, paramHttpMsg1, paramHttpMsg1);
                return;
              }
            }
          }
          catch (Exception paramHttpMsg1)
          {
            paramHttpMsg1.printStackTrace();
            paramHttpMsg1 = UniformDownloader.a(12);
            a(12, paramHttpMsg1, paramHttpMsg1);
            return;
          }
        }
        l1 = a() + paramHttpMsg2.a().length;
        long l2 = paramHttpMsg2.a();
        if (this.jdField_d_of_type_Long != l2) {
          this.jdField_d_of_type_Long = l2;
        }
        a(l1);
        this.jdField_b_of_type_Long += paramHttpMsg2.a().length;
        if (l1 < this.jdField_d_of_type_Long) {
          break;
        }
        if (!c())
        {
          QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "].closeFileStream falied.path=" + this.jdField_f_of_type_JavaLangString);
          paramHttpMsg1 = UniformDownloader.a(4);
          a(4, paramHttpMsg1, paramHttpMsg1);
          return;
        }
        QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "].decode >>>>>>>. SUCESSFUL!!!");
        paramHttpMsg1 = a();
      } while (paramHttpMsg1 == null);
      paramHttpMsg2 = new Bundle();
      paramHttpMsg2.putLong("EXT_TRANS_SIZE ", this.jdField_e_of_type_Long);
      paramHttpMsg2.putLong("EXT_TTRANS_SIZE ", this.jdField_b_of_type_Long);
      paramHttpMsg2.putInt("EXT_AUTOTRY_COUNT", this.jdField_f_of_type_Int);
      paramHttpMsg1.a(this.jdField_f_of_type_JavaLangString, this.jdField_d_of_type_Long, paramHttpMsg2);
      return;
      i = (int)((float)l1 / (float)this.jdField_d_of_type_Long * 100.0F);
      paramHttpMsg1 = a();
    } while (paramHttpMsg1 == null);
    paramHttpMsg1.a(i, null);
  }
  
  public void a(String paramString) {}
  
  public boolean a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt)
  {
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. HttpCommunicator statusChanged. status:" + paramInt);
    if ((5 == paramInt) && (a() < this.jdField_d_of_type_Long))
    {
      c();
      paramHttpMsg1 = UniformDownloader.a(14);
      QQAppInterface localQQAppInterface = UniformDownloadMgr.a().a();
      if (localQQAppInterface == null) {
        break label226;
      }
      FileManagerUtil.a(localQQAppInterface, this.jdField_c_of_type_Long, "actFileUfGenDownload", this.jdField_a_of_type_Long, "", "", "", "", 14, paramHttpMsg1, this.jdField_b_of_type_Long, this.jdField_e_of_type_Long, this.jdField_d_of_type_Long, paramHttpMsg2.b(), paramHttpMsg2.al, this.jdField_f_of_type_Int, paramHttpMsg1, null);
      FileManagerUtil.a(localQQAppInterface, this.jdField_c_of_type_Long, "actFileUfGenDownloadDetail", this.jdField_a_of_type_Long, "", "", "", "", 14, paramHttpMsg1, this.jdField_b_of_type_Long, this.jdField_e_of_type_Long, this.jdField_d_of_type_Long, paramHttpMsg2.b(), paramHttpMsg2.al, this.jdField_f_of_type_Int, paramHttpMsg1, null);
      StatisticAssist.a(localQQAppInterface.getApplication().getApplicationContext(), localQQAppInterface.a(), "Stop_download_2-0_3-1");
    }
    for (;;)
    {
      paramHttpMsg1 = a();
      if (paramHttpMsg1 != null) {
        paramHttpMsg1.a(14, "downloader fialed", null);
      }
      return true;
      label226:
      QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "].report failed - 2");
    }
  }
  
  public boolean a(String paramString, long paramLong)
  {
    if (paramString == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. start failed. filepath = null. POS:" + paramLong);
      return false;
    }
    if (jdField_a_of_type_Int == a())
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. start. is runing. POS:" + paramLong);
      return true;
    }
    this.jdField_f_of_type_JavaLangString = paramString;
    if (!b())
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. start failed. openFileStream failed. POS:" + paramLong);
      paramString = UniformDownloader.a(8);
      a(8, paramString, paramString);
      return false;
    }
    if (!a(paramLong))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. start download failed. POS:" + paramLong);
      paramString = UniformDownloader.a(6);
      a(6, paramString, paramString);
      return false;
    }
    a(jdField_a_of_type_Int);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. start to run download . POS:" + paramLong);
    return true;
  }
  
  public void b()
  {
    a(jdField_c_of_type_Int);
  }
  
  public void b(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    if (a())
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. handleError..user puase");
      return;
    }
    if (paramHttpMsg2 == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. handleError.. response=NULL:");
      c();
      paramHttpMsg1 = UniformDownloader.a(5);
      paramHttpMsg2 = UniformDownloadMgr.a().a();
      if (paramHttpMsg2 != null)
      {
        FileManagerUtil.a(paramHttpMsg2, this.jdField_c_of_type_Long, "actFileUfGenDownload", this.jdField_a_of_type_Long, "", "", "", "", 5, paramHttpMsg1, this.jdField_b_of_type_Long, this.jdField_e_of_type_Long, this.jdField_d_of_type_Long, this.jdField_e_of_type_JavaLangString, "", 0, paramHttpMsg1, null);
        FileManagerUtil.a(paramHttpMsg2, this.jdField_c_of_type_Long, "actFileUfGenDownloadDetail", this.jdField_a_of_type_Long, "", "", "", "", 5, paramHttpMsg1, this.jdField_b_of_type_Long, this.jdField_e_of_type_Long, this.jdField_d_of_type_Long, this.jdField_e_of_type_JavaLangString, "", 0, paramHttpMsg1, null);
        StatisticAssist.a(paramHttpMsg2.getApplication().getApplicationContext(), paramHttpMsg2.a(), "Stop_download_2-0_3-1");
      }
      for (;;)
      {
        paramHttpMsg2 = a();
        if (paramHttpMsg2 == null) {
          break;
        }
        paramHttpMsg2.a(5, paramHttpMsg1, null);
        return;
        QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "].report failed - 111");
      }
    }
    Object localObject2 = paramHttpMsg2.d();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "null";
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. handleError.. errString:" + (String)localObject1);
    if (jdField_c_of_type_Int == a())
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. handleError.. slience pause. may app destroy!!");
      c();
      return;
    }
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      c();
      paramHttpMsg1 = UniformDownloader.a(2);
      paramHttpMsg2 = UniformDownloadMgr.a().a();
      if (paramHttpMsg2 != null)
      {
        FileManagerUtil.a(paramHttpMsg2, this.jdField_c_of_type_Long, "actFileUfGenDownload", this.jdField_a_of_type_Long, "", "", "", "", 2, paramHttpMsg1, this.jdField_b_of_type_Long, this.jdField_e_of_type_Long, this.jdField_d_of_type_Long, this.jdField_e_of_type_JavaLangString, "", 0, paramHttpMsg1, null);
        FileManagerUtil.a(paramHttpMsg2, this.jdField_c_of_type_Long, "actFileUfGenDownloadDetail", this.jdField_a_of_type_Long, "", "", "", "", 2, paramHttpMsg1, this.jdField_b_of_type_Long, this.jdField_e_of_type_Long, this.jdField_d_of_type_Long, this.jdField_e_of_type_JavaLangString, "", 0, paramHttpMsg1, null);
        StatisticAssist.a(paramHttpMsg2.getApplication().getApplicationContext(), paramHttpMsg2.a(), "Stop_download_2-0_3-1");
      }
      for (;;)
      {
        paramHttpMsg2 = a();
        if (paramHttpMsg2 == null) {
          break;
        }
        paramHttpMsg2.a(2, paramHttpMsg1, null);
        return;
        QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "].report failed - 11");
      }
    }
    long l = paramHttpMsg2.h;
    int i = paramHttpMsg2.a();
    localObject1 = paramHttpMsg2.d();
    if ((a(paramHttpMsg1, paramHttpMsg2)) && (this.jdField_f_of_type_Int < 3))
    {
      this.jdField_f_of_type_Int += 1;
      if ((this.jdField_g_of_type_Int < 3) && (paramHttpMsg2.h == 9056))
      {
        this.jdField_g_of_type_Int += 1;
        this.jdField_f_of_type_Int -= 1;
        label652:
        QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. handleError. auto retry to download. autoRetry=" + this.jdField_f_of_type_Int + " eofRetry=" + this.jdField_g_of_type_Int);
        d();
        if (a(a())) {
          break label987;
        }
        QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. auto retry dowload failed.");
        localObject1 = UniformDownloader.a((int)13L);
        l = 13L;
      }
    }
    for (paramHttpMsg1 = (HttpMsg)localObject1;; paramHttpMsg1 = String.valueOf(i))
    {
      this.jdField_f_of_type_Int = 0;
      this.jdField_g_of_type_Int = 0;
      c();
      localObject2 = UniformDownloadMgr.a().a();
      if (localObject2 != null)
      {
        if (13L == l) {
          break label1171;
        }
        l = 11L;
        localObject1 = UniformDownloader.a((int)11L);
        paramHttpMsg1 = (HttpMsg)localObject1;
      }
      label987:
      label1171:
      for (;;)
      {
        FileManagerUtil.a((QQAppInterface)localObject2, this.jdField_c_of_type_Long, "actFileUfGenDownload", this.jdField_a_of_type_Long, "", "", "", "", l, paramHttpMsg1, this.jdField_b_of_type_Long, this.jdField_e_of_type_Long, this.jdField_d_of_type_Long, paramHttpMsg2.b(), paramHttpMsg2.al, this.jdField_f_of_type_Int, (String)localObject1, null);
        FileManagerUtil.a((QQAppInterface)localObject2, this.jdField_c_of_type_Long, "actFileUfGenDownloadDetail", this.jdField_a_of_type_Long, "", "", "", "", paramHttpMsg2.h, String.valueOf(paramHttpMsg2.a()), this.jdField_b_of_type_Long, this.jdField_e_of_type_Long, this.jdField_d_of_type_Long, paramHttpMsg2.b(), paramHttpMsg2.al, this.jdField_f_of_type_Int, paramHttpMsg2.d(), null);
        StatisticAssist.a(((QQAppInterface)localObject2).getApplication().getApplicationContext(), ((QQAppInterface)localObject2).a(), "Stop_download_2-0_3-1");
        for (;;)
        {
          paramHttpMsg1 = a();
          if (paramHttpMsg1 == null) {
            break;
          }
          paramHttpMsg1.a(6, "downloader fialed", null);
          return;
          this.jdField_g_of_type_Int = 0;
          break label652;
          QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. auto retry dowload started.");
          paramHttpMsg1 = UniformDownloadMgr.a().a();
          if (paramHttpMsg1 != null)
          {
            FileManagerUtil.a(paramHttpMsg1, this.jdField_c_of_type_Long, "actFileUfGenDownloadDetail", this.jdField_a_of_type_Long, "", "", "", "", paramHttpMsg2.h, String.valueOf(paramHttpMsg2.a()), this.jdField_b_of_type_Long, this.jdField_e_of_type_Long, this.jdField_d_of_type_Long, paramHttpMsg2.b(), paramHttpMsg2.al, this.jdField_f_of_type_Int, paramHttpMsg2.d(), null);
            return;
          }
          QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "].report failed - 1");
          return;
          QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "].report failed - 2");
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\util\UniformDownloaderGenWorker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */