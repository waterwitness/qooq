import android.os.Bundle;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.channel.QQStoryCmdHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.observer.BusinessObserver;

public class iiv
  implements BusinessObserver
{
  public iiv(QQStoryCmdHandler paramQQStoryCmdHandler, long paramLong, NetworkRequest paramNetworkRequest)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    new iiw(this, paramBoolean, paramBundle).a(new Void[0]);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iiv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */