package com.tencent.commonsdk.pool;

public class RecyclablePool
{
  private static final boolean DEBUG = false;
  volatile int mCapacity = 0;
  volatile int mCount = 0;
  private Recyclable mHead = new Recyclable();
  
  public RecyclablePool(Class<? extends Recyclable> paramClass, int paramInt)
  {
    for (;;)
    {
      int i;
      synchronized (this.mHead)
      {
        this.mCapacity = paramInt;
        this.mHead.inPool = true;
        i = 0;
        if (i >= paramInt) {}
      }
      try
      {
        Recyclable localRecyclable2 = (Recyclable)paramClass.newInstance();
        localRecyclable2.inPool = true;
        localRecyclable2.changeNext(this.mHead.getNext(), false);
        this.mHead.changeNext(localRecyclable2, false);
        this.mCount += 1;
        i += 1;
        continue;
        return;
        paramClass = finally;
        throw paramClass;
      }
      catch (Throwable localThrowable)
      {
        for (;;) {}
      }
    }
  }
  
  public Recyclable obtain(Class<? extends Recyclable> paramClass)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    Recyclable localRecyclable;
    if (this.mCount > 0)
    {
      localRecyclable = this.mHead;
      localObject1 = localObject2;
      try
      {
        if (this.mCount <= 0) {
          break label101;
        }
        localObject1 = this.mHead.getNext();
        if (localObject1 == null) {
          throw new RuntimeException("WTF");
        }
      }
      finally {}
      if (!((Recyclable)localObject1).inPool) {
        throw new RuntimeException("WTF");
      }
      this.mHead.changeNext(((Recyclable)localObject1).next, false);
      ((Recyclable)localObject1).inPool = false;
      this.mCount -= 1;
    }
    label101:
    localObject2 = localObject1;
    if (localObject1 == null) {}
    try
    {
      localObject2 = (Recyclable)paramClass.newInstance();
      return (Recyclable)localObject2;
    }
    catch (Throwable paramClass) {}
    return (Recyclable)localObject1;
  }
  
  public void recycle(Recyclable paramRecyclable)
  {
    paramRecyclable.recycle();
    if (this.mCount < this.mCapacity)
    {
      synchronized (this.mHead)
      {
        if (paramRecyclable.inPool) {
          throw new RuntimeException("WTF");
        }
      }
      if (this.mCount < this.mCapacity)
      {
        paramRecyclable.changeNext(this.mHead.getNext(), false);
        this.mHead.changeNext(paramRecyclable, false);
        paramRecyclable.inPool = true;
        this.mCount += 1;
      }
    }
  }
  
  public static class Recyclable
  {
    public boolean inPool;
    private Recyclable next;
    
    public void changeNext(Recyclable paramRecyclable, boolean paramBoolean)
    {
      if ((this.inPool) && (paramBoolean)) {
        throw new RuntimeException("WTF");
      }
      this.next = paramRecyclable;
    }
    
    public Recyclable getNext()
    {
      return this.next;
    }
    
    public void recycle()
    {
      this.next = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\commonsdk\pool\RecyclablePool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */