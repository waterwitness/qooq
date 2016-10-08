package PUSHAPI;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public final class EPushRspFlag
  implements Serializable
{
  public static final int _PUSHRSP_FALG_QQ_IN_QZONE_PAGE = 64;
  public static final int _PUSHRSP_FLAG_DUPLICATE = 8;
  public static final int _PUSHRSP_FLAG_EXIST_QZONE_APP = 128;
  public static final int _PUSHRSP_FLAG_INVALID_PARAM = 256;
  public static final int _PUSHRSP_FLAG_INVALID_TYPE = 16;
  public static final int _PUSHRSP_FLAG_QQ_FORGROUND = 32;
  public static final int _PUSHRSP_FLAG_RISE_QZONE_SUCC = 2;
  public static final int _PUSHRSP_FLAG_SHOW = 4;
  public static final int _PUSHRSP_FLAG_TRY_RISE_QZONE = 1;
  
  public EPushRspFlag()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\PUSHAPI\EPushRspFlag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */