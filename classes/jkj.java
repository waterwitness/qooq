import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import java.util.HashMap;

public class jkj
  implements Runnable
{
  public jkj(BaseApplicationImpl paramBaseApplicationImpl, int paramInt, String paramString) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_retryIndex", Integer.toString(this.jdField_a_of_type_Int));
    localHashMap.put("param_uin", this.jdField_a_of_type_JavaLangString);
    StatisticCollector.a(BaseApplicationImpl.a()).a(this.jdField_a_of_type_JavaLangString, "PcActiveSuccB", true, 0L, 0L, localHashMap, "", true);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\jkj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */