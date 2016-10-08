import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import com.tencent.widget.CustomImgView;

class tni
  implements ActionSheet.OnButtonClickListener
{
  tni(tnh paramtnh, View paramView, PicInfo paramPicInfo, ActionSheet paramActionSheet)
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
      paramView = BaseApplicationImpl.a().getSharedPreferences(this.jdField_a_of_type_Tnh.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a(), 0);
      if (paramView.getBoolean("NearbyVideoHeadDialog", false))
      {
        paramView = (PicInfo)this.jdField_a_of_type_Tnh.a.jdField_a_of_type_ComTencentWidgetCustomImgView.getTag();
        this.jdField_a_of_type_Tnh.a.jdField_a_of_type_AndroidWidgetLinearLayout.addView(NearbyProfileEditPanel.a(this.jdField_a_of_type_Tnh.a, paramView, this.jdField_a_of_type_Tnh.a.jdField_a_of_type_ComTencentWidgetCustomImgView.a()), 0);
        this.jdField_a_of_type_Tnh.a.jdField_a_of_type_AndroidWidgetLinearLayout.removeView(this.jdField_a_of_type_AndroidViewView);
        NearbyProfileEditPanel.a(this.jdField_a_of_type_Tnh.a, this.jdField_a_of_type_Tnh.a.jdField_a_of_type_ComTencentWidgetCustomImgView, this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo, ((CustomImgView)this.jdField_a_of_type_AndroidViewView).a());
        NearbyProfileEditPanel.a(this.jdField_a_of_type_Tnh.a);
      }
      else
      {
        paramView.edit().putBoolean("NearbyVideoHeadDialog", true).commit();
        paramView = DialogUtil.a(this.jdField_a_of_type_Tnh.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, this.jdField_a_of_type_Tnh.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getString(2131372702), 2131367262, 2131372704, new tnj(this), new tnk(this));
        if (!this.jdField_a_of_type_Tnh.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.isFinishing())
        {
          paramView.show();
          continue;
          paramView = AnimationUtils.a(this.jdField_a_of_type_AndroidViewView);
          this.jdField_a_of_type_Tnh.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo, paramView);
          continue;
          NearbyProfileEditPanel.a(this.jdField_a_of_type_Tnh.a, this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo, this.jdField_a_of_type_AndroidViewView);
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tni.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */