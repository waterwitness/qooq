import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hyh
  implements Runnable
{
  public hyh(ArticleInfoModule paramArticleInfoModule, MessageRecord paramMessageRecord)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (KandianMergeManager.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, (QQAppInterface)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a) != 0) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.f();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hyh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */