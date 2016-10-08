package com.tencent.open.component.cache.database;

import android.util.AndroidRuntimeException;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class AbstractDbCacheManager$BadCacheDataException
  extends AndroidRuntimeException
{
  public AbstractDbCacheManager$BadCacheDataException(String paramString)
  {
    super(paramString);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\component\cache\database\AbstractDbCacheManager$BadCacheDataException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */