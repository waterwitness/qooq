import android.view.View;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class tnc
  implements ActionSheet.OnButtonClickListener
{
  tnc(tnb paramtnb, ActionSheet paramActionSheet)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      }
      return;
    }
    this.jdField_a_of_type_Tnb.a.e = true;
    Object localObject = this.jdField_a_of_type_Tnb.a.a.a.a;
    paramView = (View)localObject;
    if (StringUtil.b((String)localObject))
    {
      paramView = (View)localObject;
      if (NearbyProfileDisplayPanel.a(this.jdField_a_of_type_Tnb.a) != null) {
        paramView = NearbyProfileDisplayPanel.a(this.jdField_a_of_type_Tnb.a).uin;
      }
    }
    localObject = paramView;
    if (StringUtil.b(paramView)) {
      localObject = "0";
    }
    long l;
    if (this.jdField_a_of_type_Tnb.a.a.b == 0L) {
      if (NearbyProfileDisplayPanel.a(this.jdField_a_of_type_Tnb.a) != null)
      {
        l = NearbyProfileDisplayPanel.a(this.jdField_a_of_type_Tnb.a).tinyId;
        label159:
        if ((!"0".equals(localObject)) || (l != 0L))
        {
          paramInt = 1105;
          if (this.jdField_a_of_type_Tnb.a.a.app == null) {
            break label618;
          }
        }
      }
    }
    label557:
    label611:
    label618:
    for (paramView = this.jdField_a_of_type_Tnb.a.a.app.a(false);; paramView = null)
    {
      if (((paramView != null) && (paramView.b(this.jdField_a_of_type_Tnb.a.a.a.d))) || (this.jdField_a_of_type_Tnb.a.a.a.g == 33) || (this.jdField_a_of_type_Tnb.a.a.a.g == 4) || (this.jdField_a_of_type_Tnb.a.a.a.g == 31)) {
        paramInt = 10000;
      }
      for (paramView = this.jdField_a_of_type_Tnb.a.a.a.d;; paramView = null)
      {
        ProfileCardUtil.a(this.jdField_a_of_type_Tnb.a.a, (String)localObject, paramView, this.jdField_a_of_type_Tnb.a.a.app.a(), paramInt);
        ReportController.b(this.jdField_a_of_type_Tnb.a.a.app, "CliOper", "", "", "0X8004828", "0X8004828", 0, 0, "", "", "", "");
        if ((NearbyProfileDisplayPanel.a(this.jdField_a_of_type_Tnb.a) != null) && (NearbyProfileDisplayPanel.a(this.jdField_a_of_type_Tnb.a).godFlag))
        {
          if (NearbyProfileDisplayPanel.a(this.jdField_a_of_type_Tnb.a).gender != 0) {
            break label557;
          }
          ReportController.b(this.jdField_a_of_type_Tnb.a.a.app, "CliOper", "", "", "0X800528E", "0X800528E", 0, 0, "", "", "", "");
        }
        for (;;)
        {
          if (!ProfileActivity.b(this.jdField_a_of_type_Tnb.a.a.a.g)) {
            break label611;
          }
          ReportController.b(this.jdField_a_of_type_Tnb.a.a.app, "CliOper", "", "", "0X800523E", "0X800523E", 0, 0, "", "", "", "");
          break;
          l = 0L;
          break label159;
          l = this.jdField_a_of_type_Tnb.a.a.b;
          break label159;
          if (NearbyProfileDisplayPanel.a(this.jdField_a_of_type_Tnb.a).gender == 1) {
            ReportController.b(this.jdField_a_of_type_Tnb.a.a.app, "CliOper", "", "", "0X800528F", "0X800528F", 0, 0, "", "", "", "");
          }
        }
        break;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tnc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */