import com.tencent.mobileqq.activity.Contacts;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;

public class lbp
  extends ContactBindObserver
{
  private lbp(Contacts paramContacts)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean)
  {
    Contacts.c(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lbp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */