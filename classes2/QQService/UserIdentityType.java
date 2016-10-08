package QQService;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public final class UserIdentityType
  implements Serializable
{
  public static final UserIdentityType UserIdentityType_Merchant;
  public static final UserIdentityType UserIdentityType_Nomal;
  public static final UserIdentityType UserIdentityType_Official;
  public static final int _UserIdentityType_Merchant = 1;
  public static final int _UserIdentityType_Nomal = 0;
  public static final int _UserIdentityType_Official = 2;
  private static UserIdentityType[] a;
  private String __T = new String();
  private int __value;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    if (!UserIdentityType.class.desiredAssertionStatus()) {}
    for (bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new UserIdentityType[3];
      UserIdentityType_Nomal = new UserIdentityType(0, 0, "UserIdentityType_Nomal");
      UserIdentityType_Merchant = new UserIdentityType(1, 1, "UserIdentityType_Merchant");
      UserIdentityType_Official = new UserIdentityType(2, 2, "UserIdentityType_Official");
      return;
    }
  }
  
  private UserIdentityType(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static UserIdentityType convert(int paramInt)
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
  
  public static UserIdentityType convert(String paramString)
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


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\QQService\UserIdentityType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */