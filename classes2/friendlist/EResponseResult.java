package friendlist;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public final class EResponseResult
  implements Serializable
{
  public static final int _eFail = 1;
  public static final int _eRefuse = 2;
  public static final int _eSucc = 0;
  
  public EResponseResult()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\friendlist\EResponseResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */