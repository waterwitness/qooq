import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine.SearchEngineEntity;
import com.tencent.mobileqq.search.searchengine.ISearchEngine;
import cooperation.qqfav.globalsearch.GroupSearchModelFavorite;
import java.util.List;

public class umb
  extends GroupSearchEngine.SearchEngineEntity
{
  public umb(GroupSearchEngine paramGroupSearchEngine, ISearchEngine paramISearchEngine, String paramString, int paramInt)
  {
    super(paramGroupSearchEngine, paramISearchEngine, paramString, paramInt);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ISearchResultGroupModel a(List paramList, String paramString)
  {
    return new GroupSearchModelFavorite(paramList, paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\umb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */