package com.tencent.imageservice;

public class Milestone
{
  private int a = 0;
  
  public void disable(int paramInt)
  {
    this.a &= (paramInt ^ 0xFFFFFFFF);
  }
  
  public void disableAll(int... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      disable(paramVarArgs[i]);
      i += 1;
    }
  }
  
  public void enable(int paramInt)
  {
    this.a |= paramInt;
  }
  
  public void enableAll(int... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      enable(paramVarArgs[i]);
      i += 1;
    }
  }
  
  public String getMilestoneString()
  {
    StringBuilder localStringBuilder = new StringBuilder(32);
    int i = 31;
    if (i >= 0)
    {
      if (isEnabled(1 << i)) {}
      for (String str = "1";; str = "0")
      {
        localStringBuilder.append(str);
        i -= 1;
        break;
      }
    }
    return localStringBuilder.toString();
  }
  
  public int getMilestoneValue()
  {
    return this.a;
  }
  
  public boolean isEnabled(int paramInt)
  {
    return (this.a & paramInt) == paramInt;
  }
  
  public void reset()
  {
    this.a = 0;
  }
  
  public void toggle(int paramInt)
  {
    this.a ^= paramInt;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\imageservice\Milestone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */