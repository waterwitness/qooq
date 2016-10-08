import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.cache.FileStorageHandler.Collector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public final class ylt
  implements FileStorageHandler.Collector
{
  public ylt()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Collection a()
  {
    synchronized ()
    {
      if (CacheManager.a().size() <= 0)
      {
        localObject1 = null;
        return (Collection)localObject1;
      }
      Object localObject1 = new ArrayList(CacheManager.a().values());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ylt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */