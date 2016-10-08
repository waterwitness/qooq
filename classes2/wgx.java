import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.webprocess.WebProcessManager.WebProcessStartListener;

public class wgx
  implements Runnable
{
  public wgx(WebProcessManager paramWebProcessManager, int paramInt, WebProcessManager.WebProcessStartListener paramWebProcessStartListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (!WebProcessManager.c())
    {
      WebProcessManager.b(true);
      WebProcessManager.a(false);
      WebProcessManager.a(this.jdField_a_of_type_ComTencentMobileqqWebprocessWebProcessManager, this.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_ComTencentMobileqqWebprocessWebProcessManager$WebProcessStartListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqWebprocessWebProcessManager$WebProcessStartListener.a(true);
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqWebprocessWebProcessManager$WebProcessStartListener == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWebprocessWebProcessManager$WebProcessStartListener.a(false);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wgx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */