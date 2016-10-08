import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class wsw
  implements DialogInterface.OnDismissListener
{
  wsw(wsv paramwsv)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.a.tipDialog = null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wsw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */