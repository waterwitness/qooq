import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine.SearchEngineEntity;
import java.util.Comparator;

public final class ulz
  implements Comparator
{
  public ulz()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(GroupSearchEngine.SearchEngineEntity paramSearchEngineEntity1, GroupSearchEngine.SearchEngineEntity paramSearchEngineEntity2)
  {
    return Integer.signum(GroupSearchEngine.SearchEngineEntity.a(paramSearchEngineEntity2) - GroupSearchEngine.SearchEngineEntity.a(paramSearchEngineEntity1));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ulz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */