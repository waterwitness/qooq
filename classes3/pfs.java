import com.tencent.mobileqq.activity.selectmember.PhoneContactSelectActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.qcall.PstnObserver;

public class pfs
  extends PstnObserver
{
  public pfs(PhoneContactSelectActivity paramPhoneContactSelectActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (this.a.a != null)
    {
      this.a.app.b(this.a.a);
      this.a.a = null;
    }
    this.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pfs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */