package PersonalState;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public final class OPERATE_TYPE
  implements Serializable
{
  public static final int _TYPE_OPERATE_ADD = 1;
  public static final int _TYPE_OPERATE_DEL = 2;
  public static final int _TYPE_OPERATE_NONE = 0;
  
  public OPERATE_TYPE()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\PersonalState\OPERATE_TYPE.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */