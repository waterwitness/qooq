package com.facebook.imageformat;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import java.io.IOException;
import java.io.InputStream;

public final class GifFormatChecker
{
  private static final byte[] FRAME_HEADER_END_1;
  private static final byte[] FRAME_HEADER_END_2;
  private static final int FRAME_HEADER_SIZE = 10;
  private static final byte[] FRAME_HEADER_START;
  
  static
  {
    byte[] arrayOfByte = new byte[4];
    arrayOfByte[1] = 33;
    arrayOfByte[2] = -7;
    arrayOfByte[3] = 4;
    FRAME_HEADER_START = arrayOfByte;
    arrayOfByte = new byte[2];
    arrayOfByte[1] = 44;
    FRAME_HEADER_END_1 = arrayOfByte;
    arrayOfByte = new byte[2];
    arrayOfByte[1] = 33;
    FRAME_HEADER_END_2 = arrayOfByte;
  }
  
  @VisibleForTesting
  static boolean circularBufferMatchesBytePattern(byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2)
  {
    Preconditions.checkNotNull(paramArrayOfByte1);
    Preconditions.checkNotNull(paramArrayOfByte2);
    if (paramInt >= 0) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      if (paramArrayOfByte2.length <= paramArrayOfByte1.length) {
        break;
      }
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfByte2.length) {
        return true;
      }
      if (paramArrayOfByte1[((i + paramInt) % paramArrayOfByte1.length)] != paramArrayOfByte2[i]) {
        break;
      }
      i += 1;
    }
  }
  
  public static boolean isAnimated(InputStream paramInputStream)
  {
    byte[] arrayOfByte = new byte[10];
    for (;;)
    {
      int j;
      int k;
      try
      {
        paramInputStream.read(arrayOfByte, 0, 10);
        int i = 0;
        j = 0;
        if (paramInputStream.read(arrayOfByte, i, 1) <= 0) {
          return false;
        }
        k = j;
        if (circularBufferMatchesBytePattern(arrayOfByte, i + 1, FRAME_HEADER_START))
        {
          if (!circularBufferMatchesBytePattern(arrayOfByte, i + 9, FRAME_HEADER_END_1))
          {
            k = j;
            if (circularBufferMatchesBytePattern(arrayOfByte, i + 9, FRAME_HEADER_END_2)) {}
          }
        }
        else
        {
          i = (i + 1) % arrayOfByte.length;
          j = k;
          continue;
          return true;
        }
      }
      catch (IOException paramInputStream)
      {
        throw new RuntimeException(paramInputStream);
      }
      do
      {
        k = j + 1;
      } while (k > 1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imageformat\GifFormatChecker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */