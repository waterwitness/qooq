import android.view.View;
import com.tencent.mobileqq.activity.SubAccountUgActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.subaccount.SubAccountProtocManager;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class moc
  implements ActionSheet.OnButtonClickListener
{
  public moc(SubAccountUgActivity paramSubAccountUgActivity, ActionSheet paramActionSheet)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
      do
      {
        return;
      } while (!this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountUgActivity.b());
      this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountUgActivity.a(2131370579);
      this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountUgActivity.jdField_b_of_type_Boolean = true;
      paramView = (SubAccountProtocManager)this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountUgActivity.app.getManager(27);
      if (paramView != null) {
        paramView.a(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountUgActivity.jdField_b_of_type_JavaLangString);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\moc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */