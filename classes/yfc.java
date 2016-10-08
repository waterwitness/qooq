import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qlink.QlinkShareJumpActivity;

public class yfc
  implements DialogInterface.OnClickListener
{
  public yfc(QlinkShareJumpActivity paramQlinkShareJumpActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\yfc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */