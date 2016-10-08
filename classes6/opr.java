import com.tencent.mobileqq.activity.phone.PhoneMatchActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;

public class opr
  extends ContactBindObserver
{
  public opr(PhoneMatchActivity paramPhoneMatchActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    if (this.a.a != null)
    {
      this.a.app.unRegistObserver(this.a.a);
      this.a.a = null;
    }
    this.a.b();
    if (paramBoolean)
    {
      if (this.a.a != null)
      {
        this.a.app.unRegistObserver(this.a.a);
        this.a.a = null;
      }
      this.a.finish();
      return;
    }
    this.a.a("更新失败，请稍后重试。");
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\opr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */