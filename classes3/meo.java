import android.os.Handler;
import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class meo
  implements AsyncBack
{
  int jdField_a_of_type_Int;
  
  public meo(QQMapActivity paramQQMapActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a(int paramInt)
  {
    if (paramInt - this.jdField_a_of_type_Int >= 1) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQMapActivity.a.post(new mep(this, paramInt));
    }
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQQMapActivity.C = 0;
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQMapActivity.a.post(new meq(this));
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "rec_locate", "click_tx_download", 0, 0, "", "", "", "");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityQQMapActivity.a.post(new mer(this));
    ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "rec_locate", "click_tx_download", 0, 1, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\meo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */