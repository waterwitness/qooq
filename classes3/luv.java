import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class luv
  implements DialogInterface.OnDismissListener
{
  public luv(MainFragment paramMainFragment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (paramDialogInterface == this.a.a) {
      this.a.a = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\luv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */