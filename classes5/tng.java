import android.text.TextUtils;
import android.view.View;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarRecordActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class tng
  implements ActionSheet.OnButtonClickListener
{
  tng(tnf paramtnf, View paramView, PicInfo paramPicInfo, ActionSheet paramActionSheet)
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
      DynamicAvatarRecordActivity.a(this.jdField_a_of_type_Tnf.a.a, 2, 13);
      ReportController.b(this.jdField_a_of_type_Tnf.a.a.app, "dc00898", "", "", "0X8007116", "0X8007116", 0, 0, "", "", "", "");
      continue;
      this.jdField_a_of_type_Tnf.a.a.a(true);
      ReportController.b(this.jdField_a_of_type_Tnf.a.a.app, "dc00898", "", "", "0X8007117", "0X8007117", 0, 0, "", "", "", "");
      continue;
      this.jdField_a_of_type_Tnf.a.a.b(true);
      ReportController.b(this.jdField_a_of_type_Tnf.a.a.app, "dc00898", "", "", "0X8007118", "0X8007118", 0, 0, "", "", "", "");
      continue;
      paramView = AnimationUtils.a(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_Tnf.a.a.a(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo, paramView);
      if ((this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.d)))
      {
        ReportController.b(this.jdField_a_of_type_Tnf.a.a.app, "dc00898", "", "", "0X8007119", "0X8007119", 0, 0, "1", "", "", "");
      }
      else
      {
        ReportController.b(this.jdField_a_of_type_Tnf.a.a.app, "dc00898", "", "", "0X8007119", "0X8007119", 0, 0, "0", "", "", "");
        continue;
        NearbyProfileEditPanel.a(this.jdField_a_of_type_Tnf.a, this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo, this.jdField_a_of_type_AndroidViewView);
        if ((this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.d))) {
          ReportController.b(this.jdField_a_of_type_Tnf.a.a.app, "dc00898", "", "", "0X800711A", "0X800711A", 0, 0, "1", "", "", "");
        } else {
          ReportController.b(this.jdField_a_of_type_Tnf.a.a.app, "dc00898", "", "", "0X800711A", "0X800711A", 0, 0, "0", "", "", "");
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tng.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */