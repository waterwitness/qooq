package NS_QZONE_FESTIVAL;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public final class RESULT_CODE
  implements Serializable
{
  public static final int _eInvalidTime = 101;
  public static final int _eNotFestival = 100;
  public static final int _eSuccess = 0;
  
  public RESULT_CODE()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\NS_QZONE_FESTIVAL\RESULT_CODE.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */