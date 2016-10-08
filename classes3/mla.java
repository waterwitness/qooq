import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.ShortcutRouterActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class mla
  implements DialogInterface.OnDismissListener
{
  public mla(ShortcutRouterActivity paramShortcutRouterActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mla.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */