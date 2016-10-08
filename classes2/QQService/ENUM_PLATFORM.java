package QQService;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public final class ENUM_PLATFORM
  implements Serializable
{
  public static final int _PLATFORM_ANDROID = 2;
  public static final int _PLATFORM_IOS = 1;
  public static final int _PLATFORM_PC = 3;
  public static final int _PLATFORM_RESERVED = 0;
  
  public ENUM_PLATFORM()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\QQService\ENUM_PLATFORM.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */