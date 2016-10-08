import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.forward.ForwardAbility.ForwardAbilityType;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;

public class ljm
  implements View.OnClickListener
{
  public ljm(ForwardRecentActivity paramForwardRecentActivity, Resources paramResources, DeviceInfo paramDeviceInfo, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.h(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity, "目前没有网络，请稍后再试!", 1000).b(this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131492908));
      return;
    }
    paramView = new Bundle();
    paramView.putString("uin", String.valueOf(this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo.din));
    paramView.putInt("uintype", 9501);
    paramView.putString("uinname", this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity.a.a(ForwardAbility.ForwardAbilityType.k.intValue(), paramView);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ljm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */