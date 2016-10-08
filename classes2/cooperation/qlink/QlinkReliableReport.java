package cooperation.qlink;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import yev;
import yew;

public class QlinkReliableReport
{
  private static QlinkReliableReport jdField_a_of_type_CooperationQlinkQlinkReliableReport;
  private static final String jdField_a_of_type_JavaLangString = "QlinkReliableReport";
  private final Object jdField_a_of_type_JavaLangObject;
  private List jdField_a_of_type_JavaUtilList;
  private Timer jdField_a_of_type_JavaUtilTimer;
  
  public QlinkReliableReport()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangObject = new Object();
  }
  
  public static QlinkReliableReport a()
  {
    if (jdField_a_of_type_CooperationQlinkQlinkReliableReport == null) {}
    try
    {
      if (jdField_a_of_type_CooperationQlinkQlinkReliableReport == null) {
        jdField_a_of_type_CooperationQlinkQlinkReliableReport = new QlinkReliableReport();
      }
      return jdField_a_of_type_CooperationQlinkQlinkReliableReport;
    }
    finally {}
  }
  
  public static void a()
  {
    QlinkReliableReport localQlinkReliableReport = a();
    if (localQlinkReliableReport != null) {
      localQlinkReliableReport.e();
    }
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2, HashMap paramHashMap)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QlinkReliableReport", 2, "collectPerformance:tagName[" + paramString2 + "]");
    }
    QlinkReliableReport localQlinkReliableReport = a();
    if (localQlinkReliableReport != null) {
      localQlinkReliableReport.a(new yew(paramString1, paramString2, paramBoolean, paramLong1, paramLong2, paramHashMap));
    }
  }
  
  private void a(yew paramyew)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QlinkReliableReport", 2, "addPerformanceReporting:" + paramyew);
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilList == null) {
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
      }
      this.jdField_a_of_type_JavaUtilList.add(paramyew);
      return;
    }
  }
  
  public static void b()
  {
    QlinkReliableReport localQlinkReliableReport = a();
    if (localQlinkReliableReport != null) {
      localQlinkReliableReport.f();
    }
  }
  
  private static void h()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QlinkReliableReport", 2, "start:");
    }
    QlinkReliableReport localQlinkReliableReport = a();
    if (localQlinkReliableReport != null) {
      localQlinkReliableReport.i();
    }
  }
  
  private void i()
  {
    if (!NetworkUtil.e(BaseApplication.getContext())) {
      if (QLog.isDevelopLevel()) {
        QLog.d("QlinkReliableReport", 2, "doReportPerformance: network is not surpport");
      }
    }
    for (;;)
    {
      return;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        List localList = this.jdField_a_of_type_JavaUtilList;
        this.jdField_a_of_type_JavaUtilList = null;
        if ((localList != null) && (localList.size() != 0))
        {
          ??? = StatisticCollector.a(BaseApplication.getContext());
          Iterator localIterator = localList.iterator();
          if (localIterator.hasNext())
          {
            yew localyew = (yew)localIterator.next();
            ((StatisticCollector)???).a(localyew.a(), localyew.b(), localyew.a(), localyew.a(), localyew.b(), localyew.a(), null);
          }
        }
      }
    }
    ((List)localObject1).clear();
  }
  
  protected void c() {}
  
  protected void d()
  {
    f();
    try
    {
      jdField_a_of_type_CooperationQlinkQlinkReliableReport = null;
      return;
    }
    finally {}
  }
  
  public void e()
  {
    QLog.d("QlinkReliableReport", 2, "doStartReportTimer");
    if (this.jdField_a_of_type_JavaUtilTimer == null)
    {
      this.jdField_a_of_type_JavaUtilTimer = new Timer();
      this.jdField_a_of_type_JavaUtilTimer.schedule(new yev(this), 60000L);
    }
  }
  
  public void f()
  {
    QLog.d("QlinkReliableReport", 2, "doStopReportTimer");
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qlink\QlinkReliableReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */