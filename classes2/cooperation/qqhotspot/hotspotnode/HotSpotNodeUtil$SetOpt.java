package cooperation.qqhotspot.hotspotnode;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HotSpotNodeUtil$SetOpt
{
  public HotSpotNodeUtil$SetOpt()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static List a(List paramList1, List paramList2)
  {
    if (paramList1 == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(Arrays.asList(new Object[paramList1.size()]));
    Collections.copy(localArrayList, paramList1);
    localArrayList.retainAll(paramList2);
    return localArrayList;
  }
  
  public static List b(List paramList1, List paramList2)
  {
    if (paramList1 == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(Arrays.asList(new Object[paramList1.size()]));
    Collections.copy(localArrayList, paramList1);
    localArrayList.addAll(paramList2);
    return localArrayList;
  }
  
  public static List c(List paramList1, List paramList2)
  {
    if (paramList1 == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(Arrays.asList(new Object[paramList1.size()]));
    Collections.copy(localArrayList, paramList1);
    localArrayList.removeAll(paramList2);
    return localArrayList;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qqhotspot\hotspotnode\HotSpotNodeUtil$SetOpt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */