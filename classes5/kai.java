import com.tencent.device.file.DeviceAVFileMsgObserver;
import com.tencent.device.msg.activities.DevicePttItemBuilder;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.device.msg.data.MessageForDevPtt;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class kai
  implements Runnable
{
  public kai(DevicePttItemBuilder paramDevicePttItemBuilder, MessageForPtt paramMessageForPtt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileTrans", 2, "downloadPtt istroop" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.istroop + " itemType " + this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.itemType + " uniseq:" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.uniseq);
    }
    DeviceAVFileMsgObserver localDeviceAVFileMsgObserver = ((DeviceMsgHandle)this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevicePttItemBuilder.a.a(49)).a();
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt instanceof MessageForDevPtt)) {
      localDeviceAVFileMsgObserver.a((MessageForDevPtt)this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\kai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */