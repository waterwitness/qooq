package com.tribe.async.utils;

public class AssertUtils
{
  private static final boolean DEBUG = true;
  
  public static void assertTrue(boolean paramBoolean)
  {
    if (!paramBoolean) {
      throw new AssertionError();
    }
  }
  
  public static void assertTrue(boolean paramBoolean, String paramString)
  {
    if (!paramBoolean) {
      throw new AssertionError(paramString);
    }
  }
  
  public static <T> T checkNotNull(T paramT)
  {
    if (paramT == null) {
      throw new NullPointerException();
    }
    return paramT;
  }
  
  public static void fail(String paramString, Object... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {}
    for (;;)
    {
      throw new AssertionError(paramString);
      paramString = String.format(paramString, paramVarArgs);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tribe\async\utils\AssertUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */