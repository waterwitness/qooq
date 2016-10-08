package cooperation.qzone;

import android.os.SystemClock;
import android.widget.Toast;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;
import ykm;
import ykn;

public class QZoneClickReport
{
  public static final String ALL_REPORT = "全量上报";
  public static final String CLICK_MESSAGE = "点击统计上报信息: ";
  public static final String NOT_HIT = ",没命中,今天命中的QQ尾号是：";
  public static final String SAMPLE_REPORT = "抽样上报";
  private static String TAG;
  private static boolean isSampled;
  public static boolean isShowToast;
  public static int reportAmount;
  public static int reportRate;
  public static int reportSampleRate;
  private static long sampleValidEndTime;
  private static long sampleValidStartTime;
  private static long startTime = SystemClock.uptimeMillis();
  private static ArrayList storedClicks;
  public static Toast toast;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    TAG = QZoneClickReport.class.getSimpleName();
    storedClicks = new ArrayList();
  }
  
  private static void clearUserSample()
  {
    isSampled = false;
    sampleValidStartTime = 0L;
    sampleValidEndTime = 0L;
  }
  
  private static long getBeijingTimeInMillis(int paramInt1, int paramInt2, int paramInt3)
  {
    return getBeijingTimeInMillis(0, 0, 0, paramInt1, paramInt2, paramInt3);
  }
  
  private static long getBeijingTimeInMillis(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    Calendar localCalendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
    if ((paramInt1 != 0) || (paramInt2 != 0) || (paramInt3 != 0))
    {
      localCalendar.set(1, paramInt1);
      localCalendar.set(2, paramInt2);
      localCalendar.set(5, paramInt3);
    }
    localCalendar.set(11, paramInt4);
    localCalendar.set(12, paramInt5);
    localCalendar.set(13, paramInt6);
    localCalendar.set(14, 0);
    return localCalendar.getTimeInMillis();
  }
  
  public static int getDaysSince1970()
  {
    return (int)((System.currentTimeMillis() - getBeijingTimeInMillis(1970, 0, 1, 0, 0, 0)) / 1000L / 60L / 60L / 24L);
  }
  
  private static long getLong(String paramString, long paramLong)
  {
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (Exception localException)
    {
      QLog.e(TAG, 2, "long string(" + paramString + ") is ill-format, return default value " + paramLong);
    }
    return paramLong;
  }
  
  private static boolean isNeedReport(String paramString)
  {
    
    if (!isTodayTime(System.currentTimeMillis())) {
      userSample(paramString);
    }
    return isSampled;
  }
  
  private static boolean isTodayTime(long paramLong)
  {
    return (sampleValidStartTime != 0L) && (sampleValidEndTime != 0L) && (paramLong >= sampleValidStartTime) && (paramLong < sampleValidEndTime);
  }
  
  public static void report(String paramString, QZoneClickReport.ReportInfo paramReportInfo, boolean paramBoolean)
  {
    ThreadManager.d(new ykm(paramString, paramReportInfo, paramBoolean));
  }
  
  public static void report(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean)
  {
    QZoneClickReport.ReportInfo localReportInfo = new QZoneClickReport.ReportInfo();
    localReportInfo.a = getLong(paramString1, 0L);
    localReportInfo.c = paramString2;
    localReportInfo.d = paramString3;
    localReportInfo.e = paramString4;
    localReportInfo.f = paramString5;
    if (QLog.isColorLevel()) {}
    try
    {
      QLog.i(TAG, 1, localReportInfo.a().toString());
      ThreadManager.d(new ykn(paramString1, localReportInfo, paramBoolean));
      return;
    }
    catch (JSONException paramString2)
    {
      for (;;)
      {
        QLog.e(TAG, 1, "", paramString2);
      }
    }
  }
  
  private static void reportSync(String paramString, QZoneClickReport.ReportInfo paramReportInfo, boolean paramBoolean)
  {
    showToast(paramReportInfo, paramBoolean, paramString);
    if ((!paramBoolean) && (!isNeedReport(paramString))) {}
    for (;;)
    {
      return;
      long l1 = SystemClock.uptimeMillis();
      long l2 = startTime;
      int i = QzoneConfig.a().a("ReportSetting", "TraceReportInterval", 600);
      int j = QzoneConfig.a().a("ReportSetting", "TraceReportCount", 20);
      synchronized (storedClicks)
      {
        storedClicks.add(paramReportInfo);
        if (!paramBoolean)
        {
          if ((storedClicks.size() < j) && ((l1 - l2 < i * 1000) || (storedClicks.size() <= 0))) {
            continue;
          }
          startReportImediately(paramString);
        }
      }
    }
    startReportImediately(paramString);
  }
  
  public static void showToast(QZoneClickReport.ReportInfo paramReportInfo, boolean paramBoolean, String paramString) {}
  
  public static void startReportImediately(String paramString)
  {
    if (storedClicks.isEmpty()) {}
    for (;;)
    {
      return;
      synchronized (storedClicks)
      {
        ArrayList localArrayList2 = new ArrayList(storedClicks);
        storedClicks.clear();
        startTime = SystemClock.uptimeMillis();
        long l = getLong(paramString, 0L);
        if (l <= 0L) {
          continue;
        }
        new QZoneClickReport.ReportRunnable(localArrayList2, l).run();
        return;
      }
    }
  }
  
  public static void startReportImediately(String paramString, QZoneClickReport.ReportInfo paramReportInfo)
  {
    long l = getLong(paramString, 0L);
    if (l > 0L)
    {
      showToast(paramReportInfo, true, paramString);
      paramString = new ArrayList();
      paramString.add(paramReportInfo);
      ThreadManager.d(new QZoneClickReport.ReportRunnable(paramString, l));
    }
  }
  
  public static void startReportImediately(String paramString1, String paramString2, String paramString3)
  {
    long l = getLong(paramString1, 0L);
    if (l > 0L)
    {
      QZoneClickReport.ReportInfo localReportInfo = new QZoneClickReport.ReportInfo();
      localReportInfo.c(paramString2);
      localReportInfo.a(l);
      localReportInfo.d(paramString3);
      startReportImediately(paramString1, localReportInfo);
    }
  }
  
  private static void userSample(String paramString)
  {
    int i = QzoneConfig.a().a("ReportSetting", "TraceReportSamples", 100);
    long l1 = getDaysSince1970();
    if (i == 0) {
      isSampled = false;
    }
    long l2;
    do
    {
      sampleValidStartTime = getBeijingTimeInMillis(0, 0, 0);
      sampleValidEndTime = getBeijingTimeInMillis(24, 0, 0);
      return;
      l2 = getLong(paramString, 0L);
    } while (l2 <= 0L);
    int j = (int)(l1 % i);
    if (j == l2 % i) {}
    for (boolean bool = true;; bool = false)
    {
      isSampled = bool;
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.d(TAG, 4, "抽中的尾数： " + j);
      break;
    }
  }
  
  /* Error */
  public static byte[] zip(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: aload_0
    //   7: invokevirtual 301	java/lang/String:getBytes	()[B
    //   10: astore_1
    //   11: iconst_0
    //   12: newarray <illegal type>
    //   14: astore_0
    //   15: new 303	java/util/zip/Deflater
    //   18: dup
    //   19: invokespecial 304	java/util/zip/Deflater:<init>	()V
    //   22: astore_3
    //   23: aload_3
    //   24: invokevirtual 307	java/util/zip/Deflater:reset	()V
    //   27: aload_3
    //   28: aload_1
    //   29: invokevirtual 311	java/util/zip/Deflater:setInput	([B)V
    //   32: aload_3
    //   33: invokevirtual 314	java/util/zip/Deflater:finish	()V
    //   36: new 316	java/io/ByteArrayOutputStream
    //   39: dup
    //   40: aload_1
    //   41: arraylength
    //   42: invokespecial 319	java/io/ByteArrayOutputStream:<init>	(I)V
    //   45: astore 4
    //   47: sipush 1024
    //   50: newarray <illegal type>
    //   52: astore_2
    //   53: aload_3
    //   54: invokevirtual 322	java/util/zip/Deflater:finished	()Z
    //   57: ifne +32 -> 89
    //   60: aload 4
    //   62: aload_2
    //   63: iconst_0
    //   64: aload_3
    //   65: aload_2
    //   66: invokevirtual 326	java/util/zip/Deflater:deflate	([B)I
    //   69: invokevirtual 330	java/io/ByteArrayOutputStream:write	([BII)V
    //   72: goto -19 -> 53
    //   75: astore_0
    //   76: aload 4
    //   78: invokevirtual 333	java/io/ByteArrayOutputStream:close	()V
    //   81: aload_1
    //   82: astore_0
    //   83: aload_3
    //   84: invokevirtual 336	java/util/zip/Deflater:end	()V
    //   87: aload_0
    //   88: areturn
    //   89: aload 4
    //   91: invokevirtual 339	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   94: astore_2
    //   95: aload_2
    //   96: astore_0
    //   97: aload 4
    //   99: invokevirtual 333	java/io/ByteArrayOutputStream:close	()V
    //   102: goto -19 -> 83
    //   105: astore_1
    //   106: goto -23 -> 83
    //   109: astore_1
    //   110: aload 4
    //   112: invokevirtual 333	java/io/ByteArrayOutputStream:close	()V
    //   115: goto -32 -> 83
    //   118: astore_1
    //   119: goto -36 -> 83
    //   122: astore_0
    //   123: aload 4
    //   125: invokevirtual 333	java/io/ByteArrayOutputStream:close	()V
    //   128: aload_0
    //   129: athrow
    //   130: astore_0
    //   131: aload_1
    //   132: astore_0
    //   133: goto -50 -> 83
    //   136: astore_1
    //   137: goto -9 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	paramString	String
    //   10	72	1	arrayOfByte1	byte[]
    //   105	1	1	localIOException1	java.io.IOException
    //   109	1	1	localOutOfMemoryError	OutOfMemoryError
    //   118	14	1	localIOException2	java.io.IOException
    //   136	1	1	localIOException3	java.io.IOException
    //   52	44	2	arrayOfByte2	byte[]
    //   22	62	3	localDeflater	java.util.zip.Deflater
    //   45	79	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   47	53	75	java/lang/Exception
    //   53	72	75	java/lang/Exception
    //   89	95	75	java/lang/Exception
    //   97	102	105	java/io/IOException
    //   47	53	109	java/lang/OutOfMemoryError
    //   53	72	109	java/lang/OutOfMemoryError
    //   89	95	109	java/lang/OutOfMemoryError
    //   110	115	118	java/io/IOException
    //   47	53	122	finally
    //   53	72	122	finally
    //   89	95	122	finally
    //   76	81	130	java/io/IOException
    //   123	128	136	java/io/IOException
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\QZoneClickReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */