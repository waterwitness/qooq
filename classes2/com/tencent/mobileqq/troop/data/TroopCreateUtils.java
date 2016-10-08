package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class TroopCreateUtils
{
  public static final String a = "troopUin";
  public static final String b = "troopLocation";
  
  public TroopCreateUtils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String a(int paramInt)
  {
    long l1 = 0x7FFFFFFF & paramInt;
    long l2 = paramInt >> 31 & 0x1;
    return (l1 | l2 << 31) + "";
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\data\TroopCreateUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */