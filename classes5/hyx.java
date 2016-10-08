import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.model.ChannelInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.SpecialChannelFilter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

public class hyx
  implements Runnable
{
  public hyx(ChannelInfoModule paramChannelInfoModule, boolean paramBoolean, List paramList)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      ReadInJoyLogicEngineEventDispatcher.a().c(false, null);
      return;
    }
    SpecialChannelFilter.a().a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelInfoModule.c(this.jdField_a_of_type_JavaUtilList);
    ReadInJoyLogicEngineEventDispatcher.a().c(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaUtilList);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hyx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */