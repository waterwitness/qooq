package NS_MOBILE_VIDEO;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public final class enum_video_status
  implements Serializable
{
  public static final int _enum_check_fail = 7;
  public static final int _enum_check_not_pass = 6;
  public static final int _enum_check_pass = 5;
  public static final int _enum_init = 0;
  public static final int _enum_not_checked = 4;
  public static final int _enum_transfer_done = 2;
  public static final int _enum_transfer_fail = 3;
  public static final int _enum_transfering = 1;
  
  public enum_video_status()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_VIDEO\enum_video_status.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */