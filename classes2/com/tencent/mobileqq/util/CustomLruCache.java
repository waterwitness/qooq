package com.tencent.mobileqq.util;

import android.support.v4.util.LruCache;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class CustomLruCache
  extends LruCache
{
  public CustomLruCache(int paramInt)
  {
    super(paramInt);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected Object create(Object paramObject)
  {
    return super.create(paramObject);
  }
  
  protected void entryRemoved(boolean paramBoolean, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    super.entryRemoved(paramBoolean, paramObject1, paramObject2, paramObject3);
  }
  
  protected int sizeOf(Object paramObject1, Object paramObject2)
  {
    return super.sizeOf(paramObject1, paramObject2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\util\CustomLruCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */