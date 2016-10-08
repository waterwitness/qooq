package com.tencent.mobileqq.bubble;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BubbleManager$LruLinkedHashMap
  extends LinkedHashMap
{
  private static final float a = 0.75F;
  private static final long serialVersionUID = 1L;
  private final Lock lock;
  protected final int maxCapacity;
  
  public BubbleManager$LruLinkedHashMap(BubbleManager paramBubbleManager, int paramInt)
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


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\bubble\BubbleManager$LruLinkedHashMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */