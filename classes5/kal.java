import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.device.JNICallCenter.DataPoint;
import com.tencent.device.msg.activities.DeviceTipActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.qphone.base.util.QLog;

public class kal
  extends BroadcastReceiver
{
  static final String jdField_a_of_type_JavaLangString = "reason";
  static final String b = "homekey";
  static final String c = "rencentkeys";
  
  public kal(DeviceTipActivity paramDeviceTipActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS"))
    {
      paramContext = paramIntent.getStringExtra("reason");
      if ((paramContext != null) && (paramContext.equals("homekey"))) {
        this.a.finish();
      }
    }
    long l;
    do
    {
      do
      {
        do
        {
          return;
          if (paramContext.equals("android.intent.action.SCREEN_OFF"))
          {
            AudioUtil.a();
            return;
          }
          if (paramContext.equals("android.intent.action.SCREEN_ON"))
          {
            AudioUtil.a(2131165199, -1, null);
            return;
          }
          if (!paramContext.equals("SmartDevice_receiveDPMsg")) {
            break;
          }
        } while ((DataPoint)paramIntent.getExtras().getParcelable("dataPoint") != null);
        return;
      } while (!paramContext.equals("On_OccupyMicrophoneNotify_Push"));
      if (QLog.isColorLevel()) {
        QLog.d(DeviceTipActivity.a, 2, "DeviceTipActivity intent.getExtras() : " + paramIntent.getExtras());
      }
      paramContext = paramIntent.getExtras();
      l = paramContext.getLong("din", 0L);
      paramContext = paramContext.getString("uin", "");
    } while ((!this.a.b.equals(String.valueOf(Long.valueOf(l)))) || (TextUtils.isEmpty(paramContext)));
    this.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\kal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */