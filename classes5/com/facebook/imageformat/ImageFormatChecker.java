package com.facebook.imageformat;

import com.facebook.common.internal.ByteStreams;
import com.facebook.common.internal.Ints;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import com.facebook.imagepipeline.webp.WebpSupportStatus;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class ImageFormatChecker
{
  private static final byte[] BMP_HEADER = asciiBytes("BM");
  private static final int EXTENDED_WEBP_HEADER_LENGTH = 21;
  private static final byte[] GIF_HEADER_87A;
  private static final byte[] GIF_HEADER_89A;
  private static final int GIF_HEADER_LENGTH = 6;
  private static final byte[] JPEG_HEADER = { -1, -40, -1 };
  private static final int MAX_HEADER_LENGTH = Ints.max(new int[] { 21, 20, JPEG_HEADER.length, PNG_HEADER.length, 6, BMP_HEADER.length });
  private static final byte[] PNG_HEADER = { -119, 80, 78, 71, 13, 10, 26, 10 };
  private static final int SIMPLE_WEBP_HEADER_LENGTH = 20;
  
  static
  {
    GIF_HEADER_87A = asciiBytes("GIF87a");
    GIF_HEADER_89A = asciiBytes("GIF89a");
  }
  
  private static byte[] asciiBytes(String paramString)
  {
    Preconditions.checkNotNull(paramString);
    try
    {
      paramString = paramString.getBytes("ASCII");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new RuntimeException("ASCII not found!", paramString);
    }
  }
  
  private static ImageFormat doGetImageFormat(byte[] paramArrayOfByte, int paramInt)
  {
    Preconditions.checkNotNull(paramArrayOfByte);
    if (WebpSupportStatus.isWebpHeader(paramArrayOfByte, 0, paramInt)) {
      return getWebpFormat(paramArrayOfByte, paramInt);
    }
    if (isJpegHeader(paramArrayOfByte, paramInt)) {
      return ImageFormat.JPEG;
    }
    if (isPngHeader(paramArrayOfByte, paramInt)) {
      return ImageFormat.PNG;
    }
    if (isGifHeader(paramArrayOfByte, paramInt)) {
      return ImageFormat.GIF;
    }
    if (isBmpHeader(paramArrayOfByte, paramInt)) {
      return ImageFormat.BMP;
    }
    return ImageFormat.UNKNOWN;
  }
  
  public static ImageFormat getImageFormat(InputStream paramInputStream)
    throws IOException
  {
    Preconditions.checkNotNull(paramInputStream);
    byte[] arrayOfByte = new byte[MAX_HEADER_LENGTH];
    return doGetImageFormat(arrayOfByte, readHeaderFromStream(paramInputStream, arrayOfByte));
  }
  
  /* Error */
  public static ImageFormat getImageFormat(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore_2
    //   4: new 139	java/io/FileInputStream
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 142	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   12: astore_0
    //   13: aload_0
    //   14: invokestatic 144	com/facebook/imageformat/ImageFormatChecker:getImageFormat	(Ljava/io/InputStream;)Lcom/facebook/imageformat/ImageFormat;
    //   17: astore_1
    //   18: aload_0
    //   19: invokestatic 150	com/facebook/common/internal/Closeables:closeQuietly	(Ljava/io/InputStream;)V
    //   22: aload_1
    //   23: areturn
    //   24: astore_0
    //   25: aload_2
    //   26: astore_0
    //   27: aload_0
    //   28: astore_1
    //   29: getstatic 125	com/facebook/imageformat/ImageFormat:UNKNOWN	Lcom/facebook/imageformat/ImageFormat;
    //   32: astore_2
    //   33: aload_0
    //   34: invokestatic 150	com/facebook/common/internal/Closeables:closeQuietly	(Ljava/io/InputStream;)V
    //   37: aload_2
    //   38: areturn
    //   39: astore_0
    //   40: aload_1
    //   41: invokestatic 150	com/facebook/common/internal/Closeables:closeQuietly	(Ljava/io/InputStream;)V
    //   44: aload_0
    //   45: athrow
    //   46: astore_2
    //   47: aload_0
    //   48: astore_1
    //   49: aload_2
    //   50: astore_0
    //   51: goto -11 -> 40
    //   54: astore_1
    //   55: goto -28 -> 27
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	paramString	String
    //   1	48	1	localObject1	Object
    //   54	1	1	localIOException	IOException
    //   3	35	2	localImageFormat	ImageFormat
    //   46	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   4	13	24	java/io/IOException
    //   4	13	39	finally
    //   29	33	39	finally
    //   13	18	46	finally
    //   13	18	54	java/io/IOException
  }
  
  public static ImageFormat getImageFormat_WrapIOException(InputStream paramInputStream)
  {
    try
    {
      paramInputStream = getImageFormat(paramInputStream);
      return paramInputStream;
    }
    catch (IOException paramInputStream)
    {
      throw Throwables.propagate(paramInputStream);
    }
  }
  
  private static ImageFormat getWebpFormat(byte[] paramArrayOfByte, int paramInt)
  {
    Preconditions.checkArgument(WebpSupportStatus.isWebpHeader(paramArrayOfByte, 0, paramInt));
    if (WebpSupportStatus.isSimpleWebpHeader(paramArrayOfByte, 0)) {
      return ImageFormat.WEBP_SIMPLE;
    }
    if (WebpSupportStatus.isLosslessWebpHeader(paramArrayOfByte, 0)) {
      return ImageFormat.WEBP_LOSSLESS;
    }
    if (WebpSupportStatus.isExtendedWebpHeader(paramArrayOfByte, 0, paramInt))
    {
      if (WebpSupportStatus.isAnimatedWebpHeader(paramArrayOfByte, 0)) {
        return ImageFormat.WEBP_ANIMATED;
      }
      if (WebpSupportStatus.isExtendedWebpHeaderWithAlpha(paramArrayOfByte, 0)) {
        return ImageFormat.WEBP_EXTENDED_WITH_ALPHA;
      }
      return ImageFormat.WEBP_EXTENDED;
    }
    return ImageFormat.UNKNOWN;
  }
  
  private static boolean isBmpHeader(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramInt < BMP_HEADER.length) {
      return false;
    }
    return matchBytePattern(paramArrayOfByte, 0, BMP_HEADER);
  }
  
  private static boolean isGifHeader(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramInt < 6) {}
    while ((!matchBytePattern(paramArrayOfByte, 0, GIF_HEADER_87A)) && (!matchBytePattern(paramArrayOfByte, 0, GIF_HEADER_89A))) {
      return false;
    }
    return true;
  }
  
  private static boolean isJpegHeader(byte[] paramArrayOfByte, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt >= JPEG_HEADER.length)
    {
      bool1 = bool2;
      if (matchBytePattern(paramArrayOfByte, 0, JPEG_HEADER)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static boolean isPngHeader(byte[] paramArrayOfByte, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt >= PNG_HEADER.length)
    {
      bool1 = bool2;
      if (matchBytePattern(paramArrayOfByte, 0, PNG_HEADER)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static boolean matchBytePattern(byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2)
  {
    Preconditions.checkNotNull(paramArrayOfByte1);
    Preconditions.checkNotNull(paramArrayOfByte2);
    if (paramInt >= 0) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      if (paramArrayOfByte2.length + paramInt <= paramArrayOfByte1.length) {
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
      if (paramArrayOfByte1[(i + paramInt)] != paramArrayOfByte2[i]) {
        break;
      }
      i += 1;
    }
  }
  
  private static int readHeaderFromStream(InputStream paramInputStream, byte[] paramArrayOfByte)
    throws IOException
  {
    Preconditions.checkNotNull(paramInputStream);
    Preconditions.checkNotNull(paramArrayOfByte);
    if (paramArrayOfByte.length >= MAX_HEADER_LENGTH) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      if (!paramInputStream.markSupported()) {
        break;
      }
      try
      {
        paramInputStream.mark(MAX_HEADER_LENGTH);
        int i = ByteStreams.read(paramInputStream, paramArrayOfByte, 0, MAX_HEADER_LENGTH);
        return i;
      }
      finally
      {
        paramInputStream.reset();
      }
    }
    return ByteStreams.read(paramInputStream, paramArrayOfByte, 0, MAX_HEADER_LENGTH);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imageformat\ImageFormatChecker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */