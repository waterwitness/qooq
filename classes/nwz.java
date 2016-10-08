import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.DeviceMsgChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class nwz
  implements View.OnClickListener
{
  public nwz(DeviceMsgChatPie paramDeviceMsgChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = (SmartDeviceProxyMgr)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
    DeviceInfo localDeviceInfo = paramView.a(Long.parseLong(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a));
    if (this.a.jdField_a_of_type_JavaLangBoolean.booleanValue())
    {
      if (DeviceMsgChatPie.a(this.a)) {
        paramView.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, localDeviceInfo, false);
      }
      this.a.x();
      return;
    }
    paramView.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, localDeviceInfo, false);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nwz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */