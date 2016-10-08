import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.rn.BaseBusi;
import com.tencent.mobileqq.nearby.rn.NRNReportUtil;
import com.tencent.mobileqq.nearby.rn.NRNReportUtil.NRNReportAction;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class tph
  implements Runnable
{
  public tph(List paramList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    bool = NRNReportUtil.jdField_a_of_type_Boolean;
    if (NRNReportUtil.jdField_a_of_type_Boolean) {
      NRNReportUtil.jdField_a_of_type_Boolean = false;
    }
    Iterator localIterator = this.a.iterator();
    localObject = null;
    NRNReportUtil.NRNReportAction localNRNReportAction;
    if (localIterator.hasNext()) {
      localNRNReportAction = (NRNReportUtil.NRNReportAction)localIterator.next();
    }
    try
    {
      localHashMap = new HashMap();
      localHashMap.put("param_FailCode", String.valueOf(localNRNReportAction.jdField_a_of_type_Int));
      localHashMap.put("param_DeviceType", String.valueOf(StatisticConstants.a()));
      localHashMap.put("param_NetType", String.valueOf(NetworkUtil.a(null)));
      if (localNRNReportAction.jdField_a_of_type_ComTencentMobileqqNearbyRnBaseBusi == null) {
        break label972;
      }
      localHashMap.put("param_NAFrom", localNRNReportAction.jdField_a_of_type_ComTencentMobileqqNearbyRnBaseBusi.w);
      localHashMap.put("param_NABusi", String.valueOf(localNRNReportAction.jdField_a_of_type_ComTencentMobileqqNearbyRnBaseBusi.r));
    }
    catch (Exception localException3)
    {
      for (;;)
      {
        HashMap localHashMap;
        label141:
        int i;
        long l;
        continue;
        localObject = null;
        continue;
        if (bool)
        {
          i = 1;
          continue;
          l = 0L;
          continue;
          l = 0L;
          continue;
          l = 0L;
        }
      }
    }
    localHashMap.put("param_NAFirst", String.valueOf(i));
    for (;;)
    {
      try
      {
        if (("actNAOpenCost".equals(localNRNReportAction.jdField_a_of_type_JavaLangString)) && (localNRNReportAction.jdField_a_of_type_ArrayOfLong != null))
        {
          localObject = new StringBuilder(100);
          if ((localNRNReportAction.jdField_a_of_type_ArrayOfLong[0] != 0L) && (localNRNReportAction.jdField_b_of_type_Long != 0L))
          {
            l = localNRNReportAction.jdField_a_of_type_ArrayOfLong[0] - localNRNReportAction.jdField_b_of_type_Long;
            localHashMap.put("param_StepA", String.valueOf(l));
            ((StringBuilder)localObject).append("param_StepA=").append(l);
            if ((localNRNReportAction.jdField_a_of_type_ArrayOfLong[3] == 0L) || (localNRNReportAction.jdField_a_of_type_ArrayOfLong[2] == 0L)) {
              continue;
            }
            l = localNRNReportAction.jdField_a_of_type_ArrayOfLong[3] - localNRNReportAction.jdField_a_of_type_ArrayOfLong[2];
            localHashMap.put("param_StepB", String.valueOf(l));
            ((StringBuilder)localObject).append(",param_StepB=").append(l);
            if ((localNRNReportAction.jdField_a_of_type_ArrayOfLong[4] == 0L) || (localNRNReportAction.jdField_a_of_type_ArrayOfLong[3] == 0L)) {
              continue;
            }
            l = localNRNReportAction.jdField_a_of_type_ArrayOfLong[4] - localNRNReportAction.jdField_a_of_type_ArrayOfLong[3];
            localHashMap.put("param_StepC", String.valueOf(l));
            ((StringBuilder)localObject).append(",param_StepC=").append(l);
            if ((localNRNReportAction.jdField_a_of_type_ArrayOfLong[5] == 0L) || (localNRNReportAction.jdField_a_of_type_ArrayOfLong[4] == 0L)) {
              continue;
            }
            l = localNRNReportAction.jdField_a_of_type_ArrayOfLong[5] - localNRNReportAction.jdField_a_of_type_ArrayOfLong[4];
            localHashMap.put("param_StepD", String.valueOf(l));
            ((StringBuilder)localObject).append(",param_StepD=").append(l);
            if (localNRNReportAction.jdField_a_of_type_ArrayOfLong[6] == 0L) {
              break label989;
            }
            if (localNRNReportAction.jdField_a_of_type_ArrayOfLong[5] == 0L) {
              continue;
            }
            l = localNRNReportAction.jdField_a_of_type_ArrayOfLong[6] - localNRNReportAction.jdField_a_of_type_ArrayOfLong[5];
            localHashMap.put("param_StepE", String.valueOf(l));
            ((StringBuilder)localObject).append(",param_StepE=").append(l);
            if (localNRNReportAction.jdField_a_of_type_ArrayOfLong[1] == 0L) {
              break label995;
            }
            l = localNRNReportAction.jdField_a_of_type_ArrayOfLong[1] - localNRNReportAction.jdField_b_of_type_Long;
            localHashMap.put("param_StepF", String.valueOf(l));
            ((StringBuilder)localObject).append(",param_StepF=").append(l);
            localObject = ((StringBuilder)localObject).toString();
          }
        }
      }
      catch (Exception localException1)
      {
        localObject = null;
      }
      try
      {
        StatisticCollector.a(BaseApplicationImpl.getContext()).a(localNRNReportAction.jdField_b_of_type_JavaLangString, localNRNReportAction.jdField_a_of_type_JavaLangString, localNRNReportAction.jdField_a_of_type_Boolean, localNRNReportAction.jdField_a_of_type_Long, 0L, localHashMap, "");
        if (NearbyUtils.b()) {
          NearbyUtils.a("NAReport", new Object[] { "reportRN", Boolean.valueOf(bool), localNRNReportAction, localObject });
        }
      }
      catch (Exception localException2)
      {
        for (;;) {}
      }
      i = 0;
      break label141;
      l = 0L;
      continue;
      l = 0L;
      continue;
      l = 0L;
      continue;
      l = 0L;
      continue;
      if (localNRNReportAction.jdField_a_of_type_ArrayOfLong[4] == 0L) {
        break label983;
      }
      l = localNRNReportAction.jdField_a_of_type_ArrayOfLong[6] - localNRNReportAction.jdField_a_of_type_ArrayOfLong[4];
      continue;
      if ((!"actNALoadBundle".equals(localNRNReportAction.jdField_a_of_type_JavaLangString)) || (localNRNReportAction.jdField_a_of_type_ArrayOfLong == null)) {
        break label967;
      }
      localObject = new StringBuilder(100);
      if ((localNRNReportAction.jdField_a_of_type_ArrayOfLong.length > 0) && (localNRNReportAction.jdField_a_of_type_ArrayOfLong[0] > 0L))
      {
        l = localNRNReportAction.jdField_a_of_type_ArrayOfLong[0] - localNRNReportAction.jdField_b_of_type_Long;
        localHashMap.put("param_stepA", String.valueOf(l));
        ((StringBuilder)localObject).append(", param_stepA=").append(l);
      }
      if ((localNRNReportAction.jdField_a_of_type_ArrayOfLong.length > 1) && (localNRNReportAction.jdField_a_of_type_ArrayOfLong[1] > 0L) && (localNRNReportAction.jdField_a_of_type_ArrayOfLong[0] > 0L))
      {
        l = localNRNReportAction.jdField_a_of_type_ArrayOfLong[1] - localNRNReportAction.jdField_a_of_type_ArrayOfLong[0];
        localHashMap.put("param_stepB", String.valueOf(l));
        ((StringBuilder)localObject).append(", param_stepB=").append(l);
      }
      if ((localNRNReportAction.jdField_a_of_type_ArrayOfLong.length > 2) && (localNRNReportAction.jdField_a_of_type_ArrayOfLong[2] > 0L) && (localNRNReportAction.jdField_a_of_type_ArrayOfLong[1] > 0L))
      {
        l = localNRNReportAction.jdField_a_of_type_ArrayOfLong[2] - localNRNReportAction.jdField_a_of_type_ArrayOfLong[1];
        localHashMap.put("param_stepC", String.valueOf(l));
        ((StringBuilder)localObject).append(", param_stepC=").append(l);
      }
      localObject = ((StringBuilder)localObject).toString();
      continue;
      localException1.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */