import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;

public class lnv
  implements DialogInterface.OnDismissListener
{
  public lnv(GesturePWDUnlockActivity paramGesturePWDUnlockActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (!GesturePWDUnlockActivity.a(this.a))
    {
      GesturePWDUnlockActivity.a(this.a, true);
      return;
    }
    this.a.e();
    GesturePWDUtils.setGestureUnlockFailedType(this.a, 1);
    StatisticCollector.a(this.a.getBaseContext()).a(this.a.app, this.a.app.a(), "Gesture_pwd", "click_wrong_pwd", 0, 1, "0", null, null, null, null);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lnv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */