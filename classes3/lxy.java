import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class lxy
  extends Handler
{
  public lxy(NotifyPushSettingActivity paramNotifyPushSettingActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    for (;;)
    {
      try
      {
        int i = paramMessage.what;
        switch (i)
        {
        default: 
          return;
        }
      }
      finally {}
      boolean bool = ((Boolean)paramMessage.obj).booleanValue();
      NotifyPushSettingActivity.g(this.a).setChecked(bool);
      continue;
      paramMessage = (String)paramMessage.obj;
      NotifyPushSettingActivity.a(this.a, paramMessage);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */