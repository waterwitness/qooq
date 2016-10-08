package com.tencent.component.network.utils;

public class AssertUtil
{
  public static void assertTrue(boolean paramBoolean)
  {
    if (!paramBoolean) {
      throw new AssertionError();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\component\network\utils\AssertUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */