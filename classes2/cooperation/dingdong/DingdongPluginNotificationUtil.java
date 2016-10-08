package cooperation.dingdong;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class DingdongPluginNotificationUtil
{
  public static final String a = "_dingdong_notification_schedule_has_flag_";
  public static final String b = "_dingdong_notification_schedule_id_";
  private static final String c = "DingdongPluginNotificationUtil";
  
  public DingdongPluginNotificationUtil()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(Activity paramActivity, Intent paramIntent)
  {
    paramIntent = paramIntent.getStringExtra("_dingdong_notification_schedule_id_");
    Intent localIntent = new Intent();
    localIntent.putExtra("schedule_feed_id", paramIntent);
    DingdongPluginHelper.a(paramActivity, "com.dingdong.business.Schedule.Activity.ScheduleDetailActivity", localIntent, -1);
    paramActivity.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\dingdong\DingdongPluginNotificationUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */