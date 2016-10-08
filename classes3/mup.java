import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Handler;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class mup
  implements DialogInterface.OnDismissListener
{
  public mup(TroopMemberListActivity paramTroopMemberListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.a.postDelayed(new mwd(this.a), 150L);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */