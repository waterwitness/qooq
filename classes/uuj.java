import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;

public class uuj
  implements Runnable
{
  public uuj(StatisticCollector paramStatisticCollector, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      SharedPreferences localSharedPreferences = StatisticCollector.a().getSharedPreferences("crashcontrol", 0);
      if ((localSharedPreferences != null) && (localSharedPreferences.getBoolean("shouldStopMsf", false)))
      {
        this.jdField_a_of_type_ComTencentMobileqqStatisticsStatisticCollector.a(this.jdField_a_of_type_JavaLangString, "actKillMsf", true, 0L, 0L, null, "");
        localSharedPreferences.edit().putBoolean("shouldStopMsf", false).commit();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\uuj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */