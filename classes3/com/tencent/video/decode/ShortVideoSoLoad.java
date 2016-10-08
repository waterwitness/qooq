package com.tencent.video.decode;

import android.content.Context;
import android.os.Environment;
import java.io.File;

public class ShortVideoSoLoad
{
  private static final String DEFAULT_SHORT_VIDEO_PATH = Environment.getDataDirectory() + "/data/" + "com.tencent.mobileqq" + "/app_lib/QzoneVideoPlugin/";
  private static final String PKG_NAME = "com.tencent.mobileqq";
  private static final String SHORT_VIDEO_SO_LIB = "/app_lib/QzoneVideoPlugin/";
  public static final int VIDEO_FILE_NOT_FIND = -2;
  public static final int VIDEO_INVALID_PARAM = -1;
  public static final int VIDEO_LOAD_ERROR = -3;
  public static final int VIDEO_LOAD_SUCCESS = 0;
  public static final int VIDEO_LOAD_UNINIT = -4;
  public static int VIDEO_SO_LOAD_STATUS = -4;
  public static final int VIDEO_SO_VERSION_ERR = -5;
  
  public static int LoadExtractedShortVideo(String paramString)
  {
    if (VIDEO_SO_LOAD_STATUS == 0) {
      return VIDEO_SO_LOAD_STATUS;
    }
    if (paramString == null)
    {
      VIDEO_SO_LOAD_STATUS = -1;
      return -1;
    }
    int i;
    if (!new File(paramString).exists()) {
      i = -2;
    }
    for (;;)
    {
      VIDEO_SO_LOAD_STATUS = i;
      return i;
      try
      {
        System.load(paramString);
        i = 0;
      }
      catch (UnsatisfiedLinkError paramString)
      {
        i = -3;
      }
    }
  }
  
  public static int LoadExtractedShortVideoSo(String paramString, Context paramContext)
  {
    if (VIDEO_SO_LOAD_STATUS == 0) {
      return VIDEO_SO_LOAD_STATUS;
    }
    if (paramString == null)
    {
      VIDEO_SO_LOAD_STATUS = -1;
      return -1;
    }
    paramContext = getShortVideoSoPath(paramContext) + getLibActualName(paramString);
    if (!new File(paramContext).exists()) {
      i = -2;
    }
    for (;;)
    {
      j = i;
      if (i != 0) {}
      try
      {
        System.loadLibrary(paramString);
        j = 0;
      }
      catch (UnsatisfiedLinkError paramString)
      {
        for (;;)
        {
          j = i;
        }
      }
      VIDEO_SO_LOAD_STATUS = j;
      return j;
      try
      {
        System.load(paramContext);
        i = 0;
      }
      catch (UnsatisfiedLinkError paramContext)
      {
        i = -3;
      }
    }
  }
  
  public static String getLibActualName(String paramString)
  {
    return "lib" + paramString + ".so";
  }
  
  public static String getShortVideoSoPath(Context paramContext)
  {
    if (paramContext == null) {
      return DEFAULT_SHORT_VIDEO_PATH;
    }
    paramContext = paramContext.getFilesDir();
    if (paramContext != null) {
      return paramContext.getParent() + "/app_lib/QzoneVideoPlugin/";
    }
    return DEFAULT_SHORT_VIDEO_PATH;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\video\decode\ShortVideoSoLoad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */