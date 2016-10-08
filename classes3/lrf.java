import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.mobileqq.statistics.StatisticCollector;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.ReportInfo;
import java.util.HashMap;

public class lrf
  implements Runnable
{
  public lrf(Leba paramLeba, LebaViewItem paramLebaViewItem)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityLeba.a(null, -1, this.jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem);
    Object localObject = (QZoneManagerImp)this.jdField_a_of_type_ComTencentMobileqqActivityLeba.a.getManager(9);
    if ((localObject != null) && (((QZoneManagerImp)localObject).a(1) <= 0) && (((QZoneManagerImp)localObject).a(2) <= 0))
    {
      localObject = new QZoneClickReport.ReportInfo();
      ((QZoneClickReport.ReportInfo)localObject).c = "1";
      ((QZoneClickReport.ReportInfo)localObject).d = "0";
      ((QZoneClickReport.ReportInfo)localObject).b = 4;
      ((QZoneClickReport.ReportInfo)localObject).k = "3";
      ((QZoneClickReport.ReportInfo)localObject).l = "mainEntrance";
      ((QZoneClickReport.ReportInfo)localObject).m = "activefeed";
      QZoneClickReport.report(this.jdField_a_of_type_ComTencentMobileqqActivityLeba.a.getAccount(), (QZoneClickReport.ReportInfo)localObject, false);
      localObject = new HashMap();
      ((HashMap)localObject).put("source_type", "3");
      ((HashMap)localObject).put("source_from", "mainEntrance");
      ((HashMap)localObject).put("source_to", "activefeed");
      StatisticCollector.a(BaseApplicationImpl.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqActivityLeba.a.getAccount(), "actQZSourceDataReport", true, 0L, 0L, (HashMap)localObject, null);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lrf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */