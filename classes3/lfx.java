import android.view.View;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class lfx
  implements ActionSheet.OnButtonClickListener
{
  public lfx(DiscussionInfoCardActivity paramDiscussionInfoCardActivity, ActionSheet paramActionSheet)
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
      if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()) && (!this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.isFinishing()))
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
        this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
      }
      return;
      ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity, DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity), null, this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.app.a(), 1107);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lfx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */