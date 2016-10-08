package com.tencent.biz.pubaccount.util;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class PublicTracker
{
  private static long jdField_a_of_type_Long = 0L;
  public static final String a = "SUBSCRIPT_FEEDS_COST";
  private static ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(new HashMap(8));
  public static final String b = "SUBSCRIPT_AIO_COST";
  public static final String c = "KANDIAN_FEEDS_COST";
  public static final String d = "KANDIAN_TO_SUBSCRIPT_COST";
  public static final String e = "LEBA_KANDIAN_FEEDS_COST";
  public static final String f = "SERVICE_FOLDER_COST";
  private static final String g = "PubAccAutoMonitor";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(String paramString1, String paramString2)
  {
    long l = SystemClock.uptimeMillis();
    if (paramString1 != null)
    {
      paramString2 = (Long)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString1);
      if (paramString2 != null)
      {
        jdField_a_of_type_Long = l - paramString2.longValue();
        QLog.i("PubAccAutoMonitor", 1, paramString1 + ", cost=" + jdField_a_of_type_Long);
        if (jdField_a_of_type_Long <= 10000L) {
          break label74;
        }
      }
    }
    label74:
    while (paramString2 == null)
    {
      do
      {
        return;
        if (TextUtils.equals(paramString1, "SUBSCRIPT_FEEDS_COST"))
        {
          StatisticCollector.a(BaseApplicationImpl.a()).a(null, "actSubscribeOpenCost", true, jdField_a_of_type_Long, 0L, null, null);
          return;
        }
        if (TextUtils.equals(paramString1, "SUBSCRIPT_AIO_COST"))
        {
          StatisticCollector.a(BaseApplicationImpl.a()).a(null, "actSubscribeAIOOpenCost", true, jdField_a_of_type_Long, 0L, null, null);
          return;
        }
        if (TextUtils.equals(paramString1, "KANDIAN_FEEDS_COST"))
        {
          StatisticCollector.a(BaseApplicationImpl.a()).a(null, "actKandianOpenCost", true, jdField_a_of_type_Long, 0L, null, null);
          return;
        }
        if (TextUtils.equals(paramString1, "KANDIAN_TO_SUBSCRIPT_COST"))
        {
          StatisticCollector.a(BaseApplicationImpl.a()).a(null, "actKandianToSubscribeCost", true, jdField_a_of_type_Long, 0L, null, null);
          return;
        }
      } while ((TextUtils.equals(paramString1, "LEBA_KANDIAN_FEEDS_COST")) || (!TextUtils.equals(paramString1, "SERVICE_FOLDER_COST")));
      StatisticCollector.a(BaseApplicationImpl.a()).a(null, "actServiceFolderToServiceNumListCost", true, jdField_a_of_type_Long, 0L, null, null);
      return;
    }
    jdField_a_of_type_Long = 0L;
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString2, Long.valueOf(l));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\util\PublicTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */