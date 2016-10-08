import com.tencent.mobileqq.activity.AuthDevRenameActivity;
import com.tencent.mobileqq.app.SecSvcObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;

public class klk
  extends SecSvcObserver
{
  public klk(AuthDevRenameActivity paramAuthDevRenameActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, int paramInt, byte[] paramArrayOfByte, String paramString)
  {
    AuthDevRenameActivity.a(this.a);
    if (!paramBoolean)
    {
      QQToast.a(this.a, this.a.getString(2131370767), 0).b(this.a.getTitleBarHeight());
      return;
    }
    this.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\klk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */