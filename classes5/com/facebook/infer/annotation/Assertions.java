package com.facebook.infer.annotation;

import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

public class Assertions
{
  public static void assertCondition(boolean paramBoolean)
  {
    if (!paramBoolean) {
      throw new AssertionError();
    }
  }
  
  public static void assertCondition(boolean paramBoolean, String paramString)
  {
    if (!paramBoolean) {
      throw new AssertionError(paramString);
    }
  }
  
  public static <T> T assertNotNull(@Nullable T paramT)
  {
    if (paramT == null) {
      throw new AssertionError();
    }
    return paramT;
  }
  
  public static <T> T assertNotNull(@Nullable T paramT, String paramString)
  {
    if (paramT == null) {
      throw new AssertionError(paramString);
    }
    return paramT;
  }
  
  public static AssertionError assertUnreachable()
  {
    throw new AssertionError();
  }
  
  public static AssertionError assertUnreachable(Exception paramException)
  {
    throw new AssertionError(paramException);
  }
  
  public static AssertionError assertUnreachable(String paramString)
  {
    throw new AssertionError(paramString);
  }
  
  public static void assumeCondition(boolean paramBoolean) {}
  
  public static void assumeCondition(boolean paramBoolean, String paramString) {}
  
  public static <T> T assumeNotNull(@Nullable T paramT)
  {
    return paramT;
  }
  
  public static <T> T assumeNotNull(@Nullable T paramT, String paramString)
  {
    return paramT;
  }
  
  public static <T> T getAssertingNotNull(List<T> paramList, int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < paramList.size())) {}
    for (boolean bool = true;; bool = false)
    {
      assertCondition(bool);
      return (T)assertNotNull(paramList.get(paramInt));
    }
  }
  
  public static <K, V> V getAssertingNotNull(Map<K, V> paramMap, K paramK)
  {
    assertCondition(paramMap.containsKey(paramK));
    return (V)assertNotNull(paramMap.get(paramK));
  }
  
  public static <T> T getAssumingNotNull(List<T> paramList, int paramInt)
  {
    return (T)paramList.get(paramInt);
  }
  
  public static <K, V> V getAssumingNotNull(Map<K, V> paramMap, K paramK)
  {
    return (V)paramMap.get(paramK);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\infer\annotation\Assertions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */