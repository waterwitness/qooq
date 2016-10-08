import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.aio.PlusPanel;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ndu
  implements DialogInterface.OnDismissListener
{
  public ndu(PlusPanel paramPlusPanel)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if ((this.a.a == null) || (this.a.a.isShowing())) {}
    try
    {
      this.a.a.dismiss();
      this.a.a = null;
      return;
    }
    catch (Exception paramDialogInterface)
    {
      for (;;) {}
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ndu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */