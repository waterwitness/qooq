import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.GroupManagerActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lob
  implements DialogInterface.OnDismissListener
{
  public lob(GroupManagerActivity paramGroupManagerActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    GroupManagerActivity.b(this.a, null);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lob.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */