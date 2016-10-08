import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.OldBigDataChannelManager;
import mqq.observer.AccountObserver;
import mqq.os.MqqHandler;

public class tin
  extends AccountObserver
{
  public tin(OldBigDataChannelManager paramOldBigDataChannelManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onExchangeUin(String paramString1, String paramString2, String paramString3)
  {
    ThreadManager.a().post(new tio(this));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */