package SummaryCard;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public final class GiftOpenFlag
  implements Serializable
{
  public static final int _GIFT_OPEN_FLAG_CLOSE = 0;
  public static final int _GIFT_OPEN_FLAG_NEARBY = 1;
  
  public GiftOpenFlag()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\SummaryCard\GiftOpenFlag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */