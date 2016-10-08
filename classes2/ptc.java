import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.apollo.view.ApolloInfo;
import com.tencent.mobileqq.apollo.view.ApolloLinearLayout.ViewHolder;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class ptc
  implements Runnable
{
  public ptc(ApolloPanel paramApolloPanel, ApolloLinearLayout.ViewHolder paramViewHolder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayout$ViewHolder == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayout$ViewHolder.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.a == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.a.a == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayout$ViewHolder.jdField_a_of_type_AndroidWidgetImageView == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "holder.apolloInfo == null");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayout$ViewHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayout$ViewHolder.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.a.a, this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.a.a.getResources().getDisplayMetrics().density));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ptc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */