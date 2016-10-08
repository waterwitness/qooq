import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ProfilePerformanceReport;
import java.util.HashMap;

public class xrm
  implements Runnable
{
  public xrm(ProfilePerformanceReport paramProfilePerformanceReport, String paramString, long paramLong, HashMap paramHashMap)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    StatisticCollector.a(BaseApplicationImpl.getContext()).a(this.jdField_a_of_type_JavaLangString, ProfilePerformanceReport.a(this.jdField_a_of_type_ComTencentUtilProfilePerformanceReport), true, this.jdField_a_of_type_Long, 0L, this.jdField_a_of_type_JavaUtilHashMap, "");
    if (QLog.isDevelopLevel()) {
      QLog.i("ProfilePerformanceReport", 4, "end of report");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xrm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */