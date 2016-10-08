import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.av.ui.HYControlUI;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class gpi
  implements Runnable
{
  gpi(gph paramgph)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.a.a.jdField_a_of_type_ComTencentAvVideoController != null) && (this.a.a.jdField_a_of_type_ComTencentAvVideoController.a().j != 4) && (this.a.a.h == 1) && (!this.a.a.jdField_a_of_type_Boolean) && (this.a.a.m != 2))
    {
      this.a.a.a(false);
      this.a.a.c(false);
      if ((this.a.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) && ((this.a.a.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI)) && (!(this.a.a.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof HYControlUI)))
      {
        ((DoubleVideoCtrlUI)this.a.a.jdField_a_of_type_ComTencentAvUiVideoControlUI).a();
        ((DoubleVideoCtrlUI)this.a.a.jdField_a_of_type_ComTencentAvUiVideoControlUI).a(true);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */