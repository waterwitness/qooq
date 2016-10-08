import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import com.tencent.mobileqq.troop.utils.TroopFileError.TroopFileErrorObserver;
import java.lang.ref.WeakReference;

public final class vpn
  implements DialogInterface.OnClickListener
{
  public vpn()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((TroopFileError.a != null) && (TroopFileError.a.get() != null))
    {
      TroopFileError.TroopFileErrorObserver localTroopFileErrorObserver = (TroopFileError.TroopFileErrorObserver)TroopFileError.a.get();
      if (localTroopFileErrorObserver != null) {
        localTroopFileErrorObserver.a = 0;
      }
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vpn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */