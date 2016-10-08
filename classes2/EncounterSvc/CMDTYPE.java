package EncounterSvc;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public final class CMDTYPE
  implements Serializable
{
  public static final int _CMD_CHECK_IN_CRC = 103;
  public static final int _CMD_CHECK_IN_NB = 101;
  public static final int _CMD_GET_ENCOUNTER = 1;
  public static final int _CMD_GET_ENCOUNTERV2 = 3;
  public static final int _CMD_GET_ENCOUNTER_CRC = 2;
  public static final int _CMD_GET_ENTRANCE = 4;
  public static final int _CMD_GET_RECOMMENDER = 5;
  public static final int _CMD_GET_USERINFO_FROMNB = 102;
  public static final int _CMD_INIT = 0;
  
  public CMDTYPE()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\EncounterSvc\CMDTYPE.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */