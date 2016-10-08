import android.widget.ImageButton;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.TroopBarReplyActivity;

public class vio
  implements Runnable
{
  public vio(TroopBarReplyActivity paramTroopBarReplyActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    TroopBarReplyActivity.a(this.a, 2);
    this.a.a.setSelected(true);
    this.a.b.setSelected(false);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vio.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */