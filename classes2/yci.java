import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.huangye.HYBlankActivity;

public class yci
  implements DialogInterface.OnDismissListener
{
  public yci(HYBlankActivity paramHYBlankActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    HYBlankActivity.b(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yci.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */