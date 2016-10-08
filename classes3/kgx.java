import android.app.Dialog;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class kgx
  implements Runnable
{
  kgx(kgw paramkgw)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = 0;
    try
    {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.jdField_a_of_type_AndroidWidgetLinearLayout.removeViewAt(this.a.jdField_a_of_type_Int);
      if (!this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.b) {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.a(false);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.jdField_a_of_type_AndroidViewView = null;
      int j = this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      while (i < j)
      {
        View localView = this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
        if (localView.getTag() != null) {
          localView.setTag(Integer.valueOf(i));
        }
        i += 1;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.jdField_a_of_type_AndroidAppDialog.dismiss();
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kgx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */