import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.PubAccBindTroopListActivity;
import mqq.os.MqqHandler;

public class vfg
  extends MqqHandler
{
  public vfg(PubAccBindTroopListActivity paramPubAccBindTroopListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (!this.a.app.isLogin()) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      this.a.a();
      return;
    }
    this.a.a();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */