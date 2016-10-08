import com.tencent.biz.pubaccount.readinjoy.model.ArticleReadInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleReadInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.List;

public class hyr
  implements Runnable
{
  public hyr(ArticleReadInfoModule paramArticleReadInfoModule)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    List localList = this.a.a.a(ArticleReadInfo.class, true, null, null, null, null, null, null);
    ArticleReadInfoModule.a(this.a, localList);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hyr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */