import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qlink.QlinkStandardDialogActivity;

public class yfm
  implements DialogInterface.OnClickListener
{
  public yfm(QlinkStandardDialogActivity paramQlinkStandardDialogActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yfm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */