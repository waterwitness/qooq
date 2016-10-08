import com.tencent.av.VideoController;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.av.ui.QavPanel;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gsg
  implements Runnable
{
  public gsg(DoubleVideoCtrlUI paramDoubleVideoCtrlUI)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.a.jdField_a_of_type_ComTencentAvVideoController == null) || (this.a.jdField_a_of_type_ComTencentAvUiQavPanel == null)) {}
    for (;;)
    {
      return;
      if ((this.a.jdField_a_of_type_ComTencentAvVideoController.c()) && (VcSystemInfo.d()))
      {
        this.a.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(1, true);
        this.a.jdField_a_of_type_ComTencentAvUiQavPanel.b(1, true);
      }
      while ((this.a.jdField_a_of_type_ComTencentAvUiQavPanel != null) && (this.a.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131299019)) && (this.a.jdField_a_of_type_ComTencentAvVideoController != null) && (!this.a.jdField_a_of_type_ComTencentAvUiQavPanel.b(3)))
      {
        this.a.t_();
        return;
        this.a.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(1, false);
        this.a.jdField_a_of_type_ComTencentAvUiQavPanel.b(1, false);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */