import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQTabWidget.onTabWidgetTouchMoveListener;
import com.tencent.qphone.base.util.QLog;

public class luo
  implements QQTabWidget.onTabWidgetTouchMoveListener
{
  public luo(MainFragment paramMainFragment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    int i = GesturePWDUtils.getGesturePWDState(MainFragment.a(this.a).a(), MainFragment.a(this.a).a());
    int j = GesturePWDUtils.getGesturePWDMode(MainFragment.a(this.a).a(), MainFragment.a(this.a).a());
    if ((i == 2) && (j == 20))
    {
      if (QLog.isColorLevel()) {
        QLog.d("mainactivity", 2, "gesturepwd manual move.");
      }
      ((SplashActivity)this.a.getActivity()).startUnlockActivity();
      this.a.getActivity().overridePendingTransition(2130968592, 2130968589);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\luo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */