import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class mri
  implements DialogInterface.OnClickListener
{
  public mri(TroopInfoActivity paramTroopInfoActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.i();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mri.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */