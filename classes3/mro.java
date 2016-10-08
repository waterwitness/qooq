import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.TroopLowCreditLevelNotifyActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class mro
  implements DialogInterface.OnClickListener
{
  public mro(TroopLowCreditLevelNotifyActivity paramTroopLowCreditLevelNotifyActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mro.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */