import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class knc
  extends BroadcastReceiver
{
  public knc(BaseChatPie paramBaseChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("tencent.av.v2q.StartVideoChat".equals(paramContext))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "receive action_recv_video_request");
      }
      this.a.e(2);
    }
    do
    {
      do
      {
        do
        {
          return;
          if (!"android.intent.action.PHONE_STATE".equals(paramContext)) {
            break;
          }
          paramContext = (TelephonyManager)this.a.jdField_a_of_type_AndroidContentContext.getSystemService("phone");
          if (paramContext.getCallState() == 1)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.aio.BaseChatPie", 2, "receive action_phone_state_changed|call_state_ringing");
            }
            this.a.e(2);
          }
        } while (paramContext.getCallState() != 1);
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.BaseChatPie", 2, "receive action_phone_state_changed|call_state_ringing");
        }
        paramContext = MediaPlayerManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      } while (!paramContext.b());
      paramContext.a(false);
      return;
    } while ((BaseChatPie.h() != 1) || (!"vivo_smart_shot_enter".equals(paramContext)));
    if (QLog.isColorLevel()) {
      QLog.d("vivo", 2, "receive action_vivo_smart_shot_enter");
    }
    BaseChatPie.a(this.a, Boolean.valueOf(false));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\knc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */