import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.av.utils.TraeHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.ColorRingManager;
import com.tencent.widget.ActionSheet.OnDismissListener;
import java.io.File;
import java.lang.ref.WeakReference;

public class gsa
  implements ActionSheet.OnDismissListener
{
  public gsa(DoubleVideoCtrlUI paramDoubleVideoCtrlUI, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss()
  {
    if (this.jdField_a_of_type_Boolean) {
      if ((this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && ((this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_JavaLangRefWeakReference.get() instanceof AVActivity))) {
        ((AVActivity)this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_JavaLangRefWeakReference.get()).finish();
      }
    }
    for (;;)
    {
      ReportController.b(null, "CliOper", "", "", "0X8005C89", "0X8005C89", 0, 0, "", "", "", "");
      return;
      if (this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvVideoController != null)
      {
        String str = ColorRingManager.a(this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvVideoController.a().a, 3);
        if (new File(str).exists())
        {
          if (!this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvVideoController.a().b) {
            TraeHelper.a().a(this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 0, str, -1, null);
          }
        }
        else if (!this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvVideoController.a().b) {
          TraeHelper.a().a(this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131165200, null, -1, null);
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gsa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */