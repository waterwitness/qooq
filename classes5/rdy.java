import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.dating.DatingManager;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import mqq.app.MobileQQ;

public class rdy
  implements Runnable
{
  public rdy(DatingManager paramDatingManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    SharedPreferences.Editor localEditor = this.a.a.getApplication().getSharedPreferences(this.a.a.a(), 0).edit();
    localEditor.putString("inprocess_dating_id", DatingManager.a(this.a));
    localEditor.commit();
    DatingUtil.a("saveInProcessDatingId", new Object[] { DatingManager.a(this.a) });
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rdy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */