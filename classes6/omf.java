import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.messagesearch.C2CMessageResultAdapter;
import com.tencent.mobileqq.activity.messagesearch.C2CMessageSearchDialog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

public class omf
  implements AbsListView.OnScrollListener
{
  int jdField_a_of_type_Int;
  int b;
  int c;
  
  public omf(C2CMessageSearchDialog paramC2CMessageSearchDialog)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 0;
    this.b = 0;
    this.c = 0;
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i(C2CMessageSearchDialog.jdField_a_of_type_JavaLangString, 2, "onScrollStateChanged, reach bottom, scrollState " + paramInt + " firstVisibleItem: " + this.c + ", lastItem:" + this.jdField_a_of_type_Int + ", totalItemCount = " + this.b + ", mIsComplete: " + this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.d + ", requesting:" + this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.jdField_c_of_type_Boolean + ", mSearchMode: " + this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.t + ", mCurrentKeyword: " + this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.jdField_b_of_type_JavaLangString);
    }
    if (this.b == 0) {}
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_Int != this.b) || (paramInt != 0));
      if ((this.c != 0) && (!this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.jdField_c_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.jdField_c_of_type_Boolean = true;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.t == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.i(C2CMessageSearchDialog.jdField_a_of_type_JavaLangString, 2, "onScrollStateChanged searchRoamMessageLocal >>>>> isComplete: " + this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.d);
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageResultAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.jdField_b_of_type_JavaLangString, 2);
          this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.jdField_a_of_type_AndroidContentContext.getString(2131368129));
          this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.jdField_b_of_type_AndroidViewView.setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.jdField_c_of_type_AndroidWidgetLinearLayout.findViewById(2131303045).setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.i(C2CMessageSearchDialog.jdField_a_of_type_JavaLangString, 2, "onScrollStateChanged searchRoamMessageInCloud >>>>> isComplete: " + this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.d);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.d)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.jdField_c_of_type_AndroidWidgetTextView.setText("已展示全部搜索结果");
          this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.jdField_c_of_type_AndroidWidgetLinearLayout.findViewById(2131303045).setVisibility(8);
          this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.jdField_b_of_type_AndroidViewView.setVisibility(0);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.jdField_a_of_type_AndroidContentContext.getString(2131368125));
        this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.jdField_b_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.jdField_c_of_type_AndroidWidgetLinearLayout.findViewById(2131303045).setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.jdField_a_of_type_Long = System.currentTimeMillis();
        this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.b(2);
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "chat_history", "ChatSearch", "Slip_resultup", 0, 0, new String[0]);
        return;
      }
    } while ((this.c != 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.jdField_c_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.d) || (this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.t != 1));
    this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.jdField_c_of_type_AndroidWidgetTextView.setText("已展示全部搜索结果");
    this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.jdField_c_of_type_AndroidWidgetLinearLayout.findViewById(2131303045).setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.jdField_b_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.c = paramInt1;
    this.jdField_a_of_type_Int = (paramInt1 + paramInt2);
    this.b = paramInt3;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\omf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */