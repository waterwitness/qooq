import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.phone.BaseActivityView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class onv
  implements DialogInterface.OnDismissListener
{
  public onv(BaseActivityView paramBaseActivityView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.a = null;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\onv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */