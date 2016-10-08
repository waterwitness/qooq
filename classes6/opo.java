import com.tencent.mobileqq.activity.phone.BaseActivityView.IPhoneContext;
import com.tencent.mobileqq.activity.phone.PhoneInnerFrame;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;

public class opo
  extends ContactBindObserver
{
  public opo(PhoneInnerFrame paramPhoneInnerFrame)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.a.a)
    {
      this.a.b().a().unRegistObserver(this);
      this.a.g();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\opo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */