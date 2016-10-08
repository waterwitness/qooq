import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.LbsBaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;

public class lqf
  implements View.OnClickListener
{
  public lqf(LbsBaseActivity paramLbsBaseActivity, Runnable paramRunnable)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityLbsBaseActivity.getAppInterface().b("CliOper", "", "", "0X8004444", "0X8004444", 0, 0, "", "", "", "");
    if (NetworkUtil.e(BaseApplication.getContext()))
    {
      this.jdField_a_of_type_JavaLangRunnable.run();
      NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityLbsBaseActivity.getAppInterface().getAccount(), false);
      if ((LbsBaseActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLbsBaseActivity) != null) && (LbsBaseActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLbsBaseActivity).isShowing())) {
        LbsBaseActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLbsBaseActivity).dismiss();
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityLbsBaseActivity.a(1, 2131367481);
    } while ((LbsBaseActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLbsBaseActivity) == null) || (!LbsBaseActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLbsBaseActivity).isShowing()));
    LbsBaseActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLbsBaseActivity).dismiss();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lqf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */