import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public final class rgg
  implements Runnable
{
  public rgg(int paramInt, String paramString, boolean paramBoolean, long paramLong)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(this.jdField_a_of_type_Int));
    StatisticCollector.a(BaseApplicationImpl.getContext()).a(this.jdField_a_of_type_JavaLangString, "actEnterHotChatAIO", this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, localHashMap, "");
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a("NearbyTransitActivity", "reportResult", new Object[] { "end of report" });
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rgg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */