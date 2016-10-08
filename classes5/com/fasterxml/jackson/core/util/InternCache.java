package com.fasterxml.jackson.core.util;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public final class InternCache
  extends LinkedHashMap<String, String>
{
  private static final int MAX_ENTRIES = 100;
  public static final InternCache instance = new InternCache();
  
  private InternCache()
  {
    super(100, 0.8F, true);
  }
  
  public String intern(String paramString)
  {
    try
    {
      String str2 = (String)get(paramString);
      String str1 = str2;
      if (str2 == null)
      {
        str1 = paramString.intern();
        put(str1, str1);
      }
      return str1;
    }
    finally {}
  }
  
  protected boolean removeEldestEntry(Map.Entry<String, String> paramEntry)
  {
    return size() > 100;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\fasterxml\jackson\core\util\InternCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */