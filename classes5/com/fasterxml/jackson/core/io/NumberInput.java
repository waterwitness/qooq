package com.fasterxml.jackson.core.io;

public final class NumberInput
{
  static final long L_BILLION = 1000000000L;
  static final String MAX_LONG_STR = String.valueOf(Long.MAX_VALUE);
  static final String MIN_LONG_STR_NO_SIGN = String.valueOf(Long.MIN_VALUE).substring(1);
  public static final String NASTY_SMALL_DOUBLE = "2.2250738585072012e-308";
  
  public static boolean inLongRange(String paramString, boolean paramBoolean)
  {
    String str;
    int j;
    int i;
    if (paramBoolean)
    {
      str = MIN_LONG_STR_NO_SIGN;
      j = str.length();
      i = paramString.length();
      if (i >= j) {
        break label34;
      }
    }
    label34:
    label80:
    for (;;)
    {
      return true;
      str = MAX_LONG_STR;
      break;
      if (i > j) {
        return false;
      }
      i = 0;
      for (;;)
      {
        if (i >= j) {
          break label80;
        }
        int k = paramString.charAt(i) - str.charAt(i);
        if (k != 0)
        {
          if (k < 0) {
            break;
          }
          return false;
        }
        i += 1;
      }
    }
  }
  
  public static boolean inLongRange(char[] paramArrayOfChar, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    String str;
    int i;
    if (paramBoolean)
    {
      str = MIN_LONG_STR_NO_SIGN;
      i = str.length();
      if (paramInt2 >= i) {
        break label32;
      }
    }
    label32:
    label79:
    for (;;)
    {
      return true;
      str = MAX_LONG_STR;
      break;
      if (paramInt2 > i) {
        return false;
      }
      paramInt2 = 0;
      for (;;)
      {
        if (paramInt2 >= i) {
          break label79;
        }
        int j = paramArrayOfChar[(paramInt1 + paramInt2)] - str.charAt(paramInt2);
        if (j != 0)
        {
          if (j < 0) {
            break;
          }
          return false;
        }
        paramInt2 += 1;
      }
    }
  }
  
  public static double parseAsDouble(String paramString, double paramDouble)
  {
    if (paramString == null) {}
    do
    {
      return paramDouble;
      paramString = paramString.trim();
    } while (paramString.length() == 0);
    try
    {
      double d = parseDouble(paramString);
      return d;
    }
    catch (NumberFormatException paramString) {}
    return paramDouble;
  }
  
  public static int parseAsInt(String paramString, int paramInt)
  {
    if (paramString == null) {}
    String str;
    int k;
    do
    {
      return paramInt;
      str = paramString.trim();
      k = str.length();
    } while (k == 0);
    int m = 0;
    int i = m;
    int j = k;
    paramString = str;
    int n;
    if (k < 0)
    {
      n = str.charAt(0);
      if (n != 43) {
        break label91;
      }
      paramString = str.substring(1);
      j = paramString.length();
      i = m;
    }
    for (;;)
    {
      if (i >= j) {}
      label91:
      try
      {
        i = Integer.parseInt(paramString);
        return i;
      }
      catch (NumberFormatException paramString) {}
      i = m;
      j = k;
      paramString = str;
      if (n == 45)
      {
        i = 0 + 1;
        j = k;
        paramString = str;
        continue;
        k = paramString.charAt(i);
        if ((k > 57) || (k < 48)) {
          try
          {
            double d = parseDouble(paramString);
            return (int)d;
          }
          catch (NumberFormatException paramString)
          {
            return paramInt;
          }
        }
        i += 1;
      }
    }
    return paramInt;
  }
  
  public static long parseAsLong(String paramString, long paramLong)
  {
    if (paramString == null) {}
    String str;
    int k;
    do
    {
      return paramLong;
      str = paramString.trim();
      k = str.length();
    } while (k == 0);
    int m = 0;
    int i = m;
    int j = k;
    paramString = str;
    int n;
    if (k < 0)
    {
      n = str.charAt(0);
      if (n != 43) {
        break label91;
      }
      paramString = str.substring(1);
      j = paramString.length();
      i = m;
    }
    for (;;)
    {
      if (i >= j) {}
      label91:
      try
      {
        long l = Long.parseLong(paramString);
        return l;
      }
      catch (NumberFormatException paramString) {}
      i = m;
      j = k;
      paramString = str;
      if (n == 45)
      {
        i = 0 + 1;
        j = k;
        paramString = str;
        continue;
        k = paramString.charAt(i);
        if ((k > 57) || (k < 48)) {
          try
          {
            double d = parseDouble(paramString);
            return d;
          }
          catch (NumberFormatException paramString)
          {
            return paramLong;
          }
        }
        i += 1;
      }
    }
    return paramLong;
  }
  
  public static double parseDouble(String paramString)
    throws NumberFormatException
  {
    if ("2.2250738585072012e-308".equals(paramString)) {
      return Double.MIN_VALUE;
    }
    return Double.parseDouble(paramString);
  }
  
  public static int parseInt(String paramString)
  {
    int m = 0;
    int i = paramString.charAt(0);
    int i1 = paramString.length();
    if (i == 45) {
      m = 1;
    }
    int j;
    if (m != 0)
    {
      if ((i1 == 1) || (i1 > 10))
      {
        j = Integer.parseInt(paramString);
        return j;
      }
      j = 1 + 1;
      i = paramString.charAt(1);
    }
    for (;;)
    {
      if ((i > 57) || (i < 48))
      {
        return Integer.parseInt(paramString);
        if (i1 > 9) {
          return Integer.parseInt(paramString);
        }
      }
      else
      {
        int n = i - 48;
        i = n;
        int k = j;
        if (j < i1)
        {
          int i2 = j + 1;
          i = paramString.charAt(j);
          if ((i > 57) || (i < 48)) {
            return Integer.parseInt(paramString);
          }
          k = n * 10 + (i - 48);
          i = k;
          if (i2 < i1)
          {
            j = i2 + 1;
            i = paramString.charAt(i2);
            if ((i > 57) || (i < 48)) {
              return Integer.parseInt(paramString);
            }
            n = k * 10 + (i - 48);
            i = n;
            k = j;
            if (j < i1)
            {
              i = j;
              j = n;
              do
              {
                k = i + 1;
                i = paramString.charAt(i);
                if ((i > 57) || (i < 48)) {
                  return Integer.parseInt(paramString);
                }
                n = j * 10 + (i - 48);
                j = n;
                i = k;
              } while (k < i1);
              i = n;
            }
          }
        }
        j = i;
        if (m == 0) {
          break;
        }
        return -i;
      }
      j = 1;
    }
  }
  
  public static int parseInt(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int i = paramArrayOfChar[paramInt1] - '0';
    int j = paramInt2 + paramInt1;
    int k = paramInt1 + 1;
    paramInt1 = i;
    if (k < j)
    {
      paramInt2 = i * 10 + (paramArrayOfChar[k] - '0');
      i = k + 1;
      paramInt1 = paramInt2;
      if (i < j)
      {
        paramInt2 = paramInt2 * 10 + (paramArrayOfChar[i] - '0');
        i += 1;
        paramInt1 = paramInt2;
        if (i < j)
        {
          paramInt2 = paramInt2 * 10 + (paramArrayOfChar[i] - '0');
          i += 1;
          paramInt1 = paramInt2;
          if (i < j)
          {
            paramInt2 = paramInt2 * 10 + (paramArrayOfChar[i] - '0');
            i += 1;
            paramInt1 = paramInt2;
            if (i < j)
            {
              paramInt2 = paramInt2 * 10 + (paramArrayOfChar[i] - '0');
              i += 1;
              paramInt1 = paramInt2;
              if (i < j)
              {
                paramInt2 = paramInt2 * 10 + (paramArrayOfChar[i] - '0');
                i += 1;
                paramInt1 = paramInt2;
                if (i < j)
                {
                  paramInt2 = paramInt2 * 10 + (paramArrayOfChar[i] - '0');
                  i += 1;
                  paramInt1 = paramInt2;
                  if (i < j) {
                    paramInt1 = paramInt2 * 10 + (paramArrayOfChar[i] - '0');
                  }
                }
              }
            }
          }
        }
      }
    }
    return paramInt1;
  }
  
  public static long parseLong(String paramString)
  {
    if (paramString.length() <= 9) {
      return parseInt(paramString);
    }
    return Long.parseLong(paramString);
  }
  
  public static long parseLong(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    paramInt2 -= 9;
    long l = parseInt(paramArrayOfChar, paramInt1, paramInt2);
    return parseInt(paramArrayOfChar, paramInt1 + paramInt2, 9) + l * 1000000000L;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\fasterxml\jackson\core\io\NumberInput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */