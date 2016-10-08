import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.downloadnew.MyAppApi;

public class wxe
  implements DialogInterface.OnDismissListener
{
  public wxe(MyAppApi paramMyAppApi)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.a = null;
    this.a.c = false;
    this.a.c = false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wxe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */