import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.concurrent.atomic.AtomicInteger;

public class hxo
  implements Runnable
{
  public hxo(KandianMergeManager paramKandianMergeManager, MessageRecord paramMessageRecord)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    KandianMergeManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager).a().a(AppConstants.ba, 7220, false, false);
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.extInt == 2)
    {
      KandianMergeManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager).a().b(AppConstants.ba, 7220, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq);
      if (KandianMergeManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager).get() > 0) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b(2);
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.extInt != 1) {
      return;
    }
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.jdField_a_of_type_JavaLangString = AppConstants.aZ;
    localSessionInfo.jdField_a_of_type_Int = 1008;
    ChatActivityFacade.a(KandianMergeManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager), localSessionInfo);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hxo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */