import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richstatus.EditActivity;

public class uho
  implements DialogInterface.OnDismissListener
{
  public uho(EditActivity paramEditActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.g();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\uho.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */