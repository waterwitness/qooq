package com.tencent.util;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public class Pair
  implements Serializable
{
  public final Object first;
  public final Object second;
  
  public Pair(Object paramObject1, Object paramObject2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.first = paramObject1;
    this.second = paramObject2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    for (;;)
    {
      return true;
      if (!(paramObject instanceof Pair)) {
        return false;
      }
      try
      {
        paramObject = (Pair)paramObject;
        if ((!this.first.equals(((Pair)paramObject).first)) || (!this.second.equals(((Pair)paramObject).second))) {
          return false;
        }
      }
      catch (ClassCastException paramObject) {}
    }
    return false;
  }
  
  public int hashCode()
  {
    return (this.first.hashCode() + 527) * 31 + this.second.hashCode();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\util\Pair.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */