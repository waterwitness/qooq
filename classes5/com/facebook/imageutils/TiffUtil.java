package com.facebook.imageutils;

import com.facebook.common.logging.FLog;
import java.io.IOException;
import java.io.InputStream;

class TiffUtil
{
  private static final Class<?> TAG = TiffUtil.class;
  public static final int TIFF_BYTE_ORDER_BIG_END = 1296891946;
  public static final int TIFF_BYTE_ORDER_LITTLE_END = 1229531648;
  public static final int TIFF_TAG_ORIENTATION = 274;
  public static final int TIFF_TYPE_SHORT = 3;
  
  public static int getAutoRotateAngleFromOrientation(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    case 4: 
    case 5: 
    case 7: 
    default: 
      FLog.i(TAG, "Unsupported orientation");
    case 1: 
      return 0;
    case 3: 
      return 180;
    case 6: 
      return 90;
    }
    return 270;
  }
  
  private static int getOrientationFromTiffEntry(InputStream paramInputStream, int paramInt, boolean paramBoolean)
    throws IOException
  {
    if (paramInt < 10) {}
    while ((StreamProcessor.readPackedInt(paramInputStream, 2, paramBoolean) != 3) || (StreamProcessor.readPackedInt(paramInputStream, 4, paramBoolean) != 1)) {
      return 0;
    }
    paramInt = StreamProcessor.readPackedInt(paramInputStream, 2, paramBoolean);
    StreamProcessor.readPackedInt(paramInputStream, 2, paramBoolean);
    return paramInt;
  }
  
  private static int moveToTiffEntryWithTag(InputStream paramInputStream, int paramInt1, boolean paramBoolean, int paramInt2)
    throws IOException
  {
    if (paramInt1 < 14) {}
    for (;;)
    {
      return 0;
      int i = StreamProcessor.readPackedInt(paramInputStream, 2, paramBoolean);
      int j = paramInt1 - 2;
      paramInt1 = i;
      i = j;
      while ((paramInt1 > 0) && (i >= 12))
      {
        j = StreamProcessor.readPackedInt(paramInputStream, 2, paramBoolean);
        i -= 2;
        if (j == paramInt2) {
          return i;
        }
        paramInputStream.skip(10L);
        i -= 10;
        paramInt1 -= 1;
      }
    }
  }
  
  public static int readOrientationFromTIFF(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    TiffHeader localTiffHeader = new TiffHeader(null);
    paramInt = readTiffHeader(paramInputStream, paramInt, localTiffHeader);
    int i = localTiffHeader.firstIfdOffset - 8;
    if ((paramInt == 0) || (i > paramInt)) {
      return 0;
    }
    paramInputStream.skip(i);
    return getOrientationFromTiffEntry(paramInputStream, moveToTiffEntryWithTag(paramInputStream, paramInt - i, localTiffHeader.isLittleEndian, 274), localTiffHeader.isLittleEndian);
  }
  
  private static int readTiffHeader(InputStream paramInputStream, int paramInt, TiffHeader paramTiffHeader)
    throws IOException
  {
    if (paramInt <= 8) {
      return 0;
    }
    paramTiffHeader.byteOrder = StreamProcessor.readPackedInt(paramInputStream, 4, false);
    if ((paramTiffHeader.byteOrder != 1229531648) && (paramTiffHeader.byteOrder != 1296891946))
    {
      FLog.e(TAG, "Invalid TIFF header");
      return 0;
    }
    if (paramTiffHeader.byteOrder == 1229531648) {}
    for (boolean bool = true;; bool = false)
    {
      paramTiffHeader.isLittleEndian = bool;
      paramTiffHeader.firstIfdOffset = StreamProcessor.readPackedInt(paramInputStream, 4, paramTiffHeader.isLittleEndian);
      paramInt = paramInt - 4 - 4;
      if ((paramTiffHeader.firstIfdOffset >= 8) && (paramTiffHeader.firstIfdOffset - 8 <= paramInt)) {
        break;
      }
      FLog.e(TAG, "Invalid offset");
      return 0;
    }
    return paramInt;
  }
  
  private static class TiffHeader
  {
    int byteOrder;
    int firstIfdOffset;
    boolean isLittleEndian;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imageutils\TiffUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */