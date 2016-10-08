import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyProxy;
import com.tencent.mobileqq.nearby.NearbyRelevantObserver;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class lxw
  extends NearbyRelevantObserver
{
  public lxw(NotifyPushSettingActivity paramNotifyPushSettingActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean)
  {
    boolean bool = this.a.app.a().b();
    NotifyPushSettingActivity.h(this.a).setChecked(bool);
    if (!paramBoolean)
    {
      QQToast.a(this.a, "附近新鲜事通知设置失败", 0).b(this.a.getTitleBarHeight());
      QLog.i(NotifyPushSettingActivity.class.getSimpleName(), 2, "failed to set freshnews_switch ");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lxw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */