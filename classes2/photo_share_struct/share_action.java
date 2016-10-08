package photo_share_struct;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public final class share_action
  implements Serializable
{
  public static final int _kActionDefault = 0;
  public static final int _kAddShare = 4;
  public static final int _kCreateSource = 1;
  public static final int _kDelShare = 8;
  public static final int _kEditNick = 16;
  public static final int _kJoinShare = 2;
  
  public share_action()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\photo_share_struct\share_action.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */