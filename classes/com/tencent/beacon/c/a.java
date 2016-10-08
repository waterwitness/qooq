package com.tencent.beacon.c;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class a<T>
{
  private Lock a = new ReentrantLock();
  private Condition b = this.a.newCondition();
  private volatile T c;
  
  public final T a()
    throws InterruptedException
  {
    this.a.lock();
    try
    {
      while (this.c == null) {
        this.b.await();
      }
      localObject2 = this.c;
    }
    finally
    {
      this.a.unlock();
    }
    Object localObject2;
    this.a.unlock();
    return (T)localObject2;
  }
  
  public final void a(T paramT)
  {
    this.a.lock();
    try
    {
      this.c = paramT;
      if (paramT != null) {
        this.b.signal();
      }
      return;
    }
    finally
    {
      this.a.unlock();
    }
  }
  
  public final T b()
  {
    return (T)this.c;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\beacon\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */