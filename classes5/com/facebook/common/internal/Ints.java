package com.facebook.common.internal;

public class Ints
{
  public static int max(int... paramVarArgs)
  {
    boolean bool;
    int j;
    int i;
    if (paramVarArgs.length > 0)
    {
      bool = true;
      Preconditions.checkArgument(bool);
      j = paramVarArgs[0];
      i = 1;
    }
    for (;;)
    {
      if (i >= paramVarArgs.length)
      {
        return j;
        bool = false;
        break;
      }
      int k = j;
      if (paramVarArgs[i] > j) {
        k = paramVarArgs[i];
      }
      i += 1;
      j = k;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\common\internal\Ints.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */