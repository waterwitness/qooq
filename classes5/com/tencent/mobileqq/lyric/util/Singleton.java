package com.tencent.mobileqq.lyric.util;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract class Singleton
{
  private volatile Object a;
  
  public Singleton()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected abstract Object a(Object paramObject);
  
  public final Object b(Object paramObject)
  {
    if (this.a == null) {}
    try
    {
      if (this.a == null) {
        this.a = a(paramObject);
      }
      return this.a;
    }
    finally {}
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\lyric\util\Singleton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */