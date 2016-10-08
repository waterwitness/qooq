import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.AccountManager;

public class kxc
  extends BroadcastReceiver
{
  public kxc(ChatHistoryForC2C paramChatHistoryForC2C)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ((TextUtils.isEmpty(paramContext)) || (!TextUtils.equals(paramContext, "mqq.intent.action.DEVLOCK_ROAM"))) {}
    int j;
    label110:
    label225:
    label231:
    do
    {
      return;
      this.a.getApplicationContext().unregisterReceiver(this.a.a);
      boolean bool = paramIntent.getBooleanExtra("auth_dev_open", false);
      j = paramIntent.getIntExtra("auth_dev_open_cb_reason", 0);
      paramIntent = paramIntent.getByteArrayExtra("devlock_roam_sig");
      int i;
      QQAppInterface localQQAppInterface;
      String str;
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder().append("openDevLock callback isOpen: ").append(bool).append(", reason: ").append(j).append(", da2 length: ");
        if (paramIntent == null)
        {
          i = 0;
          QLog.d("ChatHistoryForC2C", 2, i);
        }
      }
      else
      {
        localQQAppInterface = this.a.app;
        str = j + "";
        if (!bool) {
          break label225;
        }
      }
      for (paramContext = "true";; paramContext = "false")
      {
        VipUtils.a(localQQAppInterface, "chat_history", "LockSet", "opendev_amount", 1, 0, new String[] { str, "0", paramContext });
        if (!this.a.isFinishing()) {
          break label231;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ChatHistoryForC2C", 2, "openDevLock callback but activity is finishing...");
        return;
        i = paramIntent.length;
        break label110;
      }
      if (bool)
      {
        if ((paramIntent != null) && (paramIntent.length > 0))
        {
          ChatHistoryForC2C.b(this.a, false);
          return;
        }
        paramContext = (AccountManager)this.a.app.getManager(0);
        if (paramContext != null)
        {
          ChatHistoryForC2C.a(this.a);
          paramContext.refreshDA2(this.a.app.a(), new kxd(this));
          return;
        }
        ChatHistoryForC2C.b(this.a);
        return;
      }
      if ((2 != j) && (3 != j)) {
        break;
      }
      ChatHistoryForC2C.b(this.a, false);
    } while (2 != j);
    VipUtils.a(this.a.app, "chat_history", "LockSet", "Clk_PswUse", 1, 0, new String[0]);
    return;
    ChatHistoryForC2C.b(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kxc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */