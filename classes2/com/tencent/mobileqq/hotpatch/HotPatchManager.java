package com.tencent.mobileqq.hotpatch;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.INetEngine.IBreakDownFix;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import svn;

public class HotPatchManager
  implements Handler.Callback, INetEngine.IBreakDownFix, INetEngine.INetEngineListener, Manager
{
  private static final int jdField_a_of_type_Int = 1052688;
  private static final String jdField_a_of_type_JavaLangString = "HotPatchManager";
  private static final int jdField_b_of_type_Int = 1052689;
  private static final String jdField_b_of_type_JavaLangString = "dex";
  private static final int jdField_c_of_type_Int = 3;
  private static final String jdField_c_of_type_JavaLangString = "Native";
  private static final int jdField_d_of_type_Int = 0;
  private static final String jdField_d_of_type_JavaLangString = "DVM";
  private static final int jdField_e_of_type_Int = 1;
  private static final String jdField_e_of_type_JavaLangString = "art";
  private static final int f = 2;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  
  public HotPatchManager(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.b(), this);
  }
  
  private void a(NetReq paramNetReq, int paramInt1, int paramInt2)
  {
    QLog.d("HotPatchManager", 1, "doOnProgress curOffset=" + paramInt1 + ", totalLen=" + paramInt2);
  }
  
  /* Error */
  private static java.security.cert.Certificate[] a(java.util.jar.JarFile paramJarFile, java.util.jar.JarEntry paramJarEntry)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: new 103	java/io/BufferedInputStream
    //   8: dup
    //   9: aload_0
    //   10: aload_1
    //   11: invokevirtual 109	java/util/jar/JarFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   14: invokespecial 112	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: astore_2
    //   18: aload_2
    //   19: astore_0
    //   20: sipush 4096
    //   23: newarray <illegal type>
    //   25: astore 5
    //   27: aload_2
    //   28: astore_0
    //   29: aload_2
    //   30: aload 5
    //   32: iconst_0
    //   33: aload 5
    //   35: arraylength
    //   36: invokevirtual 118	java/io/InputStream:read	([BII)I
    //   39: iconst_m1
    //   40: if_icmpne -13 -> 27
    //   43: aload 4
    //   45: astore_0
    //   46: aload_1
    //   47: ifnull +12 -> 59
    //   50: aload_2
    //   51: astore_0
    //   52: aload_1
    //   53: invokevirtual 124	java/util/jar/JarEntry:getCertificates	()[Ljava/security/cert/Certificate;
    //   56: astore_1
    //   57: aload_1
    //   58: astore_0
    //   59: aload_0
    //   60: astore_1
    //   61: aload_2
    //   62: ifnull +9 -> 71
    //   65: aload_2
    //   66: invokevirtual 127	java/io/InputStream:close	()V
    //   69: aload_0
    //   70: astore_1
    //   71: aload_1
    //   72: areturn
    //   73: astore_1
    //   74: aload_1
    //   75: invokevirtual 130	java/io/IOException:printStackTrace	()V
    //   78: aload_0
    //   79: areturn
    //   80: astore_1
    //   81: aconst_null
    //   82: astore_2
    //   83: aload_2
    //   84: astore_0
    //   85: ldc 18
    //   87: iconst_1
    //   88: new 73	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   95: ldc -123
    //   97: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: aload_1
    //   101: invokevirtual 134	java/io/IOException:toString	()Ljava/lang/String;
    //   104: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   113: aload_2
    //   114: astore_0
    //   115: aload_1
    //   116: invokevirtual 130	java/io/IOException:printStackTrace	()V
    //   119: aload_3
    //   120: astore_1
    //   121: aload_2
    //   122: ifnull -51 -> 71
    //   125: aload_2
    //   126: invokevirtual 127	java/io/InputStream:close	()V
    //   129: aconst_null
    //   130: areturn
    //   131: astore_0
    //   132: aload_0
    //   133: invokevirtual 130	java/io/IOException:printStackTrace	()V
    //   136: aconst_null
    //   137: areturn
    //   138: astore_1
    //   139: aconst_null
    //   140: astore_2
    //   141: aload_2
    //   142: astore_0
    //   143: ldc 18
    //   145: iconst_1
    //   146: new 73	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   153: ldc -120
    //   155: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: aload_1
    //   159: invokevirtual 137	java/lang/RuntimeException:toString	()Ljava/lang/String;
    //   162: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   171: aload_2
    //   172: astore_0
    //   173: aload_1
    //   174: invokevirtual 138	java/lang/RuntimeException:printStackTrace	()V
    //   177: aload_3
    //   178: astore_1
    //   179: aload_2
    //   180: ifnull -109 -> 71
    //   183: aload_2
    //   184: invokevirtual 127	java/io/InputStream:close	()V
    //   187: aconst_null
    //   188: areturn
    //   189: astore_0
    //   190: aload_0
    //   191: invokevirtual 130	java/io/IOException:printStackTrace	()V
    //   194: aconst_null
    //   195: areturn
    //   196: astore_1
    //   197: aconst_null
    //   198: astore_0
    //   199: aload_0
    //   200: ifnull +7 -> 207
    //   203: aload_0
    //   204: invokevirtual 127	java/io/InputStream:close	()V
    //   207: aload_1
    //   208: athrow
    //   209: astore_0
    //   210: aload_0
    //   211: invokevirtual 130	java/io/IOException:printStackTrace	()V
    //   214: goto -7 -> 207
    //   217: astore_1
    //   218: goto -19 -> 199
    //   221: astore_1
    //   222: goto -81 -> 141
    //   225: astore_1
    //   226: goto -143 -> 83
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	229	0	paramJarFile	java.util.jar.JarFile
    //   0	229	1	paramJarEntry	java.util.jar.JarEntry
    //   17	167	2	localBufferedInputStream	java.io.BufferedInputStream
    //   1	177	3	localObject1	Object
    //   3	41	4	localObject2	Object
    //   25	9	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   65	69	73	java/io/IOException
    //   5	18	80	java/io/IOException
    //   125	129	131	java/io/IOException
    //   5	18	138	java/lang/RuntimeException
    //   183	187	189	java/io/IOException
    //   5	18	196	finally
    //   203	207	209	java/io/IOException
    //   20	27	217	finally
    //   29	43	217	finally
    //   52	57	217	finally
    //   85	113	217	finally
    //   115	119	217	finally
    //   143	171	217	finally
    //   173	177	217	finally
    //   20	27	221	java/lang/RuntimeException
    //   29	43	221	java/lang/RuntimeException
    //   52	57	221	java/lang/RuntimeException
    //   20	27	225	java/io/IOException
    //   29	43	225	java/io/IOException
    //   52	57	225	java/io/IOException
  }
  
  private void b(NetResp paramNetResp)
  {
    svn localsvn = (svn)paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.a();
    if (localsvn == null) {
      return;
    }
    if (paramNetResp.e == 3)
    {
      QLog.d("TAG", 1, "doOnResp is downloading...");
      return;
    }
    boolean bool;
    long l1;
    long l2;
    if (paramNetResp.e == 0)
    {
      bool = true;
      l1 = SystemClock.elapsedRealtime();
      l2 = localsvn.jdField_a_of_type_Long;
    }
    for (;;)
    {
      try
      {
        QLog.d("HotPatchManager", 1, "doOnResp reslut=" + bool + ", mTotalFileLen=" + paramNetResp.jdField_a_of_type_Long + ", UserData=" + localsvn + ", cost time=" + (l1 - l2));
        if ((!bool) || (paramNetResp.jdField_a_of_type_Long != localsvn.jdField_b_of_type_Long)) {
          break label369;
        }
        StatisticCollector.a(BaseApplicationImpl.a()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f(), "actNvwaDownload", 200, localsvn.jdField_a_of_type_JavaLangString);
        int i = a(localsvn.jdField_a_of_type_JavaLangString, paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.jdField_b_of_type_JavaLangString);
        QLog.d("HotPatchManager", 1, "doOnResp checkPatchSignature reslut=" + i);
        if (i == 0) {
          break label308;
        }
        if (i == 1)
        {
          paramNetResp = new File(paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.jdField_b_of_type_JavaLangString);
          if (paramNetResp.exists()) {
            paramNetResp.delete();
          }
        }
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localsvn.jdField_a_of_type_JavaLangString);
        return;
      }
      catch (Throwable paramNetResp)
      {
        StatisticCollector.a(BaseApplicationImpl.a()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f(), "actNvwaDownload", 202, localsvn.jdField_a_of_type_JavaLangString);
        QLog.d("HotPatchManager", 1, "doOnResp throwable=" + paramNetResp.toString());
        paramNetResp.printStackTrace();
        return;
      }
      bool = false;
      break;
      label308:
      if ((new DexClassLoader(paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.jdField_b_of_type_JavaLangString, BaseApplicationImpl.getContext().getDir("dex", 0).getAbsolutePath(), paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.jdField_b_of_type_JavaLangString, BaseApplicationImpl.getContext().getClassLoader()) != null) && (BaseApplicationImpl.j == 0))
      {
        paramNetResp = BaseApplicationImpl.a();
        paramNetResp.a(paramNetResp, false);
        continue;
        label369:
        if (localsvn.jdField_a_of_type_Int < 3)
        {
          a(localsvn.jdField_a_of_type_JavaLangString, localsvn.jdField_b_of_type_JavaLangString, localsvn.jdField_b_of_type_Long, localsvn.jdField_a_of_type_Int);
          return;
        }
        StatisticCollector.a(BaseApplicationImpl.a()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f(), "actNvwaDownload", 201, localsvn.jdField_a_of_type_JavaLangString);
        paramNetResp = new File(paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.jdField_b_of_type_JavaLangString);
        if (paramNetResp.exists()) {
          paramNetResp.delete();
        }
      }
    }
  }
  
  /* Error */
  public int a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 18
    //   2: iconst_1
    //   3: new 73	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   10: ldc_w 274
    //   13: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: aload_2
    //   17: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   23: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   26: new 105	java/util/jar/JarFile
    //   29: dup
    //   30: aload_2
    //   31: invokespecial 275	java/util/jar/JarFile:<init>	(Ljava/lang/String;)V
    //   34: astore 4
    //   36: aload 4
    //   38: astore_3
    //   39: aload 4
    //   41: invokevirtual 279	java/util/jar/JarFile:entries	()Ljava/util/Enumeration;
    //   44: astore 5
    //   46: aload 4
    //   48: astore_3
    //   49: aload 5
    //   51: invokeinterface 284 1 0
    //   56: ifeq +355 -> 411
    //   59: aload 4
    //   61: astore_3
    //   62: aload 5
    //   64: invokeinterface 287 1 0
    //   69: checkcast 120	java/util/jar/JarEntry
    //   72: astore 6
    //   74: aload 4
    //   76: astore_3
    //   77: aload 6
    //   79: invokevirtual 290	java/util/jar/JarEntry:isDirectory	()Z
    //   82: ifne -36 -> 46
    //   85: aload 4
    //   87: astore_3
    //   88: aload 6
    //   90: invokevirtual 293	java/util/jar/JarEntry:getName	()Ljava/lang/String;
    //   93: ldc_w 295
    //   96: invokevirtual 301	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   99: ifne -53 -> 46
    //   102: aload 4
    //   104: astore_3
    //   105: aload 4
    //   107: aload 6
    //   109: invokestatic 303	com/tencent/mobileqq/hotpatch/HotPatchManager:a	(Ljava/util/jar/JarFile;Ljava/util/jar/JarEntry;)[Ljava/security/cert/Certificate;
    //   112: astore 6
    //   114: aload 4
    //   116: astore_3
    //   117: new 73	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   124: ldc_w 305
    //   127: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: astore 7
    //   132: aload 6
    //   134: ifnull +249 -> 383
    //   137: aload 4
    //   139: astore_3
    //   140: aload 6
    //   142: arraylength
    //   143: istore 8
    //   145: aload 4
    //   147: astore_3
    //   148: ldc 18
    //   150: iconst_1
    //   151: aload 7
    //   153: iload 8
    //   155: invokevirtual 82	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   158: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   164: aload 6
    //   166: ifnull -120 -> 46
    //   169: aload 4
    //   171: astore_3
    //   172: aload 6
    //   174: arraylength
    //   175: iconst_1
    //   176: if_icmpne -130 -> 46
    //   179: aload 4
    //   181: astore_3
    //   182: new 307	android/content/pm/Signature
    //   185: dup
    //   186: aload 6
    //   188: iconst_0
    //   189: aaload
    //   190: invokevirtual 313	java/security/cert/Certificate:getEncoded	()[B
    //   193: invokespecial 316	android/content/pm/Signature:<init>	([B)V
    //   196: invokestatic 317	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   199: invokevirtual 321	com/tencent/qphone/base/util/BaseApplication:getPackageManager	()Landroid/content/pm/PackageManager;
    //   202: ldc_w 323
    //   205: bipush 64
    //   207: invokevirtual 329	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   210: getfield 335	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   213: iconst_0
    //   214: aaload
    //   215: invokevirtual 339	android/content/pm/Signature:equals	(Ljava/lang/Object;)Z
    //   218: istore 9
    //   220: aload 4
    //   222: astore_3
    //   223: ldc 18
    //   225: iconst_1
    //   226: new 73	java/lang/StringBuilder
    //   229: dup
    //   230: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   233: ldc_w 341
    //   236: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: iload 9
    //   241: invokevirtual 173	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   244: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   250: aload 4
    //   252: astore_3
    //   253: aload_1
    //   254: invokestatic 347	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   257: ifne +58 -> 315
    //   260: aload 4
    //   262: astore_3
    //   263: aload_2
    //   264: aload_1
    //   265: invokevirtual 350	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   268: ifeq +47 -> 315
    //   271: aload 4
    //   273: astore_3
    //   274: invokestatic 193	com/tencent/common/app/BaseApplicationImpl:a	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   277: ldc_w 352
    //   280: iconst_4
    //   281: invokevirtual 356	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   284: invokeinterface 362 1 0
    //   289: astore_2
    //   290: aload 4
    //   292: astore_3
    //   293: aload_2
    //   294: ldc_w 364
    //   297: iload 9
    //   299: invokeinterface 370 3 0
    //   304: pop
    //   305: aload 4
    //   307: astore_3
    //   308: aload_2
    //   309: invokeinterface 373 1 0
    //   314: pop
    //   315: aload 4
    //   317: astore_3
    //   318: invokestatic 193	com/tencent/common/app/BaseApplicationImpl:a	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   321: invokestatic 198	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   324: astore_2
    //   325: aload 4
    //   327: astore_3
    //   328: aload_0
    //   329: getfield 57	com/tencent/mobileqq/hotpatch/HotPatchManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   332: invokevirtual 202	com/tencent/mobileqq/app/QQAppInterface:f	()Ljava/lang/String;
    //   335: astore 5
    //   337: iload 9
    //   339: ifeq +50 -> 389
    //   342: sipush 300
    //   345: istore 8
    //   347: aload 4
    //   349: astore_3
    //   350: aload_2
    //   351: aload 5
    //   353: ldc_w 375
    //   356: iload 8
    //   358: aload_1
    //   359: invokevirtual 209	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   362: iload 9
    //   364: ifeq +33 -> 397
    //   367: iconst_0
    //   368: istore 8
    //   370: aload 4
    //   372: ifnull +8 -> 380
    //   375: aload 4
    //   377: invokevirtual 376	java/util/jar/JarFile:close	()V
    //   380: iload 8
    //   382: ireturn
    //   383: iconst_0
    //   384: istore 8
    //   386: goto -241 -> 145
    //   389: sipush 301
    //   392: istore 8
    //   394: goto -47 -> 347
    //   397: iconst_1
    //   398: istore 8
    //   400: goto -30 -> 370
    //   403: astore_1
    //   404: aload_1
    //   405: invokevirtual 130	java/io/IOException:printStackTrace	()V
    //   408: iload 8
    //   410: ireturn
    //   411: aload 4
    //   413: ifnull +8 -> 421
    //   416: aload 4
    //   418: invokevirtual 376	java/util/jar/JarFile:close	()V
    //   421: iconst_1
    //   422: ireturn
    //   423: astore_1
    //   424: aload_1
    //   425: invokevirtual 130	java/io/IOException:printStackTrace	()V
    //   428: goto -7 -> 421
    //   431: astore_3
    //   432: aconst_null
    //   433: astore_2
    //   434: invokestatic 193	com/tencent/common/app/BaseApplicationImpl:a	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   437: invokestatic 198	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   440: aload_0
    //   441: getfield 57	com/tencent/mobileqq/hotpatch/HotPatchManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   444: invokevirtual 202	com/tencent/mobileqq/app/QQAppInterface:f	()Ljava/lang/String;
    //   447: ldc_w 375
    //   450: sipush 302
    //   453: aload_1
    //   454: invokevirtual 209	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   457: ldc 18
    //   459: iconst_1
    //   460: new 73	java/lang/StringBuilder
    //   463: dup
    //   464: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   467: ldc_w 378
    //   470: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: aload_3
    //   474: invokevirtual 379	java/security/cert/CertificateEncodingException:toString	()Ljava/lang/String;
    //   477: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   483: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   486: aload_3
    //   487: invokevirtual 380	java/security/cert/CertificateEncodingException:printStackTrace	()V
    //   490: aload_2
    //   491: ifnull +7 -> 498
    //   494: aload_2
    //   495: invokevirtual 376	java/util/jar/JarFile:close	()V
    //   498: iconst_2
    //   499: ireturn
    //   500: astore_1
    //   501: aload_1
    //   502: invokevirtual 130	java/io/IOException:printStackTrace	()V
    //   505: goto -7 -> 498
    //   508: astore_2
    //   509: aconst_null
    //   510: astore 4
    //   512: aload 4
    //   514: astore_3
    //   515: invokestatic 193	com/tencent/common/app/BaseApplicationImpl:a	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   518: invokestatic 198	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   521: aload_0
    //   522: getfield 57	com/tencent/mobileqq/hotpatch/HotPatchManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   525: invokevirtual 202	com/tencent/mobileqq/app/QQAppInterface:f	()Ljava/lang/String;
    //   528: ldc_w 375
    //   531: sipush 302
    //   534: aload_1
    //   535: invokevirtual 209	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   538: aload 4
    //   540: astore_3
    //   541: ldc 18
    //   543: iconst_1
    //   544: new 73	java/lang/StringBuilder
    //   547: dup
    //   548: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   551: ldc_w 382
    //   554: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: aload_2
    //   558: invokevirtual 134	java/io/IOException:toString	()Ljava/lang/String;
    //   561: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   564: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   567: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   570: aload 4
    //   572: astore_3
    //   573: aload_2
    //   574: invokevirtual 130	java/io/IOException:printStackTrace	()V
    //   577: aload 4
    //   579: ifnull +8 -> 587
    //   582: aload 4
    //   584: invokevirtual 376	java/util/jar/JarFile:close	()V
    //   587: iconst_2
    //   588: ireturn
    //   589: astore_1
    //   590: aload_1
    //   591: invokevirtual 130	java/io/IOException:printStackTrace	()V
    //   594: goto -7 -> 587
    //   597: astore_2
    //   598: aconst_null
    //   599: astore 4
    //   601: aload 4
    //   603: astore_3
    //   604: invokestatic 193	com/tencent/common/app/BaseApplicationImpl:a	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   607: invokestatic 198	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   610: aload_0
    //   611: getfield 57	com/tencent/mobileqq/hotpatch/HotPatchManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   614: invokevirtual 202	com/tencent/mobileqq/app/QQAppInterface:f	()Ljava/lang/String;
    //   617: ldc_w 375
    //   620: sipush 302
    //   623: aload_1
    //   624: invokevirtual 209	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   627: aload 4
    //   629: astore_3
    //   630: ldc 18
    //   632: iconst_1
    //   633: new 73	java/lang/StringBuilder
    //   636: dup
    //   637: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   640: ldc_w 384
    //   643: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   646: aload_2
    //   647: invokevirtual 385	android/content/pm/PackageManager$NameNotFoundException:toString	()Ljava/lang/String;
    //   650: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   653: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   656: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   659: aload 4
    //   661: astore_3
    //   662: aload_2
    //   663: invokevirtual 386	android/content/pm/PackageManager$NameNotFoundException:printStackTrace	()V
    //   666: aload 4
    //   668: ifnull +8 -> 676
    //   671: aload 4
    //   673: invokevirtual 376	java/util/jar/JarFile:close	()V
    //   676: iconst_2
    //   677: ireturn
    //   678: astore_1
    //   679: aload_1
    //   680: invokevirtual 130	java/io/IOException:printStackTrace	()V
    //   683: goto -7 -> 676
    //   686: astore_2
    //   687: aconst_null
    //   688: astore 4
    //   690: aload 4
    //   692: astore_3
    //   693: invokestatic 193	com/tencent/common/app/BaseApplicationImpl:a	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   696: invokestatic 198	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   699: aload_0
    //   700: getfield 57	com/tencent/mobileqq/hotpatch/HotPatchManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   703: invokevirtual 202	com/tencent/mobileqq/app/QQAppInterface:f	()Ljava/lang/String;
    //   706: ldc_w 375
    //   709: sipush 302
    //   712: aload_1
    //   713: invokevirtual 209	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   716: aload 4
    //   718: astore_3
    //   719: ldc 18
    //   721: iconst_1
    //   722: new 73	java/lang/StringBuilder
    //   725: dup
    //   726: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   729: ldc_w 388
    //   732: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   735: aload_2
    //   736: invokevirtual 233	java/lang/Throwable:toString	()Ljava/lang/String;
    //   739: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   742: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   745: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   748: aload 4
    //   750: astore_3
    //   751: aload_2
    //   752: invokevirtual 234	java/lang/Throwable:printStackTrace	()V
    //   755: aload 4
    //   757: ifnull +8 -> 765
    //   760: aload 4
    //   762: invokevirtual 376	java/util/jar/JarFile:close	()V
    //   765: iconst_2
    //   766: ireturn
    //   767: astore_1
    //   768: aload_1
    //   769: invokevirtual 130	java/io/IOException:printStackTrace	()V
    //   772: goto -7 -> 765
    //   775: astore_1
    //   776: aconst_null
    //   777: astore_3
    //   778: aload_3
    //   779: ifnull +7 -> 786
    //   782: aload_3
    //   783: invokevirtual 376	java/util/jar/JarFile:close	()V
    //   786: aload_1
    //   787: athrow
    //   788: astore_2
    //   789: aload_2
    //   790: invokevirtual 130	java/io/IOException:printStackTrace	()V
    //   793: goto -7 -> 786
    //   796: astore_1
    //   797: goto -19 -> 778
    //   800: astore_1
    //   801: aload_2
    //   802: astore_3
    //   803: goto -25 -> 778
    //   806: astore_2
    //   807: goto -117 -> 690
    //   810: astore_2
    //   811: goto -210 -> 601
    //   814: astore_2
    //   815: goto -303 -> 512
    //   818: astore_3
    //   819: aload 4
    //   821: astore_2
    //   822: goto -388 -> 434
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	825	0	this	HotPatchManager
    //   0	825	1	paramString1	String
    //   0	825	2	paramString2	String
    //   38	312	3	localJarFile1	java.util.jar.JarFile
    //   431	56	3	localCertificateEncodingException1	java.security.cert.CertificateEncodingException
    //   514	289	3	localObject1	Object
    //   818	1	3	localCertificateEncodingException2	java.security.cert.CertificateEncodingException
    //   34	786	4	localJarFile2	java.util.jar.JarFile
    //   44	308	5	localObject2	Object
    //   72	115	6	localObject3	Object
    //   130	22	7	localStringBuilder	StringBuilder
    //   143	266	8	i	int
    //   218	145	9	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   375	380	403	java/io/IOException
    //   416	421	423	java/io/IOException
    //   26	36	431	java/security/cert/CertificateEncodingException
    //   494	498	500	java/io/IOException
    //   26	36	508	java/io/IOException
    //   582	587	589	java/io/IOException
    //   26	36	597	android/content/pm/PackageManager$NameNotFoundException
    //   671	676	678	java/io/IOException
    //   26	36	686	java/lang/Throwable
    //   760	765	767	java/io/IOException
    //   26	36	775	finally
    //   782	786	788	java/io/IOException
    //   39	46	796	finally
    //   49	59	796	finally
    //   62	74	796	finally
    //   77	85	796	finally
    //   88	102	796	finally
    //   105	114	796	finally
    //   117	132	796	finally
    //   140	145	796	finally
    //   148	164	796	finally
    //   172	179	796	finally
    //   182	220	796	finally
    //   223	250	796	finally
    //   253	260	796	finally
    //   263	271	796	finally
    //   274	290	796	finally
    //   293	305	796	finally
    //   308	315	796	finally
    //   318	325	796	finally
    //   328	337	796	finally
    //   350	362	796	finally
    //   515	538	796	finally
    //   541	570	796	finally
    //   573	577	796	finally
    //   604	627	796	finally
    //   630	659	796	finally
    //   662	666	796	finally
    //   693	716	796	finally
    //   719	748	796	finally
    //   751	755	796	finally
    //   434	490	800	finally
    //   39	46	806	java/lang/Throwable
    //   49	59	806	java/lang/Throwable
    //   62	74	806	java/lang/Throwable
    //   77	85	806	java/lang/Throwable
    //   88	102	806	java/lang/Throwable
    //   105	114	806	java/lang/Throwable
    //   117	132	806	java/lang/Throwable
    //   140	145	806	java/lang/Throwable
    //   148	164	806	java/lang/Throwable
    //   172	179	806	java/lang/Throwable
    //   182	220	806	java/lang/Throwable
    //   223	250	806	java/lang/Throwable
    //   253	260	806	java/lang/Throwable
    //   263	271	806	java/lang/Throwable
    //   274	290	806	java/lang/Throwable
    //   293	305	806	java/lang/Throwable
    //   308	315	806	java/lang/Throwable
    //   318	325	806	java/lang/Throwable
    //   328	337	806	java/lang/Throwable
    //   350	362	806	java/lang/Throwable
    //   39	46	810	android/content/pm/PackageManager$NameNotFoundException
    //   49	59	810	android/content/pm/PackageManager$NameNotFoundException
    //   62	74	810	android/content/pm/PackageManager$NameNotFoundException
    //   77	85	810	android/content/pm/PackageManager$NameNotFoundException
    //   88	102	810	android/content/pm/PackageManager$NameNotFoundException
    //   105	114	810	android/content/pm/PackageManager$NameNotFoundException
    //   117	132	810	android/content/pm/PackageManager$NameNotFoundException
    //   140	145	810	android/content/pm/PackageManager$NameNotFoundException
    //   148	164	810	android/content/pm/PackageManager$NameNotFoundException
    //   172	179	810	android/content/pm/PackageManager$NameNotFoundException
    //   182	220	810	android/content/pm/PackageManager$NameNotFoundException
    //   223	250	810	android/content/pm/PackageManager$NameNotFoundException
    //   253	260	810	android/content/pm/PackageManager$NameNotFoundException
    //   263	271	810	android/content/pm/PackageManager$NameNotFoundException
    //   274	290	810	android/content/pm/PackageManager$NameNotFoundException
    //   293	305	810	android/content/pm/PackageManager$NameNotFoundException
    //   308	315	810	android/content/pm/PackageManager$NameNotFoundException
    //   318	325	810	android/content/pm/PackageManager$NameNotFoundException
    //   328	337	810	android/content/pm/PackageManager$NameNotFoundException
    //   350	362	810	android/content/pm/PackageManager$NameNotFoundException
    //   39	46	814	java/io/IOException
    //   49	59	814	java/io/IOException
    //   62	74	814	java/io/IOException
    //   77	85	814	java/io/IOException
    //   88	102	814	java/io/IOException
    //   105	114	814	java/io/IOException
    //   117	132	814	java/io/IOException
    //   140	145	814	java/io/IOException
    //   148	164	814	java/io/IOException
    //   172	179	814	java/io/IOException
    //   182	220	814	java/io/IOException
    //   223	250	814	java/io/IOException
    //   253	260	814	java/io/IOException
    //   263	271	814	java/io/IOException
    //   274	290	814	java/io/IOException
    //   293	305	814	java/io/IOException
    //   308	315	814	java/io/IOException
    //   318	325	814	java/io/IOException
    //   328	337	814	java/io/IOException
    //   350	362	814	java/io/IOException
    //   39	46	818	java/security/cert/CertificateEncodingException
    //   49	59	818	java/security/cert/CertificateEncodingException
    //   62	74	818	java/security/cert/CertificateEncodingException
    //   77	85	818	java/security/cert/CertificateEncodingException
    //   88	102	818	java/security/cert/CertificateEncodingException
    //   105	114	818	java/security/cert/CertificateEncodingException
    //   117	132	818	java/security/cert/CertificateEncodingException
    //   140	145	818	java/security/cert/CertificateEncodingException
    //   148	164	818	java/security/cert/CertificateEncodingException
    //   172	179	818	java/security/cert/CertificateEncodingException
    //   182	220	818	java/security/cert/CertificateEncodingException
    //   223	250	818	java/security/cert/CertificateEncodingException
    //   253	260	818	java/security/cert/CertificateEncodingException
    //   263	271	818	java/security/cert/CertificateEncodingException
    //   274	290	818	java/security/cert/CertificateEncodingException
    //   293	305	818	java/security/cert/CertificateEncodingException
    //   308	315	818	java/security/cert/CertificateEncodingException
    //   318	325	818	java/security/cert/CertificateEncodingException
    //   328	337	818	java/security/cert/CertificateEncodingException
    //   350	362	818	java/security/cert/CertificateEncodingException
  }
  
  /* Error */
  public int a(java.util.ArrayList paramArrayList)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 11
    //   3: iconst_0
    //   4: istore 12
    //   6: iconst_0
    //   7: istore 13
    //   9: iconst_0
    //   10: istore 7
    //   12: iload 12
    //   14: istore 9
    //   16: iload 13
    //   18: istore 10
    //   20: new 73	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   27: ldc_w 393
    //   30: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: astore_3
    //   34: aload_1
    //   35: ifnull +1579 -> 1614
    //   38: iload 12
    //   40: istore 9
    //   42: iload 13
    //   44: istore 10
    //   46: aload_1
    //   47: invokevirtual 399	java/util/ArrayList:size	()I
    //   50: invokestatic 405	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   53: astore_2
    //   54: iload 12
    //   56: istore 9
    //   58: iload 13
    //   60: istore 10
    //   62: ldc 18
    //   64: iconst_1
    //   65: aload_3
    //   66: aload_2
    //   67: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   70: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: iload 12
    //   78: istore 9
    //   80: iload 13
    //   82: istore 10
    //   84: invokestatic 193	com/tencent/common/app/BaseApplicationImpl:a	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   87: ldc_w 352
    //   90: iconst_4
    //   91: invokevirtual 356	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   94: astore 4
    //   96: iload 12
    //   98: istore 9
    //   100: iload 13
    //   102: istore 10
    //   104: aload 4
    //   106: ldc_w 407
    //   109: ldc_w 409
    //   112: invokeinterface 413 3 0
    //   117: astore_2
    //   118: iload 12
    //   120: istore 9
    //   122: iload 13
    //   124: istore 10
    //   126: aload_2
    //   127: invokestatic 347	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   130: ifne +111 -> 241
    //   133: iload 12
    //   135: istore 9
    //   137: iload 13
    //   139: istore 10
    //   141: new 415	org/json/JSONArray
    //   144: dup
    //   145: aload_2
    //   146: invokespecial 416	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   149: astore_2
    //   150: iload 11
    //   152: istore 8
    //   154: aload_1
    //   155: ifnull +412 -> 567
    //   158: iload 11
    //   160: istore 8
    //   162: iload 12
    //   164: istore 9
    //   166: iload 13
    //   168: istore 10
    //   170: aload_1
    //   171: invokevirtual 399	java/util/ArrayList:size	()I
    //   174: ifle +393 -> 567
    //   177: iconst_0
    //   178: istore 11
    //   180: iload 7
    //   182: istore 8
    //   184: iload 7
    //   186: istore 9
    //   188: iload 7
    //   190: istore 10
    //   192: iload 11
    //   194: aload_1
    //   195: invokevirtual 399	java/util/ArrayList:size	()I
    //   198: if_icmpge +369 -> 567
    //   201: iload 7
    //   203: istore 9
    //   205: iload 7
    //   207: istore 10
    //   209: aload_1
    //   210: iload 11
    //   212: invokevirtual 420	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   215: checkcast 297	java/lang/String
    //   218: astore_3
    //   219: iload 7
    //   221: istore 9
    //   223: iload 7
    //   225: istore 10
    //   227: aload_3
    //   228: invokestatic 347	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   231: ifeq +29 -> 260
    //   234: iload 7
    //   236: istore 8
    //   238: goto +1363 -> 1601
    //   241: iload 12
    //   243: istore 9
    //   245: iload 13
    //   247: istore 10
    //   249: new 415	org/json/JSONArray
    //   252: dup
    //   253: invokespecial 421	org/json/JSONArray:<init>	()V
    //   256: astore_2
    //   257: goto -107 -> 150
    //   260: iload 7
    //   262: istore 9
    //   264: iload 7
    //   266: istore 10
    //   268: new 423	org/json/JSONObject
    //   271: dup
    //   272: aload_3
    //   273: invokespecial 424	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   276: astore_3
    //   277: iload 7
    //   279: istore 9
    //   281: iload 7
    //   283: istore 10
    //   285: aload_3
    //   286: ldc_w 426
    //   289: invokevirtual 430	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   292: astore 5
    //   294: iload 7
    //   296: istore 9
    //   298: iload 7
    //   300: istore 10
    //   302: ldc 18
    //   304: iconst_1
    //   305: new 73	java/lang/StringBuilder
    //   308: dup
    //   309: ldc_w 432
    //   312: invokespecial 78	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   315: iload 11
    //   317: invokevirtual 82	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   320: ldc_w 434
    //   323: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: aload_3
    //   327: ldc_w 436
    //   330: invokevirtual 440	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   333: invokevirtual 82	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   336: ldc_w 442
    //   339: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: aload 5
    //   344: invokevirtual 445	org/json/JSONArray:length	()I
    //   347: invokevirtual 82	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   350: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   353: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   356: iconst_0
    //   357: istore 9
    //   359: iload 7
    //   361: istore 8
    //   363: iload 9
    //   365: aload 5
    //   367: invokevirtual 445	org/json/JSONArray:length	()I
    //   370: if_icmpge +1231 -> 1601
    //   373: aload 5
    //   375: iload 9
    //   377: invokevirtual 449	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   380: astore 6
    //   382: aload 6
    //   384: ifnonnull +10 -> 394
    //   387: iload 7
    //   389: istore 8
    //   391: goto +1230 -> 1621
    //   394: ldc 18
    //   396: iconst_1
    //   397: new 73	java/lang/StringBuilder
    //   400: dup
    //   401: ldc_w 451
    //   404: invokespecial 78	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   407: iload 9
    //   409: invokevirtual 82	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   412: ldc_w 453
    //   415: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: aload 6
    //   420: invokevirtual 454	org/json/JSONObject:toString	()Ljava/lang/String;
    //   423: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   429: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   432: aload 6
    //   434: ldc_w 456
    //   437: invokevirtual 459	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   440: ifeq +1194 -> 1634
    //   443: aload 6
    //   445: ldc_w 456
    //   448: invokevirtual 462	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   451: astore_3
    //   452: ldc 22
    //   454: aload_3
    //   455: invokevirtual 463	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   458: ifeq +16 -> 474
    //   461: aload_2
    //   462: aload 6
    //   464: invokevirtual 467	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   467: pop
    //   468: iconst_1
    //   469: istore 8
    //   471: goto +1150 -> 1621
    //   474: iload 7
    //   476: istore 8
    //   478: ldc 26
    //   480: aload_3
    //   481: invokevirtual 463	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   484: ifeq +1137 -> 1621
    //   487: ldc_w 469
    //   490: new 73	java/lang/StringBuilder
    //   493: dup
    //   494: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   497: ldc_w 471
    //   500: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: aload 6
    //   505: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   508: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   511: invokestatic 476	com/tencent/kingkong/Common$Log:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   514: invokestatic 193	com/tencent/common/app/BaseApplicationImpl:a	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   517: aload 6
    //   519: iconst_0
    //   520: invokestatic 481	com/tencent/kingkong/UpdateManager:a	(Landroid/content/Context;Lorg/json/JSONObject;Z)V
    //   523: iload 7
    //   525: istore 8
    //   527: goto +1094 -> 1621
    //   530: astore_1
    //   531: ldc 18
    //   533: iconst_1
    //   534: new 73	java/lang/StringBuilder
    //   537: dup
    //   538: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   541: ldc_w 483
    //   544: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   547: aload_1
    //   548: invokevirtual 484	org/json/JSONException:toString	()Ljava/lang/String;
    //   551: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   554: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   557: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   560: aload_1
    //   561: invokevirtual 485	org/json/JSONException:printStackTrace	()V
    //   564: iload 7
    //   566: ireturn
    //   567: aload_2
    //   568: invokevirtual 445	org/json/JSONArray:length	()I
    //   571: istore 12
    //   573: aload 4
    //   575: ldc_w 487
    //   578: iconst_m1
    //   579: invokeinterface 490 3 0
    //   584: istore 7
    //   586: iload 12
    //   588: iconst_1
    //   589: if_icmple +1089 -> 1678
    //   592: iconst_m1
    //   593: istore 10
    //   595: iconst_0
    //   596: istore 9
    //   598: iload 9
    //   600: aload_2
    //   601: invokevirtual 445	org/json/JSONArray:length	()I
    //   604: if_icmpge +1067 -> 1671
    //   607: aload_2
    //   608: iload 9
    //   610: invokevirtual 449	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   613: astore_1
    //   614: aload_1
    //   615: ldc_w 492
    //   618: invokevirtual 459	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   621: ifeq +1044 -> 1665
    //   624: aload_1
    //   625: ldc_w 492
    //   628: invokevirtual 440	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   631: istore 11
    //   633: goto +1008 -> 1641
    //   636: aload 4
    //   638: ldc_w 492
    //   641: iconst_0
    //   642: invokeinterface 490 3 0
    //   647: istore 9
    //   649: aload 4
    //   651: invokeinterface 362 1 0
    //   656: astore_3
    //   657: iload 12
    //   659: ifle +921 -> 1580
    //   662: iload 11
    //   664: iflt +916 -> 1580
    //   667: iload 11
    //   669: iload 12
    //   671: if_icmpge +909 -> 1580
    //   674: aload_2
    //   675: iload 11
    //   677: invokevirtual 449	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   680: astore 4
    //   682: aload 4
    //   684: ldc_w 492
    //   687: invokevirtual 459	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   690: ifeq +1000 -> 1690
    //   693: aload 4
    //   695: ldc_w 492
    //   698: invokevirtual 440	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   701: istore 7
    //   703: iload 7
    //   705: istore 8
    //   707: iload 8
    //   709: iload 9
    //   711: if_icmpne +985 -> 1696
    //   714: iconst_0
    //   715: istore 7
    //   717: iload 7
    //   719: istore 9
    //   721: iload 7
    //   723: istore 10
    //   725: aload_3
    //   726: ldc_w 492
    //   729: iload 8
    //   731: invokeinterface 496 3 0
    //   736: pop
    //   737: iload 7
    //   739: istore 9
    //   741: iload 7
    //   743: istore 10
    //   745: aload 4
    //   747: ldc_w 498
    //   750: invokevirtual 459	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   753: ifeq +949 -> 1702
    //   756: iload 7
    //   758: istore 9
    //   760: iload 7
    //   762: istore 10
    //   764: aload 4
    //   766: ldc_w 498
    //   769: invokevirtual 462	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   772: astore_1
    //   773: iload 7
    //   775: istore 9
    //   777: iload 7
    //   779: istore 10
    //   781: aload_3
    //   782: ldc_w 498
    //   785: aload_1
    //   786: invokeinterface 502 3 0
    //   791: pop
    //   792: iload 7
    //   794: istore 9
    //   796: iload 7
    //   798: istore 10
    //   800: aload 4
    //   802: ldc_w 456
    //   805: invokevirtual 459	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   808: ifeq +901 -> 1709
    //   811: iload 7
    //   813: istore 9
    //   815: iload 7
    //   817: istore 10
    //   819: aload 4
    //   821: ldc_w 456
    //   824: invokevirtual 462	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   827: astore_1
    //   828: iload 7
    //   830: istore 9
    //   832: iload 7
    //   834: istore 10
    //   836: aload_3
    //   837: ldc_w 456
    //   840: aload_1
    //   841: invokeinterface 502 3 0
    //   846: pop
    //   847: iload 7
    //   849: istore 9
    //   851: iload 7
    //   853: istore 10
    //   855: aload 4
    //   857: ldc_w 504
    //   860: invokevirtual 459	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   863: ifeq +853 -> 1716
    //   866: iload 7
    //   868: istore 9
    //   870: iload 7
    //   872: istore 10
    //   874: aload 4
    //   876: ldc_w 504
    //   879: invokevirtual 507	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   882: istore 16
    //   884: iload 7
    //   886: istore 9
    //   888: iload 7
    //   890: istore 10
    //   892: aload_3
    //   893: ldc_w 504
    //   896: iload 16
    //   898: invokeinterface 370 3 0
    //   903: pop
    //   904: iload 7
    //   906: istore 9
    //   908: iload 7
    //   910: istore 10
    //   912: aload 4
    //   914: ldc_w 509
    //   917: invokevirtual 459	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   920: ifeq +802 -> 1722
    //   923: iload 7
    //   925: istore 9
    //   927: iload 7
    //   929: istore 10
    //   931: aload 4
    //   933: ldc_w 509
    //   936: invokevirtual 507	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   939: istore 16
    //   941: iload 7
    //   943: istore 9
    //   945: iload 7
    //   947: istore 10
    //   949: aload_3
    //   950: ldc_w 511
    //   953: iload 16
    //   955: invokeinterface 370 3 0
    //   960: pop
    //   961: iload 7
    //   963: istore 9
    //   965: iload 7
    //   967: istore 10
    //   969: aload 4
    //   971: ldc_w 513
    //   974: invokevirtual 459	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   977: ifeq +751 -> 1728
    //   980: iload 7
    //   982: istore 9
    //   984: iload 7
    //   986: istore 10
    //   988: aload 4
    //   990: ldc_w 513
    //   993: invokevirtual 462	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   996: astore_1
    //   997: iload 7
    //   999: istore 9
    //   1001: iload 7
    //   1003: istore 10
    //   1005: aload_3
    //   1006: ldc_w 513
    //   1009: aload_1
    //   1010: invokeinterface 502 3 0
    //   1015: pop
    //   1016: iload 7
    //   1018: istore 9
    //   1020: iload 7
    //   1022: istore 10
    //   1024: aload 4
    //   1026: ldc_w 515
    //   1029: invokevirtual 459	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1032: ifeq +703 -> 1735
    //   1035: iload 7
    //   1037: istore 9
    //   1039: iload 7
    //   1041: istore 10
    //   1043: aload 4
    //   1045: ldc_w 515
    //   1048: invokevirtual 462	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1051: astore_1
    //   1052: iload 7
    //   1054: istore 9
    //   1056: iload 7
    //   1058: istore 10
    //   1060: aload_3
    //   1061: ldc_w 517
    //   1064: aload_1
    //   1065: invokeinterface 502 3 0
    //   1070: pop
    //   1071: iload 7
    //   1073: istore 9
    //   1075: iload 7
    //   1077: istore 10
    //   1079: aload 4
    //   1081: ldc_w 519
    //   1084: invokevirtual 459	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1087: ifeq +655 -> 1742
    //   1090: iload 7
    //   1092: istore 9
    //   1094: iload 7
    //   1096: istore 10
    //   1098: aload 4
    //   1100: ldc_w 519
    //   1103: invokevirtual 462	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1106: astore_1
    //   1107: iload 7
    //   1109: istore 9
    //   1111: iload 7
    //   1113: istore 10
    //   1115: aload_3
    //   1116: ldc_w 521
    //   1119: aload_1
    //   1120: invokeinterface 502 3 0
    //   1125: pop
    //   1126: iload 7
    //   1128: istore 9
    //   1130: iload 7
    //   1132: istore 10
    //   1134: aload 4
    //   1136: ldc_w 523
    //   1139: invokevirtual 459	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1142: ifeq +607 -> 1749
    //   1145: iload 7
    //   1147: istore 9
    //   1149: iload 7
    //   1151: istore 10
    //   1153: aload 4
    //   1155: ldc_w 523
    //   1158: invokevirtual 462	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1161: astore_1
    //   1162: iload 7
    //   1164: istore 9
    //   1166: iload 7
    //   1168: istore 10
    //   1170: aload_3
    //   1171: ldc_w 523
    //   1174: aload_1
    //   1175: invokeinterface 502 3 0
    //   1180: pop
    //   1181: iload 7
    //   1183: istore 9
    //   1185: iload 7
    //   1187: istore 10
    //   1189: aload 4
    //   1191: ldc_w 525
    //   1194: invokevirtual 459	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1197: ifeq +559 -> 1756
    //   1200: iload 7
    //   1202: istore 9
    //   1204: iload 7
    //   1206: istore 10
    //   1208: aload 4
    //   1210: ldc_w 525
    //   1213: invokevirtual 462	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1216: astore_1
    //   1217: iload 7
    //   1219: istore 9
    //   1221: iload 7
    //   1223: istore 10
    //   1225: aload_3
    //   1226: ldc_w 525
    //   1229: aload_1
    //   1230: invokeinterface 502 3 0
    //   1235: pop
    //   1236: iload 7
    //   1238: istore 9
    //   1240: iload 7
    //   1242: istore 10
    //   1244: aload 4
    //   1246: ldc_w 527
    //   1249: invokevirtual 459	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1252: ifeq +511 -> 1763
    //   1255: iload 7
    //   1257: istore 9
    //   1259: iload 7
    //   1261: istore 10
    //   1263: aload 4
    //   1265: ldc_w 527
    //   1268: invokevirtual 462	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1271: astore_1
    //   1272: iload 7
    //   1274: istore 9
    //   1276: iload 7
    //   1278: istore 10
    //   1280: aload_3
    //   1281: ldc_w 527
    //   1284: aload_1
    //   1285: invokeinterface 502 3 0
    //   1290: pop
    //   1291: iload 7
    //   1293: istore 9
    //   1295: iload 7
    //   1297: istore 10
    //   1299: aload 4
    //   1301: ldc_w 529
    //   1304: invokevirtual 459	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1307: ifeq +191 -> 1498
    //   1310: iload 7
    //   1312: istore 9
    //   1314: iload 7
    //   1316: istore 10
    //   1318: aload 4
    //   1320: ldc_w 529
    //   1323: invokevirtual 462	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1326: astore_1
    //   1327: iload 7
    //   1329: istore 9
    //   1331: iload 7
    //   1333: istore 10
    //   1335: aload_3
    //   1336: ldc_w 529
    //   1339: aload_1
    //   1340: invokeinterface 502 3 0
    //   1345: pop
    //   1346: iload 7
    //   1348: istore 9
    //   1350: iload 7
    //   1352: istore 10
    //   1354: aload 4
    //   1356: ldc_w 530
    //   1359: invokevirtual 459	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1362: ifeq +143 -> 1505
    //   1365: iload 7
    //   1367: istore 9
    //   1369: iload 7
    //   1371: istore 10
    //   1373: aload 4
    //   1375: ldc_w 530
    //   1378: invokevirtual 534	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   1381: lstore 14
    //   1383: iload 7
    //   1385: istore 9
    //   1387: iload 7
    //   1389: istore 10
    //   1391: aload_3
    //   1392: ldc_w 530
    //   1395: lload 14
    //   1397: invokeinterface 538 4 0
    //   1402: pop
    //   1403: iload 7
    //   1405: istore 9
    //   1407: iload 7
    //   1409: istore 10
    //   1411: aload_3
    //   1412: ldc_w 487
    //   1415: iload 11
    //   1417: invokeinterface 496 3 0
    //   1422: pop
    //   1423: iload 7
    //   1425: istore 9
    //   1427: iload 7
    //   1429: istore 10
    //   1431: aload_3
    //   1432: ldc_w 540
    //   1435: iload 12
    //   1437: invokeinterface 496 3 0
    //   1442: pop
    //   1443: iload 7
    //   1445: istore 9
    //   1447: iload 7
    //   1449: istore 10
    //   1451: aload_3
    //   1452: ldc_w 407
    //   1455: aload_2
    //   1456: invokevirtual 541	org/json/JSONArray:toString	()Ljava/lang/String;
    //   1459: invokeinterface 502 3 0
    //   1464: pop
    //   1465: iload 7
    //   1467: istore 9
    //   1469: iload 7
    //   1471: istore 10
    //   1473: aload_3
    //   1474: invokeinterface 373 1 0
    //   1479: pop
    //   1480: iload 7
    //   1482: istore 9
    //   1484: iload 7
    //   1486: istore 10
    //   1488: aload_0
    //   1489: iconst_1
    //   1490: invokevirtual 544	com/tencent/mobileqq/hotpatch/HotPatchManager:a	(Z)V
    //   1493: iload 7
    //   1495: iconst_2
    //   1496: ior
    //   1497: ireturn
    //   1498: ldc_w 409
    //   1501: astore_1
    //   1502: goto -175 -> 1327
    //   1505: lconst_0
    //   1506: lstore 14
    //   1508: goto -125 -> 1383
    //   1511: astore_1
    //   1512: iload 9
    //   1514: istore 7
    //   1516: ldc 18
    //   1518: iconst_1
    //   1519: new 73	java/lang/StringBuilder
    //   1522: dup
    //   1523: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   1526: ldc_w 546
    //   1529: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1532: aload_1
    //   1533: invokevirtual 233	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1536: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1539: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1542: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1545: aload_1
    //   1546: invokevirtual 234	java/lang/Throwable:printStackTrace	()V
    //   1549: iload 7
    //   1551: ireturn
    //   1552: astore_1
    //   1553: goto -37 -> 1516
    //   1556: astore_1
    //   1557: iload 8
    //   1559: istore 7
    //   1561: goto -45 -> 1516
    //   1564: astore_1
    //   1565: iload 10
    //   1567: istore 7
    //   1569: goto -1038 -> 531
    //   1572: astore_1
    //   1573: iload 8
    //   1575: istore 7
    //   1577: goto -1046 -> 531
    //   1580: iload 8
    //   1582: istore 7
    //   1584: goto -161 -> 1423
    //   1587: iload 7
    //   1589: istore 11
    //   1591: goto -955 -> 636
    //   1594: iload 10
    //   1596: istore 11
    //   1598: goto +54 -> 1652
    //   1601: iload 11
    //   1603: iconst_1
    //   1604: iadd
    //   1605: istore 11
    //   1607: iload 8
    //   1609: istore 7
    //   1611: goto -1431 -> 180
    //   1614: ldc_w 548
    //   1617: astore_2
    //   1618: goto -1564 -> 54
    //   1621: iload 9
    //   1623: iconst_1
    //   1624: iadd
    //   1625: istore 9
    //   1627: iload 8
    //   1629: istore 7
    //   1631: goto -1272 -> 359
    //   1634: ldc_w 409
    //   1637: astore_3
    //   1638: goto -1186 -> 452
    //   1641: iload 11
    //   1643: iload 10
    //   1645: if_icmple -51 -> 1594
    //   1648: iload 9
    //   1650: istore 7
    //   1652: iload 9
    //   1654: iconst_1
    //   1655: iadd
    //   1656: istore 9
    //   1658: iload 11
    //   1660: istore 10
    //   1662: goto -1064 -> 598
    //   1665: iconst_m1
    //   1666: istore 11
    //   1668: goto -27 -> 1641
    //   1671: iload 7
    //   1673: istore 11
    //   1675: goto -1039 -> 636
    //   1678: iload 12
    //   1680: iconst_1
    //   1681: if_icmpne -94 -> 1587
    //   1684: iconst_0
    //   1685: istore 11
    //   1687: goto -1051 -> 636
    //   1690: iconst_0
    //   1691: istore 8
    //   1693: goto -986 -> 707
    //   1696: iconst_1
    //   1697: istore 7
    //   1699: goto -982 -> 717
    //   1702: ldc_w 409
    //   1705: astore_1
    //   1706: goto -933 -> 773
    //   1709: ldc_w 409
    //   1712: astore_1
    //   1713: goto -885 -> 828
    //   1716: iconst_0
    //   1717: istore 16
    //   1719: goto -835 -> 884
    //   1722: iconst_0
    //   1723: istore 16
    //   1725: goto -784 -> 941
    //   1728: ldc_w 409
    //   1731: astore_1
    //   1732: goto -735 -> 997
    //   1735: ldc_w 409
    //   1738: astore_1
    //   1739: goto -687 -> 1052
    //   1742: ldc_w 409
    //   1745: astore_1
    //   1746: goto -639 -> 1107
    //   1749: ldc_w 409
    //   1752: astore_1
    //   1753: goto -591 -> 1162
    //   1756: ldc_w 409
    //   1759: astore_1
    //   1760: goto -543 -> 1217
    //   1763: ldc_w 409
    //   1766: astore_1
    //   1767: goto -495 -> 1272
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1770	0	this	HotPatchManager
    //   0	1770	1	paramArrayList	java.util.ArrayList
    //   53	1565	2	localObject1	Object
    //   33	1605	3	localObject2	Object
    //   94	1280	4	localObject3	Object
    //   292	82	5	localJSONArray	org.json.JSONArray
    //   380	138	6	localJSONObject	org.json.JSONObject
    //   10	1688	7	i	int
    //   152	1540	8	j	int
    //   14	1643	9	k	int
    //   18	1643	10	m	int
    //   1	1685	11	n	int
    //   4	1678	12	i1	int
    //   7	239	13	i2	int
    //   1381	126	14	l	long
    //   882	842	16	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   363	382	530	org/json/JSONException
    //   394	452	530	org/json/JSONException
    //   452	468	530	org/json/JSONException
    //   478	523	530	org/json/JSONException
    //   20	34	1511	java/lang/Throwable
    //   46	54	1511	java/lang/Throwable
    //   62	76	1511	java/lang/Throwable
    //   84	96	1511	java/lang/Throwable
    //   104	118	1511	java/lang/Throwable
    //   126	133	1511	java/lang/Throwable
    //   141	150	1511	java/lang/Throwable
    //   170	177	1511	java/lang/Throwable
    //   192	201	1511	java/lang/Throwable
    //   209	219	1511	java/lang/Throwable
    //   227	234	1511	java/lang/Throwable
    //   249	257	1511	java/lang/Throwable
    //   268	277	1511	java/lang/Throwable
    //   285	294	1511	java/lang/Throwable
    //   302	356	1511	java/lang/Throwable
    //   725	737	1511	java/lang/Throwable
    //   745	756	1511	java/lang/Throwable
    //   764	773	1511	java/lang/Throwable
    //   781	792	1511	java/lang/Throwable
    //   800	811	1511	java/lang/Throwable
    //   819	828	1511	java/lang/Throwable
    //   836	847	1511	java/lang/Throwable
    //   855	866	1511	java/lang/Throwable
    //   874	884	1511	java/lang/Throwable
    //   892	904	1511	java/lang/Throwable
    //   912	923	1511	java/lang/Throwable
    //   931	941	1511	java/lang/Throwable
    //   949	961	1511	java/lang/Throwable
    //   969	980	1511	java/lang/Throwable
    //   988	997	1511	java/lang/Throwable
    //   1005	1016	1511	java/lang/Throwable
    //   1024	1035	1511	java/lang/Throwable
    //   1043	1052	1511	java/lang/Throwable
    //   1060	1071	1511	java/lang/Throwable
    //   1079	1090	1511	java/lang/Throwable
    //   1098	1107	1511	java/lang/Throwable
    //   1115	1126	1511	java/lang/Throwable
    //   1134	1145	1511	java/lang/Throwable
    //   1153	1162	1511	java/lang/Throwable
    //   1170	1181	1511	java/lang/Throwable
    //   1189	1200	1511	java/lang/Throwable
    //   1208	1217	1511	java/lang/Throwable
    //   1225	1236	1511	java/lang/Throwable
    //   1244	1255	1511	java/lang/Throwable
    //   1263	1272	1511	java/lang/Throwable
    //   1280	1291	1511	java/lang/Throwable
    //   1299	1310	1511	java/lang/Throwable
    //   1318	1327	1511	java/lang/Throwable
    //   1335	1346	1511	java/lang/Throwable
    //   1354	1365	1511	java/lang/Throwable
    //   1373	1383	1511	java/lang/Throwable
    //   1391	1403	1511	java/lang/Throwable
    //   1411	1423	1511	java/lang/Throwable
    //   1431	1443	1511	java/lang/Throwable
    //   1451	1465	1511	java/lang/Throwable
    //   1473	1480	1511	java/lang/Throwable
    //   1488	1493	1511	java/lang/Throwable
    //   363	382	1552	java/lang/Throwable
    //   394	452	1552	java/lang/Throwable
    //   452	468	1552	java/lang/Throwable
    //   478	523	1552	java/lang/Throwable
    //   567	586	1556	java/lang/Throwable
    //   598	633	1556	java/lang/Throwable
    //   636	657	1556	java/lang/Throwable
    //   674	703	1556	java/lang/Throwable
    //   20	34	1564	org/json/JSONException
    //   46	54	1564	org/json/JSONException
    //   62	76	1564	org/json/JSONException
    //   84	96	1564	org/json/JSONException
    //   104	118	1564	org/json/JSONException
    //   126	133	1564	org/json/JSONException
    //   141	150	1564	org/json/JSONException
    //   170	177	1564	org/json/JSONException
    //   192	201	1564	org/json/JSONException
    //   209	219	1564	org/json/JSONException
    //   227	234	1564	org/json/JSONException
    //   249	257	1564	org/json/JSONException
    //   268	277	1564	org/json/JSONException
    //   285	294	1564	org/json/JSONException
    //   302	356	1564	org/json/JSONException
    //   725	737	1564	org/json/JSONException
    //   745	756	1564	org/json/JSONException
    //   764	773	1564	org/json/JSONException
    //   781	792	1564	org/json/JSONException
    //   800	811	1564	org/json/JSONException
    //   819	828	1564	org/json/JSONException
    //   836	847	1564	org/json/JSONException
    //   855	866	1564	org/json/JSONException
    //   874	884	1564	org/json/JSONException
    //   892	904	1564	org/json/JSONException
    //   912	923	1564	org/json/JSONException
    //   931	941	1564	org/json/JSONException
    //   949	961	1564	org/json/JSONException
    //   969	980	1564	org/json/JSONException
    //   988	997	1564	org/json/JSONException
    //   1005	1016	1564	org/json/JSONException
    //   1024	1035	1564	org/json/JSONException
    //   1043	1052	1564	org/json/JSONException
    //   1060	1071	1564	org/json/JSONException
    //   1079	1090	1564	org/json/JSONException
    //   1098	1107	1564	org/json/JSONException
    //   1115	1126	1564	org/json/JSONException
    //   1134	1145	1564	org/json/JSONException
    //   1153	1162	1564	org/json/JSONException
    //   1170	1181	1564	org/json/JSONException
    //   1189	1200	1564	org/json/JSONException
    //   1208	1217	1564	org/json/JSONException
    //   1225	1236	1564	org/json/JSONException
    //   1244	1255	1564	org/json/JSONException
    //   1263	1272	1564	org/json/JSONException
    //   1280	1291	1564	org/json/JSONException
    //   1299	1310	1564	org/json/JSONException
    //   1318	1327	1564	org/json/JSONException
    //   1335	1346	1564	org/json/JSONException
    //   1354	1365	1564	org/json/JSONException
    //   1373	1383	1564	org/json/JSONException
    //   1391	1403	1564	org/json/JSONException
    //   1411	1423	1564	org/json/JSONException
    //   1431	1443	1564	org/json/JSONException
    //   1451	1465	1564	org/json/JSONException
    //   1473	1480	1564	org/json/JSONException
    //   1488	1493	1564	org/json/JSONException
    //   567	586	1572	org/json/JSONException
    //   598	633	1572	org/json/JSONException
    //   636	657	1572	org/json/JSONException
    //   674	703	1572	org/json/JSONException
  }
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1052689, (int)paramLong1, (int)paramLong2, paramNetReq).sendToTarget();
  }
  
  public void a(NetReq paramNetReq, NetResp paramNetResp)
  {
    if ((paramNetReq == null) || (paramNetResp == null)) {}
    while (!(paramNetReq instanceof HttpNetReq)) {
      return;
    }
    paramNetReq = (HttpNetReq)paramNetReq;
    paramNetReq.jdField_a_of_type_Long += paramNetResp.c;
    paramNetResp.c = 0L;
    paramNetResp = "bytes=" + paramNetReq.jdField_a_of_type_Long + "-";
    paramNetReq.jdField_a_of_type_JavaUtilHashMap.put("Range", paramNetResp);
  }
  
  public void a(NetResp paramNetResp)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1052688, paramNetResp).sendToTarget();
    }
  }
  
  public void a(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    QLog.d("HotPatchManager", 1, "downloadPatch start tryTimes=" + paramInt + ", patchName=" + paramString1 + ", patchUrl=" + paramString2 + ", size=" + paramLong);
    if ((paramInt < 3) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.contains(paramString1))) {
      return;
    }
    INetEngine localINetEngine = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0);
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this;
    localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix = this;
    localHttpNetReq.jdField_a_of_type_JavaLangString = paramString2;
    localHttpNetReq.c = 0;
    localHttpNetReq.jdField_b_of_type_JavaLangString = ("/data/data/com.tencent.mobileqq/files/hotpatch/" + paramString1);
    localHttpNetReq.a(new svn(this, paramInt + 1, SystemClock.elapsedRealtime(), paramLong, paramString1, paramString2));
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1, localHttpNetReq);
    localINetEngine.a(localHttpNetReq);
  }
  
  public void a(boolean paramBoolean)
  {
    QLog.d("HotPatchManager", 1, "checkNeedDownloadPatch cfgChanged=" + paramBoolean);
    try
    {
      SharedPreferences localSharedPreferences = BaseApplicationImpl.a().getSharedPreferences("sp_dex_patch", 4);
      if (!localSharedPreferences.getBoolean("enable", false))
      {
        QLog.d("HotPatchManager", 1, "checkNeedDownloadPatch enable is false");
        return;
      }
      str2 = localSharedPreferences.getString("appVersion", "");
      if ((TextUtils.isEmpty(str2)) || (!str2.equals(ApkUtils.a(BaseApplicationImpl.getContext()) + "." + ApkUtils.a(BaseApplicationImpl.getContext()))))
      {
        QLog.d("HotPatchManager", 1, "checkNeedDownloadPatch app version not match");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.d("HotPatchManager", 1, "checkNeedDownloadPatch throwable=" + localThrowable.toString());
      localThrowable.printStackTrace();
      return;
    }
    if (!"229354".equals(localThrowable.getString("revision", "")))
    {
      QLog.d("HotPatchManager", 1, "checkNeedDownloadPatch revision not match");
      return;
    }
    String str2 = localThrowable.getString("sysVersion", "");
    if ((!TextUtils.isEmpty(str2)) && (!str2.contains(String.valueOf(Build.VERSION.SDK_INT))))
    {
      QLog.d("HotPatchManager", 1, "checkNeedDownloadPatch system version not match");
      return;
    }
    str2 = localThrowable.getString("deviceInfo", "");
    if ((!TextUtils.isEmpty(str2)) && ((!str2.contains(Build.BRAND)) || (!str2.contains(Build.MODEL))))
    {
      QLog.d("HotPatchManager", 1, "checkNeedDownloadPatch device not match");
      return;
    }
    str2 = localThrowable.getString("name", "");
    if (TextUtils.isEmpty(str2))
    {
      QLog.d("HotPatchManager", 1, "checkNeedDownloadPatch patch name is empty");
      return;
    }
    String str3 = localThrowable.getString("url", "");
    if (TextUtils.isEmpty(str3))
    {
      QLog.d("HotPatchManager", 1, "checkNeedDownloadPatch patch url is empty");
      return;
    }
    long l = localThrowable.getLong("size", 0L);
    if (l <= 0L)
    {
      QLog.d("HotPatchManager", 1, "checkNeedDownloadPatch patch size is 0");
      return;
    }
    String str1 = "/data/data/com.tencent.mobileqq/files/hotpatch/" + str2;
    File localFile = new File(str1);
    if ((!localFile.exists()) || (localFile.length() != l))
    {
      if (localFile.exists()) {
        localFile.delete();
      }
      QLog.d("HotPatchManager", 1, "checkNeedDownloadPatch need to download patch");
      a(str2, str3, l, 0);
      return;
    }
    int i = a(str2, str1);
    QLog.d("HotPatchManager", 1, "checkNeedDownloadPatch verify patch result=" + i);
    if (i == 1) {
      localFile.delete();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      b((NetResp)paramMessage.obj);
      continue;
      a((NetReq)paramMessage.obj, paramMessage.arg1, paramMessage.arg2);
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    this.jdField_a_of_type_AndroidOsHandler = null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\hotpatch\HotPatchManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */