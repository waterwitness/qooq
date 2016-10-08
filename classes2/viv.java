import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.TroopBarShareActivity;
import com.tencent.mobileqq.utils.TroopBarShareUtils;

public class viv
  implements DialogInterface.OnClickListener
{
  public viv(TroopBarShareActivity paramTroopBarShareActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.a.finish();
      TroopBarShareUtils.a(this.a.app, "suc_app", this.a.b);
      return;
    }
    TroopBarShareUtils.a(this.a.app, "suc_tribe", this.a.b);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\viv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */