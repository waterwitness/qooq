import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.equipmentlock.DevlockPhoneStatus;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class rli
  implements DialogInterface.OnClickListener
{
  public rli(DevlockPhoneStatus paramDevlockPhoneStatus)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\rli.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */