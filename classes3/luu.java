import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class luu
  implements DialogInterface.OnDismissListener
{
  public luu(MainFragment paramMainFragment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.d();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\luu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */