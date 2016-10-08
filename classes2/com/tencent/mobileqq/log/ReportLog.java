package com.tencent.mobileqq.log;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.utils.HeavyTaskExecutor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import mqq.app.CrashHandler;
import mqq.app.MobileQQ;
import szb;
import szc;
import szd;

public class ReportLog
  extends CrashHandler
{
  static final int jdField_a_of_type_Int = 10000001;
  public static ProgressDialog a;
  private static Handler jdField_a_of_type_AndroidOsHandler = new szb(Looper.getMainLooper());
  private static IHttpCommunicatorListener jdField_a_of_type_ComTencentMobileqqUtilsHttputilsIHttpCommunicatorListener = new szc();
  public static final String a = "/Tencent/MobileQQ/log/";
  private static Thread.UncaughtExceptionHandler jdField_a_of_type_JavaLangThread$UncaughtExceptionHandler;
  public static boolean a = false;
  private static final byte[] jdField_a_of_type_ArrayOfByte;
  static final int jdField_b_of_type_Int = 10000002;
  public static final String b = "log.txt";
  private static boolean jdField_b_of_type_Boolean = false;
  private static byte[] jdField_b_of_type_ArrayOfByte;
  public static String c;
  public static final String d = "Network";
  public static final String e = "Video";
  public static final String f = "LBS";
  public static String g = "http://bugtrace.3g.qq.com/upload/1/0";
  private static final String h = "ReportLog";
  private static final String i = "dump.hprof";
  private static String j;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ArrayOfByte = "9u23fh$jkf^%43hj".getBytes();
    j = "0";
    c = "/Tencent/MobileQQ/log/";
  }
  
  public ReportLog()
  {
    if (jdField_a_of_type_JavaLangThread$UncaughtExceptionHandler == null) {
      jdField_a_of_type_JavaLangThread$UncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
    }
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    if (jdField_b_of_type_Boolean == paramBoolean) {}
    do
    {
      return;
      jdField_b_of_type_Boolean = paramBoolean;
    } while (!paramBoolean);
    try
    {
      c = ReportLogHelper.a(paramContext, "/Tencent/MobileQQ/log/") + "/";
      ReportLogHelper.b = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      ReportLogHelper.c = Build.MODEL;
      ReportLogHelper.d = Build.VERSION.RELEASE;
      return;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
  }
  
  /* Error */
  public static void a(com.tencent.mobileqq.utils.httputils.HttpCommunicator paramHttpCommunicator, Context paramContext, ProgressDialog paramProgressDialog)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 164	com/tencent/common/config/AppSetting:a	I
    //   5: ldc -90
    //   7: ldc -88
    //   9: invokestatic 174	com/tencent/qphone/base/util/QLog:doReportLogSelf	(ILjava/lang/String;Ljava/lang/String;)V
    //   12: aload_0
    //   13: ifnonnull +4 -> 17
    //   16: return
    //   17: aload_2
    //   18: putstatic 176	com/tencent/mobileqq/log/ReportLog:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   21: new 104	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   28: aload_1
    //   29: ldc 13
    //   31: invokestatic 110	com/tencent/mobileqq/log/ReportLogHelper:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   34: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc 116
    //   39: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: putstatic 62	com/tencent/mobileqq/log/ReportLog:c	Ljava/lang/String;
    //   48: new 178	java/io/File
    //   51: dup
    //   52: new 104	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   59: getstatic 62	com/tencent/mobileqq/log/ReportLog:c	Ljava/lang/String;
    //   62: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: ldc 21
    //   67: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokespecial 181	java/io/File:<init>	(Ljava/lang/String;)V
    //   76: astore 5
    //   78: aload 5
    //   80: invokevirtual 185	java/io/File:exists	()Z
    //   83: ifeq -67 -> 16
    //   86: aconst_null
    //   87: ldc -69
    //   89: iconst_1
    //   90: invokestatic 190	com/tencent/mobileqq/log/ReportLog:a	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   93: iconst_1
    //   94: putstatic 192	com/tencent/mobileqq/log/ReportLog:jdField_a_of_type_Boolean	Z
    //   97: aload 5
    //   99: invokevirtual 196	java/io/File:length	()J
    //   102: lstore 7
    //   104: lload 7
    //   106: l2i
    //   107: newarray <illegal type>
    //   109: astore 4
    //   111: new 198	java/io/BufferedInputStream
    //   114: dup
    //   115: new 200	java/io/FileInputStream
    //   118: dup
    //   119: aload 5
    //   121: invokespecial 203	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   124: invokespecial 206	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   127: astore_2
    //   128: lload 7
    //   130: l2i
    //   131: istore 6
    //   133: aload_2
    //   134: astore_1
    //   135: aload_2
    //   136: aload 4
    //   138: iconst_0
    //   139: iload 6
    //   141: invokevirtual 210	java/io/BufferedInputStream:read	([BII)I
    //   144: i2l
    //   145: lload 7
    //   147: lcmp
    //   148: ifeq +41 -> 189
    //   151: aload_2
    //   152: astore_1
    //   153: new 158	java/lang/Exception
    //   156: dup
    //   157: ldc -44
    //   159: invokespecial 213	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   162: athrow
    //   163: astore_1
    //   164: aload_2
    //   165: astore_0
    //   166: aload_1
    //   167: astore_2
    //   168: aload_0
    //   169: astore_1
    //   170: aload_2
    //   171: invokevirtual 216	java/lang/Exception:printStackTrace	()V
    //   174: aload_0
    //   175: ifnull -159 -> 16
    //   178: aload_0
    //   179: invokevirtual 219	java/io/BufferedInputStream:close	()V
    //   182: return
    //   183: astore_0
    //   184: aload_0
    //   185: invokevirtual 220	java/io/IOException:printStackTrace	()V
    //   188: return
    //   189: aload_2
    //   190: astore_1
    //   191: aload_2
    //   192: invokevirtual 219	java/io/BufferedInputStream:close	()V
    //   195: aload 5
    //   197: invokevirtual 223	java/io/File:delete	()Z
    //   200: pop
    //   201: getstatic 225	com/tencent/mobileqq/log/ReportLog:jdField_b_of_type_ArrayOfByte	[B
    //   204: ifnonnull +11 -> 215
    //   207: ldc -29
    //   209: invokevirtual 54	java/lang/String:getBytes	()[B
    //   212: putstatic 225	com/tencent/mobileqq/log/ReportLog:jdField_b_of_type_ArrayOfByte	[B
    //   215: getstatic 60	com/tencent/mobileqq/log/ReportLog:j	Ljava/lang/String;
    //   218: ifnonnull +8 -> 226
    //   221: ldc 58
    //   223: putstatic 60	com/tencent/mobileqq/log/ReportLog:j	Ljava/lang/String;
    //   226: new 229	KQQ/UploadInfo
    //   229: dup
    //   230: invokespecial 230	KQQ/UploadInfo:<init>	()V
    //   233: astore_1
    //   234: aload_1
    //   235: getstatic 164	com/tencent/common/config/AppSetting:a	I
    //   238: i2l
    //   239: putfield 234	KQQ/UploadInfo:lAppID	J
    //   242: aload_1
    //   243: getstatic 60	com/tencent/mobileqq/log/ReportLog:j	Ljava/lang/String;
    //   246: invokestatic 240	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   249: putfield 243	KQQ/UploadInfo:lFromMID	J
    //   252: aload_1
    //   253: lconst_0
    //   254: putfield 246	KQQ/UploadInfo:lToMID	J
    //   257: aload_1
    //   258: iconst_1
    //   259: putfield 250	KQQ/UploadInfo:shType	S
    //   262: aload_1
    //   263: getstatic 225	com/tencent/mobileqq/log/ReportLog:jdField_b_of_type_ArrayOfByte	[B
    //   266: putfield 253	KQQ/UploadInfo:vSignature	[B
    //   269: aload_1
    //   270: invokevirtual 256	KQQ/UploadInfo:toByteArray	()[B
    //   273: astore_1
    //   274: new 258	com/tencent/qphone/base/util/Cryptor
    //   277: dup
    //   278: invokespecial 259	com/tencent/qphone/base/util/Cryptor:<init>	()V
    //   281: aload_1
    //   282: getstatic 56	com/tencent/mobileqq/log/ReportLog:jdField_a_of_type_ArrayOfByte	[B
    //   285: invokevirtual 263	com/tencent/qphone/base/util/Cryptor:encrypt	([B[B)[B
    //   288: astore_1
    //   289: new 265	KQQ/HttpUploadReq
    //   292: dup
    //   293: invokespecial 266	KQQ/HttpUploadReq:<init>	()V
    //   296: astore_2
    //   297: aload_2
    //   298: aload_1
    //   299: putfield 269	KQQ/HttpUploadReq:vEncryptUploadInfo	[B
    //   302: aload_2
    //   303: aload 4
    //   305: putfield 272	KQQ/HttpUploadReq:vFileData	[B
    //   308: new 274	com/tencent/mobileqq/utils/httputils/HttpMsg
    //   311: dup
    //   312: getstatic 86	com/tencent/mobileqq/log/ReportLog:g	Ljava/lang/String;
    //   315: aload_2
    //   316: invokevirtual 275	KQQ/HttpUploadReq:toByteArray	()[B
    //   319: getstatic 82	com/tencent/mobileqq/log/ReportLog:jdField_a_of_type_ComTencentMobileqqUtilsHttputilsIHttpCommunicatorListener	Lcom/tencent/mobileqq/utils/httputils/IHttpCommunicatorListener;
    //   322: invokespecial 278	com/tencent/mobileqq/utils/httputils/HttpMsg:<init>	(Ljava/lang/String;[BLcom/tencent/mobileqq/utils/httputils/IHttpCommunicatorListener;)V
    //   325: astore_1
    //   326: aload_1
    //   327: ldc_w 280
    //   330: invokevirtual 282	com/tencent/mobileqq/utils/httputils/HttpMsg:c	(Ljava/lang/String;)V
    //   333: aload_0
    //   334: aload_1
    //   335: invokevirtual 287	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)I
    //   338: pop
    //   339: iconst_0
    //   340: putstatic 192	com/tencent/mobileqq/log/ReportLog:jdField_a_of_type_Boolean	Z
    //   343: iconst_0
    //   344: ifeq -328 -> 16
    //   347: new 289	java/lang/NullPointerException
    //   350: dup
    //   351: invokespecial 290	java/lang/NullPointerException:<init>	()V
    //   354: athrow
    //   355: astore_0
    //   356: aload_0
    //   357: invokevirtual 220	java/io/IOException:printStackTrace	()V
    //   360: return
    //   361: astore_0
    //   362: aload_3
    //   363: astore_1
    //   364: aload_1
    //   365: ifnull +7 -> 372
    //   368: aload_1
    //   369: invokevirtual 219	java/io/BufferedInputStream:close	()V
    //   372: aload_0
    //   373: athrow
    //   374: astore_1
    //   375: aload_1
    //   376: invokevirtual 220	java/io/IOException:printStackTrace	()V
    //   379: goto -7 -> 372
    //   382: astore_0
    //   383: goto -19 -> 364
    //   386: astore_2
    //   387: aconst_null
    //   388: astore_0
    //   389: goto -221 -> 168
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	392	0	paramHttpCommunicator	com.tencent.mobileqq.utils.httputils.HttpCommunicator
    //   0	392	1	paramContext	Context
    //   0	392	2	paramProgressDialog	ProgressDialog
    //   1	362	3	localObject	Object
    //   109	195	4	arrayOfByte	byte[]
    //   76	120	5	localFile	java.io.File
    //   131	9	6	k	int
    //   102	44	7	l	long
    // Exception table:
    //   from	to	target	type
    //   135	151	163	java/lang/Exception
    //   153	163	163	java/lang/Exception
    //   191	195	163	java/lang/Exception
    //   178	182	183	java/io/IOException
    //   347	355	355	java/io/IOException
    //   93	128	361	finally
    //   195	215	361	finally
    //   215	226	361	finally
    //   226	343	361	finally
    //   368	372	374	java/io/IOException
    //   135	151	382	finally
    //   153	163	382	finally
    //   170	174	382	finally
    //   191	195	382	finally
    //   93	128	386	java/lang/Exception
    //   195	215	386	java/lang/Exception
    //   215	226	386	java/lang/Exception
    //   226	343	386	java/lang/Exception
  }
  
  public static void a(String paramString)
  {
    j = paramString;
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (!jdField_b_of_type_Boolean) {}
    while (jdField_a_of_type_Boolean) {
      return;
    }
    a(paramString1, paramString2, true);
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    ReportLogHelper.a(paramString1, paramString2, paramBoolean);
  }
  
  public static void a(byte[] paramArrayOfByte)
  {
    jdField_b_of_type_ArrayOfByte = paramArrayOfByte;
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    super.uncaughtException(paramThread, paramThrowable);
    QLog.d("ReportLog", 1, "uncaughtException java crash handler.");
    SharedPreferencesProxyManager.getInstance().trySave();
    HeavyTaskExecutor.a();
    paramThread = (MobileQQ)BaseApplication.getContext();
    try
    {
      ReportLogHelper.b = paramThread.getPackageManager().getPackageInfo(paramThread.getPackageName(), 0).versionName;
      ReportLogHelper.c = Build.MODEL;
      ReportLogHelper.d = Build.VERSION.RELEASE;
      Object localObject = new ByteArrayOutputStream();
      paramThrowable.printStackTrace(new PrintStream((OutputStream)localObject));
      localObject = new StringBuilder(new String(((ByteArrayOutputStream)localObject).toByteArray()));
      if ((paramThrowable instanceof OutOfMemoryError))
      {
        System.gc();
        ((StringBuilder)localObject).append("\n");
        ((StringBuilder)localObject).append(BitmapManager.a());
        ((StringBuilder)localObject).append("\n");
      }
      a("crash", ((StringBuilder)localObject).toString(), true);
      paramThread.crashed();
      paramThread.sendBroadcast(new Intent("qqplayer_exit_action"));
      paramThread = new szd(this, paramThread);
      if (Thread.currentThread() != Looper.getMainLooper().getThread())
      {
        new Handler(Looper.getMainLooper()).postAtFrontOfQueue(paramThread);
        return;
      }
      paramThread.run();
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\log\ReportLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */