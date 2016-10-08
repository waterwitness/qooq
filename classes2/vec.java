import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.NearbyMemberActivity;
import com.tencent.mobileqq.troop.widget.RadarView;
import com.tencent.qphone.base.util.QLog;

public class vec
  extends BroadcastReceiver
{
  public vec(NearbyMemberActivity paramNearbyMemberActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("android.intent.action.SCREEN_ON".equals(paramContext))
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyMemberActivity.troop.nearby_mem", 2, "ACTION_SCREEN_ON");
      }
      if (this.a.a != null) {
        this.a.a.setStartScan(true);
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (!"android.intent.action.SCREEN_OFF".equals(paramContext)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("NearbyMemberActivity.troop.nearby_mem", 2, "ACTION_SCREEN_OFF");
          }
        } while (this.a.a == null);
        this.a.a.setStartScan(false);
        return;
      } while (!"android.intent.action.USER_PRESENT".equals(paramContext));
      if (QLog.isColorLevel()) {
        QLog.d("NearbyMemberActivity.troop.nearby_mem", 2, "ACTION_USER_PRESENT");
      }
    } while (this.a.a == null);
    this.a.a.setStartScan(true);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */