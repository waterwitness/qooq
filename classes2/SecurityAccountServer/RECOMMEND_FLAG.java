package SecurityAccountServer;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public final class RECOMMEND_FLAG
  implements Serializable
{
  public static final int _RECOMMEND_FLAG_NO = 2;
  public static final int _RECOMMEND_FLAG_RESERVED = 0;
  public static final int _RECOMMEND_FLAG_YES = 1;
  
  public RECOMMEND_FLAG()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\SecurityAccountServer\RECOMMEND_FLAG.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */