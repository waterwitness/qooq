import android.view.View;
import com.tencent.mobileqq.activity.ChatHistoryFileActivity;
import com.tencent.mobileqq.activity.ChatHistoryViewBase;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class kwk
  implements ActionSheet.OnButtonClickListener
{
  public kwk(ChatHistoryFileActivity paramChatHistoryFileActivity, ActionSheet paramActionSheet)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((!this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a(3, this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.b, this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.c)) || (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryViewBase.a(ChatHistoryFileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kwk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */