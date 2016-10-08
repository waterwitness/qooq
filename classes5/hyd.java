import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelTopCookie;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.List;

public class hyd
  implements Runnable
{
  public hyd(ArticleInfoModule paramArticleInfoModule)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    List localList = this.a.a.a(ChannelTopCookie.class, true, null, null, null, null, null, null);
    this.a.a(localList);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hyd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */