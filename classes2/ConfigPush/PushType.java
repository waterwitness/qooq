package ConfigPush;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public final class PushType
  implements Serializable
{
  public static final int _PUSH_CLILOG_CONFIG = 3;
  public static final int _PUSH_FMT_SERVER_LIST = 2;
  public static final int _PUSH_SERVER_LIST = 1;
  
  public PushType()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ConfigPush\PushType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */