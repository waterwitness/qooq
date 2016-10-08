package com.tencent.qphone.base.util;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.commonsdk.pool.RecyclablePool;
import com.tencent.commonsdk.pool.RecyclablePool.Recyclable;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.auth.b;
import com.tencent.mobileqq.msf.core.c.m;
import com.tencent.mobileqq.msf.core.f;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.service.MsfService;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;

public class QLog
{
  public static final int CLR = 2;
  public static final int DEV = 4;
  private static final int[] INTERVAL_RETRY_INIT;
  private static final int MSG_CLEAR = 3;
  private static final int MSG_INIT_WRITER = 1;
  private static final int MSG_WRITE = 2;
  private static final String QlogSpTag = "QLog";
  private static final String ReportLogSelfTimeTag = "";
  public static final String TAG_REPORTLEVEL_COLORUSER = "W";
  public static final String TAG_REPORTLEVEL_DEVELOPER = "D";
  public static final String TAG_REPORTLEVEL_USER = "E";
  private static int UIN_REPORTLOG_LEVEL = 0;
  public static final int USR = 1;
  protected static int _DEFAULT_REPORTLOG_LEVEL = 0;
  static long colorLogTime = 0L;
  static HashSet colorTags = new HashSet();
  private static long currentLogSecond = 0L;
  protected static final boolean isDebug = false;
  protected static boolean isLogToFile = true;
  private static long lastCheckLogFileTime = 0L;
  private static long lastPrintMemeoryTime = 0L;
  public static final String logLevelHead = "LOGLEVEL_";
  public static final String logLevelTime = "LOGLEVELTIME";
  private static String logPath;
  public static final String logSaveTime = "LOGSAVETIME";
  private static String logTime;
  private static final int myProcessId;
  private static long nextHourTime = 0L;
  private static String oldLogPath;
  public static String packageName;
  private static String processName;
  private static int retryInitTimes = 0;
  static String sBuildNumber = "";
  private static StringBuilder sBuilder = new StringBuilder(10240);
  private static b sHead;
  private static RecyclablePool sPool;
  private static b sTail;
  static Field sValueField;
  private static char[] sValues;
  static c sWriteHandler;
  private static final String tag = "MSF.D.QLog";
  private static BufferedWriter writer;
  
  static
  {
    _DEFAULT_REPORTLOG_LEVEL = 1;
    UIN_REPORTLOG_LEVEL = _DEFAULT_REPORTLOG_LEVEL;
    logPath = "";
    oldLogPath = "";
    processName = "";
    packageName = "";
    myProcessId = Process.myPid();
    INTERVAL_RETRY_INIT = new int[] { 1, 1, 1, 2, 2, 4, 4, 8, 16, 29 };
    logTime = "";
  }
  
  private static void addLogItem(String arg0, int paramInt, String paramString2, Throwable paramThrowable)
  {
    long l = System.currentTimeMillis();
    if ((colorLogTime != 0L) && (l - colorLogTime > 1800000L))
    {
      colorLogTime = 0L;
      colorTags.clear();
    }
    b localb = (b)sPool.obtain(b.class);
    localb.a = l;
    localb.b = Thread.currentThread().getId();
    localb.c = paramInt;
    localb.d = ???;
    localb.e = paramString2;
    localb.f = paramThrowable;
    synchronized (processName)
    {
      if (sHead == null)
      {
        sHead = localb;
        sTail = localb;
        return;
      }
      sTail.changeNext(localb, true);
      sTail = localb;
    }
  }
  
  private static boolean checkCurrentLogFileExists()
  {
    long l = System.currentTimeMillis();
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(l);
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yy.MM.dd.HH");
    logTime = new SimpleDateFormat("yy-MM-dd HH:mm:ss").format(Long.valueOf(l));
    localObject = localSimpleDateFormat.format(((Calendar)localObject).getTime());
    localObject = logPath + getLogFileName((String)localObject);
    if (!new File(logPath).exists()) {}
    while (!new File((String)localObject).exists()) {
      return false;
    }
    return true;
  }
  
  public static void d(String paramString1, int paramInt, String paramString2)
  {
    d(paramString1, paramInt, paramString2, null);
  }
  
  public static void d(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    String str;
    if ((UIN_REPORTLOG_LEVEL >= paramInt) || (colorTags.contains(paramString1)))
    {
      str = paramString2;
      if (paramString2 == null) {
        str = "";
      }
      if (paramThrowable != null) {
        break label48;
      }
      Log.d(paramString1, str);
    }
    for (;;)
    {
      addLogItem(paramString1, paramInt, str, paramThrowable);
      return;
      label48:
      Log.d(paramString1, str, paramThrowable);
    }
  }
  
  public static void d(String paramString, int paramInt, Throwable paramThrowable, Object... paramVarArgs)
  {
    int j = 0;
    int k = paramVarArgs.length;
    if (paramThrowable == null) {}
    StringBuilder localStringBuilder;
    for (int i = 0;; i = 128)
    {
      localStringBuilder = new StringBuilder(i + k * 30);
      i = j;
      while (i < paramVarArgs.length)
      {
        localStringBuilder.append(paramVarArgs[i]);
        i += 1;
      }
    }
    d(paramString, paramInt, localStringBuilder.toString(), paramThrowable);
  }
  
  public static void d(String paramString, int paramInt, Object... paramVarArgs)
  {
    d(paramString, paramInt, null, paramVarArgs);
  }
  
  public static void doReportLogSelf(int paramInt, String paramString1, String paramString2)
  {
    int i = 0;
    Object localObject = BaseApplication.getContext().getSharedPreferences("QLog", 0);
    long l = ((SharedPreferences)localObject).getLong("", -1L);
    if ((l == -1L) || (System.currentTimeMillis() - l > 3600000L))
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putLong("", System.currentTimeMillis());
      ((SharedPreferences.Editor)localObject).commit();
      i = 1;
    }
    if (i != 0)
    {
      paramString1 = new g(paramInt, paramString1, paramString2);
      paramString1.setName("doReportLogSelfThread");
      paramString1.start();
    }
  }
  
  public static void e(String paramString1, int paramInt, String paramString2)
  {
    e(paramString1, paramInt, paramString2, null);
  }
  
  public static void e(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    String str;
    if ((UIN_REPORTLOG_LEVEL >= paramInt) || (colorTags.contains(paramString1)))
    {
      str = paramString2;
      if (paramString2 == null) {
        str = "";
      }
      if (paramThrowable != null) {
        break label48;
      }
      Log.e(paramString1, str);
    }
    for (;;)
    {
      addLogItem(paramString1, paramInt, str, paramThrowable);
      return;
      label48:
      Log.e(paramString1, str, paramThrowable);
    }
  }
  
  public static void e(String paramString, int paramInt, Throwable paramThrowable, Object... paramVarArgs)
  {
    int j = 0;
    int k = paramVarArgs.length;
    if (paramThrowable == null) {}
    StringBuilder localStringBuilder;
    for (int i = 0;; i = 128)
    {
      localStringBuilder = new StringBuilder(i + k * 30);
      i = j;
      while (i < paramVarArgs.length)
      {
        localStringBuilder.append(paramVarArgs[i].toString());
        i += 1;
      }
    }
    e(paramString, paramInt, localStringBuilder.toString(), paramThrowable);
  }
  
  public static void e(String paramString, int paramInt, Object... paramVarArgs)
  {
    e(paramString, paramInt, null, paramVarArgs);
  }
  
  public static void endColorLog(String[] paramArrayOfString, int paramInt, boolean paramBoolean, String paramString)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramArrayOfString[i];
      colorTags.remove(str);
      i += 1;
    }
    if (paramBoolean) {
      doReportLogSelf(paramInt, "mobileqq", paramString);
    }
  }
  
  public static void flushLog()
  {
    sWriteHandler.sendEmptyMessage(2);
    sWriteHandler.sendEmptyMessageDelayed(2, 20L);
    sWriteHandler.sendEmptyMessageDelayed(2, 80L);
    sWriteHandler.sendEmptyMessageDelayed(2, 160L);
    sWriteHandler.sendEmptyMessageDelayed(2, 320L);
  }
  
  public static SimpleDateFormat getLogFileFormatter()
  {
    return new SimpleDateFormat("yy.MM.dd.HH");
  }
  
  public static String getLogFileName(String paramString)
  {
    return processName.replace(":", "_") + "." + paramString + ".log";
  }
  
  public static String getLogPath()
  {
    return logPath;
  }
  
  public static String getOldLogPath()
  {
    return oldLogPath;
  }
  
  public static String getReportLevel(int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    default: 
      return "E";
    case 2: 
      return "W";
    case 4: 
      return "D";
    }
    return "E";
  }
  
  public static String getStackTraceString(Throwable paramThrowable)
  {
    return MsfSdkUtils.getStackTraceString(paramThrowable);
  }
  
  public static char[] getStringValue(StringBuilder paramStringBuilder)
  {
    try
    {
      if (sValueField == null)
      {
        sValueField = StringBuilder.class.getSuperclass().getDeclaredField("value");
        sValueField.setAccessible(true);
      }
      paramStringBuilder = (char[])sValueField.get(paramStringBuilder);
      return paramStringBuilder;
    }
    catch (NoSuchFieldException paramStringBuilder)
    {
      paramStringBuilder.printStackTrace();
      return null;
    }
    catch (IllegalArgumentException paramStringBuilder)
    {
      for (;;)
      {
        paramStringBuilder.printStackTrace();
      }
    }
    catch (IllegalAccessException paramStringBuilder)
    {
      for (;;)
      {
        paramStringBuilder.printStackTrace();
      }
    }
  }
  
  public static int getUIN_REPORTLOG_LEVEL()
  {
    return UIN_REPORTLOG_LEVEL;
  }
  
  public static void i(String paramString1, int paramInt, String paramString2)
  {
    i(paramString1, paramInt, paramString2, null);
  }
  
  public static void i(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    String str;
    if ((UIN_REPORTLOG_LEVEL >= paramInt) || (colorTags.contains(paramString1)))
    {
      str = paramString2;
      if (paramString2 == null) {
        str = "";
      }
      if (paramThrowable != null) {
        break label48;
      }
      Log.i(paramString1, str);
    }
    for (;;)
    {
      addLogItem(paramString1, paramInt, str, paramThrowable);
      return;
      label48:
      Log.i(paramString1, str, paramThrowable);
    }
  }
  
  public static void init(String paramString1, String paramString2, String paramString3, long paramLong)
  {
    int i;
    if (sWriteHandler == null)
    {
      processName = paramString2;
      packageName = paramString1;
      sBuildNumber = paramString3;
      paramString1 = new HandlerThread("logWriteThread");
      paramString1.start();
      sWriteHandler = new c(paramString1.getLooper());
      sWriteHandler.sendEmptyMessageDelayed(1, paramLong);
      if (!isDevelopLevel()) {
        break label82;
      }
      i = 512;
    }
    for (;;)
    {
      sPool = new RecyclablePool(b.class, i);
      return;
      label82:
      if (isColorLevel()) {
        i = 256;
      } else {
        i = 128;
      }
    }
  }
  
  static void initLogFile(long paramLong)
    throws IOException
  {
    logPath = Environment.getExternalStorageDirectory().getPath() + "/tencent/msflogs/" + packageName.replace(".", "/") + "/";
    oldLogPath = Environment.getExternalStorageDirectory().getPath() + "/tencent/" + packageName.replace(".", "/") + "/";
    Object localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).setTimeInMillis(paramLong);
    Object localObject2 = new SimpleDateFormat("yy.MM.dd.HH");
    logTime = new SimpleDateFormat("yy-MM-dd HH:mm:ss").format(Long.valueOf(paramLong));
    localObject2 = ((SimpleDateFormat)localObject2).format(((Calendar)localObject1).getTime());
    ((Calendar)localObject1).set(14, 0);
    ((Calendar)localObject1).add(11, 1);
    ((Calendar)localObject1).set(12, 0);
    ((Calendar)localObject1).set(13, 0);
    nextHourTime = ((Calendar)localObject1).getTimeInMillis();
    localObject2 = logPath + getLogFileName((String)localObject2);
    localObject1 = new File(logPath);
    for (;;)
    {
      try
      {
        if (!((File)localObject1).exists()) {
          ((File)localObject1).mkdirs();
        }
        localObject2 = new File((String)localObject2);
        try
        {
          if (!((File)localObject2).exists())
          {
            boolean bool = ((File)localObject2).createNewFile();
            localObject1 = localObject2;
            if (writer != null)
            {
              writer.write(logTime + "|" + processName + "|D|" + "|QQ_Version: " + sBuildNumber + "\r\n");
              writer.write(logTime + "|" + processName + "|D|" + "MSF.D.QLog" + "|" + Build.MODEL + " " + Build.VERSION.RELEASE + " create newLogFile " + ((File)localObject2).getName() + " " + bool + "\n");
              writer.flush();
              localObject1 = localObject2;
            }
            writer = new BufferedWriter(new h((File)localObject1, true), 8192);
            if (writer != null)
            {
              writer.write(logTime + "|" + processName + "|D|" + "|QQ_Version: " + sBuildNumber + "\r\n");
              writer.flush();
            }
            return;
          }
          localObject1 = localObject2;
          if (writer == null) {
            continue;
          }
          writer.write(logTime + "|" + processName + "|D|" + "|QQ_Version: " + sBuildNumber + "\r\n");
          writer.write(logTime + "|" + processName + "|E|" + "MSF.D.QLog" + "|" + Build.MODEL + " " + Build.VERSION.RELEASE + "|newLogFile " + ((File)localObject2).getName() + " is existed.\n");
          writer.flush();
          localObject1 = localObject2;
          continue;
          ((Throwable)localObject2).printStackTrace();
        }
        catch (Throwable localThrowable2)
        {
          localObject1 = localObject2;
          localObject2 = localThrowable2;
        }
      }
      catch (Throwable localThrowable1)
      {
        continue;
      }
      try
      {
        if ((!TextUtils.isEmpty(processName)) && (processName.endsWith("msf")))
        {
          Object localObject3 = new StringWriter();
          ((Throwable)localObject2).printStackTrace(new PrintWriter((Writer)localObject3));
          localObject3 = ((StringWriter)localObject3).toString();
          if ((MsfService.getCore() != null) && (MsfService.getCore().statReporter != null))
          {
            HashMap localHashMap = new HashMap();
            localHashMap.put("acount", MsfService.getCore().getAccountCenter().i());
            localHashMap.put("except", localObject3);
            localHashMap.put("exceptMsg", "" + ((Throwable)localObject2).getMessage());
            MsfService.getCore().statReporter.a("msfloginitexcpt", false, 0L, 0L, localHashMap, false, false);
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public static boolean isColorLevel()
  {
    return UIN_REPORTLOG_LEVEL > 1;
  }
  
  public static final boolean isDevelopLevel()
  {
    return UIN_REPORTLOG_LEVEL >= 4;
  }
  
  public static void p(String paramString1, String paramString2)
  {
    Log.d(paramString1, "[s]" + paramString2);
  }
  
  public static void setUIN_REPORTLOG_LEVEL(int paramInt)
  {
    UIN_REPORTLOG_LEVEL = paramInt;
    d("MSF.D.QLog", 1, "set UIN_REPORTLOG_LEVEL " + getUIN_REPORTLOG_LEVEL());
  }
  
  public static void startColorLog(String[] paramArrayOfString)
  {
    colorLogTime = System.currentTimeMillis();
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramArrayOfString[i];
      colorTags.add(str);
      i += 1;
    }
  }
  
  public static void syncReportLogSelf(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    String str = paramString1 + ".zip";
    File localFile = new File(str);
    localFile.delete();
    try
    {
      localFile.createNewFile();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new a(paramString1));
      f.a(localArrayList, str);
      f.a(paramInt, str, paramString2, paramString3);
      localFile.delete();
      return;
    }
    catch (IOException paramString1)
    {
      paramString1.printStackTrace();
      d("MSF.D.QLog", 1, "doReportLogSelf error " + paramString1);
    }
  }
  
  public static void w(String paramString1, int paramInt, String paramString2)
  {
    w(paramString1, paramInt, paramString2, null);
  }
  
  public static void w(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    String str;
    if ((UIN_REPORTLOG_LEVEL >= paramInt) || (colorTags.contains(paramString1)))
    {
      str = paramString2;
      if (paramString2 == null) {
        str = "";
      }
      if (paramThrowable != null) {
        break label48;
      }
      Log.w(paramString1, str);
    }
    for (;;)
    {
      addLogItem(paramString1, paramInt, str, paramThrowable);
      return;
      label48:
      Log.w(paramString1, str, paramThrowable);
    }
  }
  
  private static boolean writeLogToFile()
  {
    boolean bool1 = false;
    b localb;
    try
    {
      if (writer == null) {
        return true;
      }
      Object localObject1;
      if ((isColorLevel()) && (BaseApplication.getContext() != null) && (System.currentTimeMillis() - lastPrintMemeoryTime > 180000L))
      {
        localObject1 = (ActivityManager)BaseApplication.getContext().getSystemService("activity");
        ??? = new ActivityManager.MemoryInfo();
        ((ActivityManager)localObject1).getMemoryInfo((ActivityManager.MemoryInfo)???);
        d("MSF.D.QLog", 2, "availMem:" + ((ActivityManager.MemoryInfo)???).availMem / 1024L / 1024L + "M" + " lowThreshold:" + ((ActivityManager.MemoryInfo)???).threshold / 1024L / 1024L + "M");
        lastPrintMemeoryTime = System.currentTimeMillis();
      }
      if ((System.currentTimeMillis() - lastCheckLogFileTime > 180000L) && (!checkCurrentLogFileExists()))
      {
        lastCheckLogFileTime = System.currentTimeMillis();
        return true;
      }
      synchronized (processName)
      {
        localb = sTail;
        localObject1 = sHead;
        sTail = null;
        sHead = null;
        if (localObject1 == null) {
          return false;
        }
      }
      bool2 = bool1;
    }
    catch (Throwable localThrowable)
    {
      e("MSF.D.QLog", 1, localThrowable.getMessage());
      return true;
    }
    for (;;)
    {
      boolean bool2;
      if (!bool1)
      {
        bool2 = bool1;
        if (localThrowable.a > nextHourTime) {
          bool2 = true;
        }
      }
      long l = localThrowable.a;
      if ((l >= currentLogSecond + 1000L) || (l < currentLogSecond))
      {
        logTime = MsfSdkUtils.timeFormatter.format(Long.valueOf(l));
        if ((l >= currentLogSecond + 1000L) && (l < currentLogSecond + 2000L)) {
          currentLogSecond += 1000L;
        }
      }
      else
      {
        ??? = sBuilder.delete(0, sBuilder.length());
        ((StringBuilder)???).append(logTime).append('|').append(localThrowable.a).append('[').append(myProcessId).append(']').append(localThrowable.b).append('|').append(getReportLevel(localThrowable.c)).append('|').append(localThrowable.d).append('|').append(localThrowable.e).append('\n');
        if ((sValues == null) || (sValues.length != ((StringBuilder)???).capacity())) {
          sValues = getStringValue((StringBuilder)???);
        }
        if (sValues == null) {
          break label542;
        }
        writer.write(sValues, 0, ((StringBuilder)???).length());
      }
      for (;;)
      {
        if (localThrowable.f != null)
        {
          writer.write(Log.getStackTraceString(localThrowable.f));
          writer.write(10);
        }
        ??? = (b)localThrowable.getNext();
        sPool.recycle(localThrowable);
        if (localThrowable != localb) {
          break label555;
        }
        writer.flush();
        return bool2;
        ??? = Calendar.getInstance();
        ((Calendar)???).setTimeInMillis(l);
        ((Calendar)???).set(14, 0);
        currentLogSecond = ((Calendar)???).getTimeInMillis();
        break;
        label542:
        writer.write(((StringBuilder)???).toString());
      }
      label555:
      Object localObject3 = ???;
      bool1 = bool2;
    }
  }
  
  public static class a
    extends File
  {
    public String a = "";
    
    public a(File paramFile, String paramString)
    {
      super(paramString);
    }
    
    public a(String paramString)
    {
      super();
    }
  }
  
  public static class b
    extends RecyclablePool.Recyclable
  {
    public long a;
    public long b;
    public int c;
    public String d;
    public String e;
    public Throwable f;
    
    public void recycle()
    {
      super.recycle();
      this.a = 0L;
      this.b = 0L;
      this.c = 0;
      this.d = "";
      this.e = "";
      this.f = null;
    }
  }
  
  static class c
    extends Handler
  {
    public c(Looper paramLooper)
    {
      super();
    }
    
    /* Error */
    public void handleMessage(android.os.Message arg1)
    {
      // Byte code:
      //   0: ldc2_w 17
      //   3: lstore 5
      //   5: aload_1
      //   6: getfield 24	android/os/Message:what	I
      //   9: tableswitch	default:+27->36, 1:+28->37, 2:+242->251, 3:+62->71
      //   36: return
      //   37: ldc 26
      //   39: ldc 28
      //   41: invokestatic 34	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
      //   44: pop
      //   45: invokestatic 40	java/lang/System:currentTimeMillis	()J
      //   48: invokestatic 44	com/tencent/qphone/base/util/QLog:initLogFile	(J)V
      //   51: iconst_0
      //   52: invokestatic 48	com/tencent/qphone/base/util/QLog:access$002	(I)I
      //   55: pop
      //   56: getstatic 52	com/tencent/qphone/base/util/QLog:sWriteHandler	Lcom/tencent/qphone/base/util/QLog$c;
      //   59: iconst_2
      //   60: invokevirtual 56	com/tencent/qphone/base/util/QLog$c:removeMessages	(I)V
      //   63: getstatic 52	com/tencent/qphone/base/util/QLog:sWriteHandler	Lcom/tencent/qphone/base/util/QLog$c;
      //   66: iconst_2
      //   67: invokevirtual 60	com/tencent/qphone/base/util/QLog$c:sendEmptyMessage	(I)Z
      //   70: pop
      //   71: invokestatic 64	com/tencent/qphone/base/util/QLog:access$000	()I
      //   74: ifle -38 -> 36
      //   77: ldc 26
      //   79: ldc 66
      //   81: invokestatic 34	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
      //   84: pop
      //   85: invokestatic 70	com/tencent/qphone/base/util/QLog:access$200	()Ljava/lang/String;
      //   88: astore_1
      //   89: aload_1
      //   90: monitorenter
      //   91: aconst_null
      //   92: invokestatic 74	com/tencent/qphone/base/util/QLog:access$402	(Lcom/tencent/qphone/base/util/QLog$b;)Lcom/tencent/qphone/base/util/QLog$b;
      //   95: invokestatic 77	com/tencent/qphone/base/util/QLog:access$302	(Lcom/tencent/qphone/base/util/QLog$b;)Lcom/tencent/qphone/base/util/QLog$b;
      //   98: pop
      //   99: aload_1
      //   100: monitorexit
      //   101: getstatic 52	com/tencent/qphone/base/util/QLog:sWriteHandler	Lcom/tencent/qphone/base/util/QLog$c;
      //   104: iconst_3
      //   105: invokevirtual 56	com/tencent/qphone/base/util/QLog$c:removeMessages	(I)V
      //   108: getstatic 52	com/tencent/qphone/base/util/QLog:sWriteHandler	Lcom/tencent/qphone/base/util/QLog$c;
      //   111: iconst_3
      //   112: ldc2_w 17
      //   115: invokevirtual 81	com/tencent/qphone/base/util/QLog$c:sendEmptyMessageDelayed	(IJ)Z
      //   118: pop
      //   119: return
      //   120: astore_1
      //   121: aload_1
      //   122: invokevirtual 85	java/lang/Exception:printStackTrace	()V
      //   125: invokestatic 64	com/tencent/qphone/base/util/QLog:access$000	()I
      //   128: istore_3
      //   129: ldc 26
      //   131: new 87	java/lang/StringBuilder
      //   134: dup
      //   135: invokespecial 89	java/lang/StringBuilder:<init>	()V
      //   138: ldc 28
      //   140: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   143: iload_3
      //   144: invokevirtual 96	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   147: ldc 98
      //   149: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   152: invokestatic 102	com/tencent/qphone/base/util/QLog:access$100	()[I
      //   155: iload_3
      //   156: iaload
      //   157: invokevirtual 96	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   160: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   163: invokestatic 34	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
      //   166: pop
      //   167: getstatic 52	com/tencent/qphone/base/util/QLog:sWriteHandler	Lcom/tencent/qphone/base/util/QLog$c;
      //   170: iconst_1
      //   171: invokevirtual 56	com/tencent/qphone/base/util/QLog$c:removeMessages	(I)V
      //   174: getstatic 52	com/tencent/qphone/base/util/QLog:sWriteHandler	Lcom/tencent/qphone/base/util/QLog$c;
      //   177: iconst_1
      //   178: invokestatic 102	com/tencent/qphone/base/util/QLog:access$100	()[I
      //   181: iload_3
      //   182: iaload
      //   183: ldc 106
      //   185: imul
      //   186: i2l
      //   187: invokevirtual 81	com/tencent/qphone/base/util/QLog$c:sendEmptyMessageDelayed	(IJ)Z
      //   190: pop
      //   191: getstatic 52	com/tencent/qphone/base/util/QLog:sWriteHandler	Lcom/tencent/qphone/base/util/QLog$c;
      //   194: iconst_3
      //   195: invokevirtual 56	com/tencent/qphone/base/util/QLog$c:removeMessages	(I)V
      //   198: getstatic 52	com/tencent/qphone/base/util/QLog:sWriteHandler	Lcom/tencent/qphone/base/util/QLog$c;
      //   201: astore_1
      //   202: invokestatic 64	com/tencent/qphone/base/util/QLog:access$000	()I
      //   205: ifne +8 -> 213
      //   208: ldc2_w 107
      //   211: lstore 5
      //   213: aload_1
      //   214: iconst_3
      //   215: lload 5
      //   217: invokevirtual 81	com/tencent/qphone/base/util/QLog$c:sendEmptyMessageDelayed	(IJ)Z
      //   220: pop
      //   221: iload_3
      //   222: iconst_1
      //   223: iadd
      //   224: istore 4
      //   226: iload 4
      //   228: istore_3
      //   229: iload 4
      //   231: invokestatic 102	com/tencent/qphone/base/util/QLog:access$100	()[I
      //   234: arraylength
      //   235: if_icmplt +5 -> 240
      //   238: iconst_1
      //   239: istore_3
      //   240: iload_3
      //   241: invokestatic 48	com/tencent/qphone/base/util/QLog:access$002	(I)I
      //   244: pop
      //   245: return
      //   246: astore_2
      //   247: aload_1
      //   248: monitorexit
      //   249: aload_2
      //   250: athrow
      //   251: invokestatic 112	com/tencent/qphone/base/util/QLog:access$500	()Z
      //   254: ifeq +22 -> 276
      //   257: getstatic 52	com/tencent/qphone/base/util/QLog:sWriteHandler	Lcom/tencent/qphone/base/util/QLog$c;
      //   260: iconst_1
      //   261: invokevirtual 56	com/tencent/qphone/base/util/QLog$c:removeMessages	(I)V
      //   264: getstatic 52	com/tencent/qphone/base/util/QLog:sWriteHandler	Lcom/tencent/qphone/base/util/QLog$c;
      //   267: iconst_1
      //   268: ldc2_w 113
      //   271: invokevirtual 81	com/tencent/qphone/base/util/QLog$c:sendEmptyMessageDelayed	(IJ)Z
      //   274: pop
      //   275: return
      //   276: getstatic 52	com/tencent/qphone/base/util/QLog:sWriteHandler	Lcom/tencent/qphone/base/util/QLog$c;
      //   279: iconst_2
      //   280: invokevirtual 56	com/tencent/qphone/base/util/QLog$c:removeMessages	(I)V
      //   283: getstatic 52	com/tencent/qphone/base/util/QLog:sWriteHandler	Lcom/tencent/qphone/base/util/QLog$c;
      //   286: iconst_2
      //   287: ldc2_w 113
      //   290: invokevirtual 81	com/tencent/qphone/base/util/QLog$c:sendEmptyMessageDelayed	(IJ)Z
      //   293: pop
      //   294: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	295	0	this	c
      //   246	4	2	localObject	Object
      //   128	113	3	i	int
      //   224	12	4	j	int
      //   3	213	5	l	long
      // Exception table:
      //   from	to	target	type
      //   37	71	120	java/lang/Exception
      //   91	101	246	finally
      //   247	249	246	finally
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\qphone\base\util\QLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */