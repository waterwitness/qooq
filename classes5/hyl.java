import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

public class hyl
  implements Runnable
{
  public hyl(ArticleInfoModule paramArticleInfoModule, List paramList, int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    for (List localList = ArticleInfoModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_Long, this.jdField_a_of_type_Boolean);; localList = this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a.post(new hym(this, localList));
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hyl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */