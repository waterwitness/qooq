import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.LocalMultiProcConfig;

public final class yll
  implements DialogInterface.OnClickListener
{
  public yll()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (LocalMultiProcConfig.a("qz_safe_mode_no_tip", false)) {
      LocalMultiProcConfig.b("comboqz_protect_enable", false);
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yll.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */