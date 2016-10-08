import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.model.PublicAccountSearchResultModel;
import com.tencent.mobileqq.search.searchengine.PublicAccountSearchEngine;
import java.util.Comparator;

public final class una
  implements Comparator
{
  public una()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(PublicAccountSearchResultModel paramPublicAccountSearchResultModel1, PublicAccountSearchResultModel paramPublicAccountSearchResultModel2)
  {
    int j = Long.signum(paramPublicAccountSearchResultModel2.b() - paramPublicAccountSearchResultModel1.b());
    int i = j;
    if (j == 0) {
      i = PublicAccountSearchEngine.a(paramPublicAccountSearchResultModel1, paramPublicAccountSearchResultModel2);
    }
    return i;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\una.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */