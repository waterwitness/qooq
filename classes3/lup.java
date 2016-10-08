import com.tencent.biz.now.NowLiveManager;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.observer.GetRedPointExObserver;

public class lup
  extends GetRedPointExObserver
{
  public lup(MainFragment paramMainFragment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a()
  {
    if (!MainFragment.a(this.a).a().a) {
      return;
    }
    MainFragment.a(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */