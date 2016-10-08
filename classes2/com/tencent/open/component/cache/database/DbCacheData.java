package com.tencent.open.component.cache.database;

import android.content.ContentValues;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract class DbCacheData
{
  public DbCacheData()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public abstract void a(ContentValues paramContentValues);
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\component\cache\database\DbCacheData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */