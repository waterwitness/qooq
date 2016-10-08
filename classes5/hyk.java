import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;

public class hyk
  implements Runnable
{
  public hyk(ArticleInfoModule paramArticleInfoModule, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a.b("DELETE FROM " + ArticleInfo.class.getSimpleName() + " WHERE mChannelID = " + this.jdField_a_of_type_Int);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hyk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */