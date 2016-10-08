import android.view.WindowManager.BadTokenException;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarRecordActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class qso
  implements Runnable
{
  public qso(DynamicAvatarRecordActivity paramDynamicAvatarRecordActivity, String paramString, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    String str = this.jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_Int == 2002) {
      str = this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarRecordActivity.getString(2131362953);
    }
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarRecordActivity.a = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarRecordActivity, 230).setMessage(str).setPositiveButton(this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarRecordActivity.getString(2131362952), new qsp(this));
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarRecordActivity.a.setCancelable(false);
      this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarRecordActivity.a.show();
      return;
    }
    catch (WindowManager.BadTokenException localBadTokenException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i(DynamicAvatarRecordActivity.a(), 2, "", localBadTokenException);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qso.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */