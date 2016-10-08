import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.viareport.ReportManager;

public class wun
  implements Runnable
{
  public wun(ReportManager paramReportManager, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentOpenBusinessViareportReportManager.a) {
      LogUtility.b("viareport", "isUploading ---return");
    }
    while (!this.jdField_a_of_type_ComTencentOpenBusinessViareportReportManager.a(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.jdField_a_of_type_ComTencentOpenBusinessViareportReportManager.a(this.jdField_a_of_type_JavaLangString, null, true);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wun.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */