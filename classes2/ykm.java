import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.ReportInfo;

public final class ykm
  implements Runnable
{
  public ykm(String paramString, QZoneClickReport.ReportInfo paramReportInfo, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QZoneClickReport.access$000(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_CooperationQzoneQZoneClickReport$ReportInfo, this.jdField_a_of_type_Boolean);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ykm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */