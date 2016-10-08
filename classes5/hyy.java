import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.model.ChannelInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.SpecialChannelFilter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

public class hyy
  implements Runnable
{
  public hyy(ChannelInfoModule paramChannelInfoModule, boolean paramBoolean, List paramList1, List paramList2)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      ReadInJoyLogicEngineEventDispatcher.a().b(false, null);
      return;
    }
    ChannelInfoModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelInfoModule, true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelInfoModule.a(this.jdField_a_of_type_JavaUtilList, true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelInfoModule.c(this.b);
    if (!ReadInJoyUtils.a())
    {
      List localList = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelInfoModule.a(this.jdField_a_of_type_JavaUtilList);
      SpecialChannelFilter.a().a(this.b);
      SpecialChannelFilter.a().b(localList);
      localList = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelInfoModule.c();
      if (!this.b.equals(localList)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelInfoModule.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelInfoModule.c());
      }
    }
    ReadInJoyLogicEngineEventDispatcher.a().a(true, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelInfoModule.a());
    if (!ReadInJoyUtils.a())
    {
      ReadInJoyLogicEngineEventDispatcher.a().b(true, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelInfoModule.b());
      return;
    }
    ReadInJoyLogicEngineEventDispatcher.a().b(true, this.jdField_a_of_type_JavaUtilList);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hyy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */