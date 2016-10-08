package SummaryCard;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public final class QCallInfoStatus
  implements Serializable
{
  public static final int _QCALL_INFO_STATUS_ACCESS_SUCCEED = 1;
  public static final int _QCALL_INFO_STATUS_NOT_ACTIVATED = 101;
  public static final int _QCALL_INFO_STATUS_SERVICE_SWITCHOFF = 100;
  
  public QCallInfoStatus()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\SummaryCard\QCallInfoStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */