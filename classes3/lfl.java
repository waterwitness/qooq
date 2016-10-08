import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.DialogActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lfl
  implements DialogInterface.OnClickListener
{
  public lfl(DialogActivity paramDialogActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.cancel();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lfl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */