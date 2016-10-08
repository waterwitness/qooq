package com.tencent.mobileqq.ptt;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.soload.SoLoadCore;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class PttSoLoader
{
  public static final String a = "PttSoLoader";
  public static boolean a;
  
  public PttSoLoader()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String a()
  {
    String str = SoLoadCore.getAppWorkPath(BaseApplicationImpl.a);
    if (str == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PttSoLoader", 2, "getFilesDir is null");
      }
      return "";
    }
    return str + "/UnCompressPttSoTemp/";
  }
  
  /* Error */
  public static boolean a(android.content.Context paramContext, String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: invokestatic 66	com/tencent/av/core/VcSystemInfo:f	()I
    //   6: istore 4
    //   8: invokestatic 69	com/tencent/mobileqq/ptt/PttSoLoader:b	()Ljava/lang/String;
    //   11: astore_3
    //   12: ldc 45
    //   14: astore_2
    //   15: iload 4
    //   17: iconst_2
    //   18: if_icmple +32 -> 50
    //   21: new 47	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   28: aload_3
    //   29: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: ldc 71
    //   34: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: aload_1
    //   38: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: ldc 73
    //   43: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: astore_2
    //   50: ldc 8
    //   52: monitorenter
    //   53: new 75	java/io/File
    //   56: dup
    //   57: aload_2
    //   58: invokespecial 78	java/io/File:<init>	(Ljava/lang/String;)V
    //   61: invokevirtual 81	java/io/File:exists	()Z
    //   64: istore 6
    //   66: invokestatic 37	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   69: ifeq +28 -> 97
    //   72: ldc 8
    //   74: iconst_2
    //   75: new 47	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   82: ldc 83
    //   84: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload_2
    //   88: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: invokestatic 43	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   97: iload 6
    //   99: ifeq +111 -> 210
    //   102: aload_2
    //   103: invokestatic 88	java/lang/System:load	(Ljava/lang/String;)V
    //   106: iconst_1
    //   107: putstatic 90	com/tencent/mobileqq/ptt/PttSoLoader:a	Z
    //   110: ldc 8
    //   112: monitorexit
    //   113: getstatic 90	com/tencent/mobileqq/ptt/PttSoLoader:a	Z
    //   116: aload_1
    //   117: invokestatic 95	com/tencent/mobileqq/transfile/PttInfoCollector:a	(ZLjava/lang/String;)V
    //   120: invokestatic 37	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   123: ifeq +39 -> 162
    //   126: ldc 8
    //   128: iconst_2
    //   129: new 47	java/lang/StringBuilder
    //   132: dup
    //   133: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   136: ldc 97
    //   138: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: aload_2
    //   142: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: ldc 99
    //   147: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: getstatic 90	com/tencent/mobileqq/ptt/PttSoLoader:a	Z
    //   153: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   156: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokestatic 43	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   162: iload 5
    //   164: ireturn
    //   165: astore_3
    //   166: invokestatic 37	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   169: ifeq +31 -> 200
    //   172: ldc 8
    //   174: iconst_2
    //   175: new 47	java/lang/StringBuilder
    //   178: dup
    //   179: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   182: ldc 104
    //   184: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: aload_3
    //   188: invokevirtual 107	java/lang/UnsatisfiedLinkError:getMessage	()Ljava/lang/String;
    //   191: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: invokestatic 43	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   200: aload_0
    //   201: aload_1
    //   202: invokestatic 112	com/tencent/commonsdk/soload/SoLoadUtilNew:loadSoByName	(Landroid/content/Context;Ljava/lang/String;)Z
    //   205: istore 5
    //   207: goto -97 -> 110
    //   210: invokestatic 37	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   213: ifeq +11 -> 224
    //   216: ldc 8
    //   218: iconst_2
    //   219: ldc 114
    //   221: invokestatic 43	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   224: aload_0
    //   225: aload_1
    //   226: invokestatic 112	com/tencent/commonsdk/soload/SoLoadUtilNew:loadSoByName	(Landroid/content/Context;Ljava/lang/String;)Z
    //   229: istore 5
    //   231: goto -121 -> 110
    //   234: astore_0
    //   235: ldc 8
    //   237: monitorexit
    //   238: aload_0
    //   239: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	240	0	paramContext	android.content.Context
    //   0	240	1	paramString	String
    //   14	128	2	str1	String
    //   11	18	3	str2	String
    //   165	23	3	localUnsatisfiedLinkError	UnsatisfiedLinkError
    //   6	13	4	i	int
    //   1	229	5	bool1	boolean
    //   64	34	6	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   102	110	165	java/lang/UnsatisfiedLinkError
    //   53	97	234	finally
    //   102	110	234	finally
    //   110	113	234	finally
    //   166	200	234	finally
    //   200	207	234	finally
    //   210	224	234	finally
    //   224	231	234	finally
    //   235	238	234	finally
  }
  
  public static String b()
  {
    String str = SoLoadCore.getAppWorkPath(BaseApplicationImpl.a);
    if (str == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PttSoLoader", 2, "getFilesDir is null");
      }
      return "";
    }
    return str + "/txPttlib/";
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\ptt\PttSoLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */