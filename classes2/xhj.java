import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;

public class xhj
  implements DialogInterface.OnClickListener
{
  public xhj(OpenSDKAppInterface paramOpenSDKAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xhj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */