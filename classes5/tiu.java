import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.business.NearbyCardHandler;
import com.tencent.mobileqq.nearby.guide.NearbyGuideActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;

public class tiu
  implements View.OnClickListener
{
  public tiu(NearbyGuideActivity paramNearbyGuideActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if ((this.a.jdField_a_of_type_AndroidAppDialog != null) && (!this.a.isFinishing()))
    {
      this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
      this.a.jdField_a_of_type_AndroidAppDialog = null;
      this.a.d("正在导入...");
      if (this.a.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler == null) {
        this.a.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler = ((NearbyCardHandler)this.a.app.a(60));
      }
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler.a(NearbyPeopleProfileActivity.r, 5);
      this.a.e("0X8005909");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tiu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */