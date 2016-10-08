package SecurityAccountServer;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public final class ACCOUNT_ABILITY
  implements Serializable
{
  public static final int _ABILITY_CHAT = 1;
  public static final int _ABILITY_NOCHAT = 0;
  
  public ACCOUNT_ABILITY()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\SecurityAccountServer\ACCOUNT_ABILITY.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */