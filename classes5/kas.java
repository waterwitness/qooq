import com.tencent.device.msg.data.DeviceComnFileMsgProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.concurrent.ConcurrentHashMap;

public class kas
  implements Runnable
{
  public kas(DeviceComnFileMsgProcessor paramDeviceComnFileMsgProcessor, MessageForDeviceFile paramMessageForDeviceFile)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (DeviceComnFileMsgProcessor.a(this.jdField_a_of_type_ComTencentDeviceMsgDataDeviceComnFileMsgProcessor).containsKey(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeviceFile.uSessionID)))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeviceFile.nFileStatus = 23;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeviceFile.serial();
      DeviceComnFileMsgProcessor.a(this.jdField_a_of_type_ComTencentDeviceMsgDataDeviceComnFileMsgProcessor).a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeviceFile.frienduin, 9501, this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeviceFile.uniseq, this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeviceFile.msgData);
      DeviceComnFileMsgProcessor.a(this.jdField_a_of_type_ComTencentDeviceMsgDataDeviceComnFileMsgProcessor, this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeviceFile);
      DeviceComnFileMsgProcessor.a(this.jdField_a_of_type_ComTencentDeviceMsgDataDeviceComnFileMsgProcessor).remove(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeviceFile.uSessionID));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\kas.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */