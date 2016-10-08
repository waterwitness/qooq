package com.tencent.proxyinner.utility;

import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class NowPerfUtil
{
  static boolean sEnabelPerflog;
  static List sSteps;
  static long stimeStart = 0L;
  
  static
  {
    if (UtilMisc.isTestEnv("Live")) {}
    for (boolean bool = true;; bool = false)
    {
      sEnabelPerflog = bool;
      sSteps = new ArrayList();
      return;
    }
  }
  
  public static void dumpAll()
  {
    if (sEnabelPerflog)
    {
      String str = "";
      long l = 0L;
      int i = 0;
      if (i < sSteps.size())
      {
        StepInfo localStepInfo = (StepInfo)sSteps.get(i);
        if (i == 0)
        {
          Log.i("NowPerf", ">>>" + localStepInfo.info);
          str = ">>>" + localStepInfo.info + "time = " + localStepInfo.time + "\r\n";
        }
        for (l = stimeStart;; l = localStepInfo.time)
        {
          i += 1;
          break;
          str = str + " time=" + (localStepInfo.time - stimeStart) + ",timeSpan=" + (localStepInfo.time - l) + ",step=" + localStepInfo.info + "timestamp = " + localStepInfo.time + "\r\n";
        }
      }
      new Thread(new Runnable()
      {
        public void run()
        {
          try
          {
            RandomAccessFile localRandomAccessFile = new RandomAccessFile(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + "perflog.txt", "rw");
            localRandomAccessFile.seek(localRandomAccessFile.length());
            localRandomAccessFile.writeUTF(this.val$finalStr_write);
            localRandomAccessFile.close();
            return;
          }
          catch (FileNotFoundException localFileNotFoundException)
          {
            localFileNotFoundException.printStackTrace();
            return;
          }
          catch (IOException localIOException)
          {
            localIOException.printStackTrace();
          }
        }
      }).start();
    }
  }
  
  public static void reset()
  {
    sSteps.clear();
  }
  
  public static void start(String paramString)
  {
    if (sEnabelPerflog)
    {
      stimeStart = System.currentTimeMillis();
      sSteps.clear();
      sSteps.add(new StepInfo(paramString, stimeStart));
    }
  }
  
  public static void step(String paramString)
  {
    if ((!sEnabelPerflog) || (sSteps.size() <= 0)) {
      return;
    }
    long l = System.currentTimeMillis();
    sSteps.add(new StepInfo(paramString, l));
  }
  
  static final class StepInfo
  {
    public String info;
    public long time;
    
    public StepInfo(String paramString, long paramLong)
    {
      this.info = paramString;
      this.time = paramLong;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\proxyinner\utility\NowPerfUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */