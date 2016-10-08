import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;

public class hyc
  implements Runnable
{
  public hyc(ArticleInfoModule paramArticleInfoModule, ArticleInfo paramArticleInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) {
      QLog.d(ArticleInfoModule.jdField_a_of_type_JavaLangString, 2, "delete article fail ! title : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTitle + " , articleID : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hyc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */