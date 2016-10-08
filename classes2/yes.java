import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qlink.QlinkBridgeActivity;

public class yes
  implements DialogInterface.OnClickListener
{
  public yes(QlinkBridgeActivity paramQlinkBridgeActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */