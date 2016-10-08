import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.model.PublicAccountSearchResultModel;
import com.tencent.mobileqq.search.searchengine.PublicAccountSearchEngine;
import java.util.Comparator;

public final class unb
  implements Comparator
{
  public unb()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(PublicAccountSearchResultModel paramPublicAccountSearchResultModel1, PublicAccountSearchResultModel paramPublicAccountSearchResultModel2)
  {
    int j = Long.signum(paramPublicAccountSearchResultModel2.b() - paramPublicAccountSearchResultModel1.b());
    int i = j;
    if (j == 0) {
      i = Long.signum(paramPublicAccountSearchResultModel2.a() - paramPublicAccountSearchResultModel1.a());
    }
    j = i;
    if (i == 0) {
      j = PublicAccountSearchEngine.a(paramPublicAccountSearchResultModel1, paramPublicAccountSearchResultModel2);
    }
    return j;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\unb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */