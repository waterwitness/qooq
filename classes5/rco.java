import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.dating.BaseMsgBoxActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class rco
  extends FriendListObserver
{
  public rco(BaseMsgBoxActivity paramBaseMsgBoxActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (!this.a.a) {
      return;
    }
    this.a.runOnUiThread(new rcp(this, paramBoolean, paramString));
  }
  
  protected void b(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (!this.a.a) {
      return;
    }
    this.a.runOnUiThread(new rcq(this, paramBoolean, paramString1, paramString2));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rco.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */