import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.viareport.BatchReportInfo;
import com.tencent.open.business.viareport.ReportDbHelper;
import com.tencent.open.business.viareport.ReportManager;

public class wum
  implements Runnable
{
  public wum(ReportManager paramReportManager, boolean paramBoolean, BatchReportInfo paramBatchReportInfo, Bundle paramBundle, String paramString)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    boolean bool = false;
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentOpenBusinessViareportBatchReportInfo == null)) {
      if ((this.jdField_a_of_type_AndroidOsBundle != null) && (this.jdField_a_of_type_ComTencentOpenBusinessViareportReportManager.b(this.jdField_a_of_type_AndroidOsBundle.getString("appid_for_getting_config")))) {
        this.jdField_a_of_type_ComTencentOpenBusinessViareportReportManager.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidOsBundle, false);
      }
    }
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentOpenBusinessViareportBatchReportInfo != null) && (this.jdField_a_of_type_ComTencentOpenBusinessViareportBatchReportInfo.a()) && (this.jdField_a_of_type_ComTencentOpenBusinessViareportReportManager.b(null))) {
        ReportDbHelper.a().a("table_new_data", this.jdField_a_of_type_ComTencentOpenBusinessViareportBatchReportInfo);
      }
      if (this.jdField_a_of_type_ComTencentOpenBusinessViareportReportManager.jdField_a_of_type_Boolean)
      {
        LogUtility.b("viareport", "isUploading ---return");
        return;
      }
    } while ((!this.jdField_a_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentOpenBusinessViareportReportManager.a(this.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_ComTencentOpenBusinessViareportReportManager.a()));
    ReportManager localReportManager = this.jdField_a_of_type_ComTencentOpenBusinessViareportReportManager;
    String str = this.jdField_a_of_type_JavaLangString;
    Bundle localBundle = this.jdField_a_of_type_AndroidOsBundle;
    if (this.jdField_a_of_type_ComTencentOpenBusinessViareportBatchReportInfo != null) {
      bool = true;
    }
    localReportManager.a(str, localBundle, bool);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */