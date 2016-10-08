import com.tencent.mobileqq.app.CircleManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.observer.AccountObserver;

public class pux
  extends AccountObserver
{
  public pux(CircleManager paramCircleManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onExchangeUin(String paramString1, String paramString2, String paramString3)
  {
    CircleManager.a(this.a).a(new puy(this));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pux.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */