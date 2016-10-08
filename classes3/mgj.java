import com.tencent.mobileqq.activity.QQSettingMsgHistoryActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class mgj
  extends FriendListObserver
{
  public mgj(QQSettingMsgHistoryActivity paramQQSettingMsgHistoryActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void b(boolean paramBoolean, Map paramMap)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("SecuritySettingActivity", 2, "onSetGeneralSettingsC2CRoaming issuc =" + paramBoolean);
    }
    this.a.e();
    if (paramBoolean)
    {
      QQToast.a(this.a.getApplicationContext(), 2, 2131369191, 0).b(this.a.getTitleBarHeight());
      return;
    }
    if (QQSettingMsgHistoryActivity.a(this.a) != null)
    {
      QQSettingMsgHistoryActivity.a(this.a).setOnCheckedChangeListener(null);
      paramMap = QQSettingMsgHistoryActivity.a(this.a);
      if (this.a.app.f() != 1) {
        break label159;
      }
    }
    label159:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      paramMap.setChecked(paramBoolean);
      QQSettingMsgHistoryActivity.a(this.a).setOnCheckedChangeListener(this.a);
      QQToast.a(this.a.getApplicationContext(), 2131369192, 0).b(this.a.getTitleBarHeight());
      return;
    }
  }
  
  protected void c(boolean paramBoolean)
  {
    if (paramBoolean) {
      QQSettingMsgHistoryActivity.b(this.a);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mgj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */