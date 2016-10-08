import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class mfz
  extends BroadcastReceiver
{
  public mfz(QQSettingMe paramQQSettingMe)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, "UpdateVipInfoReceiver: intent=" + paramIntent.toString());
    }
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("key_pay_action_result", false)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "UpdateVipInfoReceiver: need update ");
      }
      this.a.v();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mfz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */