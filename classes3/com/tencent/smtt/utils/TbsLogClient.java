package com.tencent.smtt.utils;

import android.os.Process;
import android.util.Log;
import android.widget.TextView;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Vector;

public class TbsLogClient
{
  static final String TBS_LOG_FILE = "tbslog.txt";
  static TbsLogClient intance = null;
  static File mLogFile = null;
  Vector<String> logMessage;
  TextView mView;
  private SimpleDateFormat time_formatter;
  
  /* Error */
  public TbsLogClient(android.content.Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 39	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: aconst_null
    //   6: putfield 41	com/tencent/smtt/utils/TbsLogClient:time_formatter	Ljava/text/SimpleDateFormat;
    //   9: aload_0
    //   10: new 43	java/text/SimpleDateFormat
    //   13: dup
    //   14: ldc 45
    //   16: getstatic 51	java/util/Locale:US	Ljava/util/Locale;
    //   19: invokespecial 54	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   22: putfield 41	com/tencent/smtt/utils/TbsLogClient:time_formatter	Ljava/text/SimpleDateFormat;
    //   25: getstatic 28	com/tencent/smtt/utils/TbsLogClient:mLogFile	Ljava/io/File;
    //   28: ifnonnull +29 -> 57
    //   31: invokestatic 60	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   34: ldc 62
    //   36: invokevirtual 68	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   39: ifeq +56 -> 95
    //   42: aload_1
    //   43: bipush 6
    //   45: invokestatic 74	com/tencent/smtt/utils/FileUtil:getTBSSdcardFilePath	(Landroid/content/Context;I)Ljava/lang/String;
    //   48: astore_1
    //   49: aload_1
    //   50: ifnonnull +25 -> 75
    //   53: aconst_null
    //   54: putstatic 28	com/tencent/smtt/utils/TbsLogClient:mLogFile	Ljava/io/File;
    //   57: return
    //   58: astore_2
    //   59: aload_0
    //   60: new 43	java/text/SimpleDateFormat
    //   63: dup
    //   64: ldc 45
    //   66: invokespecial 77	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   69: putfield 41	com/tencent/smtt/utils/TbsLogClient:time_formatter	Ljava/text/SimpleDateFormat;
    //   72: goto -47 -> 25
    //   75: new 79	java/io/File
    //   78: dup
    //   79: aload_1
    //   80: ldc 11
    //   82: invokespecial 82	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   85: putstatic 28	com/tencent/smtt/utils/TbsLogClient:mLogFile	Ljava/io/File;
    //   88: return
    //   89: astore_1
    //   90: aload_1
    //   91: invokevirtual 85	java/lang/SecurityException:printStackTrace	()V
    //   94: return
    //   95: aconst_null
    //   96: putstatic 28	com/tencent/smtt/utils/TbsLogClient:mLogFile	Ljava/io/File;
    //   99: return
    //   100: astore_1
    //   101: aload_1
    //   102: invokevirtual 86	java/lang/NullPointerException:printStackTrace	()V
    //   105: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	this	TbsLogClient
    //   0	106	1	paramContext	android.content.Context
    //   58	1	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   9	25	58	java/lang/Exception
    //   25	49	89	java/lang/SecurityException
    //   53	57	89	java/lang/SecurityException
    //   75	88	89	java/lang/SecurityException
    //   95	99	89	java/lang/SecurityException
    //   25	49	100	java/lang/NullPointerException
    //   53	57	100	java/lang/NullPointerException
    //   75	88	100	java/lang/NullPointerException
    //   95	99	100	java/lang/NullPointerException
  }
  
  public void d(String paramString1, String paramString2) {}
  
  public void e(String paramString1, String paramString2)
  {
    Log.e(paramString1, paramString2);
  }
  
  public void i(String paramString1, String paramString2) {}
  
  public void setLogView(TextView paramTextView)
  {
    this.mView = paramTextView;
  }
  
  public void showLog(String paramString)
  {
    if (this.mView != null) {
      this.mView.post(new LogRunnable(paramString));
    }
  }
  
  public void v(String paramString1, String paramString2) {}
  
  public void w(String paramString1, String paramString2) {}
  
  public void writeLog(String paramString)
  {
    if (mLogFile != null)
    {
      String str = this.time_formatter.format(Long.valueOf(System.currentTimeMillis()));
      LogFileUtils.writeDataToStorage(mLogFile, str + " pid=" + Process.myPid() + " " + paramString + "\n", true);
    }
  }
  
  private class LogRunnable
    implements Runnable
  {
    String mLog = null;
    
    LogRunnable(String paramString)
    {
      this.mLog = paramString;
    }
    
    public void run()
    {
      if (TbsLogClient.this.mView != null) {
        TbsLogClient.this.mView.append(this.mLog + "\n");
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\smtt\utils\TbsLogClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */