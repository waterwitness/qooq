import android.content.Intent;
import com.tencent.mobileqq.activity.phone.ContactListView;
import com.tencent.mobileqq.activity.phone.PhoneMatchView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;

public class opt
  extends ContactBindObserver
{
  public opt(PhoneMatchView paramPhoneMatchView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver != null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.a.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
      this.a.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = null;
    }
    this.a.g();
    if (paramBoolean)
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.a.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
        this.a.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = null;
      }
      if (this.a.jdField_a_of_type_Int == 2)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setResult(-1);
        this.a.f();
        return;
      }
      Intent localIntent = new Intent(this.a.getContext(), ContactListView.class);
      this.a.a(localIntent);
      return;
    }
    this.a.a("更新失败，请稍后重试。");
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\opt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */