package org.apache.commons.cli;

final class OptionValidator
{
  private static boolean isValidChar(char paramChar)
  {
    return Character.isJavaIdentifierPart(paramChar);
  }
  
  private static boolean isValidOpt(char paramChar)
  {
    return (isValidChar(paramChar)) || (paramChar == '?') || (paramChar == '@');
  }
  
  static void validateOption(String paramString)
    throws IllegalArgumentException
  {
    int i = 0;
    if (paramString == null) {}
    for (;;)
    {
      return;
      char c;
      if (paramString.length() == 1)
      {
        c = paramString.charAt(0);
        if (!isValidOpt(c)) {
          throw new IllegalArgumentException("Illegal option name '" + c + "'");
        }
      }
      else
      {
        char[] arrayOfChar = paramString.toCharArray();
        int j = arrayOfChar.length;
        while (i < j)
        {
          c = arrayOfChar[i];
          if (!isValidChar(c)) {
            throw new IllegalArgumentException("The option '" + paramString + "' contains an illegal " + "character : '" + c + "'");
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\org\apache\commons\cli\OptionValidator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */