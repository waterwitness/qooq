import android.text.TextUtils;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.msg.activities.DevLittleVideoItemBuilder;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class jzy
  implements Runnable
{
  public jzy(DevLittleVideoItemBuilder paramDevLittleVideoItemBuilder, MessageForDevLittleVideo paramMessageForDevLittleVideo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    SmartDeviceProxyMgr localSmartDeviceProxyMgr = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevLittleVideoItemBuilder.a.a(51);
    DeviceMsgHandle localDeviceMsgHandle = (DeviceMsgHandle)this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevLittleVideoItemBuilder.a.a(49);
    for (;;)
    {
      synchronized (localDeviceMsgHandle.a)
      {
        Iterator localIterator = localDeviceMsgHandle.a.entrySet().iterator();
        if (localIterator.hasNext())
        {
          if (((MessageRecord)((Map.Entry)localIterator.next()).getValue()).uniseq != this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.uniseq) {
            continue;
          }
          i = 1;
          if ((i == 0) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.thumbFileKey)))
          {
            long l = localSmartDeviceProxyMgr.a(this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.thumbFileKey, this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.coverkey2, 2154);
            localDeviceMsgHandle.a.put(Long.valueOf(l), this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo);
          }
          return;
        }
      }
      int i = 0;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jzy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */