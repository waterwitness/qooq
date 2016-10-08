import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.activity.aio.tips.TroopAssistTipsBar;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.statistics.ReportController;

public class ofa
  implements View.OnClickListener
{
  public ofa(TroopAssistTipsBar paramTroopAssistTipsBar)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    QQAppInterface localQQAppInterface;
    String str;
    if (this.a.a())
    {
      TroopAssistantManager.a().a(TroopAssistTipsBar.a(this.a), TroopAssistTipsBar.a(this.a).a);
      TroopAssistTipsBar.a(this.a).a();
      localQQAppInterface = TroopAssistTipsBar.a(this.a);
      str = TroopAssistTipsBar.a(this.a).a;
      if (TroopAssistTipsBar.a(this.a).b(TroopAssistTipsBar.a(this.a).a) != 3) {
        break label112;
      }
    }
    label112:
    for (paramView = "1";; paramView = "0")
    {
      ReportController.b(localQQAppInterface, "dc00899", "Grp_msg", "", "aio-topbar", "Clk_close", 0, 0, str, paramView, "", "");
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ofa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */