import com.tencent.mobileqq.activity.DialogActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class lfn
  implements Runnable
{
  public lfn(DialogActivity paramDialogActivity, QQCustomDialog paramQQCustomDialog)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    DialogActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDialogActivity, this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lfn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */