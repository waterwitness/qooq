package com.facebook.react.bridge;

import javax.annotation.Nullable;

public class SoftAssertions
{
  public static void assertCondition(boolean paramBoolean, String paramString)
  {
    if (!paramBoolean) {
      throw new AssertionException(paramString);
    }
  }
  
  public static <T> T assertNotNull(@Nullable T paramT)
  {
    if (paramT == null) {
      throw new AssertionException("Expected object to not be null!");
    }
    return paramT;
  }
  
  public static void assertUnreachable(String paramString)
  {
    throw new AssertionException(paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\bridge\SoftAssertions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */