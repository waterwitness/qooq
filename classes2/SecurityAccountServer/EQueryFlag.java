package SecurityAccountServer;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public final class EQueryFlag
  implements Serializable
{
  public static final int _EQueryFlag_ALL = 1;
  public static final int _EQueryFlag_NONE = 0;
  public static final int _EQueryFlag_UPDATE = 2;
  
  public EQueryFlag()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\SecurityAccountServer\EQueryFlag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */