import com.tencent.device.msg.activities.DevLittleVideoItemBuilder;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;

public class jzw
  implements Runnable
{
  public jzw(DevLittleVideoItemBuilder paramDevLittleVideoItemBuilder, MessageForDevLittleVideo paramMessageForDevLittleVideo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ShortVideoReq localShortVideoReq = ShortVideoBusiManager.a(0, 4);
    localShortVideoReq.a(ShortVideoBusiManager.a(this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo, localShortVideoReq));
    ShortVideoBusiManager.a(localShortVideoReq, this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevLittleVideoItemBuilder.a);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jzw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */