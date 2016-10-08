import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.Contacts;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;

public class lbi
  implements Runnable
{
  public lbi(Contacts paramContacts, long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("sp_public_account_with_cuin_" + this.jdField_a_of_type_ComTencentMobileqqActivityContacts.a.a(), 0);
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putLong("public_account_manage_contacts_enter_time", this.jdField_a_of_type_Long);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lbi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */