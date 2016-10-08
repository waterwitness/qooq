import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vipgift.VipGiftDownloadInfo;
import com.tencent.mobileqq.vipgift.VipGiftManager;

public class nqe
  implements Runnable
{
  public nqe(StructingMsgItemBuilder paramStructingMsgItemBuilder, VipGiftDownloadInfo paramVipGiftDownloadInfo, VipGiftManager paramVipGiftManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftDownloadInfo.d == 1L) && (this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftDownloadInfo.b.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)))
    {
      this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftManager.a(6L, this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftDownloadInfo.a);
      ((BaseActivity)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_AndroidContentContext).runOnUiThread(new nqf(this));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nqe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */