import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.mobileqq.activity.UpgradeActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class mzu
  implements DialogInterface.OnKeyListener
{
  public mzu(UpgradeActivity paramUpgradeActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      this.a.finish();
      this.a.b();
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mzu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */