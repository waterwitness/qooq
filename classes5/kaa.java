import com.tencent.device.msg.activities.DevShortVideoItemBuilder;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;

public class kaa
  implements Runnable
{
  public kaa(DevShortVideoItemBuilder paramDevShortVideoItemBuilder, MessageForShortVideo paramMessageForShortVideo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ShortVideoReq localShortVideoReq = ShortVideoBusiManager.a(1, this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevShortVideoItemBuilder.i);
    localShortVideoReq.a(ShortVideoBusiManager.a(this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevShortVideoItemBuilder.i, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, localShortVideoReq));
    ShortVideoBusiManager.a(localShortVideoReq, this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevShortVideoItemBuilder.a);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\kaa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */