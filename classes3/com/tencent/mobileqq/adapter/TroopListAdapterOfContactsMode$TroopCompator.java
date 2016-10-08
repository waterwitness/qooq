package com.tencent.mobileqq.adapter;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Comparator;

public class TroopListAdapterOfContactsMode$TroopCompator
  implements Comparator
{
  public TroopListAdapterOfContactsMode$TroopCompator()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(TroopListAdapterOfContactsMode.TroopListItemWithMask paramTroopListItemWithMask1, TroopListAdapterOfContactsMode.TroopListItemWithMask paramTroopListItemWithMask2)
  {
    return paramTroopListItemWithMask1.a - paramTroopListItemWithMask2.a;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\adapter\TroopListAdapterOfContactsMode$TroopCompator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */