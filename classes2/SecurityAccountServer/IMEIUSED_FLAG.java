package SecurityAccountServer;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public final class IMEIUSED_FLAG
  implements Serializable
{
  public static final int _IMEI_AUTO_MATCH = 2;
  public static final int _IMEI_MANUAL_MATCH = 3;
  public static final int _IMEI_NOT_CHANGED = 1;
  
  public IMEIUSED_FLAG()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\SecurityAccountServer\IMEIUSED_FLAG.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */