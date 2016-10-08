import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel;
import com.tencent.widget.CustomImgView;

class tov
  implements Runnable
{
  tov(tou paramtou)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    NearbyProfileEditPanel.a(this.a.jdField_a_of_type_Tos.a, this.a.jdField_a_of_type_Tos.a.jdField_a_of_type_ComTencentWidgetCustomImgView, (PicInfo)this.a.jdField_a_of_type_AndroidViewView.getTag(), this.a.jdField_a_of_type_ComTencentWidgetCustomImgView.a());
    this.a.jdField_a_of_type_Tos.a.jdField_a_of_type_ComTencentWidgetCustomImgView.setVisibility(0);
    NearbyProfileEditPanel.a(this.a.jdField_a_of_type_Tos.a);
    this.a.jdField_a_of_type_Tos.a.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.a.jdField_a_of_type_ComTencentWidgetCustomImgView);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tov.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */