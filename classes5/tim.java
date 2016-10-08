import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class tim
  implements Runnable
{
  tim(til paramtil)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      NearbySPUtil.c(this.a.jdField_a_of_type_JavaLangString);
      long l1 = this.a.c - this.a.e;
      long l2 = this.a.f - this.a.e;
      long l3 = this.a.d;
      long l4 = this.a.e;
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_DeviceType", StatisticConstants.a() + "");
      localHashMap.put("param_PreloadType", this.a.b + "");
      if ((l1 > 0L) && (l1 < 60000L) && (l2 > 0L) && (l2 < 60000L))
      {
        if (this.a.jdField_a_of_type_Int != 0) {
          break label262;
        }
        StatisticCollector.a(BaseApplicationImpl.getContext()).a(this.a.jdField_a_of_type_JavaLangString, "actEnterNearbyActCost", false, l2, l1, localHashMap, "");
      }
      while (QLog.isColorLevel())
      {
        NearbyUtils.a("NearbyProcessPerf", new Object[] { Integer.valueOf(this.a.jdField_a_of_type_Int), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3 - l4), Integer.valueOf(this.a.b) });
        return;
        label262:
        if (this.a.jdField_a_of_type_Int == 1) {
          StatisticCollector.a(BaseApplicationImpl.getContext()).a(this.a.jdField_a_of_type_JavaLangString, "actEnterNearbyActCost", true, l2, l1, localHashMap, "");
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tim.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */