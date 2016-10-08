package SummaryCardTaf;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public final class ESummaryCardResult
  implements Serializable
{
  public static final int _EM_BCM_RESULT_DENIED_SVIP = 101108;
  public static final int _EM_BCM_RESULT_DENIED_VIP = 101107;
  public static final int _EM_BCM_RESULT_OK = 0;
  
  public ESummaryCardResult()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\SummaryCardTaf\ESummaryCardResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */