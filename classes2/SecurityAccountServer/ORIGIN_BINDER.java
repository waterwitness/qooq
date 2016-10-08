package SecurityAccountServer;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public final class ORIGIN_BINDER
  implements Serializable
{
  public static final int _ORIGIN_BINDER_MOBILEQQ = 1;
  public static final int _ORIGIN_BINDER_MULTI = 4;
  public static final int _ORIGIN_BINDER_NOSTORE = 3;
  public static final int _ORIGIN_BINDER_PC = 2;
  public static final int _ORIGIN_BINDER_RESERVED = 0;
  
  public ORIGIN_BINDER()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\SecurityAccountServer\ORIGIN_BINDER.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */