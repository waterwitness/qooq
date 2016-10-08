import com.tencent.biz.pubaccount.readinjoy.model.InterestLabelInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.InterestLabelInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class hze
  implements Runnable
{
  public hze(InterestLabelInfoModule paramInterestLabelInfoModule, List paramList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      InterestLabelInfoModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelInterestLabelInfoModule).clear();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        InterestLabelInfo localInterestLabelInfo = (InterestLabelInfo)localIterator.next();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelInterestLabelInfoModule.a(localInterestLabelInfo);
        InterestLabelInfoModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelInterestLabelInfoModule).put(Integer.valueOf(localInterestLabelInfo.mInterestLabelID), localInterestLabelInfo);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */