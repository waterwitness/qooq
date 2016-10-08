package com.facebook.imageformat;

public class ImageFileExtensionMap
{
  public static String getFileExtension(ImageFormat paramImageFormat)
    throws UnsupportedOperationException
  {
    switch (paramImageFormat)
    {
    default: 
      throw new UnsupportedOperationException("Unknown image format " + paramImageFormat.name());
    case BMP: 
    case GIF: 
    case JPEG: 
    case PNG: 
    case UNKNOWN: 
      return "webp";
    case WEBP_ANIMATED: 
      return "jpeg";
    case WEBP_EXTENDED: 
      return "png";
    case WEBP_EXTENDED_WITH_ALPHA: 
      return "gif";
    }
    return "bmp";
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imageformat\ImageFileExtensionMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */