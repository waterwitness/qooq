package com.tencent.mobileqq.statistics;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class StatisticHitRateCollector
{
  public static StatisticHitRateCollector a;
  public static final String a = "actQZLoadHitRateRed";
  public static final String b = "actQZLoadHitRateLeba";
  public static final String c = "actQZLoadHitRateProfile";
  public Map a;
  public Map b = new ConcurrentHashMap();
  private String d;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ComTencentMobileqqStatisticsStatisticHitRateCollector = new StatisticHitRateCollector("qzone");
  }
  
  public StatisticHitRateCollector(String paramString)
  {
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    this.d = ("StatisticHitRateCollector_" + paramString);
  }
  
  public static StatisticHitRateCollector a()
  {
    return jdField_a_of_type_ComTencentMobileqqStatisticsStatisticHitRateCollector;
  }
  
  public static String a()
  {
    AppRuntime localAppRuntime = null;
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.a();
    if (localBaseApplicationImpl != null) {
      localAppRuntime = localBaseApplicationImpl.a();
    }
    if (localAppRuntime == null) {
      return "0";
    }
    if (localAppRuntime.getAccount() == null) {
      return "0";
    }
    return localAppRuntime.getAccount();
  }
  
  public void a(String paramString)
  {
    a(paramString, "actQZLoadHitRateRed");
  }
  
  public void a(String paramString1, String paramString2)
  {
    Boolean localBoolean = (Boolean)this.jdField_a_of_type_JavaUtilMap.get(paramString2);
    if ((localBoolean == null) || (!localBoolean.booleanValue()))
    {
      localBoolean = (Boolean)this.b.get(paramString2);
      if ((localBoolean != null) && (localBoolean.booleanValue()))
      {
        this.jdField_a_of_type_JavaUtilMap.put(paramString2, Boolean.valueOf(true));
        if (QLog.isColorLevel()) {
          QLog.d(this.d, 2, "hitEnd sucess action = " + paramString2 + " , hit = true" + ", uin = " + paramString1);
        }
        StatisticCollector.a(BaseApplicationImpl.getContext()).a(paramString1, paramString2, true, 0L, 0L, null, null);
        this.jdField_a_of_type_JavaUtilMap.remove(paramString2);
        this.b.remove(paramString2);
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.d, 2, "preloadMark preloadAction = " + paramString + " , flag = " + paramBoolean);
    }
    if (paramBoolean) {
      b(a(), paramString);
    }
    this.jdField_a_of_type_JavaUtilMap.put(paramString, Boolean.valueOf(false));
    this.b.put(paramString, Boolean.valueOf(true));
  }
  
  public void b(String paramString)
  {
    a(paramString, "actQZLoadHitRateLeba");
  }
  
  public void b(String paramString1, String paramString2)
  {
    if (paramString2 != null)
    {
      Boolean localBoolean = (Boolean)this.jdField_a_of_type_JavaUtilMap.get(paramString2);
      if ((localBoolean == null) || (!localBoolean.booleanValue()))
      {
        localBoolean = (Boolean)this.b.get(paramString2);
        if ((localBoolean != null) && (localBoolean.booleanValue()))
        {
          this.jdField_a_of_type_JavaUtilMap.put(paramString2, Boolean.valueOf(true));
          if (QLog.isColorLevel()) {
            QLog.d(this.d, 2, "hitEnd action = " + paramString2 + " , hit = false" + ", uin = " + paramString1);
          }
          StatisticCollector.a(BaseApplicationImpl.getContext()).a(paramString1, paramString2, false, 0L, 0L, null, null);
          this.jdField_a_of_type_JavaUtilMap.remove(paramString2);
          this.b.remove(paramString2);
        }
      }
    }
  }
  
  public void c(String paramString)
  {
    a(paramString, "actQZLoadHitRateProfile");
  }
  
  public void d(String paramString)
  {
    Iterator localIterator = this.b.keySet().iterator();
    while (localIterator.hasNext()) {
      b(paramString, (String)localIterator.next());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\statistics\StatisticHitRateCollector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */