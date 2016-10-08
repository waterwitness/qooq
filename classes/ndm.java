import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager.Listener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ndm
  implements Runnable
{
  public ndm(MediaPlayerManager paramMediaPlayerManager, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager) != null) {
      MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager).d(this.jdField_a_of_type_Int);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ndm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */