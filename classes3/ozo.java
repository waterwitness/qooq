import android.view.WindowManager.BadTokenException;
import com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class ozo
  implements Runnable
{
  public ozo(FlowCameraActivity2 paramFlowCameraActivity2, String paramString, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    String str = this.jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_Int == 2002) {
      str = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowCameraActivity2.getString(2131362953);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowCameraActivity2.a = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowCameraActivity2, 230).setMessage(str).setPositiveButton(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowCameraActivity2.getString(2131362952), new ozp(this));
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowCameraActivity2.a.setCancelable(false);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowCameraActivity2.a.show();
      return;
    }
    catch (WindowManager.BadTokenException localBadTokenException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("FlowCameraActivity", 2, "", localBadTokenException);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ozo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */