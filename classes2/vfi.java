import android.os.Message;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.PubAccBindTroopListActivity;
import java.util.Map;
import mqq.os.MqqHandler;

public class vfi
  extends FriendListObserver
{
  public vfi(PubAccBindTroopListActivity paramPubAccBindTroopListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a()
  {
    this.a.a();
  }
  
  protected void a(boolean paramBoolean, String paramString) {}
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if (paramBoolean) {
      this.a.a.sendEmptyMessage(1);
    }
  }
  
  protected void a(boolean paramBoolean, Map paramMap)
  {
    if (paramBoolean) {
      this.a.a.sendEmptyMessage(1);
    }
  }
  
  void b(String paramString)
  {
    if (!paramString.equals(this.a.app.getAccount())) {
      return;
    }
    this.a.a.obtainMessage(1).sendToTarget();
    this.a.runOnUiThread(new vfj(this));
  }
  
  protected void b(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      b(paramString);
    }
  }
  
  protected void b(boolean paramBoolean, String[] paramArrayOfString)
  {
    if (paramBoolean) {
      ThreadManager.a(new vfk(this), 5, null, true);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vfi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */