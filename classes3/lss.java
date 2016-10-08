import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.FTSDBManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.managers.MessageRecordManagerImpl;
import com.tencent.mobileqq.utils.HistoryChatMsgSearchKeyUtil;
import com.tencent.mobileqq.widget.PadQQCheckBox;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.manager.AccountManager;

public class lss
  implements Runnable
{
  public lss(LoginActivity paramLoginActivity, String paramString, QQProgressDialog paramQQProgressDialog)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityLoginActivity.getAppRuntime().stopPCActivePolling("deleteAccount");
    for (;;)
    {
      try
      {
        ((AccountManager)this.jdField_a_of_type_ComTencentMobileqqActivityLoginActivity.getAppRuntime().getManager(0)).deleteAccount(this.jdField_a_of_type_JavaLangString, null);
        HistoryChatMsgSearchKeyUtil.a(this.jdField_a_of_type_JavaLangString);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityLoginActivity.a.a())
        {
          FTSDBManager.a((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqActivityLoginActivity.getAppRuntime(), this.jdField_a_of_type_JavaLangString, true);
          new MessageRecordManagerImpl().a(this.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_ComTencentMobileqqActivityLoginActivity.b(this.jdField_a_of_type_JavaLangString);
        }
        Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityLoginActivity;
        if (Build.VERSION.SDK_INT <= 10) {
          continue;
        }
        i = 4;
        localObject1 = ((LoginActivity)localObject1).getSharedPreferences("Last_Login", i);
        if ((localObject1 != null) && (((SharedPreferences)localObject1).contains("uin")) && (((SharedPreferences)localObject1).getString("uin", "").equals(this.jdField_a_of_type_JavaLangString)))
        {
          ((SharedPreferences)localObject1).edit().remove("uin").commit();
          if (QLog.isColorLevel()) {
            QLog.d("login", 2, "delete Last_Login");
          }
        }
      }
      catch (Exception localException)
      {
        int i;
        localException.printStackTrace();
      }
      finally
      {
        if (0 == 0) {
          continue;
        }
        throw new NullPointerException();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityLoginActivity.runOnUiThread(new lst(this));
      return;
      i = 0;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lss.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */