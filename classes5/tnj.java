import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel;
import com.tencent.widget.CustomImgView;

class tnj
  implements DialogInterface.OnClickListener
{
  tnj(tni paramtni)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    paramDialogInterface = (PicInfo)this.a.jdField_a_of_type_Tnh.a.jdField_a_of_type_ComTencentWidgetCustomImgView.getTag();
    this.a.jdField_a_of_type_Tnh.a.jdField_a_of_type_AndroidWidgetLinearLayout.addView(NearbyProfileEditPanel.a(this.a.jdField_a_of_type_Tnh.a, paramDialogInterface, this.a.jdField_a_of_type_Tnh.a.jdField_a_of_type_ComTencentWidgetCustomImgView.a()), 0);
    this.a.jdField_a_of_type_Tnh.a.jdField_a_of_type_AndroidWidgetLinearLayout.removeView(this.a.jdField_a_of_type_AndroidViewView);
    NearbyProfileEditPanel.a(this.a.jdField_a_of_type_Tnh.a, this.a.jdField_a_of_type_Tnh.a.jdField_a_of_type_ComTencentWidgetCustomImgView, this.a.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo, ((CustomImgView)this.a.jdField_a_of_type_AndroidViewView).a());
    NearbyProfileEditPanel.a(this.a.jdField_a_of_type_Tnh.a);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tnj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */