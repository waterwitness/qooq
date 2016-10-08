import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings.System;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import mqq.os.MqqHandler;

public class ldo
  extends BroadcastReceiver
{
  public ldo(Conversation paramConversation)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (("android.intent.action.TIME_SET".equals(paramContext)) || ("android.intent.action.TIMEZONE_CHANGED".equals(paramContext)) || ("android.intent.action.DATE_CHANGED".equals(paramContext)))
    {
      paramContext = Settings.System.getString(this.a.a().getContentResolver(), "date_format");
      if ((Conversation.a(this.a) != null) && (TimeManager.a().a(paramContext)) && (Conversation.a(this.a)))
      {
        this.a.a(1014, 0L, false);
        this.a.s();
      }
      SubAccountControll.b(this.a.a, paramContext);
      if (this.a.a != null)
      {
        paramContext = this.a.a.a(TroopAssistantActivity.class);
        if (paramContext != null) {
          paramContext.sendEmptyMessage(2);
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ldo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */