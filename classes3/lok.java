import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.GroupManagerActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lok
  implements DialogInterface.OnDismissListener
{
  public lok(GroupManagerActivity paramGroupManagerActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    GroupManagerActivity.a(this.a, null);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lok.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */