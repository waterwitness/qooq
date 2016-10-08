package org.apache.commons.cli;

final class Util
{
  static String stripLeadingAndTrailingQuotes(String paramString)
  {
    int i = paramString.length();
    String str = paramString;
    if (i > 1)
    {
      str = paramString;
      if (paramString.startsWith("\""))
      {
        str = paramString;
        if (paramString.endsWith("\""))
        {
          str = paramString;
          if (paramString.substring(1, i - 1).indexOf('"') == -1) {
            str = paramString.substring(1, i - 1);
          }
        }
      }
    }
    return str;
  }
  
  static String stripLeadingHyphens(String paramString)
  {
    String str;
    if (paramString == null) {
      str = null;
    }
    do
    {
      return str;
      if (paramString.startsWith("--")) {
        return paramString.substring(2, paramString.length());
      }
      str = paramString;
    } while (!paramString.startsWith("-"));
    return paramString.substring(1, paramString.length());
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\org\apache\commons\cli\Util.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */