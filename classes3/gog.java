import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.smallscreen.SmallScreenDoubleVideoControlUI;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gog
  implements Runnable
{
  public gog(SmallScreenDoubleVideoControlUI paramSmallScreenDoubleVideoControlUI)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.a.jdField_a_of_type_ComTencentAvVideoController != null) && (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null))
    {
      SessionInfo localSessionInfo = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
      this.a.jdField_a_of_type_ComTencentAvVideoController.a(localSessionInfo.c, 0);
      this.a.jdField_a_of_type_ComTencentAvVideoController.c(localSessionInfo.c, 9);
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), localSessionInfo.c, Boolean.valueOf(true) });
      this.a.jdField_a_of_type_ComTencentAvVideoController.a();
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */