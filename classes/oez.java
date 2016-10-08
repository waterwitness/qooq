import android.widget.Toast;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.activity.aio.tips.TroopAssistTipsBar;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class oez
  implements Runnable
{
  public oez(TroopAssistTipsBar paramTroopAssistTipsBar)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((TroopAssistTipsBar.a(this.a).b(TroopAssistTipsBar.a(this.a).a) != 2) && (TroopAssistTipsBar.a(this.a).b(TroopAssistTipsBar.a(this.a).a) != 3)) {}
    do
    {
      do
      {
        return;
        if (TroopAssistantManager.a().c(TroopAssistTipsBar.a(this.a), TroopAssistTipsBar.a(this.a).a)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(TroopAssistTipsBar.a(), 2, "getTroopAssistTipInRange false, return ");
      return;
      if (this.a.a != null) {
        this.a.a.cancel();
      }
    } while (!TroopAssistTipsBar.a(this.a).a(this.a, new Object[0]));
    TroopAssistantManager.a().c(TroopAssistTipsBar.a(this.a), TroopAssistTipsBar.a(this.a).a);
    ReportController.b(TroopAssistTipsBar.a(this.a), "CliOper", "", "", "Grp_helper", "Aio_grp_banner", 0, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oez.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */