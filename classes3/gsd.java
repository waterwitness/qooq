import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.utils.TipsManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class gsd
  implements Runnable
{
  public gsd(DoubleVideoCtrlUI paramDoubleVideoCtrlUI)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.a.jdField_a_of_type_ComTencentAvVideoController == null) || (this.a.jdField_a_of_type_ComTencentAvUiQavPanel == null) || (this.a.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131299023)) || (this.a.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131299019))) {
      return;
    }
    if ((this.a.jdField_a_of_type_ComTencentAvVideoController.c()) && (VcSystemInfo.d())) {
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 1)
      {
        this.a.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(1, true);
        this.a.jdField_a_of_type_ComTencentAvUiQavPanel.b(1, true);
      }
    }
    for (;;)
    {
      this.a.t_();
      if (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Boolean) {
        break;
      }
      this.a.jdField_a_of_type_ComTencentAvVideoController.a(true, this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString);
      return;
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 1)
      {
        this.a.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(1, false);
        this.a.jdField_a_of_type_ComTencentAvUiQavPanel.b(1, false);
      }
      if ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().h == 1) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean))
      {
        if (QLog.isColorLevel()) {
          QLog.d("DoubleVideoCtrlUI", 2, "FixTerSwitchStatus ,switch to pc ,local close camera");
        }
        this.a.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(1, false);
        this.a.jdField_a_of_type_ComTencentAvUiQavPanel.b(1, false);
        this.a.w();
        this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106) });
        this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(23, true);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gsd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */