package com.tencent.mobileqq.adapter;

import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;

public class TroopListAdapterOfContactsMode$TroopListItem
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public TroopInfo a;
  public int e;
  
  public TroopListAdapterOfContactsMode$TroopListItem(int paramInt, Entity paramEntity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.e = paramInt;
    this.a = ((TroopInfo)paramEntity);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\adapter\TroopListAdapterOfContactsMode$TroopListItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */