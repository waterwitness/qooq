import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqindividuality.QQIndividualityBridgeActivity;

public class yik
  implements DialogInterface.OnDismissListener
{
  public yik(QQIndividualityBridgeActivity paramQQIndividualityBridgeActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.a.a) {
      QQIndividualityBridgeActivity.a(this.a);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQIndividuality", 2, "dialog dismiss: " + this.a.a);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yik.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */