import com.tencent.mobileqq.activity.phone.SettingActivity2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;

public class oqa
  extends ContactBindObserver
{
  public oqa(SettingActivity2 paramSettingActivity2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    if (this.a.c != null)
    {
      this.a.app.unRegistObserver(this.a.c);
      this.a.c = null;
    }
    this.a.b();
    if (paramBoolean)
    {
      if (this.a.c != null)
      {
        this.a.app.unRegistObserver(this.a.c);
        this.a.c = null;
      }
      this.a.a();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\oqa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */