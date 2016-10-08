import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.QQCustomDialogThreeBtns;

public class wby
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  
  public wby(QQCustomDialogThreeBtns paramQQCustomDialogThreeBtns, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogThreeBtns.a != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogThreeBtns.a.onClick(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogThreeBtns, this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogThreeBtns.a(this.jdField_a_of_type_Int));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogThreeBtns.dismiss();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\wby.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */