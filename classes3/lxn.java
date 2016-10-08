import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.NotifyPCActiveActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lxn
  implements DialogInterface.OnClickListener
{
  public lxn(NotifyPCActiveActivity paramNotifyPCActiveActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    BaseApplicationImpl.a().a(null, null, null, null);
    this.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lxn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */