package ct;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class dc
{
  public static final Pattern a;
  public static final Pattern b;
  public static final Pattern c = a;
  public static final Pattern d = Pattern.compile("[A-Z0-9]{12}");
  
  static
  {
    Pattern localPattern = Pattern.compile("[0-9a-zA-Z+-]*");
    a = localPattern;
    b = localPattern;
  }
  
  public static String a(String paramString, Pattern paramPattern)
  {
    String str;
    if (paramString == null) {
      str = "";
    }
    do
    {
      return str;
      str = paramString;
    } while (paramPattern.matcher(paramString).matches());
    return "";
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ct\dc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */