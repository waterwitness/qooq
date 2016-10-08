import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ndi
  implements Runnable
{
  public ndi(MediaPlayerManager paramMediaPlayerManager, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager, this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.c();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ndi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */