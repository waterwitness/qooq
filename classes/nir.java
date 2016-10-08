import android.view.View;
import com.tencent.device.msg.data.DeviceGroupChatMsgProcessor;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.mobileqq.activity.aio.item.DevicePicItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class nir
  implements ActionSheet.OnButtonClickListener
{
  public nir(DevicePicItemBuilder paramDevicePicItemBuilder, MessageForDeviceFile paramMessageForDeviceFile, ActionSheet paramActionSheet)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    if ("device_groupchat".equals(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeviceFile.extStr)) {
      ((DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemDevicePicItemBuilder.a.a(49)).a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeviceFile);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemDevicePicItemBuilder.a();
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemDevicePicItemBuilder.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeviceFile);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nir.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */