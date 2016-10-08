package SecurityAccountServer;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public final class ENetworkType
  implements Serializable
{
  public static final int _NETWORK_2G = 2;
  public static final int _NETWORK_3G = 3;
  public static final int _NETWORK_4G = 4;
  public static final int _NETWORK_UNKNOWN = 0;
  public static final int _NETWORK_WIFI = 1;
  
  public ENetworkType()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\SecurityAccountServer\ENetworkType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */