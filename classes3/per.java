import SecurityAccountServer.RespondQueryQQBindingStat;
import com.tencent.mobileqq.activity.selectmember.ContactsInnerFrame;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;

public class per
  extends ContactBindObserver
{
  public per(ContactsInnerFrame paramContactsInnerFrame)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a.a.unRegistObserver(this);
    switch (ContactsInnerFrame.a(this.a).d())
    {
    case 5: 
    default: 
      ContactsInnerFrame.c(this.a);
      return;
    case 0: 
    case 4: 
    case 6: 
      ContactsInnerFrame.a(this.a);
      return;
    case 1: 
    case 2: 
      ContactsInnerFrame.b(this.a);
      return;
    }
    if (ContactsInnerFrame.a(this.a).a().lastUsedFlag == 2L)
    {
      ContactsInnerFrame.a(this.a);
      return;
    }
    ContactsInnerFrame.b(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\per.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */