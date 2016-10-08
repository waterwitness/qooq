import android.os.Handler;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class muj
  implements Runnable
{
  public muj(TroopMemberListActivity paramTroopMemberListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.a.J == 1) || (this.a.J == 11))
    {
      Object[] arrayOfObject = this.a.a(this.a.k);
      this.a.a.sendMessage(this.a.a.obtainMessage(1, arrayOfObject));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\muj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */