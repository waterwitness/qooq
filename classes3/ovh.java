import VACDReport.ReportHeader;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ovh
  implements Runnable
{
  public ovh(VACDReportMgr paramVACDReportMgr, List paramList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      if (QLog.isColorLevel()) {
        QLog.i("VACDReport", 2, "handleReponse headers is null or empty");
      }
    }
    ArrayList localArrayList;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("VACDReport", 2, "handleReponse headers size = " + this.jdField_a_of_type_JavaUtilList.size());
      }
      localArrayList = new ArrayList(8);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        ReportHeader localReportHeader = (ReportHeader)localIterator.next();
        if ((localReportHeader != null) && (localReportHeader.result == 0)) {
          localArrayList.add(Long.valueOf(localReportHeader.seqno));
        }
      }
    } while (localArrayList.isEmpty());
    VACDReportMgr.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletReportVACDReportMgr).a(localArrayList);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ovh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */