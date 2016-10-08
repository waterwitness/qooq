import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.ControlUIObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gpk
  implements Runnable
{
  public gpk(AVActivity paramAVActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentAvVideoController == null) {}
    while ((this.a.jdField_a_of_type_ComTencentAvVideoController.a() == null) || (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().O)) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentAvVideoController.a(this.a.jdField_a_of_type_ComTencentAvVideoController.a().c, 1);
    int i = this.a.jdField_a_of_type_ComTencentAvVideoController.a().f;
    this.a.jdField_a_of_type_ComTencentAvVideoController.c(this.a.jdField_a_of_type_ComTencentAvVideoController.a().c, 21);
    if (i == 1) {
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().f = 3;
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().l = 3000;
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().g = false;
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().E = 0;
      this.a.jdField_a_of_type_ComTencentAvUiControlUIObserver.c();
      return;
      if (i == 2) {
        this.a.jdField_a_of_type_ComTencentAvVideoController.a().f = 4;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gpk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */