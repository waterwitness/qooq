import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

public class hyi
  implements Runnable
{
  public hyi(ArticleInfoModule paramArticleInfoModule, boolean paramBoolean, int paramInt, List paramList)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaUtilList);
    List localList = ArticleInfoModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule, this.jdField_a_of_type_JavaUtilList);
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_Int, localList);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hyi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */