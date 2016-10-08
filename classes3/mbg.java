import com.tencent.mobileqq.activity.PublicAccountListActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class mbg
  extends FriendListObserver
{
  public mbg(PublicAccountListActivity paramPublicAccountListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean) {
      this.a.f();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mbg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */