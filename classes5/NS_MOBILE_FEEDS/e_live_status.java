package NS_MOBILE_FEEDS;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public final class e_live_status
  implements Serializable
{
  public static final int _kLiveEndNoVideo = 2;
  public static final int _kLiveEndWithAbnormalVideo = 4;
  public static final int _kLiveEndWithNormalVideo = 3;
  public static final int _kLiveEndWithUnknownException = 5;
  public static final int _kLiveError = 100;
  public static final int _kLiveOnline = 1;
  public static final int _kLiveStatusInit = 0;
  
  public e_live_status()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_FEEDS\e_live_status.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */