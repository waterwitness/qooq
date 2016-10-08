import android.os.Build.VERSION;
import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.startup.director.StartupDirector;
import com.tencent.mobileqq.startup.step.NewRuntime;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import java.util.HashMap;

public class uti
  implements Runnable
{
  public uti(StartupDirector paramStartupDirector, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6) {}
  
  public void run()
  {
    Object localObject;
    QQAppInterface localQQAppInterface;
    if (BaseApplicationImpl.i == 1)
    {
      if (this.jdField_a_of_type_Long > 0L) {
        StatisticCollector.a(BaseApplicationImpl.a).a(null, "actLoginA", true, this.jdField_a_of_type_Long, 0L, null, null);
      }
      if (this.b > 0L)
      {
        localObject = BaseApplicationImpl.a.a();
        if ((localObject != null) && ((localObject instanceof QQAppInterface)))
        {
          localQQAppInterface = (QQAppInterface)localObject;
          if (this.b != 2201L) {
            break label461;
          }
          localObject = "1";
          ReportController.b(localQQAppInterface, "CliOper", "", "", "0X80064F6", "0X80064F6", 0, 0, (String)localObject, "", "", "");
        }
      }
      if (this.c > 0L)
      {
        Log.i("AutoMonitor", "ActionLoginM, cost=" + this.d);
        localObject = new HashMap();
        ((HashMap)localObject).put("cost", this.d + "");
        StatisticCollector.a(BaseApplicationImpl.a).a(null, "actLoginM", true, this.d, 0L, (HashMap)localObject, null);
      }
      if ((this.e > 0L) && (this.f < 30000L))
      {
        Log.i("AutoMonitor", "ActionLoginS, cost=" + this.f);
        localObject = new HashMap();
        ((HashMap)localObject).put("cost", this.f + "");
        StatisticCollector.a(BaseApplicationImpl.a).a(null, "actLoginS", true, this.f, 0L, (HashMap)localObject, null);
      }
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.a.a();
      localObject = localQQAppInterface.getAccount();
      if ((localObject != null) && (((String)localObject).length() != 0)) {
        break label484;
      }
      localObject = "0";
    }
    label461:
    label484:
    for (;;)
    {
      ReportController.a(localQQAppInterface, "P_CliOper", "Vip_login_upload", "", "upload", "report", 0, 0, AppSetting.a(BaseApplicationImpl.a, (String)localObject), "", "", "");
      if ("Success".equals(BaseApplicationImpl.sInjectResult)) {
        UnifiedMonitor.a().a();
      }
      if (Build.VERSION.SDK_INT < 16)
      {
        localObject = new HashMap();
        ((HashMap)localObject).put("result", NewRuntime.jdField_a_of_type_Long + "");
        ((HashMap)localObject).put("device", DeviceInfoUtil.d());
        ((HashMap)localObject).put("osVersion", DeviceInfoUtil.e());
        StatisticCollector.a(BaseApplicationImpl.a).a(null, "LinearAllocReplace", true, 0L, 0L, (HashMap)localObject, null);
      }
      return;
      if (this.b == 2200L)
      {
        localObject = "3";
        break;
      }
      localObject = "2";
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\uti.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */