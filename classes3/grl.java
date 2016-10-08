import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class grl
  implements Runnable
{
  public grl(DoubleVideoCtrlUI paramDoubleVideoCtrlUI)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.a.jdField_a_of_type_ComTencentAvVideoController != null) && (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null))
    {
      this.a.jdField_a_of_type_ComTencentAvVideoController.a(this.a.jdField_a_of_type_ComTencentAvVideoController.a().c, 0);
      this.a.jdField_a_of_type_ComTencentAvVideoController.c(this.a.jdField_a_of_type_ComTencentAvVideoController.a().c, 9);
      this.a.jdField_a_of_type_ComTencentAvVideoController.a();
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\grl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */