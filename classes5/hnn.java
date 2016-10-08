import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.util.WeakReference;

public class hnn
  extends FriendListObserver
{
  WeakReference a;
  
  public hnn(AccountDetailActivity paramAccountDetailActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new WeakReference(paramAccountDetailActivity);
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    AccountDetailActivity localAccountDetailActivity = (AccountDetailActivity)this.a.get();
    if (localAccountDetailActivity == null) {}
    while ((localAccountDetailActivity.k) || (!paramBoolean) || (!paramString.equals(localAccountDetailActivity.p))) {
      return;
    }
    localAccountDetailActivity.R();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hnn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */