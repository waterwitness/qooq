package com.facebook.imagepipeline.nativecode;

import android.os.Build.VERSION;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.internal.Preconditions;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.webp.WebpSupportStatus;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@DoNotStrip
public class WebpTranscoder
{
  static {}
  
  public static boolean isWebpNativelySupported(ImageFormat paramImageFormat)
  {
    switch (paramImageFormat)
    {
    default: 
      Preconditions.checkArgument(false);
    case UNKNOWN: 
    case BMP: 
      do
      {
        return false;
      } while (Build.VERSION.SDK_INT < 14);
      return true;
    }
    return WebpSupportStatus.sIsExtendedWebpSupported;
  }
  
  @DoNotStrip
  private static native void nativeTranscodeWebpToJpeg(InputStream paramInputStream, OutputStream paramOutputStream, int paramInt)
    throws IOException;
  
  @DoNotStrip
  private static native void nativeTranscodeWebpToPng(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException;
  
  public static void transcodeWebpToJpeg(InputStream paramInputStream, OutputStream paramOutputStream, int paramInt)
    throws IOException
  {
    nativeTranscodeWebpToJpeg((InputStream)Preconditions.checkNotNull(paramInputStream), (OutputStream)Preconditions.checkNotNull(paramOutputStream), paramInt);
  }
  
  public static void transcodeWebpToPng(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    nativeTranscodeWebpToPng((InputStream)Preconditions.checkNotNull(paramInputStream), (OutputStream)Preconditions.checkNotNull(paramOutputStream));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\nativecode\WebpTranscoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */