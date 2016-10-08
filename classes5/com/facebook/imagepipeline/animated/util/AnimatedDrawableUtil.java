package com.facebook.imagepipeline.animated.util;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import com.facebook.imageutils.BitmapUtil;
import java.util.Arrays;

public class AnimatedDrawableUtil
{
  private static final int FRAME_DURATION_MS_FOR_MIN = 100;
  private static final int MIN_FRAME_DURATION_MS = 11;
  
  public static boolean isOutsideRange(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool2 = false;
    if ((paramInt1 == -1) || (paramInt2 == -1)) {
      return true;
    }
    if (paramInt1 <= paramInt2) {
      return (paramInt3 < paramInt1) || (paramInt3 > paramInt2);
    }
    boolean bool1 = bool2;
    if (paramInt3 < paramInt1)
    {
      bool1 = bool2;
      if (paramInt3 > paramInt2) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void appendMemoryString(StringBuilder paramStringBuilder, int paramInt)
  {
    if (paramInt < 1024)
    {
      paramStringBuilder.append(paramInt);
      paramStringBuilder.append("KB");
      return;
    }
    int i = paramInt / 1024;
    paramInt = paramInt % 1024 / 100;
    paramStringBuilder.append(i);
    paramStringBuilder.append(".");
    paramStringBuilder.append(paramInt);
    paramStringBuilder.append("MB");
  }
  
  public void fixFrameDurations(int[] paramArrayOfInt)
  {
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfInt.length) {
        return;
      }
      if (paramArrayOfInt[i] < 11) {
        paramArrayOfInt[i] = 100;
      }
      i += 1;
    }
  }
  
  public int getFrameForTimestampMs(int[] paramArrayOfInt, int paramInt)
  {
    int i = Arrays.binarySearch(paramArrayOfInt, paramInt);
    paramInt = i;
    if (i < 0) {
      paramInt = -i - 1 - 1;
    }
    return paramInt;
  }
  
  public int[] getFrameTimeStampsFromDurations(int[] paramArrayOfInt)
  {
    int[] arrayOfInt = new int[paramArrayOfInt.length];
    int j = 0;
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfInt.length) {
        return arrayOfInt;
      }
      arrayOfInt[i] = j;
      j += paramArrayOfInt[i];
      i += 1;
    }
  }
  
  @SuppressLint({"NewApi"})
  public int getSizeOfBitmap(Bitmap paramBitmap)
  {
    return BitmapUtil.getSizeInBytes(paramBitmap);
  }
  
  public int getTotalDurationFromFrameDurations(int[] paramArrayOfInt)
  {
    int j = 0;
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfInt.length) {
        return j;
      }
      j += paramArrayOfInt[i];
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\animated\util\AnimatedDrawableUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */