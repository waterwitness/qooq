import android.widget.TextView;
import com.tencent.mobileqq.activity.phone.ContactListView;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

public class oow
  extends ContactBindObserver
{
  private oow(ContactListView paramContactListView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ContactListView.a(), 2, "onHideContact isSuccess=" + paramBoolean);
    }
    if ((paramBoolean) && ((this.a.jdField_a_of_type_Int == 4) || (this.a.jdField_a_of_type_Int == 5))) {
      this.a.j();
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    if ((!paramBoolean) || (!NetworkUtil.e(this.a.getContext())))
    {
      this.a.i();
      this.a.g();
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = this.a.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.d();
    if (!paramBoolean1)
    {
      this.a.i();
      this.a.g();
      if (((i == 0) || (i == 4)) && (this.a.m == 0)) {
        this.a.a(2131368649, 3000L);
      }
    }
    do
    {
      return;
      this.a.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
    } while (!this.a.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.c());
    this.a.a(2131368647, 0L, false);
  }
  
  protected void c(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      this.a.i();
      ContactListView.a(this.a, true);
      if ((paramInt & 0x1) == 0) {
        this.a.g();
      }
    }
    for (;;)
    {
      if (this.a.jdField_a_of_type_Int == 6) {
        this.a.f();
      }
      return;
      this.a.g();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\oow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */