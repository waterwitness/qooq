import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class mrj
  implements DialogInterface.OnClickListener
{
  public mrj(TroopInfoActivity paramTroopInfoActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mrj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */