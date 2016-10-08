import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.QQCustomSplitDialog;

public class wcu
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  
  public wcu(QQCustomSplitDialog paramQQCustomSplitDialog, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomSplitDialog.a != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomSplitDialog.a.onClick(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomSplitDialog, this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomSplitDialog.a(this.jdField_a_of_type_Int));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomSplitDialog.dismiss();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wcu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */