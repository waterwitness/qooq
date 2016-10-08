package EncounterSvc;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public final class NearbyEntranceType
  implements Serializable
{
  public static final int _Nearby_Activity = 4;
  public static final int _Nearby_All = 0;
  public static final int _Nearby_Date = 1;
  public static final int _Nearby_Group = 2;
  public static final int _Nearby_HotChat = 8;
  public static final int _Nearby_None = -1;
  public static final int _Nearby_Top = 16;
  
  public NearbyEntranceType()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\EncounterSvc\NearbyEntranceType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */