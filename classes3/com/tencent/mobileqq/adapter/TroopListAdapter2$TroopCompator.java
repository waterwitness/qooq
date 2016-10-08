package com.tencent.mobileqq.adapter;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Comparator;

public class TroopListAdapter2$TroopCompator
  implements Comparator
{
  public TroopListAdapter2$TroopCompator()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(TroopListAdapter2.TroopListItemWithMask paramTroopListItemWithMask1, TroopListAdapter2.TroopListItemWithMask paramTroopListItemWithMask2)
  {
    return paramTroopListItemWithMask1.a - paramTroopListItemWithMask2.a;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\adapter\TroopListAdapter2$TroopCompator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */