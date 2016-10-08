package com.tencent.mobileqq.adapter.contacts;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;

public class BuddyItemBuilder
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public static final int f = 5;
  public static final int g = 6;
  public static final int h = 99;
  private static final int i = 0;
  private static final int j = 1;
  private static final int k = 2;
  
  public BuddyItemBuilder()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static BuddyListItem a(int paramInt, Entity paramEntity, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (paramInt == 0) {
      return new BuddyListFriends(paramQQAppInterface, paramContext, paramEntity);
    }
    if (paramInt == 5) {
      return new BuddyListDevices(paramQQAppInterface, paramContext, paramEntity);
    }
    if (paramInt == 1) {
      return new BuddyListPhone(paramQQAppInterface, paramContext, paramEntity);
    }
    if (paramInt == 2) {
      return new BuddyListTroop(paramQQAppInterface, paramContext, paramEntity, 2);
    }
    if (paramInt == 3) {
      return new BuddyListTroop(paramQQAppInterface, paramContext, paramEntity, 3);
    }
    if (paramInt == 4) {
      return new BuddyListFriends(paramQQAppInterface, paramContext, paramEntity);
    }
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\adapter\contacts\BuddyItemBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */