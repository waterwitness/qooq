package EncounterSvc;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public final class REASON_TYPE
  implements Serializable
{
  public static final int _REASON_DEFAULT = 0;
  public static final int _REASON_LACK_FRIEND = 2;
  public static final int _REASON_LESS = 3;
  public static final int _REASON_MORE = 4;
  public static final int _REASON_NEWBIE = 1;
  
  public REASON_TYPE()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\EncounterSvc\REASON_TYPE.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */