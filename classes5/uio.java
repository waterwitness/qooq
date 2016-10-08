import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richstatus.EditActivity;

public class uio
  implements DialogInterface.OnClickListener
{
  public uio(EditActivity paramEditActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.cancel();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\uio.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */