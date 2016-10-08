import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.LbsBaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lqj
  implements DialogInterface.OnDismissListener
{
  public lqj(LbsBaseActivity paramLbsBaseActivity, Runnable paramRunnable)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (!LbsBaseActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLbsBaseActivity))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityLbsBaseActivity.d();
      return;
    }
    LbsBaseActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLbsBaseActivity, this.jdField_a_of_type_JavaLangRunnable);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lqj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */