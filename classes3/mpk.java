import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class mpk
  implements Runnable
{
  public mpk(TroopAssistantActivity paramTroopAssistantActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      List localList = this.a.a();
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("data|size");
        if (localList != null) {
          break label64;
        }
      }
      label64:
      for (int i = 0;; i = localList.size())
      {
        QLog.i("TroopAssistantActivity", 2, i);
        this.a.runOnUiThread(new mpl(this, localList));
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      ReportController.b(this.a.app, "P_CliOper", "BizTechReport", "", "troop_assistant", "load_data_failed", 0, 0, localException.toString(), "", "", "");
      if (QLog.isColorLevel()) {
        QLog.i("TroopAssistantActivity", 2, localException.toString());
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mpk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */