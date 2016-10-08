import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.device.file.DevVideoMsgProcessor;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.DeviceMsgChatPie;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class nxd
  implements DialogInterface.OnClickListener
{
  public nxd(DeviceMsgChatPie paramDeviceMsgChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    DevVideoMsgProcessor.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, this.a.ap);
    this.a.ap = "";
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nxd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */