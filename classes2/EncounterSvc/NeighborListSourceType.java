package EncounterSvc;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public final class NeighborListSourceType
  implements Serializable
{
  public static final int _List_From_MessageBox = 1;
  public static final int _List_From_Neighbor = 0;
  public static final int _List_From_PublicAlumnus = 2;
  public static final int _List_From_SummaryCardInterestTag = 3;
  
  public NeighborListSourceType()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\EncounterSvc\NeighborListSourceType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */