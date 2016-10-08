package QQService;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public final class PushType
  implements Serializable
{
  public static final PushType PUSH_TYPE_NONE;
  public static final PushType PUSH_TYPE_VISITOR_INCR;
  public static final PushType PUSH_TYPE_VOTE_INCR;
  public static final int _PUSH_TYPE_NONE = -1;
  public static final int _PUSH_TYPE_VISITOR_INCR = 1;
  public static final int _PUSH_TYPE_VOTE_INCR = 0;
  private static PushType[] a;
  private String __T = new String();
  private int __value;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    if (!PushType.class.desiredAssertionStatus()) {}
    for (bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new PushType[3];
      PUSH_TYPE_NONE = new PushType(0, -1, "PUSH_TYPE_NONE");
      PUSH_TYPE_VOTE_INCR = new PushType(1, 0, "PUSH_TYPE_VOTE_INCR");
      PUSH_TYPE_VISITOR_INCR = new PushType(2, 1, "PUSH_TYPE_VISITOR_INCR");
      return;
    }
  }
  
  private PushType(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static PushType convert(int paramInt)
  {
    int i = 0;
    while (i < a.length)
    {
      if (a[i].value() == paramInt) {
        return a[i];
      }
      i += 1;
    }
    if (!$assertionsDisabled) {
      throw new AssertionError();
    }
    return null;
  }
  
  public static PushType convert(String paramString)
  {
    int i = 0;
    while (i < a.length)
    {
      if (a[i].toString().equals(paramString)) {
        return a[i];
      }
      i += 1;
    }
    if (!$assertionsDisabled) {
      throw new AssertionError();
    }
    return null;
  }
  
  public String toString()
  {
    return this.__T;
  }
  
  public int value()
  {
    return this.__value;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\QQService\PushType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */