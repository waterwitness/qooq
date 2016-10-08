import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class obn
  implements BusinessObserver
{
  public obn(PublicAccountChatPie paramPublicAccountChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      QLog.i("SSOHttpUtils", 2, "PublicAccount RefreshStepsObserver onReceive");
      ThreadManager.a(new obo(this), 5, null, true);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\obn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */