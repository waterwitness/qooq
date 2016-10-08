package com.tencent.mobileqq.activity.selectmember;

import com.tencent.mobileqq.data.CommonlyUsedTroop;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Comparator;

public class TroopListAdapter$CommonlyUsedTroopCompator
  implements Comparator
{
  protected TroopListAdapter$CommonlyUsedTroopCompator(TroopListAdapter paramTroopListAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(CommonlyUsedTroop paramCommonlyUsedTroop1, CommonlyUsedTroop paramCommonlyUsedTroop2)
  {
    if (paramCommonlyUsedTroop1.addedTimestamp < paramCommonlyUsedTroop2.addedTimestamp) {
      return 1;
    }
    if (paramCommonlyUsedTroop1.addedTimestamp > paramCommonlyUsedTroop2.addedTimestamp) {
      return -1;
    }
    return 0;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\selectmember\TroopListAdapter$CommonlyUsedTroopCompator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */