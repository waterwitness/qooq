import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.av.utils.TraeHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.ColorRingManager;
import java.io.File;
import java.lang.ref.WeakReference;

public class grz
  implements DialogInterface.OnKeyListener
{
  public grz(DoubleVideoCtrlUI paramDoubleVideoCtrlUI, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (!this.jdField_a_of_type_Boolean) {
        break label59;
      }
      if ((this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && ((this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_JavaLangRefWeakReference.get() instanceof AVActivity))) {
        ((AVActivity)this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_JavaLangRefWeakReference.get()).finish();
      }
    }
    return false;
    label59:
    if (this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      paramDialogInterface = ColorRingManager.a(this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvVideoController.a().a, 3);
      if (!new File(paramDialogInterface).exists()) {
        break label162;
      }
      if (!this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvVideoController.a().b) {
        TraeHelper.a().a(this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 0, paramDialogInterface, -1, null);
      }
    }
    for (;;)
    {
      ReportController.b(null, "CliOper", "", "", "0X8005C89", "0X8005C89", 0, 0, "", "", "", "");
      break;
      label162:
      if (!this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvVideoController.a().b) {
        TraeHelper.a().a(this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131165200, null, -1, null);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\grz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */