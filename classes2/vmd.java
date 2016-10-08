import android.app.Activity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.data.TroopCreateLogic;
import java.util.TimerTask;

public class vmd
  extends TimerTask
{
  public vmd(TroopCreateLogic paramTroopCreateLogic)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.a != null) {
      this.a.a.runOnUiThread(new vme(this));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vmd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */