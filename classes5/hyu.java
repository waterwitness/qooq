import com.tencent.biz.pubaccount.readinjoy.model.ArticleReadInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleReadInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.HashMap;

public class hyu
  implements Runnable
{
  public hyu(ArticleReadInfoModule paramArticleReadInfoModule, ArticleReadInfo paramArticleReadInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleReadInfoModule.a.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleReadInfo);
    ArticleReadInfoModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleReadInfoModule).remove(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleReadInfo);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hyu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */