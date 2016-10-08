package NS_MOBILE_FEEDS;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public final class FACE_CONFIRM_TYPE
  implements Serializable
{
  public static final int _FACE_CONFIRM_ALL = 65535;
  public static final int _FACE_CONFIRM_CONFIRMED = 1;
  public static final int _FACE_CONFIRM_UNCONFIRM = 0;
  public static final int _FACE_GET_ALBUM_CONFIRMED = 3;
  
  public FACE_CONFIRM_TYPE()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_FEEDS\FACE_CONFIRM_TYPE.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */