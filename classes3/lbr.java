import com.tencent.mobileqq.activity.Contacts;
import com.tencent.mobileqq.adapter.BuddyListAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lbr
  extends MessageObserver
{
  private lbr(Contacts paramContacts)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    Contacts localContacts = this.a;
    if (paramInt1 != 0) {}
    for (boolean bool = true;; bool = false)
    {
      localContacts.e = bool;
      if (this.a.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter.b();
        this.a.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter.a();
      }
      return;
    }
  }
  
  protected void b(int paramInt1, int paramInt2)
  {
    Contacts localContacts = this.a;
    if (paramInt1 != 0) {}
    for (boolean bool = true;; bool = false)
    {
      localContacts.f = bool;
      if (this.a.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter.c();
        this.a.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter.a(this.a.f, AppConstants.ak);
        this.a.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter.a();
      }
      return;
    }
  }
  
  protected void c()
  {
    if (this.a.jdField_a_of_type_Boolean) {
      this.a.a(1400L, true);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lbr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */