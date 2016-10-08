package com.tencent.mqp.app.sec;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class MQPSecUtil
{
  public static int a = 0;
  private static MQPSecUtil jdField_a_of_type_ComTencentMqpAppSecMQPSecUtil;
  private static final String jdField_a_of_type_JavaLangString = "MQPSecUtil";
  private static final String b = "mqpintchk";
  
  /* Error */
  static
  {
    // Byte code:
    //   0: getstatic 26	com/tencent/mobileqq/hotpatch/NotVerifyClass:DO_VERIFY_CLASS	Z
    //   3: istore 4
    //   5: iconst_1
    //   6: putstatic 28	com/tencent/mqp/app/sec/MQPSecUtil:jdField_a_of_type_Int	I
    //   9: invokestatic 34	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   12: astore_2
    //   13: new 36	java/io/File
    //   16: dup
    //   17: new 38	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   24: aload_2
    //   25: invokevirtual 47	android/content/Context:getFilesDir	()Ljava/io/File;
    //   28: invokevirtual 51	java/io/File:getParent	()Ljava/lang/String;
    //   31: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: ldc 57
    //   36: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: ldc 14
    //   41: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: ldc 59
    //   46: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokespecial 65	java/io/File:<init>	(Ljava/lang/String;)V
    //   55: astore_1
    //   56: aload_1
    //   57: invokevirtual 69	java/io/File:exists	()Z
    //   60: ifne +31 -> 91
    //   63: ldc 71
    //   65: astore_0
    //   66: getstatic 76	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   69: ldc 78
    //   71: invokevirtual 84	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   74: ifeq +95 -> 169
    //   77: ldc 78
    //   79: astore_0
    //   80: aload_0
    //   81: ldc 86
    //   83: if_acmpeq +8 -> 91
    //   86: aload_2
    //   87: aload_0
    //   88: invokestatic 89	com/tencent/mqp/app/sec/MQPSecUtil:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   91: aload_1
    //   92: astore_0
    //   93: aload_1
    //   94: invokevirtual 69	java/io/File:exists	()Z
    //   97: ifne +46 -> 143
    //   100: new 36	java/io/File
    //   103: dup
    //   104: new 38	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   111: aload_2
    //   112: invokevirtual 47	android/content/Context:getFilesDir	()Ljava/io/File;
    //   115: invokevirtual 51	java/io/File:getParent	()Ljava/lang/String;
    //   118: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: ldc 91
    //   123: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: ldc 14
    //   128: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: ldc 59
    //   133: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: invokespecial 65	java/io/File:<init>	(Ljava/lang/String;)V
    //   142: astore_0
    //   143: aload_0
    //   144: invokevirtual 69	java/io/File:exists	()Z
    //   147: ifeq +82 -> 229
    //   150: aload_0
    //   151: invokevirtual 94	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   154: invokestatic 99	java/lang/System:load	(Ljava/lang/String;)V
    //   157: iconst_1
    //   158: istore_3
    //   159: iload_3
    //   160: ifne +8 -> 168
    //   163: ldc 14
    //   165: invokestatic 102	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   168: return
    //   169: getstatic 76	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   172: ldc 104
    //   174: invokevirtual 84	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   177: ifeq -97 -> 80
    //   180: ldc 86
    //   182: astore_0
    //   183: goto -103 -> 80
    //   186: astore_0
    //   187: aload_0
    //   188: invokevirtual 107	java/lang/Throwable:printStackTrace	()V
    //   191: goto -100 -> 91
    //   194: astore_1
    //   195: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   198: ifeq +31 -> 229
    //   201: ldc 11
    //   203: iconst_2
    //   204: new 38	java/lang/StringBuilder
    //   207: dup
    //   208: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   211: ldc 114
    //   213: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: aload_0
    //   217: invokevirtual 94	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   220: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: invokestatic 118	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   229: iconst_0
    //   230: istore_3
    //   231: goto -72 -> 159
    //   234: astore_0
    //   235: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   238: ifeq -70 -> 168
    //   241: ldc 11
    //   243: iconst_2
    //   244: ldc 120
    //   246: invokestatic 118	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   249: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   65	118	0	localObject	Object
    //   186	31	0	localThrowable	Throwable
    //   234	1	0	localUnsatisfiedLinkError1	UnsatisfiedLinkError
    //   55	39	1	localFile	java.io.File
    //   194	1	1	localUnsatisfiedLinkError2	UnsatisfiedLinkError
    //   12	100	2	localBaseApplication	com.tencent.qphone.base.util.BaseApplication
    //   158	73	3	i	int
    //   3	1	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   66	77	186	java/lang/Throwable
    //   86	91	186	java/lang/Throwable
    //   169	180	186	java/lang/Throwable
    //   150	157	194	java/lang/UnsatisfiedLinkError
    //   163	168	234	java/lang/UnsatisfiedLinkError
  }
  
  public static MQPSecUtil a()
  {
    if (jdField_a_of_type_ComTencentMqpAppSecMQPSecUtil == null) {
      jdField_a_of_type_ComTencentMqpAppSecMQPSecUtil = new MQPSecUtil();
    }
    return jdField_a_of_type_ComTencentMqpAppSecMQPSecUtil;
  }
  
  /* Error */
  private static void a(android.content.Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: new 38	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   11: ldc -124
    //   13: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: aload_1
    //   17: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: ldc -122
    //   22: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: ldc -120
    //   27: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: astore 4
    //   35: new 38	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   42: aload_0
    //   43: invokevirtual 47	android/content/Context:getFilesDir	()Ljava/io/File;
    //   46: invokevirtual 51	java/io/File:getParent	()Ljava/lang/String;
    //   49: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: ldc -118
    //   54: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: astore 5
    //   62: new 38	java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   69: aload 5
    //   71: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: ldc -122
    //   76: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: ldc -120
    //   81: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: astore_1
    //   88: new 36	java/io/File
    //   91: dup
    //   92: aload 5
    //   94: invokespecial 65	java/io/File:<init>	(Ljava/lang/String;)V
    //   97: invokevirtual 141	java/io/File:mkdirs	()Z
    //   100: pop
    //   101: aload_0
    //   102: invokevirtual 145	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   105: aload 4
    //   107: invokevirtual 151	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   110: astore_0
    //   111: new 153	java/io/FileOutputStream
    //   114: dup
    //   115: aload_1
    //   116: invokespecial 154	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   119: astore_2
    //   120: sipush 4096
    //   123: newarray <illegal type>
    //   125: astore_1
    //   126: aload_0
    //   127: aload_1
    //   128: invokevirtual 160	java/io/InputStream:read	([B)I
    //   131: istore 6
    //   133: iload 6
    //   135: ifle +36 -> 171
    //   138: aload_2
    //   139: aload_1
    //   140: iconst_0
    //   141: iload 6
    //   143: invokevirtual 166	java/io/OutputStream:write	([BII)V
    //   146: goto -20 -> 126
    //   149: astore_1
    //   150: aload_0
    //   151: astore_1
    //   152: aload_2
    //   153: astore_0
    //   154: aload_1
    //   155: ifnull +7 -> 162
    //   158: aload_1
    //   159: invokevirtual 169	java/io/InputStream:close	()V
    //   162: aload_0
    //   163: ifnull +7 -> 170
    //   166: aload_0
    //   167: invokevirtual 170	java/io/OutputStream:close	()V
    //   170: return
    //   171: aload_0
    //   172: ifnull +7 -> 179
    //   175: aload_0
    //   176: invokevirtual 169	java/io/InputStream:close	()V
    //   179: aload_2
    //   180: ifnull -10 -> 170
    //   183: aload_2
    //   184: invokevirtual 170	java/io/OutputStream:close	()V
    //   187: return
    //   188: astore_0
    //   189: aload_0
    //   190: invokevirtual 171	java/io/IOException:printStackTrace	()V
    //   193: return
    //   194: astore_0
    //   195: aload_0
    //   196: invokevirtual 171	java/io/IOException:printStackTrace	()V
    //   199: return
    //   200: astore_1
    //   201: aconst_null
    //   202: astore_0
    //   203: aload_3
    //   204: astore_2
    //   205: aload_0
    //   206: ifnull +7 -> 213
    //   209: aload_0
    //   210: invokevirtual 169	java/io/InputStream:close	()V
    //   213: aload_2
    //   214: ifnull +7 -> 221
    //   217: aload_2
    //   218: invokevirtual 170	java/io/OutputStream:close	()V
    //   221: aload_1
    //   222: athrow
    //   223: astore_0
    //   224: aload_0
    //   225: invokevirtual 171	java/io/IOException:printStackTrace	()V
    //   228: goto -7 -> 221
    //   231: astore_1
    //   232: aload_3
    //   233: astore_2
    //   234: goto -29 -> 205
    //   237: astore_1
    //   238: goto -33 -> 205
    //   241: astore_0
    //   242: aconst_null
    //   243: astore_0
    //   244: aload_2
    //   245: astore_1
    //   246: goto -92 -> 154
    //   249: astore_1
    //   250: aconst_null
    //   251: astore_2
    //   252: aload_0
    //   253: astore_1
    //   254: aload_2
    //   255: astore_0
    //   256: goto -102 -> 154
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	259	0	paramContext	android.content.Context
    //   0	259	1	paramString	String
    //   3	252	2	localObject1	Object
    //   1	232	3	localObject2	Object
    //   33	73	4	str1	String
    //   60	33	5	str2	String
    //   131	11	6	i	int
    // Exception table:
    //   from	to	target	type
    //   120	126	149	java/lang/Exception
    //   126	133	149	java/lang/Exception
    //   138	146	149	java/lang/Exception
    //   175	179	188	java/io/IOException
    //   183	187	188	java/io/IOException
    //   158	162	194	java/io/IOException
    //   166	170	194	java/io/IOException
    //   101	111	200	finally
    //   209	213	223	java/io/IOException
    //   217	221	223	java/io/IOException
    //   111	120	231	finally
    //   120	126	237	finally
    //   126	133	237	finally
    //   138	146	237	finally
    //   101	111	241	java/lang/Exception
    //   111	120	249	java/lang/Exception
  }
  
  public static void do_report(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MQPSecUtil", 2, "report_tracer:" + paramString);
    }
    ReportController.a((QQAppInterface)BaseApplicationImpl.a().a(), "P_CliOper", "Safe_MQPSecUtil", "", "AntiTrace", paramString, 0, 0, "", "", "", "");
  }
  
  public static native boolean memchk(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte);
  
  public static native byte[] memreport(String paramString, int paramInt1, int paramInt2);
  
  public native void antitrace(String paramString);
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mqp\app\sec\MQPSecUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */