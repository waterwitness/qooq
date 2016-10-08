package com.tencent.mobileqq.activity.selectmember;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Comparator;

public class TroopListAdapter$TroopCompator
  implements Comparator
{
  protected TroopListAdapter$TroopCompator(TroopListAdapter paramTroopListAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(TroopListAdapter.TroopListItemWithMask paramTroopListItemWithMask1, TroopListAdapter.TroopListItemWithMask paramTroopListItemWithMask2)
  {
    return paramTroopListItemWithMask1.a - paramTroopListItemWithMask2.a;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\selectmember\TroopListAdapter$TroopCompator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */