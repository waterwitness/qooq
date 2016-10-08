import SecurityAccountServer.RespondQueryQQBindingStat;
import com.tencent.mobileqq.activity.selectmember.PhoneContactTabView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;

public class pgg
  extends ContactBindObserver
{
  public pgg(PhoneContactTabView paramPhoneContactTabView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a.a.unRegistObserver(this);
    switch (PhoneContactTabView.a(this.a).d())
    {
    case 5: 
    default: 
      PhoneContactTabView.b(this.a);
      return;
    case 6: 
      this.a.d();
      return;
    case 0: 
    case 1: 
    case 2: 
    case 4: 
      PhoneContactTabView.a(this.a);
      return;
    }
    if (PhoneContactTabView.a(this.a).a().lastUsedFlag == 2L)
    {
      this.a.d();
      return;
    }
    PhoneContactTabView.a(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pgg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */