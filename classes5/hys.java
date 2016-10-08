import com.tencent.biz.pubaccount.readinjoy.model.ArticleReadInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleReadInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Iterator;
import java.util.List;

public class hys
  implements Runnable
{
  public hys(ArticleReadInfoModule paramArticleReadInfoModule, List paramList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        ArticleReadInfo localArticleReadInfo = (ArticleReadInfo)localIterator.next();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleReadInfoModule.a(localArticleReadInfo);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hys.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */