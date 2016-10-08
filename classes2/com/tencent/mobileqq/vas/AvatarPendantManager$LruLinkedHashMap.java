package com.tencent.mobileqq.vas;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AvatarPendantManager$LruLinkedHashMap
  extends LinkedHashMap
{
  private static final float a = 0.75F;
  private static final long serialVersionUID = 1L;
  private final Lock lock;
  protected final int maxCapacity;
  
  public AvatarPendantManager$LruLinkedHashMap(int paramInt)
  {
    super(paramInt, 0.75F, true);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.lock = new ReentrantLock();
    this.maxCapacity = paramInt;
  }
  
  public Object get(Object paramObject)
  {
    try
    {
      this.lock.lock();
      paramObject = super.get(paramObject);
      return paramObject;
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  public Object put(Object paramObject1, Object paramObject2)
  {
    try
    {
      this.lock.lock();
      paramObject1 = super.put(paramObject1, paramObject2);
      return paramObject1;
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  protected boolean removeEldestEntry(Map.Entry paramEntry)
  {
    return size() > this.maxCapacity;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vas\AvatarPendantManager$LruLinkedHashMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */