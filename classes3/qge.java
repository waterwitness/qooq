import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richstatus.EditActivity;
import com.tencent.mobileqq.vas.SignatureTemplateConfig.SignatureTemplateType;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class qge
  implements Handler.Callback
{
  public qge(SignatureManager paramSignatureManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (2 == paramMessage.what)
    {
      SignatureManager.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType = (SignatureTemplateConfig.SignatureTemplateType[])paramMessage.obj;
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        paramMessage = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(EditActivity.class);
        if (paramMessage != null) {
          paramMessage.sendEmptyMessageDelayed(2, 50L);
        }
        if (QLog.isColorLevel()) {
          QLog.d("SignatureManager", 2, "update sign tpl info...");
        }
      }
    }
    for (;;)
    {
      return true;
      if ((3 == paramMessage.what) && (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
      {
        paramMessage = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(EditActivity.class);
        if (paramMessage != null) {
          paramMessage.sendEmptyMessageDelayed(7, 50L);
        }
        if (QLog.isColorLevel()) {
          QLog.d("SignatureManager", 2, "update sign tpl animation ...");
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */