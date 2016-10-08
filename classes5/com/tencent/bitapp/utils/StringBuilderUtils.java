package com.tencent.bitapp.utils;

public class StringBuilderUtils
{
  private static ThreadLocal<StringBuilder> builder = new ThreadLocal();
  
  public static StringBuilder obtain()
  {
    StringBuilder localStringBuilder = (StringBuilder)builder.get();
    if (localStringBuilder == null)
    {
      localStringBuilder = new StringBuilder();
      builder.set(localStringBuilder);
      return localStringBuilder;
    }
    localStringBuilder.setLength(0);
    return localStringBuilder;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\utils\StringBuilderUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */