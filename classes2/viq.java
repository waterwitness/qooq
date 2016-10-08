import android.widget.ImageButton;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.TroopBarReplyActivity;

public class viq
  implements Runnable
{
  public viq(TroopBarReplyActivity paramTroopBarReplyActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    TroopBarReplyActivity.a(this.a, 3);
    this.a.a.setSelected(false);
    this.a.b.setSelected(true);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\viq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */