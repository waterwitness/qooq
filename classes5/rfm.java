import com.tencent.mobileqq.dating.HotChatFlashPicActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DESUtil;
import java.util.concurrent.atomic.AtomicBoolean;

public class rfm
  implements Runnable
{
  public rfm(HotChatFlashPicActivity paramHotChatFlashPicActivity, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    DESUtil.b(this.jdField_a_of_type_JavaLangString, HotChatFlashPicActivity.c(this.jdField_a_of_type_ComTencentMobileqqDatingHotChatFlashPicActivity));
    HotChatFlashPicActivity.b(this.jdField_a_of_type_ComTencentMobileqqDatingHotChatFlashPicActivity, true);
    if (!HotChatFlashPicActivity.a(this.jdField_a_of_type_ComTencentMobileqqDatingHotChatFlashPicActivity).get()) {
      HotChatFlashPicActivity.b(this.jdField_a_of_type_ComTencentMobileqqDatingHotChatFlashPicActivity, this.jdField_a_of_type_JavaLangString);
    }
    HotChatFlashPicActivity.a(this.jdField_a_of_type_ComTencentMobileqqDatingHotChatFlashPicActivity, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rfm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */