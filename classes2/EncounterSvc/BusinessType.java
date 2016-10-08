package EncounterSvc;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public final class BusinessType
  implements Serializable
{
  public static final int _BusinessType_Friend = 1;
  public static final int _BusinessType_MQQ = 0;
  public static final int _BusinessType_MQQNoAct = 2;
  public static final int _BusinessType_SNG = 4;
  public static final int _BusinessType_TEST = 3;
  
  public BusinessType()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\EncounterSvc\BusinessType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */