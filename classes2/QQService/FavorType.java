package QQService;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public final class FavorType
  implements Serializable
{
  public static final FavorType FAVOR_TYPE_FAVORITE;
  public static final FavorType FAVOR_TYPE_UNFAVORITE;
  public static final int _FAVOR_TYPE_FAVORITE = 0;
  public static final int _FAVOR_TYPE_UNFAVORITE = 1;
  private static FavorType[] a;
  private String __T = new String();
  private int __value;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    if (!FavorType.class.desiredAssertionStatus()) {}
    for (bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new FavorType[2];
      FAVOR_TYPE_FAVORITE = new FavorType(0, 0, "FAVOR_TYPE_FAVORITE");
      FAVOR_TYPE_UNFAVORITE = new FavorType(1, 1, "FAVOR_TYPE_UNFAVORITE");
      return;
    }
  }
  
  private FavorType(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static FavorType convert(int paramInt)
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
  
  public static FavorType convert(String paramString)
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


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\QQService\FavorType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */