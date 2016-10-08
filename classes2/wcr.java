import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.QQCustomSplitDialog;

public class wcr
  implements View.OnClickListener
{
  public wcr(QQCustomSplitDialog paramQQCustomSplitDialog, DialogInterface.OnClickListener paramOnClickListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomSplitDialog, 0);
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomSplitDialog.dismiss();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wcr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */