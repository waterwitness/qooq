package com.tencent.mobileqq.model;

import com.tencent.mobileqq.data.TroopMessageNavigateInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Comparator;

public class TroopInfoManager$NavigationMsgComparator
  implements Comparator
{
  public TroopInfoManager$NavigationMsgComparator()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(TroopMessageNavigateInfo paramTroopMessageNavigateInfo1, TroopMessageNavigateInfo paramTroopMessageNavigateInfo2)
  {
    return -(paramTroopMessageNavigateInfo1.type - paramTroopMessageNavigateInfo2.type);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\model\TroopInfoManager$NavigationMsgComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */