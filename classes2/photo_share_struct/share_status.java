package photo_share_struct;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public final class share_status
  implements Serializable
{
  public static final int _eStatusConfirm = 2;
  public static final int _eStatusDefault = 0;
  public static final int _eStatusDel = 4;
  public static final int _eStatusExit = 5;
  public static final int _eStatusInvite = 1;
  public static final int _eStatusUrl = 3;
  
  public share_status()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\photo_share_struct\share_status.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */