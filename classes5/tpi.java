import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;

public final class tpi
  implements Runnable
{
  public tpi(String paramString, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      boolean bool = ((Boolean)NearbySPUtil.a(this.jdField_a_of_type_JavaLangString, "key_rn_soready_reported", Boolean.valueOf(false))).booleanValue();
      if (!bool)
      {
        StatisticCollector.a(BaseApplicationImpl.getContext()).a(this.jdField_a_of_type_JavaLangString, "actRNSoReady", this.jdField_a_of_type_Boolean, 0L, 0L, null, "");
        NearbySPUtil.a(this.jdField_a_of_type_JavaLangString, "key_rn_soready_reported", Boolean.valueOf(true));
      }
      if (NearbyUtils.b()) {
        NearbyUtils.a("NAReport", new Object[] { "reportRNSoReady", this.jdField_a_of_type_JavaLangString, Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(bool) });
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */