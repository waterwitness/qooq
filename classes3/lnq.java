import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.GesturePWDSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class lnq
  implements CompoundButton.OnCheckedChangeListener
{
  public lnq(GesturePWDSettingActivity paramGesturePWDSettingActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int j = 1;
    paramCompoundButton = this.a;
    String str = this.a.app.a();
    if (paramBoolean)
    {
      i = 2;
      GesturePWDUtils.setGesturePWDState(paramCompoundButton, str, i);
      this.a.a(paramBoolean);
      paramCompoundButton = this.a.app;
      if (!paramBoolean) {
        break label96;
      }
    }
    label96:
    for (int i = j;; i = 0)
    {
      ReportController.b(paramCompoundButton, "CliOper", "", "", "Setting_tab", "Setting_Gesture_password", 0, i, "", "", "", "");
      this.a.a();
      return;
      i = 1;
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lnq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */