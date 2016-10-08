package com.facebook.common.media;

import android.webkit.MimeTypeMap;
import com.facebook.common.internal.ImmutableMap;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nullable;

public class MediaUtils
{
  public static final Map<String, String> ADDITIONAL_ALLOWED_MIME_TYPES = ImmutableMap.of("mkv", "video/x-matroska");
  
  @Nullable
  private static String extractExtension(String paramString)
  {
    int i = paramString.lastIndexOf('.');
    if ((i < 0) || (i == paramString.length() - 1)) {
      return null;
    }
    return paramString.substring(i + 1);
  }
  
  @Nullable
  public static String extractMime(String paramString)
  {
    paramString = extractExtension(paramString);
    if (paramString == null) {
      paramString = null;
    }
    String str2;
    String str1;
    do
    {
      return paramString;
      str2 = paramString.toLowerCase(Locale.US);
      str1 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str2);
      paramString = str1;
    } while (str1 != null);
    return (String)ADDITIONAL_ALLOWED_MIME_TYPES.get(str2);
  }
  
  public static boolean isNonNativeSupportedMimeType(String paramString)
  {
    return ADDITIONAL_ALLOWED_MIME_TYPES.containsValue(paramString);
  }
  
  public static boolean isPhoto(@Nullable String paramString)
  {
    return (paramString != null) && (paramString.startsWith("image/"));
  }
  
  public static boolean isVideo(@Nullable String paramString)
  {
    return (paramString != null) && (paramString.startsWith("video/"));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\common\media\MediaUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */