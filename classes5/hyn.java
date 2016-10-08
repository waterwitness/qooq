import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFHandlerUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.List;

public class hyn
  implements Runnable
{
  public hyn(ArticleInfoModule paramArticleInfoModule, String paramString, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a;
    String str = this.jdField_a_of_type_JavaLangString;
    int i = this.jdField_a_of_type_Int;
    long l = this.jdField_a_of_type_Long;
    int j = this.b;
    localObject = ((EntityManager)localObject).a(ArticleInfo.class, true, str, new String[] { String.valueOf(i), String.valueOf(l) }, null, null, "mRecommendSeq desc", String.valueOf(j));
    if (localObject != null) {
      ReadInJoyMSFHandlerUtils.a((List)localObject);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a((List)localObject, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_Long, this.jdField_a_of_type_Boolean, this.c);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hyn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */