import com.tencent.mobileqq.activity.phone.SettingActivity2;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;

class opz
  extends ContactBindObserver
{
  opz(opy paramopy)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void c(boolean paramBoolean)
  {
    this.a.a.a.b();
    this.a.a.a.app.unRegistObserver(this);
    if (paramBoolean)
    {
      this.a.a.a.a.a(true, true);
      this.a.a.a.setResult(4002);
      this.a.a.a.finish();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\opz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */