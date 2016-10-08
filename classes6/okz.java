import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.NewFriendManager.INewFriendListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class okz
  implements NewFriendManager.INewFriendListener
{
  public okz(MainAssistObserver paramMainAssistObserver)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    this.a.f();
  }
  
  public void b()
  {
    if ((this.a.a == null) || (this.a.a.app == null)) {
      return;
    }
    ((NewFriendManager)this.a.a.app.getManager(33)).c();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\okz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */