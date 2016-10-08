import android.os.Message;
import com.tencent.mobileqq.activity.SendMultiPictureHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class mkg
  extends TransProcessorHandler
{
  public mkg(SendMultiPictureHelper paramSendMultiPictureHelper)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    paramMessage = (FileMsg)paramMessage.obj;
    if (paramMessage == null) {
      if (QLog.isColorLevel()) {
        QLog.d("SendMultiPictureHelper", 2, "file is null");
      }
    }
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("SendMultiPictureHelper", 2, "transferListener status: " + i);
        }
        i = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessage.r, paramMessage.k, paramMessage.c);
      } while (this.a.d);
      if (this.a.jdField_b_of_type_Boolean)
      {
        if (paramMessage.Z == 1005)
        {
          this.a.jdField_c_of_type_Boolean = true;
          return;
        }
        if (paramMessage.Z == 1003)
        {
          this.a.a();
          return;
        }
        SendMultiPictureHelper.a(this.a, this.a.jdField_c_of_type_Int, this.a.jdField_c_of_type_JavaLangString, paramMessage.c);
        return;
      }
      if (paramMessage.Z == 1003)
      {
        if (this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) {
          this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(String.format(this.a.f, new Object[] { Integer.valueOf(this.a.jdField_a_of_type_Int + 1), Integer.valueOf(this.a.jdField_b_of_type_Int), Integer.valueOf(100) }));
        }
        this.a.a();
        return;
      }
      if (paramMessage.Z == 1005)
      {
        this.a.a();
        return;
      }
    } while (this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null);
    this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(String.format(this.a.f, new Object[] { Integer.valueOf(this.a.jdField_a_of_type_Int + 1), Integer.valueOf(this.a.jdField_b_of_type_Int), Integer.valueOf(i) }));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mkg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */