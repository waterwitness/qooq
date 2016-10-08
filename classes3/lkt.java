import android.app.Activity;
import android.view.View;
import android.widget.Toast;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.profile.view.ProfileShoppingView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class lkt
  implements ActionSheet.OnButtonClickListener
{
  lkt(lkq paramlkq, String paramString, ActionSheet paramActionSheet)
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
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a();
      return;
      ReportController.b(this.jdField_a_of_type_Lkq.a.app, "CliOper", "", "", "card_mall", "0X8006680", 0, 0, "1", "", "", VipUtils.a(this.jdField_a_of_type_Lkq.a.app, this.jdField_a_of_type_Lkq.a.app.a()));
      if ((this.jdField_a_of_type_Lkq.a.d == 160L) || (ProfileCardUtil.d(this.jdField_a_of_type_Lkq.a.jdField_a_of_type_JavaUtilArrayList)) || (this.jdField_a_of_type_Lkq.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.lCurrentStyleId == ProfileCardTemplate.h) || ((this.jdField_a_of_type_Lkq.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileShoppingView)))
      {
        Toast.makeText(this.jdField_a_of_type_Lkq.a.getApplicationContext(), 2131370910, 0).show();
      }
      else
      {
        this.jdField_a_of_type_Lkq.a.a(this.jdField_a_of_type_Lkq.a.c, this.jdField_a_of_type_Lkq.a.d);
        continue;
        ReportController.b(this.jdField_a_of_type_Lkq.a.app, "CliOper", "", "", "card_mall", "0X8006680", 0, 0, "2", "", "", VipUtils.a(this.jdField_a_of_type_Lkq.a.app, this.jdField_a_of_type_Lkq.a.app.a()));
        String str1 = "";
        Object localObject = this.jdField_a_of_type_Lkq.a.a();
        paramView = str1;
        if (localObject != null)
        {
          paramView = str1;
          if (((String)localObject).equals("CustomCover")) {
            paramView = "oldCustom=1";
          }
        }
        localObject = this.jdField_a_of_type_Lkq.a;
        String str2 = this.jdField_a_of_type_Lkq.a.app.a();
        if (this.jdField_a_of_type_JavaLangString.equals("CLICK_HEADER_BG")) {}
        for (str1 = "inside.friendCardBackground";; str1 = "inside.blackBar")
        {
          ProfileCardUtil.a((Activity)localObject, str2, str1, 1, 1, 1, paramView, false);
          break;
        }
        ReportController.b(this.jdField_a_of_type_Lkq.a.app, "CliOper", "", "", "card_mall", "0X8006680", 0, 0, "3", "", "", VipUtils.a(this.jdField_a_of_type_Lkq.a.app, this.jdField_a_of_type_Lkq.a.app.a()));
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lkt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */