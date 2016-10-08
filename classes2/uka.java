import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.rn.RNReportImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import java.util.HashMap;

public class uka
  implements Runnable
{
  public uka(RNReportImpl paramRNReportImpl, SparseArray paramSparseArray, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int j;
    ukb localukb;
    String str;
    try
    {
      if (!NearbyUtils.a()) {
        break label751;
      }
      localStringBuilder = new StringBuilder();
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder;
      localException.printStackTrace();
      return;
    }
    HashMap localHashMap;
    int i;
    label294:
    Object localObject2;
    Object localObject3;
    if (j < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      if (j > 0) {
        localStringBuilder.append(" , ");
      }
      localukb = (ukb)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(j));
      if ((localukb == null) || (localukb.jdField_b_of_type_Long <= 0L) || (localukb.jdField_b_of_type_Long > 3600000L)) {
        break label759;
      }
      str = (String)this.jdField_a_of_type_ComTencentMobileqqRnRNReportImpl.jdField_a_of_type_AndroidUtilSparseArray.get(localukb.g);
      if (str == null)
      {
        if (!NearbyUtils.a()) {
          break label759;
        }
        NearbyUtils.a("RNReportImpl", "realReport", new Object[] { "tag is null", localukb.toString() });
        break label759;
      }
      if (localException != null) {
        localException.append("[").append(str).append(", cost=").append(localukb.jdField_b_of_type_Long).append(", failCode=").append(localukb.h).append(", lastStep=").append(localukb.jdField_a_of_type_Int).append(", key=").append(this.jdField_a_of_type_JavaLangString);
      }
      localHashMap = new HashMap();
      localHashMap.put("param_FailCode", String.valueOf(localukb.h));
      localHashMap.put("param_DeviceType", String.valueOf(StatisticConstants.a()));
      localHashMap.put("param_NetType", String.valueOf(NetworkUtil.a(null)));
      localHashMap.put("param_LastStep", String.valueOf(localukb.jdField_a_of_type_Int));
      localHashMap.put("param_Key", this.jdField_a_of_type_JavaLangString);
      i = 0;
      if (i < localukb.jdField_a_of_type_AndroidUtilSparseArray.size())
      {
        localObject2 = (ukc)localukb.jdField_a_of_type_AndroidUtilSparseArray.get(localukb.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i));
        if (localObject2 == null) {
          break label768;
        }
        localObject3 = (String)this.jdField_a_of_type_ComTencentMobileqqRnRNReportImpl.b.get(((ukc)localObject2).g);
        if ((localObject3 == null) || (((String)localObject3).length() <= 0)) {
          break label768;
        }
        localHashMap.put(localObject3, String.valueOf(((ukc)localObject2).jdField_b_of_type_Long));
        if (localException == null) {
          break label768;
        }
        localException.append(", ").append((String)localObject3).append("=").append(((ukc)localObject2).jdField_b_of_type_Long);
        break label768;
      }
      if (localukb.g == 2)
      {
        localObject2 = (ukb)this.jdField_a_of_type_AndroidUtilSparseArray.get(21);
        localObject3 = (ukb)this.jdField_a_of_type_AndroidUtilSparseArray.get(22);
        if (localObject2 == null) {
          break label777;
        }
        if (((ukb)localObject2).jdField_b_of_type_Int == 3)
        {
          break label777;
          label469:
          localHashMap.put("param_CacheFlag", String.valueOf(i));
          label482:
          localObject2 = StatisticCollector.a(BaseApplicationImpl.getContext());
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqRnRNReportImpl.c;
          if (localukb.h != 0) {
            break label796;
          }
        }
      }
    }
    label751:
    label759:
    label768:
    label777:
    label783:
    label789:
    label796:
    for (boolean bool = true;; bool = false)
    {
      ((StatisticCollector)localObject2).a((String)localObject3, str, bool, localukb.jdField_b_of_type_Long, 0L, localHashMap, "");
      if (localException != null)
      {
        localException.append("]");
        break label759;
        if (((ukb)localObject2).jdField_b_of_type_Int == 1)
        {
          i = 2;
          break label469;
        }
        if ((((ukb)localObject2).c == 3) || (localObject3 == null)) {
          break label783;
        }
        if (((ukb)localObject3).d == 2)
        {
          i = 4;
          break label469;
        }
        if (((ukb)localObject3).e != 3) {
          break label789;
        }
        i = 5;
        break label469;
        if (localukb.g == 21)
        {
          localHashMap.put("param_BundleInCache", String.valueOf(localukb.jdField_b_of_type_Int));
          localHashMap.put("param_ModuleInFile", String.valueOf(localukb.c));
          break label482;
        }
        if (localukb.g == 22)
        {
          localHashMap.put("param_BSNeedUpdate", String.valueOf(localukb.d));
          localHashMap.put("param_DenpenExit", String.valueOf(localukb.e));
          break label482;
        }
        if (localukb.g != 6) {
          break label482;
        }
        localHashMap.put("param_RCReady", String.valueOf(localukb.f));
        break label482;
        if ((NearbyUtils.a()) && (localException != null)) {
          NearbyUtils.a("RNReportImpl", "realReport", new Object[] { localException.toString() });
        }
        this.jdField_a_of_type_AndroidUtilSparseArray.clear();
        return;
        Object localObject1 = null;
        j = 0;
        break;
      }
      j += 1;
      break;
      i += 1;
      break label294;
      i = 1;
      break label469;
      i = 3;
      break label469;
      i = 6;
      break label469;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uka.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */