import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyProxy;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.ArrayList;

public class tmq
  implements View.OnClickListener
{
  public tmq(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    PicInfo localPicInfo = (PicInfo)paramView.getTag();
    paramView = AnimationUtils.a(paramView);
    this.a.a.a(this.a.a.jdField_a_of_type_JavaUtilArrayList.indexOf(localPicInfo), paramView);
    ReportController.b(this.a.a.app, "CliOper", "", "", "0X800482A", "0X800482A", 0, 0, "", "", "", "");
    if (NearbyProxy.a(this.a.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g, this.a.a.D)) {
      this.a.a.app.a().b(localPicInfo.a);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tmq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */