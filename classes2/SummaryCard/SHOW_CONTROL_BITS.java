package SummaryCard;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public final class SHOW_CONTROL_BITS
  implements Serializable
{
  public static final int _NOT_SHOW_JOINED_GROUP = 64;
  public static final int _NOT_SHOW_SERVICES = 32;
  public static final int _QZONE_UNAUTHORIZED = 128;
  public static final int _SHOW_LOGIN_DAYS = 16;
  public static final int _SHOW_QZONE_FEEDS = 1;
  public static final int _SHOW_QZONE_PICS = 2;
  public static final int _SHOW_VOICE_BUTTON = 8;
  public static final int _SHOW_VOTE_BUTTON = 4;
  
  public SHOW_CONTROL_BITS()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\SummaryCard\SHOW_CONTROL_BITS.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */