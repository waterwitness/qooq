package ct;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import com.tencent.map.geolocation.TencentLocation;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

public final class cy
  implements Thread.UncaughtExceptionHandler
{
  private static final String a = TencentLocation.class.getPackage().getName();
  private final Context b;
  private final String c;
  private final String d;
  private final Thread.UncaughtExceptionHandler e;
  
  private cy(Context paramContext, String paramString1, String paramString2)
  {
    this.b = paramContext;
    this.c = paramString1;
    this.d = paramString2;
    this.e = Thread.getDefaultUncaughtExceptionHandler();
  }
  
  @SuppressLint({"NewApi"})
  private static String a(Context paramContext, Thread paramThread, Throwable paramThrowable)
  {
    try
    {
      Object localObject1 = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      localObject2 = bl.a(paramContext).a(1000L);
      if (localObject2 != null)
      {
        str = ((bm)localObject2).d();
        if (localObject2 == null) {
          break label536;
        }
        localObject2 = ((bm)localObject2).e();
        localStringBuilder = new StringBuilder("SDK_V" + str + "_Errlog|");
        localStringBuilder.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(new Date())).append("|");
        localObject3 = (TelephonyManager)paramContext.getSystemService("phone");
        if (localObject3 == null) {
          break label566;
        }
        localObject3 = ((TelephonyManager)localObject3).getDeviceId();
        localStringBuilder.append((String)localObject3).append("|");
        localStringBuilder.append(str).append("|");
        localStringBuilder.append((String)localObject2).append("|");
        localStringBuilder.append(paramContext.getPackageName()).append("|");
        localStringBuilder.append(((PackageInfo)localObject1).versionName).append("|");
        localStringBuilder.append(((PackageInfo)localObject1).versionCode).append("|");
        localStringBuilder.append(Build.VERSION.RELEASE).append("|");
        localStringBuilder.append(Build.MODEL).append("|");
        localStringBuilder.append("android-").append(Build.VERSION.SDK_INT).append("|");
        localStringBuilder.append(paramThread.getName()).append("|");
        localStringBuilder.append("ExceptionClass:").append(paramThrowable.getClass()).append("|");
        localStringBuilder.append("ExceptionMessage:").append(paramThrowable.getMessage()).append("|");
        localStringBuilder.append("ExceptionDetails:");
        localObject1 = new StringWriter();
        paramThread = new PrintWriter((Writer)localObject1);
        paramThrowable.printStackTrace(paramThread);
        localObject1 = localObject1.toString().replaceAll("\r|\n", "__");
        paramThread.close();
        localStringBuilder.append((String)localObject1);
        if ((paramThrowable instanceof LinkageError))
        {
          localStringBuilder.append("|").append(Build.CPU_ABI).append(",").append(Build.CPU_ABI2).append("|");
          if (Build.VERSION.SDK_INT <= 8) {
            break label544;
          }
          paramThread = new File(paramContext.getApplicationInfo().nativeLibraryDir);
          if ((paramThread != null) && (paramThread.isDirectory())) {
            localStringBuilder.append(paramThread.getAbsolutePath()).append("|").append(Arrays.toString(paramThread.list()));
          }
          localStringBuilder.append("|");
          paramContext = new File(paramContext.getFilesDir(), "libtencentloc.so");
          if (!paramContext.exists()) {
            break label556;
          }
          localStringBuilder.append(paramContext.length());
        }
        return localStringBuilder.toString();
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        StringBuilder localStringBuilder;
        PackageInfo localPackageInfo = new PackageInfo();
        continue;
        String str = "None";
        continue;
        label536:
        Object localObject2 = "None";
        continue;
        label544:
        paramThread = paramContext.getDir("lib", 0);
        continue;
        label556:
        localStringBuilder.append(0);
        continue;
        label566:
        Object localObject3 = "";
      }
    }
  }
  
  public static void a(Context paramContext)
  {
    if (!(Thread.getDefaultUncaughtExceptionHandler() instanceof cy))
    {
      File localFile = new File(paramContext.getDir("txsdklog", 0), "raw");
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      Thread.setDefaultUncaughtExceptionHandler(new cy(paramContext, localFile.getAbsolutePath(), "http://lstest.map.qq.com/stat"));
    }
  }
  
  private boolean a(Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return false;
    }
    if (!bl.a(this.b).b.q) {
      return true;
    }
    for (;;)
    {
      paramThrowable = paramThrowable.getCause();
      if (paramThrowable == null) {
        break;
      }
      StackTraceElement[] arrayOfStackTraceElement = paramThrowable.getStackTrace();
      int j = arrayOfStackTraceElement.length;
      int i = 0;
      while (i < j)
      {
        StackTraceElement localStackTraceElement = arrayOfStackTraceElement[i];
        if (("TL".equals(localStackTraceElement.getFileName())) || (localStackTraceElement.getClassName().contains(a))) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  /* Error */
  public final void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    // Byte code:
    //   0: aload_2
    //   1: instanceof 336
    //   4: ifeq +25 -> 29
    //   7: aload_0
    //   8: getfield 39	ct/cy:b	Landroid/content/Context;
    //   11: invokestatic 77	ct/bl:a	(Landroid/content/Context;)Lct/bl;
    //   14: ldc_w 338
    //   17: invokevirtual 341	ct/bl:a	(Ljava/lang/String;)Lct/bp;
    //   20: getstatic 346	ct/bw:a	Landroid/os/Bundle;
    //   23: invokevirtual 351	ct/bp:b	(Landroid/os/Bundle;)Z
    //   26: ifne +286 -> 312
    //   29: aload_0
    //   30: getfield 39	ct/cy:b	Landroid/content/Context;
    //   33: invokestatic 77	ct/bl:a	(Landroid/content/Context;)Lct/bl;
    //   36: getfield 298	ct/bl:b	Lct/bm;
    //   39: getfield 354	ct/bm:r	Z
    //   42: ifeq +110 -> 152
    //   45: aload_0
    //   46: getfield 39	ct/cy:b	Landroid/content/Context;
    //   49: aload_1
    //   50: aload_2
    //   51: invokestatic 356	ct/cy:a	(Landroid/content/Context;Ljava/lang/Thread;Ljava/lang/Throwable;)Ljava/lang/String;
    //   54: astore 6
    //   56: new 221	java/io/File
    //   59: dup
    //   60: new 90	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 357	java/lang/StringBuilder:<init>	()V
    //   67: aload_0
    //   68: getfield 41	ct/cy:c	Ljava/lang/String;
    //   71: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: ldc_w 359
    //   77: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: invokestatic 365	java/util/UUID:randomUUID	()Ljava/util/UUID;
    //   83: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   86: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: invokespecial 231	java/io/File:<init>	(Ljava/lang/String;)V
    //   92: astore_3
    //   93: invokestatic 371	java/nio/charset/Charset:defaultCharset	()Ljava/nio/charset/Charset;
    //   96: astore 4
    //   98: aconst_null
    //   99: astore 5
    //   101: new 373	java/io/BufferedWriter
    //   104: dup
    //   105: new 375	java/io/OutputStreamWriter
    //   108: dup
    //   109: new 377	java/io/FileOutputStream
    //   112: dup
    //   113: aload_3
    //   114: iconst_1
    //   115: invokespecial 380	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   118: aload 4
    //   120: invokespecial 383	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/nio/charset/Charset;)V
    //   123: invokespecial 384	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   126: astore 4
    //   128: aload 4
    //   130: astore_3
    //   131: aload 4
    //   133: aload 6
    //   135: invokevirtual 387	java/io/BufferedWriter:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   138: pop
    //   139: aload 4
    //   141: astore_3
    //   142: aload 4
    //   144: invokevirtual 390	java/io/BufferedWriter:flush	()V
    //   147: aload 4
    //   149: invokestatic 395	ct/b:a	(Ljava/io/Closeable;)V
    //   152: aload_0
    //   153: aload_2
    //   154: invokespecial 397	ct/cy:a	(Ljava/lang/Throwable;)Z
    //   157: ifeq +144 -> 301
    //   160: new 90	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 357	java/lang/StringBuilder:<init>	()V
    //   167: new 106	java/text/SimpleDateFormat
    //   170: dup
    //   171: ldc_w 399
    //   174: getstatic 114	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   177: invokespecial 117	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   180: new 119	java/util/Date
    //   183: dup
    //   184: invokespecial 120	java/util/Date:<init>	()V
    //   187: invokevirtual 124	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   190: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: invokestatic 405	java/lang/Math:random	()D
    //   196: ldc2_w 406
    //   199: dmul
    //   200: d2i
    //   201: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   204: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: astore_3
    //   208: new 90	java/lang/StringBuilder
    //   211: dup
    //   212: invokespecial 357	java/lang/StringBuilder:<init>	()V
    //   215: aload_3
    //   216: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: ldc_w 409
    //   222: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: astore_3
    //   229: aload_0
    //   230: getfield 39	ct/cy:b	Landroid/content/Context;
    //   233: aload_1
    //   234: aload_2
    //   235: invokestatic 356	ct/cy:a	(Landroid/content/Context;Ljava/lang/Thread;Ljava/lang/Throwable;)Ljava/lang/String;
    //   238: astore 4
    //   240: aload_0
    //   241: getfield 43	ct/cy:d	Ljava/lang/String;
    //   244: ifnull +57 -> 301
    //   247: aload_0
    //   248: getfield 39	ct/cy:b	Landroid/content/Context;
    //   251: invokestatic 77	ct/bl:a	(Landroid/content/Context;)Lct/bl;
    //   254: ldc_w 288
    //   257: aload 4
    //   259: new 90	java/lang/StringBuilder
    //   262: dup
    //   263: invokespecial 357	java/lang/StringBuilder:<init>	()V
    //   266: aload_0
    //   267: getfield 41	ct/cy:c	Ljava/lang/String;
    //   270: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: ldc_w 359
    //   276: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: aload_3
    //   280: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   286: invokestatic 414	ct/cz:a	(Lct/bl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/concurrent/CountDownLatch;
    //   289: astore_3
    //   290: aload_3
    //   291: ldc2_w 415
    //   294: getstatic 422	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   297: invokevirtual 428	java/util/concurrent/CountDownLatch:await	(JLjava/util/concurrent/TimeUnit;)Z
    //   300: pop
    //   301: aload_0
    //   302: getfield 51	ct/cy:e	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   305: aload_1
    //   306: aload_2
    //   307: invokeinterface 430 3 0
    //   312: return
    //   313: astore 5
    //   315: aconst_null
    //   316: astore_3
    //   317: aload 5
    //   319: athrow
    //   320: astore 5
    //   322: aload_3
    //   323: astore 4
    //   325: aload 5
    //   327: astore_3
    //   328: aload 4
    //   330: invokestatic 395	ct/b:a	(Ljava/io/Closeable;)V
    //   333: aload_3
    //   334: athrow
    //   335: astore_3
    //   336: goto -184 -> 152
    //   339: astore_3
    //   340: aload_3
    //   341: invokevirtual 432	java/lang/InterruptedException:printStackTrace	()V
    //   344: goto -43 -> 301
    //   347: astore_3
    //   348: aload 5
    //   350: astore 4
    //   352: goto -24 -> 328
    //   355: astore 5
    //   357: aload 4
    //   359: astore_3
    //   360: goto -43 -> 317
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	363	0	this	cy
    //   0	363	1	paramThread	Thread
    //   0	363	2	paramThrowable	Throwable
    //   92	242	3	localObject1	Object
    //   335	1	3	localIOException1	java.io.IOException
    //   339	2	3	localInterruptedException	InterruptedException
    //   347	1	3	localObject2	Object
    //   359	1	3	localObject3	Object
    //   96	262	4	localObject4	Object
    //   99	1	5	localObject5	Object
    //   313	5	5	localIOException2	java.io.IOException
    //   320	29	5	localObject6	Object
    //   355	1	5	localIOException3	java.io.IOException
    //   54	80	6	str	String
    // Exception table:
    //   from	to	target	type
    //   101	128	313	java/io/IOException
    //   131	139	320	finally
    //   142	147	320	finally
    //   317	320	320	finally
    //   56	98	335	java/io/IOException
    //   147	152	335	java/io/IOException
    //   328	335	335	java/io/IOException
    //   290	301	339	java/lang/InterruptedException
    //   101	128	347	finally
    //   131	139	355	java/io/IOException
    //   142	147	355	java/io/IOException
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ct\cy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */