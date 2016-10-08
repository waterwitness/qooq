import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.os.MqqHandler;

public class mvk
  implements Runnable
{
  public mvk(TroopMemberListActivity paramTroopMemberListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.b(this.a.k, null);
    ThreadManager.c().post(new mvl(this));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mvk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */