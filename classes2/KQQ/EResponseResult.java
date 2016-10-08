package KQQ;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public final class EResponseResult
  implements Serializable
{
  public static final int _eFail = 1;
  public static final int _eSucc = 0;
  private static EResponseResult[] a;
  public static final EResponseResult eFail;
  public static final EResponseResult eSucc;
  private String __T = new String();
  private int __value;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    if (!EResponseResult.class.desiredAssertionStatus()) {}
    for (bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new EResponseResult[2];
      eSucc = new EResponseResult(0, 0, "eSucc");
      eFail = new EResponseResult(1, 1, "eFail");
      return;
    }
  }
  
  private EResponseResult(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static EResponseResult convert(int paramInt)
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
  
  public static EResponseResult convert(String paramString)
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


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\KQQ\EResponseResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */