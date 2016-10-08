import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.model.InterestLabelInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.InterestLabelInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Iterator;
import java.util.List;

public class hzf
  implements Runnable
{
  public hzf(InterestLabelInfoModule paramInterestLabelInfoModule, List paramList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    InterestLabelInfoModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelInterestLabelInfoModule).clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      InterestLabelInfo localInterestLabelInfo = (InterestLabelInfo)localIterator.next();
      InterestLabelInfoModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelInterestLabelInfoModule).add(localInterestLabelInfo);
    }
    ReadInJoyLogicEngineEventDispatcher.a().a(InterestLabelInfoModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelInterestLabelInfoModule));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */