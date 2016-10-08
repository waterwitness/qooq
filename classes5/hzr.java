import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFService;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class hzr
  implements Runnable
{
  public hzr(ReadInJoyMSFService paramReadInJoyMSFService, ToServiceMsg paramToServiceMsg, WeakReference paramWeakReference)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = ReadInJoyMSFService.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService);
    this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.getAttributes().put("seq", Integer.valueOf(i));
    ReadInJoyMSFService.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService).put(Integer.valueOf(i), this.jdField_a_of_type_JavaLangRefWeakReference);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hzr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */