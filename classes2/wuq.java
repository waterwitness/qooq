import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.component.cache.database.DbCacheManager;
import com.tencent.open.component.cache.database.DbCacheService;
import java.util.HashMap;

public class wuq
  implements wup
{
  public wuq(DbCacheService paramDbCacheService)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(DbCacheManager paramDbCacheManager)
  {
    synchronized (this.a.a)
    {
      this.a.a.remove(paramDbCacheManager.a());
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wuq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */