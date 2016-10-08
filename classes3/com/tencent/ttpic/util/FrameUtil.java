package com.tencent.ttpic.util;

import android.util.Log;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.Frame;

public class FrameUtil
{
  private static final String TAG = FrameUtil.class.getSimpleName();
  
  public static int getLength(BaseFilter paramBaseFilter)
  {
    int i = 0;
    while (paramBaseFilter != null)
    {
      i += 1;
      paramBaseFilter = paramBaseFilter.getmNextFilter();
    }
    return i;
  }
  
  public static int getLength(Frame paramFrame)
  {
    int i = 0;
    while ((paramFrame != null) && (paramFrame.getTextureId() > 0))
    {
      i += 1;
      paramFrame = paramFrame.nextFrame;
    }
    return i;
  }
  
  public static Frame getSecondLastRenderFrame(Frame paramFrame)
  {
    Object localObject;
    if ((!isValid(paramFrame)) || (!isValid(paramFrame.nextFrame)))
    {
      localObject = null;
      return (Frame)localObject;
    }
    Frame localFrame = paramFrame;
    for (;;)
    {
      localObject = localFrame;
      if (!isValid(paramFrame)) {
        break;
      }
      localObject = localFrame;
      if (!isValid(paramFrame.nextFrame)) {
        break;
      }
      localFrame = paramFrame;
      paramFrame = paramFrame.nextFrame;
    }
  }
  
  public static boolean isValid(Frame paramFrame)
  {
    return (paramFrame != null) && (paramFrame.getTextureId() != 0);
  }
  
  public static void printFilterList(BaseFilter paramBaseFilter)
  {
    Log.d(TAG, "[FILTER] BEGIN");
    int i = 0;
    while (paramBaseFilter != null)
    {
      Log.d(TAG, "[FILTER] " + i + " " + paramBaseFilter);
      paramBaseFilter = paramBaseFilter.getmNextFilter();
      i += 1;
    }
    Log.d(TAG, "[FILTER] END");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\ttpic\util\FrameUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */