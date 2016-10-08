package com.tencent.util;

import android.text.TextUtils;
import com.tencent.view.FilterDefault;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

public class LogUtil
{
  public static final boolean ACQUIRE_FOCUS_STATE = false;
  public static boolean ENABLE_FPS = false;
  public static final String PROFILE_TAG = "profile";
  private static HashMap<String, Long> mTimeStampMap = new HashMap();
  private static Log sLog = null;
  
  public static int d(Object paramObject, String paramString)
  {
    if (FilterDefault.ENABLE_DEBUG)
    {
      paramObject = getTag(paramObject);
      if (sLog == null) {
        break label30;
      }
      sLog.d((String)paramObject, paramString, null);
    }
    label30:
    while (!enableLog(3, (String)paramObject)) {
      return 0;
    }
    return android.util.Log.d((String)paramObject, paramString);
  }
  
  public static int e(Object paramObject, String paramString)
  {
    if (FilterDefault.ENABLE_DEBUG)
    {
      paramObject = getTag(paramObject);
      if (sLog == null) {
        break label30;
      }
      sLog.e((String)paramObject, paramString, null);
    }
    label30:
    while (!enableLog(6, (String)paramObject)) {
      return 0;
    }
    return android.util.Log.e((String)paramObject, paramString);
  }
  
  public static int e(Object paramObject, String paramString, Throwable paramThrowable)
  {
    if (FilterDefault.ENABLE_DEBUG)
    {
      paramObject = getTag(paramObject);
      if (sLog == null) {
        break label30;
      }
      sLog.e((String)paramObject, paramString, paramThrowable);
    }
    label30:
    while (!enableLog(6, (String)paramObject)) {
      return 0;
    }
    return android.util.Log.e((String)paramObject, paramString, paramThrowable);
  }
  
  public static boolean enableLog(int paramInt, String paramString)
  {
    return FilterDefault.ENABLE_DEBUG;
  }
  
  public static Log getLog()
  {
    return sLog;
  }
  
  public static String getTag(Object paramObject)
  {
    if (paramObject == null) {
      return "filter process";
    }
    if ((paramObject instanceof String)) {
      return (String)paramObject;
    }
    return paramObject.getClass().getSimpleName();
  }
  
  public static int i(Object paramObject, String paramString)
  {
    if (FilterDefault.ENABLE_DEBUG)
    {
      paramObject = getTag(paramObject);
      if (sLog == null) {
        break label30;
      }
      sLog.i((String)paramObject, paramString, null);
    }
    label30:
    while (!enableLog(4, (String)paramObject)) {
      return 0;
    }
    return android.util.Log.i((String)paramObject, paramString);
  }
  
  public static void printTime(String paramString1, String paramString2)
  {
    if ((!FilterDefault.ENABLE_DEBUG) || (!FilterDefault.ENABLE_PROFILE) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      return;
      if (paramString2.contains("BEGIN"))
      {
        l1 = System.currentTimeMillis();
        mTimeStampMap.put(paramString1, Long.valueOf(l1));
        android.util.Log.i(paramString1, paramString2);
        return;
      }
    } while (!paramString2.contains("END"));
    long l1 = ((Long)mTimeStampMap.get(paramString1)).longValue();
    long l2 = System.currentTimeMillis();
    android.util.Log.i(paramString1, paramString2 + " = " + (l2 - l1));
  }
  
  public static void setLog(Log paramLog)
  {
    sLog = paramLog;
  }
  
  public static int v(Object paramObject, String paramString)
  {
    if (FilterDefault.ENABLE_DEBUG)
    {
      paramObject = getTag(paramObject);
      if (sLog == null) {
        break label30;
      }
      sLog.v((String)paramObject, paramString, null);
    }
    label30:
    while (!enableLog(2, (String)paramObject)) {
      return 0;
    }
    return android.util.Log.v((String)paramObject, paramString);
  }
  
  public static int w(Object paramObject, String paramString)
  {
    if (FilterDefault.ENABLE_DEBUG)
    {
      paramObject = getTag(paramObject);
      if (sLog == null) {
        break label30;
      }
      sLog.w((String)paramObject, paramString, null);
    }
    label30:
    while (!enableLog(5, (String)paramObject)) {
      return 0;
    }
    return android.util.Log.w((String)paramObject, paramString);
  }
  
  public static int writeLog(Object paramObject, String paramString)
  {
    if ((FilterDefault.ENABLE_DEBUG) && (FilterDefault.ENABLE_PROFILE))
    {
      paramObject = getTag(paramObject);
      if (!enableLog(5, (String)paramObject)) {}
    }
    try
    {
      paramString = paramString + "\n";
      long l = System.currentTimeMillis();
      FileOutputStream localFileOutputStream = new FileOutputStream("/mnt/sdcard/log.txt", true);
      localFileOutputStream.write((String.valueOf(l) + "--\t").getBytes());
      localFileOutputStream.write(((String)paramObject).getBytes());
      localFileOutputStream.write(new String("\t").getBytes());
      localFileOutputStream.write(paramString.getBytes());
      localFileOutputStream.flush();
      localFileOutputStream.close();
      return 0;
    }
    catch (FileNotFoundException paramObject)
    {
      for (;;)
      {
        ((FileNotFoundException)paramObject).printStackTrace();
      }
    }
    catch (IOException paramObject)
    {
      for (;;)
      {
        ((IOException)paramObject).printStackTrace();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\util\LogUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */