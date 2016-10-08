package com.tencent.mm.sdk.b;

import java.util.TimeZone;

public final class f
{
  private static final TimeZone GMT = TimeZone.getTimeZone("GMT");
  public static final long[] t = { 300L, 200L, 300L, 200L };
  private static final long[] u = { 300L, 50L, 300L, 50L };
  private static final char[] v = { 60, 62, 34, 39, 38, 13, 10, 32, 9 };
  private static final String[] w = { "&lt;", "&gt;", "&quot;", "&apos;", "&amp;", "&#x0D;", "&#x0A;", "&#x20;", "&#x09;" };
  
  public static boolean c(String paramString)
  {
    return (paramString == null) || (paramString.length() <= 0);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mm\sdk\b\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */