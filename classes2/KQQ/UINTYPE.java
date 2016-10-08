package KQQ;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public final class UINTYPE
  implements Serializable
{
  public static final UINTYPE UIN_EMAIL;
  public static final UINTYPE UIN_MOBILE;
  public static final UINTYPE UIN_QQ;
  public static final int _UIN_EMAIL = 1;
  public static final int _UIN_MOBILE = 2;
  public static final int _UIN_QQ = 0;
  private static UINTYPE[] a;
  private String __T = new String();
  private int __value;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    if (!UINTYPE.class.desiredAssertionStatus()) {}
    for (bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new UINTYPE[3];
      UIN_QQ = new UINTYPE(0, 0, "UIN_QQ");
      UIN_EMAIL = new UINTYPE(1, 1, "UIN_EMAIL");
      UIN_MOBILE = new UINTYPE(2, 2, "UIN_MOBILE");
      return;
    }
  }
  
  private UINTYPE(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static UINTYPE convert(int paramInt)
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
  
  public static UINTYPE convert(String paramString)
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


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\KQQ\UINTYPE.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */