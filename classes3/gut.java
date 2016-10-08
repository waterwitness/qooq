import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.av.ui.MultiIncomingCallsActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class gut
  implements DialogInterface.OnDismissListener
{
  public gut(MultiIncomingCallsActivity paramMultiIncomingCallsActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d(MultiIncomingCallsActivity.a, 2, "destroyUI when dialog dismiss");
    }
    this.a.b();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gut.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */