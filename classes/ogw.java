import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.StringUtil;
import java.util.List;
import mqq.os.MqqHandler;

public class ogw
  implements Runnable
{
  public ogw(AddContactsView paramAddContactsView, String paramString, SharedPreferences paramSharedPreferences)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    List localList = AddContactsView.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView);
    String str = AddContactsView.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView, localList);
    if (!this.jdField_a_of_type_JavaLangString.equals(str))
    {
      AddContactsView.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView, localList);
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString(AddContactsView.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView), StringUtil.a(AddContactsView.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView), ",")).commit();
      ThreadManager.c().post(new ogx(this, str));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ogw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */