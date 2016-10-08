package SecurityAccountServer;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public final class RECOMMEND_TYPE
  implements Serializable
{
  public static final int _RECOMMEND_CIRCLE = 1;
  public static final int _RECOMMEND_MOBILEONLY = 0;
  public static final int _RECOOMEND_ALL = 2;
  
  public RECOMMEND_TYPE()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\SecurityAccountServer\RECOMMEND_TYPE.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */