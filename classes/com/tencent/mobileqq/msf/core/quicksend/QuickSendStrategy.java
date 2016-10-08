package com.tencent.mobileqq.msf.core.quicksend;

public class QuickSendStrategy
{
  public static final int STRATEGY_COMMON = 0;
  public static final int STRATEGY_MSG = 1;
  
  public static a getStragegyArgs(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return new a(5000L, 0L, 0, true);
    }
    return new a(5000L, 60000L, 12, true);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\msf\core\quicksend\QuickSendStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */