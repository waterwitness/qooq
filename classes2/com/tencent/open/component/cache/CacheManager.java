package com.tencent.open.component.cache;

import android.content.Context;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.component.cache.database.DbCacheService;
import java.io.File;
import wuo;

public class CacheManager
{
  protected static DbCacheService a;
  
  protected CacheManager()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static DbCacheService a()
  {
    return a;
  }
  
  protected static String a(Context paramContext, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramContext = wuo.a(paramContext); paramContext == null; paramContext = wuo.a(paramContext, "cache")) {
      return null;
    }
    return paramContext.getAbsolutePath();
  }
  
  public static void a(Context paramContext)
  {
    a = DbCacheService.a(paramContext);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\component\cache\CacheManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */