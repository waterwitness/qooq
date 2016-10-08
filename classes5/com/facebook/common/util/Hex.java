package com.facebook.common.util;

public class Hex
{
  private static final byte[] DIGITS;
  private static final char[] FIRST_CHAR;
  private static final char[] HEX_DIGITS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  private static final char[] SECOND_CHAR;
  
  static
  {
    FIRST_CHAR = new char['Ā'];
    SECOND_CHAR = new char['Ā'];
    int j = 0;
    label131:
    int i;
    if (j >= 256)
    {
      DIGITS = new byte[103];
      j = 0;
      if (j <= 70) {
        break label189;
      }
      i = 0;
      label139:
      if (i < 10) {
        break label202;
      }
    }
    for (j = 0;; j = (byte)(j + 1))
    {
      if (j >= 6)
      {
        return;
        FIRST_CHAR[j] = HEX_DIGITS[(j >> 4 & 0xF)];
        SECOND_CHAR[j] = HEX_DIGITS[(j & 0xF)];
        j += 1;
        break;
        label189:
        DIGITS[j] = -1;
        j += 1;
        break label131;
        label202:
        DIGITS[(i + 48)] = i;
        i = (byte)(i + 1);
        break label139;
      }
      DIGITS[(j + 65)] = ((byte)(j + 10));
      DIGITS[(j + 97)] = ((byte)(j + 10));
    }
  }
  
  public static String byte2Hex(int paramInt)
  {
    if ((paramInt > 255) || (paramInt < 0)) {
      throw new IllegalArgumentException("The int converting to hex should be in range 0~255");
    }
    return String.valueOf(FIRST_CHAR[paramInt]) + String.valueOf(SECOND_CHAR[paramInt]);
  }
  
  public static byte[] decodeHex(String paramString)
  {
    int m = paramString.length();
    if ((m & 0x1) != 0) {
      throw new IllegalArgumentException("Odd number of characters.");
    }
    int k = 0;
    byte[] arrayOfByte = new byte[m >> 1];
    int i = 0;
    int j = 0;
    for (;;)
    {
      if (j >= m) {
        i = k;
      }
      int n;
      int i1;
      for (;;)
      {
        if (i == 0) {
          return arrayOfByte;
        }
        throw new IllegalArgumentException("Invalid hexadecimal digit: " + paramString);
        n = j + 1;
        j = paramString.charAt(j);
        if (j > 102)
        {
          i = 1;
        }
        else
        {
          i1 = DIGITS[j];
          if (i1 == -1)
          {
            i = 1;
          }
          else
          {
            j = n + 1;
            n = paramString.charAt(n);
            if (n > 102)
            {
              i = 1;
            }
            else
            {
              n = DIGITS[n];
              if (n != -1) {
                break;
              }
              i = 1;
            }
          }
        }
      }
      arrayOfByte[i] = ((byte)(i1 << 4 | n));
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static String encodeHex(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    char[] arrayOfChar = new char[paramArrayOfByte.length * 2];
    int j = 0;
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfByte.length) {}
      int k;
      do
      {
        return new String(arrayOfChar, 0, j);
        k = paramArrayOfByte[i] & 0xFF;
      } while ((k == 0) && (paramBoolean));
      int m = j + 1;
      arrayOfChar[j] = FIRST_CHAR[k];
      j = m + 1;
      arrayOfChar[m] = SECOND_CHAR[k];
      i += 1;
    }
  }
  
  public static byte[] hexStringToByteArray(String paramString)
  {
    return decodeHex(paramString.replaceAll(" ", ""));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\common\util\Hex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */