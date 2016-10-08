import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;
import java.util.ArrayList;
import java.util.List;

class wnm
  implements Runnable
{
  wnm(wnl paramwnl, List paramList1, List paramList2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = (TextView)this.jdField_a_of_type_Wnl.jdField_a_of_type_AndroidViewView.findViewById(2131302238);
    LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_Wnl.jdField_a_of_type_AndroidViewView.findViewById(2131302239);
    localLinearLayout.removeAllViews();
    StringBuilder localStringBuilder = new StringBuilder(24);
    localStringBuilder.append(this.jdField_a_of_type_Wnl.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.getContext().getString(2131369956));
    if ((this.jdField_a_of_type_Wnl.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Wnl.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(this.jdField_a_of_type_Wnl.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.jdField_a_of_type_JavaLangString)))
    {
      localObject = new ArrayList();
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        ((List)localObject).addAll(this.jdField_a_of_type_JavaUtilList);
        if (AppSetting.j)
        {
          localStringBuilder.append("你已开通");
          ProfileCardMoreInfoView.a(this.jdField_a_of_type_Wnl.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView, localStringBuilder, this.jdField_a_of_type_JavaUtilList);
        }
        if ((this.b != null) && (this.b.size() > 0)) {
          ((List)localObject).addAll(this.b);
        }
        ProfileCardMoreInfoView.a(this.jdField_a_of_type_Wnl.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView, (List)localObject, localLinearLayout);
      }
    }
    for (;;)
    {
      if (AppSetting.j) {
        this.jdField_a_of_type_Wnl.jdField_a_of_type_AndroidViewView.setContentDescription(localStringBuilder.toString());
      }
      return;
      if (!AppSetting.j) {
        break;
      }
      localStringBuilder.append("你未开通特权服务，快去开通vip服务吧！");
      this.jdField_a_of_type_Wnl.jdField_a_of_type_AndroidViewView.setContentDescription(localStringBuilder.toString());
      break;
      if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0))
      {
        String str = this.jdField_a_of_type_Wnl.jdField_a_of_type_ComTencentMobileqqDataCard.privilegePromptStr;
        localLinearLayout.setVisibility(8);
        if (TextUtils.isEmpty(str))
        {
          ((TextView)localObject).setVisibility(4);
        }
        else
        {
          ((TextView)localObject).setVisibility(0);
          ((TextView)localObject).setText(str);
          if (AppSetting.j) {
            localStringBuilder.append("TA还未开通任何服务特权");
          }
        }
      }
      else
      {
        ProfileCardMoreInfoView.a(this.jdField_a_of_type_Wnl.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView, this.jdField_a_of_type_JavaUtilList, localLinearLayout);
        if (AppSetting.j)
        {
          localStringBuilder.append("你的好友已开通");
          ProfileCardMoreInfoView.a(this.jdField_a_of_type_Wnl.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView, localStringBuilder, this.jdField_a_of_type_JavaUtilList);
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wnm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */